package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-repeating-character-replacement/
//LeetCode 424
//Video : https://www.youtube.com/watch?v=gqXU1UyA8pk
//Key Idea: Adding characters to the window and use the map to track the number of dominant char(meaning the character that counts the most in the window).
//Expanding the window as wide as it can be until window size - number of dominant character > k which means there are at least k characters are not same as the dominant character,
//so we need shrink the window from the left side and also update the character count in the map.
public class LongestRepeatingCharacterReplacement {

    //Mo
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        int windowEnd = 0;
        int windowStart = 0;
        int longestSubstring = Integer.MIN_VALUE;

        while(windowEnd < s.length()){
            char endChar = s.charAt(windowEnd);
            frequencyMap.put(endChar, frequencyMap.getOrDefault(endChar, 0) +1);

            int maxWindowFrequency = getMaxWindowFrequency(frequencyMap);

            while((windowEnd - windowStart +1) - maxWindowFrequency > k){
                char startChar = s.charAt(windowStart);
                frequencyMap.put(startChar, frequencyMap.get(startChar) -1);

                if(frequencyMap.get(startChar) == 0){
                    frequencyMap.remove(startChar);
                }
                windowStart++;
            }

            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart +1);
            windowEnd++;
        }

        return longestSubstring;
    }

    private int getMaxWindowFrequency(Map<Character, Integer> frequencyMap){

        int max = 0;
        for(int a :frequencyMap.values()){
            max = Math.max(max ,a);
        }

        return max;
    }


    // IMPORTANT: maxRepeat is not the accurate number of dominant character, It is the historical maximum count
    // We do not care about it because unless it gets greater, it won't affect our final max window size.
    int maxRepeat = 0;
    public int characterReplacementV2(String s, int k) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        int windowEnd = 0;
        int windowStart = 0;
        int maxRepeat = 0;
        int longestSubstring = Integer.MIN_VALUE;

        while(windowEnd < s.length()){
            char endChar = s.charAt(windowEnd);
            frequencyMap.put(endChar, frequencyMap.getOrDefault(endChar, 0) +1);

            maxRepeat = Math.max(maxRepeat, frequencyMap.get(endChar));

            while((windowEnd - windowStart +1) - maxRepeat > k){
                char startChar = s.charAt(windowStart);
                frequencyMap.put(startChar, frequencyMap.get(startChar) -1);

                if(frequencyMap.get(startChar) == 0){
                    frequencyMap.remove(startChar);
                }
                windowStart++;
            }

            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart +1);
            windowEnd++;
        }

        return longestSubstring;
    }
}
