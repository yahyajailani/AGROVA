package view;

import model.Penyalur;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

//Tampilan Menu Penyalur
public class PenyalurView extends ConsoleView {
    public int menu(Penyalur p) {
        return menu("MENU PENYALUR - " + p.getNamaKios() + " (" + p.getNamaKecamatan() + ")", "Beranda",
                "Mengelola Penyaluran Pupuk", "Mencatat Data Penyaluran", "Monitoring Laporan");
    }

    public int menuPenyaluran() {
        return menu("MENGELOLA PENYALURAN PUPUK", "Konfirmasi Penerimaan dari Pengelola", "Stok Pupuk Kios",
                "Riwayat Penyaluran dari Pengelola");
    }

    public int menuMencatat() {
        return menu("MENCATAT DATA PENYALURAN", "Penyaluran Subsidi", "Penyaluran Non-Subsidi");
    }

    public boolean konfirmasiKeluar() {
        return yesNo("Yakin ingin keluar?");
    }

    public void beranda(Penyalur p, Map<String, Object> ringkasanKios, List<Map<String, Object>> pengirimanMenunggu) {
        pesan("\nSelamat datang, " + p.getNama() + ".");
        showKeyValue("Data kios", p.getInfoProfil());
        showKeyValue("Ringkasan kios Anda", ringkasanKios);
        showTable("Pengiriman dari pengelola menunggu konfirmasi", pengirimanMenunggu);
    }

    //Penyaluran dari pengelola
    public void tidakAdaPengiriman() {
        pesan("Tidak ada pengiriman yang menunggu konfirmasi.");
    }

    public void daftarPengiriman(List<Map<String, Object>> rows) {
        showTable("Daftar pengiriman dari pengelola", rows);
    }

    public int inputIdPengiriman() {
        return askInt("ID pengiriman yang diterima (0 = batal): ");
    }

    public void idTidakAda() {
        pesan("ID tidak ada dalam daftar.");
    }

    public void rincian(List<Map<String, Object>> rows) {
        showTable("Pupuk yang dikirim", rows);
    }

    public boolean fisikSesuai() {
        return yesNo("Fisik pupuk sudah diperiksa dan sesuai?");
    }

    public void dibatalkan() {
        pesan("Konfirmasi dibatalkan.");
    }

    public void belumWaktunya(LocalDate kirim) {
        pesan("Pengiriman dijadwalkan " + kirim + ", belum bisa dikonfirmasi.");
    }

    public void diterima() {
        pesan("\nStatus: Selesai (diterima), stok pupuk kios bertambah");
    }

    //Mencatat penyaluran + bukti
    public String inputNikPenerima() {
        return readLine("Masukkan NIK petani penerima: ");
    }

    public void nikTidakTerdaftar() {
        pesan("NIK tidak terdaftar di kios Anda.");
    }

    public void belumAdaStok(String kategori) {
        pesan("Belum ada pupuk " + kategori + " yang tersedia di kios Anda.");
    }

    public void kuotaPetani(int kuota) {
        pesan("Kuota subsidi petani (golongan dan luas lahan): " + kuota + " karung");
    }

    public int inputIdPupuk() {
        return askInt("ID pupuk yang disalurkan (0 = batal): ");
    }

    public void pupukTidakAda() {
        pesan("Pupuk tidak ada dalam daftar.");
    }

    public int inputJumlah() {
        return askInt("Jumlah karung: ", 1, 1_000_000);
    }

    public void ditolak(String alasan) {
        pesan("Penyaluran ditolak: " + alasan);
    }

    public boolean konfirmasiSerah(String petani, int jumlah, String pupuk) {
        return yesNo("Serahkan " + jumlah + " karung " + pupuk + " kepada " + petani + "?");
    }

    public void penyaluranDicatat(int sisaKuota) {
        pesan("\nPenyaluran berhasil dicatat. Stok pupuk dan kuota dikurangi.");
        if (sisaKuota >= 0) {
            pesan("Sisa kuota petani: " + sisaKuota + " karung");
        }
    }

    public void buktiDibuat(Path file) {
        pesan("Bukti penerimaan digital berhasil dicetak: " + file.toAbsolutePath());
    }

    //Monitoring
    public boolean tanyaCetakLaporan() {
        return yesNo("Cetak laporan ke PDF?");
    }

    public void laporanTersimpan(Path file) {
        pesan("Laporan PDF berhasil dibuat: " + file.toAbsolutePath());
    }
}
