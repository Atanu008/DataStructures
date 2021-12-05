package org.atanu.java.ds.dp;

import java.util.*;

//https://leetcode.com/problems/word-break-ii/
//LeetCode 140
//Check APAS
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {

        return wordBreak(s, new HashSet<>(wordDict), 0, new HashMap<>());
    }

    public List<String> wordBreak(String s, HashSet<String> wordSet, int start, Map<Integer, List<String>> map){

        if(map.containsKey(start)){
            return map.get(start);
        }

        List<String> result = new ArrayList<>();
        if(start == s.length()){
            result.add("");
            return result;
        }

        for(int end = start+1; end <= s.length(); end++){
            String word = s.substring(start, end);
            if(wordSet.contains(word)){
                for(String temp : wordBreak(s, wordSet, end , map)){
                    result.add(word + (temp.equals("") ? "" : " ") + temp);
                }
            }
        }

        map.put(start, result);
        return result;
    }

    //Bottom UP DP
    //Check APAS
    public List<String> wordBreakV2(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);
        List<String>[] dp = new ArrayList[s.length() +1];
        List<String> initial = new ArrayList<>();

        initial.add("");
        dp[0] = initial;

        for(int end = 1; end <= s.length(); end++){
            List<String> list = new ArrayList<>();
            for(int start = 0; start < end; start++){
                String word = s.substring(start, end);
                if(dp[start].size() > 0 && wordSet.contains(word)){
                    for(String str : dp[start]){
                        list.add(str + (str.equals("") ? "" : " ") + word);
                    }
                }
            }
            dp[end] = list;
        }

        return dp[s.length()];
    }
}
