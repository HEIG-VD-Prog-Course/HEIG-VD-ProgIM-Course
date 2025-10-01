package ch.comem.serie6;

public class Exercice6 {
    
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
        String[] prenoms = {"Paul", "Simone", "Louis", "Anaïs"};
        int[] ages = {      23,     45,       24,      16};

        System.out.println("Tri par ages");
        sortParAges(ages, prenoms);
        for (int i = 0; i < prenoms.length; i++) {
            System.out.println(prenoms[i] + "\t" + ages[i]);
        }
        System.out.println();

        System.out.println("Tri par prenoms");
        sortParPrenoms(prenoms, ages);
        for (int i = 0; i < prenoms.length; i++) {
            System.out.println(prenoms[i] + "\t" + ages[i]);
        }
    }

    // Il suffit d'adapter un des algorithmes de tri ;-)
    public static void sortParAges(int[] arr, String[] arr2) {
        for (int k = 0; k < arr.length - 1; k++) {
            for (int i = 0; i < arr.length - 1 - k; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    String temp2 = arr2[i];
                    arr[i] = arr[i+1];
                    arr2[i] = arr2[i+1];
                    arr[i+1] = temp;
                    arr2[i+1] = temp2;
                }
            }
        }
    }

    // Il suffit d'adapter un des algorithmes de tri ;-)
    public static void sortParPrenoms(String[] arr, int[] arr2) {
        for (int k = 0; k < arr.length - 1; k++) {
            for (int i = 0; i < arr.length - 1 - k; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    String temp = arr[i];
                    int temp2 = arr2[i];
                    arr[i] = arr[i+1];
                    arr2[i] = arr2[i+1];
                    arr[i+1] = temp;
                    arr2[i+1] = temp2;
                }
            }
        }
    }
}
