package controller;

import view.util.SampleData;
import config.Koneksi;
import model.BusinessException;
import model.KategoriPenyaluran;
import model.Kios;
import model.KlasifikasiPetani;
import model.NonSubsidi;
import model.Pengelola;
import model.Penyalur;
import model.Penyaluran;
import model.Petani;
import model.Pupuk;
import model.Subsidi;
import model.User;
import model.dao.KiosDao;
import model.dao.PenyaluranDao;
import model.dao.PupukDao;
import model.dao.UserDao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Penghubung antara GUI (Swing) dan backend (DAO + MySQL). Semua method mengembalikan data yang sudah
 * dalam format tabel GUI (Object[][]) atau melempar {@link Galat} berisi pesan yang siap ditampilkan.
 *
 * Aturan bisnis diambil dari controller backend semula: golongan petani Gol A tidak berhak subsidi,
 * kuota subsidi = luas lahan x karung per hektar, stok dipotong dari batch pupuk kios, 1 karung = 50 kg.
 */
public final class GuiController {

    private GuiController() {
    }

    // ================================================================== infrastruktur

    /** Galat yang pesannya aman ditampilkan langsung ke pengguna. */
    public static class Galat extends RuntimeException {
        public Galat(String pesan) {
            super(pesan);
        }

        public Galat(String pesan, Throwable sebab) {
            super(pesan, sebab);
        }
    }

    @FunctionalInterface
    private interface Kerja<T> {
        T jalan() throws Exception;
    }

    private static <T> T coba(Kerja<T> k) {
        try {
            return k.jalan();
        } catch (Galat e) {
            throw e;
        } catch (BusinessException e) {
            throw new Galat(e.getMessage(), e);
        } catch (SQLException e) {
            throw new Galat("Gagal mengakses database: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new Galat(e.getMessage() == null ? e.toString() : e.getMessage(), e);
        }
    }

    /** Uji koneksi database. @return null jika berhasil, atau pesan galat. */
    public static String ujiKoneksi() {
        try {
            Koneksi.get();
            return null;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    private static final DateTimeFormatter FMT_TGL = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final int KG_KARUNG = Pupuk.BERAT_KARUNG_KG;
    private static boolean tabelSiap;

    /** Tabel transaksi petani (pesanan + penyaluran langsung) dibuat otomatis bila belum ada. */
    private static synchronized void siapkanTabel() throws SQLException {
        if (tabelSiap) {
            return;
        }
        Koneksi.update("CREATE TABLE IF NOT EXISTS transaksi ("
                + "id_transaksi INT AUTO_INCREMENT PRIMARY KEY, "
                + "petani_id_user INT NOT NULL, "
                + "kios_id_kios INT NOT NULL, "
                + "nama_pupuk VARCHAR(100) NOT NULL, "
                + "kategori_pupuk VARCHAR(20) NOT NULL, "
                + "jumlah_kg INT NOT NULL, "
                + "jenis VARCHAR(10) NOT NULL, "
                + "status VARCHAR(12) NOT NULL, "
                + "tanggal DATE NOT NULL, "
                + "tanggal_selesai DATE NULL"
                + ") ENGINE=InnoDB");
        Koneksi.update("CREATE TABLE IF NOT EXISTS kuota_kecamatan ("
                + "id_kuota INT AUTO_INCREMENT PRIMARY KEY, "
                + "nama_kecamatan VARCHAR(100) NOT NULL, "
                + "nama_pupuk VARCHAR(100) NOT NULL, "
                + "kategori_pupuk VARCHAR(20) NOT NULL, "
                + "tahun INT NOT NULL, "
                + "kuota_kg INT NOT NULL"
                + ") ENGINE=InnoDB");
        tabelSiap = true;
    }

    // ---- pemformat

    static String fmt(long n) {
        return String.format(Locale.GERMANY, "%,d", n);
    }

    static String tgl(Object o) {
        LocalDate d = keTanggal(o);
        return d == null ? "-" : d.format(FMT_TGL);
    }

    private static LocalDate keTanggal(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof LocalDate d) {
            return d;
        }
        if (o instanceof java.sql.Date d) {
            return d.toLocalDate();
        }
        if (o instanceof java.time.LocalDateTime d) {
            return d.toLocalDate();
        }
        if (o instanceof java.sql.Timestamp d) {
            return d.toLocalDateTime().toLocalDate();
        }
        return null;
    }

    /** "2500 Kg" -> 2500. */
    private static int angka(Object v) {
        if (v == null) {
            return 0;
        }
        String d = v.toString().replaceAll("[^0-9]", "");
        return d.isEmpty() ? 0 : Integer.parseInt(d);
    }

    private static int kode(String kode) {
        String d = kode == null ? "" : kode.replaceAll("[^0-9]", "");
        if (d.isEmpty()) {
            throw new Galat("Pilih data terlebih dahulu.");
        }
        return Integer.parseInt(d);
    }

    private static String kodePny(int id) {
        return String.format("PNY-%04d", id);
    }

    private static String kodeTrx(int id) {
        return String.format("TRX-%04d", id);
    }

    private static String uiStatus(String s) {
        if (Penyaluran.PROSES.equals(s)) {
            return "Dikirim";
        }
        if (Penyaluran.SELESAI.equals(s)) {
            return "Diterima";
        }
        return s == null ? "-" : s;
    }

    @SuppressWarnings("unchecked")
    private static List<Map<String, Object>> baris(String sql, Object... p) throws SQLException {
        return (List<Map<String, Object>>) (List<?>) Koneksi.query(sql, p);
    }

    private static String s(Map<String, Object> r, String k) {
        String v = Koneksi.strOf(r, k);
        return v == null ? "" : v;
    }

    private static long lng(Map<String, Object> r, String k) {
        Object v = r == null ? null : r.get(k);
        return v instanceof Number n ? n.longValue() : 0L;
    }

    private static int i(Map<String, Object> r, String k) {
        return Koneksi.intOf(r, k);
    }

    // ---- produk (label GUI <-> nama_pupuk + kategori di DB)

    /** Pupuk di combo GUI, mis. "Urea Subsidi", "NPK nonsubsidi". */
    public record Produk(String nama, String kategori) {
        public Produk {
            nama = bersih(nama);
        }

        public static Produk dari(String label) {
            String t = label == null ? "" : label.trim();
            String low = t.toLowerCase(Locale.ROOT);
            String nama;
            String kat;
            if (low.endsWith("non subsidi")) {
                nama = t.substring(0, t.length() - 11);
                kat = Pupuk.NONSUBSIDI;
            } else if (low.endsWith("nonsubsidi")) {
                nama = t.substring(0, t.length() - 10);
                kat = Pupuk.NONSUBSIDI;
            } else if (low.endsWith("subsidi")) {
                nama = t.substring(0, t.length() - 7);
                kat = Pupuk.SUBSIDI;
            } else {
                throw new Galat("Pilih pupuk terlebih dahulu.");
            }
            nama = nama.trim();
            if (nama.isEmpty()) {
                throw new Galat("Pilih pupuk terlebih dahulu.");
            }
            return new Produk(nama, kat);
        }

        String kunci() {
            return nama.toLowerCase(Locale.ROOT);
        }

        boolean subsidi() {
            return Pupuk.SUBSIDI.equals(kategori);
        }
    }

    /** Buang akhiran "Subsidi"/"Nonsubsidi"/"Non subsidi" (data DB tidak konsisten: 'ZA Subsidi', 'Urea nonsubsidi', 'ZA'). */
    static String bersih(String nama) {
        return nama == null ? "" : nama.trim().replaceAll("(?i)\\s+(non\\s?subsidi|subsidi)\\s*$", "").trim();
    }

    /** Ekspresi SQL yang menormalkan nama pupuk dengan aturan yang sama seperti {@link #bersih}. */
    private static String norm(String kolom) {
        return "TRIM(REPLACE(REPLACE(REPLACE(LOWER(TRIM(" + kolom + ")), ' non subsidi', ''), ' nonsubsidi', ''), ' subsidi', ''))";
    }

    private static String labelProduk(String nama, String kategori) {
        return bersih(nama) + (Pupuk.SUBSIDI.equals(kategori) ? " Subsidi" : " Nonsubsidi");
    }

    /** Harga per kg (Rp). Subsidi: dari kolom harga_het bila ada; selain itu harga acuan. */
    public static long hargaPerKg(String labelProduk) {
        try {
            Produk pr = Produk.dari(labelProduk);
            if (pr.subsidi()) {
                Map<String, Object> r = Koneksi.one("SELECT MIN(s.harga_het) AS h FROM subsidi s JOIN pupuk pu ON pu.id_pupuk = s.id_pupuk "
                        + "WHERE " + norm("pu.nama_pupuk") + " = ? AND s.harga_het > 0", pr.kunci());
                Object h = r == null ? null : r.get("h");
                if (h instanceof Number n && n.longValue() > 0) {
                    long v = n.longValue();
                    return v >= 10000 ? v / KG_KARUNG : v;   // nilai besar dianggap harga per karung
                }
            }
        } catch (Exception e) {
            // jatuh ke harga acuan
        }
        return SampleData.hargaPerKg(labelProduk);
    }

    // ---- pengguna saat ini

    private static User pengguna() {
        User u = Session.user();
        if (u == null) {
            throw new Galat("Anda belum masuk. Silakan login terlebih dahulu.");
        }
        return u;
    }

    private static Pengelola pengelola() {
        if (pengguna() instanceof Pengelola p) {
            return p;
        }
        throw new Galat("Aksi ini hanya untuk Pengelola.");
    }

    private static Penyalur penyalur() {
        if (pengguna() instanceof Penyalur p) {
            return p;
        }
        throw new Galat("Aksi ini hanya untuk Penyalur.");
    }

    private static Petani petani() {
        if (pengguna() instanceof Petani p) {
            return p;
        }
        throw new Galat("Aksi ini hanya untuk Petani.");
    }

    // ================================================================== autentikasi

    /** Login GUI. @return null bila berhasil (pengguna disimpan di Session), atau pesan galat. */
    public static String login(String email, String sandi) {
        if (email == null || email.trim().isEmpty()) {
            return "Email tidak boleh kosong.";
        }
        if (sandi == null || sandi.isEmpty()) {
            return "Kata sandi tidak boleh kosong.";
        }
        try {
            User u = coba(() -> new UserDao().login(email.trim(), sandi));
            if (u == null) {
                return "Email atau kata sandi tidak sesuai.";
            }
            Session.masuk(u);
            return null;
        } catch (Galat e) {
            return e.getMessage();
        }
    }

    /** Peran akun yang sedang login: "pengelola", "penyalur", atau "petani". */
    public static String peran() {
        User u = Session.user();
        return u == null ? "" : u.getPeran().name().toLowerCase(Locale.ROOT);
    }

    private static Kios kiosDiKecamatan(String kecamatan) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT id_kios, nama_kios, nama_kecamatan FROM kios "
                + "WHERE LOWER(TRIM(nama_kecamatan)) = LOWER(TRIM(?)) "
                + "ORDER BY (SELECT COUNT(*) FROM penyalur py WHERE py.kios_id_kios = kios.id_kios) DESC, id_kios LIMIT 1", kecamatan);
        if (r == null || r.isEmpty()) {
            throw new Galat("Belum ada kios terdaftar di kecamatan " + kecamatan + ".");
        }
        return new Kios(i(r, "id_kios"), s(r, "nama_kios"), s(r, "nama_kecamatan"));
    }

