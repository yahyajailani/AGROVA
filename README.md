<div align="center">

# ── ⟡ ˙🌱 ̟  AGROVA  ˙🌱 ̟  ⟡ ──

*Sistem Informasi Pengelolaan Distribusi Pupuk Subsidi dan Nonsubsidi*
*Perusahaan Root · Samarinda*

<img width="1047" height="496" alt="WhatsApp Image 2026-11-07 at 15 49 22" src="https://github.com/user-attachments/assets/2e5f0b5d-982c-470c-8e7b-f9641789a1be" />

</div>

---

<div align="justify">

## ── ⟡ Deskripsi Singkat

**Perusahaan Root** menyalurkan pupuk kimia dari gudang pusat ke penyalur (kios) di 10 kecamatan Kota Samarinda, Kalimantan Timur, lalu ke petani. Pupuk terbagi dua golongan: **subsidi**, yang harganya dibantu pemerintah dan dijatah per petani, dan **nonsubsidi**, yang harganya ditanggung penuh pembeli.

Di lapangan, pencatatan masih manual lewat surat dan kertas. Cara ini rawan bukti pengiriman palsu, menyulitkan pemantauan status pengiriman, dan membuat pupuk berpotensi disalurkan melebihi jatah. Pengelola dan penyalur juga sulit mengetahui sisa jatah dan pergerakan stok tiap kecamatan secara cepat.

Maka dibuatlah sebuah aplikasi desktop (Java Swing + MySQL) bernama **AGROVA** untuk mendigitalkan distribusi pupuk subsidi dan nonsubsidi pada Perusahaan Root, mulai dari gudang pusat sampai ke tangan petani, dengan jatah yang dibatasi otomatis, penyaluran yang tercatat berdasarkan NIK, dan bukti penyaluran yang bisa dicetak. Di dalamnya:

* **Pengelola (Root)** mengatur penyaluran dari gudang ke kecamatan tertentu, menetapkan kuota, dan memantau laporan.
* **Penyalur (kios)** mengonfirmasi kiriman yang masuk, memproses pesanan petani, dan menyalurkan pupuk berdasarkan NIK.
* **Petani** memesan pupuk sesuai jatahnya, memantau status pesanan, dan melihat riwayat penerimaan.

Aturan jatah dijalankan otomatis oleh sistem. Petani digolongkan dari luas lahannya:

| Golongan | Luas lahan | Hak subsidi |
|:---:|:---:|---|
| Gol A | lebih dari 2 ha | Tidak berhak, hanya pupuk nonsubsidi |
| Gol B | 1 – 2 ha | 150 kg per musim tanam (semua pupuk subsidi digabung) |
| Gol C | kurang dari 1 ha | 300 kg per musim tanam (semua pupuk subsidi digabung) |

AGROVA berkaitan dengan **SDGs 12** (Konsumsi dan Produksi yang Bertanggung Jawab) dan **SDGs 8** (Pekerjaan Layak dan Pertumbuhan Ekonomi).

</div>

---

## ── ⟡ Fitur Utama Program

### ˙🌱 ̟  Pengunjung (sebelum melakukan login atau daftar)
| Fitur | Penjelasan |
|---|---|
| Beranda | Halaman utama dengan katalog pupuk subsidi bergambar. |
| Tentang Kami | Profil Perusahaan Root, cara kerja distribusi, kuota per golongan, dan fokus SDGs. |
| Rekomendasi | Saran jenis pupuk berdasarkan tanaman, serta pupuk subsidi dengan alokasi terbanyak. |
| Login | Masuk dengan email dan kata sandi. Sistem mengarahkan pengguna sesuai perannya. |
| Daftar akun | Pendaftaran **petani** (NIK, luas lahan, kecamatan) atau **penyalur** (nama kios, izin usaha, kecamatan). Golongan petani ditentukan otomatis dari luas lahan. |

