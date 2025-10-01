package ch.comem.serie3;

import ch.comem.Clavier;

/**
 * Calculer et afficher le plus petit et le plus grand nombre d'une liste de 10 nombres entiers.
 */
public class Exercice05_RecherchePetitGrand {

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
        final int NB_ELEMENTS = 10;
        // Cas particulier pour le premier membre du flot.
        // En effet on ne peut pas le comparer avec "petit" et "grand".
        int nb = Clavier.rend_int("Entrez le 1er nombre : ");
        // On initialise donc "petit" et "grand" avec "nb"
        int petit = nb;
        int grand = nb;
        // On compare les éléments du reste du flot avec "petit" et "grand".
        for (int i=2; i<=NB_ELEMENTS; i++){
            nb = Clavier.rend_int("Entrez le " + (i+1) + "e nombre:");
            if (nb < petit){
               petit = nb;
            } else if (nb > grand) {
                grand = nb;
            }
        }
        System.out.println("Le plus grand nombre est: " + grand);
        System.out.println("Le plus petit nombre est: " + petit);
    }
}