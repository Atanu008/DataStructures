package org.bgd.java.ds.dp.dpOnStocks;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">...</a>
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 *
 * Note:
 *
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 *
 *
 * Example 1:
 *
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Example 2:
 *
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 */
public class BuySellStocksTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return maxProfitMemo(prices, 0, 0, fee, dp);
    }

    private int maxProfitRec(int[] prices, int i, int buy, int fee) {
        if (i == prices.length) {
            return 0;
        }

        int take = 0;
        int notTake = 0;
        if (buy == 0) { // to buy
            notTake = maxProfitRec(prices, i + 1, buy, fee);
            take = -prices[i] + maxProfitRec(prices, i + 1, 1, fee);
        } else if (buy == 1) { // to sell
            notTake = maxProfitRec(prices, i + 1, buy, fee);
            take = prices[i] + maxProfitRec(prices, i + 1, 0, fee) - fee;
        }
        return Math.max(take, notTake);
    }

    private int maxProfitMemo(int[] prices, int i, int buy, int fee, int[][] dp) {
        if (i == prices.length) {
            return 0;
        }

        int take = 0;
        int notTake = 0;
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }
        if (buy == 0) { // to buy
            notTake = maxProfitMemo(prices, i + 1, buy, fee, dp);
            take = -prices[i] + maxProfitMemo(prices, i + 1, 1, fee, dp);
        } else if (buy == 1) { // to sell
            notTake = maxProfitMemo(prices, i + 1, buy, fee, dp);
            take = prices[i] - fee + maxProfitMemo(prices, i + 1, 0, fee, dp);
        }
        return dp[i][buy] = Math.max(take, notTake);
    }
}
