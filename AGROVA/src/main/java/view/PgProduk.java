package view;

import controller.GuiController;
import view.util.*;

/** Produk. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgProduk extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgProduk() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        TableKit.muat(tblProd, GuiController::produkTersediaKiosSaya);
        InputFilters.keyword(txtCariProd, 40);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlHeaderPr = new javax.swing.JPanel();
        pnlTitlesPr = new javax.swing.JPanel();
        lblTitlePr = new javax.swing.JLabel();
        lblSubPr = new javax.swing.JLabel();
        pnlTopPr = new javax.swing.JPanel();
        scrBodyPr = new javax.swing.JScrollPane();
        pnlOuterPr = new javax.swing.JPanel();
        pnlStackPr = new javax.swing.JPanel();
        pnlGapPr0 = new javax.swing.JPanel();
        pnlCardProd = new javax.swing.JPanel();
        pnlHeadProd = new javax.swing.JPanel();
        lblHProd = new javax.swing.JLabel();
        pnlToolProd = new javax.swing.JPanel();
        txtCariProd = new javax.swing.JTextField();
        btnCariProd = new javax.swing.JButton();
        scrProd = new javax.swing.JScrollPane();
        tblProd = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        pnlHeaderPr.setName("pnlHeaderPr");
        pnlHeaderPr.setOpaque(false);
        pnlHeaderPr.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        scrBodyPr.setName("scrBodyPr");
        scrBodyPr.setHorizontalScrollBarPolicy(31);
        setLayout(new java.awt.BorderLayout());
        pnlTitlesPr.setName("pnlTitlesPr");
        pnlTitlesPr.setOpaque(false);
        pnlTitlesPr.setAlignmentX(0.0f);
        pnlTopPr.setName("pnlTopPr");
        pnlTopPr.setOpaque(false);
        pnlHeaderPr.setLayout(new java.awt.BorderLayout());
        lblTitlePr.setName("lblTitlePr");
        lblTitlePr.setFont(new java.awt.Font("Georgia", 0, 26));
        lblTitlePr.setForeground(new java.awt.Color(29, 42, 34));
        lblTitlePr.setText("Produk");
        lblSubPr.setName("lblSubPr");
        lblSubPr.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubPr.setForeground(new java.awt.Color(122, 127, 115));
        lblSubPr.setText("Pupuk yang tersedia di kecamatan Anda.");
        pnlTitlesPr.setLayout(new javax.swing.BoxLayout(pnlTitlesPr, javax.swing.BoxLayout.PAGE_AXIS));
        pnlTitlesPr.add(lblTitlePr);
        pnlTitlesPr.add(lblSubPr);
        pnlTopPr.setLayout(new java.awt.FlowLayout(2, 8, 0));
        pnlHeaderPr.add(pnlTitlesPr, java.awt.BorderLayout.WEST);
        pnlHeaderPr.add(pnlTopPr, java.awt.BorderLayout.EAST);
        pnlOuterPr.setName("pnlOuterPr");
        pnlOuterPr.setOpaque(true);
        pnlOuterPr.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterPr.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlStackPr.setName("pnlStackPr");
        pnlStackPr.setOpaque(false);
        pnlStackPr.setAlignmentX(0.0f);
        pnlOuterPr.setLayout(new java.awt.BorderLayout());
        pnlGapPr0.setName("pnlGapPr0");
        pnlGapPr0.setOpaque(false);
        pnlGapPr0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapPr0.setAlignmentX(0.0f);
        pnlStackPr.setLayout(new javax.swing.BoxLayout(pnlStackPr, javax.swing.BoxLayout.PAGE_AXIS));
        pnlCardProd.setName("pnlCardProd");
        pnlCardProd.setOpaque(true);
        pnlCardProd.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardProd.setAlignmentX(0.0f);
        pnlGapPr0.setLayout(new java.awt.BorderLayout());
        pnlHeadProd.setName("pnlHeadProd");
        pnlHeadProd.setOpaque(false);
        pnlHeadProd.setAlignmentX(0.0f);
        pnlHeadProd.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadProd.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlToolProd.setName("pnlToolProd");
        pnlToolProd.setOpaque(false);
        pnlToolProd.setAlignmentX(0.0f);
        pnlToolProd.setMaximumSize(new java.awt.Dimension(4000, 52));
        scrProd.setName("scrProd");
        scrProd.setPreferredSize(new java.awt.Dimension(600, 330));
        scrProd.setMaximumSize(new java.awt.Dimension(4000, 330));
        scrProd.setAlignmentX(0.0f);
        pnlCardProd.setLayout(new javax.swing.BoxLayout(pnlCardProd, javax.swing.BoxLayout.PAGE_AXIS));
        lblHProd.setName("lblHProd");
        lblHProd.setFont(new java.awt.Font("Georgia", 0, 17));
        lblHProd.setForeground(new java.awt.Color(29, 42, 34));
        lblHProd.setText("Produk tersedia");
        pnlHeadProd.setLayout(new java.awt.BorderLayout());
        pnlHeadProd.add(lblHProd, java.awt.BorderLayout.WEST);
        txtCariProd.setName("txtCariProd");
        txtCariProd.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtCariProd.setForeground(new java.awt.Color(29, 42, 34));
        txtCariProd.setPreferredSize(new java.awt.Dimension(260, 40));
        btnCariProd.setName("btnCariProd");
        btnCariProd.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnCariProd.setForeground(new java.awt.Color(255, 255, 255));
        btnCariProd.setBackground(new java.awt.Color(31, 77, 58));
        btnCariProd.setText("Cari");
        btnCariProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariProdActionPerformed(evt);
            }
        });
        pnlToolProd.setLayout(new java.awt.FlowLayout(0, 8, 0));
        pnlToolProd.add(txtCariProd);
        pnlToolProd.add(btnCariProd);
        tblProd.setName("tblProd");
        tblProd.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Produk", "Kategori", "Harga (Rp/kg)", "Tersedia (kg)"}) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        scrProd.setViewportView(tblProd);
        pnlCardProd.add(pnlHeadProd);
        pnlCardProd.add(pnlToolProd);
        pnlCardProd.add(scrProd);
        pnlGapPr0.add(pnlCardProd, java.awt.BorderLayout.CENTER);
        pnlStackPr.add(pnlGapPr0);
        pnlOuterPr.add(pnlStackPr, java.awt.BorderLayout.NORTH);
        scrBodyPr.setViewportView(pnlOuterPr);
        add(pnlHeaderPr, java.awt.BorderLayout.NORTH);
        add(scrBodyPr, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void btnCariProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariProdActionPerformed
        TableKit.cari(tblProd, txtCariProd.getText());
    }//GEN-LAST:event_btnCariProdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlHeaderPr;
    private javax.swing.JPanel pnlTitlesPr;
    private javax.swing.JLabel lblTitlePr;
    private javax.swing.JLabel lblSubPr;
    private javax.swing.JPanel pnlTopPr;
    private javax.swing.JScrollPane scrBodyPr;
    private javax.swing.JPanel pnlOuterPr;
    private javax.swing.JPanel pnlStackPr;
    private javax.swing.JPanel pnlGapPr0;
    private javax.swing.JPanel pnlCardProd;
    private javax.swing.JPanel pnlHeadProd;
    private javax.swing.JLabel lblHProd;
    private javax.swing.JPanel pnlToolProd;
    private javax.swing.JTextField txtCariProd;
    private javax.swing.JButton btnCariProd;
    private javax.swing.JScrollPane scrProd;
    private javax.swing.JTable tblProd;
    // End of variables declaration//GEN-END:variables
}
