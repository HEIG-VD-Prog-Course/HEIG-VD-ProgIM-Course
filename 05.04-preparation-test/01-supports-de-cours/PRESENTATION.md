---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
title: HEIG-VD ProgIM1 Course - Quiz de révision
description: Quiz de révision pour la préparation au test de l'unité d'enseignement ProgIM1 enseigné à la HEIG-VD, Suisse
url: https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/05.04-preparation-test/01-supports-de-cours/index.html
header: "**Quiz de révision**"
footer: '[**HEIG-VD**](https://heig-vd.ch) - [ProgIM1 2025-2026](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course) - [CC BY-SA 4.0](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md)'
headingDivider: 6
math: mathjax
-->

# Quiz de révision

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

## Instructions

Ce quiz contient des questions de révision pour vous préparer au test.

**Comment utiliser ce quiz** :

- Lisez chaque question attentivement
- Essayez d'y répondre mentalement ou sur papier
- Passez à la diapositive suivante pour voir la réponse
- Si vous vous trompez, notez le thème à réviser

**Bonne chance !**

## Question 1 - Donnée

> Que signifie l'acronyme JDK ?

## Question 1 - Réponse

**JDK** signifie **Java Development Kit** (Kit de développement Java).

C'est l'ensemble des outils nécessaires pour développer des programmes Java :

- Compilateur
- JRE (Java Runtime Environment)
- Bibliothèques de classes
- Outils de développement

## Question 2 - Donnée

> Quelle est la différence entre les opérateurs `=` et `==` ?

## Question 2 - Réponse

**`=` est l'opérateur d'affectation** : Il permet de mettre une valeur dans une
variable.

```java
int age = 25;  // Affecte la valeur 25 à la variable age
```

**`==` est l'opérateur de comparaison** : Il compare deux valeurs et retourne un
booléen.

```java
if (age == 25) {  // Compare age avec 25
    System.out.println("L'âge est 25");
}
```

## Question 3 - Donnée

> Citez quatre types de Java.

## Question 3 - Réponse (1/2)

<div class=two-columns  >
<div>

**Entiers** :

- `int` (32 bits)

**Réels** :

- `double` (64 bits)

</div>
<div>

**Chaînes** :

- `String` (chaîne de caractères)

**Autres** :

- `boolean` (vrai/faux)

</div>

## Question 4 - Donnée

> Que va afficher ce code ?
>
> ```java
> System.out.println(9 % 5);
> ```

## Question 4 - Réponse

Le code affiche **4**.

L'opérateur `%` calcule le **reste de la division entière**.

9 divisé par 5 = 1 reste **4**

## Question 5 - Donnée

> Que va afficher ce code ?
>
> ```java
> System.out.println("2" + 1 + 2);
> ```

## Question 5 - Réponse

Le code affiche **"212"**.

Quand on utilise `+` avec une chaîne de caractères, Java concatène :

- `"2" + 1` → `"21"` (concaténation)
- `"21" + 2` → `"212"` (concaténation)

Si on voulait obtenir 5, il faudrait écrire : `1 + 2 + "2"` → `"32"`

## Question 6 - Donnée

> Quelle est la différence entre une boucle `while` et une boucle `do...while` ?

## Question 6 - Réponse

**Boucle `while`** : La condition est testée **avant** d'entrer dans la boucle.
Elle peut ne jamais s'exécuter.

**Boucle `do...while`** : La condition est testée **après** l'exécution du bloc.
Elle s'exécute **au moins une fois**.

```java
do {
    // S'exécute au moins une fois
} while (condition);

while (condition) {
    // Peut ne jamais s'exécuter
}
```

## Question 7 - Donnée

> Quelle boucle utiliser si on connaît le nombre de répétitions à l'avance ?

## Question 7 - Réponse

On utilise une **boucle `for`** quand on connaît le nombre de répétitions.

```java
// Répéter 10 fois
for (int i = 0; i < 10; i++) {
    System.out.println("Itération " + i);
}
```

Si on ne connaît pas le nombre de répétitions, on utilise `while` ou
`do...while`.

## Question 8 - Donnée

> Qu'est-ce qu'un tableau ?

## Question 8 - Réponse

Un **tableau** est une structure de données qui :

- Regroupe plusieurs éléments du **même type**
- A une **taille fixe** définie à la création
- Permet d'accéder aux éléments par leur **index** (position)

```java
int[] numbers = new int[5];  // Tableau de 5 entiers
numbers[0] = 10;  // Premier élément
numbers[4] = 50;  // Dernier élément
```

Les indices vont de `0` à `length - 1`.

## Question 9 - Donnée

> Comment accéder au dernier élément d'un tableau nommé `array` ?

## Question 9 - Réponse

On accède au dernier élément avec l'index `array.length - 1` :

```java
int[] array = {10, 20, 30, 40, 50};
int lastElement = array[array.length - 1];  // 50
```

**Attention** : `array.length` donne la taille du tableau (5), mais les indices
vont de 0 à 4 !

## Question 10 - Donnée

> Qu'est-ce qu'une méthode (fonction) ?

## Question 10 - Réponse

<div class="two-columns">
<div>

Une **méthode** est un bloc de code réutilisable qui :

- Effectue une tâche spécifique
- Peut recevoir des **paramètres**
- Peut **retourner** une valeur
- Évite la répétition de code

</div>
<div>

```java
public static int add(int a, int b) {
    return a + b;
}

// Appel de la méthode
int sum = add(5, 3);  // sum vaut 8
```

</div>

## Question 11 - Donnée

> Que signifie le mot-clé `void` dans une déclaration de méthode ?

## Question 11 - Réponse

`void` signifie que la méthode **ne retourne aucune valeur**.

