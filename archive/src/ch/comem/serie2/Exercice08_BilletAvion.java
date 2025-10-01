package ch.comem.serie2;

import ch.comem.Clavier;

/*
    La compagnie d'aviation "Les Ailes" vous demande de réaliser un programme qui sera mis à la      disposition des voyageurs dans les aéroports. Ce programme devra permettre aux clients d'interroger le système sur le prix du billet; celui-ci varie en fonction du type de voyageur ainsi que du nombre de vols déjà effectués avec la compagnie au cours de l'année de la manière suivante:

    Les employés de la compagnie (type de voyageur n°1) bénéficient d'un rabais de 20% sur le prix de base du billet,

        - les membres du club "Cigogne" (type n°2) obtiennent un rabais de 10% sur le prix de base du billet, 
        - les autres voyageurs (type n°3) n'obtiennent pas de rabais.

    De plus, si le voyageur a déjà volé avec la compagnie lors de l'année courante, il bénéficie d'un rabais supplémentaire (sur le prix de base) proportionnel au nombre de vols effectués; celui-ci se monte à 10% pour un vol, à 15% pour 2, 3 ou 4 vols et à 20% pour 5 vols ou plus.

    Le programme que vous êtes chargés de réaliser calculera et affichera le prix effectif du billet (arrondi à 5 centimes) à partir du prix de base, du type de voyageur et du nombre de vols effectués au cours de l'année.

   ​ Exemple :
   ​	     Entrez le prix du billet : 123.45
   ​	     Tapez 1 si vous êtes un client normal,
   ​	     Tapez 2 si vous êtes un employé de la compagnie,
   ​	     Tapez 3 si vous êtes membre du club CIGOGNE.
   ​	     3
   ​	     Entez le nombre de vols effectués avec notre compagnie : 45 
   ​          Prix de base : 123.45.-
   ​	     Votre rabais : 30%
   ​	     Votre prix : 86.40.-
*/

public class Exercice08_BilletAvion {

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
        
        // Rabais
        final double RABAIS_COMPAGNIE = 20;
        final double RABAIS_CIGOGNE = 10;
        final double RABAIS_VOL_MINIMUM = 10;
        final double RABAIS_VOL_MOYEN = 15;
        final double RABAIS_VOL_MAXIMUM = 20;
        // Type voyageur
        final int NON_MEMBRE = 1;
        final int MEMBRE_COMPAGNIE = 2;
        final int MEMBRE_CIGOGNE = 3;

        double prixBaseBillet = Clavier.rend_double("Entrez le prix de base du billet: ");
        String message = "Etes vous un client normal (saisissez " + NON_MEMBRE + "), " +
            "un employé de la compagnie (saisissez " + MEMBRE_COMPAGNIE + "), " +
            "ou un membre du club CICOGNE (saisissez " + MEMBRE_CIGOGNE + "): ";
        int typeVoyageur = Clavier.rend_int(message);
        int nbVols = Clavier.rend_int("Entrez le nombre de vols effectués avec notre compagnie cette année: ");

        double rabais = 0;
        if (typeVoyageur == MEMBRE_COMPAGNIE) {
            rabais = RABAIS_COMPAGNIE;
        } else if (typeVoyageur == MEMBRE_CIGOGNE) {
            rabais = RABAIS_CIGOGNE;
        }
        
        double rabaisVols = 0;
        if (nbVols > 4) {
            rabaisVols = RABAIS_VOL_MAXIMUM;
        } else if (nbVols >= 2) {
            rabaisVols = RABAIS_VOL_MOYEN;
        } else if (nbVols == 1) {
            rabaisVols = RABAIS_VOL_MINIMUM;
        }
        rabais = rabais + rabaisVols;
        
        double prixFinal = prixBaseBillet * (1-rabais/100);
        final double PRECISION = 0.05;
        double prixFinalArrondi = Math.round(prixFinal/PRECISION)*PRECISION;
        
        
        System.out.println("Prix de base: " + prixBaseBillet);
        System.out.println("Vous avez droit à un rabais de " + rabais + "%");
        System.out.println("Le prix final du billet d'avion est donc de " + prixFinalArrondi + " CHF");
    }   
}