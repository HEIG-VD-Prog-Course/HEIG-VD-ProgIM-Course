# Évaluation - Programmation 1

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

---

**Nom :**

**Prénom :**

**Date :** 14 novembre 2024

---

## Instructions

Cette évaluation porte sur les contenus suivants :

- Séquence, sélection et itération
- Variables & Constantes
- Fonctions
- Entrée/sortie/encodage
- Bonnes pratiques

**Durée :** 120 minutes

**Documents autorisés :** Aucun (closed-book)

**Matériel autorisé :** Casque anti-bruit (sans musique)

**Important :** L'évaluation se déroule entièrement sur la plateforme
d'évaluation en ligne. Une documentation sera fournie pour les méthodes Java non
triviales si nécessaire.

> [!CAUTION]
>
> Toute tentative de tricherie entraînera automatiquement la note de 1 pour
> l'ensemble de l'examen, sans discussion possible.

---

## Section 1 : Vrai ou Faux (12 points)

Pour chaque affirmation, indiquez si elle est vraie ou fausse.

**Temps estimé : 10 minutes**

### Question 1 (2 points - Facile)

En Java, une constante déclarée avec le mot-clé `final` peut être modifiée après
son initialisation.

- [ ] Vrai
- [ ] Faux

<details>
<summary>Afficher la réponse</summary>

**Réponse : Faux**

Objectif : Comprendre l'utilisation des constantes en Java

Une constante déclarée avec `final` ne peut **pas** être modifiée après son
initialisation. C'est justement le but d'une constante : sa valeur reste fixe
tout au long de l'exécution du programme.

</details>

### Question 2 (2 points)

Une boucle `while` vérifie sa condition avant d'exécuter le corps de la boucle,
tandis qu'une boucle `do-while` exécute le corps au moins une fois avant de
vérifier la condition.

- [ ] Vrai
- [ ] Faux

<details>
<summary>Afficher la réponse</summary>

**Réponse : Vrai**

Objectif : Distinguer les différents types de boucles en Java

La boucle `while` vérifie d'abord la condition (elle peut ne jamais s'exécuter
si la condition est fausse dès le début), tandis que la boucle `do-while`
exécute le corps au moins une fois avant de vérifier la condition.

</details>

### Question 3 (2 points)

En Java, les noms de variables doivent toujours commencer par une majuscule
selon les conventions de nommage.

- [ ] Vrai
- [ ] Faux

<details>
<summary>Afficher la réponse</summary>

**Réponse : Faux**

Objectif : Connaître les conventions de nommage en Java

En Java, les noms de variables commencent par une **minuscule** en utilisant la
convention camelCase (exemple : `userName`, `totalPrice`). Les noms de classes
commencent par une majuscule (PascalCase).

</details>

---

## Section 2 : Choix multiples (9 points)

Pour chaque question, cochez la ou les réponses correctes. Plusieurs réponses
peuvent être correctes.

### Question 4 (3 points)

Parmi les déclarations suivantes, lesquelles sont correctes en Java ?

- [ ] `int age = 25;`
- [ ] `double price = 19.99;`
- [ ] `String name = "Alice";`
- [ ] `boolean isValid = 1;`

<details>
<summary>Afficher la réponse</summary>

Objectif : Identifier les déclarations de variables correctes en Java

Réponses correctes :

- [x] `int age = 25;` **(1 point)** - Déclaration correcte d'un entier
- [x] `double price = 19.99;` **(1 point)** - Déclaration correcte d'un nombre
      décimal
- [x] `String name = "Alice";` **(1 point)** - Déclaration correcte d'une chaîne
      de caractères
- [ ] `boolean isValid = 1;` - **Incorrecte** : en Java, un booléen doit être
      `true` ou `false`, pas `1` ou `0`

</details>

### Question 5 (3 points)

Quelle(s) affirmation(s) est/sont vraie(s) concernant les méthodes en Java ?

- [ ] Une méthode peut retourner une valeur avec le mot-clé `return`
- [ ] Une méthode peut avoir plusieurs paramètres séparés par des virgules
- [ ] Une méthode `void` doit toujours contenir une instruction `return`
- [ ] Une méthode peut être appelée depuis la méthode `main`

<details>
<summary>Afficher la réponse</summary>

Objectif : Comprendre les caractéristiques des méthodes en Java

Réponses correctes :

- [x] Une méthode peut retourner une valeur avec le mot-clé `return` **(1
      point)**
- [x] Une méthode peut avoir plusieurs paramètres séparés par des virgules **(1
      point)**
- [ ] Une méthode `void` doit toujours contenir une instruction `return` -
      **Faux** : une méthode `void` n'est pas obligée d'avoir un `return`
- [x] Une méthode peut être appelée depuis la méthode `main` **(1 point)**

</details>

### Question 6 (3 points)

Parmi les bonnes pratiques suivantes, lesquelles sont recommandées ?

