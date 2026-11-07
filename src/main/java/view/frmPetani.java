package view;

import view.util.*;

/** AGROVA — Petani. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class frmPetani extends javax.swing.JFrame {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public frmPetani() {
        initComponents();
        Styler.applyFrame(this);
        if (controller.Session.adaLogin()) {
            String nama = controller.GuiController.namaPengguna();
            lblLightSubRole.setText("<html>PETANI<br><b>" + esc(nama) + "</b></html>");
            lblSubSalam.setText("Halo, " + nama);
        }
        Styler.sidebar(pnlSidebar, new java.awt.Color(34, 44, 14));
        Styler.icon(navBeranda, Icons.Name.HOME);
        Styler.icon(navProduk, Icons.Name.SPROUT);
        Styler.icon(navPesan, Icons.Name.PLUS);
        Styler.icon(navStatus, Icons.Name.CLOCK);
        Styler.icon(navRiwayat, Icons.Name.HISTORY);
        Styler.icon(navProfil, Icons.Name.USERS);
        Styler.icon(navKeluar, Icons.Name.LOGOUT);
        Styler.icon(btnGhostNotif, Icons.Name.BELL);
        segarkanNotif();
        Nav.bind(pnlPages, new javax.swing.JToggleButton[]{navBeranda, navProduk, navPesan, navStatus, navRiwayat, navProfil}, new javax.swing.JPanel[]{new PgBerandaPetani(), new PgProduk(), new PgPesan(), new PgStatus(), new PgRiwayatPetani(), new PgProfil(controller.GuiController.profil())});
    }

    private static String esc(String t) {
        return t.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }


    /** Menampilkan jumlah notifikasi yang belum dibaca pada tombol lonceng. */
    private void segarkanNotif() {
        int n = controller.GuiController.jumlahNotifikasiBaru();
        btnGhostNotif.setText(n > 0 ? "Notifikasi (" + n + ")" : "Notifikasi");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSidebar = new javax.swing.JPanel();
        pnlNavTop = new javax.swing.JPanel();
        lblBrand = new javax.swing.JLabel();
        lblLightSubRole = new javax.swing.JLabel();
        navBeranda = new javax.swing.JToggleButton();
        navProduk = new javax.swing.JToggleButton();
        navPesan = new javax.swing.JToggleButton();
        navStatus = new javax.swing.JToggleButton();
        navRiwayat = new javax.swing.JToggleButton();
        navProfil = new javax.swing.JToggleButton();
        pnlNavBot = new javax.swing.JPanel();
        navKeluar = new javax.swing.JToggleButton();
        pnlMain = new javax.swing.JPanel();
        pnlTopbar = new javax.swing.JPanel();
        lblSubSalam = new javax.swing.JLabel();
        pnlTopAct = new javax.swing.JPanel();
        btnGhostNotif = new javax.swing.JButton();
        pnlPages = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGROVA — Petani");
        setExtendedState(6);
        setPreferredSize(new java.awt.Dimension(1280, 780));

        pnlSidebar.setPreferredSize(new java.awt.Dimension(236, 700));
        pnlSidebar.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 18, 22, 18));
        pnlSidebar.setBackground(new java.awt.Color(34, 44, 14));
        pnlSidebar.setLayout(new java.awt.BorderLayout());

        pnlNavTop.setAlignmentX(0.0F);
        pnlNavTop.setOpaque(false);
        pnlNavTop.setLayout(new javax.swing.BoxLayout(pnlNavTop, javax.swing.BoxLayout.PAGE_AXIS));

        lblBrand.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 4, 0, 0));
        lblBrand.setText("AGROVA");
        lblBrand.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        lblBrand.setForeground(new java.awt.Color(243, 238, 223));
        pnlNavTop.add(lblBrand);

        lblLightSubRole.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 4, 24, 0));
        lblLightSubRole.setText("<html>PETANI<br><b>Budi Santoso</b></html>");
        lblLightSubRole.setForeground(new java.awt.Color(181, 199, 183));
        pnlNavTop.add(lblLightSubRole);

        navBeranda.setMaximumSize(new java.awt.Dimension(4000, 44));
        navBeranda.setPreferredSize(new java.awt.Dimension(200, 44));
        navBeranda.setText("Beranda");
        navBeranda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navBeranda.setForeground(new java.awt.Color(181, 199, 183));
        navBeranda.setBackground(new java.awt.Color(34, 44, 14));
        pnlNavTop.add(navBeranda);

        navProduk.setMaximumSize(new java.awt.Dimension(4000, 44));
        navProduk.setPreferredSize(new java.awt.Dimension(200, 44));
        navProduk.setText("Produk");
        navProduk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navProduk.setForeground(new java.awt.Color(181, 199, 183));
        navProduk.setBackground(new java.awt.Color(34, 44, 14));
        pnlNavTop.add(navProduk);

        navPesan.setMaximumSize(new java.awt.Dimension(4000, 44));
        navPesan.setPreferredSize(new java.awt.Dimension(200, 44));
        navPesan.setText("Pesan");
        navPesan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navPesan.setForeground(new java.awt.Color(181, 199, 183));
        navPesan.setBackground(new java.awt.Color(34, 44, 14));
        pnlNavTop.add(navPesan);

        navStatus.setMaximumSize(new java.awt.Dimension(4000, 44));
        navStatus.setPreferredSize(new java.awt.Dimension(200, 44));
        navStatus.setText("Status Pesanan");
        navStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navStatus.setForeground(new java.awt.Color(181, 199, 183));
        navStatus.setBackground(new java.awt.Color(34, 44, 14));
        pnlNavTop.add(navStatus);

        navRiwayat.setMaximumSize(new java.awt.Dimension(4000, 44));
        navRiwayat.setPreferredSize(new java.awt.Dimension(200, 44));
        navRiwayat.setText("Riwayat");
        navRiwayat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navRiwayat.setForeground(new java.awt.Color(181, 199, 183));
        navRiwayat.setBackground(new java.awt.Color(34, 44, 14));
        pnlNavTop.add(navRiwayat);

        navProfil.setBackground(new java.awt.Color(34, 44, 14));
        navProfil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navProfil.setForeground(new java.awt.Color(181, 199, 183));
        navProfil.setText("Profil");
        navProfil.setMaximumSize(new java.awt.Dimension(4000, 44));
        navProfil.setPreferredSize(new java.awt.Dimension(200, 44));
        navProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navProfilActionPerformed(evt);
            }
        });
        pnlNavTop.add(navProfil);

        pnlSidebar.add(pnlNavTop, java.awt.BorderLayout.NORTH);

        pnlNavBot.setAlignmentX(0.0F);
        pnlNavBot.setOpaque(false);
        pnlNavBot.setLayout(new javax.swing.BoxLayout(pnlNavBot, javax.swing.BoxLayout.PAGE_AXIS));

        navKeluar.setPreferredSize(new java.awt.Dimension(200, 44));
        navKeluar.setText("Keluar");
        navKeluar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navKeluar.setForeground(new java.awt.Color(181, 199, 183));
        navKeluar.setBackground(new java.awt.Color(34, 44, 14));
        navKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navKeluarActionPerformed(evt);
            }
        });
        pnlNavBot.add(navKeluar);

        pnlSidebar.add(pnlNavBot, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlSidebar, java.awt.BorderLayout.WEST);

        pnlMain.setBackground(new java.awt.Color(246, 241, 231));
        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlTopbar.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 28, 4, 28));
        pnlTopbar.setOpaque(false);
        pnlTopbar.setLayout(new java.awt.BorderLayout());

        lblSubSalam.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubSalam.setForeground(new java.awt.Color(122, 127, 115));
        lblSubSalam.setText("Halo, Budi Santoso");
        pnlTopbar.add(lblSubSalam, java.awt.BorderLayout.WEST);

        pnlTopAct.setOpaque(false);
        pnlTopAct.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnGhostNotif.setText("Notifikasi");
        btnGhostNotif.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostNotif.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostNotif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostNotifActionPerformed(evt);
            }
        });
        pnlTopAct.add(btnGhostNotif);

        pnlTopbar.add(pnlTopAct, java.awt.BorderLayout.EAST);

        pnlMain.add(pnlTopbar, java.awt.BorderLayout.NORTH);

        pnlPages.setBackground(new java.awt.Color(246, 241, 231));
        pnlPages.setLayout(new java.awt.CardLayout());
        pnlMain.add(pnlPages, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 1294, 788);
    }// </editor-fold>//GEN-END:initComponents

    private void navKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navKeluarActionPerformed
        if (Dialogs.confirm(this, "Keluar dari AGROVA?")) {
            controller.Session.keluar();
            new frmLogin().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_navKeluarActionPerformed

    private void btnGhostNotifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostNotifActionPerformed
        new dlgNotifikasi(this, true).setVisible(true);
        segarkanNotif();
    }//GEN-LAST:event_btnGhostNotifActionPerformed

    private void navProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navProfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navProfilActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhostNotif;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblLightSubRole;
    private javax.swing.JLabel lblSubSalam;
    private javax.swing.JToggleButton navBeranda;
    private javax.swing.JToggleButton navKeluar;
    private javax.swing.JToggleButton navPesan;
    private javax.swing.JToggleButton navProduk;
    private javax.swing.JToggleButton navProfil;
    private javax.swing.JToggleButton navRiwayat;
    private javax.swing.JToggleButton navStatus;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNavBot;
    private javax.swing.JPanel pnlNavTop;
    private javax.swing.JPanel pnlPages;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlTopAct;
    private javax.swing.JPanel pnlTopbar;
    // End of variables declaration//GEN-END:variables
}
