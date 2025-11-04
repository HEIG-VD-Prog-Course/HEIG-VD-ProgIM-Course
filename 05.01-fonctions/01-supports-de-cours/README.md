# Cours 05.01 - Fonctions

## Ressources

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/05.01-fonctions/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/05.01-fonctions/01-supports-de-cours/05.01-fonctions-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/)
- Exercices : [Lien vers le contenu](../03-exercices/README.md)

## Table des matières

- [Ressources](#ressources)
- [Table des matières](#table-des-matières)
- [Objectifs](#objectifs)
- [Qu'est-ce qu'une méthode ?](#quest-ce-quune-méthode-)
- [Déclarer une méthode en Java](#déclarer-une-méthode-en-java)
- [Appeler une méthode en Java](#appeler-une-méthode-en-java)
- [Passer des paramètres à une méthode](#passer-des-paramètres-à-une-méthode)
- [Retourner une valeur depuis une méthode](#retourner-une-valeur-depuis-une-méthode)
- [Passer plusieurs paramètres à une méthode](#passer-plusieurs-paramètres-à-une-méthode)
- [Portée des variables](#portée-des-variables)
- [Variables de classe](#variables-de-classe)
- [Méthodes prédéfinies en Java](#méthodes-prédéfinies-en-java)
  - [Méthodes mathématiques](#méthodes-mathématiques)
  - [Méthodes sur les chaînes de caractères](#méthodes-sur-les-chaînes-de-caractères)
- [Réutiliser du code avec des méthodes](#réutiliser-du-code-avec-des-méthodes)
- [Conclusion](#conclusion)
- [Exercices](#exercices)

## Objectifs

Les méthodes (ou fonctions) sont un concept fondamental en programmation. Elles
permettent de découper un programme en morceaux plus petits, plus faciles à
comprendre et à maintenir. Les méthodes permettent également de réutiliser du
code, en l'encapsulant dans une méthode que l'on peut appeler à plusieurs
endroits.

Dans ce cours, nous allons voir comment déclarer et appeler des méthodes en
Java. Nous allons également voir comment passer des paramètres à une méthode et
comment retourner une valeur depuis une méthode.

De façon plus concise, vous devriez être capables de :

- Décrire ce qu'est une méthode en programmation
- Déclarer une méthode en Java
- Appeler une méthode en Java
- Passer des paramètres à une méthode en Java
- Utiliser une valeur de retour
- Expliquer ce qu'est une portée de variable
- Utiliser des variables de classe
- Savoir où trouver la documentation sur les méthodes prédéfinies en Java
- Utiliser des méthodes prédéfinies en Java
- Réutiliser du code avec des méthodes

## Qu'est-ce qu'une méthode ?

Une méthode est un ensemble d'instructions qui effectue une tâche spécifique.
Une méthode peut prendre des paramètres en entrée et peut retourner une valeur
en sortie.

Imaginez que vous préparez un gâteau. La recette du gâteau est comme une méthode
: elle décrit les étapes à suivre pour obtenir le gâteau final. Vous pouvez
utiliser différents ingrédients (les paramètres) et obtenir un gâteau (la valeur
de retour).

Comme en mathématiques, une méthode en programmation prend des arguments en
entrée et retourne une valeur en sortie. Par exemple, la fonction mathématique
$f(x) = x^2$ prend un argument $x$ en entrée et retourne $x^2$ en sortie. Si on
appelle la fonction $f(3)$, on obtient $9$.

En programmation, une méthode est définie par un nom, une liste de paramètres
(optionnelle) et un bloc de code. Une fois définie, une méthode peut être
appelée à partir d'un autre endroit du programme et permet de structurer le code
en le découpant en morceaux plus petits et plus faciles à comprendre.

## Déclarer une méthode en Java

En Java, une méthode est déclarée avec un modificateur d'accès (comme `public`),
le mot-clé `static` (pour le moment), le type de retour, le nom de la méthode,
des parenthèses `()` et des accolades `{}` contenant le code de la méthode.

Voici un exemple de déclaration de méthode en Java :

```java
public class Main {
    public static void sayHello() {
        System.out.println("Bonjour le monde !");
    }
}
```

Dans cet exemple, la méthode `sayHello` ne prend pas de paramètres et ne
retourne pas de valeur (type `void`). Elle affiche simplement le message
`Bonjour le monde !` à l'écran.

Le mot-clé `static` signifie que la méthode appartient à la classe elle-même et
non à une instance de la classe. Nous verrons ce concept plus en détail dans les
prochains cours.

## Appeler une méthode en Java

Pour appeler une méthode en Java, on utilise le nom de la méthode suivi de
parenthèses `()`. Les parenthèses peuvent contenir des paramètres à passer à la
méthode, si elle en prend.

Un exemple d'appel de méthode en Java sans paramètres :

```java
public class Main {
    public static void sayHello() {
        System.out.println("Bonjour le monde !");
    }

    public static void main(String[] args) {
        sayHello(); // Affiche "Bonjour le monde !"
    }
}
```

Dans cet exemple, la méthode `sayHello` est appelée depuis la méthode `main`, ce
qui affiche le message `Bonjour le monde !` à l'écran.

Il est tout à fait possible d'appeler une méthode à plusieurs reprises dans un
programme :

```java
public class Main {
    public static void sayHello() {
        System.out.println("Bonjour le monde !");
    }

    public static void main(String[] args) {
        sayHello(); // Affiche "Bonjour le monde !"
        sayHello(); // Affiche "Bonjour le monde !"
        sayHello(); // Affiche "Bonjour le monde !"
    }
}
```

Dans cet exemple, la méthode `sayHello` est appelée trois fois, ce qui affiche
le message `Bonjour le monde !` trois fois à l'écran.

## Passer des paramètres à une méthode

Une méthode peut également prendre des paramètres en entrée. Par exemple, la
méthode suivante prend un paramètre `name` et affiche un message de salutation
personnalisé :

```java
public class Main {
    public static void sayHello(String name) {
        System.out.println("Bonjour " + name + " !");
    }
}
```

Pour appeler cette méthode, on passe un argument à la méthode :

```java
public class Main {
    public static void sayHello(String name) {
        System.out.println("Bonjour " + name + " !");
    }

    public static void main(String[] args) {
        sayHello("Alice"); // Affiche "Bonjour Alice !"
        sayHello("Bob");   // Affiche "Bonjour Bob !"
    }
}
```

Dans cet exemple, la méthode `sayHello` est appelée avec l'argument `"Alice"`,
ce qui affiche le message `Bonjour Alice !` à l'écran. La méthode est ensuite
appelée avec l'argument `"Bob"`, ce qui affiche le message `Bonjour Bob !` à
l'écran.

## Retourner une valeur depuis une méthode

Une méthode peut également retourner une valeur. La valeur peut ensuite être
utilisée dans le code appelant (le code qui appelle la méthode).

Pour retourner une valeur depuis une méthode, on utilise le mot-clé `return`.
Une méthode ne peut retourner qu'une seule valeur.

Par exemple, la méthode suivante prend un paramètre `x` et retourne le carré de
ce paramètre :

```java
public class Main {
    public static int square(int x) {
        return x * x;
    }
}
```

Pour utiliser la valeur retournée par une méthode, on peut l'assigner à une
variable :

```java
public class Main {
    public static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        int result = square(3);
        System.out.println(result); // Affiche 9
    }
}
```

Dans cet exemple, la méthode `square` est appelée avec l'argument `3`, ce qui
retourne `9`. La valeur retournée est ensuite assignée à la variable `result`,
qui est affichée à l'écran.

## Passer plusieurs paramètres à une méthode

Une méthode peut avoir plusieurs paramètres. Les paramètres sont séparés par des
virgules (`,`) et sont passés dans le même ordre que leur déclaration.

Par exemple, la méthode suivante prend deux paramètres `x` et `y` et retourne la
somme de ces deux paramètres :

```java
public class Main {
    public static int add(int x, int y) {
        return x + y;
    }
}
```

Pour utiliser cette méthode, on passe deux arguments :

```java
public class Main {
    public static int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        int result = add(3, 5);
        System.out.println(result); // Affiche 8
    }
}
```

## Portée des variables

Les variables déclarées à l'intérieur d'une méthode sont locales à cette
méthode. Cela signifie qu'elles ne sont accessibles que dans le contexte de la
méthode et ne peuvent pas être utilisées en dehors de celle-ci.

Par exemple, la variable `x` déclarée dans la méthode `square` n'est pas
accessible en dehors de cette méthode :

```java
public class Main {
    public static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        System.out.println(x); // Erreur : variable x non définie
    }
}
```

Dans cet exemple, la variable `x` est déclarée à l'intérieur de la méthode
`square` et n'est pas accessible en dehors de celle-ci. Si on essaie d'afficher
la variable `x` en dehors de la méthode, on obtient une erreur de compilation.

Imaginez que vous avez une boîte à outils. Les outils à l'intérieur de la boîte
sont comme les variables locales : elles ne sont accessibles que lorsque vous
ouvrez la boîte. Une fois la boîte fermée, vous ne pouvez plus accéder aux
outils.

## Variables de classe

Il est possible de déclarer des variables de classe en Java, c'est-à-dire des
variables qui sont accessibles dans toutes les méthodes de la classe. Pour
déclarer une variable de classe, on utilise le mot-clé `static` :

```java
public class Main {
    public static int x = 42;

    public static void square() {
        x = x * x;
    }

    public static void main(String[] args) {
        square();
        System.out.println(x); // Affiche 1764
    }
}
```

Dans cet exemple, la variable `x` est déclarée en dehors des méthodes et est
accessible à l'intérieur de toutes les méthodes de la classe.

Il est généralement déconseillé d'utiliser des variables de classe, car elles
rendent le code moins lisible et plus difficile à maintenir. Il est préférable
de passer des paramètres à une méthode plutôt que d'utiliser des variables de
classe.

## Méthodes prédéfinies en Java

Java dispose de nombreuses méthodes prédéfinies qui permettent d'effectuer
diverses tâches. Par exemple, la méthode `length` de la classe `String` permet
de calculer la longueur d'une chaîne de caractères :

```java
public class Main {
    public static void main(String[] args) {
        String text = "Bonjour le monde !";
        int length = text.length();
        System.out.println(length); // Affiche 18
    }
}
```

Dans cet exemple, la méthode `length` est appelée sur la chaîne de caractères
`"Bonjour le monde !"`, ce qui retourne `18`. La valeur retournée est assignée à
la variable `length`, qui est affichée à l'écran.

Toutes les méthodes prédéfinies en Java sont documentées dans la documentation
officielle de Java : <https://docs.oracle.com/en/java/javase/21/docs/api/> et
sont organisées par classes. Voici quelques classes utiles (entre autres) :

- [Classe Math](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Math.html) -
  Méthodes mathématiques
- [Classe String](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html) -
  Méthodes sur les chaînes de caractères
- [Classe System](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html) -
  Méthodes système

Nous allons en explorer quelques-unes dans les sections suivantes.

### Méthodes mathématiques

Java dispose de nombreuses méthodes mathématiques prédéfinies dans la classe
`Math` pour effectuer des opérations mathématiques courantes. Par exemple, la
méthode `sqrt` permet de calculer la racine carrée d'un nombre :

```java
public class Main {
    public static void main(String[] args) {
        double result = Math.sqrt(16);
        System.out.println(result); // Affiche 4.0
    }
}
```

Il existe évidemment d'autres méthodes mathématiques prédéfinies en Java, comme
`abs`, `round`, `min`, `max`, `random`, etc.

Vous allez les explorer dans les exercices.

### Méthodes sur les chaînes de caractères

Java dispose de nombreuses méthodes prédéfinies dans la classe `String` pour
manipuler des chaînes de caractères. Par exemple, la méthode `toUpperCase`
permet de convertir une chaîne de caractères en majuscules :

```java
public class Main {
    public static void main(String[] args) {
        String text = "bonjour le monde !";
        String result = text.toUpperCase();
        System.out.println(result); // Affiche "BONJOUR LE MONDE !"
    }
}
```

Il existe évidemment d'autres méthodes de chaînes de caractères prédéfinies en
Java, comme `toLowerCase`, `length`, `substring`, `replace`, etc.

Vous allez les explorer dans les exercices.

## Réutiliser du code avec des méthodes

Les méthodes permettent de réutiliser du code en l'encapsulant dans une méthode
que l'on peut appeler à plusieurs endroits. Cela évite de dupliquer du code et
rend le programme plus facile à maintenir.

Par exemple, si vous devez calculer le carré d'un nombre à plusieurs endroits
dans votre programme, vous pouvez créer une méthode `square` et l'appeler à
chaque fois que vous en avez besoin :

```java
public class Main {
    public static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        System.out.println(square(3));  // Affiche 9
        System.out.println(square(5));  // Affiche 25
        System.out.println(square(10)); // Affiche 100
    }
}
```

Au lieu de dupliquer le calcul `x * x` à plusieurs endroits, vous l'encapsulez
dans une méthode et vous l'appelez à chaque fois que vous en avez besoin.

## Conclusion

Les méthodes sont un concept fondamental en programmation. Elles permettent de
découper un programme en morceaux plus petits, plus faciles à comprendre et à
maintenir. Les méthodes permettent également de réutiliser du code, en
l'encapsulant dans une méthode que l'on peut appeler à plusieurs endroits.

Java dispose de nombreuses méthodes prédéfinies qui permettent d'effectuer
diverses tâches. Ces méthodes sont organisées par classes et sont documentées
dans la documentation officielle de Java.

Dans les prochains cours, nous verrons comment utiliser certaines méthodes plus
en détails pour résoudre des problèmes concrets.

## Exercices

Nous vous invitons à réaliser les exercices de ce cours pour renforcer votre
compréhension des concepts vus en classe.

Vous trouverez les détails des exercices ici :
[Exercices](../03-exercices/README.md).
