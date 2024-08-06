package org.bgd.java.ds.dp.dpOnStocks;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">...</a>
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time.
 * You must sell before buying again.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BuySellStocksIII {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return maxProfitMemo(prices, 0, 1, 2, dp);
    }

    /**
     * Recursive
     */
    private int maxProfitRec(int[] prices, int i, int buy, int cap) {
        if (i == prices.length) {
            return 0;
        }

        if (cap == 0) {
            return 0;
        }
        int take = 0;
        int notTake = 0;
        if (buy == 1) {
            take = -prices[i] + maxProfitRec(prices, i + 1, 0, cap);
            notTake = maxProfitRec(prices, i + 1, buy, cap);
        } else if (buy == 0) {
            //sell
            take = prices[i] + maxProfitRec(prices, i + 1, 1, cap - 1);
            notTake = maxProfitRec(prices, i + 1, buy, cap);
        }
        return Math.max(take, notTake);
    }

    /**
     * Memoized solution
     */

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
