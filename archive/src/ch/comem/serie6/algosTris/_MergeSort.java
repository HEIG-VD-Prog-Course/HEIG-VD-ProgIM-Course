package ch.comem.serie6.algosTris;

import java.util.Arrays;

// Pour les détails du fonctionnement : https://fr.wikipedia.org/wiki/Tri_fusion
// Code adapté de : https://favtutor.com/blogs/sorting-algorithms-java
public class _MergeSort {
    private static void merge(int arr[], int left, int middle, int right) {
        int low = middle - left + 1;                    //size of the left subarray
        int high = right - middle;                      //size of the right subarray

        int l[] = new int[low];                         //create the left and right subarray
        int r[] = new int[high];

        int i = 0, j = 0;

        for (i = 0; i < low; i++) {                               //copy elements into left subarray{
            l[i] = arr[left + i];
        }
        for (j = 0; j < high; j++) {                       //copy elements into right subarray
            r[j] = arr[middle + 1 + j];
        }

        int k = left;                                      //get starting index for sort
        i = 0;                                             //reset loop variables before performing merge
        j = 0;

        while (i < low && j < high)                       //merge the left and right subarrays
        {
            if (l[i] <= r[j])
            {
                arr[k] = l[i];
                i++;
            }
            else
            {
                arr[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < low)                             //merge the remaining elements from the left subarray
        {
            arr[k] = l[i];
            i++;
            k++;
        }

        while (j < high)                           //merge the remaining elements from right subarray
        {
            arr[k] = r[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int arr[], int left, int right)       //helper function that creates the sub cases for sorting
    {
        int middle;
        if (left < right) {                                            //sort only if the left index is lesser than the right index (meaning that sorting is done)
            middle = (left + right) / 2;

            mergeSort(arr, left, middle);                              //left subarray
            mergeSort(arr, middle + 1, right);                     //right subarray
            merge(arr, left, middle, right);                          //merge the two subarrays
        }
    }
    
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String args[])
    {
        int arr[] = { 9, 3, 1, 5, 13, 12 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}