### ˙🌱 ̟  Pengelola
| Fitur | Penjelasan |
|---|---|
| Dashboard | Ringkasan stok gudang, penyaluran hari ini dan bulan ini, jumlah petani, petani penerima subsidi, serta grafik sebaran per kecamatan. |
| Penyaluran | Mengirim pupuk dari gudang ke kecamatan tujuan. Data dapat dicari, diubah, dan dihapus. |
| Pupuk Subsidi | Menetapkan kuota per kecamatan, produk, dan tahun. Penyaluran tidak boleh melebihi kuota. Tersedia pemantauan terpakai, dikirim, dipesan, dan sisa kuota. |
| Lihat Data | Data petani, data penyalur, dan ketersediaan pupuk (hanya baca). |
| Laporan | Rekap penyaluran dengan filter tanggal, produk, dan kecamatan. |
| Notifikasi dan Profil | Pemberitahuan terbaru dan data akun. |

### ˙🌱 ̟  Penyalur
| Fitur | Penjelasan |
|---|---|
| Beranda | Ringkasan stok kios, pengiriman masuk, pesanan petani, dan jumlah tersalur bulan ini. |
| Verifikasi | Menerima kiriman dari gudang, serta menyetujui atau menolak pesanan petani. |
| Salurkan | Menyerahkan pupuk langsung ke petani. Cukup isi NIK 16 digit, nama petani tampil otomatis, lalu sistem mengecek kuota dan pilihan pupuk yang boleh diberikan. |
| Stok | Stok kios: jumlah diterima, terjual, dipesan, dan sisa. |
| Riwayat | Riwayat transaksi kios. Bukti penyaluran dapat dicetak dan disimpan sebagai PDF. |

### ˙🌱 ̟  Petani
| Fitur | Penjelasan |
|---|---|
| Beranda | Kuota, sisa kuota, dan pesanan aktif. |
| Produk | Pupuk yang tersedia di kios kecamatan petani. |
| Pesan | Memesan pupuk sesuai kuota. Petani Gol A hanya melihat pupuk nonsubsidi. |
| Status Pesanan | Memantau pesanan dan membatalkan pesanan yang masih berstatus Menunggu. |
| Riwayat | Daftar pupuk yang sudah diterima. |

---

## ── ⟡ Tech Stack

| Kategori | Teknologi | Keterangan |
|---|---|---|
| Bahasa | **Java 17** | Logika aplikasi dan penerapan OOP. |
| Riset dan Penelusuran | **Google Chrome & Google Scholar** | Penelusuran referensi literatur, jurnal, dan pencarian solusi teknis. |
| Pemodelan dan Diagram | **Draw.io** | Pembuatan flowchart dan Use Case Diagram |
| Perancangan Database | **Data Modeler** | Perancangan struktur dan relasi basis data (Entity Relationship Diagram / ERD). |
| Database | **MySQL / MariaDB** | Menyimpan data pengguna, kios, pupuk, penyaluran, dan transaksi. |
| Dokumentasi | **Microsoft Word** | Penyusunan draf laporan dan dokumentasi proyek. |
| Akses data | **JDBC & MySQL Connector/J 8.3.0** | Query lewat `PreparedStatement` di dalam class DAO. |
| Desain UI/UX | **Figma** | Perancangan desain GUI atau UI/UX aplikasi. |
| GUI | **Java Swing** | Antarmuka desktop, dirancang dengan NetBeans GUI Builder (berkas `.form`). |
| ORM | **Hibernate ORM 7.4.5.Final** (JPA) | Dikonfigurasi lewat `persistence.xml` dan diuji pada `TestKoneksiOrm`. |
| Arsitektur | **MVC + DAO** | Memisahkan tampilan, alur program, model data, dan akses database. |
| Build tool | **Apache Maven** | Dependency dan build, dengan `maven-shade-plugin` untuk JAR siap jalan. |
| IDE | **Apache NetBeans** | Pengembangan dan perancangan GUI. |
| Version control | **Git** dan **GitHub** | Pengelolaan versi dan kolaborasi tim. |
| Keamanan | **SHA-256** | Kata sandi disimpan dalam bentuk hash (`model.Security`). |
| Presentasi | **Canva** | Pembuatan presentasi (slide deck) proyek. |

