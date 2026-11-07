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
| Arsitektur | **MVC, DAO, & Singleton** | Memisahkan tampilan, alur program, model data, dan akses database. |
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

AGROVA dirancang dengan menggunakan pola MVC (Model-View-Controller) dan DAO (Data Access Object) agar pemisahan tugas antar-bagian menjadi lebih jelas. Tampilan antarmuka, proses bisnis, data, dan koneksi database dipisah secara terstruktur agar kode menjadi lebih rapi, serta mudah untuk dikelola dan dikembangkan ke depannya.

```
AGROVA/
├── database/
│   └── perusahaan_root.sql
├── laporan/
│   └── laporan_penyaluran_20261106_134052.pdf
├── src/main/
│   ├── java/
│   │   ├── config/
│   │   │   ├── Koneksi.java
│   │   │   ├── EntityManagerProvider.java
│   │   │   ├── TestKoneksi.java 
│   │   │   └── TestKoneksiOrm.java 
│   │   ├── controller/
│   │   │   ├── GuiController.java 
│   │   │   ├── Session.java 
│   │   │   ├── Kelola.java  
│   │   │   ├── RoleController.java 
│   │   │   ├── AuthController.java
│   │   │   ├── MainController.java
│   │   │   ├── PengelolaController.java
│   │   │   ├── PenyalurController.java
│   │   │   ├── PenyaluranController.java
│   │   │   └── PetaniController.java
│   │   ├── main/
│   │   │   └── Main.java  
│   │   ├── model/
│   │   │   ├── User.java  
│   │   │   ├── Pengelola.java
│   │   │   ├── Penyalur.java
│   │   │   ├── Petani.java
│   │   │   ├── Role.java
│   │   │   ├── Kios.java
│   │   │   ├── Pupuk.java
│   │   │   ├── Penyaluran.java
│   │   │   ├── KategoriPenyaluran.java 
│   │   │   ├── Subsidi.java
│   │   │   ├── NonSubsidi.java
│   │   │   ├── KlasifikasiPetani.java
│   │   │   ├── Security.java
│   │   │   ├── BusinessException.java
│   │   │   └── dao/
│   │   │       ├── CrudDao.java  
│   │   │       ├── UserDao.java
│   │   │       ├── PupukDao.java
│   │   │       ├── PenyaluranDao.java
│   │   │       ├── KiosDao.java
│   │   │       └── LaporanDao.java
│   │   └── view/
│   │       ├── frmBeranda.java   
│   │       ├── frmLogin.java
│   │       ├── frmDaftar.java
│   │       ├── frmPengelola.java 
│   │       ├── frmPenyalur.java
│   │       ├── frmPetani.java
│   │       ├── PgBerandaGuest.java 
│   │       ├── PgTentang.java
│   │       ├── PgRekomendasi.java
│   │       ├── PgDashboard.java   
│   │       ├── PgPenyaluran.java
│   │       ├── PgSubsidi.java
│   │       ├── PgLihatData.java
│   │       ├── PgLaporan.java
│   │       ├── PgBerandaPenyalur.java 
│   │       ├── PgKonfirmasi.java
│   │       ├── PgSalurkan.java
│   │       ├── PgStok.java
│   │       ├── PgRiwayatPenyalur.java
│   │       ├── PgBerandaPetani.java 
│   │       ├── PgProduk.java
│   │       ├── PgPesan.java
│   │       ├── PgStatus.java
│   │       ├── PgRiwayatPetani.java
│   │       ├── PgProfil.java 
│   │       ├── dlgNota.java 
│   │       ├── dlgNotifikasi.java
│   │       ├── dlgUbahPenyaluran.java
│   │       ├── PdfReport.java 
│   │       ├── Table.java
│   │       ├── ConsoleView.java 
│   │       ├── MainView.java
│   │       ├── AuthView.java
│   │       ├── PengelolaView.java
│   │       ├── PenyalurView.java
│   │       ├── PenyaluranView.java
│   │       ├── PetaniView.java
│   │       └── util/
│   │           ├── Theme.java
│   │           ├── Styler.java
│   │           ├── Nav.java 
│   │           ├── Refreshable.java
│   │           ├── Validasi.java
│   │           ├── InputFilters.java
│   │           ├── Fields.java
│   │           ├── TableKit.java
│   │           ├── Charts.java
│   │           ├── Dialogs.java
│   │           ├── Icons.java
│   │           ├── ThinScrollBarUI.java
│   │           └── SampleData.java
│   └── resources/
│       ├── META-INF/
│       │   └── persistence.xml
│       └── images/
│           ├── beranda_hero.png
│           ├── beranda_hero_gelap.png
│           ├── daftar_brand.png
│           ├── login_brand.png
│           ├── logo_kecil.png
│           ├── eye.png
│           ├── eye_off.png
│           ├── pupuk/ 
│           │   ├── urea_subsidi.png
│           │   ├── npk_subsidi.png
│           │   ├── npk_phonska_subsidi.png
│           │   ├── npk_untuk_kakao_subsidi.png
│           │   ├── za_subsidi.png
│           │   ├── dolomit_subsidi.png
│           │   ├── urea_nonsubsidi.png
│           │   ├── npk_nonsubsidi.png
│           │   ├── za_nonsubsidi.png
│           │   ├── kcl_nonsubsidi.png
│           │   ├── sp_36_nonsubsidi.png
│           │   ├── tsp_nonsubsidi.png
│           │   ├── dap_nonsubsidi.png
│           │   └── kecil/
│           └── tentang/
│               ├── pabrik.jpg
│               ├── sdg8.png
│               └── sdg12.png
├── tools/     
│   ├── common.py
│   ├── dsl.py
│   ├── fb.py
│   ├── guest.py
│   ├── roles.py
│   └── export/
│       ├── Export.java
│       └── Art.java.txt
├── .gitignore
└── pom.xml
```

