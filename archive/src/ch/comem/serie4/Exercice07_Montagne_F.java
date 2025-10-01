package ch.comem.serie4;

import java.util.Arrays;
import ch.comem.Clavier;

/**
 * Ecrire un programme permettant de saisir une phrase et qui stocke chaque mot dans une case d'un tableau.
 */
public class Exercice07_Montagne_F {

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
        presenteProgramme();
        String phrase = saisiPhrase();
        String[] mots = splittePhrase(phrase);
        System.out.println(Arrays.toString(mots));
    }   

    private static void presenteProgramme() {
        System.out.println("Ce programme permet de saisir une phrase, "
                + "puis stocke chaque mot dans une case d'un tableau");
    }

    private static String saisiPhrase() {
        String phrase;
        do {
            phrase = Clavier.rend_String("Veuillez saisir une phrase : ").trim();
            if (phrase.length()==0) {
                System.out.println("Il faut une phrase !");
            }
        } while (phrase.length()==0);
        return phrase;
    }

    private static String[] splittePhrase(String phrase) {
        //On compte le nombre d'espaces pour pouvoir dimentionner le tableau
        int compteur = 0;
        char precedant = '_';
        final char ESPACE = ' ';
        char car;
        for (int i = 0; i < phrase.length(); i++) {
            car = phrase.charAt(i);
            if (car==ESPACE && precedant!=ESPACE) {
                compteur++;
            }
            precedant = car;
        }
        String[] mots = new String[compteur+1];
        String mot = "";
        int j=0;
        for (int i = 0; i < phrase.length(); i++) {
            car = phrase.charAt(i);
            if (car!=ESPACE) {
                mot+=car;
            } else {
                if (precedant != ESPACE) {
                    mots[j] = mot;
                    mot = "";
                    j++;
                }
            }
            precedant = car;
        }
        mots[j] = mot;
        return mots;
    }
}