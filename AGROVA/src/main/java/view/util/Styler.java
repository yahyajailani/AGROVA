package view.util;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.plaf.basic.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Penata gaya (styler) untuk seluruh form: komponen Swing standar diberi tampilan AGROVA berdasarkan awalan NAMA variabelnya.
 * Panggil Styler.apply(this) di konstruktor setelah initComponents(). Tidak ada komponen buatan sendiri di form.
 * Awalan: pnlCard (kartu), pnlSidebar, lblTitle/lblH/lblBig/lblSub/lblHint/lblLight, btn (utama), btnGhost, btnDanger, btnGold, btnLink,
 * nav (menu sidebar), seg (pilihan peran), txt (isian), cmb, tbl, bar (JProgressBar: barSub, barNon, barRiver, barWarn).
 */
public final class Styler {
    private Styler() {
    }

    static final Color LINE = new Color(0xD9D2BE);

    // ------------------------------------------------------------------ jalan masuk
    /**
     * Memberi nama komponen = nama variabelnya bila belum punya nama. Styler memilih gaya dari NAMA komponen, jadi ini
     * menjaga tampilan tetap utuh walau NetBeans meregenerasi initComponents() tanpa baris setName(...).
     */
    private static void nameFromFields(Object owner) {
        for (java.lang.reflect.Field fld : owner.getClass().getDeclaredFields()) {
            if (!Component.class.isAssignableFrom(fld.getType()) || java.lang.reflect.Modifier.isStatic(fld.getModifiers())) continue;
            try {
                fld.setAccessible(true);
                Object v = fld.get(owner);
                if (v instanceof Component c && c.getName() == null) c.setName(fld.getName());
            } catch (ReflectiveOperationException | RuntimeException ignored) {
                // abaikan: field tak bisa dibaca
            }
        }
    }

    public static void apply(Container root) {
        nameFromFields(root);
        if (root instanceof JComponent jc && root.getName() == null) jc.setOpaque(false);
        walk(root);
        if (root instanceof JFrame f) f.getContentPane().setBackground(Theme.PAPER);
    }

    public static void applyDialog(JDialog d) {
        nameFromFields(d);
        d.getContentPane().setBackground(Theme.PAPER);
        walk(d.getContentPane());
        d.pack();
        d.setLocationRelativeTo(d.getOwner());
    }

    public static void applyFrame(JFrame f) {
        nameFromFields(f);
        f.getContentPane().setBackground(Theme.PAPER);
        walk(f.getContentPane());
        f.setLocationRelativeTo(null);
    }

    private static void walk(Component c) {
        style(c);
        if (c instanceof Container k) for (Component x : k.getComponents()) walk(x);
    }

    private static boolean is(Component c, String prefix) {
        String n = c.getName();
        return n != null && n.startsWith(prefix);
    }

