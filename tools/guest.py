from dsl import *
from fb import IC
from common import KEC
PK = 'agrova.ui.guest'
def seg(prefix, names):
    return Gr('pnlSeg' + prefix, [Tog('tog' + n, n, ev=False) for n in names], len(names), 6, 0, alignmentX=0.0, maximumSize=D(W, 44), preferredSize=D(300, 44))
def brand_side(head, text, bullets, img, size):
    html = ('<html><div style="width:330px"><div style="font-family:Georgia;font-size:26px;color:white">AGROVA</div>'
            '<div style="color:#cfe0d4;font-size:10px">Distribusi pupuk · Perusahaan Root · Samarinda</div><br><br>'
            '<div style="font-family:Georgia;font-size:21px;color:white">' + head + '</div><br>'
            '<div style="color:#e3ede5;font-size:11px">' + text + '</div><br><br>'
            + ''.join('<div style="color:white;font-size:11px">✓&nbsp; ' + b + '</div>' for b in bullets) + '</div>')
    return L('lblLightImgBrand', html, con='West', icon=IC(img), horizontalTextPosition=0, verticalTextPosition=0, preferredSize=D(*size))
POST_ART = '        Styler.art(pnlBrand, 150, true);\n'

def login():
    form = V('pnlForm', [
        L('lblHLogin', 'Masuk ke akun'), L('lblSubLogin', 'Pilih peran Anda lalu masukkan email dan kata sandi.', border=E(2, 0, 14, 0)),
        L('lblFieldPeran', 'Masuk sebagai'), seg('Peran', ['Pengelola', 'Penyalur', 'Petani']),
        L('lblGap1', ' '),
        Field('Email', 'Email', ' '), Field('Sandi', 'Kata sandi', ' ', True),
        Bd('pnlRow', [Ck('chkIngat', 'Ingat saya', con='West'), Btn('btnLinkLupa', 'Lupa kata sandi?', con='East')], alignmentX=0.0, maximumSize=D(W, 36)),
        L('lblGap2', ' '),
        Full(Btn('btnMasuk', 'Masuk')),
        L('lblGap3', ' '),
        Bd('pnlRow2', [L('lblSubDaftar', 'Petani baru?', con='West'), Btn('btnGhostDaftar', 'Daftar akun', con='Center'), Btn('btnLinkBeranda', 'Kembali ke beranda', con='East')], alignmentX=0.0, maximumSize=D(W, 40)),
    ], border=E(34, 40, 30, 40))
    form.con = 'Center'
    form.props['border'] = E(70, 90, 40, 90)
    side = brand_side('Dari gudang pusat sampai ke tangan petani.', 'Pantau kuota, stok, dan penyaluran pupuk subsidi dalam satu tempat.', ['Kuota per kecamatan terkontrol', 'Bukti penyaluran tercatat', 'Riwayat dapat dilacak'], '/images/login_brand.png', (540, 720))
    handlers = {
      'btnMasukActionPerformed': '''        String email = txtEmail.getText().trim();
        String sandi = new String(txtSandi.getPassword());
        boolean ok = true;
        lblHintEmail.setText(" ");
        lblHintSandi.setText(" ");
        if (!email.matches("^[\\\\w.+-]+@[\\\\w-]+(\\\\.[\\\\w-]+)+$")) {
            lblHintEmail.setText("Format email tidak valid");
            ok = false;
        }
        if (sandi.length() < 6) {
            lblHintSandi.setText("Kata sandi minimal 6 karakter");
            ok = false;
        }
        if (!ok) {
            return;
        }
        // TODO backend: autentikasi email + kata sandi + peran (togPengelola / togPenyalur / togPetani)
        java.awt.Window w = javax.swing.SwingUtilities.getWindowAncestor(this);
        javax.swing.JFrame next = togPengelola.isSelected() ? new agrova.ui.pengelola.frmPengelola()
                : togPenyalur.isSelected() ? new agrova.ui.penyalur.frmPenyalur() : new agrova.ui.petani.frmPetani();
        next.setVisible(true);
        dispose();''',
      'btnGhostDaftarActionPerformed': '        new frmDaftar().setVisible(true);\n        dispose();',
      'btnLinkBerandaActionPerformed': '        new frmBeranda().setVisible(true);\n        dispose();',
      'btnLinkLupaActionPerformed': '        Dialogs.todo(this, "Lupa kata sandi"); // TODO backend',
    }
    handlers['btnMasukActionPerformed'] = handlers['btnMasukActionPerformed'].replace('        java.awt.Window w = javax.swing.SwingUtilities.getWindowAncestor(this);\n', '')
    post = '''        Styler.applyFrame(this);
        Styler.icon(btnMasuk, Icons.Name.ARROW);
        Nav.group(togPengelola, togPenyalur, togPetani);
        InputFilters.email(txtEmail, 60);
        InputFilters.password(txtSandi, 40);
        lblHintEmail.setForeground(Theme.CLAY);
        lblHintSandi.setForeground(Theme.CLAY);'''
    gen('frame', PK, 'frmLogin', 'AGROVA — Masuk', (1180, 720), [side, form], ('border', {}), post, BASE, '', handlers)

