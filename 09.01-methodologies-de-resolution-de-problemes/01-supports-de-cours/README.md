# Méthodologies de résolution de problèmes

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/09.01-methodologies-de-resolution-de-problemes/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/09.01-methodologies-de-resolution-de-problemes/01-supports-de-cours/09.01-methodologies-de-resolution-de-problemes-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/)
- Exercices : [Lien vers le contenu](../03-exercices/README.md)

## Introduction

La programmation ne se résume pas à connaître la syntaxe d'un langage. Un bon
développeur ou une bonne développeuse est avant tout une personne capable de
**résoudre des problèmes de manière structurée**.

> [!IMPORTANT] La méthodologie de résolution de problèmes est plus importante
> que la maîtrise d'un langage spécifique. Un bon ingénieur ou une bonne
> ingénieure sait **comment** aborder un problème, pas seulement **quoi** coder.

### Pourquoi la méthodologie est essentielle

Lorsque vous serez confronté à un problème réel en entreprise ou dans un projet,
vous n'aurez pas toujours quelqu'un pour vous dire exactement quoi faire. Vous
devrez :

- Comprendre le problème dans son ensemble
- Identifier ce qui est vraiment demandé
- Décomposer le problème en parties gérables
- Concevoir une solution avant de coder
- Évaluer si votre solution répond bien au besoin

**Exemple concret** : Imaginez qu'on vous demande de créer un système pour gérer
une bibliothèque de prêt d'outils entre voisins. Si vous commencez directement à
coder sans réfléchir, vous risquez de vous perdre rapidement. Une bonne
méthodologie vous permet d'avancer de manière structurée et efficace.

### Apprendre à apprendre

En informatique, les technologies évoluent constamment. Ce que vous apprenez
aujourd'hui (Java, par exemple) pourrait ne pas être le langage que vous
utiliserez dans 5 ans. Ce qui reste constant, c'est votre capacité à :

- Analyser un problème
- Concevoir une solution
- L'implémenter de manière claire
- La tester et la valider

Ces compétences sont **transférables** d'un langage à l'autre, d'un domaine à
l'autre.

## Décomposition de problèmes

La décomposition consiste à diviser un problème complexe en sous-problèmes plus
simples et gérables. C'est une compétence fondamentale en programmation.

### Approche descendante (top-down)

L'approche descendante consiste à partir du problème global et à le diviser
progressivement en sous-problèmes de plus en plus détaillés.

**Principe** :

1. Comprendre le problème dans son ensemble
2. Identifier les grandes étapes nécessaires
3. Décomposer chaque étape en sous-étapes
4. Continuer jusqu'à avoir des tâches simples à implémenter

**Exemple : Organiser une fête de quartier**

```
Niveau 1 : Organiser une fête de quartier
├── Niveau 2 : Planifier l'événement
│   ├── Choisir une date
│   ├── Trouver un lieu
│   └── Établir un budget
├── Niveau 2 : Gérer la logistique
│   ├── Réserver le matériel
│   ├── Organiser les stands
│   └── Prévoir la gestion des déchets
└── Niveau 2 : Communiquer
    ├── Créer des affiches
    ├── Informer les voisins
    └── Coordonner les bénévoles
```

Chaque sous-problème peut ensuite être décomposé davantage :

```
Gérer la logistique
└── Prévoir la gestion des déchets
    ├── Calculer le nombre de poubelles nécessaires
    ├── Organiser le tri sélectif
    ├── Prévoir la collecte et le recyclage
    └── Sensibiliser les participantes au tri
```

**Application en programmation** :

Imaginons un programme pour gérer un potager partagé :

```
Programme de gestion de potager partagé
├── Gérer les membres
│   ├── Ajouter un nouveau membre
│   ├── Retirer un membre
│   └── Afficher la liste des membres
├── Gérer les parcelles
│   ├── Attribuer une parcelle
│   ├── Libérer une parcelle
│   └── Afficher l'état des parcelles
└── Gérer les ressources communes
    ├── Planifier l'arrosage
    ├── Gérer le compost
    └── Organiser l'entretien collectif
```

### Approche ascendante (bottom-up)

L'approche ascendante consiste à identifier d'abord les petites tâches ou
fonctions de base, puis à les combiner pour résoudre des problèmes plus
complexes.

**Principe** :

