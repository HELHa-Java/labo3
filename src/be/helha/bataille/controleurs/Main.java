package be.helha.bataille.controleurs;

import be.helha.bataille.modeles.Jeu;
import be.helha.bataille.vues.UI;

// TODO : Vérifier que le jeu fonctionne (Bataille simple)
// TODO : Comprendre la structure du code (MVC)
// TODO : Corriger les 2 tests qui ne passent pas
// TODO : Comprendre les setUp (@BeforeEach) et le assertThrows dans les tests
// TODO : Modifier la méthode UI.afficheTour pour que le MVC soit respecté
// TODO : Ajouter le choix de la carte à jouer par chaque joueur à chaque tour (oui, ce n'est plus donc la bataille ;))
// TODO : Permettre de jouer à plus que 3 joueurs (c'est celui qui a la meilleure carte qui gagne)
// TODO : Permettre de choisir le nombre de joueurs dès le début du jeu
// TODO : Tout tester

/**
 * Contrôleur principal
 */
public class Main {

    public static void main(String[] args) {
        // Création du modèle de jeu
        Jeu jeu = new Jeu();

        // Création de la vue
        UI ui = new UI(jeu);

        ActionEnum action;
        do {
            jeu.mélanger();
            jeu.distribue();
            while (!jeu.estFini()) {
                ui.afficheTour(jeu.jouerUnTour());
            }
            ui.afficheFin();
            jeu.reinitialise();
            action = ui.quelleAction();
        } while (action != ActionEnum.QUITTER);

    }
}
