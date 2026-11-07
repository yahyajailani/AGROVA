package view;

import controller.GuiController;
import view.util.*;

/** Konfirmasi. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgKonfirmasi extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgKonfirmasi() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        TableKit.muat(tblMasuk, GuiController::pengirimanMasuk);
        InputFilters.keyword(txtCariMasuk, 40);
        TableKit.muat(tblMenunggu, GuiController::pesananMenunggu);
        InputFilters.keyword(txtCariMenunggu, 40);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeaderKf = new javax.swing.JPanel();
        pnlTitlesKf = new javax.swing.JPanel();
        lblTitleKf = new javax.swing.JLabel();
        lblSubKf = new javax.swing.JLabel();
        pnlTopKf = new javax.swing.JPanel();
        scrBodyKf = new javax.swing.JScrollPane();
        pnlOuterKf = new javax.swing.JPanel();
        pnlStackKf = new javax.swing.JPanel();
        pnlGapKf0 = new javax.swing.JPanel();
        tabKonf = new javax.swing.JTabbedPane();
        pnlTabMasuk = new javax.swing.JPanel();
        pnlCardMasuk = new javax.swing.JPanel();
        pnlHeadMasuk = new javax.swing.JPanel();
        lblHMasuk = new javax.swing.JLabel();
        pnlToolMasuk = new javax.swing.JPanel();
        txtCariMasuk = new javax.swing.JTextField();
        btnCariMasuk = new javax.swing.JButton();
        btnTerima = new javax.swing.JButton();
        btnGhostTolak = new javax.swing.JButton();
        scrMasuk = new javax.swing.JScrollPane();
        tblMasuk = new javax.swing.JTable();
        pnlTabMenunggu = new javax.swing.JPanel();
        pnlCardMenunggu = new javax.swing.JPanel();
        pnlHeadMenunggu = new javax.swing.JPanel();
        lblHMenunggu = new javax.swing.JLabel();
        pnlToolMenunggu = new javax.swing.JPanel();
        txtCariMenunggu = new javax.swing.JTextField();
        btnCariMenunggu = new javax.swing.JButton();
        btnSetuju = new javax.swing.JButton();
        btnGhostTolakP = new javax.swing.JButton();
        scrMenunggu = new javax.swing.JScrollPane();
        tblMenunggu = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderKf.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderKf.setOpaque(false);
        pnlHeaderKf.setLayout(new java.awt.BorderLayout());

        pnlTitlesKf.setAlignmentX(0.0F);
        pnlTitlesKf.setOpaque(false);
        pnlTitlesKf.setLayout(new javax.swing.BoxLayout(pnlTitlesKf, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitleKf.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitleKf.setForeground(new java.awt.Color(29, 42, 34));
        lblTitleKf.setText("Verifikasi");
        pnlTitlesKf.add(lblTitleKf);

        lblSubKf.setText("Terima kiriman dan setujui pesanan petani.");
        lblSubKf.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubKf.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesKf.add(lblSubKf);

        pnlHeaderKf.add(pnlTitlesKf, java.awt.BorderLayout.WEST);

        pnlTopKf.setOpaque(false);
        pnlTopKf.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderKf.add(pnlTopKf, java.awt.BorderLayout.EAST);

        add(pnlHeaderKf, java.awt.BorderLayout.NORTH);

        scrBodyKf.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterKf.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterKf.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterKf.setLayout(new java.awt.BorderLayout());

        pnlStackKf.setAlignmentX(0.0F);
        pnlStackKf.setOpaque(false);
        pnlStackKf.setLayout(new javax.swing.BoxLayout(pnlStackKf, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapKf0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapKf0.setAlignmentX(0.0F);
        pnlGapKf0.setOpaque(false);
        pnlGapKf0.setLayout(new java.awt.BorderLayout());

        tabKonf.setAlignmentX(0.0F);
        tabKonf.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tabKonf.setMaximumSize(new java.awt.Dimension(4000, 480));
        tabKonf.setPreferredSize(new java.awt.Dimension(700, 480));

        pnlTabMasuk.setAlignmentX(0.0F);
        pnlTabMasuk.setOpaque(false);
        pnlTabMasuk.setLayout(new javax.swing.BoxLayout(pnlTabMasuk, javax.swing.BoxLayout.PAGE_AXIS));

        pnlCardMasuk.setAlignmentX(0.0F);
        pnlCardMasuk.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardMasuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardMasuk.setLayout(new javax.swing.BoxLayout(pnlCardMasuk, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadMasuk.setAlignmentX(0.0F);
        pnlHeadMasuk.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadMasuk.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadMasuk.setOpaque(false);
        pnlHeadMasuk.setLayout(new java.awt.BorderLayout());

        lblHMasuk.setText("Pengiriman dari gudang");
        lblHMasuk.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHMasuk.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadMasuk.add(lblHMasuk, java.awt.BorderLayout.WEST);

        pnlCardMasuk.add(pnlHeadMasuk);

        pnlToolMasuk.setAlignmentX(0.0F);
        pnlToolMasuk.setMaximumSize(new java.awt.Dimension(4000, 52));
        pnlToolMasuk.setOpaque(false);
        pnlToolMasuk.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCariMasuk.setPreferredSize(new java.awt.Dimension(260, 40));
        txtCariMasuk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCariMasuk.setForeground(new java.awt.Color(29, 42, 34));
        pnlToolMasuk.add(txtCariMasuk);

        btnCariMasuk.setText("Cari");
        btnCariMasuk.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCariMasuk.setForeground(new java.awt.Color(255, 255, 255));
        btnCariMasuk.setBackground(new java.awt.Color(31, 77, 58));
        btnCariMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariMasukActionPerformed(evt);
            }
        });
        pnlToolMasuk.add(btnCariMasuk);

        btnTerima.setText("Terima");
        btnTerima.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTerima.setForeground(new java.awt.Color(255, 255, 255));
        btnTerima.setBackground(new java.awt.Color(31, 77, 58));
        btnTerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerimaActionPerformed(evt);
            }
        });
        pnlToolMasuk.add(btnTerima);

        btnGhostTolak.setText("Tolak");
        btnGhostTolak.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostTolak.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostTolak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostTolakActionPerformed(evt);
            }
        });
        pnlToolMasuk.add(btnGhostTolak);

        pnlCardMasuk.add(pnlToolMasuk);

        scrMasuk.setPreferredSize(new java.awt.Dimension(600, 300));
        scrMasuk.setMaximumSize(new java.awt.Dimension(4000, 300));
        scrMasuk.setAlignmentX(0.0F);

        tblMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Penyaluran", "Tanggal", "Kategori", "Produk", "Jumlah (kg)", "Status", "Diterima"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrMasuk.setViewportView(tblMasuk);

        pnlCardMasuk.add(scrMasuk);

        pnlTabMasuk.add(pnlCardMasuk);

        tabKonf.addTab("Pengiriman masuk", pnlTabMasuk);

        pnlTabMenunggu.setAlignmentX(0.0F);
        pnlTabMenunggu.setOpaque(false);
        pnlTabMenunggu.setLayout(new javax.swing.BoxLayout(pnlTabMenunggu, javax.swing.BoxLayout.PAGE_AXIS));

        pnlCardMenunggu.setAlignmentX(0.0F);
        pnlCardMenunggu.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardMenunggu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardMenunggu.setLayout(new javax.swing.BoxLayout(pnlCardMenunggu, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadMenunggu.setAlignmentX(0.0F);
        pnlHeadMenunggu.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadMenunggu.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadMenunggu.setOpaque(false);
        pnlHeadMenunggu.setLayout(new java.awt.BorderLayout());

        lblHMenunggu.setText("Pesanan diproses");
        lblHMenunggu.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHMenunggu.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadMenunggu.add(lblHMenunggu, java.awt.BorderLayout.WEST);

        pnlCardMenunggu.add(pnlHeadMenunggu);

        pnlToolMenunggu.setAlignmentX(0.0F);
        pnlToolMenunggu.setMaximumSize(new java.awt.Dimension(4000, 52));
        pnlToolMenunggu.setOpaque(false);
        pnlToolMenunggu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCariMenunggu.setPreferredSize(new java.awt.Dimension(260, 40));
        txtCariMenunggu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCariMenunggu.setForeground(new java.awt.Color(29, 42, 34));
        pnlToolMenunggu.add(txtCariMenunggu);

        btnCariMenunggu.setText("Cari");
        btnCariMenunggu.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCariMenunggu.setForeground(new java.awt.Color(255, 255, 255));
        btnCariMenunggu.setBackground(new java.awt.Color(31, 77, 58));
        btnCariMenunggu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariMenungguActionPerformed(evt);
            }
        });
        pnlToolMenunggu.add(btnCariMenunggu);

        btnSetuju.setText("Terima");
        btnSetuju.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSetuju.setForeground(new java.awt.Color(255, 255, 255));
        btnSetuju.setBackground(new java.awt.Color(31, 77, 58));
        btnSetuju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetujuActionPerformed(evt);
            }
        });
        pnlToolMenunggu.add(btnSetuju);

        btnGhostTolakP.setText("Tolak");
        btnGhostTolakP.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostTolakP.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostTolakP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostTolakPActionPerformed(evt);
            }
        });
        pnlToolMenunggu.add(btnGhostTolakP);

        pnlCardMenunggu.add(pnlToolMenunggu);

        scrMenunggu.setPreferredSize(new java.awt.Dimension(600, 300));
        scrMenunggu.setMaximumSize(new java.awt.Dimension(4000, 300));
        scrMenunggu.setAlignmentX(0.0F);

        tblMenunggu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Transaksi", "Tanggal", "Kategori", "Produk", "NIK", "Petani", "Jumlah (kg)", "Stok (kg)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrMenunggu.setViewportView(tblMenunggu);

        pnlCardMenunggu.add(scrMenunggu);

        pnlTabMenunggu.add(pnlCardMenunggu);

        tabKonf.addTab("Pesanan petani", pnlTabMenunggu);

        pnlGapKf0.add(tabKonf, java.awt.BorderLayout.CENTER);

        pnlStackKf.add(pnlGapKf0);

        pnlOuterKf.add(pnlStackKf, java.awt.BorderLayout.NORTH);

        scrBodyKf.setViewportView(pnlOuterKf);

        add(scrBodyKf, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariMasukActionPerformed
        TableKit.cari(tblMasuk, txtCariMasuk.getText());
    }//GEN-LAST:event_btnCariMasukActionPerformed

    private void btnTerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerimaActionPerformed
        if (tblMasuk.getSelectedRow() < 0) {
            Dialogs.info(this, "Pilih pengiriman terlebih dahulu.");
            return;
        }
        String kode = TableKit.pilih(tblMasuk, 0);
        if (!Dialogs.confirm(this, "Pastikan pupuk fisik sudah sesuai. Konfirmasi penerimaan " + kode + "?")) {
            return;
        }
        if (Dialogs.coba(this, () -> GuiController.terimaPengiriman(kode))) {
            Dialogs.info(this, "Pengiriman " + kode + " dikonfirmasi. Stok kios bertambah.");
            TableKit.muat(tblMasuk, GuiController::pengirimanMasuk);
        }
    }//GEN-LAST:event_btnTerimaActionPerformed

    private void btnGhostTolakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostTolakActionPerformed
        Dialogs.info(this, "Penolakan pengiriman dari gudang belum didukung oleh database AGROVA.\n"
                + "Hubungi pengelola bila ada ketidaksesuaian pupuk, lalu jangan konfirmasi pengiriman tersebut.");
    }//GEN-LAST:event_btnGhostTolakActionPerformed

    private void btnCariMenungguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariMenungguActionPerformed
        TableKit.cari(tblMenunggu, txtCariMenunggu.getText());
    }//GEN-LAST:event_btnCariMenungguActionPerformed

    private void btnSetujuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetujuActionPerformed
        if (tblMenunggu.getSelectedRow() < 0) {
            Dialogs.info(this, "Pilih pesanan terlebih dahulu.");
            return;
        }
        String kode = TableKit.pilih(tblMenunggu, 0);
        if (Dialogs.coba(this, () -> GuiController.setujuiPesanan(kode))) {
            Dialogs.info(this, "Pesanan " + kode + " diterima. Stok kios dikurangi.");
            TableKit.muat(tblMenunggu, GuiController::pesananMenunggu);
        }
    }//GEN-LAST:event_btnSetujuActionPerformed

    private void btnGhostTolakPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostTolakPActionPerformed
        String kode = TableKit.pilih(tblMenunggu, 0);
        if (kode == null) {
            Dialogs.info(this, "Pilih pesanan terlebih dahulu.");
            return;
        }
        if (Dialogs.confirm(this, "Tolak pesanan " + kode + "?") && Dialogs.coba(this, () -> GuiController.tolakPesanan(kode))) {
            TableKit.muat(tblMenunggu, GuiController::pesananMenunggu);
        }
    }//GEN-LAST:event_btnGhostTolakPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariMasuk;
    private javax.swing.JButton btnCariMenunggu;
    private javax.swing.JButton btnGhostTolak;
    private javax.swing.JButton btnGhostTolakP;
    private javax.swing.JButton btnSetuju;
    private javax.swing.JButton btnTerima;
    private javax.swing.JLabel lblHMasuk;
    private javax.swing.JLabel lblHMenunggu;
    private javax.swing.JLabel lblSubKf;
    private javax.swing.JLabel lblTitleKf;
    private javax.swing.JPanel pnlCardMasuk;
    private javax.swing.JPanel pnlCardMenunggu;
    private javax.swing.JPanel pnlGapKf0;
    private javax.swing.JPanel pnlHeadMasuk;
    private javax.swing.JPanel pnlHeadMenunggu;
    private javax.swing.JPanel pnlHeaderKf;
    private javax.swing.JPanel pnlOuterKf;
    private javax.swing.JPanel pnlStackKf;
    private javax.swing.JPanel pnlTabMasuk;
    private javax.swing.JPanel pnlTabMenunggu;
    private javax.swing.JPanel pnlTitlesKf;
    private javax.swing.JPanel pnlToolMasuk;
    private javax.swing.JPanel pnlToolMenunggu;
    private javax.swing.JPanel pnlTopKf;
    private javax.swing.JScrollPane scrBodyKf;
    private javax.swing.JScrollPane scrMasuk;
    private javax.swing.JScrollPane scrMenunggu;
    private javax.swing.JTabbedPane tabKonf;
    private javax.swing.JTable tblMasuk;
    private javax.swing.JTable tblMenunggu;
    private javax.swing.JTextField txtCariMasuk;
    private javax.swing.JTextField txtCariMenunggu;
    // End of variables declaration//GEN-END:variables
}
