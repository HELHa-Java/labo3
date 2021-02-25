package be.helha.bataille.modeles;

import java.util.Objects;

public class Carte {
    private int valeur;
    private Couleur couleur;

    public Carte(int valeur, Couleur couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        String name;
        switch (valeur) {
            case 1:
                name = "As";
                break;
            case 11:
                name = "Valet";
                break;
            case 12:
                name = "Dame";
                break;
            case 13:
                name = "Roi";
                break;
            default:
                name = String.valueOf(valeur);
        }

        return name + " de " + couleur.name().toLowerCase();
    }

    public boolean estAvant(Carte carte) {
        return this.valeur < carte.valeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return valeur == carte.valeur &&
                couleur == carte.couleur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valeur, couleur);
    }
}
