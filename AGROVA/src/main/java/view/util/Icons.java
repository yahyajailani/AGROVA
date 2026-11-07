package view.util;

import javax.swing.Icon;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Ikon vektor digambar dengan Java2D pada kisi 24x24. Tidak bergantung pada font emoji / file gambar,
 * sehingga tampil sama di Windows, Linux, maupun macOS dan tajam di layar HiDPI.
 */
public final class Icons {

    public enum Name {
        DASHBOARD, DATA, LIST, REPORT, BOX, TRUCK, USERS, LEAF, WAREHOUSE, CHECK, SEARCH, BELL,
        LOGOUT, PLUS, ARROW, CLOCK, PIN, HOME, SPROUT, LOCK, HISTORY, MAIL
    }

    private Icons() {
    }

    public static Icon of(Name name, int size, Color color) {
        return new VectorIcon(name, size, color);
    }

    private static final class VectorIcon implements Icon {
        private final Name name;
        private final int size;
        private final Color color;

        VectorIcon(Name name, int size, Color color) {
            this.name = name;
            this.size = size;
            this.color = color;
        }

        @Override
        public int getIconWidth() {
            return size;
        }

        @Override
        public int getIconHeight() {
            return size;
        }

        @Override
        public void paintIcon(Component c, Graphics g0, int x, int y) {
            Graphics2D g = (Graphics2D) g0.create();
            try {
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
                g.translate(x, y);
                double s = size / 24.0;
                g.scale(s, s);
                g.setColor(color);
                g.setStroke(new BasicStroke(1.8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                draw(g, name);
            } finally {
                g.dispose();
            }
        }
    }

    private static RoundRectangle2D rr(double x, double y, double w, double h, double r) {
        return new RoundRectangle2D.Double(x, y, w, h, r * 2, r * 2);
    }

    private static Line2D ln(double x1, double y1, double x2, double y2) {
        return new Line2D.Double(x1, y1, x2, y2);
    }

    private static Path2D poly(boolean close, double... p) {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(p[0], p[1]);
        for (int i = 2; i < p.length; i += 2) path.lineTo(p[i], p[i + 1]);
        if (close) path.closePath();
        return path;
    }

    private static void draw(Graphics2D g, Name n) {
        switch (n) {
            case DASHBOARD -> {
                g.draw(rr(3.5, 3.5, 7, 7, 2));
                g.draw(rr(13.5, 3.5, 7, 7, 2));
                g.draw(rr(3.5, 13.5, 7, 7, 2));
                g.draw(rr(13.5, 13.5, 7, 7, 2));
            }
            case DATA -> {
                g.draw(new Ellipse2D.Double(4, 3, 16, 5.5));
                g.draw(new Arc2D.Double(4, 8.5, 16, 5.5, 180, 180, Arc2D.OPEN));
                g.draw(new Arc2D.Double(4, 14, 16, 5.5, 180, 180, Arc2D.OPEN));
                g.draw(ln(4, 5.75, 4, 16.75));
                g.draw(ln(20, 5.75, 20, 16.75));
            }
            case LIST -> {
                g.draw(rr(5, 3.5, 14, 17.5, 2.5));
                g.draw(ln(9, 8.5, 15, 8.5));
                g.draw(ln(9, 12.5, 15, 12.5));
                g.draw(ln(9, 16.5, 12.5, 16.5));
            }
            case REPORT -> {
                g.draw(poly(true, 6, 3, 14, 3, 19, 8, 19, 21, 6, 21));
                g.draw(poly(false, 14, 3, 14, 8, 19, 8));
                g.draw(ln(9, 13, 16, 13));
                g.draw(ln(9, 17, 16, 17));
            }
            case BOX -> {
                g.draw(poly(true, 12, 3, 20, 7.5, 20, 16.5, 12, 21, 4, 16.5, 4, 7.5));
                g.draw(poly(false, 4, 7.5, 12, 12, 20, 7.5));
                g.draw(ln(12, 12, 12, 21));
            }
            case TRUCK -> {
                g.draw(poly(false, 14, 16.5, 2.5, 16.5, 2.5, 6.5, 14, 6.5, 14, 16.5));
                g.draw(poly(false, 14, 10, 18, 10, 21.5, 13.2, 21.5, 16.5, 14, 16.5));
                g.draw(new Ellipse2D.Double(5, 15.5, 4, 4));
                g.draw(new Ellipse2D.Double(15, 15.5, 4, 4));
            }
            case USERS -> {
                g.draw(new Ellipse2D.Double(8.5, 3.5, 7, 7));
                g.draw(new Arc2D.Double(4.5, 13.5, 15, 14, 0, 180, Arc2D.OPEN));
            }
            case LEAF -> {
                Path2D.Double p = new Path2D.Double();
                p.moveTo(5, 19);
                p.curveTo(4.5, 10, 10, 4.5, 20, 4);
                p.curveTo(20, 13.5, 15, 19.5, 5, 19);
                g.draw(p);
                g.draw(ln(5, 19, 13, 11));
            }
            case SPROUT -> {
                g.draw(ln(12, 21, 12, 11));
                Path2D.Double a = new Path2D.Double();
                a.moveTo(12, 13);
                a.curveTo(12, 8.5, 8.5, 6.5, 4.5, 7);
                a.curveTo(4.5, 11, 7.5, 13.5, 12, 13);
                g.draw(a);
                Path2D.Double b = new Path2D.Double();
                b.moveTo(12, 11);
                b.curveTo(12, 6.5, 15.5, 4, 19.5, 4.5);
                b.curveTo(19.5, 8.5, 16.5, 11.5, 12, 11);
                g.draw(b);
            }
            case WAREHOUSE -> {
                g.draw(poly(true, 3, 10, 12, 3.5, 21, 10, 21, 20.5, 3, 20.5));
                g.draw(poly(false, 8.5, 20.5, 8.5, 13.5, 15.5, 13.5, 15.5, 20.5));
                g.draw(ln(8.5, 17, 15.5, 17));
            }
            case HOME -> {
                g.draw(poly(false, 3.5, 11, 12, 4, 20.5, 11));
                g.draw(poly(false, 6, 9.5, 6, 20, 18, 20, 18, 9.5));
                g.draw(poly(false, 10, 20, 10, 14, 14, 14, 14, 20));
            }
            case CHECK -> g.draw(poly(false, 5, 12.5, 10, 17.5, 19, 7));
            case SEARCH -> {
                g.draw(new Ellipse2D.Double(4.5, 4.5, 12, 12));
                g.draw(ln(15, 15, 20, 20));
            }
            case BELL -> {
                Path2D.Double p = new Path2D.Double();
                p.moveTo(5.5, 17);
                p.curveTo(7, 15.5, 7, 13, 7, 10.5);
                p.curveTo(7, 7, 9, 5.5, 12, 5.5);
                p.curveTo(15, 5.5, 17, 7, 17, 10.5);
                p.curveTo(17, 13, 17, 15.5, 18.5, 17);
                p.closePath();
                g.draw(p);
                g.draw(ln(12, 3.5, 12, 5.5));
                g.draw(new Arc2D.Double(9.5, 17.5, 5, 4, 180, 180, Arc2D.OPEN));
            }
            case LOGOUT -> {
                g.draw(poly(false, 10, 4, 5, 4, 5, 20, 10, 20));
                g.draw(ln(10, 12, 20, 12));
                g.draw(poly(false, 16, 8, 20, 12, 16, 16));
            }
            case PLUS -> {
                g.draw(ln(12, 5, 12, 19));
                g.draw(ln(5, 12, 19, 12));
            }
            case ARROW -> {
                g.draw(ln(4.5, 12, 19.5, 12));
                g.draw(poly(false, 14, 6.5, 19.5, 12, 14, 17.5));
            }
            case CLOCK -> {
                g.draw(new Ellipse2D.Double(3.5, 3.5, 17, 17));
                g.draw(poly(false, 12, 7.5, 12, 12, 15.5, 14));
            }
            case PIN -> {
                Path2D.Double p = new Path2D.Double();
                p.moveTo(12, 21);
                p.curveTo(6, 14.5, 5, 12, 5, 9.5);
                p.curveTo(5, 5.5, 8.2, 3, 12, 3);
                p.curveTo(15.8, 3, 19, 5.5, 19, 9.5);
                p.curveTo(19, 12, 18, 14.5, 12, 21);
                g.draw(p);
                g.draw(new Ellipse2D.Double(9.5, 7, 5, 5));
            }
            case LOCK -> {
                g.draw(rr(5, 10.5, 14, 10, 2.5));
                g.draw(new Arc2D.Double(8, 3.5, 8, 10, 0, 180, Arc2D.OPEN));
                g.draw(ln(12, 14.5, 12, 17));
            }
            case MAIL -> {
                g.draw(rr(3.5, 5.5, 17, 13, 2.5));
                g.draw(poly(false, 4, 7, 12, 13, 20, 7));
            }
            case HISTORY -> {
                g.draw(new Arc2D.Double(4, 4, 16, 16, 40, 290, Arc2D.OPEN));
                g.draw(poly(false, 12, 8, 12, 12, 15, 13.5));
                g.draw(poly(false, 4.5, 3.5, 4.5, 8, 9, 8));
            }
            default -> {
            }
        }
    }
}
