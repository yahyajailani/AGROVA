package model;


//Abstract kategori penyaluran
public abstract class KategoriPenyaluran {
    public abstract String getNama();

    /** @throws BusinessException kalau total karung penyaluran melanggar aturan kategori ini. */
    public abstract void validasi(int totalKarung);
}
