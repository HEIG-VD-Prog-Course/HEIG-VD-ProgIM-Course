package ch.comem.serie2;

import ch.comem.Clavier;

/*
    Un cinéma désire automatiser le calcul du prix de ses billets d'entrée. 
         Le prix du billet varie en fonction de différents critères : 
                - Les enfants jusqu'à l'âge de 7 ans y compris payent 5 Frs ; 
                - Les jeunes entre 8 à 18 ans y compris payent 10 Frs; 
                - Pour les autres, le prix est de 15 Frs. 
    De plus, une réduction de 20% est faite sur ce prix le lundi, une réduction de 10% est faite le mardi et le jeudi, les autres jours il n'y a pas de réduction. 
    Le programme que vous êtes chargés de réaliser calculera et affichera le prix à payer (arrondi à 50 centimes) à partir de l'âge et du jour.

   ​     Exemple : 
   ​          Saisissez l'âge de la personne : 15
   ​          Veuillez entrer le nom du jour en minuscule (Ex: lundi) : lundi
   ​          Prix de base : 10.-
   ​          Votre rabais : 20%
   ​          Votre prix :  8.00.- 
*/

public class Exercice09_Cinema {

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
        // les rabais selon les jours
        final double RABAIS_LUNDI = 20;
        final double RABAIS_MARDI_JEUDI = 10;
        // les ages limites pour les tarifs
        final int AGE_TARIF_ENFANT = 7;
        final int AGE_TARIF_JEUNE = 18;
        // les prix de base selon les tranches d'âge
        final double PRIX_ENFANT = 5;
        final double PRIX_JEUNE = 10;
        final double PRIX_NORMAL = 15;
        // les identifiant des tarifs
        final int TARIF_LUNDI = 1;
        final int TARIF_MARDI_JEUDI = 2;
        final int TARIF_AUTRES_JOURS = 3;
       
        int age = Clavier.rend_int("Saisissez l'âge de la personne :");
        
        String message = "Sommes-nous en tarif lundi (saisissez " + TARIF_LUNDI + "), " +
            "en tarif mardi-jeudi (saisissez " + TARIF_MARDI_JEUDI + "), " +
            "ou en tarif \"autres jours\" (saisissez " + TARIF_AUTRES_JOURS + "): ";
        int typeTarif = Clavier.rend_int(message);

        double prixDeBase;
        if (age <= AGE_TARIF_ENFANT) {
            prixDeBase = PRIX_ENFANT;
        } else if (age <= AGE_TARIF_JEUNE) {
            prixDeBase = PRIX_JEUNE;
        } else {
            prixDeBase = PRIX_NORMAL;
        }
        
        double rabais = 0;
        if (typeTarif == TARIF_LUNDI) {
            rabais = RABAIS_LUNDI;
        } else if (typeTarif == TARIF_MARDI_JEUDI) {
            rabais = RABAIS_MARDI_JEUDI;
        }
        
        double prixFinal = prixDeBase * (100 - rabais) / 100;
        final double PRECISION = 0.05;
        double prixFinalArrondi = Math.round(prixFinal/PRECISION)*PRECISION;

        System.out.println("le prix de base du billet est de " + prixDeBase + " CHF");
        System.out.println("Le rabais est de " + rabais + "%");
        System.out.println("Le prix final est de " + prixFinalArrondi + " CHF");
    }
}