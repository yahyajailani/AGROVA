package view;

import model.Role;
import model.User;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

//Tampilan Menu Pengelola
public class PengelolaView extends ConsoleView {
    public int menuUtama(String nama) {
        return menu("MENU PENGELOLA - " + nama, "Beranda", "Melihat Data Penyalur", "Mengelola Data Penyaluran", "Monitoring Laporan");
    }

    public int menuLihatData() {
        return menu("MELIHAT DATA", "Data Penyalur", "Data Petani", "Data Pengguna (semua peran)");
    }

    public int menuMonitoring() {
        return menu("MONITORING LAPORAN", "Lihat Dashboard", "Cetak Laporan Penyaluran (PDF)",
                "Data Penyaluran Pupuk (rincian pupuk)");
    }

    public boolean konfirmasiKeluar() {
        return yesNo("Yakin ingin keluar?");
    }

    public void beranda(User u, Map<String, Object> ringkasan) {
        pesan("\nSelamat datang kembali, " + u.getNama() + " (Pengelola).");
        showKeyValue("Profil", u.getInfoProfil());
        showKeyValue("Ringkasan AGROVA", ringkasan);
    }

    public void dashboard(Map<String, Object> ringkasan, List<Map<String, Object>> perKios) {
        showKeyValue("Ringkasan AGROVA", ringkasan);
        showFiltered("Penyaluran per Kios", perKios);
    }

    public boolean tanyaCetak() {
        return yesNo("Cetak laporan ke PDF?");
    }

    public void laporanTersimpan(Path file) {
        pesan("Laporan PDF berhasil dibuat: " + file.toAbsolutePath());
    }

    //Daftar setiap user
    public void daftarPengguna(List<User> users) {
        System.out.println();
        System.out.println("--- Data Pengguna (semua peran) ---");
        Map<Role, Integer> hitung = new EnumMap<>(Role.class);
        int no = 1;
        for (User u : users) {
            System.out.println(no++ + ". " + u);
            hitung.merge(u.getPeran(), 1, Integer::sum);
        }
        System.out.println("Total: " + users.size() + " pengguna " + hitung);
    }
}

