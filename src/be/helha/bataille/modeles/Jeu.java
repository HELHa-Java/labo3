package be.helha.bataille.modeles;

public class Jeu {
    public static final int NB_CARTES = 52;
    protected Joueur[] joueurs = new Joueur[2];
    protected Paquet paquet = new Paquet(NB_CARTES);

    public Jeu() {
        initialise();
    }

    private void initialise() {
        paquet.ajouterToutesLesCartes();
        for (int i = 0; i < joueurs.length; i++) {
            joueurs[i] = new Joueur();
        }
    }

    public void distribue() {
        while (paquet.taille() > 0) {
            for (Joueur joueur : joueurs) {
                joueur.addCarte(paquet.tirerUneCarte());
            }
        }
    }

    public void mélanger() {
        paquet.mélanger();
    }

    public Joueur[] getJoueurs() {
        // renvoie une copie pour préserver l'encapsulation
        return joueurs.clone();
    }

    public Tour jouerUnTour() {
        Carte cartes[] = new Carte[joueurs.length];
        for (int i = 0; i < joueurs.length; i++) {
            cartes[i] = joueurs[i].donnerCarte();
        }
        if (cartes[0].estAvant(cartes[1])) {
            joueurs[1].incrementeScore();
        } else {
            joueurs[0].incrementeScore();
        }
        return new Tour(cartes[0], cartes[1]);
    }

    public boolean estFini() {
        return !joueurs[0].aEncoreDesCartes();
    }

    public void reinitialise() {
        paquet = new Paquet(NB_CARTES);
        initialise();
    }
}
