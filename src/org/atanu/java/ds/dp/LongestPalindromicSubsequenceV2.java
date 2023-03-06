package org.atanu.java.ds.dp;

//https://leetcode.com/problems/longest-palindromic-subsequence/description/
//Leetcode 516

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/39P3Kxknlnr

//Bottom ip Visualization check needed
public class LongestPalindromicSubsequenceV2 {
    public int longestPalindromeSubseq(String s) {
        // Initializing a lookup table of dimensions len(s) x len(s)
        int lookupTable[][] = new int[s.length()][s.length()];

        // Every sequence with one element is a palindrome of length 1
        for (int i = 0; i< s.length(); i++)
            lookupTable[i][i]=1;

        for (int startIndex = s.length() -1; startIndex >= 0; startIndex--)
            for (int endIndex = startIndex + 1; endIndex < s.length(); endIndex++)

                // case 1: elements at the beginning and the end are the same
                if ( s.charAt(startIndex) == s.charAt(endIndex)){
                    lookupTable[startIndex][endIndex] = 2 + lookupTable[startIndex + 1][endIndex - 1];
                }

                // case 2: skip one element either from the beginning or the end
                else{
                    lookupTable[startIndex][endIndex]= Math.max(lookupTable[startIndex + 1][endIndex], lookupTable[startIndex][endIndex - 1]);
                }
        return lookupTable[0][s.length()-1];
    }
}
