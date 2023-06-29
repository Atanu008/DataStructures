package org.atanu.java.ds.dp;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Leetcode 121
// However its not DP. But keeping these so that all Buy and Stock problem are in same place
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int price : prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    // Brute Force
    public int maxProfit_v2(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
}
