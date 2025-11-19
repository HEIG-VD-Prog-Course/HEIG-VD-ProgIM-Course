---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
title: HEIG-VD ProgIM1 Course - Template
description: Template pour l'unité d'enseignement ProgIM1 enseigné à la HEIG-VD, Suisse
url: https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/09.01-algorithmes-de-parcours/01-supports-de-cours/index.html
header: "**Template**"
footer: '[**HEIG-VD**](https://heig-vd.ch) - [ProgIM1 2025-2026](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course) - [CC BY-SA 4.0](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md)'
headingDivider: 6
math: mathjax
-->

<!-- _class: title -->

# Algorithmes de parcours

<!--
_class: lead
_paginate: false
-->

<https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course>

[Support de cours][cours] · [Présentation (web)][presentation-web] ·
[Présentation (PDF)][presentation-pdf]

<small>V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).</small>

<small>Ce travail est sous licence [CC BY-SA 4.0][license].</small>

![bg brightness:2 opacity:0.2][illustration-principale]

## _Retrouvez plus de détails dans le support de cours_

<!-- _class: lead -->

_Cette présentation est un résumé du support de cours. Pour plus de détails,
consultez le [support de cours][cours]._

## Objectifs

À la fin de cette séance, vous devriez être capable de :

À l'issue de ce module, vous serez capable de :

- Comprendre et implémenter différents algorithmes de recherche.
- Différencier la recherche linéaire et la recherche binaire.
- Analyser la complexité temporelle des algorithmes de recherche.
- Choisir l'algorithme de recherche approprié selon le contexte.
- Implémenter des parcours séquentiels et indexés dans des collections.

![bg right:40%][illustration-objectifs]

## Recherche dans les données

La recherche d'éléments est une opération fondamentale en programmation.

**Exemples quotidiens :**

- Trouver un contact dans votre téléphone.
- Chercher un mot dans un dictionnaire.
- Localiser un livre dans une bibliothèque.
- Rechercher un produit sur un site e-commerce.

**Question** : Comment ces systèmes trouvent-ils rapidement l'information ?

## Recherche linéaire

### Principe

Parcourir les éléments un par un jusqu'à trouver ce qu'on cherche.

```java
public static int linearSearch(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == target) {
            return i; // Trouvé !
        }
    }
    return -1; // Pas trouvé
}
```

**Analogie** : Chercher vos clés en vidant votre sac objet par objet.

## Recherche linéaire - Complexité

**Combien de comparaisons sont nécessaires ?**

Tableau : `[10, 25, 30, 45, 50]` - Recherche : `30`

- Comparaison 1 : `10 ≠ 30`
- Comparaison 2 : `25 ≠ 30`
- Comparaison 3 : `30 = 30` ✓ Trouvé !

**Complexité :**

- Meilleur cas : **O(1)** - élément au début
- Cas moyen : **O(n/2)** ≈ **O(n)**
- Pire cas : **O(n)** - élément à la fin ou absent

## Recherche linéaire - Avantages et inconvénients

**Avantages :**

- Simple à comprendre et implémenter.
- Fonctionne sur des données non triées.
- Efficace pour de petites collections.

**Inconvénients :**

- Lent pour de grandes collections.
- Doit parcourir tous les éléments dans le pire cas.

**Usage** : Petites listes, données non triées, recherches occasionnelles.

## Recherche binaire

### Principe

Sur des données **triées**, diviser la zone de recherche en deux à chaque étape.

```java
public static int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1;

    while (left <= right) {
        int middle = left + (right - left) / 2;

        if (array[middle] == target) return middle;
        if (array[middle] < target) left = middle + 1;
        else right = middle - 1;
    }
    return -1;
}
```

## Recherche binaire - Exemple

Tableau trié : `[5, 10, 15, 20, 25, 30, 35, 40, 45]` - Recherche : `25`

**Étape 1 :** Milieu = `25` ✓ Trouvé en 1 comparaison !

Recherche : `5`

**Étape 1 :** Milieu = `25` → trop grand, chercher à gauche **Étape 2 :** Milieu
= `10` → trop grand, chercher à gauche **Étape 3 :** Milieu = `5` ✓ Trouvé en 3
comparaisons !

**Recherche linéaire aurait nécessité 5 comparaisons pour `25` et 1 pour `5`.**

## Recherche binaire - Complexité

**Pour 1'000'000 d'éléments :**

- Recherche linéaire : jusqu'à **1'000'000** comparaisons
- Recherche binaire : maximum **20** comparaisons

**Formule** : log₂(n) comparaisons

|  Éléments | Comparaisons max |
| --------: | ---------------: |
|        10 |                4 |
|       100 |                7 |
|     1'000 |               10 |
| 1'000'000 |               20 |

## Recherche binaire - Condition importante

**La recherche binaire nécessite des données TRIÉES.**

```java
int[] unsorted = {30, 10, 50, 20, 40};
Arrays.binarySearch(unsorted, 20); // Résultat imprévisible !

int[] sorted = {10, 20, 30, 40, 50};
Arrays.sort(sorted); // Tri préalable
Arrays.binarySearch(sorted, 20); // Fonctionne correctement
```

