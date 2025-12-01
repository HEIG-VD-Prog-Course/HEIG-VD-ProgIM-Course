/**
 * Exemple 04 : Comparaison de solutions - Trouver le maximum
 * 
 * Ce programme illustre comment évaluer différentes approches
 * pour résoudre un même problème.
 * 
 * Problème : Trouver la valeur maximale dans un tableau d'entiers
 * 
 * Ce programme présente 3 solutions différentes et les compare selon
 * les critères de qualité : lisibilité, maintenabilité et efficacité.
 */

import java.util.Arrays;

public class ComparaisonSolutions {
    
    // ========================================================================
    // SOLUTION 1 : Parcours simple
    // ========================================================================
    
    /**
     * Trouve le maximum en parcourant le tableau une seule fois.
     * 
     * Avantages :
     * - Simple et directe
     * - Efficace : O(n) - un seul parcours
     * - Ne modifie pas le tableau
     * 
     * Inconvénients :
     * - Nécessite un cas particulier pour tableau vide
     */
    public static int trouverMaximumSimple(int[] tableau) {
        if (tableau == null || tableau.length == 0) {
            throw new IllegalArgumentException("Le tableau ne peut pas être vide");
        }
        
        int max = tableau[0];
        
        for (int i = 1; i < tableau.length; i++) {
            if (tableau[i] > max) {
                max = tableau[i];
            }
        }
        
        return max;
    }
    
    // ========================================================================
    // SOLUTION 2 : Avec tri préalable
    // ========================================================================
    
    /**
     * Trouve le maximum en triant d'abord le tableau.
     * 
     * Avantages :
     * - Code très court
     * - Facile à comprendre
     * 
     * Inconvénients :
     * - Inefficace : O(n log n) - le tri est coûteux
     * - MODIFIE le tableau d'origine
     * - Gaspille du temps de calcul
     */
    public static int trouverMaximumAvecTri(int[] tableau) {
        if (tableau == null || tableau.length == 0) {
            throw new IllegalArgumentException("Le tableau ne peut pas être vide");
        }
        
        Arrays.sort(tableau); // ATTENTION : modifie le tableau
        return tableau[tableau.length - 1];
    }
    
    // ========================================================================
    // SOLUTION 3 : Avec copie puis tri
    // ========================================================================
    
    /**
     * Trouve le maximum en copiant puis triant le tableau.
     * 
     * Avantages :
     * - Ne modifie pas le tableau d'origine
     * - Code court
     * 
     * Inconvénients :
     * - Inefficace : O(n log n) pour le tri
     * - Utilise plus de mémoire (copie du tableau)
     * - Complexe pour un problème simple
     */
    public static int trouverMaximumAvecCopieTri(int[] tableau) {
        if (tableau == null || tableau.length == 0) {
            throw new IllegalArgumentException("Le tableau ne peut pas être vide");
        }
        
        int[] copie = Arrays.copyOf(tableau, tableau.length);
        Arrays.sort(copie);
        return copie[copie.length - 1];
    }
    
    // ========================================================================
    // COMPARAISON DES SOLUTIONS
    // ========================================================================
    
    /**
     * Compare les trois solutions selon différents critères.
     */
    public static void comparerSolutions() {
        System.out.println("=== COMPARAISON DES SOLUTIONS ===\n");
        
        System.out.println("CRITÈRE 1 : Lisibilité");
        System.out.println("-----------------------");
        System.out.println("Solution 1 (Parcours simple) : ★★★★☆");
        System.out.println("  → Claire et directe, facile à comprendre");
        System.out.println("Solution 2 (Tri) : ★★★★★");
        System.out.println("  → Très courte, intention évidente");
        System.out.println("Solution 3 (Copie + Tri) : ★★★☆☆");
        System.out.println("  → Un peu plus complexe à cause de la copie");
        
        System.out.println("\nCRITÈRE 2 : Maintenabilité");
        System.out.println("--------------------------");
        System.out.println("Solution 1 : ★★★★★");
        System.out.println("  → Facile à modifier, code explicite");
        System.out.println("Solution 2 : ★★☆☆☆");
        System.out.println("  → DANGER : modifie le tableau (effet de bord)");
        System.out.println("Solution 3 : ★★★★☆");
        System.out.println("  → Pas d'effet de bord, mais utilise plus de mémoire");
        
        System.out.println("\nCRITÈRE 3 : Efficacité");
        System.out.println("----------------------");
        System.out.println("Solution 1 : ★★★★★ O(n)");
        System.out.println("  → Un seul parcours, optimal");
        System.out.println("Solution 2 : ★★☆☆☆ O(n log n)");
        System.out.println("  → Tri inutile, gaspille du temps");
        System.out.println("Solution 3 : ★☆☆☆☆ O(n log n) + copie");
        System.out.println("  → Le plus lent ET utilise plus de mémoire");
        
        System.out.println("\n=== VERDICT ===");
        System.out.println("Solution recommandée : Solution 1 (Parcours simple)");
        System.out.println("Raison : Meilleur équilibre entre lisibilité, maintenabilité et efficacité");
    }
    
    // ========================================================================
    // DÉMONSTRATION DES EFFETS DE BORD
    // ========================================================================
    
