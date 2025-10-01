package ch.comem.serie3;

import ch.comem.Clavier;

/**
 * Ecrire un algorithme qui demande un nombre de départ (entier positif),
 * et qui calcule sa factorielle. Exemple : la factorielle de 5, notée 5!, vaut
 * 1 x 2 x 3 x 4 x 5 = 120.
 */
public class Exercice08_Factoriel {

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
        int limite = Clavier.rend_int("Entrez un nombre entier dont vous voulez la factorielle : ");
        int nb = 2;
        double factorielle = 1;
        //on continue tant que le calcul n'est pas fini
        //et qu'aucun dépassement de capacité ne se produit
        while (nb <= limite && nb <= Double.MAX_VALUE / factorielle) {
            factorielle = factorielle * nb;
            nb++;
        }
        //si il y a eu un dépassement de capacité on affichage une erreur
        if (nb > Double.MAX_VALUE / factorielle) {
            System.err.print("Le calcul de " + limite + "! provoque un dépassement de capacité.");
            System.err.println(" Le résultat est trop grand pour être stocké en mémoire.");
            System.err.println("Le maxmimum calculable est " + (nb-2) + "! .");
            System.exit(0);
        }
        System.out.println(limite + "! = " + factorielle);
    }
}