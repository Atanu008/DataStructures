package org.atanu.java.ds.binarysearch;

public class PeakElement {

    //Time Comlexity O(n). Linear Search
    public static void findPeakElementSol1(int[] arr) {

        int first = arr[0];
        int last = arr[arr.length - 1];

        if (arr.length > 2 && first > arr[1])
            System.out.println(first);
        if (arr.length > 2 && last > arr[arr.length - 2])
            System.out.println(last);

        for (int i = 1; i < arr.length - 1; i++) {

            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
                System.out.println("Peak Element is " + arr[i]);
        }
    }

    public static int findPeakElementSol2(int[] A, int low, int high) {

        int mid = low + (high - low) / 2;

        // check if mid element is greater than its neighbors
        if ((mid == 0 || A[mid - 1] <= A[mid]) &&
                (mid == A.length - 1 || A[mid + 1] <= A[mid])) {
            return mid;
        }

        // If middle element is not peak and its left neighbor is
        // greater than it,then left half must have a peak element
        if (mid > 0 && A[mid - 1] > A[mid]) {
            return findPeakElementSol2(A, low, mid - 1);
        }

        // If middle element is not peak and its right neighbor
        // is greater than it, then right half must have a peak
        // element
        return findPeakElementSol2(A, mid + 1, high);

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 4, 1, 0};
        //	int arr[] = {1, 3, 5, 10, 9, 20};

        findPeakElementSol1(arr);

        int index = findPeakElementSol2(arr, 0, arr.length - 1);

        System.out.println("Peak Element is " + arr[index]);

    }

}
