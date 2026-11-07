package controller;

import view.AuthView;
import model.Kios;
import model.Penyalur;
import model.Petani;
import model.User;
import model.KlasifikasiPetani;
import model.dao.KiosDao;
import model.dao.LaporanDao;
import model.dao.UserDao;

import java.sql.SQLException;

//Login dan Daftar
public class AuthController {
    private final AuthView view = new AuthView();
    private final UserDao userDao = new UserDao();
    private final KiosDao kiosDao = new KiosDao();
    private final LaporanDao laporan = new LaporanDao();
    
//Pengaturan alur login pengguna
    public User login() throws SQLException {
        while (true) {
            AuthView.Kredensial k = view.formLogin();
            User u = (User) userDao.login(k.email(), k.password());
            if (u != null) {
                view.loginBerhasil();
                return u;
            }
            if (!view.loginGagalUlangi()) {
                return null;
            }
        }
    }

   //Pendaftaran akun penyalur dan petani
    public boolean register() throws SQLException {
        boolean penyalur = view.pilihPeran().equals("Penyalur");
        String nama = view.inputNama();

        String email;
        while (true) {
            email = view.inputEmail();
            if (!userDao.emailTerdaftar(email)) {
                break;
            }
            if (!view.emailSudahTerdaftarUlangi()) {
                return false;
            }
        }
        String noHp = view.inputNoHp();
        String password = view.inputPassword();

        view.tampilKios(laporan.kios());
        Kios kios;
        while (true) {
            int idKios = view.inputIdKios();
            kios = kiosDao.findById(idKios);
            if (kios != null) {
                break;
            }
            view.kiosTidakAda();
        }
        User baru;
        if (penyalur) {
            String izin = view.inputIzinUsaha();
            baru = new Penyalur(0, nama, email, noHp, izin, kios.getNamaKios(), kios.getId(), kios.getNamaKecamatan());
        } else {
            String nik;
            while (true) {
                nik = view.inputNik();
                if (!userDao.nikTerdaftar(nik)) {
                    break;
                }
                if (!view.nikDuplikatUlangi()) {
                    return false;
                }
            }
            var luas = view.inputLuasLahan();
            String golongan = KlasifikasiPetani.tentukanGolongan(luas);
            
            baru = new Petani(0,nama,email,noHp,nik,luas,golongan,kios.getId(),kios.getNamaKios(),kios.getNamaKecamatan());
        }   
        userDao.daftar(baru, password);
        view.registrasiBerhasil();
        return true;
    }
}

