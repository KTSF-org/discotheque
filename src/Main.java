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
                System.out.print("Choix:");
                choix = Controller.scan.nextInt();

                switch (choix) {
                    case 1:
                        c.ajouterDisque();
                        break;
                    case 2:
                        c.supprimerDisqueParNom();
                        break;
                    case 3:
                        c.supprimerDisqueParAuteurEtNom();
                        break;
                    case 4:
                        c.afficherDiscotheque();
                        break;
                    case 5:
                        c.viderDiscotheque();
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
            }

        } while (choix != 0);

        Controller.scan.close();

    }
}
