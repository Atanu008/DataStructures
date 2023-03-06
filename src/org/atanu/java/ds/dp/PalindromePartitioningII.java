package org.atanu.java.ds.dp;

//https://leetcode.com/problems/palindrome-partitioning-ii/description/
//Leetcode 132

//Video can Refer : https://www.youtube.com/watch?v=_H8V5hJUGd0
public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return findMinimumCut(s, 0, s.length() -1, dp);
    }

    private int findMinimumCut(String s, int start , int end, Integer[][] dp){
        if(start == end || isPalindrome(s, start, end)){
            return 0;
        }

        if(dp[start][end] != null){
            return dp[start][end];
        }

        int minimumCut = end - start + 1;
        //Try cutting the substring
        for (int currentCutIndex = start; currentCutIndex < end; currentCutIndex++) {
            // find result for substring (start, currentEndIndex) if it is palindrome
            // If left portion(start To currentCutIndex) of the cut is palindrome then check for right part
            // We will recurse for only right part
            // Only when left part turns out to be palindrome
            // Reason : If left substring becomes palindrome then there is no need to partition it further
            // (which in turn reduces the number of recursive calls)
            if (isPalindrome(s, start, currentCutIndex)) {
                minimumCut = Math
                        .min(minimumCut, 1 + findMinimumCut(s, currentCutIndex + 1, end, dp));
            }
        }

        return dp[start][end] = minimumCut;
    }

    private boolean isPalindrome(String s, int start, int end){

        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
