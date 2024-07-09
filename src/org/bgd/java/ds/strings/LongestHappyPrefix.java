package org.bgd.java.ds.strings;

/**
 * <a href="https://leetcode.com/problems/longest-happy-prefix/description/">...</a>
 *
 * A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).
 *
 * Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "level"
 * Output: "l"
 * Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
 * Example 2:
 *
 * Input: s = "ababab"
 * Output: "abab"
 * Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
 */
public class LongestHappyPrefix {

    /**
     * This is the preprocessing step of KMP
     * @param s
     * @return
     */
    public String longestPrefix(String s) {
        int m = s.length();
        int[] lps = new int[m];

        int j = 0;

        int i = 1;

        while (i < m) {
            if (s.charAt(i) == s.charAt(j)) {
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
        int max = lps[s.length() - 1];
        return s.substring(0, max);
    }
}
