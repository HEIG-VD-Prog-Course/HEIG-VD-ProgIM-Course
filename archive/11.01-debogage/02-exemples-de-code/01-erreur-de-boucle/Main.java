/**
 * Exemple de débogage : Erreur de boucle
 * 
 * Ce programme contient un bug qui cause une ArrayIndexOutOfBoundsException.
 * 
 * MISSION :
 * 1. Placer un breakpoint dans la boucle
 * 2. Lancer le débogueur (F5)
 * 3. Surveiller la variable 'i' et comparer avec 'numbers.length'
 * 4. Identifier le problème et le corriger
 */
public class Main {
    

    /**
     * Calcule la somme des éléments d'un tableau.
     * 
     * ATTENTION : Cette méthode contient un bug !
     * 
     * @param numbers le tableau de nombres
     * @return la somme des éléments
     */
    public static int calculateSum(int[] numbers) {
        int sum = 0;

        // BUG : <= au lieu de <
        // Cela fait que i atteint numbers.length, ce qui dépasse le tableau
        for (int i = 0; i <= numbers.length; i++) {
            sum += numbers[i]; // ArrayIndexOutOfBoundsException quand i = 5
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== Débogage : Erreur de boucle ===\n");

        int[] numbers = { 10, 20, 30, 40, 50 };

        System.out.println("Calcul de la somme des nombres...");

        // BUG INTENTIONNEL ICI
        int sum = calculateSum(numbers);

        System.out.println("Somme totale : " + sum);

        System.out.println("\n=== Fin de l'exemple ===");
    }
}

/*
 * CORRECTION :
 * 
 * Changer la condition de boucle de :
 * for (int i = 0; i <= numbers.length; i++)
 * 
 * En :
 * for (int i = 0; i < numbers.length; i++)
 * 
 * EXPLICATION :
 * - Un tableau de taille 5 a des indices de 0 à 4
 * - Utiliser <= fait que i atteint 5, ce qui est hors limites
 * - Utiliser < garantit que i reste dans les limites (0 à 4)
 */
