---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
title: HEIG-VD ProgIM1 Course - Variables & Constantes
description: Variables & Constantes pour l'unité d'enseignement ProgIM1 enseigné à la HEIG-VD, Suisse
url: https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/04.02-variables-constantes/01-supports-de-cours/index.html
header: "**Variables & Constantes**"
footer: '[**HEIG-VD**](https://heig-vd.ch) - [ProgIM1 2025-2026](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course) - [CC BY-SA 4.0](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md)'
headingDivider: 6
math: mathjax
-->

# Variables & Constantes

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

## Objectifs (1/2)

À la fin de cette séance, vous devriez être capable de :

- Identifier et appliquer les structures algorithmiques fondamentales :
  séquence, sélection et itération en Java
- Utiliser efficacement les variables, les constantes et les types de données de
  base en Java

![bg right:40%][illustration-objectifs]

## Objectifs (2/2)

- Comprendre la différence entre variables et constantes
- Effectuer des opérations arithmétiques
- Prendre des décisions avec les structures conditionnelles (if/else)
- Répéter des actions avec les boucles (while et for)

![bg right:40%][illustration-objectifs]

## Rappel du cours précédent

<!-- _class: lead -->

## Ce que vous avez déjà appris

- ✅ Installation de l'environnement Java (JDK + IDE)
- ✅ Compilation vs interprétation
- ✅ Votre premier programme "Hello World"
- ✅ La méthode `main` comme point d'entrée

![bg right:40%][illustration-principale]

## Aujourd'hui : stocker et manipuler des données !

<!-- _class: lead -->

## Les variables en Java

<!-- _class: lead -->

## Qu'est-ce qu'une variable ?

Une variable est comme une **boîte** qui contient une information.

Elle a :

