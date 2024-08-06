package org.bgd.java.ds.dp.twodimension;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">...</a>
 *
 * 300. Longest Increasing Subsequence
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 */
public class LIS {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return lisRec(nums, 0, -1);
    }

    private int lisRec(int[] a, int curr, int prev) {
        if (curr == a.length) {
            return 0;
        }

        int notTake = lisRec(a, curr + 1, prev);
        int take = -1;

        if (prev < 0 || a[curr] > a[prev]) {
            take = 1 + lisRec(a, curr + 1, curr);
        }

        return Math.max(notTake, take);

    }

    private int lis(int[] nums, int curr, int prev, int[][] dp) {
        if (curr == nums.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        int l1 = lis(nums, curr + 1, prev, dp);

        if (prev < 0 || nums[curr] > nums[prev]) {
            l1 = Math.max(l1, 1 + lis(nums, curr + 1, curr, dp));
        }

        dp[curr][prev + 1] = l1;
        return dp[curr][prev + 1];
    }
}
