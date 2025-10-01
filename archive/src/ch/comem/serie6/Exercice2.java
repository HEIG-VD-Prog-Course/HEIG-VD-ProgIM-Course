package ch.comem.serie6;

import ch.comem.Clavier;

public class Exercice2 {
    
    // Règle les éventuels problèmes d'affichage des accents
    static {
        try {
            System.setOut(new java.io.PrintStream(
                    new java.io.FileOutputStream(java.io.FileDescriptor.out), true, "UTF-8"));
            
        } catch (java.io.UnsupportedEncodingException ex) {
            System.out.println("VM dont support UTF-8");
        }
    }
    
    private static final int NB_ELEMENTS = 300000;
    
    public static void main(String[] args) {
        calculeEtAfficheResultatsAvecAlgoBasique();

        System.out.println("Par contre, les recherches avec l'algorithme de recherche dichotomique sont super rapide !");
        System.out.println("Tapez sur la touche ENTER pour vous en rendre compte");
        Clavier.rend_String("");

        calculeEtAfficheResultatsAvecAlgoRechercheDichotomique();
    }

    public static int[] rendTab(int nbElements) {
        int[] tab = new int[nbElements];
        for (int i=1; i<=tab.length; i++) {
            tab[i-1] = i;
        }
        return tab;
    }

    public static void calculeEtAfficheResultatsAvecAlgoBasique() {
        int[] tab = rendTab(NB_ELEMENTS);
        int max = 0;
        int min = NB_ELEMENTS;
        long total = 0;
        int nbRecherches;
        System.out.println("Patience ! Les recherches dans un tableau avec l'algorithme basique sont longues...");
        long t1 = System.currentTimeMillis();
        for (int i=1; i<=NB_ELEMENTS; i++) {
            nbRecherches = rendNbRecherchesNormal(tab, i);
            total+=nbRecherches;
            if (nbRecherches>max) {
                max = nbRecherches;
            }
            if (nbRecherches<min) {
                min = nbRecherches;
            }
            if (i%10000==0) {
                System.out.print(".");
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Pour un tableau de " + NB_ELEMENTS + " éléments (triés ou non) avec l'algorithme basique : " );
        System.out.println("Le nombre de recherches minimum pour trouver un élément : " + min);
        System.out.println("Le nombre de recherches moyen pour trouver un élément : " + total/NB_ELEMENTS);
        System.out.println("le nombre de recherches max pour trouver un élément : " + max);
        System.out.println("Le temps pour rechercher " + NB_ELEMENTS + " éléments a pris : " + (t2-t1)/1000d + "[s]");
        System.out.println();
    }

    private static void calculeEtAfficheResultatsAvecAlgoRechercheDichotomique() {
        int[] tab = rendTab(NB_ELEMENTS);
        int max = 0;
        int min = NB_ELEMENTS;
        long total = 0;
        int nbRecherches;
        long t1 = System.currentTimeMillis();
        for (int i=1; i<=NB_ELEMENTS; i++) {
            nbRecherches = rendNbRecherchesDichotomique(tab, i);
            total+=nbRecherches;
            if (nbRecherches>max) {
                max = nbRecherches;
            }
            if (nbRecherches<min) {
                min = nbRecherches;
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Pour un tableau de " + NB_ELEMENTS + " éléments triés avec l'algorithme de recherche dichotomique : " );
        System.out.println("Le nombre de recherches minimum pour trouver un élément : " + min);
        System.out.println("Le nombre de recherches moyen pour trouver un élément : " + total/NB_ELEMENTS);
        System.out.println("le nombre de recherches max pour trouver un élément : " + max);
        System.out.println("Le temps pour rechercher " + NB_ELEMENTS + " éléments a pris : " + (t2-t1)/1000d + "[s]");
        System.out.println("Mais le tableau doit être trié ;-)");
    }

    public static int rendNbRecherchesNormal(int[] arr, int value) {
        int index = -1;
        int nbRecherches = 0;
        boolean found;
        do {
            nbRecherches++;
            index++;
            found = arr[index] == value;
        } while (!found && index<arr.length-1);
        return nbRecherches;
    }

    public static int rendNbRecherchesDichotomique(int[] arr, int value) {
        int nbRecherches = 0;
        int start = 0;
        int end = arr.length - 1;
        boolean stop = false;
        int mid;
        do {
            mid = (start + end) / 2;
            nbRecherches++;
            if (arr[mid] > value) {
                end = mid - 1;
            } else if (arr[mid] < value) {
                start = mid + 1;
            } else {
                stop = true;
            }
        } while (start <= end && !stop);
        return nbRecherches;
    }
}
