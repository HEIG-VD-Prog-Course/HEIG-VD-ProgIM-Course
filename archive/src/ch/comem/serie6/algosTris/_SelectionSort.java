package ch.comem.serie6.algosTris;

import java.util.Arrays;

// Pour les détails du fonctionnement : https://fr.wikipedia.org/wiki/Tri_par_sélection
// Code adapté de https://favtutor.com/blogs/sorting-algorithms-java
public class _SelectionSort {

    public static void sort(int arr[])
    {
        int pos;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            pos = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[pos]) {                  //find the index of the minimum element
                    pos = j;
                }
            }

            temp = arr[pos];            //swap the current element with the minimum element
            arr[pos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String args[])
    {
        int arr[] = {64,25,12,22,11};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
