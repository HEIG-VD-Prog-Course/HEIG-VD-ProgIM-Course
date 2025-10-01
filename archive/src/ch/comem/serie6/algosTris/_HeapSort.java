package ch.comem.serie6.algosTris;

import java.util.Arrays;

// Pour les détails du fonctionnement : https://fr.wikipedia.org/wiki/Tri_par_tas
// Code adapté de : https://favtutor.com/blogs/sorting-algorithms-java
public class _HeapSort {
    public static void sort(int arr[])
    {
        int temp;

        for (int i = arr.length / 2 - 1; i >= 0; i--)                //build the heap
        {
            heapify(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i > 0; i--)                            //extract elements from the heap
        {
            temp = arr[0];                                                  //move current root to end (since it is the largest)
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);                                             //recall heapify to rebuild heap for the remaining elements
        }
    }

    private static void heapify(int arr[], int n, int i)
    {
        int max= i; // Initialize largest as root
        int left = 2 * i + 1; //index of the left child of ith node = 2*i + 1
        int right = 2 * i + 2; //index of the right child of ith node  = 2*i + 2
        int temp;

        if (left < n && arr[left] > arr[max])            //check if the left child of the root is larger than the root
        {
            max= left;
        }

        if (right < n && arr[right] > arr[max])            //check if the right child of the root is larger than the root
        {
            max= right;
        }

        if (max!= i)
        {                                               //repeat the procedure for finding the largest element in the heap
            temp = arr[i];
            arr[i] = arr[max];
            arr[max]= temp;
            heapify(arr, n, max);
        }
    }

    public static void main(String args[])
    {
        int arr[] = { 1, 12, 9 , 3, 10, 15 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
