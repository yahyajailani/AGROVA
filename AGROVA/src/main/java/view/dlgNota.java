package view;

import controller.GuiController;
import view.util.*;

/** Nota penyaluran. Dibuka dari tabel Laporan dengan mengklik satu baris. Tampilan dikelola NetBeans GUI Builder (tab Design). */
public class dlgNota extends javax.swing.JDialog {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public dlgNota(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Styler.applyDialog(this);
        lblHNota.setFont(Theme.serif(20f, java.awt.Font.PLAIN));
        setLocationRelativeTo(parent);
    }

    private Object[] barisNota;

    private void simpanPdf() {
        if (barisNota == null) {
            return;
        }
        java.util.List<String> isi = new java.util.ArrayList<>();
        javax.swing.JLabel[] k = {lblKeyNota1, lblKeyNota2, lblKeyNota3, lblKeyNota4, lblKeyNota5, lblKeyNota6, lblKeyNota7, lblKeyNota8, lblKeyNota9};
        javax.swing.JLabel[] v = {lblValNota1, lblValNota2, lblValNota3, lblValNota4, lblValNota5, lblValNota6, lblValNota7, lblValNota8, lblValNota9};
        for (int i = 0; i < k.length; i++) {
            isi.add(String.format("%-16s: %s", k[i].getText(), v[i].getText()));
        }
        isi.add("");
        isi.add(String.format("%-16s: %s", "TOTAL", lblValNotaTotal.getText()));
        try {
            java.nio.file.Path f = PdfReport.write(java.nio.file.Path.of("nota"),
                    "nota_" + lblValNota1.getText(), "NOTA PENYALURAN PUPUK", isi);
            Dialogs.info(this, "Nota disimpan di:\n" + f.toAbsolutePath());
        } catch (java.io.IOException e) {
            Dialogs.error(this, "Gagal menyimpan PDF: " + e.getMessage());
        }
    }

    /** @param baris No, Tanggal kirim, Kategori, Produk, Kecamatan, Jumlah (kg), Tanggal terima, Status (urutan kolom tabel Laporan) */
    public void setNota(Object[] baris) {
        barisNota = baris;
        String no = String.valueOf(baris[0]), kirim = String.valueOf(baris[1]), kategori = String.valueOf(baris[2]),
                produk = String.valueOf(baris[3]), kec = String.valueOf(baris[4]), jumlah = String.valueOf(baris[5]),
                terima = String.valueOf(baris[6]), status = String.valueOf(baris[7]);
        long kg = 0;
        try {
            kg = Long.parseLong(jumlah.replace(".", "").trim());
        } catch (NumberFormatException e) {
            // tetap 0
        }
        long harga = GuiController.hargaPerKg(produk);
        lblValNota1.setText(no);
        lblValNota2.setText(kirim);
        lblValNota3.setText(terima);
        lblValNota4.setText(kategori);
        lblValNota5.setText(produk);
        lblValNota6.setText(kec);
        lblValNota7.setText(jumlah + " kg");
        lblValNota8.setText("Rp " + String.format(java.util.Locale.GERMANY, "%,d", harga));
        lblValNota9.setText(status);
        lblValNotaTotal.setText("Rp " + String.format(java.util.Locale.GERMANY, "%,d", harga * kg));
    }

