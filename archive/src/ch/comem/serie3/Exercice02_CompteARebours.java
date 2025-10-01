package ch.comem.serie3;

import ch.comem.Clavier;

public class Exercice02_CompteARebours {

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
        int nb;
        do {
            nb = Clavier.rend_int("Entrez un entier strictement positif: ");
            if (nb<=0) System.out.println("Le nombre n'est pas strictement positif");
        } while (nb<=0);
        
        System.out.println("Compte à rebours à partir de " + nb);
        System.out.println("***********************************");
        int rebours=nb;
        while (rebours>=0){
            System.out.println(rebours);
            rebours--;
        }
    }
}