---
marp: true
title: "Projet guidé - Puissance 4"
description: "Développement étape par étape d'un jeu Puissance 4 en console"
author: "V. Guidoux"
theme: teaching
paginate: true
_paginate: false
math: mathjax
---

<!-- _class: title-slide lead -->

# Projet guidé - Puissance 4

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Développement étape par étape

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md

---

<!-- _class: lead -->

## Objectifs du cours

À l'issue de ce cours, vous serez capable de :

- Analyser un problème complexe et le décomposer en étapes
- Utiliser des tableaux 2D pour une grille de jeu
- Implémenter des algorithmes de détection de motifs
- Organiser votre code en fonctions réutilisables
- Développer une application interactive complète
- Tester et déboguer méthodiquement

---

## Le jeu Puissance 4

**Règles :**

- Grille de 6 lignes × 7 colonnes
- 2 joueurs : X (rouge) et O (jaune)
- Chacun son tour, placer un pion dans une colonne
- Le pion tombe à la position la plus basse (gravité)
- **But :** Aligner 4 pions (horizontal, vertical, diagonal)

```text
| | | | | | | |
| | | | | | | |
| | |O| | | | |
| |X|O| | | | |
| |X|X|O| | | |
|X|O|X|O|X| | |
 1 2 3 4 5 6 7
```

---

## Représentation en mémoire

**Tableau 2D de caractères :**

```java
char[][] grid = new char[6][7];  // 6 lignes, 7 colonnes
```

**Contenu des cases :**

- `' '` (espace) → case vide
- `'X'` → pion de la joueuse 1
- `'O'` → pion de la joueuse 2

**Indices :**

- Lignes : de 0 (haut) à 5 (bas)
- Colonnes : de 0 à 6

---

## Décomposition du problème

**Fonctionnalités nécessaires :**

1. Afficher la grille
2. Placer un pion (avec gravité)
3. Alterner les joueurs
4. Détecter victoire horizontale
5. Détecter victoire verticale et diagonale
6. Détecter match nul
7. Boucle de jeu complète

**Approche : développement incrémental**

---

## Étape 1 : Affichage de la grille

**Objectif :** Créer et afficher une grille vide

```java
public static void displayGrid(char[][] grid) {
    for (int row = 0; row < grid.length; row++) {
        System.out.print("|");
        for (int col = 0; col < grid[row].length; col++) {
            System.out.print(grid[row][col] + "|");
        }
        System.out.println();
    }
    System.out.println(" 1 2 3 4 5 6 7");
}
```

**Concepts :** Boucles imbriquées, affichage formaté

---

## Étape 1 : Initialisation

**Remplir la grille avec des espaces :**

```java
public static char[][] createGrid() {
    char[][] grid = new char[6][7];
    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
            grid[row][col] = ' ';
        }
    }
    return grid;
}
```

**Résultat :**

```text
| | | | | | | |
| | | | | | | |
...
```

---

## Étape 2 : Placement d'un pion

**Objectif :** Placer un pion en respectant la gravité

**Algorithme :**

1. Demander la colonne au joueur
2. Valider l'entrée (1-7 et colonne non pleine)
3. Trouver la ligne la plus basse disponible
4. Placer le pion

**Concept clé : la gravité**

Les pions tombent jusqu'en bas !

---

## Étape 2 : Trouver la ligne disponible

**Parcourir de bas en haut :**

```java
public static int findLowestRow(char[][] grid, int col) {
    // Parcourir de la dernière ligne vers la première
    for (int row = grid.length - 1; row >= 0; row--) {
        if (grid[row][col] == ' ') {
            return row;  // Première case vide trouvée
        }
    }
    return -1;  // Colonne pleine
}
```

**Point important :** On commence par `grid.length - 1` (ligne du bas)

---

## Étape 2 : Placement complet

```java
public static int placeToken(char[][] grid, int col, char player) {
    int row = findLowestRow(grid, col);
    if (row != -1) {
        grid[row][col] = player;
    }
    return row;
}
```

