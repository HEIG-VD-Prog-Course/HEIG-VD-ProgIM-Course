/**
 * Exemple de débogage : Erreurs de calcul
 * 
 * Ce programme contient plusieurs erreurs de calcul subtiles.
 * 
 * MISSION :
 * 1. Placer des breakpoints dans chaque méthode de test
 * 2. Utiliser la section WATCH pour surveiller les expressions
 * 3. Comparer les résultats attendus avec les résultats obtenus
 * 4. Identifier les erreurs de calcul
 */
public class Main {
    

    /**
     * Test 1 : Calcul de prix avec TVA
     * 
     * BUG : Ordre des opérations incorrect
     */
    public static void testPriceCalculation() {
        System.out.println("--- Test 1 : Calcul de prix ---");

        double basePrice = 100.0;
        double discount = 0.20; // 20% de réduction
        double taxRate = 0.077; // 7.7% de TVA

        // BUG : L'ordre des opérations est incorrect
        // On devrait d'abord appliquer la réduction, PUIS la TVA
        double finalPrice = basePrice * (1 + taxRate) * (1 - discount);

        System.out.println("Prix de base : " + basePrice + " CHF");
        System.out.println("Réduction : " + (discount * 100) + "%");
        System.out.println("TVA : " + (taxRate * 100) + "%");
        System.out.println("Prix final : " + finalPrice + " CHF");
        System.out.println("Attendu : 86.16 CHF");
        System.out.println();
    }

    /**
     * Test 2 : Conversion de température
     * 
     * BUG : Division entière avant multiplication
     */
    public static void testTemperatureConversion() {
        System.out.println("--- Test 2 : Conversion Celsius -> Fahrenheit ---");

        int celsius = 25;

        // BUG : Division entière 9/5 = 1 (pas 1.8)
        int fahrenheit = celsius * 9 / 5 + 32;

        System.out.println(celsius + "°C = " + fahrenheit + "°F");
        System.out.println("Attendu : 77°F");
        System.out.println("(Formule : F = C * 9/5 + 32)");
        System.out.println();
    }

    /**
     * Test 3 : Calcul de factorielle
     * 
     * BUG : Dépassement de capacité (overflow)
     */
    public static void testFactorial() {
        System.out.println("--- Test 3 : Factorielle ---");

        int n = 20;

        // BUG : 20! dépasse la capacité d'un int (overflow)
        int factorial = calculateFactorial(n);

        System.out.println(n + "! = " + factorial);
        System.out.println("(Résultat incorrect à cause de l'overflow)");
        System.out.println("Attendu : 2432902008176640000");
        System.out.println();
    }

    /**
     * Calcule la factorielle d'un nombre.
     * 
     * @param n le nombre
     * @return n!
     */
    public static int calculateFactorial(int n) {
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i; // Overflow pour de grandes valeurs
        }

        return result;
    }

    /**
     * Test 4 : Calcul de pourcentage
     * 
     * BUG : Division entière
     */
    public static void testPercentage() {
        System.out.println("--- Test 4 : Pourcentage ---");

        int correct = 17;
        int total = 20;

        // BUG : Division entière (int / int = int)
        int percentage = correct * 100 / total;

        System.out.println("Questions correctes : " + correct + "/" + total);
        System.out.println("Pourcentage : " + percentage + "%");
        System.out.println("Attendu : 85%");
        System.out.println();
    }
}

/*
 * CORRECTIONS :
 * 
 * 1. testPriceCalculation() :
 * - Appliquer d'abord la réduction, puis la TVA :
 * double finalPrice = basePrice * (1 - discount) * (1 + taxRate);
 * 
 * 2. testTemperatureConversion() :
 * - Utiliser des doubles :
 * double fahrenheit = celsius * 9.0 / 5.0 + 32;
 * 
 * Ou :
 * double fahrenheit = celsius * 1.8 + 32;
 * 
 * 3. testFactorial() :
 * - Utiliser long au lieu de int :
 * long factorial = calculateFactorialLong(n);
 * 
 * - Modifier la méthode :
 * public static long calculateFactorialLong(int n) {
 * long result = 1;
 * for (int i = 2; i <= n; i++) {
 * result *= i;
 * }
 * return result;
 *

    public static void main(String[] args) {
        System.out.println("=== Débogage : Erreurs de calcul ===\n");

        testPriceCalculation();
        testTemperatureConversion();
        testFactorial();
        testPercentage();

        System.out.println("\n=== Fin de l'exemple ===");
    }
}
 * 
 * 4. testPercentage() :
 * - Caster en double :
 * double percentage = (double) correct * 100 / total;
 * 
 * Ou :
 * double percentage = correct * 100.0 / total;
 * 
 * EXPLICATION :
 * - Les erreurs de calcul sont difficiles à voir sans débogueur
 * - Utiliser WATCH pour surveiller les expressions intermédiaires
 * - Attention à l'ordre des opérations et aux types de données
 * - Les divisions entières sont une source fréquente d'erreurs
 */
