from common import *
PGL, PSY, PTN = 'agrova.ui.pengelola', 'agrova.ui.penyalur', 'agrova.ui.petani'
def barrow(k, name, pct, txt):
    return Bd('pnlRowBar' + k, [L('lblB' + k, name, con='West', preferredSize=D(160, 24)), Bar('barK' + k, pct, con='Center'), L('lblHint' + k, txt, con='East', preferredSize=D(70, 24))], alignmentX=0.0, maximumSize=D(W, 30), border=E(3, 0, 3, 0))
def btn(n, t, icon=None): return Btn(n, t)

# ---------------------------------------------------------------- PENGELOLA
def pengelola():
    # Dashboard
    pg = PG()
    bars = [barrow(str(i), n, p, f'{p}%') for i, (n, p) in enumerate(zip(KEC[:8], [82, 71, 64, 58, 49, 37, 30, 22]))]
    c1 = Card('Kec', 'Distribusi per kecamatan', bars, 'Terserap dari kuota')
    ring = Tabs('tabRingkas', [('Stok', V('pnlTabStok', [L('lblB1S', 'Urea Subsidi — 145.000 kg'), L('lblB2S', 'NPK Phonska — 98.000 kg'), L('lblB3S', 'Pupuk Organik — 60.000 kg')], border=E(12, 12, 12, 12))),
                                ('Kuota', V('pnlTabKat', [L('lblB1K', 'Kuota terserap — 61%'), Bar('barSub', 61), L('lblB2K', 'Sisa kuota — 39%'), Bar('barSisa', 39)], border=E(12, 12, 12, 12))),
                                ('Perhatian', V('pnlTabAtt', [L('lblErrA', '• Kuota Palaran terserap 22% — di bawah target'), L('lblErrB', '• Stok Pupuk Organik menipis'), L('lblErrC', '• 3 pengiriman menunggu konfirmasi')], border=E(12, 12, 12, 12)))], 180)
    c2 = Card('Ring', 'Ringkasan gudang', [ring])
    pg.code('        Styler.hintError(lblErrA, lblErrB, lblErrC);')
    blocks = [stats('Dash', [('Total stok gudang', '303.000 kg', 'semua produk'), ('Penyaluran bulan ini', '18.250 kg', '12 transaksi'), ('Petani terdaftar', '1.284', '10 kecamatan'), ('Menunggu konfirmasi', '3', 'pengiriman')]),
              grid2('Dash', c1, c2, 330), tcard(pg, 'Terbaru', 'Penyaluran terbaru', C['ringkas'], 'penyaluranRingkas', search=False, h=200)]
    mkpage(PGL, 'PgDashboard', 'Dash', 'Dashboard', 'Ringkasan distribusi pupuk seluruh kecamatan.', blocks, pg)

    # Penyaluran
    pg = PG()
    f = Frm('Pny', [CField('Produk', 'Produk', PROD), CField('Kec', 'Kecamatan tujuan', KEC), Field('Jumlah', 'Jumlah (kg)', ' ')],
            [Btn('btnSimpanPny', 'Kirim ke penyalur'), Btn('btnGhostResetPny', 'Kosongkan')])
    pg.h['btnSimpanPnyActionPerformed'] = '''        lblHintJumlah.setText(" ");
        if (!txtJumlah.getText().matches("[1-9]\\\\d{0,6}")) {
            lblHintJumlah.setText("Jumlah harus bilangan bulat lebih dari 0");
            return;
        }
        // TODO backend: simpan penyaluran (kategori, produk, kecamatan, jumlah) + cek stok & kuota
        Dialogs.info(this, "Penyaluran dicatat (data contoh).");'''
    pg.h['btnGhostResetPnyActionPerformed'] = '        txtJumlah.setText("");\n        lblHintJumlah.setText(" ");'
    pg.h['btnUbahActionPerformed'] = '        new agrova.ui.dialog.dlgUbahPenyaluran(Dialogs.owner(this), true).setVisible(true);'
    pg.h['btnBuktiActionPerformed'] = '        new agrova.ui.dialog.dlgBukti(Dialogs.owner(this), true).setVisible(true);'
    pg.code('        InputFilters.digits(txtJumlah, 7);\n        lblHintJumlah.setForeground(Theme.CLAY);')
    blocks = [Card('Form', 'Penyaluran baru', f), tcard(pg, 'Pny', 'Daftar penyaluran', C['penyaluran'], 'penyaluran', [Btn('btnUbah', 'Ubah'), Btn('btnBukti', 'Bukti'), Btn('btnHapus', 'Hapus')], h=300)]
    mkpage(PGL, 'PgPenyaluran', 'Pny', 'Penyaluran', 'Kirim pupuk dari gudang ke kecamatan.', blocks, pg)

    # Subsidi
    pg = PG()
    f = Frm('Kuota', [CField('Kec', 'Kecamatan', KEC), CField('Produk', 'Produk', PROD), Field('Tahun', 'Tahun', ' '), Field('Jumlah', 'Kuota (kg)', ' ')], [Btn('btnSimpanKuota', 'Simpan kuota'), Btn('btnGhostReset', 'Kosongkan')])
    pg.h['btnSimpanKuotaActionPerformed'] = '''        lblHintTahun.setText(" ");
        lblHintJumlah.setText(" ");
        boolean ok = true;
        if (!txtTahun.getText().matches("20\\\\d{2}")) {
            lblHintTahun.setText("Tahun tidak valid (20xx)");
            ok = false;
        }
        if (!txtJumlah.getText().matches("[1-9]\\\\d{0,7}")) {
            lblHintJumlah.setText("Kuota harus bilangan bulat lebih dari 0");
            ok = false;
        }
        if (!ok) {
            return;
        }
        // TODO backend: simpan/ubah kuota kecamatan'''.replace("        // TODO backend: simpan/ubah kuota kecamatan", "        // TODO backend: simpan/ubah kuota kecamatan\n        Dialogs.info(this, \"Kuota disimpan (data contoh).\");")
    pg.h['btnGhostResetActionPerformed'] = '        txtTahun.setText("");\n        txtJumlah.setText("");'
    pg.code('        InputFilters.digits(txtTahun, 4);\n        InputFilters.digits(txtJumlah, 8);\n        lblHintTahun.setForeground(Theme.CLAY);\n        lblHintJumlah.setForeground(Theme.CLAY);')
    t = Tabs('tabSub', [
      ('Kuota', V('pnlTabKuota', [Card('FKuota', 'Atur kuota', f), tcard(pg, 'Kuota', 'Kuota kecamatan', C['kuota'], 'kuota', h=200)])),
      ('Data petani', V('pnlTabPetani', [tcard(pg, 'Petani', 'Petani subsidi', C['petani'], 'petani', h=300)])),
      ('Penyaluran', V('pnlTabPny', [tcard(pg, 'PnyPetani', 'Penyaluran ke petani', C['pp'], 'penyaluranPetani', h=300)])),
      ('Pantau', V('pnlTabPantau', [tcard(pg, 'Pantau', 'Pantau kuota per kecamatan', C['pantau'], 'pantau', h=300)]))], 620)
    mkpage(PGL, 'PgSubsidi', 'Sub', 'Pupuk Subsidi', 'Kuota, petani, penyaluran, dan pemantauan.', [t], pg)

    # Lihat data
    pg = PG()
    t = Tabs('tabData', [('Petani', V('pnlTabP', [tcard(pg, 'Ptn', 'Data petani', C['petani'], 'petani', h=360)])),
                         ('Penyalur', V('pnlTabY', [tcard(pg, 'Pyl', 'Data penyalur', C['penyalur'], 'penyalur', h=360)])),
                         ('Ketersediaan', V('pnlTabK', [tcard(pg, 'Ktr', 'Ketersediaan pupuk', C['ketersediaan'], 'ketersediaan', h=360)]))], 520)
    mkpage(PGL, 'PgLihatData', 'Data', 'Lihat Data', 'Data master (hanya baca).', [t], pg)

    # Laporan
    pg = PG()
    f = Frm('Lap', [Field('Dari', 'Dari tanggal', 'dd-MM-yyyy'), Field('Sampai', 'Sampai tanggal', 'dd-MM-yyyy'), CField('Produk', 'Produk', ['Semua'] + PROD), CField('Kec', 'Kecamatan', ['Semua'] + KEC)],
            [Btn('btnTampil', 'Tampilkan'), Btn('btnGhostPdf', 'Ekspor PDF')])
    pg.h['btnTampilActionPerformed'] = '''        String re = "(0[1-9]|[12]\\\\\\\\d|3[01])-(0[1-9]|1[0-2])-20\\\\\\\\d{2}";
        lblHintDari.setText("dd-MM-yyyy");
        lblHintSampai.setText("dd-MM-yyyy");
        boolean ok = true;
        if (!txtDari.getText().matches(re)) {
            lblHintDari.setText("Tanggal tidak valid");
            ok = false;
        }
        if (!txtSampai.getText().matches(re)) {
            lblHintSampai.setText("Tanggal tidak valid");
            ok = false;
        }
        if (!ok) {
            return;
        }
        // TODO backend: ambil data laporan sesuai filter lalu TableKit.fill(tblLaporan, hasil)
        TableKit.fill(tblLaporan, SampleData.laporan());'''
    pg.h['btnTampilActionPerformed'] = pg.h['btnTampilActionPerformed'].replace('\\\\\\\\', '\\\\')
    pg.code('        InputFilters.digits(txtDari, 10);\n        InputFilters.digits(txtSampai, 10);')
    blocks = [Card('Filter', 'Filter laporan', f), tcard(pg, 'Laporan', 'Hasil laporan', C['penyaluran'], 'laporan', search=False, h=300)]
    mkpage(PGL, 'PgLaporan', 'Lap', 'Laporan', 'Rekap penyaluran periode tertentu.', blocks, pg)
    shell(PGL, 'frmPengelola', 'AGROVA — Pengelola', 'PENGELOLA', '', [('Dashboard', 'Dashboard', 'DASHBOARD'), ('Penyaluran', 'Penyaluran', 'TRUCK'), ('Subsidi', 'Pupuk Subsidi', 'LEAF'), ('LihatData', 'Lihat Data', 'DATA'), ('Laporan', 'Laporan', 'REPORT')],
          ['PgDashboard', 'PgPenyaluran', 'PgSubsidi', 'PgLihatData', 'PgLaporan'], 'new java.awt.Color(14, 42, 32)', 'Halo, Pengelola Root')

