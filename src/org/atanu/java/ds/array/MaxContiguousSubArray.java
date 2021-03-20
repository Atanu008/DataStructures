package org.atanu.java.ds.array;

public class MaxContiguousSubArray {

    // Time Complexity O(n2)
    public static void maxContiguousSubArray(int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        int firstIndex = -1;
        int lastIndex = -1;

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                // Update Sum for each sub Array
                sum += arr[j];

                // Update the sum if it is greater than the sum
                if (sum > maxSum) {
                    maxSum = sum;
                    firstIndex = i;
                    lastIndex = j;

                }
            }
        }

        System.out.println("Maximum Sum is  " + maxSum + "  [ " + firstIndex + " , " + lastIndex + " ]");
    }

    public static int maxContiguousSubArrayKadane(int[] A) {

        // stores maximum sum sub-array found so far
        int maxSoFar = A[0];

        // stores maximum sum of sub-array ending at current position
        int maxEndingHere = A[0];

        for (int i = 1; i < A.length; i++) {

            // update maximum sum of sub-array "ending" at index i (by adding
            // current element to maximum sum ending at previous index i-1)
            maxEndingHere = maxEndingHere + A[i];

            // Update maxEndingHere as current element can be greater if the previous elements are negative
            maxEndingHere = Math.max(maxEndingHere, A[i]);

            // update result if current sub-array sum is found to be greater
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {

        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        maxContiguousSubArray(A);

        System.out.println("Maximum sum is " + maxContiguousSubArrayKadane(A));
    }

}
