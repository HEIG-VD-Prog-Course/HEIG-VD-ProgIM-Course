package ch.comem.serie6;

public class Exercice1 {
    public static void main(String[] args) {
        int[] tab = {1,2,3,4,5,6,7,8,9,10,20,30};

        int index = rechercheDichotomique(tab, 11);
        System.out.println(index);

        index = rechercheDichotomique(tab, 7);
        System.out.println(index);
    }

    /**
     * Attention ! Ne fonctionne que si les valeurs du tableau sont triées par ordre croissant
     * @param arr   Le tableau
     * @param value La valeur à chercher
     * @return L'index de la (première) case valant "value" ou -1 si value n'a pas été trouvée
     */
    public static int rechercheDichotomique(int[] arr, int value) {
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        boolean stop = false;
        int mid;
        do {
            mid = (start + end) / 2;
            if (arr[mid] > value) {
                end = mid - 1;
            } else if (arr[mid] < value) {
                start = mid + 1;
            } else {
                stop = true;
                index = mid;
            }
        } while (start <= end && !stop);
        return index;
    }
}
