package org.atanu.java.ds.dp;

//Solution using Unbounded Knapsack
//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
//https://leetcode.com/discuss/interview-question/1271572/rod-cutting-dp

//Exactly same as Unbounded Knapsack
//This is Bottom Up Solution
public class RodCutting_v4 {
    public int maxProfit(int[] prices, int n){

        int[] length = new int[n];
        for(int i = 0; i < n; i++){
            length[i] = i + 1;
        }

        int[][] dp = new int[n + 1][ n + 1];
        //Initailly no base values.
        //No profit can be made for zero length(represent first row)
        //also Np profit with no cut(represnt first column)

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(length[i - 1] <= j){
                    dp[i][j] = prices[i-1] + dp[i][j - length[i-1]]
                            + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][n];
    }

    public static void main(String[] args) {

        int[]  prices = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = prices.length;

        RodCutting_v4 rodCutting = new RodCutting_v4();
        int maxProfit = rodCutting.maxProfit(prices, n);
        System.out.println("Bottom Up");
        System.out.println(maxProfit);
    }


}
