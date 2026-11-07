package view;

import model.Security;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class AuthView extends ConsoleView {
    public record Kredensial(String email, String password) { }

    public Kredensial formLogin() {
        title("MASUK");
        String email = readLine("Email    : ");
        String pw = readLine("Password : ");
        return new Kredensial(email, pw);
    }

    public void loginBerhasil() {
        pesan("\nAnda berhasil login");
    }

    public boolean loginGagalUlangi() {
        pesan("\nEmail dan password tidak sesuai");
        return yesNo("Apakah mencoba lagi?");
    }


    //Daftar akun
    public String pilihPeran() {
        title("DAFTAR AKUN");
        return askChoice("Daftar sebagai", List.of("Penyalur", "Petani"), -1);
    }

    public String inputNama() {
        return askText("Nama lengkap", 150);
    }

    public String inputEmail() {
        while (true) {
            String email = readLine("Email: ");
            if (!Security.isEmail(email)) {
            } else {
                return email;
            }
            pesan("  Format email tidak valid (maksimal 50 karakter).");
        }
    }

    public boolean emailSudahTerdaftarUlangi() {
        pesan("Email sudah terdaftar");
        return yesNo("Apakah mencoba lagi?");
    }

    public String inputNoHp() {
        while (true) {
            String s = readLine("No HP (angka saja): ");
            if (Security.isDigits(s, 10, 13)) {
                return s;
            }
            pesan("  No HP harus 10-13 digit angka.");
        }
    }

    public String inputPassword() {
        while (true) {
            String pw = readLine("Password (minimal 6 karakter): ");
            if (pw.length() < 6 || pw.length() > 64) {
                pesan("  Password harus 6-64 karakter.");
                continue;
            }
            if (!pw.equals(readLine("Ulangi password: "))) {
                pesan("  Password tidak sama.");
                continue;
            }
            return pw;
        }
    }

    public void tampilKios(List<Map<String, Object>> rows) {
        showTable("Daftar Kios", rows);
    }

    public int inputIdKios() {
        return askInt("ID kios Anda: ", 1, Integer.MAX_VALUE);
    }

    public void kiosTidakAda() {
        pesan("  Kios tidak ditemukan.");
    }

    public String inputIzinUsaha() {
        return askText("Nomor izin usaha", 50);
    }

    public String inputNik() {
        while (true) {
            String s = readLine("NIK (16 digit): ");
            if (Security.isDigits(s, 16, 16)) {
                return s;
            }
            pesan("  NIK harus 16 digit angka.");
        }
    }

    public boolean nikDuplikatUlangi() {
        pesan("NIK tidak valid atau terdapat duplikasi");
        return yesNo("Apakah mencoba lagi?");
    }

    public BigDecimal inputLuasLahan() {
        return askDecimal("Luas lahan (hektar, 0.01 - 99.99): ", new BigDecimal("0.01"), new BigDecimal("99.99"));
    }

    public String inputGolongan() {
        return askText("Golongan", 10);
    }

    public void registrasiBerhasil() {
        pesan("\nAkun berhasil ditambahkan. Silakan masuk.");
    }
}

