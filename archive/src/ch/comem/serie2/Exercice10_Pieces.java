package ch.comem.serie2;

import ch.comem.Clavier;

/*
    Une entreprise de vente de pièces détachées désire automatiser le calcul des factures pour ses clients.
    La somme à payer varie en fonction du nombre de pièces de la manière suivante: 
            - Les clients achetant au moins 50 pièces bénéficient d'un rabais de 3%, 
            - ceux qui achètent au moins 100 pièces obtiennent un rabais de 5%, enfin,
            - ceux qui achètent 1000 pièces ou plus obtiennent un rabais de 10%.
    Sur le prix obtenu, les clients doivent payer la TVA qui se monte :
            - à 8,2% pour des lots comprenant jusqu'à 250 pièces y compris, 
            - à 6,3% pour les lots comprenant jusqu'à 500 pièces y compris et 
            - à 4,5% pour les lots de plus de 500 pièces.

    Le programme que vous êtes chargés de réaliser calculera et affichera la somme à payer (arrondie à 10 centimes) à partir de la donnée du nombre de pièces et du prix unitaire (prix d'une pièce).

    ​     Exemple :
    ​          Combien de pièces voulez-vous acheter ? 552
    ​          Quel est le prix unitaire de la pièce ? 4.75
    ​          Le prix TTC pour 552 pièces à 4.75.- avec un rabais de 5% et un taux TVA à 4.5% sera de : 2602.90.- 
*/

public class Exercice10_Pieces {

    // Règle les éventuels problèmes d'affichage des accents
    static {
        try {
            System.setOut(new java.io.PrintStream(
                    new java.io.FileOutputStream(java.io.FileDescriptor.out), true, "UTF-8"));
            
        } catch (java.io.UnsupportedEncodingException ex) {
            System.out.println("VM dont support UTF-8");
        }
    }
    
    public static void main(String[] args) {
        // les rabais selon le nombre de pièces achetées en %
        final double RABAIS_PETITE_QUANTITE = 3;
        final double RABAIS_MOYENNE_QUANTITE = 5;
        final double RABAIS_GRANDE_QUANTITE = 10;
        // les nombres de pièces minimum pour bénéficier des rabais sur la quantité
        final int NB_PIECES_RABAIS_PETITE_QUANTITE = 50;
        final int NB_PIECES_RABAIS_MOYENNE_QUANTITE = 100;
        final int NB_PIECES_RABAIS_GRANDE_QUANTITE = 1000;
        // les TVA selon le nombre de pièces
        final double TVA_PETITE_QUANTITE = 8.2;
        final double TVA_MOYENNE_QUANTITE = 6.3;
        final double TVA_GRANDE_QUANTITE = 4.5;
        // les nombres de pièces maximum pour bénéficier de la TVA correspondante
        final int NB_PIECES_TVA_PETITE_QUANTITE = 250;
        final int NB_PIECES_TVA_MOYENNE_QUANTITE = 500;

        int nbPieces = Clavier.rend_int("Combien de pièces voulez vous acheter ?");
        double prixUnitaire = Clavier.rend_double("Quel est le prix unitaire de la pièce ?");

        final double PRECISION = 0.05;
        
        double rabais;
        if (nbPieces >= NB_PIECES_RABAIS_GRANDE_QUANTITE) {
            rabais = RABAIS_GRANDE_QUANTITE;
        } else if (nbPieces >= NB_PIECES_RABAIS_MOYENNE_QUANTITE) {
            rabais = RABAIS_MOYENNE_QUANTITE;
        } else if (nbPieces >= NB_PIECES_RABAIS_PETITE_QUANTITE) {
            rabais = RABAIS_PETITE_QUANTITE;
        } else {
            rabais = 0;
        }
        
        double tauxTva;
        if (nbPieces <= NB_PIECES_TVA_PETITE_QUANTITE) {
            tauxTva = TVA_PETITE_QUANTITE;
        } else if (nbPieces <= NB_PIECES_TVA_MOYENNE_QUANTITE) {
            tauxTva = TVA_MOYENNE_QUANTITE;
        } else {
            tauxTva = TVA_GRANDE_QUANTITE;
        }      
        
        double prix = nbPieces * prixUnitaire * (1 - rabais/ 100);
        double tva = prix * tauxTva / 100;
        double prixTTC = prix+tva;
        double prixArrondi = Math.round(prix/PRECISION)*PRECISION;
        double tvaArrondie = Math.round(tva/PRECISION)*PRECISION; 
        double prixTTCArrondi = Math.round(prixTTC/PRECISION)*PRECISION; 

        System.out.println("Nombre de pièces: " + nbPieces);
        System.out.println("Prix unitaire: " + prixUnitaire + " CHF");
        System.out.println("Rabais obtenu: " + rabais + " %");
        System.out.println("Total brut: " + prixArrondi + " CHF");
        System.out.println("Taux tva: " + tauxTva + " %");
        System.out.println("Total tva: " + tvaArrondie + " CHF");
        System.out.println("Total TTC: " + prixTTCArrondi + " CHF");
    }
}