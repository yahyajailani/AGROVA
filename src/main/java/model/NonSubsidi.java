package model;

//Data non subsidi
public class NonSubsidi extends KategoriPenyaluran {
    private final int jumlahKarung;
    private final int noPo;

    public NonSubsidi(int jumlahKarung, int noPo) {
        if (jumlahKarung < 1) {
            throw new BusinessException("Jumlah karung non-subsidi minimal 1.");
        }
        if (noPo < 1) {
            throw new BusinessException("No PO pupuk harus berupa angka lebih dari 0.");
        }
        this.jumlahKarung = jumlahKarung;
        this.noPo = noPo;
    }

    public int getJumlahKarung() { return jumlahKarung; }
    public int getNoPo() { return noPo; }

    @Override
    public String getNama() {
        return "Non-Subsidi";
    }

    @Override
    public void validasi(int totalKarung) {
        if (totalKarung < 1) {
            throw new BusinessException("Penyaluran non-subsidi minimal 1 karung.");
        }
    }
}
