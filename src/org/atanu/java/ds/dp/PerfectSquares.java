package org.atanu.java.ds.dp;

//https://leetcode.com/problems/perfect-squares/
//LeetCode 279
//Video : https://www.youtube.com/watch?v=aZuQXkO0-XA

import java.util.Arrays;

//Similar to LIS problem
//Just try to find the logic for 9/4;
// i = 9; and j = 3
//// Plus 1 means we are taking the jth Number and will calculate remaining from dp table
// dp[9] = Math.min(dp[9], dp[9 - 3*3] + 1);
// dp[9] = Math.min(dp[9], dp[0] + 1); //dp[0] that means we are using only 3 and no other number needed dp[0] = 0;
public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){

            for(int j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        int n = 12;
        System.out.println(" least number of perfect square numbers for "+ n + " is "+ perfectSquares.numSquares(n));
        n = 13;
        System.out.println(" least number of perfect square numbers for "+ n + " is "+ perfectSquares.numSquares(n));
    }
}
