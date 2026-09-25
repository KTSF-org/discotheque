
import application.Controller;
import exceptions.AlbumDejaExistantException;
import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import exceptions.SaisieInvalideException;

public class Main {
    public static void main(String[] args) {


        Controller c = new Controller();
        int choix = 0;

        do {
            try {
                c.afficherMenu();
                System.out.println("Choix : ");
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
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }

                System.out.println();
            } catch (AlbumDejaExistantException | AlbumIntrouvableException | DiscothequeVideException | SaisieInvalideException  e) {
                System.err.println(e.getMessage());
            }

        } while (choix != 0);

        Controller.scan.close();

    }

}