    /** Nota transaksi penyalur. @param baris No. Transaksi, Tanggal, Kategori, Produk, NIK, Petani, Jumlah (kg), Jenis, Status */
    public void setNotaTransaksi(Object[] baris) {
        setNota(new Object[]{baris[0], baris[1], baris[2], baris[3], baris[4], baris[6], "-", baris[8]});
        barisNota = baris;
        lblHNota.setText("NOTA TRANSAKSI");
        lblKeyNota1.setText("No. transaksi");
        lblKeyNota2.setText("Tanggal");
        lblKeyNota3.setText("Petani");
        lblValNota3.setText(String.valueOf(baris[5]));
        lblKeyNota6.setText("NIK");
        lblValNota6.setText(String.valueOf(baris[4]));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBodyNota = new javax.swing.JPanel();
        lblHNota = new javax.swing.JLabel();
        lblSubNota = new javax.swing.JLabel();
        pnlBarisNota1 = new javax.swing.JPanel();
        lblKeyNota1 = new javax.swing.JLabel();
        lblValNota1 = new javax.swing.JLabel();
        pnlBarisNota2 = new javax.swing.JPanel();
        lblKeyNota2 = new javax.swing.JLabel();
        lblValNota2 = new javax.swing.JLabel();
        pnlBarisNota3 = new javax.swing.JPanel();
        lblKeyNota3 = new javax.swing.JLabel();
        lblValNota3 = new javax.swing.JLabel();
        pnlBarisNota4 = new javax.swing.JPanel();
        lblKeyNota4 = new javax.swing.JLabel();
        lblValNota4 = new javax.swing.JLabel();
        pnlBarisNota5 = new javax.swing.JPanel();
        lblKeyNota5 = new javax.swing.JLabel();
        lblValNota5 = new javax.swing.JLabel();
        pnlBarisNota6 = new javax.swing.JPanel();
        lblKeyNota6 = new javax.swing.JLabel();
        lblValNota6 = new javax.swing.JLabel();
        pnlBarisNota7 = new javax.swing.JPanel();
        lblKeyNota7 = new javax.swing.JLabel();
        lblValNota7 = new javax.swing.JLabel();
        pnlBarisNota8 = new javax.swing.JPanel();
        lblKeyNota8 = new javax.swing.JLabel();
        lblValNota8 = new javax.swing.JLabel();
        pnlBarisNota9 = new javax.swing.JPanel();
        lblKeyNota9 = new javax.swing.JLabel();
        lblValNota9 = new javax.swing.JLabel();
        lblGapNota = new javax.swing.JLabel();
        pnlBarisNotaTotal = new javax.swing.JPanel();
        lblKeyNotaTotal = new javax.swing.JLabel();
        lblValNotaTotal = new javax.swing.JLabel();
        pnlActNota = new javax.swing.JPanel();
        btnGhostPdfNota = new javax.swing.JButton();
        btnGhostTutupNota = new javax.swing.JButton();

        setTitle("Nota penyaluran");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(460, 560));
        setResizable(false);