1. Identifier les opérations de base nécessaires
2. Implémenter ces opérations simples
3. Combiner ces opérations pour créer des fonctionnalités plus complexes
4. Assembler le tout pour résoudre le problème global

**Exemple : Calculateur d'empreinte carbone**

Commençons par les opérations de base :

```java
// Opérations de base
double calculerDistanceVelo(double km)
double calculerDistanceVoiture(double km)
double calculerDistanceTrain(double km)
double calculerDistanceAvion(double km)
```

Ensuite, on combine ces opérations :

```java
// Fonction de niveau intermédiaire
double calculerEmpreinteMensuelle(
    double kmVelo, double kmVoiture,
    double kmTrain, double kmAvion
)
```

Enfin, on crée la fonction de haut niveau :

```java
// Fonction finale
void afficherBilanAnnuel(double[] donneesParMois)
```

### Identifier les sous-problèmes réutilisables

Lors de la décomposition, certains sous-problèmes reviennent souvent. Il est
important de les identifier pour éviter de dupliquer le code.

**Exemple** : Dans un système de gestion de bibliothèque d'outils :

```
Sous-problèmes réutilisables :
- Valider une date
- Calculer le nombre de jours entre deux dates
- Vérifier si un utilisateur existe
- Afficher un message d'erreur formaté
```

Ces fonctions peuvent être utilisées dans plusieurs contextes différents :

```java
// Fonction réutilisable
boolean validerDate(int jour, int mois, int annee) {
    if (mois < 1 || mois > 12) return false;
    if (jour < 1 || jour > joursParMois(mois, annee)) return false;
    return true;
}

// Utilisée dans différents contextes
void enregistrerEmprunt() {
    // Utilise validerDate pour la date d'emprunt
}

void enregistrerReservation() {
    // Utilise validerDate pour la date de réservation
}
```

> [!TIP] Lorsque vous identifiez un sous-problème qui pourrait être utile
> ailleurs, créez une fonction dédiée avec un nom clair et des paramètres
> génériques.

## Analyse du problème

Avant de commencer à coder, il est essentiel d'analyser le problème en
profondeur. Cette phase permet d'éviter de nombreuses erreurs et de gagner du
temps.

### Identifier les entrées et les sorties

Pour chaque problème, demandez-vous :

