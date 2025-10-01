package ch.comem.serie1;

import ch.comem.Clavier;

/*

Veuillez écrire un programme permettant de savoir si un nombre est divisible par un autre.
    Exemple 1 :
        Veuillez saisir un nombre : 13
        Veuillez saisir un diviseur : 7
        13 est-il divisible par 7 ? : false
    
    Exemple 2 :
        Veuillez saisir un nombre : 14
        Veuillez saisir un diviseur : 7
        14 est-il divisible par 7 ? : true

*/

public class Exercice11_Divisible {

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
        int nombre = Clavier.rend_int("Veuillez saisir un nombre : ");
        int diviseur = Clavier.rend_int("Veuillez saisir un diviseur : ");
        
        System.out.println(nombre + " est-il divisible par " + diviseur + 
                " ? " + (nombre%diviseur==0));
    }
}