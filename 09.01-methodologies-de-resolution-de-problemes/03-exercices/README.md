# Méthodologies de résolution de problèmes - Exercices

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

Ces exercices vous permettent de mettre en pratique les méthodologies de
résolution de problèmes vues en cours. Ils sont conçus pour développer votre
capacité à analyser, décomposer et résoudre des problèmes de manière
structurée.

**Important** : Pour chaque exercice, suivez ces étapes :

1. Lire et comprendre le problème
2. Analyser (entrées, sorties, contraintes)
3. Décomposer en sous-problèmes
4. Écrire du pseudocode (pour les exercices de programmation)
5. Implémenter la solution
6. Tester avec différents cas

## Exercice 1 : Décomposition sur papier

**Objectif** : Pratiquer la décomposition d'un problème complexe sans coder.

### Énoncé

Une bibliothèque locale souhaite créer un système de gestion d'emprunts de
livres. Le système doit permettre :

- L'inscription de nouveaux membres
- L'ajout de nouveaux livres au catalogue
- L'emprunt d'un livre par un membre (maximum 3 livres par membre)
- Le retour d'un livre
- L'affichage des livres disponibles
- L'affichage des emprunts d'un membre
- Le calcul des retards et des amendes (0.50 CHF par jour de retard)

### Travail demandé

**Sur papier ou dans un fichier texte**, réalisez les tâches suivantes :

1. **Créer un diagramme de décomposition** montrant comment diviser ce problème
   en sous-problèmes

2. **Pour chaque sous-problème principal**, identifiez :
   - Les entrées nécessaires
   - Les sorties attendues
   - Les contraintes à respecter

3. **Listez les fonctions nécessaires** avec leur signature (nom et paramètres)

4. **Identifiez les structures de données** nécessaires pour stocker :
   - Les membres
   - Les livres
   - Les emprunts

<details>
<summary>Solution</summary>

### 1. Diagramme de décomposition

```
Système de gestion de bibliothèque
├── Gérer les membres
│   ├── Inscrire un nouveau membre
│   ├── Afficher les informations d'un membre
│   └── Afficher tous les membres
├── Gérer le catalogue
│   ├── Ajouter un livre
│   ├── Retirer un livre
│   └── Afficher les livres disponibles
├── Gérer les emprunts
│   ├── Emprunter un livre
│   ├── Retourner un livre
│   ├── Afficher les emprunts d'un membre
│   └── Vérifier les retards
└── Gérer les amendes
    ├── Calculer les jours de retard
    ├── Calculer le montant d'une amende
    └── Afficher les amendes d'un membre
```

### 2. Analyse des sous-problèmes principaux

**Gérer les membres**

| Aspect       | Description                                     |
| ------------ | ----------------------------------------------- |
| Entrées      | Nom, prénom, numéro de membre                   |
| Sorties      | Confirmation d'inscription ou message d'erreur  |
| Contraintes  | Numéro de membre unique, nom non vide           |

**Gérer le catalogue**

| Aspect       | Description                                     |
| ------------ | ----------------------------------------------- |
| Entrées      | Titre, auteur, ISBN, nombre d'exemplaires       |
| Sorties      | Confirmation d'ajout ou message d'erreur        |
| Contraintes  | ISBN unique, au moins 1 exemplaire              |

**Gérer les emprunts**

| Aspect       | Description                                            |
| ------------ | ------------------------------------------------------ |
| Entrées      | Numéro de membre, ISBN du livre, date d'emprunt        |
| Sorties      | Confirmation d'emprunt ou message d'erreur             |
| Contraintes  | Maximum 3 livres par membre, livre disponible         |

**Gérer les amendes**

| Aspect       | Description                                            |
| ------------ | ------------------------------------------------------ |
| Entrées      | Date d'emprunt, date de retour, durée autorisée        |
| Sorties      | Montant de l'amende                                    |
| Contraintes  | 0.50 CHF par jour de retard, durée maximale 30 jours   |

### 3. Fonctions nécessaires

```java
// Gestion des membres
boolean inscrireMembre(String nom, String prenom, int numeroMembre)
boolean membreExiste(int numeroMembre)
void afficherMembre(int numeroMembre)
void afficherTousMembres()

// Gestion du catalogue
boolean ajouterLivre(String titre, String auteur, String isbn, int nbExemplaires)
boolean retirerLivre(String isbn)
void afficherLivresDisponibles()
boolean livreDisponible(String isbn)
int obtenirNombreExemplairesDisponibles(String isbn)

// Gestion des emprunts
boolean emprunterLivre(int numeroMembre, String isbn, String dateEmprunt)
boolean retournerLivre(int numeroMembre, String isbn, String dateRetour)
void afficherEmpruntsMembre(int numeroMembre)
boolean verifierRetards(int numeroMembre)
int obtenirNombreEmprunts(int numeroMembre)

// Gestion des amendes
int calculerJoursRetard(String dateEmprunt, String dateRetour, int dureeAutorisee)
double calculerMontantAmende(int joursRetard)
void afficherAmendesMembre(int numeroMembre)

// Fonctions utilitaires
boolean validerDate(String date)
int calculerDifferenceJours(String date1, String date2)
```

