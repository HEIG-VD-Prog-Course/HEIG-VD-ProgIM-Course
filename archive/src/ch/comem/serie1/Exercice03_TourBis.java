package ch.comem.serie1;

/*
   Reprenez le programme précédent et ajoutez 1 au nombre de tours (sans écrire 4! ;-)
   L'exécution du programme devrait afficher ceci :
       Le temps effectué pour les 4 tours et de 6.0 minutes.
 */
public class Exercice03_TourBis {

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
        int nombreDeTours = 3;
        nombreDeTours++;
        double tempsEnMinParTour = 1.5;
        double tempsTotalEnMin = nombreDeTours * tempsEnMinParTour;
        System.out.println("Le temps effectué pour les "
                + nombreDeTours + " tours est de " + tempsTotalEnMin + " minutes.");
        
    }

}
