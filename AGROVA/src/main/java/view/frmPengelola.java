package view;

import view.util.*;

/** AGROVA — Pengelola. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class frmPengelola extends javax.swing.JFrame {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public frmPengelola() {
        initComponents();
        Styler.applyFrame(this);
        if (controller.Session.adaLogin()) {
            String nama = controller.GuiController.namaPengguna();
            lblLightSubRole.setText("<html>PENGELOLA<br><b>" + esc(nama) + "</b></html>");
            lblSubSalam.setText("Halo, " + nama);
        }
        Styler.sidebar(pnlSidebar, new java.awt.Color(14, 42, 32));
        Styler.icon(navDashboard, Icons.Name.DASHBOARD);
        Styler.icon(navPenyaluran, Icons.Name.TRUCK);
        Styler.icon(navSubsidi, Icons.Name.LEAF);
        Styler.icon(navLihatData, Icons.Name.DATA);
        Styler.icon(navLaporan, Icons.Name.REPORT);
        Styler.icon(navProfil, Icons.Name.USERS);
        Styler.icon(navKeluar, Icons.Name.LOGOUT);
        Styler.icon(btnGhostNotif, Icons.Name.BELL);
        Nav.bind(pnlPages, new javax.swing.JToggleButton[]{navDashboard, navPenyaluran, navSubsidi, navLihatData, navLaporan, navProfil}, new javax.swing.JPanel[]{new PgDashboard(), new PgPenyaluran(), new PgSubsidi(), new PgLihatData(), new PgLaporan(), new PgProfil(controller.GuiController.profil())});
    }

    private static String esc(String t) {
        return t.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSidebar = new javax.swing.JPanel();
        pnlNavTop = new javax.swing.JPanel();
        lblBrand = new javax.swing.JLabel();
        lblLightSubRole = new javax.swing.JLabel();
        navDashboard = new javax.swing.JToggleButton();
        navPenyaluran = new javax.swing.JToggleButton();
        navSubsidi = new javax.swing.JToggleButton();
        navLihatData = new javax.swing.JToggleButton();
        navLaporan = new javax.swing.JToggleButton();
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
        setTitle("AGROVA — Pengelola");
        setExtendedState(6);
        setPreferredSize(new java.awt.Dimension(1280, 780));

        pnlSidebar.setPreferredSize(new java.awt.Dimension(236, 700));
        pnlSidebar.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 18, 22, 18));
        pnlSidebar.setBackground(new java.awt.Color(14, 42, 32));
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
        lblLightSubRole.setText("<html>PENGELOLA<br><b>Pengelola Root</b></html>");
        lblLightSubRole.setForeground(new java.awt.Color(181, 199, 183));
        pnlNavTop.add(lblLightSubRole);

        navDashboard.setMaximumSize(new java.awt.Dimension(4000, 44));
        navDashboard.setPreferredSize(new java.awt.Dimension(200, 44));
        navDashboard.setText("Dashboard");
        navDashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navDashboard.setForeground(new java.awt.Color(181, 199, 183));
        navDashboard.setBackground(new java.awt.Color(14, 42, 32));
        pnlNavTop.add(navDashboard);

        navPenyaluran.setMaximumSize(new java.awt.Dimension(4000, 44));
        navPenyaluran.setPreferredSize(new java.awt.Dimension(200, 44));
        navPenyaluran.setText("Penyaluran");
        navPenyaluran.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navPenyaluran.setForeground(new java.awt.Color(181, 199, 183));
        navPenyaluran.setBackground(new java.awt.Color(14, 42, 32));
        pnlNavTop.add(navPenyaluran);

        navSubsidi.setMaximumSize(new java.awt.Dimension(4000, 44));
        navSubsidi.setPreferredSize(new java.awt.Dimension(200, 44));
        navSubsidi.setText("Pupuk Subsidi");
        navSubsidi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navSubsidi.setForeground(new java.awt.Color(181, 199, 183));
        navSubsidi.setBackground(new java.awt.Color(14, 42, 32));
        pnlNavTop.add(navSubsidi);

        navLihatData.setMaximumSize(new java.awt.Dimension(4000, 44));
        navLihatData.setPreferredSize(new java.awt.Dimension(200, 44));
        navLihatData.setText("Lihat Data");
        navLihatData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navLihatData.setForeground(new java.awt.Color(181, 199, 183));
        navLihatData.setBackground(new java.awt.Color(14, 42, 32));
        pnlNavTop.add(navLihatData);

        navLaporan.setMaximumSize(new java.awt.Dimension(4000, 44));
        navLaporan.setPreferredSize(new java.awt.Dimension(200, 44));
        navLaporan.setText("Laporan");
        navLaporan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navLaporan.setForeground(new java.awt.Color(181, 199, 183));
        navLaporan.setBackground(new java.awt.Color(14, 42, 32));
        pnlNavTop.add(navLaporan);

        navProfil.setMaximumSize(new java.awt.Dimension(4000, 44));
        navProfil.setPreferredSize(new java.awt.Dimension(200, 44));
        navProfil.setText("Profil");
        navProfil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navProfil.setForeground(new java.awt.Color(181, 199, 183));
        navProfil.setBackground(new java.awt.Color(14, 42, 32));
        pnlNavTop.add(navProfil);

        pnlSidebar.add(pnlNavTop, java.awt.BorderLayout.NORTH);

        pnlNavBot.setAlignmentX(0.0F);
        pnlNavBot.setOpaque(false);
        pnlNavBot.setLayout(new javax.swing.BoxLayout(pnlNavBot, javax.swing.BoxLayout.PAGE_AXIS));

        navKeluar.setPreferredSize(new java.awt.Dimension(200, 44));
        navKeluar.setText("Keluar");
        navKeluar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navKeluar.setForeground(new java.awt.Color(181, 199, 183));
        navKeluar.setBackground(new java.awt.Color(14, 42, 32));
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

        lblSubSalam.setText("Halo, Pengelola Root");
        lblSubSalam.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubSalam.setForeground(new java.awt.Color(122, 127, 115));
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
    }//GEN-LAST:event_btnGhostNotifActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhostNotif;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblLightSubRole;
    private javax.swing.JLabel lblSubSalam;
    private javax.swing.JToggleButton navDashboard;
    private javax.swing.JToggleButton navKeluar;
    private javax.swing.JToggleButton navLaporan;
    private javax.swing.JToggleButton navLihatData;
    private javax.swing.JToggleButton navPenyaluran;
    private javax.swing.JToggleButton navProfil;
    private javax.swing.JToggleButton navSubsidi;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNavBot;
    private javax.swing.JPanel pnlNavTop;
    private javax.swing.JPanel pnlPages;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlTopAct;
    private javax.swing.JPanel pnlTopbar;
    // End of variables declaration//GEN-END:variables
}