def daftar():
    def tab_petani():
        ks = [Field('Nik', 'NIK (16 digit)', ' '), Field('Nama', 'Nama lengkap', ' '), CField('Kecamatan', 'Kecamatan', KEC, ' '),
              Field('Luas', 'Luas lahan (ha)', ' '), Field('Email', 'Email', ' '), Field('Sandi', 'Kata sandi', 'Minimal 8 karakter, ada huruf dan angka', True),
              Field('Ulang', 'Ulangi kata sandi', ' ', True), Full(Btn('btnDaftar', 'Buat akun petani'))]
        return V('pnlTabPetani', ks, border=E(14, 0, 8, 0))
    def tab_penyalur():
        ks = [Field('NamaP', 'Nama kios', ' '), Field('IzinP', 'No. izin usaha', ' '), CField('KecP', 'Kecamatan layanan', KEC, ' '),
              Field('TelpP', 'No. telepon', ' '), Field('EmailP', 'Email', ' '), Field('SandiP', 'Kata sandi', 'Minimal 8 karakter, ada huruf dan angka', True),
              Field('UlangP', 'Ulangi kata sandi', ' ', True), Full(Btn('btnDaftarPenyalur', 'Daftarkan kios'))]
        return V('pnlTabPenyalur', ks, border=E(14, 0, 8, 0))
    tabs = Tabs('tabDaftar', [('Petani', tab_petani()), ('Penyalur (kios)', tab_penyalur())])
    form = V('pnlForm', [
        L('lblHDaftar', 'Buat akun'), L('lblSubDaftar', 'Pilih jenis akun: petani atau penyalur (pendaftaran kios).', border=E(2, 0, 10, 0)), tabs,
        Bd('pnlRow2', [L('lblSubSudah', 'Sudah punya akun?', con='West'), Btn('btnGhostMasuk', 'Masuk', con='Center'), Btn('btnLinkBeranda', 'Kembali ke beranda', con='East')], alignmentX=0.0, maximumSize=D(W, 40)),
    ], border=E(22, 40, 18, 40))
    form.con = 'Center'
    scr = N('javax.swing.JScrollPane', 'scrBodyDaftar', kids=[Bd('pnlOuterDaftar', [form])], props={'horizontalScrollBarPolicy': 31}, con='Center')
    side = brand_side('Satu akun untuk petani dan penyalur.', 'Petani mendaftarkan NIK dan lahannya. Penyalur mendaftarkan kiosnya agar dapat menerima dan menyalurkan pupuk subsidi.', ['NIK dan izin usaha tervalidasi', 'Kuota sesuai luas lahan', 'Penyaluran terpantau'], '/images/daftar_brand.png', (480, 760))
    EMAIL = '"^[\\\\w.+-]+@[\\\\w-]+(\\\\.[\\\\w-]+)+$"'
    h = {
      'btnDaftarActionPerformed': """        boolean ok = true;
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblHintNik, lblHintNama, lblHintLuas, lblHintEmail, lblHintUlang}) {
            l.setText(" ");
        }
        String sandi = new String(txtSandi.getPassword());
        if (!txtNik.getText().matches("\\\\d{16}")) {
            lblHintNik.setText("NIK harus 16 digit angka");
            ok = false;
        }
        if (txtNama.getText().trim().length() < 3) {
            lblHintNama.setText("Nama minimal 3 huruf");
            ok = false;
        }
        if (!txtLuas.getText().matches("\\\\d+([,.]\\\\d{1,2})?") || txtLuas.getText().matches("0+([,.]0+)?")) {
            lblHintLuas.setText("Luas lahan harus angka lebih dari 0");
            ok = false;
        }
        if (!txtEmail.getText().trim().matches(""" + EMAIL + """)) {
            lblHintEmail.setText("Format email tidak valid");
            ok = false;
        }
        if (!sandi.matches("^(?=.*[A-Za-z])(?=.*\\\\d).{8,}$")) {
            lblHintSandi.setText("Minimal 8 karakter, ada huruf dan angka");
            lblHintSandi.setForeground(Theme.CLAY);
            ok = false;
        }
        if (!sandi.equals(new String(txtUlang.getPassword()))) {
            lblHintUlang.setText("Kata sandi tidak sama");
            ok = false;
        }
        if (!ok) {
            return;
        }
        // TODO backend: simpan data petani (NIK, nama, kecamatan, luas, email, kata sandi ter-hash)
        Dialogs.info(this, "Pendaftaran petani berhasil (data contoh). Silakan masuk.");
        new frmLogin().setVisible(true);
        dispose();""",
      'btnDaftarPenyalurActionPerformed': """        boolean ok = true;
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblHintNamaP, lblHintIzinP, lblHintTelpP, lblHintEmailP, lblHintUlangP}) {
            l.setText(" ");
        }
        String sandi = new String(txtSandiP.getPassword());
        if (txtNamaP.getText().trim().length() < 3) {
            lblHintNamaP.setText("Nama kios minimal 3 huruf");
            ok = false;
        }
        if (!txtIzinP.getText().trim().matches("[A-Za-z0-9/.\\\\-]{5,30}")) {
            lblHintIzinP.setText("No. izin usaha 5-30 karakter (huruf, angka, / . -)");
            ok = false;
        }
        if (!txtTelpP.getText().matches("08\\\\d{8,12}")) {
            lblHintTelpP.setText("Nomor telepon diawali 08, 10-14 digit");
            ok = false;
        }
        if (!txtEmailP.getText().trim().matches(""" + EMAIL + """)) {
            lblHintEmailP.setText("Format email tidak valid");
            ok = false;
        }
        if (!sandi.matches("^(?=.*[A-Za-z])(?=.*\\\\d).{8,}$")) {
            lblHintSandiP.setText("Minimal 8 karakter, ada huruf dan angka");
            lblHintSandiP.setForeground(Theme.CLAY);
            ok = false;
        }
        if (!sandi.equals(new String(txtUlangP.getPassword()))) {
            lblHintUlangP.setText("Kata sandi tidak sama");
            ok = false;
        }
        if (!ok) {
            return;
        }
        // TODO backend: simpan akun penyalur + data kios (nama kios, no. izin usaha, kecamatan layanan, telepon)
        Dialogs.info(this, "Kios berhasil didaftarkan (data contoh). Silakan masuk.");
        new frmLogin().setVisible(true);
        dispose();""",
      'btnGhostMasukActionPerformed': '        new frmLogin().setVisible(true);\n        dispose();',
      'btnLinkBerandaActionPerformed': '        new frmBeranda().setVisible(true);\n        dispose();'}
    post = """        Styler.applyFrame(this);
        InputFilters.digits(txtNik, 16);
        InputFilters.nama(txtNama, 60);
        InputFilters.decimal(txtLuas, 3, 2);
        InputFilters.email(txtEmail, 60);
        InputFilters.password(txtSandi, 40);
        InputFilters.password(txtUlang, 40);
        InputFilters.nama(txtNamaP, 60);
        InputFilters.keyword(txtIzinP, 30);
        InputFilters.digits(txtTelpP, 14);
        InputFilters.email(txtEmailP, 60);
        InputFilters.password(txtSandiP, 40);
        InputFilters.password(txtUlangP, 40);
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblHintNik, lblHintNama, lblHintLuas, lblHintEmail, lblHintUlang, lblHintNamaP, lblHintIzinP, lblHintTelpP, lblHintEmailP, lblHintUlangP}) {
            l.setForeground(Theme.CLAY);
        }"""
    gen('frame', PK, 'frmDaftar', 'AGROVA — Buat Akun', (1180, 760), [side, scr], ('border', {}), post, BASE, '', h)