- Un **nom** (pour la retrouver)
- Un **type** (le genre d'information)
- Une **valeur** (l'information elle-même)

![bg right:40%][illustration-variables]

## Analogies de la vie réelle (1/2)

<div class="two-columns">
<div>

🍎 **Un panier de pommes**

- Nom : `appleCount`
- Type : nombre entier (`int`)
- Valeur : `5`
</div>

<div>

💰 **Un portefeuille**

- Nom : `myMoney`
- Type : nombre décimal (`double`)
- Valeur : `25.50`
</div>

## Analogies de la vie réelle (2/2)

<div class="two-columns">
<div>

📛 **Une étiquette avec votre nom**

- Nom : `myName`
- Type : texte (`String`)
- Valeur : `"Marie"`

</div>
<div>

💡 **Un interrupteur**

- Nom : `lampOn`
- Type : vrai/faux (`boolean`)
- Valeur : `true`

</div>

## Déclaration et initialisation

```java
// Déclaration + initialisation en une ligne
int appleCount = 5;

// Ou en deux étapes
int pearCount;        // Déclaration
pearCount = 3;         // Initialisation
```

> 💡 **Bonne pratique** : Initialisez toujours vos variables au moment de leur
> déclaration !

## Les types de données de base

<!-- _class: lead -->

## Le type `int` (nombres entiers)

```java
public class AppleBasket {
    public static void main(String[] args) {
        // Je déclare une variable pour compter les pommes
        int appleCount = 5;

        // J'affiche le nombre de pommes
        System.out.println("Mon panier contient " + appleCount + " pommes");
    }
}
```

**Résultat :** `Mon panier contient 5 pommes`

![bg right:30%][illustration-les-nombres]

## Le type `double` (nombres décimaux)

```java
public class TotalPrice {
    public static void main(String[] args) {
        double bookPrice = 15.90;
        double coffeePrice = 4.50;
        double totalPrice = bookPrice + coffeePrice;

        System.out.println("Prix total : " + totalPrice + " francs");
    }
}
```

**Résultat :** `Prix total : 20.4 francs`

![bg right:30%][illustration-les-nombres]

## Différence entre `int` et `double`

| Type     | Pour quoi ?            | Exemples                      |
| -------- | ---------------------- | ----------------------------- |
| `int`    | **Compter** des choses | Pommes, personnes, jours      |
| `double` | **Mesurer** des choses | Prix, distances, températures |

> ⚠️ Attention : `7 / 2` donne `3` (division entière) !

## Le type `String` (texte)

```java
public class WelcomeMessage {
    public static void main(String[] args) {
        String name = "Sophie";
        String message = "Bienvenue " + name + " !";

        System.out.println(message);
    }
}
```

**Résultat :** `Bienvenue Sophie !`

> 💡 Le symbole `+` permet de **concaténer** (coller) des textes ensemble

![bg right:30%][illustration-les-chaines-de-caracteres]

## Le type `boolean` (vrai ou faux)

```java
public class EvenNumber {
    public static void main(String[] args) {
        int number = 10;
        boolean isEven = (number % 2 == 0);

        System.out.println("Le nombre " + number + " est pair : " + isEven);
    }
}
```

**Résultat :** `Le nombre 10 est pair : true`

![bg right:30%][illustration-les-booleens]

## Opérations sur les variables

<!-- _class: lead -->

## Opérateurs arithmétiques

| Opérateur | Signification  | Exemple  | Résultat |
| --------- | -------------- | -------- | -------- |
| `+`       | Addition       | `5 + 3`  | `8`      |
| `-`       | Soustraction   | `5 - 3`  | `2`      |
| `*`       | Multiplication | `5 * 3`  | `15`     |
| `/`       | Division       | `10 / 2` | `5`      |
| `%`       | Modulo (reste) | `10 % 3` | `1`      |

## Modifier une variable

```java
public class ModifyBasket {
    public static void main(String[] args) {
        int apples = 5;
        System.out.println("Au début, j'ai " + apples + " pommes");

        apples = apples + 3;
        System.out.println("Après ajout, j'ai " + apples + " pommes");
    }
}
```

**Résultat :**

```text
Au début, j'ai 5 pommes
Après ajout, j'ai 8 pommes
```

![bg right:30%][illustration-variables]

## Raccourcis pratiques

```java
int points = 10;

points += 5;   // Équivalent à : points = points + 5;
points -= 2;   // Équivalent à : points = points - 2;
points *= 2;   // Équivalent à : points = points * 2;
points /= 4;   // Équivalent à : points = points / 4;

points++;      // Équivalent à : points = points + 1;
points--;      // Équivalent à : points = points - 1;
```

> 💡 Ces raccourcis rendent le code plus concis !

## Les constantes en Java

<!-- _class: lead -->

## Variables vs Constantes

| Variables                         | Constantes                          |
| --------------------------------- | ----------------------------------- |
| Peuvent être modifiées            | **Ne peuvent PAS être modifiées**   |
| Nom en minuscules (`age`, `prix`) | Nom en MAJUSCULES (`AGE_MAX`, `PI`) |
| Déclarées normalement             | Déclarées avec le mot-clé `final`   |
| Pour des valeurs qui changent     | Pour des valeurs qui restent fixes  |

## Pourquoi utiliser des constantes ?

✅ **Clarté** : `TVA_SUISSE` est plus clair que `0.077`

✅ **Sécurité** : Impossible de modifier accidentellement

✅ **Maintenance** : Modifier à un seul endroit

✅ **Intention** : Indique clairement que la valeur est fixe

## Exemple : Calculer la TVA

```java
public class CalculateVAT {
    public static void main(String[] args) {
        final double SWISS_VAT = 0.077;  // 7.7%
        double priceExclVAT = 100.0;

        double vatAmount = priceExclVAT * SWISS_VAT;
        double priceInclVAT = priceExclVAT + vatAmount;

        System.out.println("Prix TTC : " + priceInclVAT + " francs");
    }
}
```

**Résultat :** `Prix TTC : 107.7 francs`

## Les structures algorithmiques

<!-- _class: lead -->

## Les trois structures fondamentales

1. **Séquence** : exécuter les instructions les unes après les autres
2. **Sélection** : prendre des décisions (if/else)
3. **Itération** : répéter des actions (boucles while et for)

> 🎯 Ces trois structures sont les briques de base de TOUS les programmes !

## La séquence

**Principe :** Les instructions s'exécutent de haut en bas, dans l'ordre

```java
public class SequencePriceInclVAT {
    public static void main(String[] args) {
        double priceExclVAT = 100.0;           // 1. Définir le prix HT
        final double VAT = 0.077;        // 2. Définir le taux de TVA
        double vatAmount = priceExclVAT * VAT; // 3. Calculer la TVA
        double priceInclVAT = priceExclVAT + vatAmount; // 4. Calculer le prix TTC
        System.out.println("Prix TTC : " + priceInclVAT); // 5. Afficher
    }
}
```

## La sélection (if/else)

<!-- _class: lead -->

## Prendre des décisions

**SI** une condition est vraie, **ALORS** faire quelque chose, **SINON** faire
autre chose

```java
if (condition) {
    // Code si la condition est vraie
} else {
    // Code si la condition est fausse
}
```

![bg right:40%][illustration-les-structures-de-controle-conditionnelles]

## Opérateurs de comparaison

| Opérateur | Signification       | Exemple     |
| --------- | ------------------- | ----------- |
| `==`      | Égal à              | `a == b`    |
| `!=`      | Différent de        | `a != b`    |
| `>`       | Supérieur à         | `a > b`     |
| `<`       | Inférieur à         | `a < b`     |
| `>=`      | Supérieur ou égal à | `age >= 18` |
| `<=`      | Inférieur ou égal à | `age <= 65` |

## Exemple : Vérifier l'âge pour voter

```java
public class CanVote {
    public static void main(String[] args) {
        final int VOTING_AGE = 18;
        int age = 20;

        if (age >= VOTING_AGE) {
            System.out.println("Vous pouvez voter !");
        } else {
            System.out.println("Vous ne pouvez pas encore voter");
        }
    }
}
```

**Résultat :** `Vous pouvez voter !`

## Opérateurs logiques

| Opérateur | Signification | Exemple                    |
| --------- | ------------- | -------------------------- |
| `&&`      | ET (AND)      | `age >= 18 && age < 65`    |
| `\|\|`    | OU (OR)       | `jour == 6 \|\| jour == 7` |
| `!`       | NON (NOT)     | `!isAdult`                 |

> 💡 `&&` = toutes les conditions doivent être vraies  
> 💡 `||` = au moins une condition doit être vraie

## Exemple : Conditions multiples

```java
public class EnterBar {
    public static void main(String[] args) {
        int age = 20;
        boolean hasIdCard = true;

        if (age >= 18 && hasIdCard) {
            System.out.println("Vous pouvez entrer");
        } else {
            System.out.println("Accès refusé");
        }
    }
}
```

**Résultat :** `Vous pouvez entrer`

## L'itération - La boucle while

<!-- _class: lead -->

## Répéter tant qu'une condition est vraie

**Syntaxe :**

```java
while (condition) {
    // Instructions à répéter
}
```

> ⚠️ Attention aux boucles infinies ! La condition doit finir par devenir
> fausse.

![bg right:40%][illustration-pseudocode]

## Exemple : Économiser de l'argent

```java
public class SaveMoney {
    public static void main(String[] args) {
        final int TARGET = 300;
        int weeklySavings = 50;
        int total = 0;
        int week = 0;

        while (total < TARGET) {
            week++;
            total += weeklySavings;
            System.out.println("Semaine " + week + " : " + total + " francs");
        }

        System.out.println("Objectif atteint en " + week + " semaines !");
    }
}
```

## Résultat de l'exemple

```text
Semaine 1 : 50 francs
Semaine 2 : 100 francs
Semaine 3 : 150 francs
Semaine 4 : 200 francs
Semaine 5 : 250 francs
Semaine 6 : 300 francs

Objectif atteint en 6 semaines !
```

## Les éléments clés d'une boucle while

1. **Initialisation** : Créer la variable de contrôle avant la boucle
2. **Condition** : Définir quand la boucle doit continuer
3. **Modification** : Changer la variable dans la boucle pour que la condition
   finisse par être fausse

```java
int counter = 0;           // 1. Initialisation
while (counter < 5) {      // 2. Condition
    System.out.println(counter);
    counter++;             // 3. Modification
}
```

## L'itération - La boucle for

<!-- _class: lead -->

## Répéter un nombre connu de fois

**Syntaxe :**

```java
for (initialisation; condition; incrémentation) {
    // Instructions à répéter
}
```

![bg right:40%][illustration-pseudocode]

## Exemple : Arroser des plantes

```java
public class WaterPlants {
    public static void main(String[] args) {
        final int PLANT_COUNT = 5;

        System.out.println("J'ai " + PLANT_COUNT + " plantes à arroser");

        for (int plant = 1; plant <= PLANT_COUNT; plant++) {
            System.out.println("J'arrose la plante numéro " + plant);
        }

        System.out.println("Toutes les plantes sont arrosées !");
    }
}
```

## Résultat de l'exemple

```text
J'ai 5 plantes à arroser
J'arrose la plante numéro 1
J'arrose la plante numéro 2
J'arrose la plante numéro 3
J'arrose la plante numéro 4
J'arrose la plante numéro 5
Toutes les plantes sont arrosées !
```

## Exemple : Table de multiplication

```java
public class MultiplicationTable {
    public static void main(String[] args) {
        final int NUMBER = 5;

        System.out.println("Table de multiplication de " + NUMBER + " :");

        for (int i = 1; i <= 10; i++) {
            int result = NUMBER * i;
            System.out.println(NUMBER + " x " + i + " = " + result);
        }
    }
}
```

## Quand utiliser while vs for ?

<div class="two-columns">
<div>

**Utilisez `while` quand :**

- ❓ Vous ne connaissez pas le nombre d'itérations à l'avance
- 📊 La condition d'arrêt dépend d'un événement
- 💰 Exemple : économiser jusqu'à atteindre un objectif
</div>
<div>

**Utilisez `for` quand :**

- ✅ Vous connaissez exactement le nombre d'itérations
- 🔢 Vous voulez parcourir une séquence de nombres
- 🌱 Exemple : arroser 5 plantes, compter de 1 à 10

</div>

## Erreurs courantes à éviter

<!-- _class: lead -->

## ⚠️ Confusion entre `=` et `==`

```java
// ❌ ERREUR
if (age = 18) {  // Affectation au lieu de comparaison
    // ...
}

// ✅ CORRECT
if (age == 18) {  // Comparaison
    // ...
}
```

## ⚠️ Boucle infinie

```java
// ❌ ERREUR - Boucle infinie !
int i = 0;
while (i < 10) {
    System.out.println(i);
    // Oups ! On oublie i++;
}

// ✅ CORRECT
int i = 0;
while (i < 10) {
    System.out.println(i);
    i++;  // On incrémente le compteur
}
```

## ⚠️ Variable non initialisée

```java
// ❌ ERREUR
int total;  // Pas d'initialisation
total = total + 5;  // total n'a pas de valeur !

// ✅ CORRECT
int total = 0;  // Initialisation
total = total + 5;  // Maintenant ça fonctionne
```

## Bonnes pratiques

<!-- _class: lead -->

## 📝 Nommage des variables

✅ **Bon** : Noms descriptifs

```java
int appleCount;
double totalPrice;
final int VOTING_AGE = 18;
```

❌ **Mauvais** : Noms vagues

```java
int n;
double p;
final int A = 18;
```

## 🎨 Indentation

```java
// ✅ Bon - Code indenté et lisible
if (age >= 18) {
    System.out.println("Majeur");
    if (hasLicense) {
        System.out.println("Peut conduire");
    }
}

// ❌ Mauvais - Difficile à lire
if (age >= 18) {
System.out.println("Majeur");
if (hasLicense) {
System.out.println("Peut conduire");
}
}
```

## 💬 Commentaires utiles

```java
// ✅ Bon - Explique le "pourquoi"
final double SWISS_VAT = 0.077;  // Taux défini par la loi suisse

// ❌ Inutile - Répète le code
int age = 18;  // Je déclare une variable age
```

> 💡 Expliquez **pourquoi**, pas **quoi** !

## Récapitulatif

<!-- _class: lead -->

## Ce que vous avez appris aujourd'hui

✅ Les **variables** et les **constantes** en Java

✅ Les **types de données** de base (`int`, `double`, `String`, `boolean`)

✅ Les **opérations arithmétiques** et la **modification** de variables

✅ La **séquence** d'instructions

## Ce que vous avez appris aujourd'hui (suite)

✅ La **sélection** avec `if`/`else` pour prendre des décisions

✅ L'**itération** avec `while` et `for` pour répéter des actions

✅ Les **bonnes pratiques** de programmation

> 🎉 Vous avez maintenant tous les outils de base pour programmer en Java !

## À vous de jouer !

- (Re)lire le [support de cours][cours]
- Réaliser les [exercices][exercices]
- Expérimenter avec [PlantUML en ligne][plantuml-editor]
- Poser des questions si nécessaire

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
- [Illustration variables][illustration-variables] par
  [Javier Allegue Barros](https://unsplash.com/@soymeraki) sur
  [Unsplash](https://unsplash.com/photos/C7B-ExXpOIE)
- [Illustration pseudocode][illustration-pseudocode] par
  [Florian Olivo](https://unsplash.com/@florianolv) sur
  [Unsplash](https://unsplash.com/photos/4hbJ-eymZ1o)
- [Illustration exercices][illustration-exercices] par
  [Green Chameleon](https://unsplash.com/@craftedbygc) sur
  [Unsplash](https://unsplash.com/photos/s9CC2SKySJM)
- [Illustration nombres][illustration-les-nombres] par
  [Nick Hillier](https://unsplash.com/@nhillier) sur
  [Unsplash](https://unsplash.com/photos/assorted-numbers-photography-yD5rv8_WzxA)
- [Illustration chaînes][illustration-les-chaines-de-caracteres] par
  [Kier in Sight Archives](https://unsplash.com/@kierinsightarchives) sur
  [Unsplash](https://unsplash.com/photos/white-and-black-abstract-illustration-qXA4b_dZSbQ)
- [Illustration booléens][illustration-les-booleens] par
  [Brooke Lark](https://unsplash.com/@brookelark) sur
  [Unsplash](https://unsplash.com/photos/person-holding-calendar-at-january-BRBjShcA8D4)
- [Illustration opérateurs][illustration-les-operateurs] par
  [charlesdeluvio](https://unsplash.com/@charlesdeluvio) sur
  [Unsplash](https://unsplash.com/photos/white-calculator-on-white-table-GlavtG-umzE)
- [Illustration constantes][illustration-les-constantes] par
  [Kenny Eliason](https://unsplash.com/@neonbrand) sur
  [Unsplash](https://unsplash.com/photos/red-bricks-wall-XEsx2NVpqWY)
- [Illustration structures de
  contrôle][illustration-les-structures-de-controle-conditionnelles] par
  [Arham Jain](https://unsplash.com/@arham_jain48) sur
  [Unsplash](https://unsplash.com/photos/a-painting-of-blue-flowers-on-a-white-background-OkiDTYxLo34)
- [Illustration à vous de jouer][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/FJFPuE1MAOM)

<!-- URLs -->

[presentation-web]:
	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/04.02-variables-constantes/01-supports-de-cours/index.html
[presentation-pdf]:
	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/04.02-variables-constantes/01-supports-de-cours/04.02-variables-constantes-presentation.pdf
[cours]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/04.02-variables-constantes/01-supports-de-cours
[exercices]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/04.02-variables-constantes/02-exercices
[plantuml-editor]: https://plantuml.nortalle.ch
[license]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]: ./images/home.jpg
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-variables]:
	https://images.unsplash.com/photo-1558618666-fcd25c85cd64?fit=crop&h=720
[illustration-pseudocode]:
	https://images.unsplash.com/photo-1461749280684-dccba630e2f6?fit=crop&h=720
[illustration-exercices]:
	https://images.unsplash.com/photo-1434030216411-0b793f4b4173?fit=crop&h=720
[illustration-les-nombres]:
	https://images.unsplash.com/photo-1502570149819-b2260483d302?fit=crop&h=720
[illustration-les-chaines-de-caracteres]:
	https://images.unsplash.com/photo-1622321786092-a3df1d448be1?fit=crop&h=720
[illustration-les-booleens]:
	https://images.unsplash.com/photo-1484981184820-2e84ea0af397?fit=crop&h=720
[illustration-les-operateurs]:
	https://images.unsplash.com/photo-1587145820266-a5951ee6f620?fit=crop&h=720
[illustration-les-constantes]:
	https://images.unsplash.com/photo-1495578942200-c5f5d2137def?fit=crop&h=720
[illustration-les-structures-de-controle-conditionnelles]:
	https://images.unsplash.com/photo-1590593162201-f67611a18b87?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
