package org.bgd.java.ds.dp.dpOnStrings;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/distinct-subsequences/description/">...</a>
 *
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "rabbbit", t = " "
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from s.
 * rabbbit
 * rabbbit
 * rabbbit
 * Example 2:
 *
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from s.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return numDistinctMemo(s, t, m - 1, n - 1, dp);

    }

    /**
     * Recursive Solution
     */
    private int numDistinctRec(String s, String t, int i, int j) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (s.charAt(i) == t.charAt(j)) {
            return numDistinctRec(s, t, i - 1, j) + numDistinctRec(s, t, i - 1, j - 1);
        }
        return numDistinctRec(s, t, i - 1, j);
    }

    private int numDistinctMemo(String s, String t, int i, int j, int[][] dp) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = numDistinctMemo(s, t, i - 1, j, dp) + numDistinctMemo(s, t, i - 1, j - 1, dp);
        } else {
            dp[i][j] = numDistinctMemo(s, t, i - 1, j, dp);
        }
        return dp[i][j];
    }

    /**
     * Tabulation
     */
    private int numDistinctTabulation(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}

