package ch.comem.serie6.algosTris;

import java.util.Arrays;

// Pour les détails du fonctionnement : https://fr.wikipedia.org/wiki/Tri_rapide
// Code adapté de : https://www.geeksforgeeks.org/dual-pivot-quicksort/
public class _DualPivotQuickSort {

    public static void sort(int[] arr) {
        dualPivotQuickSort(arr, 0, arr.length-1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void dualPivotQuickSort(int[] arr,
                                   int low, int high) {
        if (low < high) {

            // piv[] stores left pivot and right pivot.
            // piv[0] means left pivot and
            // piv[1] means right pivot
            int[] piv;
            piv = partition(arr, low, high);

            dualPivotQuickSort(arr, low, piv[0] - 1);
            dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
            dualPivotQuickSort(arr, piv[1] + 1, high);
        }
    }

    private static int[] partition(int[] arr, int low, int high) {
        if (arr[low] > arr[high])
            swap(arr, low, high);

        // p is the left pivot, and q
        // is the right pivot.
        int j = low + 1;
        int g = high - 1, k = low + 1,
                p = arr[low], q = arr[high];

        while (k <= g) {

            // If elements are less than the left pivot
            if (arr[k] < p) {
                swap(arr, k, j);
                j++;
            }

            // If elements are greater than or equal
            // to the right pivot
            else if (arr[k] >= q) {
                while (arr[g] > q && k < g)
                    g--;

                swap(arr, k, g);
                g--;

                if (arr[k] < p) {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        // Bring pivots to their appropriate positions.
        swap(arr, low, j);
        swap(arr, high, g);

        // Returning the indices of the pivots
        // because we cannot return two elements
        // from a function, we do that using an array.
        return new int[]{j, g};
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {6, 4, 5, 12, 2, 11, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}