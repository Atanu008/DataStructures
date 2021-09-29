package org.atanu.java.ds.array;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-subarray/
//LeetCode 53
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // stores maximum sum sub-array found so far
        int maxSoFar = nums[0];
        // stores maximum sum of sub-array ending at current position
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // update maximum sum of sub-array "ending" at index i (by adding
            // current element to maximum sum ending at previous index i-1)
            maxEndingHere = maxEndingHere + nums[i];
            // Update maxEndingHere as current element can be greater if the previous elements are negative
            maxEndingHere = Math.max(maxEndingHere, nums[i]);
            // update result if current sub-array sum is found to be greater
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public int maxSubArrayV2(int[] nums) {
        // stores maximum sum sub-array found so far
        int maxSoFar = Integer.MIN_VALUE;
        // stores maximum sum of sub-array ending at current position
        int maxEndingHere = 0;
        for (int i = 0; i < nums.length; i++) {
            // update maximum sum of sub-array "ending" at index i (by adding
            // current element to maximum sum ending at previous index i-1)
            maxEndingHere = maxEndingHere + nums[i];
            // Update maxEndingHere as current element can be greater if the previous elements are negative
            maxEndingHere = Math.max(maxEndingHere, nums[i]);
            // update result if current sub-array sum is found to be greater
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public int[] printMaxSubArray(int[] nums) {
        // stores endpoints of maximum sum subarray found so far
        int start = 0, end = 0;
        // stores starting index of a positive-sum sequence
        int begin = 0;

        // stores maximum sum sub-array found so far
        int maxSoFar = Integer.MIN_VALUE;
        // stores maximum sum of sub-array ending at current position
        int maxEndingHere = 0;
        for (int i = 0; i < nums.length; i++) {
            // update maximum sum of sub-array "ending" at index i (by adding
            // current element to maximum sum ending at previous index i-1)
            maxEndingHere = maxEndingHere + nums[i];
            // Update maxEndingHere as current element can be greater if the previous elements are negative
            if (nums[i] > maxEndingHere) {
                maxEndingHere = nums[i];
                begin = i;
            }
            // update result if current sub-array sum is found to be greater
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = begin;
                end = i;
            }

        }
        return Arrays.copyOfRange(nums, start, end + 1);
    }

    // Function to find the maximum sum of a contiguous subarray
    // in a given integer array
    public  int kadane(int[] A) {
        // find the maximum element present in a given array
        int max = Arrays.stream(A).max().getAsInt();

        // if the array contains all negative values, return the maximum element
        if (max < 0) {
            return max;
        }

        // stores the maximum sum subarray found so far
        int maxSoFar = 0;

        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;

        // do for each element of the given array
        for (int i : A) {
            // update the maximum sum of subarray "ending" at index `i` (by adding the
            // current element to maximum sum ending at previous index `i-1`)
            maxEndingHere = maxEndingHere + i;

            // if the maximum sum is negative, set it to 0 (which represents
            // an empty subarray)
            maxEndingHere = Integer.max(maxEndingHere, 0);

            // update the result if the current subarray sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = new MaximumSubarray().maxSubArray(nums);
        int slice[] = new MaximumSubarray().printMaxSubArray(nums);
        int maxSumKadane = new MaximumSubarray().kadane(nums);
        System.out.println("Kadane Max Sum "+ maxSumKadane);
        System.out.print("The contiguous subarray with the largest sum " + maxSum + " is " +
                Arrays.toString(slice));
    }
}
