package config;

import jakarta.persistence.EntityManager;

public class TestKoneksiOrm {
    
     public static void main(String[] args) {
         System.out.println("Mengecek koneksi ke database (ORM)...");
         
        try (EntityManager em = EntityManagerProvider.getEntityManager()) {
            Object result = em.createNativeQuery("SELECT 1").getSingleResult();
            System.out.println("Koneksi ORM berhasil: " + result);
        } catch (Exception e) {
            System.out.println("Koneksi ORM gagal: " + e.getMessage());
        } finally {
            EntityManagerProvider.close();
        }
    }
}
