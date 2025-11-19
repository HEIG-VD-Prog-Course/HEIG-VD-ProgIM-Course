# Bibliothèques et packages - Supports de cours

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/08.01-bibliotheques-et-packages/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/08.01-bibliotheques-et-packages/01-supports-de-cours/08.01-bibliotheques-et-packages-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/)
- Exercices : [Lien vers le contenu](../03-exercices/README.md)

## Table des matières

- [Ressources annexes](#ressources-annexes)
- [Table des matières](#table-des-matières)
- [Objectifs](#objectifs)
- [Introduction aux packages](#introduction-aux-packages)
- [Les packages en Java](#les-packages-en-java)
  - [Qu'est-ce qu'un package ?](#quest-ce-quun-package-)
  - [Déclarer un package](#déclarer-un-package)
  - [Convention de nommage](#convention-de-nommage)
  - [Structure de dossiers](#structure-de-dossiers)
- [Importer des classes](#importer-des-classes)
  - [Import spécifique](#import-spécifique)
  - [Import avec wildcard](#import-avec-wildcard)
  - [Import statique](#import-statique)
  - [Package java.lang](#package-javalang)
- [Bibliothèques standard de Java](#bibliothèques-standard-de-java)
  - [java.util - Utilitaires](#javautil---utilitaires)
  - [java.time - Date et heure](#javatime---date-et-heure)
  - [java.io - Entrées/Sorties](#javaio---entréessorties)
  - [java.math - Mathématiques avancées](#javamath---mathématiques-avancées)
- [Visibilité et modificateurs d'accès](#visibilité-et-modificateurs-daccès)
  - [Public](#public)
  - [Private](#private)
  - [Protected](#protected)
  - [Package-private (par défaut)](#package-private-par-défaut)
- [La documentation Java (Javadoc)](#la-documentation-java-javadoc)
  - [Lire la Javadoc](#lire-la-javadoc)
  - [Écrire de la Javadoc](#écrire-de-la-javadoc)
- [Conclusion](#conclusion)
- [Exemples de code](#exemples-de-code)
- [Exercices](#exercices)

## Objectifs

À l'issue de ce cours, la personne qui étudie sera capable de :

- Comprendre le concept de package en Java et son utilité.
- Organiser son code en packages de manière cohérente.
- Importer et utiliser des classes provenant d'autres packages.
- Utiliser les principales bibliothèques standard de Java (java.util, java.time,
  java.io).
- Lire et comprendre la documentation Java (Javadoc).
- Créer des programmes modulaires et réutilisables.
- Comprendre les notions de visibilité et d'encapsulation liées aux packages.

## Introduction aux packages

Jusqu'à présent, nous avons écrit tous nos programmes dans des classes simples,
sans organisation particulière. Cependant, lorsque les projets deviennent plus
complexes avec de nombreuses classes, il devient nécessaire de les organiser de
manière structurée.

Les packages en Java sont des conteneurs qui permettent de regrouper des classes
et des interfaces liées entre elles. Ils servent plusieurs objectifs :

- **Organisation** : Regrouper logiquement les classes par fonctionnalité.
- **Réutilisation** : Faciliter l'utilisation de code dans différents projets.
- **Éviter les conflits** : Prévenir les collisions de noms entre classes.
- **Contrôle d'accès** : Gérer la visibilité des classes et de leurs membres.

Imaginons une bibliothèque physique : les livres sont organisés par catégories
(romans, sciences, histoire, etc.). De la même manière, les packages organisent
les classes par thématiques.

## Les packages en Java

### Qu'est-ce qu'un package ?

Un package est un espace de noms qui organise un ensemble de classes et
d'interfaces liées. Java lui-même est organisé en packages :

- `java.lang` : Classes fondamentales (String, Math, System, etc.)
- `java.util` : Utilitaires (collections, dates, random, etc.)
- `java.io` : Entrées/sorties (lecture/écriture de fichiers)
- `java.time` : Gestion moderne des dates et heures
- `java.math` : Mathématiques de précision (BigInteger, BigDecimal)

### Déclarer un package

Pour placer une classe dans un package, on utilise l'instruction `package` en
première ligne du fichier (avant toute import ou déclaration de classe) :

```java
package models;

public class Student {
    private String name;
    private int age;

    // ... constructeurs et méthodes
}
```

Cette classe `Student` appartient maintenant au package `models`.

### Convention de nommage

Par convention, les noms de packages suivent ces règles :

- **Tout en minuscules** : `utils`, `models`, `controllers`
- **Pas de majuscules ni de tirets** : éviter `Utils` ou `my-package`
- **Structure hiérarchique** avec points : `com.example.project.models`
- **Nom de domaine inversé** pour éviter les conflits :
  `ch.heigvd.progim.models`

Exemples de noms de packages :

```java
package ch.heigvd.bank.models;
package ch.heigvd.bank.services;
package ch.heigvd.bank.utils;
```

### Structure de dossiers

Les packages correspondent à une structure de dossiers sur le disque. Par
exemple :

```text
src/
├── ch/
│   └── heigvd/
│       └── bank/
│           ├── models/
│           │   ├── Account.java
│           │   └── Customer.java
│           ├── services/
│           │   └── BankService.java
│           └── utils/
│               └── Calculator.java
```

Le package `ch.heigvd.bank.models` correspond au dossier
`src/ch/heigvd/bank/models/`.

## Importer des classes

Pour utiliser une classe d'un autre package, nous devons l'importer avec
l'instruction `import`.

### Import spécifique

L'import spécifique indique exactement quelle classe nous voulons utiliser :

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // ...
    }
}
```

C'est l'approche recommandée car elle rend le code plus explicite.

### Import avec wildcard

Le wildcard `*` importe toutes les classes d'un package :

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> ages = new HashMap<>();
        // ...
    }
}
```

**Attention** : L'import avec `*` n'importe que les classes du package spécifié,
pas les sous-packages. Par exemple, `import java.util.*` n'importe pas les
classes de `java.util.stream`.

### Import statique

L'import statique permet d'importer des membres statiques (méthodes ou
constantes) :

```java
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        double radius = 5.0;
        double area = PI * radius * radius;
        double diagonal = sqrt(2.0) * 10;

        System.out.println("Aire : " + area);
        System.out.println("Diagonale : " + diagonal);
    }
}
```

Sans import statique, il faudrait écrire `Math.PI` et `Math.sqrt()`.

### Package java.lang

Le package `java.lang` est automatiquement importé dans tous les programmes
Java. Il contient les classes fondamentales :

- `String` : Chaînes de caractères
- `System` : Système (entrées/sorties, etc.)
- `Math` : Fonctions mathématiques
- `Integer`, `Double`, `Boolean` : Wrappers des types primitifs
- `Object` : Classe mère de toutes les classes

Pas besoin d'importer ces classes, elles sont toujours disponibles.

## Bibliothèques standard de Java

Java propose une vaste bibliothèque standard appelée Java API (Application
Programming Interface). Explorons les packages les plus utiles.

### java.util - Utilitaires

Ce package contient des utilitaires essentiels :

**Collections :**

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

ArrayList<String> list = new ArrayList<>();
HashMap<String, Integer> map = new HashMap<>();
HashSet<Integer> set = new HashSet<>();
```

**Scanner :**

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
String name = scanner.nextLine();
```

**Random :**

```java
import java.util.Random;

Random random = new Random();
int dice = random.nextInt(6) + 1;  // 1 à 6
```

**Arrays (déjà vu) :**

```java
import java.util.Arrays;

int[] numbers = {3, 1, 4, 1, 5};
Arrays.sort(numbers);
System.out.println(Arrays.toString(numbers));
```

### java.time - Date et heure

Ce package moderne gère les dates et heures (introduit en Java 8) :

**LocalDate :**

```java
import java.time.LocalDate;

LocalDate today = LocalDate.now();
LocalDate birthDate = LocalDate.of(2000, 5, 15);

int age = today.getYear() - birthDate.getYear();
System.out.println("Âge : " + age);
```

**LocalTime :**

```java
import java.time.LocalTime;

LocalTime now = LocalTime.now();
LocalTime meeting = LocalTime.of(14, 30);  // 14h30

System.out.println("Heure actuelle : " + now);
System.out.println("Réunion à : " + meeting);
```

**LocalDateTime :**

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

LocalDateTime now = LocalDateTime.now();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
String formattedDate = now.format(formatter);

System.out.println("Date et heure : " + formattedDate);
```

**Period et Duration :**

```java
import java.time.LocalDate;
import java.time.Period;

LocalDate start = LocalDate.of(2020, 1, 1);
LocalDate end = LocalDate.of(2025, 11, 3);

Period period = Period.between(start, end);
System.out.println(period.getYears() + " ans, " +
                   period.getMonths() + " mois, " +
                   period.getDays() + " jours");
```

### java.io - Entrées/Sorties

Ce package gère la lecture et l'écriture de fichiers :

**Lecture de fichier :**

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    System.err.println("Erreur de lecture : " + e.getMessage());
}
```

**Écriture de fichier :**

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
    writer.write("Bonjour le monde !");
    writer.newLine();
    writer.write("Deuxième ligne");
} catch (IOException e) {
    System.err.println("Erreur d'écriture : " + e.getMessage());
}
```

### java.math - Mathématiques avancées

Ce package fournit des classes pour des calculs de haute précision :

**BigInteger :**

```java
import java.math.BigInteger;

BigInteger a = new BigInteger("123456789012345678901234567890");
BigInteger b = new BigInteger("987654321098765432109876543210");

BigInteger sum = a.add(b);
BigInteger product = a.multiply(b);

System.out.println("Somme : " + sum);
System.out.println("Produit : " + product);
```

**BigDecimal :**

```java
import java.math.BigDecimal;

BigDecimal price = new BigDecimal("19.99");
BigDecimal quantity = new BigDecimal("3");

BigDecimal total = price.multiply(quantity);
System.out.println("Total : " + total + " CHF");
```

## Visibilité et modificateurs d'accès

Les packages permettent de contrôler la visibilité des classes et de leurs
membres grâce aux modificateurs d'accès.

### Public

Le modificateur `public` rend un élément accessible depuis n'importe où :

```java
package models;

public class Student {
    public String name;  // Accessible partout

    public void sayHello() {  // Accessible partout
        System.out.println("Bonjour !");
    }
}
```

### Private

Le modificateur `private` restreint l'accès à la classe elle-même :

```java
package models;

public class BankAccount {
    private double balance;  // Accessible uniquement dans cette classe

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;  // OK, on est dans la même classe
        }
    }
}
```

### Protected

Le modificateur `protected` permet l'accès dans le même package et aux
sous-classes :

```java
package models;

public class Person {
    protected String name;  // Accessible dans le package et aux sous-classes
}
```

### Package-private (par défaut)

Sans modificateur, l'accès est limité au package :

```java
package models;

class InternalHelper {  // Pas de 'public', accessible uniquement dans 'models'
    void help() {
        // ...
    }
}
```

Récapitulatif de la visibilité :

| Modificateur | Classe | Package | Sous-classe | Monde |
| ------------ | ------ | ------- | ----------- | ----- |
| public       | ✓      | ✓       | ✓           | ✓     |
| protected    | ✓      | ✓       | ✓           | ✗     |
| (aucun)      | ✓      | ✓       | ✗           | ✗     |
| private      | ✓      | ✗       | ✗           | ✗     |

## La documentation Java (Javadoc)

La Javadoc est la documentation officielle de l'API Java. Elle décrit toutes les
classes, méthodes et constantes disponibles.

### Lire la Javadoc

La documentation Java est disponible en ligne :
[https://docs.oracle.com/en/java/javase/17/docs/api/](https://docs.oracle.com/en/java/javase/17/docs/api/)

Pour trouver une classe :

1. Rechercher le package (ex: `java.util`)
2. Cliquer sur la classe (ex: `ArrayList`)
3. Lire la description, les constructeurs et les méthodes

Exemple de lecture de la doc pour `ArrayList` :

- **Description générale** : Présente ce qu'est un ArrayList
- **Constructeurs** : Comment créer un ArrayList
- **Méthodes** : `add()`, `get()`, `remove()`, `size()`, etc.
- **Exemples** : Parfois inclus dans la documentation

### Écrire de la Javadoc

Vous pouvez documenter votre propre code avec des commentaires Javadoc :

```java
package models;

/**
 * Représente un compte bancaire simple.
 *
 * Cette classe permet de gérer le solde d'un compte avec des opérations
 * de dépôt et de retrait.
 *
 * @author V. Guidoux
 * @version 1.0
 */
public class BankAccount {
    private double balance;

    /**
     * Crée un nouveau compte bancaire avec un solde initial.
     *
     * @param initialBalance le solde initial du compte
     * @throws IllegalArgumentException si le solde initial est négatif
     */
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Le solde ne peut pas être négatif");
        }
        this.balance = initialBalance;
    }

    /**
     * Dépose un montant sur le compte.
     *
     * @param amount le montant à déposer (doit être positif)
     * @return le nouveau solde après le dépôt
     */
    public double deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        return balance;
    }

    /**
     * Retourne le solde actuel du compte.
     *
     * @return le solde du compte
     */
    public double getBalance() {
        return balance;
    }
}
```

Les balises Javadoc courantes :

- `@param` : Décrit un paramètre
- `@return` : Décrit la valeur de retour
- `@throws` : Décrit une exception qui peut être levée
- `@author` : Indique l'auteur
- `@version` : Indique la version
- `@see` : Référence à une autre classe ou méthode

## Conclusion

Les packages et bibliothèques sont essentiels pour écrire du code Java
professionnel et maintenable. Ils permettent :

- D'organiser le code de manière logique et structurée.
- De réutiliser du code existant (bibliothèques standard).
- D'éviter les conflits de noms.
- De contrôler la visibilité et l'encapsulation.

Points clés à retenir :

- Un package est déclaré avec `package` en début de fichier.
- Les classes d'autres packages sont importées avec `import`.
- Java fournit de nombreuses bibliothèques standard (`java.util`, `java.time`,
  `java.io`, etc.).
- Les modificateurs d'accès contrôlent la visibilité.
- La Javadoc est la documentation de référence de l'API Java.

Dans les prochains cours, nous continuerons à utiliser ces bibliothèques pour
créer des programmes plus sophistiqués.

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
