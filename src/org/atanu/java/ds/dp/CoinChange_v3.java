package org.atanu.java.ds.dp;

//https://leetcode.com/problems/coin-change/description/
//Leetcode 322
//This solution is via Unbounded knapsack
//Video Reference : https://www.youtube.com/watch?v=ZI17bgz07EE&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=14

public class CoinChange_v3 {


    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];
        //Its impossible to have amount > 0 with zero coins(first row represent zero coin)
        //mark the first dp row with impossible value
        //Only the amount zero can be formed with having no/zero coin. so keeping the first cell as zero
        for(int i = 1; i <= amount; i++){
            // impossible . Integer.MAX_VALUE has edge cases(going negatime in case o f+ 1) , so did amount + 1
            dp[0][i] = amount + 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return (dp[n][amount] > amount ? -1 : dp[n][amount]);
    }



    //Below is the top Down . This will not work for few test cases
    //Need to handle the max value rerturn grace fully.

    public int coinChange_v2(int[] coins, int amount) {
        int n = coins.length;

        Integer[][] dp = new Integer[n + 1][amount + 1];
        return  minWays(coins, amount, n, dp);
    }

    private int minWays(int[] coins, int amount, int index, Integer[][] dp){
        //Base condition
        //If the amount is zero then its possible to form the amount
        if(amount == 0){
            return 0;
        }
        //if the amount is +ve and we have no coin then its impossible to form the amount
        //return infinity
        if(index == 0 && amount > 0){
            return Integer.MAX_VALUE;
        }


        if (dp[index][amount] != null){
            return dp[index][amount];
        }

        if (coins[index - 1] <= amount){
            return dp[index][amount] = 1 + Math.min(minWays(coins, amount- coins[index - 1], index, dp),
                    minWays(coins, amount, index - 1, dp));
        }
        else{
            return dp[index][amount] = minWays(coins, amount, index - 1, dp);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        CoinChange_v3 coinChange = new CoinChange_v3();
        int minCoins = coinChange.coinChange(coins, amount);
        //Output: 3
        //Explanation: 11 = 5 + 5 + 1
        System.out.println(minCoins);

        coins = new int[]{2};
        amount = 5;
        minCoins = coinChange.coinChange(coins, amount);
        //Output: -1
        //Explanation: Impossible to form with coins with value 2
        System.out.println(minCoins);

    }
}
