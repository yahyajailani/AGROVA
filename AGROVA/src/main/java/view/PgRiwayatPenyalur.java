package view;

import controller.GuiController;
import view.util.*;

/** Riwayat. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgRiwayatPenyalur extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgRiwayatPenyalur() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        TableKit.muat(tblRiw, GuiController::riwayatPenyalur);
        InputFilters.keyword(txtCariRiw, 40);
    }

    private void cetakNota() {
        int i = tblRiw.getSelectedRow();
        if (i < 0) {
            Dialogs.info(this, "Pilih dulu satu baris transaksi.");
            return;
        }
        i = tblRiw.convertRowIndexToModel(i);
        Object[] baris = new Object[tblRiw.getModel().getColumnCount()];
        for (int c = 0; c < baris.length; c++) {
            baris[c] = tblRiw.getModel().getValueAt(i, c);
        }
        dlgNota nota = new dlgNota(Dialogs.owner(this), true);
        nota.setNotaTransaksi(baris);
        nota.setVisible(true);
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
        btnCetakNotaRiw = new javax.swing.JButton();
        scrRiw = new javax.swing.JScrollPane();
        tblRiw = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(980, 700));
        setBackground(new java.awt.Color(246, 241, 231));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderRw.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderRw.setOpaque(false);
        pnlHeaderRw.setLayout(new java.awt.BorderLayout());

        pnlTitlesRw.setAlignmentX(0.0F);
        pnlTitlesRw.setOpaque(false);
        pnlTitlesRw.setLayout(new javax.swing.BoxLayout(pnlTitlesRw, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitleRw.setText("Riwayat");
        lblTitleRw.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitleRw.setForeground(new java.awt.Color(29, 42, 34));
        pnlTitlesRw.add(lblTitleRw);

        lblSubRw.setText("Riwayat transaksi di kios Anda. Pilih satu baris lalu klik Cetak Bukti Penyaluran.");
        lblSubRw.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubRw.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesRw.add(lblSubRw);

        pnlHeaderRw.add(pnlTitlesRw, java.awt.BorderLayout.WEST);

        pnlTopRw.setOpaque(false);
        pnlTopRw.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderRw.add(pnlTopRw, java.awt.BorderLayout.EAST);

        add(pnlHeaderRw, java.awt.BorderLayout.NORTH);

        scrBodyRw.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterRw.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterRw.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterRw.setLayout(new java.awt.BorderLayout());

        pnlStackRw.setAlignmentX(0.0F);
        pnlStackRw.setOpaque(false);
        pnlStackRw.setLayout(new javax.swing.BoxLayout(pnlStackRw, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapRw0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapRw0.setAlignmentX(0.0F);
        pnlGapRw0.setOpaque(false);
        pnlGapRw0.setLayout(new java.awt.BorderLayout());

        pnlCardRiw.setAlignmentX(0.0F);
        pnlCardRiw.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardRiw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardRiw.setLayout(new javax.swing.BoxLayout(pnlCardRiw, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadRiw.setAlignmentX(0.0F);
        pnlHeadRiw.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadRiw.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadRiw.setOpaque(false);
        pnlHeadRiw.setLayout(new java.awt.BorderLayout());

        lblHRiw.setText("Riwayat penyaluran");
        lblHRiw.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHRiw.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadRiw.add(lblHRiw, java.awt.BorderLayout.WEST);

        pnlCardRiw.add(pnlHeadRiw);

        pnlToolRiw.setAlignmentX(0.0F);
        pnlToolRiw.setMaximumSize(new java.awt.Dimension(4000, 52));
        pnlToolRiw.setOpaque(false);
        pnlToolRiw.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCariRiw.setPreferredSize(new java.awt.Dimension(260, 40));
        txtCariRiw.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCariRiw.setForeground(new java.awt.Color(29, 42, 34));
        pnlToolRiw.add(txtCariRiw);

        btnCariRiw.setText("Cari");
        btnCariRiw.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCariRiw.setForeground(new java.awt.Color(255, 255, 255));
        btnCariRiw.setBackground(new java.awt.Color(31, 77, 58));
        btnCariRiw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariRiwActionPerformed(evt);
            }
        });
        pnlToolRiw.add(btnCariRiw);

        btnCetakNotaRiw.setBackground(new java.awt.Color(31, 77, 58));
        btnCetakNotaRiw.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCetakNotaRiw.setForeground(new java.awt.Color(255, 255, 255));
        btnCetakNotaRiw.setText("Cetak Bukti Penyaluran");
        btnCetakNotaRiw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakNotaRiwActionPerformed(evt);
            }
        });
        pnlToolRiw.add(btnCetakNotaRiw);

        pnlCardRiw.add(pnlToolRiw);

        scrRiw.setPreferredSize(new java.awt.Dimension(600, 420));
        scrRiw.setMaximumSize(new java.awt.Dimension(4000, 420));
        scrRiw.setAlignmentX(0.0F);

        tblRiw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Transaksi", "Tanggal", "Kategori", "Produk", "NIK", "Petani", "Jumlah (kg)", "Jenis", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrRiw.setViewportView(tblRiw);

        pnlCardRiw.add(scrRiw);

        pnlGapRw0.add(pnlCardRiw, java.awt.BorderLayout.CENTER);

        pnlStackRw.add(pnlGapRw0);

        pnlOuterRw.add(pnlStackRw, java.awt.BorderLayout.NORTH);

        scrBodyRw.setViewportView(pnlOuterRw);

        add(scrBodyRw, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakNotaRiwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakNotaRiwActionPerformed
        cetakNota();
    }//GEN-LAST:event_btnCetakNotaRiwActionPerformed

    private void btnCariRiwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariRiwActionPerformed
        TableKit.cari(tblRiw, txtCariRiw.getText());
    }//GEN-LAST:event_btnCariRiwActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariRiw;
    private javax.swing.JButton btnCetakNotaRiw;
    private javax.swing.JLabel lblHRiw;
    private javax.swing.JLabel lblSubRw;
    private javax.swing.JLabel lblTitleRw;
    private javax.swing.JPanel pnlCardRiw;
    private javax.swing.JPanel pnlGapRw0;
    private javax.swing.JPanel pnlHeadRiw;
    private javax.swing.JPanel pnlHeaderRw;
    private javax.swing.JPanel pnlOuterRw;
    private javax.swing.JPanel pnlStackRw;
    private javax.swing.JPanel pnlTitlesRw;
    private javax.swing.JPanel pnlToolRiw;
    private javax.swing.JPanel pnlTopRw;
    private javax.swing.JScrollPane scrBodyRw;
    private javax.swing.JScrollPane scrRiw;
    private javax.swing.JTable tblRiw;
    private javax.swing.JTextField txtCariRiw;
    // End of variables declaration//GEN-END:variables
}
