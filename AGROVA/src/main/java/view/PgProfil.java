package view;

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

        setName("PgProfil");
        setBackground(new java.awt.Color(246, 241, 231));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());
        pnlHeadProf.setName("pnlHeadProf");
        pnlHeadProf.setOpaque(false);
        lblTitleProf.setName("lblTitleProf");
        lblTitleProf.setText("Profil");
        lblTitleProf.setFont(new java.awt.Font("Georgia", 0, 26));
        lblTitleProf.setForeground(new java.awt.Color(29, 42, 34));
        lblSubProf.setName("lblSubProf");
        lblSubProf.setText("Data akun Anda di AGROVA.");
        lblSubProf.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubProf.setForeground(new java.awt.Color(122, 127, 115));
        lblSubProf.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 16, 0));
        pnlWrapProf.setName("pnlWrapProf");
        pnlWrapProf.setOpaque(false);
        pnlCardProf.setName("pnlCardProf");
        pnlCardProf.setOpaque(true);
        pnlCardProf.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardProf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardProf.setPreferredSize(new java.awt.Dimension(560, 420));
        pnlIsiProf.setName("pnlIsiProf");
        pnlIsiProf.setOpaque(false);
        pnlIsiProf.setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        pnlAtasProf.setName("pnlAtasProf");
        pnlAtasProf.setOpaque(false);
        pnlAtasProf.setAlignmentX(0.0f);
        pnlAtasProf.setMaximumSize(new java.awt.Dimension(4000, 64));
        lblAvatarProf.setName("lblAvatarProf");
        lblAvatarProf.setText("A");
        lblAvatarProf.setFont(new java.awt.Font("Georgia", 0, 24));
        lblAvatarProf.setForeground(new java.awt.Color(243, 238, 223));
        lblAvatarProf.setOpaque(true);
        lblAvatarProf.setBackground(new java.awt.Color(31, 77, 58));
        lblAvatarProf.setHorizontalAlignment(0);
        lblAvatarProf.setPreferredSize(new java.awt.Dimension(54, 54));
        lblNamaProf.setName("lblNamaProf");
        lblNamaProf.setText("Nama pengguna");
        lblNamaProf.setFont(new java.awt.Font("Georgia", 0, 20));
        lblNamaProf.setForeground(new java.awt.Color(29, 42, 34));
        lblGapProf.setName("lblGapProf");
        lblGapProf.setText(" ");
        lblGapProf.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblGapProf.setForeground(new java.awt.Color(29, 42, 34));
        lblGapProf.setPreferredSize(new java.awt.Dimension(10, 14));
        pnlBarisProf1.setName("pnlBarisProf1");
        pnlBarisProf1.setOpaque(false);
        pnlBarisProf1.setAlignmentX(0.0f);
        pnlBarisProf1.setMaximumSize(new java.awt.Dimension(4000, 38));
        lblKeyProf1.setName("lblKeyProf1");
        lblKeyProf1.setText("Email");
        lblKeyProf1.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblKeyProf1.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf1.setPreferredSize(new java.awt.Dimension(160, 36));
        lblValProf1.setName("lblValProf1");
        lblValProf1.setText("nama@contoh.id");
        lblValProf1.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblValProf1.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisProf2.setName("pnlBarisProf2");
        pnlBarisProf2.setOpaque(false);
        pnlBarisProf2.setAlignmentX(0.0f);
        pnlBarisProf2.setMaximumSize(new java.awt.Dimension(4000, 38));
        lblKeyProf2.setName("lblKeyProf2");
        lblKeyProf2.setText("No. telepon");
        lblKeyProf2.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblKeyProf2.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf2.setPreferredSize(new java.awt.Dimension(160, 36));
        lblValProf2.setName("lblValProf2");
        lblValProf2.setText("0812xxxxxxxx");
        lblValProf2.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblValProf2.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisProf3.setName("pnlBarisProf3");
        pnlBarisProf3.setOpaque(false);
        pnlBarisProf3.setAlignmentX(0.0f);
        pnlBarisProf3.setMaximumSize(new java.awt.Dimension(4000, 38));
        lblKeyProf3.setName("lblKeyProf3");
        lblKeyProf3.setText("Detail 1");
        lblKeyProf3.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblKeyProf3.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf3.setPreferredSize(new java.awt.Dimension(160, 36));
        lblValProf3.setName("lblValProf3");
        lblValProf3.setText("-");
        lblValProf3.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblValProf3.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisProf4.setName("pnlBarisProf4");
        pnlBarisProf4.setOpaque(false);
        pnlBarisProf4.setAlignmentX(0.0f);
        pnlBarisProf4.setMaximumSize(new java.awt.Dimension(4000, 38));
        lblKeyProf4.setName("lblKeyProf4");
        lblKeyProf4.setText("Detail 2");
        lblKeyProf4.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblKeyProf4.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf4.setPreferredSize(new java.awt.Dimension(160, 36));
        lblValProf4.setName("lblValProf4");
        lblValProf4.setText("-");
        lblValProf4.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblValProf4.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisProf5.setName("pnlBarisProf5");
        pnlBarisProf5.setOpaque(false);
        pnlBarisProf5.setAlignmentX(0.0f);
        pnlBarisProf5.setMaximumSize(new java.awt.Dimension(4000, 38));
        lblKeyProf5.setName("lblKeyProf5");
        lblKeyProf5.setText("Detail 3");
        lblKeyProf5.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblKeyProf5.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf5.setPreferredSize(new java.awt.Dimension(160, 36));
        lblValProf5.setName("lblValProf5");
        lblValProf5.setText("-");
        lblValProf5.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblValProf5.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisProf6.setName("pnlBarisProf6");
        pnlBarisProf6.setOpaque(false);
        pnlBarisProf6.setAlignmentX(0.0f);
        pnlBarisProf6.setMaximumSize(new java.awt.Dimension(4000, 38));
        lblKeyProf6.setName("lblKeyProf6");
        lblKeyProf6.setText("Detail 4");
        lblKeyProf6.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblKeyProf6.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf6.setPreferredSize(new java.awt.Dimension(160, 36));
        lblValProf6.setName("lblValProf6");
        lblValProf6.setText("-");
        lblValProf6.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblValProf6.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisProf7.setName("pnlBarisProf7");
        pnlBarisProf7.setOpaque(false);
        pnlBarisProf7.setAlignmentX(0.0f);
        pnlBarisProf7.setMaximumSize(new java.awt.Dimension(4000, 38));
        lblKeyProf7.setName("lblKeyProf7");
        lblKeyProf7.setText("Detail 5");
        lblKeyProf7.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblKeyProf7.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyProf7.setPreferredSize(new java.awt.Dimension(160, 36));
        lblValProf7.setName("lblValProf7");
        lblValProf7.setText("-");
        lblValProf7.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblValProf7.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadProf.setLayout(new javax.swing.BoxLayout(pnlHeadProf, javax.swing.BoxLayout.PAGE_AXIS));
        pnlWrapProf.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        pnlCardProf.setLayout(new java.awt.BorderLayout());
        pnlIsiProf.setLayout(new javax.swing.BoxLayout(pnlIsiProf, javax.swing.BoxLayout.PAGE_AXIS));
        pnlAtasProf.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 14, 0));
        pnlBarisProf1.setLayout(new java.awt.BorderLayout());
        pnlBarisProf2.setLayout(new java.awt.BorderLayout());
        pnlBarisProf3.setLayout(new java.awt.BorderLayout());
        pnlBarisProf4.setLayout(new java.awt.BorderLayout());
        pnlBarisProf5.setLayout(new java.awt.BorderLayout());
        pnlBarisProf6.setLayout(new java.awt.BorderLayout());
        pnlBarisProf7.setLayout(new java.awt.BorderLayout());
        pnlHeadProf.add(lblTitleProf);
        pnlHeadProf.add(lblSubProf);
        pnlAtasProf.add(lblAvatarProf);
        pnlAtasProf.add(lblNamaProf);
        pnlBarisProf1.add(lblKeyProf1, java.awt.BorderLayout.WEST);
        pnlBarisProf1.add(lblValProf1, java.awt.BorderLayout.CENTER);
        pnlBarisProf2.add(lblKeyProf2, java.awt.BorderLayout.WEST);
        pnlBarisProf2.add(lblValProf2, java.awt.BorderLayout.CENTER);
        pnlBarisProf3.add(lblKeyProf3, java.awt.BorderLayout.WEST);
        pnlBarisProf3.add(lblValProf3, java.awt.BorderLayout.CENTER);
        pnlBarisProf4.add(lblKeyProf4, java.awt.BorderLayout.WEST);
        pnlBarisProf4.add(lblValProf4, java.awt.BorderLayout.CENTER);
        pnlBarisProf5.add(lblKeyProf5, java.awt.BorderLayout.WEST);
        pnlBarisProf5.add(lblValProf5, java.awt.BorderLayout.CENTER);
        pnlBarisProf6.add(lblKeyProf6, java.awt.BorderLayout.WEST);
        pnlBarisProf6.add(lblValProf6, java.awt.BorderLayout.CENTER);
        pnlBarisProf7.add(lblKeyProf7, java.awt.BorderLayout.WEST);
        pnlBarisProf7.add(lblValProf7, java.awt.BorderLayout.CENTER);
        pnlIsiProf.add(pnlAtasProf);
        pnlIsiProf.add(lblGapProf);
        pnlIsiProf.add(pnlBarisProf1);
        pnlIsiProf.add(pnlBarisProf2);
        pnlIsiProf.add(pnlBarisProf3);
        pnlIsiProf.add(pnlBarisProf4);
        pnlIsiProf.add(pnlBarisProf5);
        pnlIsiProf.add(pnlBarisProf6);
        pnlIsiProf.add(pnlBarisProf7);
        pnlCardProf.add(pnlIsiProf, java.awt.BorderLayout.CENTER);
        pnlWrapProf.add(pnlCardProf);
        add(pnlHeadProf, java.awt.BorderLayout.NORTH);
        add(pnlWrapProf, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlHeadProf;
    private javax.swing.JLabel lblTitleProf;
    private javax.swing.JLabel lblSubProf;
    private javax.swing.JPanel pnlWrapProf;
    private javax.swing.JPanel pnlCardProf;
    private javax.swing.JPanel pnlIsiProf;
    private javax.swing.JPanel pnlAtasProf;
    private javax.swing.JLabel lblAvatarProf;
    private javax.swing.JLabel lblNamaProf;
    private javax.swing.JLabel lblGapProf;
    private javax.swing.JPanel pnlBarisProf1;
    private javax.swing.JLabel lblKeyProf1;
    private javax.swing.JLabel lblValProf1;
    private javax.swing.JPanel pnlBarisProf2;
    private javax.swing.JLabel lblKeyProf2;
    private javax.swing.JLabel lblValProf2;
    private javax.swing.JPanel pnlBarisProf3;
    private javax.swing.JLabel lblKeyProf3;
    private javax.swing.JLabel lblValProf3;
    private javax.swing.JPanel pnlBarisProf4;
    private javax.swing.JLabel lblKeyProf4;
    private javax.swing.JLabel lblValProf4;
    private javax.swing.JPanel pnlBarisProf5;
    private javax.swing.JLabel lblKeyProf5;
    private javax.swing.JLabel lblValProf5;
    private javax.swing.JPanel pnlBarisProf6;
    private javax.swing.JLabel lblKeyProf6;
    private javax.swing.JLabel lblValProf6;
    private javax.swing.JPanel pnlBarisProf7;
    private javax.swing.JLabel lblKeyProf7;
    private javax.swing.JLabel lblValProf7;
    // End of variables declaration//GEN-END:variables
}
