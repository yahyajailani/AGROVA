package view.util;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;

/** Utilitas tabel: gaya seragam dan pengisian data (renderer, model). */
public final class TableKit {
    private TableKit() {
    }

    public static void style(JTable t) {
        t.setRowHeight(36);
        t.setShowGrid(false);
        t.setIntercellSpacing(new Dimension(0, 0));
        t.setFont(Theme.sans(12.5f, Font.PLAIN));
        t.setForeground(Theme.INK);
        t.setFillsViewportHeight(true);
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        t.setSelectionBackground(Theme.MINT);
        t.setSelectionForeground(Theme.INK);
        JTableHeader h = t.getTableHeader();
        h.setReorderingAllowed(false);
        h.setPreferredSize(new Dimension(10, 34));
        h.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tb, Object v, boolean s, boolean f, int r, int c) {
                JLabel l = (JLabel) super.getTableCellRendererComponent(tb, v, false, false, r, c);
                l.setFont(Theme.sans(11.5f, Font.BOLD));
                l.setForeground(Theme.MUTED);
                l.setBackground(Theme.SURFACE);
                l.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                return l;
            }
        });
        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tb, Object v, boolean s, boolean f, int r, int c) {
                String txt = v == null ? "" : v.toString();
                JLabel l = (JLabel) super.getTableCellRendererComponent(tb, txt, s, false, r, c);
                l.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                l.setOpaque(true);
                l.setBackground(s ? Theme.MINT : (r % 2 == 0 ? Theme.SURFACE : Theme.SURFACE_ALT));
                boolean num = txt.matches("[0-9.,%]+( kg)?");
                l.setHorizontalAlignment(num ? SwingConstants.RIGHT : SwingConstants.LEFT);
                Color pill = switch (txt) {
                    case "Dikirim", "Menunggu", "Baru" -> Theme.RIVER;
                    case "Diterima", "Selesai", "Dibaca" -> new Color(0x2E7D3F);
                    case "Dibatalkan", "Ditolak" -> Theme.CLAY;
                    default -> null;
                };
                l.setForeground(pill != null ? pill : Theme.INK);
                l.setFont(Theme.sans(12.5f, pill != null ? Font.BOLD : Font.PLAIN));
                return l;
            }
        });
    }

    /** Mengganti isi tabel dengan data (baris array). Cocok dipanggil backend dengan hasil query. */
    public static void fill(JTable t, List<Object[]> rows) {
        DefaultTableModel m = (DefaultTableModel) t.getModel();
        m.setRowCount(0);
        for (Object[] r : rows) m.addRow(r);
    }

    public static void fill(JTable t, Object[][] rows) {
        fill(t, java.util.Arrays.asList(rows));
    }

    /** Isi tabel dari backend. Bila gagal (mis. database mati) tabel dikosongkan dan pesan galat ditampilkan. */
    public static void muat(JTable t, java.util.function.Supplier<Object[][]> sumber) {
        try {
            fill(t, sumber.get());
        } catch (RuntimeException e) {
            fill(t, new Object[0][]);
            final String pesan = e.getMessage() == null ? e.toString() : e.getMessage();
            if (!pesan.equals(galatTerakhir)) {
                galatTerakhir = pesan;
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(t.getTopLevelAncestor(), pesan, "AGROVA", JOptionPane.ERROR_MESSAGE));
            }
        }
    }

    private static String galatTerakhir;

    /** Saring baris tabel yang memuat kata kunci (tanpa membedakan huruf besar/kecil). Kosong = tampilkan semua. */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void cari(JTable t, String kata) {
        if (!(t.getRowSorter() instanceof javax.swing.table.TableRowSorter)) {
            t.setRowSorter(new javax.swing.table.TableRowSorter(t.getModel()));
        }
        javax.swing.table.TableRowSorter sorter = (javax.swing.table.TableRowSorter) t.getRowSorter();
        String k = kata == null ? "" : kata.trim();
        sorter.setRowFilter(k.isEmpty() ? null : RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(k)));
    }

    /** Nilai kolom pada baris terpilih (memperhitungkan penyaringan/pengurutan), atau null bila tidak ada pilihan. */
    public static String pilih(JTable t, int kolom) {
        int r = t.getSelectedRow();
        return r < 0 ? null : String.valueOf(t.getValueAt(r, kolom));
    }

    /** Semua nilai pada baris terpilih, atau null. */
    public static Object[] barisPilih(JTable t) {
        int r = t.getSelectedRow();
        if (r < 0) {
            return null;
        }
        Object[] o = new Object[t.getColumnCount()];
        for (int c = 0; c < o.length; c++) {
            o[c] = t.getValueAt(r, c);
        }
        return o;
    }
    /**
     * Membuat kolom tertentu membungkus teks ke beberapa baris (tidak terpotong "..."); tinggi baris
     * menyesuaikan isi dan dihitung ulang saat data berubah atau lebar tabel berubah.
     */
    public static void bungkus(JTable t, int... kolom) {
        TableCellRenderer r = (tb, v, sel, foc, row, col) -> {
            JTextArea a = new JTextArea(v == null ? "" : v.toString());
            a.setLineWrap(true);
            a.setWrapStyleWord(true);
            a.setFont(Theme.sans(12.5f, Font.PLAIN));
            a.setForeground(Theme.INK);
            a.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
            a.setOpaque(true);
            a.setBackground(sel ? Theme.MINT : (row % 2 == 0 ? Theme.SURFACE : Theme.SURFACE_ALT));
            a.setSize(Math.max(40, tb.getColumnModel().getColumn(col).getWidth()), Short.MAX_VALUE);
            return a;
        };
        for (int c : kolom) t.getColumnModel().getColumn(c).setCellRenderer(r);
        Runnable fit = () -> {
            for (int row = 0; row < t.getRowCount(); row++) {
                int h = 36;
                for (int c : kolom) {
                    Component comp = t.prepareRenderer(t.getCellRenderer(row, c), row, c);
                    h = Math.max(h, comp.getPreferredSize().height);
                }
                if (t.getRowHeight(row) != h) t.setRowHeight(row, h);
            }
        };
        t.getModel().addTableModelListener(e -> SwingUtilities.invokeLater(fit));
        t.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override public void componentResized(java.awt.event.ComponentEvent e) { SwingUtilities.invokeLater(fit); }
        });
        SwingUtilities.invokeLater(fit);
    }

    /** Isi combo produk dari daftar lengkap; bila tidak berhak subsidi, item yang memuat "subsidi" tanpa "non" dibuang. */
    public static void saringProduk(javax.swing.JComboBox<String> cmb, String[] semua, boolean berhakSubsidi) {
        java.util.List<String> isi = new java.util.ArrayList<>();
        for (String t : semua) {
            String x = t.trim().toLowerCase();
            boolean subsidi = x.endsWith("subsidi") && !x.endsWith("nonsubsidi") && !x.endsWith("non subsidi");
            if (berhakSubsidi || !subsidi) {
                isi.add(t);
            }
        }
        cmb.setModel(new javax.swing.DefaultComboBoxModel<>(isi.toArray(new String[0])));
    }
}
