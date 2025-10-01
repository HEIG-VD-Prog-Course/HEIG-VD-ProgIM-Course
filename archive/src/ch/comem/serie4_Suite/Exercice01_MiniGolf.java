package ch.comem.serie4_Suite;

import ch.comem.Clavier;

public class Exercice01_MiniGolf {

    public static void main(String[] args) {
        // Ce programme permet de gérer une partie de minigolf (18 trous) entre plusieurs joueurs

        final char PASSAGE_A_LA_LIGNE;
        PASSAGE_A_LA_LIGNE = (char) 13; // Le caractère 13 correspond au retour de chariot
        // on peut aussi écrire : passageALaLigne = '\n'; 
        // Le caractère \ correspond à un caractère d'échappement

        int nbTrous;

        nbTrous = 18;
        String saisieUtilisateur;
        int choixUtilisateur;
        String[] tabChoix = new String[7];

        tabChoix[0] = "Saisir le nombre d'essais d'un joueur pour un trou";
        int choixSaisieNbEssaisJoueur;

        choixSaisieNbEssaisJoueur = 1;
        tabChoix[1] = "Afficher le score d'un joueur";
        int choixAfficherScore;

        choixAfficherScore = 2;
        tabChoix[2] = "Afficher tous les scores";
        int choixAfficherScores;

        choixAfficherScores = 3;
        tabChoix[3] = "Afficher les résultats de la partie";
        int choixAfficherResultats;

        choixAfficherResultats = 4;
        tabChoix[4] = "Afficher le(s) gagnant(s)";
        int choixAfficherGagnant;

        choixAfficherGagnant = 5;
        tabChoix[5] = "Afficher le(s) perdant(s)";
        int choixAfficherPerdant;

        choixAfficherPerdant = 6;
        tabChoix[6] = "Quitter l'application";
        int nbJoueurs;
        int indexTabChoix;
        boolean choixOk;
        int nbEssaisMax;
        int nbEssais;

        nbEssaisMax = 10;
        int indexTabJoueurs;
        boolean nomOk;
        int indexTabScores;
        int indexTabTotaux;
        boolean partieTerminee;

        partieTerminee = false;
        boolean trouAEteJoue;
        int scoreGagnant;

        scoreGagnant = (nbEssaisMax + 2) * nbTrous;
        int scorePerdant;

        scorePerdant = 0;
        String gagnant;

        gagnant = "";
        String perdant;

        perdant = "";
        System.out.println("Bonjour, ce programme permet de gérer une partie de minigolf entre plusieurs joueurs." + PASSAGE_A_LA_LIGNE);

        // Saisie du nombre de joueurs
        do {
            nbJoueurs = Clavier.rend_int("Veuillez saisir le nombre de joueurs : ");
        } while (nbJoueurs <= 0);
        String[] tabJoueurs = new String[nbJoueurs];
        int[] tabScores = new int[nbJoueurs * nbTrous];
        int[] tabTotaux = new int[nbJoueurs];

        // Initialisation du tableau des scores
        for (indexTabScores = 0; indexTabScores <= tabScores.length - 1; indexTabScores++) {
            tabScores[indexTabScores] = 0;
        }

        // Initialisation du tableau des totaux
        for (indexTabTotaux = 0; indexTabTotaux <= nbJoueurs - 1; indexTabTotaux++) {
            tabTotaux[indexTabTotaux] = 0;
        }

        // Saisie du nom du/des joueur(s)
        for (indexTabJoueurs = 0; indexTabJoueurs <= nbJoueurs - 1; indexTabJoueurs++) {
            do {
                saisieUtilisateur = Clavier.rend_String("Veuillez saisi le nom du " + (indexTabJoueurs + 1) + "e joueur : ");
                nomOk = !saisieUtilisateur.equals("");
            } while (!nomOk);
            tabJoueurs[indexTabJoueurs] = saisieUtilisateur;
        }
        do {

            System.out.println();
            // Affichage du menu
            for (indexTabChoix = 0; indexTabChoix <= tabChoix.length - 1; indexTabChoix++) {
                System.out.println(Integer.toString(indexTabChoix + 1) + ".) " + tabChoix[indexTabChoix]);
            }

            // Saisie du choix de l'utilisateur
            do {
                choixUtilisateur = Clavier.rend_int(PASSAGE_A_LA_LIGNE
                        + "Que désirez-vous faire ? [1-"
                        + tabChoix.length + "] : ");
                choixOk = choixUtilisateur >= 1 && choixUtilisateur <= tabChoix.length;
            } while (!choixOk);

            // réalisation du choix demandé
            if (choixUtilisateur == choixSaisieNbEssaisJoueur) {
                if (!partieTerminee) {

                    // Affichage du nom des joueurs
                    for (indexTabJoueurs = 0; indexTabJoueurs <= nbJoueurs - 1; indexTabJoueurs++) {
                        System.out.println(Integer.toString(indexTabJoueurs + 1) + ".) " + tabJoueurs[indexTabJoueurs]);
                    }

                    // Choix d'un joueur
                    do {
                        choixUtilisateur = Clavier.rend_int("Qui a joué ? [1-" + nbJoueurs + "] : ");
                        choixOk = choixUtilisateur >= 1 && choixUtilisateur <= nbJoueurs;
                    } while (!choixOk);
                    indexTabJoueurs = choixUtilisateur - 1;

                    // Choix d'un trou
                    do {
                        choixUtilisateur = Clavier.rend_int("Quel numéro de trou a joué "
                                + tabJoueurs[indexTabJoueurs]
                                + "? [1-"
                                + nbTrous + "] : ");
                        choixOk = choixUtilisateur >= 1 && choixUtilisateur <= nbTrous;
                    } while (!choixOk);
                    indexTabScores = indexTabJoueurs * nbTrous + choixUtilisateur - 1;
                    if (tabScores[indexTabScores] == 0) {

                        // Saisie du score
                        do {
                            choixUtilisateur = Clavier.rend_int("Combien d'essais a fallu à "
                                    + tabJoueurs[indexTabJoueurs]
                                    + " pour finir le trou "
                                    + choixUtilisateur + " ? [1-"
                                    + nbEssaisMax + "] : ");
                            choixOk = choixUtilisateur >= 1;
                        } while (!choixOk);
                        if (choixUtilisateur >= nbEssaisMax + 1) {
                            nbEssais = nbEssaisMax + 2;
                        } else {
                            nbEssais = choixUtilisateur;
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
            } else {
                if (choixUtilisateur == choixAfficherScore) {

                    // Affichage du nom des joueurs
                    for (indexTabJoueurs = 0; indexTabJoueurs <= nbJoueurs - 1; indexTabJoueurs++) {
                        System.out.println(Integer.toString(indexTabJoueurs + 1) + ".) " + tabJoueurs[indexTabJoueurs]);
                    }

                    // Choix d'un joueur
                    do {
                        choixUtilisateur = Clavier.rend_int("De qui voulez-vous le score ? [1-"
                                        + nbJoueurs + "] : ");
                        choixOk = choixUtilisateur >= 1 && choixUtilisateur <= nbJoueurs;
                    } while (!choixOk);

                    // Affichage du score du joueur
                    indexTabJoueurs = choixUtilisateur - 1;
                    indexTabScores = indexTabJoueurs * nbTrous + choixUtilisateur - 1;
                    System.out.println("Score de " + tabJoueurs[indexTabJoueurs]);
                    for (indexTabScores = indexTabJoueurs * nbTrous; indexTabScores <= indexTabJoueurs * nbTrous - 1 + nbTrous; indexTabScores++) {
                        System.out.print("Trou " + (indexTabScores % nbTrous + 1) + " : ");
                        if (tabScores[indexTabScores] == 0) {
                            System.out.println("Pas joué");
                        } else {
                            System.out.println(tabScores[indexTabScores]);
                        }
                    }
                } else {
                    if (choixUtilisateur == choixAfficherScores) {

                        // Affichage des scores des joueurs
                        for (indexTabJoueurs = 0; indexTabJoueurs <= nbJoueurs - 1; indexTabJoueurs++) {

                            // Affichage du score d'un joueur
                            indexTabScores = indexTabJoueurs * nbTrous + choixUtilisateur - 1;
                            System.out.println("Score de " + tabJoueurs[indexTabJoueurs]);
                            for (indexTabScores = indexTabJoueurs * nbTrous; indexTabScores <= indexTabJoueurs * nbTrous - 1 + nbTrous; indexTabScores++) {
                                System.out.print("Trou " + (indexTabScores % nbTrous + 1) + " : ");
                                if (tabScores[indexTabScores] == 0) {
                                    System.out.println("Pas joué");
                                } else {
                                    System.out.println(tabScores[indexTabScores]);
                                }
                            }
                        }
                    } else {
                        if (partieTerminee) {
                            if (choixUtilisateur == choixAfficherResultats) {

                                // Affichage des résultats des joueurs
                                for (indexTabJoueurs = 0; indexTabJoueurs <= nbJoueurs - 1; indexTabJoueurs++) {
                                    System.out.println("Score final de " + tabJoueurs[indexTabJoueurs] + " : " + tabTotaux[indexTabJoueurs] + " coups");
                                }
                            } else {
                                if (choixUtilisateur == choixAfficherGagnant) {
                                    System.out.println("Le gagnant est : " + gagnant);
                                } else {
                                    if (choixUtilisateur == choixAfficherPerdant) {
                                        if (perdant.equals("")) {
                                            System.out.println("Il n'y a pas de perdant !");
                                        } else {
                                            System.out.println("Le perdant est : " + perdant);
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("La partie n'est pas encore terminée");
                        }
                    }
                }
            }

            // Est-ce que la partie est terminée ?
            if (!partieTerminee) {
                indexTabScores = -1;
                do {
                    indexTabScores = indexTabScores + 1;
                    trouAEteJoue = tabScores[indexTabScores] != 0;
                } while (trouAEteJoue && indexTabScores < tabScores.length - 1);
                partieTerminee = trouAEteJoue;
                if (partieTerminee) {

                    // Recherche du score du gagnant et du score du perdant
                    for (indexTabTotaux = 0; indexTabTotaux <= nbJoueurs - 1; indexTabTotaux++) {
                        if (tabTotaux[indexTabTotaux] < scoreGagnant) {
                            scoreGagnant = tabTotaux[indexTabTotaux];
                        } else {
                            if (tabTotaux[indexTabTotaux] > scorePerdant) {
                                scorePerdant = tabTotaux[indexTabTotaux];
                            }
                        }
                    }

                    // Recherche du/des nom(s) du/des gagnant(s)
                    for (indexTabTotaux = 0; indexTabTotaux <= nbJoueurs - 1; indexTabTotaux++) {
                        if (tabTotaux[indexTabTotaux] == scoreGagnant) {
                            if (gagnant.equals("")) {
                                gagnant = tabJoueurs[indexTabTotaux];
                            } else {
                                gagnant = gagnant + " et " + tabJoueurs[indexTabTotaux] + " ";
                            }
                        } else {
                            if (tabTotaux[indexTabTotaux] == scorePerdant) {
                                if (perdant.equals("")) {
                                    perdant = tabJoueurs[indexTabTotaux] + " ";
                                } else {
                                    perdant = perdant + " et " + tabJoueurs[indexTabTotaux] + " ";
                                }
                            }
                        }
                    }
                }
            }
            System.out.print(PASSAGE_A_LA_LIGNE);
        } while (choixUtilisateur != tabChoix.length);
        System.out.println("A bientôt pour une nouvelle partie ;-)");
    }
}
