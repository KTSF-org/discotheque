package application;

import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import exceptions.SaisieInvalideException;
import modele.Album;
import modele.CompactDisque;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import modele.DisqueVinyle;
import modele.FichierNumerique;

import java.time.format.DateTimeParseException;
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
        System.out.println("5. Modifier la quantité d'un album");
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

            Album album = null;
            if(typeAlbum == 1) {
                album = ajouterCompactDisque(nomAlbum, nomAuteur, dAnneeAlbum, quantite);
            } else if (typeAlbum == 2) {
                album = ajouterDisqueVinyle(nomAlbum, nomAuteur, dAnneeAlbum, quantite);

            } else {
                album = ajouterFichierNumerique(nomAlbum, nomAuteur, dAnneeAlbum, quantite);
            }

            if(album!=null) {
                discotheque.ajouterAlbum(album);
                System.out.println("Album ajouté avec succès !");
            }

        } catch (SaisieInvalideException | DateTimeParseException e) {
            System.err.println(e.getMessage().toString());
        }
    }

    public CompactDisque ajouterCompactDisque(String nomAlbum, String nomAuteur, LocalDate dAnneeAlbum, int quantite) {
        try {
            String numero = saisieNom("Saisissez le numéro du CD --> (CD-001) :");
            String type = saisieNom("Saisissez le type de CD --> Simple ou Double :");

            return new CompactDisque(nomAlbum, nomAuteur, dAnneeAlbum, quantite, numero, type);
        } catch (SaisieInvalideException e) {
            System.err.println(e.getMessage().toString());
        }
        return null;
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

    public void modifierQuantiteAlbum(){
        String nom = saisieNom("Saisir le nom de l'album dont vous voulez modifier la quantité");
        System.out.println("Saisir la quantité");
        int qte = saisieInt("Saisir la quantité :");
        if(qte<0)throw new SaisieInvalideException("La quantité doit-être supérieur ou égale à 0");
        discotheque.modifierQuantiteAlbum(nom,qte);
    }

    public String saisieNom(String msg) throws SaisieInvalideException {
        System.out.println(msg);
        String nom = scan.nextLine();
        if (nom.isEmpty()) {
            throw new SaisieInvalideException("Saisie invalide");
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

    public static int saisieInt(String msg) {
        int nombre = 0;
        boolean saisieValide = false;
        System.out.println(msg);
        while (!saisieValide) {
            try {
                nombre = scan.nextInt();
                scan.nextLine();
                saisieValide = true;
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez entrer un nombre entier valide");
                scan.next(); // on vide le jeton invalide du buffer
            }
        }
        return nombre;
    }

    public static double saisieDouble(String msg) {
        double nombre = 0.0d;
        boolean saisieValide = false;
        System.out.println(msg);
        while (!saisieValide) {
            try {
                nombre = scan.nextDouble();
                saisieValide = true;
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez entrer un nombre valide");
                scan.next(); // on vide le jeton invalide du buffer
            }
        }
        return nombre;
    }
}
