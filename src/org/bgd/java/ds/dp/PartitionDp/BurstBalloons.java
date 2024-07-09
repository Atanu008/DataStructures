package org.bgd.java.ds.dp.PartitionDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/burst-balloons/
 *
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
 *
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
 *
 * Return the maximum coins you can collect by bursting the balloons wisely.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * Example 2:
 *
 * Input: nums = [1,5]
 * Output: 10
 *
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        List<Integer> a = new ArrayList<>();
        for(int i : nums) {
            a.add(i);
        }
        a.addFirst(1);
        a.addLast(1);
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] arr :dp) {
            Arrays.fill(arr, -1);
        }
        return maxCoinsMemo(1, nums.length, a, dp);
    }

    private int maxCoinsRec(int i, int j, List<Integer> nums) {
        if(i > j) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++) {
            int c = nums.get(i-1) * nums.get(ind) * nums.get(j+1)  + maxCoinsRec(i, ind-1, nums) + maxCoinsRec(ind+1, j, nums);
            max = Math.max(max, c);
        }
        return max;
    }

    private int maxCoinsMemo(int i, int j, List<Integer> nums, int[][] dp) {
        if(i > j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++) {
            int c = nums.get(i-1) * nums.get(ind) * nums.get(j+1)  + maxCoinsMemo(i, ind-1, nums, dp) + maxCoinsMemo(ind+1, j, nums, dp);
            max = Math.max(max, c);
        }
        return dp[i][j] = max;
    }
}
