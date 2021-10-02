package org.atanu.java.ds.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//LeetCode 121
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int minpPrice = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){

            if(prices[i] < minpPrice){
                minpPrice = prices[i];
            }
            if(prices[i] - minpPrice > maxProfit){
                maxProfit = prices[i] - minpPrice;
            }
        }
        return maxProfit;
    }

    public int maxProfitV2(int[] prices) {

        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i = 1; i < prices.length; i++) {

            maxEndingHere = maxEndingHere + prices[i] - prices[i-1];
            maxEndingHere = Math.max(maxEndingHere, 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    //Its same as v2 but more verbose
    public int maxProfitV3(int[] prices) {

        int[] profit = new int[prices.length];
        // prepare the profit array .
        // profit[i] = prices[i] - prices[i-1]
        // for first element there is no left, profit is zero
        for(int i = 0; i < prices.length; i++){
            if(i== 0){
                profit[i] = 0;
            }
            else{
                profit[i] = prices[i] - prices[i-1];
            }
        }

        // Apply Kadane on on the profit Array
        int maxSoFar = 0;

        int maxEndingHere = profit[0];
        for (int i = 1; i < profit.length; i++) {

            maxEndingHere = maxEndingHere + profit[i];

            maxEndingHere = Math.max(maxEndingHere, profit[i]);

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {

    }
}
