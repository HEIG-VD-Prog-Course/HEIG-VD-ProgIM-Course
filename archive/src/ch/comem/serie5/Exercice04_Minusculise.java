package ch.comem.serie5;

/**
 * Ecrire une fonction qui retourne le caractère reçu en argument en minuscule.
 * Exemple : "A" => "a"
 * @author Jean-Pierre Hess
 */
public class Exercice04_Minusculise {

    public static void main(String[] args) {
        char aMaj = 'A';
        char aMin = minusculise(aMaj);
        System.out.println("La minuscule de " + aMaj + " est " + aMin);
    }

    /**
     * Permet de minusculiser la majuscule spécifiée
     * @param majuscule Le caractère à minusculiser
     * @return La minuscule si c'est possible sinon retourne le caractère spécifié
     */
    public static char minusculise(char majuscule) {
        char minuscule = majuscule;
        if (majuscule>='A' && majuscule<='Z') {
            minuscule = (char) (majuscule + ('a'-'A'));
        }
        return minuscule;
    }
    
}
