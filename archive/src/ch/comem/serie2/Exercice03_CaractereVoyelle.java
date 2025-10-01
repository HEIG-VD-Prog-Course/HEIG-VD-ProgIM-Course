package ch.comem.serie2;

import ch.comem.Clavier;

/*
    Ecrire un programme qui demande un caractère à l’utilisateur et qui vérifie 
    si c’est une voyelle. (Ne pas prendre en compte les caractères accentués). 
*/

public class Exercice03_CaractereVoyelle {

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
 
        // Saisie du caractère
        char c = Clavier.rend_char("Entrez un caractère: ");
        
        // Calcul
        boolean estVoyelle = (c == 'a' || c == 'A' ||
                              c == 'e' || c == 'E' ||
                              c == 'i' || c == 'I' ||
                              c == 'o' || c == 'O' ||
                              c == 'u' || c == 'U' ||
                              c == 'y' || c == 'Y');
        
        // Affichage
        System.out.print("Le caractère '" + c + "' ");
        if (estVoyelle) {
            System.out.print("est");
        } else {
            System.out.print("n'est pas");
        }
        System.out.println(" une voyelle.");
    }
}