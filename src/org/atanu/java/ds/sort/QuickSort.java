package org.atanu.java.ds.sort;

public class QuickSort {

    private static int partition(int[] array, int start, int end) {

        int pIndex = start;
        int pivot = array[end]; //make the last element as pivot element.
		
		
		/*rearrange the array by putting elements which are less than pivot
	       on one side(left) and which are greater that on other(right). */
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                swap(i, pIndex, array);
                pIndex++;
            }

        }
        swap(end, pIndex, array); //put the pivot element in its proper place.

        return pIndex; //return the position of the pivot
    }

    public static void quickort(int[] array, int start, int end) {
        if (start < end) {
            int partionIndex = partition(array, start, end); //stores the position of pivot element
            quickort(array, start, partionIndex - 1);   //sorts the left side of pivot.
            quickort(array, partionIndex + 1, end); //sorts the right side of pivot.
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


        int arr[] = {64, 34, 25, 12, 22, 11, 90, 34};

        System.out.println("Unsorted Sorted array: ");
        printArray(arr);

        quickort(arr, 0, arr.length - 1);

        System.out.println("Sorted array after appying QuickSort: ");
        printArray(arr);

    }

}
