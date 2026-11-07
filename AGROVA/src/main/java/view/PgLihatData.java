package view;

import controller.GuiController;
import view.util.*;

/** Lihat Data. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */
public class PgLihatData extends javax.swing.JPanel {

    static {
        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri
    }

    public PgLihatData() {
        initComponents();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));
        Styler.apply(this);
        TableKit.muat(tblPtn, GuiController::dataPetani);
        InputFilters.keyword(txtCariPtn, 40);
        TableKit.muat(tblPyl, GuiController::dataPenyalur);
        InputFilters.keyword(txtCariPyl, 40);
        TableKit.muat(tblKtr, GuiController::ketersediaan);
        InputFilters.keyword(txtCariKtr, 40);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlHeaderData = new javax.swing.JPanel();
        pnlTitlesData = new javax.swing.JPanel();
        lblTitleData = new javax.swing.JLabel();
        lblSubData = new javax.swing.JLabel();
        pnlTopData = new javax.swing.JPanel();
        scrBodyData = new javax.swing.JScrollPane();
        pnlOuterData = new javax.swing.JPanel();
        pnlStackData = new javax.swing.JPanel();
        pnlGapData0 = new javax.swing.JPanel();
        tabData = new javax.swing.JTabbedPane();
        pnlTabP = new javax.swing.JPanel();
        pnlCardPtn = new javax.swing.JPanel();
        pnlHeadPtn = new javax.swing.JPanel();
        lblHPtn = new javax.swing.JLabel();
        pnlToolPtn = new javax.swing.JPanel();
        txtCariPtn = new javax.swing.JTextField();
        btnCariPtn = new javax.swing.JButton();
        scrPtn = new javax.swing.JScrollPane();
        tblPtn = new javax.swing.JTable();
        pnlTabY = new javax.swing.JPanel();
        pnlCardPyl = new javax.swing.JPanel();
        pnlHeadPyl = new javax.swing.JPanel();
        lblHPyl = new javax.swing.JLabel();
        pnlToolPyl = new javax.swing.JPanel();
        txtCariPyl = new javax.swing.JTextField();
        btnCariPyl = new javax.swing.JButton();
        scrPyl = new javax.swing.JScrollPane();
        tblPyl = new javax.swing.JTable();
        pnlTabK = new javax.swing.JPanel();
        pnlCardKtr = new javax.swing.JPanel();
        pnlHeadKtr = new javax.swing.JPanel();
        lblHKtr = new javax.swing.JLabel();
        pnlToolKtr = new javax.swing.JPanel();
        txtCariKtr = new javax.swing.JTextField();
        btnCariKtr = new javax.swing.JButton();
        scrKtr = new javax.swing.JScrollPane();
        tblKtr = new javax.swing.JTable();

        setBackground(new java.awt.Color(246, 241, 231));
        setPreferredSize(new java.awt.Dimension(980, 700));
        pnlHeaderData.setName("pnlHeaderData");
        pnlHeaderData.setOpaque(false);
        pnlHeaderData.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 26, 12, 26));
        scrBodyData.setName("scrBodyData");
        scrBodyData.setHorizontalScrollBarPolicy(31);
        setLayout(new java.awt.BorderLayout());
        pnlTitlesData.setName("pnlTitlesData");
        pnlTitlesData.setOpaque(false);
        pnlTitlesData.setAlignmentX(0.0f);
        pnlTopData.setName("pnlTopData");
        pnlTopData.setOpaque(false);
        pnlHeaderData.setLayout(new java.awt.BorderLayout());
        lblTitleData.setName("lblTitleData");
        lblTitleData.setFont(new java.awt.Font("Georgia", 0, 26));
        lblTitleData.setForeground(new java.awt.Color(29, 42, 34));
        lblTitleData.setText("Lihat Data");
        lblSubData.setName("lblSubData");
        lblSubData.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubData.setForeground(new java.awt.Color(122, 127, 115));
        lblSubData.setText("Data master (hanya baca).");
        pnlTitlesData.setLayout(new javax.swing.BoxLayout(pnlTitlesData, javax.swing.BoxLayout.PAGE_AXIS));
        pnlTitlesData.add(lblTitleData);
        pnlTitlesData.add(lblSubData);
        pnlTopData.setLayout(new java.awt.FlowLayout(2, 8, 0));
        pnlHeaderData.add(pnlTitlesData, java.awt.BorderLayout.WEST);
        pnlHeaderData.add(pnlTopData, java.awt.BorderLayout.EAST);
        pnlOuterData.setName("pnlOuterData");
        pnlOuterData.setOpaque(true);
        pnlOuterData.setBackground(new java.awt.Color(246, 241, 231));
        pnlOuterData.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 26, 26, 26));
        pnlStackData.setName("pnlStackData");
        pnlStackData.setOpaque(false);
        pnlStackData.setAlignmentX(0.0f);
        pnlOuterData.setLayout(new java.awt.BorderLayout());
        pnlGapData0.setName("pnlGapData0");
        pnlGapData0.setOpaque(false);
        pnlGapData0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlGapData0.setAlignmentX(0.0f);
        pnlStackData.setLayout(new javax.swing.BoxLayout(pnlStackData, javax.swing.BoxLayout.PAGE_AXIS));
        tabData.setName("tabData");
        tabData.setFont(new java.awt.Font("Segoe UI", 1, 13));
        tabData.setAlignmentX(0.0f);
        tabData.setPreferredSize(new java.awt.Dimension(700, 520));
        tabData.setMaximumSize(new java.awt.Dimension(4000, 520));
        pnlGapData0.setLayout(new java.awt.BorderLayout());
        pnlTabP.setName("pnlTabP");
        pnlTabP.setOpaque(false);
        pnlTabP.setAlignmentX(0.0f);
        pnlTabY.setName("pnlTabY");
        pnlTabY.setOpaque(false);
        pnlTabY.setAlignmentX(0.0f);
        pnlTabK.setName("pnlTabK");
        pnlTabK.setOpaque(false);
        pnlTabK.setAlignmentX(0.0f);
        pnlCardPtn.setName("pnlCardPtn");
        pnlCardPtn.setOpaque(true);
        pnlCardPtn.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardPtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardPtn.setAlignmentX(0.0f);
        pnlTabP.setLayout(new javax.swing.BoxLayout(pnlTabP, javax.swing.BoxLayout.PAGE_AXIS));
        pnlHeadPtn.setName("pnlHeadPtn");
        pnlHeadPtn.setOpaque(false);
        pnlHeadPtn.setAlignmentX(0.0f);
        pnlHeadPtn.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadPtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlToolPtn.setName("pnlToolPtn");
        pnlToolPtn.setOpaque(false);
        pnlToolPtn.setAlignmentX(0.0f);
        pnlToolPtn.setMaximumSize(new java.awt.Dimension(4000, 52));
        scrPtn.setName("scrPtn");
        scrPtn.setPreferredSize(new java.awt.Dimension(600, 360));
        scrPtn.setMaximumSize(new java.awt.Dimension(4000, 360));
        scrPtn.setAlignmentX(0.0f);
        pnlCardPtn.setLayout(new javax.swing.BoxLayout(pnlCardPtn, javax.swing.BoxLayout.PAGE_AXIS));
        lblHPtn.setName("lblHPtn");
        lblHPtn.setFont(new java.awt.Font("Georgia", 0, 17));
        lblHPtn.setForeground(new java.awt.Color(29, 42, 34));
        lblHPtn.setText("Data petani");
        pnlHeadPtn.setLayout(new java.awt.BorderLayout());
        pnlHeadPtn.add(lblHPtn, java.awt.BorderLayout.WEST);
        txtCariPtn.setName("txtCariPtn");
        txtCariPtn.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtCariPtn.setForeground(new java.awt.Color(29, 42, 34));
        txtCariPtn.setPreferredSize(new java.awt.Dimension(260, 40));
        btnCariPtn.setName("btnCariPtn");
        btnCariPtn.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnCariPtn.setForeground(new java.awt.Color(255, 255, 255));
        btnCariPtn.setBackground(new java.awt.Color(31, 77, 58));
        btnCariPtn.setText("Cari");
        btnCariPtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPtnActionPerformed(evt);
            }
        });
        pnlToolPtn.setLayout(new java.awt.FlowLayout(0, 8, 0));
        pnlToolPtn.add(txtCariPtn);
        pnlToolPtn.add(btnCariPtn);
        tblPtn.setName("tblPtn");
        tblPtn.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"NIK", "Nama", "Kecamatan", "Luas (ha)", "Email", "Terdaftar"}) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        scrPtn.setViewportView(tblPtn);
        pnlCardPtn.add(pnlHeadPtn);
        pnlCardPtn.add(pnlToolPtn);
        pnlCardPtn.add(scrPtn);
        pnlTabP.add(pnlCardPtn);
        pnlCardPyl.setName("pnlCardPyl");
        pnlCardPyl.setOpaque(true);
        pnlCardPyl.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardPyl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardPyl.setAlignmentX(0.0f);
        pnlTabY.setLayout(new javax.swing.BoxLayout(pnlTabY, javax.swing.BoxLayout.PAGE_AXIS));
        pnlHeadPyl.setName("pnlHeadPyl");
        pnlHeadPyl.setOpaque(false);
        pnlHeadPyl.setAlignmentX(0.0f);
        pnlHeadPyl.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadPyl.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlToolPyl.setName("pnlToolPyl");
        pnlToolPyl.setOpaque(false);
        pnlToolPyl.setAlignmentX(0.0f);
        pnlToolPyl.setMaximumSize(new java.awt.Dimension(4000, 52));
        scrPyl.setName("scrPyl");
        scrPyl.setPreferredSize(new java.awt.Dimension(600, 360));
        scrPyl.setMaximumSize(new java.awt.Dimension(4000, 360));
        scrPyl.setAlignmentX(0.0f);
        pnlCardPyl.setLayout(new javax.swing.BoxLayout(pnlCardPyl, javax.swing.BoxLayout.PAGE_AXIS));
        lblHPyl.setName("lblHPyl");
        lblHPyl.setFont(new java.awt.Font("Georgia", 0, 17));
        lblHPyl.setForeground(new java.awt.Color(29, 42, 34));
        lblHPyl.setText("Data penyalur");
        pnlHeadPyl.setLayout(new java.awt.BorderLayout());
        pnlHeadPyl.add(lblHPyl, java.awt.BorderLayout.WEST);
        txtCariPyl.setName("txtCariPyl");
        txtCariPyl.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtCariPyl.setForeground(new java.awt.Color(29, 42, 34));
        txtCariPyl.setPreferredSize(new java.awt.Dimension(260, 40));
        btnCariPyl.setName("btnCariPyl");
        btnCariPyl.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnCariPyl.setForeground(new java.awt.Color(255, 255, 255));
        btnCariPyl.setBackground(new java.awt.Color(31, 77, 58));
        btnCariPyl.setText("Cari");
        btnCariPyl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPylActionPerformed(evt);
            }
        });
        pnlToolPyl.setLayout(new java.awt.FlowLayout(0, 8, 0));
        pnlToolPyl.add(txtCariPyl);
        pnlToolPyl.add(btnCariPyl);
        tblPyl.setName("tblPyl");
        tblPyl.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Nama", "Email", "Kecamatan", "Pengiriman", "Selesai", "Terdaftar"}) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        scrPyl.setViewportView(tblPyl);
        pnlCardPyl.add(pnlHeadPyl);
        pnlCardPyl.add(pnlToolPyl);
        pnlCardPyl.add(scrPyl);
        pnlTabY.add(pnlCardPyl);
        pnlCardKtr.setName("pnlCardKtr");
        pnlCardKtr.setOpaque(true);
        pnlCardKtr.setBackground(new java.awt.Color(255, 253, 248));
        pnlCardKtr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 223, 204)));
        pnlCardKtr.setAlignmentX(0.0f);
        pnlTabK.setLayout(new javax.swing.BoxLayout(pnlTabK, javax.swing.BoxLayout.PAGE_AXIS));
        pnlHeadKtr.setName("pnlHeadKtr");
        pnlHeadKtr.setOpaque(false);
        pnlHeadKtr.setAlignmentX(0.0f);
        pnlHeadKtr.setMaximumSize(new java.awt.Dimension(4000, 34));
        pnlHeadKtr.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlToolKtr.setName("pnlToolKtr");
        pnlToolKtr.setOpaque(false);
        pnlToolKtr.setAlignmentX(0.0f);
        pnlToolKtr.setMaximumSize(new java.awt.Dimension(4000, 52));
        scrKtr.setName("scrKtr");
        scrKtr.setPreferredSize(new java.awt.Dimension(600, 360));
        scrKtr.setMaximumSize(new java.awt.Dimension(4000, 360));
        scrKtr.setAlignmentX(0.0f);
        pnlCardKtr.setLayout(new javax.swing.BoxLayout(pnlCardKtr, javax.swing.BoxLayout.PAGE_AXIS));
        lblHKtr.setName("lblHKtr");
        lblHKtr.setFont(new java.awt.Font("Georgia", 0, 17));
        lblHKtr.setForeground(new java.awt.Color(29, 42, 34));
        lblHKtr.setText("Ketersediaan pupuk");
        pnlHeadKtr.setLayout(new java.awt.BorderLayout());
        pnlHeadKtr.add(lblHKtr, java.awt.BorderLayout.WEST);
        txtCariKtr.setName("txtCariKtr");
        txtCariKtr.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtCariKtr.setForeground(new java.awt.Color(29, 42, 34));
        txtCariKtr.setPreferredSize(new java.awt.Dimension(260, 40));
        btnCariKtr.setName("btnCariKtr");
        btnCariKtr.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnCariKtr.setForeground(new java.awt.Color(255, 255, 255));
        btnCariKtr.setBackground(new java.awt.Color(31, 77, 58));
        btnCariKtr.setText("Cari");
        btnCariKtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariKtrActionPerformed(evt);
            }
        });
        pnlToolKtr.setLayout(new java.awt.FlowLayout(0, 8, 0));
        pnlToolKtr.add(txtCariKtr);
        pnlToolKtr.add(btnCariKtr);
        tblKtr.setName("tblKtr");
        tblKtr.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Produk", "Kategori", "Stok gudang (kg)", "Dialokasikan (kg)", "Menunggu (kg)"}) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        scrKtr.setViewportView(tblKtr);
        pnlCardKtr.add(pnlHeadKtr);
        pnlCardKtr.add(pnlToolKtr);
        pnlCardKtr.add(scrKtr);
        pnlTabK.add(pnlCardKtr);
        tabData.addTab("Petani", pnlTabP);
        tabData.addTab("Penyalur", pnlTabY);
        tabData.addTab("Ketersediaan", pnlTabK);
        pnlGapData0.add(tabData, java.awt.BorderLayout.CENTER);
        pnlStackData.add(pnlGapData0);
        pnlOuterData.add(pnlStackData, java.awt.BorderLayout.NORTH);
        scrBodyData.setViewportView(pnlOuterData);
        add(pnlHeaderData, java.awt.BorderLayout.NORTH);
        add(scrBodyData, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void btnCariPtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPtnActionPerformed
        TableKit.cari(tblPtn, txtCariPtn.getText());
    }//GEN-LAST:event_btnCariPtnActionPerformed

    private void btnCariPylActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPylActionPerformed
        TableKit.cari(tblPyl, txtCariPyl.getText());
    }//GEN-LAST:event_btnCariPylActionPerformed

    private void btnCariKtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariKtrActionPerformed
        TableKit.cari(tblKtr, txtCariKtr.getText());
    }//GEN-LAST:event_btnCariKtrActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlHeaderData;
    private javax.swing.JPanel pnlTitlesData;
    private javax.swing.JLabel lblTitleData;
    private javax.swing.JLabel lblSubData;
    private javax.swing.JPanel pnlTopData;
    private javax.swing.JScrollPane scrBodyData;
    private javax.swing.JPanel pnlOuterData;
    private javax.swing.JPanel pnlStackData;
    private javax.swing.JPanel pnlGapData0;
    private javax.swing.JTabbedPane tabData;
    private javax.swing.JPanel pnlTabP;
    private javax.swing.JPanel pnlCardPtn;
    private javax.swing.JPanel pnlHeadPtn;
    private javax.swing.JLabel lblHPtn;
    private javax.swing.JPanel pnlToolPtn;
    private javax.swing.JTextField txtCariPtn;
    private javax.swing.JButton btnCariPtn;
    private javax.swing.JScrollPane scrPtn;
    private javax.swing.JTable tblPtn;
    private javax.swing.JPanel pnlTabY;
    private javax.swing.JPanel pnlCardPyl;
    private javax.swing.JPanel pnlHeadPyl;
    private javax.swing.JLabel lblHPyl;
    private javax.swing.JPanel pnlToolPyl;
    private javax.swing.JTextField txtCariPyl;
    private javax.swing.JButton btnCariPyl;
    private javax.swing.JScrollPane scrPyl;
    private javax.swing.JTable tblPyl;
    private javax.swing.JPanel pnlTabK;
    private javax.swing.JPanel pnlCardKtr;
    private javax.swing.JPanel pnlHeadKtr;
    private javax.swing.JLabel lblHKtr;
    private javax.swing.JPanel pnlToolKtr;
    private javax.swing.JTextField txtCariKtr;
    private javax.swing.JButton btnCariKtr;
    private javax.swing.JScrollPane scrKtr;
    private javax.swing.JTable tblKtr;
    // End of variables declaration//GEN-END:variables
}
