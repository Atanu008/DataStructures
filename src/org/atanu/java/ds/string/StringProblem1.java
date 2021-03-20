package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringProblem1 {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int result = 0;

        //Define Left and Right Pointer
        //Keep an window and expand right side of the window
        //Update the left Pointer if we have any common character
        for (int low = 0, high = 0; high < s.length(); high++) {

            if (map.containsKey(s.charAt(high))) {
                low = Math.max(map.get(s.charAt(high)), low);
            }

            result = Math.max(result, high - low);
            map.put(s.charAt(high), high);
        }

        return result;
    }

    public int lengthOfLongestSubstringSol2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public static void main(String[] args) {


    }

}
