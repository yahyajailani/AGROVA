package view;

import view.util.*;

/** AGROVA — Buat Akun. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class frmDaftar extends javax.swing.JFrame {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

public frmDaftar() {
        initComponents();
        if (lblLightImgBrand.getIcon() instanceof javax.swing.ImageIcon gbr) {
            lblLightImgBrand.setIcon(Fields.penuh(gbr));
        }
        lblLightImgBrand.setOpaque(true);
        lblLightImgBrand.setBackground(Theme.FOREST_DEEP);
        Styler.applyFrame(this);
        
        for (javax.swing.JPasswordField pf : new javax.swing.JPasswordField[]{txtSandi, txtUlang, txtSandiP, txtUlangP}) Fields.pasangMata(pf);
        
        InputFilters.digits(txtNik, 16);
        InputFilters.nama(txtNama, 60);
        InputFilters.decimal(txtLuas, 2, 2);
        
        // Dikembalikan menggunakan filter email standar
        InputFilters.email(txtEmail, 60); 
        
        InputFilters.password(txtSandi, 40);
        InputFilters.password(txtUlang, 40);
        InputFilters.nama(txtNamaP, 60);
        InputFilters.digits(txtIzinP, 6);   
        InputFilters.digits(txtTelpP, 15);
        
        // Dikembalikan menggunakan filter email standar
        InputFilters.email(txtEmailP, 60); 
        
        InputFilters.password(txtSandiP, 40);
        InputFilters.password(txtUlangP, 40);
        
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblHintNik, lblHintNama, lblHintLuas, lblHintEmail, lblHintUlang, lblHintNamaP, lblHintIzinP, lblHintTelpP, lblHintEmailP, lblHintUlangP}) {
            l.setForeground(Theme.CLAY);
        }
        
        // Petunjuk format teks biasa (hint statis) untuk Petani
        lblFieldEmail.setText("Email Petani");
        lblHintEmail.setText("Contoh format: nama@petani.com");

        // Petunjuk format teks biasa (hint statis) untuk Penyalur
        lblFieldEmailP.setText("Email Penyalur");
        lblHintEmailP.setText("Contoh format: nama@kios.com");

        // Konfigurasi Tampilan Nomor Izin Usaha Otomatis
        lblFieldIzinP.setText("No. izin usaha (angka saja)");
        lblHintIzinP.setText("Format lengkap dibuat otomatis");
        txtIzinP.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            private void ubah() {
                String d = txtIzinP.getText();
                lblHintIzinP.setForeground(Theme.MUTED);
                lblHintIzinP.setText(d.isEmpty() || d.length() > 6 ? "Format lengkap dibuat otomatis"
                        : "Tercatat sebagai: " + String.format("SIUP/%d/%03d", java.time.Year.now().getValue(), Long.parseLong(d)));
            }
            @Override public void insertUpdate(javax.swing.event.DocumentEvent e) { ubah(); }
            @Override public void removeUpdate(javax.swing.event.DocumentEvent e) { ubah(); }
            @Override public void changedUpdate(javax.swing.event.DocumentEvent e) { ubah(); }
        });

        setMinimumSize(new java.awt.Dimension(900, 600));
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLightImgBrand = new javax.swing.JLabel();
        scrBodyDaftar = new javax.swing.JScrollPane();
        pnlOuterDaftar = new javax.swing.JPanel();
        pnlForm = new javax.swing.JPanel();
        lblHDaftar = new javax.swing.JLabel();
        lblSubDaftar = new javax.swing.JLabel();
        tabDaftar = new javax.swing.JTabbedPane();
        pnlTabPetani = new javax.swing.JPanel();
        pnlFNik = new javax.swing.JPanel();
        lblFieldNik = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        lblHintNik = new javax.swing.JLabel();
        pnlFNama = new javax.swing.JPanel();
        lblFieldNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblHintNama = new javax.swing.JLabel();
        pnlFKecamatan = new javax.swing.JPanel();
        lblFieldKecamatan = new javax.swing.JLabel();
        cmbKecamatan = new javax.swing.JComboBox();
        lblHintKecamatan = new javax.swing.JLabel();
        pnlFLuas = new javax.swing.JPanel();
        lblFieldLuas = new javax.swing.JLabel();
        txtLuas = new javax.swing.JTextField();
        lblHintLuas = new javax.swing.JLabel();
        pnlFEmail = new javax.swing.JPanel();
        lblFieldEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblHintEmail = new javax.swing.JLabel();
        pnlFSandi = new javax.swing.JPanel();
        lblFieldSandi = new javax.swing.JLabel();
        txtSandi = new javax.swing.JPasswordField();
        lblHintSandi = new javax.swing.JLabel();
        pnlFUlang = new javax.swing.JPanel();
        lblFieldUlang = new javax.swing.JLabel();
        txtUlang = new javax.swing.JPasswordField();
        lblHintUlang = new javax.swing.JLabel();
        btnDaftarPetani = new javax.swing.JButton();
        pnlTabPenyalur = new javax.swing.JPanel();
        pnlFNamaP = new javax.swing.JPanel();
        lblFieldNamaP = new javax.swing.JLabel();
        txtNamaP = new javax.swing.JTextField();
        lblHintNamaP = new javax.swing.JLabel();
        pnlFIzinP = new javax.swing.JPanel();
        lblFieldIzinP = new javax.swing.JLabel();
        txtIzinP = new javax.swing.JTextField();
        lblHintIzinP = new javax.swing.JLabel();
        pnlFKecP = new javax.swing.JPanel();
        lblFieldKecP = new javax.swing.JLabel();
        cmbKecP = new javax.swing.JComboBox();
        lblHintKecP = new javax.swing.JLabel();
        pnlFTelpP = new javax.swing.JPanel();
        lblFieldTelpP = new javax.swing.JLabel();
        txtTelpP = new javax.swing.JTextField();
        lblHintTelpP = new javax.swing.JLabel();
        pnlFEmailP = new javax.swing.JPanel();
        lblFieldEmailP = new javax.swing.JLabel();
        txtEmailP = new javax.swing.JTextField();
        lblHintEmailP = new javax.swing.JLabel();
        pnlFSandiP = new javax.swing.JPanel();
        lblFieldSandiP = new javax.swing.JLabel();
        txtSandiP = new javax.swing.JPasswordField();
        lblHintSandiP = new javax.swing.JLabel();
        pnlFUlangP = new javax.swing.JPanel();
        lblFieldUlangP = new javax.swing.JLabel();
        txtUlangP = new javax.swing.JPasswordField();
        lblHintUlangP = new javax.swing.JLabel();
        btnDaftarPenyalur = new javax.swing.JButton();
        pnlRow2 = new javax.swing.JPanel();
        lblSubSudah = new javax.swing.JLabel();
        btnGhostMasuk = new javax.swing.JButton();
        btnLinkBeranda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGROVA — Buat Akun");
        setExtendedState(6);

        lblLightImgBrand.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblLightImgBrand.setForeground(new java.awt.Color(227, 237, 229));
        lblLightImgBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/daftar_brand.png"))); // NOI18N
        lblLightImgBrand.setText("<html><div style=\"width:330px\"><div style=\"font-family:Georgia;font-size:26px;color:white\">AGROVA</div><div style=\"color:#cfe0d4;font-size:10px\">Distribusi pupuk subsidi · Perusahaan Root · Samarinda</div><br><br><div style=\"font-family:Georgia;font-size:21px;color:white\">Pupuk subsidi sampai ke tangan yang tepat.</div><br><div style=\"color:#e3ede5;font-size:11px\">Petani mendaftarkan lahan, penyalur mendaftarkan usahanya. Semua data tervalidasi dan tercatat.</div><br><br><div style=\"color:white;font-size:11px\">");
        lblLightImgBrand.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLightImgBrand, java.awt.BorderLayout.WEST);

        scrBodyDaftar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterDaftar.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterDaftar.setLayout(new java.awt.BorderLayout());

        pnlForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 40, 18, 40));
        pnlForm.setAlignmentX(0.0F);
        pnlForm.setOpaque(false);
        pnlForm.setLayout(new javax.swing.BoxLayout(pnlForm, javax.swing.BoxLayout.PAGE_AXIS));

        lblHDaftar.setText("Buat akun");
        lblHDaftar.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHDaftar.setForeground(new java.awt.Color(29, 42, 34));
        pnlForm.add(lblHDaftar);

        lblSubDaftar.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 10, 0));
        lblSubDaftar.setText("Pilih jenis akun: petani atau penyalur (pendaftaran kios).");
        lblSubDaftar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubDaftar.setForeground(new java.awt.Color(122, 127, 115));
        pnlForm.add(lblSubDaftar);

        tabDaftar.setAlignmentX(0.0F);
        tabDaftar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        pnlTabPetani.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 0, 8, 0));
        pnlTabPetani.setAlignmentX(0.0F);
        pnlTabPetani.setOpaque(false);
        pnlTabPetani.setLayout(new javax.swing.BoxLayout(pnlTabPetani, javax.swing.BoxLayout.PAGE_AXIS));

        pnlFNik.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFNik.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFNik.setAlignmentX(0.0F);
        pnlFNik.setOpaque(false);
        pnlFNik.setLayout(new javax.swing.BoxLayout(pnlFNik, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldNik.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldNik.setText("NIK (16 digit)");
        lblFieldNik.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldNik.setForeground(new java.awt.Color(29, 42, 34));
        pnlFNik.add(lblFieldNik);

        txtNik.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtNik.setAlignmentX(0.0F);
        txtNik.setPreferredSize(new java.awt.Dimension(220, 42));
        txtNik.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNik.setForeground(new java.awt.Color(29, 42, 34));
        txtNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNikActionPerformed(evt);
            }
        });
        pnlFNik.add(txtNik);

        lblHintNik.setText(" ");
        lblHintNik.setForeground(new java.awt.Color(122, 127, 115));
        pnlFNik.add(lblHintNik);

        pnlTabPetani.add(pnlFNik);

        pnlFNama.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFNama.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFNama.setAlignmentX(0.0F);
        pnlFNama.setOpaque(false);
        pnlFNama.setLayout(new javax.swing.BoxLayout(pnlFNama, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldNama.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldNama.setText("Nama lengkap");
        lblFieldNama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldNama.setForeground(new java.awt.Color(29, 42, 34));
        pnlFNama.add(lblFieldNama);

        txtNama.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtNama.setAlignmentX(0.0F);
        txtNama.setPreferredSize(new java.awt.Dimension(220, 42));
        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNama.setForeground(new java.awt.Color(29, 42, 34));
        pnlFNama.add(txtNama);

        lblHintNama.setText(" ");
        lblHintNama.setForeground(new java.awt.Color(122, 127, 115));
        pnlFNama.add(lblHintNama);

        pnlTabPetani.add(pnlFNama);

        pnlFKecamatan.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFKecamatan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFKecamatan.setAlignmentX(0.0F);
        pnlFKecamatan.setOpaque(false);
        pnlFKecamatan.setLayout(new javax.swing.BoxLayout(pnlFKecamatan, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldKecamatan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldKecamatan.setText("Kecamatan");
        lblFieldKecamatan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldKecamatan.setForeground(new java.awt.Color(29, 42, 34));
        pnlFKecamatan.add(lblFieldKecamatan);

        cmbKecamatan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbKecamatan.setForeground(new java.awt.Color(29, 42, 34));
        cmbKecamatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Kecamatan", "Loa Janan Ilir", "Palaran", "Samarinda Ilir", "Samarinda Kota", "Samarinda Seberang", "Samarinda Ulu", "Samarinda Utara", "Sambutan", "Sungai Kunjang", "Sungai Pinang" }));
        cmbKecamatan.setAlignmentX(0.0F);
        cmbKecamatan.setMaximumSize(new java.awt.Dimension(4000, 42));
        cmbKecamatan.setPreferredSize(new java.awt.Dimension(220, 42));
        pnlFKecamatan.add(cmbKecamatan);

        lblHintKecamatan.setText(" ");
        lblHintKecamatan.setForeground(new java.awt.Color(122, 127, 115));
        pnlFKecamatan.add(lblHintKecamatan);

        pnlTabPetani.add(pnlFKecamatan);

        pnlFLuas.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFLuas.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFLuas.setAlignmentX(0.0F);
        pnlFLuas.setOpaque(false);
        pnlFLuas.setLayout(new javax.swing.BoxLayout(pnlFLuas, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldLuas.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldLuas.setText("Luas lahan (ha)");
        lblFieldLuas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldLuas.setForeground(new java.awt.Color(29, 42, 34));
        pnlFLuas.add(lblFieldLuas);

        txtLuas.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtLuas.setAlignmentX(0.0F);
        txtLuas.setPreferredSize(new java.awt.Dimension(220, 42));
        txtLuas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLuas.setForeground(new java.awt.Color(29, 42, 34));
        pnlFLuas.add(txtLuas);

        lblHintLuas.setText(" ");
        lblHintLuas.setForeground(new java.awt.Color(122, 127, 115));
        pnlFLuas.add(lblHintLuas);

        pnlTabPetani.add(pnlFLuas);

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

        txtEmail.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtEmail.setAlignmentX(0.0F);
        txtEmail.setPreferredSize(new java.awt.Dimension(220, 42));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(29, 42, 34));
        pnlFEmail.add(txtEmail);

        lblHintEmail.setText(" ");
        lblHintEmail.setForeground(new java.awt.Color(122, 127, 115));
        pnlFEmail.add(lblHintEmail);

        pnlTabPetani.add(pnlFEmail);

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

        txtSandi.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtSandi.setAlignmentX(0.0F);
        txtSandi.setPreferredSize(new java.awt.Dimension(220, 42));
        txtSandi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSandi.setForeground(new java.awt.Color(29, 42, 34));
        pnlFSandi.add(txtSandi);

        lblHintSandi.setForeground(new java.awt.Color(122, 127, 115));
        lblHintSandi.setText("Minimal 6 karakter, ada huruf dan angka");
        pnlFSandi.add(lblHintSandi);

        pnlTabPetani.add(pnlFSandi);

        pnlFUlang.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFUlang.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFUlang.setAlignmentX(0.0F);
        pnlFUlang.setOpaque(false);
        pnlFUlang.setLayout(new javax.swing.BoxLayout(pnlFUlang, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldUlang.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldUlang.setText("Ulangi kata sandi");
        lblFieldUlang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldUlang.setForeground(new java.awt.Color(29, 42, 34));
        pnlFUlang.add(lblFieldUlang);

        txtUlang.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtUlang.setAlignmentX(0.0F);
        txtUlang.setPreferredSize(new java.awt.Dimension(220, 42));
        txtUlang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUlang.setForeground(new java.awt.Color(29, 42, 34));
        pnlFUlang.add(txtUlang);

        lblHintUlang.setText(" ");
        lblHintUlang.setForeground(new java.awt.Color(122, 127, 115));
        pnlFUlang.add(lblHintUlang);

        pnlTabPetani.add(pnlFUlang);

        btnDaftarPetani.setBackground(new java.awt.Color(31, 77, 58));
        btnDaftarPetani.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDaftarPetani.setForeground(new java.awt.Color(255, 255, 255));
        btnDaftarPetani.setText("Buat akun petani");
        btnDaftarPetani.setMaximumSize(new java.awt.Dimension(4000, 46));
        btnDaftarPetani.setPreferredSize(new java.awt.Dimension(300, 46));
        btnDaftarPetani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarPetaniActionPerformed(evt);
            }
        });
        pnlTabPetani.add(btnDaftarPetani);

        tabDaftar.addTab("Petani", pnlTabPetani);

        pnlTabPenyalur.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 0, 8, 0));
        pnlTabPenyalur.setAlignmentX(0.0F);
        pnlTabPenyalur.setOpaque(false);
        pnlTabPenyalur.setLayout(new javax.swing.BoxLayout(pnlTabPenyalur, javax.swing.BoxLayout.PAGE_AXIS));

        pnlFNamaP.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFNamaP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFNamaP.setAlignmentX(0.0F);
        pnlFNamaP.setOpaque(false);
        pnlFNamaP.setLayout(new javax.swing.BoxLayout(pnlFNamaP, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldNamaP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldNamaP.setText("Nama kios");
        lblFieldNamaP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldNamaP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFNamaP.add(lblFieldNamaP);

        txtNamaP.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtNamaP.setAlignmentX(0.0F);
        txtNamaP.setPreferredSize(new java.awt.Dimension(220, 42));
        txtNamaP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNamaP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFNamaP.add(txtNamaP);

        lblHintNamaP.setText(" ");
        lblHintNamaP.setForeground(new java.awt.Color(122, 127, 115));
        pnlFNamaP.add(lblHintNamaP);

        pnlTabPenyalur.add(pnlFNamaP);

        pnlFIzinP.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFIzinP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFIzinP.setAlignmentX(0.0F);
        pnlFIzinP.setOpaque(false);
        pnlFIzinP.setLayout(new javax.swing.BoxLayout(pnlFIzinP, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldIzinP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldIzinP.setText("No. izin usaha");
        lblFieldIzinP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldIzinP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFIzinP.add(lblFieldIzinP);

        txtIzinP.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtIzinP.setAlignmentX(0.0F);
        txtIzinP.setPreferredSize(new java.awt.Dimension(220, 42));
        txtIzinP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIzinP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFIzinP.add(txtIzinP);

        lblHintIzinP.setText(" ");
        lblHintIzinP.setForeground(new java.awt.Color(122, 127, 115));
        pnlFIzinP.add(lblHintIzinP);

        pnlTabPenyalur.add(pnlFIzinP);

        pnlFKecP.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFKecP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFKecP.setAlignmentX(0.0F);
        pnlFKecP.setOpaque(false);
        pnlFKecP.setLayout(new javax.swing.BoxLayout(pnlFKecP, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldKecP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldKecP.setText("Kecamatan layanan");
        lblFieldKecP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldKecP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFKecP.add(lblFieldKecP);

        cmbKecP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbKecP.setForeground(new java.awt.Color(29, 42, 34));
        cmbKecP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih kecamatan...", "Samarinda Ulu", "Samarinda Utara", "Samarinda Ilir", "Samarinda Kota", "Samarinda Seberang", "Sungai Kunjang", "Palaran", "Loa Janan Ilir", "Sambutan", "Sambutan Baru", "Sempaja Selatan", "Mugirejo", "Air Putih", "Sidodadi", "Teluk Lerong", "Baqa" }));
        cmbKecP.setAlignmentX(0.0F);
        cmbKecP.setMaximumSize(new java.awt.Dimension(4000, 42));
        cmbKecP.setPreferredSize(new java.awt.Dimension(220, 42));
        pnlFKecP.add(cmbKecP);

        lblHintKecP.setText(" ");
        lblHintKecP.setForeground(new java.awt.Color(122, 127, 115));
        pnlFKecP.add(lblHintKecP);

        pnlTabPenyalur.add(pnlFKecP);

        pnlFTelpP.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFTelpP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFTelpP.setAlignmentX(0.0F);
        pnlFTelpP.setOpaque(false);
        pnlFTelpP.setLayout(new javax.swing.BoxLayout(pnlFTelpP, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldTelpP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldTelpP.setText("No. telepon");
        lblFieldTelpP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldTelpP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFTelpP.add(lblFieldTelpP);

        txtTelpP.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtTelpP.setAlignmentX(0.0F);
        txtTelpP.setPreferredSize(new java.awt.Dimension(220, 42));
        txtTelpP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTelpP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFTelpP.add(txtTelpP);

        lblHintTelpP.setText(" ");
        lblHintTelpP.setForeground(new java.awt.Color(122, 127, 115));
        pnlFTelpP.add(lblHintTelpP);

        pnlTabPenyalur.add(pnlFTelpP);

        pnlFEmailP.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFEmailP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFEmailP.setAlignmentX(0.0F);
        pnlFEmailP.setOpaque(false);
        pnlFEmailP.setLayout(new javax.swing.BoxLayout(pnlFEmailP, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldEmailP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldEmailP.setText("Email");
        lblFieldEmailP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldEmailP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFEmailP.add(lblFieldEmailP);

        txtEmailP.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtEmailP.setAlignmentX(0.0F);
        txtEmailP.setPreferredSize(new java.awt.Dimension(220, 42));
        txtEmailP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmailP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFEmailP.add(txtEmailP);

        lblHintEmailP.setText(" ");
        lblHintEmailP.setForeground(new java.awt.Color(122, 127, 115));
        pnlFEmailP.add(lblHintEmailP);

        pnlTabPenyalur.add(pnlFEmailP);

        pnlFSandiP.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFSandiP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFSandiP.setAlignmentX(0.0F);
        pnlFSandiP.setOpaque(false);
        pnlFSandiP.setLayout(new javax.swing.BoxLayout(pnlFSandiP, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldSandiP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldSandiP.setText("Kata sandi");
        lblFieldSandiP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldSandiP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFSandiP.add(lblFieldSandiP);

        txtSandiP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSandiP.setForeground(new java.awt.Color(29, 42, 34));
        txtSandiP.setAlignmentX(0.0F);
        txtSandiP.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtSandiP.setPreferredSize(new java.awt.Dimension(220, 42));
        txtSandiP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSandiPActionPerformed(evt);
            }
        });
        pnlFSandiP.add(txtSandiP);

        lblHintSandiP.setForeground(new java.awt.Color(122, 127, 115));
        lblHintSandiP.setText("Minimal 6 karakter, ada huruf dan angka");
        pnlFSandiP.add(lblHintSandiP);

        pnlTabPenyalur.add(pnlFSandiP);

        pnlFUlangP.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFUlangP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFUlangP.setAlignmentX(0.0F);
        pnlFUlangP.setOpaque(false);
        pnlFUlangP.setLayout(new javax.swing.BoxLayout(pnlFUlangP, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldUlangP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldUlangP.setText("Ulangi kata sandi");
        lblFieldUlangP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldUlangP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFUlangP.add(lblFieldUlangP);

        txtUlangP.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtUlangP.setAlignmentX(0.0F);
        txtUlangP.setPreferredSize(new java.awt.Dimension(220, 42));
        txtUlangP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUlangP.setForeground(new java.awt.Color(29, 42, 34));
        pnlFUlangP.add(txtUlangP);

        lblHintUlangP.setText(" ");
        lblHintUlangP.setForeground(new java.awt.Color(122, 127, 115));
        pnlFUlangP.add(lblHintUlangP);

        pnlTabPenyalur.add(pnlFUlangP);

        btnDaftarPenyalur.setText("Daftarkan kios");
        btnDaftarPenyalur.setMaximumSize(new java.awt.Dimension(4000, 46));
        btnDaftarPenyalur.setPreferredSize(new java.awt.Dimension(300, 46));
        btnDaftarPenyalur.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDaftarPenyalur.setForeground(new java.awt.Color(255, 255, 255));
        btnDaftarPenyalur.setBackground(new java.awt.Color(31, 77, 58));
        btnDaftarPenyalur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarPenyalurActionPerformed(evt);
            }
        });
        pnlTabPenyalur.add(btnDaftarPenyalur);

        tabDaftar.addTab("Penyalur", pnlTabPenyalur);

        pnlForm.add(tabDaftar);

        pnlRow2.setAlignmentX(0.0F);
        pnlRow2.setMaximumSize(new java.awt.Dimension(4000, 40));
        pnlRow2.setOpaque(false);
        pnlRow2.setLayout(new java.awt.BorderLayout());

        lblSubSudah.setText("Sudah punya akun?");
        lblSubSudah.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubSudah.setForeground(new java.awt.Color(122, 127, 115));
        pnlRow2.add(lblSubSudah, java.awt.BorderLayout.WEST);

        btnGhostMasuk.setBackground(new java.awt.Color(242, 242, 242));
        btnGhostMasuk.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostMasuk.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostMasuk.setText("Masuk");
        btnGhostMasuk.setBorder(null);
        btnGhostMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostMasukActionPerformed(evt);
            }
        });
        pnlRow2.add(btnGhostMasuk, java.awt.BorderLayout.CENTER);

        btnLinkBeranda.setText("Kembali ke beranda");
        btnLinkBeranda.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLinkBeranda.setForeground(new java.awt.Color(31, 77, 58));
        btnLinkBeranda.setContentAreaFilled(false);
        btnLinkBeranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkBerandaActionPerformed(evt);
            }
        });
        pnlRow2.add(btnLinkBeranda, java.awt.BorderLayout.EAST);

        pnlForm.add(pnlRow2);

        pnlOuterDaftar.add(pnlForm, java.awt.BorderLayout.CENTER);

        scrBodyDaftar.setViewportView(pnlOuterDaftar);

        getContentPane().add(scrBodyDaftar, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 1194, 768);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDaftarPetaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarPetaniActionPerformed
        boolean ok = true;
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblHintNik, lblHintNama, lblHintLuas, lblHintEmail, lblHintUlang}) {
            l.setText(" ");
        }
        String sandi = new String(txtSandi.getPassword());
        if (!txtNik.getText().matches("\\d{16}")) {
            lblHintNik.setText("NIK harus 16 digit angka");
            ok = false;
        }
        if (txtNama.getText().trim().length() < 3) {
            lblHintNama.setText("Nama minimal 3 huruf");
            ok = false;
        }
        lblHintKecamatan.setText(" ");
        lblHintKecamatan.setForeground(Theme.CLAY);
        if (cmbKecamatan.getSelectedIndex() <= 0) {
            lblHintKecamatan.setText("Kecamatan wajib dipilih");
            ok = false;
        }
        if (!txtLuas.getText().matches("\\d+([,.]\\d{1,2})?") || txtLuas.getText().matches("0+([,.]0+)?")) {
            lblHintLuas.setText("Luas lahan harus angka lebih dari 0");
            ok = false;
        }
// Wajib menggunakan domain @petani.com
        String emailPetaniInput = txtEmail.getText().trim().toLowerCase();
        if (!emailPetaniInput.matches("^[\\w.+-]+@petani\\.com$")) {
            lblHintEmail.setText("Email harus berformat nama@petani.com");
            ok = false;
        }
        if (!sandi.matches("^(?=.*[A-Za-z])(?=.*\\d).{6,}$")) {
            lblHintSandi.setText("Minimal 6 karakter, ada huruf dan angka");
            lblHintSandi.setForeground(Theme.CLAY);
            ok = false;
        }
        if (!sandi.equals(new String(txtUlang.getPassword()))) {
            lblHintUlang.setText("Kata sandi tidak sama");
            ok = false;
        }
        if (!ok) {
            return;
        }
        if (!Dialogs.coba(this, () -> controller.GuiController.daftarPetani(txtNama.getText().trim(), txtNik.getText(),
                String.valueOf(cmbKecamatan.getSelectedItem()), txtLuas.getText(),
                txtEmail.getText().trim(), sandi))) {
            return;
        }
        Dialogs.info(this, "Pendaftaran petani berhasil. Silakan masuk.");
        new frmLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDaftarPetaniActionPerformed

    private void btnDaftarPenyalurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarPenyalurActionPerformed
        boolean ok = true;
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblHintNamaP, lblHintIzinP, lblHintTelpP, lblHintEmailP, lblHintUlangP}) {
            l.setText(" ");
        }
        String sandi = new String(txtSandiP.getPassword());
        if (txtNamaP.getText().trim().length() < 3) {
            lblHintNamaP.setText("Nama kios minimal 3 huruf");
            ok = false;
        }
        if (!txtIzinP.getText().matches("\\d{1,6}") || Long.parseLong("0" + txtIzinP.getText()) == 0) {
            lblHintIzinP.setForeground(Theme.CLAY);
            lblHintIzinP.setText("Isi angka saja (1-6 digit), mis. 12");
            ok = false;
        }
        lblHintKecP.setText(" ");
        lblHintKecP.setForeground(Theme.CLAY);
        if (cmbKecP.getSelectedIndex() <= 0) {
            lblHintKecP.setText("Kecamatan layanan wajib dipilih");
            ok = false;
        }
        if (!txtTelpP.getText().matches("08\\d{8,11}")) {
            lblHintTelpP.setText("Nomor telepon diawali 08, min 10 & max 13 digit");
            ok = false;
        }
        String emailPenyalurInput = txtEmailP.getText().trim().toLowerCase();
        if (!emailPenyalurInput.matches("^[\\w.+-]+@kios\\.com$")) {
            lblHintEmailP.setText("Email harus berformat nama@kios.com");
            ok = false;
        }
        if (!sandi.matches("^(?=.*[A-Za-z])(?=.*\\d).{6,}$")) {
            lblHintSandiP.setText("Minimal 6 karakter, ada huruf dan angka");
            lblHintSandiP.setForeground(Theme.CLAY);
            ok = false;
        }
        if (!sandi.equals(new String(txtUlangP.getPassword()))) {
            lblHintUlangP.setText("Kata sandi tidak sama");
            ok = false;
        }
        if (!ok) {
            return;
        }
        if (!Dialogs.coba(this, () -> controller.GuiController.daftarPenyalur(txtNamaP.getText().trim(), txtIzinP.getText(),
                String.valueOf(cmbKecP.getSelectedItem()), txtTelpP.getText(), txtEmailP.getText().trim(), sandi))) {
            return;
        }
        Dialogs.info(this, "Kios berhasil didaftarkan. Silakan masuk.");
        new frmLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDaftarPenyalurActionPerformed

    private void btnGhostMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostMasukActionPerformed
        new frmLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGhostMasukActionPerformed

    private void btnLinkBerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkBerandaActionPerformed
        new frmBeranda().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLinkBerandaActionPerformed

    private void txtSandiPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSandiPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSandiPActionPerformed

    private void txtNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNikActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDaftarPenyalur;
    private javax.swing.JButton btnDaftarPetani;
    private javax.swing.JButton btnGhostMasuk;
    private javax.swing.JButton btnLinkBeranda;
    private javax.swing.JComboBox cmbKecP;
    private javax.swing.JComboBox cmbKecamatan;
    private javax.swing.JLabel lblFieldEmail;
    private javax.swing.JLabel lblFieldEmailP;
    private javax.swing.JLabel lblFieldIzinP;
    private javax.swing.JLabel lblFieldKecP;
    private javax.swing.JLabel lblFieldKecamatan;
    private javax.swing.JLabel lblFieldLuas;
    private javax.swing.JLabel lblFieldNama;
    private javax.swing.JLabel lblFieldNamaP;
    private javax.swing.JLabel lblFieldNik;
    private javax.swing.JLabel lblFieldSandi;
    private javax.swing.JLabel lblFieldSandiP;
    private javax.swing.JLabel lblFieldTelpP;
    private javax.swing.JLabel lblFieldUlang;
    private javax.swing.JLabel lblFieldUlangP;
    private javax.swing.JLabel lblHDaftar;
    private javax.swing.JLabel lblHintEmail;
    private javax.swing.JLabel lblHintEmailP;
    private javax.swing.JLabel lblHintIzinP;
    private javax.swing.JLabel lblHintKecP;
    private javax.swing.JLabel lblHintKecamatan;
    private javax.swing.JLabel lblHintLuas;
    private javax.swing.JLabel lblHintNama;
    private javax.swing.JLabel lblHintNamaP;
    private javax.swing.JLabel lblHintNik;
    private javax.swing.JLabel lblHintSandi;
    private javax.swing.JLabel lblHintSandiP;
    private javax.swing.JLabel lblHintTelpP;
    private javax.swing.JLabel lblHintUlang;
    private javax.swing.JLabel lblHintUlangP;
    private javax.swing.JLabel lblLightImgBrand;
    private javax.swing.JLabel lblSubDaftar;
    private javax.swing.JLabel lblSubSudah;
    private javax.swing.JPanel pnlFEmail;
    private javax.swing.JPanel pnlFEmailP;
    private javax.swing.JPanel pnlFIzinP;
    private javax.swing.JPanel pnlFKecP;
    private javax.swing.JPanel pnlFKecamatan;
    private javax.swing.JPanel pnlFLuas;
    private javax.swing.JPanel pnlFNama;
    private javax.swing.JPanel pnlFNamaP;
    private javax.swing.JPanel pnlFNik;
    private javax.swing.JPanel pnlFSandi;
    private javax.swing.JPanel pnlFSandiP;
    private javax.swing.JPanel pnlFTelpP;
    private javax.swing.JPanel pnlFUlang;
    private javax.swing.JPanel pnlFUlangP;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlOuterDaftar;
    private javax.swing.JPanel pnlRow2;
    private javax.swing.JPanel pnlTabPenyalur;
    private javax.swing.JPanel pnlTabPetani;
    private javax.swing.JScrollPane scrBodyDaftar;
    private javax.swing.JTabbedPane tabDaftar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailP;
    private javax.swing.JTextField txtIzinP;
    private javax.swing.JTextField txtLuas;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaP;
    private javax.swing.JTextField txtNik;
    private javax.swing.JPasswordField txtSandi;
    private javax.swing.JPasswordField txtSandiP;
    private javax.swing.JTextField txtTelpP;
    private javax.swing.JPasswordField txtUlang;
    private javax.swing.JPasswordField txtUlangP;
    // End of variables declaration//GEN-END:variables
}
