package org.atanu.java.ds.dp;

// Coding Minutes : https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/25798556#overview
// Educative : https://www.techiedelight.com/rod-cutting/
public class RodCutting_v2 {
    public int rodCut(int[] price, int length) {

        // `dp[i]` stores the maximum profit achieved from a rod of length `i`
        int[] dp = new int[length + 1];
        dp[0] = 0; //For length zero we have no profit

        for(int i = 1; i <= length; i++){
            // divide the rod of length `i` into two rods of length `j`
            // and `i-j` each and take maximum
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }
        // `dp[n]` stores the maximum profit achieved from a rod of length `n`
        return dp[length];
    }

    public static void main(String[] args) {
        RodCutting_v2 rodCutting = new RodCutting_v2();
        int[]  prices = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int maxProfit = rodCutting.rodCut(prices, prices.length);
        System.out.println("Bottom Up : ");
        System.out.println(maxProfit);
    }
}
