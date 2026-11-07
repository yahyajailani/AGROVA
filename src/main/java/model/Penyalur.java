package model;

import java.util.Map;

//Data penyalur
public class Penyalur extends User {
    private String nomorIzinUsaha;
    private String namaKios;
    private int idKios;
    private final String namaKecamatan;

    public Penyalur(int id, String nama, String email, String noHp,
                    String nomorIzinUsaha, String namaKios, int idKios, String namaKecamatan) {
        super(id, nama, email, noHp);
        setNomorIzinUsaha(nomorIzinUsaha);
        setNamaKios(namaKios);
        this.idKios = idKios;
        this.namaKecamatan = namaKecamatan;
    }

    public String getNomorIzinUsaha() { return nomorIzinUsaha; }

    public final void setNomorIzinUsaha(String v) {
        if (v == null || v.isBlank() || v.length() > 50) {
            throw new BusinessException("Nomor izin usaha wajib diisi (maksimal 50 karakter).");
        }
        this.nomorIzinUsaha = v.trim();
    }

    public String getNamaKios() { return namaKios; }

    public final void setNamaKios(String v) {
        if (v == null || v.isBlank() || v.length() > 100) {
            throw new BusinessException("Nama kios wajib diisi (maksimal 100 karakter).");
        }
        this.namaKios = v.trim();
    }

    public int getIdKios() { return idKios; }
    public void setIdKios(int idKios) { this.idKios = idKios; }
    public String getNamaKecamatan() { return namaKecamatan; }

    @Override
    public Role getPeran() {
        return Role.PENYALUR;
    }

    @Override
    public Map<String, Object> getInfoProfil() {
        Map<String, Object> m = super.getInfoProfil();
        m.put("nama_kios", namaKios);
        m.put("nomor_izin_usaha", nomorIzinUsaha);
        m.put("kecamatan", namaKecamatan);
        return m;
    }
}
