package view.util;

/** Data contoh agar tampilan terlihat hidup saat desain. GuiController: ganti dengan hasil query database. */
public final class SampleData {
    private SampleData() {
    }

    public static Object[][] penyaluran() {
        return new Object[][]{
                {"PNY-0003", "07-10-2026", "Subsidi", "NPK Phonska", "Samarinda Ilir", "750", "-", "Dikirim"},
                {"PNY-0002", "02-10-2026", "Subsidi", "Urea Subsidi", "Sambutan", "3.000", "04-10-2026", "Diterima"},
                {"PNY-0001", "01-10-2026", "Subsidi", "Urea Subsidi", "Samarinda Ulu", "5.000", "03-10-2026", "Diterima"}};
    }

    public static Object[][] penyaluranRingkas() {
        Object[][] p = penyaluran();
        Object[][] r = new Object[p.length][5];
        for (int i = 0; i < p.length; i++) r[i] = new Object[]{p[i][0], p[i][3], p[i][4], p[i][5], p[i][7]};
        return r;
    }

    public static Object[][] kuota() {
        return new Object[][]{
                {"Samarinda Ulu", "Urea Subsidi", "2026", "20.000", "5.000", "15.000"},
                {"Samarinda Ulu", "NPK Phonska", "2026", "15.000", "0", "15.000"},
                {"Sungai Pinang", "Urea Subsidi", "2026", "10.000", "0", "10.000"}};
    }

    public static Object[][] petani() {
        return new Object[][]{
                {"6472010101900001", "Budi Santoso", "Samarinda Ulu", "1,50", "petani1@agrova.id", "01-10-2026"},
                {"6472014505850002", "Siti Rahayu", "Samarinda Ulu", "0,80", "petani2@agrova.id", "01-10-2026"},
                {"6472021212880003", "Ahmad Fauzi", "Samarinda Ilir", "2,00", "-", "01-10-2026"}};
    }

    public static Object[][] ketersediaan() {
        return new Object[][]{
                {"Urea Subsidi", "Subsidi", "145.000", "5.000", "0"},
                {"NPK Phonska Subsidi", "Subsidi", "150.000", "0", "750"},
                {"Pupuk Organik Subsidi", "Subsidi", "150.000", "0", "0"}};
    }

    public static Object[][] pantau() {
        return new Object[][]{
                {"Samarinda Ulu", "Urea Subsidi", "20.000", "5.000", "5.000", "1.420", "15.000", "25 %"},
                {"Samarinda Ulu", "NPK Phonska", "15.000", "0", "0", "0", "15.000", "0 %"},
                {"Sungai Pinang", "Urea Subsidi", "10.000", "0", "0", "0", "10.000", "0 %"}};
    }

    public static Object[][] penyalur() {
        return new Object[][]{
                {"Tani Makmur", "penyalur.ulu@agrova.id", "Samarinda Ulu", "2", "2", "01-10-2026"},
                {"Sumber Tani", "penyalur.pinang@agrova.id", "Sungai Pinang", "0", "0", "01-10-2026"}};
    }

    public static Object[][] penyaluranPetani() {
        return new Object[][]{
                {"TRX-0012", "05-10-2026", "Subsidi", "Urea Subsidi", "Samarinda Ulu", "6472010101900001", "Budi Santoso", "50", "Pesanan", "Diproses"},
                {"TRX-0011", "03-10-2026", "Subsidi", "Urea Subsidi", "Samarinda Ulu", "6472014505850002", "Siti Rahayu", "40", "Langsung", "Diterima"}};
    }

    public static Object[][] pengirimanMasuk() {
        return new Object[][]{
                {"PNY-0003", "07-10-2026", "Subsidi", "NPK Phonska", "750", "Dikirim", "-"}};
    }

    public static Object[][] pesananMenunggu() {
        return new Object[][]{
                {"TRX-0012", "05-10-2026", "Subsidi", "Urea Subsidi", "6472010101900001", "Budi Santoso", "50", "4.700"},
                {"TRX-0013", "05-10-2026", "Subsidi", "NPK Phonska", "6472014505850002", "Siti Rahayu", "40", "750"}};
    }

    public static Object[][] notifikasi() {
        return new Object[][]{
                {"05-10-2026 09:12", "Pengiriman baru", "1.000 kg Urea Subsidi menuju kecamatan Anda", "Baru"},
                {"05-10-2026 08:40", "Pesanan baru", "Budi Santoso memesan 50 kg Urea Subsidi", "Baru"},
                {"01-10-2026 10:00", "Penerimaan dikonfirmasi", "PNY-0001 diterima", "Dibaca"}};
    }

    public static Object[][] kuotaPetani() {
        return new Object[][]{{"Urea Subsidi", "300", "50", "250"}, {"NPK Phonska", "225", "0", "225"}, {"Pupuk Organik Subsidi", "750", "300", "450"}};
    }

