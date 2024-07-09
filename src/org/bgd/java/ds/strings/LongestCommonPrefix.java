package org.bgd.java.ds.strings;

/**
 * https://leetcode.com/problems/longest-common-prefix/editorial/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    /**
     * Scanning all strings approach
     * @param strs
     * @return
     */

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    /**
     * Binary Search based
     */
    public String longestCommonPrefixWithBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minlen = Integer.MAX_VALUE;

        for (String s : strs) {
            minlen = Math.min(minlen, s.length());
        }
        int l = 1, r = minlen;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isCommon(strs, m)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return strs[0].substring(0, (l + r) / 2);
    }

    private boolean isCommon(String[] s, int l) {
        String str1 = s[0].substring(0, l);
        for (int i = 1; i < s.length; i++) {
            if (!s[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }
}
