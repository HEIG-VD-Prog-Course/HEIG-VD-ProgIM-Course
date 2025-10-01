package ch.comem.serie2;

import ch.comem.Clavier;

/*
    Ecrire un programme qui demande un nombre à l’utilisateur, et l’informe 
    ensuite si ce nombre est négatif (<0) ou positif (>=0). 
*/

public class Exercice04_PositifNegatif {

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
 
        // Saisie du nombre
        double nb = Clavier.rend_double("Entrez un nombre: ");
        
        // Calcul
        boolean estPositif = nb>=0;
 
        // Affichage du résultat
        System.out.print("Le nombre " + nb + " est ");
        if (estPositif) {
            System.out.println("positif");
        } else {
            System.out.println("négatif");
        }
    }
}