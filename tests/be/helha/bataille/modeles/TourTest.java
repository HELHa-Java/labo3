package be.helha.bataille.modeles;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TourTest {

    @Test
    public void testToString() {
        Tour tour = new Tour(new Carte(1, Couleur.CARREAU), new Carte(2, Couleur.TREFFLE));
        assertEquals(tour.toString(), "Tour : As de carreau vs 2 de treffle => Joueur 2 Gagnant");
        tour = new Tour(new Carte(5, Couleur.CARREAU), new Carte(2, Couleur.TREFFLE));
        assertEquals(tour.toString(), "Tour : 5 de carreau vs 2 de treffle => Joueur 1 Gagnant");
    }

    @Test
    public void joueur1Gagnant() {
        Tour tour = new Tour(new Carte(1, Couleur.CARREAU), new Carte(2, Couleur.TREFFLE));
        assertFalse(tour.joueur1Gagnant());
        tour = new Tour(new Carte(5, Couleur.CARREAU), new Carte(2, Couleur.TREFFLE));
        assertTrue(tour.joueur1Gagnant());
    }
}