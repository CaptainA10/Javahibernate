package bo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    @Column(name = "PRENOM", nullable = false)
    private String prenom;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Emprunt> emprunts = new ArrayList<>();

    // Constructeurs
    public Client() {}

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public List<Emprunt> getEmprunts() { return emprunts; }

    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
}