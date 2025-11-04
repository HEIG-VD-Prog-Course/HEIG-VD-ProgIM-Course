# Débogage - Exercices

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

## Exercices

### Exercice 1 : Identifier le type d'erreur

Pour chacun des bugs suivants, indiquez de quel type d'erreur il s'agit
(compilation, exécution, ou logique) et expliquez comment le corriger.

**Cas 1 :**

```java
int total = 0
for (int i = 0; i < 10; i++) {
    total += i;
}
```

**Cas 2 :**

```java
String text = null;
System.out.println(text.toUpperCase());
```

**Cas 3 :**

```java
int age = 25;
if (age > 18) {
    System.out.println("Vous êtes mineur");
}
```

**Cas 4 :**

```java
int[] numbers = {1, 2, 3, 4, 5};
for (int i = 0; i <= numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

**Cas 5 :**

```java
double result = 5 / 2;
System.out.println(result);  // Affiche 2.0 au lieu de 2.5
```

<details>
<summary>Solution</summary>

**Cas 1 : Erreur de compilation**

- **Type** : Erreur de syntaxe (manque un point-virgule).
- **Correction** : `int total = 0;`
- **Explication** : Le compilateur détecte cette erreur immédiatement.

---

**Cas 2 : Erreur d'exécution**

- **Type** : NullPointerException.
- **Correction** : Vérifier si `text` est `null` avant de l'utiliser :
  ```java
  if (text != null) {
      System.out.println(text.toUpperCase());
  }
  ```
- **Explication** : Le code compile mais plante à l'exécution.

---

**Cas 3 : Erreur logique**

- **Type** : Message incorrect (logique inversée).
- **Correction** : Changer le message :
  ```java
  if (age > 18) {
      System.out.println("Vous êtes majeur");
  }
  ```
- **Explication** : Le code fonctionne mais produit un résultat incorrect.

---

**Cas 4 : Erreur d'exécution**

- **Type** : ArrayIndexOutOfBoundsException (dépassement d'indice).
- **Correction** : Changer `<=` en `<` :
  ```java
  for (int i = 0; i < numbers.length; i++)
  ```
- **Explication** : `numbers.length` vaut 5, mais les indices vont de 0 à 4.

---

**Cas 5 : Erreur logique**

- **Type** : Division entière au lieu de division réelle.
- **Correction** : Caster en `double` :
  ```java
  double result = (double) 5 / 2;
  // Ou : double result = 5.0 / 2;
  ```
- **Explication** : La division `5 / 2` (int/int) donne 2, qui est ensuite
  converti en 2.0.

</details>

---

### Exercice 2 : Déboguer une recherche

Le code suivant est censé rechercher un élément dans un tableau et retourner son
indice. Cependant, il contient un bug.

```java
public static int findElement(int[] array, int target) {
    for (int i = 0; i <= array.length; i++) {
        if (array[i] == target) {
            return i;
        }
    }
    return -1;  // Non trouvé
}
```

**Questions :**

1. Quel est le bug ?
2. Dans quelles conditions le bug se manifeste-t-il ?
3. Comment utiliser le débogueur pour l'identifier ?
4. Quelle est la correction ?

<details>
<summary>Solution</summary>

**1. Quel est le bug ?**

Le bug est dans la condition de la boucle : `i <= array.length` au lieu de
`i < array.length`.

---

**2. Dans quelles conditions le bug se manifeste-t-il ?**

Le bug se manifeste quand l'élément cherché **n'est pas dans le tableau**. Dans
ce cas, la boucle continue jusqu'à `i = array.length`, ce qui cause une
`ArrayIndexOutOfBoundsException`.

Si l'élément est trouvé avant, le `return` arrête la boucle et le bug ne se
manifeste pas.

---

**3. Comment utiliser le débogueur pour l'identifier ?**

**Étapes de débogage :**

1. Placer un breakpoint dans la boucle `for`.
2. Appeler la méthode avec un élément qui n'existe pas :
   ```java
   int[] numbers = {1, 2, 3, 4, 5};
   int index = findElement(numbers, 10);  // 10 n'existe pas
   ```
3. Lancer le débogueur (F5).
4. Utiliser Step Over (F10) pour avancer dans la boucle.
5. Observer la valeur de `i` dans la section VARIABLES.
6. Constater que `i` atteint `5` alors que `array.length` vaut `5`.
7. Identifier que `array[5]` est hors limites (les indices vont de 0 à 4).

---

**4. Quelle est la correction ?**

```java
public static int findElement(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {  // < au lieu de <=
        if (array[i] == target) {
            return i;
        }
    }
    return -1;
}
```

**Explication** : Utiliser `<` garantit que `i` reste dans les limites valides
(0 à `array.length - 1`).

</details>

---

### Exercice 3 : Déboguer un calcul de moyenne

Le code suivant calcule la moyenne d'un tableau de notes, mais le résultat est
toujours un entier.

```java
public static double calculateAverage(int[] grades) {
    int sum = 0;

    for (int i = 0; i < grades.length; i++) {
        sum += grades[i];
    }

    double average = sum / grades.length;
    return average;
}
```

**Questions :**

1. Pourquoi le résultat est-il toujours un entier ?
2. Comment utiliser la section WATCH pour identifier le problème ?
3. Quelle est la correction ?

<details>
<summary>Solution</summary>

**1. Pourquoi le résultat est-il toujours un entier ?**

Le problème vient de la division entière : `sum / grades.length`.

- `sum` est un `int`.
- `grades.length` est un `int`.
- La division `int / int` donne un `int`.
- Le résultat entier est ensuite converti en `double`.

**Exemple :**

- `sum = 75`, `grades.length = 4`
- `75 / 4 = 18` (division entière, pas 18.75)
- `average = 18.0` (conversion en double après)

---

**2. Comment utiliser la section WATCH pour identifier le problème ?**

**Étapes avec WATCH :**

1. Placer un breakpoint sur la ligne `double average = sum / grades.length;`.
2. Lancer le débogueur avec un tableau de test :
   ```java
   int[] grades = {15, 18, 12, 16, 14};  // Somme = 75, moyenne = 15.0
   ```
3. Quand le programme s'arrête, ouvrir la section **WATCH**.
4. Ajouter les expressions suivantes :
   - `sum` → 75
   - `grades.length` → 5
   - `sum / grades.length` → 15 (division entière !)
   - `(double) sum / grades.length` → 15.0 (correction)
5. Constater que `sum / grades.length` donne un entier.

---

**3. Quelle est la correction ?**

**Option 1** : Caster `sum` en `double` :

```java
double average = (double) sum / grades.length;
```

**Option 2** : Caster `grades.length` en `double` :

```java
double average = sum / (double) grades.length;
```

**Option 3** : Multiplier par `1.0` :

```java
double average = sum * 1.0 / grades.length;
```

**Explication** : Dès qu'un des opérandes est un `double`, Java effectue une
division réelle au lieu d'une division entière.

</details>

---

### Exercice 4 : Déboguer une boucle infinie

Le code suivant est censé afficher les nombres de 1 à 10, mais il ne s'arrête
jamais.

```java
public static void printNumbers() {
    int i = 1;
    while (i <= 10) {
        System.out.println(i);
    }
}
```

**Questions :**

1. Pourquoi la boucle ne se termine-t-elle jamais ?
2. Comment utiliser le débogueur pour le constater ?
3. Quelle est la correction ?

<details>
<summary>Solution</summary>

**1. Pourquoi la boucle ne se termine-t-elle jamais ?**

La variable `i` n'est jamais incrémentée. Elle reste à `1` indéfiniment, donc la
condition `i <= 10` est toujours vraie.

---

**2. Comment utiliser le débogueur pour le constater ?**

**Étapes de débogage :**

1. Placer un breakpoint sur la ligne `System.out.println(i);`.
2. Lancer le débogueur (F5).
3. Observer la valeur de `i` dans la section VARIABLES → `i = 1`.
4. Appuyer sur Continue (F5) ou Step Over (F10) plusieurs fois.
5. Constater que `i` reste toujours à `1` et ne change jamais.
6. Identifier qu'il manque une instruction pour modifier `i`.

**Alternative** : Utiliser **Pause** (⏸️) pendant l'exécution pour voir où le
programme est bloqué.

---

**3. Quelle est la correction ?**

Ajouter l'incrémentation de `i` dans la boucle :

```java
public static void printNumbers() {
    int i = 1;
    while (i <= 10) {
        System.out.println(i);
        i++;  // <- Ajouter cette ligne
    }
}
```

**Explication** : Sans `i++`, la condition ne change jamais et la boucle ne se
termine pas.

</details>

---

### Exercice 5 : Déboguer une condition avec breakpoint conditionnel

Le code suivant recherche tous les nombres pairs dans un tableau, mais il y a un
bug.

```java
public static int countEven(int[] numbers) {
    int count = 0;

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] % 2 = 0) {  // BUG ICI
            count++;
        }
    }

    return count;
}
```

**Questions :**

1. Quel est le bug (erreur de compilation) ?
2. Comment utiliser un **breakpoint conditionnel** pour tester uniquement les
   nombres pairs ?
3. Quelle est la correction ?

<details>
<summary>Solution</summary>

**1. Quel est le bug ?**

Le bug est l'utilisation de `=` (affectation) au lieu de `==` (comparaison) :

```java
if (numbers[i] % 2 = 0)  // ERREUR
```

Cela tente d'affecter `0` à `numbers[i] % 2`, ce qui n'est pas possible.

**Type d'erreur** : Erreur de compilation.

**Message d'erreur** : `The left-hand side of an assignment must be a variable`

---

**2. Comment utiliser un breakpoint conditionnel ?**

Une fois le code corrigé, pour tester uniquement les nombres pairs :

**Étapes :**

1. Placer un breakpoint sur la ligne `count++`.
2. Clic droit sur le breakpoint → **Edit Breakpoint**.
3. Sélectionner **Expression**.
4. Entrer la condition : `numbers[i] % 2 == 0`.
5. Lancer le débogueur.

Le programme s'arrêtera uniquement quand un nombre pair est trouvé.

**Utilité** : Permet de s'arrêter dans des cas spécifiques sans avoir à faire
Continue plusieurs fois.

---

**3. Quelle est la correction ?**

Changer `=` en `==` :

```java
public static int countEven(int[] numbers) {
    int count = 0;

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] % 2 == 0) {  // == pour comparer
            count++;
        }
    }

    return count;
}
```

**Explication** :

- `=` est l'opérateur d'affectation.
- `==` est l'opérateur de comparaison.

</details>

---

### Exercice 6 : Démarche complète de débogage

Le code suivant est censé trouver le maximum d'un tableau, mais il ne fonctionne
pas correctement.

```java
public static int findMax(int[] numbers) {
    int max = 0;

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] > max) {
            max = numbers[i];
        }
    }

    return max;
}
```

**Tâche :** Appliquez la démarche complète de débogage :

1. **Reproduire le bug** : Testez avec différents tableaux et identifiez les cas
   qui ne fonctionnent pas.
2. **Localiser le bug** : Utilisez le débogueur pour trouver la ligne
   problématique.
3. **Comprendre le bug** : Analysez pourquoi le résultat est incorrect.
4. **Formuler une hypothèse** : Émettez une théorie sur la cause.
5. **Tester l'hypothèse** : Utilisez WATCH pour vérifier.
6. **Corriger le bug** : Appliquez la correction.
7. **Vérifier la correction** : Testez avec plusieurs cas.

<details>
<summary>Solution</summary>

**1. Reproduire le bug**

**Tests :**

```java
int[] test1 = {5, 10, 3, 8, 2};
System.out.println("Max : " + findMax(test1));  // Attendu : 10, Résultat : 10 ✓

