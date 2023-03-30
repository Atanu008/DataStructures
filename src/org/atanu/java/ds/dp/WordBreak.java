package org.atanu.java.ds.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/
//LeetCode 139
public class WordBreak {

    //Recursion. Time Limit Exceeded in LeetCode
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

        for (int end = start+1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    //Memoization . Top Down DP
    public boolean wordBreakV2(String s, List<String> wordDict) {
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }

        if(memo[start] != null){
            return memo[start];
        }

        for (int end = start+1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }
        return memo[start] = false;
    }

    //Bottom Up
    //Video : https://www.youtube.com/watch?v=2NaaM_z_Jig
    public boolean wordBreakV3(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];


        for(int end = 0; end < s.length(); end ++){
            for(int start = 0; start <= end; start++){
                String wordToCheck = s.substring(start,end+1);
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
        return dp[s.length() - 1] > 0;
    }

    //Same as version 3 . Little modification in loop parameter
    public boolean wordBreakV3a(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int[] dp = new int[s.length() + 1];

        for(int end = 1; end <= s.length(); end ++){
            for(int start = 0; start < end; start++){
                String wordToCheck = s.substring(start,end);
                if(wordSet.contains(wordToCheck)){
                    if(start > 0){
                        dp[end] += dp[start];
                    }
                    else{
                        dp[end] += 1;
                    }
                }
            }
        }
        return dp[s.length()] > 0;
    }

    public boolean wordBreakV4(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for(int end = 1; end <= s.length(); end ++){
            for(int start = 0; start < end; start++){
                String wordToCheck = s.substring(start,end);
                if(dp[start] && wordSet.contains(wordToCheck)){
                    dp[end] = true;
                    //break;
                }
            }
        }
        return dp[s.length()];
    }
}