Adapun penjelasan singkat mengenai peran dari masing-masing package yang ada di dalam AGROVA, yaitu sebagai berikut.

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
Encapsulation adalah pembungkusan data dan perilaku dalam satu class. Atribut disembunyikan dengan private, lalu akses ke atribut itu dibuka secara terkendali lewat getter dan setter. Dengan begitu, data tidak bisa diubah sembarangan dari luar dan aturan penjagaannya cukup ditulis di satu tempat.

Pada AGROVA, encapsulation diterapkan pada class User dan Petani untuk menjaga data akun dan data petani tetap valid. Semua atributnya private, dan setter-nya memeriksa isi sebelum menyimpan: format email, no. HP 9–15 digit, NIK 16 digit, dan luas lahan 0,01–99,99 hektare. Jika aturan dilanggar, setter melempar BusinessException. Setter validasi juga dibuat final supaya subclass tidak bisa melonggarkan aturannya.

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
}
```

```java
public final void setNik(String nik) {
    if (!Security.isDigits(nik, 16, 16)) {
        throw new BusinessException("NIK harus 16 digit angka.");
    }
    this.nik = nik;
}
```

### ˙🌱 ̟  Inheritance
Inheritance memungkinkan sebuah class (subclass) mewarisi atribut dan method dari class lain (superclass) lewat kata kunci extends. Atribut dan method yang sama cukup ditulis sekali di superclass, sehingga kode tidak berulang dan hubungan antarclass lebih jelas.

Pada AGROVA, Pengelola, Penyalur, dan Petani mewarisi User, sehingga data dasar akun (id, nama, email, no. HP) ditulis satu kali di User. Tiap subclass hanya menambahkan atribut miliknya, misalnya jabatan dan NIP untuk pengelola, atau NIK, luas lahan, dan golongan untuk petani, lalu memanggil constructor induk dengan super(...). Pola ini sama dengan supertype dan subtype pada ERD (user menjadi pengelola, penyalur, petani). Pewarisan juga dipakai pada `Subsidi` dan `NonSubsidi` yang mewarisi `KategoriPenyaluran`.

```java
public class Pengelola extends User {
    private String jabatan;
    private String nip;

    public Pengelola(int id, String nama, String email, String noHp, String jabatan, String nip) {
        super(id, nama, email, noHp);
        this.jabatan = jabatan;
        this.nip = nip;
    }
}
```

### ˙🌱 ̟  Polymorphism
Polymorphism berarti satu nama method dapat berperilaku berbeda tergantung konteksnya. Ada dua bentuknya: overriding, ketika perilaku ditentukan oleh jenis objek saat program berjalan, dan overloading, ketika perilaku ditentukan oleh parameter yang dikirim. Keduanya membuat kode pemanggil lebih sederhana karena tidak perlu memeriksa jenis objek satu per satu.

Pada AGROVA, kedua bentuk ini dipakai. Overriding muncul pada aturan validasi kategori pupuk (Subsidi dan NonSubsidi) serta pada `getInfoProfil()` milik tiap peran pengguna. Sedangkan, overloading muncul pada `UserDao.cari()` yang bisa mencari pengguna berdasarkan id maupun email.

**1. Overriding**\
Overriding terjadi ketika subclass menulis ulang method milik superclass dengan nama dan parameter yang sama, biasanya ditandai dengan `@Override` tetapi dengan isi yang berbeda. Saat method dipanggil, Java memilih versi yang sesuai dengan jenis objek sebenarnya.

Pada AGROVA, Subsidi dan NonSubsidi sama-sama menimpa `validasi()` dari `KategoriPenyaluran`. Pupuk subsidi menolak penyaluran yang melebihi kuota, sedangkan nonsubsidi hanya mensyaratkan minimal 1 karung. Oleh karena itu, `Penyaluran.validasiSebelumSimpan()` cukup memanggil `getDetail().validasi(...)` tanpa mengecek jenis pupuknya. Overriding juga dipakai pada `getInfoProfil():` Pengelola dan Petani memanggil versi induk lalu menambahkan data khas masing-masing.

```java
@Override
public void validasi(int totalKarung) {
    if (totalKarung > kuotaSubsidi) {
        throw new BusinessException("Penyaluran ditolak: Kuota melebihi kuota subsidi ("
                + totalKarung + " > " + kuotaSubsidi + ")");
    }
}

