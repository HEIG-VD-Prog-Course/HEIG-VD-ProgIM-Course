# Algorithmes de parcours - Exercices

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/09.01-algorithmes-de-parcours/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/09.01-algorithmes-de-parcours/01-supports-de-cours/09.01-algorithmes-de-parcours-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/)

## Exercice 1 : Recherche du premier élément pair

Écrivez une fonction qui trouve le **premier** nombre pair dans un tableau.

La fonction doit :

1. Parcourir le tableau de gauche à droite.
2. Retourner l'index du premier nombre pair trouvé.
3. Retourner -1 si aucun nombre pair n'existe.

Testez avec différents tableaux : `{1, 3, 5, 7, 9}`, `{1, 3, 4, 7, 9}`,
`{2, 3, 4}`.

<details>
<summary>Solution</summary>

```java
public class FirstEvenNumber {
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 3, 5, 7, 9},
            {1, 3, 4, 7, 9},
            {2, 3, 4}
        };

        for (int[] array : testCases) {
            System.out.print("Tableau : ");
            printArray(array);

            int index = findFirstEven(array);

            if (index != -1) {
                System.out.println("Premier nombre pair à l'index " + index +
                        " (valeur : " + array[index] + ")");
            } else {
                System.out.println("Aucun nombre pair trouvé");
            }
            System.out.println();
        }
    }

    /**
     * Trouve l'index du premier nombre pair dans un tableau.
     *
     * @param array le tableau à parcourir
     * @return l'index du premier nombre pair, ou -1 si aucun
     */
    public static int findFirstEven(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
```

</details>

## Exercice 2 : Recherche binaire récursive

Implémentez la recherche binaire de manière **récursive** (au lieu d'itérative).

La fonction doit :

1. Prendre en paramètres le tableau, la valeur à chercher, l'index de début et
   l'index de fin.
2. Retourner l'index de l'élément trouvé ou -1.
3. Utiliser l'approche récursive (la fonction s'appelle elle-même).

Testez avec un tableau trié : `{5, 10, 15, 20, 25, 30, 35, 40, 45, 50}`.

<details>
<summary>Solution</summary>

```java
public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};

        System.out.println("Tableau trié : ");
        printArray(sortedArray);
        System.out.println();

        int[] toFind = {25, 5, 50, 17, 100};

        for (int target : toFind) {
            int index = binarySearchRecursive(sortedArray, target, 0, sortedArray.length - 1);

            if (index != -1) {
                System.out.println("Élément " + target + " trouvé à l'index " + index);
            } else {
                System.out.println("Élément " + target + " non trouvé");
            }
        }
    }

    /**
     * Recherche binaire récursive.
     *
     * @param array le tableau trié
     * @param target la valeur à chercher
     * @param left l'index de début de la zone de recherche
     * @param right l'index de fin de la zone de recherche
     * @return l'index de l'élément trouvé, ou -1
     */
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        // Cas de base : zone de recherche vide
        if (left > right) {
            return -1;
        }

        // Calculer l'index du milieu
        int middle = left + (right - left) / 2;

        // Cas de base : élément trouvé
        if (array[middle] == target) {
            return middle;
        }

        // Appel récursif sur la moitié appropriée
        if (array[middle] < target) {
            // Chercher dans la moitié droite
            return binarySearchRecursive(array, target, middle + 1, right);
        } else {
            // Chercher dans la moitié gauche
            return binarySearchRecursive(array, target, left, middle - 1);
        }
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
```

</details>

## Exercice 3 : Recherche de tous les éléments

Écrivez une fonction qui trouve **toutes les occurrences** d'une valeur dans un
tableau.

La fonction doit :

1. Retourner un `ArrayList<Integer>` contenant tous les index où la valeur
   apparaît.
2. Retourner une liste vide si la valeur n'est pas trouvée.

Testez avec : `{5, 2, 8, 2, 9, 2, 3}` et cherchez toutes les occurrences de `2`.

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;

