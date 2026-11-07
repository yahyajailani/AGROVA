package model.dao;

import config.Koneksi;
import model.Kios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KiosDao implements CrudDao<Kios> {
    
    private Kios map(Map<String, Object> r) {
        return new Kios(Koneksi.intOf(r, "id_kios"), Koneksi.strOf(r, "nama_kios"), Koneksi.strOf(r, "nama_kecamatan"));
    }

    @Override
    public List<Kios> findAll() throws SQLException {
        List<Kios> out = new ArrayList<>();
        List rows = Koneksi.query("SELECT * FROM kios ORDER BY id_kios");
        for (Object obj : rows) {
            Map<String, Object> r = (Map<String, Object>) obj;
            out.add(map(r));
        }
        return out;
    }

    @Override
    public Kios findById(int id) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT * FROM kios WHERE id_kios = ?", id);
        return r == null || r.isEmpty() ? null : map(r);
    }

    @Override
    public long insert(Kios k) throws SQLException {
        return Koneksi.insert("INSERT INTO kios (nama_kios, nama_kecamatan) VALUES (?, ?)", k.getNamaKios(), k.getNamaKecamatan());
    }

    @Override
    public boolean update(Kios k) throws SQLException {
        return Koneksi.update("UPDATE kios SET nama_kios = ?, nama_kecamatan = ? WHERE id_kios = ?",
                k.getNamaKios(), k.getNamaKecamatan(), k.getId()) > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return Koneksi.update("DELETE FROM kios WHERE id_kios = ?", id) > 0;
    }
}