---

## ── ⟡ Perancangan Sistem

### ˙🌱 ̟  Flowchart
Berikut ini merupakan beberapa menu flowchart atau diagram alur yang dibuat dalam perancangan AGROVA.

<details>
<summary>1. Flowchart Menu Utama</summary>
<img width="5007" height="2873" alt="Capstone kelompok 18 NEW-Menu Utama" src="https://github.com/user-attachments/assets/b114165a-cb1e-4298-b08b-4afbdbcd93e8" />
</details>

<details>
<summary>2. Flowchart Menu Pengelola</summary>
<img width="2192" height="1979" alt="Capstone kelompok 18 NEW-Menu Pengelola" src="https://github.com/user-attachments/assets/5941343c-35e5-45b5-bbfa-ce2b695861d5" />
</details>

<details>
<summary>3. Flowchart Menu Penyaluran</summary>
<img width="3052" height="1856" alt="Capstone kelompok 18 NEW-Menu Penyaluran" src="https://github.com/user-attachments/assets/bc61043e-0f73-4084-9041-4a8e3840eb3d" />
</details>

<details>
<summary>4. Flowchart Menu Subsidi</summary>
<img width="3689" height="2073" alt="Capstone kelompok 18 NEW-Menu Subsidi" src="https://github.com/user-attachments/assets/efefd597-57ad-4aa9-9417-d9513bc11c42" />
</details>

<details>
<summary>5. Flowchart Menu Nonsubsidi</summary>
<img width="2743" height="863" alt="Capstone kelompok 18 NEW-Menu Nonsubsidi" src="https://github.com/user-attachments/assets/6166455b-f888-42f0-b1dd-30d51cfb8247" />
</details>

<details>
<summary>6. Flowchart Menu Penyalur</summary>
<img width="2630" height="1609" alt="Capstone kelompok 18 NEW-Menu Penyalur" src="https://github.com/user-attachments/assets/28696773-84cd-474d-bd49-be56af3119f7" />
</details>

<details>
<summary>7. Flowchart Menu Petani: Subsidi</summary>
<img width="3287" height="2381" alt="Capstone kelompok 18 NEW-Menu Petani - Subsidi" src="https://github.com/user-attachments/assets/a5ed3611-0d06-4bf3-9025-0d93fe327fb3" />
</details>

<details>
<summary>8. Flowchart Menu Petani: Nonsubsidi</summary>
<img width="1566" height="1042" alt="Capstone kelompok 18 NEW-Menu Petani - Nonsubsidi" src="https://github.com/user-attachments/assets/e11e62ed-d557-4d71-a9f1-cdba07260293" />
</details>

### ˙🌱 ̟  Use Case Diagram
Sistem AGROVA memiliki tiga aktor utama di dalamnya yaitu **Pengelola**, **Penyalur**, dan **Petani**.

<details>
<summary>Use Case Diagram AGROVA</summary>
<img width="1442" height="1382" alt="Capstone kelompok 18 NEW-Use Case" src="https://github.com/user-attachments/assets/d6596696-131b-476b-bacb-0ce63b877623" />
</details>

### ˙🌱 ̟  ERD
Entitas `pupuk` dan `user` dimodelkan dengan pola *supertype–subtype*. Entitas`pupuk` dibagi menjadi `subsidi` dan `non_subsidi`, sedangkan `user` dibagi menjadi `pengelola`, `penyalur`, dan `petani`.

<details>
<summary>ERD Logical</summary>
Berikut ini ialah gambar ERD Logical yang telah dibuat dalam pembuatan AGROVA.
<img width="976" height="769" alt="ERD Logical Model" src="https://github.com/user-attachments/assets/36803989-7a08-4267-80de-a50ae925ba10" />
</details>

<details>
<summary>ERD Relational</summary>
Berikut ini ialah gambar ERD Relational yang telah dibuat dalam pembuatan AGROVA.
<img width="1041" height="900" alt="ERD Relational Model" src="https://github.com/user-attachments/assets/6a3ba9c9-9a3e-40e7-8d4d-f52ef9efa8f8" />
</details>

