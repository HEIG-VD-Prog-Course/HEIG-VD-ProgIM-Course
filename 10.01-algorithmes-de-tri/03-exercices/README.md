# Algorithmes de tri - Exercices

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

## Exercices

### Exercice 1 : Tri à bulles amélioré

Implémentez une version améliorée du tri à bulles qui :

1. S'arrête dès que le tableau est trié (pas d'échange dans un passage).
2. Réduit la zone de parcours à chaque itération.
3. Compte le nombre de comparaisons et d'échanges effectués.

**Signature de la méthode :**

```java
public static void bubbleSortImproved(int[] array)
```

**Exemple d'utilisation :**

```java
int[] numbers = {5, 2, 8, 1, 9};
bubbleSortImproved(numbers);
// numbers est maintenant [1, 2, 5, 8, 9]
```

**Questions :**

1. Quelle est la complexité temporelle dans le meilleur cas (tableau déjà trié)
   ?
2. Quelle est la complexité temporelle dans le pire cas (tableau inversé) ?
3. Combien de comparaisons et d'échanges sont effectués pour le tableau
   `{3, 2, 1}` ?

<details>
<summary>Solution</summary>

```java
/**
 * Tri à bulles amélioré avec optimisations.
 */
public static void bubbleSortImproved(int[] array) {
    int n = array.length;
    int comparisons = 0;
    int swaps = 0;

    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;

        // Zone de parcours réduite : n - 1 - i
        for (int j = 0; j < n - 1 - i; j++) {
            comparisons++;

            if (array[j] > array[j + 1]) {
                // Échanger
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swaps++;
                swapped = true;
            }
        }

        // Arrêt anticipé si aucun échange
        if (!swapped) {
            break;
        }
    }

    System.out.println("Comparaisons : " + comparisons);
    System.out.println("Échanges : " + swaps);
}
```

**Réponses :**

1. **Meilleur cas** : O(n) - Si le tableau est déjà trié, on fait un seul
   passage sans échange et on s'arrête.
2. **Pire cas** : O(n²) - Si le tableau est inversé, on doit faire tous les
   passages et tous les échanges possibles.
3. **Pour `{3, 2, 1}`** :
   - Passage 1 : 2 comparaisons, 2 échanges → `{2, 1, 3}`
   - Passage 2 : 1 comparaison, 1 échange → `{1, 2, 3}`
   - **Total : 3 comparaisons, 3 échanges**

</details>

---

### Exercice 2 : Tri par sélection du maximum

Modifiez le tri par sélection pour qu'il recherche le **maximum** au lieu du
minimum et le place à la fin du tableau (plutôt qu'au début).

**Signature de la méthode :**

```java
public static void selectionSortMax(int[] array)
```

**Exemple d'utilisation :**

```java
int[] numbers = {64, 25, 12, 22, 11};
selectionSortMax(numbers);
// numbers est maintenant [11, 12, 22, 25, 64]
```

**Question :** Quelle est la différence de performance entre cette version et la
version classique qui cherche le minimum ?

<details>
<summary>Solution</summary>

```java
/**
 * Tri par sélection qui recherche le maximum.
 */
public static void selectionSortMax(int[] array) {
    int n = array.length;

    // Parcourir du dernier au premier élément
    for (int i = n - 1; i > 0; i--) {
        // Trouver le maximum dans la partie non triée [0...i]
        int maxIndex = 0;

        for (int j = 1; j <= i; j++) {
            if (array[j] > array[maxIndex]) {
                maxIndex = j;
            }
        }

        // Échanger le maximum avec l'élément en position i
        if (maxIndex != i) {
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }
}
```

**Réponse à la question :**

Il n'y a **aucune différence de performance** entre les deux versions. Les deux
effectuent exactement le même nombre de comparaisons et d'échanges. La
complexité reste O(n²) dans tous les cas.

La seule différence est l'ordre dans lequel les éléments sont placés (partie
triée au début vs à la fin), mais le nombre d'opérations est identique.

</details>

---

### Exercice 3 : Tri par insertion avec décalage

Implémentez le tri par insertion en utilisant une approche en deux étapes :

1. Trouver la position d'insertion de l'élément.
2. Décaler tous les éléments vers la droite.
3. Insérer l'élément à sa position.

**Signature de la méthode :**

```java
public static void insertionSortShift(int[] array)
```

**Exemple d'utilisation :**

```java
int[] numbers = {5, 2, 4, 6, 1, 3};
insertionSortShift(numbers);
// numbers est maintenant [1, 2, 3, 4, 5, 6]
```

**Question :** Cette approche est-elle plus ou moins efficace que la version
classique du tri par insertion ?

<details>
<summary>Solution</summary>

```java
/**
 * Tri par insertion avec décalage explicite.
 */
public static void insertionSortShift(int[] array) {
    int n = array.length;

    for (int i = 1; i < n; i++) {
        int key = array[i];

        // Étape 1 : Trouver la position d'insertion
        int insertPos = i;
        for (int j = i - 1; j >= 0; j--) {
            if (array[j] > key) {
                insertPos = j;
            } else {
                break;
            }
        }

        // Étape 2 : Décaler les éléments vers la droite
        for (int k = i; k > insertPos; k--) {
            array[k] = array[k - 1];
        }

        // Étape 3 : Insérer l'élément
        array[insertPos] = key;
    }
}
```