# ---------------------------------------------------------------- PENYALUR
def penyalur():
    pg = PG()
    blocks = [stats('Bp', [('Stok kecamatan', '9.850 kg', 'semua produk'), ('Pengiriman masuk', '2', 'menunggu konfirmasi'), ('Pesanan petani', '3', 'menunggu disetujui'), ('Tersalur bulan ini', '1.420 kg', '')]),
              tcard(pg, 'Notif', 'Notifikasi terbaru', C['notif'], 'notifikasi', search=False, h=220)]
    mkpage(PSY, 'PgBeranda', 'Bp', 'Beranda Penyalur', 'Kecamatan Samarinda Ulu — Tani Makmur.', blocks, pg)

    pg = PG()
    pg.h['btnTerimaActionPerformed'] = '        if (tblMasuk.getSelectedRow() < 0) {\n            Dialogs.info(this, "Pilih pengiriman terlebih dahulu.");\n            return;\n        }\n        // TODO backend: konfirmasi penerimaan pengiriman\n        Dialogs.info(this, "Pengiriman dikonfirmasi (data contoh).");'
    pg.h['btnBuktiActionPerformed'] = '        new agrova.ui.dialog.dlgBukti(Dialogs.owner(this), true).setVisible(true);'
    pg.h['btnSetujuActionPerformed'] = '        if (tblMenunggu.getSelectedRow() < 0) {\n            Dialogs.info(this, "Pilih pesanan terlebih dahulu.");\n            return;\n        }\n        // TODO backend: setujui pesanan petani\n        Dialogs.info(this, "Pesanan disetujui (data contoh).");'
    t = Tabs('tabKonf', [('Pengiriman masuk', V('pnlTabMasuk', [tcard(pg, 'Masuk', 'Pengiriman dari gudang', C['masuk'], 'pengirimanMasuk', [Btn('btnTerima', 'Terima'), Btn('btnBukti', 'Lihat bukti'), Btn('btnGhostTolak', 'Tolak')], h=300)])),
                         ('Pesanan petani', V('pnlTabMenunggu', [tcard(pg, 'Menunggu', 'Pesanan menunggu', C['menunggu'], 'pesananMenunggu', [Btn('btnSetuju', 'Setujui'), Btn('btnGhostTolakP', 'Tolak')], h=300)]))], 480)
    mkpage(PSY, 'PgKonfirmasi', 'Kf', 'Konfirmasi', 'Terima kiriman dan setujui pesanan petani.', [t], pg)

    pg = PG()
    f = Frm('Sal', [Field('Nik', 'NIK petani (16 digit)', ' '), CField('Produk', 'Produk', PROD), Field('Jumlah', 'Jumlah (kg)', ' ')], [Btn('btnSalurkan', 'Salurkan'), Btn('btnGhostCek', 'Cek kuota')])
    pg.h['btnSalurkanActionPerformed'] = '''        lblHintNik.setText(" ");
        lblHintJumlah.setText(" ");
        boolean ok = true;
        if (!txtNik.getText().matches("\\\\d{16}")) {
            lblHintNik.setText("NIK harus 16 digit angka");
            ok = false;
        }
        if (!txtJumlah.getText().matches("[1-9]\\\\d{0,5}")) {
            lblHintJumlah.setText("Jumlah harus bilangan bulat lebih dari 0");
            ok = false;
        }
        if (!ok) {
            return;
        }
        // TODO backend: salurkan pupuk (cek kuota petani + stok kecamatan)
        Dialogs.info(this, "Penyaluran dicatat (data contoh).");'''
    pg.h['btnGhostCekActionPerformed'] = '        // TODO backend: ambil kuota petani berdasarkan NIK lalu TableKit.fill(tblKuotaPetani, hasil)\n        TableKit.fill(tblKuotaPetani, SampleData.kuotaPetani());'
    pg.code('        InputFilters.digits(txtNik, 16);\n        InputFilters.digits(txtJumlah, 6);\n        lblHintNik.setForeground(Theme.CLAY);\n        lblHintJumlah.setForeground(Theme.CLAY);')
    blocks = [Card('FSal', 'Salurkan ke petani', f), tcard(pg, 'KuotaPetani', 'Kuota petani', C['kuotaPetani'], 'kuotaPetani', search=False, h=170)]
    mkpage(PSY, 'PgSalurkan', 'Sl', 'Salurkan', 'Serahkan pupuk kepada petani sesuai kuota.', blocks, pg)

    pg = PG()
    t = Tabs('tabStok', [('Stok kecamatan', V('pnlTabStok', [tcard(pg, 'StokKec', 'Stok kecamatan', C['stokKec'], 'stokKecamatan', h=320)])),
                         ('Ketersediaan', V('pnlTabKet', [tcard(pg, 'Ket', 'Ketersediaan produk', C['stokTersedia'], 'stokTersedia', h=320)]))], 460)
    mkpage(PSY, 'PgStok', 'St', 'Stok', 'Persediaan pupuk di kecamatan Anda.', [t], pg)

    pg = PG()
    mkpage(PSY, 'PgRiwayat', 'Rw', 'Riwayat', 'Seluruh penyaluran yang pernah dicatat.', [tcard(pg, 'Riw', 'Riwayat penyaluran', C['riwP'], 'riwayatPenyalur', h=420)], pg)
    shell(PSY, 'frmPenyalur', 'AGROVA — Penyalur', 'PENYALUR', '', [('Beranda', 'Beranda', 'HOME'), ('Konfirmasi', 'Konfirmasi', 'CHECK'), ('Salurkan', 'Salurkan', 'TRUCK'), ('Stok', 'Stok', 'WAREHOUSE'), ('Riwayat', 'Riwayat', 'HISTORY')],
          ['PgBeranda', 'PgKonfirmasi', 'PgSalurkan', 'PgStok', 'PgRiwayat'], 'new java.awt.Color(11, 38, 48)', 'Halo, Tani Makmur')

