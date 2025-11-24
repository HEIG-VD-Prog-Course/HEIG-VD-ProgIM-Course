---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
title: HEIG-VD ProgIM1 Course - Algorithmes de tri
description: Algorithmes de tri pour l'unité d'enseignement ProgIM1 enseigné à la HEIG-VD, Suisse
url: https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/10.01-algorithmes-de-tri/01-supports-de-cours/index.html
header: "**Algorithmes de tri**"
footer: '[**HEIG-VD**](https://heig-vd.ch) - [ProgIM1 2025-2026](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course) - [CC BY-SA 4.0](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md)'
headingDivider: 6
math: mathjax
-->

# Algorithmes de tri

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

- Comprendre et implémenter différents algorithmes de tri.
- Analyser la complexité temporelle et spatiale des algorithmes de tri.
- Différencier les algorithmes de tri simples des algorithmes avancés.
- Choisir l'algorithme de tri approprié selon le contexte.
- Comparer les performances de différents algorithmes de tri.

![bg right:40%][illustration-objectifs]

## Pourquoi trier ?

Le tri est une opération fondamentale en informatique.

**Avantages du tri :**

- Permet la recherche binaire (O(log n) au lieu de O(n)).
- Facilite l'identification des doublons.
- Améliore la présentation des données.
- Optimise de nombreux algorithmes.

**Exemples quotidiens :**

- Classer des emails par date.
- Organiser des contacts par nom.
- Trier des produits par prix.

## Tri à bulles (Bubble Sort)

### Principe

Comparer des paires d'éléments adjacents et les échanger s'ils sont dans le
mauvais ordre. Répéter jusqu'à ce que le tableau soit trié.

**Analogie** : Les grandes valeurs "remontent" comme des bulles vers la fin.

```
[5, 2, 8, 1] → [2, 5, 1, 8] → [2, 1, 5, 8] → [1, 2, 5, 8]
```

**Complexité** : O(n²) dans le cas moyen et pire cas.

## Tri à bulles - Code

```java
public static void bubbleSort(int[] array) {
    int n = array.length;

    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;

        for (int j = 0; j < n - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                // Échanger
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
            }
        }

        if (!swapped) break; // Déjà trié
    }
}
```

## Tri par sélection (Selection Sort)

### Principe

Trouver le minimum dans la partie non triée et le placer au début. Répéter pour
chaque position.

**Analogie** : Sélectionner toujours la plus petite carte restante.

```
[5, 2, 8, 1] → [1, 2, 8, 5] → [1, 2, 5, 8]
 ↑ min         ↑ min         ↑ min
```

**Complexité** : O(n²) dans tous les cas.

## Tri par sélection - Code

```java
public static void selectionSort(int[] array) {
    int n = array.length;

    for (int i = 0; i < n - 1; i++) {
        // Trouver le minimum
        int minIndex = i;

        for (int j = i + 1; j < n; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }

        // Échanger
        int temp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = temp;
    }
}
```

## Tri par insertion (Insertion Sort)

### Principe

Construire le tableau trié un élément à la fois. Insérer chaque élément à sa
position correcte dans la partie déjà triée.

**Analogie** : Comme trier des cartes à jouer dans votre main.

```
[5, 2, 8, 1]
[2, 5, 8, 1]  ← Insérer 2
[2, 5, 8, 1]  ← 8 déjà à sa place
[1, 2, 5, 8]  ← Insérer 1 au début
```

## Tri par insertion - Code

```java
public static void insertionSort(int[] array) {
    int n = array.length;

    for (int i = 1; i < n; i++) {
        int key = array[i];
        int j = i - 1;

        // Décaler les éléments plus grands
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j--;
        }

        array[j + 1] = key;
    }
}
```

**Complexité** : O(n²) cas moyen, mais O(n) si presque trié !

## Comparaison des tris simples

| Algorithme        | Meilleur cas | Cas moyen | Pire cas | Stable |
| ----------------- | ------------ | --------- | -------- | ------ |
| Tri à bulles      | O(n)         | O(n²)     | O(n²)    | Oui    |
| Tri par sélection | O(n²)        | O(n²)     | O(n²)    | Non    |
| Tri par insertion | O(n)         | O(n²)     | O(n²)    | Oui    |

**Usage** : Petites collections (< 50 éléments), données presque triées.

## Tri fusion (Merge Sort)

### Principe

**Diviser pour régner** :

1. Diviser le tableau en deux moitiés.
2. Trier récursivement chaque moitié.
3. Fusionner les deux moitiés triées.

```
[5, 2, 8, 1, 9, 3]
     ↓ Diviser
[5, 2, 8]  [1, 9, 3]
     ↓ Diviser encore
[5] [2, 8]  [1] [9, 3]
     ↓ Trier et fusionner
[2, 5, 8]  [1, 3, 9]
     ↓ Fusionner
[1, 2, 3, 5, 8, 9]
```

## Tri fusion - Complexité

**Complexité** : O(n log n) dans tous les cas !

**Pourquoi ?**

- Diviser : log n niveaux (diviser par 2 à chaque fois).
- Fusionner : O(n) à chaque niveau.
- Total : O(n) × log n = O(n log n).

**Exemple** : Pour 1'000'000 d'éléments :

