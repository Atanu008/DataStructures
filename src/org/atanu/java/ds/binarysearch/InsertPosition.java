package org.atanu.java.ds.binarysearch;


public class InsertPosition {

    public static int insertPosition(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            //If Item Found return the index
            if (arr[mid] == target) {
                return mid;
            }

            // Search left if the target is smaller than mid
            if (target < arr[mid]) {

                high = mid - 1;
            }

            // Search right if the target is larger than mid
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90, 100, 130,
                140, 160, 170};

        int target = 165;

        System.out.println("Insert position of " + target + "  is " + insertPosition(arr, target));


    }

}
