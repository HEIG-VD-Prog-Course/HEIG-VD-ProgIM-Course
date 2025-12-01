/**
 * Exemple 03 : Planificateur de covoiturage pour une communauté
 * 
 * Ce programme illustre la gestion d'un problème complexe avec
 * plusieurs structures de données et validation d'erreurs.
 * 
 * Contexte :
 * Une communauté locale souhaite organiser un système de covoiturage
 * pour réduire l'empreinte carbone des trajets quotidiens. Le système
 * doit permettre de grouper les personnes ayant des trajets similaires.
 * 
 * Ce programme démontre :
 * 1. La gestion de structures de données multiples
 * 2. La validation et la gestion d'erreurs
 * 3. L'application de plusieurs stratégies combinées
 */

public class PlanificateurCovoiturage {

    // Structure simple pour représenter un trajet
    static class Trajet {
        String conducteur;
        String depart;
        String arrivee;
        int places;
        String[] passagers;
        int nbPassagers;

        Trajet(String conducteur, String depart, String arrivee, int places) {
            this.conducteur = conducteur;
            this.depart = depart;
            this.arrivee = arrivee;
            this.places = places;
            this.passagers = new String[places];
            this.nbPassagers = 0;
        }
    }

    // Base de données des trajets
    private static Trajet[] trajets = new Trajet[20];
    private static int nbTrajets = 0;

    // ========================================================================
    // VALIDATION ET GESTION D'ERREURS
    // ========================================================================

    /**
     * Valide qu'une chaîne n'est pas vide.
     */
    private static boolean estChaineValide(String chaine) {
        return chaine != null && !chaine.trim().isEmpty();
    }

    /**
     * Valide un nombre de places.
     */
    private static boolean estNombrePlacesValide(int places) {
        return places > 0 && places <= 4; // Maximum 4 passagers
    }

    /**
     * Trouve un trajet correspondant à des critères.
     */
    private static Trajet trouverTrajet(String depart, String arrivee) {
        for (int i = 0; i < nbTrajets; i++) {
            Trajet t = trajets[i];
            if (t.depart.equalsIgnoreCase(depart) &&
                    t.arrivee.equalsIgnoreCase(arrivee) &&
                    t.nbPassagers < t.places) {
                return t;
            }
        }
        return null;
    }

    // ========================================================================
    // GESTION DES TRAJETS
    // ========================================================================

    /**
     * Propose un nouveau trajet de covoiturage.
     */
    public static boolean proposerTrajet(String conducteur, String depart,
            String arrivee, int places) {
        // Validation des entrées
        if (!estChaineValide(conducteur)) {
            System.out.println("Erreur : nom du conducteur invalide.");
            return false;
        }

        if (!estChaineValide(depart) || !estChaineValide(arrivee)) {
            System.out.println("Erreur : lieu de départ ou d'arrivée invalide.");
            return false;
        }

        if (!estNombrePlacesValide(places)) {
            System.out.println("Erreur : nombre de places invalide (1-4).");
            return false;
        }

        // Vérifier qu'il y a de la place dans la base
        if (nbTrajets >= trajets.length) {
            System.out.println("Erreur : capacité maximale atteinte.");
            return false;
        }

        // Créer et enregistrer le trajet
        Trajet nouveauTrajet = new Trajet(conducteur, depart, arrivee, places);
        trajets[nbTrajets] = nouveauTrajet;
        nbTrajets++;

        System.out.printf("✓ Trajet ajouté : %s propose %s → %s (%d places)%n",
                conducteur, depart, arrivee, places);
        return true;
    }

    /**
     * Réserve une place dans un covoiturage.
     */
    public static boolean reserverPlace(String passager, String depart, String arrivee) {
        // Validation
        if (!estChaineValide(passager)) {
            System.out.println("Erreur : nom du passager invalide.");
            return false;
        }

        // Chercher un trajet disponible
        Trajet trajet = trouverTrajet(depart, arrivee);

        if (trajet == null) {
            System.out.println("Aucun trajet disponible pour ce parcours.");
            return false;
        }

        // Vérifier que le passager n'est pas déjà inscrit
        for (int i = 0; i < trajet.nbPassagers; i++) {
            if (trajet.passagers[i].equals(passager)) {
                System.out.println("Erreur : déjà inscrit à ce trajet.");
                return false;
            }
        }

        // Ajouter le passager
        trajet.passagers[trajet.nbPassagers] = passager;
        trajet.nbPassagers++;

        System.out.printf("✓ %s réservé une place avec %s (%s → %s)%n",
                passager, trajet.conducteur, depart, arrivee);
        return true;
    }

