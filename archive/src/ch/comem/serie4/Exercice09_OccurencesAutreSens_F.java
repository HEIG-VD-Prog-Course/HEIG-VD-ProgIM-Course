package ch.comem.serie4;

/**
 * Soit un tableau de N notes entières de l'intervalle [1;6] initialisé par vos
 * soins. Ecrire un programme permettant d'afficher sous forme d'histogramme
 * vertical le nombre d'occurrences de chaque note.
 */
public class Exercice09_OccurencesAutreSens_F {

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
        final int NB_NOTES = 20;
        final int VAL_MIN = 1;
        final int VAL_MAX = 6;
        final char SYMBOLE = '#';
        int[] tabNotes = new int[NB_NOTES];
        int[] tabOccurences = new int[VAL_MAX - VAL_MIN + 1];

        presenteProgramme(NB_NOTES, VAL_MIN, VAL_MAX);
        genereNotesEtCompteNbOccurences(tabNotes, tabOccurences,
                VAL_MIN, VAL_MAX);
        afficheHistogrammeVertical(tabOccurences, VAL_MIN, VAL_MAX, SYMBOLE);
    }

    private static void presenteProgramme(int nbNotes, int valMin, int valMax) {
        System.out.println("Ce programme génère " + nbNotes + " notes au hasard (entre " + valMin + " et " + valMax + ")");
        System.out.println("Il affiche le nombre d'occurences de chaque note sous forme d'histogramme horizontal");
    }

    private static void genereNotesEtCompteNbOccurences(int[] tabNotes, int[] tabOccurences, int valMin, int valMax) {
        if (tabNotes != null && tabNotes.length > 0
                && tabOccurences != null && tabOccurences.length > 0) {
            int decalage = valMin;
            // Génération des tabNotes et comptage des occurences
            System.out.print("\nVoici les notes (aléatoires) : ");
            for (int i = 0; i < tabNotes.length; i++) {
                tabNotes[i] = ((int) (Math.random() * (valMax - valMin + 1)) + valMin);
                System.out.print(tabNotes[i] + " ");
                tabOccurences[tabNotes[i] - decalage]++;
            }
            System.out.println("\n");
        }
    }

    private static void afficheHistogrammeVertical(int[] tabOccurences,
            int valMin, int valMax, char symbole) {

        if (tabOccurences != null && tabOccurences.length > 0) {
            // Recherche du nombre max d'occurences
            int max = 0;
            for (int i = 0; i < tabOccurences.length; i++) {
                if (tabOccurences[i] > max) {
                    max = tabOccurences[i];
                }
            }

            // Pour toutes les occurences
            for (int i = max; i >= 1; i--) {
                // Pour chacune des notes
                for (int j = 0; j < tabOccurences.length; j++) {
                    // Affichage du caractère adhéquat
                    if (tabOccurences[j] >= i) {
                        System.out.print(symbole);
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }

            // Affichage de toutes les notes
            for (int i = valMin; i <= valMax; i++) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
