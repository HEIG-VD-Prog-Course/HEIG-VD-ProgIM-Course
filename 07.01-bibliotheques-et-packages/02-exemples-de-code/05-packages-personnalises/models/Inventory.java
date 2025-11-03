package models;

import java.util.ArrayList;

/**
 * Représente un inventaire de produits.
 * 
 * Cette classe gère une collection de produits et fournit des
 * méthodes pour les manipuler.
 */
public class Inventory {
    private ArrayList<Product> products;

    /**
     * Crée un nouvel inventaire vide.
     */
    public Inventory() {
        this.products = new ArrayList<>();
    }

    /**
     * Ajoute un produit à l'inventaire.
     * 
     * @param product le produit à ajouter
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Recherche un produit par son nom.
     * 
     * @param name le nom du produit recherché
     * @return le produit trouvé, ou null si non trouvé
     */
    public Product findProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Retourne tous les produits de l'inventaire.
     * 
     * @return la liste des produits
     */
    public ArrayList<Product> getAllProducts() {
        return products;
    }

    /**
     * Calcule la valeur totale de l'inventaire.
     * 
     * @return la somme de la valeur de tous les produits
     */
    public double getTotalInventoryValue() {
        double total = 0;
        for (Product product : products) {
            total += product.getTotalValue();
        }
        return total;
    }

    /**
     * Retourne le nombre de produits dans l'inventaire.
     * 
     * @return le nombre de produits
     */
    public int getProductCount() {
        return products.size();
    }
}
