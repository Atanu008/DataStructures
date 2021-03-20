package org.atanu.java.ds.array;

import java.util.Arrays;

public class DutchNationalFlagLeetCode75 {

    public static void dutchNationalFlagSol1(int[] arr) {

        int zeros = 0;
        int ones = 0;
        int twos = 0;

        // Count Zeros , Ones and Two
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                zeros++;
            if (arr[i] == 1)
                ones++;
            if (arr[i] == 2)
                twos++;

        }
        // Scan teh array again and place the numbers
        for (int i = 0; i < arr.length; i++) {

            if (i < zeros) {
                arr[i] = 0;
            }

            if (i >= zeros && i < (zeros + ones)) {
                arr[i] = 1;
            }


            if (i >= (zeros + ones) && i < (zeros + ones + twos)) {
                arr[i] = 2;
            }
        }


    }

    // Variation of Quick Sort
    public static void dutchNationalFlagSol2(int[] arr) {

        int start = 0; // will place zeros from start Index.
        int end = arr.length - 1; // will place two from end Index
        int mid = 0; // forward moving pointer

        int pivot = 1; // Chosen One because for this requirement only

        while (mid <= end) {

            //For the Case of Zero . swap zero in start and forward the flow
            if (arr[mid] < pivot) {
                swap(arr, mid, start);
                start++;
                mid++;
            }

            // For Case One . Do nothing . Just forward the pointer
            else if (arr[mid] == pivot) {
                mid++;
            }

            // For Case Two . swap mid to end. But dont increment the mid.
            // After swap arr[mid] can either be 0,1
            // we will not move mid as the swapped value can be 0 or 1(less than Or Equal to Pivot)
            else if (arr[mid] > pivot) { // Can use else also

                swap(arr, mid, end);
                end--;
            }
        }

    }

    private static void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 0, 1, 1, 2, 0, 0, 2, 1, 0};

        dutchNationalFlagSol1(arr);

        System.out.println(Arrays.toString(arr));

        int[] a = {0, 1, 2, 0, 1, 1, 2, 0, 0, 2, 1, 0};

        dutchNationalFlagSol2(a);

        System.out.println(Arrays.toString(a));


    }

}
