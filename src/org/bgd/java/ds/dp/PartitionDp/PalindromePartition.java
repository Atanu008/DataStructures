package org.bgd.java.ds.dp.PartitionDp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning-ii/">...</a>
 *
 *Given a string s, partition s such that every
 * substring of the partition is a palindrome
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * Example 1:
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * <p>
 * Example 2:
 * Input: s = "a"
 * Output: 0
 * <p>
 * Example 3:
 * Input: s = "ab"
 * Output: 1
 */
public class PalindromePartition {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return minCutMemo(s, 0, dp) - 1;
    }

    private int minCutRec(String s, int i) {
        if (i == s.length()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                int c = 1 + minCutRec(s, j);
                min = Math.min(min, c);
            }
        }
        return min;
    }

    private int minCutMemo(String s, int i, int[] dp) {
        if (i == s.length()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if (dp[i] != -1) {
            return dp[i];
        }

        for (int j = i; j < s.length(); j++) {

            if (isPalindrome(s, i, j)) {
                int c = 1 + minCutMemo(s, j + 1, dp);
                min = Math.min(min, c);
            }
        }
        return dp[i] = min;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}



