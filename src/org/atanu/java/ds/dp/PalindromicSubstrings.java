package org.atanu.java.ds.dp;

//https://leetcode.com/problems/palindromic-substrings/description//
//Leetcode 647

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        //Base case: single letter substrings
        //Single letter is always palindrome
        //In DP table , all the diagonal elements(left top corner to right bottom corner) will be true.
        // Count for every individual character i.e ans++
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            ans++;
        }
        // Base case: double letter substrings
        // If two adjacent character then they are palindrome
        // Count if its a palindrome . i.e ans++
        for(int i = 0; i < n -1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                ans++;
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
                    ans++;
                }
            }
        }

        return ans;
    }
}
