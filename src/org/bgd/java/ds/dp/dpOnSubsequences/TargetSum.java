package org.bgd.java.ds.dp.dpOnSubsequences;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/target-sum/">...</a>
 *
 * 494. Target Sum
 *
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 */
public class TargetSum {

    /**
     * Recursive solution
     * @param nums
     * @param target
     * @return
     */

    public int findTargetSumWays(int[] nums, int target) {
        return targetSumRec(nums, 0, target);
    }

    private int targetSumRec(int[] nums, int i, int target) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
        }
        if (i < nums.length)
            return targetSumRec(nums, i + 1, target + nums[i]) + targetSumRec(nums, i + 1, target - nums[i]);
        return 0;
    }

    /**
     * Top down Memoized
     This requires a 2d dp array to track the sum of all elements till i and the total which is precomputed
     */

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

    public int findTargetSumWaysII(int[] nums, int target) {
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

}
