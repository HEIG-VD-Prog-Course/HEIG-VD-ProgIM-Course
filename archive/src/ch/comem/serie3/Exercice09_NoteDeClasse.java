package ch.comem.serie3;

import ch.comem.Clavier;

/**
 * L'utilisateur choisi un nombre N de notes et saisi ces N notes. A la fin de
 * la saisie, le programme affiche la somme, la moyenne et la plus grande de ces
 * notes. De plus, il faut assurer le contrôle de la validité de notes saisies
 * [1;6].
 */
public class Exercice09_NoteDeClasse {

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
        int nbNotes = 0;
        boolean nbNotesOk;
        do {
            nbNotes = Clavier.rend_int("Combien de notes voulez-vous saisir ? : ");
            nbNotesOk = nbNotes > 0;
            if (!nbNotesOk) {
                System.out.println("Le nombre de notes n'est pas valide !");
            }
        } while (!nbNotesOk);

        double note;
        //on initialise le maximum et la somme
        double somme = 0;
        double max = NOTE_MIN;
        boolean noteOk;
        //pour chaque note
        for (int nbFois = 1; nbFois <= nbNotes; nbFois++) {
            // saisie de la note
            do {
                note = Clavier.rend_double("Entrez la " + nbFois + "e note : ");
                noteOk = (note >= NOTE_MIN && note <= NOTE_MAX);
                if (!noteOk) {
                    System.out.print("La note " + note + " n'a pas été prise en compte");
                }
            } while (!noteOk);
            // prise en compte de la note
            if (note > max) {
                max = note;
            }
            somme += note;
        }

        // une fois toutes les notes saisies, on peut calculer la moyenne
        double moyenne = somme / nbNotes;
        // arrondie au 100e
        final double PRECISION = 0.01;
        double moyenneArrondie = Math.round(moyenne/PRECISION)*PRECISION;
        System.out.println("La somme des notes vaut : " + somme);
        System.out.println("La moyenne des notes vaut : " + moyenneArrondie);
        System.out.println("La meilleure note est : " + max);
    }
}