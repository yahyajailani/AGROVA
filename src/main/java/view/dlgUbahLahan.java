package view;

import controller.GuiController;
import view.util.*;

/** Pop-up untuk memperbarui luas lahan petani (hanya boleh membesar; golongan ikut berubah otomatis). Tampilan dikelola NetBeans GUI Builder (tab Design). */
public class dlgUbahLahan extends javax.swing.JDialog {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    private boolean tersimpan;

    public dlgUbahLahan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Styler.applyDialog(this);
        InputFilters.decimal(txtLuasBaru, 2, 2);
        lblBLuasNow.setFont(Theme.sans(14f, java.awt.Font.BOLD));
        try {
            lblBLuasNow.setText(GuiController.luasLahanSaya());
        } catch (RuntimeException e) {
            lblBLuasNow.setText("-");
        }
        txtLuasBaru.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { hitungGolongan(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { hitungGolongan(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { hitungGolongan(); }
        });
    }

    /** @return true bila luas lahan berhasil disimpan. */
    public boolean isTersimpan() {
        return tersimpan;
    }

    private void hitungGolongan() {
        lblHintGol.setText("Golongan setelah diperbarui: " + GuiController.golonganUntukLuas(txtLuasBaru.getText()));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBodyUbah = new javax.swing.JPanel();
        lblHUbah = new javax.swing.JLabel();
        lblSubUbah = new javax.swing.JLabel();
        lblFieldLuasNow = new javax.swing.JLabel();
        lblBLuasNow = new javax.swing.JLabel();
        lblFieldLuasBaru = new javax.swing.JLabel();
        txtLuasBaru = new javax.swing.JTextField();
        lblHintGol = new javax.swing.JLabel();
        lblHintAturan = new javax.swing.JLabel();
        pnlActUbah = new javax.swing.JPanel();
        btnGhostBatalUbah = new javax.swing.JButton();
        btnSimpanUbah = new javax.swing.JButton();

        setTitle("Perbarui Luas Lahan");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(540, 380));
        setResizable(false);

        pnlBodyUbah.setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 18, 26));
        pnlBodyUbah.setAlignmentX(0.0F);
        pnlBodyUbah.setOpaque(false);
        pnlBodyUbah.setLayout(new javax.swing.BoxLayout(pnlBodyUbah, javax.swing.BoxLayout.PAGE_AXIS));

        lblHUbah.setText("Perbarui luas lahan");
        lblHUbah.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHUbah.setForeground(new java.awt.Color(29, 42, 34));
        lblHUbah.setAlignmentX(0.0F);
        pnlBodyUbah.add(lblHUbah);

        lblSubUbah.setText("Luas lahan hanya bisa diperbesar. Golongan dihitung ulang otomatis.");
        lblSubUbah.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubUbah.setForeground(new java.awt.Color(122, 127, 115));
        lblSubUbah.setAlignmentX(0.0F);
        lblSubUbah.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 14, 0));
        pnlBodyUbah.add(lblSubUbah);

        lblFieldLuasNow.setText("Luas lahan saat ini (ha)");
        lblFieldLuasNow.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldLuasNow.setForeground(new java.awt.Color(80, 86, 76));
        lblFieldLuasNow.setAlignmentX(0.0F);
        lblFieldLuasNow.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlBodyUbah.add(lblFieldLuasNow);

        lblBLuasNow.setText("-");
        lblBLuasNow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBLuasNow.setForeground(new java.awt.Color(29, 42, 34));
        lblBLuasNow.setAlignmentX(0.0F);
        lblBLuasNow.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 12, 0));
        pnlBodyUbah.add(lblBLuasNow);

        lblFieldLuasBaru.setText("Luas lahan baru (ha)");
        lblFieldLuasBaru.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldLuasBaru.setForeground(new java.awt.Color(80, 86, 76));
        lblFieldLuasBaru.setAlignmentX(0.0F);
        lblFieldLuasBaru.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlBodyUbah.add(lblFieldLuasBaru);

        txtLuasBaru.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLuasBaru.setForeground(new java.awt.Color(29, 42, 34));
        txtLuasBaru.setAlignmentX(0.0F);
        txtLuasBaru.setPreferredSize(new java.awt.Dimension(220, 42));
        txtLuasBaru.setMaximumSize(new java.awt.Dimension(4000, 42));
        pnlBodyUbah.add(txtLuasBaru);

        lblHintGol.setText("Golongan setelah diperbarui: -");
        lblHintGol.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblHintGol.setForeground(new java.awt.Color(122, 127, 115));
        lblHintGol.setAlignmentX(0.0F);
        lblHintGol.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 0, 0, 0));
        pnlBodyUbah.add(lblHintGol);

        lblHintAturan.setText("Gol A: di atas 2 ha. Gol B: 1 sampai 2 ha. Gol C: di bawah 1 ha.");
        lblHintAturan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblHintAturan.setForeground(new java.awt.Color(122, 127, 115));
        lblHintAturan.setAlignmentX(0.0F);
        lblHintAturan.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 14, 0));
        pnlBodyUbah.add(lblHintAturan);

        pnlActUbah.setAlignmentX(0.0F);
        pnlActUbah.setMaximumSize(new java.awt.Dimension(4000, 48));
        pnlActUbah.setOpaque(false);
        pnlActUbah.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnGhostBatalUbah.setText("Batal");
        btnGhostBatalUbah.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostBatalUbah.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostBatalUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostBatalUbahActionPerformed(evt);
            }
        });
        pnlActUbah.add(btnGhostBatalUbah);

        btnSimpanUbah.setText("Simpan");
        btnSimpanUbah.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSimpanUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanUbah.setBackground(new java.awt.Color(31, 77, 58));
        btnSimpanUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanUbahActionPerformed(evt);
            }
        });
        pnlActUbah.add(btnSimpanUbah);

        pnlBodyUbah.add(pnlActUbah);

        getContentPane().add(pnlBodyUbah, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 554, 388);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGhostBatalUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostBatalUbahActionPerformed
        dispose();
    }//GEN-LAST:event_btnGhostBatalUbahActionPerformed

    private void btnSimpanUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanUbahActionPerformed
        String teks = txtLuasBaru.getText().trim();
        if (teks.isEmpty()) {
            Dialogs.info(this, "Isi luas lahan baru terlebih dahulu.");
            return;
        }
        String[] hasil = new String[1];
        if (Dialogs.coba(this, () -> hasil[0] = GuiController.perbaruiLuasLahan(teks))) {
            tersimpan = true;
            Dialogs.info(this, "Luas lahan berhasil diperbarui. Golongan Anda sekarang " + hasil[0] + ".");
            dispose();
        }
    }//GEN-LAST:event_btnSimpanUbahActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhostBatalUbah;
    private javax.swing.JButton btnSimpanUbah;
    private javax.swing.JLabel lblBLuasNow;
    private javax.swing.JLabel lblFieldLuasBaru;
    private javax.swing.JLabel lblFieldLuasNow;
    private javax.swing.JLabel lblHUbah;
    private javax.swing.JLabel lblHintAturan;
    private javax.swing.JLabel lblHintGol;
    private javax.swing.JLabel lblSubUbah;
    private javax.swing.JPanel pnlActUbah;
    private javax.swing.JPanel pnlBodyUbah;
    private javax.swing.JTextField txtLuasBaru;
    // End of variables declaration//GEN-END:variables
}
