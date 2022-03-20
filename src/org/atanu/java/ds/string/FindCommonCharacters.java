package org.atanu.java.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-common-characters/
//LeetCode 1002
public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {

        int[] commonCount = new int[26];
        Arrays.fill(commonCount, Integer.MAX_VALUE);

        for(String word : words) {

            int[] charCountInEachWord = new int[26];
            for(char ch : word.toCharArray()){
                charCountInEachWord[ch -'a']++;
            }
            for(int i = 0; i < 26; i++) {
                commonCount[i] = Math.min(commonCount[i], charCountInEachWord[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for(char ch = 'a'; ch <= 'z'; ch++) {
            while(commonCount[ch - 'a'] --> 0){
                String a = ""+ch;
                result.add(a);
            }
        }

        return result;
    }
}
