#import "@preview/codelst:2.0.2": sourcecode
#import "@local/heig-vd-evaluations-and-exams-template:0.1.0": conf, question_types

#let parts = (
  ("Question 1", 6),
  ("Question 2", 6),
  ("Question 3", 4),
  ("Question 4", 6),
  ("Question 5", 7),
  ("Question 6", 6),
  ("Question 7", 6),
  ("Question 8", 5),
  ("Question 9", 4),
)

#let additional_information = [
  Vous n'avez pas le droit à des pages de résumé pour cette partie.
  Vous pouvez répondre aux questions en français ou en anglais.
  Toute tentative de triche sera sanctionnée par la note de 1.

  _Examen d'entraînement préparé avec l'aide de Ludovic Delafontaine, Hadrien Louis, GitHub Copilot et Claude (Anthropic)._
]

#show: doc => conf(
  evaluation_title: "Programmation Ingénierie des Médias 1 (ProgIM1)",
  evaluation_subtitle: "Examen d'entraînement - Partie 1",
  evaluation_date: "24.01.2026",
  duration: "90 minutes",
  parts,
  additional_information,
  doc,
)

#let show_official_answer = true

// ============================================================================
// QUESTION 1 : Pseudocode et diagramme d'activité
// ============================================================================

#question_types.question_statement(
  title: "Lecture de diagramme d'activité",
  statement: [
    Le diagramme d'activité UML ci-dessous représente un algorithme.
    
    #image("assets/recherche-tableau.png", width: 50%)
    
    *Partie A (3 points)* : Expliquez en quelques phrases ce que fait cet algorithme.
    
    *Partie B (3 points)* : Créez votre propre diagramme d'activité UML pour un algorithme qui calcule la somme de tous les éléments d'un tableau d'entiers.
  ],
  points: 6,
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  height_cm: 8cm,
  margin_bottom: 0cm,
  icon_text: "Partie A : Explication de l'algorithme",
  show_official_answer: show_official_answer,
  official_answer: [
    *Explication (3 points) :*
    
    Cet algorithme recherche un élément (42) dans un tableau d'entiers.
    Il parcourt le tableau élément par élément avec une boucle.
    Si l'élément est trouvé, il retourne sa position (index).
    Si l'élément n'est pas trouvé après avoir parcouru tout le tableau, il retourne -1.
    
    *(1 point pour identifier qu'il s'agit d'une recherche, 1 point pour le parcours, 1 point pour les valeurs de retour)*
  ],
)

#question_types.answer_bloc_with_icon(
  height_cm: 18cm,
  margin_bottom: 0cm,
  icon_text: "Partie B : Diagramme d'activité pour calcul de somme",
  show_official_answer: show_official_answer,
  official_answer: [
    *Éléments attendus (3 points) :*
    - Début/Fin (0.5 point)
    - Déclaration du tableau et d'une variable somme = 0 (0.5 point)
    - Boucle parcourant tous les éléments du tableau (1 point)
    - Addition de chaque élément à la somme (0.5 point)
    - Retour ou affichage de la somme (0.5 point)
    
    *Structure attendue approximative :*
    - Début
    - somme = 0, i = 0
    - Tant que i < longueur tableau
      - somme = somme + tableau[i]
      - i = i + 1
    - Retourner somme
    - Fin
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 2 : QCM Vocabulaire et concepts Java
// ============================================================================

#question_types.multiple_choice_question(
  title: "Vocabulaire et concepts Java",
  statement: [
    Pour chacune des affirmations suivantes, indiquez si elle est *vraie* ou *fausse*.
  ],
  points: 6,
  header: ("Affirmation", "Vrai/Faux"),
  show_official_answer: show_official_answer,
  answers: (
    (
      "En Java, un paramètre est la valeur concrète passée lors de l'appel d'une méthode, tandis qu'un argument est la variable déclarée dans la signature de la méthode.",
      "Faux (c'est l'inverse)",
    ),
    (
      "Le JDK (Java Development Kit) contient le compilateur Java ainsi que la JVM (Java Virtual Machine).",
      "Vrai",
    ),
    (
      "Un fichier .java est compilé en fichier .class qui contient du bytecode exécutable par la JVM.",
      "Vrai",
    ),
    (
      "En Java, une variable déclarée avec le mot-clé 'final' ne peut plus être modifiée après son initialisation.",
      "Vrai",
    ),
    (
      "La compilation transforme le code source en langage machine directement exécutable par le processeur.",
      "Faux (elle produit du bytecode pour la JVM)",
    ),
    (
      "Une méthode et une fonction sont exactement la même chose en programmation.",
      "Faux (une méthode est une fonction dans une classe)",
    ),
  ),
)

