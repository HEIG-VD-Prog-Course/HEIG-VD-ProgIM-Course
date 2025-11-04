import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Exemple d'utilisation de collections avancées en Java.
 * 
 * Cet exemple montre comment utiliser HashMap, Random, et la classe
 * Collections pour manipuler des données.
 * 
 * Documentation : https://docs.oracle.com/en/java/javase/17/docs/api/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exemple : Collections avancées ===\n");

        // Utilisation de HashMap pour stocker des notes d'étudiants
        HashMap<String, Double> grades = new HashMap<>();
        grades.put("Alice", 5.5);
        grades.put("Bob", 4.8);
        grades.put("Charlie", 5.2);
        grades.put("Diana", 4.5);
        grades.put("Eva", 5.8);

        System.out.println("Notes des étudiants :");
        for (String name : grades.keySet()) {
            System.out.printf("- %s : %.1f%n", name, grades.get(name));
        }

        // Calcul de la moyenne
        double sum = 0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        double average = sum / grades.size();
        System.out.printf("%nMoyenne de la classe : %.2f%n", average);

        // Utilisation de Random pour simuler des lancers de dés
        Random random = new Random();
        System.out.println("\nSimulation de 5 lancers de dés :");

        ArrayList<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int roll = random.nextInt(6) + 1; // 1 à 6
            rolls.add(roll);
            System.out.println("Lancer " + (i + 1) + " : " + roll);
        }

        // Utilisation de Collections pour trier et mélanger
        System.out.println("\nRésultats triés : " + rolls);
        Collections.sort(rolls);
        System.out.println("Après tri croissant : " + rolls);

        Collections.sort(rolls, Collections.reverseOrder());
        System.out.println("Après tri décroissant : " + rolls);

        // Mélanger une liste
        ArrayList<String> participants = new ArrayList<>();
        participants.add("Alice");
        participants.add("Bob");
        participants.add("Charlie");
        participants.add("Diana");
        participants.add("Eva");

        System.out.println("\nOrdre original : " + participants);
        Collections.shuffle(participants);
        System.out.println("Ordre mélangé : " + participants);

        // Recherche dans une collection triée
        ArrayList<Integer> sortedNumbers = new ArrayList<>();
        for (int i = 2; i <= 20; i += 2) {
            sortedNumbers.add(i);
        }

        System.out.println("\nNombres pairs : " + sortedNumbers);
        int searchValue = 12;
        int index = Collections.binarySearch(sortedNumbers, searchValue);
        System.out.println("Position de " + searchValue + " : " + index);

        System.out.println("\n=== Fin de l'exemple ===");
    }
}
