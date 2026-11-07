package model;

import java.math.BigDecimal;

//Data Subsidi
public class Subsidi extends KategoriPenyaluran {
    private final int kuotaSubsidi;
    private final BigDecimal hargaNormal;
    private final BigDecimal hargaHet;
    private final int kuotaAlokasi;

    public Subsidi(int kuotaSubsidi, BigDecimal hargaNormal, BigDecimal hargaHet, int kuotaAlokasi) {
        if (kuotaSubsidi < 1 || kuotaAlokasi < 0) {
            throw new BusinessException("Kuota subsidi minimal 1 dan kuota alokasi tidak boleh negatif.");
        }
        if (hargaNormal.signum() < 0 || hargaHet.signum() < 0) {
            throw new BusinessException("Harga tidak boleh negatif.");
        }
        this.kuotaSubsidi = kuotaSubsidi;
        this.hargaNormal = hargaNormal;
        this.hargaHet = hargaHet;
        this.kuotaAlokasi = kuotaAlokasi;
    }

    public int getKuotaSubsidi() { return kuotaSubsidi; }

    public BigDecimal getHargaNormal() { return hargaNormal; }

    public BigDecimal getHargaHet() { return hargaHet; }

    public int getKuotaAlokasi() { return kuotaAlokasi; }

    @Override
    public String getNama() {
        return "Subsidi";
    }

    @Override
    public void validasi(int totalKarung) {
        if (totalKarung > kuotaSubsidi) {
            throw new BusinessException("Penyaluran ditolak: Kuota melebihi kuota subsidi ("
                    + totalKarung + " > " + kuotaSubsidi + ")");
        }
    }
}
