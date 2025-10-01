package ch.comem.serie6;

import java.util.Random;

// Insertion d'un élément dans un tableau de manière à ce que le tableau soit toujours trié par ordre croissant
public class Exercice4 {

    public static void main(String[] args) {
        int[] tab = new int[20];
        int nbElemDansTab = 0;
        Random generateurAleatoire = new Random();
        for (int noElem = 1; noElem <= tab.length; noElem++) {
            int element = generateurAleatoire.nextInt(100) + 1;
            System.out.print("insertion de " + element + " => ");
            insereElement(tab, element, nbElemDansTab);
            nbElemDansTab++;
            afficheTab(tab, nbElemDansTab);
        }
    }

    public static void afficheTab(int[] tab, int nbElemDansTab) {
        for (int i = 0; i < nbElemDansTab; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    public static void insereElement(int tab[], int element, int nbElemDansTab) {
        int indexInsertion = binarySearch(tab, 0, nbElemDansTab, element);
        if (indexInsertion < nbElemDansTab) {
            decale(tab, indexInsertion, nbElemDansTab);
        }
        tab[indexInsertion] = element;
    }

    public static void decale(int tab[], int indexDebut, int indexFin) {
        for (int i = indexFin; i > indexDebut; i--) {
            //System.out.println("decalage de " + (i - 1) + " vers " + i);
            tab[i] = tab[i - 1];
        }
    }

    public static int binarySearch(int arr[], int first, int last, int key) {
        int index;
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (last < 0) {
            index = 0;
        } else {
            if (first < last) {
                index = first;
                if (arr[first] < key) {
                    index--;
                }
            } else {
                index = last;
                if (first<arr.length) {
                    if (arr[first] > key) {
                        index++;
                    }
                }
            }
        }
        //System.out.println("Debug : index : " + index + ", first : " + first + ", last : " + last);
        return index;
    }
}