package view;

import controller.GuiController;
import view.util.*;

/** Stok. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgStok extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgStok() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        TableKit.muat(tblStokKec, GuiController::stokKios);
        InputFilters.keyword(txtCariStokKec, 40);
        TableKit.muat(tblKet, GuiController::produkTersediaKiosSaya);
        InputFilters.keyword(txtCariKet, 40);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlHeaderSt = new javax.swing.JPanel();
        pnlTitlesSt = new javax.swing.JPanel();
        lblTitleSt = new javax.swing.JLabel();
        lblSubSt = new javax.swing.JLabel();
        pnlTopSt = new javax.swing.JPanel();
        scrBodySt = new javax.swing.JScrollPane();
        pnlOuterSt = new javax.swing.JPanel();
        pnlStackSt = new javax.swing.JPanel();
        pnlGapSt0 = new javax.swing.JPanel();
        tabStok = new javax.swing.JTabbedPane();
        pnlTabStok = new javax.swing.JPanel();
        pnlCardStokKec = new javax.swing.JPanel();
        pnlHeadStokKec = new javax.swing.JPanel();
        lblHStokKec = new javax.swing.JLabel();
        pnlToolStokKec = new javax.swing.JPanel();
        txtCariStokKec = new javax.swing.JTextField();
        btnCariStokKec = new javax.swing.JButton();
        scrStokKec = new javax.swing.JScrollPane();
        tblStokKec = new javax.swing.JTable();
        pnlTabKet = new javax.swing.JPanel();
        pnlCardKet = new javax.swing.JPanel();
        pnlHeadKet = new javax.swing.JPanel();
        lblHKet = new javax.swing.JLabel();
        pnlToolKet = new javax.swing.JPanel();
        txtCariKet = new javax.swing.JTextField();
        btnCariKet = new javax.swing.JButton();
        scrKet = new javax.swing.JScrollPane();
        tblKet = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        pnlHeaderSt.setName("pnlHeaderSt");
        pnlHeaderSt.setOpaque(false);
        pnlHeaderSt.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        scrBodySt.setName("scrBodySt");
        scrBodySt.setHorizontalScrollBarPolicy(31);
        setLayout(new java.awt.BorderLayout());
        pnlTitlesSt.setName("pnlTitlesSt");
        pnlTitlesSt.setOpaque(false);
        pnlTitlesSt.setAlignmentX(0.0f);
        pnlTopSt.setName("pnlTopSt");
        pnlTopSt.setOpaque(false);
        pnlHeaderSt.setLayout(new java.awt.BorderLayout());
        lblTitleSt.setName("lblTitleSt");
        lblTitleSt.setFont(new java.awt.Font("Georgia", 0, 26));
        lblTitleSt.setForeground(new java.awt.Color(29, 42, 34));
        lblTitleSt.setText("Stok");
        lblSubSt.setName("lblSubSt");
        lblSubSt.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubSt.setForeground(new java.awt.Color(122, 127, 115));
        lblSubSt.setText("Stok kios: jumlah diterima, terjual, dipesan, dan sisa pupuk yang masih tersedia.");
        pnlTitlesSt.setLayout(new javax.swing.BoxLayout(pnlTitlesSt, javax.swing.BoxLayout.PAGE_AXIS));
        pnlTitlesSt.add(lblTitleSt);
        pnlTitlesSt.add(lblSubSt);
        pnlTopSt.setLayout(new java.awt.FlowLayout(2, 8, 0));
        pnlHeaderSt.add(pnlTitlesSt, java.awt.BorderLayout.WEST);
        pnlHeaderSt.add(pnlTopSt, java.awt.BorderLayout.EAST);
        pnlOuterSt.setName("pnlOuterSt");
        pnlOuterSt.setOpaque(true);
        pnlOuterSt.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterSt.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlStackSt.setName("pnlStackSt");
        pnlStackSt.setOpaque(false);
        pnlStackSt.setAlignmentX(0.0f);
        pnlOuterSt.setLayout(new java.awt.BorderLayout());
        pnlGapSt0.setName("pnlGapSt0");
        pnlGapSt0.setOpaque(false);
        pnlGapSt0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapSt0.setAlignmentX(0.0f);
        pnlStackSt.setLayout(new javax.swing.BoxLayout(pnlStackSt, javax.swing.BoxLayout.PAGE_AXIS));
        tabStok.setName("tabStok");
        tabStok.setFont(new java.awt.Font("Segoe UI", 1, 13));
        tabStok.setAlignmentX(0.0f);
        tabStok.setPreferredSize(new java.awt.Dimension(700, 460));
        tabStok.setMaximumSize(new java.awt.Dimension(4000, 460));
        pnlGapSt0.setLayout(new java.awt.BorderLayout());
        pnlTabStok.setName("pnlTabStok");
        pnlTabStok.setOpaque(false);
        pnlTabStok.setAlignmentX(0.0f);
        pnlTabKet.setName("pnlTabKet");
        pnlTabKet.setOpaque(false);
        pnlTabKet.setAlignmentX(0.0f);
        pnlCardStokKec.setName("pnlCardStokKec");
        pnlCardStokKec.setOpaque(true);
        pnlCardStokKec.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStokKec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStokKec.setAlignmentX(0.0f);
        pnlTabStok.setLayout(new javax.swing.BoxLayout(pnlTabStok, javax.swing.BoxLayout.PAGE_AXIS));
        pnlHeadStokKec.setName("pnlHeadStokKec");
        pnlHeadStokKec.setOpaque(false);
        pnlHeadStokKec.setAlignmentX(0.0f);
        pnlHeadStokKec.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadStokKec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlToolStokKec.setName("pnlToolStokKec");
        pnlToolStokKec.setOpaque(false);
        pnlToolStokKec.setAlignmentX(0.0f);
        pnlToolStokKec.setMaximumSize(new java.awt.Dimension(4000, 52));
        scrStokKec.setName("scrStokKec");
        scrStokKec.setPreferredSize(new java.awt.Dimension(600, 320));
        scrStokKec.setMaximumSize(new java.awt.Dimension(4000, 320));
        scrStokKec.setAlignmentX(0.0f);
        pnlCardStokKec.setLayout(new javax.swing.BoxLayout(pnlCardStokKec, javax.swing.BoxLayout.PAGE_AXIS));
        lblHStokKec.setName("lblHStokKec");
        lblHStokKec.setFont(new java.awt.Font("Georgia", 0, 17));
        lblHStokKec.setForeground(new java.awt.Color(29, 42, 34));
        lblHStokKec.setText("Stok kecamatan");
        pnlHeadStokKec.setLayout(new java.awt.BorderLayout());
        pnlHeadStokKec.add(lblHStokKec, java.awt.BorderLayout.WEST);
        txtCariStokKec.setName("txtCariStokKec");
        txtCariStokKec.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtCariStokKec.setForeground(new java.awt.Color(29, 42, 34));
        txtCariStokKec.setPreferredSize(new java.awt.Dimension(260, 40));
        btnCariStokKec.setName("btnCariStokKec");
        btnCariStokKec.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnCariStokKec.setForeground(new java.awt.Color(255, 255, 255));
        btnCariStokKec.setBackground(new java.awt.Color(31, 77, 58));
        btnCariStokKec.setText("Cari");
        btnCariStokKec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariStokKecActionPerformed(evt);
            }
        });
        pnlToolStokKec.setLayout(new java.awt.FlowLayout(0, 8, 0));
        pnlToolStokKec.add(txtCariStokKec);
        pnlToolStokKec.add(btnCariStokKec);
        tblStokKec.setName("tblStokKec");
        tblStokKec.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Produk", "Kategori", "Diterima (kg)", "Terjual (kg)", "Dipesan (kg)", "Sisa tersedia (kg)"}) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        scrStokKec.setViewportView(tblStokKec);
        pnlCardStokKec.add(pnlHeadStokKec);
        pnlCardStokKec.add(pnlToolStokKec);
        pnlCardStokKec.add(scrStokKec);
        pnlTabStok.add(pnlCardStokKec);
        pnlCardKet.setName("pnlCardKet");
        pnlCardKet.setOpaque(true);
        pnlCardKet.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardKet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardKet.setAlignmentX(0.0f);
        pnlTabKet.setLayout(new javax.swing.BoxLayout(pnlTabKet, javax.swing.BoxLayout.PAGE_AXIS));
        pnlHeadKet.setName("pnlHeadKet");
        pnlHeadKet.setOpaque(false);
        pnlHeadKet.setAlignmentX(0.0f);
        pnlHeadKet.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadKet.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlToolKet.setName("pnlToolKet");
        pnlToolKet.setOpaque(false);
        pnlToolKet.setAlignmentX(0.0f);
        pnlToolKet.setMaximumSize(new java.awt.Dimension(4000, 52));
        scrKet.setName("scrKet");
        scrKet.setPreferredSize(new java.awt.Dimension(600, 320));
        scrKet.setMaximumSize(new java.awt.Dimension(4000, 320));
        scrKet.setAlignmentX(0.0f);
        pnlCardKet.setLayout(new javax.swing.BoxLayout(pnlCardKet, javax.swing.BoxLayout.PAGE_AXIS));
        lblHKet.setName("lblHKet");
        lblHKet.setFont(new java.awt.Font("Georgia", 0, 17));
        lblHKet.setForeground(new java.awt.Color(29, 42, 34));
        lblHKet.setText("Ketersediaan produk");
        pnlHeadKet.setLayout(new java.awt.BorderLayout());
        pnlHeadKet.add(lblHKet, java.awt.BorderLayout.WEST);
        txtCariKet.setName("txtCariKet");
        txtCariKet.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtCariKet.setForeground(new java.awt.Color(29, 42, 34));
        txtCariKet.setPreferredSize(new java.awt.Dimension(260, 40));
        btnCariKet.setName("btnCariKet");
        btnCariKet.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnCariKet.setForeground(new java.awt.Color(255, 255, 255));
        btnCariKet.setBackground(new java.awt.Color(31, 77, 58));
        btnCariKet.setText("Cari");
        btnCariKet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariKetActionPerformed(evt);
            }
        });
        pnlToolKet.setLayout(new java.awt.FlowLayout(0, 8, 0));
        pnlToolKet.add(txtCariKet);
        pnlToolKet.add(btnCariKet);
        tblKet.setName("tblKet");
        tblKet.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Produk", "Kategori", "Harga (Rp/kg)", "Tersedia (kg)"}) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        scrKet.setViewportView(tblKet);
        pnlCardKet.add(pnlHeadKet);
        pnlCardKet.add(pnlToolKet);
        pnlCardKet.add(scrKet);
        pnlTabKet.add(pnlCardKet);
        tabStok.addTab("Stok kecamatan", pnlTabStok);
        tabStok.addTab("Ketersediaan", pnlTabKet);
        pnlGapSt0.add(tabStok, java.awt.BorderLayout.CENTER);
        pnlStackSt.add(pnlGapSt0);
        pnlOuterSt.add(pnlStackSt, java.awt.BorderLayout.NORTH);
        scrBodySt.setViewportView(pnlOuterSt);
        add(pnlHeaderSt, java.awt.BorderLayout.NORTH);
        add(scrBodySt, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void btnCariStokKecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariStokKecActionPerformed
        TableKit.cari(tblStokKec, txtCariStokKec.getText());
    }//GEN-LAST:event_btnCariStokKecActionPerformed

    private void btnCariKetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariKetActionPerformed
        TableKit.cari(tblKet, txtCariKet.getText());
    }//GEN-LAST:event_btnCariKetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlHeaderSt;
    private javax.swing.JPanel pnlTitlesSt;
    private javax.swing.JLabel lblTitleSt;
    private javax.swing.JLabel lblSubSt;
    private javax.swing.JPanel pnlTopSt;
    private javax.swing.JScrollPane scrBodySt;
    private javax.swing.JPanel pnlOuterSt;
    private javax.swing.JPanel pnlStackSt;
    private javax.swing.JPanel pnlGapSt0;
    private javax.swing.JTabbedPane tabStok;
    private javax.swing.JPanel pnlTabStok;
    private javax.swing.JPanel pnlCardStokKec;
    private javax.swing.JPanel pnlHeadStokKec;
    private javax.swing.JLabel lblHStokKec;
    private javax.swing.JPanel pnlToolStokKec;
    private javax.swing.JTextField txtCariStokKec;
    private javax.swing.JButton btnCariStokKec;
    private javax.swing.JScrollPane scrStokKec;
    private javax.swing.JTable tblStokKec;
    private javax.swing.JPanel pnlTabKet;
    private javax.swing.JPanel pnlCardKet;
    private javax.swing.JPanel pnlHeadKet;
    private javax.swing.JLabel lblHKet;
    private javax.swing.JPanel pnlToolKet;
    private javax.swing.JTextField txtCariKet;
    private javax.swing.JButton btnCariKet;
    private javax.swing.JScrollPane scrKet;
    private javax.swing.JTable tblKet;
    // End of variables declaration//GEN-END:variables
}
