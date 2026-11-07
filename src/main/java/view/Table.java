package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Format tabel teks untuk tampilan dan pdf
public final class Table {
    private static final int MAX_COL = 38;

    private Table() { }

    public static String cell(Object v) {
        if (v == null) {
            return "-";
        }
        String s = v.toString().replace('\r', ' ').replace('\n', ' ').trim();
        return s.isEmpty() ? "-" : s;
    }

    public static List<String> format(List<Map<String, Object>> rows) {
        List<String> out = new ArrayList<>();
        if (rows == null || rows.isEmpty()) {
            out.add("(Tidak ada data)");
            return out;
        }
        List<String> cols = new ArrayList<>(rows.get(0).keySet());
        int[] w = new int[cols.size()];
        for (int i = 0; i < cols.size(); i++) {
            w[i] = cols.get(i).length();
        }
        for (Map<String, Object> r : rows) {
            for (int i = 0; i < cols.size(); i++) {
                w[i] = Math.max(w[i], Math.min(MAX_COL, cell(r.get(cols.get(i))).length()));
            }
        }
        StringBuilder sep = new StringBuilder("+");
        for (int x : w) {
            sep.append("-".repeat(x + 2)).append("+");
        }
        out.add(sep.toString());
        out.add(line(cols, w));
        out.add(sep.toString());
        for (Map<String, Object> r : rows) {
            List<String> vals = new ArrayList<>();
            for (String c : cols) {
                vals.add(cell(r.get(c)));
            }
            out.add(line(vals, w));
        }
        out.add(sep.toString());
        out.add(rows.size() + " baris");
        return out;
    }

    private static String line(List<String> vals, int[] w) {
        StringBuilder sb = new StringBuilder("|");
        for (int i = 0; i < vals.size(); i++) {
            String s = vals.get(i);
            if (s.length() > w[i]) {
                s = s.substring(0, Math.max(0, w[i] - 1)) + "~";
            }
            sb.append(' ').append(s).append(" ".repeat(w[i] - s.length())).append(" |");
        }
        return sb.toString();
    }
}

