package org.atanu.java.ds.dp;

//https://leetcode.com/problems/longest-increasing-subsequence/
//LeetCode 300
//Coding Minute
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        //Base Case. For one element Subsequence is always one
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            //Base Case. For one element Subsequence is always one
            dp[i] = 1;
            //Check for all previous elements.
            //If (nums[i] > nums[j] then take the length of jth element(i.e dp[j]) + 1(means teh ith element)
            //Take the maximum while evluating all js
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }

            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence increasingSubsequence = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Longest Increasing Subsequence is " + increasingSubsequence.lengthOfLIS(nums));

    }
}
