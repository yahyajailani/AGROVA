package view;

import view.util.*;

/** AGROVA — Beranda. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class frmBeranda extends javax.swing.JFrame {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public frmBeranda() {
        initComponents();
        Styler.applyFrame(this);
        // menu atas hanya teks: tanpa ikon dan tanpa penanda kuning
        for (javax.swing.JToggleButton t : new javax.swing.JToggleButton[]{navBeranda, navTentang, navRekomendasi}) {
            t.putClientProperty("tanpaPenanda", Boolean.TRUE);
        }
        Nav.bind(pnlPages, new javax.swing.JToggleButton[]{navBeranda, navTentang, navRekomendasi}, new javax.swing.JPanel[]{new PgBerandaGuest(), new PgTentang(), new PgRekomendasi()});
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlForestNav = new javax.swing.JPanel();
        lblBrandTop = new javax.swing.JLabel();
        pnlNavMenu = new javax.swing.JPanel();
        navBeranda = new javax.swing.JToggleButton();
        navTentang = new javax.swing.JToggleButton();
        navRekomendasi = new javax.swing.JToggleButton();
        pnlKanan = new javax.swing.JPanel();
        btnGhostDaftarAtas = new javax.swing.JButton();
        btnGoldLoginAtas = new javax.swing.JButton();
        pnlPages = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGROVA — Beranda");
        setExtendedState(6);

        pnlForestNav.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 28, 12, 28));
        pnlForestNav.setBackground(new java.awt.Color(20, 53, 40));
        pnlForestNav.setLayout(new java.awt.BorderLayout());

        lblBrandTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_agrova.png"))); // NOI18N
        lblBrandTop.setIconTextGap(10);
        lblBrandTop.setText("");
        lblBrandTop.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        lblBrandTop.setForeground(new java.awt.Color(243, 238, 223));
        pnlForestNav.add(lblBrandTop, java.awt.BorderLayout.WEST);

        pnlNavMenu.setOpaque(false);

        navBeranda.setBackground(new java.awt.Color(20, 53, 40));
        navBeranda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navBeranda.setForeground(new java.awt.Color(181, 199, 183));
        navBeranda.setText("Beranda");
        navBeranda.setPreferredSize(new java.awt.Dimension(130, 40));
        pnlNavMenu.add(navBeranda);

        navTentang.setBackground(new java.awt.Color(20, 53, 40));
        navTentang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navTentang.setForeground(new java.awt.Color(181, 199, 183));
        navTentang.setText("Tentang Kami");
        navTentang.setPreferredSize(new java.awt.Dimension(150, 40));
        pnlNavMenu.add(navTentang);

        navRekomendasi.setBackground(new java.awt.Color(20, 53, 40));
        navRekomendasi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navRekomendasi.setForeground(new java.awt.Color(181, 199, 183));
        navRekomendasi.setText("Rekomendasi");
        navRekomendasi.setPreferredSize(new java.awt.Dimension(150, 40));
        pnlNavMenu.add(navRekomendasi);

        pnlForestNav.add(pnlNavMenu, java.awt.BorderLayout.CENTER);

        pnlKanan.setOpaque(false);
        pnlKanan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnGhostDaftarAtas.setText("Daftar");
        btnGhostDaftarAtas.setPreferredSize(new java.awt.Dimension(110, 40));
        btnGhostDaftarAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostDaftarAtasActionPerformed(evt);
            }
        });
        pnlKanan.add(btnGhostDaftarAtas);

        btnGoldLoginAtas.setText("Login");
        btnGoldLoginAtas.setPreferredSize(new java.awt.Dimension(110, 40));
        btnGoldLoginAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoldLoginAtasActionPerformed(evt);
            }
        });
        pnlKanan.add(btnGoldLoginAtas);

        pnlForestNav.add(pnlKanan, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlForestNav, java.awt.BorderLayout.NORTH);

        pnlPages.setBackground(new java.awt.Color(246, 241, 231));
        pnlPages.setLayout(new java.awt.CardLayout());
        getContentPane().add(pnlPages, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 1214, 768);
    }// </editor-fold>//GEN-END:initComponents


    private void btnGhostDaftarAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostDaftarAtasActionPerformed
        new frmDaftar().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGhostDaftarAtasActionPerformed

    private void btnGoldLoginAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoldLoginAtasActionPerformed
        new frmLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoldLoginAtasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhostDaftarAtas;
    private javax.swing.JButton btnGoldLoginAtas;
    private javax.swing.JLabel lblBrandTop;
    private javax.swing.JToggleButton navBeranda;
    private javax.swing.JToggleButton navRekomendasi;
    private javax.swing.JToggleButton navTentang;
    private javax.swing.JPanel pnlForestNav;
    private javax.swing.JPanel pnlKanan;
    private javax.swing.JPanel pnlNavMenu;
    private javax.swing.JPanel pnlPages;
    // End of variables declaration//GEN-END:variables
}
