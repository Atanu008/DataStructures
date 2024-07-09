package org.bgd.java.ds.strings;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">...</a>
 *
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicString {
    public String longestPalindrome(String s) {
        int[] ans = new int[] { 0, 0 };
        int max = 0;
        String palindrome = "";
        for (int i = 0; i < s.length(); i++) {
            int oddPalindrome = checkFromCenter(s, i, i);
            if (oddPalindrome > ans[1] - ans[0] + 1) {
                int d = oddPalindrome / 2;
                ans[0] = i - d;
                ans[1] = i + d;
            }
            int evenPalindrome = checkFromCenter(s, i, i + 1);
            if (evenPalindrome > ans[1] - ans[0] + 1) {
                int d = oddPalindrome / 2 - 1;
                ans[0] = i - d;
                ans[1] = i + 1 + d;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }

    private int checkFromCenter(String s, int i, int j) {
        int left = i, right = j;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
