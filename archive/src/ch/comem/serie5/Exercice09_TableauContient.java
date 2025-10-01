package ch.comem.serie5;

/**
 * Ecrire une fonction prenant comme arguments un nombre et un tableau de réel et 
 * qui retourne un booléen permettant de savoir si le nombre et contenu dans le tableau.
 * @author Jean-Pierre Hess
 */
public class Exercice09_TableauContient {

    public static void main(String[] args) {
        double[] tab =  {2.1, 4.6, 6.2, 8.7, 10.1, 1/3d};
        double val = 0.33;
        System.out.println(tabContient(val, tab));
        val = 0.3333;
        System.out.println(tabContient(val, tab));
        val = 8.7;
        System.out.println(tabContient(val, tab));
    }

    /**
     * Permet de savoir si la valeur spécifiée se trouve dans le tableau ou non
     * @param val La valeur à chercher
     * @param tab Le tableau des valeurs
     * @return true si la valeur fait partie du tableau, false sinon
     */
    private static boolean tabContient(double val, double[] tab) {
        final double PRECISION = 0.0001; // comme les réels ne sont que des approximations !
                                         // il est fortement déconseillé d'utiliser l'opérateur == 
                                         // pour comparer des réels !
        // On s'arrête dès qu'on a trouvé la valeur
        int i = -1;
        boolean trouve = false;
        do {
            i++;
            trouve = Math.abs(tab[i] - val) <= PRECISION; 
        } while (!trouve && i<tab.length-1);
        return trouve;
    }
}