package view.util;

import javax.swing.*;
import java.awt.*;

/** Pembantu dialog dan penanda titik sambung backend. */
public final class Dialogs {

    private Dialogs() {
    }

    public static void error(Component parent, String pesan) {
        JOptionPane.showMessageDialog(parent, pesan, "AGROVA", JOptionPane.ERROR_MESSAGE);
    }

    /** Tampilkan galat dari backend (pesan sudah siap dibaca pengguna). */
    public static void gagal(Component parent, Exception e) {
        error(parent, e.getMessage() == null ? e.toString() : e.getMessage());
    }

    /** Jalankan aksi backend; bila gagal tampilkan pesannya. @return true bila berhasil. */
    public static boolean coba(Component parent, Runnable aksi) {
        try {
            aksi.run();
            return true;
        } catch (RuntimeException e) {
            gagal(parent, e);
            return false;
        }
    }

    /** Dipanggil tombol yang belum disambung. GuiController: ganti pemanggilan ini dengan logika sebenarnya. */
    public static void todo(Component parent, String aksi) {
        JOptionPane.showMessageDialog(parent, "Aksi \"" + aksi + "\" belum disambungkan ke backend.\n(TODO backend)", "AGROVA", JOptionPane.INFORMATION_MESSAGE);
    }

    public static Frame owner(Component c) {
        Window w = SwingUtilities.getWindowAncestor(c);
        return w instanceof Frame f ? f : null;
    }

    public static void info(Component parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, "AGROVA", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(Component parent, String msg) {
        return JOptionPane.showConfirmDialog(parent, msg, "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