public class FindAllOccurrences {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 2, 9, 2, 3};
        int target = 2;

        System.out.print("Tableau : ");
        printArray(array);
        System.out.println("\nRecherche de toutes les occurrences de " + target + "\n");

        ArrayList<Integer> indices = findAllOccurrences(array, target);

        if (indices.isEmpty()) {
            System.out.println("Aucune occurrence trouvée");
        } else {
            System.out.println("Trouvé " + indices.size() + " occurrence(s) aux index :");
            for (int index : indices) {
                System.out.println("  - Index " + index + " (valeur : " + array[index] + ")");
            }
        }

        // Test avec une valeur absente
        System.out.println("\nRecherche de 10 :");
        ArrayList<Integer> notFound = findAllOccurrences(array, 10);
        System.out.println("Nombre d'occurrences : " + notFound.size());
    }

    /**
     * Trouve tous les index où une valeur apparaît dans un tableau.
     *
     * @param array le tableau à parcourir
     * @param target la valeur à chercher
     * @return une liste d'index
     */
    public static ArrayList<Integer> findAllOccurrences(int[] array, int target) {
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
```

</details>

## Exercice 4 : Recherche d'un étudiant

Créez une classe `Student` avec les attributs `name` (String) et `id` (int).

Écrivez un programme qui :

1. Crée une `ArrayList<Student>` avec plusieurs étudiants.
2. Implémente une fonction `findStudentById` qui recherche un étudiant par son
   ID.
3. Implémente une fonction `findStudentsByName` qui retourne tous les étudiants
   ayant un nom contenant une chaîne donnée (recherche partielle, insensible à
   la casse).

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Student[id=%d, name=%s]", id, name);
    }
}

public class StudentSearch {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Amal Cohen", 1001));
        students.add(new Student("Amal Santos", 1002));
        students.add(new Student("Marin Cohen", 1003));
        students.add(new Student("Jin Nguyen", 1004));
        students.add(new Student("Tanu Ali", 1005));

        System.out.println("=== Liste des étudiants ===\n");
        for (Student student : students) {
            System.out.println(student);
        }

        // Recherche par ID
        System.out.println("\n--- Recherche par ID ---\n");
        int searchId = 1003;
        Student found = findStudentById(students, searchId);

        if (found != null) {
            System.out.println("Étudiant trouvé : " + found);
        } else {
            System.out.println("Aucun étudiant avec l'ID " + searchId);
        }

        // Recherche par nom (partiel)
        System.out.println("\n--- Recherche par nom ---\n");
        String searchName = "martin";
        ArrayList<Student> matches = findStudentsByName(students, searchName);

        System.out.println("Étudiants dont le nom contient '" + searchName + "' :");
        if (matches.isEmpty()) {
            System.out.println("Aucun résultat");
        } else {
            for (Student student : matches) {
                System.out.println("  - " + student);
            }
        }
    }

    /**
     * Recherche un étudiant par son ID.
     *
     * @param students la liste d'étudiants
     * @param id l'ID à rechercher
     * @return l'étudiant trouvé, ou null
     */
    public static Student findStudentById(ArrayList<Student> students, int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    /**
     * Recherche tous les étudiants dont le nom contient une chaîne donnée.
     *
     * @param students la liste d'étudiants
     * @param namePattern la chaîne à chercher (insensible à la casse)
     * @return une liste d'étudiants correspondants
     */
    public static ArrayList<Student> findStudentsByName(
            ArrayList<Student> students, String namePattern) {

        ArrayList<Student> results = new ArrayList<>();
        String lowerPattern = namePattern.toLowerCase();

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(lowerPattern)) {
                results.add(student);
            }
        }

        return results;
    }
}
```

</details>

## Exercice 5 : Recherche dans une grille

Créez une grille (matrice) 5×5 remplie de nombres aléatoires entre 1 et 100.

Écrivez un programme qui :

1. Affiche la grille de manière formatée.
2. Trouve et affiche toutes les positions où un nombre donné apparaît.
3. Trouve la ligne contenant la somme la plus élevée.
4. Trouve la colonne contenant le plus grand nombre.

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;
import java.util.Random;

public class GridSearch {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;
        int[][] grid = createRandomGrid(rows, cols);

        System.out.println("=== Grille générée ===\n");
        displayGrid(grid);

        // Recherche de toutes les positions d'une valeur
        System.out.println("\n--- Recherche d'une valeur ---\n");
        int target = grid[2][3]; // Prendre une valeur qui existe
        System.out.println("Recherche de la valeur : " + target + "\n");

        ArrayList<int[]> positions = findAllPositions(grid, target);
        System.out.println("Trouvé " + positions.size() + " occurrence(s) :");
        for (int[] pos : positions) {
            System.out.println("  Position [" + pos[0] + "][" + pos[1] + "]");
        }

        // Ligne avec la somme la plus élevée
        System.out.println("\n--- Ligne avec la somme maximale ---\n");
        int maxRow = findRowWithMaxSum(grid);
        int maxSum = calculateRowSum(grid, maxRow);
        System.out.println("Ligne " + maxRow + " avec une somme de " + maxSum);

        // Colonne avec le plus grand nombre
        System.out.println("\n--- Colonne avec le plus grand nombre ---\n");
        int[] maxInfo = findColumnWithMaxValue(grid);
        System.out.println("Colonne " + maxInfo[0] + " contient le maximum : " +
                maxInfo[1] + " à la ligne " + maxInfo[2]);
    }

    /**
     * Crée une grille avec des nombres aléatoires.
     *
     * @param rows nombre de lignes
     * @param cols nombre de colonnes
     * @return la grille générée
     */
    public static int[][] createRandomGrid(int rows, int cols) {
        int[][] grid = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = random.nextInt(100) + 1;
            }
        }

        return grid;
    }

    /**
     * Affiche une grille de manière formatée.
     *
     * @param grid la grille à afficher
     */
    public static void displayGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(String.format("%4d ", grid[i][j]));
            }
            System.out.println();
        }
    }

    /**
     * Trouve toutes les positions d'une valeur dans la grille.
     *
     * @param grid la grille
     * @param target la valeur à chercher
     * @return une liste de positions [ligne, colonne]
     */
    public static ArrayList<int[]> findAllPositions(int[][] grid, int target) {
        ArrayList<int[]> positions = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == target) {
                    positions.add(new int[]{i, j});
                }
            }
        }

        return positions;
    }

    /**
     * Trouve la ligne avec la somme la plus élevée.
     *
     * @param grid la grille
     * @return l'index de la ligne
     */
    public static int findRowWithMaxSum(int[][] grid) {
        int maxRow = 0;
        int maxSum = calculateRowSum(grid, 0);

        for (int i = 1; i < grid.length; i++) {
            int sum = calculateRowSum(grid, i);
            if (sum > maxSum) {
                maxSum = sum;
                maxRow = i;
            }
        }

        return maxRow;
    }

    /**
     * Calcule la somme d'une ligne.
     *
     * @param grid la grille
     * @param row l'index de la ligne
     * @return la somme
     */
    public static int calculateRowSum(int[][] grid, int row) {
        int sum = 0;
        for (int j = 0; j < grid[row].length; j++) {
            sum += grid[row][j];
        }
        return sum;
    }

    /**
     * Trouve la colonne contenant le plus grand nombre.
     *
     * @param grid la grille
     * @return un tableau [colonne, valeur maximale, ligne de cette valeur]
     */
    public static int[] findColumnWithMaxValue(int[][] grid) {
        int maxCol = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxRow = 0;

        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] > maxValue) {
                    maxValue = grid[i][j];
                    maxCol = j;
                    maxRow = i;
                }
            }
        }

        return new int[]{maxCol, maxValue, maxRow};
    }
}
```

</details>

## Exercice 6 : Comparaison de performances

Créez un programme qui compare les performances de la recherche linéaire et de
la recherche binaire.

Le programme doit :

1. Créer un grand tableau trié de 100'000 éléments.
2. Effectuer 1'000 recherches aléatoires avec chaque algorithme.
3. Mesurer et afficher le temps d'exécution de chaque méthode.
4. Calculer le rapport de vitesse entre les deux algorithmes.

**Indice** : Utilisez `System.nanoTime()` pour mesurer le temps.

<details>
<summary>Solution</summary>

```java
import java.util.Arrays;
import java.util.Random;

