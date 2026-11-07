package view;

import controller.GuiController;
import view.util.*;

/** Pupuk Subsidi. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgSubsidi extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgSubsidi() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        InputFilters.digits(txtTahun, 4);
        InputFilters.digits(txtJumlah, 8);
        lblHintTahun.setForeground(Theme.CLAY);
        lblHintJumlah.setForeground(Theme.CLAY);
        TableKit.muat(tblKuota, GuiController::kuotaKecamatan);
        InputFilters.keyword(txtCariKuota, 40);
        TableKit.muat(tblPetani, GuiController::dataPetani);
        InputFilters.keyword(txtCariPetani, 40);
        TableKit.muat(tblPnyPetani, GuiController::transaksiSemua);
        InputFilters.keyword(txtCariPnyPetani, 40);
        TableKit.muat(tblPantau, GuiController::pantauKuota);
        InputFilters.keyword(txtCariPantau, 40);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeaderSub = new javax.swing.JPanel();
        pnlTitlesSub = new javax.swing.JPanel();
        lblTitleSub = new javax.swing.JLabel();
        lblSubSub = new javax.swing.JLabel();
        pnlTopSub = new javax.swing.JPanel();
        scrBodySub = new javax.swing.JScrollPane();
        pnlOuterSub = new javax.swing.JPanel();
        pnlStackSub = new javax.swing.JPanel();
        pnlGapSub0 = new javax.swing.JPanel();
        tabSub = new javax.swing.JTabbedPane();
        pnlTabKuota = new javax.swing.JPanel();
        pnlCardFKuota = new javax.swing.JPanel();
        pnlHeadFKuota = new javax.swing.JPanel();
        lblHFKuota = new javax.swing.JLabel();
        pnlGridKuota = new javax.swing.JPanel();
        pnlFKec = new javax.swing.JPanel();
        lblFieldKec = new javax.swing.JLabel();
        cmbKec = new javax.swing.JComboBox();
        lblHintKec = new javax.swing.JLabel();
        pnlFProduk = new javax.swing.JPanel();
        lblFieldProduk = new javax.swing.JLabel();
        cmbProduk = new javax.swing.JComboBox();
        lblHintProduk = new javax.swing.JLabel();
        pnlFTahun = new javax.swing.JPanel();
        lblFieldTahun = new javax.swing.JLabel();
        txtTahun = new javax.swing.JTextField();
        lblHintTahun = new javax.swing.JLabel();
        pnlFJumlah = new javax.swing.JPanel();
        lblFieldJumlah = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        lblHintJumlah = new javax.swing.JLabel();
        pnlActKuota = new javax.swing.JPanel();
        btnSimpanKuota = new javax.swing.JButton();
        btnGhostReset = new javax.swing.JButton();
        pnlCardKuota = new javax.swing.JPanel();
        pnlHeadKuota = new javax.swing.JPanel();
        lblHKuota = new javax.swing.JLabel();
        pnlToolKuota = new javax.swing.JPanel();
        txtCariKuota = new javax.swing.JTextField();
        btnCariKuota = new javax.swing.JButton();
        scrKuota = new javax.swing.JScrollPane();
        tblKuota = new javax.swing.JTable();
        pnlTabPetani = new javax.swing.JPanel();
        pnlCardPetani = new javax.swing.JPanel();
        pnlHeadPetani = new javax.swing.JPanel();
        lblHPetani = new javax.swing.JLabel();
        pnlToolPetani = new javax.swing.JPanel();
        txtCariPetani = new javax.swing.JTextField();
        btnCariPetani = new javax.swing.JButton();
        scrPetani = new javax.swing.JScrollPane();
        tblPetani = new javax.swing.JTable();
        pnlTabPny = new javax.swing.JPanel();
        pnlCardPnyPetani = new javax.swing.JPanel();
        pnlHeadPnyPetani = new javax.swing.JPanel();
        lblHPnyPetani = new javax.swing.JLabel();
        pnlToolPnyPetani = new javax.swing.JPanel();
        txtCariPnyPetani = new javax.swing.JTextField();
        btnCariPnyPetani = new javax.swing.JButton();
        scrPnyPetani = new javax.swing.JScrollPane();
        tblPnyPetani = new javax.swing.JTable();
        pnlTabPantau = new javax.swing.JPanel();
        pnlCardPantau = new javax.swing.JPanel();
        pnlHeadPantau = new javax.swing.JPanel();
        lblHPantau = new javax.swing.JLabel();
        pnlToolPantau = new javax.swing.JPanel();
        txtCariPantau = new javax.swing.JTextField();
        btnCariPantau = new javax.swing.JButton();
        scrPantau = new javax.swing.JScrollPane();
        tblPantau = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderSub.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderSub.setOpaque(false);
        pnlHeaderSub.setLayout(new java.awt.BorderLayout());

        pnlTitlesSub.setAlignmentX(0.0F);
        pnlTitlesSub.setOpaque(false);
        pnlTitlesSub.setLayout(new javax.swing.BoxLayout(pnlTitlesSub, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitleSub.setText("Pupuk Subsidi");
        lblTitleSub.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitleSub.setForeground(new java.awt.Color(29, 42, 34));
        pnlTitlesSub.add(lblTitleSub);

        lblSubSub.setText("Kuota, petani, penyaluran, dan pemantauan.");
        lblSubSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubSub.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesSub.add(lblSubSub);

        pnlHeaderSub.add(pnlTitlesSub, java.awt.BorderLayout.WEST);

        pnlTopSub.setOpaque(false);
        pnlTopSub.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderSub.add(pnlTopSub, java.awt.BorderLayout.EAST);

        add(pnlHeaderSub, java.awt.BorderLayout.NORTH);

        scrBodySub.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterSub.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterSub.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterSub.setLayout(new java.awt.BorderLayout());

        pnlStackSub.setAlignmentX(0.0F);
        pnlStackSub.setOpaque(false);
        pnlStackSub.setLayout(new javax.swing.BoxLayout(pnlStackSub, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapSub0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapSub0.setAlignmentX(0.0F);
        pnlGapSub0.setOpaque(false);
        pnlGapSub0.setLayout(new java.awt.BorderLayout());

        tabSub.setAlignmentX(0.0F);
        tabSub.setPreferredSize(new java.awt.Dimension(700, 620));
        tabSub.setMaximumSize(new java.awt.Dimension(4000, 620));
        tabSub.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        pnlTabKuota.setAlignmentX(0.0F);
        pnlTabKuota.setOpaque(false);
        pnlTabKuota.setLayout(new javax.swing.BoxLayout(pnlTabKuota, javax.swing.BoxLayout.PAGE_AXIS));

        pnlCardFKuota.setAlignmentX(0.0F);
        pnlCardFKuota.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardFKuota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardFKuota.setLayout(new javax.swing.BoxLayout(pnlCardFKuota, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadFKuota.setAlignmentX(0.0F);
        pnlHeadFKuota.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadFKuota.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadFKuota.setOpaque(false);
        pnlHeadFKuota.setLayout(new java.awt.BorderLayout());

        lblHFKuota.setText("Atur kuota");
        lblHFKuota.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHFKuota.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadFKuota.add(lblHFKuota, java.awt.BorderLayout.WEST);

        pnlCardFKuota.add(pnlHeadFKuota);

        pnlGridKuota.setAlignmentX(0.0F);
        pnlGridKuota.setMaximumSize(new java.awt.Dimension(4000, 200));
        pnlGridKuota.setPreferredSize(new java.awt.Dimension(700, 200));
        pnlGridKuota.setOpaque(false);
        pnlGridKuota.setLayout(new java.awt.GridLayout(0, 2, 16, 0));

        pnlFKec.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFKec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFKec.setAlignmentX(0.0F);
        pnlFKec.setOpaque(false);
        pnlFKec.setLayout(new javax.swing.BoxLayout(pnlFKec, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldKec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldKec.setText("Kecamatan");
        lblFieldKec.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldKec.setForeground(new java.awt.Color(29, 42, 34));
        pnlFKec.add(lblFieldKec);

        cmbKec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbKec.setForeground(new java.awt.Color(29, 42, 34));
        cmbKec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Kecamatan", "Samarinda Ulu", "Samarinda Utara", "Samarinda Ilir", "Samarinda Kota", "Samarinda Seberang", "Sungai Kunjang", "Palaran", "Loa Janan Ilir", "Sambutan", "Sambutan Baru", "Sempaja Selatan", "Mugirejo", "Air Putih", "Sidodadi", "Teluk Lerong", "Baqa" }));
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

        pnlGridKuota.add(pnlFKec);

        pnlFProduk.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFProduk.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFProduk.setAlignmentX(0.0F);
        pnlFProduk.setOpaque(false);
        pnlFProduk.setLayout(new javax.swing.BoxLayout(pnlFProduk, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldProduk.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldProduk.setText("Produk");
        lblFieldProduk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldProduk.setForeground(new java.awt.Color(29, 42, 34));
        pnlFProduk.add(lblFieldProduk);

        cmbProduk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbProduk.setForeground(new java.awt.Color(29, 42, 34));
        cmbProduk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih pupuk", "Urea Subsidi ", "NPK Subsidi ", "NPK untuk kakao Subsidi ", "NPK Phonska Subsidi ", "ZA Subsidi     ", "Dolomit Subsidi", "Urea nonsubsidi", "NPK nonsubsidi ", "SP-36 nonsubsidi ", "ZA nonsubsidi ", "KCl nonsubsidi ", "TSP nonsubsidi ", "DAP nonsubsidi " }));
        cmbProduk.setAlignmentX(0.0F);
        cmbProduk.setMaximumSize(new java.awt.Dimension(4000, 42));
        cmbProduk.setPreferredSize(new java.awt.Dimension(220, 42));
        pnlFProduk.add(cmbProduk);

        lblHintProduk.setText(" ");
        lblHintProduk.setForeground(new java.awt.Color(122, 127, 115));
        pnlFProduk.add(lblHintProduk);

        pnlGridKuota.add(pnlFProduk);

        pnlFTahun.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFTahun.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFTahun.setAlignmentX(0.0F);
        pnlFTahun.setOpaque(false);
        pnlFTahun.setLayout(new javax.swing.BoxLayout(pnlFTahun, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldTahun.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldTahun.setText("Tahun");
        lblFieldTahun.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldTahun.setForeground(new java.awt.Color(29, 42, 34));
        pnlFTahun.add(lblFieldTahun);

        txtTahun.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTahun.setForeground(new java.awt.Color(29, 42, 34));
        txtTahun.setAlignmentX(0.0F);
        txtTahun.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtTahun.setPreferredSize(new java.awt.Dimension(220, 42));
        txtTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTahunActionPerformed(evt);
            }
        });
        pnlFTahun.add(txtTahun);

        lblHintTahun.setText(" ");
        lblHintTahun.setForeground(new java.awt.Color(122, 127, 115));
        pnlFTahun.add(lblHintTahun);

        pnlGridKuota.add(pnlFTahun);

        pnlFJumlah.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFJumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFJumlah.setAlignmentX(0.0F);
        pnlFJumlah.setOpaque(false);
        pnlFJumlah.setLayout(new javax.swing.BoxLayout(pnlFJumlah, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldJumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldJumlah.setText("Kuota (kg)");
        lblFieldJumlah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldJumlah.setForeground(new java.awt.Color(29, 42, 34));
        pnlFJumlah.add(lblFieldJumlah);

        txtJumlah.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtJumlah.setAlignmentX(0.0F);
        txtJumlah.setPreferredSize(new java.awt.Dimension(220, 42));
        txtJumlah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJumlah.setForeground(new java.awt.Color(29, 42, 34));
        pnlFJumlah.add(txtJumlah);

        lblHintJumlah.setText(" ");
        lblHintJumlah.setForeground(new java.awt.Color(122, 127, 115));
        pnlFJumlah.add(lblHintJumlah);

        pnlGridKuota.add(pnlFJumlah);

        pnlCardFKuota.add(pnlGridKuota);

        pnlActKuota.setAlignmentX(0.0F);
        pnlActKuota.setMaximumSize(new java.awt.Dimension(4000, 48));
        pnlActKuota.setOpaque(false);
        pnlActKuota.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnSimpanKuota.setText("Simpan kuota");
        btnSimpanKuota.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSimpanKuota.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanKuota.setBackground(new java.awt.Color(31, 77, 58));
        btnSimpanKuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanKuotaActionPerformed(evt);
            }
        });
        pnlActKuota.add(btnSimpanKuota);

        btnGhostReset.setText("Kosongkan");
        btnGhostReset.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostReset.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostResetActionPerformed(evt);
            }
        });
        pnlActKuota.add(btnGhostReset);

        pnlCardFKuota.add(pnlActKuota);

        pnlTabKuota.add(pnlCardFKuota);

        pnlCardKuota.setAlignmentX(0.0F);
        pnlCardKuota.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardKuota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardKuota.setLayout(new javax.swing.BoxLayout(pnlCardKuota, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadKuota.setAlignmentX(0.0F);
        pnlHeadKuota.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadKuota.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadKuota.setOpaque(false);
        pnlHeadKuota.setLayout(new java.awt.BorderLayout());

        lblHKuota.setText("Kuota kecamatan");
        lblHKuota.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHKuota.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadKuota.add(lblHKuota, java.awt.BorderLayout.WEST);

        pnlCardKuota.add(pnlHeadKuota);

        pnlToolKuota.setAlignmentX(0.0F);
        pnlToolKuota.setMaximumSize(new java.awt.Dimension(4000, 52));
        pnlToolKuota.setOpaque(false);
        pnlToolKuota.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCariKuota.setPreferredSize(new java.awt.Dimension(260, 40));
        txtCariKuota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCariKuota.setForeground(new java.awt.Color(29, 42, 34));
        pnlToolKuota.add(txtCariKuota);

        btnCariKuota.setText("Cari");
        btnCariKuota.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCariKuota.setForeground(new java.awt.Color(255, 255, 255));
        btnCariKuota.setBackground(new java.awt.Color(31, 77, 58));
        btnCariKuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariKuotaActionPerformed(evt);
            }
        });
        pnlToolKuota.add(btnCariKuota);

        pnlCardKuota.add(pnlToolKuota);

        scrKuota.setPreferredSize(new java.awt.Dimension(600, 200));
        scrKuota.setMaximumSize(new java.awt.Dimension(4000, 200));
        scrKuota.setAlignmentX(0.0F);

        tblKuota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kecamatan", "Produk", "Tahun", "Kuota (kg)", "Terpakai (kg)", "Sisa (kg)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrKuota.setViewportView(tblKuota);

        pnlCardKuota.add(scrKuota);

        pnlTabKuota.add(pnlCardKuota);

        tabSub.addTab("Kuota", pnlTabKuota);

        pnlTabPetani.setAlignmentX(0.0F);
        pnlTabPetani.setOpaque(false);
        pnlTabPetani.setLayout(new javax.swing.BoxLayout(pnlTabPetani, javax.swing.BoxLayout.PAGE_AXIS));

        pnlCardPetani.setAlignmentX(0.0F);
        pnlCardPetani.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardPetani.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardPetani.setLayout(new javax.swing.BoxLayout(pnlCardPetani, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadPetani.setAlignmentX(0.0F);
        pnlHeadPetani.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadPetani.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadPetani.setOpaque(false);
        pnlHeadPetani.setLayout(new java.awt.BorderLayout());

        lblHPetani.setText("Petani subsidi");
        lblHPetani.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHPetani.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadPetani.add(lblHPetani, java.awt.BorderLayout.WEST);

        pnlCardPetani.add(pnlHeadPetani);

        pnlToolPetani.setAlignmentX(0.0F);
        pnlToolPetani.setMaximumSize(new java.awt.Dimension(4000, 52));
        pnlToolPetani.setOpaque(false);
        pnlToolPetani.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCariPetani.setPreferredSize(new java.awt.Dimension(260, 40));
        txtCariPetani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCariPetani.setForeground(new java.awt.Color(29, 42, 34));
        pnlToolPetani.add(txtCariPetani);

        btnCariPetani.setText("Cari");
        btnCariPetani.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCariPetani.setForeground(new java.awt.Color(255, 255, 255));
        btnCariPetani.setBackground(new java.awt.Color(31, 77, 58));
        btnCariPetani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPetaniActionPerformed(evt);
            }
        });
        pnlToolPetani.add(btnCariPetani);

        pnlCardPetani.add(pnlToolPetani);

        scrPetani.setPreferredSize(new java.awt.Dimension(600, 300));
        scrPetani.setMaximumSize(new java.awt.Dimension(4000, 300));
        scrPetani.setAlignmentX(0.0F);

        tblPetani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIK", "Nama", "Kecamatan", "Luas (ha)", "Email", "Terdaftar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrPetani.setViewportView(tblPetani);

        pnlCardPetani.add(scrPetani);

        pnlTabPetani.add(pnlCardPetani);

        tabSub.addTab("Data petani", pnlTabPetani);

        pnlTabPny.setAlignmentX(0.0F);
        pnlTabPny.setOpaque(false);
        pnlTabPny.setLayout(new javax.swing.BoxLayout(pnlTabPny, javax.swing.BoxLayout.PAGE_AXIS));

        pnlCardPnyPetani.setAlignmentX(0.0F);
        pnlCardPnyPetani.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardPnyPetani.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardPnyPetani.setLayout(new javax.swing.BoxLayout(pnlCardPnyPetani, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadPnyPetani.setAlignmentX(0.0F);
        pnlHeadPnyPetani.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadPnyPetani.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadPnyPetani.setOpaque(false);
        pnlHeadPnyPetani.setLayout(new java.awt.BorderLayout());

        lblHPnyPetani.setText("Penyaluran ke petani");
        lblHPnyPetani.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHPnyPetani.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadPnyPetani.add(lblHPnyPetani, java.awt.BorderLayout.WEST);

        pnlCardPnyPetani.add(pnlHeadPnyPetani);

        pnlToolPnyPetani.setAlignmentX(0.0F);
        pnlToolPnyPetani.setMaximumSize(new java.awt.Dimension(4000, 52));
        pnlToolPnyPetani.setOpaque(false);
        pnlToolPnyPetani.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCariPnyPetani.setPreferredSize(new java.awt.Dimension(260, 40));
        txtCariPnyPetani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCariPnyPetani.setForeground(new java.awt.Color(29, 42, 34));
        pnlToolPnyPetani.add(txtCariPnyPetani);

        btnCariPnyPetani.setText("Cari");
        btnCariPnyPetani.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCariPnyPetani.setForeground(new java.awt.Color(255, 255, 255));
        btnCariPnyPetani.setBackground(new java.awt.Color(31, 77, 58));
        btnCariPnyPetani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPnyPetaniActionPerformed(evt);
            }
        });
        pnlToolPnyPetani.add(btnCariPnyPetani);

        pnlCardPnyPetani.add(pnlToolPnyPetani);

        scrPnyPetani.setPreferredSize(new java.awt.Dimension(600, 300));
        scrPnyPetani.setMaximumSize(new java.awt.Dimension(4000, 300));
        scrPnyPetani.setAlignmentX(0.0F);

        tblPnyPetani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Transaksi", "Tanggal", "Kategori", "Produk", "Kecamatan", "NIK", "Petani", "Jumlah (kg)", "Jenis", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrPnyPetani.setViewportView(tblPnyPetani);

        pnlCardPnyPetani.add(scrPnyPetani);

        pnlTabPny.add(pnlCardPnyPetani);

        tabSub.addTab("Penyaluran", pnlTabPny);

        pnlTabPantau.setAlignmentX(0.0F);
        pnlTabPantau.setOpaque(false);
        pnlTabPantau.setLayout(new javax.swing.BoxLayout(pnlTabPantau, javax.swing.BoxLayout.PAGE_AXIS));

        pnlCardPantau.setAlignmentX(0.0F);
        pnlCardPantau.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardPantau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardPantau.setLayout(new javax.swing.BoxLayout(pnlCardPantau, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadPantau.setAlignmentX(0.0F);
        pnlHeadPantau.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadPantau.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadPantau.setOpaque(false);
        pnlHeadPantau.setLayout(new java.awt.BorderLayout());

        lblHPantau.setText("Pantau kuota per kecamatan");
        lblHPantau.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHPantau.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadPantau.add(lblHPantau, java.awt.BorderLayout.WEST);

        pnlCardPantau.add(pnlHeadPantau);

        pnlToolPantau.setAlignmentX(0.0F);
        pnlToolPantau.setMaximumSize(new java.awt.Dimension(4000, 52));
        pnlToolPantau.setOpaque(false);
        pnlToolPantau.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCariPantau.setPreferredSize(new java.awt.Dimension(260, 40));
        txtCariPantau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCariPantau.setForeground(new java.awt.Color(29, 42, 34));
        pnlToolPantau.add(txtCariPantau);

        btnCariPantau.setText("Cari");
        btnCariPantau.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCariPantau.setForeground(new java.awt.Color(255, 255, 255));
        btnCariPantau.setBackground(new java.awt.Color(31, 77, 58));
        btnCariPantau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPantauActionPerformed(evt);
            }
        });
        pnlToolPantau.add(btnCariPantau);

        pnlCardPantau.add(pnlToolPantau);

        scrPantau.setPreferredSize(new java.awt.Dimension(600, 300));
        scrPantau.setMaximumSize(new java.awt.Dimension(4000, 300));
        scrPantau.setAlignmentX(0.0F);

        tblPantau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kecamatan", "Produk", "Kuota", "Terpakai", "Dikirim", "Dipesan", "Sisa", "Terserap"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrPantau.setViewportView(tblPantau);

        pnlCardPantau.add(scrPantau);

        pnlTabPantau.add(pnlCardPantau);

        tabSub.addTab("Pantau", pnlTabPantau);

        pnlGapSub0.add(tabSub, java.awt.BorderLayout.CENTER);

        pnlStackSub.add(pnlGapSub0);

        pnlOuterSub.add(pnlStackSub, java.awt.BorderLayout.NORTH);

        scrBodySub.setViewportView(pnlOuterSub);

        add(scrBodySub, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanKuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanKuotaActionPerformed
        lblHintTahun.setText(" ");
        lblHintJumlah.setText(" ");
        boolean ok = true;
        
        // Mengubah validasi agar tahun minimal 2026 sampai 2099
        if (!txtTahun.getText().matches("20[2-9]\\d")) {
            lblHintTahun.setText("Tahun tidak valid (minimal 2026)");
            ok = false;
        }
        
        if (!txtJumlah.getText().matches("[1-9]\\d{0,7}")) {
            lblHintJumlah.setText("Kuota harus bilangan bulat lebih dari 0");
            ok = false;
        }
        
        if (!ok) {
            return;
        }
        String kec = String.valueOf(cmbKec.getSelectedItem());
        String produk = String.valueOf(cmbProduk.getSelectedItem());
        int tahun = Integer.parseInt(txtTahun.getText());
        long kg = Long.parseLong(txtJumlah.getText());
        if (!Dialogs.coba(this, () -> GuiController.simpanKuota(kec, produk, tahun, kg))) {
            return;
        }
        Dialogs.info(this, "Kuota disimpan.");
        TableKit.muat(tblKuota, GuiController::kuotaKecamatan);
        TableKit.muat(tblPantau, GuiController::pantauKuota);
    }//GEN-LAST:event_btnSimpanKuotaActionPerformed

    private void btnGhostResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostResetActionPerformed
        txtTahun.setText("");
        txtJumlah.setText("");
    }//GEN-LAST:event_btnGhostResetActionPerformed

    private void btnCariKuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariKuotaActionPerformed
        TableKit.cari(tblKuota, txtCariKuota.getText());
    }//GEN-LAST:event_btnCariKuotaActionPerformed

    private void btnCariPetaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPetaniActionPerformed
        TableKit.cari(tblPetani, txtCariPetani.getText());
    }//GEN-LAST:event_btnCariPetaniActionPerformed

    private void btnCariPnyPetaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPnyPetaniActionPerformed
        TableKit.cari(tblPnyPetani, txtCariPnyPetani.getText());
    }//GEN-LAST:event_btnCariPnyPetaniActionPerformed

    private void btnCariPantauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPantauActionPerformed
        TableKit.cari(tblPantau, txtCariPantau.getText());
    }//GEN-LAST:event_btnCariPantauActionPerformed

    private void txtTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTahunActionPerformed

    private void cmbKecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKecActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariKuota;
    private javax.swing.JButton btnCariPantau;
    private javax.swing.JButton btnCariPetani;
    private javax.swing.JButton btnCariPnyPetani;
    private javax.swing.JButton btnGhostReset;
    private javax.swing.JButton btnSimpanKuota;
    private javax.swing.JComboBox cmbKec;
    private javax.swing.JComboBox cmbProduk;
    private javax.swing.JLabel lblFieldJumlah;
    private javax.swing.JLabel lblFieldKec;
    private javax.swing.JLabel lblFieldProduk;
    private javax.swing.JLabel lblFieldTahun;
    private javax.swing.JLabel lblHFKuota;
    private javax.swing.JLabel lblHKuota;
    private javax.swing.JLabel lblHPantau;
    private javax.swing.JLabel lblHPetani;
    private javax.swing.JLabel lblHPnyPetani;
    private javax.swing.JLabel lblHintJumlah;
    private javax.swing.JLabel lblHintKec;
    private javax.swing.JLabel lblHintProduk;
    private javax.swing.JLabel lblHintTahun;
    private javax.swing.JLabel lblSubSub;
    private javax.swing.JLabel lblTitleSub;
    private javax.swing.JPanel pnlActKuota;
    private javax.swing.JPanel pnlCardFKuota;
    private javax.swing.JPanel pnlCardKuota;
    private javax.swing.JPanel pnlCardPantau;
    private javax.swing.JPanel pnlCardPetani;
    private javax.swing.JPanel pnlCardPnyPetani;
    private javax.swing.JPanel pnlFJumlah;
    private javax.swing.JPanel pnlFKec;
    private javax.swing.JPanel pnlFProduk;
    private javax.swing.JPanel pnlFTahun;
    private javax.swing.JPanel pnlGapSub0;
    private javax.swing.JPanel pnlGridKuota;
    private javax.swing.JPanel pnlHeadFKuota;
    private javax.swing.JPanel pnlHeadKuota;
    private javax.swing.JPanel pnlHeadPantau;
    private javax.swing.JPanel pnlHeadPetani;
    private javax.swing.JPanel pnlHeadPnyPetani;
    private javax.swing.JPanel pnlHeaderSub;
    private javax.swing.JPanel pnlOuterSub;
    private javax.swing.JPanel pnlStackSub;
    private javax.swing.JPanel pnlTabKuota;
    private javax.swing.JPanel pnlTabPantau;
    private javax.swing.JPanel pnlTabPetani;
    private javax.swing.JPanel pnlTabPny;
    private javax.swing.JPanel pnlTitlesSub;
    private javax.swing.JPanel pnlToolKuota;
    private javax.swing.JPanel pnlToolPantau;
    private javax.swing.JPanel pnlToolPetani;
    private javax.swing.JPanel pnlToolPnyPetani;
    private javax.swing.JPanel pnlTopSub;
    private javax.swing.JScrollPane scrBodySub;
    private javax.swing.JScrollPane scrKuota;
    private javax.swing.JScrollPane scrPantau;
    private javax.swing.JScrollPane scrPetani;
    private javax.swing.JScrollPane scrPnyPetani;
    private javax.swing.JTabbedPane tabSub;
    private javax.swing.JTable tblKuota;
    private javax.swing.JTable tblPantau;
    private javax.swing.JTable tblPetani;
    private javax.swing.JTable tblPnyPetani;
    private javax.swing.JTextField txtCariKuota;
    private javax.swing.JTextField txtCariPantau;
    private javax.swing.JTextField txtCariPetani;
    private javax.swing.JTextField txtCariPnyPetani;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtTahun;
    // End of variables declaration//GEN-END:variables
}