        pnlBodyNota.setBackground(new java.awt.Color(255, 253, 248));
        pnlBodyNota.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 30, 20, 30));
        pnlBodyNota.setLayout(new javax.swing.BoxLayout(pnlBodyNota, javax.swing.BoxLayout.PAGE_AXIS));

        lblHNota.setText("NOTA PENYALURAN");
        lblHNota.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblHNota.setForeground(new java.awt.Color(29, 42, 34));
        pnlBodyNota.add(lblHNota);

        lblSubNota.setText("AGROVA · Distribusi pupuk Samarinda");
        lblSubNota.setForeground(new java.awt.Color(122, 127, 115));
        lblSubNota.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 14, 0));
        pnlBodyNota.add(lblSubNota);

        pnlBarisNota1.setOpaque(false);
        pnlBarisNota1.setAlignmentX(0.0F);
        pnlBarisNota1.setMaximumSize(new java.awt.Dimension(4000, 30));
        pnlBarisNota1.setLayout(new java.awt.BorderLayout());

        lblKeyNota1.setText("No. penyaluran");
        lblKeyNota1.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyNota1.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBarisNota1.add(lblKeyNota1, java.awt.BorderLayout.WEST);

        lblValNota1.setText("PNY-0001");
        lblValNota1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValNota1.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisNota1.add(lblValNota1, java.awt.BorderLayout.CENTER);

        pnlBodyNota.add(pnlBarisNota1);

        pnlBarisNota2.setOpaque(false);
        pnlBarisNota2.setAlignmentX(0.0F);
        pnlBarisNota2.setMaximumSize(new java.awt.Dimension(4000, 30));
        pnlBarisNota2.setLayout(new java.awt.BorderLayout());

        lblKeyNota2.setText("Tanggal kirim");
        lblKeyNota2.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyNota2.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBarisNota2.add(lblKeyNota2, java.awt.BorderLayout.WEST);

        lblValNota2.setText("01-10-2026");
        lblValNota2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValNota2.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisNota2.add(lblValNota2, java.awt.BorderLayout.CENTER);

        pnlBodyNota.add(pnlBarisNota2);

        pnlBarisNota3.setOpaque(false);
        pnlBarisNota3.setAlignmentX(0.0F);
        pnlBarisNota3.setMaximumSize(new java.awt.Dimension(4000, 30));
        pnlBarisNota3.setLayout(new java.awt.BorderLayout());

        lblKeyNota3.setText("Tanggal terima");
        lblKeyNota3.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyNota3.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBarisNota3.add(lblKeyNota3, java.awt.BorderLayout.WEST);

        lblValNota3.setText("03-10-2026");
        lblValNota3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValNota3.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisNota3.add(lblValNota3, java.awt.BorderLayout.CENTER);

        pnlBodyNota.add(pnlBarisNota3);

        pnlBarisNota4.setOpaque(false);
        pnlBarisNota4.setAlignmentX(0.0F);
        pnlBarisNota4.setMaximumSize(new java.awt.Dimension(4000, 30));
        pnlBarisNota4.setLayout(new java.awt.BorderLayout());

        lblKeyNota4.setText("Kategori");
        lblKeyNota4.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyNota4.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBarisNota4.add(lblKeyNota4, java.awt.BorderLayout.WEST);

        lblValNota4.setText("Subsidi");
        lblValNota4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValNota4.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisNota4.add(lblValNota4, java.awt.BorderLayout.CENTER);

        pnlBodyNota.add(pnlBarisNota4);

        pnlBarisNota5.setOpaque(false);
        pnlBarisNota5.setAlignmentX(0.0F);
        pnlBarisNota5.setMaximumSize(new java.awt.Dimension(4000, 30));
        pnlBarisNota5.setLayout(new java.awt.BorderLayout());

        lblKeyNota5.setText("Produk");
        lblKeyNota5.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyNota5.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBarisNota5.add(lblKeyNota5, java.awt.BorderLayout.WEST);

        lblValNota5.setText("Urea Subsidi");
        lblValNota5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValNota5.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisNota5.add(lblValNota5, java.awt.BorderLayout.CENTER);

        pnlBodyNota.add(pnlBarisNota5);

        pnlBarisNota6.setOpaque(false);
        pnlBarisNota6.setAlignmentX(0.0F);
        pnlBarisNota6.setMaximumSize(new java.awt.Dimension(4000, 30));
        pnlBarisNota6.setLayout(new java.awt.BorderLayout());

        lblKeyNota6.setText("Kecamatan tujuan");
        lblKeyNota6.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyNota6.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBarisNota6.add(lblKeyNota6, java.awt.BorderLayout.WEST);

        lblValNota6.setText("Samarinda Ulu");
        lblValNota6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValNota6.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisNota6.add(lblValNota6, java.awt.BorderLayout.CENTER);

        pnlBodyNota.add(pnlBarisNota6);

        pnlBarisNota7.setOpaque(false);
        pnlBarisNota7.setAlignmentX(0.0F);
        pnlBarisNota7.setMaximumSize(new java.awt.Dimension(4000, 30));
        pnlBarisNota7.setLayout(new java.awt.BorderLayout());

        lblKeyNota7.setText("Jumlah");
        lblKeyNota7.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyNota7.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBarisNota7.add(lblKeyNota7, java.awt.BorderLayout.WEST);

        lblValNota7.setText("5.000 kg");
        lblValNota7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValNota7.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisNota7.add(lblValNota7, java.awt.BorderLayout.CENTER);

        pnlBodyNota.add(pnlBarisNota7);

        pnlBarisNota8.setOpaque(false);
        pnlBarisNota8.setAlignmentX(0.0F);
        pnlBarisNota8.setMaximumSize(new java.awt.Dimension(4000, 30));
        pnlBarisNota8.setLayout(new java.awt.BorderLayout());

        lblKeyNota8.setText("Harga per kg");
        lblKeyNota8.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyNota8.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBarisNota8.add(lblKeyNota8, java.awt.BorderLayout.WEST);

        lblValNota8.setText("Rp 2.250");
        lblValNota8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValNota8.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisNota8.add(lblValNota8, java.awt.BorderLayout.CENTER);

        pnlBodyNota.add(pnlBarisNota8);

        pnlBarisNota9.setOpaque(false);
        pnlBarisNota9.setAlignmentX(0.0F);
        pnlBarisNota9.setMaximumSize(new java.awt.Dimension(4000, 30));
        pnlBarisNota9.setLayout(new java.awt.BorderLayout());

        lblKeyNota9.setText("Status");
        lblKeyNota9.setForeground(new java.awt.Color(122, 127, 115));
        lblKeyNota9.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBarisNota9.add(lblKeyNota9, java.awt.BorderLayout.WEST);

        lblValNota9.setText("Diterima");
        lblValNota9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValNota9.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisNota9.add(lblValNota9, java.awt.BorderLayout.CENTER);

        pnlBodyNota.add(pnlBarisNota9);

        lblGapNota.setText(" ");
        lblGapNota.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblGapNota.setForeground(new java.awt.Color(29, 42, 34));
        lblGapNota.setPreferredSize(new java.awt.Dimension(10, 8));
        pnlBodyNota.add(lblGapNota);

        pnlBarisNotaTotal.setOpaque(false);
        pnlBarisNotaTotal.setAlignmentX(0.0F);
        pnlBarisNotaTotal.setMaximumSize(new java.awt.Dimension(4000, 30));
        pnlBarisNotaTotal.setLayout(new java.awt.BorderLayout());

        lblKeyNotaTotal.setText("TOTAL");
        lblKeyNotaTotal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblKeyNotaTotal.setForeground(new java.awt.Color(29, 42, 34));
        lblKeyNotaTotal.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBarisNotaTotal.add(lblKeyNotaTotal, java.awt.BorderLayout.WEST);

        lblValNotaTotal.setText("Rp 11.250.000");
        lblValNotaTotal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblValNotaTotal.setForeground(new java.awt.Color(29, 42, 34));
        pnlBarisNotaTotal.add(lblValNotaTotal, java.awt.BorderLayout.CENTER);

        pnlBodyNota.add(pnlBarisNotaTotal);

        pnlActNota.setOpaque(false);
        pnlActNota.setAlignmentX(0.0F);
        pnlActNota.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 0, 0, 0));
        pnlActNota.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnGhostPdfNota.setText("Simpan PDF");
        btnGhostPdfNota.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostPdfNota.setForeground(new java.awt.Color(31, 77, 58));
        btnGhostPdfNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhostPdfNotaActionPerformed(evt);
            }
        });
        pnlActNota.add(btnGhostPdfNota);

        btnGhostTutupNota.setText("Tutup");
        btnGhostTutupNota.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnGhostTutupNota.setForeground(new java.awt.Color(31, 77, 58));
        pnlActNota.add(btnGhostTutupNota);

        pnlBodyNota.add(pnlActNota);

        getContentPane().add(pnlBodyNota, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 714, 428);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGhostPdfNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostPdfNotaActionPerformed
        simpanPdf();
    }//GEN-LAST:event_btnGhostPdfNotaActionPerformed

    private void btnGhostTutupNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhostTutupNotaActionPerformed
        dispose();
    }//GEN-LAST:event_btnGhostTutupNotaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhostPdfNota;
    private javax.swing.JButton btnGhostTutupNota;
    private javax.swing.JLabel lblGapNota;
    private javax.swing.JLabel lblHNota;
    private javax.swing.JLabel lblKeyNota1;
    private javax.swing.JLabel lblKeyNota2;
    private javax.swing.JLabel lblKeyNota3;
    private javax.swing.JLabel lblKeyNota4;
    private javax.swing.JLabel lblKeyNota5;
    private javax.swing.JLabel lblKeyNota6;
    private javax.swing.JLabel lblKeyNota7;
    private javax.swing.JLabel lblKeyNota8;
    private javax.swing.JLabel lblKeyNota9;
    private javax.swing.JLabel lblKeyNotaTotal;
    private javax.swing.JLabel lblSubNota;
    private javax.swing.JLabel lblValNota1;
    private javax.swing.JLabel lblValNota2;
    private javax.swing.JLabel lblValNota3;
    private javax.swing.JLabel lblValNota4;
    private javax.swing.JLabel lblValNota5;
    private javax.swing.JLabel lblValNota6;
    private javax.swing.JLabel lblValNota7;
    private javax.swing.JLabel lblValNota8;
    private javax.swing.JLabel lblValNota9;
    private javax.swing.JLabel lblValNotaTotal;
    private javax.swing.JPanel pnlActNota;
    private javax.swing.JPanel pnlBarisNota1;
    private javax.swing.JPanel pnlBarisNota2;
    private javax.swing.JPanel pnlBarisNota3;
    private javax.swing.JPanel pnlBarisNota4;
    private javax.swing.JPanel pnlBarisNota5;
    private javax.swing.JPanel pnlBarisNota6;
    private javax.swing.JPanel pnlBarisNota7;
    private javax.swing.JPanel pnlBarisNota8;
    private javax.swing.JPanel pnlBarisNota9;
    private javax.swing.JPanel pnlBarisNotaTotal;
    private javax.swing.JPanel pnlBodyNota;
    // End of variables declaration//GEN-END:variables
}
