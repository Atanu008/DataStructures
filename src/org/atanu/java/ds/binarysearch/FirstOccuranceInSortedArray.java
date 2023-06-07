package org.atanu.java.ds.binarysearch;

public class FirstOccuranceInSortedArray {

    public static int findFirstOccuranceInSortedArray(int[] arr, int x) {
        // search space is A[left..right]
        int low = 0;
        int high = arr.length - 1;
        // initialize the result by -1
        int result = -1;

        // iterate till search space contains at-least one element
        while (low <= high) {
            // find the mid value in the search space and
            // compares it with key value
            int mid = (high + low) / 2;
            // if key is found, update the result and
            // go on searching towards left (lefter indices)
            if (x == arr[mid]) {
                result = mid;
                high = mid - 1;
            }
            // if key is less than the mid element, discard right half
            else if (x < arr[mid]) {
                high = mid - 1;
            }
            // if key is more than the mid element, discard left half
            else {
                low = mid + 1;
            }
        }
        // return the leftmost index or -1 if the element is not found
        return result;
    }

    public static int findFirstOccuranceInSortedArray_v2(int[] arr, int x) {
        // search space is A[left..right]
        int low = 0;
        int high = arr.length - 1;
        // iterate till search space contains at-least one element
        while (low < high) {
            // find the mid value in the search space and
            // compares it with key value
            int mid = (high + low) / 2;

            // if key is greater than the mid element, discard left half
            if (x > arr[mid]) {
                low = mid + 1;
            }
            // if key <= mid element, discard Right half, search Left
            else {
                high = mid;
            }
        }
        // return the leftmost index or -1 if the element is not found
        return high;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 5};

        System.out.println(findFirstOccuranceInSortedArray(arr, 3));
        System.out.println(findFirstOccuranceInSortedArray_v2(arr, 3));

    }

}
