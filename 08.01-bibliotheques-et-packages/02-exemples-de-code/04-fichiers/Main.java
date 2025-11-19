import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Exemple d'utilisation de java.io pour lire et écrire des fichiers.
 * 
 * Cet exemple montre comment :
 * - Écrire des données dans un fichier texte
 * - Lire des données depuis un fichier texte
 * - Gérer les exceptions avec try-with-resources
 * 
 * Documentation :
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/package-summary.html
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exemple : Fichiers ===\n");

        String filename = "notes.txt";

        // Écriture dans un fichier
        writeGradesToFile(filename);

        // Lecture depuis un fichier
        ArrayList<String> grades = readGradesFromFile(filename);

        // Affichage et calcul de statistiques
        displayStatistics(grades);

        System.out.println("\n=== Fin de l'exemple ===");
    }

    /**
     * Écrit des notes d'étudiants dans un fichier.
     * 
     * Utilise BufferedWriter avec try-with-resources pour garantir
     * la fermeture automatique du fichier.
     * 
     * @param filename le nom du fichier à créer
     */
    private static void writeGradesToFile(String filename) {
        System.out.println("Écriture des notes dans " + filename + "...");

        // try-with-resources : fermeture automatique du fichier
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Alice;5.5\n");
            writer.write("Bob;4.8\n");
            writer.write("Charlie;5.2\n");
            writer.write("Diana;4.5\n");
            writer.write("Eva;5.8\n");
            writer.write("Frank;4.9\n");
            writer.write("Grace;5.3\n");

            System.out.println("Notes écrites avec succès !");

        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture : " + e.getMessage());
        }
    }

    /**
     * Lit des notes depuis un fichier et les retourne dans une liste.
     * 
     * @param filename le nom du fichier à lire
     * @return une liste contenant chaque ligne du fichier
     */
    private static ArrayList<String> readGradesFromFile(String filename) {
        System.out.println("\nLecture des notes depuis " + filename + "...");
        ArrayList<String> grades = new ArrayList<>();

        // try-with-resources : fermeture automatique du fichier
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Lecture ligne par ligne jusqu'à la fin du fichier
            while ((line = reader.readLine()) != null) {
                grades.add(line);
            }

            System.out.println(grades.size() + " lignes lues avec succès !");

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture : " + e.getMessage());
        }

        return grades;
    }

    /**
     * Affiche les notes et calcule des statistiques.
     * 
     * @param grades la liste des lignes contenant les notes
     */
    private static void displayStatistics(ArrayList<String> grades) {
        System.out.println("\n--- Notes des étudiants ---");

        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int count = 0;

        for (String line : grades) {
            // Séparation du nom et de la note
            String[] parts = line.split(";");

            if (parts.length == 2) {
                String name = parts[0];
                double grade = Double.parseDouble(parts[1]);

                System.out.println(String.format("%-10s : %.1f", name, grade));

                // Calculs statistiques
                sum += grade;
                count++;

                if (grade < min) {
                    min = grade;
                }
                if (grade > max) {
                    max = grade;
                }
            }
        }

        // Affichage des statistiques
        if (count > 0) {
            double average = sum / count;
            System.out.println("\n--- Statistiques ---");
            System.out.println("Nombre d'étudiants : " + count);
            System.out.println("Moyenne : " + average);
            System.out.println("Note minimale : " + min);
            System.out.println("Note maximale : " + max);
        }
    }
}
