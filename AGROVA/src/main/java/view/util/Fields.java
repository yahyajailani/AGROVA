package view.util;

import java.awt.*;
import javax.swing.*;

/** Pembantu komponen isian: kolom sandi dengan ikon mata (lihat/sembunyikan sandi). */
public final class Fields {
    private Fields() {
    }

    /** Ikon mata sederhana (digambar), dicoret bila sandi sedang disembunyikan = false. */
    private static final class EyeIcon implements Icon {
        private final boolean terlihat;
        EyeIcon(boolean terlihat) { this.terlihat = terlihat; }
        @Override public int getIconWidth() { return 22; }
        @Override public int getIconHeight() { return 16; }
        @Override
        public void paintIcon(Component c, Graphics g0, int x, int y) {
            Graphics2D g = (Graphics2D) g0.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(terlihat ? Theme.FOREST : Theme.MUTED);
            g.setStroke(new BasicStroke(1.6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g.drawArc(x + 1, y + 1, 20, 18, 0, 180);      // kelopak atas
            g.drawArc(x + 1, y - 3, 20, 18, 180, 180);    // kelopak bawah
            g.fillOval(x + 8, y + 4, 6, 6);               // pupil
            if (!terlihat) g.drawLine(x + 3, y + 14, x + 19, y + 1);
            g.dispose();
        }
    }

    /** Menaruh tombol mata di dalam kolom sandi (satu kotak dengan kolomnya). */
    public static void mataDiDalam(JPasswordField f, AbstractButton mata) {
        f.setLayout(new BorderLayout());
        f.add(mata, BorderLayout.EAST);
        f.setBorder(BorderFactory.createCompoundBorder(f.getBorder(), BorderFactory.createEmptyBorder(0, 0, 0, 40)));
    }

    /** Kolom sandi dengan ikon mata di dalamnya (lihat / sembunyikan sandi). */
    public static JPasswordField sandiDenganMata(JPasswordField f) {
        final char sembunyi = f.getEchoChar() == 0 ? '\u2022' : f.getEchoChar();
        JToggleButton mata = new JToggleButton(new EyeIcon(false));
        mata.setName("mataSandi");
        mata.setToolTipText("Tampilkan / sembunyikan kata sandi");
        mata.setFocusable(false);
        mata.setBorderPainted(false);
        mata.setContentAreaFilled(false);
        mata.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mata.setPreferredSize(new Dimension(40, 36));
        mata.addActionListener(e -> {
            boolean lihat = mata.isSelected();
            f.setEchoChar(lihat ? (char) 0 : sembunyi);
            mata.setIcon(new EyeIcon(lihat));
        });
        mataDiDalam(f, mata);
        return f;
    }

    /** Ikon gambar yang memenuhi seluruh area komponen (dipotong ala "cover"); ukuran awal mengikuti gambar asli. */
    public static Icon penuh(ImageIcon src) {
        return new Icon() {
            @Override public int getIconWidth() { return src.getIconWidth(); }
            @Override public int getIconHeight() { return src.getIconHeight(); }
            @Override
            public void paintIcon(Component c, Graphics g0, int x, int y) {
                Graphics2D g = (Graphics2D) g0.create();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                int cw = c.getWidth(), ch = c.getHeight();
                double k = Math.max(cw / (double) src.getIconWidth(), ch / (double) src.getIconHeight());
                int w = (int) Math.ceil(src.getIconWidth() * k), h = (int) Math.ceil(src.getIconHeight() * k);
                g.drawImage(src.getImage(), (cw - w) / 2, (ch - h) / 2, w, h, null);
                g.dispose();
            }
        };
    }

    /** Mengganti kolom sandi pada panel induknya dengan versi ber-ikon mata (posisi di panel tetap sama). */
    public static void pasangMata(JPasswordField f) {
        Container induk = f.getParent();
        if (induk == null) return;
        int idx = -1;
        for (int i = 0; i < induk.getComponentCount(); i++) if (induk.getComponent(i) == f) idx = i;
        if (idx < 0) return;
        sandiDenganMata(f);
    }
}
