package org.atanu.java.ds.string;

//https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
//LeetCode 828

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Amazing Intutive Explanation : https://www.youtube.com/watch?v=eN8zATT702M
public class CountUniqueCharactersOfAllSubstringsOfAGivenString {

    public int uniqueLetterString(String s) {

        Map<Character, List<Integer>> charToIndexMapping = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            charToIndexMapping.putIfAbsent(ch, new ArrayList<>());
            charToIndexMapping.get(ch).add(i);
        }

        int sum = 0;
        for(List<Integer> indices : charToIndexMapping.values()){

            for(int i = 0; i < indices.size(); i++){
                int left = i == 0 ? indices.get(i) + 1 : indices.get(i) - indices.get(i-1);
                int right = i == indices.size() -1 ? s.length() - indices.get(i) : indices.get(i+1) - indices.get(i);
                sum += left * right;
            }
        }

        return sum;
    }
}
