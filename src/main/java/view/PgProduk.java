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
        
        // Memuat data produk tersedia kios dan filter pencarian
        TableKit.muat(tblProd, GuiController::produkTersediaKiosSaya);
        InputFilters.keyword(txtCariProd, 40);
        
        // (Opsional) Jika ingin menampilkan nama/kecamatan di header halaman Produk
        try {
            lblSubBt.setText(GuiController.namaPengguna() + " — " + GuiController.kecamatanSaya() + ".");
        } catch (RuntimeException e) {
            // Abaikan jika tidak digunakan
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeaderPr = new javax.swing.JPanel();
        pnlTitlesPr = new javax.swing.JPanel();
        lblTitlePr = new javax.swing.JLabel();
        lblSubBt = new javax.swing.JLabel();
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

        setPreferredSize(new java.awt.Dimension(980, 700));
        setBackground(new java.awt.Color(246, 241, 231));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderPr.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderPr.setOpaque(false);
        pnlHeaderPr.setLayout(new java.awt.BorderLayout());

        pnlTitlesPr.setAlignmentX(0.0F);
        pnlTitlesPr.setOpaque(false);
        pnlTitlesPr.setLayout(new javax.swing.BoxLayout(pnlTitlesPr, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitlePr.setText("Produk");
        lblTitlePr.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitlePr.setForeground(new java.awt.Color(29, 42, 34));
        pnlTitlesPr.add(lblTitlePr);

        lblSubBt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubBt.setForeground(new java.awt.Color(122, 127, 115));
        lblSubBt.setText("Budi Santoso — Samarinda Ulu.");
        lblSubBt.setName("lblSubBt"); // NOI18N
        pnlTitlesPr.add(lblSubBt);

        lblSubPr.setText("Pupuk yang tersedia di kecamatan Anda.");
        lblSubPr.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubPr.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesPr.add(lblSubPr);

        pnlHeaderPr.add(pnlTitlesPr, java.awt.BorderLayout.WEST);

        pnlTopPr.setOpaque(false);
        pnlTopPr.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderPr.add(pnlTopPr, java.awt.BorderLayout.EAST);

        add(pnlHeaderPr, java.awt.BorderLayout.NORTH);

        scrBodyPr.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterPr.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterPr.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterPr.setLayout(new java.awt.BorderLayout());

        pnlStackPr.setAlignmentX(0.0F);
        pnlStackPr.setOpaque(false);
        pnlStackPr.setLayout(new javax.swing.BoxLayout(pnlStackPr, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapPr0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapPr0.setAlignmentX(0.0F);
        pnlGapPr0.setOpaque(false);
        pnlGapPr0.setLayout(new java.awt.BorderLayout());

        pnlCardProd.setAlignmentX(0.0F);
        pnlCardProd.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardProd.setLayout(new javax.swing.BoxLayout(pnlCardProd, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadProd.setAlignmentX(0.0F);
        pnlHeadProd.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadProd.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadProd.setOpaque(false);
        pnlHeadProd.setLayout(new java.awt.BorderLayout());

        lblHProd.setText("Produk tersedia");
        lblHProd.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHProd.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadProd.add(lblHProd, java.awt.BorderLayout.WEST);

        pnlCardProd.add(pnlHeadProd);

        pnlToolProd.setAlignmentX(0.0F);
        pnlToolProd.setMaximumSize(new java.awt.Dimension(4000, 52));
        pnlToolProd.setOpaque(false);
        pnlToolProd.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCariProd.setPreferredSize(new java.awt.Dimension(260, 40));
        txtCariProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCariProd.setForeground(new java.awt.Color(29, 42, 34));
        pnlToolProd.add(txtCariProd);

        btnCariProd.setText("Cari");
        btnCariProd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCariProd.setForeground(new java.awt.Color(255, 255, 255));
        btnCariProd.setBackground(new java.awt.Color(31, 77, 58));
        btnCariProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariProdActionPerformed(evt);
            }
        });
        pnlToolProd.add(btnCariProd);

        pnlCardProd.add(pnlToolProd);

        scrProd.setPreferredSize(new java.awt.Dimension(600, 330));
        scrProd.setMaximumSize(new java.awt.Dimension(4000, 330));
        scrProd.setAlignmentX(0.0F);

        tblProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produk", "Kategori", "Harga (Rp/kg)", "Tersedia (kg)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrProd.setViewportView(tblProd);

        pnlCardProd.add(scrProd);

        pnlGapPr0.add(pnlCardProd, java.awt.BorderLayout.CENTER);

        pnlStackPr.add(pnlGapPr0);

        pnlOuterPr.add(pnlStackPr, java.awt.BorderLayout.NORTH);

        scrBodyPr.setViewportView(pnlOuterPr);

        add(scrBodyPr, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariProdActionPerformed
        TableKit.cari(tblProd, txtCariProd.getText());
    }//GEN-LAST:event_btnCariProdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariProd;
    private javax.swing.JLabel lblHProd;
    private javax.swing.JLabel lblSubBt;
    private javax.swing.JLabel lblSubPr;
    private javax.swing.JLabel lblTitlePr;
    private javax.swing.JPanel pnlCardProd;
    private javax.swing.JPanel pnlGapPr0;
    private javax.swing.JPanel pnlHeadProd;
    private javax.swing.JPanel pnlHeaderPr;
    private javax.swing.JPanel pnlOuterPr;
    private javax.swing.JPanel pnlStackPr;
    private javax.swing.JPanel pnlTitlesPr;
    private javax.swing.JPanel pnlToolProd;
    private javax.swing.JPanel pnlTopPr;
    private javax.swing.JScrollPane scrBodyPr;
    private javax.swing.JScrollPane scrProd;
    private javax.swing.JTable tblProd;
    private javax.swing.JTextField txtCariProd;
    // End of variables declaration//GEN-END:variables
}
