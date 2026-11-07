package model.dao;

import config.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import model.Kios;
import java.util.List;

public class KiosDao implements CrudDao<Kios> {

    @Override
    public List<Kios> findAll() {
        try (EntityManager em = EntityManagerProvider.getEntityManager()) {
            return em.createQuery("SELECT k FROM Kios k ORDER BY k.id", Kios.class)
                    .getResultList();
        }
    }

    @Override
    public Kios findById(int id) {
        try (EntityManager em = EntityManagerProvider.getEntityManager()) {
            return em.find(Kios.class, id);
        }
    }

    @Override
    public long insert(Kios k) {
        try (EntityManager em = EntityManagerProvider.getEntityManager()) {
            em.getTransaction().begin();
            try {
                k.setId(0);
                em.persist(k);
                em.getTransaction().commit();
                return k.getId();
            } catch (RuntimeException e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            }
        }
    }

    @Override
    public boolean update(Kios k) {
        try (EntityManager em = EntityManagerProvider.getEntityManager()) {
            em.getTransaction().begin();
            try {
                Kios ada = em.find(Kios.class, k.getId());
                if (ada == null) {
                    em.getTransaction().rollback();
                    return false;
                }
                ada.setNamaKios(k.getNamaKios());
                ada.setNamaKecamatan(k.getNamaKecamatan());
                em.getTransaction().commit();
                return true;
            } catch (RuntimeException e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            }
        }
    }

    @Override
    public boolean delete(int id) {
        try (EntityManager em = EntityManagerProvider.getEntityManager()) {
            em.getTransaction().begin();
            try {
                Kios ada = em.find(Kios.class, id);
                if (ada == null) {
                    em.getTransaction().rollback();
                    return false;
                }
                em.remove(ada);
                em.getTransaction().commit();
                return true;
            } catch (RuntimeException e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            }
        }
    }
}