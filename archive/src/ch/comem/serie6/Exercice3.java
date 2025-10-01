package ch.comem.serie6;

import java.util.Random;
import ch.comem.serie6.algosTris.*;

public class Exercice3 {
    
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

        final int NB_TRIS = 10; // nb tris par algorithme
        final int NB_ELEMENTS = 50000;
        long totalTempsEnMillis = 0;
        long tempsEnMillis;

        for (int noTri = 1; noTri <= NB_TRIS; noTri++) {
            int tab[] = rendTab(NB_ELEMENTS, 1, NB_ELEMENTS);
            long t1 = System.currentTimeMillis();
            _DualPivotQuickSort.sort(tab);
            long t2 = System.currentTimeMillis();
            tempsEnMillis = t2 - t1;
            totalTempsEnMillis += tempsEnMillis;
            System.out.print(".");
        }
        System.out.println();
        System.out.println("Temps moyen pour un tri rapide : " +
                totalTempsEnMillis / NB_TRIS / 1000d + "[s]");

        for (int noTri = 1; noTri <= NB_TRIS; noTri++) {
            int tab[] = rendTab(NB_ELEMENTS, 1, NB_ELEMENTS);
            long t1 = System.currentTimeMillis();
            _MergeSort.sort(tab);
            long t2 = System.currentTimeMillis();
            tempsEnMillis = t2 - t1;
            totalTempsEnMillis += tempsEnMillis;
            System.out.print(".");
        }
        System.out.println();
        System.out.println("Temps moyen pour un tri par fusion : " +
                totalTempsEnMillis / NB_TRIS / 1000d + "[s]");

        for (int noTri = 1; noTri <= NB_TRIS; noTri++) {
            int tab[] = rendTab(NB_ELEMENTS, 1, NB_ELEMENTS);
            long t1 = System.currentTimeMillis();
            _HeapSort.sort(tab);
            long t2 = System.currentTimeMillis();
            tempsEnMillis = t2 - t1;
            totalTempsEnMillis += tempsEnMillis;
            System.out.print(".");
        }
        System.out.println();
        System.out.println("Temps moyen pour un tri par tas : " +
                totalTempsEnMillis / NB_TRIS / 1000d + "[s]");

        for (int noTri=1; noTri<=NB_TRIS; noTri++) {
            int tab[] = rendTab(NB_ELEMENTS, 1, NB_ELEMENTS);
            long t1 = System.currentTimeMillis();
            _InsertionSort.sort(tab);
            long t2 = System.currentTimeMillis();
            tempsEnMillis = t2 - t1;
            totalTempsEnMillis+=tempsEnMillis;
            System.out.print(".");
        }
        System.out.println();
        System.out.println("Temps moyen pour un tri par insertion : " +
                totalTempsEnMillis/NB_TRIS/1000d + "[s]");

        for (int noTri = 1; noTri <= NB_TRIS; noTri++) {
            int tab[] = rendTab(NB_ELEMENTS, 1, NB_ELEMENTS);
            long t1 = System.currentTimeMillis();
            _SelectionSort.sort(tab);
            long t2 = System.currentTimeMillis();
            tempsEnMillis = t2 - t1;
            totalTempsEnMillis += tempsEnMillis;
            System.out.print(".");
        }
        System.out.println("");
        System.out.println("Temps moyen pour un tri par sélection : " +
                totalTempsEnMillis / NB_TRIS / 1000d + "[s]");

        for (int noTri = 1; noTri <= NB_TRIS; noTri++) {
            int tab[] = rendTab(NB_ELEMENTS, 1, 100);
            long t1 = System.currentTimeMillis();
            _BubbleSort.sort(tab);
            long t2 = System.currentTimeMillis();
            tempsEnMillis = t2 - t1;
            totalTempsEnMillis += tempsEnMillis;
            System.out.print(".");
        }
        System.out.println();
        System.out.println("Temps moyen pour un tri à bulles : " +
                totalTempsEnMillis / NB_TRIS / 1000d + "[s]");
        System.out.println();
    }

    public static int[] rendTab(int nbElements, int valMin, int valMax) {
        int[] tab = new int[nbElements];
        int nbPossibilites = valMax - valMin + 1;
        Random generateurAleatoire = new Random();
        for (int i = 0; i < tab.length; i++) {
            tab[i] = generateurAleatoire.nextInt(nbPossibilites) + valMin;
        }
        return tab;
    }
}
