package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
//LeetCode 159
//same as https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
//Here K = 2
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // sliding window left and right pointers
        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(windowEnd < s.length()){

            char endChar = s.charAt(windowEnd);
            map.put(endChar , map.getOrDefault(endChar,0) +1);

            // sliding window contains more than 2 characters
            // So thats a invalid window . we want at most i.e lesser or equal to k(2)
            // Shrink the window from left until it become valid . i.e map.size() <= 2
            while(map.size() > 2){
                char startChar = s.charAt(windowStart);
                map.put(startChar, map.get(startChar) -1);
                // delete the leftmost character
                if(map.get(startChar) == 0){
                    map.remove(startChar);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart +1);

            windowEnd++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters longestSubstring = new LongestSubstringWithAtMostTwoDistinctCharacters();
        String s = "eceba";
        //Output: 3
        //Explanation: The substring is "ece" with length 3.
        System.out.println(longestSubstring.lengthOfLongestSubstringTwoDistinct(s));

        s = "aaaa";
        //Output: 3
        //Explanation: The substring is "ece" with length 3.
        System.out.println(longestSubstring.lengthOfLongestSubstringTwoDistinct(s));

        s = "";
        //Output: 3
        //Explanation: The substring is "ece" with length 3.
        System.out.println(longestSubstring.lengthOfLongestSubstringTwoDistinct(s));
    }
}
