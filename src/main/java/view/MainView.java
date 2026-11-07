package view;

import java.util.List;
import java.util.Map;

//Tampilan Menu Utama
public class MainView extends ConsoleView {
    public int menuUtama() {
        return menu("AGROVA - MENU UTAMA", "Beranda", "Tentang Kami", "Dashboard", "Masuk", "Daftar");
    }

    public void beranda() {
        pesan("\nSelamat datang di AGROVA.");
        pesan("Sistem distribusi pupuk subsidi dan non-subsidi. Silakan Masuk atau Daftar untuk melanjutkan.");
    }

    public void tentang() {
        pesan("\nAGROVA - Sistem Informasi Pengelolaan Distribusi Pupuk Subsidi dan Non-Subsidi");
        pesan("pada Perusahaan Root di Samarinda.");
        pesan("Peran pengguna: Pengelola (mengatur penyaluran), Penyalur (menerima dan menyalurkan di kios),");
        pesan("dan Petani (melihat produk, hak subsidi, dan status penerimaan pupuk).");
    }

    public void dashboardPublik(Map<String, Object> ringkasan, List<Map<String, Object>> pupuk) {
        showKeyValue("Ringkasan AGROVA", ringkasan);
        showTable("Ketersediaan Pupuk", pupuk);
    }

    public boolean konfirmasiKeluar() {
        return yesNo("Keluar dari aplikasi?");
    }

    public void gagalKoneksi(String pesanError) {
        pesan("Gagal terhubung ke database: " + pesanError);
        pesan("Cek: MySQL sudah menyala, database 'agrova' sudah di-import,");
        pesan("lalu sesuaikan user/password di Koneksi.java atau lewat environment variable AGROVA_DB_*.");
    }

    public void sudahLogout() {
        pesan("\nAnda telah keluar. Kembali ke Menu Utama.");
    }

    public void terimaKasih() {
        pesan("\nTerima kasih telah menggunakan AGROVA.");
    }
}

