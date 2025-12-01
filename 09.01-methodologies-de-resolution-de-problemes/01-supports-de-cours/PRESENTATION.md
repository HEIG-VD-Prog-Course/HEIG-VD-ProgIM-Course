---
marp: true
title: "Méthodologies de résolution de problèmes"
author: "V. Guidoux"
theme: default
paginate: true
class: lead
---

<!-- _class: lead -->

# Méthodologies de résolution de problèmes

## Apprendre à penser comme un ingénieur

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence
[CC BY-SA 4.0](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md).

---

<!-- _class: lead -->

## Question : Qu'est-ce qui différencie un bon développeur d'un excellent développeur ?

---

<!-- _class: lead -->

## Réponse : La **méthodologie**

Pas la connaissance de la syntaxe.
Pas le nombre de langages maîtrisés.
Mais la **capacité à résoudre des problèmes**.

---

## Pourquoi ce cours ?

Jusqu'ici, vous avez appris :

- La syntaxe Java
- Les variables, les boucles, les tableaux
- Des structures de données de base

**Maintenant**, il est temps d'apprendre à **penser** comme un ingénieur.

---

## Ingénieur vs Technicien

| Technicien                         | Ingénieur                           |
| ---------------------------------- | ----------------------------------- |
| Applique des solutions connues     | Conçoit de nouvelles solutions      |
| Suit des procédures                | Crée des procédures                 |
| Sait **quoi** faire                | Sait **comment** aborder un problème |
| Maîtrise des outils spécifiques    | S'adapte à tout outil               |

> Vous êtes formés pour devenir des **ingénieurs**, pas des techniciens.

---

<!-- _class: lead -->

## Objectif du cours

À la fin de cette séance, vous serez capable de :

- **Décomposer** un problème complexe
- **Analyser** entrées, sorties et contraintes
- **Concevoir** une solution structurée
- **Évaluer** différentes approches
- **Tester** systématiquement

---

## Méthodologie : un exemple concret

**Problème** : Organiser une fête de quartier

Comment vous y prendriez-vous ?

---

## Approche spontanée

"Je vais organiser une fête de quartier."

→ Par où commencer ?
→ Qu'est-ce qu'il faut faire en premier ?
→ Qu'est-ce que j'oublie ?

**Résultat** : On se sent dépassé, on ne sait pas par où commencer.

---

## Approche structurée : Décomposition

```
Organiser une fête de quartier
├── Planifier l'événement
│   ├── Choisir une date
│   ├── Trouver un lieu
│   └── Établir un budget
├── Gérer la logistique
│   ├── Réserver le matériel
│   ├── Organiser les stands
│   └── Prévoir la gestion des déchets
└── Communiquer
    ├── Créer des affiches
    ├── Informer les voisins
    └── Coordonner les bénévoles
```

---

## Chaque sous-problème devient gérable

```
Prévoir la gestion des déchets
├── Calculer le nombre de poubelles nécessaires
├── Organiser le tri sélectif
├── Prévoir la collecte et le recyclage
└── Sensibiliser les participantes au tri
```

Maintenant, vous avez un **plan d'action** clair.

---

<!-- _class: lead -->

## De la vie réelle à la programmation

Cette même méthodologie s'applique à la programmation.

---

## Problème : Gérer un potager partagé

Sans méthodologie :

```java
public static void main(String[] args) {
    // Euh... par où commencer ?
    // Qu'est-ce que je dois coder en premier ?
    // Comment gérer tout ça ?
}
```

---

## Avec méthodologie : Décomposer

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

---

## Chaque sous-problème devient une fonction

```java
void ajouterMembre(String nom)
void retirerMembre(String nom)
void afficherMembres()

void attribuerParcelle(String nom, int numeroParcelle)
void libererParcelle(int numeroParcelle)
void afficherParcelles()

void planifierArrosage()
void gererCompost()
void organiserEntretien()
```

Maintenant, chaque fonction est **simple** et **claire**.

---

<!-- _class: lead -->

## Les étapes de la résolution de problèmes

---

## Étape 1 : Analyser le problème

Avant de coder, posez-vous ces questions :