- **Quelles sont les données en entrée ?** (ce que l'utilisatrice fournit)
- **Quelles sont les données en sortie ?** (ce que le programme doit produire)
- **Quel est le format de ces données ?** (nombre, texte, tableau, etc.)

**Exemple : Calculateur de réduction pour un système d'échange local**

| Aspect  | Description                                            |
| ------- | ------------------------------------------------------ |
| Entrées | Prix initial (double), nombre de services rendus (int) |
| Sorties | Prix final après réduction (double)                    |
| Format  | Nombres avec 2 décimales pour les prix                 |

**Exemple : Planificateur de covoiturage**

| Aspect  | Description                                            |
| ------- | ------------------------------------------------------ |
| Entrées | Liste de trajets, adresses de départ/arrivée, horaires |
| Sorties | Groupes de covoiturage optimisés, économies de CO2     |
| Format  | Tableau de structures complexes, rapport textuel       |

### Identifier les contraintes et les cas limites

Les contraintes définissent les limites du problème. Les cas limites (edge
cases) sont les situations particulières qui pourraient poser problème.

**Types de contraintes** :

- **Contraintes de domaine** : valeurs minimales/maximales acceptées
- **Contraintes de format** : format des données en entrée
- **Contraintes de performance** : temps de calcul acceptable
- **Contraintes métier** : règles spécifiques au domaine

**Exemple : Système de réservation d'outils**

| Type de contrainte | Description                                   |
| ------------------ | --------------------------------------------- |
| Domaine            | La durée de prêt est entre 1 et 30 jours      |
| Format             | Le nom de l'outil est une chaîne non vide     |
| Performance        | Réponse en moins d'1 seconde                  |
| Métier             | Un outil ne peut être prêté qu'à une personne |

**Cas limites à considérer** :

```
Entrées valides mais extrêmes :
- Durée de prêt = 1 jour (minimum)
- Durée de prêt = 30 jours (maximum)
- Nom de l'outil = "A" (très court)

Entrées invalides :
- Durée de prêt = 0 ou négative
- Durée de prêt > 30
- Nom de l'outil vide ou null
- Date de début dans le passé

Situations exceptionnelles :
- Aucun outil disponible
- Tous les outils sont réservés
- L'utilisatrice a déjà emprunté cet outil
```

> [!WARNING] Ne pas prendre en compte les cas limites est l'une des erreurs les
> plus fréquentes en programmation. Un programme qui fonctionne dans les cas
> normaux mais échoue dans les cas limites est un programme incomplet.

### Définir les critères de réussite

Comment saurez-vous que votre programme fonctionne correctement ? Il faut
définir des critères clairs de réussite.

**Exemple : Calculateur d'empreinte carbone**

| Critère       | Description                                |
| ------------- | ------------------------------------------ |
| Fonctionnel   | Calcule correctement l'empreinte en kg CO2 |
| Précision     | Arrondi à 2 décimales                      |
| Validation    | Refuse les distances négatives             |
| Utilisabilité | Messages d'erreur clairs                   |
| Comparaison   | Affiche les moyennes nationales            |

**Critères généraux de qualité** :

- **Correction** : Le programme produit les résultats attendus
- **Robustesse** : Le programme gère les erreurs sans planter
- **Lisibilité** : Le code est facile à comprendre
- **Maintenabilité** : Le code est facile à modifier
- **Efficacité** : Le programme s'exécute dans un temps raisonnable

## Stratégies de conception

Une fois le problème analysé et décomposé, il faut concevoir la solution. Il
existe plusieurs stratégies pour y parvenir.

### Diviser pour régner

Cette stratégie consiste à diviser le problème en sous-problèmes
**indépendants**, les résoudre séparément, puis combiner les solutions.

**Principe** :

1. Diviser le problème en sous-problèmes plus petits
2. Résoudre chaque sous-problème indépendamment
3. Combiner les solutions des sous-problèmes

**Exemple : Validation d'un formulaire d'inscription**

Au lieu de valider tout le formulaire d'un coup, on peut le diviser :

```java
boolean validerFormulaire(String nom, String email, String telephone) {
    boolean nomValide = validerNom(nom);
    boolean emailValide = validerEmail(email);
    boolean telephoneValide = validerTelephone(telephone);

    return nomValide && emailValide && telephoneValide;
}

boolean validerNom(String nom) {
    // Vérifie que le nom n'est pas vide et contient au moins 2 caractères
    return nom != null && nom.length() >= 2;
}

boolean validerEmail(String email) {
    // Vérifie que l'email contient @ et un point
    return email != null && email.contains("@") && email.contains(".");
}

boolean validerTelephone(String telephone) {
    // Vérifie que le téléphone contient uniquement des chiffres
    return telephone != null && telephone.matches("[0-9]+");
}
```

Chaque fonction de validation est **indépendante** et peut être testée
séparément.

### Approche itérative vs approche récursive

Il existe deux grandes façons de concevoir des algorithmes : l'approche
itérative (avec des boucles) et l'approche récursive (une fonction qui s'appelle
elle-même).

**Approche itérative** : Répéter une opération avec une boucle

```java
// Calcul de la somme des N premiers entiers (itératif)
int sommePremiers(int n) {
    int somme = 0;
    for (int i = 1; i <= n; i++) {
        somme = somme + i;
    }
    return somme;
}
```

**Approche récursive** : Une fonction qui s'appelle elle-même

```java
// Calcul de la somme des N premiers entiers (récursif)
int sommePremiers(int n) {
    if (n == 1) {
        return 1;  // Cas de base
    }
    return n + sommePremiers(n - 1);  // Appel récursif
}
```

> [!NOTE] À ce stade du cours, vous n'avez pas besoin de maîtriser la
> récursivité. L'approche itérative est généralement plus naturelle pour
> débuter. La récursivité sera abordée dans des cours plus avancés.

**Quand utiliser quelle approche ?**

| Situation                                 | Approche recommandée   |
| ----------------------------------------- | ---------------------- |
| Parcourir un tableau                      | Itérative              |
| Répéter une action N fois                 | Itérative              |
| Problème naturellement récursif           | Récursive              |
| Recherche dans une structure arborescente | Récursive ou itérative |

### Utilisation de fonctions pour structurer le code

Les fonctions sont l'outil principal pour structurer votre code. Elles
permettent de :

- **Réutiliser** du code
- **Organiser** le code en blocs logiques
- **Simplifier** la lecture
- **Faciliter** les tests

**Principes de conception de fonctions** :

