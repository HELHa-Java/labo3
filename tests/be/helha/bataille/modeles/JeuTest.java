package be.helha.bataille.modeles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static be.helha.bataille.modeles.Jeu.NB_CARTES;
import static org.junit.jupiter.api.Assertions.*;

public class JeuTest {

    private Jeu jeu;

    @BeforeEach
    public void setUp() {
        jeu = new Jeu();
    }

    @Test
    public void distribue() {
        assertFalse(jeu.paquet.estVide());
        assertFalse(jeu.getJoueurs()[0].aEncoreDesCartes());
        assertFalse(jeu.getJoueurs()[1].aEncoreDesCartes());
        jeu.distribue();
        assertTrue(jeu.paquet.estVide());
        assertTrue(jeu.getJoueurs()[0].aEncoreDesCartes());
        assertTrue(jeu.getJoueurs()[1].aEncoreDesCartes());
    }

    @Test
    public void mélanger() {
        // délégation vers paquet, pas besoin de tester
    }

    @Test
    public void getJoueurs() {
        assertFalse(jeu.getJoueurs() == jeu.joueurs);
        assertTrue(jeu.getJoueurs()[0] == jeu.joueurs[0]);
        assertTrue(jeu.getJoueurs()[1] == jeu.joueurs[1]);
    }

    @Test
    public void jouerUnTour() {
        jeu.distribue();
        Tour tour = jeu.jouerUnTour();
        assertNotEquals(tour, null);
    }

    @Test
    public void estFini() {
        // Indice : Il ne faut pas changer le modèle. C'est le code du test qui n'est pas correct.
        //          Utilisez le debugger pour comprendre ce qui se passe.
        assertTrue(jeu.estFini());
        jeu.distribue();
        for (int i = 0; i < NB_CARTES; i++) {
            assertFalse(jeu.estFini());
            jeu.jouerUnTour();
        }
        assertTrue(jeu.estFini());
        jeu.reinitialise();
        assertTrue(jeu.estFini());
        jeu.distribue();
        assertFalse(jeu.estFini());
    }

    @Test
    public void reinitialise() {
        // voir estFini
    }
}