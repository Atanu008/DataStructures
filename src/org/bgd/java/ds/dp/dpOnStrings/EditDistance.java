package org.bgd.java.ds.dp.dpOnStrings;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/edit-distance/">...</a>
 *
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return minDistanceMemo(word1, word2, m, n, dp);

    }

    /**
     * Recursive Solution
     */
    private int minDistanceRec(String w1, String w2, int i, int j) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if (w1.charAt(i) == w2.charAt(j)) {
            return minDistanceRec(w1, w2, i - 1, j - 1);
        }

        int insert = 1 + minDistanceRec(w1, w2, i - 1, j);
        int delete = 1 + minDistanceRec(w1, w2, i, j - 1);
        int replace = 1 + minDistanceRec(w1, w2, i - 1, j - 1);
        return Math.min(insert, Math.min(delete, replace));
    }

    /**
     * Memoized Solution
     */
    private int minDistanceMemo(String w1, String w2, int i, int j, int[][] dp) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
            dp[i][j] = minDistanceMemo(w1, w2, i - 1, j - 1, dp);
            return dp[i][j];
        }

        int insert = 1 + minDistanceMemo(w1, w2, i - 1, j, dp);
        int delete = 1 + minDistanceMemo(w1, w2, i, j - 1, dp);
        int replace = 1 + minDistanceMemo(w1, w2, i - 1, j - 1, dp);
        dp[i][j] = Math.min(insert, Math.min(delete, replace));
        return dp[i][j];
    }

    /**
     * Tabulation
     */

    private int minDistanceTab(String w1, String w2) {
        int m = w1.length();
        int n = w2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];

                } else {
                    int insert = 1 + dp[i - 1][j];
                    int delete = 1 + dp[i][j - 1];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }
}
