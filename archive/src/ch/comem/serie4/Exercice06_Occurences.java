package ch.comem.serie4;

public class Exercice06_Occurences {

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
        System.out.println("Ce programme génère 1000 valeurs entre deux valeurs");
        System.out.println("Il affiche ensuite le nombre d'occurences de chaque valeur");
        final int NB_ELEMENTS = 1000;
        final int VAL_MIN = 0;
        final int VAL_MAX = 9;
        int[] nombres = new int[NB_ELEMENTS];
        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = ((int) (Math.random() * (VAL_MAX - VAL_MIN + 1)) + VAL_MIN);
        }
        
        // Indication : pour stocker les valeurs du nb. d'occurences, il suffit
        //              de décommenter les lignes grises
        
        //int[] tabOccChiffres = new int[VAL_MAX-VAL_MIN+1];
        //int index = 0;
        for (int chiffre = VAL_MIN;chiffre <= VAL_MAX; chiffre++) {
            System.out.print(chiffre);
            int compteur = 0;
            for (int i = 0; i < nombres.length; i++) {
                if (nombres[i] == chiffre) {
                    compteur++;
                }
            }
            //tabOccChiffres[index] = compteur;
            //index++;
            System.out.println(" => " + compteur + " occurences");
        }
    }
}
