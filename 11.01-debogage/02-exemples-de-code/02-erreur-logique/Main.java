/**
 * Exemple de débogage : Erreur logique
 * 
 * Ce programme compile et s'exécute sans erreur, mais produit des résultats
 * incorrects. C'est une erreur logique.
 * 
 * MISSION :
 * 1. Exécuter le programme et observer les résultats bizarres
 * 2. Placer des breakpoints dans checkAge()
 * 3. Utiliser Step Into pour suivre l'exécution
 * 4. Inspecter les valeurs et identifier la logique incorrecte
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Débogage : Erreur logique ===\n");

        // Tester différents âges
        checkAge("Ariel", 25);
        checkAge("Nox", 17);
        checkAge("Amaru", 18);
        checkAge("David", 12);

        System.out.println("\n--- Test de calcul de moyenne ---\n");

        // Test de moyenne
        int[] grades = { 15, 18, 12, 16, 14 };
        double average = calculateAverage(grades);
        System.out.println("Moyenne : " + average);
        System.out.println("(Attendu : 15.0, mais vous verrez autre chose...)");

        System.out.println("\n=== Fin de l'exemple ===");
    }

    /**
     * Vérifie si une personne est majeure ou mineure.
     * 
     * BUG : Les messages sont inversés !
     * 
     * @param name le nom de la personne
     * @param age  l'âge de la personne
     */
    public static void checkAge(String name, int age) {
        // BUG : Les messages sont inversés
        if (age >= 18) {
            System.out.println(name + " (" + age + " ans) est mineur.");
        } else {
            System.out.println(name + " (" + age + " ans) est majeur.");
        }
    }

    /**
     * Calcule la moyenne d'un tableau de notes.
     * 
     * BUG : Division entière au lieu de division réelle !
     * 
     * @param grades le tableau de notes
     * @return la moyenne
     */
    public static double calculateAverage(int[] grades) {
        int sum = 0;

        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }

        // BUG : Division entière (int / int = int)
        // Le résultat est converti en double APRÈS la division
        double average = sum / grades.length;

        return average;
    }
}

/*
 * CORRECTIONS :
 * 
 * 1. Erreur dans checkAge() :
 * 
 * Inverser les messages :
 * if (age >= 18) {
 * System.out.println(name + " (" + age + " ans) est majeur.");
 * } else {
 * System.out.println(name + " (" + age + " ans) est mineur.");
 * }
 * 
 * 2. Erreur dans calculateAverage() :
 * 
 * Caster en double avant la division :
 * double average = (double) sum / grades.length;
 * 
 * Ou :
 * double average = sum / (double) grades.length;
 * 
 * EXPLICATION :
 * - Les erreurs logiques sont les plus difficiles à détecter
 * - Le débogueur permet d'inspecter les valeurs et de suivre la logique
 * - Il faut comparer les résultats attendus avec les résultats obtenus
 */
