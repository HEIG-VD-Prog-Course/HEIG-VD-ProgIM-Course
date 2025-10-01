package ch.comem.serie3;

import ch.comem.Clavier;

/**
 * Compter combien il y a de nombres inférieurs ou égaux à 15 dans une liste de 10 nombres entiers.
 */
public class Exercice06_Compteur {

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
        final int NB_LIMITE = 15;
        //avec un flot vide, aucun nombre n'est plus petit que la limite
        int nb;
        int compteur = 0;
        //pour chaque membre du flot
        for (int i = 0; i < NB_ELEMENTS; i++) {
            nb = Clavier.rend_int("Entrez le " + (i+1) + "e nombre:");
            //si le nombre est plus petit ou égal à la limite on incrémente le compteur
            if (nb <= NB_LIMITE) {
                compteur++;
            }
        }
        System.out.println("Il y a " + compteur + " nombre(s) inférieurs ou égaux à " + NB_LIMITE);
    }
}