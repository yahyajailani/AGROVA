package view.util;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import javax.swing.*;

/**
 * Pemilih tanggal berupa kalender kecil. Dipasang pada JTextField biasa: kolom tidak bisa diketik,
 * klik kolom atau ikon kalender di dalamnya untuk memilih tanggal. Hasil berformat dd-MM-yyyy.
 */
public final class DatePicker {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final String[] BULAN = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli",
        "Agustus", "September", "Oktober", "November", "Desember"};
    private static final String[] HARI = {"Sen", "Sel", "Rab", "Kam", "Jum", "Sab", "Min"};

    private DatePicker() {
    }

    /** Pasang kalender pada kolom. Panggil SETELAH Styler.apply (Styler mengganti tampilan kolom). */
    public static void pasang(JTextField f) {
        f.setEditable(false);
        f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        f.setToolTipText("Klik untuk memilih tanggal");

        JButton ikon = new JButton(new KalenderIcon());
        ikon.setName("ikonKalender");
        ikon.setFocusable(false);
        ikon.setBorderPainted(false);
        ikon.setContentAreaFilled(false);
        ikon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ikon.setPreferredSize(new Dimension(40, 36));
        f.setLayout(new BorderLayout());
        f.add(ikon, BorderLayout.EAST);
        f.setBorder(BorderFactory.createCompoundBorder(f.getBorder(), BorderFactory.createEmptyBorder(0, 0, 0, 40)));

        Runnable buka = () -> tampilkan(f);
        ikon.addActionListener(e -> buka.run());
        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buka.run();
            }
        });
    }

    /** Tanggal yang sedang dipilih pada kolom, atau null bila kosong. */
    public static LocalDate nilai(JTextField f) {
        try {
            return LocalDate.parse(f.getText().trim(), FORMAT);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private static void tampilkan(JTextField f) {
        LocalDate dipilih = nilai(f);
        JPopupMenu menu = new JPopupMenu();
        menu.setBorder(BorderFactory.createLineBorder(Theme.BORDER));
        menu.setBackground(Theme.SURFACE);
        menu.add(new Kalender(f, menu, dipilih));
        menu.show(f, 0, f.getHeight() + 2);
    }

    /** Panel kalender bulanan. */
    private static final class Kalender extends JPanel {
        private final JTextField kolom;
        private final JPopupMenu menu;
        private final LocalDate dipilih;
        private YearMonth bulan;
        private final JLabel judul = new JLabel("", SwingConstants.CENTER);
        private final JPanel grid = new JPanel(new GridLayout(7, 7, 2, 2));

        Kalender(JTextField kolom, JPopupMenu menu, LocalDate dipilih) {
            super(new BorderLayout(0, 8));
            this.kolom = kolom;
            this.menu = menu;
            this.dipilih = dipilih;
            this.bulan = YearMonth.from(dipilih != null ? dipilih : LocalDate.now());
            setBackground(Theme.SURFACE);
            setBorder(BorderFactory.createEmptyBorder(12, 12, 10, 12));

            JPanel atas = new JPanel(new BorderLayout());
            atas.setOpaque(false);
            JButton prev = panah("‹", -1);
            JButton next = panah("›", 1);
            judul.setFont(Theme.serif(16f, Font.PLAIN));
            judul.setForeground(Theme.INK);
            atas.add(prev, BorderLayout.WEST);
            atas.add(judul, BorderLayout.CENTER);
            atas.add(next, BorderLayout.EAST);
            add(atas, BorderLayout.NORTH);

            grid.setOpaque(false);
            add(grid, BorderLayout.CENTER);

            JPanel bawah = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 0));
            bawah.setOpaque(false);
            JButton hariIni = tautan("Hari ini");
            hariIni.addActionListener(e -> pilih(LocalDate.now()));
            JButton hapus = tautan("Kosongkan");
            hapus.addActionListener(e -> {
                kolom.setText("");
                menu.setVisible(false);
            });
            bawah.add(hariIni);
            bawah.add(hapus);
            add(bawah, BorderLayout.SOUTH);

            setPreferredSize(new Dimension(300, 290));
            isi();
        }

        private JButton panah(String teks, int arah) {
            JButton b = new JButton(teks);
            b.setFont(Theme.sans(20f, Font.BOLD));
            b.setForeground(Theme.FOREST);
            b.setFocusable(false);
            b.setBorderPainted(false);
            b.setContentAreaFilled(false);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            b.setMargin(new Insets(0, 0, 0, 0));
            b.setBorder(BorderFactory.createEmptyBorder());
            b.setPreferredSize(new Dimension(36, 30));
            b.addActionListener(e -> {
                bulan = bulan.plusMonths(arah);
                isi();
            });
            return b;
        }

        private JButton tautan(String teks) {
            JButton b = new JButton(teks);
            b.setFont(Theme.sans(12f, Font.BOLD));
            b.setForeground(Theme.FOREST);
            b.setFocusable(false);
            b.setBorderPainted(false);
            b.setContentAreaFilled(false);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            return b;
        }

        private void pilih(LocalDate d) {
            kolom.setText(d.format(FORMAT));
            menu.setVisible(false);
        }

        private void isi() {
            judul.setText(BULAN[bulan.getMonthValue() - 1] + " " + bulan.getYear());
            grid.removeAll();
            for (String h : HARI) {
                JLabel l = new JLabel(h, SwingConstants.CENTER);
                l.setFont(Theme.sans(11.5f, Font.BOLD));
                l.setForeground(Theme.MUTED);
                grid.add(l);
            }
            int geser = bulan.atDay(1).getDayOfWeek().getValue() - 1; // Senin = 0
            LocalDate mulai = bulan.atDay(1).minusDays(geser);
            LocalDate hari = LocalDate.now();
            for (int k = 0; k < 42; k++) {
                LocalDate d = mulai.plusDays(k);
                boolean bulanIni = YearMonth.from(d).equals(bulan);
                boolean terpilih = d.equals(dipilih);
                JButton b = new JButton(String.valueOf(d.getDayOfMonth())) {
                    @Override
                    protected void paintComponent(Graphics g0) {
                        Graphics2D g = (Graphics2D) g0.create();
                        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        if (terpilih) {
                            g.setColor(Theme.FOREST);
                            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                        } else if (getModel().isRollover()) {
                            g.setColor(Theme.MINT);
                            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                        }
                        if (d.equals(hari) && !terpilih) {
                            g.setColor(Theme.FOREST);
                            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                        }
                        g.dispose();
                        super.paintComponent(g0);
                    }
                };
                b.setFont(Theme.sans(12.5f, terpilih ? Font.BOLD : Font.PLAIN));
                b.setForeground(terpilih ? Color.WHITE : (bulanIni ? Theme.INK : new Color(0xC3C6BC)));
                b.setFocusable(false);
                b.setBorderPainted(false);
                b.setContentAreaFilled(false);
                b.setOpaque(false);
                b.setMargin(new Insets(0, 0, 0, 0));
                b.setBorder(BorderFactory.createEmptyBorder());
                b.setHorizontalAlignment(SwingConstants.CENTER);
                b.setRolloverEnabled(true);
                b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                b.addActionListener(e -> pilih(d));
                grid.add(b);
            }
            grid.revalidate();
            grid.repaint();
        }
    }

    /** Ikon kalender kecil yang digambar sendiri. */
    private static final class KalenderIcon implements Icon {
        @Override public int getIconWidth() { return 18; }
        @Override public int getIconHeight() { return 18; }
        @Override
        public void paintIcon(Component c, Graphics g0, int x, int y) {
            Graphics2D g = (Graphics2D) g0.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(Theme.FOREST);
            g.setStroke(new BasicStroke(1.6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g.drawRoundRect(x + 1, y + 3, 15, 13, 3, 3);
            g.drawLine(x + 1, y + 7, x + 16, y + 7);
            g.drawLine(x + 5, y + 1, x + 5, y + 4);
            g.drawLine(x + 12, y + 1, x + 12, y + 4);
            g.fillOval(x + 5, y + 10, 2, 2);
            g.fillOval(x + 9, y + 10, 2, 2);
            g.dispose();
        }
    }
}
