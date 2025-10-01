package ch.comem.serie1;

import ch.comem.Clavier;

/*
        L'utilisateur saisit la valeur du rayon d'un cercle et le programme calcule 
        et affiche la surface et la circonférence.
        Exemple : 
            Veuillez saisir la valeur du rayon du cercle : 10.5
            La surface du cercle est de : 346.3605900582747
            La circonférence est de : 65.97344572538566
 */
public class Exercice06_Cercle {

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
        System.out.println("Calcul de la surface et de la circonférence d'un cercle.");
        double rayon = Clavier.rend_double("Veuillez saisir la valeur du rayon du cercle : ");
        double surface = rayon * rayon * Math.PI;
        double circonference = rayon * 2 * Math.PI;
        System.out.println("La surface du cercle est de : " + surface);
        System.out.println("La circonférence d'un cercle est de : " + circonference);
    }
}