```java
// Méthode qui ne retourne rien
public static void displayMessage(String message) {
    System.out.println(message);
    // Pas de return
}

// Méthode qui retourne un int
public static int add(int a, int b) {
    return a + b;  // return obligatoire
}
```

## Question 12 - Donnée

> Quelle est la différence entre `System.out.print()` et `System.out.println()`
> ?

## Question 12 - Réponse

**`System.out.print()`** : Affiche sans aller à la ligne.

**`System.out.println()`** : Affiche et va à la ligne (`ln` = line).

```java
System.out.print("Bonjour ");
System.out.print("le monde");
// Affiche : Bonjour le monde

System.out.println("Bonjour");
System.out.println("le monde");
// Affiche :
// Bonjour
// le monde
```

## Question 13 - Donnée

> Comment lire un nombre entier saisi par l'utilisateur avec `Scanner` ?

## Question 13 - Réponse (1/2)

On utilise la méthode `nextInt()` :

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
```

## Question 13 - Réponse (2/2)

```java
        System.out.print("Entrez un nombre : ");
        int number = scanner.nextInt();

        System.out.println("Vous avez saisi : " + number);

        scanner.close();
    }
}
```

Autres méthodes : `nextDouble()`, `nextLine()`, `nextBoolean()`.

## Question 14 - Donnée

> Pourquoi est-il dangereux de comparer deux nombres réels (`double`) avec
> l'opérateur `==` ?

## Question 14 - Réponse

Les nombres réels sont des **approximations** en mémoire. Deux calculs qui
devraient donner le même résultat peuvent donner des valeurs légèrement
différentes.

```java
double a = 0.1 + 0.2;
double b = 0.3;

if (a == b) {  // DANGER ! Peut être false
    System.out.println("Égaux");
}
```

**Solution** : Comparer avec une tolérance :

```java
if (Math.abs(a - b) < 0.0001) {  // Tolérance de 0.0001
    System.out.println("Égaux");
}
```

## Question 15 - Donnée

> Quelles sont les conventions de nommage en Java pour :
>
> - Les variables
> - Les constantes

## Question 15 - Réponse

**Variables et méthodes** : `camelCase`

```java
int userName;
void calculateTotal() { }
```

**Constantes** : `UPPER_SNAKE_CASE`

```java
final double TAX_RATE = 0.2;
final int MAX_VALUE = 100;
```

## Question 16 - Donnée

> Que va afficher ce code ?

```java
for (int i = 0; i < 3; i++) {
    System.out.println(i);
}
```

## Question 16 - Réponse

Le code affiche :

```text
0
1
2
```

La boucle s'exécute **3 fois** avec `i` prenant les valeurs 0, 1, puis 2.

Quand `i` vaut 3, la condition `i < 3` est fausse, donc on sort de la boucle.

## Question 17 - Donnée

> Qu'est-ce que l'encodage UTF-8 ?

## Question 17 - Réponse

<div class="two-columns">
<div>

**UTF-8** est un encodage de caractères qui :

- Représente **tous** les caractères Unicode (toutes les langues + emojis)
- Utilise **1 à 4 octets** par caractère
- Est **compatible avec ASCII** (les 128 premiers caractères)

</div>
<div>

- Est le **standard actuel** sur Internet

Exemples :

- `A` → 1 octet
- `é` → 2 octets
- `中` → 3 octets
- Emoji → 4 octets

</div>

## Question 18 - Donnée

> Que va afficher ce code ?

```java
 int[] array = {10, 20, 30};
 System.out.println(array.length);
```

## Question 18 - Réponse

Le code affiche **3**.

La propriété `length` d'un tableau donne sa **taille** (nombre d'éléments).

**Attention** : Les indices vont de 0 à `length - 1` (ici de 0 à 2).

## Question 19 - Donnée

> Combien de paramètres peut avoir une méthode ?

## Question 19 - Réponse (1/2)

Une méthode peut avoir **autant de paramètres que nécessaire**.

## Question 19 - Réponse (2/2)

```java
// 0 paramètre
public static void sayHello() { }

// 1 paramètre
public static void greet(String name) { }

// 3 paramètres
public static int add(int a, int b, int c) {
    return a + b + c;
}

// Beaucoup de paramètres
public static void method(int a, double b, String c, boolean d) { }
```

## Question 20 - Donnée

> Que va afficher ce code ?

```java
int x = 5;
int y = 10;
System.out.println(x > 3 && y < 15);
```

## Question 20 - Réponse (1/2)

```java
int x = 5;
int y = 10;
System.out.println(x > 3 && y < 15);
```

```text
true
```

## Question 20 - Réponse (2/2)

L'opérateur `&&` (ET logique) retourne `true` si **les deux conditions** sont
vraies :

- `x > 3` → `5 > 3` → `true`
- `y < 15` → `10 < 15` → `true`
- `true && true` → `true`

Si une seule condition était fausse, le résultat serait `false`.

## Fin du quiz !

<!--
_class: lead
-->

Vous avez terminé le quiz de révision.

**Prochaines étapes** :

- Identifiez les thèmes où vous avez des difficultés
- Relisez les supports de cours correspondants
- Refaites les exercices
- Entraînez-vous avec les questionnaires des années précédentes

**Bonne préparation pour le test !**

## Sources

- [Questionnaires des années précédentes][questionnaires]
- [Supports de cours](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course)

<!-- URLs -->

[presentation-web]:
	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/05.04-preparation-test/01-supports-de-cours/index.html
[presentation-pdf]:
	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/05.04-preparation-test/01-supports-de-cours/05.04-preparation-test-presentation.pdf
[cours]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/05.04-preparation-test/01-supports-de-cours
[questionnaires]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/archive/Questionnaires/questionnaires-complets.md
[license]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]: ./images/home.jpg
