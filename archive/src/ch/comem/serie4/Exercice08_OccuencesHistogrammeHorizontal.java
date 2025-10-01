package ch.comem.serie4;

/**
 * Soit un tableau de N notes entières de l'intervalle [1;6] initialisé par vos soins.
 *  Ecrire un programme permettant d'afficher sous forme d'histogramme le nombre d'occurrences de chaque note : 
 *
 * ​	Exemple : (N=12)
 *  ​		1           (aucune occurrence de la note 1)
 *  ​		2 X         (1 occurrence de la note 2)
 *  ​		3 XXXX      (4 occurrence de la note 3)
 *  ​		4 XX        (2 occurrences de la note 4)
 *  ​		5 XXX       (3 occurrences de la note 5)
 *  ​		6 XX        (2 occurrences de la note 6)
 */
public class Exercice08_OccuencesHistogrammeHorizontal {

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
        System.out.println("Ce programme génère " + NB_NOTES + " notes au hasard (entre " + VAL_MIN + " et " + VAL_MAX + ")");
        System.out.println("Il affiche le nombre d'occurences de chaque note sous forme d'histogramme horizontal");
        final char SYMBOLE = '#';
        int[] tabNotes = new int[NB_NOTES];
        int[] tabOccurences = new int[VAL_MAX-VAL_MIN+1];
        int decalage = VAL_MIN;
        // Génération des tabNotes et comptage des occurences
        for (int i = 0; i < tabNotes.length; i++) {
            tabNotes[i] = ((int) (Math.random() * (VAL_MAX - VAL_MIN + 1)) + VAL_MIN);
            System.out.print(tabNotes[i] + " ");
            tabOccurences[tabNotes[i]-decalage]++; 
        }
        System.out.println();
        
        // Affichage sous forme d'histogramme horizontal
        for (int i = 0; i < tabOccurences.length; i++) {
            System.out.print((i+decalage) + " ");
            for (int j = 0; j < tabOccurences[i]; j++) {
                System.out.print(SYMBOLE);
            }
            System.out.println();
        }   
    }
}