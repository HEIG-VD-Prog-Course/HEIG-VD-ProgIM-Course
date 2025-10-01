package ch.comem.serie1;

import ch.comem.Clavier;

/*

Veuillez compléter le programme précédant pour connaître le nombre de photos sur la dernière ligne.
    Exemple :
                Combien de photos avez-vous : 427
                Combien de photos par lignes : 11
                Il y aura 38 ligne(s) constituées de 11 photos.
                Il y aura 9 photo(s) sur la dernière ligne.

*/

public class Exercice10_PhotosBis {

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
        
        System.out.println("Il y aura " + nbPhotos%nbPhotosParLignes + 
                " photo(s) sur la dernière ligne");
    }
}