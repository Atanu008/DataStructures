package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/word-pattern/
//LeetCode 290
//Same As IsomorphicString
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        Map<Character, String> mapPatternToS = new HashMap<>();
        Map<String, Character> mapSToPattern = new HashMap<>();

        if(pattern.length() != words.length){
            return false;
        }

        for(int i = 0 ; i < pattern.length(); i++){
            Character patternChar = pattern.charAt(i);
            String word = words[i];

            if(mapPatternToS.containsKey(patternChar)){
                if(!mapPatternToS.get(patternChar).equals(word)){
                    return false;
                }
            }
            if(mapSToPattern.containsKey(word)){
                if((mapSToPattern.get(word) != patternChar)){
                    return false;
                }
            }

            mapPatternToS.put(patternChar, word);
            mapSToPattern.put(word, patternChar);

        }
        return true;
    }


    //Using One Map. However containsValue is O(N) operation
    //Video : https://www.youtube.com/watch?v=dnlB0lvz5LY
    public boolean wordPatternV2(String pattern, String s) {

        String[] words = s.split(" ");
        Map<Character, String> map = new HashMap<>();

        if(pattern.length() != words.length){
            return false;
        }

        for(int i = 0 ; i < pattern.length(); i++){
            Character patternChar = pattern.charAt(i);
            String word = words[i];

            if(map.containsKey(patternChar)){
                if(!map.get(patternChar).equals(word)){
                    return false;
                }
            }
            else{
                if(map.containsValue(word)){
                    return false;
                }

                map.put(patternChar, word);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern(pattern, s));
        pattern = "abba"; s = "dog cat cat fish";
        System.out.println(wordPattern.wordPattern(pattern, s));
    }
}
