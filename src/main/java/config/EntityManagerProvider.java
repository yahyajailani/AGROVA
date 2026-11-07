package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {

    // Instance Singleton
    private static final EntityManagerProvider INSTANCE =
            new EntityManagerProvider();

    // EntityManagerFactory
    private EntityManagerFactory emf;

    // Konstruktor private
    private EntityManagerProvider() {
    }

    // Mengambil instance Singleton
    public static EntityManagerProvider getInstance() {
        return INSTANCE;
    }

    // Membuat EntityManagerFactory
    private synchronized EntityManagerFactory factory() {

        if (emf == null || !emf.isOpen()) {
            try {
                emf = Persistence.createEntityManagerFactory(
                        "perusahaanRootPU"
                );

            } catch (RuntimeException ex) {

                System.err.println(
                        "Gagal membuat EntityManagerFactory: "
                        + ex.getMessage()
                );

                throw ex;
            }
        }

        return emf;
    }

    // Mengambil EntityManager
    public static EntityManager getEntityManager() {
        return INSTANCE.factory().createEntityManager();
    }

    // Memeriksa status EntityManagerFactory
    public static boolean open() {
        synchronized (INSTANCE) {
            return INSTANCE.emf != null && INSTANCE.emf.isOpen();
        }
    }

    // Menutup EntityManagerFactory
    public static void close() {
        synchronized (INSTANCE) {
            if (INSTANCE.emf != null && INSTANCE.emf.isOpen()) {
                INSTANCE.emf.close();
            }
            INSTANCE.emf = null;
        }
    }
}