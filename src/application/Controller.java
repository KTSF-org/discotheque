package application;

import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import exceptions.SaisieInvalideException;

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

    public void afficherDiscotheque() {
        discotheque.listerAblums();
    }

    public void afficherAlbum() throws AlbumIntrouvableException, DiscothequeVideException {
        String aNom = saisieNom("Veuillez saisir le nom de l'album à afficher");
        modele.Album a = discotheque.rechercherAlbum(aNom);
        a.toString();
    }

    public void supprimerAlbum() {
        String nom = saisieNom("Saisir le nom de l'album à supprimer :");
        discotheque.supprimerAlbum(nom);
    }

    public String saisieNom(String msg) throws SaisieInvalideException {
        scan.nextLine();
        System.out.println(msg);
        String nom = scan.nextLine();
        if (nom.isEmpty()) {
            throw new SaisieInvalideException("saisie invalide");
        }
        return nom;
    }

    public String saisieDate(String msg) throws SaisieInvalideException {
        scan.nextLine();
        System.out.print(msg);
        String dateD = scan.nextLine();
        if (dateD.isEmpty()) {
            throw new SaisieInvalideException("date de l'album non saisie");
        }
        return dateD;
    }
}
