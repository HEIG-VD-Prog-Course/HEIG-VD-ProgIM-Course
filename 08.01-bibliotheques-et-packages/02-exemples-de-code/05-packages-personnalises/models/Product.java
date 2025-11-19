package models;

/**
 * Représente un produit dans un système de gestion d'inventaire.
 * 
 * Cette classe est publique et peut être utilisée depuis n'importe
 * quel autre package.
 */
public class Product {
    private String name;
    private double price;
    private int quantity;

    /**
     * Crée un nouveau produit.
     * 
     * @param name     le nom du produit
     * @param price    le prix unitaire
     * @param quantity la quantité en stock
     */
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retourne le nom du produit.
     * 
     * @return le nom du produit
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne le prix du produit.
     * 
     * @return le prix unitaire
     */
    public double getPrice() {
        return price;
    }

    /**
     * Retourne la quantité en stock.
     * 
     * @return la quantité disponible
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Modifie la quantité en stock.
     * 
     * @param quantity la nouvelle quantité
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Calcule la valeur totale du stock pour ce produit.
     * 
     * @return le prix multiplié par la quantité
     */
    public double getTotalValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f CHF (stock: %d)", name, price, quantity);
    }
}
