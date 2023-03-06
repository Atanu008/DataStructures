package org.atanu.java.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;

//A Variation of Longest Palindromic subsequence

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/m7mogE3k269

public class MinimumDeletionsInAStringToMakeItAPalindrome {

    //number of minimum deletions as:
    //Length(s)−LPS(s)
    //Suppose we have String length 8
    //Longest palindromic sequence is 5
    //So how many elements left that are not part of palindrimic subsequence : 8 - 5 = 3
    //So if we delete these elements that String would be palindromic

    public int minimumDeletions(String s) {
        int length = s.length();
        Integer[][] dp = new Integer[length][length];
        return length - longestPalindromicSubsequence(s, 0, length - 1, dp);
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

    public static void main(String[] args) {

        MinimumDeletionsInAStringToMakeItAPalindrome makeItAPalindrome = new MinimumDeletionsInAStringToMakeItAPalindrome();
        ArrayList< String > strings = new ArrayList < String > (
                Arrays.asList("raddar", "lleveal", "aqwrqhanisahinahqwe", "pqr")
        );

        // Let's uncomment this and check the effect of dynamic programming using memoization

        // strings.add("aeqirradarqwruifdfgdtrrrraaadddaqweraarrr");

        int index = 0;
        for (String input: strings) {
            System.out.println((++index) + ". The minimum deletions required to make '" + input + "' a palindrome is: "
                    + makeItAPalindrome.minimumDeletions(input));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
