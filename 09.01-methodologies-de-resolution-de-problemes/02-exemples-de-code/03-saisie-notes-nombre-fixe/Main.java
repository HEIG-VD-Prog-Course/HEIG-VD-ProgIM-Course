import java.util.Scanner;

/**
 * Programme de gestion de notes - Étape 3
 * 
 * Version avec saisie interactive des notes (nombre fixe).
 * Cette version introduit :
 * - La classe Scanner pour lire les entrées utilisatrice
 * - La validation des données saisies
 * - L'interaction avec l'utilisatrice
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Programme de gestion de notes - Étape 3 ===\n");

        // Création du Scanner pour lire les entrées
        Scanner scanner = new Scanner(System.in);

        // Nombre de notes à saisir (fixe)
        final int NOMBRE_NOTES = 5;
        double[] notes = new double[NOMBRE_NOTES];

        System.out.println("--- Saisie des notes ---");
        // Saisie des notes
        for (int i = 0; i < NOMBRE_NOTES; i++) {
            boolean valid = false;

            while (!valid) {
                System.out.print("Entrez la note " + (i + 1) + " (entre 1.0 et 6.0) : ");

                // Vérification que l'entrée est bien un nombre
                if (scanner.hasNextDouble()) {
                    double grade = scanner.nextDouble();

                    // Validation de la note
                    if (grade >= 1.0 && grade <= 6.0) {
                        notes[i] = grade;
                        valid = true;
                    } else {
                        System.out.println("Erreur : la note doit être entre 1.0 et 6.0");
                    }
                } else {
                    System.out.println("Erreur : veuillez entrer un nombre valide");
                    scanner.next(); // Consommer l'entrée invalide
                }
            }
        }

        System.out.println("\n--- Affichage des notes saisies ---");
        // Affichage des notes
        for (int i = 0; i < notes.length; i++) {
            System.out.println("Note " + (i + 1) + " : " + notes[i]);
        }

        System.out.println("\n--- Calcul du minimum ---");
        // Calcul du minimum
        double min = notes[0];
        for (int i = 1; i < notes.length; i++) {
            if (notes[i] < min) {
                min = notes[i];
            }
        }
        System.out.println("Note minimale : " + min);

        System.out.println("\n--- Calcul du maximum ---");
        // Calcul du maximum
        double max = notes[0];
        for (int i = 1; i < notes.length; i++) {
            if (notes[i] > max) {
                max = notes[i];
            }
        }
        System.out.println("Note maximale : " + max);

        System.out.println("\n--- Calcul de la moyenne ---");
        // Calcul de la moyenne
        double sum = 0;
        for (double note : notes) {
            sum += note;
        }
        double average = sum / notes.length;
        System.out.println("Moyenne : " + average);

        System.out.println("\n=== Résumé des statistiques ===");
        System.out.println("Minimum : " + min);
        System.out.println("Maximum : " + max);
        System.out.println("Moyenne : " + average);

        // Fermeture du Scanner
        scanner.close();
    }
}
