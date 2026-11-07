package view;

import model.NonSubsidi;
import model.Penyaluran;
import model.Pupuk;
import model.Subsidi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

//Tampilan dan form Menu Penyaluran
public class PenyaluranView extends ConsoleView {
    public int menu() {
        return menu("MENGELOLA DATA PENYALURAN", "Tambah", "Lihat Data Penyaluran", "Lihat Ketersediaan Pupuk", "Ubah", "Hapus",
                "Penyaluran Subsidi", "Penyaluran Non-Subsidi");
    }

    public int menuSubsidi() {
        return menu("MENU SUBSIDI", "Lihat Tabel Subsidi", "Pantau Status dan Laporan Penyaluran");
    }

    //Tambah
    public void judulTambah() {
        title("TAMBAH PENYALURAN");
    }

    public int inputIdKiosTujuan() {
        return askInt("ID kios tujuan (0 = batal): ");
    }

    public void kiosTidakAda() {
        pesan("  Kios tidak ditemukan.");
    }

    public void infoKios(List<Map<String, Object>> penyalur, int jumlahPetani) {
        showTable("Penyalur di kios ini", penyalur);
        pesan("Petani terdaftar di kios ini: " + jumlahPetani);
    }

    public boolean lanjutTanpaPenyalur() {
        return yesNo("Belum ada penyalur di kios ini. Tetap lanjutkan?");
    }

    public String pilihStatus(String def) {
        return askChoice("Status kirim", Penyaluran.STATUS, Penyaluran.STATUS.indexOf(def));
    }

    public LocalDate inputTanggal(String label, LocalDate def) {
        return askDate(label, def);
    }

    public String inputNamaPupuk() {
        return askText("Jenis / nama pupuk", 150);
    }

    public int inputJumlahKarung() {
        return askInt("Jumlah karung (1 karung = " + Pupuk.BERAT_KARUNG_KG + " kg): ", 1, 1_000_000);
    }

    public String inputDeskripsi() {
        return readLine("Deskripsi pupuk (boleh kosong): ");
    }

    public void pupukDitambahkan(String nama) {
        pesan("  Pupuk ditambahkan: " + nama);
    }

    public boolean tambahPupukLagi() {
        return yesNo("Tambah pupuk lain?");
    }

    public void batalTanpaPupuk() {
        pesan("Penyaluran dibatalkan: belum ada pupuk yang ditambahkan.");
    }

    public boolean pilihSubsidi() {
        return askChoice("Kategori pupuk", List.of("Subsidi", "Non-Subsidi"), -1).equals("Subsidi");
    }

    public Subsidi inputSubsidi() {
        BigDecimal max = new BigDecimal("999999999.99");
        int kuota = askInt("Kuota subsidi (karung): ", 1, 100_000_000);
        BigDecimal normal = askDecimal("Harga normal (Rp): ", BigDecimal.ZERO, max);
        BigDecimal het = askDecimal("Harga HET (Rp): ", BigDecimal.ZERO, max);
        int alokasi = askInt("Kuota alokasi (karung): ", 0, 100_000_000);
        return new Subsidi(kuota, normal, het, alokasi);
    }

    public NonSubsidi inputNonSubsidi(int karung) {
        int jumlah = askInt("Jumlah karung non-subsidi [" + karung + "]: ", 1, 100_000_000);
        int po = askInt("No PO pupuk (angka): ", 1, Integer.MAX_VALUE);
        return new NonSubsidi(jumlah, po);
    }

    public boolean konfirmasiSimpan(Penyaluran p) {
        pesan("\n--- Ringkasan penyaluran ---");
        pesan("Kios tujuan : " + p.getIdKios() + "   Status: " + p.getStatusKirim() + "   Tanggal kirim: " + p.getTanggalKirim());
        for (Pupuk pu : p.getPupuk()) {
            pesan("  - " + pu + " [" + pu.getDetail().getNama() + "]");
        }
        pesan("Total karung : " + p.getJumlahKarung() + "   Total berat: " + p.getTotalBeratKg() + " Kg");
        return yesNo("Simpan penyaluran?");
    }

    public void dibatalkan() {
        pesan("Penyaluran dibatalkan.");
    }

    public void berhasilDisimpan() {
        pesan("\nPenyaluran berhasil");
    }

    //Ubah / hapus
    public void belumAdaData() {
        pesan("Belum ada data penyaluran.");
    }

    public int inputIdPenyaluran(String aksi) {
        return askInt("ID penyaluran yang " + aksi + " (0 = batal): ");
    }

    public void dataTidakDitemukan() {
        pesan("Data tidak ditemukan.");
    }

    public void dataSaatIni(Penyaluran p) {
        showKeyValue("Data saat ini", kv("id", p.getId(), "status_kirim", p.getStatusKirim(), "tanggal_kirim", p.getTanggalKirim(),
                "tanggal_terima", p.getTanggalTerima(), "id_kios", p.getIdKios(),
                "jumlah_karung", p.getJumlahKarung(), "total_berat_kg", p.getTotalBeratKg()));
    }

    public int inputIdKiosBaru(int sekarang) {
        String s = readLine("ID kios tujuan (Enter = tetap " + sekarang + "): ");
        if (s.isEmpty()) {
            return sekarang;
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            pesan("  Input harus berupa angka.");
            return -1;
        }
    }

    public void diperbarui() {
        pesan("\nData Berhasil diperbarui");
    }

    public void peringatanSudahDiterima() {
        pesan("Perhatian: penyaluran ini sudah berstatus Selesai (diterima penyalur).");
    }

    public boolean konfirmasiHapus() {
        return yesNo("Hapus data?");
    }

    public void dihapus() {
        pesan("\nData Berhasil dihapus");
        pesan("Pupuk, kuota subsidi, dan data non-subsidi milik penyaluran ini ikut dihapus otomatis");
    }

    //Subsidi
    public void ringkasanKuota(int totalKuota, int totalSalur) {
        pesan("Total kuota subsidi: " + totalKuota + " karung | tersalurkan: " + totalSalur
                + " karung | sisa: " + (totalKuota - totalSalur) + " karung");
    }
}

