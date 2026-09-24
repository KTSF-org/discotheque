package application;

import exceptions.SaisieInvalideException;
import modele.Album;
import modele.CompactDisque;

import javax.swing.plaf.InsetsUIResource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Controller {
    public static Scanner scan = new Scanner(System.in);

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
            if(typeAlbum<1 || typeAlbum>3)
                throw new SaisieInvalideException("Veuillez saisir un nombre valide");
            String nomAlbum = saisieNom("Saisissez le nom de l'album :");
            String nomAuteur = saisieNom("Saisissez le nom de l'auteur :");
            String sAnneeAlbum = saisieDate("Saisissez l'année de l'album jj/mm/aaaa :");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dAnneeAlbum = LocalDate.parse(sAnneeAlbum, formatter);
            if(dAnneeAlbum.isAfter(LocalDate.now()) || dAnneeAlbum.isBefore(LocalDate.parse("1886-01-01"))) {
                throw new SaisieInvalideException("Veuillez saisir une date de sortie valide");
            }
            int quantite = saisieInt("Saisissez le nombre de CD :");

            if(typeAlbum == 1)

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

    public void afficherDiscotheque() {

    }

    public void afficherAlbum() {

    }

    public void supprimerAlbum() {

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
        System.out.println(msg);
        int nombre = 0;
        while(nombre==0) {
            try {
                Scanner scanner = new Scanner(System.in);
                nombre = scanner.nextInt();
            } catch (SaisieInvalideException ime) {
                System.out.println("Veuillez entrer un nombre entier");
            }
        }
        return nombre;
    }
}
