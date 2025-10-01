package ch.comem.serie2;

import ch.comem.Clavier;

/*
    Veuillez écrire un programme qui décompose une somme d'argent (saisie par l'utilisateur) en le moins de pièces de 5.-, de 2.- et de 1.- possibles.

    ​Exemple :
    ​    Veuillez saisir la somme à décomposer : 18
    ​        Il faut 5 pièces pour arriver à 18.- :
    ​            3 pièces de 5.-
    ​            1 pièce de 2.-
    ​            1 pièce de 1.-
*/

public class Exercice12_Decomposition {

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
        System.out.println("Ce programme décompose une somme d'argent en pièces de 5.-, 2.- et 1.-");
        int somme = Clavier.rend_int("Veuillez saisir la somme d'argent (valeur entière, sans les centimes) : ");
        int nbPieces5;
        int nbPieces2;
        int nbPieces1;
        int reste;
        
        reste = somme;
        nbPieces5 = reste / 5;
        reste = reste % 5;
        nbPieces2 = reste / 2;
        reste = reste % 2;
        nbPieces1 = reste;
        System.out.println("Il faut " + (nbPieces5 + nbPieces2 + nbPieces1) + " pièces pour arriver à " + somme + ".-");
        if (nbPieces5 > 0) {
            System.out.println("" + nbPieces5 + " x piece(s) de 5.-");
        }
        if (nbPieces2 > 0) {
            System.out.println("" + nbPieces2 + " x piece(s) de 2.-");
        }
        if (nbPieces1 > 0) {
            System.out.println("" + nbPieces1 + " x piece(s) de 1.-");
        }
    }
}