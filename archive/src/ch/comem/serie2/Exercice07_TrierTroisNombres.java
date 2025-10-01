package ch.comem.serie2;

import ch.comem.Clavier;

/*
    Veuillez écrire un programme qui saisit trois nombres a, b, c et qui affiche les valeurs saisies par ordre      croissant.

    Exemple :
   ​         Veuillez saisir le 1e nombre : 4.2
   ​         Veuillez saisir le 2e nombre : 10.5
   ​         Veuillez saisir le 3e nombre : -5
   ​         Vous avez saisi les valeurs suivantes : -5, 4.2 et 10.5
*/

public class Exercice07_TrierTroisNombres {

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
        double a = Clavier.rend_double("Entrez la valeur de a : ");
        double b = Clavier.rend_double("Entrez la valeur de b : ");
        double c = Clavier.rend_double("Entrez la valeur de c : ");

        double petit = a;
        double moyen = b;
        double grand = c;
        double temp;
        if (petit > moyen){
            temp = moyen;
            moyen = petit;
            petit = temp;
        }
        if (moyen > grand){
            temp = grand;
            grand = moyen;
            moyen = temp;
        }
        if (petit > moyen){
            temp = moyen;
            moyen = petit;
            petit = temp;
        }
        System.out.print("Les trois nombres (" + a + ", " + b + ", " + c + ") triés par ordre croissant: ");
        System.out.println(petit + ", " + moyen + ", " + grand);
    }
}