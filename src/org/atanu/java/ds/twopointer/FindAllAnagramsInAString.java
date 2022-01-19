package org.atanu.java.ds.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
//LeetCode 438
//Exactlu same as permutation-in-string . Here we just need to record start window.
//https://leetcode.com/problems/permutation-in-string/
//LeetCode 567
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> anagramIndexes = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for(char c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int count = p.length();
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
                anagramIndexes.add(windowStart);
            }
            //If the window size is greater than the length of the pattern, shrink the window to make it equal to the pattern’s size
            if (windowEnd >= p.length() - 1) {

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

        return anagramIndexes;
    }
}
