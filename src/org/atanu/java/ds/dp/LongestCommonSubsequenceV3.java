package org.atanu.java.ds.dp;

//https://leetcode.com/problems/longest-common-subsequence/
//Leetcode 1143

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/JEDQk5qglp9

//Reverse the given sequence. Let’s call the original sequence original. Let’s call the reversed sequence reverse.
//Use the LCS algorithm to find the longest common subsequence between original and reverse. Let LCS(original, reverse) be a function that returns the longest common subsequence between the pair of strings.
//The answer from LCS will, in fact, be the longest palindromic subsequence.
public class LongestCommonSubsequenceV3 {
    public int longestPalindromeSubseq(String s) {
        String reverseString = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, reverseString);
    }
    public  int longestCommonSubsequence(String str1, String str2){

        int m = str1.length() + 1;
        int n = str2.length() + 1;

        int[][] dp = new int[m][n];
        //Dont need to full DP with some values for empty string and other combination its zero only

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // If the characters at this position match,
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    // add 1 to the previous diagonal and store it in this diagonal
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    // If the characters don't match, fill this entry with the max of the
                    // left and top elements
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
