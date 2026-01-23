#import "@preview/codelst:2.0.2": sourcecode
#import "@local/heig-vd-evaluations-and-exams-template:0.1.0": conf, question_types

#let parts = (
  ("Question 1", 7),
  ("Question 2", 8),
  ("Question 3", 8),
  ("Question 4", 6),
  ("Question 5", 5),
  ("Question 6", 6),
)

#let additional_information = [
  Vous avez le droit à une page recto-verso de résumé avec vos propres notes.

  Vous pouvez répondre aux questions en français ou en anglais.

  Toute tentative de triche sera sanctionnée par la note de 1.

  _*Merci de mettre votre prénom et nom sur chaque page.*_

  #v(0.5cm)

  _Examen d'entraînement préparé avec l'aide de Ludovic Delafontaine, Hadrien Louis, GitHub Copilot et Claude (Anthropic)._
]

#show: doc => conf(
  evaluation_title: "Programmation Ingénierie des Médias 1 (ProgIM1)",
  evaluation_subtitle: "Examen d'entraînement - Partie 2",
  evaluation_date: "24.01.2026",
  duration: "90 minutes",
  parts,
  additional_information,
  doc,
)

#let show_official_answer = true

// ============================================================================
// QUESTION 1 : Code avec erreurs - Tableaux et boucles
// ============================================================================