#pagebreak()

// ============================================================================
// QUESTION 3 : Types primitifs (simplifié)
// ============================================================================

#question_types.question_statement(
  title: "Types primitifs en Java",
  statement: [
    1. Donnez 4 types primitifs en Java parmi les 8 existants. *(2 points)*
    
    2. Pourquoi dit-on que les nombres à virgule flottante (`float`, `double`) ne sont pas précis pour représenter certaines valeurs décimales ? Donnez un exemple. *(2 points)*
  ],
  points: 4,
)

#question_types.answer_bloc(
  // height_cm: 10cm,
  margin_bottom: 0cm,
  show_official_answer: show_official_answer,
  official_answer: [
    *1. Types primitifs (2 points) :*
    - `int`, `double`, `boolean`, `char`
    - Ou : `byte`, `short`, `long`, `float`
    
    *(0.5 point par type correct)*
    
    *2. Imprécision des flottants (2 points) :*
    
    Les nombres à virgule flottante utilisent une représentation binaire qui ne peut pas représenter exactement certaines fractions décimales.
    
    Exemple : `0.1 + 0.2` donne `0.30000000000000004` et non `0.3` exactement.
    
    *(1 point pour l'explication, 1 point pour l'exemple)*
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 4 : Portée des variables - Code avec erreurs
// ============================================================================

#question_types.question_statement(
  title: "Portée des variables",
  statement: [
    Le code Java ci-dessous contient *exactement 3 erreurs* liées à la portée des variables.
    
    Pour chaque erreur :
    1. Indiquez la/les ligne(s) concernée(s)
    2. Expliquez ce qui ne fonctionne pas et pourquoi
    
    ```java
    public class PorteeVariables {
        public static int compteur = 0;
        
        public static void main(String[] args) {
            int nombre = 10;
            
            if (nombre > 5) {
                int resultat = nombre * 2;
                compteur = compteur + 1;
            }
            
            System.out.println("Résultat : " + resultat);
            
            for (int i = 0; i < 3; i++) {
                int valeur = i * 2;
            }
            
            System.out.println("Valeur finale : " + valeur);
            
            calculer();
        }
        
        public static void calculer() {
            int somme = nombre + 5;
            System.out.println("Somme : " + somme);
        }
    }
    ```
  ],
  points: 6,
)
#pagebreak()

