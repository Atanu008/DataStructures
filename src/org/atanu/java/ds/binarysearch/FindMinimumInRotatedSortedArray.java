package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Leetcode 153
public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] arr) {

        int length = arr.length;
        int low = 0;
        int high = arr.length - 1;

        // iterate till search space contains at-least one element
        while (low <= high) {
            // if the search space is already sorted, we have
            // found the minimum element (at index left)
            if (arr[low] <= arr[high]) {
                return low;
            }
            int mid = low + (high - low)/2;
            // find next and previous element of the mid element
            // (in circular manner)
            int next = (mid + 1) % length;
            int prev = (mid - 1 + length) % length;
            //Now we need to keep Searching in Unsorted part of the array. will ignore the sorted part

            // if mid element is less than both its next and previous
            // neighbor, then it is the minimum element of the array
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }
            // if A[mid..right] is sorted and mid is not the min element,
            // then pivot element cannot be present in A[mid..right] and
            // we can discard A[mid..right] and search in the left half
            else if (arr[mid] <= arr[high]) {
                high = mid - 1;
            }
            // if A[left..mid] is sorted then pivot element cannot be
            // present in it and we can discard A[left..mid] and search
            // in the right half
            else if (arr[mid] >= arr[low]) {
                low = mid + 1;
            }
        }
        // invalid input
        return -1;
    }


    public static void main(String[] args) {

        int[] A = {8, 9, 10, 12, 1, 2, 3, 4, 5, 6, 7};

        System.out.println("The array is rotated " + findMin(A) + " times");

    }

}
