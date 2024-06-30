package org.bgd.java.ds.dp.onedimension;

import java.util.Arrays;

/**
 * <a href="https://www.geeksforgeeks.org/problems/minimal-cost/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimal-cost">...</a>
 *
 *
 * Minimal Cost
 * There are n stones and an array of heights and Geek is standing at stone 1 and can jump to one of the following: Stone i+1, i+2, ... i+k stone and cost will be [hi-hj] is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches Stone n.
 *
 * Examples :
 * Input: n = 5, k = 3 heights = {10, 30, 40, 50, 20}
 * Output: 30
 * Explanation: Geek will follow the path 1->2->5, the total cost would be | 10-30| + |30-20| = 30, which is minimum
 * Input: n = 3, k = 1 heights = {10,20,10}
 * Output: 20
 * Explanation: Geek will follow the path 1->2->3, the total cost would be |10 - 20| + |20 - 10| = 20.
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function minimizeCost() which takes the array height, and integer n, and integer k and returns the minimum energy that is lost.
 *
 *
 */
public class FrogJumpKDistance {
    public int minimizeCost(int[] arr, int N, int K) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return minCostMemo(arr, N - 1, K, dp);
    }

    /**
     * Recursive solution
     * @param arr
     * @param i
     * @param k
     * @return
     */
    private int minCostRec(int[] arr, int i, int k) {
        if (i == 0) {
            return 0;
        }
        int steps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (i - j > 0) {
                int value = minCostRec(arr, i - j, k) + Math.abs(arr[i] - arr[i - j]);
                steps = Math.min(steps, value);
            }
        }
        return steps;
    }

    /**
     * Memoization
     */

    private int minCostMemo(int[] arr, int i, int k, int[] dp) {
        if (i == 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int steps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (i - j >= 0) {
                int value = minCostMemo(arr, i - j, k, dp) + Math.abs(arr[i] - arr[i - j]);
                steps = Math.min(steps, value);
            }
        }
        dp[i] = steps;
        return dp[i];
    }

    /**
     * Tabulation
     * @param arr
     * @param N
     * @param K
     * @return
     */

    private int minCostTabulation(int[] arr, int N, int K) {
        int[] dp = new int[N];
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            int steps = Integer.MAX_VALUE;
            for (int j = 1; j <= K; j++) {
                if (i - j >= 0) {
                    int value = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    steps = Math.min(steps, value);
                }
            }
            dp[i] = steps;
        }
        return dp[N - 1];
    }
}
