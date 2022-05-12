package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/ransom-note/
//LeetCode 383
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] letters = new int[26];

        for(char ch : magazine.toCharArray()){
            letters[ch - 'a']++;
        }

        for(char ch : ransomNote.toCharArray()){
            if(--letters[ch - 'a'] < 0){
                return false;
            }
        }

        return true;
    }

    public boolean canConstructV2(String ransomNote, String magazine) {

        Map<Character, Integer> magazineFreq = new HashMap<>();

        for(char ch : magazine.toCharArray()){
            magazineFreq.put(ch, magazineFreq.getOrDefault(ch , 0) + 1);
        }

        for(char ch : ransomNote.toCharArray()){

            int count = magazineFreq.getOrDefault(ch, 0) - 1;
            if(count < 0){
                return false;
            }
            magazineFreq.put(ch,count);

        }

        return true;
    }
}
