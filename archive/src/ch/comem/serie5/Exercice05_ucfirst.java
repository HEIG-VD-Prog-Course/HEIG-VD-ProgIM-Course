package ch.comem.serie5;

/**
 * En vous basant sur les fonctions de l'exercice 3 et 4, veillez écrire une
 * fonction nommée 'ucfirst' prenant comme argument une chaine de caractère et
 * qui retourne une chaine de caractère dont la 1ère lettre est une majuscule
 * suivie de lettres minuscules.
 *
 * Exemple : ​	"PAUL" => "Paul" ​	"simone" => "Simone"
 *
 * @author Jean-Pierre Hess
 */
public class Exercice05_ucfirst {

    public static void main(String[] args) {
        String prenom1 = "PAUL";
        String prenom2 = "simone";
        prenom1 = ucfirst(prenom1);
        System.out.println(prenom1);
        prenom2 = ucfirst(prenom2);
        System.out.println(prenom2);
    }

    /**
     * Permet de mettre la première lettre de la chaîne spécifiée en majuscule
     * et le reste en minuscule
     * @param prenom Le prénom à traiter
     * @return Le prénom avec la 1e lettre en majuscule et le reste en minuscule
     */
    private static String ucfirst(String prenom) {
        String chaine = "";
        if (prenom != null && prenom.length() >= 1) {
            chaine += Exercice03_Majusculise.majusculise(prenom.charAt(0));
            char car;
            for (int i = 1; i < prenom.length(); i++) {
                car = prenom.charAt(i);
                chaine += Exercice04_Minusculise.minusculise(car);
            }
        }
        return chaine;
    }
}
