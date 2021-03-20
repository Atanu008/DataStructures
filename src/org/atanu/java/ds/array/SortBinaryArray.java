package org.atanu.java.ds.array;

import java.util.Arrays;

public class SortBinaryArray {

    private static void sortBinaryArraySol1(int[] a) {

        int countZero = 0;
        int n = a.length;

        // count number of 0's
        for (int i = 0; i < n; i++) {

            if (a[i] == 0)
                countZero++;
        }

        // put 0's in the beginning
        for (int j = 0; j < countZero; j++) {

            a[j] = 0;
        }

        // fill all remaining elements by 1
        for (int j = countZero; j < n; j++) {

            a[j] = 1;
        }


    }

    private static void sortBinaryArraySol2(int[] a) {

        int k = 0;

        for (int i = 0; i < a.length; i++) {

            // if current element is zero, put 0 at next free
            // position in the array
            if (a[i] == 0)
                a[k++] = 0;
        }

        // fill all remaining indices by 1
        for (int j = k; j < a.length; j++) {
            a[j] = 1;
        }

    }

    //This concept is related to partition of quick sort .
    //In quick sort� partition, after one scan, the left of array in smallest and right of array is largest of selected pivot element
    private static void sortBinaryArraySol3(int[] a) {

        int pivot = 1;
        int k = 0;

        // each time we encounter a 0, k is incremented and
        // 0 is placed before the pivot
        for (int i = 0; i < a.length; i++) {

            if (a[i] < pivot) {

                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;

                k++;
            }
        }

    }

    public static void main(String[] args) {
        int A[] = {0, 0, 1, 0, 1, 1, 0, 1, 0, 0};
        int B[] = {0, 0, 1, 0, 1, 1, 0, 1, 0, 0};
        int C[] = {0, 0, 1, 0, 1, 1, 0, 1, 0, 0};

        sortBinaryArraySol1(A);
        sortBinaryArraySol2(B);
        sortBinaryArraySol3(C);

        // print the rearranged array
        System.out.println(Arrays.toString(A));
        // print the rearranged array
        System.out.println(Arrays.toString(B));
        // print the rearranged array
        System.out.println(Arrays.toString(C));

    }


}
