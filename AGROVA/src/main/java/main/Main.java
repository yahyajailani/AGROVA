/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;


/**
 *
 * @author ASUS FC
 */
import view.frmBeranda;
import view.util.Theme;
import controller.GuiController;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/** AGROVA - titik masuk program (satu-satunya main). Menjalankan tampilan GUI. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        Theme.install();
        SwingUtilities.invokeLater(() -> {
            String galat = GuiController.ujiKoneksi();
            if (galat != null) {
                JOptionPane.showMessageDialog(null,
                        "Gagal terhubung ke database:\n" + galat
                        + "\n\nPastikan MySQL menyala dan database 'agrova' sudah di-import."
                        + "\nUser/password diatur di config/Koneksi.java.",
                        "AGROVA", JOptionPane.WARNING_MESSAGE);
            }
            new frmBeranda().setVisible(true);
        });
    }
}
