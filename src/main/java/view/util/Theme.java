package view.util;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Tema "Sawah Teras": kertas krem hangat, hijau hutan, emas padi, biru sungai Mahakam.
 * Semua warna dan font dipusatkan di sini supaya mudah diubah dari satu tempat.
 */
public final class Theme {

    private Theme() {
    }

    // ---- permukaan
    public static final Color PAPER = new Color(0xF6F1E7);      // latar halaman
    public static final Color SURFACE = new Color(0xFFFDF8);    // kartu
    public static final Color SURFACE_ALT = new Color(0xFAF6EC); // baris zebra / input
    public static final Color BORDER = new Color(0xE7DFCC);

    // ---- teks
    public static final Color INK = new Color(0x1D2A22);
    public static final Color MUTED = new Color(0x7A7F73);
    public static final Color ON_DARK = new Color(0xF3EEDF);
    public static final Color ON_DARK_MUTED = new Color(0xB5C7B7);

    // ---- merek
    public static final Color FOREST = new Color(0x1F4D3A);
    public static final Color FOREST_DARK = new Color(0x143528);
    public static final Color FOREST_DEEP = new Color(0x0E2A20);
    public static final Color MINT = new Color(0xDCEBDD);

    // ---- makna data
    public static final Color LEAF = new Color(0x4E9F5D);   // subsidi
    public static final Color GOLD = new Color(0xD9A21B);   // non-subsidi
    public static final Color RIVER = new Color(0x2F7F9E);  // dalam pengiriman
    public static final Color CLAY = new Color(0xC4572F);   // peringatan / batal
    public static final Color SLATE = new Color(0x8A9388);  // menunggu / netral

    private static final Set<String> FAMILIES = new HashSet<>(Arrays.asList(
            GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));

    private static final String SANS = pick("Segoe UI", "Inter", "Carlito", "Helvetica Neue", "DejaVu Sans", Font.SANS_SERIF);
    private static final String SERIF = pick("Georgia", "Cambria", "Caladea", "DejaVu Serif", Font.SERIF);

    private static String pick(String... names) {
        for (String n : names) if (FAMILIES.contains(n)) return n;
        return names[names.length - 1];
    }

    public static Font sans(float size, int style) {
        return new Font(SANS, style, 1).deriveFont(style, size);
    }

    public static Font serif(float size, int style) {
        return new Font(SERIF, style, 1).deriveFont(style, size);
    }

    public static Color alpha(Color c, int a) {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), Math.max(0, Math.min(255, a)));
    }

    public static Color mix(Color a, Color b, float t) {
        t = Math.max(0f, Math.min(1f, t));
        return new Color(
                Math.round(a.getRed() + (b.getRed() - a.getRed()) * t),
                Math.round(a.getGreen() + (b.getGreen() - a.getGreen()) * t),
                Math.round(a.getBlue() + (b.getBlue() - a.getBlue()) * t));
    }

    public static Graphics2D aa(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        return g;
    }

    /** Memasang tema ke komponen Swing standar (JTextField, JComboBox, JOptionPane, dst.). Panggil sekali di main(). */
    private static boolean installed;

    public static void install() {
        if (installed) {
            return;
        }
        installed = true;
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
            // tetap pakai look and feel bawaan
        }
        UIManager.put("control", new ColorUIResource(SURFACE));
        UIManager.put("nimbusBase", new ColorUIResource(FOREST));
        UIManager.put("nimbusBlueGrey", new ColorUIResource(0xC9C2AE));
        UIManager.put("nimbusFocus", new ColorUIResource(LEAF));
        UIManager.put("nimbusSelectionBackground", new ColorUIResource(0xCFE5D2));
        UIManager.put("nimbusSelectedText", new ColorUIResource(INK));
        UIManager.put("text", new ColorUIResource(INK));
        UIManager.put("nimbusLightBackground", new ColorUIResource(SURFACE));
        UIManager.put("OptionPane.background", new ColorUIResource(SURFACE));
        UIManager.put("Panel.background", new ColorUIResource(SURFACE));
        UIManager.put("defaultFont", new FontUIResource(sans(13f, Font.PLAIN)));
    }
}
