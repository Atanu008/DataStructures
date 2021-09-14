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
            if(nums[i] > maxEndingHere ){
                maxEndingHere = nums[i];
                begin = i;
            }
            // update result if current sub-array sum is found to be greater
            if(maxEndingHere > maxSoFar ){
                maxSoFar = maxEndingHere;
                start = begin;
                end = i;
            }

        }
        return Arrays.copyOfRange(nums, start, end + 1);
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int maxSum = new MaximumSubarray().maxSubArray(nums);
        int slice[] = new MaximumSubarray().printMaxSubArray(nums);
        System.out.print("The contiguous subarray with the largest sum "+ maxSum+" is " +
                Arrays.toString(slice));
    }
}