    /**
     * Démontre le problème de la Solution 2 (effet de bord).
     */
    public static void demonstrerEffetDeBord() {
        System.out.println("\n=== DÉMONSTRATION : Effet de bord ===\n");
        
        int[] tableau = {5, 2, 9, 1, 7, 3};
        
        System.out.println("Tableau original : " + Arrays.toString(tableau));
        
        System.out.println("\nUtilisation de la Solution 2 (tri)...");
        int max = trouverMaximumAvecTri(tableau);
        System.out.println("Maximum trouvé : " + max);
        System.out.println("Tableau après : " + Arrays.toString(tableau));
        System.out.println("⚠️  ATTENTION : Le tableau a été modifié !");
        
        // Refaire avec un nouveau tableau
        int[] tableau2 = {5, 2, 9, 1, 7, 3};
        System.out.println("\n\nTableau original : " + Arrays.toString(tableau2));
        
        System.out.println("\nUtilisation de la Solution 1 (parcours simple)...");
        int max2 = trouverMaximumSimple(tableau2);
        System.out.println("Maximum trouvé : " + max2);
        System.out.println("Tableau après : " + Arrays.toString(tableau2));
        System.out.println("✓ Le tableau n'a pas été modifié");
    }
    
    // ========================================================================
    // TESTS DE PERFORMANCE
    // ========================================================================
    
    /**
     * Compare les performances des trois solutions.
     */
    public static void testerPerformance() {
        System.out.println("\n=== TEST DE PERFORMANCE ===\n");
        
        // Créer un grand tableau
        int taille = 100000;
        int[] grandTableau = new int[taille];
        for (int i = 0; i < taille; i++) {
            grandTableau[i] = (int) (Math.random() * 1000000);
        }
        
        // Solution 1
        long debut1 = System.nanoTime();
        int max1 = trouverMaximumSimple(Arrays.copyOf(grandTableau, taille));
        long fin1 = System.nanoTime();
        long temps1 = (fin1 - debut1) / 1000; // en microsecondes
        
        // Solution 2 (on copie avant pour ne pas modifier l'original)
        long debut2 = System.nanoTime();
        int max2 = trouverMaximumAvecTri(Arrays.copyOf(grandTableau, taille));
        long fin2 = System.nanoTime();
        long temps2 = (fin2 - debut2) / 1000;
        
        // Solution 3
        long debut3 = System.nanoTime();
        int max3 = trouverMaximumAvecCopieTri(grandTableau);
        long fin3 = System.nanoTime();
        long temps3 = (fin3 - debut3) / 1000;
        
        System.out.printf("Taille du tableau : %d éléments%n%n", taille);
        System.out.printf("Solution 1 (Parcours simple) : %d μs%n", temps1);
        System.out.printf("Solution 2 (Tri) : %d μs%n", temps2);
        System.out.printf("Solution 3 (Copie + Tri) : %d μs%n%n", temps3);
        
        System.out.printf("Solution 2 est %.1fx plus lente que Solution 1%n", 
                         (double) temps2 / temps1);
        System.out.printf("Solution 3 est %.1fx plus lente que Solution 1%n", 
                         (double) temps3 / temps1);
    }
    
    // ========================================================================
    // TESTS DE CORRECTION
    // ========================================================================
    
    /**
     * Vérifie que toutes les solutions donnent le même résultat.
     */
    public static void testerCorrection() {
        System.out.println("\n=== TEST DE CORRECTION ===\n");
        
        int[][] tableauxTest = {
            {5, 2, 9, 1, 7, 3},
            {-5, -2, -9, -1, -7},
            {42},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1},
            {3, 3, 3, 3, 3}
        };
        
        boolean tousReussis = true;
        
        for (int i = 0; i < tableauxTest.length; i++) {
            int[] tableau = tableauxTest[i];
            
            int max1 = trouverMaximumSimple(Arrays.copyOf(tableau, tableau.length));
            int max2 = trouverMaximumAvecTri(Arrays.copyOf(tableau, tableau.length));
            int max3 = trouverMaximumAvecCopieTri(tableau);
            
            boolean reussi = (max1 == max2 && max2 == max3);
            
            System.out.printf("Test %d : %s%n", i + 1, Arrays.toString(tableau));
            System.out.printf("  Solution 1: %d, Solution 2: %d, Solution 3: %d → %s%n",
                            max1, max2, max3, reussi ? "✓" : "✗");
            
            if (!reussi) {
                tousReussis = false;
            }
        }
        
        System.out.println("\n" + (tousReussis ? 
            "✓ Tous les tests ont réussi" : 
            "✗ Certains tests ont échoué"));
    }
    
    // ========================================================================
    // PROGRAMME PRINCIPAL
    // ========================================================================
    
    public static void main(String[] args) {
        System.out.println("=== COMPARAISON DE SOLUTIONS POUR TROUVER LE MAXIMUM ===\n");
        
        // 1. Comparaison théorique
        comparerSolutions();
        
        // 2. Démonstration de l'effet de bord
        demonstrerEffetDeBord();
        
        // 3. Tests de correction
        testerCorrection();
        
        // 4. Tests de performance
        testerPerformance();
        
        System.out.println("\n=== CONCLUSION ===");
        System.out.println("Pour ce problème, la Solution 1 (parcours simple) est la meilleure.");
        System.out.println("Elle est à la fois lisible, maintenable et efficace.");
        System.out.println("La Solution 2 (tri) est à éviter car elle modifie le tableau.");
        System.out.println("La Solution 3 (copie + tri) gaspille temps et mémoire.");
        System.out.println("\nLeçon : Ne pas sur-compliquer. La solution la plus simple est souvent la meilleure.");
    }
}
