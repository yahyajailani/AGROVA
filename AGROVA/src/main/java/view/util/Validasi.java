package view.util;

import java.util.regex.Pattern;

/**
 * Aturan validasi input yang dipakai bersama oleh semua form. Setiap method mengembalikan
 * pesan kesalahan (String) atau null bila isian sudah benar, sehingga mudah dipasang ke label hint.
 */
public final class Validasi {
    private Validasi() {
    }

    // Pattern khusus untuk nama pengguna email (hanya huruf, angka, titik, underscore, tanpa spasi/domain)
    private static final Pattern USERNAME_EMAIL = Pattern.compile("^[a-z0-9._]+$");

    public static String wajib(String v, String label) {
        return v == null || v.isBlank() ? label + " wajib diisi" : null;
    }

// Validasi email lengkap Petani (wajib berakhiran @petani.com)
    public static String emailPetani(String v) {
        if (v == null || v.isBlank()) return "Email wajib diisi";
        String email = v.trim().toLowerCase();
        if (!email.endsWith("@petani.com")) {
            return "Email harus menggunakan domain @petani.com";
        }
        if (!email.matches("^[a-z0-9._%+-]+@petani\\.com$")) {
            return "Format email tidak valid";
        }
        return null;
    }

    // Validasi email lengkap Penyalur (wajib berakhiran @kios.com)
    public static String emailPenyalur(String v) {
        if (v == null || v.isBlank()) return "Email wajib diisi";
        String email = v.trim().toLowerCase();
        if (!email.endsWith("@kios.com")) {
            return "Email harus menggunakan domain @kios.com";
        }
        if (!email.matches("^[a-z0-9._%+-]+@kios\\.com$")) {
            return "Format email tidak valid";
        }
        return null;
    }
    
    public static String sandi(String v) {
        if (v == null || v.isEmpty()) return "Kata sandi wajib diisi";
        if (v.length() < 6) return "Kata sandi minimal 6 karakter";
        return null;
    }

    /** Sandi untuk pendaftaran: minimal 8 karakter dan memuat huruf serta angka. */
    public static String sandiBaru(String v) {
        if (v == null || v.isEmpty()) return "Kata sandi wajib diisi";
        if (v.length() < 8) return "Minimal 8 karakter, ada huruf dan angka";
        if (!v.matches(".*[A-Za-z].*") || !v.matches(".*\\d.*")) return "Minimal 8 karakter, ada huruf dan angka";
        return null;
    }

    public static String konfirmasiSandi(String sandi, String ulang) {
        if (ulang == null || ulang.isEmpty()) return "Ulangi kata sandi";
        return ulang.equals(sandi) ? null : "Kata sandi tidak sama";
    }

    /** Nama orang: huruf, spasi, titik, apostrof, tanda hubung; minimal 3 karakter. */
    public static String nama(String v, String label) {
        if (v == null || v.isBlank()) return label + " wajib diisi";
        String t = v.trim();
        if (t.length() < 3) return label + " minimal 3 karakter";
        if (!t.matches("^[A-Za-z][A-Za-z .'-]*$")) return label + " hanya boleh huruf";
        return null;
    }

    /** NIK harus tepat 16 digit. */
    public static String nik(String v) {
        if (v == null || v.isBlank()) return "NIK wajib diisi";
        return v.matches("\\d{16}") ? null : "NIK harus 16 digit angka";
    }

    /** Nomor telepon Indonesia: diawali 08, hanya angka, 10 sampai 13 digit. */
    public static String telepon(String v) {
        if (v == null || v.isBlank()) return "Nomor telepon wajib diisi";
        if (!v.matches("\\d+")) return "Nomor telepon hanya boleh angka";
        if (!v.startsWith("08")) return "Nomor telepon harus diawali 08";
        if (v.length() < 10) return "Nomor telepon minimal 10 digit";
        if (v.length() > 13) return "Nomor telepon maksimal 13 digit";
        return null;
    }

    /** Angka bulat positif dalam rentang [min, max]. */
    public static String angka(String v, String label, long min, long max) {
        if (v == null || v.isBlank()) return label + " wajib diisi";
        if (!v.matches("\\d{1,12}")) return label + " harus berupa angka";
        long n = Long.parseLong(v);
        if (n < min) return label + " minimal " + min;
        if (n > max) return label + " maksimal " + max;
        return null;
    }

    /** Desimal positif (titik sebagai pemisah), mis. luas lahan. */
    public static String desimal(String v, String label, double min, double max) {
        if (v == null || v.isBlank()) return label + " wajib diisi";
        try {
            double d = Double.parseDouble(v);
            if (d < min) return label + " minimal " + min;
            if (d > max) return label + " maksimal " + max;
            return null;
        } catch (NumberFormatException e) {
            return label + " tidak valid";
        }
    }

    /** Tanggal yyyy-MM-dd yang benar-benar ada di kalender. */
    public static String tanggal(String v, String label) {
        if (v == null || v.isBlank()) return label + " wajib diisi";
        try {
            java.time.LocalDate.parse(v.trim());
            return null;
        } catch (java.time.format.DateTimeParseException e) {
            return label + " tidak valid (gunakan tahun-bulan-tanggal)";
        }
    }

    /** Pilihan combo box wajib dipilih (indeks 0 atau teks "Pilih..." dianggap kosong). */
    public static String pilihan(Object v, String label) {
        if (v == null) return label + " wajib dipilih";
        String s = v.toString().trim();
        return s.isEmpty() || s.startsWith("Pilih") || s.equals("...") ? label + " wajib dipilih" : null;
    }
}
