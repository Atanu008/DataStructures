package org.atanu.java.ds.dp;

//https://leetcode.com/problems/delete-operation-for-two-strings/description/

//Longest Common Subsequence Variation

//To make them identical, just find the longest common subsequence.
//The rest of the characters have to be deleted from the both the strings,
// which does not belong to longest common subsequence.
public class DeleteOperationForTwoStrings {
    public int minDistance(String s1, String s2) {
        int lcs = lcs(s1, s2);
        return (s1.length() - lcs) + (s2.length() - lcs) ;
    }

    private int lcs(String str1, String str2){
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
