package ch.comem.serie4;

public class Exercice06_Occurences_F {

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
        final int NB_ELEMENTS = 1000;
        final int VAL_MIN = 0;
        final int VAL_MAX = 9;
        int[] nombres = new int[NB_ELEMENTS];

        presenteProgramme();
        initialiseTableauValeurs(nombres, VAL_MIN, VAL_MAX);
        afficheOccurences(nombres, VAL_MIN, VAL_MAX);
    }

    private static void presenteProgramme() {
        System.out.println("Ce programme génère 1000 valeurs entre deux valeurs");
        System.out.println("Il affiche ensuite le nombre d'occurences de chaque valeur");
    }

    private static void initialiseTableauValeurs(int[] nombres, int valMin, int valMax) {
        if (nombres != null && nombres.length > 0) {
            for (int i = 0; i < nombres.length; i++) {
                nombres[i] = ((int) (Math.random() * (valMax - valMin + 1)) + valMin);
            }
        }
    }

    private static void afficheOccurences(int[] nombres, int valMin, int valMax) {
        if (nombres != null && nombres.length > 0) {
            for (int chiffre = valMin; chiffre <= valMax; chiffre++) {
                System.out.print(chiffre);
                int compteur = 0;
                for (int i = 0; i < nombres.length; i++) {
                    if (nombres[i] == chiffre) {
                        compteur++;
                    }
                }
                System.out.println(" => " + compteur + " occurences");
            }
        }
    }
}
