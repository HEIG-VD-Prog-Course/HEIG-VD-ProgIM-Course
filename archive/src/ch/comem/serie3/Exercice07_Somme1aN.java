package ch.comem.serie3;

import ch.comem.Clavier;

/**
 * Ecrire un algorithme qui demande un nombre entier de départ, et qui
 * calcule la somme des entiers à partir de 1 jusqu’à ce nombre. Par exemple, si
 * l'on entre 5, le programme doit calculer : 1 + 2 + 3 + 4 + 5 = 15
 */
public class Exercice07_Somme1aN {

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
        int limiteSup = Clavier.rend_int("Entrez un nombre eniter : ");
        //au départ la somme est nul
        int somme = 0;
        //boucle de parcours des nombres (on ajoute ces nombres à la somme)
        for(int nb=1; nb<=limiteSup; nb++){
            somme = somme + nb;
        }
        System.out.print("La somme des nombres entiers entre 1 et " +
                limiteSup + " vaut: ");
        System.out.println(somme);
        
        System.out.print("La somme des nombres entiers (vive les math ;-) entre 1 et " +
                limiteSup + " vaut: ");
        System.out.println(limiteSup*(limiteSup+1) /2);
    }
}