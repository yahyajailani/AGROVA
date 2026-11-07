package view;

import controller.GuiController;
import view.util.*;

/** Salurkan. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgSalurkan extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgSalurkan() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        InputFilters.digits(txtNik, 16);
        InputFilters.digits(txtJumlah, 6);
        lblHintNik.setForeground(Theme.CLAY);
        lblHintJumlah.setForeground(Theme.CLAY);
        TableKit.fill(tblKuotaPetani, new Object[0][]);
        semuaProduk = new String[cmbProduk.getItemCount()];
        for (int i = 0; i < semuaProduk.length; i++) {
            semuaProduk[i] = String.valueOf(cmbProduk.getItemAt(i));
        }
        // NIK diubah: kembalikan daftar lengkap; setelah 16 digit, tampilkan nama petani dan sesuaikan pilihan pupuk
        txtNik.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { nikBerubah(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { nikBerubah(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { }
        });
    }

    private void nikBerubah() {
        TableKit.saringProduk(cmbProduk, semuaProduk, true);
        lblHintNik.setForeground(Theme.CLAY);
        lblHintNik.setText(" ");
        String nik = txtNik.getText();
        if (nik.length() != 16) {
            return;
        }
        try {
            String nama = GuiController.namaPetaniNik(nik);
            lblHintNik.setForeground(Theme.FOREST);
            lblHintNik.setText("Nama petani: " + nama);
            TableKit.saringProduk(cmbProduk, semuaProduk, GuiController.berhakSubsidiNik(nik));
        } catch (RuntimeException e) {
            lblHintNik.setText("NIK tidak terdaftar di kios Anda");
        }
    }

    private String[] semuaProduk;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeaderSl = new javax.swing.JPanel();
        pnlTitlesSl = new javax.swing.JPanel();
        lblTitleSl = new javax.swing.JLabel();
        lblSubSl = new javax.swing.JLabel();
        pnlTopSl = new javax.swing.JPanel();
        scrBodySl = new javax.swing.JScrollPane();
        pnlOuterSl = new javax.swing.JPanel();
        pnlStackSl = new javax.swing.JPanel();
        pnlGapSl0 = new javax.swing.JPanel();
        pnlCardFSal = new javax.swing.JPanel();
        pnlHeadFSal = new javax.swing.JPanel();
        lblHFSal = new javax.swing.JLabel();
        pnlGridSal = new javax.swing.JPanel();
        pnlFNik = new javax.swing.JPanel();
        lblFieldNik = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        lblHintNik = new javax.swing.JLabel();
        pnlFProduk = new javax.swing.JPanel();
        lblFieldProduk = new javax.swing.JLabel();
        cmbProduk = new javax.swing.JComboBox();
        lblHintProduk = new javax.swing.JLabel();
        pnlFJumlah = new javax.swing.JPanel();
        lblFieldJumlah = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        lblHintJumlah = new javax.swing.JLabel();
        pnlActSal = new javax.swing.JPanel();
        btnSalurkan = new javax.swing.JButton();
        btnGhostCek = new javax.swing.JButton();
        pnlGapSl1 = new javax.swing.JPanel();
        pnlCardKuotaPetani = new javax.swing.JPanel();
        pnlHeadKuotaPetani = new javax.swing.JPanel();
        lblHKuotaPetani = new javax.swing.JLabel();
        scrKuotaPetani = new javax.swing.JScrollPane();
        tblKuotaPetani = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderSl.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderSl.setOpaque(false);
        pnlHeaderSl.setLayout(new java.awt.BorderLayout());

        pnlTitlesSl.setAlignmentX(0.0F);
        pnlTitlesSl.setOpaque(false);
        pnlTitlesSl.setLayout(new javax.swing.BoxLayout(pnlTitlesSl, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitleSl.setText("Salurkan");
        lblTitleSl.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitleSl.setForeground(new java.awt.Color(29, 42, 34));
        pnlTitlesSl.add(lblTitleSl);

        lblSubSl.setText("Serahkan pupuk kepada petani sesuai kuota.");
        lblSubSl.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubSl.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesSl.add(lblSubSl);

        pnlHeaderSl.add(pnlTitlesSl, java.awt.BorderLayout.WEST);

        pnlTopSl.setOpaque(false);
        pnlTopSl.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderSl.add(pnlTopSl, java.awt.BorderLayout.EAST);

        add(pnlHeaderSl, java.awt.BorderLayout.NORTH);

        scrBodySl.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterSl.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterSl.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterSl.setLayout(new java.awt.BorderLayout());

        pnlStackSl.setAlignmentX(0.0F);
        pnlStackSl.setOpaque(false);
        pnlStackSl.setLayout(new javax.swing.BoxLayout(pnlStackSl, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapSl0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapSl0.setAlignmentX(0.0F);
        pnlGapSl0.setOpaque(false);
        pnlGapSl0.setLayout(new java.awt.BorderLayout());

        pnlCardFSal.setAlignmentX(0.0F);
        pnlCardFSal.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardFSal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardFSal.setLayout(new javax.swing.BoxLayout(pnlCardFSal, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadFSal.setAlignmentX(0.0F);
        pnlHeadFSal.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadFSal.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadFSal.setOpaque(false);
        pnlHeadFSal.setLayout(new java.awt.BorderLayout());

        lblHFSal.setText("Salurkan ke petani");
        lblHFSal.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHFSal.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadFSal.add(lblHFSal, java.awt.BorderLayout.WEST);

        pnlCardFSal.add(pnlHeadFSal);

        pnlGridSal.setAlignmentX(0.0F);
        pnlGridSal.setMaximumSize(new java.awt.Dimension(4000, 200));
        pnlGridSal.setPreferredSize(new java.awt.Dimension(700, 200));
        pnlGridSal.setOpaque(false);
        pnlGridSal.setLayout(new java.awt.GridLayout(0, 2, 16, 0));

        pnlFNik.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFNik.setAlignmentX(0.0F);
        pnlFNik.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFNik.setOpaque(false);
        pnlFNik.setLayout(new javax.swing.BoxLayout(pnlFNik, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldNik.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldNik.setText("NIK petani (16 digit)");
        lblFieldNik.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldNik.setForeground(new java.awt.Color(29, 42, 34));
        pnlFNik.add(lblFieldNik);

        txtNik.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNik.setForeground(new java.awt.Color(29, 42, 34));
        txtNik.setAlignmentX(0.0F);
        txtNik.setMaximumSize(new java.awt.Dimension(4000, 42));
        txtNik.setPreferredSize(new java.awt.Dimension(220, 42));
        txtNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNikActionPerformed(evt);
            }
        });
        pnlFNik.add(txtNik);

        lblHintNik.setText(" ");
        lblHintNik.setForeground(new java.awt.Color(122, 127, 115));
        pnlFNik.add(lblHintNik);

        pnlGridSal.add(pnlFNik);

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
        cmbProduk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih pupuk", "Urea Subsidi", "NPK Subsidi", "NPK untuk kakao Subsidi", "NPK Phonska Subsidi", "ZA Subsidi", "Dolomit Subsidi", "Urea nonsubsidi", "NPK nonsubsidi", "SP-36 nonsubsidi", "ZA nonsubsidi", "KCl nonsubsidi", "TSP nonsubsidi", "DAP nonsubsidi" }));
        cmbProduk.setAlignmentX(0.0F);
        cmbProduk.setMaximumSize(new java.awt.Dimension(4000, 42));
        cmbProduk.setPreferredSize(new java.awt.Dimension(220, 42));
        cmbProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdukActionPerformed(evt);
            }
        });
        pnlFProduk.add(cmbProduk);

        lblHintProduk.setText(" ");
        lblHintProduk.setForeground(new java.awt.Color(122, 127, 115));
        pnlFProduk.add(lblHintProduk);

        pnlGridSal.add(pnlFProduk);

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

        pnlGridSal.add(pnlFJumlah);

        pnlCardFSal.add(pnlGridSal);

        pnlActSal.setAlignmentX(0.0F);
        pnlActSal.setMaximumSize(new java.awt.Dimension(4000, 48));
        pnlActSal.setOpaque(false);
        pnlActSal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnSalurkan.setText("Salurkan");
        btnSalurkan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSalurkan.setForeground(new java.awt.Color(255, 255, 255));
        btnSalurkan.setBackground(new java.awt.Color(31, 77, 58));
        btnSalurkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalurkanActionPerformed(evt);
            }
        });
        pnlActSal.add(btnSalurkan);

        btnGhostCek.setText("Cek kuota");
        btnGhostCek.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostCek.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostCekActionPerformed(evt);
            }
        });
        pnlActSal.add(btnGhostCek);

        pnlCardFSal.add(pnlActSal);

        pnlGapSl0.add(pnlCardFSal, java.awt.BorderLayout.CENTER);

        pnlStackSl.add(pnlGapSl0);

        pnlGapSl1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapSl1.setAlignmentX(0.0F);
        pnlGapSl1.setOpaque(false);
        pnlGapSl1.setLayout(new java.awt.BorderLayout());

        pnlCardKuotaPetani.setAlignmentX(0.0F);
        pnlCardKuotaPetani.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardKuotaPetani.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardKuotaPetani.setLayout(new javax.swing.BoxLayout(pnlCardKuotaPetani, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadKuotaPetani.setAlignmentX(0.0F);
        pnlHeadKuotaPetani.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadKuotaPetani.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadKuotaPetani.setOpaque(false);
        pnlHeadKuotaPetani.setLayout(new java.awt.BorderLayout());

        lblHKuotaPetani.setText("Kuota petani");
        lblHKuotaPetani.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHKuotaPetani.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadKuotaPetani.add(lblHKuotaPetani, java.awt.BorderLayout.WEST);

        pnlCardKuotaPetani.add(pnlHeadKuotaPetani);

        scrKuotaPetani.setPreferredSize(new java.awt.Dimension(600, 170));
        scrKuotaPetani.setMaximumSize(new java.awt.Dimension(4000, 170));
        scrKuotaPetani.setAlignmentX(0.0F);

        tblKuotaPetani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produk", "Kuota (kg)", "Terpakai (kg)", "Sisa (kg)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrKuotaPetani.setViewportView(tblKuotaPetani);

        pnlCardKuotaPetani.add(scrKuotaPetani);

        pnlGapSl1.add(pnlCardKuotaPetani, java.awt.BorderLayout.CENTER);

        pnlStackSl.add(pnlGapSl1);

        pnlOuterSl.add(pnlStackSl, java.awt.BorderLayout.NORTH);

        scrBodySl.setViewportView(pnlOuterSl);

        add(scrBodySl, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalurkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalurkanActionPerformed
        lblHintNik.setText(" ");
        lblHintJumlah.setText(" ");
        boolean ok = true;
        if (!txtNik.getText().matches("\\d{16}")) {
            lblHintNik.setText("NIK harus 16 digit angka");
            ok = false;
        }
        if (!txtJumlah.getText().matches("[1-9]\\d{0,5}")) {
            lblHintJumlah.setText("Jumlah harus bilangan bulat lebih dari 0");
            ok = false;
        }
        if (!ok) {
            return;
        }
        String nik = txtNik.getText();
        String produk = String.valueOf(cmbProduk.getSelectedItem());
        int kg = Integer.parseInt(txtJumlah.getText());
        if (!Dialogs.coba(this, () -> GuiController.salurkan(nik, produk, kg))) {
            return;
        }
        Dialogs.info(this, "Penyaluran dicatat. Stok kios dan kuota petani diperbarui.");
        txtJumlah.setText("");
        TableKit.muat(tblKuotaPetani, () -> GuiController.kuotaPetani(nik));
    }//GEN-LAST:event_btnSalurkanActionPerformed

    private void btnGhostCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostCekActionPerformed
        lblHintNik.setText(" ");
        if (!txtNik.getText().matches("\\d{16}")) {
            lblHintNik.setText("NIK harus 16 digit angka");
            return;
        }
        String nik = txtNik.getText();
        try {
            TableKit.fill(tblKuotaPetani, GuiController.kuotaPetani(nik));
            // seleksi penerima subsidi: petani Golongan A hanya boleh pupuk nonsubsidi
            TableKit.saringProduk(cmbProduk, semuaProduk, GuiController.berhakSubsidiNik(nik));
        } catch (RuntimeException e) {
            TableKit.fill(tblKuotaPetani, new Object[0][]);
            Dialogs.gagal(this, e);
        }
    }//GEN-LAST:event_btnGhostCekActionPerformed

    private void cmbProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProdukActionPerformed

    private void txtNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNikActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhostCek;
    private javax.swing.JButton btnSalurkan;
    private javax.swing.JComboBox cmbProduk;
    private javax.swing.JLabel lblFieldJumlah;
    private javax.swing.JLabel lblFieldNik;
    private javax.swing.JLabel lblFieldProduk;
    private javax.swing.JLabel lblHFSal;
    private javax.swing.JLabel lblHKuotaPetani;
    private javax.swing.JLabel lblHintJumlah;
    private javax.swing.JLabel lblHintNik;
    private javax.swing.JLabel lblHintProduk;
    private javax.swing.JLabel lblSubSl;
    private javax.swing.JLabel lblTitleSl;
    private javax.swing.JPanel pnlActSal;
    private javax.swing.JPanel pnlCardFSal;
    private javax.swing.JPanel pnlCardKuotaPetani;
    private javax.swing.JPanel pnlFJumlah;
    private javax.swing.JPanel pnlFNik;
    private javax.swing.JPanel pnlFProduk;
    private javax.swing.JPanel pnlGapSl0;
    private javax.swing.JPanel pnlGapSl1;
    private javax.swing.JPanel pnlGridSal;
    private javax.swing.JPanel pnlHeadFSal;
    private javax.swing.JPanel pnlHeadKuotaPetani;
    private javax.swing.JPanel pnlHeaderSl;
    private javax.swing.JPanel pnlOuterSl;
    private javax.swing.JPanel pnlStackSl;
    private javax.swing.JPanel pnlTitlesSl;
    private javax.swing.JPanel pnlTopSl;
    private javax.swing.JScrollPane scrBodySl;
    private javax.swing.JScrollPane scrKuotaPetani;
    private javax.swing.JTable tblKuotaPetani;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtNik;
    // End of variables declaration//GEN-END:variables
}