#question_types.answer_bloc(
  margin_bottom: 0cm,
  show_official_answer: show_official_answer,
  official_answer: [
    *Les 3 erreurs (6 points, 2 points par erreur identifiée et expliquée) :*
    
    1. *Ligne 12* : La variable `resultat` est déclarée dans le bloc `if` et n'est pas accessible en dehors de ce bloc. Elle n'existe plus après la ligne 10.
    
    2. *Ligne 18* : La variable `valeur` est déclarée dans la boucle `for` et n'est accessible que dans cette boucle. Elle n'existe pas en dehors.
    
    3. *Ligne 23* : La variable `nombre` est locale à la méthode `main` et n'est pas accessible dans la méthode `calculer`.
    
    *(Note : Il n'y a en fait que 3 erreurs principales. Si l'étudiant·e en trouve d'autres logiques, les accepter)*
    
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 5 : Bonnes pratiques
// ============================================================================

#question_types.question_statement(
  title: "Bonnes pratiques de programmation",
  statement: [
    Voici un extrait de code Java. Identifiez les problèmes liés aux *conventions de nommage Java* vues en cours et proposez des corrections.
    
    *Partie A (3 points)* : Conventions de nommage
    
    ```java
    public class CalculateurStatistiques {
        public static final double taux_tva = 0.077;
        private int NombreEtudiants;
        
        public void CalculerMoyenne(int[] notes) {
            double m = 0.0;
            // ...
        }
        
        private String Nom_Complet;
    }
    ```
    
    Pour chaque problème identifié, indiquez :
    - La ligne concernée
    - Le problème (quelle convention Java n'est pas respectée)
    - La correction
    
    *Partie B (3 points)* : Pour chacun des commentaires suivants, indiquez s'il est *utile* ou *redondant* et justifiez brièvement :
    
    ```java
    // Incrémente le compteur de 1
    compteur++;
    
    // Vérifie que l'âge est valide pour voter (18+)
    if (age >= 18) {
        peutVoter = true;
    }
    
    // Calcule le prix TTC en ajoutant la TVA de 20%
    double prixTTC = prixHT * 1.20;
    ```
  ],
  points: 6,
)

#pagebreak()


#question_types.answer_bloc(
  // height_cm: 18cm,
  margin_bottom: 0cm,
  show_official_answer: show_official_answer,
  official_answer: [
    *Partie A (3 points) :*
    
    1. Ligne 2 : `taux_tva` → `TAUX_TVA` 
       - *Problème* : Les constantes (final static) doivent être en MAJUSCULES_AVEC_UNDERSCORE
       - *(0.6 point)*
    
    2. Ligne 3 : `NombreEtudiants` → `nombreEtudiants`
       - *Problème* : Les attributs (variables d'instance) doivent commencer par une minuscule (camelCase)
       - *(0.6 point)*
    
    3. Ligne 5 : `CalculerMoyenne` → `calculerMoyenne`
       - *Problème* : Les méthodes doivent commencer par une minuscule (camelCase)
       - *(0.6 point)*
    
    4. Ligne 6 : `m` → `moyenne` ou `somme` (nom plus explicite)
       - *Problème* : Les noms de variables doivent être explicites (convention vue en cours)
       - *(0.6 point)*
    
    5. Ligne 10 : `Nom_Complet` → `nomComplet`
       - *Problème* : Les attributs doivent être en camelCase, pas de underscore ni majuscule au début
       - *(0.6 point)*
    
    *Partie B (3 points) :*
    
    1. *Redondant* : Le commentaire ne fait que répéter ce que le code fait de manière évidente. *(1 point)*
    
    2. *Utile* : Le commentaire explique la logique métier (âge pour voter), pas juste ce que fait le code. *(1 point)*
    
    3. *Moyennement utile* : Explique le taux de TVA ce qui peut être utile, mais pourrait être mieux avec une constante `TAUX_TVA`. *(1 point)*
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 6 : Packages et imports
// ============================================================================

#question_types.question_statement(
  title: "Packages et bibliothèques Java",
  statement: [
    1. À quoi sert un package en Java ? *(2 points)*
    
    2. Quelle est la différence entre `import java.util.*;` et `import java.util.Scanner;` ? Quelle forme est préférable et pourquoi ? *(3 points)*
    
    3. Indiquez brièvement l'utilité de ces trois packages de la bibliothèque standard Java : *(1.5 points)*
       - `java.util`
       - `java.io`
       - `java.time`
  ],
  points: 6,
)

#question_types.answer_bloc(
  margin_bottom: 0cm,
  show_official_answer: show_official_answer,
  official_answer: [
    *1. Utilité des packages (2 points) :*
    
    Un package permet d'organiser les classes Java de manière logique et hiérarchique, éviter les conflits de noms, et faciliter la réutilisation du code.
    
    *2. Différence import (2.5 points) :*
    
    - `import java.util.*;` importe *toutes* les classes du package `java.util`
    - `import java.util.Scanner;` importe *uniquement* la classe `Scanner`
    
    La forme spécifique (`Scanner`) est préférable car :
    - Plus claire : on voit exactement quelles classes sont utilisées
    - Évite les conflits de noms
    - Meilleure performance de compilation
    
    *3. Utilité des packages (1.5 points - 0.5 point par package) :*
    
    - `java.util` : classes utilitaires (collections, dates, Scanner, etc.)
    - `java.io` : entrées/sorties (lecture/écriture de fichiers)
    - `java.time` : gestion moderne des dates et heures
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 7 : Compilation et exécution Java
// ============================================================================

#question_types.question_statement(
  title: "Compilation et exécution Java en ligne de commande",
  statement: [
    Vous avez un fichier `Calculatrice.java` qui contient une classe publique `Calculatrice` avec une méthode `main` qui accepte deux arguments (deux nombres à additionner).
    
    1. Donnez la commande pour compiler ce fichier. *(1.5 points)*
    
    2. Donnez la commande pour exécuter le programme avec les arguments `10` et `25`. *(1.5 points)*
    
    3. Expliquez ce qui se passe lors de la compilation d'un fichier Java. *(2 points)*
  ],
  points: 5,
)

#question_types.answer_bloc_with_icon(
  height_cm: 4cm,
  margin_bottom: 0cm,
  icon_image: image("assets/icons/fa-terminal.svg", width: 0.4cm),
  icon_text: "Question 1 : Compilation",
  show_official_answer: show_official_answer,
  official_answer: [
    ```bash
    javac Calculatrice.java
    ```
    
    *(1.5 point pour la commande correcte)*
  ],
)

#question_types.answer_bloc_with_icon(
  height_cm: 4cm,
  margin_bottom: 0cm,
  icon_image: image("assets/icons/fa-terminal.svg", width: 0.4cm),
  icon_text: "Question 2 : Exécution",
  show_official_answer: show_official_answer,
  official_answer: [
    ```bash
    java Calculatrice 10 25
    ```
    
    *(1.5 point pour la commande correcte, noter l'absence de .class)*
  ],
)

#question_types.answer_bloc_with_icon(
  height_cm: 8cm,
  margin_bottom: 0cm,
  icon_text: "Question 3 : Explication",
  show_official_answer: show_official_answer,
  official_answer: [
    *Processus de compilation (2 points) :*
    
    1. Le compilateur Java (`javac`) lit le fichier source `.java`
    2. Il vérifie la syntaxe et la cohérence du code
    3. Il traduit le code Java en bytecode (instructions pour la JVM)
    4. Il génère un fichier `.class` contenant ce bytecode
    5. Ce bytecode peut ensuite être exécuté par la JVM sur n'importe quelle plateforme
    
    *(2 points pour une explication complète du processus)*
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 8 : Erreurs de syntaxe Java
// ============================================================================

#question_types.question_statement(
  title: "Identification d'erreurs de syntaxe",
  statement: [
    Le code Java ci-dessous contient *exactement 5 erreurs de syntaxe* qui empêcheront la compilation.
    
    Pour chaque erreur :
    1. Indiquez la/les ligne(s) concernée(s)
    2. Expliquez quelle règle de syntaxe Java n'est pas respectée
    3. Proposez la correction
    
    ```java
    public class CalculMoyenne {
        public static void main(String[] args) {
            int[] notes = {5, 4, 6, 3, 5}
            double somme = 0;
            
            for (int i = 0, i < notes.length, i++) {
                somme = somme + notes[i];
            }
            
            double moyenne = somme / notes.length;
            
            System.out.println("La moyenne est : " + moyenne)
            
            if (moyenne >= 4) {
                System.out.println("Réussi !");
            }
        }
    }
    ```
  ],
  points: 5,
)

#pagebreak()


#question_types.answer_bloc(
  margin_bottom: 0cm,
  show_official_answer: show_official_answer,
  official_answer: [
    *Les 5 erreurs de syntaxe (1 point par erreur identifiée et corrigée) :*
    
    1. *Ligne 3* : Il manque un point-virgule `;` à la fin de la déclaration du tableau
       - *Correction* : `int[] notes = {5, 4, 6, 3, 5};`
    
    2. *Ligne 6* : Dans la boucle `for`, la première virgule devrait être un point-virgule
       - *Correction* : `for (int i = 0; i < notes.length, i++)`
    
    3. *Ligne 6* : Dans la boucle `for`, la deuxième virgule devrait être un point-virgule
       - *Correction* : `for (int i = 0; i < notes.length; i++)`
    
    4. *Ligne 12* : Il manque un point-virgule `;` à la fin du `println`
       - *Correction* : `System.out.println("La moyenne est : " + moyenne);`
    
    5. *Ligne 14* : Il manque une accolade ouvrante `{` après la condition `if`
       - *Note* : Le code compile sans accolades pour un `if` avec une seule instruction, mais c'est une mauvaise pratique
       - *Correction* : `if (moyenne >= 4) {`
    
    *Code corrigé complet :*
    ```java
    public class CalculMoyenne {
        public static void main(String[] args) {
            int[] notes = {5, 4, 6, 3, 5};
            double somme = 0;
            
            for (int i = 0; i < notes.length; i++) {
                somme = somme + notes[i];
            }
            
            double moyenne = somme / notes.length;
            
            System.out.println("La moyenne est : " + moyenne);
            
            if (moyenne >= 4) {
                System.out.println("Réussi !");
            }
        }
    }
    ```
  ],
)

#pagebreak()

= Question 9

#question_types.question_statement(
  title: "Analyse de bonnes pratiques",
  statement: [
    Voici deux versions d'un code Java qui affiche un message selon la valeur d'une moyenne :
    
    *Version A :*
    ```java
    if (moyenne >= 4)
        System.out.println("Réussi !");
    else
        System.out.println("Échoué !");
    ```
    
    *Version B :*
    ```java
    if (moyenne >= 4) {
        System.out.println("Réussi !");
    } else {
        System.out.println("Échoué !");
    }
    ```
    
    Répondez aux questions suivantes :
    
    1. La version A compile-t-elle sans erreur ? Justifiez brièvement.
    
    2. La version B compile-t-elle sans erreur ? Justifiez brièvement.
    
    3. Laquelle des deux versions recommanderiez-vous d'utiliser ? Expliquez votre choix en mentionnant au moins deux raisons liées aux bonnes pratiques de programmation.
  ],
  points: 4,
)