---

## ── ⟡ Struktur Folder/Package

Aplikasi menerapkan **MVC** dengan lapisan **DAO** untuk akses database.

```
AGROVA/
├── database/
│   └── perusahaan_root.sql
├── src/main/
│   ├── java/
│   │   ├── config/
│   │   │   ├── DatabaseConfig.java
│   │   │   ├── EntityManagerProvider.java
│   │   │   ├── Koneksi.java
│   │   │   └── TestKoneksiOrm.java
│   │   ├── controller/
│   │   │   ├── AuthController.java
│   │   │   ├── GuiController.java
│   │   │   ├── KelolaController.java
│   │   │   ├── PengelolaController.java
│   │   │   ├── PenyalurController.java
│   │   │   ├── PetaniController.java
│   │   │   ├── PupukController.java
│   │   │   ├── PenyaluranController.java
│   │   │   ├── KiosController.java
│   │   │   └── RoleController.java
│   │   ├── main/
│   │   │   └── Main.java
│   │   ├── model/
│   │   │   ├── User.java
│   │   │   ├── Pengelola.java
│   │   │   ├── Penyalur.java
│   │   │   ├── Petani.java
│   │   │   ├── Pupuk.java
│   │   │   ├── Penyaluran.java
│   │   │   ├── Kios.java
│   │   │   ├── Subsidi.java
│   │   │   ├── NonSubsidi.java
│   │   │   ├── KategoriPenyaluran.java
│   │   │   ├── Role.java
│   │   │   └── Security.java
│   │   ├── dao/
│   │   │   ├── CrudDao.java
│   │   │   ├── UserDao.java
│   │   │   ├── PupukDao.java
│   │   │   ├── PenyaluranDao.java
│   │   │   ├── KiosDao.java
│   │   │   └── LaporanDao.java
│   │   └── view/
│   │       ├── BerandaView.java
│   │       ├── LoginView.java
│   │       ├── DaftarView.java
│   │       ├── PengelolaView.java
│   │       ├── PenyalurView.java
│   │       ├── PetaniView.java
│   │       ├── LaporanView.java
│   │       ├── dialog/
│   │       │   ├── KonfirmasiDialog.java
│   │       │   ├── InputPupukDialog.java
│   │       │   └── DetailPenyaluranDialog.java
│   │       └── util/
│   │           ├── Charts.java
│   │           ├── Dialogs.java
│   │           ├── Nav.java
│   │           ├── Styler.java
│   │           ├── TableKit.java
│   │           ├── Theme.java
│   │           └── Validasi.java
│   └── resources/
│       ├── META-INF/
│       │   └── persistence.xml
│       └── images/
│           ├── logo.png
│           ├── hero.png
│           └── sdgs.png
├── tools/
└── laporan/
    └── RekapPenyaluran.pdf
```

| Package | Peran |
|---|---|
| `config` | Pengaturan koneksi database (JDBC dan JPA) dan class uji koneksi. |
| `model` | Class entitas dan aturan data. Tidak mencetak apa pun ke layar. |
| `model.dao` | Semua query SQL berada di sini. |
| `controller` | Alur program dan aturan bisnis (kuota, hak subsidi, stok). |
| `view` | Tampilan Swing dan input pengguna. |
| `view.util` | Tema, validasi input, tabel, grafik, dan komponen bantu. |

---

## ── ⟡ Penerapan 4 Pilar OOP

### ˙🌱 ̟  Encapsulation
Atribut pada class model dibuat `private` dan hanya bisa diubah lewat getter/setter. Setter sekaligus menjadi tempat validasi, sehingga data yang masuk ke objek selalu sudah benar. Setter yang divalidasi dibuat `final` agar aturannya tidak bisa ditimpa subclass.

