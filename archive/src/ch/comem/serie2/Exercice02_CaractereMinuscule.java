package ch.comem.serie2;

import ch.comem.Clavier;

/*
    Ecrire un programme qui demande un caractère à l’utilisateur et qui vérifie 
    si c’est une lettre minuscule (ne pas prendre en compte les caractères accentués). 
*/

public class Exercice02_CaractereMinuscule {

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
        boolean estMinuscule = c >='a' && c <='z';
 
        // Affichage du résultat
        System.out.print("Le caractère '" + c + "' ");
        if (estMinuscule) {
            System.out.print("est");
        } else {
            System.out.print("n'est pas");
        }
        System.out.println(" une lettre minuscule.");
    }
}