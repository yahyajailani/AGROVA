package view.util;

import javax.swing.*;
import java.awt.*;

/** Perekat navigasi: tombol menu (JToggleButton) menampilkan kartu halaman (JPanel form) pada panel ber-CardLayout. */
public final class Nav {
    private Nav() {
    }

    public static void bind(JPanel host, JToggleButton[] buttons, JPanel[] pages) {
        host.setLayout(new CardLayout());
        ButtonGroup g = new ButtonGroup();
        for (int i = 0; i < pages.length; i++) {
            host.add(pages[i], "p" + i);
            g.add(buttons[i]);
            final int idx = i;
            buttons[i].addActionListener(e -> ((CardLayout) host.getLayout()).show(host, "p" + idx));
        }
        buttons[0].setSelected(true);
        ((CardLayout) host.getLayout()).show(host, "p0");
    }

    public static void group(AbstractButton... bs) {
        ButtonGroup g = new ButtonGroup();
        for (AbstractButton b : bs) g.add(b);
        bs[0].setSelected(true);
    }
}
