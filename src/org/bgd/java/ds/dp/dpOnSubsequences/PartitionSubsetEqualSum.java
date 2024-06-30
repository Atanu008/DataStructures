package org.bgd.java.ds.dp.dpOnSubsequences;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/partition-equal-subset-sum/description/">...</a>
 *
 * 416. Partition Equal Subset Sum
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */

public class PartitionSubsetEqualSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int[][] dp = new int[nums.length][sum + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return canPartitionMemo(nums, sum / 2, nums.length - 1, dp);
    }

    /**
     * Recursive
     */

    private boolean canParitionRec(int[] nums, int sum, int index) {
        if (sum == 0) {
            return true;
        }
        if (index == 0) {
            return nums[index] == sum;
        }
        boolean notTake = canParitionRec(nums, sum, index - 1);
        boolean take = false;
        if (nums[index] <= sum) {
            take = canParitionRec(nums, sum - nums[index], index - 1);
        }
        return take || notTake;
    }

    /**
     * Memoization
     */

    private boolean canPartitionMemo(int[] nums, int sum, int index, int[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (index == 0) {
            return nums[index] == sum;
        }
        if (dp[index][sum] != -1) {
            return dp[index][sum] == 1;
        }
        boolean notTake = canPartitionMemo(nums, sum, index - 1, dp);
        boolean take = false;
        if (nums[index] <= sum) {
            take = canPartitionMemo(nums, sum - nums[index], index - 1, dp);
        }
        dp[index][sum] = take || notTake ? 1 : 0;
        return dp[index][sum] == 1;
    }

    /**
     * Tabulation
     */

    private boolean canPartitionTab(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length][sum + 1];
        sum = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean nottake = dp[i - 1][j];
                boolean take = false;
                if (nums[i] <= j) {
                    take = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = take || nottake;
            }
        }
        return dp[nums.length - 1][sum];
    }
}