### 4. Structures de données

**Membres** (tableau ou liste) :

```java
class Membre {
    int numeroMembre;
    String nom;
    String prenom;
    int nbEmpruntsActuels;
}
```

**Livres** (tableau ou liste) :

```java
class Livre {
    String isbn;
    String titre;
    String auteur;
    int nbExemplairesTotal;
    int nbExemplairesDisponibles;
}
```

**Emprunts** (tableau ou liste) :

```java
class Emprunt {
    int numeroMembre;
    String isbn;
    String dateEmprunt;
    String dateRetourPrevue;
    String dateRetourEffective; // null si pas encore retourné
    double amende;
}
```

</details>

---

## Exercice 2 : Pseudocode pour un distributeur de boissons

**Objectif** : Écrire du pseudocode structuré pour planifier une solution.

### Énoncé

Un distributeur automatique de boissons fonctionne de la manière suivante :

- Il contient 3 types de boissons : café (1.50 CHF), thé (1.00 CHF), chocolat
  chaud (2.00 CHF)
- L'utilisatrice insère des pièces (0.10, 0.20, 0.50, 1.00, 2.00 CHF)
- Elle sélectionne une boisson
- Le distributeur vérifie si le montant inséré est suffisant
- Si oui, il distribue la boisson et rend la monnaie
- Si non, il affiche un message d'erreur et propose de rendre la monnaie ou
  d'insérer plus d'argent

### Travail demandé

Écrivez le pseudocode pour gérer une transaction complète du distributeur.
Décomposez le problème en plusieurs fonctions.

<details>
<summary>Solution</summary>

```
CONSTANTES :
    PRIX_CAFE = 1.50
    PRIX_THE = 1.00
    PRIX_CHOCOLAT = 2.00
    PIECES_VALIDES = [0.10, 0.20, 0.50, 1.00, 2.00]

FONCTION principale()
    DEBUT
        afficherMenu()
        montantInsere ← 0
        
        REPETER
            afficherMessage("Insérez des pièces (0 pour terminer)")
            piece ← lirePiece()
            
            SI piece > 0 ALORS
                SI estPieceValide(piece) ALORS
                    montantInsere ← montantInsere + piece
                    afficherMessage("Total : " + montantInsere + " CHF")
                SINON
                    afficherMessage("Pièce non acceptée")
                FIN SI
            FIN SI
        JUSQU'À piece = 0
        
        SI montantInsere > 0 ALORS
            choix ← lireChoixBoisson()
            prixBoisson ← obtenirPrixBoisson(choix)
            
            SI prixBoisson != -1 ALORS
                traiterAchat(montantInsere, prixBoisson, choix)
            SINON
                afficherMessage("Choix invalide. Remboursement en cours.")
                rembourser(montantInsere)
            FIN SI
        FIN SI
    FIN

FONCTION estPieceValide(piece : réel) : booléen
    DEBUT
        POUR chaque valeur DANS PIECES_VALIDES FAIRE
            SI piece = valeur ALORS
                RETOURNER vrai
            FIN SI
        FIN POUR
        RETOURNER faux
    FIN

FONCTION afficherMenu()
    DEBUT
        afficher("=== DISTRIBUTEUR DE BOISSONS ===")
        afficher("1. Café (1.50 CHF)")
        afficher("2. Thé (1.00 CHF)")
        afficher("3. Chocolat chaud (2.00 CHF)")
    FIN

FONCTION lireChoixBoisson() : entier
    DEBUT
        afficherMessage("Choisissez votre boisson (1-3) :")
        choix ← lireEntier()
        RETOURNER choix
    FIN

FONCTION obtenirPrixBoisson(choix : entier) : réel
    DEBUT
        SI choix = 1 ALORS
            RETOURNER PRIX_CAFE
        SINON SI choix = 2 ALORS
            RETOURNER PRIX_THE
        SINON SI choix = 3 ALORS
            RETOURNER PRIX_CHOCOLAT
        SINON
            RETOURNER -1  // Choix invalide
        FIN SI
    FIN

FONCTION traiterAchat(montantInsere : réel, prix : réel, choix : entier)
    DEBUT
        SI montantInsere >= prix ALORS
            afficherMessage("Distribution de la boisson...")
            distribuerBoisson(choix)
            
            monnaie ← montantInsere - prix
            
            SI monnaie > 0 ALORS
                afficherMessage("Votre monnaie : " + monnaie + " CHF")
                rendreMonnaie(monnaie)
            FIN SI
        SINON
            manquant ← prix - montantInsere
            afficherMessage("Montant insuffisant. Il manque " + manquant + " CHF")
            afficherMessage("1. Insérer plus d'argent")
            afficherMessage("2. Annuler et se faire rembourser")
            
            choixAction ← lireEntier()
            
            SI choixAction = 1 ALORS
                // Relancer le processus d'insertion de pièces
                principale()
            SINON
                rembourser(montantInsere)
            FIN SI
        FIN SI
    FIN

FONCTION distribuerBoisson(choix : entier)
    DEBUT
        SI choix = 1 ALORS
            afficher("☕ Voici votre café")
        SINON SI choix = 2 ALORS
            afficher("🍵 Voici votre thé")
        SINON SI choix = 3 ALORS
            afficher("🍫 Voici votre chocolat chaud")
        FIN SI
    FIN

FONCTION rendreMonnaie(montant : réel)
    DEBUT
        // Simplification : on suppose que le distributeur a toujours la monnaie
        afficherMessage("Monnaie rendue : " + montant + " CHF")
        
        // Dans un vrai système, on calculerait les pièces à rendre
        // (2.00, 1.00, 0.50, 0.20, 0.10)
    FIN

FONCTION rembourser(montant : réel)
    DEBUT
        afficherMessage("Remboursement de " + montant + " CHF")
        rendreMonnaie(montant)
    FIN
```

