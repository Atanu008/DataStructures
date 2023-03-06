package org.atanu.java.ds.dp;

//https://leetcode.com/problems/longest-palindromic-substring/description/
//Leetcode 5
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1){
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1; //Initaila One , individial characters would be always palindromw with length 1
        //Base case: single letter substrings
        //Single letter is always palindrome
        //In DP table , all the diagonal elements(left top corner to right bottom corner) will be true.
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        // Base case: double letter substrings
        // If two adjacent character then they are palindrome
        // Mark teh starting point , length = 2
        for(int i = 0; i < n -1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        // All other cases: substrings of length 3 to n
        for(int len = 3; len <= n; len++){
            // Fix the starting index
            //            1 2 3 4 5 6 7 8
            // String s = a b c d e f g h
            //In this case i would max go till f = n - len
            // we need + 1 as i is zero based : n - len + 1
            for(int i = 0; i < n - len + 1; i++){
                // Get the ending index of substring from
                // starting index i and length len
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }
        //System.out.println(maxLength);
        return s.substring(start, start + maxLength);
    }
}
