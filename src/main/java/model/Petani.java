package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

//Data petani
public class Petani extends User {
    public static final int KARUNG_GOL_A = 5;
    public static final int KARUNG_GOL_B = 4;
    public static final int KARUNG_GOL_C = 3;

    private String nik;
    private BigDecimal luasLahan;
    private String golongan;
    private int idKios;
    private final String namaKios;
    private final String namaKecamatan;

    public Petani(int id, String nama, String email, String noHp, String nik, BigDecimal luasLahan,
                  String golongan, int idKios, String namaKios, String namaKecamatan) {
        super(id, nama, email, noHp);
        setNik(nik);
        setLuasLahan(luasLahan);
        setGolongan(golongan);
        this.idKios = idKios;
        this.namaKios = namaKios;
        this.namaKecamatan = namaKecamatan;
    }

    public String getNik() { return nik; }

    public final void setNik(String nik) {
        if (!Security.isDigits(nik, 16, 16)) {
            throw new BusinessException("NIK harus 16 digit angka.");
        }
        this.nik = nik;
    }

    public BigDecimal getLuasLahan() { return luasLahan; }

    public final void setLuasLahan(BigDecimal v) {
        if (v == null || v.compareTo(new BigDecimal("0.01")) < 0 || v.compareTo(new BigDecimal("99.99")) > 0) {
            throw new BusinessException("Luas lahan harus antara 0.01 dan 99.99 hektar.");
        }
        this.luasLahan = v;
    }

    public String getGolongan() { return golongan; }

    public final void setGolongan(String v) {
        if (v == null || v.isBlank() || v.length() > 10) {
            throw new BusinessException("Golongan wajib diisi (maksimal 10 karakter).");
        }
        this.golongan = v.trim();
    }

    public int getIdKios() { return idKios; }
    public void setIdKios(int idKios) { this.idKios = idKios; }
    public String getNamaKios() { return namaKios; }
    public String getNamaKecamatan() { return namaKecamatan; }

    /* Penghitungan jumlah jatah maksimal(kuota) karung pupuk subsidi
    luas lahan petani(ha) * ketetapan jumlah karung per ha berdasarkan golongan petani
    */
    public int getKuotaKarung() {
        return hitungKuota(luasLahan, golongan);
    }

    public static int hitungKuota(BigDecimal luasLahan, String golongan) {
    if (golongan.equalsIgnoreCase(KlasifikasiPetani.GOL_A)) {
        return 0;  
    }
    int perHektar;
    if (golongan.equalsIgnoreCase("Gol B")) {
        perHektar = KARUNG_GOL_B;
    } else {
        perHektar = KARUNG_GOL_C;
    }
    return luasLahan.multiply(BigDecimal.valueOf(perHektar)).setScale(0, RoundingMode.CEILING).intValue();
}

    @Override
    public Role getPeran() {
        return Role.PETANI;
    }

    @Override
    public Map<String, Object> getInfoProfil() {
        Map<String, Object> m = super.getInfoProfil();
        m.put("nik", nik);
        m.put("luas_lahan", luasLahan + " Hektare ");
        m.put("golongan", golongan);
        m.put("kuota_subsidi_karung", getKuotaKarung() + " karung ");
        m.put("kios", namaKios);
        m.put("kecamatan", namaKecamatan);
        return m;
    }
}