`model/User.java`
```java
public abstract class User {
    private int id;
    private String nama;
    private String email;
    private String noHp;

    public final void setEmail(String email) {
        if (!Security.isEmail(email)) {
            throw new BusinessException("Format email tidak valid (maksimal 50 karakter).");
        }
        this.email = email;
    }

    public final void setNoHp(String noHp) {
        if (!Security.isDigits(noHp, 9, 15)) {
            throw new BusinessException("No HP harus 9-15 digit angka.");
        }
        this.noHp = noHp;
    }
    // ...
}
```

### ˙🌱 ̟  Inheritance
`Pengelola`, `Penyalur`, dan `Petani` mewarisi `User`, sehingga atribut dasar akun (id, nama, email, no. HP) cukup ditulis sekali. Tiap subclass menambahkan atribut miliknya sendiri dan memanggil constructor induk dengan `super(...)`.

`model/Pengelola.java`
```java
public class Pengelola extends User {
    private String jabatan;
    private String nip;

    public Pengelola(int id, String nama, String email, String noHp, String jabatan, String nip) {
        super(id, nama, email, noHp);
        this.jabatan = jabatan;
        this.nip = nip;
    }
    // ...
}
```
Pewarisan juga dipakai pada `Subsidi` dan `NonSubsidi` yang mewarisi `KategoriPenyaluran`.

### ˙🌱 ̟  Polymorphism
**Overriding.** `Subsidi` dan `NonSubsidi` sama-sama menimpa `validasi()` dengan aturan yang berbeda. Saat `Penyaluran` divalidasi, program cukup memanggil `getDetail().validasi(...)` dan Java memilih versi yang sesuai dengan jenis objeknya.

`model/Subsidi.java` dan `model/NonSubsidi.java`
```java
// Subsidi
@Override
public void validasi(int totalKarung) {
    if (totalKarung > kuotaSubsidi) {
        throw new BusinessException("Penyaluran ditolak: Kuota melebihi kuota subsidi ("
                + totalKarung + " > " + kuotaSubsidi + ")");
    }
}

// NonSubsidi
@Override
public void validasi(int totalKarung) {
    if (totalKarung < 1) {
        throw new BusinessException("Penyaluran non-subsidi minimal 1 karung.");
    }
}
```
Contoh lain: `getInfoProfil()` pada `User` ditimpa oleh tiap subclass untuk menambahkan data khasnya (jabatan dan NIP untuk pengelola, NIK dan luas lahan untuk petani).

**Overloading.** `UserDao` memiliki dua method `cari` dengan parameter berbeda.

`model/dao/UserDao.java`
```java
public User cari(int id) throws SQLException { /* cari berdasarkan id user */ }

public User cari(String email) throws SQLException { /* cari berdasarkan email */ }
```

### ˙🌱 ̟  Abstraction
- **Abstract class `User`** memaksa setiap subclass menentukan perannya lewat `getPeran()`.
- **Abstract class `KategoriPenyaluran`** menetapkan kerangka kategori pupuk (`getNama()` dan `validasi()`) tanpa isi.
- **Interface `CrudDao<T>`** menjadi kontrak operasi database (`findAll`, `findById`, `insert`, `update`, `delete`) yang diimplementasikan `PupukDao`, `PenyaluranDao`, dan `KiosDao`.
- **Interface `Kelola`** menjadi kontrak untuk controller.

`model/User.java`, `model/KategoriPenyaluran.java`, `model/dao/CrudDao.java`
```java
public abstract Role getPeran();   // User

public abstract class KategoriPenyaluran {
    public abstract String getNama();
    public abstract void validasi(int totalKarung);
}

public interface CrudDao<T> {
    List<T> findAll() throws SQLException;
    T findById(int id) throws SQLException;
    long insert(T data) throws SQLException;
    boolean update(T data) throws SQLException;
    boolean delete(int id) throws SQLException;
}
```

---

## ── ⟡ Alur Penggunaan Program
Berikut ini ialah alur penggunaan program dari AGROVA.

