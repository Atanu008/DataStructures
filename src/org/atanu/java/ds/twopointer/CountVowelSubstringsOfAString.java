package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/count-vowel-substrings-of-a-string/description/
// Leetcode 2062
// Check This for explanation https://leetcode.com/problems/subarrays-with-k-different-integers/description/

public class CountVowelSubstringsOfAString {

    public int countVowelSubstrings(String word) {
        return subStringWithAtMostKVowel(word, 5) - subStringWithAtMostKVowel(word, 4);
    }

    private int subStringWithAtMostKVowel(String s, int k) {

        int windowEnd = 0;
        int windowStart = 0;
        int numberOfsubString = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(windowEnd < s.length()){
            char end = s.charAt(windowEnd);
            if(!isVowel(end)){
                // If NOT Vowel, start a fresh window as the previous substring is invalid
                windowStart = windowEnd + 1;
                map.clear();
            }
            else {
                map.put(end, map.getOrDefault(end, 0) + 1);
                while(map.size() > k){
                    char start = s.charAt(windowStart);
                    map.put(start, map.get(start) - 1);
                    if(map.get(start) == 0){
                        map.remove(start);
                    }
                    // Shrink the window
                    windowStart++;
                }
                numberOfsubString += windowEnd - windowStart + 1;
            }
            //Expand the right window
            windowEnd++;
        }

        return numberOfsubString;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u';
    }

    // Brute Force
    public int countVowelSubstrings_v2(String word) {
        int result= 0;

        for(int i = 0; i < word.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j = i; j < word.length(); j++){
                char ch = word.charAt(j);
                if(!isVowel(ch)){
                    set.clear();
                    break; // NOT possible to have substring with vowel
                }
                else {
                    set.add(ch);
                    if(set.size() == 5){
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountVowelSubstringsOfAString countVowelSubstringsOfAString = new CountVowelSubstringsOfAString();
        String word = "aeiouu";
        int result = countVowelSubstringsOfAString.countVowelSubstrings(word);
        //Explanation: The vowel substrings of word are as follows (underlined):
        //- "aeiouu"
        //- "aeiouu"
        System.out.println(result);

        result = countVowelSubstringsOfAString.countVowelSubstrings_v2(word);
        System.out.println(result);
    }
}
