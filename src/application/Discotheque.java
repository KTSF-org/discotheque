package application;

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

    //TODO implementer + throws exception
    public void ajouterAlbum(Album a) {

    }

    //TODO implementer + throws exception
    public void listerAblums() {

    }

    //TODO implementer + throws exception
    public Album rechercherAlbum(String nom) {
        return null;
    }

    //TODO implementer + throws exception
    public void supprimerAlbum(String nom) {

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
