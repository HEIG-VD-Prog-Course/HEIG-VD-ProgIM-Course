package ch.comem.serie5;

/**
 * Ecrire une fonction qui retourne le caractère reçu en argument en majuscule.
 * Exemple : "a" => "A" 
 * Remarque : Ne pas tenir compte des accents.
 * @author Jean-Pierre Hess
 */
public class Exercice03_Majusculise {

    public static void main(String[] args) {
        char aMin = 'a';
        char aMaj = majusculise(aMin);
        System.out.println("La majuscule de " + aMin + " est " + aMaj);
    }

    /**
     * Permet de majusculiser la minuscule spécifiée
     * @param minuscule Le caractère à majusculiser
     * @return La majuscule si c'est possible sinon retourne le caractère spécifié
     */
    public static char majusculise(char minuscule) {
        char majuscule = minuscule;
        if (minuscule>='a' && minuscule<='z') {
            majuscule = (char) (minuscule - ('a'-'A'));
        }
        return majuscule;
    }
    
}