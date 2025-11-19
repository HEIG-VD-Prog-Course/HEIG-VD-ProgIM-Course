# Algorithmes de tri - Supports de cours

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/10.01-algorithmes-de-tri/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/10.01-algorithmes-de-tri/01-supports-de-cours/10.01-algorithmes-de-tri-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/)
- Exercices : [Lien vers le contenu](../03-exercices/README.md)

## Introduction

Le tri est l'une des opérations les plus fondamentales en informatique. Trier
des données permet de les organiser, de les rechercher plus efficacement, et de
les présenter de manière compréhensible.

Dans ce module, nous explorerons différents algorithmes de tri, de plus simples
aux plus sophistiqués, en analysant leurs avantages, inconvénients, et
performances.

## Pourquoi trier ?

Le tri est essentiel pour de nombreuses raisons :

- **Recherche efficace** : La recherche binaire nécessite des données triées.
- **Organisation** : Afficher des données dans un ordre logique.
- **Élimination de doublons** : Plus facile sur des données triées.
- **Fusion de données** : Combiner plusieurs sources triées.
- **Optimisation** : De nombreux algorithmes sont plus efficaces sur des données
  triées.

**Exemples quotidiens** :

- Classer des emails par date.
- Trier des contacts par nom.
- Organiser des produits par prix.
- Ranger des fichiers alphabétiquement.

## Tri à bulles (Bubble Sort)

### Principe

Le tri à bulles est l'algorithme de tri le plus simple. Il compare des paires
d'éléments adjacents et les échange s'ils sont dans le mauvais ordre. Ce
processus est répété jusqu'à ce que le tableau soit trié.

**Analogie** : Comme des bulles d'air qui remontent à la surface, les plus
grandes valeurs "remontent" vers la fin du tableau.

### Fonctionnement

1. Comparer chaque paire d'éléments adjacents.
2. Échanger les éléments s'ils sont dans le mauvais ordre.
3. Répéter le processus pour tout le tableau.
4. Continuer jusqu'à ce qu'aucun échange ne soit nécessaire.

### Exemple en Java

```java
public static void bubbleSort(int[] array) {
    int n = array.length;

    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;

        for (int j = 0; j < n - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                // Échanger les éléments
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
            }
        }

        // Si aucun échange, le tableau est trié
        if (!swapped) {
            break;
        }
    }
}
```

### Complexité

- **Meilleur cas** : O(n) - tableau déjà trié avec optimisation
- **Cas moyen** : O(n²)
- **Pire cas** : O(n²) - tableau trié en ordre inverse
- **Espace** : O(1) - tri en place

### Avantages et inconvénients

**Avantages** :

