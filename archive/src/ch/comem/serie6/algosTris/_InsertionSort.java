package ch.comem.serie6.algosTris;

import java.util.Arrays;

// Pour les détails du fonctionnement : https://fr.wikipedia.org/wiki/Tri_par_insertion
// Code adapté de : https://www.techiedelight.com/insertion-sort-iterative-recursive/
public class _InsertionSort {

    // Function to perform insertion sort on `arr[]`
    public static void sort(int[] arr)
    {
        // Start from the second element
        // (the element at index 0 is already sorted)
        for (int i = 1; i < arr.length; i++)
        {
            int value = arr[i];
            int j = i;

            // find index `j` within the sorted subset `arr[0…i-1]`
            // where element `arr[i]` belongs
            while (j > 0 && arr[j - 1] > value)
            {
                arr[j] = arr[j - 1];
                j--;
            }

            // note that the subarray `arr[j…i-1]` is shifted to
            // the right by one position, i.e., `arr[j+1…i]`

            arr[j] = value;
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {22, 21, 11, 15, 16};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}