    /** Kios di suatu kecamatan: {id, nama kios}. */
    public static List<String[]> daftarKios(String kecamatan) {
        return coba(() -> {
            List<String[]> out = new ArrayList<>();
            for (Map<String, Object> r : baris("SELECT id_kios, nama_kios FROM kios WHERE LOWER(TRIM(nama_kecamatan)) = LOWER(TRIM(?)) ORDER BY nama_kios", kecamatan)) {
                out.add(new String[]{String.valueOf(i(r, "id_kios")), s(r, "nama_kios")});
            }
            return out;
        });
    }

    /** Petani otomatis ditempatkan di kios yang punya penyalur pada kecamatannya. Form petani tidak meminta no. telepon:
     *  kolom no_hp pada tabel user diisi dengan no. telepon penyalur kios tersebut. */
    public static void daftarPetani(String nama, String nik, String kecamatan, String luasTeks, String email, String sandi) {
        coba(() -> {
            UserDao dao = new UserDao();
            if (dao.emailTerdaftar(email)) {
                throw new Galat("Email sudah terdaftar.");
            }
            if (dao.nikTerdaftar(nik)) {
                throw new Galat("NIK sudah terdaftar.");
            }
            BigDecimal luas = new BigDecimal(luasTeks.trim().replace(',', '.'));
            Kios kios = kiosDiKecamatan(kecamatan);   // kios di kecamatan itu yang punya penyalur
            int idKios = kios.getId();
            Map<String, Object> hp = Koneksi.one("SELECT u.no_hp FROM penyalur py JOIN `user` u ON u.id_user = py.id_user "
                    + "WHERE py.kios_id_kios = ? LIMIT 1", idKios);
            String noHp = s(hp, "no_hp");
            if (!model.Security.isDigits(noHp, 9, 15)) {
                noHp = "000000000";
            }
            String golongan = KlasifikasiPetani.tentukanGolongan(luas);
            Petani baru = new Petani(0, nama, email, noHp, nik, luas, golongan, kios.getId(), kios.getNamaKios(),
                    kios.getNamaKecamatan());
            dao.daftar(baru, sandi);
            return null;
        });
    }

    public static void daftarPenyalur(String namaKios, String izinAngka, String kecamatan, String noHp,
            String email, String sandi) {
        coba(() -> {
            UserDao dao = new UserDao();
            if (dao.emailTerdaftar(email)) {
                throw new Galat("Email sudah terdaftar.");
            }
            KiosDao kiosDao = new KiosDao();
            Map<String, Object> r = Koneksi.one("SELECT id_kios, nama_kios, nama_kecamatan FROM kios "
                    + "WHERE LOWER(TRIM(nama_kecamatan)) = LOWER(TRIM(?)) AND LOWER(TRIM(nama_kios)) = LOWER(TRIM(?)) LIMIT 1",
                    kecamatan, namaKios);
            Kios kios;
            if (r == null || r.isEmpty()) {
                long id = kiosDao.insert(new Kios(0, namaKios.trim(), kecamatan));
                kios = new Kios((int) id, namaKios.trim(), kecamatan);
            } else {
                kios = new Kios(i(r, "id_kios"), s(r, "nama_kios"), s(r, "nama_kecamatan"));
            }
            String izin = String.format("SIUP/%d/%03d", LocalDate.now().getYear(), Long.parseLong(izinAngka));
            Penyalur baru = new Penyalur(0, namaKios, email, noHp, izin, kios.getNamaKios(), kios.getId(),
                    kios.getNamaKecamatan());
            dao.daftar(baru, sandi);
            Koneksi.update("UPDATE penyalur SET no_telepon = ? WHERE id_user = ?", noHp, baru.getId());
            return null;
        });
    }

    // ================================================================== profil

    public static String[][] profil() {
        User u = Session.user();
        if (u == null) {
            return SampleData.profilPengelola();   // pratinjau desain tanpa login
        }
        if (u instanceof Pengelola p) {
            return new String[][]{{"Nama", p.getNama()}, {"Peran", "Pengelola"}, {"Jabatan", nz(p.getJabatan())},
                {"NIP", nz(p.getNip())}, {"No. telepon", p.getNoHp()}, {"Email", p.getEmail()}};
        }
        if (u instanceof Penyalur p) {
            return new String[][]{{"Nama kios", p.getNamaKios()}, {"Peran", "Penyalur"},
                {"No. izin usaha", p.getNomorIzinUsaha()}, {"Kecamatan layanan", p.getNamaKecamatan()},
                {"No. telepon", p.getNoHp()}, {"Email", p.getEmail()}};
        }
        Petani p = (Petani) u;
        return new String[][]{{"Nama", p.getNama()}, {"Peran", "Petani"}, {"NIK", p.getNik()},
            {"Kecamatan", p.getNamaKecamatan()},
            {"Luas lahan (ha)", String.format(Locale.GERMANY, "%.2f", p.getLuasLahan())},
            {"Email", p.getEmail()}, {"Kios / golongan", p.getNamaKios() + " / " + p.getGolongan()}};
    }

