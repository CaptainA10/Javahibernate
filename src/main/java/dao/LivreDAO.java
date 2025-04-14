package dao;

import bo.Livre;
import jakarta.persistence.EntityManager;

public class LivreDAO {

    private EntityManager em;

    public LivreDAO(EntityManager em) {
        this.em = em;
    }

    public Livre findById(Long id) {
        return em.find(Livre.class, id);  // simple find JPA
    }
}
