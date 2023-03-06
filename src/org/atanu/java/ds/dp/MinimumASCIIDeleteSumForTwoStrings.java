package org.atanu.java.ds.dp;

//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
//Leetcode 712
public class MinimumASCIIDeleteSumForTwoStrings {

    /*Intuition :
    s1 = "sea"
    s2 = "eat"

    lcs = "ea"

    when we delete lcs from s1, we are left with character 's', and same happens
    in s2, and we are left with character 't'.
    In result we need to add 's' and 't' */

    //Same idea with classic problem 1143. Longest Common Subsequence.
    //In this case, we define Longest Common Subsequence as Maximum Ascii Sum Common Subsequence between string s1 and s2.
    //Then the lowest ASCII sum of deleted characters = total ascii sum - Maximum Ascii Sum Common Subsequence * 2.
    // multiply 2 because the LCS characters are in both String

    public int minimumDeleteSum(String str1, String str2) {

        int m = str1.length() + 1;
        int n = str2.length() + 1;

        int[][] dp = new int[m][n];
        //Dont need to full DP with some values for empty string and other combination its zero only

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // If the characters at this position match,
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    // add 1 to the previous diagonal and store it in this diagonal
                    dp[i][j] = (int)str1.charAt(i-1) + dp[i-1][j-1];
                }
                else{
                    // If the characters don't match, fill this entry with the max of the
                    // left and top elements
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        int totalAscii = 0;
        for(char ch : str1.toCharArray()){
            totalAscii += (int)ch;
        }

        for(char ch : str2.toCharArray()){
            totalAscii += (int)ch;
        }

        return totalAscii - 2 * dp[str1.length()][str2.length()];
    }
}
