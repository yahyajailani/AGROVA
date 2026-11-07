package controller;

import config.Koneksi;
import model.KlasifikasiPetani;
import model.Penyalur;
import model.Petani;
import model.Pupuk;
import model.dao.PenyaluranDao;
import model.dao.PupukDao;
import view.PdfReport;
import view.PenyalurView;
import view.Table;

import java.nio.file.Path;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Menu penyalur
public class PenyalurController extends RoleController {
    private static final String PENGIRIMAN_MENUNGGU = "p.kios_id_kios = ? AND p.status_kirim = 'Proses'";

    private final PenyalurView view = new PenyalurView();
    private final PenyaluranDao penyaluranDao = new PenyaluranDao();
    private final PupukDao pupukDao = new PupukDao();
    private final Penyalur penyalur;

    public PenyalurController(Penyalur penyalur) {
        super(penyalur);
        this.penyalur = penyalur;
    }

    @Override
    public void jalankan() {
        while (true) {
            int c = view.menu(penyalur);
            if (c == 0) {
                if (view.konfirmasiKeluar()) {
                    return;
                }
                continue;
            }
            view.safe(() -> aksi(c));
        }
    }

    private void aksi(int c) throws Exception {
        switch (c) {
            case 1 -> view.beranda(penyalur, laporan.ringkasanKios(penyalur.getIdKios()),
                    laporan.penyaluran(PENGIRIMAN_MENUNGGU, penyalur.getIdKios()));
            case 2 -> menuPenyaluran();
            case 3 -> menuMencatat();
            case 4 -> monitoring();
            default -> view.pesan("Pilihan Tidak Valid!");
        }
    }

    // Mengelola Penyaluran Pupuk
    private void menuPenyaluran() {
        while (true) {
            int c = view.menuPenyaluran();
            if (c == 0) {
                return;
            }
            view.safe(() -> {
                int idKios = penyalur.getIdKios();
                switch (c) {
                    case 1 -> konfirmasiPenerimaan(idKios);
                    case 2 -> view.showFiltered("Stok Pupuk Kios " + penyalur.getNamaKios(), laporan.stokTersedia(idKios));
                    default -> view.showFiltered("Riwayat Penyaluran dari Pengelola",
                            laporan.penyaluran("p.kios_id_kios = ?", idKios));
                }
            });
        }
    }

    private void konfirmasiPenerimaan(int idKios) throws SQLException {
        List<Map<String, Object>> rows = laporan.penyaluran(PENGIRIMAN_MENUNGGU, idKios);
        if (rows.isEmpty()) {
            view.tidakAdaPengiriman();
            return;
        }
        view.daftarPengiriman(rows);
        int id = view.inputIdPengiriman();
        if (id == 0) {
            return;
        }
        Map<String, Object> pilih = cariBaris(rows, id);
        if (pilih == null) {
            view.idTidakAda();
            return;
        }
        view.rincian(laporan.rincian("p.id_penyaluran = ?", id));
        if (!view.fisikSesuai()) {
            view.dibatalkan();
            return;
        }
        LocalDate kirim = (LocalDate) pilih.get("tanggal_kirim");
        LocalDate hariIni = LocalDate.now();
        if (hariIni.isBefore(kirim)) {
            view.belumWaktunya(kirim);
            return;
        }
        if (penyaluranDao.konfirmasiTerima(id, idKios, hariIni)) {
            view.diterima();
        }
    }

    // Mencatat Data Penyaluran (include Cetak Bukti)
    private void menuMencatat() {
        while (true) {
            int c = view.menuMencatat();
            if (c == 0) {
                return;
            }
            view.safe(() -> salurkan(c == 1 ? Pupuk.SUBSIDI : Pupuk.NONSUBSIDI));
        }
    }

