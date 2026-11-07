package view;

import controller.GuiController;
import view.util.*;

/** Ubah Penyaluran. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class dlgUbahPenyaluran extends javax.swing.JDialog {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public dlgUbahPenyaluran(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Styler.applyDialog(this);
        InputFilters.digits(txtJumlah, 7);
        lblHintJumlah.setForeground(Theme.CLAY);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBodyUbah = new javax.swing.JPanel();
        lblHUbah = new javax.swing.JLabel();
        lblSubUbah = new javax.swing.JLabel();
        pnlFKec = new javax.swing.JPanel();
        lblFieldKec = new javax.swing.JLabel();
        cmbKec = new javax.swing.JComboBox();
        lblHintKec = new javax.swing.JLabel();
        lblFieldJumlah = new javax.swing.JLabel();
        pnlFJumlah = new javax.swing.JPanel();
        txtJumlah = new javax.swing.JTextField();
        lblHintJumlah = new javax.swing.JLabel();
        lblFieldKec1 = new javax.swing.JLabel();
        cmbKec1 = new javax.swing.JComboBox();
        pnlActUbah = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnGhostBatal = new javax.swing.JButton();

        setTitle("Ubah Penyaluran");
        setModal(true);
        setResizable(false);

        pnlBodyUbah.setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 18, 26));
        pnlBodyUbah.setAlignmentX(0.0F);
        pnlBodyUbah.setOpaque(false);
        pnlBodyUbah.setLayout(new javax.swing.BoxLayout(pnlBodyUbah, javax.swing.BoxLayout.PAGE_AXIS));

        lblHUbah.setText("Ubah penyaluran");
        lblHUbah.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHUbah.setForeground(new java.awt.Color(29, 42, 34));
        pnlBodyUbah.add(lblHUbah);

        lblSubUbah.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 12, 0));
        lblSubUbah.setText("Perbarui jumlah atau kecamatan tujuan.");
        lblSubUbah.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubUbah.setForeground(new java.awt.Color(122, 127, 115));
        pnlBodyUbah.add(lblSubUbah);

        pnlFKec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFKec.setAlignmentX(0.0F);
        pnlFKec.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFKec.setOpaque(false);
        pnlFKec.setLayout(new javax.swing.BoxLayout(pnlFKec, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldKec.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldKec.setForeground(new java.awt.Color(29, 42, 34));
        lblFieldKec.setText("Kecamatan");
        lblFieldKec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlFKec.add(lblFieldKec);

        cmbKec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbKec.setForeground(new java.awt.Color(29, 42, 34));
        cmbKec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Kecamatan", "Loa Janan Ilir", "Palaran", "Samarinda Ilir", "Samarinda Kota", "Samarinda Seberang", "Samarinda Ulu", "Samarinda Utara", "Sambutan", "Sungai Kunjang", "Sungai Pinang" }));
        cmbKec.setAlignmentX(0.0F);
        cmbKec.setMaximumSize(new java.awt.Dimension(4000, 42));
        cmbKec.setPreferredSize(new java.awt.Dimension(220, 42));
        cmbKec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKecActionPerformed(evt);
            }
        });
        pnlFKec.add(cmbKec);

        lblHintKec.setText(" ");
        lblHintKec.setForeground(new java.awt.Color(122, 127, 115));
        pnlFKec.add(lblHintKec);

        lblFieldJumlah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldJumlah.setForeground(new java.awt.Color(29, 42, 34));
        lblFieldJumlah.setText("Jumlah (kg)");
        lblFieldJumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlFKec.add(lblFieldJumlah);

        pnlBodyUbah.add(pnlFKec);

        pnlFJumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFJumlah.setAlignmentX(0.0F);
        pnlFJumlah.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFJumlah.setOpaque(false);
        pnlFJumlah.setLayout(new javax.swing.BoxLayout(pnlFJumlah, javax.swing.BoxLayout.PAGE_AXIS));

        txtJumlah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJumlah.setForeground(new java.awt.Color(29, 42, 34));
        txtJumlah.setAlignmentX(0.0F);
        txtJumlah.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtJumlah.setPreferredSize(new java.awt.Dimension(220, 42));
        pnlFJumlah.add(txtJumlah);

        lblHintJumlah.setText(" ");
        lblHintJumlah.setForeground(new java.awt.Color(122, 127, 115));
        pnlFJumlah.add(lblHintJumlah);

        lblFieldKec1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldKec1.setForeground(new java.awt.Color(29, 42, 34));
        lblFieldKec1.setText("Kategori");
        lblFieldKec1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldKec1.setName("lblFieldKec1"); // NOI18N
        pnlFJumlah.add(lblFieldKec1);

        cmbKec1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbKec1.setForeground(new java.awt.Color(29, 42, 34));
        cmbKec1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Kategori", "Subsidi", "Nonsubsidi" }));
        cmbKec1.setAlignmentX(0.0F);
        cmbKec1.setMaximumSize(new java.awt.Dimension(4000, 42));
        cmbKec1.setName("cmbKec1"); // NOI18N
        cmbKec1.setPreferredSize(new java.awt.Dimension(220, 42));
        cmbKec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKec1ActionPerformed(evt);
            }
        });
        pnlFJumlah.add(cmbKec1);

        pnlBodyUbah.add(pnlFJumlah);

        pnlActUbah.setAlignmentX(0.0F);
        pnlActUbah.setMaximumSize(new java.awt.Dimension(4000, 48));
        pnlActUbah.setOpaque(false);
        pnlActUbah.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlBodyUbah.add(pnlActUbah);

        btnSimpan.setBackground(new java.awt.Color(31, 77, 58));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        pnlBodyUbah.add(btnSimpan);

        btnGhostBatal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostBatal.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostBatal.setText("Batal");
        btnGhostBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostBatalActionPerformed(evt);
            }
        });
        pnlBodyUbah.add(btnGhostBatal);

        getContentPane().add(pnlBodyUbah, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 434, 388);
    }// </editor-fold>//GEN-END:initComponents

    private String kodePenyaluran;

    /** Mengisi dialog dengan data penyaluran terpilih. @return false bila data tidak dapat dimuat. */
    public boolean setPenyaluran(String kode) {
        try {
            String[] d = GuiController.detailPenyaluran(kode);
            kodePenyaluran = kode;
            lblSubUbah.setText(kode + " — hanya tujuan kecamatan dan jumlah yang dapat diubah.");
            cmbKec1.setSelectedItem(d[0]);
            cmbKec.setSelectedItem(d[1]);
            txtJumlah.setText(d[2]);
            return true;
        } catch (RuntimeException e) {
            Dialogs.gagal(this, e);
            return false;
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        lblHintJumlah.setText(" ");
        if (!txtJumlah.getText().matches("[1-9]\\d{0,6}")) {
            lblHintJumlah.setText("Jumlah harus bilangan bulat lebih dari 0");
            return;
        }
        if (kodePenyaluran == null) {
            dispose();
            return;
        }
        int kg = Integer.parseInt(txtJumlah.getText());
        String kategori = String.valueOf(cmbKec1.getSelectedItem());
        String kec = String.valueOf(cmbKec.getSelectedItem());
        if (Dialogs.coba(this, () -> GuiController.ubahPenyaluran(kodePenyaluran, kategori, kec, kg))) {
            dispose();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnGhostBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnGhostBatalActionPerformed

    private void cmbKecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKecActionPerformed

    private void cmbKec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKec1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKec1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhostBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbKec;
    private javax.swing.JComboBox cmbKec1;
    private javax.swing.JLabel lblFieldJumlah;
    private javax.swing.JLabel lblFieldKec;
    private javax.swing.JLabel lblFieldKec1;
    private javax.swing.JLabel lblHUbah;
    private javax.swing.JLabel lblHintJumlah;
    private javax.swing.JLabel lblHintKec;
    private javax.swing.JLabel lblSubUbah;
    private javax.swing.JPanel pnlActUbah;
    private javax.swing.JPanel pnlBodyUbah;
    private javax.swing.JPanel pnlFJumlah;
    private javax.swing.JPanel pnlFKec;
    private javax.swing.JTextField txtJumlah;
    // End of variables declaration//GEN-END:variables
}