- Très simple à comprendre et implémenter.
- Tri stable (préserve l'ordre relatif des éléments égaux).
- Tri en place (pas de mémoire supplémentaire).

**Inconvénients** :

- Très lent pour de grandes collections.
- Inefficace même pour des données partiellement triées.

## Tri par sélection (Selection Sort)

### Principe

Le tri par sélection trouve le plus petit élément du tableau non trié et le
place au début. Il répète ce processus pour le reste du tableau.

**Analogie** : Comme trier des cartes en sélectionnant toujours la plus petite
carte restante.

### Fonctionnement

1. Trouver le minimum dans le tableau non trié.
2. L'échanger avec le premier élément non trié.
3. Avancer la frontière entre la partie triée et non triée.
4. Répéter jusqu'à ce que tout soit trié.

### Exemple en Java

```java
public static void selectionSort(int[] array) {
    int n = array.length;

    for (int i = 0; i < n - 1; i++) {
        // Trouver le minimum dans la partie non triée
        int minIndex = i;

        for (int j = i + 1; j < n; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }

        // Échanger avec le premier élément non trié
        int temp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = temp;
    }
}
```

### Complexité

- **Tous les cas** : O(n²)
- **Espace** : O(1) - tri en place

### Avantages et inconvénients

**Avantages** :

- Simple à comprendre et implémenter.
- Nombre minimal d'échanges (n-1 au maximum).
- Tri en place.

**Inconvénients** :

- Toujours O(n²), même si le tableau est déjà trié.
- Non stable (peut changer l'ordre relatif d'éléments égaux).

## Tri par insertion (Insertion Sort)

### Principe

Le tri par insertion construit le tableau trié un élément à la fois. Il prend
chaque élément et l'insère à sa position correcte dans la partie déjà triée.

**Analogie** : Comme trier des cartes à jouer dans votre main en insérant chaque
nouvelle carte à sa place.

### Fonctionnement

1. Commencer avec le deuxième élément.
2. Comparer avec les éléments précédents.
3. Décaler les éléments plus grands vers la droite.
4. Insérer l'élément à sa position correcte.
5. Répéter pour tous les éléments.

### Exemple en Java

```java
public static void insertionSort(int[] array) {
    int n = array.length;

    for (int i = 1; i < n; i++) {
        int key = array[i];
        int j = i - 1;

        // Décaler les éléments plus grands vers la droite
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j--;
        }

        // Insérer l'élément à sa position
        array[j + 1] = key;
    }
}
```

### Complexité

- **Meilleur cas** : O(n) - tableau déjà trié
- **Cas moyen** : O(n²)
- **Pire cas** : O(n²) - tableau trié en ordre inverse
- **Espace** : O(1) - tri en place

### Avantages et inconvénients

**Avantages** :

- Simple et intuitif.
- Très efficace pour de petites collections.
- Excellent pour des données presque triées.
- Tri stable et en place.
- Tri adaptatif (plus rapide si partiellement trié).

**Inconvénients** :

- Lent pour de grandes collections.

## Tri fusion (Merge Sort)

### Principe

Le tri fusion utilise la stratégie "diviser pour régner". Il divise
récursivement le tableau en deux moitiés, trie chaque moitié, puis fusionne les
résultats.

### Fonctionnement

1. Diviser le tableau en deux moitiés.
2. Trier récursivement chaque moitié.
3. Fusionner les deux moitiés triées.

### Exemple en Java

```java
public static void mergeSort(int[] array, int left, int right) {
    if (left < right) {
        int middle = left + (right - left) / 2;

        // Trier les deux moitiés
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);

        // Fusionner les moitiés triées
        merge(array, left, middle, right);
    }
}

private static void merge(int[] array, int left, int middle, int right) {
    // Tailles des sous-tableaux
    int n1 = middle - left + 1;
    int n2 = right - middle;

    // Tableaux temporaires
    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    // Copier les données
    for (int i = 0; i < n1; i++) {
        leftArray[i] = array[left + i];
    }
    for (int j = 0; j < n2; j++) {
        rightArray[j] = array[middle + 1 + j];
    }

    // Fusionner les tableaux
    int i = 0, j = 0, k = left;

    while (i < n1 && j < n2) {
        if (leftArray[i] <= rightArray[j]) {
            array[k] = leftArray[i];
            i++;
        } else {
            array[k] = rightArray[j];
            j++;
        }
        k++;
    }

    // Copier les éléments restants
    while (i < n1) {
        array[k] = leftArray[i];
        i++;
        k++;
    }

    while (j < n2) {
        array[k] = rightArray[j];
        j++;
        k++;
    }
}
```

### Complexité

- **Tous les cas** : O(n log n)
- **Espace** : O(n) - nécessite de la mémoire temporaire

### Avantages et inconvénients

**Avantages** :

- Performances garanties en O(n log n).
- Tri stable.
- Prévisible et fiable.
- Excellent pour trier des listes chaînées.

**Inconvénients** :

- Nécessite de la mémoire supplémentaire.
- Plus lent que le tri rapide en pratique pour les tableaux.

## Tri rapide (Quick Sort)

### Principe

Le tri rapide choisit un élément "pivot", partitionne le tableau autour du
pivot, puis trie récursivement les sous-tableaux.

### Fonctionnement

1. Choisir un pivot.
2. Partitionner : éléments < pivot à gauche, éléments > pivot à droite.
3. Trier récursivement les deux partitions.

### Exemple en Java

```java
public static void quickSort(int[] array, int low, int high) {
    if (low < high) {
        // Partitionner et obtenir l'index du pivot
        int pivotIndex = partition(array, low, high);

        // Trier récursivement les sous-tableaux
        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);
    }
}

private static int partition(int[] array, int low, int high) {
    int pivot = array[high]; // Choisir le dernier élément comme pivot
    int i = low - 1; // Index du plus petit élément

    for (int j = low; j < high; j++) {
        if (array[j] <= pivot) {
            i++;

            // Échanger array[i] et array[j]
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Placer le pivot à sa position finale
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    return i + 1;
}
```

### Complexité

- **Meilleur cas** : O(n log n)
- **Cas moyen** : O(n log n)
- **Pire cas** : O(n²) - pivot mal choisi (tableau déjà trié)
- **Espace** : O(log n) - pile de récursion

### Avantages et inconvénients

**Avantages** :

- Très rapide en pratique.
- Tri en place (peu de mémoire supplémentaire).
- Cache-friendly.

**Inconvénients** :

- Pas stable.
- Pire cas en O(n²) (rare avec un bon choix de pivot).
- Performances variables selon le pivot.

## Méthodes de tri en Java

Java fournit des méthodes de tri intégrées optimisées :

### Arrays.sort()

```java
int[] numbers = {5, 2, 8, 1, 9};
Arrays.sort(numbers);
// Résultat : {1, 2, 5, 8, 9}

// Tri d'une portion du tableau
Arrays.sort(numbers, 0, 3); // Trie les 3 premiers éléments
```

**Algorithme utilisé** : Dual-Pivot Quicksort (variante optimisée du tri
rapide).

### Collections.sort()

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(5);
list.add(2);
list.add(8);

Collections.sort(list);
// Résultat : [2, 5, 8]
```

**Algorithme utilisé** : Timsort (hybride entre tri fusion et tri par
insertion).

### Tri d'objets avec Comparator

```java
class Student {
    String name;
    int age;
}

ArrayList<Student> students = new ArrayList<>();
// ... ajouter des étudiants

// Trier par âge
Collections.sort(students, new Comparator<Student>() {
    public int compare(Student s1, Student s2) {
        return s1.age - s2.age;
    }
});

// Ou avec une lambda expression (Java 8+)
Collections.sort(students, (s1, s2) -> s1.age - s2.age);

// Ou encore plus simple
students.sort(Comparator.comparingInt(s -> s.age));
```

## Comparaison des algorithmes

| Algorithme        | Meilleur cas | Cas moyen  | Pire cas   | Espace   | Stable |
| ----------------- | ------------ | ---------- | ---------- | -------- | ------ |
| Tri à bulles      | O(n)         | O(n²)      | O(n²)      | O(1)     | Oui    |
| Tri par sélection | O(n²)        | O(n²)      | O(n²)      | O(1)     | Non    |
| Tri par insertion | O(n)         | O(n²)      | O(n²)      | O(1)     | Oui    |
| Tri fusion        | O(n log n)   | O(n log n) | O(n log n) | O(n)     | Oui    |
| Tri rapide        | O(n log n)   | O(n log n) | O(n²)      | O(log n) | Non    |

## Stabilité d'un tri

Un tri est **stable** s'il préserve l'ordre relatif des éléments égaux.

**Exemple** : Trier des personnes par âge, puis par nom.

- Tri stable : Les personnes de même âge restent dans l'ordre alphabétique.
- Tri non stable : L'ordre alphabétique peut être modifié.

**Algorithmes stables** : Tri à bulles, tri par insertion, tri fusion.
**Algorithmes non stables** : Tri par sélection, tri rapide.

## Quand utiliser quel algorithme ?

### Tri à bulles

- Petites collections (< 10 éléments).
- Apprentissage et démonstration.
- Données presque triées.

### Tri par insertion

- Petites collections (< 50 éléments).
- Données presque triées.
- Tri en ligne (ajout progressif d'éléments).

### Tri fusion

- Stabilité requise.
- Données importantes.
- Performances prévisibles nécessaires.
- Tri de listes chaînées.

### Tri rapide

- Grandes collections.
- Performance maximale en pratique.
- Stabilité non requise.

### Arrays.sort() / Collections.sort()

- **Utilisation recommandée dans la plupart des cas** : Algorithmes optimisés et
  testés.

## Conclusion

Le choix de l'algorithme de tri dépend de plusieurs facteurs :

- La taille des données.
- L'ordre initial des données.
- Les contraintes de mémoire.
- La nécessité de stabilité.
- Les contraintes de performance.

Pour la plupart des applications, utilisez les méthodes de tri intégrées de Java
(`Arrays.sort()` ou `Collections.sort()`). Elles sont optimisées et choisissent
automatiquement le meilleur algorithme selon le contexte.

Cependant, comprendre comment fonctionnent les algorithmes de tri vous permet de
prendre des décisions éclairées et de résoudre des problèmes complexes.

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
