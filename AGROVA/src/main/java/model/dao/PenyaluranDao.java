package model.dao;

import config.Koneksi;
import model.KategoriPenyaluran;
import model.NonSubsidi;
import model.Penyaluran;
import model.Pupuk;
import model.Subsidi;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PenyaluranDao implements CrudDao<Penyaluran> {
    private final PupukDao pupukDao = new PupukDao();

    //Total berat(Kg) bertipe varchar
    private static int beratDariTeks(Object v) {
        if (v == null) {
            return 0;
        }
        String digits = v.toString().replaceAll("[^0-9]", "");
        return digits.isEmpty() ? 0 : Integer.parseInt(digits);
    }

    private Penyaluran map(Map<String, Object> r) {
        Penyaluran p = new Penyaluran(
                Koneksi.intOf(r, "id_penyaluran"), 
                Koneksi.strOf(r, "status_kirim"),
                (LocalDate) r.get("tanggal_kirim"), 
                (LocalDate) r.get("tanggal_terima"),
                Koneksi.intOf(r, "kios_id_kios"), 
                Koneksi.intOf(r, "pengelola_id_user")
        );
        p.setJumlahKarung(Koneksi.intOf(r, "jumlah_karung"));
        p.setTotalBeratKg(beratDariTeks(r.get("total_berat_kg")));
        return p;
    }

    @Override
    public List<Penyaluran> findAll() throws SQLException {
        List<Penyaluran> out = new ArrayList<>();
        List rows = Koneksi.query("SELECT * FROM penyaluran ORDER BY id_penyaluran");
        for (Object obj : rows) {
            Map<String, Object> r = (Map<String, Object>) obj;
            out.add(map(r));
        }
        return out;
    }

    @Override
    public Penyaluran findById(int id) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT * FROM penyaluran WHERE id_penyaluran = ?", id);
        if (r == null || r.isEmpty()) {
            return null;
        }
        Penyaluran p = map(r);
        for (Pupuk pu : pupukDao.findByPenyaluran(id)) {
            pu.setDetail(detail(pu));
            p.tambahPupuk(pu);
        }
        return p;
    }

    private KategoriPenyaluran detail(Pupuk pu) throws SQLException {
        if (Pupuk.SUBSIDI.equals(pu.getKategori())) {
            Map<String, Object> s = Koneksi.one("SELECT * FROM subsidi WHERE id_pupuk = ?", pu.getId());
            return s == null || s.isEmpty() ? null : new Subsidi(
                    Koneksi.intOf(s, "kuota_subsidi"), 
                    (BigDecimal) s.get("harga_normal"),
                    (BigDecimal) s.get("harga_het"), 
                    Koneksi.intOf(s, "kuota_alokasi")
            );
        }
        Map<String, Object> n = Koneksi.one("SELECT * FROM non_subsidi WHERE id_pupuk = ?", pu.getId());
        return n == null || n.isEmpty() ? null : new NonSubsidi(
                Koneksi.intOf(n, "jumlah_karung_pupuk_nonsubsidi"), 
                Koneksi.intOf(n, "no_po_pupuk")
        );
    }
    
    //Simpan Penyaluran
    @Override
    public long insert(Penyaluran p) throws SQLException {
        p.validasiSebelumSimpan();
        p.hitungTotal();
        long[] id = new long[1];
        
        Koneksi.tx(new Koneksi.Work() {
            @Override
            public void run() throws SQLException {
                id[0] = Koneksi.insert("INSERT INTO penyaluran (status_kirim, tanggal_kirim, tanggal_terima, pengelola_id_user, "
                        + "jumlah_karung, total_berat_kg, kios_id_kios) VALUES (?,?,?,?,?,?,?)",
                        p.getStatusKirim(), p.getTanggalKirim(), p.getTanggalTerima(), p.getIdPengelola(),
                        p.getJumlahKarung(), p.getTotalBeratKg() + " Kg", p.getIdKios());
                
                for (Pupuk pu : p.getPupuk()) {
                    pu.setIdPenyaluran((int) id[0]);
                    long idPupuk = pupukDao.insert(pu);
                    pu.setId((int) idPupuk);
                    
                    KategoriPenyaluran det = pu.getDetail();
                    if (det instanceof Subsidi s) {
                        Koneksi.update("INSERT INTO subsidi (id_pupuk, kuota_subsidi, harga_normal, harga_het, kuota_alokasi) "
                                + "VALUES (?,?,?,?,?)", idPupuk, s.getKuotaSubsidi(), s.getHargaNormal(), s.getHargaHet(), s.getKuotaAlokasi());
                    } else if (det instanceof NonSubsidi n) {
                        Koneksi.update("INSERT INTO non_subsidi (id_pupuk, jumlah_karung_pupuk_nonsubsidi, no_po_pupuk) "
                                + "VALUES (?,?,?)", idPupuk, n.getJumlahKarung(), n.getNoPo());
                    }
                }
            }
        });
        
        p.setId((int) id[0]);
        return id[0];
    }

    //Ubah data penyaluran
    @Override
    public boolean update(Penyaluran p) throws SQLException {
        p.validasiTanggal();
        return Koneksi.update("UPDATE penyaluran SET status_kirim = ?, tanggal_kirim = ?, tanggal_terima = ?, "
                + "kios_id_kios = ? WHERE id_penyaluran = ?",
                p.getStatusKirim(), p.getTanggalKirim(), p.getTanggalTerima(), p.getIdKios(), p.getId()) > 0;
    }

    //Hapus penyaluran
    @Override
    public boolean delete(int id) throws SQLException {
        return Koneksi.update("DELETE FROM penyaluran WHERE id_penyaluran = ?", id) > 0;
    }

    public boolean konfirmasiTerima(int idPenyaluran, int idKios, LocalDate tanggal) throws SQLException {
        return Koneksi.update("UPDATE penyaluran SET status_kirim = ?, tanggal_terima = ? "
                + "WHERE id_penyaluran = ? AND kios_id_kios = ? AND status_kirim <> ?",
                Penyaluran.SELESAI, tanggal, idPenyaluran, idKios, Penyaluran.SELESAI) > 0;
    }
}