PKG_G = PK
def _w(t, w): return '<html><div style="width:%dpx">%s</div>' % (w, t)
def kartu(key, judul, baris, w=250, h=150):
    return V('pnlCard' + key, [L('lblH' + key, judul)] + [L('lblSub%s%d' % (key, i), _w(b, w)) for i, b in enumerate(baris)], preferredSize=D(300, h))

def pg_beranda():
    html = ('<html><div style="width:560px"><div style="color:#cfe0d4;font-size:10px">PERUSAHAAN ROOT · SAMARINDA</div><br>'
            '<div style="font-family:Georgia;font-size:30px;color:white">Pupuk sampai tepat ke tangan petani.</div><br>'
            '<div style="color:#e3ede5;font-size:12px">Distribusi pupuk subsidi dari gudang pusat, lewat penyalur kecamatan, sampai ke petani. Semua tercatat.</div></div>')
    hero = L('lblLightImgHero', html, icon=IC('/images/beranda_hero.png'), horizontalTextPosition=0, verticalTextPosition=0, alignmentX=0.0, preferredSize=D(1180, 330))
    strip = Fl('pnlForestAct', [Btn('btnGoldMulai', 'Login sekarang'), Btn('btnGhostDaftarHero', 'Daftar sebagai petani')], 0, 40, 14, alignmentX=0.0, maximumSize=D(W, 64))
    def role(key, t, d):
        return V('pnlCardRole' + key, [L('lblH' + key, t), L('lblSub' + key, _w(d, 240))], preferredSize=D(300, 110))
    roles = Gr('pnlRoles', [role('Pengelola', 'Pengelola', 'Mengatur kuota, stok gudang, dan memantau seluruh penyaluran.'),
                            role('Penyalur', 'Penyalur', 'Menerima kiriman, mengonfirmasi, lalu menyalurkan ke petani.'),
                            role('Petani', 'Petani', 'Memesan pupuk sesuai kuota dan memantau status pesanan.')], 3, 16, 0, alignmentX=0.0, maximumSize=D(W, 140), preferredSize=D(900, 130))
    def prod(key, t, k):
        return V('pnlCardProd' + key, [L('lblB' + key, t), L('lblHint' + key + 'K', k)], preferredSize=D(200, 80))
    prods = Gr('pnlProduk', [prod('Urea', 'Urea', 'Subsidi'), prod('Npk', 'NPK', 'Subsidi'), prod('Kakao', 'NPK untuk kakao', 'Subsidi'),
                             prod('Phonska', 'NPK Phonska', 'Subsidi'), prod('Za', 'ZA', 'Subsidi'), prod('Dolomit', 'Dolomit', 'Subsidi')], 3, 14, 14, alignmentX=0.0, maximumSize=D(W, 190), preferredSize=D(900, 180))
    def step(i, t, d): return V('pnlSoftStep' + i, [L('lblB' + i, i + '. ' + t), L('lblHint' + i, _w(d, 150))], preferredSize=D(200, 90))
    alur = Gr('pnlAlur', [step('1', 'Alokasi', 'Pengelola menetapkan kuota per kecamatan.'), step('2', 'Pengiriman', 'Gudang pusat mengirim ke penyalur.'), step('3', 'Konfirmasi', 'Penyalur memeriksa dan menerima barang.'), step('4', 'Penyaluran', 'Petani menebus sesuai kuota.')], 4, 14, 0, alignmentX=0.0, maximumSize=D(W, 110), preferredSize=D(900, 100))
    body = V('pnlBodyBeranda', [
        L('lblHPeran', 'Tiga peran, satu alur', border=E(28, 0, 10, 0)), roles,
        L('lblHProduk', 'Katalog pupuk subsidi', border=E(26, 0, 10, 0)), prods,
        L('lblHAlur', 'Alur distribusi', border=E(26, 0, 10, 0)), alur,
        L('lblHintFoot', '© 2026 AGROVA — Perusahaan Root, Samarinda', border=E(30, 0, 20, 0))], border=E(0, 40, 0, 40), con='Center')
    top = V('pnlTopBeranda', [hero, strip], con='North')
    page = Bd('pnlPageBeranda', [top, body])
    scr = N('javax.swing.JScrollPane', 'scrBodyBeranda', kids=[page], con='Center', props={'horizontalScrollBarPolicy': 31})
    h = {'btnGoldMulaiActionPerformed': '        new frmLogin().setVisible(true);\n        java.awt.Window w = javax.swing.SwingUtilities.getWindowAncestor(this);\n        if (w != null) {\n            w.dispose();\n        }',
         'btnGhostDaftarHeroActionPerformed': '        new frmDaftar().setVisible(true);\n        java.awt.Window w = javax.swing.SwingUtilities.getWindowAncestor(this);\n        if (w != null) {\n            w.dispose();\n        }'}
    gen('panel', PK, 'PgBeranda', 'Beranda', (1180, 700), [scr], ('border', {}), '        Styler.apply(this);', BASE, '', h)

