package ch.comem.serie4;

/**
 * Soit un tableau de N notes entières de l'intervalle [1;6] initialisé par vos
 * soins. Ecrire un programme permettant d'afficher sous forme d'histogramme le
 * nombre d'occurrences de chaque note :
 *
 * Exemple : (N=12) ​ 
 *    1      (aucune occurrence de la note 1) ​ 
 *    2 X    (1 occurrence de la note 2) ​ 
 *    3 XXXX (4 occurrence de la note 3) ​ 
 *    4 XX   (2 occurrences de la note 4) ​ 
 *    5 XXX  (3 occurrences de la note 5) 
 *    6 XX   (2 occurrences de la note 6)
 */
public class Exercice08_OccuencesHistogrammeHorizontal_F {

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
        afficheHistogrammeHorizontal(tabOccurences, VAL_MIN, SYMBOLE);

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

    private static void afficheHistogrammeHorizontal(int[] tabOccurences,
            int valMin, char symbole) {
        if (tabOccurences != null && tabOccurences.length > 0) {
            int decalage = valMin;
            for (int i = 0; i < tabOccurences.length; i++) {
                System.out.print((i + decalage) + " ");
                for (int j = 0; j < tabOccurences[i]; j++) {
                    System.out.print(symbole);
                }
                System.out.println();
            }
        }
    }
}
