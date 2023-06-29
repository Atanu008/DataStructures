package org.atanu.java.ds.twopointer;

//This Divide and conquer
//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
//LeetCode 395
//Need to refactor Code : ToDo
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * Given a String s and an integer k, return the longest "valid" substring,
     * where a substring is valid iff every character in the substring occurs
     * at least k times.
     *
     * @param s The given String
     * @param k The minimum number of times all substring characters must occur
     * @return The length of the longest valid substring
     */
    public int longestSubstring(String s, int k) {

        // Call divide and conquer helper method
        return div(s, 0, s.length(), k);
    }

    /**
     * Determines the length of the longest valid substring.
     *
     * We achieve this by recursively splitting the given String on characters
     * who do not occur at least k times (since they cannot be part of the
     * longest valid substring).
     *
     * Note that the substring of the current recursion is always equivalent
     * to s.substring(start, end).  For space reasons, we don't ever actually
     * create a new substring.
     *
     * @param s The given String
     * @param start The beginning of the substring, inclusive
     * @param end The end of the substring, exclusive
     * @param k The minimum number of times all substring characters must occur
     * @return The length of the longest valid substring
     */
    private int div(String s, int start, int end, int k) {

        /**
         * Base Case 1 of 2:
         *
         * If this substring is shorter than k, then no characters in it
         * can be repeated k times, therefore this substring and all
         * substrings that could be formed from it are invalid,
         * therefore return 0.
         */
        if (end - start < k) return 0;

        /**
         * Count the frequency of characters in this substring.
         *
         * We are guaranteed from the problem statement that the given String
         * can only contain lowercase (English?) characters, so we use a
         * table of length 26 to store the character counts.
         */
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        // For every character in the above frequency table
        for (int j = start; j < end; j++){
            /**
             * If this character occurs at least once, but fewer than k times
             * in this substring, we know:
             * (1) this character cannot be part of the longest valid substring,
             * (2) the current substring is not valid.
             *
             * Hence, we will "split" this substring on this character,
             * wherever it occurs, and check the substrings formed by that split
             */
            if (freq[s.charAt(j) - 'a'] > 0 && freq[s.charAt(j) - 'a'] < k) {
                /**
                 * Look for each occurrence of this character (i + 'a')
                 * in this substring.
                 * Split" into two substrings to solve recursively
                 */
                 int left = div(s, start, j, k);
                 int right = div(s, j + 1, end, k);
                 return Math.max(left, right);
            }
        }
        /**
         * Base Case 2 of 2:
         *
         * If every character in this substring occurs at least k times,
         * then this is a valid substring, so return this substring's length.
         */
        return end - start;
    }
}
