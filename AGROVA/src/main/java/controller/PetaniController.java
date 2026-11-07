package controller;

import config.Koneksi;
import model.Petani;
import model.Pupuk;
import model.KlasifikasiPetani;
import model.dao.PupukDao;
import view.PetaniView;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//Menu petani
public class PetaniController extends RoleController {
    private final PetaniView view = new PetaniView();
    private final PupukDao pupukDao = new PupukDao();
    private final Petani petani;

    public PetaniController(Petani petani) {
        super(petani);
        this.petani = petani;
    }

    @Override
    public void jalankan() {
        while (true) {
            int c = view.menu(petani);
            if (c == 0) {
                if (view.konfirmasiKeluar()) {
                    return;
                }
                continue;
            }
            view.safe(() -> aksi(c));
        }
    }

    private void aksi(int c) throws SQLException {
        switch (c) {
            case 1 -> view.beranda(petani);
            case 2 -> lihatProduk();
            case 3 -> menuTerimaPupuk();
            case 4 -> view.daftar("Riwayat Penerimaan Pupuk di " + petani.getNamaKios(),
                    laporan.rincian("p.kios_id_kios = ? AND p.status_kirim = 'Selesai'", petani.getIdKios()));
            case 5 -> cekHak();
            case 6 -> view.daftar("Status Penyaluran ke " + petani.getNamaKios(),
                    laporan.penyaluran("p.kios_id_kios = ?", petani.getIdKios()));
            default -> view.pesan("Pilihan Tidak Valid!");
        }
    }

    private void lihatProduk() throws SQLException {
        view.daftar("Produk Pupuk", laporan.produk());
        if (view.tanyaPanduan()) {
            view.daftar("Panduan Penggunaan Dosis Pupuk", laporan.panduanPupuk());
        }
    }

    private void menuTerimaPupuk() {
        while (true) {
            int c = view.menuTerimaPupuk();
            if (c == 0) {
                return;
            }
            view.safe(() -> terima(c == 1 ? Pupuk.SUBSIDI : Pupuk.NONSUBSIDI));
        }
    }
    
    private void terima(String kategori) throws SQLException {
    
        //Validasi NIK
        if (!view.inputNikSaya().equals(petani.getNik())) {
            view.nikTidakValid();
            return;
        }

        //Menentukan golongan berdasarkan luas lahan
        String golonganAktual = KlasifikasiPetani.tentukanGolongan(
            petani.getLuasLahan()
        );

        //Cek hak penerima pupuk subsidi
        if (kategori.equals(Pupuk.SUBSIDI)) {

            if (golonganAktual.equals(KlasifikasiPetani.GOL_A)) {

                view.pesan(
                    "\nMAAF, ANDA TIDAK BERHAK MENERIMA PUPUK SUBSIDI!"
                );

                view.pesan("Nama Petani : " + petani.getNama());

                view.pesan(
                    "Luas Lahan  : " +
                    petani.getLuasLahan() + " hektare"
                );

                view.pesan("Golongan    : " + golonganAktual);

                view.pesan(
                    "Ketentuan   : Luas lahan lebih dari 2 hektare."
                );

                view.pesan(
                    "Silakan memilih pupuk non-subsidi."
                );

                return;
            }
        }

        //Mengambil kuota subsidi
        int kuota = Integer.MAX_VALUE;

        if (kategori.equals(Pupuk.SUBSIDI)) {
            kuota = petani.getKuotaKarung();
            view.sisaKuota(kuota);
        }

        //Mengambil stok pupuk dari kios
        List<Map<String, Object>> stok =
            laporan.stokTersedia(petani.getIdKios(), kategori);

        if (stok.isEmpty()) {
            view.belumAdaStok(kategori);
            return;
        }

        //Menampilkan daftar pupuk
        view.showTable(
            "Pupuk " + kategori + " tersedia di " +
            petani.getNamaKios(),
            stok
        );

        //Memilih pupuk
        int id = view.inputIdPupuk();

        if (id == 0) {
            return;
        }

        Map<String, Object> pilih = null;

        for (Map<String, Object> r : stok) {
            if (Koneksi.intOf(r, "id") == id) {
                pilih = r;
                break;
            }
        }

        if (pilih == null) {
            view.pupukTidakAda();
            return;
        }

        //Menginput jumlah pembelian
        int jumlah = view.inputJumlah();

        int tersedia = Koneksi.intOf(pilih, "tersedia_karung");

        if (jumlah > tersedia) {
            view.stokTidakMencukupi(tersedia);
            return;
        }

        if (jumlah > kuota) {
            view.kuotaTidakMencukupi(kuota);
            return;
        }

        //Mengonfirmasi penerimaan
        if (!view.konfirmasiTerima(
            Koneksi.strOf(pilih, "nama_pupuk"),jumlah,kategori)
                ) 
        {
        return;
        }

        //Mengurangi stok pupuk
        if (!pupukDao.kurangiStok(id,jumlah * Pupuk.BERAT_KARUNG_KG)
                ) 
        {
            view.stokTidakMencukupi(tersedia);
            return;
        }

        //Menampilkan hasil
        view.pupukDiterima(jumlah);

        if (kategori.equals(Pupuk.SUBSIDI)) {
            view.kuotaSetelahDikurangi(kuota - jumlah);
        }
    }
    
    private void cekHak() throws SQLException {

        //Validasi NIK
        if (!view.inputNikSaya().equals(petani.getNik())) {
            view.nikTidakValid();
            return;
        }

        //Menghitung golongan berdasarkan luas lahan
        String golonganAktual = KlasifikasiPetani.tentukanGolongan(
            petani.getLuasLahan()
        );

        //Menampilkan profil petani
        view.showKeyValue("Data petani",petani.getInfoProfil());

        //Penentuan golongan A tidak berhak mendapatkan subsidi
        if (golonganAktual.equals(KlasifikasiPetani.GOL_A)) {

            Map<String, Object> hak = new LinkedHashMap<>();

            hak.put("golongan", golonganAktual);
            hak.put("luas_lahan_ha", petani.getLuasLahan());
            hak.put("status_subsidi", "TIDAK BERHAK");
            hak.put("kuota_subsidi_karung", 0);

            view.infoHak(hak);

            view.pesan(
                "\nANDA TIDAK BERHAK MENERIMA PUPUK SUBSIDI.");

            view.pesan(
                "Luas lahan Anda lebih dari 2 hektare.");

            view.pesan(
                "Silakan memilih pupuk non-subsidi.");
            
            return;
        }

        //Penentuan golongan B dan C berhak mendapatkan subsidi
        Map<String, Object> hak = new LinkedHashMap<>();

        hak.put("golongan", golonganAktual);
        hak.put("luas_lahan_ha", petani.getLuasLahan() + " Hektare ");
        hak.put("status_subsidi", "BERHAK");
        hak.put("kuota_subsidi_karung", petani.getKuotaKarung() + " karung ");

        view.infoHak(hak);

        //Menampilkan informasi subsidi yang sudah diterima kios
        view.showTable(
            "Subsidi yang sudah diterima kios Anda (kuota dan harga HET)",
            laporan.subsidi(
                "p.kios_id_kios = ? AND p.status_kirim = 'Selesai'",
                petani.getIdKios()
            )
        );
    }
}
