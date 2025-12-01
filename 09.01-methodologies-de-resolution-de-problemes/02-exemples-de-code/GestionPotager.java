/**
 * Exemple 02 : Gestion d'un potager partagé
 * 
 * Ce programme illustre la décomposition d'un problème complexe en
 * sous-problèmes gérables, avec une approche descendante (top-down).
 * 
 * Contexte :
 * Un potager partagé permet à plusieurs membres d'une communauté de
 * cultiver des légumes ensemble. Le système doit gérer :
 * - Les membres du potager
 * - L'attribution des parcelles
 * - La planification de l'arrosage
 * 
 * Ce programme démontre comment :
 * 1. Décomposer un problème en fonctions
 * 2. Organiser le code de manière modulaire
 * 3. Séparer les responsabilités
 */

public class GestionPotager {
    
    // Données du système (simplifiées pour l'exemple)
    // Dans un vrai programme, on utiliserait des tableaux ou des listes
    private static String[] membres = new String[10];
    private static int nombreMembres = 0;
    
    private static String[] parcelles = new String[5]; // Nom du membre qui occupe chaque parcelle
    private static final int NB_PARCELLES = 5;
    
    private static String[] planningArrosage = new String[7]; // Un membre par jour de la semaine
    
    /**
     * DÉCOMPOSITION DU PROBLÈME
     * =========================
     * 
     * Potager partagé
     * ├── Gérer les membres
     * │   ├── Ajouter un membre
     * │   ├── Retirer un membre
     * │   └── Afficher les membres
     * ├── Gérer les parcelles
     * │   ├── Attribuer une parcelle
     * │   ├── Libérer une parcelle
     * │   └── Afficher l'état des parcelles
     * └── Gérer l'arrosage
     *     ├── Planifier l'arrosage
     *     └── Afficher le planning
     */
    
    // ========================================================================
    // GESTION DES MEMBRES
    // ========================================================================
    
    /**
     * Ajoute un nouveau membre au potager.
     * 
     * @param nom Le nom du membre à ajouter
     * @return true si l'ajout a réussi, false sinon
     */
    public static boolean ajouterMembre(String nom) {
        // Validation
        if (nom == null || nom.isEmpty()) {
            System.out.println("Erreur : le nom ne peut pas être vide.");
            return false;
        }
        
        if (nombreMembres >= membres.length) {
            System.out.println("Erreur : le potager est complet.");
            return false;
        }
        
        if (membreExiste(nom)) {
            System.out.println("Erreur : ce membre existe déjà.");
            return false;
        }
        
        // Ajout
        membres[nombreMembres] = nom;
        nombreMembres++;
        System.out.println("✓ " + nom + " a été ajouté au potager.");
        return true;
    }
    
    /**
     * Retire un membre du potager.
     * 
     * @param nom Le nom du membre à retirer
     * @return true si le retrait a réussi, false sinon
     */
    public static boolean retirerMembre(String nom) {
        int index = trouverIndexMembre(nom);
        
        if (index == -1) {
            System.out.println("Erreur : ce membre n'existe pas.");
            return false;
        }
        
        // Vérifier qu'il n'occupe pas de parcelle
        if (membreOccupeParcelle(nom)) {
            System.out.println("Erreur : " + nom + " occupe encore une parcelle.");
            return false;
        }
        
        // Retrait (décaler les éléments)
        for (int i = index; i < nombreMembres - 1; i++) {
            membres[i] = membres[i + 1];
        }
        membres[nombreMembres - 1] = null;
        nombreMembres--;
        
        System.out.println("✓ " + nom + " a été retiré du potager.");
        return true;
    }
    
    /**
     * Affiche la liste de tous les membres.
     */
    public static void afficherMembres() {
        System.out.println("\n=== Membres du potager ===");
        
        if (nombreMembres == 0) {
            System.out.println("Aucun membre enregistré.");
        } else {
            for (int i = 0; i < nombreMembres; i++) {
                System.out.printf("%d. %s%n", i + 1, membres[i]);
            }
        }
        
        System.out.println("Total : " + nombreMembres + " membre(s)");
    }
    
    /**
     * Vérifie si un membre existe.
     */
    private static boolean membreExiste(String nom) {
        return trouverIndexMembre(nom) != -1;
    }
    
    /**
     * Trouve l'index d'un membre dans le tableau.
     * 
     * @return L'index du membre, ou -1 s'il n'existe pas
     */
    private static int trouverIndexMembre(String nom) {
        for (int i = 0; i < nombreMembres; i++) {
            if (membres[i].equals(nom)) {
                return i;
            }
        }
        return -1;
    }
    
    // ========================================================================
    // GESTION DES PARCELLES
    // ========================================================================
    
    /**
     * Attribue une parcelle à un membre.
     * 
     * @param nom Le nom du membre
     * @param numeroParcelle Le numéro de la parcelle (0 à 4)
     * @return true si l'attribution a réussi, false sinon
     */
    public static boolean attribuerParcelle(String nom, int numeroParcelle) {
        // Validation du numéro de parcelle
        if (numeroParcelle < 0 || numeroParcelle >= NB_PARCELLES) {
            System.out.println("Erreur : numéro de parcelle invalide.");
            return false;
        }
        
        // Vérifier que le membre existe
        if (!membreExiste(nom)) {
            System.out.println("Erreur : ce membre n'existe pas.");
            return false;
        }
        
        // Vérifier que la parcelle est libre
        if (parcelles[numeroParcelle] != null) {
            System.out.println("Erreur : cette parcelle est déjà occupée par " + 
                             parcelles[numeroParcelle] + ".");
            return false;
        }
        
        // Vérifier que le membre n'a pas déjà une parcelle
        if (membreOccupeParcelle(nom)) {
            System.out.println("Erreur : " + nom + " occupe déjà une parcelle.");
            return false;
        }
        
        // Attribution
        parcelles[numeroParcelle] = nom;
        System.out.println("✓ Parcelle " + numeroParcelle + " attribuée à " + nom + ".");
        return true;
    }
    
