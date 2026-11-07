package view;

import controller.GuiController;
import view.util.*;

/** Pesan. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgPesan extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgPesan() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        InputFilters.digits(txtJumlah, 5);
        lblHintJumlah.setForeground(Theme.CLAY);
        
        // Menampilkan nama pengguna dan kecamatan pada subtitle bagian atas
        try {
            lblSubBt.setText(GuiController.namaPengguna() + " — " + GuiController.kecamatanSaya() + ".");
        } catch (RuntimeException e) {
            // Abaikan atau tampilkan penanganan jika gagal
        }

        // seleksi penerima subsidi: petani yang tidak berhak hanya melihat pupuk nonsubsidi
        String[] semuaProduk = new String[cmbProduk.getItemCount()];
        for (int i = 0; i < semuaProduk.length; i++) {
            semuaProduk[i] = String.valueOf(cmbProduk.getItemAt(i));
        }
        try {
            TableKit.saringProduk(cmbProduk, semuaProduk, GuiController.berhakSubsidiSaya());
        } catch (RuntimeException e) {
            // tanpa data petani, biarkan daftar lengkap
        }
        TableKit.muat(tblKuotaP, GuiController::kuotaSaya);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeaderPs = new javax.swing.JPanel();
        pnlTitlesPs = new javax.swing.JPanel();
        lblTitlePs = new javax.swing.JLabel();
        lblSubBt = new javax.swing.JLabel();
        lblSubPs = new javax.swing.JLabel();
        pnlTopPs = new javax.swing.JPanel();
        scrBodyPs = new javax.swing.JScrollPane();
        pnlOuterPs = new javax.swing.JPanel();
        pnlStackPs = new javax.swing.JPanel();
        pnlGapPs0 = new javax.swing.JPanel();
        pnlCardFPsn = new javax.swing.JPanel();
        pnlHeadFPsn = new javax.swing.JPanel();
        lblHFPsn = new javax.swing.JLabel();
        pnlGridPsn = new javax.swing.JPanel();
        pnlFProduk = new javax.swing.JPanel();
        lblFieldProduk = new javax.swing.JLabel();
        cmbProduk = new javax.swing.JComboBox();
        lblHintProduk = new javax.swing.JLabel();
        pnlFJumlah = new javax.swing.JPanel();
        lblFieldJumlah = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        lblHintJumlah = new javax.swing.JLabel();
        pnlActPsn = new javax.swing.JPanel();
        btnPesan = new javax.swing.JButton();
        pnlGapPs1 = new javax.swing.JPanel();
        pnlCardKuotaP = new javax.swing.JPanel();
        pnlHeadKuotaP = new javax.swing.JPanel();
        lblHKuotaP = new javax.swing.JLabel();
        scrKuotaP = new javax.swing.JScrollPane();
        tblKuotaP = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderPs.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderPs.setOpaque(false);
        pnlHeaderPs.setLayout(new java.awt.BorderLayout());

        pnlTitlesPs.setAlignmentX(0.0F);
        pnlTitlesPs.setOpaque(false);
        pnlTitlesPs.setLayout(new javax.swing.BoxLayout(pnlTitlesPs, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitlePs.setText("Pesan");
        lblTitlePs.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitlePs.setForeground(new java.awt.Color(29, 42, 34));
        pnlTitlesPs.add(lblTitlePs);

        lblSubBt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubBt.setForeground(new java.awt.Color(122, 127, 115));
        lblSubBt.setText("Budi Santoso — Samarinda Ulu.");
        lblSubBt.setName("lblSubBt"); // NOI18N
        pnlTitlesPs.add(lblSubBt);

        lblSubPs.setText("Pesan pupuk sesuai kuota Anda.");
        lblSubPs.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubPs.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesPs.add(lblSubPs);

        pnlHeaderPs.add(pnlTitlesPs, java.awt.BorderLayout.WEST);

        pnlTopPs.setOpaque(false);
        pnlTopPs.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderPs.add(pnlTopPs, java.awt.BorderLayout.EAST);

        add(pnlHeaderPs, java.awt.BorderLayout.NORTH);

        scrBodyPs.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterPs.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterPs.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterPs.setLayout(new java.awt.BorderLayout());

        pnlStackPs.setAlignmentX(0.0F);
        pnlStackPs.setOpaque(false);
        pnlStackPs.setLayout(new javax.swing.BoxLayout(pnlStackPs, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapPs0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapPs0.setAlignmentX(0.0F);
        pnlGapPs0.setOpaque(false);
        pnlGapPs0.setLayout(new java.awt.BorderLayout());

        pnlCardFPsn.setAlignmentX(0.0F);
        pnlCardFPsn.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardFPsn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardFPsn.setLayout(new javax.swing.BoxLayout(pnlCardFPsn, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadFPsn.setAlignmentX(0.0F);
        pnlHeadFPsn.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadFPsn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadFPsn.setOpaque(false);
        pnlHeadFPsn.setLayout(new java.awt.BorderLayout());

        lblHFPsn.setText("Pesan pupuk");
        lblHFPsn.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHFPsn.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadFPsn.add(lblHFPsn, java.awt.BorderLayout.WEST);

        pnlCardFPsn.add(pnlHeadFPsn);

        pnlGridPsn.setAlignmentX(0.0F);
        pnlGridPsn.setMaximumSize(new java.awt.Dimension(4000, 100));
        pnlGridPsn.setPreferredSize(new java.awt.Dimension(700, 100));
        pnlGridPsn.setOpaque(false);
        pnlGridPsn.setLayout(new java.awt.GridLayout(0, 2, 16, 0));

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

        pnlGridPsn.add(pnlFProduk);

        pnlFJumlah.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFJumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFJumlah.setAlignmentX(0.0F);
        pnlFJumlah.setOpaque(false);
        pnlFJumlah.setLayout(new javax.swing.BoxLayout(pnlFJumlah, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldJumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldJumlah.setText("Jumlah (kg)");
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

        pnlGridPsn.add(pnlFJumlah);

        pnlCardFPsn.add(pnlGridPsn);

        pnlActPsn.setAlignmentX(0.0F);
        pnlActPsn.setMaximumSize(new java.awt.Dimension(4000, 48));
        pnlActPsn.setOpaque(false);
        pnlActPsn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnPesan.setText("Kirim pesanan");
        btnPesan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPesan.setForeground(new java.awt.Color(255, 255, 255));
        btnPesan.setBackground(new java.awt.Color(31, 77, 58));
        btnPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanActionPerformed(evt);
            }
        });
        pnlActPsn.add(btnPesan);

        pnlCardFPsn.add(pnlActPsn);

        pnlGapPs0.add(pnlCardFPsn, java.awt.BorderLayout.CENTER);

        pnlStackPs.add(pnlGapPs0);

        pnlGapPs1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapPs1.setAlignmentX(0.0F);
        pnlGapPs1.setOpaque(false);
        pnlGapPs1.setLayout(new java.awt.BorderLayout());

        pnlCardKuotaP.setAlignmentX(0.0F);
        pnlCardKuotaP.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardKuotaP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardKuotaP.setLayout(new javax.swing.BoxLayout(pnlCardKuotaP, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadKuotaP.setAlignmentX(0.0F);
        pnlHeadKuotaP.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadKuotaP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadKuotaP.setOpaque(false);
        pnlHeadKuotaP.setLayout(new java.awt.BorderLayout());

        lblHKuotaP.setText("Sisa kuota");
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

        pnlGapPs1.add(pnlCardKuotaP, java.awt.BorderLayout.CENTER);

        pnlStackPs.add(pnlGapPs1);

        pnlOuterPs.add(pnlStackPs, java.awt.BorderLayout.NORTH);

        scrBodyPs.setViewportView(pnlOuterPs);

        add(scrBodyPs, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed
        lblHintJumlah.setText(" ");
        if (!txtJumlah.getText().matches("[1-9]\\d{0,4}")) {
            lblHintJumlah.setText("Jumlah harus bilangan bulat lebih dari 0");
            return;
        }
        String produk = String.valueOf(cmbProduk.getSelectedItem());
        int kg = Integer.parseInt(txtJumlah.getText());
        if (!Dialogs.coba(this, () -> GuiController.pesan(produk, kg))) {
            return;
        }
        Dialogs.info(this, "Pesanan diajukan dengan status Diproses. Penyalur akan menerima atau menolaknya; pantau di menu Status Pesanan.");
        txtJumlah.setText("");
        TableKit.muat(tblKuotaP, GuiController::kuotaSaya);
    }//GEN-LAST:event_btnPesanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesan;
    private javax.swing.JComboBox cmbProduk;
    private javax.swing.JLabel lblFieldJumlah;
    private javax.swing.JLabel lblFieldProduk;
    private javax.swing.JLabel lblHFPsn;
    private javax.swing.JLabel lblHKuotaP;
    private javax.swing.JLabel lblHintJumlah;
    private javax.swing.JLabel lblHintProduk;
    private javax.swing.JLabel lblSubBt;
    private javax.swing.JLabel lblSubPs;
    private javax.swing.JLabel lblTitlePs;
    private javax.swing.JPanel pnlActPsn;
    private javax.swing.JPanel pnlCardFPsn;
    private javax.swing.JPanel pnlCardKuotaP;
    private javax.swing.JPanel pnlFJumlah;
    private javax.swing.JPanel pnlFProduk;
    private javax.swing.JPanel pnlGapPs0;
    private javax.swing.JPanel pnlGapPs1;
    private javax.swing.JPanel pnlGridPsn;
    private javax.swing.JPanel pnlHeadFPsn;
    private javax.swing.JPanel pnlHeadKuotaP;
    private javax.swing.JPanel pnlHeaderPs;
    private javax.swing.JPanel pnlOuterPs;
    private javax.swing.JPanel pnlStackPs;
    private javax.swing.JPanel pnlTitlesPs;
    private javax.swing.JPanel pnlTopPs;
    private javax.swing.JScrollPane scrBodyPs;
    private javax.swing.JScrollPane scrKuotaP;
    private javax.swing.JTable tblKuotaP;
    private javax.swing.JTextField txtJumlah;
    // End of variables declaration//GEN-END:variables
}
