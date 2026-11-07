package view;

import view.util.*;

/** AGROVA — Penyalur. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class frmPenyalur extends javax.swing.JFrame {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public frmPenyalur() {
        initComponents();
        Styler.applyFrame(this);
        if (controller.Session.adaLogin()) {
            String nama = controller.GuiController.namaPengguna();
            lblLightSubRole.setText("<html>PENYALUR<br><b>" + esc(nama) + "</b></html>");
            lblSubSalam.setText("Halo, " + nama);
        }
        Styler.sidebar(pnlSidebar, new java.awt.Color(11, 38, 48));
        Styler.icon(navBeranda, Icons.Name.HOME);
        Styler.icon(navKonfirmasi, Icons.Name.CHECK);
        Styler.icon(navSalurkan, Icons.Name.TRUCK);
        Styler.icon(navStok, Icons.Name.WAREHOUSE);
        Styler.icon(navRiwayat, Icons.Name.HISTORY);
        Styler.icon(navProfil, Icons.Name.USERS);
        Styler.icon(navKeluar, Icons.Name.LOGOUT);
        Styler.icon(btnGhostNotif, Icons.Name.BELL);
        Nav.bind(pnlPages, new javax.swing.JToggleButton[]{navBeranda, navKonfirmasi, navSalurkan, navStok, navRiwayat, navProfil}, new javax.swing.JPanel[]{new PgBerandaPenyalur(), new PgKonfirmasi(), new PgSalurkan(), new PgStok(), new PgRiwayatPenyalur(), new PgProfil(controller.GuiController.profil())});
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
        navBeranda = new javax.swing.JToggleButton();
        navKonfirmasi = new javax.swing.JToggleButton();
        navSalurkan = new javax.swing.JToggleButton();
        navStok = new javax.swing.JToggleButton();
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
        setTitle("AGROVA — Penyalur");
        setExtendedState(6);
        setPreferredSize(new java.awt.Dimension(1280, 780));

        pnlSidebar.setBackground(new java.awt.Color(11, 38, 48));
        pnlSidebar.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 18, 22, 18));
        pnlSidebar.setPreferredSize(new java.awt.Dimension(236, 700));
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
        lblLightSubRole.setText("<html>PENYALUR<br><b>Tani Makmur</b></html>");
        lblLightSubRole.setForeground(new java.awt.Color(181, 199, 183));
        pnlNavTop.add(lblLightSubRole);

        navBeranda.setBackground(new java.awt.Color(11, 38, 48));
        navBeranda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navBeranda.setForeground(new java.awt.Color(181, 199, 183));
        navBeranda.setText("Beranda");
        navBeranda.setMaximumSize(new java.awt.Dimension(4000, 44));
        navBeranda.setPreferredSize(new java.awt.Dimension(200, 44));
        pnlNavTop.add(navBeranda);

        navKonfirmasi.setBackground(new java.awt.Color(11, 38, 48));
        navKonfirmasi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navKonfirmasi.setForeground(new java.awt.Color(181, 199, 183));
        navKonfirmasi.setText("Verifikasi");
        navKonfirmasi.setMaximumSize(new java.awt.Dimension(4000, 44));
        navKonfirmasi.setPreferredSize(new java.awt.Dimension(200, 44));
        pnlNavTop.add(navKonfirmasi);

        navSalurkan.setBackground(new java.awt.Color(11, 38, 48));
        navSalurkan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navSalurkan.setForeground(new java.awt.Color(181, 199, 183));
        navSalurkan.setText("Salurkan");
        navSalurkan.setMaximumSize(new java.awt.Dimension(4000, 44));
        navSalurkan.setPreferredSize(new java.awt.Dimension(200, 44));
        pnlNavTop.add(navSalurkan);

        navStok.setBackground(new java.awt.Color(11, 38, 48));
        navStok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navStok.setForeground(new java.awt.Color(181, 199, 183));
        navStok.setText("Stok");
        navStok.setMaximumSize(new java.awt.Dimension(4000, 44));
        navStok.setPreferredSize(new java.awt.Dimension(200, 44));
        pnlNavTop.add(navStok);

        navRiwayat.setBackground(new java.awt.Color(11, 38, 48));
        navRiwayat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navRiwayat.setForeground(new java.awt.Color(181, 199, 183));
        navRiwayat.setText("Riwayat");
        navRiwayat.setMaximumSize(new java.awt.Dimension(4000, 44));
        navRiwayat.setPreferredSize(new java.awt.Dimension(200, 44));
        pnlNavTop.add(navRiwayat);

        navProfil.setBackground(new java.awt.Color(11, 38, 48));
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
        navKeluar.setBackground(new java.awt.Color(11, 38, 48));
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

        lblSubSalam.setText("Halo, Tani Makmur");
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
    private javax.swing.JToggleButton navKonfirmasi;
    private javax.swing.JToggleButton navProfil;
    private javax.swing.JToggleButton navRiwayat;
    private javax.swing.JToggleButton navSalurkan;
    private javax.swing.JToggleButton navStok;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNavBot;
    private javax.swing.JPanel pnlNavTop;
    private javax.swing.JPanel pnlPages;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlTopAct;
    private javax.swing.JPanel pnlTopbar;
    // End of variables declaration//GEN-END:variables
}
