package ch.comem.serie5;

/**
 * Ecrire une fonction permettant de retourner un nombre aléatoire compris 
 * entre deux bornes (valeur des bornes comprises).
 * @author Jean-Pierre Hess
 */
public class Exercice10_Aleat {

    public static void main(String[] args) {
        System.out.println(aleat(2,3));
    }

    /**
     * Rend un nombre aléatoire compris entre les bornes spécifiées (valeurs comprises)
     * @param borneMin Borne min
     * @param borneMax Borne max
     * @return Le nombre aléatoire entre borneMin et borneMax (valeurs comprises) 
     */
    private static int aleat(int borneMin, int borneMax) {
        return (int)(Math.random()*(borneMax-borneMin+1))+borneMin;
    }
}