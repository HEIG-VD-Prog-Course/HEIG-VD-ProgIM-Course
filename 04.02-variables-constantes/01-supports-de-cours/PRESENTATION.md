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

🍎 **Un panier de pommes**

- Nom : `nombreDePommes`
- Type : nombre entier (`int`)
- Valeur : `5`

💰 **Un portefeuille**

- Nom : `monArgent`
- Type : nombre décimal (`double`)
- Valeur : `25.50`

![bg right:40%][illustration-variables]

## Analogies de la vie réelle (2/2)

📛 **Une étiquette avec votre nom**

- Nom : `monNom`
- Type : texte (`String`)
- Valeur : `"Marie"`

💡 **Un interrupteur**

- Nom : `lampeAllumee`
- Type : vrai/faux (`boolean`)
- Valeur : `true`

![bg right:40%][illustration-variables]

## Déclaration et initialisation

```java
// Déclaration + initialisation en une ligne
int nombreDePommes = 5;

// Ou en deux étapes
int nombreDePoires;        // Déclaration
nombreDePoires = 3;         // Initialisation
```

> 💡 **Bonne pratique** : Initialisez toujours vos variables au moment de leur
> déclaration !

## Les types de données de base

<!-- _class: lead -->

## Le type `int` (nombres entiers)

```java
public class PanierDePommes {
    public static void main(String[] args) {
        // Je déclare une variable pour compter les pommes
        int nombreDePommes = 5;

        // J'affiche le nombre de pommes
        System.out.println("Mon panier contient " + nombreDePommes + " pommes");
    }
}
```

**Résultat :** `Mon panier contient 5 pommes`

![bg right:30%][illustration-les-nombres]

## Le type `double` (nombres décimaux)

```java
public class PrixTotal {
    public static void main(String[] args) {
        double prixLivre = 15.90;
        double prixCafe = 4.50;
        double prixTotal = prixLivre + prixCafe;

        System.out.println("Prix total : " + prixTotal + " francs");
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
public class MessageBienvenue {
    public static void main(String[] args) {
        String nom = "Sophie";
        String message = "Bienvenue " + nom + " !";

        System.out.println(message);
    }
}
```

**Résultat :** `Bienvenue Sophie !`

> 💡 Le symbole `+` permet de **concaténer** (coller) des textes ensemble

![bg right:30%][illustration-les-chaines-de-caracteres]

## Le type `boolean` (vrai ou faux)

