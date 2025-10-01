package ch.comem.serie3_Suite;

import ch.comem.Clavier;

public class Exercice06_TrouveNombre {

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
        int BORNE_MIN = 1000;
        int BORNE_MAX = 2000;
        
        System.out.println("Ce programme recherche un nombre entre " + BORNE_MIN + " et " + BORNE_MAX + " que vous avez choisi préalablement");

        int nombreMin = BORNE_MIN;
        int nombreMax = BORNE_MAX;
        int nombre;
        int nbEssais = 0;
        boolean trouve;
        boolean nombreEstPlusGrand = false;
        
        do {
            nbEssais++;
            int delta = nombreMax - nombreMin;
            if (delta > 1) {
                nombre = nombreMin + (delta) / 2;
            } else {
                if (nombreEstPlusGrand) {
                    nombre = nombreMin + 1;
                } else {
                    nombre = nombreMax - 1;
                }
            }
            String message = "Est-ce que le nombre à trouver est : " + nombre + " ? [o;n]: ";
            char c = Clavier.rend_char(message);
            trouve = c == 'o' || c == 'O';
            if (!trouve) {
                message = "Est-ce que le nombre à trouver est plus grand ? [o;n]: ";
                c = Clavier.rend_char(message);
                nombreEstPlusGrand = c == 'o' || c == 'O';
                if (nombreEstPlusGrand) {
                    nombreMin = nombre;
                } else {
                    nombreMax = nombre;
                }
            }
        } while (!trouve);
        System.out.println("Hé, hé... ;-) Il m'a fallu " + nbEssais + " essais");
    }
}