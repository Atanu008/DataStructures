package org.bgd.java.ds.dp.dpOnStrings;

import java.util.Arrays;

public class LCS {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return lcsMemo(text1, text1.length() - 1, text2, text2.length() - 1, dp);
    }

    private int lcsRec(String text1, int i, String text2, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + lcsRec(text1, i - 1, text2, j - 1);
        }
        return Math.max(lcsRec(text1, i - 1, text2, j), lcsRec(text1, i, text2, j - 1));
    }

    /**
     * Memoization
     */

    private int lcsMemo(String text1, int i, String text2, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + lcsMemo(text1, i - 1, text2, j - 1, dp);

        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Math.max(lcsMemo(text1, i - 1, text2, j, dp), lcsMemo(text1, i, text2, j - 1, dp));
        return dp[i][j];
    }

    /**
     * Tabulation with index normalization
     */
    private int lcsTabulation(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
