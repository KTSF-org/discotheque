package modele;

import java.time.LocalDate;

public class CompactDisque extends Album {

    private String numero;
    private String type;

    public CompactDisque(String nom, String auteur, LocalDate date, int quantite, String numero, String type) {
        super(nom, auteur, date, quantite);
        this.numero = numero;
        this.type = type;
    }

    @Override
    public String getSupport() {
        return "CompactDisque";
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CD : " + super.toString() +
                " | disque numéro " + numero + ", " + type;
    }
}
