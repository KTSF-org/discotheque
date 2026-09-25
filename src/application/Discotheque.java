package application;

import exceptions.AlbumDejaExistantException;
import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import modele.Album;

import java.util.ArrayList;

public class Discotheque {

    private ArrayList<Album> discotheque;

    // Constructeurs

    public Discotheque(ArrayList<Album> discotheque) {
        this.discotheque = discotheque;
    }

    public Discotheque() {
        this.discotheque = new ArrayList<>();
    }

    // Méthodes

    public void ajouterAlbum(Album a) throws AlbumDejaExistantException {
        // Controle si l'album existe déjà
        for (Album album : discotheque)
            if (album.getNom().equals(a.getNom()))
                throw new AlbumDejaExistantException("L'album " + a.getNom() + " existe déjà.");
        discotheque.add(a);
    }

    public void listerAblums() throws DiscothequeVideException {
        if (discotheque.isEmpty())
            throw new DiscothequeVideException("La discothèque est vide");
        // Print de this car toString de Discotheque implémenté
        System.out.println(this);
    }

    public Album rechercherAlbum(String nom) throws AlbumIntrouvableException, DiscothequeVideException {
        if (discotheque.isEmpty())
            throw new DiscothequeVideException("La discothèque est vide");
        for (Album album : discotheque)
            if (album.getNom().equals(nom))
                return album;
        throw new AlbumIntrouvableException("L'album " + nom + " est introuvable.");
    }

    public void supprimerAlbum(String nom) throws AlbumIntrouvableException, DiscothequeVideException {
        if (discotheque.isEmpty())
            throw new DiscothequeVideException("La discothèque est vide");
        for (int i = 0; i < discotheque.size(); i++) {
            if (discotheque.get(i).getNom().equals(nom)) {
                discotheque.remove(i);
                return;
            }
        }
        throw new AlbumIntrouvableException("L'album " + nom + " est introuvable.");
    }

    public void modifierQuantiteAlbum(String n,int q){
        modele.Album a = rechercherAlbum(n);
        a.setQuantite(q);
    }

    public void viderDiscotheque() {
        discotheque.clear();
    }


    // Assesseurs

    public ArrayList<Album> getDiscotheque() {
        return discotheque;
    }

    public void setDiscotheque(ArrayList<Album> discotheque) {
        this.discotheque = discotheque;
    }

    @Override
    public String toString() {
        String s = "\nDiscothèque : ";
        for (Album a : discotheque) {
            s += a.toString() + "\n";
        }
        return s;
    }

}
