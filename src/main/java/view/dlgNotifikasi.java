package view;

import controller.GuiController;
import view.util.*;

/** Notifikasi. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class dlgNotifikasi extends javax.swing.JDialog {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public dlgNotifikasi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Styler.applyDialog(this);
        TableKit.muat(tblNotif, GuiController::notifikasi);
        GuiController.tandaiNotifikasiDibaca(); // yang baru saja tampil dianggap sudah dibaca
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBodyNotif = new javax.swing.JPanel();
        lblHNotif = new javax.swing.JLabel();
        lblSubNotif = new javax.swing.JLabel();
        scrNotif = new javax.swing.JScrollPane();
        tblNotif = new javax.swing.JTable();
        pnlActNotif = new javax.swing.JPanel();
        btnGhostTutup = new javax.swing.JButton();

        setTitle("Notifikasi");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(700, 420));
        setResizable(false);

        pnlBodyNotif.setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 18, 26));
        pnlBodyNotif.setAlignmentX(0.0F);
        pnlBodyNotif.setOpaque(false);
        pnlBodyNotif.setLayout(new javax.swing.BoxLayout(pnlBodyNotif, javax.swing.BoxLayout.PAGE_AXIS));

        lblHNotif.setText("Notifikasi");
        lblHNotif.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHNotif.setForeground(new java.awt.Color(29, 42, 34));
        pnlBodyNotif.add(lblHNotif);

        lblSubNotif.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 12, 0));
        lblSubNotif.setText("Pemberitahuan terbaru untuk akun Anda.");
        lblSubNotif.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubNotif.setForeground(new java.awt.Color(122, 127, 115));
        pnlBodyNotif.add(lblSubNotif);

        scrNotif.setPreferredSize(new java.awt.Dimension(640, 240));
        scrNotif.setMaximumSize(new java.awt.Dimension(4000, 240));
        scrNotif.setAlignmentX(0.0F);

        tblNotif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Waktu", "Judul", "Isi", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrNotif.setViewportView(tblNotif);

        pnlBodyNotif.add(scrNotif);

        pnlActNotif.setAlignmentX(0.0F);
        pnlActNotif.setMaximumSize(new java.awt.Dimension(4000, 48));
        pnlActNotif.setOpaque(false);
        pnlActNotif.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnGhostTutup.setText("Tutup");
        btnGhostTutup.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostTutup.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostTutupActionPerformed(evt);
            }
        });
        pnlActNotif.add(btnGhostTutup);

        pnlBodyNotif.add(pnlActNotif);

        getContentPane().add(pnlBodyNotif, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 714, 428);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGhostTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostTutupActionPerformed
        dispose();
    }//GEN-LAST:event_btnGhostTutupActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhostTutup;
    private javax.swing.JLabel lblHNotif;
    private javax.swing.JLabel lblSubNotif;
    private javax.swing.JPanel pnlActNotif;
    private javax.swing.JPanel pnlBodyNotif;
    private javax.swing.JScrollPane scrNotif;
    private javax.swing.JTable tblNotif;
    // End of variables declaration//GEN-END:variables
}
