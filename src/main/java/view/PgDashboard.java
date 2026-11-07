package view;

import controller.GuiController;
import view.util.*;

/** Dashboard. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgDashboard extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgDashboard() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        muat();
    }

    /** Mengisi kartu angka, grafik, dan tabel dari database. */
    private void muat() {
        try {
            GuiController.Dashboard d = GuiController.dashboard();
            lblBigDash0.setText(GuiController.ribuan(d.stokKg()) + " kg");
            lblBigDash1.setText(GuiController.ribuan(d.bulanIniKg()) + " kg");
            lblHintDash1N.setText(d.bulanIniN() + " penyaluran");
            lblBigDash2.setText(GuiController.ribuan(d.petani()));
            lblHintDash2N.setText(d.kecamatan() + " kecamatan");
            lblBigDash3.setText(String.valueOf(d.menunggu()));
            lblBigDash4.setText(GuiController.ribuan(d.hariIniKg()) + " kg");
            lblHintDash4N.setText(d.hariIniN() + " pengiriman");
            lblBigDash5.setText(GuiController.ribuan(d.petaniSubsidi()));
            lblHintDash5N.setText("dari " + GuiController.ribuan(d.petani()) + " petani terdaftar");

            java.util.List<Charts.Item> kec = new java.util.ArrayList<>();
            for (GuiController.Pasangan p : d.perKecamatan()) {
                kec.add(new Charts.Item(p.label(), p.nilai()));
            }
            charKec.data(kec, "kg", Theme.LEAF);
            lblHintKecTop.setText(kec.isEmpty() ? "Belum ada penyaluran." : "<html><b>Terbanyak:</b> " + kec.get(0).label() + "</html>");
            pieKategori.data(java.util.List.of(new Charts.Item("Subsidi", d.subsidiKg()), new Charts.Item("Non subsidi", d.nonKg())),
                    "kg", Theme.LEAF, Theme.GOLD);
            pieKuota.data(java.util.List.of(new Charts.Item("Terdistribusi", d.terdistribusiKg()), new Charts.Item("Sisa di kios", d.sisaKg())),
                    "kg", Theme.LEAF, Theme.GOLD);

            javax.swing.JLabel[] top = {lblB1S, lblB2S, lblB3S, lblB3S1, lblB3S2, lblB3S3};
            for (int i = 0; i < top.length; i++) {
                if (i < d.topProduk().size()) {
                    GuiController.Pasangan p = d.topProduk().get(i);
                    top[i].setText(p.label() + " — " + GuiController.ribuan((long) p.nilai()) + " kg");
                } else {
                    top[i].setText(" ");
                }
            }
        } catch (RuntimeException e) {
            Dialogs.gagal(this, e);
        }
        TableKit.muat(tblTerbaru, GuiController::penyaluranRingkas);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeaderDash = new javax.swing.JPanel();
        pnlTitlesDash = new javax.swing.JPanel();
        lblTitleDash = new javax.swing.JLabel();
        lblSubDash = new javax.swing.JLabel();
        pnlTopDash = new javax.swing.JPanel();
        scrBodyDash = new javax.swing.JScrollPane();
        pnlOuterDash = new javax.swing.JPanel();
        pnlStackDash = new javax.swing.JPanel();
        pnlGapDash0 = new javax.swing.JPanel();
        pnlStatsDash = new javax.swing.JPanel();
        pnlCardStatDash4 = new javax.swing.JPanel();
        lblHintDash4T = new javax.swing.JLabel();
        lblBigDash4 = new javax.swing.JLabel();
        lblHintDash4N = new javax.swing.JLabel();
        pnlCardStatDash1 = new javax.swing.JPanel();
        lblHintDash1T = new javax.swing.JLabel();
        lblBigDash1 = new javax.swing.JLabel();
        lblHintDash1N = new javax.swing.JLabel();
        pnlCardStatDash5 = new javax.swing.JPanel();
        lblHintDash5T = new javax.swing.JLabel();
        lblBigDash5 = new javax.swing.JLabel();
        lblHintDash5N = new javax.swing.JLabel();
        pnlCardStatDash3 = new javax.swing.JPanel();
        lblHintDash3T = new javax.swing.JLabel();
        lblBigDash3 = new javax.swing.JLabel();
        lblHintDash3N = new javax.swing.JLabel();
        pnlCardStatDash0 = new javax.swing.JPanel();
        lblHintDash0T = new javax.swing.JLabel();
        lblBigDash0 = new javax.swing.JLabel();
        lblHintDash0N = new javax.swing.JLabel();
        pnlCardStatDash2 = new javax.swing.JPanel();
        lblHintDash2T = new javax.swing.JLabel();
        lblBigDash2 = new javax.swing.JLabel();
        lblHintDash2N = new javax.swing.JLabel();
        pnlGapDash1 = new javax.swing.JPanel();
        pnlDuaDash = new javax.swing.JPanel();
        pnlCardKec = new javax.swing.JPanel();
        pnlHeadKec = new javax.swing.JPanel();
        lblHKec = new javax.swing.JLabel();
        lblHintKecSub = new javax.swing.JLabel();
        charKec = new view.util.Charts.Column();
        lblHintKecTop = new javax.swing.JLabel();
        pnlCardRing = new javax.swing.JPanel();
        pnlHeadRing = new javax.swing.JPanel();
        lblHRing = new javax.swing.JLabel();
        tabRingkas = new javax.swing.JTabbedPane();
        pnlTabKomposisi = new javax.swing.JPanel();
        pieKategori = new view.util.Charts.Pie();
        pnlTabStok = new javax.swing.JPanel();
        lblB1S = new javax.swing.JLabel();
        lblB2S = new javax.swing.JLabel();
        lblB3S = new javax.swing.JLabel();
        lblB3S1 = new javax.swing.JLabel();
        lblB3S2 = new javax.swing.JLabel();
        lblB3S3 = new javax.swing.JLabel();
        pnlTabKat = new javax.swing.JPanel();
        pieKuota = new view.util.Charts.Pie();
        pnlGapDash2 = new javax.swing.JPanel();
        pnlCardTerbaru = new javax.swing.JPanel();
        pnlHeadTerbaru = new javax.swing.JPanel();
        lblHTerbaru = new javax.swing.JLabel();
        scrTerbaru = new javax.swing.JScrollPane();
        tblTerbaru = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderDash.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderDash.setOpaque(false);
        pnlHeaderDash.setLayout(new java.awt.BorderLayout());

        pnlTitlesDash.setAlignmentX(0.0F);
        pnlTitlesDash.setOpaque(false);
        pnlTitlesDash.setLayout(new javax.swing.BoxLayout(pnlTitlesDash, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitleDash.setText("Dashboard");
        lblTitleDash.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitleDash.setForeground(new java.awt.Color(29, 42, 34));
        pnlTitlesDash.add(lblTitleDash);

        lblSubDash.setText("Fokus distribusi pupuk: penyaluran hari ini, petani subsidi, dan sebaran per kecamatan.");
        lblSubDash.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubDash.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesDash.add(lblSubDash);

        pnlHeaderDash.add(pnlTitlesDash, java.awt.BorderLayout.WEST);

        pnlTopDash.setOpaque(false);
        pnlTopDash.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderDash.add(pnlTopDash, java.awt.BorderLayout.EAST);

        add(pnlHeaderDash, java.awt.BorderLayout.NORTH);

        scrBodyDash.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterDash.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterDash.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterDash.setLayout(new java.awt.BorderLayout());

        pnlStackDash.setAlignmentX(0.0F);
        pnlStackDash.setOpaque(false);
        pnlStackDash.setLayout(new javax.swing.BoxLayout(pnlStackDash, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapDash0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapDash0.setAlignmentX(0.0F);
        pnlGapDash0.setOpaque(false);
        pnlGapDash0.setLayout(new java.awt.BorderLayout());

        pnlStatsDash.setAlignmentX(0.0F);
        pnlStatsDash.setMaximumSize(new java.awt.Dimension(4000, 260));
        pnlStatsDash.setPreferredSize(new java.awt.Dimension(900, 254));
        pnlStatsDash.setOpaque(false);
        pnlStatsDash.setLayout(new java.awt.GridLayout(0, 3, 14, 14));

        pnlCardStatDash4.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatDash4.setAlignmentX(0.0F);
        pnlCardStatDash4.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatDash4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatDash4.setLayout(new javax.swing.BoxLayout(pnlCardStatDash4, javax.swing.BoxLayout.PAGE_AXIS));

        lblHintDash4T.setText("Penyaluran hari ini");
        lblHintDash4T.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash4.add(lblHintDash4T);

        lblBigDash4.setText("2.750 kg");
        lblBigDash4.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        lblBigDash4.setForeground(new java.awt.Color(29, 42, 34));
        pnlCardStatDash4.add(lblBigDash4);

        lblHintDash4N.setText("2 pengiriman");
        lblHintDash4N.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash4.add(lblHintDash4N);

        pnlStatsDash.add(pnlCardStatDash4);

        pnlCardStatDash1.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatDash1.setAlignmentX(0.0F);
        pnlCardStatDash1.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatDash1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatDash1.setLayout(new javax.swing.BoxLayout(pnlCardStatDash1, javax.swing.BoxLayout.PAGE_AXIS));

        lblHintDash1T.setText("Penyaluran bulan ini");
        lblHintDash1T.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash1.add(lblHintDash1T);

        lblBigDash1.setText("18.250 kg");
        lblBigDash1.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        lblBigDash1.setForeground(new java.awt.Color(29, 42, 34));
        pnlCardStatDash1.add(lblBigDash1);

        lblHintDash1N.setText("12 transaksi");
        lblHintDash1N.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash1.add(lblHintDash1N);

        pnlStatsDash.add(pnlCardStatDash1);

        pnlCardStatDash5.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatDash5.setAlignmentX(0.0F);
        pnlCardStatDash5.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatDash5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatDash5.setLayout(new javax.swing.BoxLayout(pnlCardStatDash5, javax.swing.BoxLayout.PAGE_AXIS));

        lblHintDash5T.setText("Petani penerima subsidi");
        lblHintDash5T.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash5.add(lblHintDash5T);

        lblBigDash5.setText("874");
        lblBigDash5.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        lblBigDash5.setForeground(new java.awt.Color(29, 42, 34));
        pnlCardStatDash5.add(lblBigDash5);

        lblHintDash5N.setText("dari 1.284 petani terdaftar");
        lblHintDash5N.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash5.add(lblHintDash5N);

        pnlStatsDash.add(pnlCardStatDash5);

        pnlCardStatDash3.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatDash3.setAlignmentX(0.0F);
        pnlCardStatDash3.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatDash3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatDash3.setLayout(new javax.swing.BoxLayout(pnlCardStatDash3, javax.swing.BoxLayout.PAGE_AXIS));

        lblHintDash3T.setText("Menunggu konfirmasi");
        lblHintDash3T.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash3.add(lblHintDash3T);

        lblBigDash3.setText("3");
        lblBigDash3.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        lblBigDash3.setForeground(new java.awt.Color(29, 42, 34));
        pnlCardStatDash3.add(lblBigDash3);

        lblHintDash3N.setText("pengiriman");
        lblHintDash3N.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash3.add(lblHintDash3N);

        pnlStatsDash.add(pnlCardStatDash3);

        pnlCardStatDash0.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatDash0.setAlignmentX(0.0F);
        pnlCardStatDash0.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatDash0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatDash0.setLayout(new javax.swing.BoxLayout(pnlCardStatDash0, javax.swing.BoxLayout.PAGE_AXIS));

        lblHintDash0T.setText("Total stok gudang");
        lblHintDash0T.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash0.add(lblHintDash0T);

        lblBigDash0.setText("303.000 kg");
        lblBigDash0.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        lblBigDash0.setForeground(new java.awt.Color(29, 42, 34));
        pnlCardStatDash0.add(lblBigDash0);

        lblHintDash0N.setText("semua produk");
        lblHintDash0N.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash0.add(lblHintDash0N);

        pnlStatsDash.add(pnlCardStatDash0);

        pnlCardStatDash2.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatDash2.setAlignmentX(0.0F);
        pnlCardStatDash2.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatDash2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatDash2.setLayout(new javax.swing.BoxLayout(pnlCardStatDash2, javax.swing.BoxLayout.PAGE_AXIS));

        lblHintDash2T.setText("Petani terdaftar");
        lblHintDash2T.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash2.add(lblHintDash2T);

        lblBigDash2.setText("1.284");
        lblBigDash2.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        lblBigDash2.setForeground(new java.awt.Color(29, 42, 34));
        pnlCardStatDash2.add(lblBigDash2);

        lblHintDash2N.setText("10 kecamatan");
        lblHintDash2N.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatDash2.add(lblHintDash2N);

        pnlStatsDash.add(pnlCardStatDash2);

        pnlGapDash0.add(pnlStatsDash, java.awt.BorderLayout.CENTER);

        pnlStackDash.add(pnlGapDash0);

        pnlGapDash1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapDash1.setAlignmentX(0.0F);
        pnlGapDash1.setOpaque(false);
        pnlGapDash1.setLayout(new java.awt.BorderLayout());

        pnlDuaDash.setAlignmentX(0.0F);
        pnlDuaDash.setMaximumSize(new java.awt.Dimension(4000, 380));
        pnlDuaDash.setPreferredSize(new java.awt.Dimension(900, 380));
        pnlDuaDash.setOpaque(false);
        pnlDuaDash.setLayout(new java.awt.GridLayout(0, 2, 16, 0));

        pnlCardKec.setAlignmentX(0.0F);
        pnlCardKec.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardKec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardKec.setLayout(new javax.swing.BoxLayout(pnlCardKec, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadKec.setAlignmentX(0.0F);
        pnlHeadKec.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadKec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadKec.setOpaque(false);
        pnlHeadKec.setLayout(new java.awt.BorderLayout());

        lblHKec.setText("Pupuk terbanyak didistribusikan per kecamatan");
        lblHKec.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHKec.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadKec.add(lblHKec, java.awt.BorderLayout.WEST);

        pnlCardKec.add(pnlHeadKec);

        lblHintKecSub.setText("kg per kecamatan");
        lblHintKecSub.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardKec.add(lblHintKecSub);

        charKec.setAlignmentX(0.0F);
        charKec.setPreferredSize(new java.awt.Dimension(300, 200));
        pnlCardKec.add(charKec);

        lblHintKecTop.setText("<html><b>Pupuk terbanyak:</b> Samarinda Ulu · NPK Phonska &nbsp;|&nbsp; Sungai Pinang · Urea Subsidi &nbsp;|&nbsp; Samarinda Ilir · Urea Non Subsidi</html>");
        lblHintKecTop.setForeground(new java.awt.Color(122, 127, 115));
        lblHintKecTop.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 14, 6, 14));
        pnlCardKec.add(lblHintKecTop);

        pnlDuaDash.add(pnlCardKec);

        pnlCardRing.setAlignmentX(0.0F);
        pnlCardRing.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardRing.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardRing.setLayout(new javax.swing.BoxLayout(pnlCardRing, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadRing.setAlignmentX(0.0F);
        pnlHeadRing.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadRing.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadRing.setOpaque(false);
        pnlHeadRing.setLayout(new java.awt.BorderLayout());

        lblHRing.setText("Ringkasan gudang dan kuota");
        lblHRing.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHRing.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadRing.add(lblHRing, java.awt.BorderLayout.WEST);

        pnlCardRing.add(pnlHeadRing);

        tabRingkas.setAlignmentX(0.0F);
        tabRingkas.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tabRingkas.setMaximumSize(new java.awt.Dimension(4000, 300));
        tabRingkas.setPreferredSize(new java.awt.Dimension(500, 280));

        pnlTabKomposisi.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabKomposisi.setAlignmentX(0.0F);
        pnlTabKomposisi.setOpaque(false);
        pnlTabKomposisi.setLayout(new java.awt.BorderLayout());
        pnlTabKomposisi.add(pieKategori, java.awt.BorderLayout.CENTER);

        tabRingkas.addTab("Subsidi vs non subsidi", pnlTabKomposisi);

        pnlTabStok.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabStok.setAlignmentX(0.0F);
        pnlTabStok.setOpaque(false);
        pnlTabStok.setLayout(new javax.swing.BoxLayout(pnlTabStok, javax.swing.BoxLayout.PAGE_AXIS));

        lblB1S.setText("Urea Subsidi — 145.000 kg");
        lblB1S.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblB1S.setForeground(new java.awt.Color(29, 42, 34));
        pnlTabStok.add(lblB1S);

        lblB2S.setText("NPK Phonska — 98.000 kg");
        lblB2S.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblB2S.setForeground(new java.awt.Color(29, 42, 34));
        pnlTabStok.add(lblB2S);

        lblB3S.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblB3S.setForeground(new java.awt.Color(29, 42, 34));
        lblB3S.setText("Dolomit — 60.000 kg");
        pnlTabStok.add(lblB3S);

        lblB3S1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblB3S1.setForeground(new java.awt.Color(29, 42, 34));
        lblB3S1.setText("NPK — 69.000 kg");
        lblB3S1.setName("lblB3S1"); // NOI18N
        pnlTabStok.add(lblB3S1);

        lblB3S2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblB3S2.setForeground(new java.awt.Color(29, 42, 34));
        lblB3S2.setText("ZA — 76.000 kg");
        lblB3S2.setName("lblB3S2"); // NOI18N
        pnlTabStok.add(lblB3S2);

        lblB3S3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblB3S3.setForeground(new java.awt.Color(29, 42, 34));
        lblB3S3.setText("NPK untuk kakao — 55.000 kg");
        lblB3S3.setName("lblB3S3"); // NOI18N
        pnlTabStok.add(lblB3S3);

        tabRingkas.addTab("Stok gudang", pnlTabStok);

        pnlTabKat.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabKat.setAlignmentX(0.0F);
        pnlTabKat.setOpaque(false);
        pnlTabKat.setLayout(new java.awt.BorderLayout());
        pnlTabKat.add(pieKuota, java.awt.BorderLayout.CENTER);

        tabRingkas.addTab("Kuota subsidi", pnlTabKat);

        pnlCardRing.add(tabRingkas);

        pnlDuaDash.add(pnlCardRing);

        pnlGapDash1.add(pnlDuaDash, java.awt.BorderLayout.CENTER);

        pnlStackDash.add(pnlGapDash1);

        pnlGapDash2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapDash2.setAlignmentX(0.0F);
        pnlGapDash2.setOpaque(false);
        pnlGapDash2.setLayout(new java.awt.BorderLayout());

        pnlCardTerbaru.setAlignmentX(0.0F);
        pnlCardTerbaru.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardTerbaru.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardTerbaru.setLayout(new javax.swing.BoxLayout(pnlCardTerbaru, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadTerbaru.setAlignmentX(0.0F);
        pnlHeadTerbaru.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadTerbaru.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadTerbaru.setOpaque(false);
        pnlHeadTerbaru.setLayout(new java.awt.BorderLayout());

        lblHTerbaru.setText("Penyaluran terbaru");
        lblHTerbaru.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHTerbaru.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadTerbaru.add(lblHTerbaru, java.awt.BorderLayout.WEST);

        pnlCardTerbaru.add(pnlHeadTerbaru);

        scrTerbaru.setPreferredSize(new java.awt.Dimension(600, 200));
        scrTerbaru.setMaximumSize(new java.awt.Dimension(4000, 200));
        scrTerbaru.setAlignmentX(0.0F);

        tblTerbaru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Penyaluran", "Produk", "Kecamatan", "Jumlah (kg)", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTerbaru.setViewportView(tblTerbaru);

        pnlCardTerbaru.add(scrTerbaru);

        pnlGapDash2.add(pnlCardTerbaru, java.awt.BorderLayout.CENTER);

        pnlStackDash.add(pnlGapDash2);

        pnlOuterDash.add(pnlStackDash, java.awt.BorderLayout.NORTH);

        scrBodyDash.setViewportView(pnlOuterDash);

        add(scrBodyDash, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.util.Charts.Column charKec;
    private javax.swing.JLabel lblB1S;
    private javax.swing.JLabel lblB2S;
    private javax.swing.JLabel lblB3S;
    private javax.swing.JLabel lblB3S1;
    private javax.swing.JLabel lblB3S2;
    private javax.swing.JLabel lblB3S3;
    private javax.swing.JLabel lblBigDash0;
    private javax.swing.JLabel lblBigDash1;
    private javax.swing.JLabel lblBigDash2;
    private javax.swing.JLabel lblBigDash3;
    private javax.swing.JLabel lblBigDash4;
    private javax.swing.JLabel lblBigDash5;
    private javax.swing.JLabel lblHKec;
    private javax.swing.JLabel lblHRing;
    private javax.swing.JLabel lblHTerbaru;
    private javax.swing.JLabel lblHintDash0N;
    private javax.swing.JLabel lblHintDash0T;
    private javax.swing.JLabel lblHintDash1N;
    private javax.swing.JLabel lblHintDash1T;
    private javax.swing.JLabel lblHintDash2N;
    private javax.swing.JLabel lblHintDash2T;
    private javax.swing.JLabel lblHintDash3N;
    private javax.swing.JLabel lblHintDash3T;
    private javax.swing.JLabel lblHintDash4N;
    private javax.swing.JLabel lblHintDash4T;
    private javax.swing.JLabel lblHintDash5N;
    private javax.swing.JLabel lblHintDash5T;
    private javax.swing.JLabel lblHintKecSub;
    private javax.swing.JLabel lblHintKecTop;
    private javax.swing.JLabel lblSubDash;
    private javax.swing.JLabel lblTitleDash;
    private view.util.Charts.Pie pieKategori;
    private view.util.Charts.Pie pieKuota;
    private javax.swing.JPanel pnlCardKec;
    private javax.swing.JPanel pnlCardRing;
    private javax.swing.JPanel pnlCardStatDash0;
    private javax.swing.JPanel pnlCardStatDash1;
    private javax.swing.JPanel pnlCardStatDash2;
    private javax.swing.JPanel pnlCardStatDash3;
    private javax.swing.JPanel pnlCardStatDash4;
    private javax.swing.JPanel pnlCardStatDash5;
    private javax.swing.JPanel pnlCardTerbaru;
    private javax.swing.JPanel pnlDuaDash;
    private javax.swing.JPanel pnlGapDash0;
    private javax.swing.JPanel pnlGapDash1;
    private javax.swing.JPanel pnlGapDash2;
    private javax.swing.JPanel pnlHeadKec;
    private javax.swing.JPanel pnlHeadRing;
    private javax.swing.JPanel pnlHeadTerbaru;
    private javax.swing.JPanel pnlHeaderDash;
    private javax.swing.JPanel pnlOuterDash;
    private javax.swing.JPanel pnlStackDash;
    private javax.swing.JPanel pnlStatsDash;
    private javax.swing.JPanel pnlTabKat;
    private javax.swing.JPanel pnlTabKomposisi;
    private javax.swing.JPanel pnlTabStok;
    private javax.swing.JPanel pnlTitlesDash;
    private javax.swing.JPanel pnlTopDash;
    private javax.swing.JScrollPane scrBodyDash;
    private javax.swing.JScrollPane scrTerbaru;
    private javax.swing.JTabbedPane tabRingkas;
    private javax.swing.JTable tblTerbaru;
    // End of variables declaration//GEN-END:variables
}
