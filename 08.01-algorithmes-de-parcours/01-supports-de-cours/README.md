# Algorithmes de parcours - Supports de cours

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/08.01-algorithmes-de-parcours/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/08.01-algorithmes-de-parcours/01-supports-de-cours/08.01-algorithmes-de-parcours-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/)
- Exercices : [Lien vers le contenu](../03-exercices/README.md)

## Introduction

Les algorithmes de parcours sont essentiels en programmation. Ils permettent de
rechercher des éléments dans des collections de données. La capacité à choisir
et implémenter le bon algorithme de recherche est cruciale pour créer des
programmes efficaces.

Dans ce module, nous explorerons différentes stratégies de recherche, de la plus
simple à la plus optimisée, en analysant leurs performances et cas d'usage.

## Comprendre la complexité algorithmique

Avant de plonger dans les algorithmes de recherche, il est essentiel de
comprendre comment on mesure leur performance. En informatique, on utilise la
**notation grand O** (Big O notation) pour exprimer la complexité d'un
algorithme.

### Qu'est-ce que la complexité ?

La complexité d'un algorithme mesure **combien de temps** (ou d'opérations) il
va prendre en fonction de la **taille des données**.

Par exemple, si vous cherchez un livre dans une bibliothèque :

- Combien de livres devrez-vous regarder ?
- Est-ce que le temps augmente beaucoup si la bibliothèque double de taille ?

### La notation O()

On note la complexité avec un **O()** suivi d'une expression mathématique. Voici
les complexités les plus courantes, de la plus rapide à la plus lente :

#### O(1) - Complexité constante

**Signification** : Le temps d'exécution ne dépend **pas** de la taille des
données.

**Exemple concret** : Accéder au premier élément d'un tableau.

```java
int[] numbers = {10, 20, 30, 40, 50};
int first = numbers[0]; // Toujours 1 opération
```

Que le tableau ait 10 éléments ou 1 million, accéder à `numbers[0]` prend
toujours le même temps.

**Graphique** : Une ligne horizontale - le temps ne change pas.

#### O(log n) - Complexité logarithmique

**Signification** : Le temps augmente **très lentement** quand les données
augmentent.

**Exemple concret** : Chercher un mot dans un dictionnaire en l'ouvrant au
milieu, puis au milieu de la moitié, etc.

**Cas pratique** :

- 1'000 éléments → environ 10 opérations
- 1'000'000 éléments → environ 20 opérations
- 1'000'000'000 éléments → environ 30 opérations

Doubler la taille n'ajoute qu'**une seule opération** supplémentaire !

**Graphique** : Une courbe qui monte doucement puis s'aplatit.

#### O(n) - Complexité linéaire

**Signification** : Le temps augmente **proportionnellement** à la taille des
données.

**Exemple concret** : Compter les pages d'un livre page par page.

**Cas pratique** :

- 1'000 éléments → 1'000 opérations maximum
- 2'000 éléments → 2'000 opérations maximum

Si vous doublez la taille, vous doublez le temps.

**Graphique** : Une ligne droite qui monte régulièrement.

#### O(n log n) - Complexité quasi-linéaire

**Signification** : Un peu plus lent que O(n), mais reste très efficace.

**Exemple concret** : Les meilleurs algorithmes de tri (comme le tri fusion).

**Graphique** : Une courbe un peu plus pentue que O(n).

#### O(n²) - Complexité quadratique

**Signification** : Le temps augmente avec le **carré** de la taille.

**Exemple concret** : Comparer chaque page d'un livre avec toutes les autres
pages.

**Cas pratique** :

- 100 éléments → 10'000 opérations
- 1'000 éléments → 1'000'000 opérations

Si vous doublez la taille, vous **quadruplez** le temps !

**Graphique** : Une courbe qui monte très rapidement.

### Comparaison visuelle

Pour 1'000 éléments :

| Complexité | Opérations | Exemple d'usage                |
| ---------- | ---------- | ------------------------------ |
| O(1)       | 1          | Accès direct à un élément      |
| O(log n)   | ~10        | Recherche binaire              |
| O(n)       | 1'000      | Recherche linéaire             |
| O(n log n) | ~10'000    | Tri fusion                     |
| O(n²)      | 1'000'000  | Tri à bulles (algorithme lent) |

### Meilleur cas, cas moyen, pire cas

