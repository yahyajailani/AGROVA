package view;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//Membuat pdf tanpa library
public final class PdfReport {
    private static final double W = 842, H = 595, MARGIN = 30;

    private PdfReport() { }

    public static Path write(Path dir, String namaFile, String judul, List<String> tabel) throws IOException {
        Files.createDirectories(dir);
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Path file = dir.resolve(namaFile + "_" + ts + ".pdf");

        List<String> lines = new ArrayList<>();
        lines.add(judul);
        lines.add("Sistem Informasi Pengelolaan Distribusi Pupuk - AGROVA");
        lines.add("Dicetak: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        lines.add("");
        lines.addAll(tabel);

        Files.write(file, build(lines));
        return file;
    }

    static byte[] build(List<String> lines) throws IOException {
        int maxLen = 1;
        for (String l : lines) {
            maxLen = Math.max(maxLen, l.length());
        }
        double font = Math.max(4, Math.min(8, (W - 2 * MARGIN) / (0.6 * maxLen)));
        double lead = font + 2;
        int perPage = (int) ((H - 2 * MARGIN - 15) / lead);

        List<List<String>> pages = new ArrayList<>();
        for (int i = 0; i < lines.size(); i += perPage) {
            pages.add(lines.subList(i, Math.min(lines.size(), i + perPage)));
        }
        if (pages.isEmpty()) {
            pages.add(new ArrayList<>());
        }

        int total = 3 + pages.size() * 2;
        int[] offsets = new int[total + 1];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write("%PDF-1.4\n".getBytes(StandardCharsets.ISO_8859_1));

        obj(out, offsets, 1, "<< /Type /Catalog /Pages 2 0 R >>");
        StringBuilder kids = new StringBuilder();
        for (int i = 0; i < pages.size(); i++) {
            kids.append(4 + i * 2).append(" 0 R ");
        }
        obj(out, offsets, 2, "<< /Type /Pages /Kids [" + kids + "] /Count " + pages.size() + " >>");
        obj(out, offsets, 3, "<< /Type /Font /Subtype /Type1 /BaseFont /Courier /Encoding /WinAnsiEncoding >>");

        for (int i = 0; i < pages.size(); i++) {
            int pageObj = 4 + i * 2, contObj = 5 + i * 2;
            StringBuilder c = new StringBuilder();
            c.append("BT /F1 ").append(f(font)).append(" Tf ").append(f(lead)).append(" TL ")
             .append(f(MARGIN)).append(' ').append(f(H - MARGIN - font)).append(" Td\n");
            for (String l : pages.get(i)) {
                c.append('(').append(esc(l)).append(") Tj T*\n");
            }
            c.append("ET\n");
            c.append("BT /F1 8 Tf ").append(f(MARGIN)).append(" 15 Td (Halaman ").append(i + 1).append(" / ")
             .append(pages.size()).append(") Tj ET\n");
            byte[] cb = c.toString().getBytes(StandardCharsets.ISO_8859_1);
            obj(out, offsets, pageObj, "<< /Type /Page /Parent 2 0 R /MediaBox [0 0 " + f(W) + " " + f(H)
                    + "] /Resources << /Font << /F1 3 0 R >> >> /Contents " + contObj + " 0 R >>");
            offsets[contObj] = out.size();
            out.write((contObj + " 0 obj\n<< /Length " + cb.length + " >>\nstream\n").getBytes(StandardCharsets.ISO_8859_1));
            out.write(cb);
            out.write("endstream\nendobj\n".getBytes(StandardCharsets.ISO_8859_1));
        }

        int xref = out.size();
        StringBuilder x = new StringBuilder("xref\n0 " + (total + 1) + "\n0000000000 65535 f \n");
        for (int i = 1; i <= total; i++) {
            x.append(String.format("%010d 00000 n \n", offsets[i]));
        }
        x.append("trailer\n<< /Size ").append(total + 1).append(" /Root 1 0 R >>\nstartxref\n").append(xref).append("\n%%EOF\n");
        out.write(x.toString().getBytes(StandardCharsets.ISO_8859_1));
        return out.toByteArray();
    }

    private static void obj(ByteArrayOutputStream out, int[] offsets, int n, String body) throws IOException {
        offsets[n] = out.size();
        out.write((n + " 0 obj\n" + body + "\nendobj\n").getBytes(StandardCharsets.ISO_8859_1));
    }

    private static String f(double d) {
        return String.format(Locale.US, "%.2f", d);
    }

    private static String esc(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == ')' || ch == '\\') {
                sb.append('\\').append(ch);
            } else if (ch > 255 || ch < 32) {
                sb.append('?');
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

