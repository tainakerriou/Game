/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbatailleklingonnienne2;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author tkerriou
 */
public class Partie {
    Joueur joueur1;
    Joueur joueur2;
    paquetDeCartes paquet;
    int mise1;
    int mise2;


    Partie(Joueur un_joueur1, Joueur un_joueur2) {
        joueur1 = un_joueur1;
        joueur2 = un_joueur2;
        paquet = new paquetDeCartes();
    }


    void distribuerCartes() {
        joueur1.attribuerCarte(paquet.PochaineCarte());
        joueur2.attribuerCarte(paquet.PochaineCarte());
    }

    void demanderMises() {
        System.out.println("\nVous pariez une mise de : ");

        Scanner sc = new Scanner(System.in);
        mise1 = sc.nextInt();

        while (mise1 < 0 || !joueur1.possederJeton(mise1)) {
            System.out.println("Erreur, veuillez parier une autre mise : ");
            mise1 = sc.nextInt();
        }
        joueur1.parier(mise1);

        System.out.println("\nVotre adversaire a parié une mise de : ");
        Random rand = new Random();
        mise2 = ((1 + rand.nextInt(joueur2.jeton - 1)) * joueur2.carteCourante.get_Score()) / 50;
        System.out.print(mise2);
        joueur2.parier(mise2);
    }

    Carte comparerCartes(Carte carte1, Carte carte2) {
        Carte carte_win;

        if (carte1.etreRoiDePique() && carte2.etreAs()) { 
            carte_win = carte2;
        } else if (carte1.etreAs() && carte2.etreRoiDePique()) {
            carte_win = carte2;
        } else if (carte1.get_Score() > carte2.get_Score()) {
            carte_win = carte2;
        } else if (carte2.get_Score() > carte1.get_Score()) {
            carte_win = carte2;
        } else {
            carte_win = null;
        }
        return carte_win;
    }

    Joueur determinerGagnant() {
        Carte victoire;
        Joueur vainqueur = null;
        victoire = comparerCartes(joueur1.carteCourante, joueur2.carteCourante);

        if (victoire == null) {
            vainqueur = null;
        } else if (victoire == joueur1.carteCourante) {
            vainqueur = joueur1;
        } else if (victoire == joueur2.carteCourante) {
            vainqueur = joueur2;
        }
        return vainqueur;
    }

    void distribueGains() {
        if (determinerGagnant() == joueur1) {
            if (mise1 >= mise2) {
                joueur1.recupererJeton(mise1 + mise2);
            } else if (mise1 < mise2) {
                joueur1.recupererJeton(2 * mise1);
                joueur2.recupererJeton(mise2 - mise1);
            }
        } else if (determinerGagnant() == joueur2) {
            if (mise2 >= mise1) {
                joueur2.recupererJeton(mise2 + mise1);
            } else if (mise2 < mise1) {
                joueur2.recupererJeton(2 * mise2);
                joueur1.recupererJeton(mise1 - mise2);
            }
        } else if (determinerGagnant() == null) {
            joueur1.recupererJeton(mise1);
            joueur2.recupererJeton(mise2);
        }
    }

    void nettoyage() {
        joueur1.jeterCarte();
        joueur2.jeterCarte();
        mise1 = 0;
        mise2 = 0;
    }

    void scoresJoueurs() {
        System.out.println("\nVous possédez " + joueur1.nombreJeton() + " jetons \n Votre adversaire possède " + joueur2.nombreJeton() + " jetons");
    }

    void gagantJeu() {
        if (joueur1.nombreJeton() >= joueur2.nombreJeton()) {
            System.out.println("Vous avez gagné !!");
        } else {
            System.out.println("Vous avez perdu !!");
        }
    }

    void tourDeJeu() {
        distribuerCartes();
        joueur1.carteCourante.afficherCarte();
        demanderMises();
        determinerGagnant();
        distribueGains();
        nettoyage();
        scoresJoueurs();
    }

    void lancerPartie() {
        do {
            tourDeJeu();
        } while (paquet.estVide() && joueur1.possederJeton(1) && joueur2.possederJeton(1));

        System.out.println("\n La partie est terminée");
        gagantJeu();
        scoresJoueurs();
        System.out.println("\n Vous pouvez rejouer ou nous quitter");
    }

}


