package view.util;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

/** Grafik sederhana (batang horizontal dan pie) yang digambar langsung dengan Java2D, tanpa pustaka tambahan. */
public final class Charts {
    private Charts() {
    }

    public static final Color[] PALET = {Theme.LEAF, Theme.GOLD, Theme.RIVER, Theme.CLAY, Theme.FOREST, Theme.SLATE,
        new Color(0x7B5EA7), new Color(0x2A9D8F)};

    /** Satu data grafik: label, nilai, dan keterangan tambahan (opsional) di sisi kanan. */
    public record Item(String label, double nilai, String keterangan) {
        public Item(String label, double nilai) {
            this(label, nilai, null);
        }
    }

    private static String angka(double v) {
        return String.format(java.util.Locale.GERMANY, "%,.0f", v);
    }

    /** Grafik batang horizontal; satu baris per data, tinggi menyesuaikan jumlah data. */
    public static class Bar extends JComponent {
        private final List<Item> data = new ArrayList<>();
        private String satuan = "kg";
        private Color warna = Theme.LEAF;
        private String kosong = "Belum ada data";

        public Bar() {
            setOpaque(false);
        }

        public Bar data(List<Item> d, String satuan, Color warna) {
            this.data.clear();
            this.data.addAll(d);
            this.satuan = satuan;
            this.warna = warna;
            int baris = Math.max(1, d.size());
            setPreferredSize(new Dimension(300, 30 + baris * 34));
            setMinimumSize(new Dimension(200, 30 + baris * 34));
            revalidate();
            repaint();
            return this;
        }

        @Override
        protected void paintComponent(Graphics g0) {
            Graphics2D g = (Graphics2D) g0.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            int w = getWidth();
            if (data.isEmpty()) {
                g.setFont(Theme.sans(12.5f, Font.PLAIN));
                g.setColor(Theme.MUTED);
                g.drawString(kosong, 4, 24);
                g.dispose();
                return;
            }
            double max = 1;
            for (Item i : data) max = Math.max(max, i.nilai());
            Font fl = Theme.sans(12.5f, Font.BOLD), fv = Theme.sans(11.5f, Font.PLAIN);
            FontMetrics ml = g.getFontMetrics(fl);
            int kiri = 0;
            for (Item i : data) kiri = Math.max(kiri, ml.stringWidth(i.label()));
            kiri = Math.min(kiri + 12, w / 3);
            int kanan = 0;
            g.setFont(fv);
            FontMetrics mv = g.getFontMetrics();
            for (Item i : data) kanan = Math.max(kanan, mv.stringWidth(teksNilai(i)));
            kanan = Math.min(kanan + 10, w / 2);
            int x0 = kiri, lebar = Math.max(40, w - kiri - kanan);
            int y = 8;
            for (Item i : data) {
                g.setFont(fl);
                g.setColor(Theme.INK);
                g.drawString(ellipsis(i.label(), ml, kiri - 8), 0, y + 17);
                g.setColor(Theme.SURFACE_ALT.darker().equals(Color.BLACK) ? Theme.BORDER : Theme.BORDER);
                g.fillRoundRect(x0, y + 5, lebar, 14, 14, 14);
                int bw = (int) Math.round(lebar * i.nilai() / max);
                g.setColor(warna);
                if (i.nilai() > 0) g.fillRoundRect(x0, y + 5, Math.max(8, bw), 14, 14, 14);
                g.setFont(fv);
                g.setColor(Theme.MUTED);
                g.drawString(ellipsis(teksNilai(i), mv, kanan - 6), x0 + lebar + 8, y + 17);
                y += 34;
            }
            g.dispose();
        }

        private String teksNilai(Item i) {
            return angka(i.nilai()) + " " + satuan + (i.keterangan() == null ? "" : " · " + i.keterangan());
        }

        static String ellipsis(String s, FontMetrics m, int max) {
            if (m.stringWidth(s) <= max) return s;
            while (s.length() > 1 && m.stringWidth(s + "…") > max) s = s.substring(0, s.length() - 1);
            return s + "…";
        }
    }

    /** Grafik batang vertikal (kolom) dengan nilai di atas tiap batang; label sumbu-x diringkas bila sempit. */
    public static class Column extends JComponent {
        private final List<Item> data = new ArrayList<>();
        private String satuan = "kg";
        private Color warna = Theme.LEAF;

        public Column() {
            setOpaque(false);
            setPreferredSize(new Dimension(300, 190));
        }

        public Column data(List<Item> d, String satuan, Color warna) {
            this.data.clear();
            this.data.addAll(d);
            this.satuan = satuan;
            this.warna = warna;
            repaint();
            return this;
        }

