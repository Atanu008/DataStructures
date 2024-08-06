package org.bgd.java.ds.dp.dpOnStocks;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/">...</a>
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 */
public class BuySellStocksII {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return maxProfitMemo(prices, 0, 0, dp);

    }

    /**
     * Recursive solutuion
     * @param prices
     * @param i
     * @param buy
     * @return
     */

    private int maxProfitRec(int[] prices, int i, int buy) {
        if (i == prices.length) {
            return 0;
        }

        int take = 0;
        int notTake = 0;
        if (buy == 0) { // to buy
            notTake = maxProfitRec(prices, i + 1, buy);
            take = -prices[i] + maxProfitRec(prices, i + 1, 1);
        } else if (buy == 1) { // to sell
            notTake = maxProfitRec(prices, i + 1, buy);
            take = prices[i] + maxProfitRec(prices, i + 1, 0);
        }
        return Math.max(take, notTake);
    }

    /**
     * Memoized Solution
     */
    private int maxProfitMemo(int[] prices, int i, int buy, int[][] dp) {
        if (i == prices.length) {
            return 0;
        }

        int take = 0;
        int notTake = 0;
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }
        if (buy == 0) { // to buy
            notTake = maxProfitMemo(prices, i + 1, buy, dp);
            take = -prices[i] + maxProfitMemo(prices, i + 1, 1, dp);
        } else if (buy == 1) { // to sell
            notTake = maxProfitMemo(prices, i + 1, buy, dp);
            take = prices[i] + maxProfitMemo(prices, i + 1, 0, dp);
        }
        return dp[i][buy] = Math.max(take, notTake);
    }

    /**
     * Tabulation
     */

    private int maxProfitMemo(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                int take = 0;
                int notTake = dp[i + 1][buy];
                if (buy == 0) { // to buy
                    take = -prices[i] + dp[i + 1][1];
                } else if (buy == 1) { // to sell

                    take = prices[i] + dp[i + 1][0];
                }
                dp[i][buy] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}