```java
public class NombrePair {
    public static void main(String[] args) {
        int nombre = 10;
        boolean estPair = (nombre % 2 == 0);

        System.out.println("Le nombre " + nombre + " est pair : " + estPair);
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

![bg right:40%][illustration-les-operateurs]

## Modifier une variable

```java
public class ModifierPanier {
    public static void main(String[] args) {
        int pommes = 5;
        System.out.println("Au début, j'ai " + pommes + " pommes");

        pommes = pommes + 3;
        System.out.println("Après ajout, j'ai " + pommes + " pommes");
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

![bg right:40%][illustration-les-constantes]

## Pourquoi utiliser des constantes ?

✅ **Clarté** : `TVA_SUISSE` est plus clair que `0.077`

✅ **Sécurité** : Impossible de modifier accidentellement

✅ **Maintenance** : Modifier à un seul endroit

✅ **Intention** : Indique clairement que la valeur est fixe

![bg right:40%][illustration-les-constantes]

## Exemple : Calculer la TVA

```java
public class CalculTVA {
    public static void main(String[] args) {
        final double TVA_SUISSE = 0.077;  // 7.7%
        double prixHT = 100.0;

        double montantTVA = prixHT * TVA_SUISSE;
        double prixTTC = prixHT + montantTVA;

        System.out.println("Prix TTC : " + prixTTC + " francs");
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

![bg right:40%][illustration-pseudocode]

## La séquence

**Principe :** Les instructions s'exécutent de haut en bas, dans l'ordre

```java
public class SequencePrixTTC {
    public static void main(String[] args) {
        double prixHT = 100.0;           // 1. Définir le prix HT
        final double TVA = 0.077;        // 2. Définir le taux de TVA
        double montantTVA = prixHT * TVA; // 3. Calculer la TVA
        double prixTTC = prixHT + montantTVA; // 4. Calculer le prix TTC
        System.out.println("Prix TTC : " + prixTTC); // 5. Afficher
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
public class PeutVoter {
    public static void main(String[] args) {
        final int AGE_MAJORITE = 18;
        int age = 20;

        if (age >= AGE_MAJORITE) {
            System.out.println("Vous pouvez voter !");
        } else {
            System.out.println("Vous ne pouvez pas encore voter");
        }
    }
}
```

**Résultat :** `Vous pouvez voter !`

## Opérateurs logiques

| Opérateur | Signification | Exemple                 |
| --------- | ------------- | ----------------------- | ------- | -------------------------- |
| `&&`      | ET (AND)      | `age >= 18 && age < 65` |
| `         |               | `                       | OU (OR) | `jour == 6 \|\| jour == 7` |
| `!`       | NON (NOT)     | `!estMajeur`            |

> 💡 `&&` = toutes les conditions doivent être vraies  
> 💡 `||` = au moins une condition doit être vraie

## Exemple : Conditions multiples

```java
public class EntrerBar {
    public static void main(String[] args) {
        int age = 20;
        boolean aCarteIdentite = true;

        if (age >= 18 && aCarteIdentite) {
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
public class EconomiserArgent {
    public static void main(String[] args) {
        final int OBJECTIF = 300;
        int economiesHebdo = 50;
        int total = 0;
        int semaine = 0;

        while (total < OBJECTIF) {
            semaine++;
            total += economiesHebdo;
            System.out.println("Semaine " + semaine + " : " + total + " francs");
        }

        System.out.println("Objectif atteint en " + semaine + " semaines !");
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
int compteur = 0;           // 1. Initialisation
while (compteur < 5) {      // 2. Condition
    System.out.println(compteur);
    compteur++;             // 3. Modification
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
public class ArroserPlantes {
    public static void main(String[] args) {
        final int NOMBRE_PLANTES = 5;

        System.out.println("J'ai " + NOMBRE_PLANTES + " plantes à arroser");

        for (int plante = 1; plante <= NOMBRE_PLANTES; plante++) {
            System.out.println("J'arrose la plante numéro " + plante);
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
public class TableMultiplication {
    public static void main(String[] args) {
        final int NOMBRE = 5;

        System.out.println("Table de multiplication de " + NOMBRE + " :");

        for (int i = 1; i <= 10; i++) {
            int resultat = NOMBRE * i;
            System.out.println(NOMBRE + " x " + i + " = " + resultat);
        }
    }
}
```

## Quand utiliser while vs for ?

**Utilisez `while` quand :**

- ❓ Vous ne connaissez pas le nombre d'itérations à l'avance
- 📊 La condition d'arrêt dépend d'un événement
- 💰 Exemple : économiser jusqu'à atteindre un objectif

**Utilisez `for` quand :**

- ✅ Vous connaissez exactement le nombre d'itérations
- 🔢 Vous voulez parcourir une séquence de nombres
- 🌱 Exemple : arroser 5 plantes, compter de 1 à 10

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
int nombreDePommes;
double prixTotal;
final int AGE_MAJORITE = 18;
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
    if (aPermis) {
        System.out.println("Peut conduire");
    }
}

// ❌ Mauvais - Difficile à lire
if (age >= 18) {
System.out.println("Majeur");
if (aPermis) {
System.out.println("Peut conduire");
}
}
```

## 💬 Commentaires utiles

```java
// ✅ Bon - Explique le "pourquoi"
final double TVA_SUISSE = 0.077;  // Taux défini par la loi suisse

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