    private static String nz(String v) {
        return v == null || v.isBlank() ? "-" : v;
    }

    /** Nama untuk sapaan (sidebar/judul). */
    public static String namaPengguna() {
        User u = Session.user();
        if (u == null) {
            return "";
        }
        return u instanceof Penyalur p ? p.getNamaKios() : u.getNama();
    }

    // ================================================================== penyaluran (pengelola -> kios)

    private record Pny(int id, String status, LocalDate kirim, LocalDate terima, int kg, int idKios,
            String kecamatan, String kategori, String produk) {

        Object[] baris() {
            return new Object[]{kodePny(id), tgl(kirim), kategori, produk, kecamatan, fmt(kg), terima == null ? "-" : tgl(terima),
                uiStatus(status)};
        }
    }

    private static List<Pny> daftarPny(String where, Object... p) throws SQLException {
        String sql = "SELECT p.id_penyaluran, p.status_kirim, p.tanggal_kirim, p.tanggal_terima, p.total_berat_kg, "
                + "p.kios_id_kios, k.nama_kecamatan, "
                + "(SELECT GROUP_CONCAT(DISTINCT pu.kategori_pupuk ORDER BY pu.kategori_pupuk SEPARATOR ' & ') "
                + "FROM pupuk pu WHERE pu.penyaluran_id_penyaluran = p.id_penyaluran) AS kategori, "
                + "(SELECT GROUP_CONCAT(CONCAT(TRIM(pu.nama_pupuk), IF(pu.kategori_pupuk = 'Subsidi', ' Subsidi', ' Nonsubsidi')) "
                + "ORDER BY pu.id_pupuk SEPARATOR ', ') FROM pupuk pu WHERE pu.penyaluran_id_penyaluran = p.id_penyaluran) AS produk "
                + "FROM penyaluran p JOIN kios k ON k.id_kios = p.kios_id_kios "
                + (where == null ? "" : "WHERE " + where + " ")
                + "ORDER BY p.id_penyaluran DESC";
        List<Pny> out = new ArrayList<>();
        for (Map<String, Object> r : baris(sql, p)) {
            out.add(new Pny(i(r, "id_penyaluran"), s(r, "status_kirim"), keTanggal(r.get("tanggal_kirim")),
                    keTanggal(r.get("tanggal_terima")), angka(r.get("total_berat_kg")), i(r, "kios_id_kios"),
                    s(r, "nama_kecamatan"), s(r, "kategori"), s(r, "produk")));
        }
        return out;
    }

    private static Object[][] jadi(List<Pny> l) {
        Object[][] o = new Object[l.size()][];
        for (int k = 0; k < o.length; k++) {
            o[k] = l.get(k).baris();
        }
        return o;
    }

    /** No, Tanggal kirim, Kategori, Produk, Kecamatan, Jumlah (kg), Tanggal terima, Status. */
    public static Object[][] penyaluran() {
        return coba(() -> jadi(daftarPny(null)));
    }

    /** 5 penyaluran terbaru: No, Produk, Kecamatan, Jumlah, Status. */
    public static Object[][] penyaluranRingkas() {
        return coba(() -> {
            List<Pny> l = daftarPny(null);
            int n = Math.min(5, l.size());
            Object[][] o = new Object[n][];
            for (int k = 0; k < n; k++) {
                Pny p = l.get(k);
                o[k] = new Object[]{kodePny(p.id), p.produk, p.kecamatan, fmt(p.kg), uiStatus(p.status)};
            }
            return o;
        });
    }

    /** Laporan dengan filter. Parameter kosong/null berarti semua. */
    public static Object[][] laporan(LocalDate dari, LocalDate sampai, String produkLabel, String kecamatan) {
        return coba(() -> {
            String kunci = null;
            if (produkLabel != null && !produkLabel.isBlank() && !produkLabel.trim().equalsIgnoreCase("Semua")) {
                Produk pr = Produk.dari(produkLabel);
                kunci = labelProduk(pr.nama, pr.kategori).toLowerCase(Locale.ROOT);
            }
            List<Pny> out = new ArrayList<>();
            for (Pny p : daftarPny(null)) {
                if (dari != null && (p.kirim == null || p.kirim.isBefore(dari))) {
                    continue;
                }
                if (sampai != null && (p.kirim == null || p.kirim.isAfter(sampai))) {
                    continue;
                }
                if (kecamatan != null && !kecamatan.isBlank() && !kecamatan.equalsIgnoreCase("Semua")
                        && !p.kecamatan.equalsIgnoreCase(kecamatan.trim())) {
                    continue;
                }
                if (kunci != null && !p.produk.toLowerCase(Locale.ROOT).contains(kunci)) {
                    continue;
                }
                out.add(p);
            }
            return jadi(out);
        });
    }

    public static void tambahPenyaluran(String produkLabel, String kecamatan, int kg) {
        coba(() -> {
            Pengelola g = pengelola();
            Produk pr = Produk.dari(produkLabel);
            if (kecamatan == null || kecamatan.startsWith("Pilih")) {
                throw new Galat("Pilih kecamatan tujuan.");
            }
            int karung = karungDariKg(kg);
            Kios kios = kiosDiKecamatan(kecamatan);
            periksaKuotaKecamatan(kios.getNamaKecamatan(), pr, LocalDate.now().getYear(), kg);
            KategoriPenyaluran detail;
            if (pr.subsidi()) {
                BigDecimal het = BigDecimal.valueOf(hargaPerKg(labelProduk(pr.nama, pr.kategori)) * KG_KARUNG);
                detail = new Subsidi(karung, het, het, 0);
            } else {
                detail = new NonSubsidi(karung, (int) (System.currentTimeMillis() / 1000L % 1_000_000_000L));
            }
            Penyaluran p = new Penyaluran(0, Penyaluran.PROSES, LocalDate.now(), null, kios.getId(), g.getId());
            p.tambahPupuk(Pupuk.baru(pr.nama, pr.kategori, karung, null, detail));
            new PenyaluranDao().insert(p);
            return null;
        });
    }

    /** Jika pengelola sudah menetapkan kuota untuk kecamatan/produk/tahun, penyaluran tidak boleh melebihinya. */
    private static void periksaKuotaKecamatan(String kecamatan, Produk pr, int tahun, int kg) throws SQLException {
        siapkanTabel();
        Map<String, Object> k = Koneksi.one("SELECT COALESCE(SUM(kuota_kg), 0) AS kuota, COUNT(*) AS n FROM kuota_kecamatan "
                + "WHERE LOWER(TRIM(nama_kecamatan)) = LOWER(TRIM(?)) AND " + norm("nama_pupuk") + " = ? AND kategori_pupuk = ? AND tahun = ?",
                kecamatan, pr.kunci(), pr.kategori, tahun);
        if (i(k, "n") == 0) {
            return;   // belum ada kuota ditetapkan -> tidak dibatasi
        }
        int terpakai = terpakaiKuota(kecamatan, pr, tahun, null);
        if (terpakai + kg > i(k, "kuota")) {
            throw new Galat("Penyaluran ditolak: melebihi kuota " + labelProduk(pr.nama, pr.kategori) + " " + tahun + " kecamatan "
                    + kecamatan + " (kuota " + fmt(i(k, "kuota")) + " kg, sudah terpakai " + fmt(terpakai) + " kg).");
        }
    }

