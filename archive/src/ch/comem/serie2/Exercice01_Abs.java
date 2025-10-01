package ch.comem.serie2;

import ch.comem.Clavier;

/*
    Ecrire un programme qui saisit et calcule la valeur absolue d’un réel. 
    Afficher le résultat sous la forme : "La valeur absolue de -5 est 5" 
*/
public class Exercice01_Abs {

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
        System.out.println("Ce programme saisi une valeur et affiche sa valeur absolue");
        
        // Saisie de la valeur
        double nb = Clavier.rend_double("Entrez un nombre dont vous voulez la valeur absolue");
        
        // Calcul
        double abs;
        if (nb<0) {
            abs = nb*-1;
        } else {
            abs = nb;
        }
        
        // Affichage du résultat
        System.out.println("La valeur absolue de " + nb + " est " + abs);
    }
}