1. **Une fonction = une responsabilité** : Chaque fonction doit faire une seule
   chose clairement définie

   ```java
   // Mauvais : fonction qui fait trop de choses
   void gererUtilisateur(String nom, String action) {
       // Validation
       // Modification de la base de données
       // Envoi d'un email
       // Affichage d'un message
   }

   // Bon : fonctions séparées
   boolean validerNom(String nom)
   void ajouterUtilisateur(String nom)
   void envoyerEmailBienvenue(String email)
   void afficherConfirmation(String message)
   ```

2. **Nom explicite** : Le nom doit décrire ce que fait la fonction

   ```java
   // Mauvais
   void f(double x)

   // Bon
   void calculerReduction(double prixInitial)
   ```

3. **Paramètres clairs** : Les paramètres doivent être nécessaires et bien
   nommés

   ```java
   // Mauvais : trop de paramètres
   void creerReservation(String n, int d, int m, int a, String o, int dur)

   // Bon : paramètres regroupés et explicites
   void creerReservation(String nomUtilisateur, Date date,
                         String nomOutil, int dureeJours)
   ```

4. **Petite taille** : Une fonction ne devrait pas dépasser 20-30 lignes

**Exemple : Gestion d'une bibliothèque d'outils**

```java
// Structure claire avec des fonctions dédiées

void afficherMenuPrincipal() {
    System.out.println("=== Bibliothèque d'outils ===");
    System.out.println("1. Emprunter un outil");
    System.out.println("2. Retourner un outil");
    System.out.println("3. Voir les outils disponibles");
    System.out.println("0. Quitter");
}

int lireChoixUtilisateur() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Votre choix : ");
    return scanner.nextInt();
}

void traiterChoix(int choix) {
    switch (choix) {
        case 1: emprunterOutil(); break;
        case 2: retournerOutil(); break;
        case 3: afficherOutilsDisponibles(); break;
        case 0: quitter(); break;
        default: afficherErreur("Choix invalide");
    }
}

void emprunterOutil() {
    String nomOutil = demanderNomOutil();
    if (outilDisponible(nomOutil)) {
        enregistrerEmprunt(nomOutil);
        afficherConfirmation("Emprunt enregistré");
    } else {
        afficherErreur("Outil non disponible");
    }
}
```

## Outils de planification

Avant d'écrire du code, il est utile d'utiliser des outils de planification pour
clarifier vos idées.

### Pseudocode

Le pseudocode est une description en langage naturel structuré de l'algorithme,
sans se préoccuper de la syntaxe d'un langage spécifique.

**Avantages** :

- Se concentrer sur la logique sans se soucier de la syntaxe
- Communiquer facilement avec d'autres personnes
- Identifier les problèmes avant de coder

**Conventions du pseudocode** :

```
DÉBUT
    instruction 1
    instruction 2
    SI condition ALORS
        instruction 3
    SINON
        instruction 4
    FIN SI

    POUR i DE 1 À n FAIRE
        instruction 5
    FIN POUR
FIN
```

**Exemple : Calculateur de réduction pour un système d'échange local**

```
DÉBUT CalculerReduction
    ENTRÉES :
        prixInitial : nombre décimal
        nombreServices : nombre entier

    SORTIE :
        prixFinal : nombre décimal

    ALGORITHME :
        tauxReduction ← 0

        SI nombreServices >= 10 ALORS
            tauxReduction ← 0.20
        SINON SI nombreServices >= 5 ALORS
            tauxReduction ← 0.10
        SINON SI nombreServices >= 1 ALORS
            tauxReduction ← 0.05
        FIN SI

        reduction ← prixInitial × tauxReduction
        prixFinal ← prixInitial - reduction

        RETOURNER prixFinal
FIN
```

Une fois le pseudocode écrit, la traduction en Java est simple :

```java
double calculerReduction(double prixInitial, int nombreServices) {
    double tauxReduction = 0;

    if (nombreServices >= 10) {
        tauxReduction = 0.20;
    } else if (nombreServices >= 5) {
        tauxReduction = 0.10;
    } else if (nombreServices >= 1) {
        tauxReduction = 0.05;
    }

    double reduction = prixInitial * tauxReduction;
    double prixFinal = prixInitial - reduction;

    return prixFinal;
}
```

### Diagrammes de flux

Les diagrammes de flux (flowcharts) sont des représentations visuelles de
l'algorithme. Ils utilisent des symboles standardisés pour représenter les
différentes étapes.

