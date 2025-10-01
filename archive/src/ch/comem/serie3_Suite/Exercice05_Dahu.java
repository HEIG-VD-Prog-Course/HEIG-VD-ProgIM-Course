package ch.comem.serie3_Suite;

import ch.comem.Clavier;

public class Exercice05_Dahu {

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
        System.out.println("Ce programme génère un nombre entre 1000 et 2000 et l'utilisateur doit le trouver");
        final int BORNE_MIN = 1000;
        final int BORNE_MAX = 2000;

        int plageValeurs = BORNE_MAX - BORNE_MIN + 1;
        final int NOMBRE_A_TROUVER = BORNE_MIN + ((int) (Math.random() * plageValeurs));

        int nbEssais = 0;

        int nombre;

        do {
            nombre = Clavier.rend_int("Saisi un entier entre " + BORNE_MIN + " et " + BORNE_MAX + " : ");
            if (nombre < NOMBRE_A_TROUVER) {
                System.out.println("Le nombre à trouver est plus grand");
            } else if (nombre > NOMBRE_A_TROUVER) {
                System.out.println("Le nombre à trouver est plus petit");
            }
            nbEssais++;
        } while (nombre != NOMBRE_A_TROUVER);
        System.out.println("Bravo tu as trouvé. Il t'as fallu " + nbEssais + " essais");
    }
}
