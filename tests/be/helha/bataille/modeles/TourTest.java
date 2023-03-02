package be.helha.bataille.modeles;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TourTest {

    @Test
    public void testToString() {
        Tour tour = new Tour(new Carte(1, Couleur.CARREAU), new Carte(2, Couleur.TREFLE));
        assertEquals(tour.toString(), "Tour : As de carreau vs 2 de trefle => Joueur 2 Gagnant");
        tour = new Tour(new Carte(5, Couleur.CARREAU), new Carte(2, Couleur.TREFLE));
        assertEquals(tour.toString(), "Tour : 5 de carreau vs 2 de trefle => Joueur 1 Gagnant");
    }

    @Test
    public void joueur1Gagnant() {
        Tour tour = new Tour(new Carte(1, Couleur.CARREAU), new Carte(2, Couleur.TREFLE));
        assertFalse(tour.joueur1Gagnant());
        tour = new Tour(new Carte(5, Couleur.CARREAU), new Carte(2, Couleur.TREFLE));
        assertTrue(tour.joueur1Gagnant());
    }
}