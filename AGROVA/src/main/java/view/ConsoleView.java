package view;

import model.BusinessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConsoleView {
    private static final BufferedReader IN =
            new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

       public static class ExitException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }

    @FunctionalInterface
    public interface Aksi {
        void jalankan() throws Exception;
    }

    //Dasar
    public String readLine(String prompt) {
        System.out.print(prompt);
        System.out.flush();
        try {
            String s = IN.readLine();
            if (s == null) {
                throw new ExitException();
            }
            return s.trim();
        } catch (IOException e) {
            throw new ExitException();
        }
    }

    public void pesan(String teks) {
        System.out.println(teks);
    }

    public void title(String t) {
        System.out.println();
        System.out.println("=".repeat(Math.max(40, t.length() + 6)));
        System.out.println("   " + t);
        System.out.println("=".repeat(Math.max(40, t.length() + 6)));
    }

    
    public void safe(Aksi a) {
        try {
            a.jalankan();
        } catch (ExitException e) {
            throw e;
        } catch (BusinessException e) {
            System.out.println("\n[!] " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("\n[!] Terjadi kesalahan database: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[!] Terjadi kesalahan: " + e);
        }
    }

   
    public int menu(String judul, String... items) {
        while (true) {
            title(judul);
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i]);
            }
            System.out.println("0. Kembali / Keluar");
            String s = readLine("Pilih menu: ");
            try {
                int c = Integer.parseInt(s);
                if (c >= 0 && c <= items.length) {
                    return c;
                }
            } catch (NumberFormatException ignored) {
                // jatuh ke pesan tidak valid
            }
            System.out.println("Pilihan Tidak Valid!");
        }
    }

    //Input
    public String askText(String label, int maxLen) {
        while (true) {
            String s = readLine(label + ": ");
            if (s.isEmpty()) {
                System.out.println("  " + label + " wajib diisi.");
            } else if (s.length() > maxLen) {
                System.out.println("  " + label + " maksimal " + maxLen + " karakter.");
            } else {
                return s;
            }
        }
    }

    public int askInt(String prompt, int min, int max) {
        while (true) {
            String s = readLine(prompt);
            try {
                int v = Integer.parseInt(s);
                if (v >= min && v <= max) {
                    return v;
                }
                System.out.println("  Masukkan angka " + min + " sampai " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("  Input harus berupa angka bulat.");
            }
        }
    }

    
    public int askInt(String prompt) {
        return askInt(prompt, 0, Integer.MAX_VALUE);
    }

    public BigDecimal askDecimal(String prompt, BigDecimal min, BigDecimal max) {
        while (true) {
            String s = readLine(prompt).replace(',', '.');
            try {
                BigDecimal v = new BigDecimal(s);
                if (v.compareTo(min) >= 0 && v.compareTo(max) <= 0) {
                    return v;
                }
                System.out.println("  Masukkan angka " + min + " sampai " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("  Input harus berupa angka (contoh 1.5).");
            }
        }
    }

    public LocalDate askDate(String prompt, LocalDate def) {
        while (true) {
            String s = readLine(prompt + (def != null ? " [Enter = " + def + "]" : "") + " (yyyy-MM-dd): ");
            if (s.isEmpty() && def != null) {
                return def;
            }
            try {
                return LocalDate.parse(s);
            } catch (DateTimeParseException e) {
                System.out.println("  Format tanggal salah. Contoh: 2026-11-02");
            }
        }
    }

    public boolean yesNo(String prompt) {
        while (true) {
            String s = readLine(prompt + " (Ya/Tidak): ").toLowerCase();
            if (s.equals("y") || s.equals("ya") || s.equals("yes") || s.equals("1")) {
                return true;
            }
            if (s.equals("t") || s.equals("tidak") || s.equals("n") || s.equals("no") || s.equals("0")) {
                return false;
            }
            System.out.println("  Jawab dengan Ya atau Tidak.");
        }
    }

    public String askChoice(String prompt, List<String> options, int defIndex) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + options.get(i) + (i == defIndex ? "  (default)" : ""));
        }
        while (true) {
            String s = readLine(prompt + ": ");
            if (s.isEmpty() && defIndex >= 0) {
                return options.get(defIndex);
            }
            try {
                int c = Integer.parseInt(s);
                if (c >= 1 && c <= options.size()) {
                    return options.get(c - 1);
                }
            } catch (NumberFormatException ignored) {
                // ulangi
            }
            System.out.println("  Pilihan Tidak Valid!");
        }
    }

    //Tabel
    public void showTable(String judul, List<Map<String, Object>> rows) {
        System.out.println();
        System.out.println("--- " + judul + " ---");
        for (String l : Table.format(rows)) {
            System.out.println(l);
        }
    }

    public void showKeyValue(String judul, Map<String, Object> row) {
        System.out.println();
        System.out.println("--- " + judul + " ---");
        int w = 0;
        for (String k : row.keySet()) {
            w = Math.max(w, k.length());
        }
        for (Map.Entry<String, Object> e : row.entrySet()) {
            System.out.println("  " + e.getKey() + " ".repeat(w - e.getKey().length()) + " : " + Table.cell(e.getValue()));
        }
    }

    
    public List<Map<String, Object>> showFiltered(String judul, List<Map<String, Object>> rows) {
        showTable(judul, rows);
        if (rows.isEmpty()) {
            return rows;
        }
        List<Map<String, Object>> cur = rows;
        List<String> cols = new ArrayList<>(rows.get(0).keySet());
        while (true) {
            if (!yesNo("Filter tabel?")) {
                return cur;
            }
            System.out.println("Kolom yang bisa difilter:");
            for (int i = 0; i < cols.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + cols.get(i));
            }
            int ci = askInt("Pilih kolom (nomor): ", 1, cols.size()) - 1;
            String kw = readLine("Kata kunci (kosong = tampilkan semua): ").toLowerCase();
            String col = cols.get(ci);
            List<Map<String, Object>> filtered = new ArrayList<>();
            for (Map<String, Object> r : rows) {
                if (kw.isEmpty() || Table.cell(r.get(col)).toLowerCase().contains(kw)) {
                    filtered.add(r);
                }
            }
            cur = filtered;
            showTable(judul + " (terfilter)", cur);
            if (yesNo("Ingin kembali?")) {
                return cur;
            }
        }
    }

    protected static Map<String, Object> kv(Object... pasangan) {
        Map<String, Object> m = new LinkedHashMap<>();
        for (int i = 0; i + 1 < pasangan.length; i += 2) {
            m.put(String.valueOf(pasangan[i]), pasangan[i + 1]);
        }
        return m;
    }
}

