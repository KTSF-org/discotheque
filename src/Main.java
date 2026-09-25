
import application.Controller;
import exceptions.AlbumDejaExistantException;
import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import exceptions.SaisieInvalideException;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {


        Controller c = new Controller();
        int choix = -1;

        do {
            try {
                c.afficherMenu();
                System.out.print("Choix:");
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
            } catch (AlbumDejaExistantException adee) {
                System.err.println(adee.getMessage());
            } catch (AlbumIntrouvableException aie) {
                System.err.println(aie.getMessage());
            } catch (DiscothequeVideException dve) {
                System.err.println(dve.getMessage());
            } catch (SaisieInvalideException sie) {
                System.err.println(sie.getMessage());
            } catch(InputMismatchException ime){
                Controller.scan.nextLine();
                System.out.println("Saisie non valide");
            }

        } while (choix != 0);

        Controller.scan.close();

    }

}
