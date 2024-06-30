package org.bgd.java.ds.dp.dpOnSubsequences;

import java.util.Arrays;

/**
 * <a href="https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1">...</a>
 *
 * You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).
 *
 * Example 1:
 *
 * Input:
 * N = 3
 * W = 4
 * values[] = {1,2,3}
 * weight[] = {4,5,1}
 * Output: 3
 * Explanation: Choose the last item that weighs 1 unit and holds a value of 3.
 * Example 2:
 *
 * Input:
 * N = 3
 * W = 3
 * values[] = {1,2,3}
 * weight[] = {4,5,6}
 * Output: 0
 * Explanation: Every item has a weight exceeding the knapsack's capacity (3).
 */
public class Knapsack01 {

    static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][W + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return knapsackMemo(W, wt, val, n - 1, dp);
    }

    /** Recursive
     *
     * @param W
     * @param wt
     * @param val
     * @param i
     * @return
     */
    private static int knapsackRec(int W, int[] wt, int[] val, int i) {
        if (i == 0) {
            if (wt[i] <= W) {
                return val[i];
            } else {
                return 0;
            }
        }
        int notTake = knapsackRec(W, wt, val, i - 1);
        int take = Integer.MIN_VALUE;
        if (wt[i] <= W) {
            take = val[i] + knapsackRec(W - wt[i], wt, val, i - 1);
        }
        return Math.max(take, notTake);
    }

    /** Memoization
     *
     */
    private static int knapsackMemo(int W, int[] wt, int[] val, int i, int[][] dp) {
        if (i == 0) {
            if (wt[i] <= W) {
                return val[i];
            } else {
                return 0;
            }
        }
        if (dp[i][W] != -1) {
            return dp[i][W];
        }
        int notTake = knapsackMemo(W, wt, val, i - 1, dp);
        int take = Integer.MIN_VALUE;
        if (wt[i] <= W) {
            take = val[i] + knapsackMemo(W - wt[i], wt, val, i - 1, dp);
        }
        dp[i][W] = Math.max(take, notTake);
        return dp[i][W];
    }

    /**
     * Tabulation
     */

    private static int knapsackTab(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][W + 1];

        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                int notTake = dp[i - 1][w];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= w) {
                    take = val[i] + dp[i - 1][w - wt[i]];
                }
                dp[i][w] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][W];
    }

}
