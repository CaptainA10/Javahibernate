package bo;

import jakarta.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliothequePU");
        EntityManager em = emf.createEntityManager();

        try {
            // 1. Trouver un emprunt avec ses livres
            System.out.println("=== Emprunt avec livres ===");
            Emprunt emprunt = em.find(Emprunt.class, 1L);
            if (emprunt != null) {
                System.out.println("Emprunt ID: " + emprunt.getId());
                System.out.println("Livres associés:");
                for (Livre livre : emprunt.getLivres()) {
                    System.out.println("- " + livre.getTitre());
                }
            }

            // 2. Trouver les emprunts d'un client
            System.out.println("\n=== Emprunts d'un client ===");
            Client client = em.find(Client.class, 1L);
            if (client != null) {
                System.out.println("Client: " + client.getNom());
                for (Emprunt e : client.getEmprunts()) {
                    System.out.println("- Emprunt ID: " + e.getId());
                }
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}