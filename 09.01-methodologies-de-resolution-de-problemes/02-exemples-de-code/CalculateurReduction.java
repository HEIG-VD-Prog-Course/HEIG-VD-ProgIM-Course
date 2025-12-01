/**
 * Exemple 01 : Calculateur de réduction pour un système d'échange local
 * 
 * Ce programme illustre les étapes de résolution de problèmes :
 * 1. Analyser le problème (entrées, sorties, contraintes)
 * 2. Écrire du pseudocode
 * 3. Implémenter en Java
 * 4. Tester systématiquement
 * 
 * Contexte :
 * Un système d'échange local (SEL) permet aux membres d'une communauté
 * d'échanger des services. Pour encourager la participation, le système
 * offre des réductions sur certains services payants en fonction du nombre
 * de services rendus par chaque membre.
 * 
 * Règles de réduction :
 * - 1 à 4 services rendus : 5% de réduction
 * - 5 à 9 services rendus : 10% de réduction
 * - 10 services ou plus : 20% de réduction
 * - 0 services rendus : pas de réduction
 */

public class CalculateurReduction {
    
    /**
     * ANALYSE DU PROBLÈME
     * ====================
     * 
     * ENTRÉES :
     *   - prixInitial : double (prix du service avant réduction)
     *   - nombreServices : int (nombre de services rendus par le membre)
     * 
     * SORTIES :
     *   - double : prix final après application de la réduction
     * 
     * CONTRAINTES :
     *   - Le prix doit être positif ou nul
     *   - Le nombre de services doit être positif ou nul
     *   - Le prix final doit être arrondi à 2 décimales
     * 
     * CAS LIMITES À CONSIDÉRER :
     *   - prixInitial = 0 (service gratuit)
     *   - nombreServices = 0 (aucun service rendu)
     *   - nombreServices = 1 (seuil minimal pour réduction)
     *   - nombreServices = 4, 5, 9, 10 (aux frontières des paliers)
     *   - prixInitial ou nombreServices négatifs (invalides)
     */
    
    /**
     * PSEUDOCODE
     * ===========
     * 
     * DÉBUT calculerPrixFinal
     *     ENTRÉES : prixInitial, nombreServices
     *     
     *     SI prixInitial < 0 OU nombreServices < 0 ALORS
     *         RETOURNER -1 (valeur d'erreur)
     *     FIN SI
     *     
     *     tauxReduction ← 0
     *     
     *     SI nombreServices >= 10 ALORS
     *         tauxReduction ← 0.20
     *     SINON SI nombreServices >= 5 ALORS
     *         tauxReduction ← 0.10
     *     SINON SI nombreServices >= 1 ALORS
     *         tauxReduction ← 0.05
     *     FIN SI
     *     
     *     reduction ← prixInitial × tauxReduction
     *     prixFinal ← prixInitial - reduction
     *     
     *     prixFinal ← arrondir(prixFinal, 2 décimales)
     *     
     *     RETOURNER prixFinal
     * FIN
     */
    
    /**
     * Calcule le prix final après application de la réduction.
     * 
     * @param prixInitial Le prix du service avant réduction (doit être >= 0)
     * @param nombreServices Le nombre de services rendus (doit être >= 0)
     * @return Le prix final après réduction, arrondi à 2 décimales, ou -1 si les entrées sont invalides
     */
    public static double calculerPrixFinal(double prixInitial, int nombreServices) {
        // Validation des entrées
        if (prixInitial < 0 || nombreServices < 0) {
            return -1; // Valeur d'erreur
        }
        
        // Détermination du taux de réduction
        double tauxReduction = 0;
        
        if (nombreServices >= 10) {
            tauxReduction = 0.20;
        } else if (nombreServices >= 5) {
            tauxReduction = 0.10;
        } else if (nombreServices >= 1) {
            tauxReduction = 0.05;
        }
        
        // Calcul de la réduction et du prix final
        double reduction = prixInitial * tauxReduction;
        double prixFinal = prixInitial - reduction;
        
        // Arrondir à 2 décimales
        prixFinal = Math.round(prixFinal * 100.0) / 100.0;
        
        return prixFinal;
    }
    