**Validation de la colonne :**

```java
Scanner scanner = new Scanner(System.in);
int col;
do {
    System.out.print("Colonne (1-7) : ");
    col = scanner.nextInt() - 1;  // Conversion 1-7 → 0-6
} while (col < 0 || col >= 7 || findLowestRow(grid, col) == -1);
```

---

## Étape 3 : Alternance des joueuses

**Objectif :** Gérer le tour par tour

**Variable de joueur courant :**

```java
char currentPlayer = 'X';  // Commence toujours par X
```

**Après chaque coup valide :**

```java
currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
```

**Affichage :**

```java
System.out.println("C'est au tour de : " + currentPlayer);
```

---

## Étape 4 : Détection horizontale

**Objectif :** Détecter 4 pions alignés horizontalement

**Stratégie : fenêtre glissante**

Pour chaque ligne, vérifier toutes les séquences de 4 cases consécutives.

```text
|X|X|X|X| | | |   ← Victoire !
 0 1 2 3 4 5 6
```

On teste :

- Colonnes 0-3 → X X X X ✓
- Colonnes 1-4 → X X X vide ✗
- ...

---

## Étape 4 : Implémentation horizontale

```java
public static boolean checkHorizontalWin(char[][] grid, char player) {
    for (int row = 0; row < grid.length; row++) {
        // S'arrêter à length - 4 car on vérifie 4 cases
        for (int col = 0; col <= grid[row].length - 4; col++) {
            if (grid[row][col] == player &&
                grid[row][col + 1] == player &&
                grid[row][col + 2] == player &&
                grid[row][col + 3] == player) {
                return true;
            }
        }
    }
    return false;
}
```

---

## Étape 5 : Détection verticale

**Même principe, mais dans les colonnes :**

```java
public static boolean checkVerticalWin(char[][] grid, char player) {
    for (int col = 0; col < grid[0].length; col++) {
        for (int row = 0; row <= grid.length - 4; row++) {
            if (grid[row][col] == player &&
                grid[row + 1][col] == player &&
                grid[row + 2][col] == player &&
                grid[row + 3][col] == player) {
                return true;
            }
        }
    }
    return false;
}
```

---

## Étape 5 : Diagonale descendante ↘

**De haut-gauche vers bas-droite :**

```java
public static boolean checkDiagonalDown(char[][] grid, char player) {
    for (int row = 0; row <= grid.length - 4; row++) {
        for (int col = 0; col <= grid[0].length - 4; col++) {
            if (grid[row][col] == player &&
                grid[row + 1][col + 1] == player &&
                grid[row + 2][col + 2] == player &&
                grid[row + 3][col + 3] == player) {
                return true;
            }
        }
    }
    return false;
}
```

**On avance en ligne ET en colonne simultanément**

---

## Étape 5 : Diagonale montante ↗

**De bas-gauche vers haut-droite :**

```java
public static boolean checkDiagonalUp(char[][] grid, char player) {
    for (int row = 3; row < grid.length; row++) {
        for (int col = 0; col <= grid[0].length - 4; col++) {
            if (grid[row][col] == player &&
                grid[row - 1][col + 1] == player &&
                grid[row - 2][col + 2] == player &&
                grid[row - 3][col + 3] == player) {
                return true;
            }
        }
    }
    return false;
}
```

**Attention :** On commence à `row = 3` (besoin de remonter de 3 cases)

---

## Étape 5 : Fonction globale de victoire

**Combiner toutes les détections :**

```java
public static boolean hasWon(char[][] grid, char player) {
    return checkHorizontalWin(grid, player) ||
           checkVerticalWin(grid, player) ||
           checkDiagonalDown(grid, player) ||
           checkDiagonalUp(grid, player);
}
```

**Organisation claire : une fonction par type de victoire**

---

## Étape 6 : Détection de match nul

**La grille est pleine :**

