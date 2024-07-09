package org.bgd.java.ds.strings;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 *
 * You are given a string s. You can convert s to a
 * palindrome
 *  by adding characters in front of it.
 *
 * Return the shortest palindrome you can find by performing this transformation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: "dcbabcd"
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse()
          .toString();
        StringBuilder newString = new StringBuilder(s + '*' + rev);

        int[] lps = new int[newString.length()];
        int j = 0, i = 1;
        while (i < newString.length()) {
            if (newString.charAt(i) == newString.charAt(j)) {
                j += 1;
                lps[i] = j;
                i += 1;
            } else {
                if (j == 0) {
                    lps[i] = 0;
                    i += 1;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        int max = lps[lps.length - 1];
        return rev.substring(0, s.length() - max) + s;

    }
}