**Symboles principaux** :

- **Ovale** : Début / Fin
- **Rectangle** : Instruction / Action
- **Losange** : Décision / Condition
- **Parallélogramme** : Entrée / Sortie
- **Flèches** : Flux d'exécution

**Exemple simple** : Vérifier si une personne peut emprunter un outil

```
    [DÉBUT]
       |
       v
[Lire nom utilisateur]
       |
       v
<Utilisateur existe?>
    /     \
  NON     OUI
   |       |
   v       v
[Erreur] <A déjà emprunté 3 outils?>
             /     \
           OUI     NON
            |       |
            v       v
        [Erreur]  [Autoriser emprunt]
                     |
                     v
                  [FIN]
```

> [!TIP] Les diagrammes de flux sont particulièrement utiles pour visualiser les
> décisions complexes et les boucles. Vous pouvez les dessiner à la main sur
> papier ou utiliser des outils comme draw.io ou PlantUML.

### Diagrammes de décomposition

Les diagrammes de décomposition montrent comment un problème complexe est divisé
en sous-problèmes.

**Exemple : Système de gestion de potager partagé**

```
                    Gérer le potager
                           |
        +------------------+------------------+
        |                  |                  |
   Gérer membres    Gérer parcelles   Gérer ressources
        |                  |                  |
    +---+---+          +---+---+          +---+---+
    |   |   |          |   |   |          |   |   |
  Ajout Sup Liste   Attrib Liber Etat  Arros Comp Entret
```

Chaque niveau peut ensuite être détaillé :

```
Gérer l'arrosage
    |
    +-- Calculer les besoins en eau
    |   |
    |   +-- Identifier les plantes
    |   +-- Consulter la météo
    |   +-- Estimer l'évaporation
    |
    +-- Planifier les tours d'arrosage
    |   |
    |   +-- Assigner les jours aux membres
    |   +-- Envoyer les rappels
    |
    +-- Enregistrer les arrosages effectués
```

### Tableaux d'analyse

Les tableaux d'analyse permettent de documenter systématiquement les entrées,
sorties et contraintes pour chaque fonction.

**Exemple : Fonction de validation d'une réservation**

| Aspect              | Description                                                         |
| ------------------- | ------------------------------------------------------------------- |
| **Nom**             | `validerReservation`                                                |
| **But**             | Vérifier qu'une réservation est possible                            |
| **Entrées**         | - `nomOutil` (String)<br>- `dateDebut` (Date)<br>- `duree` (int)    |
| **Sorties**         | `boolean` (true si valide, false sinon)                             |
| **Pré-conditions**  | - `nomOutil` non null<br>- `dateDebut` non null<br>- `duree` > 0    |
| **Post-conditions** | - Retourne true si l'outil est disponible<br>- Retourne false sinon |
| **Contraintes**     | - `duree` entre 1 et 30 jours<br>- `dateDebut` dans le futur        |
| **Cas limites**     | - Outil inexistant<br>- Date dans le passé<br>- Durée hors limites  |

Ce tableau vous aide à réfléchir à tous les aspects de la fonction avant de
l'implémenter.

## Évaluation de solutions

Il existe souvent plusieurs façons de résoudre un problème. Comment choisir la
meilleure ?

### Critères de qualité

Voici les principaux critères pour évaluer une solution :

#### 1. Lisibilité

Un code lisible est facile à comprendre par d'autres personnes (ou par vous-même
dans 6 mois).

```java
// Peu lisible
double c(double p, int n) {
    return p - (p * (n >= 10 ? 0.2 : n >= 5 ? 0.1 : n >= 1 ? 0.05 : 0));
}

// Lisible
double calculerPrixAvecReduction(double prixInitial, int nombreServices) {
    double tauxReduction = determinerTauxReduction(nombreServices);
    double reduction = prixInitial * tauxReduction;
    return prixInitial - reduction;
}

double determinerTauxReduction(int nombreServices) {
    if (nombreServices >= 10) return 0.20;
    if (nombreServices >= 5) return 0.10;
    if (nombreServices >= 1) return 0.05;
    return 0;
}
```

**Éléments de lisibilité** :

- Noms de variables explicites
- Noms de fonctions descriptifs
- Commentaires pertinents
- Indentation cohérente
- Longueur de fonction raisonnable

#### 2. Maintenabilité

