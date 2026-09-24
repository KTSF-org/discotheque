package application;

import exceptions.SaisieInvalideException;
import modele.DisqueVinyle;
import modele.FichierNumerique;

import java.time.LocalDate;
import java.util.Scanner;

public class Controller {
    public static Scanner scan = new Scanner(System.in);
    private Discotheque discotheque = new Discotheque();

    // Affiche le menu principal
    public void afficherMenu() {
        System.out.println("===== GESTION DE LA DISCOTHÈQUE =====");
        System.out.println("1. Ajouter un album");
        System.out.println("2. Lister tous les albums");
        System.out.println("3. Rechercher un album");
        System.out.println("4. Supprimer un album");
        System.out.println("0. Quitter");
    }

    public void ajouterAlbum() {

    }

    public DisqueVinyle ajouterDisqueVinyle(String nom, String auteur, LocalDate date, int quantite) {
        String numero = saisieNom("Numéro du vinyle :");
        int taille = saisieInt("Taille du vinyle (diamètre en cm : 17, 25 ou 30) : ");
        return new DisqueVinyle(nom, auteur, date, quantite, numero, taille);
    }

    public FichierNumerique ajouterFichierNumerique(String nom, String auteur, LocalDate date, int quantite) {
        String format = saisieNom("Format du fichier : ");
        double taille = saisieDouble("Taille du fichier (en Mo) : ");
        int duree = saisieInt("Durée de l'album (en minute) : ");
        return new FichierNumerique(nom, auteur, date, quantite, format, taille, duree);
    }

    public void afficherDiscotheque() {
        discotheque.listerAblums();
    }

    public void afficherAlbum() {

    }

    public void supprimerAlbum() {
        String nom = saisieNom("Saisir le nom de l'album à supprimer :");
        discotheque.supprimerAlbum(nom);
    }

    public String saisieNom(String msg) throws SaisieInvalideException {
        System.out.println(msg);
        String nom = scan.nextLine();
        if (nom.isEmpty()) {
            throw new SaisieInvalideException("saisie invalide");
        }
        return nom;
    }

    public String saisieDate(String msg) throws SaisieInvalideException {
        System.out.print(msg);
        String dateD = scan.nextLine();
        if (dateD.isEmpty()) {
            throw new SaisieInvalideException("date de l'album non saisie");
        }
        return dateD;
    }
}
