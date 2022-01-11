package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/
//LeetCode 76
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int count = t.length();
        int windowStart = 0;
        int windowEnd = 0;
        int minLength = s.length(); // Can be put Integer.MAX_VALUE
        int start = 0;
        int end = 0;
        boolean found = false;

        while (windowEnd < s.length()) {

            char ch = s.charAt(windowEnd);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                //Update Count only if the Character is present in T(i.e map)
                //And the occurrence matches with T
                if (map.get(ch) >= 0) {
                    count--;
                }

            }
            // When we found a valid window, move start to find smaller window.
            // If the start character is not present in T , then just skip it
            //Otherwise update the Count and try to invalidate the window
            while (count == 0) {

                found = true;
                int currentMinLength = windowEnd - windowStart + 1;
                //Update Min
                if (currentMinLength <= minLength) {
                    minLength = currentMinLength;
                    start = windowStart;
                    end = windowEnd;
                }
                char startChar = s.charAt(windowStart);

                if(map.containsKey(startChar)){
                    map.put(startChar, map.get(startChar) + 1);
                    //Update the counter only when if the removal of this starChar will make the window invalid
                    // and that is freq > 0 after incrementing the freq
                    if(map.get(startChar) > 0){
                        count++;
                    }
                }
                windowStart++;
            }
            windowEnd++;
        }

        return found ? s.substring(start, end+1) : "";
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "aa";
        String t = "aa";
        System.out.println(minimumWindowSubstring.minWindow(s,t));
    }
}