### ˙🌱 ̟  Akun uji coba
| Peran | Email | Kata sandi | Catatan |
|---|---|---|---|
| Pengelola | `budi@perusahaan.com` | `budi123` | Kepala Cabang |
| Penyalur | `makmur@kios.com` | `makmur1` | Toko Tani Makmur, Samarinda Ulu |
| Petani | `joko@petani.com` | `joko11` | Gol B, kios Toko Tani Makmur |
| Petani | `hartono@petani.com` | `hartono55` | Gol A, tidak berhak subsidi |

### ˙🌱 ̟  Alur penggunaan
<!-- TODO: ganti setiap screenshot dengan tangkapan layar asli, simpan di docs/images/screenshots/ -->

<details>
<summary><b>1. Beranda, Login, dan Daftar</b></summary>

Buka program, lalu pilih **Masuk** atau **Daftar** di kanan atas. Petani dan penyalur dapat mendaftar sendiri. Akun pengelola sudah disiapkan di database.

<img src="docs/images/screenshots/beranda.png" alt="Beranda" width="700">
<img src="docs/images/screenshots/login.png" alt="Login" width="700">
<img src="docs/images/screenshots/daftar.png" alt="Daftar" width="700">
</details>

<details>
<summary><b>2. Pengelola</b></summary>

1. Login sebagai pengelola, lalu lihat ringkasan di **Dashboard**.
2. Buka **Pupuk Subsidi** untuk menetapkan kuota per kecamatan.
3. Buka **Penyaluran**, pilih produk, kecamatan tujuan, dan jumlah (kg), lalu klik **Kirim ke penyalur**.
4. Pantau hasilnya di **Lihat Data** dan **Laporan**.

<img src="docs/images/screenshots/pengelola-dashboard.png" alt="Dashboard Pengelola" width="700">
<img src="docs/images/screenshots/pengelola-penyaluran.png" alt="Penyaluran" width="700">
<img src="docs/images/screenshots/pengelola-subsidi.png" alt="Pupuk Subsidi" width="700">
<img src="docs/images/screenshots/pengelola-laporan.png" alt="Laporan" width="700">
</details>

<details>
<summary><b>3. Penyalur</b></summary>

1. Login sebagai penyalur. Buka **Verifikasi** untuk menerima kiriman dari gudang dan memproses pesanan petani.
2. Untuk menyerahkan pupuk langsung, buka **Salurkan**, isi NIK petani, pilih pupuk, isi jumlah, lalu klik **Salurkan ke petani**.
3. Cek sisa pupuk di **Stok**, dan cetak bukti di **Riwayat**.

<img src="docs/images/screenshots/penyalur-verifikasi.png" alt="Verifikasi" width="700">
<img src="docs/images/screenshots/penyalur-salurkan.png" alt="Salurkan" width="700">
<img src="docs/images/screenshots/penyalur-stok.png" alt="Stok" width="700">
<img src="docs/images/screenshots/penyalur-nota.png" alt="Bukti penyaluran" width="700">
</details>

<details>
<summary><b>4. Petani</b></summary>

1. Login sebagai petani. **Beranda** menampilkan kuota dan sisa kuota.
2. Lihat pupuk yang tersedia di **Produk**, lalu buka **Pesan** untuk memesan.
3. Pantau pesanan di **Status Pesanan**. Pesanan yang masih Menunggu dapat dibatalkan.
4. Lihat pupuk yang sudah diterima di **Riwayat**.

<img src="docs/images/screenshots/petani-beranda.png" alt="Beranda Petani" width="700">
<img src="docs/images/screenshots/petani-pesan.png" alt="Pesan" width="700">
<img src="docs/images/screenshots/petani-status.png" alt="Status Pesanan" width="700">
</details>

---

## ── ⟡ Kontributor

| Nama | NIM | Program Studi |
|---|---|---|
| Elena Dementieva | 2509116008 | Sistem Informasi |
| Vidya Khansa Mizan | 2509116052 | Sistem Informasi |
| Yahya Jailani | 2509116085 | Sistem Informasi |
| Rifaa Zainul Arifin | 2509116092 | Sistem Informasi |

<div align="center">

Praktikum Sistem Basis Data · Program Studi Sistem Informasi · Fakultas Teknik · Universitas Mulawarman · 2026

</div>
