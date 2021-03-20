package org.atanu.java.ds.sort;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //swap(j , j + 1 , array); // Utility swap Method

                    // swap arr[j] and arr[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }

    }


    private static void swap(int i, int j, int[] array) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    static void printArray(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String[] args) {

        int arr[] = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Unsorted Sorted array: ");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Sorted array after appying BubbleSort: ");
        printArray(arr);

    }

}
