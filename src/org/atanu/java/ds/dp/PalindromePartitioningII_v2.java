package org.atanu.java.ds.dp;

//Same as above . just creating boolean dp array to store palindrome states for substring
public class PalindromePartitioningII_v2 {

    public int minCut(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        Boolean[][] palindromeDP = new Boolean[n][n];
        return findMinimumCut(s, 0, s.length() -1, dp, palindromeDP);
    }

    private int findMinimumCut(String s, int start , int end, Integer[][] dp, Boolean[][] palindromeDP){
        if(start == end || isPalindrome(s, start, end, palindromeDP)){
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
            if (isPalindrome(s, start, currentCutIndex, palindromeDP)) {
                minimumCut = Math
                        .min(minimumCut, 1 + findMinimumCut(s, currentCutIndex + 1, end, dp, palindromeDP));
            }
        }

        return dp[start][end] = minimumCut;
    }

    private boolean isPalindrome(String s, int start, int end, Boolean[][] palindromeDP){

        if(palindromeDP[start][end] != null){
            return palindromeDP[start][end];
        }

        int i = start;
        int j = end;

        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)){
                return palindromeDP[start][end] = false;
            }
        }
        return palindromeDP[start][end] = true;
    }
}
