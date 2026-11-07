package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Koneksi {

    // Instance Singleton
    private static final Koneksi INSTANCE = new Koneksi();

    // Koneksi database
    private Connection conn;

    // Konfigurasi database
    private static final String URL = env("AGROVA_DB_URL", "jdbc:mysql://localhost:3306/agrova");
    private static final String USER = env("AGROVA_DB_USER", "root");
    private static final String PASS = env("AGROVA_DB_PASS", "");

    private static String env(String key, String def) {
        String v = System.getenv(key);
        return v == null ? def : v;
    }

    // Konstruktor private
    private Koneksi() {
    }

    // Mengambil instance Singleton
    public static Koneksi getInstance() {
        return INSTANCE;
    }

    // Mengambil koneksi database
    public static synchronized Connection getConnection()
            throws SQLException {

        if (INSTANCE.conn == null || INSTANCE.conn.isClosed() || !INSTANCE.conn.isValid(2)) {
            INSTANCE.conn =
                    DriverManager.getConnection(URL, USER, PASS);
        }

        return INSTANCE.conn;
    }

    // Alternatif pemanggilan koneksi
    public static Connection get() throws SQLException {
        return getConnection();
    }

    // Menutup koneksi database
    public static void close() {
        try {
            if (INSTANCE.conn != null && !INSTANCE.conn.isClosed()) {
                INSTANCE.conn.close();
                INSTANCE.conn = null;
            }
        } catch (SQLException e) {
            System.err.println(
                    "Gagal menutup koneksi: " + e.getMessage()
            );
        }
    }

    // Interface untuk blok transaksi
    public interface Work {
        void run() throws SQLException;
    }

    // Menjalankan transaksi dengan Commit dan Rollback
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
                System.err.println(
                        "Gagal melakukan rollback: "
                        + rbEx.getMessage()
                );
            }

            throw e;

        } finally {

            try {
                c.setAutoCommit(oldAutoCommit);
            } catch (SQLException acEx) {
                System.err.println(
                        "Gagal mengembalikan AutoCommit: "
                        + acEx.getMessage()
                );
            }
        }
    }

    // Mengambil satu baris data
    public static Map<String, Object> one(
            String sql, Object... params) throws SQLException {

        List<Map<String, Object>> result = query(sql, params);

        return result.isEmpty()
                ? new HashMap<>()
                : result.get(0);
    }

    // Mengambil banyak baris data
    public static List<Map<String, Object>> query(
            String sql, Object... params) throws SQLException {

        List<Map<String, Object>> list = new ArrayList<>();

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

                    Map<String, Object> row =
                            new LinkedHashMap<>();

                    for (int i = 1; i <= columnCount; i++) {
                        row.put(
                                metaData.getColumnLabel(i),
                                rs.getObject(i)
                        );
                    }

                    list.add(row);
                }
            }
        }

        return list;
    }

    // Insert data dan mengambil ID Auto Increment
    public static long insert(
            String sql, Object... params) throws SQLException {

        Connection c = getConnection();

        try (PreparedStatement ps = c.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {

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

    // Update dan Delete data
    public static int update(
            String sql, Object... params) throws SQLException {

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

    // Helper parsing data Integer
    public static int intOf(
            Map<String, Object> map, String key) {

        if (map == null) {
            return 0;
        }

        Object val = map.get(key);

        return val instanceof Number
                ? ((Number) val).intValue()
                : 0;
    }

    // Helper parsing data String
    public static String strOf(
            Map<String, Object> map, String key) {

        if (map == null) {
            return null;
        }

        Object val = map.get(key);

        return val != null ? val.toString() : null;
    }
}
