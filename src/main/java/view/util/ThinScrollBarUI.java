package view.util;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;

/** Scrollbar tipis tanpa tombol panah, gaya modern. */
public class ThinScrollBarUI extends BasicScrollBarUI {

    public static void apply(JScrollPane sp) {
        sp.setBorder(null);
        sp.getVerticalScrollBar().setUI(new ThinScrollBarUI());
        sp.getHorizontalScrollBar().setUI(new ThinScrollBarUI());
        sp.getVerticalScrollBar().setPreferredSize(new Dimension(10, 10));
        sp.getHorizontalScrollBar().setPreferredSize(new Dimension(10, 10));
        sp.getVerticalScrollBar().setUnitIncrement(18);
        sp.getVerticalScrollBar().setOpaque(false);
        sp.getHorizontalScrollBar().setOpaque(false);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return zero();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return zero();
    }

    private JButton zero() {
        JButton b = new JButton();
        b.setPreferredSize(new Dimension(0, 0));
        b.setMinimumSize(new Dimension(0, 0));
        b.setMaximumSize(new Dimension(0, 0));
        return b;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        // tanpa track
    }

    @Override
    protected void paintThumb(Graphics g0, JComponent c, Rectangle r) {
        if (r.isEmpty() || !scrollbar.isEnabled()) return;
        Graphics2D g = (Graphics2D) g0.create();
        try {
            Theme.aa(g);
            g.setColor(isDragging || isThumbRollover() ? Theme.alpha(Theme.FOREST, 150) : Theme.alpha(Theme.FOREST, 70));
            g.fill(new RoundRectangle2D.Double(r.x + 2, r.y + 2, r.width - 4, r.height - 4, 8, 8));
        } finally {
            g.dispose();
        }
    }
}