Un même algorithme peut avoir différentes performances selon les circonstances :

- **Meilleur cas** : La situation la plus favorable (ex: l'élément cherché est
  le premier).
- **Cas moyen** : Ce qui se passe en général.
- **Pire cas** : La situation la plus défavorable (ex: l'élément cherché est le
  dernier).

On utilise généralement le **pire cas** pour garantir une borne supérieure.

### Pourquoi c'est important ?

Regardez cette comparaison pour chercher dans 1'000'000 d'éléments :

- **O(log n)** : 20 opérations → **instantané**
- **O(n)** : 1'000'000 opérations → **quelques secondes**
- **O(n²)** : 1'000'000'000'000 opérations → **plusieurs jours !**

Le choix de l'algorithme peut faire la différence entre un programme utilisable
et un programme inutilisable.

### En résumé

- **O(1)** : Temps constant - le meilleur possible.
- **O(log n)** : Très rapide - excellent pour grandes données.
- **O(n)** : Acceptable - temps raisonnable.
- **O(n log n)** : Bon compromis - standard pour le tri.
- **O(n²)** : Lent - à éviter pour grandes données.

Maintenant que vous comprenez comment on mesure la performance, explorons les
algorithmes de recherche !

## Recherche linéaire

### Principe

La recherche linéaire, aussi appelée recherche séquentielle, est l'algorithme de
recherche le plus simple. Elle consiste à parcourir les éléments un par un
jusqu'à trouver l'élément recherché ou atteindre la fin de la collection.

### Fonctionnement

1. Commencer au premier élément.
2. Comparer l'élément courant avec la valeur recherchée.
3. Si l'élément correspond, retourner sa position.
4. Sinon, passer à l'élément suivant.
5. Répéter jusqu'à trouver l'élément ou atteindre la fin.

### Exemple en Java

```java
public static int linearSearch(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == target) {
            return i; // Élément trouvé à la position i
        }
    }
    return -1; // Élément non trouvé
}
```

### Complexité

- **Meilleur cas** : O(1) - l'élément est au début
- **Cas moyen** : O(n/2) ≈ O(n) - l'élément est au milieu
- **Pire cas** : O(n) - l'élément est à la fin ou absent

Où n est le nombre d'éléments dans la collection.

### Avantages

- Simple à comprendre et implémenter.
- Fonctionne sur des données non triées.
- Aucune préparation nécessaire.
- Efficace pour de petites collections.

### Inconvénients

- Lent pour de grandes collections.
- Parcourt tous les éléments dans le pire cas.
- Pas optimal si de nombreuses recherches sont nécessaires.

## Recherche binaire

### Principe

La recherche binaire est un algorithme beaucoup plus efficace que la recherche
linéaire, mais elle nécessite que les données soient **triées**. Elle fonctionne
en divisant répétitivement la zone de recherche en deux.

### Fonctionnement

1. Comparer l'élément recherché avec l'élément du milieu.
2. Si l'élément correspond, retourner sa position.
3. Si l'élément recherché est plus petit, rechercher dans la moitié gauche.
4. Si l'élément recherché est plus grand, rechercher dans la moitié droite.
5. Répéter jusqu'à trouver l'élément ou que la zone soit vide.

### Exemple en Java

```java
public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
        int middle = left + (right - left) / 2;

        if (array[middle] == target) {
            return middle; // Élément trouvé
        }

        if (array[middle] < target) {
            left = middle + 1; // Chercher à droite
        } else {
            right = middle - 1; // Chercher à gauche
        }
    }

    return -1; // Élément non trouvé
}
```

### Complexité

- **Meilleur cas** : O(1) - l'élément est au milieu dès le début
- **Cas moyen** : O(log n)
- **Pire cas** : O(log n)

Où n est le nombre d'éléments dans la collection.

### Exemple de complexité

Pour un tableau de 1'000'000 d'éléments :

- Recherche linéaire : jusqu'à 1'000'000 comparaisons
- Recherche binaire : maximum 20 comparaisons (log₂(1'000'000) ≈ 20)

### Avantages

- Très rapide pour de grandes collections.
- Nombre de comparaisons croît logarithmiquement.
- Efficace pour des recherches répétées.

### Inconvénients

- Nécessite des données triées.
- Plus complexe à implémenter correctement.
- Le tri préalable peut être coûteux.