    public static Object[][] stokKecamatan() {
        return new Object[][]{
                {"Urea Subsidi", "Subsidi", "4.750", "50", "4.700"},
                {"NPK Phonska Subsidi", "Subsidi", "750", "40", "710"}};
    }

    public static Object[][] stokTersedia() {
        return new Object[][]{
                {"Urea Subsidi", "Subsidi", "2.250", "4.700"},
                {"NPK Phonska Subsidi", "Subsidi", "2.300", "710"}};
    }

    public static Object[][] riwayatPenyalur() {
        return new Object[][]{
                {"TRX-0012", "05-10-2026", "Subsidi", "Urea Subsidi", "6472010101900001", "Budi Santoso", "50", "Pesanan", "Diproses"},
                {"TRX-0011", "03-10-2026", "Subsidi", "Urea Subsidi", "6472014505850002", "Siti Rahayu", "40", "Langsung", "Diterima"}};
    }

    public static Object[][] pesananSaya() {
        return new Object[][]{
                {"TRX-0012", "05-10-2026", "Subsidi", "Urea Subsidi", "Samarinda Ulu", "50", "Diproses"},
                {"TRX-0009", "20-09-2026", "Subsidi", "NPK Phonska", "Samarinda Ulu", "40", "Diterima"}};
    }

    public static Object[][] riwayatPetani() {
        return new Object[][]{
                {"TRX-0009", "21-09-2026", "Subsidi", "NPK Phonska", "Samarinda Ulu", "40", "Tani Makmur"},
                {"TRX-0004", "02-09-2026", "Subsidi", "Urea Subsidi", "Samarinda Ulu", "100", "Tani Makmur"}};
    }

    public static Object[][] laporan() {
        return penyaluran();
    }

    /** Panduan umum pupuk per tanaman: tanaman, pupuk utama, pelengkap, catatan. GuiController boleh mengganti dengan data nyata. */
    public static Object[][] rekomendasi() {
        return new Object[][]{
                {"Padi", "Urea", "NPK Phonska", "Tanah masam: tambahkan Dolomit. ZA bila kekurangan belerang."},
                {"Jagung", "Urea", "NPK Phonska", "Beri Urea bertahap: saat tanam dan saat pertumbuhan daun."},
                {"Kakao", "NPK untuk kakao", "Dolomit", "Dolomit membantu bila tanah terlalu masam."},
                {"Cabai", "NPK", "ZA", "Perlu kalium cukup saat pembuahan."},
                {"Sayuran daun", "Urea", "NPK", "Dosis kecil dan sering agar daun tidak hangus."},
                {"Kedelai", "NPK Phonska", "Dolomit", "Kebutuhan nitrogen rendah; fokus fosfor dan kalium."}};
    }

    // ---- identitas contoh pengguna (backend: ganti dengan data akun yang sedang masuk) ----
    public static final String NAMA_PENYALUR = "Tani Makmur";
    public static final String NAMA_PETANI = "Budi Santoso";
    public static final String NAMA_PENGELOLA = "Pengelola Root";

    public static String[][] profilPengelola() {
        return new String[][]{{"Nama", NAMA_PENGELOLA}, {"Peran", "Pengelola"}, {"Jabatan", "Administrator"},
            {"NIP", "198501012010011001"}, {"No. telepon", "081200000001"}, {"Email", "pengelola@agrova.id"}};
    }

    public static String[][] profilPenyalur() {
        return new String[][]{{"Nama kios", NAMA_PENYALUR}, {"Peran", "Penyalur"}, {"No. izin usaha", "001/KIOS/2026"},
            {"Kecamatan layanan", "Samarinda Ulu"}, {"No. telepon", "081200000002"}, {"Email", "penyalur.ulu@agrova.id"}};
    }

    public static String[][] profilPetani() {
        return new String[][]{{"Nama", NAMA_PETANI}, {"Peran", "Petani"}, {"NIK", "6472010101900001"},
            {"Kecamatan", "Samarinda Ulu"}, {"Luas lahan (ha)", "1,50"}, {"Email", "petani1@agrova.id"}, {"Terdaftar", "01-10-2026"}};
    }

    /** Stok kios: Produk, Kategori, Diterima (kg), Terjual (kg), Dipesan (kg), Sisa tersedia (kg). */
    public static Object[][] stokSisa() {
        return new Object[][]{
                {"Urea Subsidi", "Subsidi", "5.000", "350", "50", "4.600"},
                {"NPK Phonska", "Subsidi", "3.000", "220", "40", "2.740"},
                {"Pupuk Organik Subsidi", "Subsidi", "2.000", "300", "0", "1.700"},
                {"Urea Non Subsidi", "Nonsubsidi", "2.000", "100", "0", "1.900"}};
    }

    /** Harga per kg (Rp) untuk nota; HET untuk subsidi. */
    public static long hargaPerKg(String produk) {
        String p = produk == null ? "" : produk.toLowerCase();
        if (p.contains("non")) return 6000;
        if (p.contains("organik")) return 800;
        if (p.contains("npk")) return 2300;
        return 2250;
    }
}