    /**
     * Annule la réservation d'un passager.
     */
    public static boolean annulerReservation(String passager, String depart, String arrivee) {
        Trajet trajet = trouverTrajet(depart, arrivee);

        if (trajet == null) {
            System.out.println("Aucun trajet trouvé.");
            return false;
        }

        // Chercher le passager
        int indexPassager = -1;
        for (int i = 0; i < trajet.nbPassagers; i++) {
            if (trajet.passagers[i].equals(passager)) {
                indexPassager = i;
                break;
            }
        }

        if (indexPassager == -1) {
            System.out.println("Ce passager n'est pas inscrit à ce trajet.");
            return false;
        }

        // Retirer le passager (décaler le tableau)
        for (int i = indexPassager; i < trajet.nbPassagers - 1; i++) {
            trajet.passagers[i] = trajet.passagers[i + 1];
        }
        trajet.passagers[trajet.nbPassagers - 1] = null;
        trajet.nbPassagers--;

        System.out.printf("✓ Réservation annulée pour %s%n", passager);
        return true;
    }

    // ========================================================================
    // AFFICHAGE ET STATISTIQUES
    // ========================================================================

    /**
     * Affiche tous les trajets disponibles.
     */
    public static void afficherTrajets() {
        System.out.println("\n=== Trajets de covoiturage disponibles ===");

        if (nbTrajets == 0) {
            System.out.println("Aucun trajet enregistré.");
            return;
        }

        for (int i = 0; i < nbTrajets; i++) {
            Trajet t = trajets[i];
            System.out.printf("%nTrajet %d :%n", i + 1);
            System.out.printf("  Conducteur : %s%n", t.conducteur);
            System.out.printf("  Parcours : %s → %s%n", t.depart, t.arrivee);
            System.out.printf("  Places : %d/%d occupées%n", t.nbPassagers, t.places);

            if (t.nbPassagers > 0) {
                System.out.print("  Passagers : ");
                for (int j = 0; j < t.nbPassagers; j++) {
                    System.out.print(t.passagers[j]);
                    if (j < t.nbPassagers - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * Calcule et affiche les statistiques d'impact écologique.
     */
    public static void afficherStatistiques() {
        System.out.println("\n=== Impact écologique ===");

        int totalPersonnes = 0;
        int totalVoitures = nbTrajets;

        for (int i = 0; i < nbTrajets; i++) {
            totalPersonnes += 1 + trajets[i].nbPassagers; // Conducteur + passagers
        }

        if (totalVoitures == 0) {
            System.out.println("Aucune donnée disponible.");
            return;
        }

        // Estimation simplifiée : chaque personne économise un trajet solo
        int trajetsEvites = totalPersonnes - totalVoitures;

        // Estimation CO2 : environ 0.2 kg CO2/km pour une voiture moyenne
        // Trajet moyen estimé à 10 km
        double co2Economise = trajetsEvites * 10 * 0.2;

        System.out.printf("Nombre de trajets : %d%n", totalVoitures);
        System.out.printf("Nombre total de personnes : %d%n", totalPersonnes);
        System.out.printf("Trajets solo évités : %d%n", trajetsEvites);
        System.out.printf("CO2 économisé (estimation) : %.1f kg%n", co2Economise);
    }

    /**
     * Affiche les trajets pour un lieu de départ donné.
     */
    public static void afficherTrajetsDepuis(String depart) {
        System.out.printf("%n=== Trajets depuis %s ===%n", depart);

        boolean trouve = false;
        for (int i = 0; i < nbTrajets; i++) {
            Trajet t = trajets[i];
            if (t.depart.equalsIgnoreCase(depart)) {
                trouve = true;
                System.out.printf("→ %s (conducteur: %s, places: %d/%d)%n",
                        t.arrivee, t.conducteur, t.nbPassagers, t.places);
            }
        }

        if (!trouve) {
            System.out.println("Aucun trajet depuis ce lieu.");
        }
    }

    // ========================================================================
    // PROGRAMME PRINCIPAL
    // ========================================================================

    public static void main(String[] args) {
        System.out.println("=== Démonstration du planificateur de covoiturage ===\n");

        // Scénario de test
        System.out.println("1. Proposition de trajets");
        proposerTrajet("Alice", "Yverdon", "Lausanne", 3);
        proposerTrajet("Bob", "Yverdon", "Lausanne", 2);
        proposerTrajet("Charlie", "Lausanne", "Genève", 4);
        proposerTrajet("Diana", "Yverdon", "Fribourg", 1);

        afficherTrajets();

        System.out.println("\n2. Réservations");
        reserverPlace("Eve", "Yverdon", "Lausanne");
        reserverPlace("Frank", "Yverdon", "Lausanne");
        reserverPlace("Grace", "Yverdon", "Lausanne");
        reserverPlace("Henry", "Lausanne", "Genève");

        afficherTrajets();

        System.out.println("\n3. Statistiques d'impact");
        afficherStatistiques();

        System.out.println("\n4. Recherche de trajets");
        afficherTrajetsDepuis("Yverdon");
        afficherTrajetsDepuis("Lausanne");

        System.out.println("\n5. Annulation");
        annulerReservation("Frank", "Yverdon", "Lausanne");

        afficherTrajets();
        afficherStatistiques();

        System.out.println("\n=== Fin de la démonstration ===");
    }
}
