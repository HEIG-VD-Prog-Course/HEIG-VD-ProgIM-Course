package ch.comem.serie5;

/**
 * Ecrire une fonction qui additionne trois réels reçu en argument et qui 
 * affiche le résultat sous la forme 4.5 + 5.2 + 6.4 = 16.1
 * @author Jean-Pierre Hess
 */
public class Exercice01_AfficheAddition {
    
    public static void main(String[] args) {
        double reel1 = 4.5;
        double reel2 = 5.2;
        double reel3 = 6.4;
        afficheResultatAddition(reel1, reel2, reel3);
    }

    /**
     * Affiche le résultat de l'addition des trois réels spécifiés
     * @param r1 Le premier réel
     * @param r2 Le second réel
     * @param r3 Le troisième réel
     */
    private static void afficheResultatAddition(double r1, double r2, double r3) {
        System.out.println(r1 + " + " + r2 + " + " + r3 + " = " + (r1+r2+r3));
    }
    
}