    /**
     * Fonction alternative : décomposition en sous-fonctions
     * Cette approche est plus modulaire et facilite les tests.
     */
    public static double calculerPrixFinalModulaire(double prixInitial, int nombreServices) {
        if (!validerEntrees(prixInitial, nombreServices)) {
            return -1;
        }
        
        double tauxReduction = determinerTauxReduction(nombreServices);
        double prixFinal = appliquerReduction(prixInitial, tauxReduction);
        
        return arrondir(prixFinal, 2);
    }
    
    /**
     * Valide que les entrées sont correctes.
     */
    private static boolean validerEntrees(double prixInitial, int nombreServices) {
        return prixInitial >= 0 && nombreServices >= 0;
    }
    
    /**
     * Détermine le taux de réduction selon le nombre de services.
     */
    private static double determinerTauxReduction(int nombreServices) {
        if (nombreServices >= 10) return 0.20;
        if (nombreServices >= 5) return 0.10;
        if (nombreServices >= 1) return 0.05;
        return 0;
    }
    
    /**
     * Applique la réduction au prix initial.
     */
    private static double appliquerReduction(double prixInitial, double tauxReduction) {
        double reduction = prixInitial * tauxReduction;
        return prixInitial - reduction;
    }
    
    /**
     * Arrondit un nombre à un nombre de décimales spécifié.
     */
    private static double arrondir(double valeur, int nbDecimales) {
        double multiplicateur = Math.pow(10, nbDecimales);
        return Math.round(valeur * multiplicateur) / multiplicateur;
    }
    
    /**
     * TESTS SYSTÉMATIQUES
     * ====================
     */
    
    /**
     * Teste la fonction avec tous les cas importants.
     */
    public static void testerCalculateurReduction() {
        System.out.println("=== Tests du calculateur de réduction ===\n");
        
        // Cas normaux
        testerCas("Normal - 5 services", 100.0, 5, 90.0);
        testerCas("Normal - 10 services", 50.0, 10, 40.0);
        testerCas("Normal - 3 services", 200.0, 3, 190.0);
        
        // Cas limites
        testerCas("Limite - 0 services", 100.0, 0, 100.0);
        testerCas("Limite - 1 service (seuil)", 100.0, 1, 95.0);
        testerCas("Limite - 4 services (avant palier)", 100.0, 4, 95.0);
        testerCas("Limite - 5 services (palier)", 100.0, 5, 90.0);
        testerCas("Limite - 9 services (avant palier)", 100.0, 9, 90.0);
        testerCas("Limite - 10 services (palier)", 100.0, 10, 80.0);
        testerCas("Limite - Prix nul", 0.0, 5, 0.0);
        
        // Cas d'erreur
        testerCas("Erreur - Prix négatif", -10.0, 5, -1.0);
        testerCas("Erreur - Services négatifs", 100.0, -5, -1.0);
        
        System.out.println("\n=== Fin des tests ===");
    }
    
    /**
     * Teste un cas spécifique et affiche le résultat.
     */
    private static void testerCas(String description, double prix, int services, double attendu) {
        double resultat = calculerPrixFinal(prix, services);
        boolean reussi = (Math.abs(resultat - attendu) < 0.01);
        
        System.out.printf("%-40s : ", description);
        if (reussi) {
            System.out.printf("✓ OK (%.2f)%n", resultat);
        } else {
            System.out.printf("✗ ERREUR - Attendu: %.2f, Obtenu: %.2f%n", attendu, resultat);
        }
    }
    
    /**
     * Programme principal : démonstration interactive.
     */
    public static void main(String[] args) {
        // Exécuter les tests automatiques
        testerCalculateurReduction();
        
        System.out.println("\n\n=== Exemples d'utilisation ===\n");
        
        // Exemples concrets
        demonstrerUtilisation("Alice", 100.0, 3);
        demonstrerUtilisation("Bob", 75.0, 7);
        demonstrerUtilisation("Charlie", 150.0, 12);
        demonstrerUtilisation("Diana", 50.0, 0);
    }
    
    /**
     * Démontre l'utilisation du calculateur pour un membre.
     */
    private static void demonstrerUtilisation(String nom, double prix, int services) {
        double prixFinal = calculerPrixFinal(prix, services);
        double economie = prix - prixFinal;
        
        System.out.printf("%s souhaite utiliser un service de %.2f CHF.%n", nom, prix);
        System.out.printf("Nombre de services rendus : %d%n", services);
        System.out.printf("Prix final : %.2f CHF (économie de %.2f CHF)%n%n", prixFinal, economie);
    }
}
