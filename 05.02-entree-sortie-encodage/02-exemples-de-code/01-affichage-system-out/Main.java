/**
 * Exemple d'affichage avec System.out en Java.
 * 
 * System.out permet d'afficher du texte dans la console (terminal).
 * Il existe plusieurs méthodes pour afficher du texte de différentes manières.
 * 
 * Documentation : https://docs.oracle.com/en/java/javase/17/docs/api/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exemple : Affichage avec System.out ===\n");

        // ========================================
        // System.out.println() : affiche ET passe à la ligne
        // ========================================
        System.out.println("Bonjour !");
        System.out.println("Ceci est une nouvelle ligne.");
        System.out.println(); // Ligne vide

        // ========================================
        // System.out.print() : affiche SANS passer à la ligne
        // ========================================
        System.out.print("Java ");
        System.out.print("est ");
        System.out.print("super !");
        System.out.println(); // On passe à la ligne manuellement
        System.out.println();

        // ========================================
        // Affichage de variables avec concaténation (+)
        // ========================================
        String name = "Alice";
        int age = 20;
        double height = 1.65;

        System.out.println("Nom : " + name);
        System.out.println("Âge : " + age + " ans");
        System.out.println("Taille : " + height + " m");
        System.out.println();

        // ========================================
        // System.out.printf() : affichage formaté
        // ========================================

        // %s : chaîne de caractères (String)
        // %d : nombre entier (int)
        // %f : nombre décimal (double)
        // %.2f : nombre décimal avec 2 chiffres après la virgule
        // %n : retour à la ligne (équivalent à \n)

        System.out.println("=== Affichage formaté avec printf ===");

        String product = "Clavier";
        double price = 49.99;
        int quantity = 3;

        System.out.printf("Produit : %s%n", product);
        System.out.printf("Prix unitaire : %.2f CHF%n", price);
        System.out.printf("Quantité : %d%n", quantity);
        System.out.printf("Total : %.2f CHF%n", price * quantity);
        System.out.println();

        // Alignement avec printf
        System.out.println("=== Tableau avec alignement ===");
        System.out.printf("%-15s | %10s | %8s%n", "Article", "Prix", "Stock");
        System.out.println("─".repeat(40));
        System.out.printf("%-15s | %10.2f | %8d%n", "Souris", 29.90, 15);
        System.out.printf("%-15s | %10.2f | %8d%n", "Écran", 299.00, 8);
        System.out.printf("%-15s | %10.2f | %8d%n", "Casque", 79.50, 23);
        System.out.println();

        // ========================================
        // Caractères spéciaux
        // ========================================
        System.out.println("=== Caractères spéciaux ===");
        System.out.println("Retour à la ligne : \\n");
        System.out.println("Première ligne\nDeuxième ligne");
        System.out.println();

        System.out.println("Tabulation : \\t");
        System.out.println("Colonne 1\tColonne 2\tColonne 3");
        System.out.println();

        System.out.println("Guillemets : \\\"");
        System.out.println("Elle a dit : \"Bonjour !\"");

        System.out.println("\n=== Fin de l'exemple ===");
    }
}
