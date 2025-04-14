package bo;
import dao.LivreDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliothequePU"); // Ton persistence.xml doit avoir ce nom
        EntityManager em = emf.createEntityManager();

        LivreDAO livreDAO = new LivreDAO(em);

        em.getTransaction().begin();
        Livre livre = livreDAO.findById(1L);
        em.getTransaction().commit();

        if (livre != null) {
            System.out.println("Livre trouvé : " + livre.getTitre() + " par " + livre.getAuteur());
        } else {
            System.out.println("Aucun livre trouvé.");
        }

        em.close();
        emf.close();
    }
}
