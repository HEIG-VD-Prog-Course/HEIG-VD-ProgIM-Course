import java.util.Arrays;

/**
 * Exemple d'implémentation du tri par insertion (Insertion Sort).
 * 
 * Le tri par insertion construit progressivement une partie triée en insérant
 * chaque nouvel élément à sa bonne position. C'est similaire à la façon dont
 * on trie des cartes à jouer dans sa main.
 * 
 * Complexité : O(n²) dans le pire cas, O(n) dans le meilleur cas (adaptatif).
 */
public class Main {
    

    /**
     * Tri par insertion simple.
     * 
     * @param array le tableau à trier
     */
    public static void insertionSort(int[] array) {
        int n = array.length;

        // Commencer à partir du deuxième élément
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Déplacer les éléments plus grands que key vers la droite
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // Insérer key à sa bonne position
            array[j + 1] = key;
        }
    }

    /**
     * Tri par insertion avec affichage des étapes.
     * 
     * @param array le tableau à trier
     */
    public static void insertionSortVerbose(int[] array) {
        int n = array.length;

        System.out.println("--- Étapes du tri par insertion ---\n");
        System.out.println("(Comme trier des cartes à jouer dans sa main)\n");

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            System.out.println("Étape " + i + " : Insérer " + key);

            // Afficher la partie triée
            System.out.print("  Partie triée avant insertion : [");
            for (int k = 0; k < i; k++) {
                System.out.print(array[k]);
                if (k < i - 1)
                    System.out.print(", ");
            }
            System.out.println("]");

            // Déplacer les éléments
            int shifts = 0;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                shifts++;
            }

            if (shifts > 0) {
                System.out.println("  → Décalage de " + shifts + " élément(s) vers la droite");
            } else {
                System.out.println("  → Pas de décalage nécessaire");
            }

            // Insérer
            array[j + 1] = key;

            System.out.print("  Partie triée après insertion : [");
            for (int k = 0; k <= i; k++) {
                System.out.print(array[k]);
                if (k < i)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("  Résultat complet : " + Arrays.toString(array));
            System.out.println();
        }

        System.out.println("Tableau final : " + Arrays.toString(array));
    }

    /**
     * Tri par insertion qui compte les comparaisons.
     * 
     * @param array le tableau à trier
     * @return le nombre de comparaisons effectuées
     */
    public static int insertionSortWithCount(int[] array) {
        int n = array.length;
        int comparisons = 0;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Compter les comparaisons
            while (j >= 0) {
                comparisons++;
                if (array[j] > key) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }

            array[j + 1] = key;
        }

        return comparisons;
    }

    /**
     * Version alternative avec déplacement explicite.
     * Utile pour comprendre le mécanisme d'insertion.
     * 
     * @param array le tableau à trier
     */
    public static void insertionSortAlternative(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];

            // Trouver la position d'insertion
            int insertPos = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > key) {
                    insertPos = j;
                } else {
                    break;
                }
            }

            // Décaler les éléments
            for (int k = i; k > insertPos; k--) {
                array[k] = array[k - 1];
            }

            // Insérer
            array[insertPos] = key;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Exemple : Tri par insertion ===\n");

        int[] numbers = { 12, 11, 13, 5, 6 };

        System.out.println("Tableau initial :");
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        // Tri avec affichage des étapes
        insertionSortVerbose(numbers.clone());

        // Test avec un tableau presque trié (adaptatif)
        System.out.println("\n--- Test avec tableau presque trié ---\n");
        int[] almostSorted = { 1, 2, 3, 8, 5, 6, 7, 4, 9, 10 };

        System.out.println("Tableau initial : " + Arrays.toString(almostSorted));
        int comparisons = insertionSortWithCount(almostSorted);
        System.out.println("Tableau trié : " + Arrays.toString(almostSorted));
        System.out.println("Comparaisons : " + comparisons);

        // Test avec un tableau complètement trié
        System.out.println("\n--- Test avec tableau déjà trié ---\n");
        int[] sorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println("Tableau initial : " + Arrays.toString(sorted));
        comparisons = insertionSortWithCount(sorted);
        System.out.println("Tableau final : " + Arrays.toString(sorted));
        System.out.println("Comparaisons : " + comparisons);
        System.out.println("(Le tri par insertion est très efficace sur");
        System.out.println(" des données déjà triées : O(n))");

        System.out.println("\n=== Fin de l'exemple ===");
    }
}
