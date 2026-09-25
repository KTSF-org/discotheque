
import application.Controller;
import exceptions.AlbumDejaExistantException;
import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import exceptions.SaisieInvalideException;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {


        Controller c = new Controller();
        int choix = 0;

        while (true) {
            try {
                c.afficherMenu();
                System.out.print("Choix :");
                choix = Controller.scan.nextInt();
                Controller.scan.nextLine();
                switch (choix) {
                    case 1:
                        c.ajouterAlbum();
                        break;
                    case 2:
                        c.afficherDiscotheque();
                        break;
                    case 3:
                        c.afficherAlbum();
                        break;
                    case 4:
                        c.supprimerAlbum();
                        break;
                    case 5:
                        c.modifierQuantiteAlbum();
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        Controller.scan.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }
            } catch (AlbumDejaExistantException | AlbumIntrouvableException | DiscothequeVideException |
                     SaisieInvalideException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException ime) {
                Controller.scan.nextLine();
                System.out.println("\u001B[31mSaisie non valide\u001B[0m");
            }
        }
    }
}
