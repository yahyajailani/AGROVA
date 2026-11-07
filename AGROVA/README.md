
## Seleksi penerima subsidi
- Petani Golongan A (lahan lebih dari 2 ha) tidak berhak pupuk subsidi.
- Petani: halaman *Pesan* dan *Produk* hanya menampilkan pupuk nonsubsidi bila tidak berhak.
- Penyalur: di halaman *Salurkan*, setelah NIK dicek (tombol Cek), pilihan pupuk menyesuaikan hak petani.
- Backend tetap menolak transaksi subsidi untuk petani yang tidak berhak (`GuiController.periksaTransaksi`).

## Revisi 7 November
- Halaman Salurkan: nama petani tampil otomatis setelah NIK 16 digit diisi.
- Kuota subsidi menurut kolom `petani.golongan`: Gol C 300 kg, Gol B 150 kg (total semua pupuk subsidi), Gol A tidak berhak (hanya nonsubsidi).
- Ikon mata sandi berada di dalam kolom sandi (login dan daftar).
- Cetak nota dipindah ke menu penyalur (Riwayat); Laporan pengelola tidak lagi membuka nota.
- Menu atas (Beranda, Tentang Kami, Rekomendasi) hanya teks, tanpa ikon dan penanda kuning.
- Tentang Kami berisi profil Perusahaan Root dan fokus SDGs; hero Beranda bergaya baru.

## Backend terbaru
Backend (config, controller, model, model.dao, view konsol) memakai berkas `PerusahaanRoot_2` terbaru. Dua berkas sengaja dipertahankan dari versi gabungan:
- `main/PerusahaanRoot.java`: satu-satunya main, membuka GUI.
- `config/Koneksi.java`: pengaturan database lewat environment variable (AGROVA_DB_URL/USER/PASS) dan sambung ulang otomatis bila koneksi mati.
Kuota subsidi di GUI memakai golongan (C 300 kg, B 150 kg, A tidak berhak); menu konsol masih memakai aturan luas lahan bawaan backend.

## Katalog bergambar
Katalog pupuk subsidi di Beranda memakai gambar karung dari `src/main/resources/images/pupuk/` (13 gambar, termasuk 7 pupuk nonsubsidi yang belum ditampilkan di halaman mana pun).

## Tampilan Design = tampilan saat dijalankan
Hero Beranda, katalog bergambar, halaman Tentang Kami, tombol *Cetak nota* (Riwayat penyalur), dan tombol *Simpan PDF* (dialog nota) kini ada di berkas `.form`/`initComponents`, sehingga tab Design NetBeans sama dengan hasil saat program dijalankan. Gambar hero memakai `images/beranda_hero_gelap.png` (gradasi gelap sudah menyatu di gambar). Gambar pupuk kecil ada di `images/pupuk/kecil/`.
Yang masih diatur lewat kode saat dijalankan: gaya warna/font oleh `Styler`, ikon mata di dalam kolom sandi (login dan daftar), serta menu atas tanpa ikon dan penanda kuning.

## Revisi 7 November (lanjutan)
- Tentang Kami: tiap bagian punya warna sendiri, hanya SDG 12 dan SDG 8 (dengan gambar SDG), foto pabrik di sisi kanan "Siapa kami".
- `UserDao.daftar`: bila id user tidak dikembalikan driver, id dicari lewat email; kios kosong disimpan NULL, bukan 0.
- Jika error "Cannot add or update a child row" masih muncul, pastikan aplikasi memakai database yang berisi data kios Anda (default `agrova`; ubah lewat `AGROVA_DB_URL` atau `config/Koneksi.java`).
