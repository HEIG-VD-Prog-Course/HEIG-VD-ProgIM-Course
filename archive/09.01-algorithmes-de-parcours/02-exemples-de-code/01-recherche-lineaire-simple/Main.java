/**
 * Exemple de recherche linéaire simple dans un tableau.
 * 
 * La recherche linéaire parcourt tous les éléments un par un jusqu'à
 * trouver l'élément recherché ou atteindre la fin du tableau.
 */
public class Main {
    

    /**
     * Effectue une recherche linéaire dans un tableau.
     * 
     * @param array  le tableau dans lequel chercher
     * @param target la valeur à chercher
     * @return l'index de l'élément trouvé, ou -1 si non trouvé
     */
    public static int linearSearch(int[] array, int target) {
        // Parcourir tous les éléments du tableau
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Élément trouvé, retourner l'index
            }
        }
        return -1; // Élément non trouvé
    }

    /**
     * Recherche linéaire qui compte le nombre de comparaisons.
     * 
     * @param array  le tableau dans lequel chercher
     * @param target la valeur à chercher
     * @return le nombre de comparaisons effectuées
     */
    public static int linearSearchWithCount(int[] array, int target) {
        int comparisons = 0;

        for (int i = 0; i < array.length; i++) {
            comparisons++;
            if (array[i] == target) {
                return comparisons;
            }
        }

        return comparisons; // Toutes les comparaisons effectuées
    }

    public static void main(String[] args) {
        System.out.println("=== Exemple : Recherche linéaire simple ===\n");

        int[] numbers = { 10, 25, 30, 45, 50, 65, 70, 85, 90 };

        // Recherche de plusieurs valeurs
        int[] toFind = { 30, 90, 10, 100 };

        for (int target : toFind) {
            int index = linearSearch(numbers, target);

            if (index != -1) {
                System.out.println("Élément " + target + " trouvé à l'index " + index);
            } else {
                System.out.println("Élément " + target + " non trouvé");
            }
        }

        // Démonstration du nombre de comparaisons
        System.out.println("\n--- Analyse des comparaisons ---\n");

        int target = 70;
        int comparisons = linearSearchWithCount(numbers, target);
        System.out.println("Recherche de " + target + " : " + comparisons + " comparaisons");

        target = 10;
        comparisons = linearSearchWithCount(numbers, target);
        System.out.println("Recherche de " + target + " : " + comparisons + " comparaisons");

        target = 100;
        comparisons = linearSearchWithCount(numbers, target);
        System.out.println("Recherche de " + target + " : " + comparisons + " comparaisons");

        System.out.println("\n=== Fin de l'exemple ===");
    }
}
