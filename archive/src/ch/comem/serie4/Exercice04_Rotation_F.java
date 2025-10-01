package ch.comem.serie4;

import java.util.Arrays;

/**
 * Ecrire un programme permettant de faire une rotation d'un tableau vers la
 * droite. Avant : ["Aline","Roger","Julia","Steven","Jules"] Après :
 * ["Roger","Julia","Steven","Jules","Aline"]
 */
public class Exercice04_Rotation_F {

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

        String[] prenoms = {"Aline", "Roger", "Julia", "Steven", "Jules"};
        System.out.println(Arrays.toString(prenoms));

        decalePrenoms(prenoms);

        System.out.println(Arrays.toString(prenoms));
    }

    private static void decalePrenoms(String[] prenoms) {

        if (prenoms != null && prenoms.length >= 2) {
            // Cas particulier pour le premier
            String premier = prenoms[0];
            // décalages
            for (int i = 1; i < prenoms.length; i++) {
                prenoms[i - 1] = prenoms[i];
            }
            // On injecte le premier à la fin
            prenoms[prenoms.length - 1] = premier;
        }
    }

}