```java
public static boolean isGridFull(char[][] grid) {
    for (int col = 0; col < grid[0].length; col++) {
        if (grid[0][col] == ' ') {
            return false;  // Il reste au moins une case libre en haut
        }
    }
    return true;  // Toutes les colonnes sont pleines
}
```

**Astuce :** Il suffit de vérifier la première ligne (si elle est pleine, tout
est plein)

---

## Étape 6 : Boucle de jeu complète

```java
while (true) {
    displayGrid(grid);

    // Tour de la joueuse
    int col = getPlayerMove(scanner, grid, currentPlayer);
    placeToken(grid, col, currentPlayer);

    // Vérifications
    if (hasWon(grid, currentPlayer)) {
        displayGrid(grid);
        System.out.println("Le joueur " + currentPlayer + " a gagné !");
        break;
    }
    if (isGridFull(grid)) {
        System.out.println("Match nul !");
        break;
    }

    // Alternance
    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
}
```

---

## Structure complète du programme

```java
public class ConnectFour {
    public static final int ROWS = 6;
    public static final int COLS = 7;

    public static void main(String[] args) { /* Boucle de jeu */ }

    public static char[][] createGrid() { /* Initialisation */ }
    public static void displayGrid(char[][] grid) { /* Affichage */ }
    public static int findLowestRow(char[][] grid, int col) { /* Gravité */ }
    public static int placeToken(char[][] grid, int col, char player) { /* Placement */ }
    public static boolean hasWon(char[][] grid, char player) { /* Victoire globale */ }
    public static boolean checkHorizontalWin(...) { /* Horizontal */ }
    public static boolean checkVerticalWin(...) { /* Vertical */ }
    public static boolean checkDiagonalDown(...) { /* Diagonale ↘ */ }
    public static boolean checkDiagonalUp(...) { /* Diagonale ↗ */ }
    public static boolean isGridFull(char[][] grid) { /* Match nul */ }
}
```

---

## Bonnes pratiques appliquées

**Organisation :**

- Une fonction, une responsabilité
- Fonctions courtes et lisibles
- Noms descriptifs (`placeToken`, `hasWon`)

**Constantes :**

```java
public static final int ROWS = 6;
public static final int COLS = 7;
public static final char PLAYER1 = 'X';
public static final char PLAYER2 = 'O';
```

**Tests progressifs :** Tester chaque étape avant de continuer

---

## Extensions possibles

**Améliorations du jeu :**

- Interface colorée (codes ANSI)
- Validation robuste des entrées
- Option pour rejouer
- Compteur de scores
- Grille personnalisable
- Intelligence artificielle
- Sauvegarde de partie
- Historique des coups

**Choisissez ce qui vous intéresse !**

---

## Récapitulatif des étapes

1. **Affichage** : Grille vide avec boucles imbriquées
2. **Placement** : Gravité et validation
3. **Alternance** : Tour par tour
4. **Horizontale** : Première détection de victoire
5. **Verticale + Diagonales** : Détections complètes
6. **Jeu complet** : Boucle avec toutes les vérifications

**Chaque étape construit sur la précédente**

---

## Concepts mobilisés

- **Tableaux 2D** : Représentation de la grille
- **Boucles imbriquées** : Parcours et affichage
- **Fonctions** : Organisation et réutilisabilité
- **Conditions** : Validation et détection
- **Scanner** : Interaction utilisatrice
- **Booléens** : Logique de contrôle
- **Constantes** : Configuration du jeu

**Un projet de synthèse complet !**

---

<!-- _class: lead -->

## À vous de jouer !

Développez votre propre Puissance 4 étape par étape.

Consultez les exemples de code et réalisez les exercices.

**Conseils :**

- Testez chaque étape avant de passer à la suivante
- Utilisez le débogueur pour comprendre
- N'hésitez pas à adapter et améliorer

---

<!-- _class: lead -->

## Questions ?

---

<!-- _class: lead -->

## Sources

- Documentation Java : https://docs.oracle.com/en/java/javase/17/docs/api/
- Règles du Puissance 4 : https://fr.wikipedia.org/wiki/Puissance_4