public class PerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== Comparaison de performances ===\n");

        int arraySize = 100000;
        int searchCount = 1000;

        // Créer un grand tableau trié
        int[] sortedArray = createSortedArray(arraySize);
        System.out.println("Tableau créé : " + arraySize + " éléments");
        System.out.println("Nombre de recherches : " + searchCount);

        // Générer des valeurs aléatoires à chercher
        int[] targets = generateRandomTargets(searchCount, arraySize);

        // Test de la recherche linéaire
        System.out.println("\n--- Recherche linéaire ---");
        long linearStart = System.nanoTime();

        for (int target : targets) {
            linearSearch(sortedArray, target);
        }

        long linearEnd = System.nanoTime();
        long linearTime = linearEnd - linearStart;

        System.out.println("Temps total : " + (linearTime / 1_000_000) + " ms");
        System.out.println("Temps moyen par recherche : " + (linearTime / searchCount / 1000) + " µs");

        // Test de la recherche binaire
        System.out.println("\n--- Recherche binaire ---");
        long binaryStart = System.nanoTime();

        for (int target : targets) {
            binarySearch(sortedArray, target);
        }

        long binaryEnd = System.nanoTime();
        long binaryTime = binaryEnd - binaryStart;

        System.out.println("Temps total : " + (binaryTime / 1_000_000) + " ms");
        System.out.println("Temps moyen par recherche : " + (binaryTime / searchCount / 1000) + " µs");

        // Comparaison
        System.out.println("\n--- Résultat ---");
        double speedup = (double) linearTime / binaryTime;
        System.out.println("La recherche binaire est " + speedup + "x plus rapide");

        // Test avec Arrays.binarySearch (méthode native)
        System.out.println("\n--- Arrays.binarySearch() (méthode Java native) ---");
        long nativeStart = System.nanoTime();

        for (int target : targets) {
            Arrays.binarySearch(sortedArray, target);
        }

        long nativeEnd = System.nanoTime();
        long nativeTime = nativeEnd - nativeStart;

        System.out.println("Temps total : " + (nativeTime / 1_000_000) + " ms");
        double nativeSpeedup = (double) binaryTime / nativeTime;
        System.out.println("La méthode native est " + nativeSpeedup +
                "x plus rapide que notre implémentation");
    }

    /**
     * Crée un tableau trié de taille donnée.
     */
    public static int[] createSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    /**
     * Génère des valeurs aléatoires à rechercher.
     */
    public static int[] generateRandomTargets(int count, int maxValue) {
        int[] targets = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            targets[i] = random.nextInt(maxValue) + 1;
        }

        return targets;
    }

    /**
     * Recherche linéaire.
     */
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Recherche binaire.
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            }

            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
```

</details>

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
