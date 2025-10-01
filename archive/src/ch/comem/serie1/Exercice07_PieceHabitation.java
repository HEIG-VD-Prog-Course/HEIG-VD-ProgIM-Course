package ch.comem.serie1;

import ch.comem.Clavier;

/*
   À partir la largeur, de la longueur et de la hauteur (en mètres) d'une pièce d'habitation, 
   calculer sa surface du sol (que l'on veut couvrir avec du parquet en bois) 
   et la surface de ses murs (que l'on veut peindre).
*/

public class Exercice07_PieceHabitation {

    // Règle les éventuels problèmes d'affichage des accents
    static {
        try {
            System.setOut(new java.io.PrintStream(
                    new java.io.FileOutputStream(java.io.FileDescriptor.out), true, "UTF-8"));
            
        } catch (java.io.UnsupportedEncodingException ex) {
            System.out.println("VM dont support UTF-8");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("À partir de la largeur, de la longueur "
               + " et de la hauteur (en m) d'une pièce d'habitation.");
        System.out.println("ce programme calcule et affiche son volume, sa "
                + "surface au sol et la surface de ses murs.");

        // Saisie des valeurs
        double largeur = Clavier.rend_double("Entrer la largeur : ");
        double longueur = Clavier.rend_double("Entrer la longueur : ");
        double hauteur = Clavier.rend_double("Entrer la hauteur : ");
        
        // Calculs
        double volume = largeur * longueur * hauteur;
        double surfaceSol = largeur * longueur;
        double surfaceMurs = 2 * hauteur * (largeur + longueur);
        
        // Affichage
        System.out.print("Pour une pièce de largeur " + largeur + "[m], ");
        System.out.print("de longueur " + longueur + "[m]  ");
        System.out.println("et de hauteur " + hauteur + "[m] ");
        System.out.println("On obtient les résultats suivants:" );
        System.out.println("Un volume de " + volume + " [m^3]");
        System.out.println("Une surface au sol de " + surfaceSol + " [m^2]");
        System.out.println("Une surface des murs de " + surfaceMurs + " [m^2]");
    }
}