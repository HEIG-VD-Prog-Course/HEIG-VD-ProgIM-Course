package ch.comem.serie5;

import java.util.Locale;

/**
 * Ecrire une fonction permettant d'arrondir un chiffre à la précision voulue.
 *
 * @author Jean-Pierre Hess
 */
public class Exercice08_Arrondi {

    public static void main(String[] args) {
        double valeur = 1972;
        double precision = 50;
        System.out.println(arrondi(valeur, precision));

        valeur = 12.3333;
        precision = 0.05;
        System.out.println(arrondi(valeur, precision));
        valeur = -12.3333;
        precision = 0.05;
        System.out.println(arrondi(valeur, precision));

        // System.out.printf(...) permet de "customiser" la sortie dans la console
        // "%.2f" pour indiquer que nous aimerions juste deux chiffres après la virgule du réel
        System.out.printf("%.2f", arrondi(valeur, precision));
        System.out.println();
        System.out.printf(new Locale.Builder()
                .setLanguage("CH")
                .setRegion("fr")
                .build(), "%.2f", arrondi(valeur, precision));
        System.out.println();
    }

    /**
     * Permet d'arrondir la valeur spécifiée à la précision spécifiée
     *
     * @param valeur La valeur à arrondir
     * @param precision La précision à laquelle on désire arrondir
     * @return La valeur arrondie
     */
    private static double arrondi(double valeur, double precision) {
        return Math.signum(valeur) * Math.round(Math.abs(valeur) / precision) * precision;
    }

}
