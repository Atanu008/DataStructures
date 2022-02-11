package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
//LeetCode 81

//https://www.educative.io/courses/grokking-the-coding-interview/RMPVM2Y4PW0
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Best Case : if key is found, return its index.
            if (arr[mid] == target) {
                return true;
            }

            //If low , Mid and High is same then we can not decide what to pick. move the duplicate pointers.
            //we will not loose any value as as these values are not same as key/target

            // the only difference from the previous solution,
            // if numbers at indexes start, mid, and end are same, we can't choose a side
            // the best we can do, is to skip one number from both ends as key != arr[mid]
            if( (arr[low] == arr[mid]) && (arr[high] == arr[mid]) ) {++low; --high;}
            // if right half (A[mid..right]) is sorted and mid is not
            // the key element
            else if (arr[mid] <= arr[high]) {

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
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};

        int key = 0;

        boolean index = new SearchInRotatedSortedArrayII().search(nums, key);

        System.out.println("Element found  " + index);
    }
}
