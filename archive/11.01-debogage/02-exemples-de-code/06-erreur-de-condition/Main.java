/**
 * Exemple de débogage : Erreurs de condition
 * 
 * Ce programme contient plusieurs erreurs dans les conditions.
 * 
 * MISSION :
 * 1. Placer des breakpoints avant les conditions
 * 2. Utiliser Step Into pour entrer dans les méthodes
 * 3. Observer quelle branche est exécutée
 * 4. Comparer avec le résultat attendu
 * 5. Identifier les conditions incorrectes
 */
public class Main {
    

    /**
     * Test 1 : Système de notation
     * 
     * BUG : Conditions incorrectes pour les plages de notes
     */
    public static void testGrading() {
        System.out.println("--- Test 1 : Système de notation ---");

        int[] scores = { 95, 85, 75, 65, 55 };

        for (int score : scores) {
            String grade = getGrade(score);
            System.out.println("Note de " + score + " : " + grade);
        }

        System.out.println();
    }

    /**
     * Détermine la note lettre selon le score.
     * 
     * BUG : Les conditions de plage sont incorrectes
     * 
     * @param score le score numérique
     * @return la note lettre
     */
    public static String getGrade(int score) {
        // BUG : Manque de vérification pour les plages intermédiaires
        if (score >= 90) {
            return "A";
        }
        if (score >= 80) {
            return "B";
        }
        if (score >= 70) {
            return "C";
        }
        if (score >= 60) {
            return "D";
        }
        // BUG : Pas de else if, donc toutes les conditions sont testées
        // Un score de 95 retourne "A", puis continue à tester inutilement
        return "F";
    }

    /**
     * Test 2 : Contrôle d'accès
     * 
     * BUG : Opérateur logique incorrect
     */
    public static void testAccessControl() {
        System.out.println("--- Test 2 : Contrôle d'accès ---");

        checkAccess("Ariel", 25, true); // Devrait avoir accès
        checkAccess("Nox", 17, true); // Devrait être refusé (mineur)
        checkAccess("Amaru", 25, false); // Devrait être refusé (pas membre)

        System.out.println();
    }

    /**
     * Vérifie si une personne peut accéder.
     * 
     * BUG : Utilise || au lieu de &&
     * 
     * @param name     le nom
     * @param age      l'âge
     * @param isMember si la personne est membre
     */
    public static void checkAccess(String name, int age, boolean isMember) {
        // BUG : || au lieu de &&
        // Cela signifie : accès autorisé si majeur OU membre
        // On veut : accès autorisé si majeur ET membre
        if (age >= 18 || isMember) {
            System.out.println(name + " : Accès autorisé");
        } else {
            System.out.println(name + " : Accès refusé");
        }
    }

    /**
     * Test 3 : Vérification de plage
     * 
     * BUG : Condition inversée
     */
    public static void testRangeCheck() {
        System.out.println("--- Test 3 : Vérification de plage ---");

        int[] values = { -5, 0, 50, 100, 150 };

        for (int value : values) {
            boolean valid = isInRange(value);
            String status;
            if (valid) {
                status = "valide";
            } else {
                status = "invalide";
            }
            System.out.println(value + " est " + status);
        }

        System.out.println();
    }

    /**
     * Vérifie si une valeur est dans la plage [0, 100].
     * 
     * BUG : Condition inversée (OR au lieu de AND)
     * 
     * @param value la valeur à vérifier
     * @return true si dans la plage
     */
    public static boolean isInRange(int value) {
        // BUG : || au lieu de &&
        // Cela vérifie si HORS de la plage, pas dans la plage
        return value < 0 || value > 100;
    }

    /**
     * Test 4 : Calcul de réduction
     * 
     * BUG : Condition avec priorité incorrecte
     */
    public static void testDiscount() {
        System.out.println("--- Test 4 : Calcul de réduction ---");

        double[] prices = { 80, 150, 250 };

        for (double price : prices) {
            double discount = calculateDiscount(price, true);
            double finalPrice = price * (1 - discount);
            System.out.println("Prix " + price + " : réduction " +
                    (discount * 100) + "%, final " + finalPrice);
        }

        System.out.println();
    }

    /**
     * Calcule la réduction applicable.
     * 
     * BUG : Priorité des opérateurs incorrecte
     * 
     * @param price le prix
     * @param isVIP si le client est VIP
     * @return le taux de réduction
     */
    public static double calculateDiscount(double price, boolean isVIP) {
        // BUG : Manque de parenthèses pour la priorité
        // La condition est évaluée comme : price > 100 && (price < 200 || isVIP)
        // On veut : (price > 100 && price < 200) || isVIP
        if (price > 100 && price < 200 || isVIP) {
            return 0.10; // 10% de réduction
        } else if (price >= 200) {
            return 0.20; // 20% de réduction
        }
        return 0.0; // Pas de réduction
    }
}

/*
 * CORRECTIONS :
 * 
 * 1. getGrade() :
 * - Utiliser else if pour éviter de tester inutilement :
 * if (score >= 90) {
 * return "A";
 * } else if (score >= 80) {
 * return "B";
 * } else if (score >= 70) {
 * return "C";
 * } else if (score >= 60) {
 * return "D";
 * } else {
 * return "F";
 * }
 * 
 * 2. checkAccess() :
 * - Changer || en && :
 * if (age >= 18 && isMember) {
 * System.out.println(name + " : Accès autorisé");
 * }
 * 
 * 3. isInRange() :
 * - Inverser la logique et changer || en && :
 * return value >= 0 && value <= 100;
 * 
 * 4. calculateDiscount() :
 * - Ajouter des parenthèses pour clarifier :
 * if ((price > 100 && price < 200) || isVIP) {
 * return 0.10;
 *

    public static void main(String[] args) {
        System.out.println("=== Débogage : Erreurs de condition ===\n");

        testGrading();
        testAccessControl();
        testRangeCheck();
        testDiscount();

        System.out.println("\n=== Fin de l'exemple ===");
    }
}
 * 
 * EXPLICATION :
 * - Les erreurs de condition sont difficiles à voir en lisant le code
 * - Le débogueur permet de voir quelle branche est exécutée
 * - Utiliser des breakpoints conditionnels pour tester des cas spécifiques
 * - Attention à la priorité des opérateurs logiques
 */
