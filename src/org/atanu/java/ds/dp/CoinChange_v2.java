package org.atanu.java.ds.dp;

//https://leetcode.com/problems/coin-change/description/
//Leetcode 322
//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/gknnXkzon6D

//Video : https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/25680068?start=195#overview
// Video : https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/25680062#overview

public class CoinChange_v2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int result = coinChnageUtil(coins, amount, dp);
        return result != Integer.MAX_VALUE ? result : -1;

    }

    private int coinChnageUtil(int[] coins, int amount, int[] dp){


        // if the total is 0, no coins are needed
        if (amount == 0) {
            return 0;
        }

        // return infinity if total becomes negative
        // Not possible to form the amount
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        //Return
        if(dp[amount] != 0){
            return dp[amount];
        }

        // initialize the minimum number of coins needed to infinity
        int minimumCoinsNeeded = Integer.MAX_VALUE;

        // do for each coin
        for (int coin: coins)
        {
            // recur to see if total can be reached by including current coin
            int result = coinChnageUtil(coins, amount - coin, dp);

            // update the minimum number of coins needed if choosing the current
            // coin resulted in a solution
            // result + 1 , because we are using the current coin
            if (result != Integer.MAX_VALUE) {
                minimumCoinsNeeded = Integer.min(minimumCoinsNeeded, result + 1);
            }
        }

        dp[amount] = minimumCoinsNeeded;
        // return the minimum number of coins needed
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("Top Down Approach");
        int[] coins = {1,2,5};
        int amount = 11;
        CoinChange_v2 coinChange = new CoinChange_v2();
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