    /** Total kg yang sudah disalurkan ke kecamatan untuk produk pada tahun tertentu; status null = semua status. */
    private static int terpakaiKuota(String kecamatan, Produk pr, int tahun, String status) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT COALESCE(SUM(GREATEST(COALESCE(s.kuota_subsidi, n.jumlah_karung_pupuk_nonsubsidi, 0) * "
                + KG_KARUNG + ", pu.stok_pupuk)), 0) AS kg "
                + "FROM pupuk pu JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                + "JOIN kios k ON k.id_kios = p.kios_id_kios "
                + "LEFT JOIN subsidi s ON s.id_pupuk = pu.id_pupuk LEFT JOIN non_subsidi n ON n.id_pupuk = pu.id_pupuk "
                + "WHERE LOWER(TRIM(k.nama_kecamatan)) = LOWER(TRIM(?)) AND " + norm("pu.nama_pupuk") + " = ? AND pu.kategori_pupuk = ? "
                + "AND YEAR(p.tanggal_kirim) = ? " + (status == null ? "" : "AND p.status_kirim = ?"),
                status == null ? new Object[]{kecamatan, pr.kunci(), pr.kategori, tahun}
                        : new Object[]{kecamatan, pr.kunci(), pr.kategori, tahun, status});
        return i(r, "kg");
    }

    private static int karungDariKg(int kg) {
        if (kg < KG_KARUNG || kg % KG_KARUNG != 0) {
            throw new Galat("Jumlah harus kelipatan " + KG_KARUNG + " kg (1 karung = " + KG_KARUNG + " kg).");
        }
        return kg / KG_KARUNG;
    }

    /** Data satu penyaluran untuk mengisi dialog ubah: {kategori, kecamatan, jumlah kg}. */
    public static String[] detailPenyaluran(String kodeTampil) {
        return coba(() -> {
            List<Pny> l = daftarPny("p.id_penyaluran = ?", kode(kodeTampil));
            if (l.isEmpty()) {
                throw new Galat("Data penyaluran tidak ditemukan.");
            }
            Pny p = l.get(0);
            return new String[]{p.kategori, p.kecamatan, String.valueOf(p.kg), p.status};
        });
    }

    /** Ubah tujuan kecamatan dan/atau jumlah (kg). Kategori pupuk tidak dapat diubah. */
    public static void ubahPenyaluran(String kodeTampil, String kategori, String kecamatan, int kg) {
        coba(() -> {
            pengelola();
            int id = kode(kodeTampil);
            PenyaluranDao dao = new PenyaluranDao();
            Penyaluran p = dao.findById(id);
            if (p == null) {
                throw new Galat("Data penyaluran tidak ditemukan.");
            }
            if (kategori != null && !kategori.startsWith("Pilih")) {
                for (Pupuk pu : p.getPupuk()) {
                    if (!pu.getKategori().equalsIgnoreCase(kategori)) {
                        throw new Galat("Kategori pupuk tidak dapat diubah. Hapus penyaluran lalu buat ulang.");
                    }
                }
            }
            if (kecamatan != null && !kecamatan.startsWith("Pilih")) {
                p.setIdKios(kiosDiKecamatan(kecamatan).getId());
            }
            int karung = karungDariKg(kg);
            boolean jumlahBerubah = karung * KG_KARUNG != p.getTotalBeratKg();
            if (jumlahBerubah) {
                if (!Penyaluran.PROSES.equals(p.getStatusKirim())) {
                    throw new Galat("Penyaluran yang sudah diterima kios tidak dapat diubah jumlahnya.");
                }
                if (p.getPupuk().size() != 1) {
                    throw new Galat("Penyaluran ini berisi beberapa jenis pupuk; jumlah tidak dapat diubah dari layar ini.");
                }
            }
            dao.update(p);
            if (jumlahBerubah) {
                Pupuk pu = p.getPupuk().get(0);
                Koneksi.tx(() -> {
                    Koneksi.update("UPDATE pupuk SET stok_pupuk = ? WHERE id_pupuk = ?", karung * KG_KARUNG, pu.getId());
                    Koneksi.update("UPDATE penyaluran SET jumlah_karung = ?, total_berat_kg = ? WHERE id_penyaluran = ?",
                            karung, karung * KG_KARUNG + " Kg", id);
                    if (pu.getDetail() instanceof Subsidi) {
                        Koneksi.update("UPDATE subsidi SET kuota_subsidi = ? WHERE id_pupuk = ?", karung, pu.getId());
                    } else {
                        Koneksi.update("UPDATE non_subsidi SET jumlah_karung_pupuk_nonsubsidi = ? WHERE id_pupuk = ?", karung, pu.getId());
                    }
                });
            }
            return null;
        });
    }

    public static void hapusPenyaluran(String kodeTampil) {
        coba(() -> {
            pengelola();
            if (!new PenyaluranDao().delete(kode(kodeTampil))) {
                throw new Galat("Data penyaluran tidak ditemukan.");
            }
            return null;
        });
    }

    // ================================================================== data master (pengelola)

    /** NIK, Nama, Kecamatan, Luas (ha), Email, Terdaftar. */
    public static Object[][] dataPetani() {
        return coba(() -> {
            List<Map<String, Object>> rs = baris("SELECT pt.nik, u.nama, k.nama_kecamatan, pt.luas_lahan, u.email "
                    + "FROM petani pt JOIN `user` u ON u.id_user = pt.id_user JOIN kios k ON k.id_kios = pt.kios_id_kios ORDER BY u.nama");
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                BigDecimal luas = r.get("luas_lahan") instanceof BigDecimal b ? b : BigDecimal.ZERO;
                o[k] = new Object[]{s(r, "nik"), s(r, "nama"), s(r, "nama_kecamatan"),
                    String.format(Locale.GERMANY, "%.2f", luas), s(r, "email"), "-"};
            }
            return o;
        });
    }

