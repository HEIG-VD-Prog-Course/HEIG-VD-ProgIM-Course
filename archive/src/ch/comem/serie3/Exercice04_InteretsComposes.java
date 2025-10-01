package ch.comem.serie3;

import ch.comem.Clavier;

public class Exercice04_InteretsComposes {

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
        // Saisie du capital (>0)
        double capital;
        boolean estPlusPetitOuEgalAZero;
        do {
            capital = Clavier.rend_double("Entrez le capital ( >0 ) de départ : ");
            estPlusPetitOuEgalAZero = (capital<=0);
            if (estPlusPetitOuEgalAZero) {
              System.out.println("Le capital n'est pas correct");
            }
        } while (estPlusPetitOuEgalAZero);
        
        // Saisie du taux d'intéret (>0) 
        double tauxInteret;
        do {
            tauxInteret = Clavier.rend_double("Entrez le taux d'intérêt en % : ");
            estPlusPetitOuEgalAZero = (tauxInteret<=0);
            if (estPlusPetitOuEgalAZero) {
              System.out.println("Le taux n'est pas correct");
            }
        } while (estPlusPetitOuEgalAZero);
        
        // Saisie du nombre de périodes (>0)
        int nbPeriodes;
        do {
            nbPeriodes = Clavier.rend_int("Entrez le nombre de périodes : ");
            estPlusPetitOuEgalAZero = (nbPeriodes<=0);
            if (estPlusPetitOuEgalAZero) {
              System.out.println("Le nombre de périodes n'est pas correct");
            }
        } while (estPlusPetitOuEgalAZero);
       
        // Calculs
        double capitalFinal = capital;
        //calcul les intérêts de chaque période
        for (int periode = 0; periode < nbPeriodes; periode++){
            capitalFinal = capitalFinal * (1 + tauxInteret/100 );
        }
        final double PRECISION = 0.05;
        double capitalFinalArrondi = Math.round(capitalFinal/PRECISION)*PRECISION;
        
        // Affichage du résultat
        System.out.print("Un somme de " + capital);
        System.out.print(" placée pendant " + nbPeriodes + " période(s)");
        System.out.print(" avec un taux d'intérêt de " + tauxInteret + "%");
        System.out.println(" génère un capital final de " + capitalFinalArrondi);
    }
}