- [ ] Utiliser des noms de variables courts comme `x`, `y`, `z` pour économiser
      de l'espace
- [ ] Indenter correctement le code pour améliorer la lisibilité
- [ ] Utiliser des constantes pour les valeurs qui ne changent pas
- [ ] Écrire des commentaires pour expliquer le "pourquoi" et non le "quoi"

<details>
<summary>Afficher la réponse</summary>

Objectif : Identifier les bonnes pratiques de programmation

Réponses correctes :

- [ ] Utiliser des noms de variables courts comme `x`, `y`, `z` pour économiser
      de l'espace - **Faux** : préférer des noms explicites
- [x] Indenter correctement le code pour améliorer la lisibilité **(1 point)**
- [x] Utiliser des constantes pour les valeurs qui ne changent pas **(1 point)**
- [x] Écrire des commentaires pour expliquer le "pourquoi" et non le "quoi" **(1
      point)**

</details>

---

## Section 3 : Questions à développement (12 points)

Répondez aux questions suivantes de manière concise et précise.

### Question 7 (4 points)

Expliquez la différence entre une boucle `for` et une boucle `while`. Dans
quelle situation préféreriez-vous utiliser l'une plutôt que l'autre ?

**Réponse :**

```


```

<details>
<summary>Afficher la réponse</summary>

Objectif : Distinguer les différents types de boucles et leur utilisation

**Réponse attendue :**

- Boucle `for` : utilisée quand on connaît le nombre d'itérations à l'avance
  **(1 point)**. Elle regroupe l'initialisation, la condition et
  l'incrémentation en un seul endroit **(1 point)**.

- Boucle `while` : utilisée quand le nombre d'itérations dépend d'une condition
  qui peut changer dynamiquement **(1 point)**.

- Exemple d'utilisation : on préfère `for` pour parcourir un tableau ou afficher
  les nombres de 1 à 10, et `while` pour lire des données jusqu'à ce que
  l'utilisateur entre "stop" **(1 point)**.

</details>

### Question 8 (4 points)

Qu'est-ce qu'un `Scanner` en Java ? Expliquez son rôle et donnez un exemple
d'utilisation pour lire une chaîne de caractères saisie par l'utilisatrice.

**Ressource :**

```java
Scanner scanner = new Scanner(System.in);
Scanner scanner = new Scanner(System.out);
System.out.println();
System.out.print();
scanner.nextLine();
scanner.nextInt();
scanner.close();
```

**Réponse :**

```


```

<details>
<summary>Afficher la réponse</summary>

Objectif : Comprendre l'utilisation du Scanner pour l'entrée utilisateur

**Réponse attendue :**

- Le `Scanner` est une classe Java qui permet de lire des données saisies par
  l'utilisatrice depuis le clavier (System.in) **(1 point)**.

- Il fournit des méthodes pour lire différents types de données (nextInt(),
  nextDouble(), nextLine(), etc.) **(1 point)**.

- Exemple d'utilisation **(2 points)** :

```java
Scanner scanner = new Scanner(System.in);
System.out.print("Entrez votre nom : ");
String name = scanner.nextLine();
scanner.close();
```

</details>

### Question 9 (4 points)

Expliquez pourquoi il est important d'utiliser des noms de variables explicites
en anglais dans votre code. Donnez un exemple d'un mauvais nom de variable et de
son amélioration.

**Réponse :**

```


```

<details>
<summary>Afficher la réponse</summary>

Objectif : Comprendre l'importance des conventions de nommage

**Réponse attendue :**

- Les noms explicites rendent le code plus lisible et compréhensible **(1
  point)**.

- L'anglais est la langue universelle de la programmation, facilitant la
  collaboration et la compatibilité avec les bibliothèques **(1 point)**.

- Exemple de mauvais nom : `x`, `tmp`, `n`, `prix` **(1 point)**.

- Amélioration : `totalPrice`, `studentCount`, `userName`, `temperature` **(1
  point)**.

</details>

---

## Section 4 : Exercices de programmation (33 points)

Pour chaque exercice, écrivez le code Java demandé. Votre code doit être correct
syntaxiquement, bien formaté et respecter les bonnes pratiques vues en cours.

### Question 10 (9 points)

Écrivez un programme Java qui :

1. Demande à l'utilisatrice de saisir deux nombres entiers
2. Calcule et affiche leur somme
3. Calcule et affiche leur produit
4. Détermine et affiche lequel des deux nombres est le plus grand (ou s'ils sont
   égaux)

**Ressource :**

```java
Scanner scanner = new Scanner(System.in);
System.out.println();
System.out.print();
scanner.nextLine();
scanner.nextInt();
scanner.close();
```

