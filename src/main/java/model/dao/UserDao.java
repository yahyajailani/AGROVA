package model.dao;

import config.Koneksi;
import model.Pengelola;
import model.Penyalur;
import model.Petani;
import model.Security;
import model.User;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UserDao {
    private static final String SEL_PENGELOLA =
            "SELECT u.id_user, u.nama, u.email, u.no_hp, g.jabatan, g.nip FROM pengelola g JOIN `user` u ON u.id_user = g.id_user";
    private static final String SEL_PENYALUR =
            "SELECT u.id_user, u.nama, u.email, u.no_hp, py.nomor_izin_usaha, py.nama_kios, py.kios_id_kios AS id_kios, k.nama_kecamatan "
                    + "FROM penyalur py JOIN `user` u ON u.id_user = py.id_user JOIN kios k ON k.id_kios = py.kios_id_kios";
    private static final String SEL_PETANI =
            "SELECT u.id_user, u.nama, u.email, u.no_hp, pt.nik, pt.luas_lahan, pt.golongan, pt.kios_id_kios AS id_kios, "
                    + "k.nama_kios, k.nama_kecamatan "
                    + "FROM petani pt JOIN `user` u ON u.id_user = pt.id_user JOIN kios k ON k.id_kios = pt.kios_id_kios";

    private Pengelola pengelola(Map<String, Object> r) {
        return new Pengelola(Koneksi.intOf(r, "id_user"), Koneksi.strOf(r, "nama"), Koneksi.strOf(r, "email"),
                Koneksi.strOf(r, "no_hp"), Koneksi.strOf(r, "jabatan"), Koneksi.strOf(r, "nip"));
    }

    private Penyalur penyalur(Map<String, Object> r) {
        return new Penyalur(Koneksi.intOf(r, "id_user"), Koneksi.strOf(r, "nama"), Koneksi.strOf(r, "email"),
                Koneksi.strOf(r, "no_hp"), Koneksi.strOf(r, "nomor_izin_usaha"), Koneksi.strOf(r, "nama_kios"),
                Koneksi.intOf(r, "id_kios"), Koneksi.strOf(r, "nama_kecamatan"));
    }

    private Petani petani(Map<String, Object> r) {
        return new Petani(Koneksi.intOf(r, "id_user"), Koneksi.strOf(r, "nama"), Koneksi.strOf(r, "email"),
                Koneksi.strOf(r, "no_hp"), Koneksi.strOf(r, "nik"), (BigDecimal) r.get("luas_lahan"),
                Koneksi.strOf(r, "golongan"), Koneksi.intOf(r, "id_kios"), Koneksi.strOf(r, "nama_kios"),
                Koneksi.strOf(r, "nama_kecamatan"));
    }

    public User login(String email, String password) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT id_user FROM `user` WHERE email = ? AND password = ?",
                email, Security.hash(password));
        return r == null || r.isEmpty() ? null : cari(Koneksi.intOf(r, "id_user"));
    }

    public User cari(int id) throws SQLException {
        Map<String, Object> r = Koneksi.one(SEL_PENGELOLA + " WHERE g.id_user = ?", id);
        if (r != null && !r.isEmpty()) {
            return pengelola(r);
        }
        r = Koneksi.one(SEL_PENYALUR + " WHERE py.id_user = ?", id);
        if (r != null && !r.isEmpty()) {
            return penyalur(r);
        }
        r = Koneksi.one(SEL_PETANI + " WHERE pt.id_user = ?", id);
        return r == null || r.isEmpty() ? null : petani(r);
    }

    public User cari(String email) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT id_user FROM `user` WHERE email = ?", email);
        return r == null || r.isEmpty() ? null : cari(Koneksi.intOf(r, "id_user"));
    }

    public List<User> findAll() throws SQLException {
        List<User> out = new ArrayList<>();
        
        List rowsPengelola = Koneksi.query(SEL_PENGELOLA + " ORDER BY u.nama");
        for (Object obj : rowsPengelola) {
            out.add(pengelola((Map<String, Object>) obj));
        }
        
        List rowsPenyalur = Koneksi.query(SEL_PENYALUR + " ORDER BY u.nama");
        for (Object obj : rowsPenyalur) {
            out.add(penyalur((Map<String, Object>) obj));
        }
        
        List rowsPetani = Koneksi.query(SEL_PETANI + " ORDER BY u.nama");
        for (Object obj : rowsPetani) {
            out.add(petani((Map<String, Object>) obj));
        }
        
        return out;
    }

    public boolean emailTerdaftar(String email) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT 1 FROM `user` WHERE email = ?", email);
        return r != null && !r.isEmpty();
    }

    public boolean nikTerdaftar(String nik) throws SQLException {
        Map<String, Object> r = Koneksi.one("SELECT 1 FROM petani WHERE nik = ?", nik);
        return r != null && !r.isEmpty();
    }

    //Daftar akun baru
    public long daftar(User baru, String passwordPlain) throws SQLException {
        long[] id = new long[1];
        String tipe = baru.getPeran().name().toLowerCase();
        
        Koneksi.tx(new Koneksi.Work() {
            @Override
            public void run() throws SQLException {
                id[0] = Koneksi.insert("INSERT INTO `user` (nama, email, password, no_hp, tipe_user) VALUES (?,?,?,?,?)",
                        baru.getNama(), baru.getEmail(), Security.hash(passwordPlain), baru.getNoHp(), tipe);
                if (id[0] <= 0) { // cadangan bila driver tidak mengembalikan kunci otomatis
                    Map<String, Object> r = Koneksi.one("SELECT id_user FROM `user` WHERE email = ?", baru.getEmail());
                    if (r == null || r.get("id_user") == null) throw new SQLException("Akun gagal dibuat: id user tidak ditemukan.");
                    id[0] = ((Number) r.get("id_user")).longValue();
                }
                
                if (baru instanceof Penyalur p) {
                    Koneksi.update("INSERT INTO penyalur (id_user, tipe_user, nomor_izin_usaha, nama_kios, kios_id_kios) VALUES (?,?,?,?,?)",
                            id[0], tipe, p.getNomorIzinUsaha(), p.getNamaKios(), p.getIdKios() > 0 ? (Object) p.getIdKios() : null);
                } else if (baru instanceof Petani t) {
                    Koneksi.update("INSERT INTO petani (id_user, tipe_user, nik, luas_lahan, golongan, kios_id_kios) VALUES (?,?,?,?,?,?)",
                            id[0], tipe, t.getNik(), t.getLuasLahan(), t.getGolongan(), t.getIdKios() > 0 ? (Object) t.getIdKios() : null);
                } else if (baru instanceof Pengelola g) {
                    Koneksi.update("INSERT INTO pengelola (id_user, tipe_user, jabatan, nip) VALUES (?,?,?,?)",
                            id[0], tipe, g.getJabatan(), g.getNip());
                }
            }
        });
        
        baru.setId((int) id[0]);
        return id[0];
    }
}