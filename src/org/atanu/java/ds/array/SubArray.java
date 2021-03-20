package org.atanu.java.ds.array;

public class SubArray {

    public static void findSubArray(int[] arr) {

        // Pick starting point
        for (int i = 0; i < arr.length; i++) {

            // Pick ending point
            for (int j = i; j < arr.length; j++) {

                // Print subarray between current starting
                // and ending points
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        findSubArray(arr);

    }

}