def pg_tentang():
    intro = V('pnlSoftIntro', [L('lblBIntro1', 'Pupuk adalah bahan yang diberikan ke tanah atau tanaman untuk menambah unsur hara.'),
        L('lblSubIntro2', _w('Tanaman butuh nitrogen (N) untuk pertumbuhan daun dan batang, fosfor (P) untuk akar dan pembungaan, serta kalium (K) untuk ketahanan dan mutu hasil. Bila tanah kekurangan unsur ini, hasil panen turun. Pupuk bersubsidi membantu petani mendapatkan unsur tersebut dengan harga lebih terjangkau, dan AGROVA mencatat penyalurannya dari gudang pusat sampai ke tangan petani.', 740))], alignmentX=0.0, maximumSize=D(W, 150), preferredSize=D(900, 130))
    jenis = Gr('pnlJenis', [
        kartu('Urea', 'Urea', ['Sumber nitrogen tinggi (sekitar 46%).', 'Mempercepat pertumbuhan daun dan batang, umum untuk padi dan jagung.', 'HET sekitar Rp112.500 per karung 50 kg.'], 250, 170),
        kartu('Npk', 'NPK', ['Pupuk majemuk: nitrogen, fosfor, dan kalium dalam satu karung.', 'Cocok untuk pemupukan dasar berbagai tanaman pangan.', 'HET sekitar Rp112.500 per karung 50 kg.'], 250, 170),
        kartu('Kakao', 'NPK untuk kakao', ['Formula majemuk untuk tanaman kakao.', 'Mendukung pembungaan dan pembentukan buah.', 'HET sekitar Rp120.000 per karung 50 kg.'], 250, 170),
        kartu('Phonska', 'NPK Phonska', ['NPK dengan tambahan sulfur.', 'Dipakai luas pada padi, jagung, dan hortikultura.', 'HET sekitar Rp85.000 per karung 50 kg.'], 250, 170),
        kartu('Za', 'ZA (Zwavelzure Ammoniak)', ['Mengandung nitrogen dan sulfur.', 'Cocok untuk tanah yang kekurangan belerang.', 'HET sekitar Rp95.000 per karung 50 kg.'], 250, 170),
        kartu('Dolomit', 'Dolomit', ['Sumber kalsium dan magnesium.', 'Menaikkan pH tanah masam dan memperbaiki serapan hara.', 'HET sekitar Rp75.000 per karung 50 kg.'], 250, 170)], 3, 14, 14, alignmentX=0.0, maximumSize=D(W, 340), preferredSize=D(900, 330))
    def tepat(i, t, d): return V('pnlSoftTepat' + i, [L('lblB' + i, t), L('lblHint' + i, _w(d, 230))], preferredSize=D(250, 80))
    enam = Gr('pnlEnam', [tepat('Jenis', 'Tepat jenis', 'Sesuai kebutuhan tanaman.'), tepat('Jumlah', 'Tepat jumlah', 'Sesuai kuota dan luas lahan.'), tepat('Harga', 'Tepat harga', 'Sesuai HET yang ditetapkan.'),
                             tepat('Tempat', 'Tepat tempat', 'Diambil di kios penyalur kecamatan.'), tepat('Waktu', 'Tepat waktu', 'Tersedia pada musim tanam.'), tepat('Mutu', 'Tepat mutu', 'Barang baik dan sesuai standar.')], 3, 14, 14, alignmentX=0.0, maximumSize=D(W, 190), preferredSize=D(900, 180))
    hak = V('pnlCardHak', [L('lblHHak', 'Siapa yang berhak membeli'),
        L('lblSubHak1', _w('Petani yang terdaftar dengan NIK dan data lahannya. Jumlah yang boleh ditebus mengikuti kuota dan golongan petani (Gol A, B, atau C), yang berkaitan dengan luas lahan. Penebusan dilakukan di kios penyalur di kecamatan petani.', 740)),
        L('lblSubHak2', _w('Di Samarinda tersedia belasan kios penyalur yang tersebar di berbagai kecamatan. Setiap penyaluran dari gudang pusat ke kios tercatat berikut statusnya (Proses atau Selesai).', 740))], alignmentX=0.0, maximumSize=D(W, 190), preferredSize=D(900, 160))
    body = V('pnlBodyTentang', [
        L('lblTitleTentang', 'Tentang Pupuk', border=E(26, 0, 4, 0)), L('lblSubTentang', 'Mengenal pupuk subsidi yang disalurkan lewat AGROVA.', border=E(0, 0, 14, 0)), intro,
        L('lblHJenis', 'Jenis pupuk subsidi', border=E(26, 0, 10, 0)), jenis,
        L('lblHEnam', 'Prinsip enam tepat', border=E(26, 0, 10, 0)), enam,
        L('lblHHak', 'Penerima subsidi', border=E(26, 0, 10, 0)) if False else L('lblHPenerima', 'Penerima subsidi', border=E(26, 0, 10, 0)), hak,
        L('lblHintHET', 'Harga di atas adalah Harga Eceran Tertinggi (HET) per karung 50 kg dan dapat berubah sesuai ketetapan pemerintah.', border=E(14, 0, 0, 0)),
        L('lblHintFootT', '© 2026 AGROVA — Perusahaan Root, Samarinda', border=E(26, 0, 20, 0))], border=E(0, 40, 0, 40), con='North')
    page = Bd('pnlPageTentang', [body])
    scr = N('javax.swing.JScrollPane', 'scrBodyTentang', kids=[page], con='Center', props={'horizontalScrollBarPolicy': 31})
    gen('panel', PK, 'PgTentang', 'Tentang Kami', (1180, 700), [scr], ('border', {}), '        Styler.apply(this);', BASE)

