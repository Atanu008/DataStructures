package org.atanu.java.ds.twopointer;

public class MaximumSumSubarrayOfSizeK {
    //Brute Force
    //A basic brute force solution will be to calculate the sum of all ‘k’ sized subarrays
    // of the given array to find the subarray with the highest sum.
    // We can start from every index of the given array and add the next ‘k’ elements to find the subarray’s sum
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0, windowSum;
        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }


    //Sliding Window
    public static int findMaxSumSubArrayV2(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k -1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSumSubarrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSumSubarrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));

        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSumSubarrayOfSizeK.findMaxSumSubArrayV2(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSumSubarrayOfSizeK.findMaxSumSubArrayV2(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
