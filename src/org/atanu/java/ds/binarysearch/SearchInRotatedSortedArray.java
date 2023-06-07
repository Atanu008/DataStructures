package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
//LeetCode 33
// Video : https://www.youtube.com/watch?v=1uu3g_uu8O0

// Another Possible Solution : (My Intution . Need to give it a try)
// I beleive this can be acheived via another approach also
// (https://leetcode.com/problems/find-in-mountain-array/
// Binary find peak in the mountain (LeetCode 852. Peak Index in a Mountain Array)
// Binary find the target in strict increasing array
// Binary find the target in strict decreasing array

public class SearchInRotatedSortedArray {

    public static int search(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // if key is found, return its index
            if (arr[mid] == target) {
                return mid;
            }

            // if right half (A[mid..right]) is sorted and mid is not the key element
            // will check if it is in right sorted half , if there (target > arr[mid] && target <= arr[high])
            // then will search in that half only
            if (arr[mid] <= arr[high]) {

                // compare key with A[mid] and A[right] to know
                // if it lies in A[mid..right] or not
                if (target > arr[mid] && target <= arr[high]) { // target is within the sorted second half of the array
                    // go searching in right sorted half
                    low = mid + 1;
                } else {
                    high = mid - 1; // go searching left
                }
            }

            // if left half (A[left..mid]) is sorted and mid is not the key element
            // will check if it is in left sorted half , if there (target < arr[mid] && target >= arr[low])
            // then will search in that half only
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

        int index = search(A, key);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }

        A = new int[]{9, 12, 17, 2, 4, 5};
        key = 2;
        index = search(A, key);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }

}
