package org.bgd.java.ds.dp.dpOnStrings;

/**
 * https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
 *
 * Given two strings. The task is to find the length of the longest common substring.
 *
 *
 * Example 1:
 *
 * Input: S1 = "ABCDGH", S2 = "ACDGHR", n = 6, m = 6
 * Output: 4
 * Explanation: The longest common substring
 * is "CDGH" which has length 4.
 * Example 2:
 *
 * Input: S1 = "ABC", S2 "ACB", n = 3, m = 3
 * Output: 1
 * Explanation: The longest common substrings
 * are "A", "B", "C" all having length 1.
 */
public class LongestCommonSubstring {
    /**
     * Direct Tabulation
     */

    int longestCommonSubstr(String S1, String S2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int longest = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                longest = Math.max(longest, dp[i][j]);
            }
        }

        return longest;
    }
}
