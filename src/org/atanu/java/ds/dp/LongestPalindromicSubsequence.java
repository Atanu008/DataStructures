package org.atanu.java.ds.dp;

//https://leetcode.com/problems/longest-palindromic-subsequence/description/
//Leetcode 516

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/39P3Kxknlnr
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return longestPalindromeSubseq(s, 0, s.length() - 1, dp);
    }

    public int longestPalindromeSubseq(String s, int startIndex, int endIndex, Integer[][] dp) {
        // Every sequence with one element is a palindrome of length 1
        if(startIndex == endIndex){
            return 1;
        }
        if(startIndex > endIndex){
            return 0;
        }

        if(dp[startIndex][endIndex] != null){
            return dp[startIndex][endIndex];
        }
        // case 1: elements at the beginning and the endIndex are the same
        if(s.charAt(startIndex) == s.charAt(endIndex)){
            return dp[startIndex][endIndex] = 2 + longestPalindromeSubseq(s, startIndex + 1, endIndex - 1, dp);
        }
        // case 2: skip one element either from the beginning or the endIndex
        return dp[startIndex][endIndex] =  Math.max(longestPalindromeSubseq(s, startIndex + 1, endIndex, dp),
                longestPalindromeSubseq(s, startIndex, endIndex - 1, dp));
    }
}
