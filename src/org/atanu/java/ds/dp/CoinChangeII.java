package org.atanu.java.ds.dp;

//https://leetcode.com/problems/coin-change-ii/description/
// Leetcode 518
// Video : https://www.youtube.com/watch?v=ruMqWViJ2_U

public class CoinChangeII {
    public int change(int amount, int[] coins) {

        int n = coins .length;

        Integer[][] dp = new Integer[n + 1][amount + 1];

        return numberOfWays(coins, amount, n, dp);
    }

    private int numberOfWays(int[] coins, int amount, int n, Integer[][] dp){
        // Amount became zero that means amount can be formed successfully
        // Return 1
        if(amount == 0){
            return 1;
        }
        // This means we are still having amount but no coins left
        // So not possible to form th eamount
        if(n == 0){
            return 0;
        }

        if(dp[n][amount] != null){
            return dp[n][amount];
        }

        if(coins[n - 1] <= amount){
            // Unbounded Knapsack
            // Include Item : numberOfWays(coins, amount - coins[n - 1], n, dp)
            // Not forwarding the item as we can consider it next time as coins having unlimited supply
            //
            // Exclude : numberOfWays(coins, amount, n - 1, dp)
            //As we need total number of ways . we need to add those possibilities

            dp[n][amount] = numberOfWays(coins, amount - coins[n - 1], n, dp)
                    + numberOfWays(coins, amount, n - 1, dp);
        }
        else{
            dp[n][amount] = numberOfWays(coins, amount, n - 1, dp);;
        }

        return dp[n][amount];
    }

    public static void main(String[] args) {
        CoinChangeII coinChange = new CoinChangeII();
        int amount = 5;
        int[] coins = {1,2,5};
        int numWays = coinChange.change(amount, coins);
        //Explanation: there are four ways to make up the amount:
        //5=5
        //5=2+2+1
        //5=2+1+1+1
        //5=1+1+1+1+1
        System.out.println(numWays);
    }
}
