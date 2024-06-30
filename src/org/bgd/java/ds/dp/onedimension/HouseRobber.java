package org.bgd.java.ds.dp.onedimension;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return robMemo(nums, 0, dp);
    }

    // Recursive
    public int robRec(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        return Math.max(robRec(nums, i + 1), nums[i] + robRec(nums, i + 2));
    }

    //Top down Memoized

    public int robMemo(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = Math.max(robMemo(nums, i + 1, dp), nums[i] + robMemo(nums, i + 2, dp));
        return dp[i];
    }

    /**
     * Memoization from last
     */
    private int robMemoII(int[] nums, int i, int[] dp) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return nums[i];
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int take = nums[i] + robMemoII(nums, i - 2, dp);
        int nottake = robMemoII(nums, i - 1, dp);
        dp[i] = Math.max(take, nottake);
        return dp[i];
    }

    /**
     * Tabulation
     */
    private int robTabulation(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int take = nums[i] + dp[i - 2];
            int nottake = dp[i - 1];
            dp[i] = Math.max(take, nottake);
        }
        return dp[nums.length - 1];
    }
}
