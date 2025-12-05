/**
 * Programme de gestion de notes - Étape 1
 * 
 * Version initiale avec variables individuelles et calculs dans main.
 * Cette version montre la progression dans l'affichage des notes :
 * - Affichage individuel avec System.out.println pour chaque note
 * - Affichage avec boucle while
 * - Affichage avec boucle for
 * - Calcul du minimum, maximum et moyenne
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Programme de gestion de notes - Étape 1 ===\n");

        // Déclaration et initialisation de 5 notes
        double note1 = 4.5;
        double note2 = 5.0;
        double note3 = 3.8;
        double note4 = 4.2;
        double note5 = 5.3;

        System.out.println("--- Affichage individuel ---");
        // Affichage de chaque note individuellement
        System.out.println("Note 1 : " + note1);
        System.out.println("Note 2 : " + note2);
        System.out.println("Note 3 : " + note3);
        System.out.println("Note 4 : " + note4);
        System.out.println("Note 5 : " + note5);

        System.out.println("\n--- Affichage avec boucle while ---");
        // Affichage avec une boucle while
        int index = 1;
        while (index <= 5) {
            double current;

            // Sélection de la note en fonction de l'index
            if (index == 1) {
                current = note1;
            } else if (index == 2) {
                current = note2;
            } else if (index == 3) {
                current = note3;
            } else if (index == 4) {
                current = note4;
            } else {
                current = note5;
            }

            System.out.println("Note " + index + " : " + current);
            index++;
        }

        System.out.println("\n--- Affichage avec boucle for ---");
        // Affichage avec une boucle for
        for (int i = 1; i <= 5; i++) {
            double current;

            // Sélection de la note en fonction de i
            if (i == 1) {
                current = note1;
            } else if (i == 2) {
                current = note2;
            } else if (i == 3) {
                current = note3;
            } else if (i == 4) {
                current = note4;
            } else {
                current = note5;
            }

            System.out.println("Note " + i + " : " + current);
        }

        System.out.println("\n--- Calcul du minimum ---");
        // Calcul du minimum
        double min = note1;

        if (note2 < min) {
            min = note2;
        }
        if (note3 < min) {
            min = note3;
        }
        if (note4 < min) {
            min = note4;
        }
        if (note5 < min) {
            min = note5;
        }

        System.out.println("Note minimale : " + min);

        System.out.println("\n--- Calcul du maximum ---");
        // Calcul du maximum
        double max = note1;

        if (note2 > max) {
            max = note2;
        }
        if (note3 > max) {
            max = note3;
        }
        if (note4 > max) {
            max = note4;
        }
        if (note5 > max) {
            max = note5;
        }

        System.out.println("Note maximale : " + max);

        System.out.println("\n--- Calcul de la moyenne ---");
        // Calcul de la moyenne
        double sum = note1 + note2 + note3 + note4 + note5;
        double average = sum / 5;

        System.out.println("Moyenne : " + average);

        System.out.println("\n=== Résumé des statistiques ===");
        System.out.println("Minimum : " + min);
        System.out.println("Maximum : " + max);
        System.out.println("Moyenne : " + average);
    }
}
