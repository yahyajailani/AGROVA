package controller;

import config.Koneksi;
import view.ConsoleView;
import view.MainView;
import model.User;
import model.Pengelola;
import model.Penyalur;
import model.Petani;
import model.dao.LaporanDao;

import java.sql.SQLException;

//Menu Utama Aplikasi
public class MainController {
    private final MainView view = new MainView();
    private final AuthController auth = new AuthController();
    private final LaporanDao laporan = new LaporanDao();

    public void jalankan() {
    try {
        Koneksi.get();
        
        menuUtama();
        
    } catch (SQLException e) {
        view.gagalKoneksi(e.getMessage());
    } catch (ConsoleView.ExitException e) {
        
    } finally {
        Koneksi.close();
        view.terimaKasih();
    }
}


    private void menuUtama() {
        while (true) {
            int c = view.menuUtama();
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
            case 1 -> view.beranda();
            case 2 -> view.tentang();
            case 3 -> view.dashboardPublik(laporan.ringkasan(), laporan.produk());
            case 4 -> masuk();
            case 5 -> {
                if (auth.register()) {
                    masuk();   // use case: Registrasi <<include>> Login
                }
            }
            default -> view.pesan("Pilihan Tidak Valid!");
        }
    }

    private void masuk() throws Exception {
        User u = auth.login();
        if (u != null) {
            buatController(u).jalankan();
            view.sudahLogout();
        }
    }

    private RoleController buatController(User u) {
        return switch (u.getPeran()) {
            case PENGELOLA -> new PengelolaController((Pengelola) u);
            case PENYALUR -> new PenyalurController((Penyalur) u);
            case PETANI -> new PetaniController((Petani) u);
        };
    }
}

