package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/permutation-in-string/
// LeetCode 567
// Same Pattern used as
// https://leetcode.com/problems/minimum-window-substring/
// LeetCode 76
public class PermutationInString {

    public boolean checkInclusion(String t, String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int count = t.length();
        int windowStart = 0;
        int windowEnd = 0;

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

            while(count == 0) {
                // Count 0 means we have all the character from pattern
                // But it if the window length is same as the pattern/target
                // then the window is the anagram/permutation of the pattern
                if(windowEnd - windowStart + 1 == t.length()){
                    return true;
                }
                char startChar = s.charAt(windowStart);

                if(map.containsKey(startChar)){
                    map.put(startChar, map.get(startChar) + 1);
                    // Update the counter only when if the removal of this starChar will make the window invalid
                    // and that is freq > 0 after incrementing the freq
                    // map.get(startChar) > 0 means this char does not belong to the patter
                    // Make the window invalid i.e count++;
                    if(map.get(startChar) > 0){
                        count++;
                    }
                }
                windowStart++;
            }
            windowEnd++;
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        String t = "ab", s = "eidbaooo";
        System.out.println(permutationInString.checkInclusion(t,s));
        t = "ab";
        s = "eidboaoo";
        System.out.println(permutationInString.checkInclusion(t,s));

    }
}
