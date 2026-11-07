package controller;

import config.Koneksi;
import model.KategoriPenyaluran;
import model.BusinessException;
import model.Pengelola;
import model.Penyaluran;
import model.Pupuk;
import model.dao.KiosDao;
import model.dao.LaporanDao;
import model.dao.PenyaluranDao;
import view.PenyaluranView;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

//Menu penyaluran
public class PenyaluranController {
    private final PenyaluranView view = new PenyaluranView();
    private final PenyaluranDao penyaluranDao = new PenyaluranDao();
    private final KiosDao kiosDao = new KiosDao();
    private final LaporanDao laporan = new LaporanDao();
    private final Pengelola pengelola;

    public PenyaluranController(Pengelola pengelola) {
        this.pengelola = pengelola;
    }

    public void jalankan() {
        while (true) {
            int c = view.menu();
            if (c == 0) {
                return;
            }
            view.safe(() -> {
                switch (c) {
                    case 1 -> tambah();
                    case 2 -> view.showFiltered("Data Penyaluran", laporan.penyaluran());
                    case 3 -> view.showFiltered("Ketersediaan Pupuk", laporan.pupuk());
                    case 4 -> ubah();
                    case 5 -> hapus();
                    case 6 -> menuSubsidi();
                    case 7 -> view.showFiltered("Tabel Non-Subsidi", laporan.nonSubsidi());
                    default -> view.pesan("Pilihan Tidak Valid!");
                }
            });
        }
    }

    // TAMBAH
    private void tambah() throws SQLException {
        view.judulTambah();
        view.showTable("Daftar Kios", laporan.kios());
        int idKios = pilihKios();
        if (idKios == 0) {
            return;
        }
        List<Map<String, Object>> penyalur = laporan.penyalurDiKios(idKios);
        view.infoKios(penyalur, laporan.jumlahPetaniDiKios(idKios));
        if (penyalur.isEmpty() && !view.lanjutTanpaPenyalur()) {
            return;
        }
        String status = view.pilihStatus(Penyaluran.PROSES);
        LocalDate kirim = view.inputTanggal("Tanggal kirim", LocalDate.now());
        LocalDate terima = status.equals(Penyaluran.SELESAI) ? view.inputTanggal("Tanggal terima", kirim) : null;
        Penyaluran p = new Penyaluran(0, status, kirim, terima, idKios, pengelola.getId());
        p.validasiTanggal();
        inputPupuk(p, view.pilihSubsidi());
        if (p.getPupuk().isEmpty()) {
            view.batalTanpaPupuk();
            return;
        }
        p.validasiSebelumSimpan();
        p.hitungTotal();
        if (!view.konfirmasiSimpan(p)) {
            view.dibatalkan();
            return;
        }
        penyaluranDao.insert(p);
        view.berhasilDisimpan();
    }

    private int pilihKios() throws SQLException {
        while (true) {
            int id = view.inputIdKiosTujuan();
            if (id == 0 || kiosDao.findById(id) != null) {
                return id;
            }
            view.kiosTidakAda();
        }
    }

    //Pengisian pupuk yang disalurkan
    private void inputPupuk(Penyaluran p, boolean subsidi) {
        do {
            String nama = view.inputNamaPupuk();
            int karung = view.inputJumlahKarung();
            String deskripsi = view.inputDeskripsi();
            try {
                KategoriPenyaluran detail = subsidi ? view.inputSubsidi() : view.inputNonSubsidi(karung);
                detail.validasi(karung);   
                p.tambahPupuk(Pupuk.baru(nama, subsidi ? Pupuk.SUBSIDI : Pupuk.NONSUBSIDI, karung, deskripsi, detail));
                view.pupukDitambahkan(nama);
            } catch (BusinessException e) {
                view.pesan("  " + e.getMessage());
            }
        } while (view.tambahPupukLagi());
    }

    // UBAH
    private void ubah() throws SQLException {
        List<Map<String, Object>> rows = laporan.penyaluran();
        if (rows.isEmpty()) {
            view.belumAdaData();
            return;
        }
        view.showFiltered("Pilih data penyaluran yang akan diubah", rows);
        int id = view.inputIdPenyaluran("diubah");
        if (id == 0) {
            return;
        }
        Penyaluran p = penyaluranDao.findById(id);
        if (p == null) {
            view.dataTidakDitemukan();
            return;
        }
        view.dataSaatIni(p);
        p.setStatusKirim(view.pilihStatus(p.getStatusKirim()));
        p.setTanggalKirim(view.inputTanggal("Tanggal kirim", p.getTanggalKirim()));
        if (p.getStatusKirim().equals(Penyaluran.SELESAI)) {
            LocalDate def = p.getTanggalTerima() != null ? p.getTanggalTerima() : p.getTanggalKirim();
            p.setTanggalTerima(view.inputTanggal("Tanggal terima", def));
        } else {
            p.setTanggalTerima(null);
        }
        while (true) {
            int kios = view.inputIdKiosBaru(p.getIdKios());
            if (kios > 0 && kiosDao.findById(kios) != null) {
                p.setIdKios(kios);
                break;
            }
            if (kios >= 0) {
                view.kiosTidakAda();
            }
        }
        penyaluranDao.update(p);
        view.diperbarui();
    }

    // HAPUS
    private void hapus() throws SQLException {
        List<Map<String, Object>> rows = laporan.penyaluran();
        if (rows.isEmpty()) {
            view.belumAdaData();
            return;
        }
        view.showFiltered("Pilih data penyaluran yang akan dihapus", rows);
        int id = view.inputIdPenyaluran("dihapus");
        if (id == 0) {
            return;
        }
        Penyaluran p = penyaluranDao.findById(id);
        if (p == null) {
            view.dataTidakDitemukan();
            return;
        }
        view.showTable("Pupuk yang ikut terhapus", laporan.rincian("p.id_penyaluran = ?", id));
        if (p.getStatusKirim().equals(Penyaluran.SELESAI)) {
            view.peringatanSudahDiterima();
        }
        if (!view.konfirmasiHapus()) {
            return;
        }
        penyaluranDao.delete(id);
        view.dihapus();
    }

    // SUBSIDI
    private void menuSubsidi() {
        while (true) {
            int c = view.menuSubsidi();
            if (c == 0) {
                return;
            }
            view.safe(() -> {
                if (c == 1) {
                    view.showFiltered("Tabel Subsidi", laporan.subsidi());
                } else {
                    pantauSubsidi();
                }
            });
        }
    }

    private void pantauSubsidi() throws SQLException {
        List<Map<String, Object>> rows = laporan.subsidi();
        int totalKuota = 0;
        int totalSalur = 0;
        for (Map<String, Object> r : rows) {
            int kuota = Koneksi.intOf(r, "kuota_subsidi");
            int salur = Koneksi.intOf(r, "tersalurkan_karung");
            r.put("sisa_kuota", kuota - salur);
            totalKuota += kuota;
            totalSalur += salur;
        }
        view.showFiltered("Pantau Penyaluran Subsidi", rows);
        view.ringkasanKuota(totalKuota, totalSalur);
    }
}
