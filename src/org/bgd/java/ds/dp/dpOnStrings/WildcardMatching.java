package org.bgd.java.ds.dp.dpOnStrings;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/wildcard-matching/">...</a>
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 *
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return isMatchMemo(s, p, s.length() - 1, p.length() - 1, dp);
    }

    /**
     * Recursive
     */

    private boolean isMatchRec(String s, String p, int i, int j) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (i >= 0 && j < 0) {
            return false;
        }

        if (i < 0 && j >= 0) {
            for (int x = 0; x <= j; x++) {
                if (p.charAt(x) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return isMatchRec(s, p, i - 1, j - 1);
        }
        if (p.charAt(j) == '*') {
            return isMatchRec(s, p, i - 1, j) || isMatchRec(s, p, i, j - 1);
        }
        return false;
    }

    /**
     * Memoized
     */

    private boolean isMatchMemo(String s, String p, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (i >= 0 && j < 0) {
            return false;
        }

        if (i < 0) {
            for (int x = 0; x <= j; x++) {
                if (p.charAt(x) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = isMatchMemo(s, p, i - 1, j - 1, dp) ? 1 : 0;
            return dp[i][j] == 1;
        }
        if (p.charAt(j) == '*') {
            dp[i][j] = (isMatchMemo(s, p, i - 1, j, dp) || isMatchMemo(s, p, i, j - 1, dp)) ? 1 : 0;
            return dp[i][j] == 1;
        }
        return false;
    }

    /**
     * Tabulation
     */

    private boolean isMatchTabul(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= n; j++) {
            boolean flag = true;
            for (int x = 1; x <= j; x++) {
                if (p.charAt(x - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}
