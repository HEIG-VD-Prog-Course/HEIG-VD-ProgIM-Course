import java.util.ArrayList;

/**
 * Classe représentant un produit.
 */
class Product {
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-15s | %6.2f CHF | Stock: %3d",
                name, category, price, stock);
    }
}

/**
 * Exemple de recherche dans une collection d'objets.
 * 
 * Cet exemple montre comment rechercher des objets selon différents
 * critères dans une ArrayList.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exemple : Recherche dans des objets ===\n");

        // Créer un inventaire de produits
        ArrayList<Product> inventory = createInventory();

        // Afficher tous les produits
        System.out.println("=== Inventaire complet ===\n");
        displayProducts(inventory);

        // Recherche par nom
        System.out.println("\n--- Recherche par nom ---\n");
        Product found = searchByName(inventory, "Clavier mécanique");
        if (found != null) {
            System.out.println("Trouvé : " + found);
        } else {
            System.out.println("Produit non trouvé");
        }

        // Recherche par catégorie
        System.out.println("\n--- Recherche par catégorie ---\n");
        ArrayList<Product> electronics = searchByCategory(inventory, "Électronique");
        System.out.println("Produits dans la catégorie 'Électronique' :");
        displayProducts(electronics);

        // Recherche par prix maximum
        System.out.println("\n--- Recherche par prix ---\n");
        ArrayList<Product> affordable = searchByMaxPrice(inventory, 100.00);
        System.out.println("Produits à moins de 100 CHF :");
        displayProducts(affordable);

        // Recherche par stock faible
        System.out.println("\n--- Recherche par stock faible ---\n");
        ArrayList<Product> lowStock = searchByLowStock(inventory, 10);
        System.out.println("Produits avec stock < 10 :");
        displayProducts(lowStock);

        // Recherche multiple (catégorie ET prix)
        System.out.println("\n--- Recherche multiple ---\n");
        ArrayList<Product> result = searchByCategoryAndMaxPrice(
                inventory, "Accessoires", 50.00);
        System.out.println("Accessoires à moins de 50 CHF :");
        displayProducts(result);

        System.out.println("\n=== Fin de l'exemple ===");
    }

    /**
     * Crée un inventaire de produits pour les démonstrations.
     * 
     * @return une liste de produits
     */
    public static ArrayList<Product> createInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        inventory.add(new Product("Ordinateur portable", "Électronique", 1299.00, 15));
        inventory.add(new Product("Souris sans fil", "Accessoires", 29.90, 50));
        inventory.add(new Product("Clavier mécanique", "Accessoires", 149.00, 25));
        inventory.add(new Product("Écran 27 pouces", "Électronique", 399.00, 8));
        inventory.add(new Product("Webcam HD", "Électronique", 79.90, 30));
        inventory.add(new Product("Câble USB-C", "Accessoires", 12.90, 100));
        inventory.add(new Product("Casque audio", "Accessoires", 89.00, 20));
        inventory.add(new Product("Disque dur externe", "Électronique", 129.00, 5));
        inventory.add(new Product("Hub USB", "Accessoires", 39.90, 40));
        inventory.add(new Product("Support d'écran", "Mobilier", 59.00, 12));

        return inventory;
    }

    /**
     * Recherche un produit par son nom exact.
     * 
     * @param inventory la liste de produits
     * @param name      le nom à rechercher
     * @return le produit trouvé, ou null
     */
    public static Product searchByName(ArrayList<Product> inventory, String name) {
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Recherche tous les produits d'une catégorie.
     * 
     * @param inventory la liste de produits
     * @param category  la catégorie à rechercher
     * @return une liste de produits correspondants
     */
    public static ArrayList<Product> searchByCategory(
            ArrayList<Product> inventory, String category) {

        ArrayList<Product> results = new ArrayList<>();

        for (Product product : inventory) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                results.add(product);
            }
        }

        return results;
    }

    /**
     * Recherche les produits dont le prix est inférieur ou égal à un maximum.
     * 
     * @param inventory la liste de produits
     * @param maxPrice  le prix maximum
     * @return une liste de produits correspondants
     */
    public static ArrayList<Product> searchByMaxPrice(
            ArrayList<Product> inventory, double maxPrice) {

        ArrayList<Product> results = new ArrayList<>();

        for (Product product : inventory) {
            if (product.getPrice() <= maxPrice) {
                results.add(product);
            }
        }

        return results;
    }

    /**
     * Recherche les produits avec un stock faible.
     * 
     * @param inventory la liste de produits
     * @param threshold le seuil de stock
     * @return une liste de produits correspondants
     */
    public static ArrayList<Product> searchByLowStock(
            ArrayList<Product> inventory, int threshold) {

        ArrayList<Product> results = new ArrayList<>();

        for (Product product : inventory) {
            if (product.getStock() < threshold) {
                results.add(product);
            }
        }

        return results;
    }

    /**
     * Recherche avec plusieurs critères (catégorie ET prix).
     * 
     * @param inventory la liste de produits
     * @param category  la catégorie
     * @param maxPrice  le prix maximum
     * @return une liste de produits correspondants
     */
    public static ArrayList<Product> searchByCategoryAndMaxPrice(
            ArrayList<Product> inventory, String category, double maxPrice) {

        ArrayList<Product> results = new ArrayList<>();

        for (Product product : inventory) {
            if (product.getCategory().equalsIgnoreCase(category) &&
                    product.getPrice() <= maxPrice) {
                results.add(product);
            }
        }

        return results;
    }

    /**
     * Affiche une liste de produits.
     * 
     * @param products la liste à afficher
     */
    public static void displayProducts(ArrayList<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Aucun produit.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
