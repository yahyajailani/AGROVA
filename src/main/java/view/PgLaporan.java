package view;

import controller.GuiController;
import view.util.*;

/** Laporan. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgLaporan extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgLaporan() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        DatePicker.pasang(txtDari);   // pilih tanggal lewat kalender, tanpa ketik manual
        DatePicker.pasang(txtSampai);
        ((javax.swing.table.DefaultTableModel) tblLaporan.getModel()).setColumnIdentifiers(
                new String[]{"No. Penyaluran", "Tanggal kirim", "Kategori", "Produk", "Kecamatan", "Jumlah (kg)", "Tanggal terima", "Status"});
        TableKit.muat(tblLaporan, () -> GuiController.laporan(null, null, null, null));
        lblSubLap.setText("Rekap penyaluran periode tertentu. ");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeaderLap = new javax.swing.JPanel();
        pnlTitlesLap = new javax.swing.JPanel();
        lblTitleLap = new javax.swing.JLabel();
        lblSubLap = new javax.swing.JLabel();
        pnlTopLap = new javax.swing.JPanel();
        scrBodyLap = new javax.swing.JScrollPane();
        pnlOuterLap = new javax.swing.JPanel();
        pnlStackLap = new javax.swing.JPanel();
        pnlGapLap0 = new javax.swing.JPanel();
        pnlCardFilter = new javax.swing.JPanel();
        pnlHeadFilter = new javax.swing.JPanel();
        lblHFilter = new javax.swing.JLabel();
        pnlGridLap = new javax.swing.JPanel();
        pnlFDari = new javax.swing.JPanel();
        lblFieldDari = new javax.swing.JLabel();
        txtDari = new javax.swing.JTextField();
        lblHintDari = new javax.swing.JLabel();
        pnlFSampai = new javax.swing.JPanel();
        lblFieldSampai = new javax.swing.JLabel();
        txtSampai = new javax.swing.JTextField();
        lblHintSampai = new javax.swing.JLabel();
        pnlFProduk = new javax.swing.JPanel();
        lblFieldProduk = new javax.swing.JLabel();
        cmbProduk = new javax.swing.JComboBox();
        lblHintProduk = new javax.swing.JLabel();
        pnlFKec = new javax.swing.JPanel();
        lblFieldKec = new javax.swing.JLabel();
        cmbKec = new javax.swing.JComboBox();
        lblHintKec = new javax.swing.JLabel();
        pnlActLap = new javax.swing.JPanel();
        btnTampil = new javax.swing.JButton();
        pnlGapLap1 = new javax.swing.JPanel();
        pnlCardLaporan = new javax.swing.JPanel();
        pnlHeadLaporan = new javax.swing.JPanel();
        lblHLaporan = new javax.swing.JLabel();
        scrLaporan = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderLap.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderLap.setOpaque(false);
        pnlHeaderLap.setLayout(new java.awt.BorderLayout());

        pnlTitlesLap.setAlignmentX(0.0F);
        pnlTitlesLap.setOpaque(false);
        pnlTitlesLap.setLayout(new javax.swing.BoxLayout(pnlTitlesLap, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitleLap.setText("Laporan");
        lblTitleLap.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitleLap.setForeground(new java.awt.Color(29, 42, 34));
        pnlTitlesLap.add(lblTitleLap);

        lblSubLap.setText("Rekap penyaluran periode tertentu.");
        lblSubLap.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubLap.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesLap.add(lblSubLap);

        pnlHeaderLap.add(pnlTitlesLap, java.awt.BorderLayout.WEST);

        pnlTopLap.setOpaque(false);
        pnlTopLap.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderLap.add(pnlTopLap, java.awt.BorderLayout.EAST);

        add(pnlHeaderLap, java.awt.BorderLayout.NORTH);

        scrBodyLap.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterLap.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterLap.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterLap.setLayout(new java.awt.BorderLayout());

        pnlStackLap.setAlignmentX(0.0F);
        pnlStackLap.setOpaque(false);
        pnlStackLap.setLayout(new javax.swing.BoxLayout(pnlStackLap, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapLap0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapLap0.setAlignmentX(0.0F);
        pnlGapLap0.setOpaque(false);
        pnlGapLap0.setLayout(new java.awt.BorderLayout());

        pnlCardFilter.setAlignmentX(0.0F);
        pnlCardFilter.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardFilter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardFilter.setLayout(new javax.swing.BoxLayout(pnlCardFilter, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadFilter.setAlignmentX(0.0F);
        pnlHeadFilter.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadFilter.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadFilter.setOpaque(false);
        pnlHeadFilter.setLayout(new java.awt.BorderLayout());

        lblHFilter.setText("Filter laporan");
        lblHFilter.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHFilter.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadFilter.add(lblHFilter, java.awt.BorderLayout.WEST);

        pnlCardFilter.add(pnlHeadFilter);

        pnlGridLap.setAlignmentX(0.0F);
        pnlGridLap.setMaximumSize(new java.awt.Dimension(4000, 200));
        pnlGridLap.setPreferredSize(new java.awt.Dimension(700, 200));
        pnlGridLap.setOpaque(false);
        pnlGridLap.setLayout(new java.awt.GridLayout(0, 2, 16, 0));

        pnlFDari.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFDari.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFDari.setAlignmentX(0.0F);
        pnlFDari.setOpaque(false);
        pnlFDari.setLayout(new javax.swing.BoxLayout(pnlFDari, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldDari.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldDari.setText("Dari tanggal");
        lblFieldDari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldDari.setForeground(new java.awt.Color(29, 42, 34));
        pnlFDari.add(lblFieldDari);

        txtDari.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtDari.setAlignmentX(0.0F);
        txtDari.setPreferredSize(new java.awt.Dimension(220, 42));
        txtDari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDari.setForeground(new java.awt.Color(29, 42, 34));
        pnlFDari.add(txtDari);

        lblHintDari.setText("Klik untuk memilih tanggal");
        lblHintDari.setForeground(new java.awt.Color(122, 127, 115));
        pnlFDari.add(lblHintDari);

        pnlGridLap.add(pnlFDari);

        pnlFSampai.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFSampai.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFSampai.setAlignmentX(0.0F);
        pnlFSampai.setOpaque(false);
        pnlFSampai.setLayout(new javax.swing.BoxLayout(pnlFSampai, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldSampai.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldSampai.setText("Sampai tanggal");
        lblFieldSampai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldSampai.setForeground(new java.awt.Color(29, 42, 34));
        pnlFSampai.add(lblFieldSampai);

        txtSampai.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtSampai.setAlignmentX(0.0F);
        txtSampai.setPreferredSize(new java.awt.Dimension(220, 42));
        txtSampai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSampai.setForeground(new java.awt.Color(29, 42, 34));
        pnlFSampai.add(txtSampai);

        lblHintSampai.setText("Klik untuk memilih tanggal");
        lblHintSampai.setForeground(new java.awt.Color(122, 127, 115));
        pnlFSampai.add(lblHintSampai);

        pnlGridLap.add(pnlFSampai);

        pnlFProduk.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFProduk.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFProduk.setAlignmentX(0.0F);
        pnlFProduk.setOpaque(false);
        pnlFProduk.setLayout(new javax.swing.BoxLayout(pnlFProduk, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldProduk.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldProduk.setText("Produk");
        lblFieldProduk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldProduk.setForeground(new java.awt.Color(29, 42, 34));
        pnlFProduk.add(lblFieldProduk);

        cmbProduk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbProduk.setForeground(new java.awt.Color(29, 42, 34));
        cmbProduk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semua", "Urea Subsidi ", "NPK Subsidi ", "NPK untuk kakao Subsidi ", "NPK Phonska Subsidi ", "ZA Subsidi     ", "Dolomit Subsidi", "Urea nonsubsidi", "NPK nonsubsidi ", "SP-36 nonsubsidi ", "ZA nonsubsidi ", "KCl nonsubsidi ", "TSP nonsubsidi ", "DAP nonsubsidi " }));
        cmbProduk.setAlignmentX(0.0F);
        cmbProduk.setMaximumSize(new java.awt.Dimension(4000, 42));
        cmbProduk.setPreferredSize(new java.awt.Dimension(220, 42));
        cmbProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdukActionPerformed(evt);
            }
        });
        pnlFProduk.add(cmbProduk);

        lblHintProduk.setText(" ");
        lblHintProduk.setForeground(new java.awt.Color(122, 127, 115));
        pnlFProduk.add(lblHintProduk);

        pnlGridLap.add(pnlFProduk);

        pnlFKec.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFKec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFKec.setAlignmentX(0.0F);
        pnlFKec.setOpaque(false);
        pnlFKec.setLayout(new javax.swing.BoxLayout(pnlFKec, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldKec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldKec.setText("Kecamatan");
        lblFieldKec.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldKec.setForeground(new java.awt.Color(29, 42, 34));
        pnlFKec.add(lblFieldKec);

        cmbKec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbKec.setForeground(new java.awt.Color(29, 42, 34));
        cmbKec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semua", "Loa Janan Ilir", "Palaran", "Samarinda Ilir", "Samarinda Kota", "Samarinda Seberang", "Samarinda Ulu", "Samarinda Utara", "Sambutan", "Sungai Kunjang", "Sungai Pinang" }));
        cmbKec.setAlignmentX(0.0F);
        cmbKec.setMaximumSize(new java.awt.Dimension(4000, 42));
        cmbKec.setPreferredSize(new java.awt.Dimension(220, 42));
        pnlFKec.add(cmbKec);

        lblHintKec.setText(" ");
        lblHintKec.setForeground(new java.awt.Color(122, 127, 115));
        pnlFKec.add(lblHintKec);

        pnlGridLap.add(pnlFKec);

        pnlCardFilter.add(pnlGridLap);

        pnlActLap.setAlignmentX(0.0F);
        pnlActLap.setMaximumSize(new java.awt.Dimension(4000, 48));
        pnlActLap.setOpaque(false);
        pnlActLap.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnTampil.setText("Tampilkan");
        btnTampil.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTampil.setForeground(new java.awt.Color(255, 255, 255));
        btnTampil.setBackground(new java.awt.Color(31, 77, 58));
        btnTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilActionPerformed(evt);
            }
        });
        pnlActLap.add(btnTampil);

        pnlCardFilter.add(pnlActLap);

        pnlGapLap0.add(pnlCardFilter, java.awt.BorderLayout.CENTER);

        pnlStackLap.add(pnlGapLap0);

        pnlGapLap1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapLap1.setAlignmentX(0.0F);
        pnlGapLap1.setOpaque(false);
        pnlGapLap1.setLayout(new java.awt.BorderLayout());

        pnlCardLaporan.setAlignmentX(0.0F);
        pnlCardLaporan.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardLaporan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardLaporan.setLayout(new javax.swing.BoxLayout(pnlCardLaporan, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadLaporan.setAlignmentX(0.0F);
        pnlHeadLaporan.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadLaporan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadLaporan.setOpaque(false);
        pnlHeadLaporan.setLayout(new java.awt.BorderLayout());

        lblHLaporan.setText("Hasil laporan");
        lblHLaporan.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHLaporan.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadLaporan.add(lblHLaporan, java.awt.BorderLayout.WEST);

        pnlCardLaporan.add(pnlHeadLaporan);

        scrLaporan.setPreferredSize(new java.awt.Dimension(600, 300));
        scrLaporan.setMaximumSize(new java.awt.Dimension(4000, 300));
        scrLaporan.setAlignmentX(0.0F);

        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Penyaluran", "Tanggal", "Kategori", "Produk", "Kecamatan", "Jumlah (kg)", "Tanggal terima", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLaporanMouseClicked(evt);
            }
        });
        scrLaporan.setViewportView(tblLaporan);

        pnlCardLaporan.add(scrLaporan);

        pnlGapLap1.add(pnlCardLaporan, java.awt.BorderLayout.CENTER);

        pnlStackLap.add(pnlGapLap1);

        pnlOuterLap.add(pnlStackLap, java.awt.BorderLayout.NORTH);

        scrBodyLap.setViewportView(pnlOuterLap);

        add(scrBodyLap, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilActionPerformed
        String re = "\\d{1,2}-\\d{1,2}-\\d{4}";
        lblHintDari.setText("Klik untuk memilih tanggal");
        lblHintSampai.setText("Klik untuk memilih tanggal");
        boolean ok = true;
        if (!txtDari.getText().matches(re)) {
            lblHintDari.setText("Pilih tanggal awal");
            ok = false;
        }
        if (!txtSampai.getText().matches(re)) {
            lblHintSampai.setText("Pilih tanggal akhir");
            ok = false;
        }
        if (!ok) {
            return;
        }
        java.time.format.DateTimeFormatter f = java.time.format.DateTimeFormatter.ofPattern("d-M-uuuu").withResolverStyle(java.time.format.ResolverStyle.STRICT);
        java.time.LocalDate dari;
        java.time.LocalDate sampai;
        try {
            dari = java.time.LocalDate.parse(txtDari.getText(), f);
            sampai = java.time.LocalDate.parse(txtSampai.getText(), f);
        } catch (java.time.format.DateTimeParseException e) {
            lblHintDari.setText("Tanggal tidak valid");
            return;
        }
        if (sampai.isBefore(dari)) {
            lblHintSampai.setText("Harus setelah tanggal awal");
            return;
        }
        String produk = String.valueOf(cmbProduk.getSelectedItem());
        String kec = String.valueOf(cmbKec.getSelectedItem());
        TableKit.muat(tblLaporan, () -> GuiController.laporan(dari, sampai, produk, kec));
    }//GEN-LAST:event_btnTampilActionPerformed

    private static String potong(Object v, int maks) {
        String t = String.valueOf(v);
        return t.length() <= maks ? t : t.substring(0, maks - 1) + "~";
    }

    private void tblLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLaporanMouseClicked
        // nota dicetak oleh penyalur (menu Riwayat), bukan dari halaman laporan pengelola
    }//GEN-LAST:event_tblLaporanMouseClicked

    private void cmbProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProdukActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTampil;
    private javax.swing.JComboBox cmbKec;
    private javax.swing.JComboBox cmbProduk;
    private javax.swing.JLabel lblFieldDari;
    private javax.swing.JLabel lblFieldKec;
    private javax.swing.JLabel lblFieldProduk;
    private javax.swing.JLabel lblFieldSampai;
    private javax.swing.JLabel lblHFilter;
    private javax.swing.JLabel lblHLaporan;
    private javax.swing.JLabel lblHintDari;
    private javax.swing.JLabel lblHintKec;
    private javax.swing.JLabel lblHintProduk;
    private javax.swing.JLabel lblHintSampai;
    private javax.swing.JLabel lblSubLap;
    private javax.swing.JLabel lblTitleLap;
    private javax.swing.JPanel pnlActLap;
    private javax.swing.JPanel pnlCardFilter;
    private javax.swing.JPanel pnlCardLaporan;
    private javax.swing.JPanel pnlFDari;
    private javax.swing.JPanel pnlFKec;
    private javax.swing.JPanel pnlFProduk;
    private javax.swing.JPanel pnlFSampai;
    private javax.swing.JPanel pnlGapLap0;
    private javax.swing.JPanel pnlGapLap1;
    private javax.swing.JPanel pnlGridLap;
    private javax.swing.JPanel pnlHeadFilter;
    private javax.swing.JPanel pnlHeadLaporan;
    private javax.swing.JPanel pnlHeaderLap;
    private javax.swing.JPanel pnlOuterLap;
    private javax.swing.JPanel pnlStackLap;
    private javax.swing.JPanel pnlTitlesLap;
    private javax.swing.JPanel pnlTopLap;
    private javax.swing.JScrollPane scrBodyLap;
    private javax.swing.JScrollPane scrLaporan;
    private javax.swing.JTable tblLaporan;
    private javax.swing.JTextField txtDari;
    private javax.swing.JTextField txtSampai;
    // End of variables declaration//GEN-END:variables
}
