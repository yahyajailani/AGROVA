package view;

import controller.GuiController;
import view.util.*;

/** Status Pesanan. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgStatus extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgStatus() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        TableKit.muat(tblStatus, GuiController::statusPesananSaya);
        InputFilters.keyword(txtCariStatus, 40);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlHeaderSts = new javax.swing.JPanel();
        pnlTitlesSts = new javax.swing.JPanel();
        lblTitleSts = new javax.swing.JLabel();
        lblSubSts = new javax.swing.JLabel();
        pnlTopSts = new javax.swing.JPanel();
        scrBodySts = new javax.swing.JScrollPane();
        pnlOuterSts = new javax.swing.JPanel();
        pnlStackSts = new javax.swing.JPanel();
        pnlGapSts0 = new javax.swing.JPanel();
        pnlCardStatus = new javax.swing.JPanel();
        pnlHeadStatus = new javax.swing.JPanel();
        lblHStatus = new javax.swing.JLabel();
        pnlToolStatus = new javax.swing.JPanel();
        txtCariStatus = new javax.swing.JTextField();
        btnCariStatus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        scrStatus = new javax.swing.JScrollPane();
        tblStatus = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        pnlHeaderSts.setName("pnlHeaderSts");
        pnlHeaderSts.setOpaque(false);
        pnlHeaderSts.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        scrBodySts.setName("scrBodySts");
        scrBodySts.setHorizontalScrollBarPolicy(31);
        setLayout(new java.awt.BorderLayout());
        pnlTitlesSts.setName("pnlTitlesSts");
        pnlTitlesSts.setOpaque(false);
        pnlTitlesSts.setAlignmentX(0.0f);
        pnlTopSts.setName("pnlTopSts");
        pnlTopSts.setOpaque(false);
        pnlHeaderSts.setLayout(new java.awt.BorderLayout());
        lblTitleSts.setName("lblTitleSts");
        lblTitleSts.setFont(new java.awt.Font("Georgia", 0, 26));
        lblTitleSts.setForeground(new java.awt.Color(29, 42, 34));
        lblTitleSts.setText("Status Pesanan");
        lblSubSts.setName("lblSubSts");
        lblSubSts.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubSts.setForeground(new java.awt.Color(122, 127, 115));
        lblSubSts.setText("Pantau pesanan yang sedang berjalan.");
        pnlTitlesSts.setLayout(new javax.swing.BoxLayout(pnlTitlesSts, javax.swing.BoxLayout.PAGE_AXIS));
        pnlTitlesSts.add(lblTitleSts);
        pnlTitlesSts.add(lblSubSts);
        pnlTopSts.setLayout(new java.awt.FlowLayout(2, 8, 0));
        pnlHeaderSts.add(pnlTitlesSts, java.awt.BorderLayout.WEST);
        pnlHeaderSts.add(pnlTopSts, java.awt.BorderLayout.EAST);
        pnlOuterSts.setName("pnlOuterSts");
        pnlOuterSts.setOpaque(true);
        pnlOuterSts.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterSts.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlStackSts.setName("pnlStackSts");
        pnlStackSts.setOpaque(false);
        pnlStackSts.setAlignmentX(0.0f);
        pnlOuterSts.setLayout(new java.awt.BorderLayout());
        pnlGapSts0.setName("pnlGapSts0");
        pnlGapSts0.setOpaque(false);
        pnlGapSts0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapSts0.setAlignmentX(0.0f);
        pnlStackSts.setLayout(new javax.swing.BoxLayout(pnlStackSts, javax.swing.BoxLayout.PAGE_AXIS));
        pnlCardStatus.setName("pnlCardStatus");
        pnlCardStatus.setOpaque(true);
        pnlCardStatus.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatus.setAlignmentX(0.0f);
        pnlGapSts0.setLayout(new java.awt.BorderLayout());
        pnlHeadStatus.setName("pnlHeadStatus");
        pnlHeadStatus.setOpaque(false);
        pnlHeadStatus.setAlignmentX(0.0f);
        pnlHeadStatus.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlToolStatus.setName("pnlToolStatus");
        pnlToolStatus.setOpaque(false);
        pnlToolStatus.setAlignmentX(0.0f);
        pnlToolStatus.setMaximumSize(new java.awt.Dimension(4000, 52));
        scrStatus.setName("scrStatus");
        scrStatus.setPreferredSize(new java.awt.Dimension(600, 330));
        scrStatus.setMaximumSize(new java.awt.Dimension(4000, 330));
        scrStatus.setAlignmentX(0.0f);
        pnlCardStatus.setLayout(new javax.swing.BoxLayout(pnlCardStatus, javax.swing.BoxLayout.PAGE_AXIS));
        lblHStatus.setName("lblHStatus");
        lblHStatus.setFont(new java.awt.Font("Georgia", 0, 17));
        lblHStatus.setForeground(new java.awt.Color(29, 42, 34));
        lblHStatus.setText("Pesanan saya");
        pnlHeadStatus.setLayout(new java.awt.BorderLayout());
        pnlHeadStatus.add(lblHStatus, java.awt.BorderLayout.WEST);
        txtCariStatus.setName("txtCariStatus");
        txtCariStatus.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtCariStatus.setForeground(new java.awt.Color(29, 42, 34));
        txtCariStatus.setPreferredSize(new java.awt.Dimension(260, 40));
        btnCariStatus.setName("btnCariStatus");
        btnCariStatus.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnCariStatus.setForeground(new java.awt.Color(255, 255, 255));
        btnCariStatus.setBackground(new java.awt.Color(31, 77, 58));
        btnCariStatus.setText("Cari");
        btnCariStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariStatusActionPerformed(evt);
            }
        });
        btnBatal.setName("btnBatal");
        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setBackground(new java.awt.Color(31, 77, 58));
        btnBatal.setText("Batalkan");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        pnlToolStatus.setLayout(new java.awt.FlowLayout(0, 8, 0));
        pnlToolStatus.add(txtCariStatus);
        pnlToolStatus.add(btnCariStatus);
        pnlToolStatus.add(btnBatal);
        tblStatus.setName("tblStatus");
        tblStatus.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"No. Transaksi", "Tanggal", "Kategori", "Produk", "Kecamatan", "Jumlah (kg)", "Status"}) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        scrStatus.setViewportView(tblStatus);
        pnlCardStatus.add(pnlHeadStatus);
        pnlCardStatus.add(pnlToolStatus);
        pnlCardStatus.add(scrStatus);
        pnlGapSts0.add(pnlCardStatus, java.awt.BorderLayout.CENTER);
        pnlStackSts.add(pnlGapSts0);
        pnlOuterSts.add(pnlStackSts, java.awt.BorderLayout.NORTH);
        scrBodySts.setViewportView(pnlOuterSts);
        add(pnlHeaderSts, java.awt.BorderLayout.NORTH);
        add(scrBodySts, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void btnCariStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariStatusActionPerformed
        TableKit.cari(tblStatus, txtCariStatus.getText());
    }//GEN-LAST:event_btnCariStatusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        if (tblStatus.getSelectedRow() < 0) {
            Dialogs.info(this, "Pilih pesanan terlebih dahulu.");
            return;
        }
        String kode = TableKit.pilih(tblStatus, 0);
        if (Dialogs.confirm(this, "Batalkan pesanan " + kode + "?") && Dialogs.coba(this, () -> GuiController.batalkanPesanan(kode))) {
            TableKit.muat(tblStatus, GuiController::statusPesananSaya);
        }
    }//GEN-LAST:event_btnBatalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlHeaderSts;
    private javax.swing.JPanel pnlTitlesSts;
    private javax.swing.JLabel lblTitleSts;
    private javax.swing.JLabel lblSubSts;
    private javax.swing.JPanel pnlTopSts;
    private javax.swing.JScrollPane scrBodySts;
    private javax.swing.JPanel pnlOuterSts;
    private javax.swing.JPanel pnlStackSts;
    private javax.swing.JPanel pnlGapSts0;
    private javax.swing.JPanel pnlCardStatus;
    private javax.swing.JPanel pnlHeadStatus;
    private javax.swing.JLabel lblHStatus;
    private javax.swing.JPanel pnlToolStatus;
    private javax.swing.JTextField txtCariStatus;
    private javax.swing.JButton btnCariStatus;
    private javax.swing.JButton btnBatal;
    private javax.swing.JScrollPane scrStatus;
    private javax.swing.JTable tblStatus;
    // End of variables declaration//GEN-END:variables
}
