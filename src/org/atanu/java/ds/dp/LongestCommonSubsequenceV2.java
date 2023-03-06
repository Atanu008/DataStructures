package org.atanu.java.ds.dp;

//https://leetcode.com/problems/longest-common-subsequence/
//Leetcode 1143

//Video Tech Dose : https://www.youtube.com/watch?v=LAKWWDX3sGw
//Coding Minutes : https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31157784?start=555#announcements
// https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/myN8WB67XYE
public class LongestCommonSubsequenceV2 {
    public  int longestCommonSubsequence(String str1, String str2){

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
