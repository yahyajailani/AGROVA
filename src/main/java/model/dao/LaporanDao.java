package model.dao;

import config.Koneksi;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class LaporanDao {
    
    //Constructor public
    public LaporanDao() {
    }

    private static final int KG_PER_KARUNG = model.Pupuk.BERAT_KARUNG_KG;

    private static String where(String w) {
        return w == null ? "" : "WHERE " + w + " ";
    }

    //Dashboard
    public Map<String, Object> ringkasan() throws SQLException {
    Map<String, Object> r = Koneksi.one(
            "SELECT (SELECT COUNT(*) FROM kios) AS jumlah_kios, "
                    + "(SELECT COUNT(*) FROM penyalur) AS jumlah_penyalur, "
                    + "(SELECT COUNT(*) FROM petani) AS jumlah_petani, "
                    + "(SELECT COUNT(DISTINCT nama_pupuk) FROM pupuk) AS jenis_pupuk, "
                    + "(SELECT COALESCE(SUM(stok_pupuk), 0) FROM pupuk) AS total_stok_kg, "
                    + "(SELECT COUNT(*) FROM penyaluran) AS total_penyaluran, "
                    + "(SELECT COUNT(*) FROM penyaluran WHERE status_kirim = 'Selesai') AS penyaluran_selesai");
    Map<String, Object> hasil = new LinkedHashMap<>();
    hasil.put("jumlah_kios", r.get("jumlah_kios") + " kios");
    hasil.put("jumlah_penyalur", r.get("jumlah_penyalur") + " penyalur");
    hasil.put("jumlah_petani", r.get("jumlah_petani") + " petani");
    hasil.put("jenis_pupuk", r.get("jenis_pupuk") + " jenis");
    hasil.put("total_stok_kg", r.get("total_stok_kg") + " kg");
    hasil.put("total_penyaluran", r.get("total_penyaluran") + " penyaluran");
    hasil.put("penyaluran_selesai", r.get("penyaluran_selesai") + " penyaluran");
    return hasil;
}

    public List perKios() throws SQLException {
        return Koneksi.query(
                "SELECT k.nama_kios AS kios, k.nama_kecamatan AS kecamatan, COUNT(p.id_penyaluran) AS total_penyaluran, "
                        + "COALESCE(SUM(p.status_kirim = 'Proses'), 0) AS proses, "
                        + "COALESCE(SUM(p.status_kirim = 'Selesai'), 0) AS selesai "
                        + "FROM kios k LEFT JOIN penyaluran p ON p.kios_id_kios = k.id_kios "
                        + "GROUP BY k.id_kios, k.nama_kios, k.nama_kecamatan ORDER BY k.nama_kios");
    }

    //Penyaluran
    public List penyaluran() throws SQLException {
        return penyaluran("");
    }

    public List penyaluran(String where, Object... params) throws SQLException {
        String kondisi = (where == null || where.trim().isEmpty()) ? "" : "WHERE " + where + " ";
        return Koneksi.query("SELECT p.id_penyaluran AS id, k.nama_kios AS kios, k.nama_kecamatan AS kecamatan, "
                + "(SELECT GROUP_CONCAT(DISTINCT pu.kategori_pupuk ORDER BY pu.kategori_pupuk SEPARATOR ' & ') "
                + "FROM pupuk pu WHERE pu.penyaluran_id_penyaluran = p.id_penyaluran) AS kategori, "
                + "p.status_kirim AS status, p.tanggal_kirim, p.tanggal_terima, u.nama AS pengelola, "
                + "p.jumlah_karung AS total_karung, p.total_berat_kg "
                + "FROM penyaluran p "
                + "JOIN kios k ON k.id_kios = p.kios_id_kios "
                + "JOIN `user` u ON u.id_user = p.pengelola_id_user "
                + kondisi + "ORDER BY p.id_penyaluran", params);
    }

    public List rincian() throws SQLException {
        return rincian(null);
    }

    public List rincian(String where, Object... params) throws SQLException {
        return Koneksi.query("SELECT p.id_penyaluran AS id, k.nama_kios AS kios, p.status_kirim AS status, p.tanggal_terima, "
                + "pu.id_pupuk, pu.nama_pupuk, pu.kategori_pupuk AS kategori, pu.satuan, "
                + "pu.stok_pupuk DIV " + KG_PER_KARUNG + " AS jumlah_karung, pu.stok_pupuk AS total_berat_kg "
                + "FROM pupuk pu "
                + "JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                + "JOIN kios k ON k.id_kios = p.kios_id_kios "
                + where(where) + "ORDER BY p.id_penyaluran, pu.id_pupuk", params);
    }

    public List subsidi() throws SQLException {
        return subsidi(null);
    }

    public List subsidi(String where, Object... params) throws SQLException {
        return Koneksi.query("SELECT pu.id_pupuk AS id, p.id_penyaluran AS penyaluran, k.nama_kios AS kios, pu.nama_pupuk, "
                + "s.kuota_subsidi, s.kuota_alokasi, s.harga_normal, s.harga_het, p.status_kirim AS status, p.tanggal_kirim, "
                + "CAST(pu.stok_pupuk DIV " + KG_PER_KARUNG + " AS SIGNED) AS stok_karung "
                + "FROM subsidi s JOIN pupuk pu ON pu.id_pupuk = s.id_pupuk "
                + "JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                + "JOIN kios k ON k.id_kios = p.kios_id_kios "
                + where(where) + "ORDER BY pu.id_pupuk", params);
    }

    public List nonSubsidi() throws SQLException {
        return Koneksi.query("SELECT pu.id_pupuk AS id, p.id_penyaluran AS penyaluran, k.nama_kios AS kios, pu.nama_pupuk, "
                + "n.jumlah_karung_pupuk_nonsubsidi AS jumlah_karung, n.no_po_pupuk, p.status_kirim AS status, p.tanggal_kirim "
                + "FROM non_subsidi n JOIN pupuk pu ON pu.id_pupuk = n.id_pupuk "
                + "JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                + "JOIN kios k ON k.id_kios = p.kios_id_kios ORDER BY pu.id_pupuk");
    }

    //Stok & kuota kios
    public List stokTersedia(int idKios) throws SQLException {
        return stokTersedia(idKios, null);
    }

    public List stokTersedia(int idKios, String kategori) throws SQLException {
        String sql = "SELECT pu.id_pupuk AS id, pu.nama_pupuk, pu.kategori_pupuk AS kategori, pu.satuan, "
                + "pu.stok_pupuk AS stok_kg, "
                + "CAST(pu.stok_pupuk DIV " + KG_PER_KARUNG + " AS SIGNED) AS stok_karung, "
                + "CAST(pu.stok_pupuk DIV " + KG_PER_KARUNG + " AS SIGNED) AS tersedia_karung "
                + "FROM pupuk pu JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                + "WHERE p.kios_id_kios = ? AND p.status_kirim = 'Selesai' "
                + (kategori == null ? "" : "AND pu.kategori_pupuk = ? ")
                + "ORDER BY pu.nama_pupuk, pu.id_pupuk";
        return kategori == null ? Koneksi.query(sql, idKios) : Koneksi.query(sql, idKios, kategori);
    }

    public Map<String, Object> ringkasanKios(int idKios) throws SQLException {
        return Koneksi.one("SELECT "
                + "(SELECT COUNT(*) FROM penyaluran WHERE kios_id_kios = ? AND status_kirim = 'Proses') AS pengiriman_proses, "
                + "(SELECT COUNT(*) FROM penyaluran WHERE kios_id_kios = ? AND status_kirim = 'Selesai') AS pengiriman_selesai, "
                + "(SELECT COUNT(*) FROM petani WHERE kios_id_kios = ?) AS jumlah_petani, "
                + "COALESCE((SELECT SUM(pu.stok_pupuk) FROM pupuk pu JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                + "WHERE p.kios_id_kios = ? AND p.status_kirim = 'Selesai' AND pu.kategori_pupuk = 'Subsidi'), 0) AS stok_subsidi_kg, "
                + "COALESCE((SELECT SUM(pu.stok_pupuk) FROM pupuk pu JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                + "WHERE p.kios_id_kios = ? AND p.status_kirim = 'Selesai' AND pu.kategori_pupuk = 'Nonsubsidi'), 0) AS stok_nonsubsidi_kg",
                idKios, idKios, idKios, idKios, idKios);
    }

    //Master data
    public List pupuk() throws SQLException {
        return Koneksi.query("SELECT pu.id_pupuk AS id, pu.nama_pupuk, pu.kategori_pupuk AS kategori, pu.satuan, "
                + "pu.stok_pupuk AS stok, p.id_penyaluran AS penyaluran, k.nama_kios AS kios, p.status_kirim AS status "
                + "FROM pupuk pu JOIN penyaluran p ON p.id_penyaluran = pu.penyaluran_id_penyaluran "
                + "JOIN kios k ON k.id_kios = p.kios_id_kios ORDER BY pu.id_pupuk");
    }

    public List produk() throws SQLException {
        return Koneksi.query("SELECT pu.nama_pupuk, pu.kategori_pupuk AS kategori, pu.satuan, COUNT(*) AS jumlah_batch, "
                + "SUM(pu.stok_pupuk) AS total_stok, MIN(s.harga_het) AS harga_het "
                + "FROM pupuk pu LEFT JOIN subsidi s ON s.id_pupuk = pu.id_pupuk "
                + "GROUP BY pu.nama_pupuk, pu.kategori_pupuk, pu.satuan ORDER BY pu.kategori_pupuk, pu.nama_pupuk");
    }

    public List panduanPupuk() throws SQLException {
        return Koneksi.query("SELECT nama_pupuk, kategori_pupuk AS kategori, satuan, MIN(deskripsi) AS panduan_dosis "
                + "FROM pupuk GROUP BY nama_pupuk, kategori_pupuk, satuan ORDER BY nama_pupuk");
    }

    public List kios() throws SQLException {
        return Koneksi.query("SELECT id_kios AS id, nama_kios, nama_kecamatan FROM kios ORDER BY id_kios");
    }

    public List penyalur() throws SQLException {
        return Koneksi.query("SELECT u.id_user AS id, u.nama, u.email, u.no_hp, py.nama_kios, py.nomor_izin_usaha, k.nama_kecamatan AS kecamatan "
                + "FROM penyalur py JOIN `user` u ON u.id_user = py.id_user "
                + "JOIN kios k ON k.id_kios = py.kios_id_kios ORDER BY u.nama");
    }

    public List penyalurDiKios(int idKios) throws SQLException {
        return Koneksi.query("SELECT u.nama, py.nama_kios, u.no_hp FROM penyalur py JOIN `user` u ON u.id_user = py.id_user "
                + "WHERE py.kios_id_kios = ?", idKios);
    }

    public int jumlahPetaniDiKios(int idKios) throws SQLException {
        return Koneksi.intOf(Koneksi.one("SELECT COUNT(*) AS jumlah FROM petani WHERE kios_id_kios = ?", idKios), "jumlah");
    }

    public List petani() throws SQLException {
        return petani(null);
    }

    public List petani(String where, Object... params) throws SQLException {
        return Koneksi.query("SELECT u.id_user AS id, u.nama, pt.nik, pt.luas_lahan, pt.golongan, u.no_hp, "
                + "k.nama_kios AS kios, k.nama_kecamatan AS kecamatan "
                + "FROM petani pt JOIN `user` u ON u.id_user = pt.id_user "
                + "JOIN kios k ON k.id_kios = pt.kios_id_kios "
                + where(where) + "ORDER BY u.nama", params);
    }
}