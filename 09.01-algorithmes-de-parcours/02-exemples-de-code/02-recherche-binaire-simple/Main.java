/**
 * Exemple de recherche binaire dans un tableau trié.
 * 
 * La recherche binaire divise répétitivement la zone de recherche en deux,
 * éliminant la moitié des éléments à chaque étape. Elle nécessite que les
 * données soient triées.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exemple : Recherche binaire simple ===\n");

        // Tableau trié (condition obligatoire pour la recherche binaire)
        int[] sortedNumbers = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 };

        System.out.println("Tableau trié : ");
        printArray(sortedNumbers);

        // Recherche de plusieurs valeurs
        int[] toFind = { 25, 5, 50, 17 };

        System.out.println("\n--- Recherches ---\n");
        for (int target : toFind) {
            int index = binarySearch(sortedNumbers, target);

            if (index != -1) {
                System.out.println("Élément " + target + " trouvé à l'index " + index);
            } else {
                System.out.println("Élément " + target + " non trouvé");
            }
        }

        // Comparaison du nombre de comparaisons
        System.out.println("\n--- Comparaison linéaire vs binaire ---\n");

        int target = 45;
        int linearComparisons = linearSearchWithCount(sortedNumbers, target);
        int binaryComparisons = binarySearchWithCount(sortedNumbers, target);

        System.out.println("Recherche de " + target + " :");
        System.out.println("  Linéaire : " + linearComparisons + " comparaisons");
        System.out.println("  Binaire  : " + binaryComparisons + " comparaisons");

        // Démonstration étape par étape
        System.out.println("\n--- Étapes de la recherche binaire ---\n");
        binarySearchVerbose(sortedNumbers, 35);

        System.out.println("\n=== Fin de l'exemple ===");
    }

    /**
     * Effectue une recherche binaire dans un tableau trié.
     * 
     * @param array  le tableau trié dans lequel chercher
     * @param target la valeur à chercher
     * @return l'index de l'élément trouvé, ou -1 si non trouvé
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            // Calculer l'index du milieu
            int middle = left + (right - left) / 2;

            // Élément trouvé
            if (array[middle] == target) {
                return middle;
            }

            // L'élément est dans la moitié droite
            if (array[middle] < target) {
                left = middle + 1;
            }
            // L'élément est dans la moitié gauche
            else {
                right = middle - 1;
            }
        }

        return -1; // Élément non trouvé
    }

    /**
     * Recherche binaire qui compte le nombre de comparaisons.
     * 
     * @param array  le tableau trié dans lequel chercher
     * @param target la valeur à chercher
     * @return le nombre de comparaisons effectuées
     */
    public static int binarySearchWithCount(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int comparisons = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            comparisons++;

            if (array[middle] == target) {
                return comparisons;
            }

            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return comparisons;
    }

    /**
     * Recherche linéaire avec comptage (pour comparaison).
     */
    public static int linearSearchWithCount(int[] array, int target) {
        int comparisons = 0;

        for (int i = 0; i < array.length; i++) {
            comparisons++;
            if (array[i] == target) {
                return comparisons;
            }
        }

        return comparisons;
    }

    /**
     * Recherche binaire avec affichage détaillé des étapes.
     * 
     * @param array  le tableau trié
     * @param target la valeur à chercher
     */
    public static void binarySearchVerbose(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int step = 1;

        System.out.println("Recherche de " + target + " :");

        while (left <= right) {
            int middle = left + (right - left) / 2;

            System.out.println("Étape " + step + " :");
            System.out.println("  Zone [" + left + " ... " + right + "]");
            System.out.println("  Milieu à l'index " + middle + " = " + array[middle]);

            if (array[middle] == target) {
                System.out.println("  ✓ Trouvé !");
                return;
            }

            if (array[middle] < target) {
                System.out.println("  → Chercher à droite");
                left = middle + 1;
            } else {
                System.out.println("  → Chercher à gauche");
                right = middle - 1;
            }

            step++;
        }

        System.out.println("Non trouvé");
    }

    /**
     * Affiche un tableau.
     */
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