    private static void style(Component c) {
        String n = c.getName() == null ? "" : c.getName();
        if (c.getParent() instanceof JComboBox) {
            return;
        }
        if (c instanceof JLabel hero && n.startsWith("lblLightImgHero") && hero.getIcon() instanceof ImageIcon src) {
            // gambar hero mengikuti lebar jendela (dipotong ala "cover"), tinggi tetap
            hero.setIcon(new CoverIcon(src));
            hero.setMaximumSize(new Dimension(Short.MAX_VALUE, hero.getPreferredSize().height));
        }
        if (c instanceof JTabbedPane t) {
            t.setFont(Theme.sans(13f, Font.BOLD));
            t.setOpaque(false);
            t.setUI(new FlatTabsUI());
        } else if (c instanceof JScrollPane sp) {
            boolean body = n.startsWith("scrBody");
            sp.setOpaque(false);
            sp.getViewport().setOpaque(false);
            if (body) {
                sp.setBorder(null);
                sp.setViewportBorder(null);
                sp.getVerticalScrollBar().setUnitIncrement(18);
            } else {
                sp.setBorder(BorderFactory.createLineBorder(Theme.BORDER, 1));
                sp.getViewport().setOpaque(true);
                sp.getViewport().setBackground(Theme.SURFACE);
            }
            ThinScrollBarUI.apply(sp);
        } else if (c instanceof JPanel p) {
            if (n.startsWith("pnlCardFlat")) {
                p.setOpaque(false);
                p.setBorder(new RoundBorder(new Color(0xFBFAF6), null, 22, 0));
            } else if (n.startsWith("pnlGlass")) {
                p.setOpaque(false);
                p.setBorder(new RoundBorder(new Color(255, 255, 255, 36), new Color(255, 255, 255, 70), 16, 12));
            } else if (n.startsWith("pnlTint")) {
                // kartu berwarna: warna isi diambil dari properti background di Design, garis = warna isi dipekatkan
                Color bg = p.getBackground();
                Color garis = new Color((bg.getRed() * 82 + Theme.INK.getRed() * 18) / 100, (bg.getGreen() * 82 + Theme.INK.getGreen() * 18) / 100, (bg.getBlue() * 82 + Theme.INK.getBlue() * 18) / 100);
                p.setOpaque(false);
                p.setBorder(new RoundBorder(bg, garis, 22, 6));
            } else if (n.startsWith("pnlCard")) {
                p.setOpaque(false);
                p.setBorder(new RoundBorder(Theme.SURFACE, Theme.BORDER, 22, 16));
            } else if (n.startsWith("pnlSoft")) {
                p.setOpaque(false);
                p.setBorder(new RoundBorder(new Color(0xF1EDE0), null, 16, 14));
            } else if (n.startsWith("pnlForest")) {
                p.setOpaque(true);
                p.setBackground(new Color(0x143528));
            } else if (n.startsWith("pnlPaper")) {
                p.setOpaque(true);
                p.setBackground(Theme.PAPER);
            } else if (n.startsWith("pnlSidebar")) {
                p.setOpaque(true);
                p.setBackground(Theme.FOREST_DARK);
            } else if (n.startsWith("pnlDark")) {
                p.setOpaque(false);
                p.setBorder(new RoundBorder(new Color(0x0A2E1E), null, 22, 24));
            } else {
                p.setOpaque(false);
            }
        } else if (c instanceof JLabel l) {
            styleLabel(l, n);
        } else if (c instanceof JToggleButton b && !(c instanceof JCheckBox) && !(c instanceof JRadioButton)) {
            if (n.startsWith("mata")) {
                // tombol ikon mata (lihat/sembunyikan sandi): tetap polos, tanpa latar segmen
                b.setOpaque(false);
                b.setContentAreaFilled(false);
                b.setBorderPainted(false);
                b.setFocusPainted(false);
                b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                return;
            }
            if (n.startsWith("nav")) {
                b.setUI(new NavUI());
                b.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 12));
                b.setHorizontalAlignment(SwingConstants.LEFT);
                b.setIconTextGap(12);
                b.setFont(Theme.sans(13.5f, Font.PLAIN));
            } else {
                b.setUI(new SegUI());
                b.setFont(Theme.sans(12.5f, Font.BOLD));
                b.setBorder(BorderFactory.createEmptyBorder(8, 6, 8, 6));
            }
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            b.setFocusPainted(false);
        } else if (c instanceof JButton b) {
            b.setUI(new PillUI(n));
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setFont(Theme.sans(13f, Font.BOLD));
            b.setBorder(BorderFactory.createEmptyBorder(9, 18, 9, 18));
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            b.setFocusPainted(false);
            b.setIconTextGap(8);
        } else if (c instanceof JCheckBox k) {
            k.setOpaque(false);
            k.setFont(Theme.sans(12.5f, Font.PLAIN));
            k.setForeground(Theme.INK);
            k.setFocusPainted(false);
        } else if (c instanceof JPasswordField t) {
            t.setUI(new BasicPasswordFieldUI() {
                @Override
                protected void paintSafely(Graphics g) {
                    whiteBg(g, getComponent());
                    super.paintSafely(g);
                }
            });
            field(t);
        } else if (c instanceof JTextField t) {
            t.setUI(new BasicTextFieldUI() {
                @Override
                protected void paintSafely(Graphics g) {
                    whiteBg(g, getComponent());
                    super.paintSafely(g);
                }
            });
            field(t);
        } else if (c instanceof JComboBox<?> cb) {
            combo(cb);
        } else if (c instanceof JTable t) {
            TableKit.style(t);
        } else if (c instanceof JProgressBar pb) {
            bar(pb, n);
        }
    }

    private static void styleLabel(JLabel l, String n) {
        if (n.startsWith("lblWarna")) {
            // label berwarna: warna teks dari Design dipertahankan; hanya font yang diseragamkan
            boolean serif = n.startsWith("lblWarnaJudul") || n.startsWith("lblWarnaHead");
            boolean besar = n.startsWith("lblWarnaJudulBesar") || n.startsWith("lblWarnaIsiBesar");
            l.setFont(serif ? Theme.serif(besar ? 24f : 17f, Font.PLAIN) : Theme.sans(besar ? 17f : 13f, Font.PLAIN));
            return;
        }
        Font f = Theme.sans(13f, Font.PLAIN);
        Color col = Theme.INK;
        if (n.startsWith("lblTitle")) f = Theme.serif(26f, Font.PLAIN);
        else if (n.startsWith("lblBig")) f = Theme.serif(30f, Font.PLAIN);
        else if (n.startsWith("lblBrand")) { f = Theme.serif(24f, Font.PLAIN); col = Theme.ON_DARK; }
        else if (n.startsWith("lblLightH")) { f = Theme.serif(22f, Font.PLAIN); col = Color.WHITE; }
        else if (n.startsWith("lblLightSub")) { f = Theme.sans(11.5f, Font.PLAIN); col = Theme.ON_DARK_MUTED; }
        else if (n.startsWith("lblLightBig")) { f = Theme.serif(30f, Font.PLAIN); col = Color.WHITE; }
        else if (n.startsWith("lblLightB")) { f = Theme.sans(12f, Font.BOLD); col = Color.WHITE; }
        else if (n.startsWith("lblLight")) { f = Theme.sans(12.5f, Font.PLAIN); col = new Color(0xE3EDE5); }
        else if (n.startsWith("lblSub")) { f = Theme.sans(13f, Font.PLAIN); col = Theme.MUTED; }
        else if (n.startsWith("lblHint")) { f = Theme.sans(11.5f, Font.PLAIN); col = Theme.MUTED; }
        else if (n.startsWith("lblH")) f = Theme.serif(17f, Font.PLAIN);
        else if (n.startsWith("lblErr")) { f = Theme.sans(11.5f, Font.PLAIN); col = Theme.CLAY; }
        else if (n.startsWith("lblB")) f = Theme.sans(13f, Font.BOLD);
        else if (n.startsWith("lblField")) f = Theme.sans(12f, Font.BOLD);
        l.setFont(f);
        l.setForeground(col);
    }

    private static void whiteBg(Graphics g0, JComponent c) {
        Graphics2D g = Theme.aa((Graphics2D) g0.create());
        g.setColor(Color.WHITE);
        g.fillRoundRect(1, 1, c.getWidth() - 2, c.getHeight() - 2, 14, 14);
        g.dispose();
    }

    private static void field(JTextField t) {
        t.setOpaque(false);
        t.setFont(Theme.sans(13.5f, Font.PLAIN));
        t.setForeground(Theme.INK);
        t.setCaretColor(Theme.FOREST);
        t.setBorder(new RoundBorder(null, LINE, 14, 10));
        t.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                t.setBorder(new RoundBorder(null, new Color(0x1F6B45), 14, 10, 2));
                t.repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                t.setBorder(new RoundBorder(null, LINE, 14, 10));
                t.repaint();
            }
        });
    }

    private static void combo(JComboBox<?> cb) {
        cb.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = new JButton("▾");
                b.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 10));
                b.setContentAreaFilled(false);
                b.setFocusPainted(false);
                b.setForeground(Theme.MUTED);
                return b;
            }
        });
        cb.setFont(Theme.sans(13.5f, Font.PLAIN));
        cb.setBackground(Color.WHITE);
        cb.setForeground(Theme.INK);
        cb.setBorder(new RoundBorder(null, LINE, 14, 4));
        cb.setOpaque(false);
    }

    private static void bar(JProgressBar pb, String n) {
        Color c = n.startsWith("barNon") ? Theme.GOLD : n.startsWith("barRiver") ? Theme.RIVER : n.startsWith("barWarn") ? Theme.CLAY : n.startsWith("barDark") ? Theme.FOREST : Theme.LEAF;
        pb.setForeground(c);
        pb.setBorderPainted(false);
        pb.setStringPainted(false);
        pb.setOpaque(false);
        pb.setUI(new BasicProgressBarUI() {
            @Override
            protected void paintDeterminate(Graphics g0, JComponent comp) {
                Graphics2D g = Theme.aa((Graphics2D) g0.create());
                int w = comp.getWidth(), h = Math.min(comp.getHeight(), 9), y = (comp.getHeight() - h) / 2;
                g.setColor(new Color(0xECE5D3));
                g.fillRoundRect(0, y, w, h, h, h);
                int fw = (int) (w * pb.getPercentComplete());
                if (fw > 0) {
                    g.setColor(pb.getForeground());
                    g.fillRoundRect(0, y, Math.max(h, fw), h, h, h);
                }
                g.dispose();
            }
        });
    }

    // ------------------------------------------------------------------ pembantu publik
    public static void icon(AbstractButton b, Icons.Name n) {
        Color col = b.getName() != null && b.getName().startsWith("nav") ? Theme.ON_DARK_MUTED : b.getName() != null && (b.getName().startsWith("btnGhost") || b.getName().startsWith("btnLink")) ? Theme.FOREST : Color.WHITE;
        if (b.getName() != null && b.getName().startsWith("btnGold")) col = Theme.INK;
        b.setIcon(Icons.of(n, 18, col));
    }

    public static void icon(JLabel l, Icons.Name n, Color c) {
        l.setIcon(Icons.of(n, 20, c));
    }

    /** Label petunjuk validasi diberi warna peringatan (teks diisi saat input tidak valid). */
    public static void hintError(JLabel... ls) {
        for (JLabel l : ls) l.setForeground(Theme.CLAY);
    }

    /** Warna sidebar tiap peran. */
    public static void sidebar(JPanel p, Color dark) {
        p.setOpaque(true);
        p.setBackground(dark);
    }

    // ------------------------------------------------------------------ border membulat
    public static final class RoundBorder extends AbstractBorder {
        private final Color fill, line;
        private final int arc, pad, stroke;

        public RoundBorder(Color fill, Color line, int arc, int pad) {
            this(fill, line, arc, pad, 1);
        }

        public RoundBorder(Color fill, Color line, int arc, int pad, int stroke) {
            this.fill = fill;
            this.line = line;
            this.arc = arc;
            this.pad = pad;
            this.stroke = stroke;
        }

        @Override
        public void paintBorder(Component c, Graphics g0, int x, int y, int w, int h) {
            Graphics2D g = Theme.aa((Graphics2D) g0.create());
            if (fill != null) {
                g.setColor(fill);
                g.fillRoundRect(x, y, w - 1, h - 1, arc, arc);
            }
            if (line != null) {
                g.setColor(line);
                g.setStroke(new BasicStroke(stroke));
                g.drawRoundRect(x + stroke / 2, y + stroke / 2, w - 1 - stroke, h - 1 - stroke, arc, arc);
            }
            g.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(pad, pad + 2, pad, pad + 2);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets i) {
            i.set(pad, pad + 2, pad, pad + 2);
            return i;
        }
    }

    // ------------------------------------------------------------------ UI tombol
    private static final class FlatTabsUI extends javax.swing.plaf.basic.BasicTabbedPaneUI {
        @Override
        protected void installDefaults() {
            super.installDefaults();
            tabInsets = new Insets(8, 16, 8, 16);
            contentBorderInsets = new Insets(1, 0, 0, 0);
            tabAreaInsets = new Insets(0, 0, 0, 0);
            selectedTabPadInsets = new Insets(0, 0, 0, 0);
        }

        @Override
        protected void paintTabBackground(Graphics g, int tp, int i, int x, int y, int w, int h, boolean sel) {
        }

        @Override
        protected void paintTabBorder(Graphics g, int tp, int i, int x, int y, int w, int h, boolean sel) {
            if (sel) {
                g.setColor(Theme.FOREST);
                g.fillRect(x + 6, y + h - 3, w - 12, 3);
            }
        }

        @Override
        protected void paintContentBorder(Graphics g, int tp, int sel) {
            g.setColor(Theme.BORDER);
            g.fillRect(0, calculateTabAreaHeight(tp, runCount, maxTabHeight) - 1, tabPane.getWidth(), 1);
        }

        @Override
        protected void paintFocusIndicator(Graphics g, int tp, Rectangle[] r, int i, Rectangle ir, Rectangle tr, boolean sel) {
        }

        @Override
        protected void paintText(Graphics g, int tp, Font font, FontMetrics m, int i, String title, Rectangle tr, boolean sel) {
            g.setFont(font);
            g.setColor(sel ? Theme.FOREST : Theme.MUTED);
            g.drawString(title, tr.x, tr.y + m.getAscent());
        }
    }

    private static final class PillUI extends BasicButtonUI {
        private final String kind;

        PillUI(String name) {
            this.kind = name.startsWith("btnGhost") ? "ghost" : name.startsWith("btnDanger") ? "danger" : name.startsWith("btnGold") ? "gold"
                    : name.startsWith("btnLink") ? "link" : name.startsWith("btnLight") ? "light" : "primary";
        }

        @Override
        public void paint(Graphics g0, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            Graphics2D g = Theme.aa((Graphics2D) g0.create());
            boolean hot = b.getModel().isRollover() || b.getModel().isPressed();
            Color bg = switch (kind) {
                case "ghost" -> hot ? new Color(0xEFE9D8) : new Color(0xFFFFFF, false);
                case "danger" -> hot ? new Color(0xA94622) : Theme.CLAY;
                case "gold" -> hot ? new Color(0xC28F12) : Theme.GOLD;
                case "light" -> hot ? new Color(0xE9EFE9) : new Color(0xFBFAF6);
                case "link" -> null;
                default -> hot ? new Color(0x2B6A4F) : Theme.FOREST;
            };
            Color fg = switch (kind) {
                case "ghost", "link" -> Theme.FOREST;
                case "gold" -> Theme.INK;
                case "light" -> Theme.FOREST;
                default -> Color.WHITE;
            };
            int w = c.getWidth(), h = c.getHeight();
            if (bg != null) {
                g.setColor(bg);
                g.fillRoundRect(0, 0, w - 1, h - 1, 14, 14);
            }
            if (kind.equals("ghost")) {
                g.setColor(new Color(0xCFC7B0));
                g.drawRoundRect(0, 0, w - 1, h - 1, 14, 14);
            }
            b.setForeground(fg);
            g.dispose();
            super.paint(g0, c);
        }
    }

    private static final class NavUI extends BasicToggleButtonUI {
        @Override
        public void paint(Graphics g0, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            Graphics2D g = Theme.aa((Graphics2D) g0.create());
            boolean on = b.isSelected();
            if (on || b.getModel().isRollover()) {
                g.setColor(new Color(255, 255, 255, on ? 34 : 16));
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 14, 14);
            }
            if (on && b.getClientProperty("tanpaPenanda") == null) {
                g.setColor(Theme.GOLD);
                g.fillRoundRect(0, 8, 4, c.getHeight() - 16, 4, 4);
            }
            b.setForeground(on ? Color.WHITE : Theme.ON_DARK);
            g.dispose();
            super.paint(g0, c);
        }
    }

    private static final class SegUI extends BasicToggleButtonUI {
        @Override
        public void paint(Graphics g0, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            Graphics2D g = Theme.aa((Graphics2D) g0.create());
            g.setColor(b.isSelected() ? Theme.FOREST : new Color(0xF1EDE0));
            g.fillRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 14, 14);
            b.setForeground(b.isSelected() ? Color.WHITE : new Color(0x59655B));
            g.dispose();
            super.paint(g0, c);
        }
    }

    /** Ikon yang menggambar gambarnya memenuhi seluruh area label (skala "cover"), ukuran pilihan tetap sama dengan gambar asli. */
    private static final class CoverIcon implements Icon {
        private final ImageIcon src;

        CoverIcon(ImageIcon src) {
            this.src = src;
        }

        @Override
        public int getIconWidth() {
            return src.getIconWidth();
        }

        @Override
        public int getIconHeight() {
            return src.getIconHeight();
        }

        @Override
        public void paintIcon(Component comp, Graphics g, int x, int y) {
            int w = comp.getWidth(), h = comp.getHeight();
            int iw = src.getIconWidth(), ih = src.getIconHeight();
            if (w <= 0 || h <= 0 || iw <= 0 || ih <= 0) return;
            double k = Math.max((double) w / iw, (double) h / ih);
            int dw = (int) Math.ceil(iw * k), dh = (int) Math.ceil(ih * k);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setClip(0, 0, w, h);
            g2.drawImage(src.getImage(), (w - dw) / 2, (h - dh) / 2, dw, dh, null);
            g2.dispose();
        }
    }
}
