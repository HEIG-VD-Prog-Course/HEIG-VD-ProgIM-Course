---
marp: true
theme: default
paginate: true
header: "Débogage"
footer: "HEIG-VD - ProgIM1 - V. Guidoux (avec GitHub Copilot)"
---

<style>
@import '../../../.marp/theme.css';
</style>

<!-- _class: title -->

# Débogage

Identifier, analyser et corriger les bugs

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md

---

## Objectifs

À l'issue de ce cours, vous serez capable de :

- Comprendre les différents types d'erreurs (compilation, exécution, logique).
- Appliquer une démarche méthodique pour identifier et corriger les bugs.
- Utiliser un débogueur (VS Code) pour inspecter l'état d'un programme.
- Placer et gérer des points d'arrêt (breakpoints).
- Naviguer dans le code avec les actions de débogage.
- Identifier et corriger les bugs courants.

---

<!-- _class: chapter -->

# Partie 1

## Concepts généraux de débogage

---

## Qu'est-ce qu'un bug ?

Un **bug** est un défaut dans un programme qui cause un comportement inattendu
ou incorrect.

**Origine du terme** : En 1947, une vraie mite (moth) s'est coincée dans un
ordinateur et causait des dysfonctionnements.

> _"Si le débogage est l'art de retirer les bugs, alors la programmation doit
> être l'art de les créer."_ — Edsger W. Dijkstra

**Réalité** : On estime que **50 à 75 % du temps de développement** est consacré
au débogage et aux tests.

---

## Types d'erreurs

Il existe trois grandes catégories d'erreurs :

1. **Erreurs de compilation** (Compile-time errors)
2. **Erreurs d'exécution** (Runtime errors)
3. **Erreurs logiques** (Logic errors)

Comprendre ces types aide à choisir la bonne approche de débogage.

---

## 1. Erreurs de compilation

**Définition** : Erreurs détectées par le compilateur avant l'exécution.

**Caractéristiques** :

- Empêchent la compilation.
- Détectées automatiquement.
- Relativement faciles à corriger.

**Exemples** :

```java
int x = 5  // Manque un point-virgule

int number = "hello";  // Type incompatible

result = x + y;  // Variable non déclarée
```

---

## 2. Erreurs d'exécution

**Définition** : Erreurs qui surviennent pendant l'exécution du programme.

**Caractéristiques** :

- Le code compile correctement.
- Le programme plante (crash) pendant son exécution.
- Provoquent des **exceptions** en Java.

**Exemples** :

```java
int result = 10 / 0;  // ArithmeticException

int[] numbers = {1, 2, 3};
int x = numbers[5];  // ArrayIndexOutOfBoundsException

String text = null;
int length = text.length();  // NullPointerException
```

---

## 3. Erreurs logiques

**Définition** : Le programme fonctionne mais produit un résultat incorrect.

**Caractéristiques** :

- **Les plus difficiles à détecter** : aucun message d'erreur.
- Le programme fait quelque chose, mais pas ce qu'on veut.
- Nécessitent une analyse approfondie.

**Exemples** :

```java
if (age >= 18) {
    System.out.println("Vous êtes mineur");  // Messages inversés !
}

double average = (a + b + c) / 3;  // Division entière si a, b, c sont int

for (int i = 0; i <= array.length; i++) {  // <= au lieu de <
    System.out.println(array[i]);
}
```

---

## Démarche méthodique de débogage

Face à un bug, suivre une méthode structurée :

1. **Reproduire le bug** : Identifier les conditions qui causent l'erreur.
2. **Localiser le bug** : Trouver la partie du code responsable.
3. **Comprendre le bug** : Analyser pourquoi il se produit.
4. **Formuler une hypothèse** : Émettre une théorie sur la cause.
5. **Tester l'hypothèse** : Vérifier si l'hypothèse est correcte.
6. **Corriger le bug** : Appliquer la correction.
7. **Vérifier la correction** : Tester que le bug est bien résolu.

---

## Techniques de débogage de base

Avant d'utiliser un débogueur, plusieurs techniques simples :

### 1. Lecture attentive du code

- Relire ligne par ligne.
- Vérifier les noms de variables (fautes de frappe).
- Vérifier les opérateurs (`==` vs `=`, `&&` vs `||`).

**Astuce** : Expliquer le code à voix haute ou à une personne (rubber duck
debugging).

---

## 2. Ajout de traces

Ajouter des `System.out.println()` pour afficher les valeurs :

```java
public static int calculateSum(int[] numbers) {
    int sum = 0;

    System.out.println("Début, tableau : " + Arrays.toString(numbers));

    for (int i = 0; i < numbers.length; i++) {
        sum += numbers[i];
        System.out.println("i = " + i + ", sum = " + sum);
    }

    return sum;
}
```

**Avantages** : Simple et rapide. **Inconvénients** : Encombre le code, à
retirer après.

