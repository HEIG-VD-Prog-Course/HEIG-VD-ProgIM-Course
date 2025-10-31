# Questionnaires de Programmation Java - Questions et Réponses

Ce document compile toutes les questions des questionnaires de programmation
Java avec leurs solutions correspondantes.

## Table des matières

- [Table des matières](#table-des-matières)
- [Questionnaire 01 - Introduction à Java](#questionnaire-01---introduction-à-java)
  - [1. Que signifie l'acronyme JDK ?](#1-que-signifie-lacronyme-jdk-)
  - [2. Que doit-on installer sur son ordinateur pour pouvoir écrire et exécuter facilement un programme écrit en Java ?](#2-que-doit-on-installer-sur-son-ordinateur-pour-pouvoir-écrire-et-exécuter-facilement-un-programme-écrit-en-java-)
  - [3. Qu'est ce qu'un algorithme ?](#3-quest-ce-quun-algorithme-)
  - [4. Un programme Java est constitué de deux blocs encastrés. Comment se nomment ces deux blocs et à quoi servent-ils ?](#4-un-programme-java-est-constitué-de-deux-blocs-encastrés-comment-se-nomment-ces-deux-blocs-et-à-quoi-servent-ils-)
  - [5. Quel est le rôle du compilateur java ?](#5-quel-est-le-rôle-du-compilateur-java-)
  - [6. Que contient le JDK ?](#6-que-contient-le-jdk-)
  - [7. Qu'est-ce qu'une variable ?](#7-quest-ce-quune-variable-)
  - [8. Quelle sont les règles de nommage d'une variable ?](#8-quelle-sont-les-règles-de-nommage-dune-variable-)
  - [9. Citez les huit types primitifs de java](#9-citez-les-huit-types-primitifs-de-java)
  - [10. Veuillez indiquer le résultat de l'exécution des expressions suivantes :](#10-veuillez-indiquer-le-résultat-de-lexécution-des-expressions-suivantes-)
  - [11. Quelle différence y a-t-il entre les opérateurs : `=` et `==` ?](#11-quelle-différence-y-a-t-il-entre-les-opérateurs---et--)
- [Questionnaire 02 - Structures de contrôle](#questionnaire-02---structures-de-contrôle)
  - [1. Veuillez écrire un programme permettant d'afficher le caractère " (un seul double-guillemet)](#1-veuillez-écrire-un-programme-permettant-dafficher-le-caractère--un-seul-double-guillemet)
  - [2. Quel est le caractère correspondant au code décimal 49 ?](#2-quel-est-le-caractère-correspondant-au-code-décimal-49-)
  - [3. Le bloc SI permet de choisir deux chemins distincts dans un programme. Que faire si nous sommes en face d'un cas où il y a trois chemins possible ? (Tapez 1 pour un ristretto, 2 pour un expresso, 3 pour un café)](#3-le-bloc-si-permet-de-choisir-deux-chemins-distincts-dans-un-programme-que-faire-si-nous-sommes-en-face-dun-cas-où-il-y-a-trois-chemins-possible--tapez-1-pour-un-ristretto-2-pour-un-expresso-3-pour-un-café)
  - [4. Que faire si nous sommes en face d'un cas où il y a quatre chemins possible ? (Tapez 1 pour un ristretto, 2 pour un expresso, 3 pour un café, 4 pour un café-latte)](#4-que-faire-si-nous-sommes-en-face-dun-cas-où-il-y-a-quatre-chemins-possible--tapez-1-pour-un-ristretto-2-pour-un-expresso-3-pour-un-café-4-pour-un-café-latte)
  - [5. Soit l'instruction suivante : `x = "1" + "2";` De quel type doit être la variable x ?](#5-soit-linstruction-suivante--x--1--2-de-quel-type-doit-être-la-variable-x-)
  - [6. Soit l'instruction suivante : `x = a && b;` De quel type doit être la variable x ?](#6-soit-linstruction-suivante--x--a--b-de-quel-type-doit-être-la-variable-x-)
  - [7. Que signifie l'opérateur || ?](#7-que-signifie-lopérateur--)
  - [8. A quoi sert la machine virtuelle java ?](#8-a-quoi-sert-la-machine-virtuelle-java-)
  - [9. Quelle est l'extension "habituelle" du code source d'un programme Java ?](#9-quelle-est-lextension-habituelle-du-code-source-dun-programme-java-)
  - [10. Quelle est l'extension du bytecode d'un programme Java ?](#10-quelle-est-lextension-du-bytecode-dun-programme-java-)
- [Questionnaire 03 - Boucles et structures itératives](#questionnaire-03---boucles-et-structures-itératives)
  - [1. Pourquoi est-il dangereux dans un programme de comparer deux réels avec l'opérateur == ?](#1-pourquoi-est-il-dangereux-dans-un-programme-de-comparer-deux-réels-avec-lopérateur--)
  - [2. Comment compare-t-on deux réels entre eux (sans l'opérateur ==) ?](#2-comment-compare-t-on-deux-réels-entre-eux-sans-lopérateur--)
  - [3. Quelle est la question ou les questions à se poser pour choisir le bon type de boucle ?](#3-quelle-est-la-question-ou-les-questions-à-se-poser-pour-choisir-le-bon-type-de-boucle-)
  - [4. Qu'est ce qui différencie la boucle do...while de la boucle while ?](#4-quest-ce-qui-différencie-la-boucle-dowhile-de-la-boucle-while-)
  - [5. La boucle for nécessite trois instructions (dans ses parenthèses) pour pouvoir fonctionner. Quelles sont-elles ?](#5-la-boucle-for-nécessite-trois-instructions-dans-ses-parenthèses-pour-pouvoir-fonctionner-quelles-sont-elles-)
  - [6. A quoi doit-on faire attention lors de l'utilisation d'une boucle do...while ou d'une boucle while ?](#6-a-quoi-doit-on-faire-attention-lors-de-lutilisation-dune-boucle-dowhile-ou-dune-boucle-while-)
  - [7. Soit la boucle suivante : `while (hasLifeLeft || points>=1000)` Quelle(s) condition(s) doit/doivent être réunie(s) pour qu'on puisse quitter la boucle ?](#7-soit-la-boucle-suivante--while-haslifeleft--points1000-quelles-conditions-doitdoivent-être-réunies-pour-quon-puisse-quitter-la-boucle-)
  - [8. Quelle est la différence entre les instructions System.out.print(...) et System.out.println(...) ?](#8-quelle-est-la-différence-entre-les-instructions-systemoutprint-et-systemoutprintln-)
  - [9. Quelle est la différence entre ces deux boucles for ?](#9-quelle-est-la-différence-entre-ces-deux-boucles-for-)
  - [10. A quoi sert le "debugger" ?](#10-a-quoi-sert-le-debugger-)
- [Questionnaire 04 - Tableaux](#questionnaire-04---tableaux)
  - [1. Qu'est ce qu'un tableau ?](#1-quest-ce-quun-tableau-)
  - [2a. Veuillez créer un tableau nommé names contenant trois chaînes de caractères](#2a-veuillez-créer-un-tableau-nommé-names-contenant-trois-chaînes-de-caractères)
  - [2b. Veuillez mettre la valeur "Dominique" dans la première case du tableau names](#2b-veuillez-mettre-la-valeur-dominique-dans-la-première-case-du-tableau-names)
  - [2c. Veuillez mettre la valeur "Claude" dans la dernière case du tableau names](#2c-veuillez-mettre-la-valeur-claude-dans-la-dernière-case-du-tableau-names)
  - [2d. Comment peut-on connaître la taille du tableau names ?](#2d-comment-peut-on-connaître-la-taille-du-tableau-names-)
  - [2e. Veuillez écrire le code nécessaire pour afficher toutes les valeurs du tableau](#2e-veuillez-écrire-le-code-nécessaire-pour-afficher-toutes-les-valeurs-du-tableau)
  - [2f. Quel est le contenu de la case du milieu du tableau ?](#2f-quel-est-le-contenu-de-la-case-du-milieu-du-tableau-)
  - [3. Soit le code suivant, qu'affichera la ligne `System.out.println(array);` ?](#3-soit-le-code-suivant-quaffichera-la-ligne-systemoutprintlnarray-)
  - [4. Lors de la création d'un tableau (en java) chaque case contient une valeur par défaut. Veuillez indiquer pour chaque type (primitifs et objet) la valeur par défaut.](#4-lors-de-la-création-dun-tableau-en-java-chaque-case-contient-une-valeur-par-défaut-veuillez-indiquer-pour-chaque-type-primitifs-et-objet-la-valeur-par-défaut)
  - [5. Exercice pratique : Écrire un programme permettant à l'utilisateur d'estimer la durée d'une seconde (10 essais)](#5-exercice-pratique--écrire-un-programme-permettant-à-lutilisateur-destimer-la-durée-dune-seconde-10-essais)
- [Questionnaire 05 - Fonctions](#questionnaire-05---fonctions)
  - [1. Qu'est ce qu'une fonction ?](#1-quest-ce-quune-fonction-)
  - [2. Quelle sont les règles de nommage d'une fonction (en java) ?](#2-quelle-sont-les-règles-de-nommage-dune-fonction-en-java-)
  - [3. Soit le code suivant : `public static void functionName() { ... }` Que signifie le mot void précédant le nom de la fonction ?](#3-soit-le-code-suivant--public-static-void-functionname----que-signifie-le-mot-void-précédant-le-nom-de-la-fonction-)
  - [4. Que doit-on faire si on désire qu'une fonction retourne un entier (int) ?](#4-que-doit-on-faire-si-on-désire-quune-fonction-retourne-un-entier-int-)
  - [5. Qu'est-ce qu'un paramètre d'une fonction ?](#5-quest-ce-quun-paramètre-dune-fonction-)
  - [6. Comment envoie-t-on une valeur à une fonction ?](#6-comment-envoie-t-on-une-valeur-à-une-fonction-)
  - [7. Combien de paramètres peut avoir une fonction ?](#7-combien-de-paramètres-peut-avoir-une-fonction-)
  - [8. Comment faire pour qu'une fonction retourne deux valeurs (par exemple la valeur min et la valeur max d'un tableau) ?](#8-comment-faire-pour-quune-fonction-retourne-deux-valeurs-par-exemple-la-valeur-min-et-la-valeur-max-dun-tableau-)
  - [9. Qu'affichera l'exécution du code suivant ?](#9-quaffichera-lexécution-du-code-suivant-)
  - [10. Veuillez écrire le code nécessaire dans la fonction main(...) pour voir le contenu du tableau retourné par la fonction returnArray() (Une valeur par ligne).](#10-veuillez-écrire-le-code-nécessaire-dans-la-fonction-main-pour-voir-le-contenu-du-tableau-retourné-par-la-fonction-returnarray-une-valeur-par-ligne)
  - [11. Qu'affichera l'exécution du code suivant ?](#11-quaffichera-lexécution-du-code-suivant-)
- [Questionnaire 06 - Tableaux multidimensionnels](#questionnaire-06---tableaux-multidimensionnels)
  - [1. Qu'affichera l'exécution du code suivant ?](#1-quaffichera-lexécution-du-code-suivant-)
  - [2. Qu'affichera l'exécution du code suivant ?](#2-quaffichera-lexécution-du-code-suivant-)
  - [3. Qu'affichera l'exécution du code suivant ?](#3-quaffichera-lexécution-du-code-suivant-)
  - [4. Soit le tableau à quatre dimensions suivant, veuillez écrire le code de la fonction returnDimensionSize(...) permettant de rendre la taille de la dimension voulue](#4-soit-le-tableau-à-quatre-dimensions-suivant-veuillez-écrire-le-code-de-la-fonction-returndimensionsize-permettant-de-rendre-la-taille-de-la-dimension-voulue)
  - [5. Qu'affichera l'exécution du code suivant ?](#5-quaffichera-lexécution-du-code-suivant-)
  - [6. Qu'affichera l'exécution du code suivant ?](#6-quaffichera-lexécution-du-code-suivant-)
- [Résumé](#résumé)

## Questionnaire 01 - Introduction à Java

### 1. Que signifie l'acronyme JDK ?

<details>
<summary>Réponse</summary>

JDK veut dire (Java Development Kit). En français, c'est le kit de développement
java.

</details>

### 2. Que doit-on installer sur son ordinateur pour pouvoir écrire et exécuter facilement un programme écrit en Java ?

<details>
<summary>Réponse</summary>

- Il est nécessaire de disposer d'un JDK (Java Development Kit)
- Il est recommandé d'installer un environnement de développement qui est une
  surcouche au JDK permettant de développer rapidement et confortablement des
  programmes Java.

</details>

### 3. Qu'est ce qu'un algorithme ?

<details>
<summary>Réponse</summary>

Un algorithme est la suite logique de tous les ordres nécessaires pour résoudre
un problème.

</details>

### 4. Un programme Java est constitué de deux blocs encastrés. Comment se nomment ces deux blocs et à quoi servent-ils ?

<details>
<summary>Réponse</summary>

```java
// Le premier bloc représente la classe associée au programme.
public class Program1 {
    // Le second bloc représente la fonction principale (main()) du programme.
    public static void main(String[] args) {

    }
}
```

Le premier bloc commence à la ligne 2 et finit à la ligne 8  
Le second bloc commence à la ligne 5 et finit à la ligne 7  
Le premier bloc contient le second bloc

Tout programme doit contenir ces deux blocs, sinon le programme ne pourra pas
s'exécuter.

</details>

### 5. Quel est le rôle du compilateur java ?

<details>
<summary>Réponse</summary>

Le rôle du compilateur java est de traduire le code source (langage humain) en
bytecode (langage machine) que la machine virtuelle va pouvoir interpréter.

</details>

### 6. Que contient le JDK ?

<details>
<summary>Réponse</summary>

Le JDK contient :

- Un compilateur
- Le JRE (Java Runtime Environment)
- Tout ce qui est nécessaire pour pouvoir exécuter un programme java (dont la
  machine virtuelle)
- Une bibliothèque de classes (Code java déjà écrit)

</details>

### 7. Qu'est-ce qu'une variable ?

<details>
<summary>Réponse</summary>

Une variable est un symbole qui associe un nom (l'identifiant) à une valeur. Le
nom doit être un identifiant unique.

</details>

### 8. Quelle sont les règles de nommage d'une variable ?

<details>
<summary>Réponse</summary>

- Toujours commencer par une lettre minuscule [a-z] (donc ne peut pas commencer
  par un chiffre)
- Utiliser le camel-case si la variable contient plusieurs noms (Ex :
  `ceciEstUnNomDeVariableRelativementFacileALire`)
- Pas d'espaces, pas de caractères accentués, pas de caractères spéciaux

</details>

### 9. Citez les huit types primitifs de java

<details>
<summary>Réponse</summary>

- **Entiers** : `byte`, `short`, `int`, `long`
- **Réels** : `float`, `double`
- **Caractère** : `char`
- **Booléen** : `boolean`

</details>

### 10. Veuillez indiquer le résultat de l'exécution des expressions suivantes :

- `System.out.println(9 % 5);`
- `System.out.println(5 / 2);`
- `System.out.println(5 == 2);`
- `System.out.println(5 != 2);`
- `System.out.println(2 + 3 * 4);`
- `System.out.println("2" + 1 + 2);`

<details>
<summary>Réponse</summary>

- Le résultat de `9 % 5` est **4**
- Le résultat de `5 / 2` est **2** !!!
- Le résultat de `5 == 2` est **false**
- Le résultat de `5 != 2` est **true**
- Le résultat de `2 + 3 * 4` est **14**
- Le résultat de `"2" + 1 + 2` est **"212"**

</details>

### 11. Quelle différence y a-t-il entre les opérateurs : `=` et `==` ?

<details>
<summary>Réponse</summary>

**`=` est l'opérateur d'affectation.** Il permet de mettre une donnée dans une
variable. Exemples :

```java
minAge = 12
referenceAge = minAge
```

**`==` est l'opérateur de comparaison.** Il permet de comparer deux données.
Exemples :

```java
a == 12  // Si a vaut 12, retourne true, sinon retourne false
5 == 2   // retourne false
var1 == var2  // Si var1 vaut var2, retourne true, sinon retourne false
```

On peut utiliser les deux opérateurs ensemble :

```java
sontEgaux = a == b  // Il faut que la variable sontEgaux soit de type boolean
```

</details>

---

## Questionnaire 02 - Structures de contrôle

### 1. Veuillez écrire un programme permettant d'afficher le caractère " (un seul double-guillemet)

<details>
<summary>Réponse</summary>

```java
System.out.println((char)34);
// ou
System.out.println("\"");
```

</details>

### 2. Quel est le caractère correspondant au code décimal 49 ?

<details>
<summary>Réponse</summary>

C'est le caractère : **'1'**

```java
System.out.println((char)49);
```

</details>

### 3. Le bloc SI permet de choisir deux chemins distincts dans un programme. Que faire si nous sommes en face d'un cas où il y a trois chemins possible ? (Tapez 1 pour un ristretto, 2 pour un expresso, 3 pour un café)

<details>
<summary>Réponse</summary>

Il faut mettre un SI dans un SI dans un SI

```java
int choice = Clavier.rend_int("Taper 1 pour un ristretto, 2 pour un expresso, 3 pour un café");
if (choice == 1) {
    System.out.println("Voilà votre ristretto");
} else {
    if (choice == 2) {
        System.out.println("Voilà votre expresso");
    } else {
        if (choice == 3) {
            System.out.println("Voilà votre café");
        }
    }
}
```

</details>

### 4. Que faire si nous sommes en face d'un cas où il y a quatre chemins possible ? (Tapez 1 pour un ristretto, 2 pour un expresso, 3 pour un café, 4 pour un café-latte)

<details>
<summary>Réponse</summary>

Il faut mettre un SI dans un SI dans un SI dans un SI (et ainsi de suite)

```java
int choice = Clavier.rend_int("Taper 1 pour un ristretto, 2 pour un expresso, 3 pour un café, 4 pour un café-latte");
if (choice == 1) {
    System.out.println("Voilà votre ristretto");
} else {
    if (choice == 2) {
        System.out.println("Voilà votre expresso");
    } else {
        if (choice == 3) {
            System.out.println("Voilà votre café");
        } else {
            if (choice == 4) {
                System.out.println("Voilà votre café-latte");
            }
        }
    }
}
```

</details>

### 5. Soit l'instruction suivante : `x = "1" + "2";` De quel type doit être la variable x ?

<details>
<summary>Réponse</summary>

Il faut que la variable soit de type **String**  
Le `+`, dans ce cas, correspond à la concaténation (tube de colle)  
x contiendra la chaîne **"12"**

</details>

### 6. Soit l'instruction suivante : `x = a && b;` De quel type doit être la variable x ?

<details>
<summary>Réponse</summary>

Il faut que la variable soit de type **boolean**  
Le `&&` correspond au ET logique (a et b doivent valoir true pour que x vaut
true)

</details>

### 7. Que signifie l'opérateur || ?

<details>
<summary>Réponse</summary>

Il s'agit du **OU logique** (opérateur booléen)

</details>

### 8. A quoi sert la machine virtuelle java ?

<details>
<summary>Réponse</summary>

La machine virtuelle permet d'interpréter le fichier byte-code

</details>

### 9. Quelle est l'extension "habituelle" du code source d'un programme Java ?

<details>
<summary>Réponse</summary>

L'extension est **.java**

</details>

### 10. Quelle est l'extension du bytecode d'un programme Java ?

<details>
<summary>Réponse</summary>

L'extension est **.class**

</details>

---

## Questionnaire 03 - Boucles et structures itératives

### 1. Pourquoi est-il dangereux dans un programme de comparer deux réels avec l'opérateur == ?

<details>
<summary>Réponse</summary>

Car les réels ne sont que des approximations (pas extrêmement précis)

```java
double value = 0.33333333333333;
if (value == 1.0/3) {
    // ON N'ENTRE PAS DANS LE IF !!!!!!!!!
    System.out.println("La valeur vaut un tiers");
}
```

</details>

### 2. Comment compare-t-on deux réels entre eux (sans l'opérateur ==) ?

<details>
<summary>Réponse</summary>

On les compare en tenant compte d'une tolérance admissible de l'imprécision.

```java
if (Math.abs(targetValue - realValue) <= allowableTolerance) {
    // ...
}
```

</details>

### 3. Quelle est la question ou les questions à se poser pour choisir le bon type de boucle ?

<details>
<summary>Réponse</summary>

**"Connaît-on le nombre de répétition à faire ?"**

- Si oui ⇒ boucle **for**
- Sinon :

**"Faut-il faire le traitement au moins une fois ?"**

- Si oui ⇒ boucle **do...while**
- Sinon ⇒ boucle **while**

</details>

### 4. Qu'est ce qui différencie la boucle do...while de la boucle while ?

<details>
<summary>Réponse</summary>

- La boucle **do...while** a sa condition à la fin de la boucle (donc se fait au
  moins une fois)
- La boucle **while** a la condition au début de la boucle (donc ne se fait
  peut-être pas)

</details>

### 5. La boucle for nécessite trois instructions (dans ses parenthèses) pour pouvoir fonctionner. Quelles sont-elles ?

<details>
<summary>Réponse</summary>

```java
for (...; ...; ...) {
    // instructions à répéter
}
```

1. **La première** consiste à déclarer une variable de boucle et de lui donner
   une valeur de départ.
2. **La seconde** correspond à la condition pour laquelle on reste dans la
   boucle.
3. **La dernière** sert à indiquer comment la variable de boucle change à chaque
   itération

Exemple :

```java
for (int counter=1; counter<=10; counter++) {
    // instructions à répéter
}
```

</details>

### 6. A quoi doit-on faire attention lors de l'utilisation d'une boucle do...while ou d'une boucle while ?

<details>
<summary>Réponse</summary>

Il faut absolument déclarer toutes les variables nécessaires à l'écriture de la
condition **AVANT** la boucle.

**Exemple d'une boucle qui ne fonctionne pas** car la variable ok n'est pas
déclarée avant la boucle :

```java
do {
    // PIÈGE !!!
    boolean ok;
    ok = ...;
} while (ok);
```

**Voici comment procéder :**

```java
boolean ok;  // BOUCLE FONCTIONNELLE
do {
    ok = ...;
} while (ok);
```

Ceci est dû au fait qu'une variable n'existe que dans le bloc "{ }" dans
laquelle elle est déclarée !

</details>

### 7. Soit la boucle suivante : `while (hasLifeLeft || points>=1000)` Quelle(s) condition(s) doit/doivent être réunie(s) pour qu'on puisse quitter la boucle ?

<details>
<summary>Réponse</summary>

Il faut que la variable `hasLifeLeft` soit à **false**  
**ET** (😉)  
que `points` soit **inférieur à 1000**

</details>

### 8. Quelle est la différence entre les instructions System.out.print(...) et System.out.println(...) ?

<details>
<summary>Réponse</summary>

```java
System.out.print("Bonjour, ");
System.out.println("les amis");
```

- **System.out.print** : Affiche ce qu'il y a dans les parenthèses dans la
  console (sans passer à la ligne)
- **System.out.println** : Affiche ce qu'il y a dans les parenthèses dans la
  console (puis, passe à la ligne)

</details>

### 9. Quelle est la différence entre ces deux boucles for ?

```java
// 1ère boucle
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

// 2ème boucle
int i;
for (i = 0; i < 10; i++) {
    System.out.println(i);
}
```

<details>
<summary>Réponse</summary>

**Dans la première boucle**, la variable de boucle `i` meurt à la fin de la
boucle.  
**Dans la seconde boucle**, la variable de boucle `i` est toujours accessible
après la boucle.

```java
// 1ère boucle
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
System.out.println(i); // PAS POSSIBLE CAR LA VARIABLE i N'EXISTE PLUS

// 2ème boucle
int i;
for (i = 0; i < 10; i++) {
    System.out.println(i);
}
System.out.println(i); // POSSIBLE, CAR LA VARIABLE i EXISTE ENCORE
```

</details>

### 10. A quoi sert le "debugger" ?

<details>
<summary>Réponse</summary>

Le debugger permet d'exécuter le programme en mode "instruction par instruction"
(F8) et de voir l'effet de chacune d'elle sur les variables du programme.

</details>

---

## Questionnaire 04 - Tableaux

### 1. Qu'est ce qu'un tableau ?

<details>
<summary>Réponse</summary>

Un tableau est une structure de données, de taille fixe, regroupant des éléments
de même type.

</details>

### 2a. Veuillez créer un tableau nommé names contenant trois chaînes de caractères

<details>
<summary>Réponse</summary>

```java
String[] names = new String[3];
```

</details>

### 2b. Veuillez mettre la valeur "Dominique" dans la première case du tableau names

<details>
<summary>Réponse</summary>

```java
names[0] = "Dominique";
```

</details>

### 2c. Veuillez mettre la valeur "Claude" dans la dernière case du tableau names

<details>
<summary>Réponse</summary>

```java
names[2] = "Claude";
// ou mieux
names[names.length-1] = "Claude";
```

</details>

### 2d. Comment peut-on connaître la taille du tableau names ?

<details>
<summary>Réponse</summary>

En utilisant la propriété `.length` liée à chaque tableau

```java
System.out.println(names.length);
// ou
int size = names.length;
```

</details>

### 2e. Veuillez écrire le code nécessaire pour afficher toutes les valeurs du tableau

<details>
<summary>Réponse</summary>

```java
for (int i=0; i<=names.length-1; i++) {
    System.out.println(names[i]);
}
```

ou en utilisant une variante de la boucle for :

```java
for (String name : names) {
    System.out.println(name);
}
```

</details>

### 2f. Quel est le contenu de la case du milieu du tableau ?

<details>
<summary>Réponse</summary>

La valeur par défaut d'une case de type String (type objet ⇒ majuscule) est
**null**.  
Cela signifie qu'il n'y a pas de String dans cette case là.

</details>

### 3. Soit le code suivant, qu'affichera la ligne `System.out.println(array);` ?

```java
int[] array = new int[3];
array[0] = 3;
array[1] = 2;
array[2] = 3;
System.out.println(array);
```

<details>
<summary>Réponse</summary>

Cela affichera le contenu de la variable tab et non le contenu des cases du
tableau.  
En d'autre terme : Cela affichera l'adresse (en hexadécimal) de l'objet
tableau.  
**[I@2d98a335** (L'adresse peut être différente chez vous)

</details>

### 4. Lors de la création d'un tableau (en java) chaque case contient une valeur par défaut. Veuillez indiquer pour chaque type (primitifs et objet) la valeur par défaut.

<details>
<summary>Réponse</summary>

- **tableau de boolean** : `false`
- **tableau d'entiers** (`byte`, `short`, `int`, `long`) : `0`
- **tableau de réels** (`float`, `double`) : `0.0`
- **tableau de char** : le 1er caractère de la table UNICODE
- **tableau de type objet** (`String`, `Scanner`, ...) : `null`

</details>

### 5. Exercice pratique : Écrire un programme permettant à l'utilisateur d'estimer la durée d'une seconde (10 essais)

<details>
<summary>Réponse</summary>

```java
public class Program {
    public static void main(String[] args) {
        double[] estimates = new double[10];
        double deltaMin = Double.MAX_VALUE;
        double delta;
        int bestAttempt = -1;

        for (int i = 0; i < estimates.length; i++) {
            System.out.println("Essai " + (i+1));
            Clavier.rend_String("Veuillez appuyer sur la touche Enter pour démarrer le chrono ");
            long t1 = System.currentTimeMillis();
            Clavier.rend_String("Veuillez appuyer sur la touche Enter pour stopper le chrono ");
            long t2 = System.currentTimeMillis();
            estimates[i] = (t2-t1)/1000d;
            System.out.println("Votre estimation : " + estimates[i] + " [s]");
            System.out.println();

            delta = Math.abs(1d-estimates[i]);
            if (delta<deltaMin) {
                deltaMin = delta;
                bestAttempt = i+1;
            }
        }

        for (int i = 0; i < estimates.length; i++) {
            System.out.println(i+1 + " essai(s) : " + estimates[i] + " [s]");
        }
        System.out.println("Votre meilleur essai a été le " + bestAttempt + "e avec un écart de " + deltaMin + " [s]");
    }
}
```

</details>

---

## Questionnaire 05 - Fonctions

### 1. Qu'est ce qu'une fonction ?

<details>
<summary>Réponse</summary>

On appelle fonction un sous-programme qui permet d'effectuer un ensemble
d'instructions par simple appel de la fonction dans le corps du programme
principal (ou depuis une autre fonction).

</details>

### 2. Quelle sont les règles de nommage d'une fonction (en java) ?

<details>
<summary>Réponse</summary>

La signature de la fonction doit être unique (nom de la fonction et type des
paramètres de la fonction)

**Exemples :**

- `main(String[])`
- `fonction1()`
- `fonction1(int)`
- `fonction1(int, double)`

**Règles :**

- Commencer par une lettre minuscule
- Peut contenir des chiffres (mais pas au début)
- Pas d'espaces
- Pas de caractères spéciaux

</details>

### 3. Soit le code suivant : `public static void functionName() { ... }` Que signifie le mot void précédant le nom de la fonction ?

<details>
<summary>Réponse</summary>

Cela signifie que la fonction **ne retourne rien**

</details>

### 4. Que doit-on faire si on désire qu'une fonction retourne un entier (int) ?

<details>
<summary>Réponse</summary>

Tout d'abord la fonction doit indiquer qu'elle retourne un entier :

```java
public static int functionThatReturnsInteger() {
    //...
}
```

puis la dernière ligne de la fonction doit comporter un `return...` (pour
retourner la valeur de cet entier) :

```java
public static int functionThatReturnsInteger() {
    // ...
    int valueToReturn = 5;
    return valueToReturn;
}
```

</details>

### 5. Qu'est-ce qu'un paramètre d'une fonction ?

<details>
<summary>Réponse</summary>

Un paramètre est une variable permettant de recevoir une donnée nécessaire au
bon fonctionnement d'une fonction.

```java
public static void parameterizedFunction(int receivedParameter) {
    // ...
    System.out.println(receivedParameter);
    // ...
}
```

</details>

### 6. Comment envoie-t-on une valeur à une fonction ?

<details>
<summary>Réponse</summary>

En la transmettant entre les parenthèses '()' lors de l'appel à la fonction

```java
public static void main(String[] args) {
    int valueToTransmit = 5;
    // appel de la fonction et transmission de la valeur
    parameterizedFunction(valueToTransmit);
}

public static void parameterizedFunction(int receivedParameter) {
    // ...
    System.out.println(receivedParameter);
    // ...
}
```

</details>

### 7. Combien de paramètres peut avoir une fonction ?

<details>
<summary>Réponse</summary>

**Autant que nécessaire**

```java
public static void parameterizedFunction(int param1, int param2, double param3, String param4) {
    //...
}
```

</details>

### 8. Comment faire pour qu'une fonction retourne deux valeurs (par exemple la valeur min et la valeur max d'un tableau) ?

<details>
<summary>Réponse</summary>

Il suffit de placer les deux valeurs dans un tableau et de retourner ce tableau

```java
public static double[] functionThatReturnsMinMax(...) {
    double min;
    double max;
    // ...
    double[] minMaxArray = {min, max};
    return minMaxArray;
}
```

</details>

### 9. Qu'affichera l'exécution du code suivant ?

```java
public class Program {
    public static void main(String[] args) {
        System.out.println(function1());
    }
    public static int function1() {
        System.out.println("function1");
        return 1;
    }
}
```

<details>
<summary>Réponse</summary>

```bash
function1
1
```

</details>

### 10. Veuillez écrire le code nécessaire dans la fonction main(...) pour voir le contenu du tableau retourné par la fonction returnArray() (Une valeur par ligne).

```java
public class Program {
    public static void main(String[] args) {
        // que faut écrire ici ?
    }
    public static int[] returnArray() {
        int[] array = new int[3];
        array[0] = 3;
        array[2] = 1;
        return array;
    }
}
```

<details>
<summary>Réponse</summary>

```java
int[] receivedArray = returnArray();
for (int i=0; i<receivedArray.length; i++) {
    System.out.println(receivedArray[i]);
}
```

</details>

### 11. Qu'affichera l'exécution du code suivant ?

```java
public class Program {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        int c = 7;
        displayValues(a,b,c);
    }
    public static void displayValues(int c, int b, int a) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
```

<details>
<summary>Réponse</summary>

```bash
7
6
5
```

</details>

---

## Questionnaire 06 - Tableaux multidimensionnels

### 1. Qu'affichera l'exécution du code suivant ?

```java
public class Prog {
    public static void main(String[] args) {
        int[][] tab = new int[2][3];
        tab[0][0] = 1;
        tab[0][1] = 2;
        tab[0][2] = 3;
        tab[1][0] = 9;
        tab[1][1] = 8;
        tab[1][2] = 7;
        display(tab);
    }
    public static void display(int[][] anArray) {
        for (int i=0; i<anArray.length; i++) {
            for (int j=0; j<anArray[0].length; j++) {
                System.out.print(anArray[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
```

<details>
<summary>Réponse</summary>

```bash
1 2 3
9 8 7
```

</details>

### 2. Qu'affichera l'exécution du code suivant ?

```java
public class Prog {
    public static void main(String[] args) {
        int[][] array = new int[2][3];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[1][0] = 9;
        array[1][1] = 8;
        array[1][2] = 7;
        display(array);
    }
    public static void display(int[][] anArray) {
        for (int i=0; i<anArray[0].length; i++) {
            for (int j=0; j<anArray.length; j++) {
                System.out.print(anArray[j][i]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
```

<details>
<summary>Réponse</summary>

```bash
1 9
2 8
3 7
```

</details>

### 3. Qu'affichera l'exécution du code suivant ?

```java
public class Prog {
    public static void main(String[] args) {
        int[][] array = new int[2][3];
        array[0][0] = 1; array[0][1] = 2; array[0][2] = 3;
        array[1][0] = 9; array[1][1] = 8; array[1][2] = 7;
        display(array);
    }
    public static void display(int[][] anArray) {
        for (int i=anArray.length-1; i>=0; i--) {
            for (int j=anArray[0].length-1; j>=0; j--) {
                System.out.print(anArray[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
```

<details>
<summary>Réponse</summary>

```bash
7 8 9
3 2 1
```

</details>

### 4. Soit le tableau à quatre dimensions suivant, veuillez écrire le code de la fonction returnDimensionSize(...) permettant de rendre la taille de la dimension voulue

```java
int[][][][] tab = new int[3][2][4][6];
System.out.println(returnDimensionSize(tab, 1)); //3
System.out.println(returnDimensionSize(tab, 2)); //2
System.out.println(returnDimensionSize(tab, 3)); //4
System.out.println(returnDimensionSize(tab, 4)); //6
```

<details>
<summary>Réponse</summary>

```java
public static int returnDimensionSize(int[][][][] anArray, int dimension) {
    int size = -1;
    if (dimension == 1) {
        size = anArray.length;
    } else if (dimension == 2) {
        size = anArray[0].length;
    } else if (dimension == 3) {
        size = anArray[0][0].length;
    } else if (dimension == 4) {
        size = anArray[0][0][0].length;
    }
    return size;
}
```

</details>

### 5. Qu'affichera l'exécution du code suivant ?

```java
boolean[][] hasBeenVisited = new boolean[8][8];
System.out.println(hasBeenVisited[4][2]);
```

<details>
<summary>Réponse</summary>

**false**

La valeur par défaut des cases d'un tableau de booléens est `false` (quelque
soit le nombre de dimensions)

</details>

### 6. Qu'affichera l'exécution du code suivant ?

```java
int[][][][] array = new int[3][2][4][6];
System.out.println(array[2][1][3].length);
```

<details>
<summary>Réponse</summary>

**6**

</details>

---

## Résumé

Ce document compile **6 questionnaires** contenant au total **61 questions**
couvrant les concepts fondamentaux de la programmation Java :

1. **Questionnaire 01** (11 questions) : Introduction à Java, JDK, variables,
   types primitifs
2. **Questionnaire 02** (10 questions) : Structures de contrôle, opérateurs,
   machine virtuelle
3. **Questionnaire 03** (10 questions) : Boucles, comparaisons de réels,
   debugger
4. **Questionnaire 04** (6 questions) : Tableaux, valeurs par défaut, exercice
   pratique
5. **Questionnaire 05** (11 questions) : Fonctions, paramètres, valeurs de
   retour
6. **Questionnaire 06** (6 questions) : Tableaux multidimensionnels

Toutes les réponses sont organisées dans des sections `<details>` pliables pour
faciliter l'apprentissage et la révision.
