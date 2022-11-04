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
public class Carte {

    private String val;
    private String coul;
    public int score;

    void calculScore() {
        score = 0;
        switch (val) {
            case "Valet":
                score += 24;//on attribue à chaque carte son score 
                break;
            case "Dame":
                score += 26;
                break;
            case "Roi":
                score += 28;
                break;
            case "As":
                score += 500;
                break;
            default:
                score += 2 * Integer.parseInt(val);//Integrer.parseInt(val) permet à l'ordinateur de considérer val comme une vraie valeur
                break;
        }
        switch (coul) {
            case "Pique":
                score += 22;
                break;
            case "Coeur":
                score += 14;
                break;
            case "Trefle":
                score += 16;
                break;
            case "Carreau":
                score += 18;
                break;
            default:
                if (("1".equals(val)) || ("2".equals(val)) || ("3".equals(val)) || ("4".equals(val)) || ("5".equals(val)) || ("6".equals(val)) || ("7".equals(val)) || ("8".equals(val)) || ("9".equals(val)) || ("10".equals(val))) {
                    score += 2 * Integer.parseInt(val);//on vérifie si la carte entrée existe
                } else {
                    val = "erreur";
                }
                break;
        }
        if (("erreur".equals(val)) || ("erreur".equals(coul))) {
            score = -1;

        }

    }

    void afficherCarte() {
        if (score == -1) {
            System.out.print("\n");
            System.out.println("Erreur de la carte :\nValeur = " + val + "\nCouleur = " + coul + "\nScore = -1");
        } else {
            System.out.print("\n");
            System.out.println("\nLa carte est :\n" + val + " de " + coul + "\nScore = " + score);
        }
    }
      
    

    String formatString() {
        return "\nLa carte est :\n" + val + " de " + coul + "\nscore = " + score;
    }

    boolean etreRoiDePique() {
        return (("Pique".equals(coul)) && ("Roi".equals(val)));
    }

    boolean etreAs() {
        return ("1".equals(val));
    }

    int get_Score() {
        return score;
    }

    Carte(String une_val, String une_coul) {
        val = une_val;
        coul = une_coul;
        calculScore();
    }
}



