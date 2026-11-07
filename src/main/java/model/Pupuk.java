package model;

//Data pupuk
public class Pupuk {
    public static final String SUBSIDI = "Subsidi";
    public static final String NONSUBSIDI = "Nonsubsidi";
    
    /*Satuan jumlah karung = total berat(kg)
    dik; 50 karung = 2500 Kg -> berat 1 karung = 2500 Kg/50 karung = 50 Kg per karung
    */
    public static final int BERAT_KARUNG_KG = 50;

    private int id;
    private String nama;
    private String kategori;
    private String satuan;
    private int stok;
    private String deskripsi;
    private int idPenyaluran;
    private KategoriPenyaluran detail;

    public Pupuk(int id, String nama, String kategori, String satuan, int stok, String deskripsi, int idPenyaluran) {
        this.id = id;
        setNama(nama);
        setKategori(kategori);
        this.satuan = satuan;
        setStok(stok);
        this.deskripsi = deskripsi;
        this.idPenyaluran = idPenyaluran;
    }

    //Stok(Kg) = jumlah karung * 50 -> 1 karung = 50 Kg
    public static Pupuk baru(String nama, String kategori, int karung, String deskripsi, KategoriPenyaluran detail) {
        if (karung < 1) {
            throw new BusinessException("Jumlah karung harus lebih dari 0.");
        }
        Pupuk p = new Pupuk(0, nama, kategori, "Kg", karung * BERAT_KARUNG_KG, deskripsi, 0);
        p.detail = detail;
        return p;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNama() { return nama; }

    public final void setNama(String nama) {
        if (nama == null || nama.isBlank() || nama.length() > 150) {
            throw new BusinessException("Nama pupuk wajib diisi (maksimal 150 karakter).");
        }
        this.nama = nama.trim();
    }

    public String getKategori() { return kategori; }

    public final void setKategori(String kategori) {
        if (!SUBSIDI.equals(kategori) && !NONSUBSIDI.equals(kategori)) {
            throw new BusinessException("Kategori pupuk harus " + SUBSIDI + " atau " + NONSUBSIDI + ".");
        }
        this.kategori = kategori;
    }

    public String getSatuan() { return satuan; }
    public void setSatuan(String satuan) { this.satuan = satuan; }
    public int getStok() { return stok; }

    public final void setStok(int stok) {
        if (stok < 0) {
            throw new BusinessException("Stok pupuk tidak boleh negatif.");
        }
        this.stok = stok;
    }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    public int getIdPenyaluran() { return idPenyaluran; }
    public void setIdPenyaluran(int idPenyaluran) { this.idPenyaluran = idPenyaluran; }
    public KategoriPenyaluran getDetail() { return detail; }
    public void setDetail(KategoriPenyaluran detail) { this.detail = detail; }

    //Jumlah karung = 2500 Kg/50 Kg = 50 karung -> total berat(stok Kg)/berat per karung(50 Kg)
    public int getKarung() {
        return stok / BERAT_KARUNG_KG;
    }

    public boolean stokCukup(int kebutuhanKg) {
        return kebutuhanKg <= stok;
    }

    @Override
    public String toString() {
        return nama + " (" + kategori + ", " + getKarung() + " karung / " + stok + " " + satuan + ")";
    }
}
