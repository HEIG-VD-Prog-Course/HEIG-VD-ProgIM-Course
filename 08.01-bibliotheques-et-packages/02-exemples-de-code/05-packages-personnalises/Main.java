
// Import des classes depuis nos packages personnalisés
import models.Product;
import models.Inventory;
import utils.Formatter;
import utils.Calculator;

/**
 * Exemple d'utilisation de packages personnalisés.
 * 
 * Cet exemple montre comment :
 * - Organiser le code en packages
 * - Importer des classes depuis différents packages
 * - Utiliser des modificateurs de visibilité
 * - Documenter le code avec Javadoc
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Formatter.formatTitle("Packages personnalisés"));
        System.out.println();

        // Création d'un inventaire
        Inventory inventory = new Inventory();

        // Ajout de produits
        inventory.addProduct(new Product("Ordinateur portable", 1299.00, 15));
        inventory.addProduct(new Product("Souris sans fil", 29.90, 50));
        inventory.addProduct(new Product("Clavier mécanique", 149.00, 25));
        inventory.addProduct(new Product("Écran 27 pouces", 399.00, 10));
        inventory.addProduct(new Product("Webcam HD", 79.90, 30));

        // Affichage de l'inventaire
        System.out.println("=== Inventaire ===\n");
        for (Product product : inventory.getAllProducts()) {
            System.out.println(product);
            System.out.println("  Valeur du stock : " +
                    Formatter.formatPrice(product.getTotalValue()));
        }

        // Statistiques globales
        System.out.println("\n" + Formatter.createSeparator(50));
        System.out.println("\n=== Statistiques ===\n");

        System.out.println("Nombre de produits : " + inventory.getProductCount());
        System.out.println("Valeur totale de l'inventaire : " +
                Formatter.formatPrice(inventory.getTotalInventoryValue()));

        // Calculs sur les prix
        double[] prices = new double[inventory.getProductCount()];
        int i = 0;
        for (Product product : inventory.getAllProducts()) {
            prices[i++] = product.getPrice();
        }

        System.out.println("\nPrix moyen : " + Formatter.formatPrice(Calculator.average(prices)));
        System.out.println("Prix minimum : " + Formatter.formatPrice(Calculator.min(prices)));
        System.out.println("Prix maximum : " + Formatter.formatPrice(Calculator.max(prices)));

        // Recherche d'un produit spécifique
        System.out.println("\n" + Formatter.createSeparator(50));
        System.out.println("\n=== Recherche ===\n");

        String searchName = "Clavier mécanique";
        Product found = inventory.findProduct(searchName);

        if (found != null) {
            System.out.println("Produit trouvé : " + found);

            // Calcul du pourcentage de la valeur totale
            double percentage = Calculator.percentage(
                    found.getTotalValue(),
                    inventory.getTotalInventoryValue());
            System.out.printf("Représente %.1f%% de la valeur totale%n", percentage);
        } else {
            System.out.println("Produit non trouvé : " + searchName);
        }

        System.out.println("\n" + Formatter.createSeparator(50));
        System.out.println("\n=== Fin de l'exemple ===");
    }
}
