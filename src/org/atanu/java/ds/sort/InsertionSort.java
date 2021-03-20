package org.atanu.java.ds.sort;

public class InsertionSort {

    private static void insertionSort(int[] array) {

        int n = array.length;

        for (int i = 1; i < n; i++) {
            int hole = i;
            int value = array[i];

            while (hole > 0 && array[hole - 1] > value) {
                array[hole] = array[hole - 1];
                hole = hole - 1;
            }
            array[hole] = value;
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

        insertionSort(arr);

        System.out.println("Sorted array after appying InsertionSort: ");
        printArray(arr);

    }

}
