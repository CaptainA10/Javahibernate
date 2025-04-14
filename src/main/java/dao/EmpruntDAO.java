package dao;

import bo.Emprunt;
import jakarta.persistence.EntityManager;

public class EmpruntDAO {
    private EntityManager em;

    public EmpruntDAO(EntityManager em) {
        this.em = em;
    }

    public Emprunt findById(Long id) {
        return em.find(Emprunt.class, id);
    }
}