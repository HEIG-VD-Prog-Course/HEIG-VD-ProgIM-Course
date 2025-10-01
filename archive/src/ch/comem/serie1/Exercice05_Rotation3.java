package ch.comem.serie1;

/*
   Idem pour une rotation de 3 variables.
   Voici ce que devra afficher le programme :
             Avant : 
                        x = 1
                        y = 2
                        z = 3
             Maintenant :
                        x = 2
                        y = 3
                        z = 1
*/

public class Exercice05_Rotation3 {

    // Règle les éventuels problèmes d'affichage des accents
    static {
        try {
            System.setOut(new java.io.PrintStream(
                    new java.io.FileOutputStream(java.io.FileDescriptor.out), true, "UTF-8"));
            
        } catch (java.io.UnsupportedEncodingException ex) {
            System.out.println("VM dont support UTF-8");
        }
    }
    
    /**
     * Début du programme
     * @param args
     */
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int z = 3;
        
        System.out.println("Avant : ");
        System.out.println("     x = " + x);
        System.out.println("     y = " + y);
        System.out.println("     z = " + z);
        
        // On sauvegarde la valeur de la variable x, car on va "l'écraser"
        int temp = x;
        // Remplace la valeur de x par la valeur de y
        x = y;
        // Remplace la valeur de y par la valeur de z
        y = z;
        // Remplace la valeur de z par la valeur de temp (c.à.d. du x sauvegardé)
        z = temp;
        
        System.out.println("Après : ");
        System.out.println("     x = " + x);
        System.out.println("     y = " + y);
        System.out.println("     z = " + z);
    }
}