        @Override
        protected void paintComponent(Graphics g0) {
            Graphics2D g = (Graphics2D) g0.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g.setFont(Theme.sans(11f, Font.PLAIN));
            FontMetrics fm = g.getFontMetrics();
            int w = getWidth(), h = getHeight();
            if (data.isEmpty()) {
                g.setColor(Theme.MUTED);
                g.drawString("Belum ada data", (w - fm.stringWidth("Belum ada data")) / 2, h / 2);
                g.dispose();
                return;
            }
            double max = 1;
            for (Item it : data) max = Math.max(max, it.nilai());
            int top = 22, bottom = 24, n = data.size(), slot = Math.max(40, w / n), bw = Math.min(58, slot - 16);
            int ch = h - top - bottom;
            g.setColor(Theme.BORDER);
            g.drawLine(0, top + ch, w, top + ch);
            for (int i = 0; i < n; i++) {
                Item it = data.get(i);
                int bh = (int) Math.round(ch * it.nilai() / max);
                int x = i * slot + (slot - bw) / 2;
                g.setColor(PALET[i % 2 == 0 ? 0 : 4]);
                g.setColor(warna);
                g.fillRoundRect(x, top + ch - bh, bw, Math.max(bh, 2), 8, 8);
                g.setColor(Theme.INK);
                String v = angka(it.nilai());
                g.drawString(v, x + (bw - fm.stringWidth(v)) / 2, top + ch - bh - 5);
                g.setColor(Theme.MUTED);
                String l = Bar.ellipsis(it.label(), fm, slot - 6);
                g.drawString(l, i * slot + (slot - fm.stringWidth(l)) / 2, top + ch + 16);
            }
            g.setColor(Theme.MUTED);
            g.drawString("(" + satuan + ")", 0, 12);
            g.dispose();
        }
    }

    /** Grafik pie dengan legenda di sisi kanan (nama, nilai, dan bagiannya). */
    public static class Pie extends JComponent {
        private final List<Item> data = new ArrayList<>();
        private final List<Color> warna = new ArrayList<>();
        private String satuan = "kg";

        public Pie() {
            setOpaque(false);
            setPreferredSize(new Dimension(300, 170));
            setMinimumSize(new Dimension(240, 150));
        }

        public Pie data(List<Item> d, String satuan, Color... warna) {
            this.data.clear();
            this.data.addAll(d);
            this.warna.clear();
            for (Color c : warna) this.warna.add(c);
            this.satuan = satuan;
            repaint();
            return this;
        }

        @Override
        protected void paintComponent(Graphics g0) {
            Graphics2D g = (Graphics2D) g0.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            double total = 0;
            for (Item i : data) total += i.nilai();
            int d = Math.min(getHeight() - 10, 150);
            int px = 6, py = (getHeight() - d) / 2;
            if (total <= 0) {
                g.setColor(Theme.BORDER);
                g.fillOval(px, py, d, d);
                g.setColor(Theme.MUTED);
                g.setFont(Theme.sans(12.5f, Font.PLAIN));
                g.drawString("Belum ada data", px + d + 16, getHeight() / 2);
                g.dispose();
                return;
            }
            double sudut = 90;
            for (int k = 0; k < data.size(); k++) {
                double ext = -360.0 * data.get(k).nilai() / total;
                g.setColor(warna.isEmpty() ? PALET[k % PALET.length] : warna.get(k % warna.size()));
                g.fill(new Arc2D.Double(px, py, d, d, sudut, ext, Arc2D.PIE));
                sudut += ext;
            }
            g.setColor(Theme.SURFACE);
            int lubang = d / 2;
            g.fillOval(px + (d - lubang) / 2, py + (d - lubang) / 2, lubang, lubang);
            int lx = px + d + 20, ly = Math.max(18, (getHeight() - data.size() * 40) / 2 + 14);
            for (int k = 0; k < data.size(); k++) {
                Item i = data.get(k);
                g.setColor(warna.isEmpty() ? PALET[k % PALET.length] : warna.get(k % warna.size()));
                g.fillRoundRect(lx, ly - 11, 13, 13, 4, 4);
                g.setColor(Theme.INK);
                g.setFont(Theme.sans(12.5f, Font.BOLD));
                g.drawString(i.label(), lx + 20, ly);
                g.setColor(Theme.MUTED);
                g.setFont(Theme.sans(11.5f, Font.PLAIN));
                g.drawString(angka(i.nilai()) + " " + satuan, lx + 20, ly + 16);
                ly += 40;
            }
            g.dispose();
        }
    }
}
