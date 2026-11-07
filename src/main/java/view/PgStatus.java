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
        
        // Menampilkan nama pengguna dan kecamatan pada subtitle bagian atas
        try {
            lblSubBt.setText(GuiController.namaPengguna() + " — " + GuiController.kecamatanSaya() + ".");
        } catch (RuntimeException e) {
            // Abaikan jika terjadi kendala pengambilan data
        }

        TableKit.muat(tblStatus, GuiController::statusPesananSaya);
        InputFilters.keyword(txtCariStatus, 40);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeaderSts = new javax.swing.JPanel();
        pnlTitlesSts = new javax.swing.JPanel();
        lblTitleSts = new javax.swing.JLabel();
        lblSubBt = new javax.swing.JLabel();
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

        setPreferredSize(new java.awt.Dimension(980, 700));
        setBackground(new java.awt.Color(246, 241, 231));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderSts.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderSts.setOpaque(false);
        pnlHeaderSts.setLayout(new java.awt.BorderLayout());

        pnlTitlesSts.setAlignmentX(0.0F);
        pnlTitlesSts.setOpaque(false);
        pnlTitlesSts.setLayout(new javax.swing.BoxLayout(pnlTitlesSts, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitleSts.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitleSts.setForeground(new java.awt.Color(29, 42, 34));
        lblTitleSts.setText("Status Pesanan");
        pnlTitlesSts.add(lblTitleSts);

        lblSubBt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubBt.setForeground(new java.awt.Color(122, 127, 115));
        lblSubBt.setText("Budi Santoso — Samarinda Ulu.");
        lblSubBt.setName("lblSubBt"); // NOI18N
        pnlTitlesSts.add(lblSubBt);

        lblSubSts.setText("Pantau status pesanan Anda: Diproses, Diterima, Ditolak, atau Dibatalkan.");
        lblSubSts.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubSts.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesSts.add(lblSubSts);

        pnlHeaderSts.add(pnlTitlesSts, java.awt.BorderLayout.WEST);

        pnlTopSts.setOpaque(false);
        pnlTopSts.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderSts.add(pnlTopSts, java.awt.BorderLayout.EAST);

        add(pnlHeaderSts, java.awt.BorderLayout.NORTH);

        scrBodySts.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterSts.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterSts.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterSts.setLayout(new java.awt.BorderLayout());

        pnlStackSts.setAlignmentX(0.0F);
        pnlStackSts.setOpaque(false);
        pnlStackSts.setLayout(new javax.swing.BoxLayout(pnlStackSts, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapSts0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapSts0.setAlignmentX(0.0F);
        pnlGapSts0.setOpaque(false);
        pnlGapSts0.setLayout(new java.awt.BorderLayout());

        pnlCardStatus.setAlignmentX(0.0F);
        pnlCardStatus.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatus.setLayout(new javax.swing.BoxLayout(pnlCardStatus, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadStatus.setAlignmentX(0.0F);
        pnlHeadStatus.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadStatus.setOpaque(false);
        pnlHeadStatus.setLayout(new java.awt.BorderLayout());

        lblHStatus.setText("Pesanan saya");
        lblHStatus.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHStatus.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadStatus.add(lblHStatus, java.awt.BorderLayout.WEST);

        pnlCardStatus.add(pnlHeadStatus);

        pnlToolStatus.setAlignmentX(0.0F);
        pnlToolStatus.setMaximumSize(new java.awt.Dimension(4000, 52));
        pnlToolStatus.setOpaque(false);
        pnlToolStatus.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCariStatus.setPreferredSize(new java.awt.Dimension(260, 40));
        txtCariStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCariStatus.setForeground(new java.awt.Color(29, 42, 34));
        pnlToolStatus.add(txtCariStatus);

        btnCariStatus.setText("Cari");
        btnCariStatus.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCariStatus.setForeground(new java.awt.Color(255, 255, 255));
        btnCariStatus.setBackground(new java.awt.Color(31, 77, 58));
        btnCariStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariStatusActionPerformed(evt);
            }
        });
        pnlToolStatus.add(btnCariStatus);

        btnBatal.setText("Batalkan");
        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setBackground(new java.awt.Color(31, 77, 58));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        pnlToolStatus.add(btnBatal);

        pnlCardStatus.add(pnlToolStatus);

        scrStatus.setPreferredSize(new java.awt.Dimension(600, 330));
        scrStatus.setMaximumSize(new java.awt.Dimension(4000, 330));
        scrStatus.setAlignmentX(0.0F);

        tblStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Transaksi", "Tanggal", "Kategori", "Produk", "Kecamatan", "Jumlah (kg)", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrStatus.setViewportView(tblStatus);

        pnlCardStatus.add(scrStatus);

        pnlGapSts0.add(pnlCardStatus, java.awt.BorderLayout.CENTER);

        pnlStackSts.add(pnlGapSts0);

        pnlOuterSts.add(pnlStackSts, java.awt.BorderLayout.NORTH);

        scrBodySts.setViewportView(pnlOuterSts);

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
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCariStatus;
    private javax.swing.JLabel lblHStatus;
    private javax.swing.JLabel lblSubBt;
    private javax.swing.JLabel lblSubSts;
    private javax.swing.JLabel lblTitleSts;
    private javax.swing.JPanel pnlCardStatus;
    private javax.swing.JPanel pnlGapSts0;
    private javax.swing.JPanel pnlHeadStatus;
    private javax.swing.JPanel pnlHeaderSts;
    private javax.swing.JPanel pnlOuterSts;
    private javax.swing.JPanel pnlStackSts;
    private javax.swing.JPanel pnlTitlesSts;
    private javax.swing.JPanel pnlToolStatus;
    private javax.swing.JPanel pnlTopSts;
    private javax.swing.JScrollPane scrBodySts;
    private javax.swing.JScrollPane scrStatus;
    private javax.swing.JTable tblStatus;
    private javax.swing.JTextField txtCariStatus;
    // End of variables declaration//GEN-END:variables
}
