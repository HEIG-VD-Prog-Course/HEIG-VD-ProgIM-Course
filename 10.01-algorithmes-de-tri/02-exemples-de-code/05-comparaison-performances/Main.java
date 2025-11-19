import java.util.Arrays;
import java.util.Random;

/**
 * Exemple de comparaison des performances des algorithmes de tri.
 * 
 * Ce programme mesure le temps d'exécution de différents algorithmes
 * de tri sur des tableaux de différentes tailles.
 * 
 * Documentation : https://docs.oracle.com/en/java/javase/17/docs/api/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exemple : Comparaison des performances ===\n");

        // Tailles de tableaux à tester
        int[] sizes = { 100, 1000, 5000 };

        for (int size : sizes) {
            System.out.println("=".repeat(60));
            System.out.println("Test avec " + size + " éléments");
            System.out.println("=".repeat(60));

            compareAlgorithms(size);
            System.out.println();
        }

        // Démonstration spécifique : tableau presque trié
        System.out.println("=".repeat(60));
        System.out.println("Test spécial : Tableau presque trié (10000 éléments)");
        System.out.println("=".repeat(60));

        testAlmostSorted(10000);

        System.out.println("\n=== Conclusions ===\n");
        System.out.println("1. Algorithmes simples (O(n²)) :");
        System.out.println("   - Tri à bulles, sélection, insertion");
        System.out.println("   - Acceptables pour petits tableaux (< 1000)");
        System.out.println("   - Très lents pour grands tableaux");
        System.out.println();
        System.out.println("2. Algorithmes efficaces (O(n log n)) :");
        System.out.println("   - Tri fusion (Merge Sort)");
        System.out.println("   - Recommandés pour tableaux moyens/grands");
        System.out.println("   - Performance stable et prévisible");
        System.out.println();
        System.out.println("3. Tri par insertion :");
        System.out.println("   - Excellent sur données presque triées");
        System.out.println("   - Adaptatif : s'adapte à l'ordre existant");
        System.out.println();
        System.out.println("4. Arrays.sort() (Java) :");
        System.out.println("   - Utilise Dual-Pivot Quicksort");
        System.out.println("   - Optimisé et très performant");
        System.out.println("   - À utiliser en production !");

        System.out.println("\n=== Fin de l'exemple ===");
    }

    /**
     * Compare les performances des différents algorithmes de tri.
     * 
     * @param size la taille du tableau à trier
     */
    public static void compareAlgorithms(int size) {
        // Générer un tableau aléatoire
        int[] original = generateRandomArray(size);

        System.out.println("\nGénération d'un tableau de " + size + " nombres aléatoires...\n");

        // Test Tri à bulles (limité aux petits tableaux)
        if (size <= 5000) {
            int[] array = original.clone();
            long time = measureTime(() -> bubbleSort(array));
            System.out.println(String.format("Tri à bulles      : %6d ms", time));
        } else {
            System.out.println("Tri à bulles      : (ignoré - trop lent pour cette taille)");
        }

        // Test Tri par sélection (limité aux petits tableaux)
        if (size <= 5000) {
            int[] array = original.clone();
            long time = measureTime(() -> selectionSort(array));
            System.out.println(String.format("Tri par sélection : %6d ms", time));
        } else {
            System.out.println("Tri par sélection : (ignoré - trop lent pour cette taille)");
        }

        // Test Tri par insertion
        int[] array1 = original.clone();
        long time = measureTime(() -> insertionSort(array1));
        System.out.println(String.format("Tri par insertion : %6d ms", time));

        // Test Tri fusion
        int[] array2 = original.clone();
        time = measureTime(() -> mergeSort(array2));
        System.out.println(String.format("Tri fusion        : %6d ms", time));

        // Test Arrays.sort() (référence)
        int[] array3 = original.clone();
        time = measureTime(() -> Arrays.sort(array3));
        System.out.println(String.format("Arrays.sort()     : %6d ms (référence Java)", time));
    }

    /**
     * Test spécifique pour tableau presque trié.
     * 
     * @param size la taille du tableau
     */
    public static void testAlmostSorted(int size) {
        // Générer un tableau presque trié (95% trié)
        int[] original = new int[size];
        for (int i = 0; i < size; i++) {
            original[i] = i;
        }

        // Échanger aléatoirement 5% des éléments
        Random rand = new Random(42);
        int swaps = size / 20;
        for (int i = 0; i < swaps; i++) {
            int idx1 = rand.nextInt(size);
            int idx2 = rand.nextInt(size);
            int temp = original[idx1];
            original[idx1] = original[idx2];
            original[idx2] = temp;
        }

        System.out.println("\nTableau avec 95% des éléments déjà dans le bon ordre...\n");

        // Test Tri par insertion (adaptatif)
        int[] array1 = original.clone();
        long time = measureTime(() -> insertionSort(array1));
        System.out.println(String.format("Tri par insertion : %6d ms (TRÈS EFFICACE)", time));

        // Test Tri fusion (non adaptatif)
        int[] array2 = original.clone();
        time = measureTime(() -> mergeSort(array2));
        System.out.println(String.format("Tri fusion        : %6d ms", time));
        System.out.println("\n→ Le tri par insertion est très performant sur");
        System.out.println("  des données presque triées (adaptatif) !");
    }

    /**
     * Génère un tableau de nombres aléatoires.
     * 
     * @param size la taille du tableau
     * @return le tableau généré
     */
    public static int[] generateRandomArray(int size) {
        Random rand = new Random(42); // Graine fixe pour reproductibilité
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size * 10);
        }

        return array;
    }

    /**
     * Mesure le temps d'exécution d'une opération.
     * 
     * @param operation l'opération à mesurer
     * @return le temps en millisecondes
     */
    public static long measureTime(Runnable operation) {
        long startTime = System.nanoTime();
        operation.run();
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000; // Convertir en ms
    }

    // ===== Implémentations des algorithmes de tri =====

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length <= 1)
            return;

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(int[] dest, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                dest[k++] = left[i++];
            } else {
                dest[k++] = right[j++];
            }
        }

        while (i < left.length)
            dest[k++] = left[i++];
        while (j < right.length)
            dest[k++] = right[j++];
    }
}
