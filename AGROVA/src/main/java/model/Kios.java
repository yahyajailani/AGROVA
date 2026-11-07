package model;

//Data kios
public class Kios {
    private int id;
    private String namaKios;
    private String namaKecamatan;

    public Kios(int id, String namaKios, String namaKecamatan) {
        this.id = id;
        this.namaKios = namaKios;
        this.namaKecamatan = namaKecamatan;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNamaKios() { return namaKios; }
    public void setNamaKios(String namaKios) { this.namaKios = namaKios; }
    public String getNamaKecamatan() { return namaKecamatan; }
    public void setNamaKecamatan(String namaKecamatan) { this.namaKecamatan = namaKecamatan; }

    @Override
    public String toString() {
        return id + ". " + namaKios + " (Kec. " + namaKecamatan + ")";
    }
}
