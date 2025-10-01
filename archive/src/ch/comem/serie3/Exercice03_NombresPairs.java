package ch.comem.serie3;

import ch.comem.Clavier;

public class Exercice03_NombresPairs {

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
        int limite;
        boolean estPlusPetitOuEgalADeux;
        do {
            limite = Clavier.rend_int("Entrez la limite supérieure ( >=2 ) des nombres pairs à afficher: ");
            estPlusPetitOuEgalADeux = (limite<=2);
            if (estPlusPetitOuEgalADeux) {
              System.out.println("Le nombre n'est pas plus grand ou égal à 2");
            }
        } while (estPlusPetitOuEgalADeux);
        
        // Affichage des résultats
        System.out.println("Liste des nombre pairs entre 1 et " + limite);
        System.out.println("********************************************");
        for(int nb=2; nb<=limite; nb+=2){
            System.out.println(nb);
        }
    }
}
