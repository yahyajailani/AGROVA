package view;

import model.Petani;

import java.util.List;
import java.util.Map;

//Tampilan Menu Petani
public class PetaniView extends ConsoleView {
    public int menu(Petani p) {
        return menu("MENU PETANI - " + p.getNama(), "Beranda", "Melihat Produk", "Menerima Pupuk",
                "Melihat Riwayat Penerimaan Pupuk", "Cek Hak dan Kuota (NIK)", "Status Penyaluran ke Kios");
    }

    public int menuTerimaPupuk() {
        return menu("MENERIMA PUPUK", "Golongan Subsidi", "Golongan Non-Subsidi");
    }

    public boolean konfirmasiKeluar() {
        return yesNo("Yakin ingin keluar?");
    }

    public void beranda(Petani p) {
        pesan("\nSelamat datang, " + p.getNama() + " (AGROVA).");
        showKeyValue("Profil", p.getInfoProfil());
    }

    public boolean tanyaPanduan() {
        return yesNo("Lihat panduan penggunaan dosis pupuk?");
    }

    public String inputNikSaya() {
        return readLine("Masukkan NIK Anda: ");
    }

    public void nikTidakValid() {
        pesan("NIK tidak valid atau bukan milik akun ini");
    }

    //Menerima pupuk
    public void belumAdaStok(String kategori) {
        pesan("Belum ada pupuk " + kategori + " yang tersedia di kios Anda.");
    }

    public void sisaKuota(int sisa) {
        pesan("Kuota subsidi Anda (berdasarkan golongan dan luas lahan): " + sisa + " karung");
    }

    public void kuotaHabis() {
        pesan("Kuota subsidi Anda sudah habis.");
    }

    public int inputIdPupuk() {
        return askInt("ID pupuk yang diterima (0 = batal): ");
    }

    public void pupukTidakAda() {
        pesan("Pupuk tidak ada dalam daftar.");
    }

    public int inputJumlah() {
        return askInt("Jumlah karung: ", 1, 1_000_000);
    }

    public void stokTidakMencukupi(int tersedia) {
        pesan("Jumlah pupuk tidak mencukupi (tersedia " + tersedia + " karung).");
    }

    public void kuotaTidakMencukupi(int sisa) {
        pesan("Kuota subsidi tidak mencukupi (sisa " + sisa + " karung).");
    }

    public boolean konfirmasiTerima(String nama, int jumlah, String kategori) {
        return yesNo("Terima " + jumlah + " karung " + nama + " (" + kategori + ")?");
    }

    public void pupukDiterima(int jumlah) {
        pesan("\nPupuk " + jumlah + " karung berhasil diterima. Stok pupuk telah dikurangi.");
    }

    public void kuotaSetelahDikurangi(int sisa) {
        pesan("Kuota subsidi setelah dikurangi: " + sisa + " karung");
    }

    public void infoHak(Map<String, Object> kuota) {
        showKeyValue("Hak dan kuota subsidi (NIK " + "Anda)", kuota);
    }

    public void daftar(String judul, List<Map<String, Object>> rows) {
        showFiltered(judul, rows);
    }
}

