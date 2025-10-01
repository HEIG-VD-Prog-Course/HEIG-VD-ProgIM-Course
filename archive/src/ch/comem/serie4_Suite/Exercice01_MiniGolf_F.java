package ch.comem.serie4_Suite;

import ch.comem.Clavier;

public class Exercice01_MiniGolf_F {

    private final static String PASSAGE_A_LA_LIGNE = System.getProperty("line.separator");
    private static boolean partieTerminee = false;
    private static final int NB_TROUS = 18;
    private static final int NB_ESSAIS_MAX = 7;
    private static String gagnant = "";
    private static String perdant = "";

    public static void main(String[] args) {

        presentationProgramme();
        final int NB_JOUEURS = saisieNbJoueurs();
        String[] tabJoueurs = new String[NB_JOUEURS];
        int[] tabScores = new int[NB_JOUEURS * NB_TROUS];
        int[] tabTotaux = new int[NB_JOUEURS];
        initialiseTabScores(tabScores);
        initialiseTabTotaux(tabTotaux);
        saisieNomsJoueurs(tabJoueurs);

        int choixUtilisateur;
        do {
            afficheMenu();
            choixUtilisateur = rendChoix();
            effectueChoix(choixUtilisateur, tabJoueurs, tabScores, tabTotaux);
            miseAJourScores(tabJoueurs, tabScores, tabTotaux);
            System.out.print(PASSAGE_A_LA_LIGNE);
        } while (choixUtilisateur != 7);

        System.out.println("A bientôt pour une nouvelle partie ;-)");
    }

    private static void presentationProgramme() {
        System.out.println("Bonjour, ce programme permet de gérer une partie "
                + "de minigolf entre plusieurs joueurs." + PASSAGE_A_LA_LIGNE);
    }

    private static int saisieNbJoueurs() {
        // Saisie du nombre de joueurs
        int nbJoueurs;
        do {
            nbJoueurs = Clavier.rend_int("Veuillez saisir le nombre de joueurs : ");
        } while (nbJoueurs <= 0);
        return nbJoueurs;
    }

    private static void initialiseTabScores(int[] tabScores) {
        for (int i = 0; i < tabScores.length; i++) {
            tabScores[i] = 0;
        }
    }

    private static void initialiseTabTotaux(int[] tabTotaux) {
        for (int i = 0; i < tabTotaux.length; i++) {
            tabTotaux[i] = 0;
        }
    }

    private static void saisieNomsJoueurs(String[] tabJoueurs) {
        String nom;
        boolean nomOk;
        for (int i = 0; i < tabJoueurs.length; i++) {
            do {
                nom = Clavier.rend_String("Veuillez saisi le nom du " + (i + 1) + "e joueur : ");
                nomOk = !nom.equals("");
            } while (!nomOk);
            tabJoueurs[i] = nom;
        }
    }

    private static void afficheMenu() {

        String[] tabChoix = {
            "Saisir le nombre d'essais d'un joueur pour un trou",
            "Afficher le score d'un joueur",
            "Afficher tous les scores",
            "Afficher les résultats de la partie",
            "Afficher le(s) gagnant(s)",
            "Afficher le(s) perdant(s)",
            "Quitter l'application"
        };
        for (int i = 0; i < tabChoix.length; i++) {
            System.out.println((i + 1) + ".) " + tabChoix[i]);
        }
        System.out.println();
    }

    private static int rendChoix() {
        int choixUtilisateur;
        boolean choixOk;
        final int CHOIX_MIN = 1;
        final int CHOIX_MAX = 7;
        do {
            choixUtilisateur = Clavier.rend_int(PASSAGE_A_LA_LIGNE + "Que désirez-vous faire ? ["
                    + CHOIX_MIN + "-" + CHOIX_MAX + "] : ");
            choixOk = choixUtilisateur >= CHOIX_MIN
                    && choixUtilisateur <= CHOIX_MAX;
        } while (!choixOk);
        return choixUtilisateur;
    }

