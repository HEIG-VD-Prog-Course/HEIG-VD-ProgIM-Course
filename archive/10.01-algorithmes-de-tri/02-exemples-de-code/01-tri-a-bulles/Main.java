import java.util.Arrays;

/**
 * Exemple d'implémentation du tri à bulles (Bubble Sort).
 * 
 * Le tri à bulles compare des paires d'éléments adjacents et les échange
 * s'ils sont dans le mauvais ordre. Il répète ce processus jusqu'à ce que
 * le tableau soit complètement trié.
 * 
 * Complexité : O(n²) dans le cas moyen et pire cas.
 */
public class Main {
    

    /**
     * Tri à bulles simple.
     * 
     * @param array le tableau à trier
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Échanger les éléments
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Tri à bulles optimisé avec détection d'arrêt anticipé.
     * Si aucun échange n'est effectué lors d'un passage, le tableau est trié.
     * 
     * @param array le tableau à trier
     */
    public static void bubbleSortOptimized(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Échanger les éléments
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // Si aucun échange, le tableau est trié
            if (!swapped) {
                System.out.println("Tableau déjà trié après " + (i + 1) + " passage(s)");
                break;
            }
        }
    }

    /**
     * Tri à bulles avec affichage des étapes.
     * 
     * @param array le tableau à trier
     */
    public static void bubbleSortVerbose(int[] array) {
        int n = array.length;
        int passNumber = 1;

        System.out.println("--- Étapes du tri à bulles ---\n");

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Passage " + passNumber + " :");
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    System.out.println("  Échange " + array[j] + " et " + array[j + 1]);

                    // Échanger
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("  Résultat : " + Arrays.toString(array));

            if (!swapped) {
                System.out.println("  → Tableau trié !");
                break;
            }

            passNumber++;
        }
    }

    /**
     * Tri à bulles qui compte les comparaisons.
     * 
     * @param array le tableau à trier
     * @return le nombre de comparaisons effectuées
     */
    public static int bubbleSortWithCount(int[] array) {
        int n = array.length;
        int comparisons = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return comparisons;
    }

    public static void main(String[] args) {
        System.out.println("=== Exemple : Tri à bulles ===\n");

        int[] numbers = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Tableau initial :");
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        // Tri avec affichage des étapes
        bubbleSortVerbose(numbers.clone());

        System.out.println("\n--- Tri optimisé ---\n");

        int[] numbers2 = { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSortOptimized(numbers2);

        System.out.println("Tableau trié :");
        System.out.println(Arrays.toString(numbers2));

        // Test avec un tableau déjà trié
        System.out.println("\n--- Test avec tableau déjà trié ---\n");
        int[] sorted = { 1, 2, 3, 4, 5, 6, 7 };

        System.out.println("Tableau initial : " + Arrays.toString(sorted));
        int comparisons = bubbleSortWithCount(sorted);
        System.out.println("Comparaisons effectuées : " + comparisons);
        System.out.println("(Optimisation détectée : tableau déjà trié)");

        System.out.println("\n=== Fin de l'exemple ===");
    }
}
