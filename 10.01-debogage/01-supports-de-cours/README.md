# Débogage - Supports de cours

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/10.01-debogage/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/10.01-debogage/01-supports-de-cours/10.01-debogage-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/)
- Exercices : [Lien vers le contenu](../03-exercices/README.md)

---

## Table des matières

- [Introduction au débogage](#introduction-au-débogage)
- [Partie 1 : Concepts généraux de débogage](#partie-1--concepts-généraux-de-débogage)
  - [Qu'est-ce qu'un bug ?](#quest-ce-quun-bug-)
  - [Types d'erreurs](#types-derreurs)
  - [Démarche méthodique de débogage](#démarche-méthodique-de-débogage)
  - [Techniques de débogage de base](#techniques-de-débogage-de-base)
- [Partie 2 : Débogage avec VS Code](#partie-2--débogage-avec-vs-code)
  - [Interface du débogueur](#interface-du-débogueur)
  - [Démarrer une session de débogage](#démarrer-une-session-de-débogage)
  - [Points d'arrêt (Breakpoints)](#points-darrêt-breakpoints)
  - [Actions de débogage](#actions-de-débogage)
  - [Inspection des données](#inspection-des-données)
  - [Console de débogage](#console-de-débogage)
- [Bugs courants et comment les éviter](#bugs-courants-et-comment-les-éviter)
- [Bonnes pratiques](#bonnes-pratiques)

---

## Introduction au débogage

Le **débogage** (debugging en anglais) est le processus qui consiste à
identifier, analyser et corriger les erreurs (bugs) dans un programme.

C'est une compétence essentielle pour tout développeur, car :

- **Personne n'écrit du code parfait du premier coup** : même les développeurs
  expérimentés font des erreurs.
- **Comprendre les bugs aide à mieux programmer** : en analysant pourquoi un bug
  s'est produit, on apprend à l'éviter à l'avenir.
- **Le débogage prend du temps** : on estime que 50 à 75 % du temps de
  développement est consacré au débogage et aux tests.

> _"Si le débogage est l'art de retirer les bugs, alors la programmation doit
> être l'art de les créer."_ — Edsger W. Dijkstra

---

## Partie 1 : Concepts généraux de débogage

Cette première partie couvre les concepts fondamentaux du débogage, applicables
quel que soit le langage ou l'outil utilisé.

### Qu'est-ce qu'un bug ?

Un **bug** est un défaut dans un programme qui cause un comportement inattendu
ou incorrect.

**Origines du terme** : Le terme "bug" (insecte en anglais) vient d'un incident
historique en 1947 où une vraie mite (moth) s'était coincée dans un ordinateur
et causait des dysfonctionnements.

### Types d'erreurs

Il existe trois grandes catégories d'erreurs :

#### 1. Erreurs de compilation (Compile-time errors)

**Définition** : Erreurs détectées par le compilateur avant l'exécution du
programme.

**Caractéristiques** :

- Empêchent la compilation du code.
- Sont détectées automatiquement par l'IDE ou le compilateur.
- Relativement faciles à corriger (le compilateur indique le problème).

**Exemples** :

```java
// Erreur de syntaxe : point-virgule manquant
int x = 5

// Erreur de type : affectation incompatible
int number = "hello";

// Variable non déclarée
result = x + y; // 'result' n'est pas déclaré
```

**Comment les corriger** :

- Lire le message d'erreur du compilateur.
- Localiser la ligne indiquée.
- Corriger la syntaxe ou le type de données.

---

#### 2. Erreurs d'exécution (Runtime errors)

**Définition** : Erreurs qui surviennent pendant l'exécution du programme.

**Caractéristiques** :

- Le code compile correctement.
- Le programme plante (crash) pendant son exécution.
- Provoquent des **exceptions** en Java.

**Exemples** :

```java
// Division par zéro
int result = 10 / 0; // ArithmeticException

// Accès à un indice invalide
int[] numbers = {1, 2, 3};
int x = numbers[5]; // ArrayIndexOutOfBoundsException

// Référence null
String text = null;
int length = text.length(); // NullPointerException
```

**Comment les corriger** :

- Lire le message d'exception (type et ligne).
- Ajouter des vérifications (conditions) avant les opérations risquées.
- Utiliser des blocs `try-catch` pour gérer les exceptions.

---

#### 3. Erreurs logiques (Logic errors)

**Définition** : Le programme compile et s'exécute sans planter, mais produit un
résultat incorrect.

**Caractéristiques** :

- **Les plus difficiles à détecter** : aucun message d'erreur.
- Le programme fait quelque chose, mais pas ce qu'on veut.
- Nécessitent une analyse approfondie du code et de la logique.

**Exemples** :

```java
// Erreur de condition
if (age >= 18) {
    System.out.println("Vous êtes mineur");
} else {
    System.out.println("Vous êtes majeur");
}
// Les messages sont inversés !

// Erreur de calcul
double average = (a + b + c) / 3; // Division entière si a, b, c sont int !

// Boucle incorrecte
for (int i = 0; i <= array.length; i++) { // <= au lieu de <
    System.out.println(array[i]); // Dépassement d'indice
}
```

**Comment les corriger** :

- Utiliser des techniques de débogage pour inspecter l'état du programme.
- Vérifier la logique étape par étape.
- Comparer les résultats attendus avec les résultats obtenus.

---

### Démarche méthodique de débogage

Face à un bug, il est important de suivre une démarche structurée plutôt que de
modifier le code au hasard. Voici une méthode efficace :

#### 1. Reproduire le bug

**Objectif** : Comprendre dans quelles conditions le bug se produit.

- Identifier les étapes pour reproduire le problème.
- Noter les entrées qui causent l'erreur.
- Vérifier si le bug se produit toujours ou seulement dans certains cas.

**Exemple** : "Le programme plante quand j'entre un nombre négatif."

---

#### 2. Localiser le bug

**Objectif** : Trouver la partie du code responsable du problème.

**Techniques** :

- **Lire le message d'erreur** : Il indique souvent la ligne problématique.
- **Diviser pour régner** : Isoler des portions de code pour identifier la zone
  du bug.
- **Remonter l'exécution** : Partir de l'endroit où l'erreur se manifeste et
  remonter dans le code.

---

#### 3. Comprendre le bug

**Objectif** : Analyser pourquoi le bug se produit.

- **Examiner les valeurs des variables** à l'endroit du bug.
- **Vérifier les conditions** : Sont-elles correctes ?
- **Analyser la logique** : Le code fait-il vraiment ce qu'on pense ?

**Questions à se poser** :

- Quelle est la valeur de cette variable à ce moment-là ?
- Cette condition est-elle vraie ou fausse ?
- Cette boucle s'arrête-t-elle au bon moment ?

---

#### 4. Formuler une hypothèse

**Objectif** : Émettre une hypothèse sur la cause du bug.

**Exemple** : "Je pense que la variable `index` dépasse la taille du tableau
parce que la boucle utilise `<=` au lieu de `<`."

---

#### 5. Tester l'hypothèse

**Objectif** : Vérifier si l'hypothèse est correcte.

**Techniques** :

- Ajouter des affichages (traces) pour vérifier les valeurs.
- Utiliser un débogueur pour inspecter l'état du programme.
- Modifier temporairement le code pour isoler le problème.

---

#### 6. Corriger le bug

**Objectif** : Appliquer la correction.

- Modifier le code pour résoudre le problème.
- **Ne corriger qu'une chose à la fois** : ne pas faire plusieurs changements
  simultanés.

---

#### 7. Vérifier la correction

**Objectif** : S'assurer que le bug est corrigé et qu'aucun nouveau bug n'a été
introduit.

- Tester le programme avec les mêmes entrées qui causaient le bug.
- Tester avec d'autres cas pour vérifier que rien n'est cassé.

---

### Techniques de débogage de base

Avant même d'utiliser un débogueur, plusieurs techniques simples permettent
d'identifier les bugs.

#### 1. Lecture attentive du code

**Description** : Relire le code ligne par ligne pour repérer les erreurs
évidentes.

**Quand l'utiliser** :

- Pour les erreurs de syntaxe ou de logique simples.
- Avant d'utiliser des outils plus complexes.

**Conseils** :

- Lire le code à voix haute ou l'expliquer à une personne (rubber duck
  debugging).
- Vérifier les noms de variables (fautes de frappe).
- Vérifier les opérateurs (`==` vs `=`, `&&` vs `||`).

---

#### 2. Ajout de traces (print statements)

**Description** : Ajouter des `System.out.println()` pour afficher les valeurs
des variables.

**Quand l'utiliser** :

- Pour vérifier qu'une portion de code est exécutée.
- Pour afficher les valeurs des variables à différents moments.

**Exemple** :

```java
public static int calculateSum(int[] numbers) {
    int sum = 0;

    System.out.println("Début du calcul, tableau : " + Arrays.toString(numbers));

    for (int i = 0; i < numbers.length; i++) {
        sum += numbers[i];
        System.out.println("i = " + i + ", sum = " + sum);
    }

    System.out.println("Somme finale : " + sum);
    return sum;
}
```

**Avantages** :

- Simple et rapide.
- Pas besoin d'outils spéciaux.

**Inconvénients** :

- Encombre le code et la sortie.
- Il faut penser à retirer les traces après.
- Pas adapté pour des bugs complexes.

---

#### 3. Simplification du code

**Description** : Simplifier ou décomposer le code pour isoler le problème.

**Techniques** :

- **Commenter des parties du code** pour voir si le bug persiste.
- **Diviser les expressions complexes** en plusieurs lignes.
- **Extraire du code en méthodes** pour tester séparément.

**Exemple** :

```java
// Complexe (difficile à déboguer)
if ((age >= 18 && hasLicense) || (age >= 16 && hasParentalConsent)) {
    // ...
}

// Simplifié
boolean isAdult = age >= 18 && hasLicense;
boolean isMinorWithConsent = age >= 16 && hasParentalConsent;

if (isAdult || isMinorWithConsent) {
    // ...
}
```

---

#### 4. Vérification des cas limites

**Description** : Tester le programme avec des valeurs extrêmes ou
inhabituelles.

**Cas à tester** :

- Valeurs nulles ou vides (tableaux vides, chaînes vides).
- Valeurs négatives (si applicables).
- Valeurs très grandes ou très petites.
- Cas limites (premier/dernier élément d'un tableau).

**Exemple** :

```java
int[] empty = {};
int[] single = {5};
int[] negative = {-1, -2, -3};
```

---

## Partie 2 : Débogage avec VS Code

Maintenant que nous avons vu les concepts généraux, explorons comment utiliser
un débogueur professionnel : celui de **Visual Studio Code**.

Un débogueur permet d'exécuter le programme **pas à pas**, d'inspecter les
variables, et de contrôler précisément l'exécution.

### Interface du débogueur

VS Code offre une interface complète pour le débogage :

#### Composants principaux

1. **Vue Run and Debug** : Panneau latéral qui affiche toutes les informations
   de débogage (variables, pile d'appels, points d'arrêt).

2. **Barre d'outils de débogage** : Boutons pour contrôler l'exécution
   (continue, step over, step into, etc.).

3. **Console de débogage** : Permet d'afficher les sorties et d'évaluer des
   expressions pendant le débogage.

4. **Sidebar de débogage** : Affiche la pile d'appels (call stack), les
   variables, les expressions surveillées (watch).

5. **Menu Run** : Contient les commandes de débogage les plus courantes.

---

### Démarrer une session de débogage

#### Prérequis

1. **Installer l'extension Java** : VS Code nécessite l'extension "Extension
   Pack for Java" pour déboguer du code Java.

2. **Ouvrir le fichier à déboguer**.

#### Méthode simple (sans configuration)

1. Ouvrir le fichier Java contenant la méthode `main`.
2. Appuyer sur **F5** ou cliquer sur "Run and Debug" dans la vue latérale.
3. Sélectionner "Java" comme débogueur.

VS Code lance automatiquement le programme en mode débogage.

#### Méthode avancée (avec launch.json)

Pour des projets plus complexes, on peut créer un fichier `launch.json` pour
configurer le débogage.

**Étapes** :

1. Ouvrir la vue "Run and Debug".
2. Cliquer sur "create a launch.json file".
3. Sélectionner "Java".

VS Code génère un fichier `.vscode/launch.json` avec une configuration par
défaut.

---

### Points d'arrêt (Breakpoints)

Un **point d'arrêt** (breakpoint) est un marqueur qui indique au débogueur de
**mettre en pause** l'exécution du programme à une ligne spécifique.

#### Placer un point d'arrêt

**Méthode 1** : Cliquer dans la **marge gauche** (à gauche des numéros de ligne)
de l'éditeur.

**Méthode 2** : Placer le curseur sur une ligne et appuyer sur **F9**.

**Apparence** : Un cercle rouge apparaît dans la marge.

#### Retirer un point d'arrêt

- Cliquer à nouveau sur le cercle rouge.
- Ou appuyer sur **F9** avec le curseur sur la ligne.

#### Gérer les points d'arrêt

La section **BREAKPOINTS** dans la vue "Run and Debug" liste tous les points
d'arrêt actifs. On peut :

- **Activer/désactiver** un point d'arrêt (case à cocher).
- **Supprimer** un ou tous les points d'arrêt.

---

#### Types de points d'arrêt

##### 1. Point d'arrêt simple

S'arrête à chaque fois que la ligne est atteinte.

##### 2. Point d'arrêt conditionnel (Conditional Breakpoint)

S'arrête uniquement si une condition est vraie.

**Utilisation** :

1. Clic droit dans la marge → "Add Conditional Breakpoint".
2. Choisir "Expression".
3. Entrer une condition, par exemple : `i == 5` ou `sum > 100`.

**Exemple d'utilisation** : Arrêter une boucle seulement quand `i` vaut 10.

##### 3. Point d'arrêt avec compteur (Hit Count Breakpoint)

S'arrête après un certain nombre de passages.

**Exemple** : Arrêter après le 50ème passage dans une boucle.

##### 4. Logpoint

Affiche un message dans la console sans arrêter l'exécution.

**Utilisation** :

1. Clic droit dans la marge → "Add Logpoint".
2. Entrer un message, par exemple : `La valeur de i est {i}`.

**Avantage** : Équivalent à un `System.out.println()` sans modifier le code.

---

### Actions de débogage

Une fois le programme en pause sur un point d'arrêt, on peut contrôler
l'exécution avec les **actions de débogage**.

#### Barre d'outils de débogage

La barre d'outils flottante contient les boutons suivants :

| Icône | Action        | Raccourci         | Description                                        |
| ----- | ------------- | ----------------- | -------------------------------------------------- |
| ▶️    | **Continue**  | **F5**            | Reprendre l'exécution jusqu'au prochain breakpoint |
| ⏸️    | **Pause**     | **F6**            | Mettre en pause l'exécution                        |
| ⤵️    | **Step Over** | **F10**           | Exécuter la ligne actuelle et passer à la suivante |
| ⬇️    | **Step Into** | **F11**           | Entrer dans la méthode appelée                     |
| ⬆️    | **Step Out**  | **Shift+F11**     | Sortir de la méthode actuelle                      |
| 🔄    | **Restart**   | **Ctrl+Shift+F5** | Redémarrer le programme                            |
| ⏹️    | **Stop**      | **Shift+F5**      | Arrêter le débogage                                |

---

#### 1. Continue (F5)

**Description** : Reprend l'exécution normale jusqu'au prochain point d'arrêt ou
jusqu'à la fin du programme.

**Quand l'utiliser** : Quand on a fini d'inspecter une section et qu'on veut
aller au prochain point d'arrêt.

---

#### 2. Step Over (F10)

**Description** : Exécute la ligne actuelle **sans entrer** dans les méthodes
appelées.

**Exemple** :

```java
int x = 5;               // <- On est ici
int y = calculate(x);    // Step Over : exécute calculate() sans y entrer
System.out.println(y);
```

Après Step Over, on passe directement à `System.out.println(y)`.

**Quand l'utiliser** : Quand on veut avancer ligne par ligne sans descendre dans
les détails des méthodes.

---

#### 3. Step Into (F11)

**Description** : Entre dans la méthode appelée pour la déboguer ligne par
ligne.

**Exemple** :

```java
int y = calculate(x);    // <- On est ici
```

Après Step Into, on entre dans la méthode `calculate()` :

```java
public static int calculate(int n) {
    int result = n * 2;  // <- On arrive ici
    return result;
}
```

**Quand l'utiliser** : Quand on veut analyser en détail ce qui se passe dans une
méthode.

---

#### 4. Step Out (Shift+F11)

**Description** : Sort de la méthode actuelle et retourne à l'appelant.

**Exemple** :

```java
public static int calculate(int n) {
    int result = n * 2;  // <- On est ici dans calculate()
    return result;       // Step Out : revient à l'appelant
}

// Appelant
int y = calculate(x);    // <- On revient ici après Step Out
```

**Quand l'utiliser** : Quand on s'est trompé en faisant Step Into ou qu'on veut
sortir rapidement d'une méthode.

---

### Inspection des données

Pendant le débogage, on peut inspecter l'état du programme : valeurs des
variables, expressions, pile d'appels.

#### 1. Section VARIABLES

La section **VARIABLES** dans la vue "Run and Debug" affiche toutes les
variables **locales** et leurs valeurs au point d'arrêt actuel.

**Fonctionnalités** :

- **Voir les valeurs** : Toutes les variables de la portée actuelle.
- **Développer les objets** : Voir les champs d'un objet ou les éléments d'un
  tableau.
- **Modifier une valeur** : Clic droit sur une variable → "Set Value" (F2).

**Exemple** :

```text
Variables
  Local
    i = 5
    sum = 15
    numbers = int[10] {...}
```

---

#### 2. Section WATCH

La section **WATCH** permet de surveiller des **expressions** spécifiques.

**Utilisation** :

1. Cliquer sur le `+` dans la section WATCH.
2. Entrer une expression, par exemple : `i * 2`, `sum / numbers.length`.

L'expression est évaluée à chaque arrêt, et sa valeur est affichée.

**Quand l'utiliser** : Pour surveiller des calculs ou des expressions complexes
sans les ajouter au code.

---

#### 3. Section CALL STACK (Pile d'appels)

La **pile d'appels** (call stack) montre la séquence des méthodes appelées pour
arriver au point actuel.

**Exemple** :

```text
Call Stack
  main:10
  calculate:25
  helper:42  <- Ligne actuelle
```

**Lecture** : Le programme est actuellement dans `helper` (ligne 42), appelé
depuis `calculate` (ligne 25), appelé depuis `main` (ligne 10).

**Utilité** : Comprendre le chemin d'exécution et remonter dans les appels.

---

#### 4. Survol des variables (Hover)

Pendant le débogage, on peut **survoler** une variable dans l'éditeur avec la
souris pour voir sa valeur instantanément.

**Avantage** : Rapide et pratique pour vérifier une valeur sans chercher dans la
section VARIABLES.

---

### Console de débogage

La **console de débogage** (Debug Console) permet d'évaluer des expressions et
d'exécuter du code pendant une session de débogage.

#### Accès

- Vue : "View" → "Debug Console".
- Raccourci : **Ctrl+Shift+Y**.

#### Utilisation

Pendant que le programme est en pause sur un breakpoint, on peut :

- **Évaluer des expressions** : Taper `i + 5` et appuyer sur Enter.
- **Appeler des méthodes** : Taper `Math.sqrt(16)`.
- **Modifier des variables** : Possible avec certaines limitations.

**Exemple** :

```text
> i
5
> i * 2
10
> numbers.length
10
```

**Avantage** : Permet d'expérimenter sans modifier le code.

---

## Bugs courants et comment les éviter

Voici une liste des bugs les plus fréquents en Java et comment les détecter avec
le débogueur.

### 1. Dépassement d'indice (ArrayIndexOutOfBoundsException)

**Cause** : Accès à un indice inexistant d'un tableau.

**Exemple** :

```java
int[] numbers = {1, 2, 3};
for (int i = 0; i <= numbers.length; i++) { // <= au lieu de <
    System.out.println(numbers[i]);
}
```

**Débogage** :

- Placer un breakpoint dans la boucle.
- Surveiller la valeur de `i` et comparer avec `numbers.length`.
- Identifier que `i` atteint 3 alors que l'indice maximum est 2.

**Correction** : Utiliser `i < numbers.length` au lieu de `i <= numbers.length`.

---

### 2. NullPointerException

**Cause** : Tentative d'utiliser un objet qui est `null`.

**Exemple** :

```java
String text = null;
int length = text.length(); // NullPointerException
```

**Débogage** :

- Placer un breakpoint avant l'appel.
- Inspecter la valeur de `text` (doit être `null`).
- Remonter dans le code pour comprendre pourquoi `text` est `null`.

**Correction** : Vérifier si l'objet est `null` avant de l'utiliser :

```java
if (text != null) {
    int length = text.length();
}
```

---

### 3. Boucle infinie

**Cause** : Condition de sortie de boucle jamais atteinte.

**Exemple** :

```java
int i = 0;
while (i < 10) {
    System.out.println(i);
    // Oubli de i++
}
```

**Débogage** :

- Placer un breakpoint dans la boucle.
- Faire plusieurs Step Over et observer que `i` ne change jamais.

**Correction** : Ajouter `i++` dans la boucle.

---

### 4. Condition incorrecte

**Cause** : Utilisation d'un opérateur incorrect ou condition inversée.

**Exemple** :

```java
if (age >= 18) {
    System.out.println("Vous êtes mineur");
} else {
    System.out.println("Vous êtes majeur");
}
```

**Débogage** :

- Placer un breakpoint avant le `if`.
- Inspecter la valeur de `age`.
- Vérifier quelle branche est exécutée et constater l'inversion.

**Correction** : Inverser les messages ou changer la condition.

---

### 5. Division entière inattendue

**Cause** : Division entre deux entiers qui produit un entier au lieu d'un
nombre à virgule.

**Exemple** :

```java
int a = 5;
int b = 2;
double result = a / b; // result = 2.0 au lieu de 2.5
```

**Débogage** :

- Placer un breakpoint après le calcul.
- Inspecter `result` et constater qu'il vaut `2.0`.
- Réaliser que la division est entière avant d'être convertie en `double`.

**Correction** : Caster au moins un opérande en `double` :

```java
double result = (double) a / b; // result = 2.5
```

---

## Bonnes pratiques

### 1. Utiliser le débogueur plutôt que des `println`

- Le débogueur est plus puissant et plus propre.
- Pas besoin de modifier le code ni de retirer les traces après.

### 2. Placer des breakpoints stratégiques

- Au début et à la fin des méthodes importantes.
- Dans les boucles (pour vérifier les itérations).
- Avant les opérations risquées (divisions, accès aux tableaux).

### 3. Utiliser les points d'arrêt conditionnels

- Pour s'arrêter uniquement dans certains cas sans avoir à faire Continue
  plusieurs fois.

### 4. Surveiller les expressions clés avec WATCH

- Plutôt que de recalculer mentalement des valeurs, laisser le débogueur le
  faire.

### 5. Vérifier la pile d'appels (Call Stack)

- Utile pour comprendre comment on est arrivé à un certain point.
- Permet de remonter dans les appels pour voir les valeurs des variables à
  différents niveaux.

### 6. Prendre le temps de comprendre

- Ne pas se précipiter pour corriger : prendre le temps d'analyser le bug en
  profondeur.
- Formuler une hypothèse avant de modifier le code.

### 7. Tester après correction

- Toujours vérifier que la correction fonctionne.
- Tester avec différents cas (y compris les cas limites).

---

## Ressources supplémentaires

- [Documentation officielle VS Code : Debugging](https://code.visualstudio.com/docs/debugtest/debugging)
- [Extension Java pour VS Code](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

---

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
