package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
//LeetCode 340

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String str, int k) {
        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();

        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        while (windowEnd < str.length()) {

            char rightchar = str.charAt(windowEnd);

            map.put(rightchar, map.getOrDefault(rightchar, 0) + 1);

            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (map.size() > k) {

                char leftChar = str.charAt(windowStart);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                windowStart++;

            }

            //maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

            if (windowEnd - windowStart + 1 > maxLength) {
                maxLength = windowEnd - windowStart + 1;
                start = windowStart;
                end = windowEnd;
            }
            //Expand the right window
            windowEnd++;
        }

        //System.out.print("Longest Substring with K Distinct " + str.substring(start, end + 1) + "   ");

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters longestSubstring = new LongestSubstringWithAtMostKDistinctCharacters();
        String s = "eceba";
        int k = 2;
        //Output: 3
        //Explanation: The substring is "ece" with length 3.
        System.out.println(longestSubstring.lengthOfLongestSubstringKDistinct(s,k));
    }
}
