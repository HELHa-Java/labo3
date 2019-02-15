package be.helha.bataille.modeles;

public class Tour {
    private Carte carteJoueur1;
    private Carte carteJoueur2;

    public Tour(Carte carteJoueur1, Carte carteJoueur2) {
        this.carteJoueur1 = carteJoueur1;
        this.carteJoueur2 = carteJoueur2;
    }

    @Override
    public String toString() {
        return "Tour : " + carteJoueur1 +
                " vs " + carteJoueur2 + " => " + (joueur1Gagnant() ? "Joueur 1 Gagnant" : "Joueur 2 Gagnant");
    }

    public boolean joueur1Gagnant() {
        return !carteJoueur1.estAvant(carteJoueur2);
    }
}
