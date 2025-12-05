/**
 * Exemple de débogage : Boucle infinie
 * 
 * Ce programme contient une boucle qui ne se termine jamais.
 * 
 * MISSION :
 * 1. Placer un breakpoint dans la boucle
 * 2. Lancer le débogueur (F5)
 * 3. Faire plusieurs Step Over (F10)
 * 4. Observer la valeur de la variable de boucle
 * 5. Identifier pourquoi la condition ne devient jamais fausse
 */
public class Main {
    

    /**
     * Affiche les nombres de 1 à 10.
     * 
     * BUG : Boucle infinie due à l'oubli d'incrémentation !
     */
    public static void printNumbers() {
        int count = 1;

        // BUG : count n'est jamais incrémenté
        while (count <= 10) {
            System.out.println(count);
            // Oubli de count++
        }
    }

    /**
     * Exemple supplémentaire avec une boucle for incorrecte.
     */
    public static void anotherInfiniteLoop() {
        // BUG : i-- au lieu de i++
        for (int i = 0; i < 10; i--) {
            System.out.println(i);
        }
    }

    /**
     * Exemple avec condition qui ne peut jamais être vraie.
     */
    public static void impossibleCondition() {
        int value = 5;

        // BUG : La condition ne sera jamais vraie
        while (value < 10) {
            System.out.println("Valeur : " + value);
            value = value - 1; // value diminue au lieu d'augmenter !
        }
    }
}

/*
 * CORRECTIONS :
 * 
 * 1. Dans printNumbers() :
 * - Ajouter l'incrémentation oubliée :
 * while (count <= 10) {
 * System.out.println(count);
 * count++; // <- Ajouter cette ligne
 * }
 * 
 * 2. Dans anotherInfiniteLoop() :
 * - Changer i-- en i++ :
 * for (int i = 0; i < 10; i++) {
 * System.out.println(i);
 *

    public static void main(String[] args) {
        System.out.println("=== Débogage : Boucle infinie ===\n");

        System.out.println("Affichage des nombres de 1 à 10 :");

        // BUG : Cette boucle ne se termine jamais
        printNumbers();

        System.out.println("\n=== Fin de l'exemple ===");
    }
}
 * 
 * 3. Dans impossibleCondition() :
 * - Changer l'opération :
 * value = value + 1; // Au lieu de value - 1
 * 
 * EXPLICATION :
 * - Les boucles infinies sont causées par des conditions qui ne deviennent
 * jamais fausses
 * - Le débogueur permet de voir si la variable de contrôle change
 * - Utiliser Step Over plusieurs fois pour voir l'évolution des variables
 * - Si une variable ne change pas alors qu'elle devrait, c'est probablement le
 * bug
 */
