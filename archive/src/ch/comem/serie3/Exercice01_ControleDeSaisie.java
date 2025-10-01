package ch.comem.serie3;

import ch.comem.Clavier;

public class Exercice01_ControleDeSaisie {

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
        double nb;
        do {
            nb = Clavier.rend_double("Veuillez saisir un nombre dans l'intervalle [1;3]");
        } while (nb<1 || nb>3);
        //si on arrive ici c'est que nb est bien entre 1 et 3.
        System.out.println("Le nombre saisi est: " + nb);
    }
}
