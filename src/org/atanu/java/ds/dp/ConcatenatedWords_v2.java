package org.atanu.java.ds.dp;

import java.util.*;

//https://leetcode.com/problems/concatenated-words/description/
//Leetcode 472
public class ConcatenatedWords_v2 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length()); // This is an optimization

        Set<String> set = new HashSet<>(); // We could add all the words here
        List<String> result = new ArrayList<>();
        for(String word : words){
            if(canConcatinate(word, set)){
                result.add(word);
            }
            set.add(word); // As the words are sorted for big word we would always have small words added before
        }

        return result;
    }
    //Word Break Problem
    private boolean canConcatinate(String word, Set<String> wordSet){
        if(wordSet.isEmpty()){
            return false;
        }

        int[] dp = new int[word.length()];

        for(int end = 0; end < word.length(); end ++){
            for(int start = 0; start <= end; start++){
                String wordToCheck = word.substring(start,end+1);
                if(wordSet.contains(wordToCheck)){
                    if(start > 0){
                        dp[end] += dp[start -1];
                    }
                    else{
                        dp[end] += 1;
                    }
                }
            }
        }
        return dp[word.length() - 1] > 0;
    }

    public static void main(String[] args) {
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String > result = concatenatedWords.findAllConcatenatedWordsInADict(words);
        result.forEach(System.out::println);
    }
}
