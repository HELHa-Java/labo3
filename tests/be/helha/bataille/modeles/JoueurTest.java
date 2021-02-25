package be.helha.bataille.modeles;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JoueurTest {

    private Joueur joueur;

    @BeforeEach
    public void setUp() {
        joueur = new Joueur();
        joueur.addCarte(new Carte(1, Couleur.CARREAU));
    }

    @Test
    public void addCarte() {
        joueur.addCarte(new Carte(5, Couleur.CARREAU));
        assertTrue(joueur.aEncoreDesCartes());
        joueur.donnerCarte();
        assertTrue(joueur.aEncoreDesCartes());
        joueur.donnerCarte();
        assertFalse(joueur.aEncoreDesCartes());
    }

    @Test
    public void donnerCarte() {
        assertTrue(joueur.aEncoreDesCartes());
        joueur.donnerCarte();
        assertFalse(joueur.aEncoreDesCartes());
    }

    @Test
    public void incScore() {
        assertEquals(joueur.getScore(), 0);
        joueur.incrementeScore();
        assertEquals(joueur.getScore(), 1);
        joueur.incrementeScore();
        assertEquals(joueur.getScore(), 2);
    }

    @Test
    public void aEncoreDesCartes() {
        assertTrue(joueur.aEncoreDesCartes());
        joueur.donnerCarte();
        assertFalse(joueur.aEncoreDesCartes());
    }

    @Test
    public void getScore() {
        assertEquals(joueur.getScore(), 0);
        joueur.incrementeScore();
        assertEquals(joueur.getScore(), 1);
        joueur.incrementeScore();
        assertEquals(joueur.getScore(), 2);
    }
}