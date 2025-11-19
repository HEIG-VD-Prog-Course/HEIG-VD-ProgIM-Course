/**
 * Exemple de parcours et recherche dans des tableaux 2D.
 * 
 * Cet exemple montre différentes stratégies pour parcourir et rechercher
 * dans des matrices (tableaux bidimensionnels).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exemple : Parcours de tableaux 2D ===\n");

        // Matrice pour les démonstrations
        int[][] matrix = {
                { 12, 45, 23, 78, 56 },
                { 34, 89, 12, 67, 90 },
                { 56, 23, 45, 12, 34 },
                { 78, 12, 67, 89, 23 }
        };

        System.out.println("=== Matrice ===\n");
        displayMatrix(matrix);

        // Recherche simple d'une valeur
        System.out.println("\n--- Recherche d'une valeur ---\n");
        int target = 67;
        if (searchValue(matrix, target)) {
            System.out.println("Valeur " + target + " trouvée dans la matrice");
            int[] position = findPosition(matrix, target);
            System.out.println("Position : [" + position[0] + "][" + position[1] + "]");
        }

        // Compter les occurrences
        System.out.println("\n--- Occurrences ---\n");
        int value = 12;
        int count = countOccurrences(matrix, value);
        System.out.println("Le nombre " + value + " apparaît " + count + " fois");

        // Trouver le maximum
        System.out.println("\n--- Recherche du maximum ---\n");
        int max = findMax(matrix);
        System.out.println("Valeur maximale : " + max);
        int[] maxPos = findPosition(matrix, max);
        System.out.println("Position : [" + maxPos[0] + "][" + maxPos[1] + "]");

        // Trouver le minimum
        System.out.println("\n--- Recherche du minimum ---\n");
        int min = findMin(matrix);
        System.out.println("Valeur minimale : " + min);

        // Recherche dans une ligne spécifique
        System.out.println("\n--- Recherche dans une ligne ---\n");
        int row = 2;
        int rowTarget = 45;
        if (searchInRow(matrix, row, rowTarget)) {
            System.out.println("Valeur " + rowTarget + " trouvée dans la ligne " + row);
        }

        // Recherche dans une colonne spécifique
        System.out.println("\n--- Recherche dans une colonne ---\n");
        int col = 3;
        int colTarget = 89;
        if (searchInColumn(matrix, col, colTarget)) {
            System.out.println("Valeur " + colTarget + " trouvée dans la colonne " + col);
        }

        // Somme de tous les éléments
        System.out.println("\n--- Statistiques ---\n");
        int sum = calculateSum(matrix);
        double average = (double) sum / (matrix.length * matrix[0].length);
        System.out.println("Somme totale : " + sum);
        System.out.printf("Moyenne : %.2f%n", average);

        System.out.println("\n=== Fin de l'exemple ===");
    }

    /**
     * Affiche une matrice de manière formatée.
     * 
     * @param matrix la matrice à afficher
     */
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Recherche une valeur dans la matrice.
     * 
     * @param matrix la matrice
     * @param target la valeur à rechercher
     * @return true si la valeur est trouvée
     */
    public static boolean searchValue(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Trouve la position d'une valeur dans la matrice.
     * 
     * @param matrix la matrice
     * @param target la valeur à rechercher
     * @return un tableau [ligne, colonne] ou null si non trouvé
     */
    public static int[] findPosition(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /**
     * Compte le nombre d'occurrences d'une valeur.
     * 
     * @param matrix la matrice
     * @param value  la valeur à compter
     * @return le nombre d'occurrences
     */
    public static int countOccurrences(int[][] matrix, int value) {
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == value) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Trouve la valeur maximale dans la matrice.
     * 
     * @param matrix la matrice
     * @return la valeur maximale
     */
    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    /**
     * Trouve la valeur minimale dans la matrice.
     * 
     * @param matrix la matrice
     * @return la valeur minimale
     */
    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        return min;
    }

    /**
     * Recherche dans une ligne spécifique.
     * 
     * @param matrix la matrice
     * @param row    l'index de la ligne
     * @param target la valeur à rechercher
     * @return true si trouvé
     */
    public static boolean searchInRow(int[][] matrix, int row, int target) {
        if (row < 0 || row >= matrix.length) {
            return false;
        }

        for (int j = 0; j < matrix[row].length; j++) {
            if (matrix[row][j] == target) {
                return true;
            }
        }

        return false;
    }

    /**
     * Recherche dans une colonne spécifique.
     * 
     * @param matrix la matrice
     * @param col    l'index de la colonne
     * @param target la valeur à rechercher
     * @return true si trouvé
     */
    public static boolean searchInColumn(int[][] matrix, int col, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (col >= 0 && col < matrix[i].length) {
                if (matrix[i][col] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Calcule la somme de tous les éléments.
     * 
     * @param matrix la matrice
     * @return la somme totale
     */
    public static int calculateSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
}
