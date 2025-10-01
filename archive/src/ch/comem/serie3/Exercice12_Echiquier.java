package ch.comem.serie3;

/**
 * Afficher un échiquier 8x8
 * case noire = caractère # 
 * case blanche = caractère o
 */
public class Exercice12_Echiquier {

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
        final char CASE_BLANCHE = 'o';
        final char CASE_NOIRE = '#';
        final int NB_LIGNES = 8;
        final int NB_COLONNES = 8;
        
        //pour chaque ligne
        for (int ligne = 0; ligne < NB_LIGNES; ligne++) {
            //pour chaque colonne de la ligne
            for (int colonne = 0; colonne < NB_COLONNES; colonne++) {
                if ((ligne + colonne) % 2 == 0) {
                    System.out.print(CASE_BLANCHE);
                    System.out.print(' ');
                } else {
                    System.out.print(CASE_NOIRE);
                    System.out.print(' ');
                }
            }
            //retour à la ligne une fois la ligne completement affichée
            System.out.println();
        }
    }
}