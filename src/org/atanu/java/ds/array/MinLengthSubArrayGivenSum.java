package org.atanu.java.ds.array;

public class MinLengthSubArrayGivenSum {

    public static int minLengthSubArrayGreaterThanK(int[] arr, int k) {

        int minLength = Integer.MAX_VALUE;

        // Iterate for every Item
        for (int i = 0; i < arr.length; i++) {

            int sum = 0;


            for (int j = i; j < arr.length; j++) {

                // Calculate the sub Array starting from i
                sum += arr[j];

                // If the sum is greater than K and length is min the update minLength
                if (sum > k && (j - i + 1) < minLength) {

                    minLength = j - i + 1;

                }

            }

        }
        // Return Min Length
        return minLength;
    }

    public static int minLengthSubArrayGreaterThanKSol2(int[] arr, int k) {

        // stores the result
        int minLength = Integer.MAX_VALUE;
        // stores window's starting index
        int left = 0;
        // stores the current window sum
        int windowSum = 0;

        // maintain a sliding window [left..right]
        for (int right = 0; right < arr.length; right++) {
            // include current element in the window
            windowSum += arr[right];

            // window becomes unstable if its sum becomes more than k
            while (windowSum > k && left <= right) {

                // update the result if current window's length is less
                // than minimum found so far
                minLength = Math.min(minLength, right - left + 1);

                // remove elements from the window's left side till window
                // becomes stable again
                windowSum -= arr[left];
                left++;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {

        // array of positive numbers
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 21;

        // find length of the smallest sub-array
        //int len = minLengthSubArrayGreaterThanK(A, k);
        int len = minLengthSubArrayGreaterThanKSol2(A, k);

        if (len != Integer.MAX_VALUE) {
            System.out.print("Smallest sub-array length is " + len);
        } else {
            System.out.print("No sub-array exists");
        }
    }

}