</details>

---

## Exercice 3 : Implémentation structurée - Calculateur de bilan carbone

**Objectif** : Implémenter une solution décomposée en fonctions claires.

### Énoncé

Créez un programme qui calcule l'empreinte carbone mensuelle d'une personne
basée sur ses déplacements.

**Données** :

- Voiture : 0.2 kg CO2/km
- Transports publics : 0.05 kg CO2/km
- Vélo/marche : 0 kg CO2/km
- Avion (court courrier < 1000 km) : 0.25 kg CO2/km
- Avion (long courrier >= 1000 km) : 0.15 kg CO2/km

**Le programme doit** :

1. Demander les kilomètres parcourus par mode de transport
2. Calculer l'empreinte pour chaque mode
3. Calculer le total mensuel
4. Comparer avec la moyenne suisse (360 kg CO2/mois pour les transports)
5. Donner des conseils pour réduire l'empreinte

### Travail demandé

Implémentez le programme en Java en suivant ces principes :

- Décomposez en fonctions claires (une responsabilité par fonction)
- Utilisez des constantes nommées pour les coefficients CO2
- Validez les entrées
- Créez des tests pour vérifier vos calculs

<details>
<summary>Solution</summary>

```java
/**
 * Calculateur de bilan carbone pour les déplacements.
 */
import java.util.Scanner;

public class BilanCarbone {
    
    // Coefficients d'émission CO2 en kg/km
    private static final double CO2_VOITURE = 0.2;
    private static final double CO2_TRANSPORT_PUBLIC = 0.05;
    private static final double CO2_VELO_MARCHE = 0.0;
    private static final double CO2_AVION_COURT = 0.25;
    private static final double CO2_AVION_LONG = 0.15;
    
    // Seuil pour distinguer court/long courrier
    private static final int SEUIL_LONG_COURRIER = 1000;
    
    // Moyenne suisse (kg CO2/mois)
    private static final double MOYENNE_SUISSE = 360.0;
    
    /**
     * Calcule l'empreinte CO2 pour la voiture.
     */
    public static double calculerCO2Voiture(double km) {
        if (km < 0) return 0;
        return km * CO2_VOITURE;
    }
    
    /**
     * Calcule l'empreinte CO2 pour les transports publics.
     */
    public static double calculerCO2TransportsPublics(double km) {
        if (km < 0) return 0;
        return km * CO2_TRANSPORT_PUBLIC;
    }
    
    /**
     * Calcule l'empreinte CO2 pour le vélo/marche.
     */
    public static double calculerCO2VeloMarche(double km) {
        return 0; // Pas d'émissions
    }
    
    /**
     * Calcule l'empreinte CO2 pour l'avion.
     */
    public static double calculerCO2Avion(double km) {
        if (km < 0) return 0;
        
        if (km < SEUIL_LONG_COURRIER) {
            return km * CO2_AVION_COURT; // Court courrier
        } else {
            return km * CO2_AVION_LONG; // Long courrier
        }
    }
    
    /**
     * Calcule l'empreinte totale.
     */
    public static double calculerEmpreinteTotal(double co2Voiture, double co2TransportsPublics,
                                               double co2VeloMarche, double co2Avion) {
        return co2Voiture + co2TransportsPublics + co2VeloMarche + co2Avion;
    }
    
    /**
     * Compare avec la moyenne suisse.
     */
    public static String comparerAvecMoyenne(double empreinte) {
        double difference = empreinte - MOYENNE_SUISSE;
        double pourcentage = (difference / MOYENNE_SUISSE) * 100;
        
        if (Math.abs(difference) < 1) {
            return "Vous êtes dans la moyenne suisse.";
        } else if (difference < 0) {
            return String.format("Bravo ! Vous êtes %.0f%% en dessous de la moyenne suisse (%.1f kg CO2).",
                               Math.abs(pourcentage), Math.abs(difference));
        } else {
            return String.format("Vous êtes %.0f%% au-dessus de la moyenne suisse (+%.1f kg CO2).",
                               pourcentage, difference);
        }
    }
    
    /**
     * Donne des conseils personnalisés.
     */
    public static void donnerConseils(double co2Voiture, double co2TransportsPublics,
                                     double co2VeloMarche, double co2Avion) {
        System.out.println("\n=== Conseils pour réduire votre empreinte ===");
        
        // Identifier le mode le plus émetteur
        double max = Math.max(Math.max(co2Voiture, co2TransportsPublics), 
                             Math.max(co2VeloMarche, co2Avion));
        
        if (co2Voiture == max && co2Voiture > 0) {
            System.out.println("🚗 La voiture est votre principale source d'émissions.");
            System.out.println("   → Privilégiez les transports publics quand c'est possible");
            System.out.println("   → Envisagez le covoiturage pour les trajets réguliers");
            System.out.println("   → Pour les courtes distances, optez pour le vélo");
        }
        
        if (co2Avion > 100) {
            System.out.println("✈️  L'avion représente une part importante de vos émissions.");
            System.out.println("   → Privilégiez le train pour les distances < 1000 km");
            System.out.println("   → Limitez les vols long-courrier");
        }
        
        if (co2VeloMarche == 0 && co2TransportsPublics == 0) {
            System.out.println("🚲 Vous n'utilisez pas les modes de transport doux.");
            System.out.println("   → Pour les trajets < 5 km, le vélo est idéal");
            System.out.println("   → La marche est excellente pour les courtes distances");
        }
        
        if (co2Voiture == 0 && co2Avion == 0) {
            System.out.println("🌱 Excellent ! Vous utilisez déjà des modes de transport durables.");
        }
    }
    
    /**
     * Affiche le détail du bilan.
     */
    public static void afficherBilan(double kmVoiture, double kmTransportsPublics,
                                    double kmVeloMarche, double kmAvion) {
        double co2Voiture = calculerCO2Voiture(kmVoiture);
        double co2TransportsPublics = calculerCO2TransportsPublics(kmTransportsPublics);
        double co2VeloMarche = calculerCO2VeloMarche(kmVeloMarche);
        double co2Avion = calculerCO2Avion(kmAvion);
        double total = calculerEmpreinteTotal(co2Voiture, co2TransportsPublics, 
                                             co2VeloMarche, co2Avion);
        
        System.out.println("\n=== Votre bilan carbone mensuel ===");
        System.out.printf("Voiture : %.0f km → %.1f kg CO2%n", kmVoiture, co2Voiture);
        System.out.printf("Transports publics : %.0f km → %.1f kg CO2%n", 
                         kmTransportsPublics, co2TransportsPublics);
        System.out.printf("Vélo/Marche : %.0f km → %.1f kg CO2%n", 
                         kmVeloMarche, co2VeloMarche);
        System.out.printf("Avion : %.0f km → %.1f kg CO2%n", kmAvion, co2Avion);
        System.out.println("─────────────────────────────────────");
        System.out.printf("TOTAL : %.1f kg CO2%n", total);
        
        System.out.println("\n" + comparerAvecMoyenne(total));
        
        donnerConseils(co2Voiture, co2TransportsPublics, co2VeloMarche, co2Avion);
    }
    
    /**
     * Lit un nombre de kilomètres (avec validation).
     */
    public static double lireKilometres(Scanner scanner, String typeTransport) {
        double km = -1;
        
        while (km < 0) {
            System.out.printf("Kilomètres parcourus en %s ce mois : ", typeTransport);
            if (scanner.hasNextDouble()) {
                km = scanner.nextDouble();
                if (km < 0) {
                    System.out.println("Erreur : le nombre doit être positif.");
                }
            } else {
                System.out.println("Erreur : veuillez entrer un nombre valide.");
                scanner.next(); // Consommer l'entrée invalide
            }
        }
        
        return km;
    }
    
    /**
     * Tests automatiques.
     */
    public static void testerCalculs() {
        System.out.println("=== Tests des calculs ===\n");
        
        // Test 1 : Voiture
        double co2 = calculerCO2Voiture(100);
        System.out.printf("Test 1 : 100 km en voiture → %.1f kg CO2 %s%n", 
                         co2, co2 == 20.0 ? "✓" : "✗");
        
        // Test 2 : Transports publics
        co2 = calculerCO2TransportsPublics(200);
        System.out.printf("Test 2 : 200 km en transports publics → %.1f kg CO2 %s%n",
                         co2, co2 == 10.0 ? "✓" : "✗");
        
        // Test 3 : Avion court courrier
        co2 = calculerCO2Avion(500);
        System.out.printf("Test 3 : 500 km en avion (court) → %.1f kg CO2 %s%n",
                         co2, co2 == 125.0 ? "✓" : "✗");
        
        // Test 4 : Avion long courrier
        co2 = calculerCO2Avion(5000);
        System.out.printf("Test 4 : 5000 km en avion (long) → %.1f kg CO2 %s%n",
                         co2, co2 == 750.0 ? "✓" : "✗");
        
        // Test 5 : Valeurs négatives
        co2 = calculerCO2Voiture(-10);
        System.out.printf("Test 5 : -10 km → %.1f kg CO2 %s%n",
                         co2, co2 == 0.0 ? "✓" : "✗");
        
        System.out.println();
    }
    
    /**
     * Programme principal.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CALCULATEUR DE BILAN CARBONE ===\n");
        System.out.println("Calculez l'empreinte carbone de vos déplacements mensuels.\n");
        
        // Exécuter les tests
        testerCalculs();
        
        // Saisie interactive
        double kmVoiture = lireKilometres(scanner, "voiture");
        double kmTransportsPublics = lireKilometres(scanner, "transports publics");
        double kmVeloMarche = lireKilometres(scanner, "vélo/marche");
        double kmAvion = lireKilometres(scanner, "avion");
        
        // Afficher le bilan
        afficherBilan(kmVoiture, kmTransportsPublics, kmVeloMarche, kmAvion);
        
        scanner.close();
    }
}
```