Un code maintenable est facile à modifier et à faire évoluer.

```java
// Difficile à maintenir : valeurs "magiques" dans le code
double calculerReduction(double prix, int services) {
    if (services >= 10) return prix * 0.20;
    if (services >= 5) return prix * 0.10;
    if (services >= 1) return prix * 0.05;
    return 0;
}

// Facile à maintenir : constantes nommées
final double TAUX_REDUCTION_BRONZE = 0.05;
final double TAUX_REDUCTION_ARGENT = 0.10;
final double TAUX_REDUCTION_OR = 0.20;
final int SEUIL_BRONZE = 1;
final int SEUIL_ARGENT = 5;
final int SEUIL_OR = 10;

double calculerReduction(double prix, int services) {
    if (services >= SEUIL_OR) return prix * TAUX_REDUCTION_OR;
    if (services >= SEUIL_ARGENT) return prix * TAUX_REDUCTION_ARGENT;
    if (services >= SEUIL_BRONZE) return prix * TAUX_REDUCTION_BRONZE;
    return 0;
}
```

Maintenant, si on veut changer les seuils ou les taux, il suffit de modifier les
constantes.

#### 3. Efficacité

L'efficacité mesure la rapidité d'exécution et l'utilisation de la mémoire.

```java
// Inefficace : recalcule à chaque fois
void afficherTableauMultiplication(int n) {
    for (int i = 1; i <= 10; i++) {
        System.out.println(n + " × " + i + " = " + (n * i));
    }
}

// Plus efficace : utilise une valeur déjà calculée
void afficherTableauMultiplication(int n) {
    int resultat = 0;
    for (int i = 1; i <= 10; i++) {
        resultat += n;  // Addition au lieu de multiplication
        System.out.println(n + " × " + i + " = " + resultat);
    }
}
```

> [!NOTE] Pour les problèmes de ce cours, l'efficacité n'est généralement pas
> critique. Privilégiez la **lisibilité** et la **maintenabilité** avant
> l'optimisation.

### Comparaison de différentes approches

Considérons le problème : trouver le maximum dans un tableau d'entiers.

**Approche 1 : Parcours simple**

```java
int trouverMaximum(int[] tableau) {
    int max = tableau[0];
    for (int i = 1; i < tableau.length; i++) {
        if (tableau[i] > max) {
            max = tableau[i];
        }
    }
    return max;
}
```

**Approche 2 : Avec tri préalable**

```java
int trouverMaximum(int[] tableau) {
    Arrays.sort(tableau);
    return tableau[tableau.length - 1];
}
```

**Comparaison** :

| Critère        | Approche 1                | Approche 2             |
| -------------- | ------------------------- | ---------------------- |
| Lisibilité     | Claire et directe         | Très simple            |
| Efficacité     | O(n) - très rapide        | O(n log n) - plus lent |
| Effet de bord  | Ne modifie pas le tableau | Modifie le tableau     |
| Recommandation | **Meilleure solution**    | À éviter               |

**Conclusion** : L'approche 1 est meilleure car elle est plus rapide et ne
modifie pas le tableau d'origine.

### Quand optimiser et quand privilégier la simplicité

> [!IMPORTANT] "Premature optimization is the root of all evil" - Donald Knuth

Il ne faut pas chercher à optimiser dès le départ. Suivez cette règle :

1. **D'abord**, faites fonctionner le programme correctement
2. **Ensuite**, rendez-le lisible et maintenable
3. **Enfin**, si nécessaire, optimisez les parties lentes

**Exemple : Vérifier si un nombre est premier**

**Version simple** :

```java
boolean estPremier(int n) {
    if (n <= 1) return false;
    for (int i = 2; i < n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}
```

Cette version fonctionne et est facile à comprendre. Pour les petits nombres (<
10000), elle est largement suffisante.

**Version optimisée** :

```java
boolean estPremier(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;

    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) return false;
    }
    return true;
}
```

Cette version est beaucoup plus rapide pour les grands nombres, mais moins
facile à comprendre.

**Quand utiliser quelle version ?**

- Pour un exercice ou un petit programme : version simple
- Pour un programme qui doit traiter des millions de nombres : version optimisée

## Testing et validation

Un programme n'est complet que s'il a été testé et validé.

### Types de cas de test

Il existe différents types de cas de test à considérer :

#### 1. Cas normaux

