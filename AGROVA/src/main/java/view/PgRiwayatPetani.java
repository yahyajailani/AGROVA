package view;

import controller.GuiController;
import view.util.*;

/** Riwayat. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgRiwayatPetani extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgRiwayatPetani() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        TableKit.muat(tblRiw, GuiController::riwayatPetani);
        InputFilters.keyword(txtCariRiw, 40);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlHeaderRw = new javax.swing.JPanel();
        pnlTitlesRw = new javax.swing.JPanel();
        lblTitleRw = new javax.swing.JLabel();
        lblSubRw = new javax.swing.JLabel();
        pnlTopRw = new javax.swing.JPanel();
        scrBodyRw = new javax.swing.JScrollPane();
        pnlOuterRw = new javax.swing.JPanel();
        pnlStackRw = new javax.swing.JPanel();
        pnlGapRw0 = new javax.swing.JPanel();
        pnlCardRiw = new javax.swing.JPanel();
        pnlHeadRiw = new javax.swing.JPanel();
        lblHRiw = new javax.swing.JLabel();
        pnlToolRiw = new javax.swing.JPanel();
        txtCariRiw = new javax.swing.JTextField();
        btnCariRiw = new javax.swing.JButton();
        scrRiw = new javax.swing.JScrollPane();
        tblRiw = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        pnlHeaderRw.setName("pnlHeaderRw");
        pnlHeaderRw.setOpaque(false);
        pnlHeaderRw.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        scrBodyRw.setName("scrBodyRw");
        scrBodyRw.setHorizontalScrollBarPolicy(31);
        setLayout(new java.awt.BorderLayout());
        pnlTitlesRw.setName("pnlTitlesRw");
        pnlTitlesRw.setOpaque(false);
        pnlTitlesRw.setAlignmentX(0.0f);
        pnlTopRw.setName("pnlTopRw");
        pnlTopRw.setOpaque(false);
        pnlHeaderRw.setLayout(new java.awt.BorderLayout());
        lblTitleRw.setName("lblTitleRw");
        lblTitleRw.setFont(new java.awt.Font("Georgia", 0, 26));
        lblTitleRw.setForeground(new java.awt.Color(29, 42, 34));
        lblTitleRw.setText("Riwayat");
        lblSubRw.setName("lblSubRw");
        lblSubRw.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubRw.setForeground(new java.awt.Color(122, 127, 115));
        lblSubRw.setText("Pupuk yang sudah diterima.");
        pnlTitlesRw.setLayout(new javax.swing.BoxLayout(pnlTitlesRw, javax.swing.BoxLayout.PAGE_AXIS));
        pnlTitlesRw.add(lblTitleRw);
        pnlTitlesRw.add(lblSubRw);
        pnlTopRw.setLayout(new java.awt.FlowLayout(2, 8, 0));
        pnlHeaderRw.add(pnlTitlesRw, java.awt.BorderLayout.WEST);
        pnlHeaderRw.add(pnlTopRw, java.awt.BorderLayout.EAST);
        pnlOuterRw.setName("pnlOuterRw");
        pnlOuterRw.setOpaque(true);
        pnlOuterRw.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterRw.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlStackRw.setName("pnlStackRw");
        pnlStackRw.setOpaque(false);
        pnlStackRw.setAlignmentX(0.0f);
        pnlOuterRw.setLayout(new java.awt.BorderLayout());
        pnlGapRw0.setName("pnlGapRw0");
        pnlGapRw0.setOpaque(false);
        pnlGapRw0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapRw0.setAlignmentX(0.0f);
        pnlStackRw.setLayout(new javax.swing.BoxLayout(pnlStackRw, javax.swing.BoxLayout.PAGE_AXIS));
        pnlCardRiw.setName("pnlCardRiw");
        pnlCardRiw.setOpaque(true);
        pnlCardRiw.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardRiw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardRiw.setAlignmentX(0.0f);
        pnlGapRw0.setLayout(new java.awt.BorderLayout());
        pnlHeadRiw.setName("pnlHeadRiw");
        pnlHeadRiw.setOpaque(false);
        pnlHeadRiw.setAlignmentX(0.0f);
        pnlHeadRiw.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadRiw.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlToolRiw.setName("pnlToolRiw");
        pnlToolRiw.setOpaque(false);
        pnlToolRiw.setAlignmentX(0.0f);
        pnlToolRiw.setMaximumSize(new java.awt.Dimension(4000, 52));
        scrRiw.setName("scrRiw");
        scrRiw.setPreferredSize(new java.awt.Dimension(600, 360));
        scrRiw.setMaximumSize(new java.awt.Dimension(4000, 360));
        scrRiw.setAlignmentX(0.0f);
        pnlCardRiw.setLayout(new javax.swing.BoxLayout(pnlCardRiw, javax.swing.BoxLayout.PAGE_AXIS));
        lblHRiw.setName("lblHRiw");
        lblHRiw.setFont(new java.awt.Font("Georgia", 0, 17));
        lblHRiw.setForeground(new java.awt.Color(29, 42, 34));
        lblHRiw.setText("Riwayat penerimaan");
        pnlHeadRiw.setLayout(new java.awt.BorderLayout());
        pnlHeadRiw.add(lblHRiw, java.awt.BorderLayout.WEST);
        txtCariRiw.setName("txtCariRiw");
        txtCariRiw.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtCariRiw.setForeground(new java.awt.Color(29, 42, 34));
        txtCariRiw.setPreferredSize(new java.awt.Dimension(260, 40));
        btnCariRiw.setName("btnCariRiw");
        btnCariRiw.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnCariRiw.setForeground(new java.awt.Color(255, 255, 255));
        btnCariRiw.setBackground(new java.awt.Color(31, 77, 58));
        btnCariRiw.setText("Cari");
        btnCariRiw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariRiwActionPerformed(evt);
            }
        });
        pnlToolRiw.setLayout(new java.awt.FlowLayout(0, 8, 0));
        pnlToolRiw.add(txtCariRiw);
        pnlToolRiw.add(btnCariRiw);
        tblRiw.setName("tblRiw");
        tblRiw.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"No. Transaksi", "Tanggal", "Kategori", "Produk", "Kecamatan", "Jumlah (kg)", "Penyalur"}) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        scrRiw.setViewportView(tblRiw);
        pnlCardRiw.add(pnlHeadRiw);
        pnlCardRiw.add(pnlToolRiw);
        pnlCardRiw.add(scrRiw);
        pnlGapRw0.add(pnlCardRiw, java.awt.BorderLayout.CENTER);
        pnlStackRw.add(pnlGapRw0);
        pnlOuterRw.add(pnlStackRw, java.awt.BorderLayout.NORTH);
        scrBodyRw.setViewportView(pnlOuterRw);
        add(pnlHeaderRw, java.awt.BorderLayout.NORTH);
        add(scrBodyRw, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void btnCariRiwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariRiwActionPerformed
        TableKit.cari(tblRiw, txtCariRiw.getText());
    }//GEN-LAST:event_btnCariRiwActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlHeaderRw;
    private javax.swing.JPanel pnlTitlesRw;
    private javax.swing.JLabel lblTitleRw;
    private javax.swing.JLabel lblSubRw;
    private javax.swing.JPanel pnlTopRw;
    private javax.swing.JScrollPane scrBodyRw;
    private javax.swing.JPanel pnlOuterRw;
    private javax.swing.JPanel pnlStackRw;
    private javax.swing.JPanel pnlGapRw0;
    private javax.swing.JPanel pnlCardRiw;
    private javax.swing.JPanel pnlHeadRiw;
    private javax.swing.JLabel lblHRiw;
    private javax.swing.JPanel pnlToolRiw;
    private javax.swing.JTextField txtCariRiw;
    private javax.swing.JButton btnCariRiw;
    private javax.swing.JScrollPane scrRiw;
    private javax.swing.JTable tblRiw;
    // End of variables declaration//GEN-END:variables
}
