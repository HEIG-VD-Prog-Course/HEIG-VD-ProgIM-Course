package ch.comem.serie1;

import ch.comem.Clavier;

/*

Dans un logiciel de gestion de photos, on désire afficher "x" photos. 
Sachant qu'il y a "y" photos par ligne, combien y aura-t-il de lignes pleines ?
Exemple :
        Combien de photos avez-vous : 427
        Combien de photos par lignes : 11
        Il y aura 38 lignes constituées de 11 photos.

*/

public class Exercice09_Photos {

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
        int nbPhotos = Clavier.rend_int("Combien de photos avez-vous : ");
        int nbPhotosParLignes = Clavier.rend_int("Combien de photos par lignes : ");  
        
        System.out.println("Il y aura " + nbPhotos/nbPhotosParLignes + 
                " lignes constituées de " + nbPhotosParLignes + " photos");
    }
}