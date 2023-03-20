package org.atanu.java.ds.dp;

// https://leetcode.com/problems/coin-change-ii/description/
// Leetcode 518
// https://www.youtube.com/watch?v=ruMqWViJ2_U
// Exactly same solution as unbounded knapsack
public class CoinChangeII_v2 {
    public int change(int amount, int[] coins) {

        int n = coins .length;

        int[][] dp = new int[n + 1][amount + 1];
        //Fill 1st row with 0 because no amount (except 0) can be formed without any coin (dont need to do it explicitly , as all elements are zero only by default)
        //Fill 1st col by 1 (assuming amount 0 can always be formed)
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    public static void main(String[] args) {
        CoinChangeII_v2 coinChange = new CoinChangeII_v2();
        int amount = 5;
        int[] coins = {1,2,5};
        int numWays = coinChange.change(amount, coins);
        System.out.println("Bottom Up Solution");
        //Explanation: there are four ways to make up the amount:
        //5=5
        //5=2+2+1
        //5=2+1+1+1
        //5=1+1+1+1+1
        System.out.println(numWays);
    }
}
