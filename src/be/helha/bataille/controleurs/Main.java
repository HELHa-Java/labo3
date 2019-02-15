package be.helha.bataille.controleurs;

import be.helha.bataille.modeles.Jeu;
import be.helha.bataille.vues.UI;

// TODO : Vérifier que le jeu fonctionne (Bataille simple)
// TODO : Comprendre la structure du code (MVC)
// TODO : Corriger les 2 tests qui ne passent pas
// TODO : Comprendre les setUp (@Before) dans les tests
// TODO : Modifier la méthode UI.afficheTour pour que le MVC soit respecté
// TODO : Ajouter la règle suivante : si les deux cartes sont à égalité, aucun point n'est donné aux joueurs
// TODO : Ajouter la règle suivante : un 8 l'emporte toujours sur n'importe quelle autre carte
// TODO : Ajouter le choix de la carte à jouer par chaque joueur à chaque tour
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
