package ch.comem.serie3_Suite;

import ch.comem.Clavier;

public class Exercice06_TrouveNombre_F {

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
        final int BORNE_MIN = 1000;
        final int BORNE_MAX = 2000;
        Exercice06_TrouveNombre_F.presenteProgramme(BORNE_MIN, BORNE_MAX);
        Exercice06_TrouveNombre_F.joue(BORNE_MIN, BORNE_MAX);
    }

    public static void presenteProgramme(int borneMin, int borneMax) {
        System.out.println("Ce programme recherche un nombre entre " + borneMin + " et " + borneMax + " que vous avez choisi préalablement");
    }

    public static int genereNombreEntre(int borneMax, int borneMin) {
        // Au cas où l'utilisateur est un âne
        if (borneMin > borneMax) {
            int tmp;
            tmp = borneMin;
            borneMin = borneMax;
            borneMax = tmp;
        }
        int plageValeurs = borneMax - borneMin + 1;
        int nombre = (int) (Math.random() * plageValeurs);
        return nombre + borneMin;
    }

    public static void joue(int borneMin, int borneMax) {
        int nombre;
        int nbEssais = 0;
        boolean trouve;
        boolean nombreEstPlusGrand = false;
        do {
            nbEssais++;
            int delta = borneMax-borneMin;
            if (delta > 1) {
                nombre = borneMin + (delta)/2;
            } else {
                if (nombreEstPlusGrand) {
                    nombre=borneMin+1;
                } else {
                    nombre=borneMax-1;
                }
            }
            trouve = Exercice06_TrouveNombre_F.estCeJuste("Est-ce que le nombre à trouver est : " + nombre + " ?");
            if (!trouve) {
                nombreEstPlusGrand = Exercice06_TrouveNombre_F.estCeJuste("Est-ce que le nombre à trouver est plus grand ? : ");
                if (nombreEstPlusGrand) {
                    borneMin=nombre;
                } else {
                    borneMax=nombre;
                }
            }
        } while (!trouve);
        System.out.println("Hé, hé... ;-) Il m'a fallu " + nbEssais + " essais");
    }

    public static boolean estCeJuste(String message) {
        char c = Clavier.rend_char(message);
        return c == 'o' || c == 'O';
    }
}
