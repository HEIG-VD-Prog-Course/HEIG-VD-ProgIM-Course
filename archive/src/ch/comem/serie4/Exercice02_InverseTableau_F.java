package ch.comem.serie4;

public class Exercice02_InverseTableau_F {

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
        int[] tab = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        inverseTableau(tab);
        afficheTableau(tab);
    }

    private static void inverseTableau(int[] tab) {
        if (tab != null && tab.length > 0) {
            int temp;
            int iFin = tab.length - 1;
            for (int i = 0; i < tab.length / 2; i++) {
                temp = tab[i];
                tab[i] = tab[iFin - i];
                tab[iFin - i] = temp;
            }
        }
    }

    private static void afficheTableau(int[] tab) {
        System.out.print("{");
        for (int i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i] + ",");
        }
        System.out.print(tab[tab.length - 1]);
        System.out.println("}");
    }
}
