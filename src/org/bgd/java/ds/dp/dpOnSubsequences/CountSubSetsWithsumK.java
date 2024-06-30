package org.bgd.java.ds.dp.dpOnSubsequences;

import java.util.Arrays;

/**
 * <a href="https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem">...</a>
 * Given an array arr of size n of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.
 *
 * Note: Answer can be very large, so, output answer modulo 109+7.
 *
 * Examples:
 *
 * Input:
 * n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
 * Output:
 * 3
 * Explanation:
 * {5, 2, 3}, {2, 8}, {10} are possible subsets.
 * Input:
 * n = 5, arr = [2, 5, 1, 4, 3], sum = 10
 * Output:
 * 3
 * Explanation:
 * {2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.
 */
public class CountSubSetsWithsumK {

    public int perfectSum(int[] arr, int n, int sum) {
        int[][] dp = new int[n][sum + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return perfectSumMemo(arr, sum, n - 1, dp);
    }

    /**
     * Recursion
     */

    private int perfectSumRec(int[] arr, int sum, int i) {
        if (sum == 0) {
            return 1;
        }
        if (i == 0) {
            if (arr[i] == sum) {
                return 1;
            }
            return 0;
        }
        int nottake = perfectSumRec(arr, sum, i - 1);
        int take = 0;
        if (arr[i] <= sum) {
            take = perfectSumRec(arr, sum - arr[i], i - 1);
        }
        return nottake + take;
    }

    /**
     * Memoization
     */

    private int perfectSumMemo(int[] arr, int sum, int i, int[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (i == 0) {
            if (arr[i] == sum) {
                return 1;
            }
            return 0;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int nottake = perfectSumMemo(arr, sum, i - 1, dp);
        int take = 0;
        if (arr[i] <= sum) {
            take = perfectSumMemo(arr, sum - arr[i], i - 1, dp);
        }
        dp[i][sum] = nottake + take;
        return dp[i][sum];
    }

}