**Votre code :**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Écrivez votre code ici






























    }
}
```

<details>
<summary>Afficher la réponse</summary>

Objectifs : Utiliser Scanner pour lire des données / Effectuer des calculs /
Utiliser des structures conditionnelles

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 1 point

        System.out.print("Premier nombre : ");
        int firstNumber = scanner.nextInt(); // 1 point

        System.out.print("Deuxième nombre : ");
        int secondNumber = scanner.nextInt(); // 1 point

        int sum = firstNumber + secondNumber; // 1 point
        int product = firstNumber * secondNumber; // 1 point

        System.out.println("Somme : " + sum);
        System.out.println("Produit : " + product);

        // 4 points pour la structure conditionnelle complète
        if (firstNumber > secondNumber) {
            System.out.println(firstNumber + " est plus grand"); // 1 point
        } else if (firstNumber < secondNumber) {
            System.out.println(secondNumber + " est plus grand"); // 1 point
        } else {
            System.out.println("Les deux nombres sont égaux"); // 1 point
        }

        scanner.close(); // 1 point
    }
}
```

</details>

### Question 11 (12 points)

Créez une méthode `calculateAverageGrade` qui prend trois notes (de type
`double`) en paramètres et retourne leur moyenne.

Ensuite, dans la méthode `main` :

1. Demandez trois notes à l'utilisatrice
2. Appelez votre méthode pour calculer la moyenne
3. Affichez la moyenne calculée
4. Affichez "Réussi" si la moyenne est supérieure ou égale à 4.0, sinon affichez
   "Échoué"

Le bouton "CODE CHECK" vous permet de tester votre code. il simule une
interaction et va mettre `5.5` pour la première note, `4` pour la deuxième note
et `4.5` pour la dernière.

**Ressource :**

```java
Scanner scanner = new Scanner(System.in);
Scanner scanner = new Scanner(System.out);
System.out.println();
System.out.print();
scanner.nextLine();
scanner.nextInt();
scanner.close();
```

**Votre code :**

```java
import java.util.Scanner;

public class Main {

    // Créez votre méthode calculateAverageGrade ici













    public static void main(String[] args) {
        // Écrivez votre code ici






























    }
}
```

<details>
<summary>Afficher la réponse</summary>

Objectifs : Créer et utiliser des méthodes / Passer des paramètres / Utiliser
une valeur de retour

```java
import java.util.Scanner;

public class Main {

    // 4 points pour la méthode complète
    public static double calculateAverageGrade(double grade1, double grade2, double grade3) {
        // Signature correcte : 2 points
        return (grade1 + grade2 + grade3) / 3.0; // Calcul et retour : 2 points
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 1 point

        System.out.print("Note 1 : ");
        double grade1 = scanner.nextDouble(); // 1 point

        System.out.print("Note 2 : ");
        double grade2 = scanner.nextDouble(); // 1 point

        System.out.print("Note 3 : ");
        double grade3 = scanner.nextDouble(); // 1 point

        double average = calculateAverageGrade(grade1, grade2, grade3); // 2 points

        System.out.println("Moyenne : " + average); // 1 point

        // 1 point pour la structure conditionnelle
        if (average >= 4.0) {
            System.out.println("Réussi");
        } else {
            System.out.println("Échoué");
        }

        scanner.close();
    }
}
```

</details>

### Question 12 (12 points)

Écrivez un programme Java qui affiche les nombres de 1 à 20, mais :

- Pour les multiples de 3, affichez "Fizz" au lieu du nombre
- Pour les multiples de 5, affichez "Buzz" au lieu du nombre
- Pour les multiples de 3 ET de 5, affichez "FizzBuzz" au lieu du nombre
- Pour les autres nombres, affichez simplement le nombre

Exemple de sortie attendue :

```text
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
16
17
Fizz
19
Buzz
```

**Votre code :**

```java
public class Main {
    public static void main(String[] args) {
        // Écrivez votre code ici






























    }
}
```

<details>
<summary>Afficher la réponse</summary>

Objectifs : Utiliser des boucles / Utiliser l'opérateur modulo / Utiliser des
structures conditionnelles imbriquées

```java
public class Main {
    public static void main(String[] args) {
        // 3 points pour la structure de boucle correcte
        for (int i = 1; i <= 20; i++) {
            // 9 points pour la logique conditionnelle complète
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz"); // 3 points
            } else if (i % 3 == 0) {
                System.out.println("Fizz"); // 2 points
            } else if (i % 5 == 0) {
                System.out.println("Buzz"); // 2 points
            } else {
                System.out.println(i); // 2 points
            }
        }
    }
}
```

**Note importante** : L'ordre des conditions est crucial ! Il faut d'abord
tester si le nombre est divisible par 3 ET 5, sinon "FizzBuzz" ne sera jamais
affiché.

</details>

---

## Barème de notation

| Section                        | Points possibles |
| ------------------------------ | ---------------- |
| Section 1 : Vrai ou Faux       | 6                |
| Section 2 : Choix multiples    | 9                |
| Section 3 : Questions à dév.   | 12               |
| Section 4 : Exercices de prog. | 33               |
| **Total**                      | **60**           |

---

**Bonne chance !**

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