**Réponse à la question :**

Cette approche est **légèrement moins efficace** que la version classique car
elle parcourt la zone deux fois :

1. Une fois pour trouver la position d'insertion.
2. Une fois pour décaler les éléments.

La version classique combine ces deux étapes en une seule boucle, ce qui est
plus efficace. Cependant, la complexité asymptotique reste O(n²) dans le pire
cas pour les deux versions.

Cette version est néanmoins plus **lisible** et plus facile à comprendre pour un
débutant.

</details>

---

### Exercice 4 : Stabilité du tri

Créez une classe `Person` avec un nom et un âge. Implémentez une méthode qui
trie un tableau de personnes par âge en utilisant :

1. Le tri à bulles.
2. Le tri par sélection.

Testez avec des personnes ayant le même âge et vérifiez si l'ordre relatif est
préservé (stabilité).

**Exemple :**

```java
Person[] people = {
    new Person("Ariel", 25),
    new Person("Nox", 30),
    new Person("Amaru", 25),
    new Person("David", 30)
};
```

**Questions :**

1. Quel tri est stable ?
2. Pourquoi l'autre n'est-il pas stable ?

<details>
<summary>Solution</summary>

```java
/**
 * Classe représentant une personne.
 */
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

/**
 * Tri à bulles pour personnes (par âge).
 */
public static void bubbleSortPeople(Person[] people) {
    int n = people.length;

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1 - i; j++) {
            // Utiliser > (strict) pour préserver la stabilité
            if (people[j].age > people[j + 1].age) {
                Person temp = people[j];
                people[j] = people[j + 1];
                people[j + 1] = temp;
            }
        }
    }
}

/**
 * Tri par sélection pour personnes (par âge).
 */
public static void selectionSortPeople(Person[] people) {
    int n = people.length;

    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;

        for (int j = i + 1; j < n; j++) {
            if (people[j].age < people[minIndex].age) {
                minIndex = j;
            }
        }

        Person temp = people[i];
        people[i] = people[minIndex];
        people[minIndex] = temp;
    }
}

/**
 * Test de stabilité.
 */
public static void main(String[] args) {
    Person[] people1 = {
        new Person("Ariel", 25),
        new Person("Nox", 30),
        new Person("Amaru", 25),
        new Person("David", 30)
    };

    Person[] people2 = people1.clone();

    System.out.println("Avant tri :");
    System.out.println(Arrays.toString(people1));

    bubbleSortPeople(people1);
    System.out.println("\nAprès tri à bulles (STABLE) :");
    System.out.println(Arrays.toString(people1));
    // Ariel et Amaru (25) restent dans cet ordre
    // Nox et David (30) restent dans cet ordre

    selectionSortPeople(people2);
    System.out.println("\nAprès tri par sélection (NON STABLE) :");
    System.out.println(Arrays.toString(people2));
    // L'ordre relatif peut changer pour les éléments égaux
}
```

**Réponses :**

1. **Tri à bulles est stable** : Il ne fait des échanges que quand un élément
   est **strictement plus grand** (>) que le suivant. Les éléments égaux ne sont
   jamais échangés, donc leur ordre relatif est préservé.

2. **Tri par sélection n'est PAS stable** : Il peut échanger un élément avec un
   autre de même valeur situé plus loin. Par exemple :
   - Tableau : `[3a, 3b, 1]`
   - Le tri par sélection échange `3a` avec `1`
   - Résultat : `[1, 3b, 3a]` → L'ordre de `3a` et `3b` est inversé

</details>

---

### Exercice 5 : Tri avec Comparator

Créez une classe `Product` avec un nom et un prix. Utilisez `Arrays.sort()` et
un `Comparator` pour trier un tableau de produits :

1. Par prix croissant.
2. Par prix décroissant.
3. Par nom (ordre alphabétique).

**Exemple :**

```java
Product[] products = {
    new Product("Laptop", 1200.0),
    new Product("Mouse", 25.0),
    new Product("Keyboard", 80.0)
};
```

<details>
<summary>Solution</summary>

```java
import java.util.Arrays;
import java.util.Comparator;

/**
 * Classe représentant un produit.
 */
class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + price + " CHF";
    }
}

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("Laptop", 1200.0),
            new Product("Mouse", 25.0),
            new Product("Keyboard", 80.0),
            new Product("Monitor", 350.0)
        };

        // 1. Tri par prix croissant
        System.out.println("=== Tri par prix croissant ===");
        Product[] sorted1 = products.clone();
        Arrays.sort(sorted1, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.price, p2.price);
            }
        });

        for (Product p : sorted1) {
            System.out.println(p);
        }

        // 2. Tri par prix décroissant
        System.out.println("\n=== Tri par prix décroissant ===");
        Product[] sorted2 = products.clone();
        Arrays.sort(sorted2, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p2.price, p1.price);
            }
        });

        for (Product p : sorted2) {
            System.out.println(p);
        }

        // 3. Tri par nom (ordre alphabétique)
        System.out.println("\n=== Tri par nom ===");
        Product[] sorted3 = products.clone();
        Arrays.sort(sorted3, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.name.compareTo(p2.name);
            }
        });

        for (Product p : sorted3) {
            System.out.println(p);
        }

        // Bonus : Syntaxe lambda (Java 8+)
        System.out.println("\n=== Tri avec lambda ===");
        Product[] sorted4 = products.clone();
        Arrays.sort(sorted4, (p1, p2) -> Double.compare(p1.price, p2.price));

        for (Product p : sorted4) {
            System.out.println(p);
        }
    }
}
```

