import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Exemple de recherche dans différentes collections Java.
 * 
 * Java fournit des méthodes intégrées pour effectuer des recherches
 * dans les tableaux et les collections.
 * 
 * Documentation : https://docs.oracle.com/en/java/javase/17/docs/api/
 */
public class Main {
    

    /**
     * Démonstration de la recherche dans ArrayList.
     */
    public static void demonstrateArrayList() {
        System.out.println("--- Recherche dans ArrayList ---\n");

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Yverdon-les-Bains");
        cities.add("Lausanne");
        cities.add("Genève");
        cities.add("Berne");
        cities.add("Zurich");

        System.out.println("Villes : " + cities);

        // indexOf() : retourne l'index de l'élément (recherche linéaire)
        int index = cities.indexOf("Genève");
        System.out.println("\nindex de 'Genève' : " + index);

        index = cities.indexOf("Fribourg");
        System.out.println("index de 'Fribourg' : " + index + " (non trouvé)");

        // contains() : vérifie si l'élément existe
        boolean exists = cities.contains("Lausanne");
        System.out.println("\nContient 'Lausanne' ? " + exists);

        exists = cities.contains("Paris");
        System.out.println("Contient 'Paris' ? " + exists);

        // lastIndexOf() : dernière occurrence
        cities.add("Lausanne"); // Doublon
        System.out.println("\nVilles avec doublon : " + cities);
        System.out.println("Première occurrence de 'Lausanne' : " + cities.indexOf("Lausanne"));
        System.out.println("Dernière occurrence de 'Lausanne' : " + cities.lastIndexOf("Lausanne"));
    }

    /**
     * Démonstration de la recherche dans les tableaux.
     */
    public static void demonstrateArrays() {
        System.out.println("\n--- Recherche dans les tableaux ---\n");

        int[] numbers = { 5, 2, 8, 1, 9, 3, 7 };
        System.out.println("Tableau non trié : " + Arrays.toString(numbers));

        // Recherche binaire nécessite un tableau trié
        Arrays.sort(numbers);
        System.out.println("Tableau trié     : " + Arrays.toString(numbers));

        // Arrays.binarySearch()
        int index = Arrays.binarySearch(numbers, 7);
        System.out.println("\nRecherche de 7 : index " + index);

        index = Arrays.binarySearch(numbers, 4);
        System.out.println("Recherche de 4 : " + index + " (non trouvé)");

        // Valeur négative indique l'insertion point
        if (index < 0) {
            int insertionPoint = -(index + 1);
            System.out.println("  → Devrait être inséré à l'index " + insertionPoint);
        }

        // Recherche dans un tableau de chaînes
        String[] names = { "Ariel", "Amaru", "Nox", "Ayo" };
        System.out.println("\nTableau de noms non trié : " + Arrays.toString(names));

        Arrays.sort(names);
        System.out.println("Tableau de noms trié     : " + Arrays.toString(names));

        index = Arrays.binarySearch(names, "Nox");
        System.out.println("Recherche de 'Nox' : index " + index);
    }

    /**
     * Démonstration de Collections.binarySearch().
     */
    public static void demonstrateCollectionsBinarySearch() {
        System.out.println("\n--- Collections.binarySearch() ---\n");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(10);
        numbers.add(30);

        System.out.println("Liste non triée : " + numbers);

        // Trier avant la recherche binaire
        Collections.sort(numbers);
        System.out.println("Liste triée     : " + numbers);

        // Recherche binaire
        int index = Collections.binarySearch(numbers, 30);
        System.out.println("\nRecherche de 30 : index " + index);

        index = Collections.binarySearch(numbers, 25);
        System.out.println("Recherche de 25 : " + index + " (non trouvé)");

        // Comparaison de performance
        System.out.println("\n--- Test de performance ---\n");

        ArrayList<Integer> largeList = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            largeList.add(i);
        }

        // Recherche linéaire (indexOf)
        long startTime = System.nanoTime();
        int pos1 = largeList.indexOf(99999);
        long linearTime = System.nanoTime() - startTime;

        // Recherche binaire
        startTime = System.nanoTime();
        int pos2 = Collections.binarySearch(largeList, 99999);
        long binaryTime = System.nanoTime() - startTime;

        System.out.println("Recherche dans une liste de 100'000 éléments :");
        System.out.println("  Recherche linéaire : " + linearTime + " ns");
        System.out.println("  Recherche binaire  : " + binaryTime + " ns");
        System.out.println("  Rapport : " + (linearTime / binaryTime) + "x plus rapide");
    }

    public static void main(String[] args) {
        System.out.println("=== Exemple : Recherche dans des collections ===\n");

        // Recherche dans ArrayList
        demonstrateArrayList();

        // Recherche dans les tableaux
        demonstrateArrays();

        // Recherche binaire avec Collections
        demonstrateCollectionsBinarySearch();

        System.out.println("\n=== Fin de l'exemple ===");
    }
}