    private static void effectueChoix(int choixUtilisateur, String[] tabJoueurs,
            int[] tabScores, int[] tabTotaux) {

        final int CHOIX_SAISIE_NB_ESSAIS_JOUEUR = 1;
        final int CHOIX_AFFICHER_SCORE = 2;
        final int CHOIX_AFFICHER_SCORES = 3;
        final int CHOIX_AFFICHER_RESULTATS = 4;
        final int CHOIX_AFFICHER_GAGNANT = 5;
        final int CHOIX_AFFICHER_PERDANT = 6;

        // réalisation du choix demandé
        switch (choixUtilisateur) {
            case CHOIX_SAISIE_NB_ESSAIS_JOUEUR:
                choixSaisieNbEssaisJoueur(tabJoueurs, tabScores, tabTotaux);
                break;
            case CHOIX_AFFICHER_SCORE:
                choixAfficherScore(tabJoueurs, tabScores);
                break;
            case CHOIX_AFFICHER_SCORES:
                choixAfficherScores(tabJoueurs, tabScores);
                break;
            case CHOIX_AFFICHER_RESULTATS:
                choixAfficherResultats(tabJoueurs, tabTotaux);
                break;
            case CHOIX_AFFICHER_GAGNANT:
                choixAfficherGagnant();
                break;
            case CHOIX_AFFICHER_PERDANT:
                choixAfficherPerdant();
                break;
            default:
        }
    }

    private static void choixSaisieNbEssaisJoueur(String[] tabJoueurs, int[] tabScores, int[] tabTotaux) {
        if (!partieTerminee) {

            // Affichage du nom des joueurs
            afficheNomsJoueurs(tabJoueurs);

            String message = "Qui a joué ? [1-" + tabJoueurs.length + "] : ";
            // Choix d'un joueur
            int indexTabJoueurs = choixJoueur(message, tabJoueurs);

            message = "Quel numéro de trou a joué "
                    + tabJoueurs[indexTabJoueurs] + "? [1-" + NB_TROUS + "] : ";
            // Choix d'un trou
            int noTrou = choixTrou(message);
            int indexTabScores = indexTabJoueurs * NB_TROUS + noTrou - 1;

            if (tabScores[indexTabScores] == 0) {

                message = "Combien d'essais a fallu à "
                        + tabJoueurs[indexTabJoueurs] + " pour finir le trou "
                        + noTrou + " ? [1-" + NB_ESSAIS_MAX + "] : ";
                int score = saisiScore(message);

                int nbEssais;
                if (score >= NB_ESSAIS_MAX) {
                    nbEssais = NB_ESSAIS_MAX;
                } else {
                    nbEssais = score;
                }

                // Stockage du score du joueur
                tabScores[indexTabScores] = nbEssais;

                // Mise à jour du total du joueur
                tabTotaux[indexTabJoueurs] = tabTotaux[indexTabJoueurs] + nbEssais;
            } else {
                System.out.println(tabJoueurs[indexTabJoueurs] + " a déjà joué ce trou !");
            }
        } else {
            System.out.println("Tous les scores ont été saisis !");
        }
    }

    private static void choixAfficherScore(String[] tabJoueurs, int[] tabScores) {
        // Affichage du nom des joueurs
        afficheNomsJoueurs(tabJoueurs);

        // Choix d'un joueur
        String message = "De qui voulez-vous le score ? [1-" + tabJoueurs.length + "] : ";
        int indexTabJoueurs = choixJoueur(message, tabJoueurs);

        // Affichage du score d'un joueur
        afficheScore(indexTabJoueurs, tabJoueurs, tabScores);
    }

    private static void afficheNomsJoueurs(String[] tabJoueurs) {
        int i = 1;
        for (String nom : tabJoueurs) {
            System.out.println(i + ".) " + nom);
            i++;
        }
    }

    private static int choixJoueur(String message, String[] tabJoueurs) {
        boolean choixOk;
        int choixUtilisateur;
        do {
            choixUtilisateur = Clavier.rend_int(message);
            choixOk = choixUtilisateur >= 1 && choixUtilisateur <= tabJoueurs.length;
        } while (!choixOk);
        return choixUtilisateur - 1;
    }

    private static void afficheScore(int indexTabJoueurs, String[] tabJoueurs, int[] tabScores) {
        int indexTabScores = indexTabJoueurs * NB_TROUS + indexTabJoueurs;
        System.out.println("Score de " + tabJoueurs[indexTabJoueurs]);
        for (indexTabScores = indexTabJoueurs * NB_TROUS; indexTabScores <= indexTabJoueurs * NB_TROUS - 1 + NB_TROUS; indexTabScores++) {
            System.out.print("Trou " + (indexTabScores % NB_TROUS + 1) + " : ");
            if (tabScores[indexTabScores] == 0) {
                System.out.println("Pas joué");
            } else {
                System.out.println(tabScores[indexTabScores]);
            }
        }
    }