Ce sont les cas d'utilisation typiques, avec des valeurs normales.

**Exemple : Fonction de calcul de réduction**

```java
// Cas normaux
testCalculerReduction(100.0, 5);   // Résultat attendu : 90.0
testCalculerReduction(50.0, 10);   // Résultat attendu : 40.0
testCalculerReduction(200.0, 3);   // Résultat attendu : 190.0
```

#### 2. Cas limites (edge cases)

Ce sont les valeurs aux frontières du domaine valide.

**Exemple : Fonction de calcul de réduction**

```java
// Cas limites
testCalculerReduction(100.0, 0);   // Résultat attendu : 100.0 (pas de réduction)
testCalculerReduction(100.0, 1);   // Résultat attendu : 95.0 (réduction minimale)
testCalculerReduction(100.0, 4);   // Résultat attendu : 95.0 (juste avant palier)
testCalculerReduction(100.0, 5);   // Résultat attendu : 90.0 (palier)
testCalculerReduction(100.0, 9);   // Résultat attendu : 90.0 (juste avant palier)
testCalculerReduction(100.0, 10);  // Résultat attendu : 80.0 (palier)
testCalculerReduction(0.0, 5);     // Résultat attendu : 0.0 (prix nul)
```

#### 3. Cas d'erreur

Ce sont les entrées invalides qui devraient être détectées.

**Exemple : Fonction de validation de réservation**

```java
// Cas d'erreur
testValiderReservation(null, dateValide, 5);          // Outil null
testValiderReservation("Perceuse", null, 5);          // Date null
testValiderReservation("Perceuse", dateValide, 0);    // Durée invalide
testValiderReservation("Perceuse", dateValide, -5);   // Durée négative
testValiderReservation("Perceuse", dateValide, 100);  // Durée trop longue
testValiderReservation("", dateValide, 5);            // Nom vide
```

### Stratégies de test

#### Test manuel

Le test manuel consiste à exécuter le programme et vérifier manuellement les
résultats.

**Avantages** :

- Simple à mettre en œuvre
- Bon pour les tests exploratoires

**Inconvénients** :

- Fastidieux et répétitif
- Erreurs humaines possibles
- Difficile à reproduire

**Exemple de procédure de test manuel** :

```
Test de la fonction calculerReduction
-------------------------------------
1. Lancer le programme
2. Entrer : prix = 100, services = 5
3. Vérifier que le résultat affiché est 90.0
4. Répéter avec prix = 50, services = 10
5. Vérifier que le résultat affiché est 40.0
...
```

#### Test automatique

Le test automatique utilise du code pour vérifier le code.

```java
void testerCalculerReduction() {
    // Test 1
    double resultat1 = calculerReduction(100.0, 5);
    if (resultat1 != 90.0) {
        System.out.println("ERREUR Test 1 : attendu 90.0, obtenu " + resultat1);
    } else {
        System.out.println("OK Test 1");
    }

    // Test 2
    double resultat2 = calculerReduction(50.0, 10);
    if (resultat2 != 40.0) {
        System.out.println("ERREUR Test 2 : attendu 40.0, obtenu " + resultat2);
    } else {
        System.out.println("OK Test 2");
    }
}
```

**Avantages** :

- Rapide et reproductible
- Détecte les régressions (erreurs réintroduites)
- Peut être exécuté automatiquement

> [!TIP] Écrivez vos tests avant ou pendant le développement, pas seulement à la
> fin. Cela vous aide à mieux concevoir vos fonctions.

### Validation systématique

Pour valider une fonction de manière complète :

1. **Identifier les catégories de tests** (normaux, limites, erreurs)
2. **Créer au moins un test par catégorie**
3. **Exécuter tous les tests**
4. **Documenter les résultats**
5. **Corriger les erreurs détectées**
6. **Re-tester après correction**

**Tableau de validation** :

| ID  | Type   | Entrée               | Sortie attendue | Sortie obtenue | Statut |
| --- | ------ | -------------------- | --------------- | -------------- | ------ |
| T1  | Normal | prix=100, services=5 | 90.0            | 90.0           | ✓      |
| T2  | Normal | prix=50, services=10 | 40.0            | 40.0           | ✓      |
| T3  | Limite | prix=100, services=0 | 100.0           | 100.0          | ✓      |
| T4  | Limite | prix=0, services=5   | 0.0             | 0.0            | ✓      |
| T5  | Erreur | prix=-10, services=5 | Exception       | 90.0           | ✗      |

