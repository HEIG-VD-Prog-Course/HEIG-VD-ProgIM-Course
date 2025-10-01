package ch.comem.serie5;

/**
 * Ecrire une fonction qui additionne trois réels reçu en argument et 
 * qui retourne le résultat.
 * @author Jean-Pierre Hess
 */
public class Exercice02_RetourneAddition {
    
    // Règle les éventuels problèmes d'affichage des accents
    static {
        try {
            System.setOut(new java.io.PrintStream(
                    new java.io.FileOutputStream(java.io.FileDescriptor.out), true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException ex) {
            System.out.println("VM dont support UTF-8");
        }
    }
    
    public static void main(String[] args) {
        double reel1 = 4.5;
        double reel2 = 5.2;
        double reel3 = 6.4;
        double resultat = rendResultatAddition(reel1, reel2, reel3);
        System.out.println("Le résultat de l'addition est : " + resultat);
    }

    private static double rendResultatAddition(double r1, double r2, double r3) {
        return r1 + r2 + r3;
    }
    
}
