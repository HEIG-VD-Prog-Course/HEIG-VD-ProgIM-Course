---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
title: HEIG-VD ProgIM1 Course - Bibliothèques et packages
description: Cours sur les bibliothèques et packages pour l'unité d'enseignement ProgIM1 enseigné à la HEIG-VD, Suisse
url: https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/08.01-bibliotheques-et-packages/01-supports-de-cours/index.html
header: "**Bibliothèques et packages**"
footer: '[**HEIG-VD**](https://heig-vd.ch) - [ProgIM1 2025-2026](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course) - [CC BY-SA 4.0](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md)'
headingDivider: 2
math: mathjax
-->

# Bibliothèques et packages

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

- Comprendre le concept de package et son utilité.
- Organiser son code en packages.
- Importer et utiliser des classes d'autres packages.
- Utiliser les bibliothèques standard Java (java.util, java.time, java.io).
- Lire la documentation Java (Javadoc).
- Comprendre la visibilité et l'encapsulation.

![bg right:40%][illustration-objectifs]

## Pourquoi les packages ?

Les packages organisent le code comme les dossiers organisent les fichiers.

**Avantages :**

- **Organisation** : Regrouper les classes par fonctionnalité
- **Réutilisation** : Faciliter l'utilisation dans d'autres projets
- **Éviter les conflits** : Deux classes peuvent avoir le même nom si elles sont
  dans des packages différents
- **Contrôle d'accès** : Gérer la visibilité

**Analogie :** Une bibliothèque avec des livres classés par thème.

## Déclarer un package

Le package est déclaré en première ligne du fichier :

```java
package models;

public class Student {
    private String name;
    private int age;

    // ... constructeurs et méthodes
}
```

**Convention de nommage :**

- Tout en minuscules : `models`, `utils`, `services`
- Structure hiérarchique : `ch.heigvd.project.models`
- Nom de domaine inversé : `ch.heigvd.bank.models`

## Structure de dossiers

Les packages correspondent à une structure de dossiers :

```text
src/
├── ch/
│   └── heigvd/
│       └── bank/
│           ├── models/
│           │   ├── Account.java
│           │   └── Customer.java
│           └── services/
│               └── BankService.java
```

Le package `ch.heigvd.bank.models` correspond au dossier
`src/ch/heigvd/bank/models/`.

## Importer des classes

Pour utiliser une classe d'un autre package, il faut l'importer :

**Import spécifique (recommandé) :**

```java
import java.util.ArrayList;
import java.util.Scanner;
```

**Import avec wildcard :**

```java
import java.util.*;  // Importe toutes les classes de java.util
```

**Import statique :**

```java
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
```

## Package java.lang

Le package `java.lang` est automatiquement importé. Il contient :

- `String` : Chaînes de caractères
- `System` : Système (entrées/sorties)
- `Math` : Fonctions mathématiques
- `Integer`, `Double`, `Boolean` : Wrappers
- `Object` : Classe mère de toutes les classes

**Pas besoin de les importer !**

## Bibliothèque java.util

Package d'utilitaires essentiels :

**Collections :**

```java
import java.util.ArrayList;
import java.util.HashMap;

ArrayList<String> list = new ArrayList<>();
HashMap<String, Integer> map = new HashMap<>();
```

**Scanner :**

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
```

**Random :**

```java
import java.util.Random;

Random random = new Random();
int dice = random.nextInt(6) + 1;
```

## Bibliothèque java.time

Gestion moderne des dates et heures (Java 8+) :

**LocalDate :**

```java
import java.time.LocalDate;

LocalDate today = LocalDate.now();
LocalDate birthDate = LocalDate.of(2000, 5, 15);

int age = today.getYear() - birthDate.getYear();
```

**LocalTime :**

```java
import java.time.LocalTime;

LocalTime now = LocalTime.now();
LocalTime meeting = LocalTime.of(14, 30);  // 14h30
```

## Bibliothèque java.time (suite)

**LocalDateTime :**

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

LocalDateTime now = LocalDateTime.now();

DateTimeFormatter formatter =
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
String formattedDate = now.format(formatter);
```

**Period :**

```java
Period period = Period.between(start, end);
System.out.println(period.getYears() + " ans");
```

## Bibliothèque java.io

Gestion des entrées/sorties (fichiers) :

**Lecture :**

```java
import java.io.BufferedReader;
import java.io.FileReader;

try (BufferedReader reader = new BufferedReader(
        new FileReader("data.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}
```

**Écriture :**

```java
try (BufferedWriter writer = new BufferedWriter(
        new FileWriter("output.txt"))) {
    writer.write("Contenu du fichier");
}
```