Le test T5 révèle un problème : la fonction ne vérifie pas que le prix est
positif.

## Développer un esprit critique

### Poser les bonnes questions

Avant de commencer à coder, posez-vous ces questions :

- **Ai-je bien compris le problème ?** Puis-je le reformuler avec mes propres
  mots ?
- **Quelles sont les entrées et les sorties ?** Sont-elles clairement définies ?
- **Quelles sont les contraintes ?** Ai-je identifié tous les cas limites ?
- **Existe-t-il des sous-problèmes similaires déjà résolus ?** Puis-je
  réutiliser du code ?
- **Ma solution est-elle la plus simple possible ?** Suis-je en train de
  compliquer inutilement ?
- **Comment puis-je tester ma solution ?** Quels cas de test vais-je utiliser ?

### Apprendre de ses erreurs

Les erreurs sont une partie normale de l'apprentissage de la programmation. Ce
qui compte, c'est d'en tirer des leçons.

**Processus d'apprentissage par l'erreur** :

1. **Identifier l'erreur** : Quel est le symptôme ? Qu'est-ce qui ne fonctionne
   pas ?
2. **Comprendre la cause** : Pourquoi l'erreur s'est-elle produite ?
3. **Corriger** : Comment résoudre le problème ?
4. **Documenter** : Noter l'erreur et la solution pour ne pas la reproduire
5. **Généraliser** : Existe-t-il d'autres endroits dans mon code avec le même
   problème ?

**Exemple d'erreur fréquente** :

```java
// Code avec erreur
int[] notes = {12, 15, 8, 18, 14};
double somme = 0;
for (int i = 0; i <= notes.length; i++) {  // BUG : <= au lieu de <
    somme += notes[i];
}
```

Cette erreur provoque une `ArrayIndexOutOfBoundsException`.

**Analyse** :

- **Symptôme** : Le programme plante avec une exception
- **Cause** : La boucle essaie d'accéder à `notes[5]` qui n'existe pas
- **Correction** : Remplacer `<=` par `<`
- **Leçon** : Toujours vérifier les bornes des boucles sur les tableaux

### Demander de l'aide efficacement

Savoir demander de l'aide est une compétence importante. Voici comment le faire
efficacement :

**Mauvaise demande d'aide** :

> "Mon code ne marche pas, pouvez-vous m'aider ?"

**Bonne demande d'aide** :

> "J'essaie de calculer la moyenne d'un tableau, mais j'obtiens toujours 0.
> Voici mon code :
>
> ```java
> int[] notes = {12, 15, 8};
> int somme = 0;
> for (int i = 0; i < notes.length; i++) {
>     somme += notes[i];
> }
> int moyenne = somme / notes.length;
> ```
>
> Je m'attendais à obtenir 11 (ou 12), mais j'obtiens 0. Qu'est-ce qui ne va pas
> ?"

**Éléments d'une bonne demande d'aide** :

- Description claire du problème
- Code minimal reproduisant le problème
- Résultat attendu vs résultat obtenu
- Ce que vous avez déjà essayé

## Synthèse

### Points clés à retenir

1. **La méthodologie avant la syntaxe** : Savoir **comment** résoudre un
   problème est plus important que connaître **quelle** syntaxe utiliser.

2. **Décomposer systématiquement** : Tout problème complexe peut être décomposé
   en sous-problèmes plus simples.

3. **Analyser avant de coder** : Identifier les entrées, sorties et contraintes
   avant de commencer à écrire du code.

4. **Planifier avec des outils** : Utiliser le pseudocode, les diagrammes et les
   tableaux d'analyse pour clarifier vos idées.

5. **Évaluer les solutions** : Comparer différentes approches selon des critères
   de lisibilité, maintenabilité et efficacité.

6. **Tester rigoureusement** : Tester les cas normaux, les cas limites et les
   cas d'erreur.

7. **Développer l'esprit critique** : Poser les bonnes questions, apprendre de
   ses erreurs, demander de l'aide efficacement.

### Exercices pratiques

Pour mettre en pratique ces méthodologies, consultez les exercices dans le
dossier `03-exercices/`.

Ces exercices vous permettront de :

- Décomposer des problèmes sur papier
- Écrire du pseudocode
- Implémenter des solutions structurées
- Comparer différentes approches
- Créer des cas de test

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