def pg_rekomendasi():
    from common import C, tcard, PG, grid2
    pg = PG()
    data = [('Urea', 100, '4.710'), ('NPK untuk kakao', 96, '4.540'), ('NPK', 86, '4.060'), ('ZA', 78, '3.650'), ('NPK Phonska', 66, '3.110'), ('Dolomit', 63, '2.950')]
    rows = [Bd('pnlRowBarR%d' % i, [L('lblBR%d' % i, n, con='West', preferredSize=D(150, 24)), Bar('barR%d' % i, pct, con='Center'), L('lblHintR%d' % i, v, con='East', preferredSize=D(60, 24))], alignmentX=0.0, maximumSize=D(W, 30), border=E(3, 0, 3, 0)) for i, (n, pct, v) in enumerate(data)]
    kiri = Card('Pop', 'Pupuk subsidi paling banyak dialokasikan', rows + [L('lblHintPop', 'Berdasarkan total kuota subsidi tiap jenis pupuk.', border=E(8, 0, 0, 0))], preferredSize=D(420, 300))
    kanan = Card('Cari', 'Pupuk apa untuk tanamanku?', [
        CField('Tanaman', 'Pilih tanaman', ['Padi', 'Jagung', 'Kakao', 'Cabai', 'Sayuran daun', 'Kedelai']),
        Full(Btn('btnLihat', 'Lihat rekomendasi')),
        L('lblSpace', ' '),
        L('lblBHasil', 'Pilih tanaman lalu tekan tombol.'),
        L('lblSubHasil', _w('Rekomendasi muncul di sini.', 340))], preferredSize=D(420, 300))
    pg.h['btnLihatActionPerformed'] = """        String t = String.valueOf(cmbTanaman.getSelectedItem());
        for (Object[] r : SampleData.rekomendasi()) {
            if (r[0].equals(t)) {
                // TODO backend: ambil rekomendasi dari database bila sudah tersedia
                lblBHasil.setText("Untuk " + t + ": " + r[1] + " (utama), " + r[2] + " (pelengkap)");
                lblSubHasil.setText("<html><div style=\\"width:340px\\">" + r[3] + "</div>");
                return;
            }
        }"""
    blocks = [grid2('Rek', kiri, kanan, 340),
              tcard(pg, 'Panduan', 'Panduan pupuk per tanaman', ['Tanaman', 'Pupuk utama', 'Pupuk pelengkap', 'Catatan'], 'rekomendasi', search=False, h=260),
              L('lblHintRek', 'Panduan umum. Sesuaikan dengan kondisi lahan dan anjuran penyuluh pertanian setempat.', border=E(0, 0, 10, 0))]
    from common import mkpage
    mkpage(PK, 'PgRekomendasi', 'Rek', 'Rekomendasi Pupuk', 'Pupuk yang paling banyak dialokasikan dan yang cocok untuk tanamanmu.', blocks, pg, size=(1180, 700))

