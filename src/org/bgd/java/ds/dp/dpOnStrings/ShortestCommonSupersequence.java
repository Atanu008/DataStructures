package org.bgd.java.ds.dp.dpOnStrings;

/**
 * <a href="https://leetcode.com/problems/shortest-common-supersequence/">...</a>
 *
 * 1092. Shortest Common Supersequence
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
 *
 * A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation:
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 * Example 2:
 *
 * Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
 * Output: "aaaaaaaa"
 */
public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                result.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) { // moving upward, so take from s
                result.append(s.charAt(i - 1));
                i--;
            } else {
                result.append(t.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            result.append(s.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            result.append(t.charAt(j - 1));
            j--;
        }
        return result.reverse()
          .toString();
    }
}
