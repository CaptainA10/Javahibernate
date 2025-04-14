package fr.esaip;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnexionJpa {
    public static void main(String[] args) {
        // Désactive les logs trop verbeux de Hibernate
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        try {
            // 1. Création de l'EntityManagerFactory
            System.out.println("Création de l'EntityManagerFactory...");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

            // 2. Création de l'EntityManager
            System.out.println("Création de l'EntityManager...");
            EntityManager em = emf.createEntityManager();
            System.out.println("EntityManager créé : " + em);

            // 3. Test de connexion à la base de données
            System.out.println("Test de connexion à la base de données...");
            boolean connected = em.isOpen();
            System.out.println("Connexion réussie ? " + connected);

            // 4. Fermeture des ressources
            em.close();
            emf.close();
            System.out.println("Toutes les ressources ont été fermées.");
        } catch (Exception e) {
            System.err.println("Erreur de connexion à la base de données :");
            e.printStackTrace();
        }
    }
}
