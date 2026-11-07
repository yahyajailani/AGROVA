from dsl import *
C = dict(
 penyaluran=['No. Penyaluran', 'Tanggal', 'Kategori', 'Produk', 'Kecamatan', 'Jumlah (kg)', 'Bukti', 'Status'],
 ringkas=['No. Penyaluran', 'Produk', 'Kecamatan', 'Jumlah (kg)', 'Status'],
 kuota=['Kecamatan', 'Produk', 'Tahun', 'Kuota (kg)', 'Terpakai (kg)', 'Sisa (kg)'],
 petani=['NIK', 'Nama', 'Kecamatan', 'Luas (ha)', 'Email', 'Terdaftar'],
 ketersediaan=['Produk', 'Kategori', 'Stok gudang (kg)', 'Dialokasikan (kg)', 'Menunggu (kg)'],
 pantau=['Kecamatan', 'Produk', 'Kuota', 'Terpakai', 'Dikirim', 'Dipesan', 'Sisa', 'Terserap'],
 penyalur=['Nama', 'Email', 'Kecamatan', 'Pengiriman', 'Selesai', 'Terdaftar'],
 pp=['No. Transaksi', 'Tanggal', 'Kategori', 'Produk', 'Kecamatan', 'NIK', 'Petani', 'Jumlah (kg)', 'Jenis', 'Status'],
 masuk=['No. Penyaluran', 'Tanggal', 'Kategori', 'Produk', 'Jumlah (kg)', 'Bukti', 'Status', 'Diterima'],
 menunggu=['No. Transaksi', 'Tanggal', 'Kategori', 'Produk', 'NIK', 'Petani', 'Jumlah (kg)', 'Stok (kg)'],
 notif=['Waktu', 'Judul', 'Isi', 'Status'],
 kuotaPetani=['Produk', 'Kuota (kg)', 'Terpakai (kg)', 'Sisa (kg)'],
 stokKec=['Produk', 'Kategori', 'Stok (kg)', 'Dipesan (kg)', 'Tersedia (kg)'],
 stokTersedia=['Produk', 'Kategori', 'Harga (Rp/kg)', 'Tersedia (kg)'],
 riwP=['No. Transaksi', 'Tanggal', 'Kategori', 'Produk', 'NIK', 'Petani', 'Jumlah (kg)', 'Jenis', 'Status'],
 pesananSaya=['No. Transaksi', 'Tanggal', 'Kategori', 'Produk', 'Kecamatan', 'Jumlah (kg)', 'Status'],
 riwPetani=['No. Transaksi', 'Tanggal', 'Kategori', 'Produk', 'Kecamatan', 'Jumlah (kg)', 'Penyalur'],
)
KEC = ['Samarinda Ulu', 'Samarinda Utara', 'Samarinda Ilir', 'Samarinda Kota', 'Samarinda Seberang', 'Sungai Kunjang', 'Palaran', 'Loa Janan Ilir', 'Sambutan', 'Sambutan Baru', 'Sempaja Selatan', 'Mugirejo', 'Air Putih', 'Sidodadi', 'Teluk Lerong', 'Baqa']
PROD = ['Urea Subsidi', 'NPK Phonska', 'Pupuk Organik Subsidi']
class PG:
    """Pengumpul post-init untuk satu halaman."""
    def __init__(s): s.post = []; s.h = {}
    def fill(s, tbl, call): s.post.append(f'        TableKit.fill(tbl{tbl}, SampleData.{call}());')
    def code(s, c): s.post.append(c)
def tcard(pg, key, title, cols, call, btns=(), search=True, h=230, sub=None):
    tool = []
    if search: tool += [Tx('txtCari' + key, preferredSize=D(260, 40)), Btn('btnCari' + key, 'Cari')]
    tool += list(btns)
    ks = []
    if tool: ks.append(Fl('pnlTool' + key, tool, 0, 8, 0, alignmentX=0.0, maximumSize=D(W, 52)))
    ks.append(Tbl(key, cols, h))
    pg.fill(key, call)
    if search: pg.code(f'        InputFilters.keyword(txtCari{key}, 40);')
    return Card(key, title, ks, sub)