</details>

---

## Exercice 4 : Comparaison de solutions - Recherche dans un tableau

**Objectif** : Évaluer et comparer différentes approches pour le même problème.

### Énoncé

Considérez le problème suivant : vérifier si un élément existe dans un tableau.

Implémentez **trois solutions différentes** :

1. **Parcours simple** : Parcourir le tableau élément par élément
2. **Avec tri puis recherche binaire** : Trier le tableau puis utiliser une
   recherche binaire
3. **Avec conversion en Set** : Convertir le tableau en ensemble (Set) puis
   vérifier la présence

### Travail demandé

1. Implémentez les trois solutions
2. Comparez-les selon les critères :
   - Lisibilité
   - Maintenabilité
   - Efficacité
3. Pour un tableau de 1000 éléments, laquelle est la plus rapide ?
4. Laquelle recommandez-vous et pourquoi ?

<details>
<summary>Solution</summary>

```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RechercheElement {
    
    // ========================================================================
    // SOLUTION 1 : Parcours simple
    // ========================================================================
    
    /**
     * Recherche un élément en parcourant le tableau.
     * 
     * Complexité : O(n) - parcours linéaire
     */
    public static boolean rechercherSimple(int[] tableau, int element) {
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] == element) {
                return true;
            }
        }
        return false;
    }
    
    // ========================================================================
    // SOLUTION 2 : Tri + recherche binaire
    // ========================================================================
    
    /**
     * Recherche un élément après avoir trié le tableau.
     * 
     * Complexité : O(n log n) pour le tri + O(log n) pour la recherche
     * ATTENTION : Modifie le tableau !
     */
    public static boolean rechercherAvecTri(int[] tableau, int element) {
        Arrays.sort(tableau); // Modifie le tableau
        return Arrays.binarySearch(tableau, element) >= 0;
    }
    
    // ========================================================================
    // SOLUTION 3 : Conversion en Set
    // ========================================================================
    
    /**
     * Recherche un élément en utilisant un Set.
     * 
     * Complexité : O(n) pour créer le Set + O(1) pour la recherche
     */
    public static boolean rechercherAvecSet(int[] tableau, int element) {
        Set<Integer> ensemble = new HashSet<>();
        for (int valeur : tableau) {
            ensemble.add(valeur);
        }
        return ensemble.contains(element);
    }
    
    // ========================================================================
    // COMPARAISON
    // ========================================================================
    
    public static void comparerSolutions() {
        System.out.println("=== COMPARAISON DES SOLUTIONS ===\n");
        
        System.out.println("CRITÈRE 1 : Lisibilité");
        System.out.println("-----------------------");
        System.out.println("Solution 1 (Parcours simple) : ★★★★★");
        System.out.println("  → Très claire et directe");
        System.out.println("Solution 2 (Tri + binaire) : ★★★☆☆");
        System.out.println("  → Utilise des méthodes Java, mais modifie le tableau");
        System.out.println("Solution 3 (Set) : ★★★★☆");
        System.out.println("  → Claire, mais nécessite de comprendre les Sets");
        
        System.out.println("\nCRITÈRE 2 : Maintenabilité");
        System.out.println("--------------------------");
        System.out.println("Solution 1 : ★★★★★");
        System.out.println("  → Pas d'effet de bord, facile à comprendre");
        System.out.println("Solution 2 : ★★☆☆☆");
        System.out.println("  → DANGER : modifie le tableau (effet de bord majeur)");
        System.out.println("Solution 3 : ★★★★☆");
        System.out.println("  → Pas d'effet de bord, mais utilise plus de mémoire");
        
        System.out.println("\nCRITÈRE 3 : Efficacité");
        System.out.println("----------------------");
        System.out.println("Solution 1 : ★★★★☆ O(n)");
        System.out.println("  → Simple et efficace pour 1 recherche");
        System.out.println("Solution 2 : ★★☆☆☆ O(n log n)");
        System.out.println("  → Inefficace pour 1 recherche, mais bon pour plusieurs");
        System.out.println("Solution 3 : ★★★☆☆ O(n) création + O(1) recherche");
        System.out.println("  → Excellent si on fait plusieurs recherches");
        
        System.out.println("\n=== VERDICT ===");
        System.out.println("Pour UNE recherche : Solution 1 (parcours simple)");
        System.out.println("Pour PLUSIEURS recherches : Solution 3 (Set)");
        System.out.println("À éviter : Solution 2 (modifie le tableau)");
    }
    
    // ========================================================================
    // TESTS DE PERFORMANCE
    // ========================================================================
    
    public static void testerPerformance() {
        System.out.println("\n=== TEST DE PERFORMANCE ===\n");
        
        int taille = 10000;
        int[] tableau = new int[taille];
        for (int i = 0; i < taille; i++) {
            tableau[i] = i;
        }
        
        int elementRecherche = 7500; // Au milieu
        
        // Solution 1
        long debut1 = System.nanoTime();
        boolean resultat1 = rechercherSimple(Arrays.copyOf(tableau, taille), elementRecherche);
        long fin1 = System.nanoTime();
        long temps1 = (fin1 - debut1) / 1000;
        
        // Solution 2 (avec copie pour ne pas modifier l'original)
        long debut2 = System.nanoTime();
        boolean resultat2 = rechercherAvecTri(Arrays.copyOf(tableau, taille), elementRecherche);
        long fin2 = System.nanoTime();
        long temps2 = (fin2 - debut2) / 1000;
        
        // Solution 3
        long debut3 = System.nanoTime();
        boolean resultat3 = rechercherAvecSet(tableau, elementRecherche);
        long fin3 = System.nanoTime();
        long temps3 = (fin3 - debut3) / 1000;
        
        System.out.printf("Taille du tableau : %d éléments%n", taille);
        System.out.printf("Élément recherché : %d%n%n", elementRecherche);
        
        System.out.printf("Solution 1 (Parcours simple) : %d μs %s%n", temps1, resultat1 ? "✓" : "✗");
        System.out.printf("Solution 2 (Tri + binaire) : %d μs %s%n", temps2, resultat2 ? "✓" : "✗");
        System.out.printf("Solution 3 (Set) : %d μs %s%n%n", temps3, resultat3 ? "✓" : "✗");
        
        System.out.printf("Solution 2 est %.1fx plus lente que Solution 1%n", (double)temps2 / temps1);
        System.out.printf("Solution 3 est %.1fx plus lente que Solution 1%n", (double)temps3 / temps1);
        
        // Test avec plusieurs recherches
        System.out.println("\n--- Test avec 100 recherches ---");
        
        long debutMulti1 = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            rechercherSimple(tableau, i * 100);
        }
        long finMulti1 = System.nanoTime();
        long tempsMulti1 = (finMulti1 - debutMulti1) / 1000;
        
        long debutMulti3 = System.nanoTime();
        Set<Integer> ensemble = new HashSet<>();
        for (int valeur : tableau) {
            ensemble.add(valeur);
        }
        for (int i = 0; i < 100; i++) {
            ensemble.contains(i * 100);
        }
        long finMulti3 = System.nanoTime();
        long tempsMulti3 = (finMulti3 - debutMulti3) / 1000;
        
        System.out.printf("Solution 1 : %d μs%n", tempsMulti1);
        System.out.printf("Solution 3 : %d μs%n", tempsMulti3);
        System.out.println("→ Pour plusieurs recherches, le Set est plus rapide !");
    }
    
    // ========================================================================
    // PROGRAMME PRINCIPAL
    // ========================================================================
    
    public static void main(String[] args) {
        System.out.println("=== COMPARAISON DE SOLUTIONS : RECHERCHE D'ÉLÉMENT ===\n");
        
        // Comparaison théorique
        comparerSolutions();
        
        // Tests de performance
        testerPerformance();
        
        System.out.println("\n=== CONCLUSION ===");
        System.out.println("Le choix dépend du contexte :");
        System.out.println("- 1 recherche → Parcours simple");
        System.out.println("- Plusieurs recherches → Set");
        System.out.println("- Tableau trié à l'avance → Recherche binaire");
    }
}
```

