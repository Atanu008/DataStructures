package org.bgd.java.ds.dp.dpOnSubsequences;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/">...</a>
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int result = coinRecMemo(coins, amount, n - 1, dp);
        return result == Math.pow(10, 9) ? -1 : result;
    }

    /**
     * Recursive
     * @param coins
     * @param amount
     * @param ind
     * @return
     */
    private int coinRec(int[] coins, int amount, int ind) {

        if (ind == 0) {
            if (amount % coins[ind] == 0) {
                return amount / coins[ind];
            } else {
                return (int) Math.pow(10, 9);
            }
        }
        int notTake = coinRec(coins, amount, ind - 1);
        int take = (int) Math.pow(10, 9);
        if (coins[ind] <= amount) {
            take = 1 + coinRec(coins, amount - coins[ind], ind);
        }

        return Math.min(take, notTake);
    }

    /**
     * Memoization
     */
    private int coinRecMemo(int[] coins, int amount, int ind, int[][] dp) {

        if (ind == 0) {
            if (amount % coins[ind] == 0) {
                return amount / coins[ind];
            } else {
                return (int) Math.pow(10, 9);
            }
        }
        if (dp[ind][amount] != -1) {
            return dp[ind][amount];
        }
        int notTake = coinRecMemo(coins, amount, ind - 1, dp);
        int take = (int) Math.pow(10, 9);
        if (coins[ind] <= amount) {
            take = 1 + coinRecMemo(coins, amount - coins[ind], ind, dp);
        }

        dp[ind][amount] = Math.min(take, notTake);
        return dp[ind][amount];
    }

    /**
     * Tabulation
     */
    private int coinChange(int[] coins, int amount, int ind) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int T = 0; T <= amount; T++) {
            if (T % coins[0] == 0) {
                dp[0][T] = T / coins[0];
            } else {
                dp[0][T] = (int) Math.pow(10, 9);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int T = 0; T <= amount; T++) {
                int notTake = dp[i - 1][T];
                int take = (int) Math.pow(10, 9);
                if (coins[i] <= T) {
                    take = 1 + dp[i][T - coins[i]];
                }

                dp[i][T] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][amount];
        if (ans == (int) Math.pow(10, 9)) {
            return -1;
        }
        return ans;

    }
}
