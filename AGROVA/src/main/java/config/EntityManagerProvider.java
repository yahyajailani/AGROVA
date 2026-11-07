package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("perusahaanRootPU");
        } catch (Throwable ex) {
            System.err.println("Gagal membuat EntityManagerFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public static boolean open() {
        try {
            return emf != null && emf.isOpen();
        } catch (Exception e) {
            return false;
        }
    }
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}