**Analyse et recommandation** :

Pour un tableau de 1000 éléments :

- **Solution 1** : Meilleure pour une seule recherche (O(n) simple)
- **Solution 2** : À éviter (modifie le tableau, inefficace pour 1 recherche)
- **Solution 3** : Meilleure si on fait plusieurs recherches

**Recommandation générale** : Solution 1 (parcours simple) pour sa simplicité,
lisibilité et absence d'effets de bord.

</details>

---

## Exercice 5 : Tests et validation - Validateur de mots de passe

**Objectif** : Créer des tests exhaustifs pour valider une solution.

### Énoncé

Créez une fonction qui valide un mot de passe selon ces critères :

- Au moins 8 caractères
- Au moins une lettre majuscule
- Au moins une lettre minuscule
- Au moins un chiffre
- Au moins un caractère spécial parmi : `!@#$%^&*`
- Pas d'espaces

La fonction doit retourner `true` si le mot de passe est valide, `false` sinon.

### Travail demandé

1. **Implémentez la fonction** `validerMotDePasse(String mdp)`
2. **Créez une suite de tests complète** couvrant :
   - Cas normaux (mots de passe valides)
   - Cas limites (longueur exacte, un seul caractère spécial, etc.)
   - Cas d'erreur (chaque critère non respecté)