def beranda():
    pg_beranda(); pg_tentang(); pg_rekomendasi()
    nav = Bd('pnlForestNav', [L('lblBrandTop', 'AGROVA', con='West'),
        Fl('pnlNavMenu', [Tog('navBeranda', 'Beranda', preferredSize=D(130, 40)), Tog('navTentang', 'Tentang Kami', preferredSize=D(150, 40)), Tog('navRekomendasi', 'Rekomendasi', preferredSize=D(150, 40))], 1, 6, 0, con='Center'),
        L('lblSubNavKosong', ' ', con='East', preferredSize=D(60, 10))], border=E(12, 28, 12, 28), con='North')
    host = P('pnlPages', [], ('card',), con='Center')
    h = {}
    post = """        Styler.applyFrame(this);
        Styler.icon(navBeranda, Icons.Name.HOME);
        Styler.icon(navTentang, Icons.Name.LEAF);
        Styler.icon(navRekomendasi, Icons.Name.SPROUT);
        Nav.bind(pnlPages, new javax.swing.JToggleButton[]{navBeranda, navTentang, navRekomendasi}, new javax.swing.JPanel[]{new PgBeranda(), new PgTentang(), new PgRekomendasi()});"""
    gen('frame', PK, 'frmBeranda', 'AGROVA — Beranda', (1200, 760), [nav, host], ('border', {}), post, BASE, '', h)
if __name__ == '__main__':
    login(); daftar(); beranda()