@Override
public void validasi(int totalKarung) {
    if (totalKarung < 1) {
        throw new BusinessException("Penyaluran non-subsidi minimal 1 karung.");
    }
}
```

```java
for (Pupuk p : pupuk) {
    p.getDetail().validasi(p.getKarung());
}
```

```java
@Override
public Map<String, Object> getInfoProfil() {
    Map<String, Object> m = super.getInfoProfil();
    m.put("jabatan", jabatan);
    m.put("nip", nip);
    return m;
}
```

**2. Overloading**\
Overloading adalah penulisan beberapa method dengan nama yang sama dalam satu class, tetapi dengan jumlah atau tipe parameter yang berbeda. Java memilih method yang tepat saat kompilasi berdasarkan argumen yang diberikan.

Pada AGROVA, `UserDao` memiliki dua method `cari. cari(int id)` mencari pengguna berdasarkan id dengan memeriksa tabel pengelola, penyalur, lalu petani. `cari(String email)` mencari berdasarkan email, kemudian meneruskan hasilnya ke `cari(int id)`. Pemanggil cukup menulis `cari(...)` dan sistem memilih versi yang cocok dengan data yang dimiliki.

```java
public User cari(int id) throws SQLException {
}

public User cari(String email) throws SQLException {
    Map<String, Object> r = Koneksi.one("SELECT id_user FROM `user` WHERE email = ?", email);
    return r == null || r.isEmpty() ? null : cari(Koneksi.intOf(r, "id_user"));
}
```

### ˙🌱 ̟  Abstraction
Abstraction adalah penyederhanaan program dengan menampilkan hal yang pokok dan menyembunyikan detail pelaksanaannya. Penerapannya memakai abstract class, yang boleh berisi method tanpa isi, dan interface, yang berfungsi sebagai kontrak bagi class lain. Pengguna class cukup tahu apa yang bisa dilakukan, tidak perlu tahu bagaimana caranya.

Pada AGROVA, abstraction diterapkan di tiga tempat. User adalah abstract class yang mewajibkan setiap subclass menentukan perannya lewat `getPeran()`. KategoriPenyaluran adalah abstract class yang hanya menetapkan `getNama()` dan `validasi()` untuk dilengkapi Subsidi dan NonSubsidi. Sementara itu, interface `CrudDao<T>` menjadi kontrak operasi database yang diimplementasikan `PupukDao`, `PenyaluranDao`, dan `KiosDao`, sehingga bagian lain program memakai `findAll`, `insert`, `update`, dan `delete` tanpa tahu isi query SQL-nya.

```java
public abstract Role getPeran();   

public abstract class KategoriPenyaluran {
    public abstract String getNama();
    public abstract void validasi(int totalKarung);
}
```

```java
public interface CrudDao<T> {
    List<T> findAll() throws SQLException;
    T findById(int id) throws SQLException;
    long insert(T data) throws SQLException;
    boolean update(T data) throws SQLException;
    boolean delete(int id) throws SQLException;
}
```

---

## ── ⟡ Penerapan Nilai Tambah

### ˙🌱 ̟  JDBC (Java Database Connectivity)
JDBC adalah API standar Java untuk menghubungkan program dengan database relasional. Lewat JDBC, program membuka koneksi, mengirim perintah SQL, lalu membaca hasilnya sebagai data Java. Agar aman dari SQL Injection, perintah SQL sebaiknya dijalankan dengan `PreparedStatement`, yaitu SQL yang nilainya diisi terpisah lewat tanda `?`.

Pada AGROVA, JDBC menjadi jalur utama akses data. Class `Koneksi` membuka koneksi ke database agrova dengan driver MySQL Connector/J dan menyediakan helper `query`, `one`, `insert`, dan update yang semuanya memakai `PreparedStatement`. Alamat, user, dan sandi database dapat diganti lewat environment variable tanpa mengubah kode. Untuk proses yang melibatkan banyak langkah, `Koneksi.tx()` menjalankan transaksi dengan commit otomatis, dan rollback jika terjadi kesalahan. Seluruh query diletakkan di class `DAO`, sehingga bagian lain program tidak perlu mengetahui isi SQL-nya.

```java
private static final String URL = env("AGROVA_DB_URL", "jdbc:mysql://localhost:3306/agrova");
private static final String USER = env("AGROVA_DB_USER", "root");
private static final String PASS = env("AGROVA_DB_PASS", "");

