package be.helha.bataille.vues;

import be.helha.bataille.controleurs.ActionEnum;
import be.helha.bataille.modeles.Jeu;
import be.helha.bataille.modeles.Joueur;
import be.helha.bataille.modeles.Tour;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    private final Jeu jeu;

    public UI(Jeu jeu) {
        this.jeu = jeu;
    }

    public ActionEnum quelleAction() {
        System.out.println("Que faire ?");
        System.out.println("1. rejouer");
        System.out.println("2. quitter");
        int entree = getIntFromInput(1, 2);
        if (entree == 1) {
            return ActionEnum.REJOUER;
        } else {
            return ActionEnum.QUITTER;
        }
    }

    private int getIntFromInput(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int entree = scanner.nextInt();
                if (entree >= min && entree <= max) {
                    return entree;
                }
            } catch (InputMismatchException e) {
                scanner.next();
            }
        }
    }

    public void afficheTour(Tour tour) {
        System.out.println(tour);
    }

    public void afficheFin() {
        System.out.println("Points finaux :");
        int i = 1;
        for (Joueur joueur : jeu.getJoueurs()) {
            System.out.println("Joueur " + i + " : " + joueur.getScore() + " points");
            i++;
        }
    }
}
