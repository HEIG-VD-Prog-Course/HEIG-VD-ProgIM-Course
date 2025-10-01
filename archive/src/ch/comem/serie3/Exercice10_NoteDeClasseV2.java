package ch.comem.serie3;

import ch.comem.Clavier;

/**
 * Idem mais cette fois-ci, on ne demande pas à l'utilisateur combien de notes
 * il veut saisir, mais c'est lui qui stoppe la saisie en entrant une note
 * invalide (hors de l'intervalle de validité [1:6]).
 */
public class Exercice10_NoteDeClasseV2 {

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
        final int NOTE_MIN = 1;
        final int NOTE_MAX = 6;

        double note;
        //on initialise le maximum et la somme
        double somme = 0;
        double max = NOTE_MIN;
        boolean noteOk;
        int nbNotes = 0;
        // saisie de la note
        do {
            note = Clavier.rend_double("Entrez la " + (nbNotes+1) + "e note : ");
            noteOk = (note >= NOTE_MIN && note <= NOTE_MAX);
            if (noteOk) {
                nbNotes++;
                if (note > max) {
                    max = note;
                }
                somme += note;
            }
        } while (noteOk);
            // prise en compte de la note

        // une fois toutes les notes saisies, on peut calculer la moyenne
        double moyenne = 0;
		if (nbNotes!=0) {
			moyenne = somme / nbNotes;
		}
        // arrondie au 100e
        final double PRECISION = 0.01;
        double moyenneArrondie = Math.round(moyenne / PRECISION) * PRECISION;
        System.out.println("La somme des notes vaut : " + somme);
        System.out.println("La moyenne des notes vaut : " + moyenneArrondie);
        System.out.println("La meilleure note est : " + max);
    }
}
