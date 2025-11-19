# Projet guidé - Puissance 4 - Supports de cours

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/12.01-projet-puissance-4/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/12.01-projet-puissance-4/01-supports-de-cours/12.01-projet-puissance-4-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/)
- Exercices : [Lien vers le contenu](../03-exercices/README.md)

## Table des matières

- [Ressources annexes](#ressources-annexes)
- [Table des matières](#table-des-matières)
- [Objectifs](#objectifs)
- [Introduction](#introduction)
- [Le jeu Puissance 4](#le-jeu-puissance-4)
  - [Règles du jeu](#règles-du-jeu)
  - [Représentation de la grille](#représentation-de-la-grille)
- [Décomposition du problème](#décomposition-du-problème)
  - [Analyse des fonctionnalités](#analyse-des-fonctionnalités)
  - [Approche progressive](#approche-progressive)
- [Étape 1 : Affichage de la grille](#étape-1--affichage-de-la-grille)
  - [Objectif](#objectif)
  - [Concepts utilisés](#concepts-utilisés)
  - [Stratégie d'implémentation](#stratégie-dimplémentation)
- [Étape 2 : Placement d'un pion](#étape-2--placement-dun-pion)
  - [Objectif](#objectif-1)
  - [Concepts utilisés](#concepts-utilisés-1)
  - [Stratégie d'implémentation](#stratégie-dimplémentation-1)
  - [La gravité](#la-gravité)
- [Étape 3 : Alternance des joueuses](#étape-3--alternance-des-joueurs)
  - [Objectif](#objectif-2)
  - [Concepts utilisés](#concepts-utilisés-2)
  - [Stratégie d'implémentation](#stratégie-dimplémentation-2)
- [Étape 4 : Détection de victoire horizontale](#étape-4--détection-de-victoire-horizontale)
  - [Objectif](#objectif-3)
  - [Concepts utilisés](#concepts-utilisés-3)
  - [Stratégie d'implémentation](#stratégie-dimplémentation-3)
  - [Algorithme de détection](#algorithme-de-détection)
- [Étape 5 : Détection de victoire verticale et diagonale](#étape-5--détection-de-victoire-verticale-et-diagonale)
  - [Objectif](#objectif-4)
  - [Concepts utilisés](#concepts-utilisés-4)
  - [Stratégie d'implémentation](#stratégie-dimplémentation-4)
  - [Les diagonales](#les-diagonales)
- [Étape 6 : Jeu complet](#étape-6--jeu-complet)
  - [Objectif](#objectif-5)
  - [Fonctionnalités finales](#fonctionnalités-finales)
  - [Structure du programme](#structure-du-programme)
- [Bonnes pratiques appliquées](#bonnes-pratiques-appliquées)
  - [Organisation du code](#organisation-du-code)
  - [Nommage](#nommage)
  - [Commentaires](#commentaires)
  - [Tests progressifs](#tests-progressifs)
- [Extensions possibles](#extensions-possibles)
- [Conclusion](#conclusion)
- [Exemples de code](#exemples-de-code)
- [Exercices](#exercices)

## Objectifs

À l'issue de ce cours, la personne qui étudie sera capable de :

- Analyser un problème complexe et le décomposer en étapes réalisables.
- Concevoir une architecture logicielle pour un projet complet.
- Utiliser des tableaux multidimensionnels pour représenter une grille de jeu.
- Implémenter des algorithmes de parcours et de détection de motifs.
- Organiser son code en fonctions réutilisables et bien nommées.
- Développer une application interactive en mode console.
- Tester et déboguer un programme étape par étape.
- Appliquer les bonnes pratiques de programmation dans un contexte réel.

## Introduction

Nous avons exploré de nombreux concepts de programmation : variables,
conditions, boucles, fonctions, tableaux. Il est maintenant temps de mettre
toutes ces connaissances en pratique dans un projet complet et concret.

Le Puissance 4 est un jeu idéal pour cela : ses règles sont simples à
comprendre, mais son implémentation demande de combiner intelligemment tous les
concepts vus en cours. Ce projet nous permettra de vivre l'expérience complète
du développement logiciel, de la conception initiale à l'application
fonctionnelle.

## Le jeu Puissance 4

### Règles du jeu

Le Puissance 4 est un jeu de stratégie pour deux joueurs qui se joue sur une
grille verticale de 6 lignes et 7 colonnes. Les règles sont simples :

1. Deux joueurs s'affrontent : l'un joue avec les pions rouges (symbolisés par
   'X'), l'autre avec les pions jaunes (symbolisés par 'O').

2. Les joueurs jouent à tour de rôle en choisissant une colonne où faire tomber
   leur pion.

3. Le pion tombe jusqu'à la position la plus basse disponible dans la colonne
   choisie (effet de gravité).

4. Le premier joueur qui aligne quatre de ses pions (horizontalement,
   verticalement ou en diagonale) gagne la partie.

5. Si la grille est complètement remplie sans qu'aucun joueur n'ait aligné
   quatre pions, la partie se termine par un match nul.

Exemple de grille en cours de partie :

```text
| | | | | | | |
| | | | | | | |
| | |O| | | | |
| |X|O| | | | |
| |X|X|O| | | |
|X|O|X|O|X| | |
 1 2 3 4 5 6 7
```

Dans cet exemple, le joueur O (jaune) a gagné avec une diagonale.

### Représentation de la grille

En programmation, nous représenterons la grille avec un tableau à deux
dimensions de caractères :

```java
char[][] grid = new char[6][7];
```

- **6 lignes** (hauteur) : index de 0 à 5
- **7 colonnes** (largeur) : index de 0 à 6

Chaque case peut contenir :

- `' '` (espace) : case vide
- `'X'` : pion de la joueuse 1 (rouge)
- `'O'` : pion de la joueuse 2 (jaune)

## Décomposition du problème

### Analyse des fonctionnalités

Avant de commencer à coder, analysons ce dont notre programme a besoin :

1. **Affichage** : Montrer la grille de jeu de façon claire et lisible.

2. **Placement** : Permettre à un joueur de choisir une colonne et placer son
   pion en respectant la gravité.

3. **Alternance** : Gérer le tour des joueuses (X puis O puis X...).

4. **Détection de victoire** : Vérifier après chaque coup si un joueur a aligné
   4 pions (horizontalement, verticalement, diagonalement).

5. **Détection de match nul** : Vérifier si la grille est pleine.

6. **Boucle de jeu** : Répéter le cycle (affichage, placement, vérification)
   jusqu'à la fin de la partie.

### Approche progressive

Plutôt que de tout implémenter d'un coup (ce qui est source d'erreurs et de
confusion), nous allons procéder étape par étape. Chaque étape ajoutera une
nouvelle fonctionnalité au programme précédent.

Cette approche s'appelle le **développement incrémental** et présente plusieurs
avantages :

- On peut tester chaque fonctionnalité séparément.
- On comprend mieux le code en le construisant progressivement.
- On peut identifier et corriger les bugs plus facilement.
- On a le sentiment de progresser régulièrement.

## Étape 1 : Affichage de la grille

### Objectif

Créer et afficher une grille vide de Puissance 4.

### Concepts utilisés

- Tableaux à deux dimensions
- Boucles imbriquées
- Caractères et chaînes de caractères

### Stratégie d'implémentation

Pour afficher la grille, nous avons besoin de :

1. **Créer le tableau** : Un tableau 2D de 6 lignes et 7 colonnes.

2. **Initialiser les cases** : Remplir toutes les cases avec le caractère espace
   `' '`.

3. **Afficher ligne par ligne** : Parcourir le tableau avec une boucle et
   afficher chaque case avec des séparateurs visuels.

Exemple de fonction d'affichage :

```java
public static void displayGrid(char[][] grid) {
    for (int row = 0; row < grid.length; row++) {
        System.out.print("|");
        for (int col = 0; col < grid[row].length; col++) {
            System.out.print(grid[row][col] + "|");
        }
        System.out.println();
    }
    // Affichage des numéros de colonnes
    System.out.println(" 1 2 3 4 5 6 7");
}
```

**Points d'attention :**

- Les boucles imbriquées : la boucle externe parcourt les lignes, la boucle
  interne parcourt les colonnes.
- L'affichage commence par la ligne du haut (index 0) et descend.
- Les numéros de colonnes facilitent le choix de la joueuse (numérotation de 1 à
  7 pour l'utilisatrice, mais indices de 0 à 6 dans le tableau).

## Étape 2 : Placement d'un pion

### Objectif

Permettre de placer un pion dans une colonne en respectant la gravité.

### Concepts utilisés

- Entrée utilisatrice avec `Scanner`
- Validation des données
- Parcours de tableau et modification

### Stratégie d'implémentation

Pour placer un pion, nous devons :

1. **Demander la colonne** : Lire l'entrée utilisatrice.

2. **Valider l'entrée** :

   - La colonne doit être entre 1 et 7.
   - La colonne ne doit pas être pleine.

3. **Trouver la ligne la plus basse disponible** : Parcourir la colonne de bas
   en haut.

4. **Placer le pion** : Modifier la case correspondante.

### La gravité

La gravité est un concept clé du Puissance 4. Lorsqu'un joueur choisit une
colonne, le pion tombe jusqu'à la position la plus basse disponible.

Algorithme pour trouver la ligne :

```java
public static int findLowestRow(char[][] grid, int col) {
    // Parcourir de bas en haut
    for (int row = grid.length - 1; row >= 0; row--) {
        if (grid[row][col] == ' ') {
            return row;  // Case vide trouvée
        }
    }
    return -1;  // Colonne pleine
}
```

**Points d'attention :**

- On commence par `grid.length - 1` (dernière ligne) et on remonte avec `row--`.
- Si on ne trouve aucune case vide, on retourne -1 pour indiquer que la colonne
  est pleine.
- Ne pas oublier de convertir la colonne utilisatrice (1-7) en index tableau
  (0-6).

## Étape 3 : Alternance des joueuses

### Objectif

Mettre en place le système de tour par tour entre deux joueurs.

### Concepts utilisés

- Variables de contrôle
- Structures conditionnelles
- Boucles de jeu

### Stratégie d'implémentation

Pour gérer l'alternance, nous avons plusieurs approches possibles :

**Approche 1 : Variable de joueur courant**

```java
char currentPlayer = 'X';  // Commence par X

// Après chaque coup :
if (currentPlayer == 'X') {
    currentPlayer = 'O';
} else {
    currentPlayer = 'X';
}
```

**Approche 2 : Opérateur ternaire**

```java
currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
```

**Points d'attention :**

- Le joueur X commence toujours.
- L'alternance ne se fait qu'après un coup valide (pas si la colonne est
  pleine).
- On peut afficher le symbole de la joueuse actuel pour clarifier qui doit
  jouer.

## Étape 4 : Détection de victoire horizontale

### Objectif

Détecter si un joueur a aligné 4 pions horizontalement.

### Concepts utilisés

- Parcours de tableau avec fenêtre glissante
- Comptage et comparaison
- Conditions logiques

### Stratégie d'implémentation

Pour détecter une victoire horizontale, nous devons vérifier chaque ligne et
chercher 4 pions consécutifs du même joueur.

### Algorithme de détection

L'idée est de parcourir chaque ligne et, pour chaque position, vérifier si les 4
cases suivantes contiennent le même symbole.

```java
public static boolean checkHorizontalWin(char[][] grid, char player) {
    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col <= grid[row].length - 4; col++) {
            // Vérifier 4 cases consécutives
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

**Points d'attention :**

- On s'arrête à `col <= grid[row].length - 4` car on a besoin de 4 cases.
- Si la colonne courante est 5, on peut vérifier les colonnes 5, 6, 7 et 8. Mais
  comme on n'a que 7 colonnes (indices 0-6), on s'arrête à la colonne 3 (qui
  permet de vérifier 3, 4, 5, 6).
- On vérifie uniquement le joueur spécifié en paramètre.

## Étape 5 : Détection de victoire verticale et diagonale

### Objectif

Compléter la détection de victoire avec les alignements verticaux et diagonaux.

### Concepts utilisés

- Parcours de tableau dans différentes directions
- Gestion des limites du tableau
- Algorithmes de détection de motifs

### Stratégie d'implémentation

**Détection verticale :**

Similaire à l'horizontale, mais on parcourt les colonnes de haut en bas.

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

### Les diagonales

Les diagonales sont plus complexes car elles nécessitent de se déplacer dans
deux directions simultanément.

**Diagonale descendante (↘)** :

```java
// De haut-gauche vers bas-droite
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
```

**Diagonale montante (↗)** :

```java
// De bas-gauche vers haut-droite
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
```

**Points d'attention :**

- Pour les diagonales descendantes, on commence à `row = 0`.
- Pour les diagonales montantes, on commence à `row = 3` (car on doit pouvoir
  remonter de 3 cases).
- Les limites de colonnes sont les mêmes pour les deux types de diagonales.

## Étape 6 : Jeu complet

### Objectif

Assembler toutes les fonctionnalités pour créer un jeu jouable.

### Fonctionnalités finales

Le programme complet doit :

1. Initialiser une grille vide
2. Afficher la grille
3. Demander au joueur courant de choisir une colonne
4. Valider et placer le pion
5. Vérifier s'il y a victoire (horizontale, verticale, diagonale)
6. Vérifier s'il y a match nul (grille pleine)
7. Alterner les joueurs
8. Répéter jusqu'à la fin de la partie
9. Afficher le résultat final

### Structure du programme

Organisation typique :

```java
public class ConnectFour {
    // Constantes
    public static final int ROWS = 6;
    public static final int COLS = 7;
    public static final char PLAYER1 = 'X';
    public static final char PLAYER2 = 'O';
    public static final char EMPTY = ' ';

    public static void main(String[] args) {
        // Initialisation
        char[][] grid = createGrid();
        char currentPlayer = PLAYER1;
        Scanner scanner = new Scanner(System.in);

        // Boucle de jeu
        while (true) {
            displayGrid(grid);

            // Tour de la joueuse
            int col = getPlayerMove(scanner, grid, currentPlayer);
            int row = placeToken(grid, col, currentPlayer);

            // Vérification victoire
            if (hasWon(grid, currentPlayer)) {
                displayGrid(grid);
                System.out.println("Le joueur " + currentPlayer + " a gagné !");
                break;
            }

            // Vérification match nul
            if (isGridFull(grid)) {
                displayGrid(grid);
                System.out.println("Match nul !");
                break;
            }

            // Alternance
            currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
        }

        scanner.close();
    }

    // Toutes les fonctions auxiliaires...
}
```

## Bonnes pratiques appliquées

### Organisation du code

- **Une fonction, une responsabilité** : Chaque fonction a un rôle précis.
- **Constantes** : Utiliser des constantes pour les valeurs qui ne changent pas
  (dimensions, symboles).
- **Fonctions réutilisables** : Les fonctions peuvent être testées
  indépendamment.

### Nommage

- **Fonctions** : Verbes d'action (`displayGrid`, `placeToken`, `checkWin`).
- **Variables** : Noms descriptifs (`currentPlayer`, `selectedColumn`).
- **Constantes** : Majuscules avec underscore (`ROWS`, `PLAYER1`).

### Commentaires

- Expliquer le "pourquoi", pas le "quoi".
- Documenter les algorithmes complexes.
- Indiquer les préconditions et postconditions des fonctions.

### Tests progressifs

- Tester chaque étape avant de passer à la suivante.
- Utiliser le débogueur pour comprendre le déroulement.
- Vérifier les cas limites (grille pleine, colonnes pleines, etc.).

## Extensions possibles

Une fois le jeu de base fonctionnel, voici quelques améliorations possibles :

1. **Interface améliorée** : Utiliser des couleurs dans la console (codes ANSI).

2. **Validation robuste** : Gérer les erreurs de saisie (lettres au lieu de
   chiffres).

3. **Rejouer** : Proposer de recommencer une partie après la fin.

4. **Scores** : Compter le nombre de victoires de chaque joueur.

5. **Grille personnalisable** : Permettre de choisir les dimensions.

6. **Intelligence artificielle** : Créer un adversaire contrôlé par
   l'ordinateur.

7. **Sauvegarde** : Enregistrer et charger une partie.

8. **Historique des coups** : Afficher les coups joués, permettre l'annulation.

## Conclusion

Le développement d'un jeu Puissance 4 est un excellent exercice de synthèse qui
mobilise tous les concepts fondamentaux de la programmation :

- Les **tableaux 2D** pour représenter la grille.
- Les **boucles imbriquées** pour parcourir et afficher.
- Les **fonctions** pour organiser le code.
- Les **conditions** pour valider et détecter.
- L'**interaction utilisatrice** pour jouer.

Ce projet démontre qu'avec des concepts simples, bien maîtrisés et bien
combinés, on peut créer des applications complètes et fonctionnelles.

L'approche progressive que nous avons suivie est applicable à tout projet de
programmation : décomposer, implémenter par étapes, tester régulièrement, et
améliorer progressivement.

## Exemples de code

Nous vous invitons maintenant à explorer les exemples de code pour découvrir
chaque étape du développement.

Vous trouverez les exemples de code ici :
[Lien vers le contenu](../02-exemples-de-code/).

## Exercices

Nous vous invitons également à réaliser les exercices de cette session pour
renforcer votre compréhension et développer votre propre version du jeu.

Vous trouverez les détails des exercices ici :
[Lien vers le contenu](../03-exercices/README.md).

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
