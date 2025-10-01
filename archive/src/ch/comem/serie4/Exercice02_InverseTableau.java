package ch.comem.serie4;

public class Exercice02_InverseTableau {

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
        int temp;
        int iFin = tab.length-1;
        for (int i = 0; i < tab.length/2; i++) {
            temp = tab[i];
            tab[i] = tab[iFin-i];
            tab[iFin-i] = temp;
        }
        // Affichage du tableau à l'endroit
        System.out.print("{");
        for (int i=0; i<tab.length-1; i++) {
            System.out.print(tab[i]+",");
        }
        System.out.print(tab[tab.length-1]);
        System.out.println("}");
    }
}
