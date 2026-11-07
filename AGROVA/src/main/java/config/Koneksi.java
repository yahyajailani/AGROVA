package config;

import java.sql.*;
import java.util.*;

public class Koneksi {
    private static Connection conn = null;

    // Bisa diganti tanpa mengubah kode lewat environment variable AGROVA_DB_URL / AGROVA_DB_USER / AGROVA_DB_PASS
    private static final String URL = env("AGROVA_DB_URL", "jdbc:mysql://localhost:3306/agrova");
    private static final String USER = env("AGROVA_DB_USER", "root");
    private static final String PASS = env("AGROVA_DB_PASS", "");

    private static String env(String key, String def) {
        String v = System.getenv(key);
        return v == null ? def : v;
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed() || !conn.isValid(2)) {
            conn = DriverManager.getConnection(URL, USER, PASS);
        }
        return conn;
    }

    public static Connection get() throws SQLException {
        return getConnection();
    }

    public static void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Gagal menutup koneksi: " + e.getMessage());
        }
    }

    // --- Interface untuk Blok Transaksi ---
    public interface Work {
        void run() throws SQLException;
    }

    // --- Helper untuk Menjalankan Transaksi (Commit / Rollback Otomatis) ---
    public static void tx(Work work) throws SQLException {
        Connection c = getConnection();
        boolean oldAutoCommit = c.getAutoCommit();
        try {
            c.setAutoCommit(false);
            work.run();
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException rbEx) {
                System.err.println("Gagal melakukan rollback: " + rbEx.getMessage());
            }
            throw e;
        } finally {
            try {
                c.setAutoCommit(oldAutoCommit);
            } catch (SQLException acEx) {
                // Abaikan
            }
        }
    }

    // --- Helper Query untuk Mengambil Satu Baris ---
    public static Map<String, Object> one(String sql, Object... params) throws SQLException {
        List result = query(sql, params);
        return result.isEmpty() ? new HashMap<>() : (Map<String, Object>) result.get(0);
    }

    // --- Helper Query untuk Mengambil Banyak Baris ---
    public static List query(String sql, Object... params) throws SQLException {
        List list = new ArrayList();
        Connection c = getConnection();
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                
                while (rs.next()) {
                    Map<String, Object> row = new LinkedHashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.put(metaData.getColumnLabel(i), rs.getObject(i));
                    }
                    list.add(row);
                }
            }
        }
        return list;
    }

    // --- Helper untuk Insert Data (Mengembalikan ID Auto-Increment) ---
    public static long insert(String sql, Object... params) throws SQLException {
        Connection c = getConnection();
        try (PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        return 0;
    }

    // --- Helper untuk Update / Delete Data ---
    public static int update(String sql, Object... params) throws SQLException {
        Connection c = getConnection();
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            return ps.executeUpdate();
        }
    }

    // --- Helper Parsing Data ---
    public static int intOf(Map<String, Object> map, String key) {
        if (map == null) return 0;
        Object val = map.get(key);
        return val instanceof Number ? ((Number) val).intValue() : 0;
    }

    public static String strOf(Map<String, Object> map, String key) {
        if (map == null) return null;
        Object val = map.get(key);
        return val != null ? val.toString() : null;
    }
}