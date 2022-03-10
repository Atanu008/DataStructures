package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
//LeetCode 1941
public class CheckAllCharactersHaveEqualNumberOfOccurrences {

    public boolean areOccurrencesEqual(String s) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) +1);
        }

        int firstCharFrequency = frequencyMap.get(s.charAt(0));

        for(int frequency : frequencyMap.values()) {
            if(frequency != firstCharFrequency){
                return false;
            }
        }

        return true;
    }
}
