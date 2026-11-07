package view;

import controller.GuiController;
import view.util.*;

/** Beranda Penyalur. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgBerandaPenyalur extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgBerandaPenyalur() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        try {
            String[] b = GuiController.berandaPenyalur();
            lblBigBp0.setText(b[0] + " kg");
            lblBigBp1.setText(b[1]);
            lblBigBp2.setText(b[2]);
            lblBigBp3.setText(b[3] + " kg");
            lblSubBp.setText("Kecamatan " + GuiController.kecamatanSaya() + " — " + GuiController.namaPengguna() + ".");
        } catch (RuntimeException e) {
            Dialogs.gagal(this, e);
        }
        TableKit.muat(tblNotif, GuiController::notifikasi);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlHeaderBp = new javax.swing.JPanel();
        pnlTitlesBp = new javax.swing.JPanel();
        lblTitleBp = new javax.swing.JLabel();
        lblSubBp = new javax.swing.JLabel();
        pnlTopBp = new javax.swing.JPanel();
        scrBodyBp = new javax.swing.JScrollPane();
        pnlOuterBp = new javax.swing.JPanel();
        pnlStackBp = new javax.swing.JPanel();
        pnlGapBp0 = new javax.swing.JPanel();
        pnlStatsBp = new javax.swing.JPanel();
        pnlCardStatBp0 = new javax.swing.JPanel();
        lblHintBp0T = new javax.swing.JLabel();
        lblBigBp0 = new javax.swing.JLabel();
        lblHintBp0N = new javax.swing.JLabel();
        pnlCardStatBp1 = new javax.swing.JPanel();
        lblHintBp1T = new javax.swing.JLabel();
        lblBigBp1 = new javax.swing.JLabel();
        lblHintBp1N = new javax.swing.JLabel();
        pnlCardStatBp2 = new javax.swing.JPanel();
        lblHintBp2T = new javax.swing.JLabel();
        lblBigBp2 = new javax.swing.JLabel();
        lblHintBp2N = new javax.swing.JLabel();
        pnlCardStatBp3 = new javax.swing.JPanel();
        lblHintBp3T = new javax.swing.JLabel();
        lblBigBp3 = new javax.swing.JLabel();
        lblHintBp3N = new javax.swing.JLabel();
        pnlGapBp1 = new javax.swing.JPanel();
        pnlCardNotif = new javax.swing.JPanel();
        pnlHeadNotif = new javax.swing.JPanel();
        lblHNotif = new javax.swing.JLabel();
        scrNotif = new javax.swing.JScrollPane();
        tblNotif = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        pnlHeaderBp.setName("pnlHeaderBp");
        pnlHeaderBp.setOpaque(false);
        pnlHeaderBp.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        scrBodyBp.setName("scrBodyBp");
        scrBodyBp.setHorizontalScrollBarPolicy(31);
        setLayout(new java.awt.BorderLayout());
        pnlTitlesBp.setName("pnlTitlesBp");
        pnlTitlesBp.setOpaque(false);
        pnlTitlesBp.setAlignmentX(0.0f);
        pnlTopBp.setName("pnlTopBp");
        pnlTopBp.setOpaque(false);
        pnlHeaderBp.setLayout(new java.awt.BorderLayout());
        lblTitleBp.setName("lblTitleBp");
        lblTitleBp.setFont(new java.awt.Font("Georgia", 0, 26));
        lblTitleBp.setForeground(new java.awt.Color(29, 42, 34));
        lblTitleBp.setText("Beranda Penyalur");
        lblSubBp.setName("lblSubBp");
        lblSubBp.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubBp.setForeground(new java.awt.Color(122, 127, 115));
        lblSubBp.setText("Kecamatan Samarinda Ulu — Tani Makmur.");
        pnlTitlesBp.setLayout(new javax.swing.BoxLayout(pnlTitlesBp, javax.swing.BoxLayout.PAGE_AXIS));
        pnlTitlesBp.add(lblTitleBp);
        pnlTitlesBp.add(lblSubBp);
        pnlTopBp.setLayout(new java.awt.FlowLayout(2, 8, 0));
        pnlHeaderBp.add(pnlTitlesBp, java.awt.BorderLayout.WEST);
        pnlHeaderBp.add(pnlTopBp, java.awt.BorderLayout.EAST);
        pnlOuterBp.setName("pnlOuterBp");
        pnlOuterBp.setOpaque(true);
        pnlOuterBp.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterBp.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlStackBp.setName("pnlStackBp");
        pnlStackBp.setOpaque(false);
        pnlStackBp.setAlignmentX(0.0f);
        pnlOuterBp.setLayout(new java.awt.BorderLayout());
        pnlGapBp0.setName("pnlGapBp0");
        pnlGapBp0.setOpaque(false);
        pnlGapBp0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapBp0.setAlignmentX(0.0f);
        pnlGapBp1.setName("pnlGapBp1");
        pnlGapBp1.setOpaque(false);
        pnlGapBp1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapBp1.setAlignmentX(0.0f);
        pnlStackBp.setLayout(new javax.swing.BoxLayout(pnlStackBp, javax.swing.BoxLayout.PAGE_AXIS));
        pnlStatsBp.setName("pnlStatsBp");
        pnlStatsBp.setOpaque(false);
        pnlStatsBp.setAlignmentX(0.0f);
        pnlStatsBp.setMaximumSize(new java.awt.Dimension(4000, 130));
        pnlStatsBp.setPreferredSize(new java.awt.Dimension(900, 120));
        pnlGapBp0.setLayout(new java.awt.BorderLayout());
        pnlCardStatBp0.setName("pnlCardStatBp0");
        pnlCardStatBp0.setOpaque(true);
        pnlCardStatBp0.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatBp0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatBp0.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatBp0.setAlignmentX(0.0f);
        pnlCardStatBp1.setName("pnlCardStatBp1");
        pnlCardStatBp1.setOpaque(true);
        pnlCardStatBp1.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatBp1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatBp1.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatBp1.setAlignmentX(0.0f);
        pnlCardStatBp2.setName("pnlCardStatBp2");
        pnlCardStatBp2.setOpaque(true);
        pnlCardStatBp2.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatBp2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatBp2.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatBp2.setAlignmentX(0.0f);
        pnlCardStatBp3.setName("pnlCardStatBp3");
        pnlCardStatBp3.setOpaque(true);
        pnlCardStatBp3.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatBp3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatBp3.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatBp3.setAlignmentX(0.0f);
        pnlStatsBp.setLayout(new java.awt.GridLayout(0, 4, 14, 0));
        lblHintBp0T.setName("lblHintBp0T");
        lblHintBp0T.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblHintBp0T.setForeground(new java.awt.Color(122, 127, 115));
        lblHintBp0T.setText("Stok kecamatan");
        lblBigBp0.setName("lblBigBp0");
        lblBigBp0.setFont(new java.awt.Font("Georgia", 0, 30));
        lblBigBp0.setForeground(new java.awt.Color(29, 42, 34));
        lblBigBp0.setText("9.850 kg");
        lblHintBp0N.setName("lblHintBp0N");
        lblHintBp0N.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblHintBp0N.setForeground(new java.awt.Color(122, 127, 115));
        lblHintBp0N.setText("semua produk");
        pnlCardStatBp0.setLayout(new javax.swing.BoxLayout(pnlCardStatBp0, javax.swing.BoxLayout.PAGE_AXIS));
        pnlCardStatBp0.add(lblHintBp0T);
        pnlCardStatBp0.add(lblBigBp0);
        pnlCardStatBp0.add(lblHintBp0N);
        lblHintBp1T.setName("lblHintBp1T");
        lblHintBp1T.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblHintBp1T.setForeground(new java.awt.Color(122, 127, 115));
        lblHintBp1T.setText("Pengiriman masuk");
        lblBigBp1.setName("lblBigBp1");
        lblBigBp1.setFont(new java.awt.Font("Georgia", 0, 30));
        lblBigBp1.setForeground(new java.awt.Color(29, 42, 34));
        lblBigBp1.setText("2");
        lblHintBp1N.setName("lblHintBp1N");
        lblHintBp1N.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblHintBp1N.setForeground(new java.awt.Color(122, 127, 115));
        lblHintBp1N.setText("menunggu konfirmasi");
        pnlCardStatBp1.setLayout(new javax.swing.BoxLayout(pnlCardStatBp1, javax.swing.BoxLayout.PAGE_AXIS));
        pnlCardStatBp1.add(lblHintBp1T);
        pnlCardStatBp1.add(lblBigBp1);
        pnlCardStatBp1.add(lblHintBp1N);
        lblHintBp2T.setName("lblHintBp2T");
        lblHintBp2T.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblHintBp2T.setForeground(new java.awt.Color(122, 127, 115));
        lblHintBp2T.setText("Pesanan petani");
        lblBigBp2.setName("lblBigBp2");
        lblBigBp2.setFont(new java.awt.Font("Georgia", 0, 30));
        lblBigBp2.setForeground(new java.awt.Color(29, 42, 34));
        lblBigBp2.setText("3");
        lblHintBp2N.setName("lblHintBp2N");
        lblHintBp2N.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblHintBp2N.setForeground(new java.awt.Color(122, 127, 115));
        lblHintBp2N.setText("menunggu disetujui");
        pnlCardStatBp2.setLayout(new javax.swing.BoxLayout(pnlCardStatBp2, javax.swing.BoxLayout.PAGE_AXIS));
        pnlCardStatBp2.add(lblHintBp2T);
        pnlCardStatBp2.add(lblBigBp2);
        pnlCardStatBp2.add(lblHintBp2N);
        lblHintBp3T.setName("lblHintBp3T");
        lblHintBp3T.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblHintBp3T.setForeground(new java.awt.Color(122, 127, 115));
        lblHintBp3T.setText("Tersalur bulan ini");
        lblBigBp3.setName("lblBigBp3");
        lblBigBp3.setFont(new java.awt.Font("Georgia", 0, 30));
        lblBigBp3.setForeground(new java.awt.Color(29, 42, 34));
        lblBigBp3.setText("1.420 kg");
        lblHintBp3N.setName("lblHintBp3N");
        lblHintBp3N.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblHintBp3N.setForeground(new java.awt.Color(122, 127, 115));
        lblHintBp3N.setText("");
        pnlCardStatBp3.setLayout(new javax.swing.BoxLayout(pnlCardStatBp3, javax.swing.BoxLayout.PAGE_AXIS));
        pnlCardStatBp3.add(lblHintBp3T);
        pnlCardStatBp3.add(lblBigBp3);
        pnlCardStatBp3.add(lblHintBp3N);
        pnlStatsBp.add(pnlCardStatBp0);
        pnlStatsBp.add(pnlCardStatBp1);
        pnlStatsBp.add(pnlCardStatBp2);
        pnlStatsBp.add(pnlCardStatBp3);
        pnlGapBp0.add(pnlStatsBp, java.awt.BorderLayout.CENTER);
        pnlCardNotif.setName("pnlCardNotif");
        pnlCardNotif.setOpaque(true);
        pnlCardNotif.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardNotif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardNotif.setAlignmentX(0.0f);
        pnlGapBp1.setLayout(new java.awt.BorderLayout());
        pnlHeadNotif.setName("pnlHeadNotif");
        pnlHeadNotif.setOpaque(false);
        pnlHeadNotif.setAlignmentX(0.0f);
        pnlHeadNotif.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadNotif.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        scrNotif.setName("scrNotif");
        scrNotif.setPreferredSize(new java.awt.Dimension(600, 220));
        scrNotif.setMaximumSize(new java.awt.Dimension(4000, 220));
        scrNotif.setAlignmentX(0.0f);
        pnlCardNotif.setLayout(new javax.swing.BoxLayout(pnlCardNotif, javax.swing.BoxLayout.PAGE_AXIS));
        lblHNotif.setName("lblHNotif");
        lblHNotif.setFont(new java.awt.Font("Georgia", 0, 17));
        lblHNotif.setForeground(new java.awt.Color(29, 42, 34));
        lblHNotif.setText("Notifikasi terbaru");
        pnlHeadNotif.setLayout(new java.awt.BorderLayout());
        pnlHeadNotif.add(lblHNotif, java.awt.BorderLayout.WEST);
        tblNotif.setName("tblNotif");
        tblNotif.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Waktu", "Judul", "Isi", "Status"}) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        scrNotif.setViewportView(tblNotif);
        pnlCardNotif.add(pnlHeadNotif);
        pnlCardNotif.add(scrNotif);
        pnlGapBp1.add(pnlCardNotif, java.awt.BorderLayout.CENTER);
        pnlStackBp.add(pnlGapBp0);
        pnlStackBp.add(pnlGapBp1);
        pnlOuterBp.add(pnlStackBp, java.awt.BorderLayout.NORTH);
        scrBodyBp.setViewportView(pnlOuterBp);
        add(pnlHeaderBp, java.awt.BorderLayout.NORTH);
        add(scrBodyBp, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlHeaderBp;
    private javax.swing.JPanel pnlTitlesBp;
    private javax.swing.JLabel lblTitleBp;
    private javax.swing.JLabel lblSubBp;
    private javax.swing.JPanel pnlTopBp;
    private javax.swing.JScrollPane scrBodyBp;
    private javax.swing.JPanel pnlOuterBp;
    private javax.swing.JPanel pnlStackBp;
    private javax.swing.JPanel pnlGapBp0;
    private javax.swing.JPanel pnlStatsBp;
    private javax.swing.JPanel pnlCardStatBp0;
    private javax.swing.JLabel lblHintBp0T;
    private javax.swing.JLabel lblBigBp0;
    private javax.swing.JLabel lblHintBp0N;
    private javax.swing.JPanel pnlCardStatBp1;
    private javax.swing.JLabel lblHintBp1T;
    private javax.swing.JLabel lblBigBp1;
    private javax.swing.JLabel lblHintBp1N;
    private javax.swing.JPanel pnlCardStatBp2;
    private javax.swing.JLabel lblHintBp2T;
    private javax.swing.JLabel lblBigBp2;
    private javax.swing.JLabel lblHintBp2N;
    private javax.swing.JPanel pnlCardStatBp3;
    private javax.swing.JLabel lblHintBp3T;
    private javax.swing.JLabel lblBigBp3;
    private javax.swing.JLabel lblHintBp3N;
    private javax.swing.JPanel pnlGapBp1;
    private javax.swing.JPanel pnlCardNotif;
    private javax.swing.JPanel pnlHeadNotif;
    private javax.swing.JLabel lblHNotif;
    private javax.swing.JScrollPane scrNotif;
    private javax.swing.JTable tblNotif;
    // End of variables declaration//GEN-END:variables
}
