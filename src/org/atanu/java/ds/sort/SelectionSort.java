package org.atanu.java.ds.sort;

public class SelectionSort {


    private static void selectionSort(int[] array) {

        int n = array.length;
        int min_index = 0;
        for (int i = 0; i < n - 1; i++) {
            min_index = i;

            for (int j = i + 1; j < n; j++) {

                if (array[min_index] > array[j]) {
                    min_index = j;
                }
            }
            //System.out.println(min_index);

            swap(i, min_index, array);
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

        selectionSort(arr);

        System.out.println("Sorted array after appying SelectionSort: ");
        printArray(arr);

    }


}