#question_types.answer_bloc(
  height_cm: 12cm,
  margin_bottom: 0cm,
  show_official_answer: show_official_answer,
  official_answer: [
    *Réponses attendues :*
    
    1. *La version A compile-t-elle ?* (1 point)
       - *Oui*, la version A compile sans erreur.
       - En Java, quand il n'y a qu'une seule instruction après `if` ou `else`, les accolades sont optionnelles.
       - Le compilateur accepte cette syntaxe.
    
    2. *La version B compile-t-elle ?* (1 point)
       - *Oui*, la version B compile sans erreur.
       - Les accolades `{}` sont toujours acceptées pour délimiter les blocs d'instructions.
    
    3. *Quelle version recommander ?* (2 points - 1 point pour le choix, 1 point pour 2 raisons)
       - *Recommandation : Version B* (avec accolades)
       - *Raisons possibles :*
         - *Lisibilité* : Les accolades rendent la structure du code plus claire et explicite
         - *Prévention d'erreurs* : Si on ajoute plus tard une deuxième instruction, on pourrait oublier d'ajouter les accolades, créant un bug silencieux
         - *Cohérence* : Le code reste uniforme même avec une seule instruction
         - *Maintenabilité* : Plus facile à modifier et moins risqué lors de modifications futures
         - *Standards de l'industrie* : La plupart des guides de style Java (Google, Oracle) recommandent toujours utiliser les accolades
       
       *(Accepter la version B avec au moins 2 raisons valables parmi celles-ci ou équivalentes)*
  ],
)