---

## 3. Simplification du code

Décomposer les expressions complexes :

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

**Avantage** : Plus facile à comprendre et à tester.

---

## 4. Vérification des cas limites

Tester avec des valeurs extrêmes :

- Tableaux vides : `int[] empty = {};`
- Un seul élément : `int[] single = {5};`
- Valeurs négatives : `int[] negative = {-1, -2, -3};`
- Valeurs nulles : `String text = null;`

**Pourquoi** : Les bugs se cachent souvent dans les cas limites.

---

<!-- _class: chapter -->

# Partie 2

## Débogage avec VS Code

---

## Pourquoi utiliser un débogueur ?

Un **débogueur** permet de :

- Exécuter le programme **pas à pas**.
- **Inspecter les variables** à n'importe quel moment.
- **Contrôler l'exécution** précisément.
- **Gagner du temps** par rapport aux `println`.

**Débogueur VS Code** : Outil professionnel intégré pour Java (et autres
langages).

---

## Interface du débogueur VS Code

**Composants principaux** :

1. **Vue Run and Debug** : Panneau latéral avec toutes les infos de débogage.
2. **Barre d'outils de débogage** : Boutons pour contrôler l'exécution.
3. **Console de débogage** : Affiche les sorties et évalue des expressions.
4. **Sidebar de débogage** : Pile d'appels, variables, watch.
5. **Menu Run** : Commandes de débogage courantes.

---

## Démarrer une session de débogage

**Méthode simple** :

1. Ouvrir le fichier Java avec `main`.
2. Appuyer sur **F5**.
3. Sélectionner "Java" comme débogueur.

VS Code lance automatiquement le programme en mode débogage.

**Prérequis** : Extension "Extension Pack for Java" installée.

---

## Points d'arrêt (Breakpoints)

Un **point d'arrêt** (breakpoint) met en pause l'exécution à une ligne
spécifique.

**Placer un breakpoint** :

- Cliquer dans la **marge gauche** de l'éditeur.
- Ou appuyer sur **F9** avec le curseur sur la ligne.

**Apparence** : Cercle rouge dans la marge.

**Retirer un breakpoint** : Cliquer à nouveau ou **F9**.

---

## Types de points d'arrêt

### 1. Point d'arrêt simple

S'arrête à chaque passage sur la ligne.

### 2. Point d'arrêt conditionnel

S'arrête uniquement si une condition est vraie.

**Utilisation** : Clic droit → "Add Conditional Breakpoint" → Entrer `i == 10`.

**Exemple** : Arrêter une boucle seulement quand `i` vaut 10.

---

## Types de points d'arrêt (suite)

### 3. Logpoint

Affiche un message sans arrêter l'exécution.

**Utilisation** : Clic droit → "Add Logpoint" → Entrer `Valeur de i : {i}`.

**Avantage** : Équivalent à `println` sans modifier le code.

### 4. Hit Count Breakpoint

S'arrête après un nombre de passages.

**Exemple** : Arrêter après le 50ème passage dans une boucle.

---

## Actions de débogage

Une fois en pause, on contrôle l'exécution avec ces actions :

| Action        | Raccourci         | Description                                     |
| ------------- | ----------------- | ----------------------------------------------- |
| **Continue**  | **F5**            | Reprendre jusqu'au prochain breakpoint          |
| **Step Over** | **F10**           | Exécuter la ligne sans entrer dans les méthodes |
| **Step Into** | **F11**           | Entrer dans la méthode appelée                  |
| **Step Out**  | **Shift+F11**     | Sortir de la méthode actuelle                   |
| **Restart**   | **Ctrl+Shift+F5** | Redémarrer le programme                         |
| **Stop**      | **Shift+F5**      | Arrêter le débogage                             |

---

## Step Over (F10)

**Description** : Exécute la ligne actuelle **sans entrer** dans les méthodes.

**Exemple** :

```java
int x = 5;               // <- On est ici
int y = calculate(x);    // Step Over : exécute calculate() sans y entrer
System.out.println(y);   // <- On arrive ici
```

**Quand l'utiliser** : Pour avancer rapidement sans descendre dans les détails.

---

## Step Into (F11)

**Description** : Entre dans la méthode appelée pour la déboguer ligne par
ligne.

**Exemple** :

```java
int y = calculate(x);    // <- On est ici, Step Into
```

On entre dans `calculate()` :

```java
public static int calculate(int n) {
    int result = n * 2;  // <- On arrive ici
    return result;
}
```

**Quand l'utiliser** : Pour analyser en détail une méthode.

---

## Step Out (Shift+F11)

**Description** : Sort de la méthode actuelle et retourne à l'appelant.

**Exemple** :

```java
public static int calculate(int n) {
    int result = n * 2;  // <- On est ici
    return result;       // Step Out
}

int y = calculate(x);    // <- On revient ici
```