**Si les données ne sont pas triées** : utilisez la recherche linéaire ou triez
d'abord.

## Comparaison des algorithmes

| Critère          | Recherche linéaire | Recherche binaire |
| ---------------- | ------------------ | ----------------- |
| Complexité       | O(n)               | O(log n)          |
| Données triées ? | Non nécessaire     | Obligatoire       |
| Simplicité       | Très simple        | Plus complexe     |
| Petites listes   | Efficace           | Overkill          |
| Grandes listes   | Lent               | Très rapide       |

**Règle générale** : Moins de 100 éléments non triés → linéaire. Plus de 100
éléments triés → binaire.

## Recherche dans ArrayList

Java fournit des méthodes intégrées pour ArrayList :

```java
ArrayList<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");

// Recherche linéaire automatique
int index = names.indexOf("Bob"); // Retourne 1
boolean exists = names.contains("Charlie"); // true

// Si la liste est triée
Collections.sort(names);
int pos = Collections.binarySearch(names, "Alice"); // 0
```

## Recherche dans les tableaux

Méthodes de la classe `Arrays` :

```java
int[] numbers = {5, 2, 8, 1, 9};

// Recherche manuelle (linéaire)
for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] == 8) {
        System.out.println("Trouvé à l'index " + i);
    }
}

// Recherche binaire (nécessite un tri)
Arrays.sort(numbers);
int index = Arrays.binarySearch(numbers, 8);
```

## Parcours de structures complexes

### Tableaux 2D

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Recherche dans la matrice
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 5) {
            System.out.println("Trouvé en [" + i + "][" + j + "]");
        }
    }
}
```

## Recherche dans des objets

```java
class Product {
    String name;
    double price;
}

ArrayList<Product> products = new ArrayList<>();
products.add(new Product("Laptop", 999.00));
products.add(new Product("Mouse", 29.90));

// Recherche par critère
for (Product p : products) {
    if (p.price < 50.00) {
        System.out.println(p.name + " est abordable !");
    }
}
```

## Optimisation : Tri + Recherches multiples

Si vous devez chercher **plusieurs fois** dans les mêmes données :

```java
int[] data = {50, 30, 20, 10, 40};

// Trier une seule fois
Arrays.sort(data); // {10, 20, 30, 40, 50}

// Effectuer plusieurs recherches rapides
int pos1 = Arrays.binarySearch(data, 30); // Rapide
int pos2 = Arrays.binarySearch(data, 10); // Rapide
int pos3 = Arrays.binarySearch(data, 50); // Rapide
```

**Coût** : Tri en O(n log n) + Recherches en O(log n) chacune

## Structures de données alternatives

Pour des performances optimales, considérez :

**HashMap** : Recherche en O(1) en moyenne

```java
HashMap<String, Integer> ages = new HashMap<>();
ages.put("Alice", 25);
Integer age = ages.get("Alice"); // Très rapide !
```

**HashSet** : Vérification d'existence en O(1)

```java
HashSet<String> emails = new HashSet<>();
emails.add("alice@example.com");
boolean exists = emails.contains("alice@example.com"); // O(1)
```

## Quand utiliser quel algorithme ?

**Recherche linéaire :**

- Données non triées
- Petite collection (< 100 éléments)
- Recherche unique ou rare

**Recherche binaire :**

- Données triées
- Grande collection
- Recherches fréquentes

**HashMap/HashSet :**

- Recherches très fréquentes
- Performance maximale requise

## Cas pratiques

| Situation                         | Algorithme recommandé |
| --------------------------------- | --------------------- |
| Annuaire téléphonique             | Recherche binaire     |
| Panier de courses                 | Recherche linéaire    |
| Vérification email déjà utilisé   | HashMap/HashSet       |
| Recherche du plus grand élément   | Parcours séquentiel   |
| Recherche dans un dictionnaire    | Recherche binaire     |
| Trouver un produit dans un panier | Recherche linéaire    |

## À vous de jouer !

- (Re)lire le support de cours.
- Explorer les exemples de code.
- Faire les [exercices][exercices].
- Poser des questions si nécessaire.

**La programmation s'apprend par la pratique !** **N'hésitez pas à créer vos
propres exercices.**

![bg right:40%][illustration-a-vous-de-jouer]

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## Sources

- [Illustration objectifs][illustration-objectifs] par
  [Aline de Nadai](https://unsplash.com/@alinedenadai) sur
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
- [Illustration à vous de jouer][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/FJFPuE1MAOM)

<!-- URLs -->

[presentation-web]:
	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/09.01-algorithmes-de-parcours/01-supports-de-cours/index.html
[presentation-pdf]:
	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/09.01-algorithmes-de-parcours/01-supports-de-cours/09.01-algorithmes-de-parcours-presentation.pdf
[cours]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/09.01-algorithmes-de-parcours/01-supports-de-cours
[exercices]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/09.01-algorithmes-de-parcours/02-exercices
[license]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
