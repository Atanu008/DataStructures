package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/permutation-in-string/
//LeetCode 567
//Same Pattern used as
//https://leetcode.com/problems/minimum-window-substring/
//LeetCode 76
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
            //When we have found all the pattern chars in Source
            //Return true
            if(count == 0){
                return true;
            }
            //If the window size is greater than the length of the pattern, shrink the window to make it equal to the pattern’s size
            if (windowEnd >= t.length() - 1) {

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
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(permutationInString.checkInclusion(s1,s2));
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(permutationInString.checkInclusion(s1,s2));

    }
}
