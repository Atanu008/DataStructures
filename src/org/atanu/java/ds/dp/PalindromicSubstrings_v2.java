package org.atanu.java.ds.dp;

//https://leetcode.com/problems/palindromic-substrings/description//
//Leetcode 647

public class PalindromicSubstrings_v2 {
    public int countSubstrings(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            // odd-length palindromes, single character center
            // Eg : aca - c is on centre(aca - Odd Length)
            ans += countPalindromeAroundCentre(i , i, s);
            // even-length palindromes, consecutive characters center
            // Eg : baab -> aa is in centre (baab Even Length)
            ans += countPalindromeAroundCentre(i , i+1, s);
        }
        return ans;
    }

    private int countPalindromeAroundCentre(int low, int high, String s) {
        int ans = 0;
        while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
            ans++; // One Palindromic substring found
            // expand around the center
            low--;
            high++;

        }
        return ans;
    }
}