#question_types.question_statement(
  title: "Analyse de code : Tableaux et boucles",
  statement: [
    Le code Java ci-dessous doit calculer la moyenne des notes d'un groupe de personnes qui étudient et afficher combien de notes sont supérieures ou égales à 4 (la note de passage).
    
    Ce code contient *exactement 4 erreurs*.
    
    Pour chaque erreur :
    1. Indiquez la/les ligne(s) concernée(s)
    2. Expliquez ce qui ne fonctionne pas et pourquoi
    3. Proposez une correction
    
    #sourcecode[```java
    public class AnalyseNotes {
        public static void main(String[] args) {
            double[] notes = {5.5, 3.0, 4.5, 2.5, 6.0, 4.0};
            
            double somme = 0;
            int nombreReussites = 0;
            
            // Calcul de la somme des notes
            for (int i = 0; i <= notes.length; i++) {
                somme = somme + notes[i];
            }
            
            // Calcul de la moyenne
            double moyenne = somme / notes.size();
            
            // Comptage des réussites
            for (int i = 1; i < notes.length; i++) {
                if (notes[i] > 4) {
                    nombreReussites++;
                }
            }
            
            System.out.println("Moyenne : " + moyenne);
            System.out.println("Nombre de réussites : " + nombreReussites);
        }
    }
    ```]
  ],
  points: 7,
)

#pagebreak()


#question_types.answer_bloc(
  margin_bottom: 0cm,
  show_official_answer: show_official_answer,
  official_answer: [
    *Les 4 erreurs (~1.75 point par erreur identifiée et corrigée) :*
    
    1. *Ligne 9* : `i <= notes.length` → doit être `i < notes.length`
       - *Problème* : Provoque un `ArrayIndexOutOfBoundsException` car les indices vont de 0 à `length-1`
       - *Correction* : `for (int i = 0; i < notes.length; i++)`
    
    2. *Ligne 14* : `notes.size()` → doit être `notes.length`
       - *Problème* : Les tableaux utilisent `.length` (attribut), pas `.size()` (méthode des collections)
       - *Correction* : `double moyenne = somme / notes.length;`
    
    3. *Ligne 17* : `i = 1` → doit être `i = 0`
       - *Problème* : On ignore la première note (index 0), ce qui fausse le comptage
       - *Correction* : `for (int i = 0; i < notes.length; i++)`
    
    4. *Ligne 18* : `notes[i] > 4` → doit être `notes[i] >= 4`
       - *Problème* : On n'inclut pas les notes exactement égales à 4.0 (note de passage)
       - *Correction* : `if (notes[i] >= 4)`
    
    *(Note : Il n'y a en fait que 4 erreurs principales. Si des erreurs logiques supplémentaires sont trouvées, les accepter si elles sont justifiées)*
    
    *Code corrigé complet :*
    ```java
    public class AnalyseNotes {
        public static void main(String[] args) {
            double[] notes = {5.5, 3.0, 4.5, 2.5, 6.0, 4.0};
            
            double somme = 0;
            int nombreReussites = 0;
            
            for (int i = 0; i < notes.length; i++) {
                somme = somme + notes[i];
            }
            
            double moyenne = somme / notes.length;
            
            for (int i = 0; i < notes.length; i++) {
                if (notes[i] >= 4) {
                    nombreReussites++;
                }
            }
            
            System.out.println("Moyenne : " + moyenne);
            System.out.println("Nombre de réussites : " + nombreReussites);
        }
    }
    ```
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 2 : Lecture et complétion de code
// ============================================================================

#question_types.question_statement(
  title: "Lecture et complétion de fonctions",
  statement: [
    *Partie A (4 points)* : Lisez la fonction suivante et expliquez ce qu'elle fait :
    
    ```java
    public static int mystere(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * mystere(n - 1);
    }
    ```
    
    1. Que retourne `mystere(5)` ? *(1 point)*
    2. Quel est le nom mathématique de cette opération ? *(1 point)*
    3. Cette fonction est-elle récursive ou itérative ? Justifiez. *(2 points)*
    
    *Partie B (4 points)* : Complétez la fonction suivante qui trouve le maximum dans un tableau :
    
    ```java
    public static int trouverMaximum(int[] tableau) {
        int max = tableau[0];
        
        for (int i = ___; i < ___; i++) {
            if (tableau[i] ___ max) {
                max = ___;
            }
        }
        
        return max;
    }
    ```
  ],
  points: 8,
)

#question_types.answer_bloc_with_icon(
  height_cm: 10cm,
  margin_bottom: 0cm,
  icon_text: "Partie A : Lecture de code",
  show_official_answer: show_official_answer,
  official_answer: [
    1. `mystere(5)` retourne `120` *(1 point)*
       - Calcul : 5 × 4 × 3 × 2 × 1 = 120
    
    2. C'est une *factorielle* *(1 point)*
    
    3. Cette fonction est *récursive* *(2 points)* car :
       - Elle s'appelle elle-même (`mystere(n - 1)`)
       - Elle a un cas de base (n <= 1) qui arrête la récursion
       
    *(1 point pour "récursive", 1 point pour la justification correcte)*
  ],
)

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Partie B : Complétion de code",
  show_official_answer: show_official_answer,
  official_answer: [
    ```java
    public static int trouverMaximum(int[] tableau) {
        int max = tableau[0];
        
        for (int i = 1; i < tableau.length; i++) {  // (2 points)
            if (tableau[i] > max) {  // (1 point)
                max = tableau[i];  // (1 point)
            }
        }
        
        return max;
    }
    ```
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 3 : Algorithme de recherche et comptage
// ============================================================================

#question_types.question_statement(
  title: "Algorithme de recherche dans un tableau",
  statement: [
    Complétez la fonction Java suivante qui cherche si un élément existe dans un tableau et retourne son index (position). Si l'élément n'existe pas, la fonction retourne `-1`.
    
    ```java
    public class RechercheTableau {
        /**
         * Cherche un élément dans un tableau
         * @param tableau Le tableau dans lequel chercher
         * @param element L'élément à chercher
         * @return L'index de l'élément, ou -1 s'il n'existe pas
         */
        public static int rechercher(int[] tableau, int element) {
            // TODO: Implémenter la recherche
            
            
            
            
            
            
            
            
            
        }
        
        public static void main(String[] args) {
            int[] nombres = {10, 25, 7, 42, 18, 3};
            
            System.out.println(rechercher(nombres, 42));  // Doit afficher 3
            System.out.println(rechercher(nombres, 99));  // Doit afficher -1
        }
    }
    ```
  ],
  points: 8,
)

#question_types.answer_bloc(
  height_cm: 15cm,
  margin_bottom: 0cm,
  show_official_answer: show_official_answer,
  official_answer: [
    ```java
    public static int rechercher(int[] tableau, int element) {
        // Parcourir le tableau (2 points - boucle correcte)
        for (int i = 0; i < tableau.length; i++) {
            // Comparer chaque élément (2 points)
            if (tableau[i] == element) {
                // Retourner l'index si trouvé (2 points)
                return i;
            }
        }
        
        // Retourner -1 si pas trouvé (2 points)
        return -1;
    }
    ```
    
    *Répartition des points :*
    - Boucle correcte parcourant tout le tableau : 2 points
    - Comparaison de chaque élément : 2 points
    - Retour de l'index quand trouvé : 2 points
    - Retour de -1 si non trouvé : 2 points
    
    *Total : 8 points*
    
    *Variantes acceptables :*
    - Utilisation de `for-each` (si adaptation correcte)
    - Utilisation de `while`
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 4 : Parcours avancés de tableaux
// ============================================================================

#question_types.question_statement(
  title: "Parcours avancés de tableaux",
  statement: [
    Pour chacune des trois tâches suivantes, complétez *uniquement la ligne de la boucle `for`*.
    
    *Partie A (2 points)* : Complétez la boucle pour parcourir le tableau *en sens inverse* :
    
    ```java
    int[] nombres = {10, 20, 30, 40, 50};
    
    for (int i = ___; ___; ___) {
        System.out.println(nombres[i]);
    }
    ```
    
    *Partie B (2 points)* : Complétez la boucle pour parcourir en *ignorant le premier et le dernier élément* :
    
    ```java
    int[] valeurs = {5, 12, 8, 15, 3};
    
    for (int i = ___; ___; ___) {
        System.out.println(valeurs[i]);
    }
    ```
    
    *Partie C (2 points)* : Complétez la boucle pour parcourir uniquement les éléments aux *indices pairs* (0, 2, 4, ...) :
    
    ```java
    String[] mots = {"chat", "chien", "oiseau", "poisson", "souris"};
    
    for (int i = ___; ___; ___) {
        System.out.println(mots[i]);
    }
    ```
  ],
  points: 6,
)

#question_types.answer_bloc_with_icon(
  height_cm: 5cm,
  margin_bottom: 0cm,
  icon_text: "Partie A : Parcours inversé (2 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    ```java
    for (int i = nombres.length - 1; i >= 0; i--) {
        System.out.println(nombres[i]);
    }
    ```
    
    *(0.7 pt initialisation, 0.7 pt condition, 0.6 pt décrémentation)*
  ],
)

#question_types.answer_bloc_with_icon(
  height_cm: 5cm,
  margin_bottom: 0cm,
  icon_text: "Partie B : Sans premier ni dernier (2 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    ```java
    for (int i = 1; i < valeurs.length - 1; i++) {
        System.out.println(valeurs[i]);
    }
    ```
    
    *(0.7 pt pour i = 1, 0.7 pt pour length - 1, 0.6 pt pour i++)*
  ],
)

#question_types.answer_bloc_with_icon(
  height_cm: 5cm,
  margin_bottom: 0cm,
  icon_text: "Partie C : Indices pairs (2 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    ```java
    for (int i = 0; i < mots.length; i += 2) {
        System.out.println(mots[i]);
    }
    ```
    
    *(0.5 pt pour i = 0, 0.5 pt pour i < length, 1 pt pour i += 2)*
    
    *Alternative acceptable :*
    ```java
    for (int i = 0; i < mots.length; i++) {
        if (i % 2 == 0) {
            System.out.println(mots[i]);
        }
    }
    ```
    *(mais moins efficace, accepter avec 1.5 point)*
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 5 : Scanner et interaction utilisateur
// ============================================================================

#question_types.question_statement(
  title: "Scanner et interaction avec l'utilisatrice",
  statement: [
    Complétez le code Java suivant pour créer un petit programme interactif qui :
    1. Demande le prénom de l'utilisatrice
    2. Demande son âge
    3. Affiche un message de bienvenue personnalisé
    
    ```java
    import java.util.Scanner;
    
    public class Bienvenue {
        public static void main(String[] args) {
            // TODO: Créer un objet Scanner
            
            
            System.out.print("Entrez votre prénom : ");
            // TODO: Lire le prénom
            
            
            System.out.print("Entrez votre âge : ");
            // TODO: Lire l'âge (nombre entier)
            
            
            // TODO: Afficher "Bonjour [prénom], vous avez [âge] ans !"
            
            
            // TODO: Fermer le Scanner
            
        }
    }
    ```
  ],
  points: 5,
)

#question_types.answer_bloc(
  height_cm: 12cm,
  margin_bottom: 0cm,
  show_official_answer: show_official_answer,
  official_answer: [
    ```java
    import java.util.Scanner;
    
    public class Bienvenue {
        public static void main(String[] args) {
            // Créer un objet Scanner (1 point)
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Entrez votre prénom : ");
            // Lire le prénom (1 point)
            String prenom = scanner.nextLine();
            
            System.out.print("Entrez votre âge : ");
            // Lire l'âge (1 point)
            int age = scanner.nextInt();
            
            // Afficher le message (1 point)
            System.out.println("Bonjour " + prenom + ", vous avez " + age + " ans !");
            
            // Fermer le Scanner (1 point)
            scanner.close();
        }
    }
    ```
    
    *Total : 5 points (1 point par TODO complété correctement)*
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 6 : Manipulation de chaînes de caractères
// ============================================================================

#question_types.question_statement(
  title: "Manipulation de chaînes de caractères (Strings)",
  statement: [
    Complétez le code suivant qui manipule des chaînes de caractères :
    
    ```java
    public class ManipulationStrings {
        public static void main(String[] args) {
            String texte = "Programmation en Java";
            
            // TODO: Afficher la longueur de la chaîne
            System.out.println("Longueur : " + ___);
            
            // TODO: Afficher le texte en majuscules
            System.out.println("Majuscules : " + ___);
            
            // TODO: Extraire le mot "Java" (indices 17 à 21)
            String mot = texte.___(17, 21);
            System.out.println("Mot extrait : " + mot);
            
            // TODO: Vérifier si le texte contient "Java"
            if (texte.___(___)) {
                System.out.println("Le texte contient Java !");
            }
        }
    }
    ```
    
    *Output attendu :*
    ```
    Longueur : 21
    Majuscules : PROGRAMMATION EN JAVA
    Mot extrait : Java
    Le texte contient Java !
    ```
  ],
  points: 6,
)

#question_types.answer_bloc(
  height_cm: 12cm,
  margin_bottom: 0cm,
  show_official_answer: show_official_answer,
  official_answer: [
    ```java
    public class ManipulationStrings {
        public static void main(String[] args) {
            String texte = "Programmation en Java";
            
            // Afficher la longueur (1.5 point)
            System.out.println("Longueur : " + texte.length());
            
            // Afficher en majuscules (1.5 point)
            System.out.println("Majuscules : " + texte.toUpperCase());
            
            // Extraire "Java" (1.5 point)
            String mot = texte.substring(17, 21);
            System.out.println("Mot extrait : " + mot);
            
            // Vérifier si contient "Java" (1.5 point)
            if (texte.contains("Java")) {
                System.out.println("Le texte contient Java !");
            }
        }
    }
    ```
  ],
)
