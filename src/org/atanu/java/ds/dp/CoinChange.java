package org.atanu.java.ds.dp;

//https://leetcode.com/problems/coin-change/description/
//Leetcode 322
//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/gknnXkzon6D

//Video : https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/25680068?start=195#overview
// Video : https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/25680062#overview

public class CoinChange {

    //Bottom Up Approach
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        //Base case . we dont need any coins for zero amount
        dp[0] = 0;

        //popolate dp state with minimum coins for all possible amounts starting from 1
        for(int i = 1; i <= amount; i++){
            dp[i] = amount + 1; // initially fill it with impossible . Integer.MAX_VALUE has som eedges cases
            //Try using all coins to form the ith amount
            for(int coin : coins){
                //if we can use the coin
                if(i - coin >= 0){
                    // dp[i - coin] represent the remaing amount state when current coin is used
                    // + 1 is because we are using the current coin
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }

            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        System.out.println("Bottom Up Approach");
        int[] coins = {1,2,5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
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