int[] test2 = {-5, -10, -3, -8, -2};
System.out.println("Max : " + findMax(test2));  // Attendu : -2, Résultat : 0 ✗

int[] test3 = {0, 0, 0};
System.out.println("Max : " + findMax(test3));  // Attendu : 0, Résultat : 0 ✓

int[] test4 = {-15, -8, -20};
System.out.println("Max : " + findMax(test4));  // Attendu : -8, Résultat : 0 ✗
```

**Observation** : Le bug se manifeste quand tous les nombres sont négatifs. Le
résultat est `0` au lieu du maximum réel.

---

**2. Localiser le bug**

**Étapes avec le débogueur :**

1. Placer un breakpoint au début de `findMax()`.
2. Appeler avec `test2 = {-5, -10, -3, -8, -2}`.
3. Observer la valeur initiale de `max` → `0`.
4. Faire Step Over (F10) dans la boucle.
5. Observer que `max` reste à `0` car tous les nombres sont négatifs (aucun
   n'est > 0).

---

**3. Comprendre le bug**

Le problème vient de l'initialisation : `int max = 0;`.

- Si tous les nombres du tableau sont négatifs, aucun n'est plus grand que `0`.
- `max` reste donc à `0`, qui n'est pas un élément du tableau.

---

**4. Formuler une hypothèse**

**Hypothèse** : L'initialisation de `max` à `0` est incorrecte. Il faudrait
initialiser `max` avec le premier élément du tableau.

---

**5. Tester l'hypothèse**

**Avec WATCH :**

1. Placer un breakpoint après la boucle.
2. Ajouter dans WATCH :
   - `max` → 0
   - `numbers[0]` → -5
3. Constater que `max` (0) est plus grand que tous les éléments du tableau
   négatifs.

---

**6. Corriger le bug**

**Option 1** : Initialiser `max` avec le premier élément :

```java
public static int findMax(int[] numbers) {
    if (numbers.length == 0) {
        throw new IllegalArgumentException("Tableau vide");
    }

    int max = numbers[0];  // Initialiser avec le premier élément

    for (int i = 1; i < numbers.length; i++) {  // Commencer à i = 1
        if (numbers[i] > max) {
            max = numbers[i];
        }
    }

    return max;
}
```

**Option 2** : Utiliser `Integer.MIN_VALUE` :

```java
public static int findMax(int[] numbers) {
    int max = Integer.MIN_VALUE;  // Valeur minimale possible

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] > max) {
            max = numbers[i];
        }
    }

    return max;
}
```

---

**7. Vérifier la correction**

Retester avec tous les cas :

```java
int[] test1 = {5, 10, 3, 8, 2};
System.out.println("Max : " + findMax(test1));  // 10 ✓

int[] test2 = {-5, -10, -3, -8, -2};
System.out.println("Max : " + findMax(test2));  // -2 ✓

int[] test3 = {0, 0, 0};
System.out.println("Max : " + findMax(test3));  // 0 ✓

int[] test4 = {-15, -8, -20};
System.out.println("Max : " + findMax(test4));  // -8 ✓
```

**Résultat** : Tous les tests passent maintenant ! ✓

---

**Leçons apprises :**

1. Toujours initialiser les variables avec des valeurs appropriées.
2. Tester avec des cas limites (nombres négatifs, zéros, tableaux vides).
3. Le débogueur permet de voir l'évolution des variables étape par étape.
4. La section WATCH est utile pour comparer des valeurs.

</details>

---

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