- Tri à bulles : ≈ 1'000'000'000'000 opérations
- Tri fusion : ≈ 20'000'000 opérations (50'000x plus rapide !)

## Tri rapide (Quick Sort)

### Principe

1. Choisir un **pivot** (élément de référence).
2. **Partitionner** : éléments < pivot à gauche, éléments > pivot à droite.
3. Trier récursivement les deux partitions.

```
[5, 2, 8, 1, 9, 3]  pivot = 3
     ↓ Partitionner
[2, 1, 3, 5, 8, 9]
 ↑ < 3  ↑  ↑ > 3
```

**Nom** : "Quick" car très rapide en pratique !

## Tri rapide - Complexité

**Complexité** :

- Meilleur/Moyen cas : O(n log n)
- Pire cas : O(n²) - si pivot mal choisi (rare)

**Pourquoi rapide en pratique ?**

- Tri en place (peu de mémoire supplémentaire).
- Cache-friendly (bonne localité mémoire).
- Constantes faibles.

**Usage** : Algorithme par défaut dans de nombreux langages, dont Java
(`Arrays.sort()` pour les types primitifs).

## Comparaison complète

| Algorithme        | Complexité   | Espace   | Stable | Usage principal                |
| ----------------- | ------------ | -------- | ------ | ------------------------------ |
| Tri à bulles      | O(n²)        | O(1)     | Oui    | Apprentissage                  |
| Tri par sélection | O(n²)        | O(1)     | Non    | Peu utilisé                    |
| Tri par insertion | O(n²)        | O(1)     | Oui    | Petites listes, presque triées |
| Tri fusion        | O(n log n)   | O(n)     | Oui    | Stabilité requise              |
| Tri rapide        | O(n log n)\* | O(log n) | Non    | Performance maximale           |

\* Cas moyen, O(n²) pire cas

## Stabilité d'un tri

Un tri est **stable** s'il préserve l'ordre relatif des éléments égaux.

**Exemple** : Personnes avec (nom, âge)

```
Avant tri par âge :
Ariel 25, Nox 30, Amaru 25

Tri stable :
Ariel 25, Amaru 25, Nox 30  ← Ariel avant Amaru

Tri non stable :
Amaru 25, Ariel 25, Nox 30  ← Ordre inversé !
```

**Importance** : Tri multi-critères (trier par âge puis par nom).

## Méthodes de tri en Java

### Arrays.sort()

```java
int[] numbers = {5, 2, 8, 1, 9};
Arrays.sort(numbers);
// Résultat : [1, 2, 5, 8, 9]

// Trier une portion
Arrays.sort(numbers, 0, 3); // 3 premiers éléments
```

**Algorithme** : Dual-Pivot Quicksort (variante optimisée).

## Collections.sort()

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(5);
list.add(2);
list.add(8);

Collections.sort(list);
// Résultat : [2, 5, 8]
```

**Algorithme** : Timsort (hybride fusion + insertion).

**Caractéristiques** : Stable, O(n log n), adaptatif.

## Trier des objets

```java
class Student {
    String name;
    int age;
}

ArrayList<Student> students = new ArrayList<>();
// ... ajouter des étudiants

// Trier par âge
students.sort(Comparator.comparingInt(s -> s.age));

// Trier par nom
students.sort(Comparator.comparing(s -> s.name));

// Trier par âge, puis par nom
students.sort(Comparator.comparingInt((Student s) -> s.age)
                        .thenComparing(s -> s.name));
```

## Quand utiliser quel algorithme ?

**Recommandation générale** : Utilisez `Arrays.sort()` ou `Collections.sort()`.

**Cas spécifiques** :

- **Petites collections (< 10)** : Tri par insertion.
- **Presque triées** : Tri par insertion.
- **Stabilité requise** : Tri fusion ou `Collections.sort()`.
- **Performance maximale** : Tri rapide ou `Arrays.sort()`.
- **Apprentissage** : Tri à bulles (simple à comprendre).

## Optimisations possibles

**Hybridation** : Combiner plusieurs algorithmes.

- Timsort : Fusion + insertion pour petites parties.
- Introsort : Rapide + fusion si récursion trop profonde.

**Choix du pivot (Quick Sort)** :

- Médiane de trois éléments.
- Pivot aléatoire.

**Détection de cas triés** : Arrêter si déjà trié.

## Exercices pratiques

1. Implémenter les 3 tris simples.
2. Comparer leurs performances sur différentes tailles.
3. Tester avec des données déjà triées, inversées, aléatoires.
4. Implémenter le tri fusion.
5. Trier une collection d'objets personnalisés.

**Conseil** : Visualisez les étapes pour mieux comprendre !

## À vous de jouer !

- (Re)lire le support de cours.
- Explorer les exemples de code.
- Faire les exercices.
- Poser des questions si nécessaire.

**La programmation s'apprend par la pratique !** **N'hésitez pas à créer vos
propres exercices.**

![bg right:40%][illustration-a-vous-de-jouer]

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## Sources

- [Oracle Java Documentation - Arrays](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html)
- [Oracle Java Documentation - Collections](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collections.html)
- Introduction to Algorithms, Cormen et al.
- Algorithms, 4th Edition, Sedgewick & Wayne
- [Timsort documentation](https://en.wikipedia.org/wiki/Timsort)
- [Illustration objectifs][illustration-objectifs] par
  [Aline de Nadai](https://unsplash.com/@alinedenadai) sur
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
- [Illustration à vous de jouer][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/FJFPuE1MAOM)

<!-- URLs -->

[presentation-web]:
	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/10.01-algorithmes-de-tri/01-supports-de-cours/index.html
[presentation-pdf]:
	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/10.01-algorithmes-de-tri/01-supports-de-cours/10.01-algorithmes-de-tri-presentation.pdf
[cours]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/10.01-algorithmes-de-tri/01-supports-de-cours
[exercices]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/10.01-algorithmes-de-tri/03-exercices
[license]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
