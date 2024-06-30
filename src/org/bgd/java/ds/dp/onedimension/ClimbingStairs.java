package org.bgd.java.ds.dp.onedimension;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    // Recursive solution first

    public int climbStairsRec(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }

    // Dynamic Programming - Recursion + Memoization

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsMemo(n, dp);
    }

    public int climbStairsMemo(int n, int[] dp) {

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = climbStairsMemo(n - 1, dp) + climbStairsMemo(n - 2, dp);
        return dp[n];
    }

    // Dynamic Programming -  Top down - Array prefill

    public int climbStairsII(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
