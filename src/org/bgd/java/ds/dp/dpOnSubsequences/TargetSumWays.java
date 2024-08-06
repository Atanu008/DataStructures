package org.bgd.java.ds.dp.dpOnSubsequences;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/">...</a>
 *
 * 2035. Partition Array Into Two Arrays to Minimize Sum Difference
 * Hard
 *
 * Topics
 *
 * Companies
 *
 * Hint
 * You are given an integer array nums of 2 * n integers.
 * You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays.
 * To partition nums, put each element of nums into one of the two arrays.
 *
 * Return the minimum possible absolute difference.
 *
 *
 *
 * Example 1:
 *
 * example-1
 * Input: nums = [3,9,7,3]
 * Output: 2
 * Explanation: One optimal partition is: [3,9] and [7,3].
 * The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.
 * Example 2:
 *
 * Input: nums = [-36,36]
 * Output: 72
 * Explanation: One optimal partition is: [-36] and [36].
 * The absolute difference between the sums of the arrays is abs((-36) - (36)) = 72.
 */
public class TargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }

        int[][] dp = new int[nums.length][2 * total + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return targetSumMemo(nums, 0, total, 0, target, dp);
    }

    private int targetSumMemo(int[] nums, int i, int total, int sum, int target, int[][] dp) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[i][sum + total] != -1) {
            return dp[i][sum + total];
        }

        if (i < nums.length) {
            dp[i][sum + total] = targetSumMemo(nums, i + 1, total, sum - nums[i], target, dp) + targetSumMemo(nums, i + 1, total, sum + nums[i], target, dp);
        }
        return dp[i][sum + total];

    }

    public int minimumDifference(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }

        return subSetSumTab(nums, total);

    }

    private int subSetSumTab(int[] nums, int total) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][total + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= total) {
            dp[0][total] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int sum = 1; sum <= total; sum++) {
                boolean notTake = dp[i - 1][sum];
                boolean take = false;
                if (nums[i] <= sum) {
                    take = dp[i - 1][sum - nums[i]];
                }
                dp[i][sum] = take || notTake;
            }
        }
        int min = Integer.MIN_VALUE;

        for (int s1 = 0; s1 <= total / 2; s1++) {
            if (dp[n - 1][s1]) {
                int s2 = total - s1;
                min = Math.min(min, Math.abs(s1 - s2));
            }
        }
        return min;
    }
}
