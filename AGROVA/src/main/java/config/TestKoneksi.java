package config;

import java.sql.Connection;

public class TestKoneksi {
    
    public static void main(String[] args) {
        System.out.println("Mengecek koneksi ke database (JDBC)...");
        
        try (Connection conn = Koneksi.getConnection()) {
            System.out.println("Koneksi JDBC berhasil: " + conn.getCatalog());
        } catch (Exception e) {
            System.out.println("Koneksi JDBC gagal: " + e.getMessage());
        }
    }
}
