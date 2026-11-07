package view;

import controller.GuiController;
import view.util.*;

/** Beranda Petani. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgBerandaPetani extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgBerandaPetani() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        TableKit.muat(tblKuotaP, GuiController::kuotaSaya);
        try {
            String[] b = GuiController.berandaPetani();
            lblBigBt0.setText(b[0] + " kg");
            lblHintBt0N.setText("pupuk subsidi");
            lblBigBt2.setText(b[2] + " kg");
            lblBigBt3.setText(b[3]);
            lblSubBt.setText(GuiController.namaPengguna() + " — " + GuiController.kecamatanSaya() + ".");
        } catch (RuntimeException e) {
            Dialogs.gagal(this, e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeaderBt = new javax.swing.JPanel();
        pnlTitlesBt = new javax.swing.JPanel();
        lblTitleBt = new javax.swing.JLabel();
        lblSubBt = new javax.swing.JLabel();
        pnlTopBt = new javax.swing.JPanel();
        scrBodyBt = new javax.swing.JScrollPane();
        pnlOuterBt = new javax.swing.JPanel();
        pnlStackBt = new javax.swing.JPanel();
        pnlGapBt0 = new javax.swing.JPanel();
        pnlStatsBt = new javax.swing.JPanel();
        pnlCardStatBt0 = new javax.swing.JPanel();
        lblHintBt0T = new javax.swing.JLabel();
        lblBigBt0 = new javax.swing.JLabel();
        lblHintBt0N = new javax.swing.JLabel();
        pnlCardStatBt2 = new javax.swing.JPanel();
        lblHintBt2T = new javax.swing.JLabel();
        lblBigBt2 = new javax.swing.JLabel();
        lblHintBt2N = new javax.swing.JLabel();
        pnlCardStatBt3 = new javax.swing.JPanel();
        lblHintBt3T = new javax.swing.JLabel();
        lblBigBt3 = new javax.swing.JLabel();
        lblHintBt3N = new javax.swing.JLabel();
        pnlGapBt1 = new javax.swing.JPanel();
        pnlCardKuotaP = new javax.swing.JPanel();
        pnlHeadKuotaP = new javax.swing.JPanel();
        lblHKuotaP = new javax.swing.JLabel();
        scrKuotaP = new javax.swing.JScrollPane();
        tblKuotaP = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderBt.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderBt.setOpaque(false);
        pnlHeaderBt.setLayout(new java.awt.BorderLayout());

        pnlTitlesBt.setAlignmentX(0.0F);
        pnlTitlesBt.setOpaque(false);
        pnlTitlesBt.setLayout(new javax.swing.BoxLayout(pnlTitlesBt, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitleBt.setText("Beranda Petani");
        lblTitleBt.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitleBt.setForeground(new java.awt.Color(29, 42, 34));
        pnlTitlesBt.add(lblTitleBt);

        lblSubBt.setText("Budi Santoso — Samarinda Ulu.");
        lblSubBt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubBt.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesBt.add(lblSubBt);

        pnlHeaderBt.add(pnlTitlesBt, java.awt.BorderLayout.WEST);

        pnlTopBt.setOpaque(false);
        pnlTopBt.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderBt.add(pnlTopBt, java.awt.BorderLayout.EAST);

        add(pnlHeaderBt, java.awt.BorderLayout.NORTH);

        scrBodyBt.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterBt.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterBt.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterBt.setLayout(new java.awt.BorderLayout());

        pnlStackBt.setAlignmentX(0.0F);
        pnlStackBt.setOpaque(false);
        pnlStackBt.setLayout(new javax.swing.BoxLayout(pnlStackBt, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapBt0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapBt0.setAlignmentX(0.0F);
        pnlGapBt0.setOpaque(false);
        pnlGapBt0.setLayout(new java.awt.BorderLayout());

        pnlStatsBt.setAlignmentX(0.0F);
        pnlStatsBt.setMaximumSize(new java.awt.Dimension(4000, 130));
        pnlStatsBt.setOpaque(false);
        pnlStatsBt.setPreferredSize(new java.awt.Dimension(900, 120));
        pnlStatsBt.setLayout(new java.awt.GridLayout(0, 4, 14, 0));

        pnlCardStatBt0.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatBt0.setAlignmentX(0.0F);
        pnlCardStatBt0.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatBt0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatBt0.setLayout(new javax.swing.BoxLayout(pnlCardStatBt0, javax.swing.BoxLayout.PAGE_AXIS));

        lblHintBt0T.setText("Kuota musim ini");
        lblHintBt0T.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatBt0.add(lblHintBt0T);

        lblBigBt0.setText("1.275 kg");
        lblBigBt0.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        lblBigBt0.setForeground(new java.awt.Color(29, 42, 34));
        pnlCardStatBt0.add(lblBigBt0);

        lblHintBt0N.setText("3 produk");
        lblHintBt0N.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatBt0.add(lblHintBt0N);

        pnlStatsBt.add(pnlCardStatBt0);

        pnlCardStatBt2.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatBt2.setAlignmentX(0.0F);
        pnlCardStatBt2.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatBt2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatBt2.setLayout(new javax.swing.BoxLayout(pnlCardStatBt2, javax.swing.BoxLayout.PAGE_AXIS));

        lblHintBt2T.setText("Sisa kuota");
        lblHintBt2T.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatBt2.add(lblHintBt2T);

        lblBigBt2.setText("925 kg");
        lblBigBt2.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        lblBigBt2.setForeground(new java.awt.Color(29, 42, 34));
        pnlCardStatBt2.add(lblBigBt2);

        lblHintBt2N.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatBt2.add(lblHintBt2N);

        pnlStatsBt.add(pnlCardStatBt2);

        pnlCardStatBt3.setPreferredSize(new java.awt.Dimension(200, 120));
        pnlCardStatBt3.setAlignmentX(0.0F);
        pnlCardStatBt3.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardStatBt3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardStatBt3.setLayout(new javax.swing.BoxLayout(pnlCardStatBt3, javax.swing.BoxLayout.PAGE_AXIS));

        lblHintBt3T.setText("Pesanan aktif");
        lblHintBt3T.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatBt3.add(lblHintBt3T);

        lblBigBt3.setText("1");
        lblBigBt3.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        lblBigBt3.setForeground(new java.awt.Color(29, 42, 34));
        pnlCardStatBt3.add(lblBigBt3);

        lblHintBt3N.setText("menunggu");
        lblHintBt3N.setForeground(new java.awt.Color(122, 127, 115));
        pnlCardStatBt3.add(lblHintBt3N);

        pnlStatsBt.add(pnlCardStatBt3);

        pnlGapBt0.add(pnlStatsBt, java.awt.BorderLayout.CENTER);

        pnlStackBt.add(pnlGapBt0);

        pnlGapBt1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapBt1.setAlignmentX(0.0F);
        pnlGapBt1.setOpaque(false);
        pnlGapBt1.setLayout(new java.awt.BorderLayout());

        pnlCardKuotaP.setAlignmentX(0.0F);
        pnlCardKuotaP.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardKuotaP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardKuotaP.setLayout(new javax.swing.BoxLayout(pnlCardKuotaP, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadKuotaP.setAlignmentX(0.0F);
        pnlHeadKuotaP.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadKuotaP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadKuotaP.setOpaque(false);
        pnlHeadKuotaP.setLayout(new java.awt.BorderLayout());

        lblHKuotaP.setText("Kuota saya");
        lblHKuotaP.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHKuotaP.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadKuotaP.add(lblHKuotaP, java.awt.BorderLayout.WEST);

        pnlCardKuotaP.add(pnlHeadKuotaP);

        scrKuotaP.setPreferredSize(new java.awt.Dimension(600, 170));
        scrKuotaP.setMaximumSize(new java.awt.Dimension(4000, 170));
        scrKuotaP.setAlignmentX(0.0F);

        tblKuotaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produk", "Kuota (kg)", "Sisa (kg)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrKuotaP.setViewportView(tblKuotaP);

        pnlCardKuotaP.add(scrKuotaP);

        pnlGapBt1.add(pnlCardKuotaP, java.awt.BorderLayout.CENTER);

        pnlStackBt.add(pnlGapBt1);

        pnlOuterBt.add(pnlStackBt, java.awt.BorderLayout.NORTH);

        scrBodyBt.setViewportView(pnlOuterBt);

        add(scrBodyBt, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBigBt0;
    private javax.swing.JLabel lblBigBt2;
    private javax.swing.JLabel lblBigBt3;
    private javax.swing.JLabel lblHKuotaP;
    private javax.swing.JLabel lblHintBt0N;
    private javax.swing.JLabel lblHintBt0T;
    private javax.swing.JLabel lblHintBt2N;
    private javax.swing.JLabel lblHintBt2T;
    private javax.swing.JLabel lblHintBt3N;
    private javax.swing.JLabel lblHintBt3T;
    private javax.swing.JLabel lblSubBt;
    private javax.swing.JLabel lblTitleBt;
    private javax.swing.JPanel pnlCardKuotaP;
    private javax.swing.JPanel pnlCardStatBt0;
    private javax.swing.JPanel pnlCardStatBt2;
    private javax.swing.JPanel pnlCardStatBt3;
    private javax.swing.JPanel pnlGapBt0;
    private javax.swing.JPanel pnlGapBt1;
    private javax.swing.JPanel pnlHeadKuotaP;
    private javax.swing.JPanel pnlHeaderBt;
    private javax.swing.JPanel pnlOuterBt;
    private javax.swing.JPanel pnlStackBt;
    private javax.swing.JPanel pnlStatsBt;
    private javax.swing.JPanel pnlTitlesBt;
    private javax.swing.JPanel pnlTopBt;
    private javax.swing.JScrollPane scrBodyBt;
    private javax.swing.JScrollPane scrKuotaP;
    private javax.swing.JTable tblKuotaP;
    // End of variables declaration//GEN-END:variables
}
