package org.bgd.java.ds.dp.dpOnStocks;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">...</a>
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 *
 * Input: prices = [1]
 * Output: 0
 */
public class BuySellStocksCoolDown {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return maxProfitMemo(prices, 0, 1, dp);
    }

    private int maxProfitRec(int[] prices, int i, int buy) {
        if (i >= prices.length) {
            return 0;
        }

        int take = 0;
        int notTake = 0;
        if (buy == 1) {
            take = -prices[i] + maxProfitRec(prices, i + 1, 0);
            notTake = 0 + maxProfitRec(prices, i + 1, buy);
        } else if (buy == 0) {
            // sell
            take = prices[i] + maxProfitRec(prices, i + 2, 1);
            notTake = 0 + maxProfitRec(prices, i + 1, buy);
        }
        return Math.max(take, notTake);
    }

    private int maxProfitMemo(int[] prices, int i, int buy, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }

        int take = 0;
        int notTake = 0;
        if (buy == 1) {
            take = -prices[i] + maxProfitMemo(prices, i + 1, 0, dp);
            notTake = 0 + maxProfitMemo(prices, i + 1, buy, dp);
        } else if (buy == 0) {
            // sell
            take = prices[i] + maxProfitMemo(prices, i + 2, 1, dp);
            notTake = 0 + maxProfitMemo(prices, i + 1, buy, dp);
        }
        return dp[i][buy] = Math.max(take, notTake);
    }
}