    //Penyaluran ke petani
    private void salurkan(String kategori) throws Exception {
        int idKios = penyalur.getIdKios();
        List<Map<String, Object>> dataPetani = laporan.petani("pt.nik = ? AND pt.kios_id_kios = ?",
                view.inputNikPenerima(), idKios);
        if (dataPetani.isEmpty()) {
            view.nikTidakTerdaftar();
            return;
        }
        Map<String, Object> pt = dataPetani.get(0);
        int kuota = Integer.MAX_VALUE;
        if (kategori.equals(Pupuk.SUBSIDI)) {
            if (!KlasifikasiPetani.berhakSubsidi((BigDecimal) pt.get("luas_lahan"))) {
                view.ditolak("petani Golongan A (lahan lebih dari 2 hektare) tidak berhak pupuk subsidi");
                return;
            }
            kuota = Petani.hitungKuota((BigDecimal) pt.get("luas_lahan"), Table.cell(pt.get("golongan")));
            view.kuotaPetani(kuota);
        }
        List<Map<String, Object>> stok = laporan.stokTersedia(idKios, kategori);
        if (stok.isEmpty()) {
            view.belumAdaStok(kategori);
            return;
        }
        view.showTable("Stok pupuk " + kategori + " di " + penyalur.getNamaKios(), stok);
        int idPupuk = view.inputIdPupuk();
        if (idPupuk == 0) {
            return;
        }
        Map<String, Object> pilih = cariBaris(stok, idPupuk);
        if (pilih == null) {
            view.pupukTidakAda();
            return;
        }
        int jumlah = view.inputJumlah();
        if (jumlah > Koneksi.intOf(pilih, "tersedia_karung")) {
            view.ditolak("melebihi kouta atau stok kurang");
            return;
        }
        if (jumlah > kuota) {
            view.ditolak("melebihi kouta atau stok kurang");
            return;
        }
        String namaPupuk = Koneksi.strOf(pilih, "nama_pupuk");
        if (!view.konfirmasiSerah(Table.cell(pt.get("nama")), jumlah, namaPupuk)) {
            return;
        }
        if (!pupukDao.kurangiStok(idPupuk, jumlah * Pupuk.BERAT_KARUNG_KG)) {
            view.ditolak("melebihi kouta atau stok kurang");
            return;
        }
        view.penyaluranDicatat(kategori.equals(Pupuk.SUBSIDI) ? kuota - jumlah : -1);
        cetakBukti(pt, namaPupuk, kategori, jumlah);   // use case: Mencatat data penyaluran <<include>> Cetak bukti penyaluran
    }

    private void cetakBukti(Map<String, Object> pt, String namaPupuk, String kategori, int jumlah) throws Exception {
        String noBukti = "BP-" + java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        List<String> baris = new ArrayList<>();
        baris.add("No. Bukti       : " + noBukti);
        baris.add("Tanggal serah   : " + LocalDate.now());
        baris.add("Kecamatan       : " + penyalur.getNamaKecamatan());
        baris.add("Penyalur / Kios : " + penyalur.getNama() + " / " + penyalur.getNamaKios());
        baris.add("");
        baris.add("Petani          : " + Table.cell(pt.get("nama")));
        baris.add("NIK             : " + Table.cell(pt.get("nik")));
        baris.add("Pupuk           : " + namaPupuk + " (" + kategori + ")");
        baris.add("Jumlah          : " + jumlah + " karung");
        baris.add("");
        baris.add("");
        baris.add("      Petani (penerima)                 Penyalur");
        baris.add("");
        baris.add("");
        baris.add("      ( " + Table.cell(pt.get("nama")) + " )          ( " + penyalur.getNama() + " )");
        Path f = PdfReport.write(Path.of("bukti"), "bukti_penyaluran_" + noBukti, "BUKTI PENYALURAN PUPUK", baris);
        view.buktiDibuat(f);
    }

    // Monitoring Laporan
    private void monitoring() throws Exception {
        int idKios = penyalur.getIdKios();
        view.showKeyValue("Ringkasan kios " + penyalur.getNamaKios(), laporan.ringkasanKios(idKios));
        List<Map<String, Object>> stok = laporan.stokTersedia(idKios);
        view.showTable("Stok Pupuk Kios", stok);
        List<Map<String, Object>> tampil = view.showFiltered("Laporan Penyaluran ke Kios",
                laporan.penyaluran("p.kios_id_kios = ?", idKios));
        if (tampil.isEmpty() || !view.tanyaCetakLaporan()) {
            return;
        }
        List<String> baris = new ArrayList<>(Table.format(stok));
        baris.add("");
        baris.addAll(Table.format(tampil));
        view.laporanTersimpan(PdfReport.write(Path.of("laporan"), "laporan_penyalur",
                "LAPORAN PENYALUR - " + penyalur.getNamaKios() + " (" + penyalur.getNamaKecamatan() + ")", baris));
    }

    private static Map<String, Object> cariBaris(List<Map<String, Object>> rows, int id) {
        for (Map<String, Object> r : rows) {
            if (((Number) r.get("id")).intValue() == id) {
                return r;
            }
        }
        return null;
    }
}

