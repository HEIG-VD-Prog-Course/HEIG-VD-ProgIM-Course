package utils;

/**
 * Classe utilitaire pour formater l'affichage de données.
 * 
 * Cette classe contient uniquement des méthodes statiques et ne
 * peut pas être instanciée.
 */
public class Formatter {

    // Constructeur privé pour empêcher l'instanciation
    private Formatter() {
        throw new UnsupportedOperationException("Classe utilitaire");
    }

    /**
     * Formate un montant en CHF avec 2 décimales.
     * 
     * @param amount le montant à formater
     * @return le montant formaté avec l'unité
     */
    public static String formatPrice(double amount) {
        return String.format("%.2f CHF", amount);
    }

    /**
     * Crée une ligne de séparation pour l'affichage.
     * 
     * @param length la longueur de la ligne
     * @return une chaîne de caractères '=' de la longueur spécifiée
     */
    public static String createSeparator(int length) {
        return "=".repeat(length);
    }

    /**
     * Formate un titre avec des bordures.
     * 
     * @param title le titre à formater
     * @return le titre encadré
     */
    public static String formatTitle(String title) {
        int length = title.length() + 4;
        String separator = createSeparator(length);
        return separator + "\n  " + title + "\n" + separator;
    }

    /**
     * Centre un texte dans une largeur donnée.
     * 
     * @param text  le texte à centrer
     * @param width la largeur totale
     * @return le texte centré
     */
    public static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text;
    }
}
