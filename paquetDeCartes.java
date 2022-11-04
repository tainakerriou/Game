/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbatailleklingonnienne2;
import java.util.Random;
/**
 *
 * @author tkerriou
 */
public class paquetDeCartes {
    
           
    String val;
    Carte[] tabCartes = new Carte[52];
    int nombreCartesRestantes;

    paquetDeCartes() {
        nombreCartesRestantes = 52;
        int i = 0;
        String CouleursPossibles[] = {"Coeur", "Carreau", "Trefle", "Pique"};// tableau de string des couleurs possibles
        String ValeurPossibles[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi"}; //  tableau de string des valeurs possibles

      
        for (String coulCourant : CouleursPossibles) {
            for (String valCourant : ValeurPossibles) {
                tabCartes[i] = new Carte(valCourant, coulCourant);
                System.out.println("\nLa carte est :\n" + valCourant + " de " + coulCourant);
                i++;
            }
        }
        Melanger();
    }

    void Melanger() {
        Random generateurAleat = new Random();
        int i, j;

        for (int k = 0; k <= 300; k++) {
            i = generateurAleat.nextInt(52); // nombre entre 0 et 51
            j = generateurAleat.nextInt(52); // nombre entre 0 et 51
            Carte temps = tabCartes[i];
            tabCartes[i] = tabCartes[j];
            tabCartes[j] = temps;
        }
    }

    Carte PochaineCarte() {
        nombreCartesRestantes--;
        Carte CarteHaute = tabCartes[nombreCartesRestantes];
        tabCartes[nombreCartesRestantes] = null;
        return CarteHaute;
    }

    boolean estVide() {
        return nombreCartesRestantes != 0; 
    }

    void AfficherPaquet() {
        for (int i = nombreCartesRestantes - 1; i >= 0; i--) {
            System.out.println(tabCartes[i].formatString());
        }
    }
}


