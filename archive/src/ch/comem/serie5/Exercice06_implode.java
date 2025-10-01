package ch.comem.serie5;

/**
 * Ecrire une fonction nommée 'implode' prenant comme argument :
 *  - un séparateur de son choix (virgule par exemple)
 *  - un tableau de réels
 * et qui rend une chaine de caractère contenant les éléments du tableau séparés par le caractère voulu : 5.5, 7.6, 3.1, 9.2, 56.4 
 * @author Jean-Pierre Hess
 */
public class Exercice06_implode {

    public static void main(String[] args) {
        double[] reels = {5.5, 7.6, 3.1, 9.2, 56.4};
        System.out.println(implode(", ",reels));
    }

    private static String implode(String separateur, double[] reels) {
        String chaine = "";
        if (reels != null && reels.length >= 1) {
            for (int i = 0; i < reels.length-1; i++) {
                chaine+= reels[i] + separateur;
            }
            chaine+=reels[reels.length-1];
        }
        return chaine;
    }
    
}