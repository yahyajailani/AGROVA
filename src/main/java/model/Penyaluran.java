package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Data dan proses penyaluran pupuk
public class Penyaluran {
    public static final String PROSES = "Proses";
    public static final String SELESAI = "Selesai";
    public static final List<String> STATUS = List.of(PROSES, SELESAI);

    private int id;
    private String statusKirim;
    private LocalDate tanggalKirim;
    private LocalDate tanggalTerima;
    private int idKios;
    private final int idPengelola;
    private int jumlahKarung;
    private int totalBeratKg;
    private final List<Pupuk> pupuk = new ArrayList<>();

    public Penyaluran(int id, String statusKirim, LocalDate tanggalKirim, LocalDate tanggalTerima,
                      int idKios, int idPengelola) {
        this.id = id;
        setStatusKirim(statusKirim);
        this.tanggalKirim = tanggalKirim;
        this.tanggalTerima = tanggalTerima;
        this.idKios = idKios;
        this.idPengelola = idPengelola;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getStatusKirim() { return statusKirim; }

    public final void setStatusKirim(String s) {
        if (!STATUS.contains(s)) {
            throw new BusinessException("Status kirim harus salah satu dari " + STATUS);
        }
        this.statusKirim = s;
    }

    public LocalDate getTanggalKirim() { return tanggalKirim; }
    public void setTanggalKirim(LocalDate t) { this.tanggalKirim = t; }
    public LocalDate getTanggalTerima() { return tanggalTerima; }
    public void setTanggalTerima(LocalDate t) { this.tanggalTerima = t; }
    public int getIdKios() { return idKios; }
    public void setIdKios(int idKios) { this.idKios = idKios; }
    public int getIdPengelola() { return idPengelola; }
    public int getJumlahKarung() { return jumlahKarung; }
    public void setJumlahKarung(int v) { this.jumlahKarung = v; }
    public int getTotalBeratKg() { return totalBeratKg; }
    public void setTotalBeratKg(int v) { this.totalBeratKg = v; }
    public List<Pupuk> getPupuk() { return Collections.unmodifiableList(pupuk); }

    //Menambah pupuk
    public void tambahPupuk(Pupuk p) {
        pupuk.add(p);
    }

    public int getTotalKarung() {
        return pupuk.stream().mapToInt(Pupuk::getKarung).sum();
    }

    //Menghitung jumlah dan berat karung
    public void hitungTotal() {
        jumlahKarung = pupuk.stream().mapToInt(Pupuk::getKarung).sum();
        totalBeratKg = pupuk.stream().mapToInt(Pupuk::getStok).sum();
    }

    //Validasi Tanggal
    public void validasiTanggal() {
        if (tanggalKirim == null) {
            throw new BusinessException("Tanggal kirim wajib diisi.");
        }
        if (SELESAI.equals(statusKirim) && tanggalTerima == null) {
            throw new BusinessException("Status Selesai wajib punya tanggal terima.");
        }
        if (tanggalTerima != null && tanggalTerima.isBefore(tanggalKirim)) {
            throw new BusinessException("Data tidak valid: tanggal terima sebelum tanggal kirim");
        }
    }

    //Validasi sebelum simpan
    public void validasiSebelumSimpan() {
        validasiTanggal();
        if (pupuk.isEmpty()) {
            throw new BusinessException("Penyaluran minimal berisi satu pupuk.");
        }
        for (Pupuk p : pupuk) {
            if (p.getDetail() == null) {
                throw new BusinessException("Kategori pupuk " + p.getNama() + " belum dilengkapi.");
            }
            p.getDetail().validasi(p.getKarung());
        }
    }
}
