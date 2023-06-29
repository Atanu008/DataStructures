package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// LeetCode 3
// Some times also called Longest Substring with Distinct Characters
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int windowEnd = 0;
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(windowEnd < s.length()){

            char rightChar = s.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) +1);

            while(map.get(rightChar) > 1){
                char leftChar = s.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) -1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart +1);
            windowEnd++;
        }

        return maxLength;
    }

    //Same solution as above . but using character
    public int lengthOfLongestSubstringV2(String s) {

        int[] frequency = new int[128];

        int left = 0;
        int right = 0;

        int max = 0;
        while(right < s.length()){

            char ch = s.charAt(right);
            frequency[ch]++;

            while(frequency[ch] > 1){
                char temp = s.charAt(left);
                frequency[temp]--;
                left++;
            }

            max = Math.max(max, right-left+1);
            right++;
        }

        return max;
    }

   //keep a hashmap which stores the characters in string as keys and their positions as values,
   //and keep two pointers which define the max substring. move the right pointer to scan through the string ,
   //and meanwhile update the hashmap. If the character is already in the hashmap,
   //then move the left pointer to the right of the same character last found.
   //Note that the two pointers can only move forward.

    public int lengthOfLongestSubstringV3(String s) {
        int windowEnd = 0;
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(windowEnd < s.length()){

            char rightChar = s.charAt(windowEnd);
            if(map.containsKey(rightChar)){
                windowStart = Math.max(windowStart, map.get(rightChar)  + 1);
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart +1);
            map.put(rightChar, windowEnd);
            windowEnd++;
        }

        return maxLength;
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters withoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("Length of the longest substring: " + withoutRepeatingCharacters.lengthOfLongestSubstringV3("aabccbb"));
        System.out.println("Length of the longest substring: " + withoutRepeatingCharacters.lengthOfLongestSubstringV3("abbbb"));
        System.out.println("Length of the longest substring: " + withoutRepeatingCharacters.lengthOfLongestSubstringV3("abccde"));
    }
}