- **Quelles sont les entrées ?** (ce que l'utilisatrice fournit)
- **Quelles sont les sorties ?** (ce que le programme doit produire)
- **Quelles sont les contraintes ?** (limites, règles)
- **Quels sont les cas limites ?** (situations exceptionnelles)

---

## Exemple : Calculateur de réduction

**Problème** : Un système d'échange local offre des réductions en fonction du
nombre de services rendus.

| Aspect       | Description                                              |
| ------------ | -------------------------------------------------------- |
| **Entrées**  | Prix initial (double), nombre de services rendus (int)   |
| **Sorties**  | Prix final après réduction (double)                      |
| **Contraintes** | - 1-4 services : 5% de réduction<br>- 5-9 services : 10%<br>- 10+ services : 20% |
| **Cas limites** | - 0 services<br>- Prix = 0<br>- Valeurs négatives (invalides) |

---

## Étape 2 : Décomposer le problème

Identifiez les sous-problèmes :

1. Déterminer le taux de réduction selon le nombre de services
2. Calculer le montant de la réduction
3. Calculer le prix final
4. Valider les entrées

Chaque sous-problème = **une fonction**

---

## Étape 3 : Planifier avec du pseudocode

Avant d'écrire du Java, écrivez en langage naturel :

```
DÉBUT CalculerReduction
    ENTRÉES : prixInitial, nombreServices
    
    SI nombreServices >= 10 ALORS
        tauxReduction ← 0.20
    SINON SI nombreServices >= 5 ALORS
        tauxReduction ← 0.10
    SINON SI nombreServices >= 1 ALORS
        tauxReduction ← 0.05
    SINON
        tauxReduction ← 0
    FIN SI
    
    reduction ← prixInitial × tauxReduction
    prixFinal ← prixInitial - reduction
    
    RETOURNER prixFinal
FIN
```

---

## Étape 4 : Implémenter en Java

Le pseudocode se traduit facilement en Java :

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

---

## Étape 5 : Tester systématiquement

Ne codez pas au hasard. **Testez méthodiquement** :

| Type          | Entrée                  | Sortie attendue |
| ------------- | ----------------------- | --------------- |
| Normal        | prix=100, services=5    | 90.0            |
| Normal        | prix=50, services=10    | 40.0            |
| Limite        | prix=100, services=0    | 100.0           |
| Limite        | prix=100, services=1    | 95.0            |
| Limite        | prix=0, services=5      | 0.0             |
| Erreur        | prix=-10, services=5    | ?               |

---

<!-- _class: lead -->

## Stratégies de conception

---

## Approche descendante (top-down)

Partir du problème global → décomposer progressivement

```
Problème global
  ↓
Sous-problèmes de niveau 1
  ↓
Sous-problèmes de niveau 2
  ↓
Fonctions simples
```

**Avantage** : Vision d'ensemble claire

---

## Approche ascendante (bottom-up)

Partir des opérations de base → combiner pour résoudre le problème

```
Fonctions simples
  ↓
Fonctions intermédiaires
  ↓
Fonctions de haut niveau
  ↓
Problème résolu
```

**Avantage** : Code réutilisable

---

## Diviser pour régner

Diviser le problème en sous-problèmes **indépendants**

**Exemple** : Validation d'un formulaire

```java
boolean validerFormulaire(String nom, String email, String telephone) {
    boolean nomValide = validerNom(nom);
    boolean emailValide = validerEmail(email);
    boolean telephoneValide = validerTelephone(telephone);
    
    return nomValide && emailValide && telephoneValide;
}
```

Chaque validation est **indépendante** et **testable séparément**.

---

<!-- _class: lead -->

## Évaluer les solutions

---

## Plusieurs solutions, laquelle choisir ?

Il existe souvent **plusieurs façons** de résoudre un problème.

Comment choisir la meilleure ?

---

## Critères de qualité

1. **Lisibilité** : Le code est-il facile à comprendre ?
2. **Maintenabilité** : Le code est-il facile à modifier ?
3. **Efficacité** : Le code est-il rapide ?

> [!IMPORTANT] Pour ce cours, privilégiez **lisibilité** et **maintenabilité**
> avant l'efficacité.

---

## Exemple : Lisibilité

**Peu lisible** :

```java
double c(double p, int n) {
    return p - (p * (n >= 10 ? 0.2 : n >= 5 ? 0.1 : n >= 1 ? 0.05 : 0));
}
```

**Lisible** :

```java
double calculerPrixAvecReduction(double prixInitial, int nombreServices) {
    double tauxReduction = determinerTauxReduction(nombreServices);
    double reduction = prixInitial * tauxReduction;
    return prixInitial - reduction;
}
```

---

## Exemple : Maintenabilité

**Difficile à maintenir** : Valeurs "magiques"

```java
if (services >= 10) return prix * 0.20;
if (services >= 5) return prix * 0.10;
```

**Facile à maintenir** : Constantes nommées

```java
final double TAUX_REDUCTION_OR = 0.20;
final int SEUIL_OR = 10;

if (services >= SEUIL_OR) return prix * TAUX_REDUCTION_OR;
```

Maintenant, modifier les seuils est **simple et clair**.

---

<!-- _class: lead -->

## Quand optimiser ?

---

## Règle d'or

> "Premature optimization is the root of all evil" - Donald Knuth

1. **D'abord**, faites fonctionner le programme correctement
2. **Ensuite**, rendez-le lisible et maintenable
3. **Enfin**, si nécessaire, optimisez les parties lentes

---

<!-- _class: lead -->

## Testing et validation

---

## Types de tests

| Type         | Description                          | Exemple                     |
| ------------ | ------------------------------------ | --------------------------- |
| Normal       | Cas typiques                         | prix=100, services=5        |
| Limite       | Valeurs aux frontières               | prix=0, services=0          |
| Erreur       | Entrées invalides                    | prix=-10, services=-5       |

**Important** : Testez **tous les types** de cas.

---

## Test automatique vs manuel

**Test manuel** :

- Exécuter le programme
- Entrer les données à la main
- Vérifier visuellement le résultat

**Test automatique** :

```java
void testerCalculerReduction() {
    double resultat = calculerReduction(100.0, 5);
    if (resultat != 90.0) {
        System.out.println("ERREUR : attendu 90.0, obtenu " + resultat);
    }
}
```

**Avantage** : Rapide, reproductible, détecte les régressions.

---

<!-- _class: lead -->

## Développer un esprit critique

---

## Poser les bonnes questions

Avant de coder :

- Ai-je bien compris le problème ?
- Quelles sont les entrées et les sorties ?
- Quelles sont les contraintes ?
- Existe-t-il des solutions similaires déjà résolues ?
- Ma solution est-elle la plus simple possible ?
- Comment puis-je tester ma solution ?

---

## Apprendre de ses erreurs

Les erreurs sont **normales** et **utiles**.

**Processus d'apprentissage** :

1. **Identifier** l'erreur
2. **Comprendre** la cause
3. **Corriger** le problème
4. **Documenter** pour ne pas répéter
5. **Généraliser** : ai-je le même problème ailleurs ?

---

## Demander de l'aide efficacement

**Mauvaise demande** :

> "Mon code ne marche pas, pouvez-vous m'aider ?"

**Bonne demande** :

> "J'essaie de calculer la moyenne d'un tableau, mais j'obtiens toujours 0.
> Voici mon code : [...]. Je m'attendais à obtenir 11, mais j'obtiens 0.
> Qu'est-ce qui ne va pas ?"

---

<!-- _class: lead -->

## Récapitulatif

---

## Les clés de la résolution de problèmes

1. **Analyser** le problème (entrées, sorties, contraintes)
2. **Décomposer** en sous-problèmes gérables
3. **Planifier** avec du pseudocode ou des diagrammes
4. **Implémenter** de manière structurée
5. **Évaluer** selon lisibilité, maintenabilité, efficacité
6. **Tester** rigoureusement (cas normaux, limites, erreurs)
7. **Critiquer** et améliorer

---

<!-- _class: lead -->

## La méthodologie est transférable

Ces compétences vous serviront :

- En Java, Python, JavaScript, C++, etc.
- En programmation web, mobile, embarquée, etc.
- Dans tous les domaines de l'ingénierie

**Vous n'apprenez pas seulement Java.**
**Vous apprenez à résoudre des problèmes.**

---

<!-- _class: lead -->

## Exercices pratiques

Maintenant, à vous de jouer !

1. Décomposer des problèmes sur papier
2. Écrire du pseudocode
3. Implémenter des solutions structurées
4. Comparer différentes approches
5. Créer des cas de test

Consultez les exercices dans `03-exercices/`

---

<!-- _class: lead -->

## Questions ?

N'oubliez pas :

> Un ingénieur ou une ingénieure sait **comment** aborder un problème, pas
> seulement **quoi** coder.

---

<!-- _class: lead -->

# Merci !

Bonne résolution de problèmes !
