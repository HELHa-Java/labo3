package be.helha.bataille.modeles;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarteTest {

    @Test
    public void estAvant() {
        assertTrue(new Carte(1,Couleur.CARREAU).estAvant(new Carte(3, Couleur.TREFLE)));
        assertFalse(new Carte(3,Couleur.CARREAU).estAvant(new Carte(1, Couleur.TREFLE)));
        assertTrue(new Carte(10,Couleur.CARREAU).estAvant(new Carte(11, Couleur.TREFLE)));
        assertFalse(new Carte(11,Couleur.CARREAU).estAvant(new Carte(10, Couleur.TREFLE)));
    }

    @Test
    public void testToString() {
        assertEquals(new Carte(1,Couleur.CARREAU).toString(), "As de carreau");
        assertEquals(new Carte(2,Couleur.COEUR).toString(), "2 de coeur");
        assertEquals(new Carte(11,Couleur.CARREAU).toString(), "Valet de carreau");
        assertEquals(new Carte(12,Couleur.TREFLE).toString(), "Dame de trefle");
        assertEquals(new Carte(13,Couleur.PIQUE).toString(), "Roi de pique");
    }


    @Test
    public void equals() {
        assertEquals(new Carte(1,Couleur.CARREAU), new Carte(1,Couleur.CARREAU));
        assertNotEquals(new Carte(1,Couleur.CARREAU), new Carte(1,Couleur.TREFLE));
        assertNotEquals(new Carte(2,Couleur.CARREAU), new Carte(1,Couleur.CARREAU));
        assertNotEquals(new Carte(10,Couleur.CARREAU), new Carte(5,Couleur.TREFLE));
    }

}