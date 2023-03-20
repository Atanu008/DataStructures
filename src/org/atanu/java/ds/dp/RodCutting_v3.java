package org.atanu.java.ds.dp;

//Solution using Unbounded Knapsack
//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
//https://leetcode.com/discuss/interview-question/1271572/rod-cutting-dp

//Exactly same as Unbounded Knapsack
//This is Top Down Solution
public class RodCutting_v3 {

    public int maxProfit(int[] prices, int[] length, int maxLength, int n, Integer[][] dp){
        // if length = 0 means we can not cut the rod any more
        // index == 0 means we have exhausted the cuts
        // n represents both 'index' and 'current piece length'
        if(maxLength == 0 || n == 0){
            return 0;
        }

        if(dp[maxLength][n] != null){
            return dp[maxLength][n];
        }

        if(length[n - 1] <= maxLength){
            dp[maxLength][n] = prices[n - 1] + maxProfit(prices, length, maxLength - length[n-1], n, dp)
                            + maxProfit(prices, length, maxLength, n - 1, dp);
        }
        else {
            dp[maxLength][n] = maxProfit(prices, length, maxLength,n - 1, dp);
        }

        return dp[maxLength][n];
    }

    public static void main(String[] args) {
        System.out.println("Top Down");
        int[]  prices = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };

        int n = prices.length;
        int[] length = new int[n];
        // since length array is not given therefore let us make one
        for(int i = 0; i < n; i++){
            length[i] = i + 1;
        }
        int rodMaxLength = n;
        Integer[][] dp = new Integer[rodMaxLength + 1][n + 1];
        RodCutting_v3 rodCuttingV3 = new RodCutting_v3();
        int maxProfit = rodCuttingV3.maxProfit(prices, length, rodMaxLength, n, dp);
        System.out.println(maxProfit);
    }
}
