package modele;

import java.time.LocalDate;

public class DisqueVinyle extends Album {

     private String numero;
     private int taille;

     public DisqueVinyle(String nom, String auteur, LocalDate date, int quantite, String numero, int taille) {
          super(nom, auteur, date, quantite);
          this.numero = numero;
          this.taille = taille;
     }

     public String getNumero() {
          return numero;
     }

     public int getTaille() {
          return taille;
     }

     public void setNumero(String numero) {
          this.numero = numero;
     }

     public void setTaille(int taille) {
          this.taille = taille;
     }

     @Override
     public String getSupport(){
          return "Disque vinyle";
     }

     @Override
     public String toString() {
          return super.toString() +
                  " | vinyle numéro " + numero + ", " + taille + "cm";
     }
}
