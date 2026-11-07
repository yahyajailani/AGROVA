package controller;

import model.Pengelola;
import model.dao.UserDao;
import view.PengelolaView;

//Menu pengelola
public class PengelolaController extends RoleController {
    private final PengelolaView view = new PengelolaView();
    private final UserDao userDao = new UserDao();
    private final PenyaluranController penyaluran;

    public PengelolaController(Pengelola pengelola) {
        super(pengelola);
        this.penyaluran = new PenyaluranController(pengelola);
    }

    @Override
    public void jalankan() {
        while (true) {
            int c = view.menuUtama(user.getNama());
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
            case 1 -> view.beranda(user, laporan.ringkasan());
            case 2 -> menuLihatData();
            case 3 -> penyaluran.jalankan();
            case 4 -> menuMonitoring();
            default -> view.pesan("Pilihan Tidak Valid!");
        }
    }

    private void menuLihatData() {
        while (true) {
            int c = view.menuLihatData();
            if (c == 0) {
                return;
            }
            view.safe(() -> {
                switch (c) {
                    case 1 -> view.showFiltered("Data Penyalur", laporan.penyalur());
                    case 2 -> view.showFiltered("Data Petani", laporan.petani());
                    default -> view.daftarPengguna(userDao.findAll());
                }
            });
        }
    }

    private void menuMonitoring() {
        while (true) {
            int c = view.menuMonitoring();
            if (c == 0) {
                return;
            }
            view.safe(() -> {
                switch (c) {
                    case 1 -> view.dashboard(laporan.ringkasan(), laporan.perKios());
                    default -> view.showFiltered("Data Penyaluran Pupuk", laporan.rincian());
                }
            });
        }
    }
}