## Recherche dans des collections

### ArrayList vs Array

Java propose différentes structures pour stocker des collections d'éléments.
Chacune a ses particularités pour la recherche.

#### Tableaux (Array)

```java
int[] numbers = {10, 20, 30, 40, 50};

// Recherche manuelle
for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] == 30) {
        System.out.println("Trouvé à l'index " + i);
    }
}

// Recherche binaire avec Arrays (si trié)
int index = Arrays.binarySearch(numbers, 30);
```

#### ArrayList

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);
numbers.add(20);
numbers.add(30);

// Recherche avec indexOf
int index = numbers.indexOf(30); // Retourne 2

// Vérification d'existence
boolean exists = numbers.contains(30); // Retourne true
```

### Méthodes de recherche en Java

#### Arrays.binarySearch()

```java
int[] sortedArray = {1, 3, 5, 7, 9, 11, 13};
int index = Arrays.binarySearch(sortedArray, 7);
// Retourne 3 (position de l'élément 7)
```

**Important** : Le tableau doit être trié, sinon le résultat est imprévisible.

#### Collections.binarySearch()

```java
ArrayList<Integer> sortedList = new ArrayList<>();
sortedList.add(1);
sortedList.add(3);
sortedList.add(5);

int index = Collections.binarySearch(sortedList, 3);
// Retourne 1 (position de l'élément 3)
```

## Parcours de structures complexes

### Parcours de tableaux multidimensionnels

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Recherche dans une matrice
public static boolean searchMatrix(int[][] matrix, int target) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == target) {
                return true;
            }
        }
    }
    return false;
}
```

### Parcours d'objets

```java
class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

ArrayList<Student> students = new ArrayList<>();
students.add(new Student("Alice", 1001));
students.add(new Student("Bob", 1002));

// Recherche par critère
for (Student student : students) {
    if (student.id == 1001) {
        System.out.println("Trouvé : " + student.name);
    }
}
```

## Optimisation de la recherche

### Tri préalable

Si vous devez effectuer de nombreuses recherches, il peut être avantageux de
trier les données une fois, puis d'utiliser la recherche binaire.

```java
int[] data = {50, 30, 20, 10, 40};

// Tri une seule fois
Arrays.sort(data); // {10, 20, 30, 40, 50}

// Recherches multiples rapides
int index1 = Arrays.binarySearch(data, 30);
int index2 = Arrays.binarySearch(data, 10);
int index3 = Arrays.binarySearch(data, 50);
```

### Structures de données alternatives

Pour des cas d'usage spécifiques, d'autres structures peuvent être plus
efficaces :

- **HashMap** : recherche en O(1) en moyenne
- **TreeSet** : maintient l'ordre et permet des recherches en O(log n)
- **HashSet** : vérification d'existence en O(1)

```java
HashMap<String, Integer> ages = new HashMap<>();
ages.put("Alice", 25);
ages.put("Bob", 30);

// Recherche très rapide
Integer age = ages.get("Alice"); // O(1)
```

## Stratégies de recherche

### Quand utiliser la recherche linéaire

- Données non triées.
- Petite collection (moins de 100 éléments).
- Recherche unique ou rare.
- Simplicité primordiale.

### Quand utiliser la recherche binaire

- Données triées ou pouvant être triées.
- Grande collection.
- Recherches fréquentes.
- Performance critique.

### Quand utiliser HashMap/HashSet

- Recherches très fréquentes.
- Pas besoin d'ordre.
- Clés uniques.
- Performance maximale souhaitée.

## Cas pratiques

### Recherche dans un annuaire

Un annuaire téléphonique est trié alphabétiquement : **recherche binaire**.

### Recherche d'un produit dans un panier

Un panier de courses n'est pas trié : **recherche linéaire**.

### Vérification d'un email déjà utilisé

Base de données d'emails : **HashMap** ou **HashSet**.

### Recherche du plus grand élément

Parcourir tous les éléments une fois : **parcours séquentiel**.

## Conclusion

Le choix de l'algorithme de recherche dépend de plusieurs facteurs :

- La taille de la collection.
- L'ordre des données.
- La fréquence des recherches.
- Les contraintes de performance.

Comprendre ces algorithmes vous permet de créer des programmes plus efficaces et
de prendre des décisions éclairées sur les structures de données à utiliser.

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
