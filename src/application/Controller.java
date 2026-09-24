package application;

import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import exceptions.SaisieInvalideException;
import modele.Album;
import modele.CompactDisque;

import javax.swing.plaf.InsetsUIResource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import modele.DisqueVinyle;
import modele.FichierNumerique;

import java.time.LocalDate;
import java.util.InputMismatchException;
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
        try {
            int typeAlbum = saisieInt("Type d'album (1 = CD, 2 = Vinyle, 3 = Fichier numérique) :");
            if (typeAlbum < 1 || typeAlbum > 3)
                throw new SaisieInvalideException("Veuillez saisir un nombre valide");
            String nomAlbum = saisieNom("Saisissez le nom de l'album :");
            String nomAuteur = saisieNom("Saisissez le nom de l'auteur :");
            String sAnneeAlbum = saisieDate("Saisissez l'année de l'album jj/mm/aaaa :");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dAnneeAlbum = LocalDate.parse(sAnneeAlbum, formatter);
            if (dAnneeAlbum.isAfter(LocalDate.now()) || dAnneeAlbum.isBefore(LocalDate.parse("1886-01-01"))) {
                throw new SaisieInvalideException("Veuillez saisir une date de sortie valide");
            }
            int quantite = saisieInt("Saisissez le nombre de CD :");

            if (typeAlbum == 1)

                CompactDisque cd = new CompactDisque(nomAlbum, nomAuteur, dAnneeAlbum, quantite)

        }
    }

    public CompactDisque ajouterCompactDisque(String nomAlbum, String nomAuteur, LocalDate dAnneeAlbum, int quantite) {
        try {
            String numero = saisieNom("Saisissez le numéro du CD --> (CD-001) :");
            String type = saisieNom("Saisissez le type de CD --> Simple ou Double :");

            CompactDisque cd = new CompactDisque(nomAlbum, nomAuteur, dAnneeAlbum, quantite, numero, type);
            discotheque.ajouterAlbum(cd);
        }
    }

    public DisqueVinyle ajouterDisqueVinyle(String nom, String auteur, LocalDate date, int quantite) {
        try {
            String numero = saisieNom("Numéro du vinyle :");
            int taille = saisieInt("Taille du vinyle (diamètre en cm : 17, 25 ou 30) : ");
            return new DisqueVinyle(nom, auteur, date, quantite, numero, taille);
        } catch (SaisieInvalideException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public FichierNumerique ajouterFichierNumerique(String nom, String auteur, LocalDate date, int quantite) {
        try {
            String format = saisieNom("Format du fichier : ");
            double taille = saisieDouble("Taille du fichier (en Mo) : ");
            int duree = saisieInt("Durée de l'album (en minute) : ");
            return new FichierNumerique(nom, auteur, date, quantite, format, taille, duree);
        } catch (SaisieInvalideException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void afficherDiscotheque() {
        discotheque.listerAblums();
    }

    public void afficherAlbum() throws AlbumIntrouvableException, DiscothequeVideException {
        String aNom = saisieNom("Veuillez saisir le nom de l'album à afficher");
        modele.Album a = discotheque.rechercherAlbum(aNom);
        System.out.println(a.toString());
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
            throw new SaisieInvalideException("Saisie invalide");
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

    public static int saisieInt(String msg) {
        Scanner scanner = new Scanner(System.in);
        int nombre = 0;
        boolean saisieValide = false;
        System.out.println(msg);
        while (!saisieValide) {
            try {
                nombre = scanner.nextInt();
                saisieValide = true;
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez entrer un nombre entier valide");
                scanner.next(); // on vide le jeton invalide du buffer
            }
        }
        return nombre;
    }

    public static double saisieDouble(String msg) {
        Scanner scanner = new Scanner(System.in);
        double nombre = 0.0d;
        boolean saisieValide = false;
        System.out.println(msg);
        while (!saisieValide) {
            try {
                nombre = scanner.nextDouble();
                saisieValide = true;
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez entrer un nombre valide");
                scanner.next(); // on vide le jeton invalide du buffer
            }
        }
        return nombre;
    }
}
