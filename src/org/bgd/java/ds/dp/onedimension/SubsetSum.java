package org.bgd.java.ds.dp.onedimension;

import java.util.Arrays;

/**
 * <a href="https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1">...</a>
 *
 * Subset Sum Problem
 *
 * Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 6
 * arr[] = {3, 34, 4, 12, 5, 2}
 * sum = 9
 * Output: 1
 * Explanation: Here there exists a subset with
 * sum = 9, 4+3+2 = 9.
 *
 */
public class SubsetSum {
    boolean isSubsetSum(int N, int[] arr, int sum) {
        int[][] dp = new int[N][sum + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return isSubset(arr, arr.length, sum, dp) == 1;
    }

    int isSubset(int[] arr, int n, int sum, int[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        if (arr[n - 1] > sum) {
            dp[n][sum] = isSubset(arr, n - 1, sum, dp);
            return dp[n][sum];
        }

        if (isSubset(arr, n - 1, sum - arr[n - 1], dp) == 1 || isSubset(arr, n - 1, sum, dp) == 1) {
            dp[n][sum] = 1;
        } else {
            dp[n][sum] = 0;
        }

        return dp[n][sum];
    }
}
