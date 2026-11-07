package model.dao;

import config.Koneksi;
import model.Pupuk;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PupukDao implements CrudDao<Pupuk> {
    
    private Pupuk map(Map<String, Object> r) {
        return new Pupuk(
                Koneksi.intOf(r, "id_pupuk"), 
                Koneksi.strOf(r, "nama_pupuk"), 
                Koneksi.strOf(r, "kategori_pupuk"),
                Koneksi.strOf(r, "satuan"), 
                Koneksi.intOf(r, "stok_pupuk"), 
                Koneksi.strOf(r, "deskripsi"),
                Koneksi.intOf(r, "penyaluran_id_penyaluran")
        );
    }

    @Override
    public List<Pupuk> findAll() throws SQLException {
        List<Pupuk> out = new ArrayList<>();
        List rows = Koneksi.query("SELECT * FROM pupuk ORDER BY id_pupuk");
        for (Object obj : rows) {
            Map<String, Object> r = (Map<String, Object>) obj;
            out.add(map(r));
        }
        return out;
    }

    public List<Pupuk> findByPenyaluran(int idPenyaluran) throws SQLException {
        List<Pupuk> out = new ArrayList<>();
        List rows = Koneksi.query("SELECT * FROM pupuk WHERE penyaluran_id_penyaluran = ? ORDER BY id_pupuk", idPenyaluran);
        for (Object obj : rows) {
            Map<String, Object> r = (Map<String, Object>) obj;
            out.add(map(r));
        }
        return out;
    }

    @Override
    public Pupuk findById(int id) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT * FROM pupuk WHERE id_pupuk = ?", id);
        return r == null || r.isEmpty() ? null : map(r);
    }

    @Override
    public long insert(Pupuk p) throws SQLException {
        return Koneksi.insert("INSERT INTO pupuk (nama_pupuk, kategori_pupuk, satuan, stok_pupuk, deskripsi, penyaluran_id_penyaluran) "
                + "VALUES (?,?,?,?,?,?)",
                p.getNama(), p.getKategori(), p.getSatuan(), p.getStok(), p.getDeskripsi(), p.getIdPenyaluran());
    }

    @Override
    public boolean update(Pupuk p) throws SQLException {
        return Koneksi.update("UPDATE pupuk SET nama_pupuk = ?, kategori_pupuk = ?, satuan = ?, stok_pupuk = ?, deskripsi = ? WHERE id_pupuk = ?",
                p.getNama(), p.getKategori(), p.getSatuan(), p.getStok(), p.getDeskripsi(), p.getId()) > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return Koneksi.update("DELETE FROM pupuk WHERE id_pupuk = ?", id) > 0;
    }

    //Pengurangan stok secara otomatis
    public boolean kurangiStok(int idPupuk, int jumlahKg) throws SQLException {
        return Koneksi.update("UPDATE pupuk SET stok_pupuk = stok_pupuk - ? WHERE id_pupuk = ? AND stok_pupuk >= ?",
                jumlahKg, idPupuk, jumlahKg) > 0;
    }

    public void tambahStok(int idPupuk, int jumlahKg) throws SQLException {
        Koneksi.update("UPDATE pupuk SET stok_pupuk = stok_pupuk + ? WHERE id_pupuk = ?", jumlahKg, idPupuk);
    }
}