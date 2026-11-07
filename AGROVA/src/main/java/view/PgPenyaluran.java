package view;

import controller.GuiController;
import view.util.*;

/** Penyaluran. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgPenyaluran extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgPenyaluran() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        InputFilters.digits(txtJumlah, 7);
        lblHintJumlah.setForeground(Theme.CLAY);
        TableKit.muat(tblPny, GuiController::penyaluran);
        InputFilters.keyword(txtCariPny, 40);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeaderPny = new javax.swing.JPanel();
        pnlTitlesPny = new javax.swing.JPanel();
        lblTitlePny = new javax.swing.JLabel();
        lblSubPny = new javax.swing.JLabel();
        pnlTopPny = new javax.swing.JPanel();
        scrBodyPny = new javax.swing.JScrollPane();
        pnlOuterPny = new javax.swing.JPanel();
        pnlStackPny = new javax.swing.JPanel();
        pnlGapPny0 = new javax.swing.JPanel();
        pnlCardForm = new javax.swing.JPanel();
        pnlHeadForm = new javax.swing.JPanel();
        lblHForm = new javax.swing.JLabel();
        pnlGridPny = new javax.swing.JPanel();
        pnlFProduk = new javax.swing.JPanel();
        lblFieldProduk = new javax.swing.JLabel();
        cmbProduk = new javax.swing.JComboBox();
        lblHintProduk = new javax.swing.JLabel();
        pnlFKec = new javax.swing.JPanel();
        lblFieldKec = new javax.swing.JLabel();
        cmbKec = new javax.swing.JComboBox();
        lblHintKec = new javax.swing.JLabel();
        pnlFJumlah = new javax.swing.JPanel();
        lblFieldJumlah = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        lblHintJumlah = new javax.swing.JLabel();
        pnlActPny = new javax.swing.JPanel();
        btnSimpanPny = new javax.swing.JButton();
        btnGhostResetPny = new javax.swing.JButton();
        pnlGapPny1 = new javax.swing.JPanel();
        pnlCardPny = new javax.swing.JPanel();
        pnlHeadPny = new javax.swing.JPanel();
        lblHPny = new javax.swing.JLabel();
        pnlToolPny = new javax.swing.JPanel();
        txtCariPny = new javax.swing.JTextField();
        btnCariPny = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        scrPny = new javax.swing.JScrollPane();
        tblPny = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());

        pnlHeaderPny.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        pnlHeaderPny.setOpaque(false);
        pnlHeaderPny.setLayout(new java.awt.BorderLayout());

        pnlTitlesPny.setAlignmentX(0.0F);
        pnlTitlesPny.setOpaque(false);
        pnlTitlesPny.setLayout(new javax.swing.BoxLayout(pnlTitlesPny, javax.swing.BoxLayout.PAGE_AXIS));

        lblTitlePny.setText("Penyaluran");
        lblTitlePny.setFont(new java.awt.Font("Georgia", 0, 26)); // NOI18N
        lblTitlePny.setForeground(new java.awt.Color(29, 42, 34));
        pnlTitlesPny.add(lblTitlePny);

        lblSubPny.setText("Kirim pupuk dari gudang ke kecamatan.");
        lblSubPny.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubPny.setForeground(new java.awt.Color(122, 127, 115));
        pnlTitlesPny.add(lblSubPny);

        pnlHeaderPny.add(pnlTitlesPny, java.awt.BorderLayout.WEST);

        pnlTopPny.setOpaque(false);
        pnlTopPny.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pnlHeaderPny.add(pnlTopPny, java.awt.BorderLayout.EAST);

        add(pnlHeaderPny, java.awt.BorderLayout.NORTH);

        scrBodyPny.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlOuterPny.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlOuterPny.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterPny.setLayout(new java.awt.BorderLayout());

        pnlStackPny.setAlignmentX(0.0F);
        pnlStackPny.setOpaque(false);
        pnlStackPny.setLayout(new javax.swing.BoxLayout(pnlStackPny, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGapPny0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapPny0.setAlignmentX(0.0F);
        pnlGapPny0.setOpaque(false);
        pnlGapPny0.setLayout(new java.awt.BorderLayout());

        pnlCardForm.setAlignmentX(0.0F);
        pnlCardForm.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardForm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardForm.setLayout(new javax.swing.BoxLayout(pnlCardForm, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadForm.setAlignmentX(0.0F);
        pnlHeadForm.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadForm.setOpaque(false);
        pnlHeadForm.setLayout(new java.awt.BorderLayout());

        lblHForm.setText("Penyaluran baru");
        lblHForm.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHForm.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadForm.add(lblHForm, java.awt.BorderLayout.WEST);

        pnlCardForm.add(pnlHeadForm);

        pnlGridPny.setAlignmentX(0.0F);
        pnlGridPny.setMaximumSize(new java.awt.Dimension(4000, 200));
        pnlGridPny.setPreferredSize(new java.awt.Dimension(700, 200));
        pnlGridPny.setOpaque(false);
        pnlGridPny.setLayout(new java.awt.GridLayout(0, 2, 16, 0));

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

        pnlGridPny.add(pnlFProduk);

        pnlFKec.setMaximumSize(new java.awt.Dimension(4000, 96));
        pnlFKec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlFKec.setAlignmentX(0.0F);
        pnlFKec.setOpaque(false);
        pnlFKec.setLayout(new javax.swing.BoxLayout(pnlFKec, javax.swing.BoxLayout.PAGE_AXIS));

        lblFieldKec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        lblFieldKec.setText("Kecamatan tujuan");
        lblFieldKec.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFieldKec.setForeground(new java.awt.Color(29, 42, 34));
        pnlFKec.add(lblFieldKec);

        cmbKec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbKec.setForeground(new java.awt.Color(29, 42, 34));
        cmbKec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Kecamatan", "Samarinda Ulu", "Samarinda Utara", "Samarinda Ilir", "Samarinda Kota", "Samarinda Seberang", "Sungai Kunjang", "Palaran", "Loa Janan Ilir", "Sambutan", "Sambutan Baru", "Sempaja Selatan", "Mugirejo", "Air Putih", "Sidodadi", "Teluk Lerong", "Baqa" }));
        cmbKec.setAlignmentX(0.0F);
        cmbKec.setMaximumSize(new java.awt.Dimension(4000, 42));
        cmbKec.setPreferredSize(new java.awt.Dimension(220, 42));
        pnlFKec.add(cmbKec);

        lblHintKec.setText(" ");
        lblHintKec.setForeground(new java.awt.Color(122, 127, 115));
        pnlFKec.add(lblHintKec);

        pnlGridPny.add(pnlFKec);

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

        pnlGridPny.add(pnlFJumlah);

        pnlCardForm.add(pnlGridPny);

        pnlActPny.setAlignmentX(0.0F);
        pnlActPny.setMaximumSize(new java.awt.Dimension(4000, 48));
        pnlActPny.setOpaque(false);
        pnlActPny.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnSimpanPny.setText("Kirim ke penyalur");
        btnSimpanPny.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSimpanPny.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanPny.setBackground(new java.awt.Color(31, 77, 58));
        btnSimpanPny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPnyActionPerformed(evt);
            }
        });
        pnlActPny.add(btnSimpanPny);

        btnGhostResetPny.setText("Kosongkan");
        btnGhostResetPny.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostResetPny.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostResetPny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostResetPnyActionPerformed(evt);
            }
        });
        pnlActPny.add(btnGhostResetPny);

        pnlCardForm.add(pnlActPny);

        pnlGapPny0.add(pnlCardForm, java.awt.BorderLayout.CENTER);

        pnlStackPny.add(pnlGapPny0);

        pnlGapPny1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapPny1.setAlignmentX(0.0F);
        pnlGapPny1.setOpaque(false);
        pnlGapPny1.setLayout(new java.awt.BorderLayout());

        pnlCardPny.setAlignmentX(0.0F);
        pnlCardPny.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardPny.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardPny.setLayout(new javax.swing.BoxLayout(pnlCardPny, javax.swing.BoxLayout.PAGE_AXIS));

        pnlHeadPny.setAlignmentX(0.0F);
        pnlHeadPny.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadPny.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlHeadPny.setOpaque(false);
        pnlHeadPny.setLayout(new java.awt.BorderLayout());

        lblHPny.setText("Daftar penyaluran");
        lblHPny.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lblHPny.setForeground(new java.awt.Color(29, 42, 34));
        pnlHeadPny.add(lblHPny, java.awt.BorderLayout.WEST);

        pnlCardPny.add(pnlHeadPny);

        pnlToolPny.setAlignmentX(0.0F);
        pnlToolPny.setMaximumSize(new java.awt.Dimension(4000, 52));
        pnlToolPny.setOpaque(false);
        pnlToolPny.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCariPny.setPreferredSize(new java.awt.Dimension(260, 40));
        txtCariPny.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCariPny.setForeground(new java.awt.Color(29, 42, 34));
        pnlToolPny.add(txtCariPny);

        btnCariPny.setText("Cari");
        btnCariPny.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCariPny.setForeground(new java.awt.Color(255, 255, 255));
        btnCariPny.setBackground(new java.awt.Color(31, 77, 58));
        btnCariPny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPnyActionPerformed(evt);
            }
        });
        pnlToolPny.add(btnCariPny);

        btnUbah.setText("Ubah");
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setBackground(new java.awt.Color(31, 77, 58));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        pnlToolPny.add(btnUbah);

        btnHapus.setText("Hapus");
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setBackground(new java.awt.Color(31, 77, 58));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        pnlToolPny.add(btnHapus);

        pnlCardPny.add(pnlToolPny);

        scrPny.setPreferredSize(new java.awt.Dimension(600, 300));
        scrPny.setMaximumSize(new java.awt.Dimension(4000, 300));
        scrPny.setAlignmentX(0.0F);

        tblPny.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Penyaluran", "Tanggal", "Kategori", "Produk", "Kecamatan", "Jumlah (kg)", "Tanggal terima", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrPny.setViewportView(tblPny);

        pnlCardPny.add(scrPny);

        pnlGapPny1.add(pnlCardPny, java.awt.BorderLayout.CENTER);

        pnlStackPny.add(pnlGapPny1);

        pnlOuterPny.add(pnlStackPny, java.awt.BorderLayout.NORTH);

        scrBodyPny.setViewportView(pnlOuterPny);

        add(scrBodyPny, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanPnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPnyActionPerformed
        lblHintJumlah.setText(" ");
        if (!txtJumlah.getText().matches("[1-9]\\d{0,6}")) {
            lblHintJumlah.setText("Jumlah harus bilangan bulat lebih dari 0");
            return;
        }
        int kg = Integer.parseInt(txtJumlah.getText());
        String produk = String.valueOf(cmbProduk.getSelectedItem());
        String kec = String.valueOf(cmbKec.getSelectedItem());
        if (!Dialogs.coba(this, () -> GuiController.tambahPenyaluran(produk, kec, kg))) {
            return;
        }
        Dialogs.info(this, "Penyaluran berhasil dicatat dan dikirim ke penyalur kecamatan " + kec + ".");
        txtJumlah.setText("");
        TableKit.muat(tblPny, GuiController::penyaluran);
    }//GEN-LAST:event_btnSimpanPnyActionPerformed

    private void btnGhostResetPnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostResetPnyActionPerformed
        txtJumlah.setText("");
        lblHintJumlah.setText(" ");
    }//GEN-LAST:event_btnGhostResetPnyActionPerformed

    private void btnCariPnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPnyActionPerformed
        TableKit.cari(tblPny, txtCariPny.getText());
    }//GEN-LAST:event_btnCariPnyActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String kode = TableKit.pilih(tblPny, 0);
        if (kode == null) {
            Dialogs.info(this, "Pilih penyaluran yang akan diubah pada tabel.");
            return;
        }
        dlgUbahPenyaluran dlg = new dlgUbahPenyaluran(Dialogs.owner(this), true);
        if (!dlg.setPenyaluran(kode)) {
            return;
        }
        dlg.setVisible(true);
        TableKit.muat(tblPny, GuiController::penyaluran);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        String kode = TableKit.pilih(tblPny, 0);
        if (kode == null) {
            Dialogs.info(this, "Pilih penyaluran yang akan dihapus pada tabel.");
            return;
        }
        if (!Dialogs.confirm(this, "Hapus penyaluran " + kode + "? Data pupuk di dalamnya ikut terhapus.")) {
            return;
        }
        if (Dialogs.coba(this, () -> GuiController.hapusPenyaluran(kode))) {
            TableKit.muat(tblPny, GuiController::penyaluran);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariPny;
    private javax.swing.JButton btnGhostResetPny;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpanPny;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox cmbKec;
    private javax.swing.JComboBox cmbProduk;
    private javax.swing.JLabel lblFieldJumlah;
    private javax.swing.JLabel lblFieldKec;
    private javax.swing.JLabel lblFieldProduk;
    private javax.swing.JLabel lblHForm;
    private javax.swing.JLabel lblHPny;
    private javax.swing.JLabel lblHintJumlah;
    private javax.swing.JLabel lblHintKec;
    private javax.swing.JLabel lblHintProduk;
    private javax.swing.JLabel lblSubPny;
    private javax.swing.JLabel lblTitlePny;
    private javax.swing.JPanel pnlActPny;
    private javax.swing.JPanel pnlCardForm;
    private javax.swing.JPanel pnlCardPny;
    private javax.swing.JPanel pnlFJumlah;
    private javax.swing.JPanel pnlFKec;
    private javax.swing.JPanel pnlFProduk;
    private javax.swing.JPanel pnlGapPny0;
    private javax.swing.JPanel pnlGapPny1;
    private javax.swing.JPanel pnlGridPny;
    private javax.swing.JPanel pnlHeadForm;
    private javax.swing.JPanel pnlHeadPny;
    private javax.swing.JPanel pnlHeaderPny;
    private javax.swing.JPanel pnlOuterPny;
    private javax.swing.JPanel pnlStackPny;
    private javax.swing.JPanel pnlTitlesPny;
    private javax.swing.JPanel pnlToolPny;
    private javax.swing.JPanel pnlTopPny;
    private javax.swing.JScrollPane scrBodyPny;
    private javax.swing.JScrollPane scrPny;
    private javax.swing.JTable tblPny;
    private javax.swing.JTextField txtCariPny;
    private javax.swing.JTextField txtJumlah;
    // End of variables declaration//GEN-END:variables
}
