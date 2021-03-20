package org.atanu.java.ds.sort;

public class MergeSort {


    // merge using only one auxiliary array
    public static void merge(int[] array, int start, int mid, int end) {

        // create a temp array
        int[] temp = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int i = start, j = mid + 1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while (i <= mid && j <= end) {
            if (array[i] <= array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];

        }

        // add elements left in the first interval
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // add elements left in the second interval
        while (j <= end) {
            temp[k++] = array[j++];
        }

        // copy temp to original interval

        for (int a = start; a <= end; a++) {
            array[a] = temp[a - start];
        }


    }

    public static void mergeUsingTwoarray(int[] array, int start, int mid, int end) {

        int n1 = mid - start + 1;
        int n2 = end - mid;

        /* Create temp arrays */
        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = array[start + i];

        for (int j = 0; j < n2; j++)
            right[j] = array[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;

        // Initial index of merged subarry array 
        int k = start;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                array[k++] = left[i++];
            else
                array[k++] = right[j++];
        }

        /* Copy remaining elements of left[] if any */
        while (i < n1) {
            array[k++] = left[i++];
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k++] = right[j++];
        }

    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2; // same as (start + end) / 2 , but avoids overflow
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            System.out.println(start + " " + mid + " " + end);
            merge(array, start, mid, end); // Using only One auxiliary array

            //mergeUsingTwoarray(array, start, mid, end); // Using Two array
        }
    }

    static void printArray(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {


        int arr[] = {64, 34, 25, 12, 22, 11, 90, 9};

        System.out.println("Unsorted Sorted array: ");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array after appying MergeSort: ");
        printArray(arr);

    }


}
