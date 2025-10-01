package ch.comem.serie4;

/**
 * Soit un tableau de N notes entières de l'intervalle [1;6] initialisé par vos soins.
 * Ecrire un programme permettant d'afficher sous forme d'histogramme vertical 
 * le nombre d'occurrences de chaque note.
 */
public class Exercice09_OccurencesAutreSens {
    
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
        
        // Recherche du nombre max d'occurences
        int max = 0;
        for (int i = 0; i < tabOccurences.length; i++) {
            if (tabOccurences[i]>max) {
                max = tabOccurences[i];
            }
        }
        
        // Pour toutes les occurences
        for (int i = max; i >= 1; i--) {
            // Pour chacune des notes
            for (int j = 0; j < tabOccurences.length; j++) {
                // Affichage du caractère adhéquat
                if (tabOccurences[j]>=i) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
       
        // Affichage de toutes les notes
        for (int j = VAL_MIN; j <= VAL_MAX; j++) {
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println();
    }
}