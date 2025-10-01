package ch.comem.serie4;

public class Exercice01_AffichageTableauInverse {

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
        int[] tab = {1,2,3,4,5,6,7,8,9,10};
        // Affichage du tableau à l'envers
        System.out.print("{");
        for (int i=tab.length-1; i>0; i--) {
            System.out.print(tab[i]+",");
        }
        System.out.print(tab[0]);
        System.out.println("}");
    }
    
}
