package ch.comem.serie6.algosTris;

import java.util.Arrays;

// Pour les détails du fonctionnement : https://fr.wikipedia.org/wiki/Tri_à_bulles
// Code adapté de : https://www.techiedelight.com/bubble-sort-iterative-recursive/
public class _BubbleSort {

    // Utility function to swap values at two indices in the array
    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to perform bubble sort on a given array `arr[]`
    public static void sort(int[] arr)
    {
        // `n-1` passes where `n` is the array's length
        for (int k = 0; k < arr.length - 1; k++)
        {
            // last `k` items are already sorted, so the inner loop can
            // avoid looking at the last `k` items
            for (int i = 0; i < arr.length - 1 - k; i++)
            {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }

            // the algorithm can be terminated if the inner loop
            // didn't do any swap
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {6, 4, 5, 12, 2, 11, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}