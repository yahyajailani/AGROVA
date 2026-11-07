package view.util;

import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;
import java.awt.Toolkit;
import java.util.regex.Pattern;
import java.util.function.UnaryOperator;

/**
 * Pembatas karakter saat mengetik/menempel. Karakter yang tidak diizinkan ditolak (disertai bunyi beep),
 * sehingga isian "aneh" tidak pernah masuk ke kolom. Validasi akhir tetap dilakukan di lapisan service.
 *
 * Contoh di NetBeans (konstruktor form, setelah initComponents()):
 *     InputFilters.digits(txtNik, 16);
 */
public final class InputFilters {

    private InputFilters() {
    }

    /** Hanya angka 0-9, panjang maksimal {@code max}. (NIK, jumlah kg, kuota) */
    public static void digits(JTextComponent c, int max) {
        install(c, max, Pattern.compile("^\\d*$"), UnaryOperator.identity());
    }

    /** Tanggal hari-bulan-tahun (mis. 1-3-2026 atau 01-03-2026): maksimal 2 digit hari, 2 digit bulan, 4 digit tahun. */
    public static void tanggal(JTextComponent c) {
        install(c, 10, Pattern.compile("^\\d{0,2}(-\\d{0,2}(-\\d{0,4})?)?$"), UnaryOperator.identity());
    }

    /** Angka desimal dengan titik; koma otomatis diubah jadi titik. (luas lahan) */
    public static void decimal(JTextComponent c, int maxInt, int maxFrac) {
        install(c, maxInt + maxFrac + 1, Pattern.compile("^\\d{0," + maxInt + "}(\\.\\d{0," + maxFrac + "})?$"),
                s -> s.replace(',', '.'));
    }

    /** Huruf A-Z, spasi, titik, apostrof, tanda hubung. (nama orang) */
    public static void nama(JTextComponent c, int max) {
        install(c, max, Pattern.compile("^[A-Za-z .'-]*$"), UnaryOperator.identity());
    }

    /** Karakter yang lazim untuk email; tanpa spasi. */
    public static void email(JTextComponent c, int max) {
        install(c, max, Pattern.compile("^[A-Za-z0-9._%+@-]*$"), UnaryOperator.identity());
    }

    /** ASCII tercetak tanpa spasi (untuk JPasswordField). */
    public static void password(JTextComponent c, int max) {
        install(c, max, Pattern.compile("^[\\x21-\\x7E]*$"), UnaryOperator.identity());
    }

    /** Nomor PO: huruf besar, angka, tanda hubung; huruf kecil otomatis jadi besar. */
    public static void noPo(JTextComponent c, int max) {
        install(c, max, Pattern.compile("^[A-Z0-9-]*$"), String::toUpperCase);
    }

    /** Kata kunci pencarian yang aman. */
    public static void keyword(JTextComponent c, int max) {
        install(c, max, Pattern.compile("^[A-Za-z0-9 .@-]*$"), UnaryOperator.identity());
    }

    private static void install(JTextComponent c, int max, Pattern allowed, UnaryOperator<String> transform) {
        if (!(c.getDocument() instanceof AbstractDocument doc)) return;
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                replace(fb, offset, 0, text, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String add = text == null ? "" : transform.apply(text);
                String current = fb.getDocument().getText(0, fb.getDocument().getLength());
                String next = current.substring(0, offset) + add + current.substring(offset + length);
                if (next.length() <= max && allowed.matcher(next).matches()) {
                    super.replace(fb, offset, length, add, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        // tempel (paste) teks kotor juga lewat filter yang sama, tidak perlu penanganan tambahan
        c.putClientProperty("agrova.filtered", Boolean.TRUE);
    }
}