    /**
     * Libère une parcelle.
     * 
     * @param numeroParcelle Le numéro de la parcelle à libérer
     * @return true si la libération a réussi, false sinon
     */
    public static boolean libererParcelle(int numeroParcelle) {
        if (numeroParcelle < 0 || numeroParcelle >= NB_PARCELLES) {
            System.out.println("Erreur : numéro de parcelle invalide.");
            return false;
        }
        
        if (parcelles[numeroParcelle] == null) {
            System.out.println("Erreur : cette parcelle est déjà libre.");
            return false;
        }
        
        String ancienOccupant = parcelles[numeroParcelle];
        parcelles[numeroParcelle] = null;
        System.out.println("✓ Parcelle " + numeroParcelle + " libérée (" + ancienOccupant + ").");
        return true;
    }
    
    /**
     * Affiche l'état de toutes les parcelles.
     */
    public static void afficherParcelles() {
        System.out.println("\n=== État des parcelles ===");
        
        for (int i = 0; i < NB_PARCELLES; i++) {
            System.out.printf("Parcelle %d : ", i);
            if (parcelles[i] == null) {
                System.out.println("LIBRE");
            } else {
                System.out.println(parcelles[i]);
            }
        }
    }
    
    /**
     * Vérifie si un membre occupe une parcelle.
     */
    private static boolean membreOccupeParcelle(String nom) {
        for (int i = 0; i < NB_PARCELLES; i++) {
            if (parcelles[i] != null && parcelles[i].equals(nom)) {
                return true;
            }
        }
        return false;
    }
    
    // ========================================================================
    // GESTION DE L'ARROSAGE
    // ========================================================================
    
    /**
     * Planifie l'arrosage pour la semaine.
     * 
     * Cette fonction attribue automatiquement les jours d'arrosage
     * aux membres qui ont une parcelle.
     */
    public static void planifierArrosage() {
        System.out.println("\n=== Planification de l'arrosage ===");
        
        // Récupérer les membres qui ont une parcelle
        String[] membresAvecParcelle = new String[NB_PARCELLES];
        int nbMembresAvecParcelle = 0;
        
        for (int i = 0; i < NB_PARCELLES; i++) {
            if (parcelles[i] != null) {
                membresAvecParcelle[nbMembresAvecParcelle] = parcelles[i];
                nbMembresAvecParcelle++;
            }
        }
        
        if (nbMembresAvecParcelle == 0) {
            System.out.println("Aucune parcelle occupée. Pas d'arrosage à planifier.");
            return;
        }
        
        // Attribuer les jours de la semaine
        String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        
        for (int i = 0; i < 7; i++) {
            planningArrosage[i] = membresAvecParcelle[i % nbMembresAvecParcelle];
        }
        
        System.out.println("✓ Planning d'arrosage créé pour la semaine.");
    }
    
    /**
     * Affiche le planning d'arrosage de la semaine.
     */
    public static void afficherPlanningArrosage() {
        System.out.println("\n=== Planning d'arrosage ===");
        
        String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        
        boolean planningVide = true;
        for (int i = 0; i < 7; i++) {
            if (planningArrosage[i] != null) {
                planningVide = false;
                break;
            }
        }
        
        if (planningVide) {
            System.out.println("Aucun planning d'arrosage défini.");
            return;
        }
        
        for (int i = 0; i < 7; i++) {
            System.out.printf("%-10s : %s%n", jours[i], 
                            planningArrosage[i] != null ? planningArrosage[i] : "-");
        }
    }
    
    // ========================================================================
    // MENU PRINCIPAL
    // ========================================================================
    
    /**
     * Affiche le menu principal.
     */
    private static void afficherMenu() {
        System.out.println("\n========================================");
        System.out.println("    GESTION DU POTAGER PARTAGÉ");
        System.out.println("========================================");
        System.out.println("1. Ajouter un membre");
        System.out.println("2. Retirer un membre");
        System.out.println("3. Afficher les membres");
        System.out.println("4. Attribuer une parcelle");
        System.out.println("5. Libérer une parcelle");
        System.out.println("6. Afficher les parcelles");
        System.out.println("7. Planifier l'arrosage");
        System.out.println("8. Afficher le planning d'arrosage");
        System.out.println("0. Quitter");
        System.out.println("========================================");
    }
    
    /**
     * Programme principal : démonstration avec des données de test.
     */
    public static void main(String[] args) {
        System.out.println("=== Démonstration du système de gestion de potager ===\n");
        
        // Scénario de démonstration
        System.out.println("1. Ajout de membres");
        ajouterMembre("Alice");
        ajouterMembre("Bob");
        ajouterMembre("Charlie");
        ajouterMembre("Diana");
        
        afficherMembres();
        
        System.out.println("\n2. Attribution de parcelles");
        attribuerParcelle("Alice", 0);
        attribuerParcelle("Bob", 1);
        attribuerParcelle("Charlie", 2);
        
        afficherParcelles();
        
        System.out.println("\n3. Planification de l'arrosage");
        planifierArrosage();
        afficherPlanningArrosage();
        
        System.out.println("\n4. Libération d'une parcelle");
        libererParcelle(1);
        
        afficherParcelles();
        
        System.out.println("\n5. Nouvelle planification après changement");
        planifierArrosage();
        afficherPlanningArrosage();
        
        System.out.println("\n=== Fin de la démonstration ===");
    }
}
