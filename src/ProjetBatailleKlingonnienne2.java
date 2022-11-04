/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbatailleklingonnienne2;

import java.util.Scanner;

/**
 *
 * @author tkerriou
 */
public class ProjetBatailleKlingonnienne2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Bonjour,vous pouvez commencer la partie");
        /*
        Carte une_carte = new Carte("10", "Trefle") ;
        Carte deux_carte = new Carte("0", "Coeur") ;
        une_carte.afficherCarte();
        deux_carte.afficherCarte();
        Joueur moi = new Joueur("Marie");
        Joueur ordinateur = new Joueur("Ordinateur");
        */
        
        Joueur moi = new Joueur("Taina");
        Joueur ordinateur = new Joueur("Ordinateur");
        Partie une_partie1 = new Partie(moi, ordinateur);
        une_partie1.lancerPartie();

    }
}
    
   

