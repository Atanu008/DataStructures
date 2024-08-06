package org.bgd.java.ds.dp.dpOnStocks;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/">...</a>
 * <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BuySellStocksIV {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k + 1];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return maxProfitMemo(prices, 0, 1, k, dp);
    }

    private int maxProfitMemo(int[] prices, int i, int buy, int cap, int[][][] dp) {
        if (i == prices.length) {
            return 0;
        }

        if (cap == 0) {
            return 0;
        }
        if (dp[i][buy][cap] != -1) {
            return dp[i][buy][cap];
        }
        int take = 0;
        int notTake = 0;
        if (buy == 1) {
            take = -prices[i] + maxProfitMemo(prices, i + 1, 0, cap, dp);
            notTake = maxProfitMemo(prices, i + 1, buy, cap, dp);
        } else if (buy == 0) {
            //sell
            take = prices[i] + maxProfitMemo(prices, i + 1, 1, cap - 1, dp);
            notTake = maxProfitMemo(prices, i + 1, buy, cap, dp);
        }
        return dp[i][buy][cap] = Math.max(take, notTake);
    }
}