def stats(key, items):
    return Gr('pnlStats' + key, [Stat(f'{key}{i}', *it) for i, it in enumerate(items)], len(items), 14, 0, alignmentX=0.0, maximumSize=D(W, 130), preferredSize=D(900, 120))
def grid2(key, a, b, h=300):
    return Gr('pnlDua' + key, [a, b], 2, 16, 0, alignmentX=0.0, maximumSize=D(W, h), preferredSize=D(900, h))
def mkpage(pkg, cls, key, title, sub, blocks, pg, actions=(), size=(980, 700)):
    kids = Page(key, title, sub, [Blk(f'{key}{i}', b, 16) for i, b in enumerate(blocks)], actions)
    gen('panel', pkg, cls, title, size, kids, ('border', {}), '        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));\n        Styler.apply(this);\n' + '\n'.join(pg.post), BASE, '', pg.h)
def Frm(key, fields, btns, title=None):
    ks = [Gr('pnlGrid' + key, fields, 2, 16, 0, alignmentX=0.0, maximumSize=D(W, 100 * ((len(fields) + 1) // 2)), preferredSize=D(700, 100 * ((len(fields) + 1) // 2))), Act(key, btns)]
    return ks
def shell(pkg, cls, title, role, sub, navs, pages, dark, user, handlers_extra=None):
    items = [Tog('nav' + k, lab, ev=False, alignmentX=0.0, maximumSize=D(W, 44), preferredSize=D(200, 44)) for k, lab, ic in navs]
    side_top = V('pnlNavTop', [L('lblBrand', 'AGROVA', border=E(0, 4, 0, 0)), L('lblLightSubRole', role, border=E(2, 4, 24, 0))] + items, con='North')
    keluar = Tog('navKeluar', 'Keluar', ev=True, alignmentX=0.0, preferredSize=D(200, 44))
    side_bot = V('pnlNavBot', [keluar], con='South')
    side = Bd('pnlSidebar', [side_top, side_bot], con='West', preferredSize=D(236, 700), border=E(26, 18, 22, 18))
    top = Bd('pnlTopbar', [L('lblSubSalam', user, con='West'), Fl('pnlTopAct', [Btn('btnGhostNotif', 'Notifikasi')], 2, 8, 0, con='East')], con='North', border=E(14, 28, 4, 28))
    pages_host = P('pnlPages', [], ('card',), con='Center')
    main = Bd('pnlMain', [top, pages_host], con='Center')
    h = {'navKeluarActionPerformed': '        if (Dialogs.confirm(this, "Keluar dari AGROVA?")) {\n            new agrova.ui.guest.frmLogin().setVisible(true);\n            dispose();\n        }',
         'btnGhostNotifActionPerformed': '        new agrova.ui.dialog.dlgNotifikasi(this, true).setVisible(true);'}
    icons = '\n'.join(f'        Styler.icon(nav{k}, Icons.Name.{ic});' for k, lab, ic in navs)
    arr = ', '.join('nav' + k for k, _, _ in navs)
    pgs = ', '.join(f'new {p}()' for p in pages)
    post = f'''        Styler.applyFrame(this);
        Styler.sidebar(pnlSidebar, {dark});
{icons}
        Styler.icon(navKeluar, Icons.Name.LOGOUT);
        Styler.icon(btnGhostNotif, Icons.Name.BELL);
        Nav.bind(pnlPages, new javax.swing.JToggleButton[]{{{arr}}}, new javax.swing.JPanel[]{{{pgs}}});'''
    gen('frame', pkg, cls, title, (1280, 780), [side, main], ('border', {}), post, BASE, '', h, imports=f'import {pkg}.*;\n')