3. **Documentez chaque test** avec son objectif
4. **Créez une fonction de test automatique** qui vérifie tous les cas

<details>
<summary>Solution</summary>

```java
public class ValidateurMotDePasse {
    
    /**
     * Valide un mot de passe selon les critères de sécurité.
     * 
     * Critères :
     * - Au moins 8 caractères
     * - Au moins une lettre majuscule
     * - Au moins une lettre minuscule
     * - Au moins un chiffre
     * - Au moins un caractère spécial (!@#$%^&*)
     * - Pas d'espaces
     * 
     * @param mdp Le mot de passe à valider
     * @return true si le mot de passe est valide, false sinon
     */
    public static boolean validerMotDePasse(String mdp) {
        // Vérification de null
        if (mdp == null) {
            return false;
        }
        
        // Critère 1 : Au moins 8 caractères
        if (mdp.length() < 8) {
            return false;
        }
        
        // Critère 2-5 : Vérifier présence des différents types de caractères
        boolean aMajuscule = false;
        boolean aMinuscule = false;
        boolean aChiffre = false;
        boolean aSpecial = false;
        
        String caracteresSpeciaux = "!@#$%^&*";
        
        for (int i = 0; i < mdp.length(); i++) {
            char c = mdp.charAt(i);
            
            // Critère 6 : Pas d'espaces
            if (c == ' ') {
                return false;
            }
            
            if (Character.isUpperCase(c)) {
                aMajuscule = true;
            } else if (Character.isLowerCase(c)) {
                aMinuscule = true;
            } else if (Character.isDigit(c)) {
                aChiffre = true;
            } else if (caracteresSpeciaux.indexOf(c) != -1) {
                aSpecial = true;
            }
        }
        
        return aMajuscule && aMinuscule && aChiffre && aSpecial;
    }
    
    /**
     * Fonction utilitaire pour tester un cas.
     */
    private static void testerCas(String description, String mdp, boolean attendu) {
        boolean resultat = validerMotDePasse(mdp);
        boolean reussi = (resultat == attendu);
        
        System.out.printf("%-60s : ", description);
        if (reussi) {
            System.out.printf("✓ OK%n");
        } else {
            System.out.printf("✗ ERREUR - Attendu: %b, Obtenu: %b (MDP: \"%s\")%n", 
                            attendu, resultat, mdp);
        }
    }
    
    /**
     * Suite de tests exhaustive.
     */
    public static void executerTests() {
        System.out.println("=== TESTS DE VALIDATION DE MOT DE PASSE ===\n");
        
        // ===== CAS NORMAUX (valides) =====
        System.out.println("--- Cas normaux (mots de passe valides) ---");
        
        testerCas("MDP valide standard", 
                 "Motdepasse1!", true);
        
        testerCas("MDP valide avec tous les types de caractères spéciaux", 
                 "Test123!@#$%^&*", true);
        
        testerCas("MDP valide long", 
                 "UnMotDePasseTresLong123!@#", true);
        
        testerCas("MDP valide avec plusieurs chiffres", 
                 "Password123456!", true);
        
        // ===== CAS LIMITES =====
        System.out.println("\n--- Cas limites ---");
        
        testerCas("MDP exactement 8 caractères (longueur minimale)", 
                 "Azerty1!", true);
        
        testerCas("MDP avec un seul caractère de chaque type", 
                 "Aa1!xxxx", true);
        
        testerCas("MDP avec un seul caractère spécial", 
                 "Password1!", true);
        
        testerCas("MDP avec caractère spécial en début", 
                 "!Password1", true);
        
        testerCas("MDP avec caractère spécial en fin", 
                 "Password1!", true);
        
        testerCas("MDP avec tous les caractères spéciaux possibles", 
                 "Aa1!@#$%^&*", true);
        
        // ===== CAS D'ERREUR =====
        System.out.println("\n--- Cas d'erreur (mots de passe invalides) ---");
        
        // Erreur : null
        testerCas("Erreur : MDP null", 
                 null, false);
        
        // Erreur : trop court
        testerCas("Erreur : MDP de 7 caractères (trop court)", 
                 "Azerty1", false);
        
        testerCas("Erreur : MDP vide", 
                 "", false);
        
        // Erreur : absence de majuscule
        testerCas("Erreur : Pas de majuscule", 
                 "password1!", false);
        
        // Erreur : absence de minuscule
        testerCas("Erreur : Pas de minuscule", 
                 "PASSWORD1!", false);
        
        // Erreur : absence de chiffre
        testerCas("Erreur : Pas de chiffre", 
                 "Motdepasse!", false);
        
        // Erreur : absence de caractère spécial
        testerCas("Erreur : Pas de caractère spécial", 
                 "Motdepasse1", false);
        
        // Erreur : présence d'espace
        testerCas("Erreur : Contient un espace au milieu", 
                 "Mot depasse1!", false);
        
        testerCas("Erreur : Contient un espace au début", 
                 " Motdepasse1!", false);
        
        testerCas("Erreur : Contient un espace à la fin", 
                 "Motdepasse1! ", false);
        
        // Erreur : combinaisons incomplètes
        testerCas("Erreur : Seulement minuscules et chiffres", 
                 "motdepasse123", false);
        
        testerCas("Erreur : Seulement majuscules et chiffres", 
                 "MOTDEPASSE123", false);
        
        testerCas("Erreur : Tous les critères sauf la longueur", 
                 "Azert1!", false);
        
        testerCas("Erreur : Caractère spécial invalide (point)", 
                 "Motdepasse1.", false);
        
        testerCas("Erreur : Caractère spécial invalide (virgule)", 
                 "Motdepasse1,", false);
        
        System.out.println("\n=== Fin des tests ===");
    }
    
    /**
     * Fonction pour obtenir un feedback détaillé sur un mot de passe.
     */
    public static void analyserMotDePasse(String mdp) {
        System.out.println("\n=== Analyse du mot de passe ===");
        System.out.println("Mot de passe : \"" + mdp + "\"");
        
        if (mdp == null) {
            System.out.println("✗ Le mot de passe est null");
            return;
        }
        
        System.out.println("\nCritères :");
        System.out.printf("  Longueur >= 8 : %s (longueur: %d)%n", 
                         mdp.length() >= 8 ? "✓" : "✗", mdp.length());
        
        boolean aMajuscule = false;
        boolean aMinuscule = false;
        boolean aChiffre = false;
        boolean aSpecial = false;
        boolean aEspace = false;
        
        String caracteresSpeciaux = "!@#$%^&*";
        
        for (int i = 0; i < mdp.length(); i++) {
            char c = mdp.charAt(i);
            if (c == ' ') aEspace = true;
            if (Character.isUpperCase(c)) aMajuscule = true;
            if (Character.isLowerCase(c)) aMinuscule = true;
            if (Character.isDigit(c)) aChiffre = true;
            if (caracteresSpeciaux.indexOf(c) != -1) aSpecial = true;
        }
        
        System.out.printf("  Majuscule : %s%n", aMajuscule ? "✓" : "✗");
        System.out.printf("  Minuscule : %s%n", aMinuscule ? "✓" : "✗");
        System.out.printf("  Chiffre : %s%n", aChiffre ? "✓" : "✗");
        System.out.printf("  Caractère spécial (!@#$%%^&*) : %s%n", aSpecial ? "✓" : "✗");
        System.out.printf("  Pas d'espaces : %s%n", !aEspace ? "✓" : "✗");
        
        boolean valide = validerMotDePasse(mdp);
        System.out.printf("%nRésultat : %s%n", valide ? "✓ VALIDE" : "✗ INVALIDE");
    }
    
    /**
     * Programme principal.
     */
    public static void main(String[] args) {
        // Exécuter la suite de tests complète
        executerTests();
        
        // Démonstrations d'analyse
        System.out.println("\n\n=== DÉMONSTRATIONS D'ANALYSE ===");
        
        analyserMotDePasse("Motdepasse1!");
        analyserMotDePasse("motdepasse123");
        analyserMotDePasse("MOT DE PASSE1!");
    }
}
```

</details>

---

## Pour aller plus loin

Si vous avez terminé tous les exercices, voici des défis supplémentaires :

### Défi 1 : Système de réservation complet

Combinez les concepts des exercices pour créer un système de réservation pour
un espace de coworking avec :

- Gestion des membres
- Réservation de salles
- Planification des créneaux
- Calcul des tarifs (réductions selon utilisation)
- Statistiques d'occupation

### Défi 2 : Optimiseur de trajets

Créez un programme qui optimise les trajets d'un groupe de personnes pour
minimiser l'empreinte carbone collective en proposant des covoiturages.

### Défi 3 : Comparaison d'algorithmes de tri

Implémentez et comparez 3 algorithmes de tri différents selon les mêmes
critères que l'exercice 4.

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md