public static List query(String sql, Object... params) throws SQLException {
    List list = new ArrayList();
    Connection c = getConnection();
    try (PreparedStatement ps = c.prepareStatement(sql)) {
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        try (ResultSet rs = ps.executeQuery()) {
        }
    }
    return list;
}
```

```java
public static void tx(Work work) throws SQLException {
    Connection c = getConnection();
    try {
        c.setAutoCommit(false);
        work.run();
        c.commit();
    } catch (SQLException e) {
        c.rollback();
        throw e;
    }
}
```

```java
@Override
public long insert(Kios k) throws SQLException {
    return Koneksi.insert("INSERT INTO kios (nama_kios, nama_kecamatan) VALUES (?, ?)",
            k.getNamaKios(), k.getNamaKecamatan());
}
```

### ˙🌱 ̟  ORM (Object Relational Mapping)
ORM adalah teknik yang memetakan class Java ke tabel database, sehingga data dapat dikelola sebagai objek tanpa menulis SQL manual. Pada AGROVA, ORM disiapkan dengan Hibernate 7.4.5.Final. Konfigurasi koneksi ada di `persistence.xml` (persistence unit perusahaanRootPU), lalu `EntityManagerProvider` membuat `EntityManagerFactory` dan menyediakan `EntityManager`. Pada versi ini, ORM dipakai untuk menguji koneksi lewat `TestKoneksiOrm`, sedangkan pengelolaan data utama (CRUD) memakai JDBC dan DAO. Class model belum dipetakan sebagai entity, sehingga `persistence.xml` memakai `exclude-unlisted-classes`.

```java
<persistence-unit name="perusahaanRootPU" transaction-type="RESOURCE_LOCAL">
    <exclude-unlisted-classes>true</exclude-unlisted-classes>
    <properties>
        <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/agrova"/>
        <property name="hibernate.hbm2ddl.auto" value="none"/>
    </properties>
</persistence-unit>
```

```java
private static final EntityManagerFactory emf;

static {
    emf = Persistence.createEntityManagerFactory("perusahaanRootPU");
}

public static EntityManager getEntityManager() {
    return emf.createEntityManager();
}
```

```java
try (EntityManager em = EntityManagerProvider.getEntityManager()) {
    Object result = em.createNativeQuery("SELECT 1").getSingleResult();
    System.out.println("Koneksi ORM berhasil: " + result);
}
```

### ˙🌱 ̟  Singleton
Singleton adalah pola desain yang menjamin sebuah class hanya punya satu instance (atau satu keadaan bersama) yang dipakai oleh seluruh program. Pola ini berguna untuk sumber daya yang mahal atau harus seragam, seperti koneksi database atau data sesi, karena mencegah pembuatan objek berulang dan data yang tidak sinkron.

Pada AGROVA, prinsip ini diterapkan dalam bentuk static singleton di tiga tempat. `Koneksi` menyimpan satu `Connection` statis yang dipakai ulang oleh semua DAO dan hanya dibuat ulang jika koneksinya terputus. `EntityManagerProvider` membuat satu `EntityManagerFactory` sekali saja saat class pertama kali dimuat. `Session` menyimpan satu pengguna yang sedang login untuk seluruh aplikasi, constructor-nya `private` sehingga class ini tidak bisa diinstansiasi, dan semua akses lewat method statis.

```java
private static Connection conn = null;

public static Connection getConnection() throws SQLException {
    if (conn == null || conn.isClosed() || !conn.isValid(2)) {
        conn = DriverManager.getConnection(URL, USER, PASS);
    }
    return conn;
}
```

```java
public final class Session {
    private static User user;

    private Session() {
    }

    public static User user() { return user; }
    public static void masuk(User u) { user = u; }
    public static void keluar() { user = null; }
    public static boolean adaLogin() { return user != null; }
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

| Nama | NIM | Kelas |
|---|---|---|
| Elena Dementieva | 2509116008 | Sistem Informasi A 2025 |
| Vidya Khansa Mizan | 2509116052 | Sistem Informasi B 2025 |
| Yahya Jailani | 2509116085 | Sistem Informasi C 2025 |
| Rifaa Zainul Arifin | 2509116092 | Sistem Informasi C 2025 |

<div align="center">

Praktikum Sistem Basis Data · Program Studi Sistem Informasi · Fakultas Teknik · Universitas Mulawarman · 2026

</div>
