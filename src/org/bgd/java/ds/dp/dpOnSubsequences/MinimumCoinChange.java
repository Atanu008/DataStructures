package org.bgd.java.ds.dp.dpOnSubsequences;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/description/">...</a>
 */
public class MinimumCoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int r = mincoins(coins, amount, coins.length - 1, dp);
        if (r == Math.pow(10, 9)) {
            return -1;
        }
        return r;
    }

    private int mincoins(int[] coins, int amount, int index, int[][] dp) {
        if (index == 0) {
            if (amount % coins[index] == 0) {
                return amount / coins[index];
            } else {
                return (int) Math.pow(10, 9);
            }
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int nottake = mincoins(coins, amount, index - 1, dp);
        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            take = 1 + mincoins(coins, amount - coins[index], index, dp);
        }
        dp[index][amount] = Math.min(take, nottake);
        return dp[index][amount];
    }
}
