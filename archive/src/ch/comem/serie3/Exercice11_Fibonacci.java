package ch.comem.serie3;

import ch.comem.Clavier;

/**
 * Afficher les premiers termes de la suite de Fibonacci jusqu'à l'ordre N. 
 * La donnée N doit être positive ou nulle. La suite de Fibonacci est:
 * F0=0
 * F1=1
 * Fk=Fk-2+Fk-1 pour k>1
 */
public class Exercice11_Fibonacci {

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
        int ordreFiboMax = 0;
        boolean ordreFiboOk;
        do {
            ordreFiboMax = Clavier.rend_int("Quel est l'ordre du nombre à calculer ? : ");
            ordreFiboOk = ordreFiboMax >= 0;
            if (!ordreFiboOk) {
                System.out.println("L'ordre n'est pas valide !");
            }
        } while (!ordreFiboOk);
        
         //affichage du premier terme de la suite
        System.out.println("f(" + 0 + ") = " + 0);
        //s'il faut affiche plus d'un terme
        if (ordreFiboMax>0){
            System.out.println("f(" + 1 + ") = " + 1);
        }
        //initialise les deux premiers termes de la suite de Fibonacci
        int fiboAntePenultieme = 0;
        int fiboPenultieme = 1;
        int fibo;
        //on a déjà affiché les 2 premiers termes de la suite de Fibonacci
        int terme = 2;
        //Affichage jusqu'a l'ordre "ordreFiboMax" des termes de la suite
        while (terme<=ordreFiboMax){
            fibo = fiboAntePenultieme + fiboPenultieme;
            //on effectue une rotation:
            //le précédent du précédent devient le précédent
            fiboAntePenultieme = fiboPenultieme;
            //et le précédent devient le membre actuel
            fiboPenultieme = fibo;
            System.out.println("f(" + terme + ") = " + fibo);
            //on a affiché un nombre de Fibonacci en plus.
            terme++;
        }
    }
}