    /** Nama kios, Email, Kecamatan, Pengiriman (proses), Selesai, Terdaftar. */
    public static Object[][] dataPenyalur() {
        return coba(() -> {
            List<Map<String, Object>> rs = baris("SELECT py.nama_kios, u.email, k.nama_kecamatan, "
                    + "(SELECT COUNT(*) FROM penyaluran x WHERE x.kios_id_kios = py.kios_id_kios AND x.status_kirim = 'Proses') AS proses, "
                    + "(SELECT COUNT(*) FROM penyaluran x WHERE x.kios_id_kios = py.kios_id_kios AND x.status_kirim = 'Selesai') AS selesai "
                    + "FROM penyalur py JOIN `user` u ON u.id_user = py.id_user JOIN kios k ON k.id_kios = py.kios_id_kios ORDER BY py.nama_kios");
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                o[k] = new Object[]{s(r, "nama_kios"), s(r, "email"), s(r, "nama_kecamatan"), String.valueOf(i(r, "proses")),
                    String.valueOf(i(r, "selesai")), "-"};
            }
            return o;
        });
    }

    /** Produk, Kategori, Stok (kg), Sudah di kios (kg), Menunggu diterima (kg). */
    public static Object[][] ketersediaan() {
        return coba(() -> {
            List<Map<String, Object>> rs = baris("SELECT pu.nama_pupuk, pu.kategori_pupuk, SUM(pu.stok_pupuk) AS total, "
                    + "SUM(CASE WHEN p.status_kirim = 'Selesai' THEN pu.stok_pupuk ELSE 0 END) AS selesai, "
                    + "SUM(CASE WHEN p.status_kirim = 'Proses' THEN pu.stok_pupuk ELSE 0 END) AS proses "
                    + "FROM pupuk pu JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                    + "GROUP BY pu.nama_pupuk, pu.kategori_pupuk ORDER BY pu.kategori_pupuk, pu.nama_pupuk");
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                o[k] = new Object[]{labelProduk(s(r, "nama_pupuk"), s(r, "kategori_pupuk")), s(r, "kategori_pupuk"),
                    fmt(i(r, "total")), fmt(i(r, "selesai")), fmt(i(r, "proses"))};
            }
            return o;
        });
    }

    /** Semua transaksi petani: TRX, Tanggal, Kategori, Produk, Kecamatan, NIK, Nama, Jumlah, Jenis, Status. */
    public static Object[][] transaksiSemua() {
        return coba(() -> {
            siapkanTabel();
            List<Map<String, Object>> rs = baris(SQL_TRX + "ORDER BY t.id_transaksi DESC");
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                o[k] = new Object[]{kodeTrx(i(r, "id_transaksi")), tgl(r.get("tanggal")), s(r, "kategori_pupuk"),
                    labelProduk(s(r, "nama_pupuk"), s(r, "kategori_pupuk")), s(r, "nama_kecamatan"), s(r, "nik"), s(r, "nama"),
                    fmt(i(r, "jumlah_kg")), s(r, "jenis"), s(r, "status")};
            }
            return o;
        });
    }

    // ================================================================== kuota kecamatan (pengelola)

    /** Tetapkan/ubah kuota (kg) suatu produk pada kecamatan untuk satu tahun. */
    public static void simpanKuota(String kecamatan, String produkLabel, int tahun, long kg) {
        coba(() -> {
            pengelola();
            siapkanTabel();
            if (kecamatan == null || kecamatan.startsWith("Pilih")) {
                throw new Galat("Pilih kecamatan.");
            }
            Produk pr = Produk.dari(produkLabel);
            if (kg < 1 || kg > Integer.MAX_VALUE) {
                throw new Galat("Kuota harus lebih dari 0.");
            }
            int n = Koneksi.update("UPDATE kuota_kecamatan SET kuota_kg = ? WHERE LOWER(TRIM(nama_kecamatan)) = LOWER(TRIM(?)) "
                    + "AND " + norm("nama_pupuk") + " = ? AND kategori_pupuk = ? AND tahun = ?", (int) kg, kecamatan, pr.kunci(), pr.kategori, tahun);
            if (n == 0) {
                Koneksi.insert("INSERT INTO kuota_kecamatan (nama_kecamatan, nama_pupuk, kategori_pupuk, tahun, kuota_kg) VALUES (?,?,?,?,?)",
                        kecamatan.trim(), pr.nama, pr.kategori, tahun, (int) kg);
            }
            return null;
        });
    }

    /** Kecamatan, Produk, Tahun, Kuota, Terpakai, Sisa (kg). */
    public static Object[][] kuotaKecamatan() {
        return coba(() -> {
            siapkanTabel();
            List<Map<String, Object>> rs = baris("SELECT nama_kecamatan, nama_pupuk, kategori_pupuk, tahun, kuota_kg FROM kuota_kecamatan "
                    + "ORDER BY tahun DESC, nama_kecamatan, nama_pupuk");
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                Produk pr = new Produk(s(r, "nama_pupuk"), s(r, "kategori_pupuk"));
                int kuota = i(r, "kuota_kg");
                int pakai = terpakaiKuota(s(r, "nama_kecamatan"), pr, i(r, "tahun"), null);
                o[k] = new Object[]{s(r, "nama_kecamatan"), labelProduk(pr.nama, pr.kategori), String.valueOf(i(r, "tahun")),
                    fmt(kuota), fmt(pakai), fmt(Math.max(0, kuota - pakai))};
            }
            return o;
        });
    }

    /** Kecamatan, Produk, Kuota, Terpakai, Dikirim, Dipesan, Sisa, Terserap (tahun berjalan terbaru). */
    public static Object[][] pantauKuota() {
        return coba(() -> {
            siapkanTabel();
            List<Map<String, Object>> rs = baris("SELECT nama_kecamatan, nama_pupuk, kategori_pupuk, tahun, kuota_kg FROM kuota_kecamatan "
                    + "ORDER BY tahun DESC, nama_kecamatan, nama_pupuk");
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                String kec = s(r, "nama_kecamatan");
                Produk pr = new Produk(s(r, "nama_pupuk"), s(r, "kategori_pupuk"));
                int tahun = i(r, "tahun");
                int kuota = i(r, "kuota_kg");
                int terpakai = terpakaiKuota(kec, pr, tahun, null);
                int diterima = terpakaiKuota(kec, pr, tahun, Penyaluran.SELESAI);
                Map<String, Object> m = Koneksi.one("SELECT COALESCE(SUM(CASE WHEN t.status = 'Menunggu' THEN t.jumlah_kg ELSE 0 END), 0) AS menunggu, "
                        + "COALESCE(SUM(CASE WHEN t.status = 'Selesai' THEN t.jumlah_kg ELSE 0 END), 0) AS selesai "
                        + "FROM transaksi t JOIN kios k ON k.id_kios = t.kios_id_kios "
                        + "WHERE LOWER(TRIM(k.nama_kecamatan)) = LOWER(TRIM(?)) AND " + norm("t.nama_pupuk") + " = ? AND t.kategori_pupuk = ? "
                        + "AND YEAR(t.tanggal) = ?", kec, pr.kunci(), pr.kategori, tahun);
                int persen = kuota == 0 ? 0 : (int) Math.round(i(m, "selesai") * 100.0 / kuota);
                o[k] = new Object[]{kec, labelProduk(pr.nama, pr.kategori), fmt(kuota), fmt(terpakai), fmt(diterima), fmt(i(m, "menunggu")),
                    fmt(Math.max(0, kuota - terpakai)), persen + " %"};
            }
            return o;
        });
    }

    // ================================================================== dashboard pengelola

    public record Pasangan(String label, double nilai) {
    }

    public record Dashboard(long stokKg, long hariIniKg, int hariIniN, long bulanIniKg, int bulanIniN, int petani,
            int petaniSubsidi, int kecamatan, int menunggu, List<Pasangan> perKecamatan, long subsidiKg, long nonKg,
            long terdistribusiKg, long sisaKg, List<Pasangan> topProduk) {
    }

    public static Dashboard dashboard() {
        return coba(() -> {
            siapkanTabel();
            List<Pny> semua = daftarPny(null);
            LocalDate h = LocalDate.now();
            long hariKg = 0;
            int hariN = 0;
            long bulanKg = 0;
            int bulanN = 0;
            int menunggu = 0;
            java.util.LinkedHashMap<String, Double> kec = new java.util.LinkedHashMap<>();
            for (Pny p : semua) {
                if (Penyaluran.PROSES.equals(p.status)) {
                    menunggu++;
                }
                if (p.kirim != null && p.kirim.equals(h)) {
                    hariKg += p.kg;
                    hariN++;
                }
                if (p.kirim != null && p.kirim.getYear() == h.getYear() && p.kirim.getMonth() == h.getMonth()) {
                    bulanKg += p.kg;
                    bulanN++;
                }
                kec.merge(p.kecamatan, (double) p.kg, Double::sum);
            }
            List<Pasangan> perKec = new ArrayList<>();
            kec.entrySet().stream().sorted((a, b) -> Double.compare(b.getValue(), a.getValue())).limit(6)
                    .forEach(e -> perKec.add(new Pasangan(e.getKey(), e.getValue())));

            Map<String, Object> st = Koneksi.one("SELECT COALESCE(SUM(stok_pupuk), 0) AS total, "
                    + "COALESCE(SUM(CASE WHEN kategori_pupuk = 'Subsidi' THEN stok_pupuk ELSE 0 END), 0) AS sub, "
                    + "COALESCE(SUM(CASE WHEN kategori_pupuk <> 'Subsidi' THEN stok_pupuk ELSE 0 END), 0) AS non FROM pupuk");
            Map<String, Object> pt = Koneksi.one("SELECT COUNT(*) AS n, COALESCE(SUM(golongan <> 'Gol A'), 0) AS sub FROM petani");
            Map<String, Object> kc = Koneksi.one("SELECT COUNT(DISTINCT nama_kecamatan) AS n FROM kios");
            Map<String, Object> td = Koneksi.one("SELECT COALESCE(SUM(jumlah_kg), 0) AS kg FROM transaksi WHERE status = 'Selesai'");
            Map<String, Object> sk = Koneksi.one("SELECT COALESCE(SUM(pu.stok_pupuk), 0) AS kg FROM pupuk pu "
                    + "JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                    + "WHERE p.status_kirim = 'Selesai' AND pu.kategori_pupuk = 'Subsidi'");

            List<Pasangan> top = new ArrayList<>();
            for (Map<String, Object> r : baris("SELECT pu.nama_pupuk, pu.kategori_pupuk, SUM(pu.stok_pupuk) AS kg FROM pupuk pu "
                    + "GROUP BY pu.nama_pupuk, pu.kategori_pupuk ORDER BY kg DESC LIMIT 6")) {
                top.add(new Pasangan(labelProduk(s(r, "nama_pupuk"), s(r, "kategori_pupuk")), i(r, "kg")));
            }
            return new Dashboard(lng(st, "total"), hariKg, hariN, bulanKg, bulanN, i(pt, "n"), i(pt, "sub"),
                    i(kc, "n"), menunggu, perKec, lng(st, "sub"), lng(st, "non"),
                    lng(td, "kg"), lng(sk, "kg"), top);
        });
    }

    public static String ribuan(long n) {
        return fmt(n);
    }

    // ================================================================== penyalur (kios)

    /** Pengiriman dari gudang yang menunggu konfirmasi: No, Tanggal kirim, Kategori, Produk, Jumlah, Status, Tanggal terima. */
    public static Object[][] pengirimanMasuk() {
        return coba(() -> {
            List<Pny> l = daftarPny("p.kios_id_kios = ? AND p.status_kirim = 'Proses'", penyalur().getIdKios());
            Object[][] o = new Object[l.size()][];
            for (int k = 0; k < o.length; k++) {
                Pny p = l.get(k);
                o[k] = new Object[]{kodePny(p.id), tgl(p.kirim), p.kategori, p.produk, fmt(p.kg), uiStatus(p.status), "-"};
            }
            return o;
        });
    }

    public static void terimaPengiriman(String kodeTampil) {
        coba(() -> {
            Penyalur py = penyalur();
            int id = kode(kodeTampil);
            List<Pny> l = daftarPny("p.id_penyaluran = ? AND p.kios_id_kios = ?", id, py.getIdKios());
            if (l.isEmpty()) {
                throw new Galat("Pengiriman tidak ditemukan untuk kios Anda.");
            }
            Pny p = l.get(0);
            LocalDate hari = LocalDate.now();
            if (p.kirim != null && hari.isBefore(p.kirim)) {
                throw new Galat("Pengiriman belum dapat diterima. Tanggal kirim: " + tgl(p.kirim) + ".");
            }
            if (!new PenyaluranDao().konfirmasiTerima(id, py.getIdKios(), hari)) {
                throw new Galat("Pengiriman sudah dikonfirmasi sebelumnya.");
            }
            return null;
        });
    }

    /** Riwayat pengiriman dari gudang ke kios ini. */
    public static Object[][] riwayatPengirimanKios() {
        return coba(() -> jadi(daftarPny("p.kios_id_kios = ?", penyalur().getIdKios())));
    }

    private static final String SQL_TRX = "SELECT t.id_transaksi, t.tanggal, t.tanggal_selesai, t.nama_pupuk, t.kategori_pupuk, t.jumlah_kg, "
            + "t.jenis, t.status, t.kios_id_kios, k.nama_kecamatan, k.nama_kios, u.nama, pt.nik "
            + "FROM transaksi t JOIN kios k ON k.id_kios = t.kios_id_kios "
            + "JOIN `user` u ON u.id_user = t.petani_id_user JOIN petani pt ON pt.id_user = t.petani_id_user ";

    /** Pesanan petani menunggu: TRX, Tanggal, Kategori, Produk, NIK, Nama, Jumlah, Stok tersedia. */
    public static Object[][] pesananMenunggu() {
        return coba(() -> {
            siapkanTabel();
            int kios = penyalur().getIdKios();
            List<Map<String, Object>> rs = baris(SQL_TRX + "WHERE t.kios_id_kios = ? AND t.status = 'Menunggu' ORDER BY t.id_transaksi", kios);
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                Produk pr = new Produk(s(r, "nama_pupuk"), s(r, "kategori_pupuk"));
                o[k] = new Object[]{kodeTrx(i(r, "id_transaksi")), tgl(r.get("tanggal")), pr.kategori,
                    labelProduk(pr.nama, pr.kategori), s(r, "nik"), s(r, "nama"), fmt(i(r, "jumlah_kg")),
                    fmt(stokKios(kios, pr))};
            }
            return o;
        });
    }

    public static void setujuiPesanan(String kodeTampil) {
        coba(() -> {
            siapkanTabel();
            int kios = penyalur().getIdKios();
            Map<String, Object> r = Koneksi.one("SELECT * FROM transaksi WHERE id_transaksi = ? AND kios_id_kios = ? AND status = 'Menunggu'",
                    kode(kodeTampil), kios);
            if (r == null || r.isEmpty()) {
                throw new Galat("Pesanan tidak ditemukan atau sudah diproses.");
            }
            Produk pr = new Produk(s(r, "nama_pupuk"), s(r, "kategori_pupuk"));
            int kg = i(r, "jumlah_kg");
            if (kg > stokKios(kios, pr)) {
                throw new Galat("Stok kios tidak mencukupi untuk pesanan ini (stok " + fmt(stokKios(kios, pr)) + " kg).");
            }
            Koneksi.tx(() -> {
                potongStok(kios, pr, kg);
                Koneksi.update("UPDATE transaksi SET status = 'Selesai', tanggal_selesai = ? WHERE id_transaksi = ?",
                        LocalDate.now(), i(r, "id_transaksi"));
            });
            return null;
        });
    }

    public static void tolakPesanan(String kodeTampil) {
        coba(() -> {
            siapkanTabel();
            if (Koneksi.update("UPDATE transaksi SET status = 'Ditolak', tanggal_selesai = ? WHERE id_transaksi = ? "
                    + "AND kios_id_kios = ? AND status = 'Menunggu'", LocalDate.now(), kode(kodeTampil), penyalur().getIdKios()) == 0) {
                throw new Galat("Pesanan tidak ditemukan atau sudah diproses.");
            }
            return null;
        });
    }

    /** Stok kios: Produk, Kategori, Diterima, Terjual, Dipesan, Sisa tersedia (kg). */
    public static Object[][] stokKios() {
        return coba(() -> {
            siapkanTabel();
            int kios = penyalur().getIdKios();
            List<Map<String, Object>> rs = baris("SELECT TRIM(pu.nama_pupuk) AS nama, pu.kategori_pupuk AS kat, SUM(pu.stok_pupuk) AS stok, "
                    + "SUM(COALESCE(s.kuota_subsidi, n.jumlah_karung_pupuk_nonsubsidi, 0)) * " + KG_KARUNG + " AS awal "
                    + "FROM pupuk pu JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                    + "LEFT JOIN subsidi s ON s.id_pupuk = pu.id_pupuk LEFT JOIN non_subsidi n ON n.id_pupuk = pu.id_pupuk "
                    + "WHERE p.kios_id_kios = ? AND p.status_kirim = 'Selesai' "
                    + "GROUP BY TRIM(pu.nama_pupuk), pu.kategori_pupuk ORDER BY pu.kategori_pupuk, nama", kios);
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                Produk pr = new Produk(s(r, "nama"), s(r, "kat"));
                int stok = i(r, "stok");
                int diterima = Math.max(i(r, "awal"), stok);
                int dipesan = dipesanKg(kios, pr);
                o[k] = new Object[]{labelProduk(pr.nama, pr.kategori), pr.kategori, fmt(diterima), fmt(diterima - stok),
                    fmt(dipesan), fmt(Math.max(0, stok - dipesan))};
            }
            return o;
        });
    }

    /** Ketersediaan produk di kios: Produk, Kategori, Harga (Rp/kg), Tersedia (kg). */
    public static Object[][] produkTersedia(int idKios) {
        return coba(() -> {
            siapkanTabel();
            List<Map<String, Object>> rs = baris("SELECT TRIM(pu.nama_pupuk) AS nama, pu.kategori_pupuk AS kat, SUM(pu.stok_pupuk) AS stok "
                    + "FROM pupuk pu JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                    + "WHERE p.kios_id_kios = ? AND p.status_kirim = 'Selesai' GROUP BY TRIM(pu.nama_pupuk), pu.kategori_pupuk "
                    + "ORDER BY pu.kategori_pupuk, nama", idKios);
            List<Object[]> o = new ArrayList<>();
            for (Map<String, Object> r : rs) {
                Produk pr = new Produk(s(r, "nama"), s(r, "kat"));
                int tersedia = Math.max(0, i(r, "stok") - dipesanKg(idKios, pr));
                String label = labelProduk(pr.nama, pr.kategori);
                o.add(new Object[]{label, pr.kategori, fmt(hargaPerKg(label)), fmt(tersedia)});
            }
            return o.toArray(new Object[0][]);
        });
    }

    public static Object[][] produkTersediaKiosSaya() {
        return coba(() -> {
            if (pengguna() instanceof Petani p) {
                Object[][] semua = produkTersedia(p.getIdKios());
                if (berhak(p)) {
                    return semua;
                }
                // petani tidak berhak subsidi: hanya produk nonsubsidi yang ditampilkan
                return java.util.Arrays.stream(semua).filter(r -> !"Subsidi".equals(String.valueOf(r[1]))).toArray(Object[][]::new);
            }
            return produkTersedia(penyalur().getIdKios());
        });
    }

    /** Nama petani ber-NIK tersebut di kios penyalur yang login; galat bila NIK tidak terdaftar di kios itu. */
    public static String namaPetaniNik(String nik) {
        return coba(() -> petaniDiKios(nik, penyalur().getIdKios()).getNama());
    }

    /** Apakah petani yang sedang login berhak pupuk subsidi (lahan tidak lebih dari 2 ha). */
    public static boolean berhakSubsidiSaya() {
        return coba(() -> berhak(petani()));
    }

    /** Apakah petani ber-NIK tersebut (di kios penyalur yang login) berhak pupuk subsidi. */
    public static boolean berhakSubsidiNik(String nik) {
        return coba(() -> berhak(petaniDiKios(nik, penyalur().getIdKios())));
    }

    private static int stokKios(int idKios, Produk pr) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT COALESCE(SUM(pu.stok_pupuk), 0) AS s FROM pupuk pu "
                + "JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                + "WHERE p.kios_id_kios = ? AND p.status_kirim = 'Selesai' AND " + norm("pu.nama_pupuk") + " = ? AND pu.kategori_pupuk = ?",
                idKios, pr.kunci(), pr.kategori);
        return i(r, "s");
    }

    private static int dipesanKg(int idKios, Produk pr) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT COALESCE(SUM(jumlah_kg), 0) AS s FROM transaksi "
                + "WHERE kios_id_kios = ? AND status = 'Menunggu' AND " + norm("nama_pupuk") + " = ? AND kategori_pupuk = ?",
                idKios, pr.kunci(), pr.kategori);
        return i(r, "s");
    }

    /** Potong stok kg dari batch kios (yang lebih lama dulu). Dipanggil di dalam transaksi DB. */
    private static void potongStok(int idKios, Produk pr, int kg) throws SQLException {
        PupukDao dao = new PupukDao();
        int sisa = kg;
        for (Map<String, Object> r : baris("SELECT pu.id_pupuk, pu.stok_pupuk FROM pupuk pu "
                + "JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                + "WHERE p.kios_id_kios = ? AND p.status_kirim = 'Selesai' AND " + norm("pu.nama_pupuk") + " = ? "
                + "AND pu.kategori_pupuk = ? AND pu.stok_pupuk > 0 ORDER BY pu.id_pupuk", idKios, pr.kunci(), pr.kategori)) {
            if (sisa == 0) {
                break;
            }
            int ambil = Math.min(sisa, i(r, "stok_pupuk"));
            if (!dao.kurangiStok(i(r, "id_pupuk"), ambil)) {
                throw new SQLException("Stok berubah saat diproses, coba lagi.");
            }
            sisa -= ambil;
        }
        if (sisa > 0) {
            throw new SQLException("Stok tidak mencukupi.");
        }
    }

    // ---- kuota petani

    private static int terpakaiSubsidiKg(int idPetani) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT COALESCE(SUM(jumlah_kg), 0) AS s FROM transaksi "
                + "WHERE petani_id_user = ? AND kategori_pupuk = 'Subsidi' AND status IN ('Menunggu', 'Selesai')", idPetani);
        return i(r, "s");
    }

    /** Kuota subsidi per tahun (semua pupuk subsidi digabung) menurut golongan di database: C 300 kg, B 150 kg, A tidak berhak. */
    private static int kuotaKg(Petani p) {
        String gol = p.getGolongan() == null ? "" : p.getGolongan().trim();
        if (gol.equalsIgnoreCase(KlasifikasiPetani.GOL_C)) {
            return 300;
        }
        if (gol.equalsIgnoreCase(KlasifikasiPetani.GOL_B)) {
            return 150;
        }
        return 0;
    }

    private static boolean berhak(Petani p) {
        return kuotaKg(p) > 0;
    }

    private static Object[][] barisKuota(Petani p) throws SQLException {
        siapkanTabel();
        int kuota = kuotaKg(p);
        int pakai = terpakaiSubsidiKg(p.getId());
        String ket = kuota == 0 ? "Pupuk subsidi (tidak berhak, " + p.getGolongan() + ")" : "Pupuk subsidi";
        return new Object[][]{{ket, fmt(kuota), fmt(pakai), fmt(Math.max(0, kuota - pakai))}};
    }

    /** Kuota petani yang sedang login: Produk, Kuota (kg), Sisa (kg). */
    public static Object[][] kuotaSaya() {
        return coba(() -> {
            Object[][] r = barisKuota(petani());
            return new Object[][]{{r[0][0], r[0][1], r[0][3]}};   // Produk, Kuota (kg), Sisa (kg)
        });
    }

    /** Kuota petani (kios penyalur ini) berdasarkan NIK. */
    public static Object[][] kuotaPetani(String nik) {
        return coba(() -> {
            Petani p = petaniDiKios(nik, penyalur().getIdKios());
            return barisKuota(p);
        });
    }

    private static Petani petaniDiKios(String nik, int idKios) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT id_user FROM petani WHERE nik = ? AND kios_id_kios = ?", nik, idKios);
        if (r == null || r.isEmpty()) {
            throw new Galat("NIK tidak terdaftar sebagai petani di kios Anda.");
        }
        return (Petani) new UserDao().cari(i(r, "id_user"));
    }

    // ---- transaksi

    private static void periksaTransaksi(Petani p, Produk pr, int kg) throws SQLException {
        if (kg <= 0) {
            throw new Galat("Jumlah harus lebih dari 0.");
        }
        if (pr.subsidi()) {
            if (!berhak(p)) {
                throw new Galat("Petani " + p.getGolongan() + " tidak berhak pupuk subsidi. Pilih pupuk nonsubsidi.");
            }
            int sisa = kuotaKg(p) - terpakaiSubsidiKg(p.getId());
            if (kg > sisa) {
                throw new Galat("Melebihi sisa kuota subsidi (sisa " + fmt(Math.max(0, sisa)) + " kg).");
            }
        }
        int tersedia = stokKios(p.getIdKios(), pr) - dipesanKg(p.getIdKios(), pr);
        if (tersedia <= 0) {
            throw new Galat("Stok " + labelProduk(pr.nama, pr.kategori) + " belum tersedia di kios.");
        }
        if (kg > tersedia) {
            throw new Galat("Stok kios tidak mencukupi (tersedia " + fmt(tersedia) + " kg).");
        }
    }

    /** Petani memesan pupuk (status Menunggu sampai disetujui penyalur). */
    public static void pesan(String produkLabel, int kg) {
        coba(() -> {
            siapkanTabel();
            Petani p = petani();
            Produk pr = Produk.dari(produkLabel);
            periksaTransaksi(p, pr, kg);
            Koneksi.insert("INSERT INTO transaksi (petani_id_user, kios_id_kios, nama_pupuk, kategori_pupuk, jumlah_kg, jenis, status, tanggal) "
                    + "VALUES (?,?,?,?,?,?,?,?)", p.getId(), p.getIdKios(), pr.nama, pr.kategori, kg, "Pesanan", "Menunggu", LocalDate.now());
            return null;
        });
    }

    /** Penyalur menyerahkan pupuk langsung kepada petani (stok langsung dipotong). */
    public static void salurkan(String nik, String produkLabel, int kg) {
        coba(() -> {
            siapkanTabel();
            Penyalur py = penyalur();
            Petani p = petaniDiKios(nik, py.getIdKios());
            Produk pr = Produk.dari(produkLabel);
            periksaTransaksi(p, pr, kg);
            Koneksi.tx(() -> {
                potongStok(py.getIdKios(), pr, kg);
                Koneksi.insert("INSERT INTO transaksi (petani_id_user, kios_id_kios, nama_pupuk, kategori_pupuk, jumlah_kg, jenis, status, tanggal, tanggal_selesai) "
                        + "VALUES (?,?,?,?,?,?,?,?,?)", p.getId(), py.getIdKios(), pr.nama, pr.kategori, kg, "Langsung", "Selesai",
                        LocalDate.now(), LocalDate.now());
            });
            return null;
        });
    }

    /** Pesanan milik petani: TRX, Tanggal, Kategori, Produk, Kecamatan, Jumlah, Status. */
    public static Object[][] statusPesananSaya() {
        return coba(() -> {
            siapkanTabel();
            List<Map<String, Object>> rs = baris(SQL_TRX + "WHERE t.petani_id_user = ? AND t.jenis = 'Pesanan' ORDER BY t.id_transaksi DESC", petani().getId());
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                o[k] = new Object[]{kodeTrx(i(r, "id_transaksi")), tgl(r.get("tanggal")), s(r, "kategori_pupuk"),
                    labelProduk(s(r, "nama_pupuk"), s(r, "kategori_pupuk")), s(r, "nama_kecamatan"), fmt(i(r, "jumlah_kg")), s(r, "status")};
            }
            return o;
        });
    }

    public static void batalkanPesanan(String kodeTampil) {
        coba(() -> {
            siapkanTabel();
            if (Koneksi.update("UPDATE transaksi SET status = 'Dibatalkan', tanggal_selesai = ? WHERE id_transaksi = ? "
                    + "AND petani_id_user = ? AND status = 'Menunggu'", LocalDate.now(), kode(kodeTampil), petani().getId()) == 0) {
                throw new Galat("Hanya pesanan berstatus Menunggu yang dapat dibatalkan.");
            }
            return null;
        });
    }

    /** Riwayat penerimaan petani: TRX, Tanggal, Kategori, Produk, Kecamatan, Jumlah, Penyalur. */
    public static Object[][] riwayatPetani() {
        return coba(() -> {
            siapkanTabel();
            List<Map<String, Object>> rs = baris(SQL_TRX + "WHERE t.petani_id_user = ? AND t.status = 'Selesai' ORDER BY t.id_transaksi DESC", petani().getId());
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                o[k] = new Object[]{kodeTrx(i(r, "id_transaksi")), tgl(r.get("tanggal_selesai")), s(r, "kategori_pupuk"),
                    labelProduk(s(r, "nama_pupuk"), s(r, "kategori_pupuk")), s(r, "nama_kecamatan"), fmt(i(r, "jumlah_kg")), s(r, "nama_kios")};
            }
            return o;
        });
    }

    /** Riwayat transaksi kios: TRX, Tanggal, Kategori, Produk, NIK, Nama, Jumlah, Jenis, Status. */
    public static Object[][] riwayatPenyalur() {
        return coba(() -> {
            siapkanTabel();
            List<Map<String, Object>> rs = baris(SQL_TRX + "WHERE t.kios_id_kios = ? ORDER BY t.id_transaksi DESC", penyalur().getIdKios());
            Object[][] o = new Object[rs.size()][];
            for (int k = 0; k < o.length; k++) {
                Map<String, Object> r = rs.get(k);
                o[k] = new Object[]{kodeTrx(i(r, "id_transaksi")), tgl(r.get("tanggal")), s(r, "kategori_pupuk"),
                    labelProduk(s(r, "nama_pupuk"), s(r, "kategori_pupuk")), s(r, "nik"), s(r, "nama"), fmt(i(r, "jumlah_kg")),
                    s(r, "jenis"), s(r, "status")};
            }
            return o;
        });
    }

    // ================================================================== ringkasan beranda

    /** {stok kios (kg), pengiriman masuk, pesanan menunggu, tersalur bulan ini (kg)}. */
    public static String[] berandaPenyalur() {
        return coba(() -> {
            siapkanTabel();
            int kios = penyalur().getIdKios();
            Map<String, Object> a = Koneksi.one("SELECT COALESCE(SUM(pu.stok_pupuk), 0) AS s FROM pupuk pu "
                    + "JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran WHERE p.kios_id_kios = ? AND p.status_kirim = 'Selesai'", kios);
            Map<String, Object> b = Koneksi.one("SELECT COUNT(*) AS n FROM penyaluran WHERE kios_id_kios = ? AND status_kirim = 'Proses'", kios);
            Map<String, Object> c = Koneksi.one("SELECT COUNT(*) AS n FROM transaksi WHERE kios_id_kios = ? AND status = 'Menunggu'", kios);
            LocalDate h = LocalDate.now();
            Map<String, Object> d = Koneksi.one("SELECT COALESCE(SUM(jumlah_kg), 0) AS s FROM transaksi WHERE kios_id_kios = ? AND status = 'Selesai' "
                    + "AND tanggal_selesai >= ?", kios, h.withDayOfMonth(1));
            return new String[]{fmt(i(a, "s")), String.valueOf(i(b, "n")), String.valueOf(i(c, "n")), fmt(i(d, "s"))};
        });
    }

    /** {kuota (kg), terpakai (kg), sisa (kg), pesanan aktif}. */
    public static String[] berandaPetani() {
        return coba(() -> {
            siapkanTabel();
            Petani p = petani();
            int kuota = kuotaKg(p);
            int pakai = terpakaiSubsidiKg(p.getId());
            Map<String, Object> c = Koneksi.one("SELECT COUNT(*) AS n FROM transaksi WHERE petani_id_user = ? AND status = 'Menunggu'", p.getId());
            return new String[]{fmt(kuota), fmt(pakai), fmt(Math.max(0, kuota - pakai)), String.valueOf(i(c, "n"))};
        });
    }

    public static String kecamatanSaya() {
        User u = Session.user();
        if (u instanceof Penyalur p) {
            return p.getNamaKecamatan();
        }
        if (u instanceof Petani p) {
            return p.getNamaKecamatan();
        }
        return "";
    }

    // ================================================================== notifikasi

    /** Waktu, Judul, Isi, Status. Dibentuk dari data penyaluran dan transaksi (tidak ada tabel khusus). */
    public static Object[][] notifikasi() {
        return coba(() -> {
            siapkanTabel();
            User u = pengguna();
            List<Object[]> o = new ArrayList<>();
            if (u instanceof Penyalur py) {
                for (Pny p : daftarPny("p.kios_id_kios = ? AND p.status_kirim = 'Proses'", py.getIdKios())) {
                    o.add(new Object[]{tgl(p.kirim), "Pengiriman baru", fmt(p.kg) + " kg " + p.produk + " menuju kios Anda (" + kodePny(p.id) + ")", "Baru"});
                }
                for (Map<String, Object> r : baris(SQL_TRX + "WHERE t.kios_id_kios = ? AND t.status = 'Menunggu' ORDER BY t.id_transaksi DESC LIMIT 10", py.getIdKios())) {
                    o.add(new Object[]{tgl(r.get("tanggal")), "Pesanan baru", s(r, "nama") + " memesan " + fmt(i(r, "jumlah_kg")) + " kg "
                        + labelProduk(s(r, "nama_pupuk"), s(r, "kategori_pupuk")), "Baru"});
                }
            } else if (u instanceof Petani pt) {
                for (Map<String, Object> r : baris(SQL_TRX + "WHERE t.petani_id_user = ? ORDER BY t.id_transaksi DESC LIMIT 10", pt.getId())) {
                    String st = s(r, "status");
                    o.add(new Object[]{tgl("Menunggu".equals(st) ? r.get("tanggal") : r.get("tanggal_selesai")), "Pesanan " + st.toLowerCase(Locale.ROOT),
                        kodeTrx(i(r, "id_transaksi")) + ": " + fmt(i(r, "jumlah_kg")) + " kg " + labelProduk(s(r, "nama_pupuk"), s(r, "kategori_pupuk")),
                        "Menunggu".equals(st) ? "Baru" : "Dibaca"});
                }
            } else {
                int n = 0;
                for (Pny p : daftarPny(null)) {
                    if (n++ >= 10) {
                        break;
                    }
                    boolean selesai = Penyaluran.SELESAI.equals(p.status);
                    o.add(new Object[]{tgl(selesai && p.terima != null ? p.terima : p.kirim),
                        selesai ? "Penerimaan dikonfirmasi" : "Menunggu konfirmasi kios",
                        kodePny(p.id) + " (" + p.kecamatan + ") " + fmt(p.kg) + " kg", selesai ? "Dibaca" : "Baru"});
                }
            }
            return o.toArray(new Object[0][]);
        });
    }
}
