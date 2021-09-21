package org.atanu.java.ds.binarysearch;

public class CircularArraySearch_LeetCode33 {

    public static int circularArraySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // if key is found, return its index
            if (arr[mid] == target) {
                return mid;
            }

            // if right half (A[mid..right]) is sorted and mid is not
            // the key element
            if (arr[mid] <= arr[high]) {

                // compare key with A[mid] and A[right] to know
                // if it lies in A[mid..right] or not
                if (target > arr[mid] && target <= arr[high]) {
                    // go searching in right sorted half
                    low = mid + 1;
                } else {
                    high = mid - 1; // go searching left
                }
            }

            // if left half (A[left..mid]) is sorted and mid is not
            // the key element
            else if (arr[mid] >= arr[low]) {

                // compare key with A[left] and A[mid] to know
                // if it lies in A[left..mid] or not
                if (target < arr[mid] && target >= arr[low]) {
                    // go searching in left sorted half
                    high = mid - 1;
                } else {
                    low = mid + 1; // go searching right
                }
            }
        }

        // key not found or invalid input
        return -1;

    }

    public static void main(String[] args) {
        int[] A = {9, 10, 2, 5, 6, 8};
        int key = 5;

        int index = circularArraySearch(A, key);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }

    }

}
