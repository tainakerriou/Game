/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbatailleklingonnienne2;

/**
 *
 * @author tkerriou
 */
public class Joueur {
 
    String nom;
    int jeton;
    Carte carteCourante;


    void attribuerCarte(Carte une_carteCourante) {
        carteCourante = une_carteCourante;
    }

    void jeterCarte() {
        carteCourante = null;
    }

    boolean possederJeton(int posseder_un_jeton) {
        return (jeton >= posseder_un_jeton);
    }

    void parier(int un_pari) {
        jeton = jeton - un_pari;
    }

    void recupererJeton(int un_gain) {
        jeton = jeton + un_gain;
    }

    int nombreJeton() {
        return jeton;
    }

    void AficherJeton() {
        System.out.println("\n Vous possédez " + jeton + " Jetons !");
    }

//Constructeur unique :
    Joueur(String un_joueur) {
        nom = un_joueur;
        jeton = 1000;
    }

}

