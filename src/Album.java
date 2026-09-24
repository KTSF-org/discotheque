import java.time.LocalDate;

public abstract class Album {

    private String nom;
    private String auteur;
    private LocalDate date;
    private int quantite;

    public Album(String nom, String auteur, LocalDate date, int quantite) {
        this.nom = nom;
        this.auteur = auteur;
        this.date = date;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Album{" +
                "nom='" + nom + '\'' +
                ", auteur='" + auteur + '\'' +
                ", date=" + date +
                ", quantite=" + quantite +
                '}';
    }

    public abstract String getSupport() {

    }
}
