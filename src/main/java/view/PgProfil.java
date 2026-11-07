package view;

import controller.GuiController;
import view.util.*;

/** Profil pengguna yang sedang masuk (pengelola, penyalur, atau petani). Tampilan dikelola NetBeans GUI Builder (tab Design). */
public class PgProfil extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgProfil() {
        initComponents();
        Styler.apply(this);
        lblAvatarProf.setForeground(Theme.ON_DARK);
        lblAvatarProf.setFont(Theme.serif(24f, java.awt.Font.PLAIN));
        lblNamaProf.setFont(Theme.serif(20f, java.awt.Font.PLAIN));
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblValProf1, lblValProf2, lblValProf3, lblValProf4, lblValProf5, lblValProf6, lblValProf7}) {
            l.setFont(Theme.sans(13.5f, java.awt.Font.BOLD));
        }
    }

    /** @param baris pasangan {label, nilai}; baris pertama = nama (kepala profil), selebihnya mengisi baris di kartu. */
    public PgProfil(String[][] baris) {
        this();
        muat(baris);
    }

    public final void muat(String[][] baris) {
        btnPerbarui.setVisible("petani".equals(GuiController.peran())); // hanya petani yang bisa memperbarui lahan
        javax.swing.JLabel[] key = {lblKeyProf1, lblKeyProf2, lblKeyProf3, lblKeyProf4, lblKeyProf5, lblKeyProf6, lblKeyProf7};
        javax.swing.JLabel[] val = {lblValProf1, lblValProf2, lblValProf3, lblValProf4, lblValProf5, lblValProf6, lblValProf7};
        javax.swing.JPanel[] row = {pnlBarisProf1, pnlBarisProf2, pnlBarisProf3, pnlBarisProf4, pnlBarisProf5, pnlBarisProf6, pnlBarisProf7};
        String nama = baris.length > 0 ? baris[0][1] : "-";
        lblNamaProf.setText(nama);
        lblAvatarProf.setText(nama.isBlank() ? "?" : nama.substring(0, 1).toUpperCase());
        for (int i = 0; i < row.length; i++) {
            boolean ada = i + 1 < baris.length;
            row[i].setVisible(ada);
            if (ada) {
                key[i].setText(baris[i + 1][0]);
                val[i].setText(baris[i + 1][1]);
            }
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeadProf = new javax.swing.JPanel();
        lblTitleProf = new javax.swing.JLabel();
        lblSubProf = new javax.swing.JLabel();
        pnlWrapProf = new javax.swing.JPanel();
        pnlCardProf = new javax.swing.JPanel();
        pnlIsiProf = new javax.swing.JPanel();
        pnlAtasProf = new javax.swing.JPanel();
        lblAvatarProf = new javax.swing.JLabel();
        lblNamaProf = new javax.swing.JLabel();
        lblGapProf = new javax.swing.JLabel();
        pnlBarisProf1 = new javax.swing.JPanel();
        lblKeyProf1 = new javax.swing.JLabel();
        lblValProf1 = new javax.swing.JLabel();
        pnlBarisProf2 = new javax.swing.JPanel();
        lblKeyProf2 = new javax.swing.JLabel();
        lblValProf2 = new javax.swing.JLabel();
        pnlBarisProf3 = new javax.swing.JPanel();
        lblKeyProf3 = new javax.swing.JLabel();
        lblValProf3 = new javax.swing.JLabel();
        pnlBarisProf4 = new javax.swing.JPanel();
        lblKeyProf4 = new javax.swing.JLabel();
        lblValProf4 = new javax.swing.JLabel();
        pnlBarisProf5 = new javax.swing.JPanel();
        lblKeyProf5 = new javax.swing.JLabel();
        lblValProf5 = new javax.swing.JLabel();
        pnlBarisProf6 = new javax.swing.JPanel();
        lblKeyProf6 = new javax.swing.JLabel();
        lblValProf6 = new javax.swing.JLabel();
        pnlBarisProf7 = new javax.swing.JPanel();
        lblKeyProf7 = new javax.swing.JLabel();
        lblValProf7 = new javax.swing.JLabel();
        btnPerbarui = new javax.swing.JButton();

        setBackground(new java.awt.Color(246, 241, 231));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());

        pnlHeadProf.setOpaque(false);
        pnlHeadProf.setLayout(new javax.swing.BoxLayout(pnlHeadProf, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitleProf.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitleProf.setForeground(new java.awt.Color(29, 42, 34));
        lblTitleProf.setText("Profil");
        pnlHeadProf.add(lblTitleProf);

        lblSubProf.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubProf.setForeground(new java.awt.Color(122, 127, 115));
        lblSubProf.setText("Data akun Anda di AGROVA.");
        lblSubProf.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 16, 0));
        pnlHeadProf.add(lblSubProf);

        add(pnlHeadProf, java.awt.BorderLayout.NORTH);

        pnlWrapProf.setOpaque(false);
        pnlWrapProf.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        pnlCardProf.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardProf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardProf.setPreferredSize(new java.awt.Dimension(560, 420));
        pnlCardProf.setLayout(new java.awt.BorderLayout());

        pnlIsiProf.setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        pnlIsiProf.setOpaque(false);
        pnlIsiProf.setLayout(new javax.swing.BoxLayout(pnlIsiProf, javax.swing.BoxLayout.PAGE_AXIS));

        pnlAtasProf.setAlignmentX(0.0F);
        pnlAtasProf.setMaximumSize(new java.awt.Dimension(4000, 64));
        pnlAtasProf.setOpaque(false);
        pnlAtasProf.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblAvatarProf.setBackground(new java.awt.Color(31, 77, 58));
        lblAvatarProf.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        lblAvatarProf.setForeground(new java.awt.Color(243, 238, 223));
        lblAvatarProf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatarProf.setText("A");
        lblAvatarProf.setOpaque(true);
        lblAvatarProf.setPreferredSize(new java.awt.Dimension(54, 54));
        pnlAtasProf.add(lblAvatarProf);

        lblNamaProf.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNamaProf.setForeground(new java.awt.Color(29, 42, 34));
        lblNamaProf.setText("Nama pengguna");
        pnlAtasProf.add(lblNamaProf);

        pnlIsiProf.add(pnlAtasProf);

        lblGapProf.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblGapProf.setForeground(new java.awt.Color(29, 42, 34));
        lblGapProf.setText(" ");
        lblGapProf.setPreferredSize(new java.awt.Dimension(10, 14));
        pnlIsiProf.add(lblGapProf);

        pnlBarisProf1.setAlignmentX(0.0F);
        pnlBarisProf1.setMaximumSize(new java.awt.Dimension(4000, 38));
        pnlBarisProf1.setOpaque(false);
        pnlBarisProf1.setLayout(new java.awt.BorderLayout());

        lblKeyProf1.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf1.setText("Email");
        lblKeyProf1.setPreferredSize(new java.awt.Dimension(160, 36));
        pnlBarisProf1.add(lblKeyProf1, java.awt.BorderLayout.WEST);

        lblValProf1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValProf1.setForeground(new java.awt.Color(29, 42, 34));
        lblValProf1.setText("nama@contoh.id");
        pnlBarisProf1.add(lblValProf1, java.awt.BorderLayout.CENTER);

        pnlIsiProf.add(pnlBarisProf1);

        pnlBarisProf2.setAlignmentX(0.0F);
        pnlBarisProf2.setMaximumSize(new java.awt.Dimension(4000, 38));
        pnlBarisProf2.setOpaque(false);
        pnlBarisProf2.setLayout(new java.awt.BorderLayout());

        lblKeyProf2.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf2.setText("No. telepon");
        lblKeyProf2.setPreferredSize(new java.awt.Dimension(160, 36));
        pnlBarisProf2.add(lblKeyProf2, java.awt.BorderLayout.WEST);

        lblValProf2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValProf2.setForeground(new java.awt.Color(29, 42, 34));
        lblValProf2.setText("0812xxxxxxxx");
        pnlBarisProf2.add(lblValProf2, java.awt.BorderLayout.CENTER);

        pnlIsiProf.add(pnlBarisProf2);

        pnlBarisProf3.setAlignmentX(0.0F);
        pnlBarisProf3.setMaximumSize(new java.awt.Dimension(4000, 38));
        pnlBarisProf3.setOpaque(false);
        pnlBarisProf3.setLayout(new java.awt.BorderLayout());

        lblKeyProf3.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf3.setText("Detail 1");
        lblKeyProf3.setPreferredSize(new java.awt.Dimension(160, 36));
        pnlBarisProf3.add(lblKeyProf3, java.awt.BorderLayout.WEST);

        lblValProf3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValProf3.setForeground(new java.awt.Color(29, 42, 34));
        lblValProf3.setText("-");
        pnlBarisProf3.add(lblValProf3, java.awt.BorderLayout.CENTER);

        pnlIsiProf.add(pnlBarisProf3);

        pnlBarisProf4.setAlignmentX(0.0F);
        pnlBarisProf4.setMaximumSize(new java.awt.Dimension(4000, 38));
        pnlBarisProf4.setOpaque(false);
        pnlBarisProf4.setLayout(new java.awt.BorderLayout());

        lblKeyProf4.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf4.setText("Detail 2");
        lblKeyProf4.setPreferredSize(new java.awt.Dimension(160, 36));
        pnlBarisProf4.add(lblKeyProf4, java.awt.BorderLayout.WEST);

        lblValProf4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValProf4.setForeground(new java.awt.Color(29, 42, 34));
        lblValProf4.setText("-");
        pnlBarisProf4.add(lblValProf4, java.awt.BorderLayout.CENTER);

        pnlIsiProf.add(pnlBarisProf4);

        pnlBarisProf5.setAlignmentX(0.0F);
        pnlBarisProf5.setMaximumSize(new java.awt.Dimension(4000, 38));
        pnlBarisProf5.setOpaque(false);
        pnlBarisProf5.setLayout(new java.awt.BorderLayout());

        lblKeyProf5.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf5.setText("Detail 3");
        lblKeyProf5.setPreferredSize(new java.awt.Dimension(160, 36));
        pnlBarisProf5.add(lblKeyProf5, java.awt.BorderLayout.WEST);

        lblValProf5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValProf5.setForeground(new java.awt.Color(29, 42, 34));
        lblValProf5.setText("-");
        pnlBarisProf5.add(lblValProf5, java.awt.BorderLayout.CENTER);

        pnlIsiProf.add(pnlBarisProf5);

        pnlBarisProf6.setAlignmentX(0.0F);
        pnlBarisProf6.setMaximumSize(new java.awt.Dimension(4000, 38));
        pnlBarisProf6.setOpaque(false);
        pnlBarisProf6.setLayout(new java.awt.BorderLayout());

        lblKeyProf6.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf6.setText("Detail 4");
        lblKeyProf6.setPreferredSize(new java.awt.Dimension(160, 36));
        pnlBarisProf6.add(lblKeyProf6, java.awt.BorderLayout.WEST);

        lblValProf6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValProf6.setForeground(new java.awt.Color(29, 42, 34));
        lblValProf6.setText("-");
        pnlBarisProf6.add(lblValProf6, java.awt.BorderLayout.CENTER);

        pnlIsiProf.add(pnlBarisProf6);

        pnlBarisProf7.setAlignmentX(0.0F);
        pnlBarisProf7.setMaximumSize(new java.awt.Dimension(4000, 38));
        pnlBarisProf7.setOpaque(false);
        pnlBarisProf7.setLayout(new java.awt.BorderLayout());

        lblKeyProf7.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf7.setText("Detail 5");
        lblKeyProf7.setPreferredSize(new java.awt.Dimension(160, 36));
        pnlBarisProf7.add(lblKeyProf7, java.awt.BorderLayout.WEST);

        lblValProf7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValProf7.setForeground(new java.awt.Color(29, 42, 34));
        lblValProf7.setText("-");
        pnlBarisProf7.add(lblValProf7, java.awt.BorderLayout.CENTER);

        pnlIsiProf.add(pnlBarisProf7);

        btnPerbarui.setText("Perbarui");
        btnPerbarui.setName("btnPerbarui"); // NOI18N
        btnPerbarui.setPreferredSize(new java.awt.Dimension(110, 40));
        btnPerbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerbaruiActionPerformed(evt);
            }
        });
        pnlIsiProf.add(btnPerbarui);

        pnlCardProf.add(pnlIsiProf, java.awt.BorderLayout.CENTER);

        pnlWrapProf.add(pnlCardProf);

        add(pnlWrapProf, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerbaruiActionPerformed
        dlgUbahLahan dlg = new dlgUbahLahan(Dialogs.owner(this), true);
        dlg.setVisible(true);
        if (dlg.isTersimpan()) {
            muat(GuiController.profil());
        }
    }//GEN-LAST:event_btnPerbaruiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPerbarui;
    private javax.swing.JLabel lblAvatarProf;
    private javax.swing.JLabel lblGapProf;
    private javax.swing.JLabel lblKeyProf1;
    private javax.swing.JLabel lblKeyProf2;
    private javax.swing.JLabel lblKeyProf3;
    private javax.swing.JLabel lblKeyProf4;
    private javax.swing.JLabel lblKeyProf5;
    private javax.swing.JLabel lblKeyProf6;
    private javax.swing.JLabel lblKeyProf7;
    private javax.swing.JLabel lblNamaProf;
    private javax.swing.JLabel lblSubProf;
    private javax.swing.JLabel lblTitleProf;
    private javax.swing.JLabel lblValProf1;
    private javax.swing.JLabel lblValProf2;
    private javax.swing.JLabel lblValProf3;
    private javax.swing.JLabel lblValProf4;
    private javax.swing.JLabel lblValProf5;
    private javax.swing.JLabel lblValProf6;
    private javax.swing.JLabel lblValProf7;
    private javax.swing.JPanel pnlAtasProf;
    private javax.swing.JPanel pnlBarisProf1;
    private javax.swing.JPanel pnlBarisProf2;
    private javax.swing.JPanel pnlBarisProf3;
    private javax.swing.JPanel pnlBarisProf4;
    private javax.swing.JPanel pnlBarisProf5;
    private javax.swing.JPanel pnlBarisProf6;
    private javax.swing.JPanel pnlBarisProf7;
    private javax.swing.JPanel pnlCardProf;
    private javax.swing.JPanel pnlHeadProf;
    private javax.swing.JPanel pnlIsiProf;
    private javax.swing.JPanel pnlWrapProf;
    // End of variables declaration//GEN-END:variables
}
