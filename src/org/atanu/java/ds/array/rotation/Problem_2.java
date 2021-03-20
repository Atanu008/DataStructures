package org.atanu.java.ds.array.rotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author atanu
 * https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
 */
public class Problem_2 {

    /*
     * Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
     *
     */


    /*Algorithm:
     *
     * rotate(arr[], d, n)
       reverse(arr[], 1, d) ;
       reverse(arr[], d + 1, n);
         reverse(arr[], 1, n);
       Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is :

       Reverse A to get ArB, where Ar is reverse of A.
       Reverse B to get ArBr, where Br is reverse of B.
       Reverse all to get (ArBr) r = BA.
     *
     *
     *
     */
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Original Array");
        printArray(arr);

        leftRotateMethod_5(arr, 2);
        System.out.println("\nPrinting Array Method 1");
        printArray(arr);

    }

    public static void leftRotateMethod_5(int[] arr, int NoOfshiftingElements) {
        reverseArray(arr, 0, NoOfshiftingElements - 1);
        reverseArray(arr, NoOfshiftingElements, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);
    }

    static void reverseArray(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;

        }
    }

    public static void printArray(int arr[]) {
        for (int d : arr) {
            System.out.print(d + "  ");
        }
    }

}
