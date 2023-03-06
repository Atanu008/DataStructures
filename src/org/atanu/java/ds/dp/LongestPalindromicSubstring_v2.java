package org.atanu.java.ds.dp;


public class LongestPalindromicSubstring_v2 {
    int start = 0;
    int maxLength = 0;
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            // odd-length palindromes, single character center
            // Eg : aca - c is on centre(aca - Odd Length)
            palindromeAroundCentre(i , i, s);
            // even-length palindromes, consecutive characters center
            // Eg : baab -> aa is in centre (baab Even Length)
            palindromeAroundCentre(i , i+1, s);
        }

        return s.substring(start, start + maxLength);
    }

    private void palindromeAroundCentre(int low, int high, String s) {

        while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
            // expand around the center
            low--;
            high++;
        }

        if(high - low -1 > maxLength){
            start = low + 1;
            maxLength = high - low -1;
        }
    }
}