**Quand l'utiliser** : Quand on s'est trompé en faisant Step Into ou qu'on veut
sortir rapidement.

---

## Inspection des données

Pendant le débogage, on peut inspecter :

### 1. Section VARIABLES

Affiche toutes les variables **locales** et leurs valeurs.

**Fonctionnalités** :

- Voir les valeurs de toutes les variables.
- Développer les objets et tableaux.
- Modifier une valeur : Clic droit → "Set Value" (F2).

---

## 2. Section WATCH

Permet de surveiller des **expressions** spécifiques.

**Utilisation** :

1. Cliquer sur le `+` dans la section WATCH.
2. Entrer une expression : `i * 2`, `sum / numbers.length`.

L'expression est évaluée à chaque arrêt.

**Quand l'utiliser** : Pour surveiller des calculs sans les ajouter au code.

---

## 3. Section CALL STACK

La **pile d'appels** montre la séquence des méthodes appelées.

**Exemple** :

```text
Call Stack
  main:10
  calculate:25
  helper:42  <- Ligne actuelle
```

**Lecture** : On est dans `helper` (ligne 42), appelé depuis `calculate` (ligne
25), appelé depuis `main` (ligne 10).

**Utilité** : Comprendre le chemin d'exécution.

---

## Console de débogage

La **console de débogage** permet d'évaluer des expressions pendant le débogage.

**Accès** : "View" → "Debug Console" ou **Ctrl+Shift+Y**.

**Utilisation** :

```text
> i
5
> i * 2
10
> numbers.length
10
```

**Avantage** : Expérimenter sans modifier le code.

---

## Bugs courants : Dépassement d'indice

**Cause** : Accès à un indice inexistant d'un tableau.

**Exemple** :

```java
int[] numbers = {1, 2, 3};
for (int i = 0; i <= numbers.length; i++) {  // <= au lieu de <
    System.out.println(numbers[i]);  // Dépassement !
}
```

**Débogage** :

- Breakpoint dans la boucle.
- Surveiller `i` et comparer avec `numbers.length`.
- Identifier que `i` atteint 3 alors que le max est 2.

---

## Bugs courants : NullPointerException

**Cause** : Tentative d'utiliser un objet qui est `null`.

**Exemple** :

```java
String text = null;
int length = text.length();  // NullPointerException
```

**Débogage** :

- Breakpoint avant l'appel.
- Inspecter `text` (doit être `null`).
- Remonter pour comprendre pourquoi.

**Correction** : Vérifier avant d'utiliser :

```java
if (text != null) {
    int length = text.length();
}
```

---

## Bugs courants : Boucle infinie

**Cause** : Condition de sortie jamais atteinte.

**Exemple** :

```java
int i = 0;
while (i < 10) {
    System.out.println(i);
    // Oubli de i++
}
```

**Débogage** :

- Breakpoint dans la boucle.
- Step Over plusieurs fois.
- Observer que `i` ne change jamais.

---

## Bugs courants : Division entière

**Cause** : Division entre deux entiers qui produit un entier.

**Exemple** :

```java
int a = 5;
int b = 2;
double result = a / b;  // result = 2.0 au lieu de 2.5
```

**Débogage** :

- Breakpoint après le calcul.
- Inspecter `result` : vaut `2.0`.
- Réaliser que la division est entière avant conversion.

**Correction** :

```java
double result = (double) a / b;  // result = 2.5
```

---

## Bonnes pratiques

1. **Utiliser le débogueur plutôt que des `println`** : Plus puissant et propre.
2. **Placer des breakpoints stratégiques** : Début/fin de méthodes, boucles,
   opérations risquées.
3. **Utiliser les breakpoints conditionnels** : Pour s'arrêter dans des cas
   spécifiques.
4. **Surveiller les expressions avec WATCH** : Laisser le débogueur calculer.
5. **Vérifier la pile d'appels** : Comprendre le chemin d'exécution.
6. **Prendre le temps de comprendre** : Formuler une hypothèse avant de
   corriger.
7. **Tester après correction** : Vérifier avec différents cas.

---

## À vous de jouer !

**Exercices pratiques** :

1. Déboguer des programmes avec différents types de bugs.
2. Utiliser les actions de débogage (Step Over, Step Into, Step Out).
3. Inspecter les variables et la pile d'appels.
4. Placer des breakpoints conditionnels.
5. Corriger les bugs courants (dépassement d'indice, NullPointerException,
   etc.).

**Objectif** : Maîtriser l'utilisation du débogueur VS Code pour identifier et
corriger efficacement les bugs.

---

## Questions ?

---

## Sources

- V. Guidoux, avec l'aide de
  [GitHub Copilot](https://github.com/features/copilot).
- Documentation VS Code :
  [Debugging](https://code.visualstudio.com/docs/debugtest/debugging)
- Ce travail est sous licence [CC BY-SA 4.0][licence].

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