# ---------------------------------------------------------------- PETANI
def petani():
    pg = PG()
    blocks = [stats('Bt', [('Kuota musim ini', '1.275 kg', '3 produk'), ('Terpakai', '350 kg', ''), ('Sisa kuota', '925 kg', ''), ('Pesanan aktif', '1', 'menunggu')]),
              tcard(pg, 'KuotaP', 'Kuota saya', C['kuotaPetani'], 'kuotaPetani', search=False, h=170)]
    mkpage(PTN, 'PgBeranda', 'Bt', 'Beranda Petani', 'Budi Santoso — Samarinda Ulu.', blocks, pg)
    pg = PG()
    mkpage(PTN, 'PgProduk', 'Pr', 'Produk', 'Pupuk yang tersedia di kecamatan Anda.', [tcard(pg, 'Prod', 'Produk tersedia', C['stokTersedia'], 'stokTersedia', h=330)], pg)
    pg = PG()
    f = Frm('Psn', [CField('Produk', 'Produk', PROD), Field('Jumlah', 'Jumlah (kg)', ' ')], [Btn('btnPesan', 'Kirim pesanan')])
    pg.h['btnPesanActionPerformed'] = '''        lblHintJumlah.setText(" ");
        if (!txtJumlah.getText().matches("[1-9]\\\\d{0,4}")) {
            lblHintJumlah.setText("Jumlah harus bilangan bulat lebih dari 0");
            return;
        }
        // TODO backend: buat pesanan (cek kuota dan stok kecamatan)
        Dialogs.info(this, "Pesanan terkirim (data contoh).");'''
    pg.code('        InputFilters.digits(txtJumlah, 5);\n        lblHintJumlah.setForeground(Theme.CLAY);')
    blocks = [Card('FPsn', 'Pesan pupuk', f), tcard(pg, 'KuotaP', 'Sisa kuota', C['kuotaPetani'], 'kuotaPetani', search=False, h=170)]
    mkpage(PTN, 'PgPesan', 'Ps', 'Pesan', 'Pesan pupuk sesuai kuota Anda.', blocks, pg)
    pg = PG()
    pg.h['btnBatalActionPerformed'] = '        if (tblStatus.getSelectedRow() < 0) {\n            Dialogs.info(this, "Pilih pesanan terlebih dahulu.");\n            return;\n        }\n        if (Dialogs.confirm(this, "Batalkan pesanan ini?")) {\n            // TODO backend: batalkan pesanan\n        }'
    mkpage(PTN, 'PgStatus', 'Sts', 'Status Pesanan', 'Pantau pesanan yang sedang berjalan.', [tcard(pg, 'Status', 'Pesanan saya', C['pesananSaya'], 'pesananSaya', [Btn('btnBatal', 'Batalkan')], h=330)], pg)
    pg = PG()
    mkpage(PTN, 'PgRiwayat', 'Rw', 'Riwayat', 'Pupuk yang sudah diterima.', [tcard(pg, 'Riw', 'Riwayat penerimaan', C['riwPetani'], 'riwayatPetani', h=360)], pg)
    shell(PTN, 'frmPetani', 'AGROVA — Petani', 'PETANI', '', [('Beranda', 'Beranda', 'HOME'), ('Produk', 'Produk', 'SPROUT'), ('Pesan', 'Pesan', 'PLUS'), ('Status', 'Status Pesanan', 'CLOCK'), ('Riwayat', 'Riwayat', 'HISTORY')],
          ['PgBeranda', 'PgProduk', 'PgPesan', 'PgStatus', 'PgRiwayat'], 'new java.awt.Color(34, 44, 14)', 'Halo, Budi Santoso')