**Points clés :**

- `Comparator<Product>` définit une méthode `compare(p1, p2)` qui retourne :

  - Négatif si `p1 < p2`
  - Zéro si `p1 == p2`
  - Positif si `p1 > p2`

- `Double.compare(a, b)` compare deux doubles correctement (gestion de NaN,
  infinité, etc.).

- `String.compareTo()` compare deux chaînes alphabétiquement.

- Avec Java 8+, on peut utiliser des **lambdas** pour simplifier :
  `(p1, p2) -> Double.compare(p1.price, p2.price)`

</details>

---

### Exercice 6 : Choix de l'algorithme

Pour chacune des situations suivantes, choisissez l'algorithme de tri le plus
approprié et justifiez votre choix :

1. Trier un tableau de 10 éléments.
2. Trier un tableau de 1 million d'éléments aléatoires.
3. Trier un tableau de 100 000 éléments presque triés (quelques éléments mal
   placés).
4. Trier une liste qui reçoit continuellement de nouveaux éléments.
5. Trier des données critiques où la performance doit être **garantie** (pas de
   pire cas catastrophique).

**Questions :**

Pour chaque situation, indiquez :

- L'algorithme recommandé.
- La justification (complexité, stabilité, adaptativité).

<details>
<summary>Solution</summary>

**1. Trier un tableau de 10 éléments**

- **Algorithme recommandé** : Tri par insertion ou tri par sélection.
- **Justification** : Pour de très petits tableaux, la simplicité
  d'implémentation prime. Les algorithmes O(n²) sont parfaitement acceptables et
  même parfois plus rapides que les algorithmes O(n log n) en raison du faible
  overhead.

---

**2. Trier un tableau de 1 million d'éléments aléatoires**

- **Algorithme recommandé** : Tri fusion (Merge Sort) ou `Arrays.sort()`.
- **Justification** : Il faut un algorithme en O(n log n). Le tri fusion
  garantit cette complexité dans tous les cas. `Arrays.sort()` (Dual-Pivot
  Quicksort) est encore meilleur et optimisé par Java.

**Performance :**

- Tri à bulles : ~500 000 000 000 opérations (inutilisable)
- Tri fusion : ~20 000 000 opérations (acceptable)

---

**3. Trier un tableau de 100 000 éléments presque triés**

- **Algorithme recommandé** : Tri par insertion.
- **Justification** : Le tri par insertion est **adaptatif** : il détecte les
  séquences déjà triées et les parcourt en O(n). Sur des données presque triées,
  il peut être plus rapide que les algorithmes O(n log n).

**Complexité dans ce cas :**

- Tri par insertion : O(n) si presque trié
- Tri fusion : O(n log n) dans tous les cas (pas adaptatif)

---

**4. Trier une liste qui reçoit continuellement de nouveaux éléments**

- **Algorithme recommandé** : Tri par insertion incrémental.
- **Justification** : Au lieu de retrier tout le tableau à chaque ajout, on
  insère directement le nouvel élément à sa position dans un tableau déjà trié
  en O(n). C'est beaucoup plus efficace que de tout retrieuter.

**Alternative :** Utiliser une structure de données comme un **tas** (heap) ou
un **arbre binaire de recherche** qui maintient l'ordre automatiquement.

---

**5. Trier des données critiques avec performance garantie**

- **Algorithme recommandé** : Tri fusion (Merge Sort).
- **Justification** : Le tri fusion garantit **toujours** O(n log n), même dans
  le pire cas. Le tri rapide (Quicksort) peut dégrader vers O(n²) dans le pire
  cas (bien que rare).

**Comparaison :**

- **Tri fusion** : O(n log n) garanti, mais utilise O(n) mémoire auxiliaire.
- **Tri rapide** : O(n log n) en moyenne, mais O(n²) dans le pire cas.

Pour des systèmes critiques (temps réel, sécurité), on préfère le tri fusion.

---

**Tableau récapitulatif :**

| Situation               | Algorithme                 | Raison                           |
| ----------------------- | -------------------------- | -------------------------------- |
| Petit tableau (n < 50)  | Insertion/Sélection        | Simplicité                       |
| Grand tableau aléatoire | Tri fusion / Arrays.sort() | O(n log n) garanti               |
| Données presque triées  | Tri par insertion          | Adaptatif : O(n) si presque trié |
| Ajouts continus         | Insertion incrémentale     | Évite de tout retrieuter         |
| Performance garantie    | Tri fusion                 | O(n log n) dans le pire cas      |

</details>

---

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
