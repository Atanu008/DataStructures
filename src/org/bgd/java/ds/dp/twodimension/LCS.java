package org.bgd.java.ds.dp.twodimension;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 *
 * 1143. Longest Common Subsequence
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 */
public class LCS {

    public int longestCommonSubsequence(String text1, String text2) {
        int r = text1.length();
        int c = text2.length();
        int[][] dp = new int[r + 1][c + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return lcsMemo(text1, text2, 0, 0, dp);
    }

    // Recursive solution
    private int lcs(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + lcs(text1, text2, i + 1, j + 1);
        }
        return Math.max(lcs(text1, text2, i + 1, j), lcs(text1, text2, i, j + 1));
    }

    // Dynamic programming memoization
    private int lcsMemo(String text1, String text2, int i, int j, int[][] dp) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + lcsMemo(text1, text2, i + 1, j + 1, dp);
        } else {
            dp[i][j] = Math.max(lcsMemo(text1, text2, i + 1, j, dp), lcsMemo(text1, text2, i, j + 1, dp));
        }
        return dp[i][j];
    }
}
