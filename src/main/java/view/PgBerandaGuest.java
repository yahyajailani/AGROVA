package view;

import view.util.*;

/** Beranda. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgBerandaGuest extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgBerandaGuest() {
        initComponents();
        Styler.apply(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrBodyBeranda = new javax.swing.JScrollPane();
        pnlPageBeranda = new javax.swing.JPanel();
        pnlTopBeranda = new javax.swing.JPanel();
        lblLightImgHero = new javax.swing.JLabel();
        pnlBodyBeranda = new javax.swing.JPanel();
        lblHProduk = new javax.swing.JLabel();
        pnlProduk = new javax.swing.JPanel();
        pnlIsiProdUrea = new javax.swing.JPanel();
        lblGbrUrea = new javax.swing.JLabel();
        pnlTeksProdUrea = new javax.swing.JPanel();
        lblBUrea = new javax.swing.JLabel();
        lblHintUreaK = new javax.swing.JLabel();
        lblUraianUrea = new javax.swing.JLabel();
        pnlIsiProdNpk = new javax.swing.JPanel();
        lblGbrNpk = new javax.swing.JLabel();
        pnlTeksProdNpk = new javax.swing.JPanel();
        lblBNpk = new javax.swing.JLabel();
        lblHintNpkK = new javax.swing.JLabel();
        lblUraianNpk = new javax.swing.JLabel();
        pnlIsiProdKakao = new javax.swing.JPanel();
        lblGbrKakao = new javax.swing.JLabel();
        pnlTeksProdKakao = new javax.swing.JPanel();
        lblBKakao = new javax.swing.JLabel();
        lblHintKakaoK = new javax.swing.JLabel();
        lblUraianKakao = new javax.swing.JLabel();
        pnlIsiProdPhonska = new javax.swing.JPanel();
        lblGbrPhonska = new javax.swing.JLabel();
        pnlTeksProdPhonska = new javax.swing.JPanel();
        lblBPhonska = new javax.swing.JLabel();
        lblHintPhonskaK = new javax.swing.JLabel();
        lblUraianPhonska = new javax.swing.JLabel();
        pnlIsiProdZa = new javax.swing.JPanel();
        lblGbrZa = new javax.swing.JLabel();
        pnlTeksProdZa = new javax.swing.JPanel();
        lblBZa = new javax.swing.JLabel();
        lblHintZaK = new javax.swing.JLabel();
        lblUraianZa = new javax.swing.JLabel();
        pnlIsiProdDolomit = new javax.swing.JPanel();
        lblGbrDolomit = new javax.swing.JLabel();
        pnlTeksProdDolomit = new javax.swing.JPanel();
        lblBDolomit = new javax.swing.JLabel();
        lblHintDolomitK = new javax.swing.JLabel();
        lblUraianDolomit = new javax.swing.JLabel();
        pnlCardProdUrea = new javax.swing.JPanel();
        pnlCardProdNpk = new javax.swing.JPanel();
        pnlCardProdKakao = new javax.swing.JPanel();
        pnlCardProdPhonska = new javax.swing.JPanel();
        pnlCardProdZa = new javax.swing.JPanel();
        pnlCardProdDolomit = new javax.swing.JPanel();
        lblHAlur = new javax.swing.JLabel();
        pnlAlur = new javax.swing.JPanel();
        pnlSoftStep1 = new javax.swing.JPanel();
        lblB1 = new javax.swing.JLabel();
        lblHint1 = new javax.swing.JLabel();
        pnlSoftStep2 = new javax.swing.JPanel();
        lblB2 = new javax.swing.JLabel();
        lblHint2 = new javax.swing.JLabel();
        pnlSoftStep3 = new javax.swing.JPanel();
        lblB3 = new javax.swing.JLabel();
        lblHint3 = new javax.swing.JLabel();
        pnlSoftStep4 = new javax.swing.JPanel();
        lblB4 = new javax.swing.JLabel();
        lblHint4 = new javax.swing.JLabel();
        lblHintFoot = new javax.swing.JLabel();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(1180, 700));
        setLayout(new java.awt.BorderLayout());

        scrBodyBeranda.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlPageBeranda.setBackground(new java.awt.Color(246, 241, 231));
        pnlPageBeranda.setLayout(new java.awt.BorderLayout());

        pnlTopBeranda.setAlignmentX(0.0F);
        pnlTopBeranda.setOpaque(false);
        pnlTopBeranda.setLayout(new javax.swing.BoxLayout(pnlTopBeranda, javax.swing.BoxLayout.PAGE_AXIS));

        lblLightImgHero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/beranda_hero_gelap.png"))); // NOI18N
        lblLightImgHero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblLightImgHero.setText("<html><table width=\"1180\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"48\"></td><td><table cellpadding=\"6\" cellspacing=\"0\"><tr><td bgcolor=\"#5BAF5B\"><font color=\"white\" size=\"3\"><b>&nbsp;MITRA DISTRIBUSI PUPUK TERPERCAYA&nbsp;</b></font></td></tr></table><div style=\"font-family:Georgia;font-size:44px;font-weight:bold;color:white\">Distribusi Pupuk</div><div style=\"font-family:Georgia;font-size:44px;font-weight:bold;color:#5BAF5B\">Tepat Sasaran</div><br><div style=\"font-size:15px;color:#f0f5f1\">Perusahaan Root menyalurkan pupuk dari gudang pusat, lewat penyalur kecamatan,<br>sampai ke tangan petani di Samarinda. Semua tercatat.</div></td></tr></table>");
        lblLightImgHero.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblLightImgHero.setForeground(new java.awt.Color(227, 237, 229));
        pnlTopBeranda.add(lblLightImgHero);

        pnlPageBeranda.add(pnlTopBeranda, java.awt.BorderLayout.NORTH);

        pnlBodyBeranda.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 0, 40));
        pnlBodyBeranda.setAlignmentX(0.0F);
        pnlBodyBeranda.setOpaque(false);
        pnlBodyBeranda.setLayout(new javax.swing.BoxLayout(pnlBodyBeranda, javax.swing.BoxLayout.PAGE_AXIS));

        lblHProduk.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 0, 10, 0));
        lblHProduk.setText("Katalog pupuk subsidi");
        lblHProduk.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHProduk.setForeground(new java.awt.Color(29, 42, 34));
        pnlBodyBeranda.add(lblHProduk);

        pnlProduk.setAlignmentX(0.0F);
        pnlProduk.setMaximumSize(new java.awt.Dimension(4000, 494));
        pnlProduk.setPreferredSize(new java.awt.Dimension(900, 494));
        pnlProduk.setOpaque(false);
        pnlProduk.setLayout(new java.awt.GridLayout(0, 3, 14, 14));

        pnlCardProdUrea.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardProdUrea.setAlignmentX(0.0F);
        pnlCardProdUrea.setPreferredSize(new java.awt.Dimension(300, 240));
        pnlCardProdUrea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardProdUrea.setLayout(new java.awt.BorderLayout());

        pnlIsiProdUrea.setOpaque(false);
        pnlIsiProdUrea.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 12));
        pnlIsiProdUrea.setLayout(new java.awt.BorderLayout(14, 0));

        lblGbrUrea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pupuk/kecil/urea_subsidi.png"))); // NOI18N
        lblGbrUrea.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlIsiProdUrea.add(lblGbrUrea, java.awt.BorderLayout.WEST);

        pnlTeksProdUrea.setOpaque(false);
        pnlTeksProdUrea.setLayout(new javax.swing.BoxLayout(pnlTeksProdUrea, javax.swing.BoxLayout.PAGE_AXIS));

        lblBUrea.setText("Urea");
        lblBUrea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBUrea.setForeground(new java.awt.Color(29, 42, 34));
        lblBUrea.setAlignmentX(0.0F);
        pnlTeksProdUrea.add(lblBUrea);

        lblHintUreaK.setText("Subsidi");
        lblHintUreaK.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblHintUreaK.setForeground(new java.awt.Color(31, 77, 58));
        lblHintUreaK.setAlignmentX(0.0F);
        pnlTeksProdUrea.add(lblHintUreaK);

        lblUraianUrea.setText("<html><div style=\"width:145px\">Sumber nitrogen tinggi (sekitar 46%). Mempercepat pertumbuhan daun dan batang, umum untuk padi dan jagung.<br><br>HET sekitar Rp112.500 per karung 50 kg.</div>");
        lblUraianUrea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblUraianUrea.setForeground(new java.awt.Color(98, 104, 92));
        lblUraianUrea.setAlignmentX(0.0F);
        pnlTeksProdUrea.add(lblUraianUrea);
        pnlIsiProdUrea.add(pnlTeksProdUrea, java.awt.BorderLayout.CENTER);
        pnlCardProdUrea.add(pnlIsiProdUrea, java.awt.BorderLayout.CENTER);
        pnlProduk.add(pnlCardProdUrea);

        pnlCardProdNpk.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardProdNpk.setAlignmentX(0.0F);
        pnlCardProdNpk.setPreferredSize(new java.awt.Dimension(300, 240));
        pnlCardProdNpk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardProdNpk.setLayout(new java.awt.BorderLayout());

        pnlIsiProdNpk.setOpaque(false);
        pnlIsiProdNpk.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 12));
        pnlIsiProdNpk.setLayout(new java.awt.BorderLayout(14, 0));

        lblGbrNpk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pupuk/kecil/npk_subsidi.png"))); // NOI18N
        lblGbrNpk.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlIsiProdNpk.add(lblGbrNpk, java.awt.BorderLayout.WEST);

        pnlTeksProdNpk.setOpaque(false);
        pnlTeksProdNpk.setLayout(new javax.swing.BoxLayout(pnlTeksProdNpk, javax.swing.BoxLayout.PAGE_AXIS));

        lblBNpk.setText("NPK");
        lblBNpk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBNpk.setForeground(new java.awt.Color(29, 42, 34));
        lblBNpk.setAlignmentX(0.0F);
        pnlTeksProdNpk.add(lblBNpk);

        lblHintNpkK.setText("Subsidi");
        lblHintNpkK.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblHintNpkK.setForeground(new java.awt.Color(31, 77, 58));
        lblHintNpkK.setAlignmentX(0.0F);
        pnlTeksProdNpk.add(lblHintNpkK);

        lblUraianNpk.setText("<html><div style=\"width:145px\">Pupuk majemuk: nitrogen, fosfor, dan kalium dalam satu karung. Cocok untuk pemupukan dasar berbagai tanaman pangan.<br><br>HET sekitar Rp112.500 per karung 50 kg.</div>");
        lblUraianNpk.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblUraianNpk.setForeground(new java.awt.Color(98, 104, 92));
        lblUraianNpk.setAlignmentX(0.0F);
        pnlTeksProdNpk.add(lblUraianNpk);
        pnlIsiProdNpk.add(pnlTeksProdNpk, java.awt.BorderLayout.CENTER);
        pnlCardProdNpk.add(pnlIsiProdNpk, java.awt.BorderLayout.CENTER);
        pnlProduk.add(pnlCardProdNpk);

        pnlCardProdKakao.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardProdKakao.setAlignmentX(0.0F);
        pnlCardProdKakao.setPreferredSize(new java.awt.Dimension(300, 240));
        pnlCardProdKakao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardProdKakao.setLayout(new java.awt.BorderLayout());

        pnlIsiProdKakao.setOpaque(false);
        pnlIsiProdKakao.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 12));
        pnlIsiProdKakao.setLayout(new java.awt.BorderLayout(14, 0));

        lblGbrKakao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pupuk/kecil/npk_untuk_kakao_subsidi.png"))); // NOI18N
        lblGbrKakao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlIsiProdKakao.add(lblGbrKakao, java.awt.BorderLayout.WEST);

        pnlTeksProdKakao.setOpaque(false);
        pnlTeksProdKakao.setLayout(new javax.swing.BoxLayout(pnlTeksProdKakao, javax.swing.BoxLayout.PAGE_AXIS));

        lblBKakao.setText("NPK untuk kakao");
        lblBKakao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBKakao.setForeground(new java.awt.Color(29, 42, 34));
        lblBKakao.setAlignmentX(0.0F);
        pnlTeksProdKakao.add(lblBKakao);

        lblHintKakaoK.setText("Subsidi");
        lblHintKakaoK.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblHintKakaoK.setForeground(new java.awt.Color(31, 77, 58));
        lblHintKakaoK.setAlignmentX(0.0F);
        pnlTeksProdKakao.add(lblHintKakaoK);

        lblUraianKakao.setText("<html><div style=\"width:145px\">Formula majemuk untuk tanaman kakao. Mendukung pembungaan dan pembentukan buah.<br><br>HET sekitar Rp120.000 per karung 50 kg.</div>");
        lblUraianKakao.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblUraianKakao.setForeground(new java.awt.Color(98, 104, 92));
        lblUraianKakao.setAlignmentX(0.0F);
        pnlTeksProdKakao.add(lblUraianKakao);
        pnlIsiProdKakao.add(pnlTeksProdKakao, java.awt.BorderLayout.CENTER);
        pnlCardProdKakao.add(pnlIsiProdKakao, java.awt.BorderLayout.CENTER);
        pnlProduk.add(pnlCardProdKakao);

        pnlCardProdPhonska.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardProdPhonska.setAlignmentX(0.0F);
        pnlCardProdPhonska.setPreferredSize(new java.awt.Dimension(300, 240));
        pnlCardProdPhonska.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardProdPhonska.setLayout(new java.awt.BorderLayout());

        pnlIsiProdPhonska.setOpaque(false);
        pnlIsiProdPhonska.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 12));
        pnlIsiProdPhonska.setLayout(new java.awt.BorderLayout(14, 0));

        lblGbrPhonska.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pupuk/kecil/npk_phonska_subsidi.png"))); // NOI18N
        lblGbrPhonska.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlIsiProdPhonska.add(lblGbrPhonska, java.awt.BorderLayout.WEST);

        pnlTeksProdPhonska.setOpaque(false);
        pnlTeksProdPhonska.setLayout(new javax.swing.BoxLayout(pnlTeksProdPhonska, javax.swing.BoxLayout.PAGE_AXIS));

        lblBPhonska.setText("NPK Phonska");
        lblBPhonska.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBPhonska.setForeground(new java.awt.Color(29, 42, 34));
        lblBPhonska.setAlignmentX(0.0F);
        pnlTeksProdPhonska.add(lblBPhonska);

        lblHintPhonskaK.setText("Subsidi");
        lblHintPhonskaK.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblHintPhonskaK.setForeground(new java.awt.Color(31, 77, 58));
        lblHintPhonskaK.setAlignmentX(0.0F);
        pnlTeksProdPhonska.add(lblHintPhonskaK);

        lblUraianPhonska.setText("<html><div style=\"width:145px\">NPK dengan tambahan sulfur. Dipakai luas pada padi, jagung, dan hortikultura.<br><br>HET sekitar Rp85.000 per karung 50 kg.</div>");
        lblUraianPhonska.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblUraianPhonska.setForeground(new java.awt.Color(98, 104, 92));
        lblUraianPhonska.setAlignmentX(0.0F);
        pnlTeksProdPhonska.add(lblUraianPhonska);
        pnlIsiProdPhonska.add(pnlTeksProdPhonska, java.awt.BorderLayout.CENTER);
        pnlCardProdPhonska.add(pnlIsiProdPhonska, java.awt.BorderLayout.CENTER);
        pnlProduk.add(pnlCardProdPhonska);

        pnlCardProdZa.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardProdZa.setAlignmentX(0.0F);
        pnlCardProdZa.setPreferredSize(new java.awt.Dimension(300, 240));
        pnlCardProdZa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardProdZa.setLayout(new java.awt.BorderLayout());

        pnlIsiProdZa.setOpaque(false);
        pnlIsiProdZa.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 12));
        pnlIsiProdZa.setLayout(new java.awt.BorderLayout(14, 0));

        lblGbrZa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pupuk/kecil/za_subsidi.png"))); // NOI18N
        lblGbrZa.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlIsiProdZa.add(lblGbrZa, java.awt.BorderLayout.WEST);

        pnlTeksProdZa.setOpaque(false);
        pnlTeksProdZa.setLayout(new javax.swing.BoxLayout(pnlTeksProdZa, javax.swing.BoxLayout.PAGE_AXIS));

        lblBZa.setText("ZA");
        lblBZa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBZa.setForeground(new java.awt.Color(29, 42, 34));
        lblBZa.setAlignmentX(0.0F);
        pnlTeksProdZa.add(lblBZa);

        lblHintZaK.setText("Subsidi");
        lblHintZaK.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblHintZaK.setForeground(new java.awt.Color(31, 77, 58));
        lblHintZaK.setAlignmentX(0.0F);
        pnlTeksProdZa.add(lblHintZaK);

        lblUraianZa.setText("<html><div style=\"width:145px\">Mengandung nitrogen dan sulfur. Cocok untuk tanah yang kekurangan belerang.<br><br>HET sekitar Rp95.000 per karung 50 kg.</div>");
        lblUraianZa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblUraianZa.setForeground(new java.awt.Color(98, 104, 92));
        lblUraianZa.setAlignmentX(0.0F);
        pnlTeksProdZa.add(lblUraianZa);
        pnlIsiProdZa.add(pnlTeksProdZa, java.awt.BorderLayout.CENTER);
        pnlCardProdZa.add(pnlIsiProdZa, java.awt.BorderLayout.CENTER);
        pnlProduk.add(pnlCardProdZa);

        pnlCardProdDolomit.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardProdDolomit.setAlignmentX(0.0F);
        pnlCardProdDolomit.setPreferredSize(new java.awt.Dimension(300, 240));
        pnlCardProdDolomit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardProdDolomit.setLayout(new java.awt.BorderLayout());

        pnlIsiProdDolomit.setOpaque(false);
        pnlIsiProdDolomit.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 12));
        pnlIsiProdDolomit.setLayout(new java.awt.BorderLayout(14, 0));

        lblGbrDolomit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pupuk/kecil/dolomit_subsidi.png"))); // NOI18N
        lblGbrDolomit.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlIsiProdDolomit.add(lblGbrDolomit, java.awt.BorderLayout.WEST);

        pnlTeksProdDolomit.setOpaque(false);
        pnlTeksProdDolomit.setLayout(new javax.swing.BoxLayout(pnlTeksProdDolomit, javax.swing.BoxLayout.PAGE_AXIS));

        lblBDolomit.setText("Dolomit");
        lblBDolomit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBDolomit.setForeground(new java.awt.Color(29, 42, 34));
        lblBDolomit.setAlignmentX(0.0F);
        pnlTeksProdDolomit.add(lblBDolomit);

        lblHintDolomitK.setText("Subsidi");
        lblHintDolomitK.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblHintDolomitK.setForeground(new java.awt.Color(31, 77, 58));
        lblHintDolomitK.setAlignmentX(0.0F);
        pnlTeksProdDolomit.add(lblHintDolomitK);

        lblUraianDolomit.setText("<html><div style=\"width:145px\">Sumber kalsium dan magnesium. Menaikkan pH tanah masam dan memperbaiki serapan hara.<br><br>HET sekitar Rp75.000 per karung 50 kg.</div>");
        lblUraianDolomit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblUraianDolomit.setForeground(new java.awt.Color(98, 104, 92));
        lblUraianDolomit.setAlignmentX(0.0F);
        pnlTeksProdDolomit.add(lblUraianDolomit);
        pnlIsiProdDolomit.add(pnlTeksProdDolomit, java.awt.BorderLayout.CENTER);
        pnlCardProdDolomit.add(pnlIsiProdDolomit, java.awt.BorderLayout.CENTER);
        pnlProduk.add(pnlCardProdDolomit);

        pnlBodyBeranda.add(pnlProduk);

        lblHAlur.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 0, 10, 0));
        lblHAlur.setText("Alur distribusi");
        lblHAlur.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHAlur.setForeground(new java.awt.Color(29, 42, 34));
        pnlBodyBeranda.add(lblHAlur);

        pnlAlur.setAlignmentX(0.0F);
        pnlAlur.setMaximumSize(new java.awt.Dimension(4000, 110));
        pnlAlur.setPreferredSize(new java.awt.Dimension(900, 100));
        pnlAlur.setOpaque(false);
        pnlAlur.setLayout(new java.awt.GridLayout(0, 4, 14, 0));

        pnlSoftStep1.setPreferredSize(new java.awt.Dimension(200, 90));
        pnlSoftStep1.setAlignmentX(0.0F);
        pnlSoftStep1.setBackground(new java.awt.Color(241, 237, 224));
        pnlSoftStep1.setLayout(new javax.swing.BoxLayout(pnlSoftStep1, javax.swing.BoxLayout.PAGE_AXIS));

        lblB1.setText("1. Alokasi");
        lblB1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblB1.setForeground(new java.awt.Color(29, 42, 34));
        pnlSoftStep1.add(lblB1);

        lblHint1.setText("<html><div style=\"width:150px\">Pengelola menetapkan kuota per kecamatan.</div>");
        lblHint1.setForeground(new java.awt.Color(122, 127, 115));
        pnlSoftStep1.add(lblHint1);

        pnlAlur.add(pnlSoftStep1);

        pnlSoftStep2.setPreferredSize(new java.awt.Dimension(200, 90));
        pnlSoftStep2.setAlignmentX(0.0F);
        pnlSoftStep2.setBackground(new java.awt.Color(241, 237, 224));
        pnlSoftStep2.setLayout(new javax.swing.BoxLayout(pnlSoftStep2, javax.swing.BoxLayout.PAGE_AXIS));

        lblB2.setText("2. Pengiriman");
        lblB2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblB2.setForeground(new java.awt.Color(29, 42, 34));
        pnlSoftStep2.add(lblB2);

        lblHint2.setText("<html><div style=\"width:150px\">Gudang pusat mengirim ke penyalur.</div>");
        lblHint2.setForeground(new java.awt.Color(122, 127, 115));
        pnlSoftStep2.add(lblHint2);

        pnlAlur.add(pnlSoftStep2);

        pnlSoftStep3.setPreferredSize(new java.awt.Dimension(200, 90));
        pnlSoftStep3.setAlignmentX(0.0F);
        pnlSoftStep3.setBackground(new java.awt.Color(241, 237, 224));
        pnlSoftStep3.setLayout(new javax.swing.BoxLayout(pnlSoftStep3, javax.swing.BoxLayout.PAGE_AXIS));

        lblB3.setText("3. Konfirmasi");
        lblB3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblB3.setForeground(new java.awt.Color(29, 42, 34));
        pnlSoftStep3.add(lblB3);

        lblHint3.setText("<html><div style=\"width:150px\">Penyalur memeriksa dan menerima barang.</div>");
        lblHint3.setForeground(new java.awt.Color(122, 127, 115));
        pnlSoftStep3.add(lblHint3);

        pnlAlur.add(pnlSoftStep3);

        pnlSoftStep4.setPreferredSize(new java.awt.Dimension(200, 90));
        pnlSoftStep4.setAlignmentX(0.0F);
        pnlSoftStep4.setBackground(new java.awt.Color(241, 237, 224));
        pnlSoftStep4.setLayout(new javax.swing.BoxLayout(pnlSoftStep4, javax.swing.BoxLayout.PAGE_AXIS));

        lblB4.setText("4. Penyaluran");
        lblB4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblB4.setForeground(new java.awt.Color(29, 42, 34));
        pnlSoftStep4.add(lblB4);

        lblHint4.setText("<html><div style=\"width:150px\">Petani menebus sesuai kuota.</div>");
        lblHint4.setForeground(new java.awt.Color(122, 127, 115));
        pnlSoftStep4.add(lblHint4);

        pnlAlur.add(pnlSoftStep4);

        pnlBodyBeranda.add(pnlAlur);

        lblHintFoot.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 0, 20, 0));
        lblHintFoot.setText("© 2026 AGROVA — Perusahaan Root, Samarinda");
        lblHintFoot.setForeground(new java.awt.Color(122, 127, 115));
        pnlBodyBeranda.add(lblHintFoot);

        pnlPageBeranda.add(pnlBodyBeranda, java.awt.BorderLayout.CENTER);

        scrBodyBeranda.setViewportView(pnlPageBeranda);

        add(scrBodyBeranda, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblB1;
    private javax.swing.JLabel lblB2;
    private javax.swing.JLabel lblB3;
    private javax.swing.JLabel lblB4;
    private javax.swing.JLabel lblHAlur;
    private javax.swing.JLabel lblHProduk;
    private javax.swing.JLabel lblHint1;
    private javax.swing.JLabel lblHint2;
    private javax.swing.JLabel lblHint3;
    private javax.swing.JLabel lblHint4;
    private javax.swing.JLabel lblHintFoot;
    private javax.swing.JLabel lblLightImgHero;
    private javax.swing.JPanel pnlAlur;
    private javax.swing.JPanel pnlBodyBeranda;
    private javax.swing.JPanel pnlCardProdDolomit;
    private javax.swing.JPanel pnlCardProdKakao;
    private javax.swing.JPanel pnlCardProdNpk;
    private javax.swing.JPanel pnlCardProdPhonska;
    private javax.swing.JPanel pnlCardProdUrea;
    private javax.swing.JPanel pnlCardProdZa;
    private javax.swing.JPanel pnlPageBeranda;
    private javax.swing.JPanel pnlProduk;
    private javax.swing.JPanel pnlIsiProdUrea;
    private javax.swing.JLabel lblGbrUrea;
    private javax.swing.JPanel pnlTeksProdUrea;
    private javax.swing.JLabel lblBUrea;
    private javax.swing.JLabel lblHintUreaK;
    private javax.swing.JLabel lblUraianUrea;
    private javax.swing.JPanel pnlIsiProdNpk;
    private javax.swing.JLabel lblGbrNpk;
    private javax.swing.JPanel pnlTeksProdNpk;
    private javax.swing.JLabel lblBNpk;
    private javax.swing.JLabel lblHintNpkK;
    private javax.swing.JLabel lblUraianNpk;
    private javax.swing.JPanel pnlIsiProdKakao;
    private javax.swing.JLabel lblGbrKakao;
    private javax.swing.JPanel pnlTeksProdKakao;
    private javax.swing.JLabel lblBKakao;
    private javax.swing.JLabel lblHintKakaoK;
    private javax.swing.JLabel lblUraianKakao;
    private javax.swing.JPanel pnlIsiProdPhonska;
    private javax.swing.JLabel lblGbrPhonska;
    private javax.swing.JPanel pnlTeksProdPhonska;
    private javax.swing.JLabel lblBPhonska;
    private javax.swing.JLabel lblHintPhonskaK;
    private javax.swing.JLabel lblUraianPhonska;
    private javax.swing.JPanel pnlIsiProdZa;
    private javax.swing.JLabel lblGbrZa;
    private javax.swing.JPanel pnlTeksProdZa;
    private javax.swing.JLabel lblBZa;
    private javax.swing.JLabel lblHintZaK;
    private javax.swing.JLabel lblUraianZa;
    private javax.swing.JPanel pnlIsiProdDolomit;
    private javax.swing.JLabel lblGbrDolomit;
    private javax.swing.JPanel pnlTeksProdDolomit;
    private javax.swing.JLabel lblBDolomit;
    private javax.swing.JLabel lblHintDolomitK;
    private javax.swing.JLabel lblUraianDolomit;
    private javax.swing.JPanel pnlSoftStep1;
    private javax.swing.JPanel pnlSoftStep2;
    private javax.swing.JPanel pnlSoftStep3;
    private javax.swing.JPanel pnlSoftStep4;
    private javax.swing.JPanel pnlTopBeranda;
    private javax.swing.JScrollPane scrBodyBeranda;
    // End of variables declaration//GEN-END:variables
}
