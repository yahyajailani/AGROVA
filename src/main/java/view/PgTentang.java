package view;

import view.util.*;

/** Tentang Kami. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgTentang extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgTentang() {
        initComponents();
        Styler.apply(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrBodyTentang = new javax.swing.JScrollPane();
        pnlPageTentang = new javax.swing.JPanel();
        pnlBodyTentang = new javax.swing.JPanel();
        lblTitleTentang = new javax.swing.JLabel();
        lblSubTentang = new javax.swing.JLabel();
        pnlTintSiapa = new javax.swing.JPanel();
        pnlIsiSiapa = new javax.swing.JPanel();
        pnlTeksSiapa = new javax.swing.JPanel();
        lblWarnaJudulBesarSiapa = new javax.swing.JLabel();
        lblWarnaIsiBesarSiapa = new javax.swing.JLabel();
        lblGbrSiapa = new javax.swing.JLabel();
        lblWarnaHeadSdg = new javax.swing.JLabel();
        pnlGridSdg = new javax.swing.JPanel();
        pnlTintSdg12 = new javax.swing.JPanel();
        pnlIsiSdg12 = new javax.swing.JPanel();
        pnlTeksSdg12 = new javax.swing.JPanel();
        lblWarnaJudulSdg12 = new javax.swing.JLabel();
        lblWarnaIsiSdg12 = new javax.swing.JLabel();
        lblGbrSdg12 = new javax.swing.JLabel();
        pnlTintSdg8 = new javax.swing.JPanel();
        pnlIsiSdg8 = new javax.swing.JPanel();
        pnlTeksSdg8 = new javax.swing.JPanel();
        lblWarnaJudulSdg8 = new javax.swing.JLabel();
        lblWarnaIsiSdg8 = new javax.swing.JLabel();
        lblGbrSdg8 = new javax.swing.JLabel();
        lblWarnaHeadCara = new javax.swing.JLabel();
        pnlTintCara = new javax.swing.JPanel();
        pnlIsiCara = new javax.swing.JPanel();
        pnlTeksCara = new javax.swing.JPanel();
        lblWarnaJudulCara = new javax.swing.JLabel();
        lblWarnaIsiCara = new javax.swing.JLabel();
        lblWarnaHeadKuota = new javax.swing.JLabel();
        pnlTintKuota = new javax.swing.JPanel();
        pnlIsiKuota = new javax.swing.JPanel();
        pnlTeksKuota = new javax.swing.JPanel();
        lblWarnaJudulKuota = new javax.swing.JLabel();
        lblWarnaIsiKuota = new javax.swing.JLabel();
        lblHintFootT = new javax.swing.JLabel();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(1180, 700));
        setLayout(new java.awt.BorderLayout());

        scrBodyTentang.setName("scrBodyTentang");
        scrBodyTentang.setHorizontalScrollBarPolicy(31);
        pnlPageTentang.setOpaque(true);
        pnlPageTentang.setBackground(new java.awt.Color(246, 241, 231));
        pnlPageTentang.setLayout(new java.awt.BorderLayout());

        pnlBodyTentang.setOpaque(false);
        pnlBodyTentang.setAlignmentX(0.0F);
        pnlBodyTentang.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 0, 40));
        pnlBodyTentang.setLayout(new javax.swing.BoxLayout(pnlBodyTentang, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitleTentang.setText("Tentang Kami");
        lblTitleTentang.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitleTentang.setForeground(new java.awt.Color(29, 42, 34));
        lblTitleTentang.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 0, 4, 0));
        pnlBodyTentang.add(lblTitleTentang);

        lblSubTentang.setText("Perusahaan Root dan sistem AGROVA: distribusi pupuk yang tercatat, tepat sasaran, dan berkelanjutan.");
        lblSubTentang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubTentang.setForeground(new java.awt.Color(122, 127, 115));
        lblSubTentang.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 14, 0));
        pnlBodyTentang.add(lblSubTentang);

        pnlTintSiapa.setBackground(new java.awt.Color(226, 242, 231));
        pnlTintSiapa.setOpaque(true);
        pnlTintSiapa.setAlignmentX(0.0F);
        pnlTintSiapa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(190, 206, 195)));
        pnlTintSiapa.setLayout(new java.awt.BorderLayout());

        pnlIsiSiapa.setOpaque(false);
        pnlIsiSiapa.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 8, 6, 8));
        pnlIsiSiapa.setLayout(new java.awt.BorderLayout(16, 0));

        pnlTeksSiapa.setOpaque(false);
        pnlTeksSiapa.setLayout(new javax.swing.BoxLayout(pnlTeksSiapa, javax.swing.BoxLayout.PAGE_AXIS));

        lblWarnaJudulBesarSiapa.setText("Siapa kami");
        lblWarnaJudulBesarSiapa.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        lblWarnaJudulBesarSiapa.setForeground(new java.awt.Color(31, 77, 58));
        lblWarnaJudulBesarSiapa.setAlignmentX(0.0F);
        lblWarnaJudulBesarSiapa.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 6, 0));
        pnlTeksSiapa.add(lblWarnaJudulBesarSiapa);

        lblWarnaIsiBesarSiapa.setText("<html><div style=\"width:540px;line-height:1.5\">Perusahaan Root adalah perusahaan distribusi pupuk yang berpusat di Samarinda, Kalimantan Timur. Kami menghubungkan gudang pusat, kios penyalur di tiap kecamatan, dan petani dalam satu alur yang tercatat. AGROVA adalah sistem yang kami kembangkan untuk mencatat penyaluran pupuk subsidi maupun nonsubsidi, mengatur kuota petani berdasarkan golongan, dan memudahkan pemantauan stok di kios.<br><br>Dengan pencatatan yang rapi dan transparan, kami ingin pupuk sampai ke tangan petani yang berhak, dalam jumlah yang tepat, dan pada waktu yang tepat, dari gudang pusat hingga kios di setiap kecamatan.</div>");
        lblWarnaIsiBesarSiapa.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblWarnaIsiBesarSiapa.setForeground(new java.awt.Color(80, 86, 76));
        lblWarnaIsiBesarSiapa.setAlignmentX(0.0F);
        pnlTeksSiapa.add(lblWarnaIsiBesarSiapa);
        pnlIsiSiapa.add(pnlTeksSiapa, java.awt.BorderLayout.CENTER);

        lblGbrSiapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tentang/pabrik.jpg"))); // NOI18N
        lblGbrSiapa.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlIsiSiapa.add(lblGbrSiapa, java.awt.BorderLayout.EAST);
        pnlTintSiapa.add(pnlIsiSiapa, java.awt.BorderLayout.CENTER);
        pnlBodyTentang.add(pnlTintSiapa);

        lblWarnaHeadSdg.setText("Fokus pada tujuan pembangunan berkelanjutan (SDGs)");
        lblWarnaHeadSdg.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblWarnaHeadSdg.setForeground(new java.awt.Color(31, 77, 58));
        lblWarnaHeadSdg.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 0, 10, 0));
        pnlBodyTentang.add(lblWarnaHeadSdg);

        pnlGridSdg.setOpaque(false);
        pnlGridSdg.setAlignmentX(0.0F);
        pnlGridSdg.setMaximumSize(new java.awt.Dimension(4000, 210));
        pnlGridSdg.setLayout(new java.awt.GridLayout(0, 2, 14, 14));

        pnlTintSdg12.setBackground(new java.awt.Color(250, 238, 208));
        pnlTintSdg12.setOpaque(true);
        pnlTintSdg12.setAlignmentX(0.0F);
        pnlTintSdg12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 202, 176)));
        pnlTintSdg12.setLayout(new java.awt.BorderLayout());

        pnlIsiSdg12.setOpaque(false);
        pnlIsiSdg12.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 8, 6, 8));
        pnlIsiSdg12.setLayout(new java.awt.BorderLayout(16, 0));

        pnlTeksSdg12.setOpaque(false);
        pnlTeksSdg12.setLayout(new javax.swing.BoxLayout(pnlTeksSdg12, javax.swing.BoxLayout.PAGE_AXIS));

        lblWarnaJudulSdg12.setText("SDG 12 \u00b7 Konsumsi dan produksi bertanggung jawab");
        lblWarnaJudulSdg12.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblWarnaJudulSdg12.setForeground(new java.awt.Color(139, 98, 16));
        lblWarnaJudulSdg12.setAlignmentX(0.0F);
        lblWarnaJudulSdg12.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 6, 0));
        pnlTeksSdg12.add(lblWarnaJudulSdg12);

        lblWarnaIsiSdg12.setText("<html><div style=\"width:300px;line-height:1.5\">Kuota per golongan petani dan pencatatan stok mencegah penyaluran berlebih dan pupuk terbuang, serta mendorong penggunaan pupuk sesuai takaran.</div>");
        lblWarnaIsiSdg12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblWarnaIsiSdg12.setForeground(new java.awt.Color(80, 86, 76));
        lblWarnaIsiSdg12.setAlignmentX(0.0F);
        pnlTeksSdg12.add(lblWarnaIsiSdg12);
        pnlIsiSdg12.add(pnlTeksSdg12, java.awt.BorderLayout.CENTER);

        lblGbrSdg12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tentang/sdg12.png"))); // NOI18N
        lblGbrSdg12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlIsiSdg12.add(lblGbrSdg12, java.awt.BorderLayout.WEST);
        pnlTintSdg12.add(pnlIsiSdg12, java.awt.BorderLayout.CENTER);
        pnlGridSdg.add(pnlTintSdg12);

        pnlTintSdg8.setBackground(new java.awt.Color(248, 226, 233));
        pnlTintSdg8.setOpaque(true);
        pnlTintSdg8.setAlignmentX(0.0F);
        pnlTintSdg8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(208, 192, 197)));
        pnlTintSdg8.setLayout(new java.awt.BorderLayout());

        pnlIsiSdg8.setOpaque(false);
        pnlIsiSdg8.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 8, 6, 8));
        pnlIsiSdg8.setLayout(new java.awt.BorderLayout(16, 0));

        pnlTeksSdg8.setOpaque(false);
        pnlTeksSdg8.setLayout(new javax.swing.BoxLayout(pnlTeksSdg8, javax.swing.BoxLayout.PAGE_AXIS));

        lblWarnaJudulSdg8.setText("SDG 8 \u00b7 Pekerjaan layak dan pertumbuhan ekonomi");
        lblWarnaJudulSdg8.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblWarnaJudulSdg8.setForeground(new java.awt.Color(145, 25, 66));
        lblWarnaJudulSdg8.setAlignmentX(0.0F);
        lblWarnaJudulSdg8.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 6, 0));
        pnlTeksSdg8.add(lblWarnaJudulSdg8);

        lblWarnaIsiSdg8.setText("<html><div style=\"width:300px;line-height:1.5\">Distribusi yang tercatat dan tepat sasaran membantu petani menjaga hasil panen dan pendapatannya, sekaligus menggerakkan usaha kios penyalur di tiap kecamatan.</div>");
        lblWarnaIsiSdg8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblWarnaIsiSdg8.setForeground(new java.awt.Color(80, 86, 76));
        lblWarnaIsiSdg8.setAlignmentX(0.0F);
        pnlTeksSdg8.add(lblWarnaIsiSdg8);
        pnlIsiSdg8.add(pnlTeksSdg8, java.awt.BorderLayout.CENTER);

        lblGbrSdg8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tentang/sdg8.png"))); // NOI18N
        lblGbrSdg8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlIsiSdg8.add(lblGbrSdg8, java.awt.BorderLayout.WEST);
        pnlTintSdg8.add(pnlIsiSdg8, java.awt.BorderLayout.CENTER);
        pnlGridSdg.add(pnlTintSdg8);
        pnlBodyTentang.add(pnlGridSdg);

        lblWarnaHeadCara.setText("Cara kerja distribusi");
        lblWarnaHeadCara.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblWarnaHeadCara.setForeground(new java.awt.Color(30, 84, 140));
        lblWarnaHeadCara.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 0, 10, 0));
        pnlBodyTentang.add(lblWarnaHeadCara);

        pnlTintCara.setBackground(new java.awt.Color(224, 238, 250));
        pnlTintCara.setOpaque(true);
        pnlTintCara.setAlignmentX(0.0F);
        pnlTintCara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 202, 211)));
        pnlTintCara.setLayout(new java.awt.BorderLayout());

        pnlIsiCara.setOpaque(false);
        pnlIsiCara.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 8, 6, 8));
        pnlIsiCara.setLayout(new java.awt.BorderLayout(16, 0));

        pnlTeksCara.setOpaque(false);
        pnlTeksCara.setLayout(new javax.swing.BoxLayout(pnlTeksCara, javax.swing.BoxLayout.PAGE_AXIS));

        lblWarnaJudulCara.setText("Dari gudang sampai ke petani");
        lblWarnaJudulCara.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblWarnaJudulCara.setForeground(new java.awt.Color(30, 84, 140));
        lblWarnaJudulCara.setAlignmentX(0.0F);
        lblWarnaJudulCara.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 6, 0));
        pnlTeksCara.add(lblWarnaJudulCara);

        lblWarnaIsiCara.setText("<html><div style=\"width:740px;line-height:1.5\">1. Pengelola mencatat penyaluran dari gudang pusat ke kios di kecamatan tujuan.<br>2. Penyalur kios mengonfirmasi penerimaan, lalu stok kios bertambah.<br>3. Petani memesan atau penyalur menyalurkan langsung sesuai hak dan kuota petani.<br>4. Setiap transaksi tercatat dan nota dapat dicetak oleh penyalur.</div>");
        lblWarnaIsiCara.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblWarnaIsiCara.setForeground(new java.awt.Color(80, 86, 76));
        lblWarnaIsiCara.setAlignmentX(0.0F);
        pnlTeksCara.add(lblWarnaIsiCara);
        pnlIsiCara.add(pnlTeksCara, java.awt.BorderLayout.CENTER);
        pnlTintCara.add(pnlIsiCara, java.awt.BorderLayout.CENTER);
        pnlBodyTentang.add(pnlTintCara);

        lblWarnaHeadKuota.setText("Kuota subsidi per golongan");
        lblWarnaHeadKuota.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblWarnaHeadKuota.setForeground(new java.awt.Color(168, 84, 20));
        lblWarnaHeadKuota.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 0, 10, 0));
        pnlBodyTentang.add(lblWarnaHeadKuota);

        pnlTintKuota.setBackground(new java.awt.Color(253, 233, 216));
        pnlTintKuota.setOpaque(true);
        pnlTintKuota.setAlignmentX(0.0F);
        pnlTintKuota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(212, 198, 183)));
        pnlTintKuota.setLayout(new java.awt.BorderLayout());

        pnlIsiKuota.setOpaque(false);
        pnlIsiKuota.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 8, 6, 8));
        pnlIsiKuota.setLayout(new java.awt.BorderLayout(16, 0));

        pnlTeksKuota.setOpaque(false);
        pnlTeksKuota.setLayout(new javax.swing.BoxLayout(pnlTeksKuota, javax.swing.BoxLayout.PAGE_AXIS));

        lblWarnaJudulKuota.setText("Siapa yang berhak dan berapa jatahnya");
        lblWarnaJudulKuota.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblWarnaJudulKuota.setForeground(new java.awt.Color(168, 84, 20));
        lblWarnaJudulKuota.setAlignmentX(0.0F);
        lblWarnaJudulKuota.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 6, 0));
        pnlTeksKuota.add(lblWarnaJudulKuota);

        lblWarnaIsiKuota.setText("<html><div style=\"width:740px;line-height:1.5\">Hak subsidi ditentukan oleh golongan petani. Golongan C mendapat kuota subsidi 300 kg, Golongan B 150 kg, dan Golongan A tidak menerima subsidi sehingga hanya melihat dan membeli pupuk nonsubsidi.</div>");
        lblWarnaIsiKuota.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblWarnaIsiKuota.setForeground(new java.awt.Color(80, 86, 76));
        lblWarnaIsiKuota.setAlignmentX(0.0F);
        pnlTeksKuota.add(lblWarnaIsiKuota);
        pnlIsiKuota.add(pnlTeksKuota, java.awt.BorderLayout.CENTER);
        pnlTintKuota.add(pnlIsiKuota, java.awt.BorderLayout.CENTER);
        pnlBodyTentang.add(pnlTintKuota);

        lblHintFootT.setText("\u00a9 2026 AGROVA \u2014 Perusahaan Root, Samarinda");
        lblHintFootT.setForeground(new java.awt.Color(122, 127, 115));
        lblHintFootT.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 0, 20, 0));
        pnlBodyTentang.add(lblHintFootT);
        pnlPageTentang.add(pnlBodyTentang, java.awt.BorderLayout.NORTH);
        scrBodyTentang.setViewportView(pnlPageTentang);
        add(scrBodyTentang, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrBodyTentang;
    private javax.swing.JPanel pnlPageTentang;
    private javax.swing.JPanel pnlBodyTentang;
    private javax.swing.JLabel lblTitleTentang;
    private javax.swing.JLabel lblSubTentang;
    private javax.swing.JPanel pnlTintSiapa;
    private javax.swing.JPanel pnlIsiSiapa;
    private javax.swing.JPanel pnlTeksSiapa;
    private javax.swing.JLabel lblWarnaJudulBesarSiapa;
    private javax.swing.JLabel lblWarnaIsiBesarSiapa;
    private javax.swing.JLabel lblGbrSiapa;
    private javax.swing.JLabel lblWarnaHeadSdg;
    private javax.swing.JPanel pnlGridSdg;
    private javax.swing.JPanel pnlTintSdg12;
    private javax.swing.JPanel pnlIsiSdg12;
    private javax.swing.JPanel pnlTeksSdg12;
    private javax.swing.JLabel lblWarnaJudulSdg12;
    private javax.swing.JLabel lblWarnaIsiSdg12;
    private javax.swing.JLabel lblGbrSdg12;
    private javax.swing.JPanel pnlTintSdg8;
    private javax.swing.JPanel pnlIsiSdg8;
    private javax.swing.JPanel pnlTeksSdg8;
    private javax.swing.JLabel lblWarnaJudulSdg8;
    private javax.swing.JLabel lblWarnaIsiSdg8;
    private javax.swing.JLabel lblGbrSdg8;
    private javax.swing.JLabel lblWarnaHeadCara;
    private javax.swing.JPanel pnlTintCara;
    private javax.swing.JPanel pnlIsiCara;
    private javax.swing.JPanel pnlTeksCara;
    private javax.swing.JLabel lblWarnaJudulCara;
    private javax.swing.JLabel lblWarnaIsiCara;
    private javax.swing.JLabel lblWarnaHeadKuota;
    private javax.swing.JPanel pnlTintKuota;
    private javax.swing.JPanel pnlIsiKuota;
    private javax.swing.JPanel pnlTeksKuota;
    private javax.swing.JLabel lblWarnaJudulKuota;
    private javax.swing.JLabel lblWarnaIsiKuota;
    private javax.swing.JLabel lblHintFootT;
    // End of variables declaration//GEN-END:variables
}