# ---------------------------------------------------------------- DIALOG
def dialogs():
    P_ = 'agrova.ui.dialog'
    k = [L('lblHUbah', 'Ubah penyaluran'), L('lblSubUbah', 'Perbarui jumlah atau kecamatan tujuan.', border=E(2, 0, 12, 0)),
         CField('Kec', 'Kecamatan', KEC), Field('Jumlah', 'Jumlah (kg)', ' '),
         Act('Ubah', [Btn('btnSimpan', 'Simpan'), Btn('btnGhostBatal', 'Batal')], 2)]
    h = {'btnSimpanActionPerformed': '''        lblHintJumlah.setText(" ");
        if (!txtJumlah.getText().matches("[1-9]\\\\d{0,6}")) {
            lblHintJumlah.setText("Jumlah harus bilangan bulat lebih dari 0");
            return;
        }
        // TODO backend: simpan perubahan penyaluran
        dispose();''', 'btnGhostBatalActionPerformed': '        dispose();'}
    gen('dialog', P_, 'dlgUbahPenyaluran', 'Ubah Penyaluran', (420, 380), [V('pnlBodyUbah', k, border=E(22, 26, 18, 26), con='Center')], ('border', {}),
        '        Styler.applyDialog(this);\n        InputFilters.digits(txtJumlah, 7);\n        lblHintJumlah.setForeground(Theme.CLAY);', BASE, '', h)
    k = [L('lblHBukti', 'Bukti penyaluran'), L('lblSubBukti', 'Foto atau berkas bukti serah terima.', border=E(2, 0, 12, 0)),
         L('lblBImg', '(pratinjau bukti)', preferredSize=D(360, 200), maximumSize=D(W, 200), border=E(70, 100, 70, 100)),
         Act('Bukti', [Btn('btnUnggah', 'Pilih berkas'), Btn('btnGhostTutup', 'Tutup')], 2)]
    h = {'btnUnggahActionPerformed': '''        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        fc.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Gambar / PDF", "jpg", "jpeg", "png", "pdf"));
        if (fc.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
            lblBImg.setText(fc.getSelectedFile().getName());
            // TODO backend: unggah berkas bukti
        }''', 'btnGhostTutupActionPerformed': '        dispose();'}
    gen('dialog', P_, 'dlgBukti', 'Bukti Penyaluran', (440, 380), [V('pnlBodyBukti', k, border=E(22, 26, 18, 26), con='Center')], ('border', {}), '        Styler.applyDialog(this);', BASE, '', h)
    pg = PG()
    tb = Tbl('Notif', C['notif'], 240, 640)
    k = [L('lblHNotif', 'Notifikasi'), L('lblSubNotif', 'Pemberitahuan terbaru untuk akun Anda.', border=E(2, 0, 12, 0)), tb,
         Act('Notif', [Btn('btnTandai', 'Tandai dibaca'), Btn('btnGhostTutup', 'Tutup')], 2)]
    h = {'btnTandaiActionPerformed': '        // TODO backend: tandai semua notifikasi sebagai dibaca\n        Dialogs.info(this, "Semua notifikasi ditandai dibaca (data contoh).");', 'btnGhostTutupActionPerformed': '        dispose();'}
    gen('dialog', P_, 'dlgNotifikasi', 'Notifikasi', (700, 420), [V('pnlBodyNotif', k, border=E(22, 26, 18, 26), con='Center')], ('border', {}),
        '        Styler.applyDialog(this);\n        TableKit.fill(tblNotif, SampleData.notifikasi());', BASE, '', h)
if __name__ == '__main__':
    pengelola(); penyalur(); petani(); dialogs()
