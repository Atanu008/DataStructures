package org.atanu.java.ds.dp;

import java.util.*;
//https://leetcode.com/problems/concatenated-words/description/
//Leetcode 472
public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length()); // This is an optimization

        Set<String> set = new HashSet<>(); // We could add all the words here
        List<String> result = new ArrayList<>();
        for(String word : words){
            if(canConcatinate(word, 0, set, new Boolean[word.length()])){
                result.add(word);
            }
            set.add(word); // As the words are sorted for big word we would always have small words added before
        }

        return result;
    }
    //Word Break Problem
    private boolean canConcatinate(String word, int start, Set<String> wordSet, Boolean[] dp){

        if(start == word.length()){
            return true;
        }

        if(dp[start] != null){
            return dp[start];
        }

        for(int end = start + 1; end <= word.length(); end++){
            if(wordSet.contains(word.substring(start, end)) && canConcatinate(word, end, wordSet, dp)){
                return dp[start] = true;
            }
        }

        return dp[start] = false;

    }

    public static void main(String[] args) {
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String > result = concatenatedWords.findAllConcatenatedWordsInADict(words);
        result.forEach(System.out::println);
    }
}
