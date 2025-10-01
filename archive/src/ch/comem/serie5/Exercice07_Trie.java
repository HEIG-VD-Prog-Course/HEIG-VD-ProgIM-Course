package ch.comem.serie5;

import java.util.Arrays;

/**
 * Ecrire une fonction permettant de trier les éléments d'un tableau par ordre
 * croissant.
 * @author Jean-Pierre Hess
 */
public class Exercice07_Trie {

    public static void main(String[] args) {
        int[] valeurs = {5, 6, 3, 1};
        trie(valeurs);
        System.out.println(Arrays.toString(valeurs));
    }

    /**
     * Permet de trier par ordre croissant les valeurs du tableau spécifié
     * @param tabVals Le tableau contenant les valeurs à trier
     */
    private static void trie(int[] tabVals) {
        int n = tabVals.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tabVals[j] > tabVals[j + 1]) {
                    // On permute les éléments
                    temp = tabVals[j];
                    tabVals[j] = tabVals[j + 1];
                    tabVals[j + 1] = temp;
                }
            }
        }
    }

}
