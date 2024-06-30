package org.bgd.java.ds.dp.dpOnSubsequences;

/**
 * https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
 *
 * 2035. Partition Array Into Two Arrays to Minimize Sum Difference
 * Hard
 *
 * Topics
 *
 * Companies
 *
 * Hint
 * You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.
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

    public int minimumDifference(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }

        return subSetSumTab(nums, total);

    }

    private boolean subsetSumKRec(int[] nums, int i, int total) {
        if (total == 0) {
            return true;
        }
        if (i == 0) {
            return nums[i] == total;
        }

        boolean notTake = subsetSumKRec(nums, i - 1, total);
        boolean take = false;
        if (nums[i] <= total) {
            take = subsetSumKRec(nums, i - 1, total - nums[i]);
        }
        return take || notTake;
    }

    private boolean subsetSumMemo(int[] nums, int i, int total, int[][] dp) {
        if (total == 0) {
            return true;
        }
        if (i == 0) {
            return nums[i] == total;
        }
        if (dp[i][total] != -1) {
            return dp[i][total] == 1;
        }

        boolean notTake = subsetSumMemo(nums, i - 1, total, dp);
        boolean take = false;
        if (nums[i] <= total) {
            take = subsetSumMemo(nums, i - 1, total - nums[i], dp);
        }
        dp[i][total] = take || notTake ? 1 : 0;
        return dp[i][total] == 1;
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
