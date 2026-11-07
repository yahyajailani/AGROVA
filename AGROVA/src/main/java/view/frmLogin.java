package view;


// atau import agrova.controller.AuthController; (sesuaikan dengan struktur folder proyek Anda)
import view.util.*;

/** AGROVA — Masuk. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class frmLogin extends javax.swing.JFrame {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public frmLogin() {
        initComponents();
        // layar penuh, form di tengah dan dapat digulir sehingga tidak ada elemen terpotong
        pnlForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 0, 24, 0));
        pnlForm.setPreferredSize(new java.awt.Dimension(440, pnlForm.getPreferredSize().height));
        getContentPane().remove(pnlForm);
        javax.swing.JPanel tengah = new javax.swing.JPanel(new java.awt.GridBagLayout());
        tengah.setOpaque(false);
        tengah.add(pnlForm, new java.awt.GridBagConstraints());
        javax.swing.JScrollPane gulir = new javax.swing.JScrollPane(tengah);
        gulir.setBorder(null);
        gulir.setOpaque(false);
        gulir.getViewport().setOpaque(false);
        gulir.getVerticalScrollBar().setUnitIncrement(16);
        getContentPane().add(gulir, java.awt.BorderLayout.CENTER);
        if (lblLightImgBrand.getIcon() instanceof javax.swing.ImageIcon gbr) {
            lblLightImgBrand.setIcon(Fields.penuh(gbr));
        }
        lblLightImgBrand.setOpaque(true);
        lblLightImgBrand.setBackground(Theme.FOREST_DEEP);
        Styler.applyFrame(this);
        // tombol mata dipasang SETELAH Styler (Styler mengganti UI kolom sandi dan akan membuang komponen di dalamnya)
        // tombol mata: tampilkan / sembunyikan sandi (komponen & ikonnya sudah ada di tab Design)
        pnlSandiBox.remove(mataSandi);
        mataSandi.setPreferredSize(new java.awt.Dimension(40, 36));
        Fields.mataDiDalam(txtSandi, mataSandi);
        mataSandi.addActionListener(e -> txtSandi.setEchoChar(mataSandi.isSelected() ? (char) 0 : '\u2022'));
        Styler.icon(btnMasuk, Icons.Name.ARROW);
        InputFilters.email(txtEmail, 60);
        InputFilters.password(txtSandi, 40);
        lblHintEmail.setForeground(Theme.CLAY);
        lblHintSandi.setForeground(Theme.CLAY);
        setMinimumSize(new java.awt.Dimension(900, 600));
        getRootPane().setDefaultButton(btnMasuk);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLightImgBrand = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        lblHLogin = new javax.swing.JLabel();
        lblSubLogin = new javax.swing.JLabel();
        lblGap1 = new javax.swing.JLabel();
        pnlFEmail = new javax.swing.JPanel();
        lblFieldEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblHintEmail = new javax.swing.JLabel();
        pnlFSandi = new javax.swing.JPanel();
        lblFieldSandi = new javax.swing.JLabel();
        pnlSandiBox = new javax.swing.JPanel();
        txtSandi = new javax.swing.JPasswordField();
        mataSandi = new javax.swing.JToggleButton();
        lblHintSandi = new javax.swing.JLabel();
        lblGap2 = new javax.swing.JLabel();
        btnMasuk = new javax.swing.JButton();
        lblGap3 = new javax.swing.JLabel();
        lblSubDaftar = new javax.swing.JLabel();
        pnlRow2 = new javax.swing.JPanel();
        btnGhostDaftar = new javax.swing.JButton();
        btnLinkBeranda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGROVA — Masuk");
        setExtendedState(6);
        setPreferredSize(new java.awt.Dimension(1180, 720));

        lblLightImgBrand.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblLightImgBrand.setForeground(new java.awt.Color(227, 237, 229));
        lblLightImgBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_brand.png"))); // NOI18N
        lblLightImgBrand.setText("<html><div style=\"width:330px\"><div style=\"font-family:Georgia;font-size:26px;color:white\">AGROVA</div><div style=\"color:#cfe0d4;font-size:10px\">Distribusi pupuk · Perusahaan Root · Samarinda</div><br><br><div style=\"font-family:Georgia;font-size:21px;color:white\">Dari gudang pusat sampai ke tangan petani.</div><br><div style=\"color:#e3ede5;font-size:11px\">Pantau kuota, stok, dan penyaluran pupuk  dalam satu tempat.</div><br><br><div style=\"color:white;font-size:11px\">");
        lblLightImgBrand.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLightImgBrand, java.awt.BorderLayout.WEST);

        pnlForm.setBackground(new java.awt.Color(246, 241, 231));
        pnlForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(70, 90, 40, 90));
        pnlForm.setAlignmentX(0.0F);
        pnlForm.setLayout(new javax.swing.BoxLayout(pnlForm, javax.swing.BoxLayout.PAGE_AXIS));

        lblHLogin.setText("Masuk ke akun");
        lblHLogin.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHLogin.setForeground(new java.awt.Color(29, 42, 34));
        pnlForm.add(lblHLogin);

        lblSubLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 14, 0));
        lblSubLogin.setText("Masukkan email dan kata sandi Anda.");
        lblSubLogin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubLogin.setForeground(new java.awt.Color(122, 127, 115));
        pnlForm.add(lblSubLogin);

        lblGap1.setText(" ");
        lblGap1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblGap1.setForeground(new java.awt.Color(29, 42, 34));
        pnlForm.add(lblGap1);

        pnlFEmail.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFEmail.setAlignmentX(0.0F);
        pnlFEmail.setOpaque(false);
        pnlFEmail.setLayout(new javax.swing.BoxLayout(pnlFEmail, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldEmail.setText("Email");
        lblFieldEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldEmail.setForeground(new java.awt.Color(29, 42, 34));
        pnlFEmail.add(lblFieldEmail);

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(29, 42, 34));
        txtEmail.setAlignmentX(0.0F);
        txtEmail.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtEmail.setPreferredSize(new java.awt.Dimension(220, 42));
        pnlFEmail.add(txtEmail);

        lblHintEmail.setText(" ");
        lblHintEmail.setForeground(new java.awt.Color(122, 127, 115));
        pnlFEmail.add(lblHintEmail);

        pnlForm.add(pnlFEmail);

        pnlFSandi.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFSandi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFSandi.setAlignmentX(0.0F);
        pnlFSandi.setOpaque(false);
        pnlFSandi.setLayout(new javax.swing.BoxLayout(pnlFSandi, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldSandi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldSandi.setText("Kata sandi");
        lblFieldSandi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldSandi.setForeground(new java.awt.Color(29, 42, 34));
        pnlFSandi.add(lblFieldSandi);

        pnlSandiBox.setMaximumSize(new java.awt.Dimension(4000, 42));
        pnlSandiBox.setAlignmentX(0.0F);
        pnlSandiBox.setPreferredSize(new java.awt.Dimension(220, 42));
        pnlSandiBox.setOpaque(false);
        pnlSandiBox.setLayout(new java.awt.BorderLayout());

        txtSandi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSandi.setForeground(new java.awt.Color(29, 42, 34));
        txtSandi.setAlignmentX(0.0F);
        txtSandi.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtSandi.setPreferredSize(new java.awt.Dimension(220, 42));
        pnlSandiBox.add(txtSandi, java.awt.BorderLayout.CENTER);

        mataSandi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye.png"))); // NOI18N
        mataSandi.setToolTipText("Tampilkan / sembunyikan kata sandi");
        mataSandi.setBorderPainted(false);
        mataSandi.setContentAreaFilled(false);
        mataSandi.setFocusPainted(false);
        mataSandi.setFocusable(false);
        mataSandi.setPreferredSize(new java.awt.Dimension(44, 42));
        mataSandi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye_off.png"))); // NOI18N
        pnlSandiBox.add(mataSandi, java.awt.BorderLayout.EAST);

        pnlFSandi.add(pnlSandiBox);

        lblHintSandi.setText(" ");
        lblHintSandi.setForeground(new java.awt.Color(122, 127, 115));
        pnlFSandi.add(lblHintSandi);

        pnlForm.add(pnlFSandi);

        lblGap2.setText(" ");
        lblGap2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblGap2.setForeground(new java.awt.Color(29, 42, 34));
        pnlForm.add(lblGap2);

        btnMasuk.setBackground(new java.awt.Color(31, 77, 58));
        btnMasuk.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMasuk.setForeground(new java.awt.Color(255, 255, 255));
        btnMasuk.setText("Masuk");
        btnMasuk.setMaximumSize(new java.awt.Dimension(4000, 46));
        btnMasuk.setPreferredSize(new java.awt.Dimension(300, 46));
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });
        pnlForm.add(btnMasuk);

        lblGap3.setText(" ");
        lblGap3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblGap3.setForeground(new java.awt.Color(29, 42, 34));
        pnlForm.add(lblGap3);

        lblSubDaftar.setText("Belum punya akun?");
        lblSubDaftar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubDaftar.setForeground(new java.awt.Color(122, 127, 115));
        lblSubDaftar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubDaftar.setMaximumSize(new java.awt.Dimension(4000, 24));
        pnlForm.add(lblSubDaftar);

        pnlRow2.setAlignmentX(0.0F);
        pnlRow2.setMaximumSize(new java.awt.Dimension(4000, 46));
        pnlRow2.setPreferredSize(new java.awt.Dimension(300, 46));
        pnlRow2.setOpaque(false);
        pnlRow2.setLayout(new java.awt.GridLayout(1, 2, 12, 0));

        btnGhostDaftar.setBackground(new java.awt.Color(246, 241, 231));
        btnGhostDaftar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostDaftar.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostDaftar.setText("Daftar");
        btnGhostDaftar.setBorder(null);
        btnGhostDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostDaftarActionPerformed(evt);
            }
        });
        pnlRow2.add(btnGhostDaftar);

        btnLinkBeranda.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLinkBeranda.setForeground(new java.awt.Color(31, 77, 58));
        btnLinkBeranda.setText("Kembali ke beranda");
        btnLinkBeranda.setContentAreaFilled(false);
        btnLinkBeranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkBerandaActionPerformed(evt);
            }
        });
        pnlRow2.add(btnLinkBeranda);

        pnlForm.add(pnlRow2);

        getContentPane().add(pnlForm, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 1194, 728);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        String email = txtEmail.getText().trim();
        String sandi = new String(txtSandi.getPassword());
        boolean ok = true;
        lblHintEmail.setText(" ");
        lblHintSandi.setText(" ");

        // 1. Validasi format email dasar
        if (!email.matches("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$")) {
            lblHintEmail.setText("Format email tidak valid");
            ok = false;
        }

        if (sandi.isEmpty()) {
            lblHintSandi.setText("Kata sandi wajib diisi");
            ok = false;
        }

        if (!ok) {
            return;
        }

        // 2. Autentikasi ke database. Peran (pengelola/penyalur/petani) ditentukan dari akun, bukan dari pilihan pengguna.
        String galat = controller.GuiController.login(email, sandi);
        if (galat != null) {
            if (galat.length() < 70) {
                lblHintSandi.setText(galat);
            } else {
                Dialogs.error(this, galat);
            }
            return;
        }

        javax.swing.JFrame next = switch (controller.GuiController.peran()) {
            case "pengelola" -> new frmPengelola();
            case "penyalur" -> new frmPenyalur();
            default -> new frmPetani();
        };
        next.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMasukActionPerformed

    private void btnGhostDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostDaftarActionPerformed
        new frmDaftar().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGhostDaftarActionPerformed

    private void btnLinkBerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkBerandaActionPerformed
        new frmBeranda().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLinkBerandaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhostDaftar;
    private javax.swing.JButton btnLinkBeranda;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JLabel lblFieldEmail;
    private javax.swing.JLabel lblFieldSandi;
    private javax.swing.JLabel lblGap1;
    private javax.swing.JLabel lblGap2;
    private javax.swing.JLabel lblGap3;
    private javax.swing.JLabel lblHLogin;
    private javax.swing.JLabel lblHintEmail;
    private javax.swing.JLabel lblHintSandi;
    private javax.swing.JLabel lblLightImgBrand;
    private javax.swing.JLabel lblSubDaftar;
    private javax.swing.JLabel lblSubLogin;
    private javax.swing.JToggleButton mataSandi;
    private javax.swing.JPanel pnlFEmail;
    private javax.swing.JPanel pnlFSandi;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlRow2;
    private javax.swing.JPanel pnlSandiBox;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtSandi;
    // End of variables declaration//GEN-END:variables
}
