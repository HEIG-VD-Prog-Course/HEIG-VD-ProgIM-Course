import java.util.Arrays;

/**
 * Exemple d'implémentation du tri fusion (Merge Sort).
 * 
 * Le tri fusion utilise la stratégie "diviser pour régner" :
 * 1. Diviser le tableau en deux moitiés
 * 2. Trier récursivement chaque moitié
 * 3. Fusionner les deux moitiés triées
 * 
 * Complexité : O(n log n) dans tous les cas.
 * Documentation : https://docs.oracle.com/en/java/javase/17/docs/api/
 */
public class Main {
    private static int indent = 0; // Pour l'affichage des étapes

    public static void main(String[] args) {
        System.out.println("=== Exemple : Tri fusion ===\n");

        int[] numbers = { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println("Tableau initial :");
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        // Tri avec affichage des étapes
        System.out.println("--- Étapes du tri fusion ---\n");
        int[] result = mergeSortVerbose(numbers);

        System.out.println("\nTableau final : " + Arrays.toString(result));

        // Démonstration sur un tableau plus grand
        System.out.println("\n--- Test sur un tableau plus grand ---\n");
        int[] largeArray = { 64, 34, 25, 12, 22, 11, 90, 88, 45, 50, 33, 17 };

        System.out.println("Tableau initial : " + Arrays.toString(largeArray));
        mergeSort(largeArray);
        System.out.println("Tableau trié : " + Arrays.toString(largeArray));

        // Comparaison de performance
        System.out.println("\n--- Performance ---");
        System.out.println("Pour n = 1000 éléments :");
        System.out.println("- Nombre d'opérations (approx) : n log n ≈ 10 000");
        System.out.println("- Tri à bulles nécessiterait : n² ≈ 1 000 000");
        System.out.println("→ Tri fusion est ~100x plus rapide !");

        System.out.println("\n=== Fin de l'exemple ===");
    }

    /**
     * Tri fusion simple (modifie le tableau en place).
     * 
     * @param array le tableau à trier
     */
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;

        // Diviser en deux sous-tableaux
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // Trier récursivement
        mergeSort(left);
        mergeSort(right);

        // Fusionner
        merge(array, left, right);
    }

    /**
     * Fusionne deux tableaux triés dans un tableau de destination.
     * 
     * @param dest  le tableau de destination
     * @param left  le tableau de gauche (trié)
     * @param right le tableau de droite (trié)
     */
    private static void merge(int[] dest, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Fusionner en comparant les éléments
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                dest[k++] = left[i++];
            } else {
                dest[k++] = right[j++];
            }
        }

        // Copier les éléments restants de left
        while (i < left.length) {
            dest[k++] = left[i++];
        }

        // Copier les éléments restants de right
        while (j < right.length) {
            dest[k++] = right[j++];
        }
    }

    /**
     * Tri fusion qui retourne un nouveau tableau (version verbose).
     * 
     * @param array le tableau à trier
     * @return un nouveau tableau trié
     */
    public static int[] mergeSortVerbose(int[] array) {
        printIndent();
        System.out.println("→ Trier : " + Arrays.toString(array));

        if (array.length <= 1) {
            printIndent();
            System.out.println("  (Tableau de taille 1 : déjà trié)");
            return array;
        }

        int mid = array.length / 2;

        // Diviser
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        printIndent();
        System.out.println("  Diviser en : " + Arrays.toString(left) +
                " et " + Arrays.toString(right));

        // Récursion
        indent += 2;
        int[] sortedLeft = mergeSortVerbose(left);
        int[] sortedRight = mergeSortVerbose(right);
        indent -= 2;

        // Fusionner
        int[] result = mergeArrays(sortedLeft, sortedRight);

        printIndent();
        System.out.println("  Fusionner " + Arrays.toString(sortedLeft) +
                " et " + Arrays.toString(sortedRight) +
                " → " + Arrays.toString(result));

        return result;
    }

    /**
     * Fusionne deux tableaux triés en un nouveau tableau trié.
     * 
     * @param left  le tableau de gauche (trié)
     * @param right le tableau de droite (trié)
     * @return le tableau fusionné et trié
     */
    private static int[] mergeArrays(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Fusionner en comparant
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Copier les restants
        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    /**
     * Affiche l'indentation pour visualiser la récursion.
     */
    private static void printIndent() {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
    }
}
