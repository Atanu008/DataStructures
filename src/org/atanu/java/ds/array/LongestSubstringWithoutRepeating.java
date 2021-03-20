package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int result = 0;
        int start = 0;
        int end = 0;
        for (int j = 0; j < s.length(); j++) {

            char ch = s.charAt(j);

            if (map.containsKey(ch)) {

                i = Math.max(i, map.get(ch));
            }

            if (j - i + 1 > result) {
                result = j - i + 1;

                start = i;
                end = j;
            }
            result = Math.max(result, j - i + 1);

            map.put(ch, j + 1);
        }

        System.out.println("Substring " + s.substring(start, end + 1));
        return result;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println("Longest length " + lengthOfLongestSubstring(s));

        String s1 = "pwwkew";
        System.out.println("Longest length " + lengthOfLongestSubstring(s1));

    }

}
