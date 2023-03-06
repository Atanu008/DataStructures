package org.atanu.java.ds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> ans = new ArrayList<>();
        for(String word : words){
            if(match(word, pattern)){
                ans.add(word);
            }
        }

        return ans;
    }

    private boolean match(String word, String pattern){

        if(word.length() != pattern.length()){
            return false;
        }
        Map<Character, Character> wordToPattern = new HashMap<>();
        Map<Character, Character> patternToWord = new HashMap<>();

        for(int i = 0; i < word.length(); i++){
            Character w = word.charAt(i);
            Character p = pattern.charAt(i);

            wordToPattern.putIfAbsent(w, p);
            patternToWord.putIfAbsent(p, w);

            if(wordToPattern.get(w) != p || patternToWord.get(p) != w){
                return false;
            }
        }

        return true;
    }
}
