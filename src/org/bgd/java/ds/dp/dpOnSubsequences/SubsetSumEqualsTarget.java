package org.bgd.java.ds.dp.dpOnSubsequences;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
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
 * Example 2:
 *
 * Input:
 * N = 6
 * arr[] = {3, 34, 4, 12, 5, 2}
 * sum = 30
 * Output: 0
 * Explanation: There is no subset with sum 30.
 */
public class SubsetSumEqualsTarget {
    Boolean isSubsetSum(int N, int[] arr, int sum) {
        int[][] dp = new int[N][sum + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return isSubSetMemo(arr, sum, N - 1, dp);
    }

    /**
     * Recursive Solution
     */

    private Boolean isSubSetSumRec(int[] arr, int sum, int index) {
        if (sum == 0) {
            return Boolean.TRUE;
        }
        if (index == 0) {
            return arr[index] == sum;
        }

        Boolean take = false;
        if (arr[index] >= sum) {
            take = isSubSetSumRec(arr, sum - arr[index], index - 1);
        }
        Boolean notTake = isSubSetSumRec(arr, sum, index - 1);
        return take || notTake;
    }

    /**
     * Top Down Memoization
     */

    private Boolean isSubSetMemo(int[] arr, int sum, int index, int[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (index == 0) {
            return arr[index] == sum;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum] == 1;
        }

        Boolean notTake = isSubSetMemo(arr, sum, index - 1, dp);
        Boolean take = false;
        if (arr[index] <= sum) {
            take = isSubSetMemo(arr, sum - arr[index], index - 1, dp);
        }
        dp[index][sum] = (take || notTake) ? 1 : 0;
        return dp[index][sum] == 1;
    }

    /**
     * Bottom up tabulation
     */

    private boolean isSubsetTable(int[] arr, int sum, int N) {
        boolean[][] dp = new boolean[N][sum + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;

        for (int i = 1; i < N; i++) {
            for (int target = 1; target <= sum; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (arr[i] <= target) {
                    take = dp[i - 1][target - arr[i]];
                }
                dp[i][target] = take || notTake;
            }
        }
        return dp[N - 1][sum];

    }
}