    private static void choixAfficherScores(String[] tabJoueurs, int[] tabScores) {
        // Affichage des scores des joueurs
        for (int indexTabJoueurs = 0; indexTabJoueurs < tabJoueurs.length; indexTabJoueurs++) {
            afficheScore(indexTabJoueurs, tabJoueurs, tabScores);
        }
    }

    private static void choixAfficherResultats(String[] tabJoueurs, int[] tabTotaux) {
        if (partieTerminee) {
            for (int indexTabJoueurs = 0; indexTabJoueurs < tabJoueurs.length; indexTabJoueurs++) {
                System.out.println("Score final de " + tabJoueurs[indexTabJoueurs] + " : " + tabTotaux[indexTabJoueurs] + " coups");
            }
        } else {
            System.out.println("La partie n'est pas encore terminée");
        }
    }

    private static int[] rendScoresGagnantPerdant(int[] tabTotaux) {
        int[] scoresGagnantPerdant = new int[2]; // Recherche du score du gagnant et du score du perdant
        int scoreGagnant = (NB_ESSAIS_MAX + 2) * NB_TROUS;
        int scorePerdant = 0;
        for (int indexTabTotaux = 0; indexTabTotaux < tabTotaux.length; indexTabTotaux++) {
            if (tabTotaux[indexTabTotaux] < scoreGagnant) {
                scoreGagnant = tabTotaux[indexTabTotaux];
            } else {
                if (tabTotaux[indexTabTotaux] > scorePerdant) {
                    scorePerdant = tabTotaux[indexTabTotaux];
                }
            }
        }
        scoresGagnantPerdant[0] = scoreGagnant;
        scoresGagnantPerdant[1] = scorePerdant;
        return scoresGagnantPerdant;
    }

    private static void definiGagnantPerdant(int[] scoresGagnantPerdant, String[] tabJoueurs, int[] tabTotaux) {
        // Recherche du/des nom(s) du/des gagnant(s)
        for (int indexTabTotaux = 0; indexTabTotaux < tabTotaux.length; indexTabTotaux++) {
            if (tabTotaux[indexTabTotaux] == scoresGagnantPerdant[0]) {
                if (gagnant.equals("")) {
                    gagnant = tabJoueurs[indexTabTotaux];
                } else {
                    gagnant = gagnant + " et " + tabJoueurs[indexTabTotaux] + " ";
                }
            } else {
                if (tabTotaux[indexTabTotaux] == scoresGagnantPerdant[1]) {
                    if (perdant.equals("")) {
                        perdant = tabJoueurs[indexTabTotaux] + " ";
                    } else {
                        perdant = perdant + " et " + tabJoueurs[indexTabTotaux] + " ";
                    }
                }
            }
        }
    }

    private static void miseAJourScores(String[] tabJoueurs, int[] tabScores, int[] tabTotaux) {
        // Est-ce que la partie est terminée ?
        if (!partieTerminee) {
            int indexTabScores = -1;
            boolean trouAEteJoue;
            do {
                indexTabScores = indexTabScores + 1;
                trouAEteJoue = tabScores[indexTabScores] != 0;
            } while (trouAEteJoue && indexTabScores < tabScores.length - 1);
            partieTerminee = trouAEteJoue;
            if (partieTerminee) {
                int[] scoresGagnantPerdant = rendScoresGagnantPerdant(tabTotaux);
                definiGagnantPerdant(scoresGagnantPerdant, tabJoueurs, tabTotaux);
            }
        }
    }

    private static int choixTrou(String message) {
        boolean choixOk;
        int noTrou;
        do {
            noTrou = Clavier.rend_int(message);
            choixOk = noTrou >= 1 && noTrou <= NB_TROUS;
        } while (!choixOk);
        return noTrou;
    }

    private static int saisiScore(String message) {
        boolean scoreOk;
        int score;
        // Saisie du score
        do {
            System.out.print(message);
            score = Clavier.rend_int(message);
            scoreOk = score >= 1;
        } while (!scoreOk);
        return score;
    }

    private static void choixAfficherPerdant() {
        if (partieTerminee) {
            if (perdant.equals("")) {
                System.out.println("Il n'y a pas de perdant !");
            } else {
                System.out.println("Le perdant est : " + perdant);
            }
        } else {
            System.out.println("La partie n'est pas encore terminée");
        }
    }

    private static void choixAfficherGagnant() {
        if (partieTerminee) {
            System.out.println("Le gagnant est : " + gagnant);
        } else {
            System.out.println("La partie n'est pas encore terminée");
        }
    }
}