## Bibliothèque java.math

Calculs de haute précision :

**BigInteger (entiers très grands) :**

```java
import java.math.BigInteger;

BigInteger a = new BigInteger("123456789012345678901234567890");
BigInteger b = new BigInteger("987654321098765432109876543210");

BigInteger sum = a.add(b);
```

**BigDecimal (décimaux précis) :**

```java
import java.math.BigDecimal;

BigDecimal price = new BigDecimal("19.99");
BigDecimal quantity = new BigDecimal("3");
BigDecimal total = price.multiply(quantity);
```

## Modificateurs d'accès

Contrôlent la visibilité des classes et membres :

| Modificateur | Classe | Package | Sous-classe | Monde |
| ------------ | ------ | ------- | ----------- | ----- |
| public       | ✓      | ✓       | ✓           | ✓     |
| protected    | ✓      | ✓       | ✓           | ✗     |
| (aucun)      | ✓      | ✓       | ✗           | ✗     |
| private      | ✓      | ✗       | ✗           | ✗     |

**Bonne pratique :** Utiliser `private` par défaut, `public` seulement si
nécessaire.

## Exemple de visibilité

```java
package models;

public class BankAccount {
    private double balance;  // Accessible uniquement dans cette classe

    public void deposit(double amount) {  // Accessible partout
        if (amount > 0) {
            balance += amount;
        }
    }

    double getBalance() {  // Package-private (accessible dans 'models')
        return balance;
    }
}
```

## Documentation Java (Javadoc)

**Lire la Javadoc :**

Documentation officielle de l'API Java :
[docs.oracle.com/en/java/javase/17/docs/api/](https://docs.oracle.com/en/java/javase/17/docs/api/)

**Utilisation :**

1. Rechercher le package (ex: `java.util`)
2. Cliquer sur la classe (ex: `ArrayList`)
3. Lire la description, constructeurs et méthodes

**Essentiel pour apprendre à utiliser de nouvelles classes !**

## Écrire de la Javadoc

Documenter votre code avec des commentaires spéciaux :

```java
/**
 * Représente un compte bancaire simple.
 *
 * @author V. Guidoux
 * @version 1.0
 */
public class BankAccount {
    /**
     * Dépose un montant sur le compte.
     *
     * @param amount le montant à déposer
     * @return le nouveau solde
     */
    public double deposit(double amount) {
        // ...
    }
}
```

## Balises Javadoc courantes

- `@param` : Décrit un paramètre
- `@return` : Décrit la valeur de retour
- `@throws` : Décrit une exception
- `@author` : Indique l'auteur
- `@version` : Indique la version
- `@see` : Référence à une autre classe/méthode

**Bonne pratique :** Documenter toutes les classes et méthodes publiques.

## Points clés à retenir

- Les **packages** organisent le code de manière logique.
- On déclare un package avec `package nom.du.package`.
- On importe des classes avec `import`.
- Java fournit de nombreuses **bibliothèques standard** :
  - `java.util` : Utilitaires et collections
  - `java.time` : Dates et heures
  - `java.io` : Entrées/sorties
  - `java.math` : Calculs précis
- Les **modificateurs d'accès** contrôlent la visibilité.
- La **Javadoc** est la documentation de référence.

![bg right:40%][illustration-conclusion]

## À vous de jouer !

- Relire le support de cours.
- Explorer les exemples de code.
- Faire les exercices.
- Consulter la Javadoc pour découvrir de nouvelles classes.
- Poser des questions si nécessaire.

**La programmation s'apprend par la pratique !**

![bg right:40%][illustration-a-vous-de-jouer]

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## Sources

- [Illustration objectifs][illustration-objectifs] par
  [Aline de Nadai](https://unsplash.com/@alinedenadai) sur
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
- [Illustration conclusion][illustration-conclusion] par
  [Susan Q Yin](https://unsplash.com/@syinq) sur
  [Unsplash](https://unsplash.com/photos/2JIvboGLeho)
- [Illustration à vous de jouer][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/FJFPuE1MAOM)

<!-- URLs -->

[presentation-web]:
	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/08.01-bibliotheques-et-packages/01-supports-de-cours/index.html
[presentation-pdf]:
	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/08.01-bibliotheques-et-packages/01-supports-de-cours/08.01-bibliotheques-et-packages-presentation.pdf
[cours]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/08.01-bibliotheques-et-packages/01-supports-de-cours
[license]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1507842217343-583bb7270b66?fit=crop&h=720
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-conclusion]:
	https://images.unsplash.com/photo-1481627834876-b7833e8f5570?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
