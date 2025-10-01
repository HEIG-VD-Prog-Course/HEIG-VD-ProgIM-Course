package ch.comem.serie1;

import ch.comem.Clavier;

/*
Veuillez écrire un programme permettant le calcul de la moyenne d'un cours dont les 
notes n'ont pas le même coefficient.
L'utilisateur saisit :
        - la note d'examen intermédiaire,     (coefficient 2)
        - la note de projet,                  (coefficient 1)
        - la note de l'examen final.          (coefficient 3)
Le programme calcule la moyenne (en fonction des coefficients) et affiche la 
moyenne du cours.

*/

public class Exercice08_Moyenne {    

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
        System.out.println("Ce programme calcul la moyenne d'un étudiant.");
        
        // Constantes
        final int COEFF_FINAL = 3;
        final int COEFF_INTER = 2;
        final int COEFF_PROJET = 1;
        
        // Saisie des valeurs
        double noteExaFinal = Clavier.rend_double("Entrez la note de l'examen final : ");
        double noteExaInter = Clavier.rend_double("Entrez la note de l'examen intermédiaire : ");
        double noteProjet = Clavier.rend_double("Entrez la note de projet : ");
        double moyenne = ((noteExaFinal * COEFF_FINAL) + (noteExaInter * COEFF_INTER) +
                (noteProjet * COEFF_PROJET)) / (COEFF_FINAL + COEFF_INTER +
                COEFF_PROJET);
        
        // Calcul
        final double PRECISION = 0.1;
        double moyenneArrondie = Math.round(moyenne/PRECISION)*PRECISION; 

        // Affichage
        System.out.println("Pour un étudiant dont les notes sont "
                + "les suivantes: ");
        System.out.println("Note de l'examen final (coeff. " + COEFF_FINAL
                + "): " + noteExaFinal );
        System.out.println("Note de l'examen intermédiaire (coeff. "
                + COEFF_INTER + "): " + noteExaInter);
        System.out.println("Note de projet (coeff. " + COEFF_PROJET + "): " +
                noteProjet);
        System.out.println("Moyenne: " + moyenneArrondie);
    }
}