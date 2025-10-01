package ch.comem.serie3_Suite;

import ch.comem.Clavier;

public class Exercice05_Dahu_F {

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
        Exercice05_Dahu_F.presenteProgramme();
        final int BORNE_MIN = 1000;
        final int BORNE_MAX = 2000;
        Exercice05_Dahu_F.joue(Exercice05_Dahu_F.genereNombreEntre(BORNE_MIN, BORNE_MAX), BORNE_MIN, BORNE_MAX);
    }

    public static void presenteProgramme() {
        System.out.println("Ce programme génère un nombre entre 100 et 200 et l'utilisateur doit le trouver");
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

    public static void joue(int nombreATrouver, int borneMin, int borneMax) {
        int nbEssais = 0;
        int nombre;
        if (nombreATrouver >= borneMin && nombreATrouver <= borneMax) {
            do {
                nombre = Exercice05_Dahu_F.rendEntierSaisi("Saisi un entier entre " + borneMin + " et " + borneMax + " : ");
                if (nombre < nombreATrouver) {
                    System.out.println("Le nombre à trouver est plus grand");
                } else if (nombre > nombreATrouver) {
                    System.out.println("Le nombre à trouver est plus petit");
                }
                nbEssais++;
            } while (nombre != nombreATrouver);
            System.out.println("Bravo tu as trouvé. Il t'as fallu " + nbEssais + " essais");
        }
    }

    public static int rendEntierSaisi(String message) {
        return Clavier.rend_int(message);
    }
}
