package ch.comem.serie6;

import java.util.Arrays;

public class Exercice5 {

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
        String[] fruits = {"pomme", "fraise", "ananas", "citron", "banane"};
        System.out.println("Avant tri : " + Arrays.toString(fruits));
        // On peut écrire un algorithme soit même ou
        // utiliser l'algorithme par défaut que nous propose Java ;-)
        Arrays.sort(fruits);
        System.out.println("Après tri : " + Arrays.toString(fruits));
    }
}
