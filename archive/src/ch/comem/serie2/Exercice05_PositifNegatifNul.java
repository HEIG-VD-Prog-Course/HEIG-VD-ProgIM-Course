package ch.comem.serie2;

import ch.comem.Clavier;

/*
    Ecrire un programme qui demande un nombre à l’utilisateur, et l’informe 
    ensuite si ce nombre est positif, négatif ou nul.
*/

public class Exercice05_PositifNegatifNul {

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
        
        // Saisie de la valeur
        double nb = Clavier.rend_double("Entrez un nombre: ");
        
        // Calculs
        boolean estStrictementPositif = nb > 0;
        boolean estStrictementNegatif = nb < 0; // ou !(nb > 0)
        
        // Affichage des résultats
        System.out.print("Le nombre " + nb + " est ");
        if (estStrictementPositif) {
            System.out.println("positif");
        } else if (estStrictementNegatif) {
            System.out.println("négatif");
        } else {
            System.out.println("nul");
        }
    }
}