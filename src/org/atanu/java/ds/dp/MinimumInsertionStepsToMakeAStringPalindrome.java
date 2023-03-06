package org.atanu.java.ds.dp;

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
//Leetcode 1312

//A Variation of Longest Palindromic subsequence

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/m7mogE3k269

public class MinimumInsertionStepsToMakeAStringPalindrome {

    //number of minimum Insertions as:
    //Length(s)−LPS(s)
    //Suppose we have String length 8
    //Longest palindromic sequence is 5
    //So how many elements left that are not part of palindrimic subsequence : 8 - 5 = 3
    //Suppose chars are : c p k
    //No if we add c p k again to the string the whole string would be palindromic
    ////So Length(s)−LPS(s) is the minimum Insertion
    //Deletion and Insertion is same only
    public int minInsertions(String s) {

        int length = s.length();
        Integer[][] dp = new Integer[length][length];
        int longestPalindromicSunsequence =  longestPalindromicSubsequence(s, 0, length -1, dp);

        return length - longestPalindromicSunsequence;
    }

    private int longestPalindromicSubsequence(String s, int startIndex, int endIndex, Integer[][] dp){

        if(startIndex > endIndex){
            return 0;
        }

        // Every sequence with one element is a palindrome of length 1
        if(startIndex == endIndex){
            return 1;
        }
        //From memo
        if(dp[startIndex][endIndex] != null){
            return dp[startIndex][endIndex];
        }
        // Case 1: elements at the beginning and the end are the same
        if(s.charAt(startIndex) == s.charAt(endIndex)){
            return  dp[startIndex][endIndex] = 2 + longestPalindromicSubsequence(s, startIndex + 1, endIndex - 1, dp);
        }
        // Case 2: skip one element either from the beginning or the end
        return dp[startIndex][endIndex] = Math.max(longestPalindromicSubsequence(s, startIndex + 1, endIndex, dp),
                longestPalindromicSubsequence(s, startIndex, endIndex - 1, dp));
    }
}
