package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Data kios
@Entity
@Table(name = "kios")
public class Kios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kios")
    private int id;

    @Column(name = "nama_kios", nullable = false, length = 100)
    private String namaKios;

    @Column(name = "nama_kecamatan", nullable = false, length = 100)
    private String namaKecamatan;

    public Kios() {
    }

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