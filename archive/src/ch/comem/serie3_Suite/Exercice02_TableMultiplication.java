package ch.comem.serie3_Suite;

import ch.comem.Clavier;

public class Exercice02_TableMultiplication {

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
        System.out.println("Ce programme permet à l'utlisateur de saisir un entier,");
        System.out.println("puis d'afficher la table de multiplication de cet entier (de 1 à 12)");
        
        int entier = Clavier.rend_int("Veuillez saisir un entier : ");
        
        for (int multiplicateur=1; multiplicateur<=12; multiplicateur++) {
            System.out.println(multiplicateur + " x " + entier + " = " + multiplicateur*entier);
        }
    }
}
