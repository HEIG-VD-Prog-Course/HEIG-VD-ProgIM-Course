import java.util.Arrays;

/**
 * Exemple d'implémentation du tri par sélection (Selection Sort).
 * 
 * Le tri par sélection divise le tableau en deux parties : une partie triée
 * et une partie non triée. À chaque itération, il sélectionne le plus petit
 * élément de la partie non triée et le place à la fin de la partie triée.
 * 
 * Complexité : O(n²) dans tous les cas (meilleur, moyen, pire).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exemple : Tri par sélection ===\n");

        int[] numbers = { 64, 25, 12, 22, 11 };

        System.out.println("Tableau initial :");
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        // Tri avec affichage des étapes
        selectionSortVerbose(numbers.clone());

        System.out.println("\n--- Comptage des échanges ---\n");

        int[] numbers2 = { 64, 25, 12, 22, 11 };
        int swaps = selectionSortWithCount(numbers2);

        System.out.println("Tableau trié : " + Arrays.toString(numbers2));
        System.out.println("Nombre d'échanges : " + swaps);
        System.out.println("(Le tri par sélection effectue toujours n-1 échanges)");

        // Comparaison avec un tableau déjà trié
        System.out.println("\n--- Tableau déjà trié ---\n");
        int[] sorted = { 1, 2, 3, 4, 5 };

        System.out.println("Tableau initial : " + Arrays.toString(sorted));
        swaps = selectionSortWithCount(sorted);
        System.out.println("Tableau final : " + Arrays.toString(sorted));
        System.out.println("Nombre d'échanges : " + swaps);
        System.out.println("(Même nombre d'échanges, le tri par sélection");
        System.out.println(" n'est pas adaptatif)");

        System.out.println("\n=== Fin de l'exemple ===");
    }

    /**
     * Tri par sélection simple.
     * 
     * @param array le tableau à trier
     */
    public static void selectionSort(int[] array) {
        int n = array.length;

        // Parcourir le tableau
        for (int i = 0; i < n - 1; i++) {
            // Trouver le minimum dans la partie non triée
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Échanger le minimum avec le premier élément non trié
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * Tri par sélection avec affichage des étapes.
     * 
     * @param array le tableau à trier
     */
    public static void selectionSortVerbose(int[] array) {
        int n = array.length;

        System.out.println("--- Étapes du tri par sélection ---\n");

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Étape " + (i + 1) + " :");

            // Afficher la partie triée et non triée
            System.out.print("  Partie triée : [");
            for (int k = 0; k < i; k++) {
                System.out.print(array[k]);
                if (k < i - 1)
                    System.out.print(", ");
            }
            System.out.println("]");

            // Trouver le minimum dans la partie non triée
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            System.out.println("  Minimum trouvé : " + array[minIndex] +
                    " (position " + minIndex + ")");

            // Échanger
            if (minIndex != i) {
                System.out.println("  Échange " + array[i] +
                        " (position " + i + ") avec " +
                        array[minIndex] + " (position " + minIndex + ")");

                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            } else {
                System.out.println("  Pas d'échange nécessaire");
            }

            System.out.println("  Résultat : " + Arrays.toString(array));
            System.out.println();
        }

        System.out.println("Tableau final : " + Arrays.toString(array));
    }

    /**
     * Tri par sélection qui compte les échanges.
     * 
     * @param array le tableau à trier
     * @return le nombre d'échanges effectués
     */
    public static int selectionSortWithCount(int[] array) {
        int n = array.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Échanger (même si minIndex == i pour garder le comptage cohérent)
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            swapCount++;
        }

        return swapCount;
    }
}
