package org.atanu.java.ds.dp;

//https://leetcode.com/problems/shortest-common-supersequence/description/
//Leetcode 1092

//Basically we need to take LCS(common chars) + the uncommon chars from both string
//Approach:
//
//We will start from the right-most cell of the dp array, initially i=n and j=m
//
//To form the string, we will work in a reverse manner.
//
//if(S1[i-1] == S2[j-1]), this means the character is an lcs character and needs to be included only once from both the strings, so we add it to the ans string and reduce both i and j by 1. We reduce them simultaneously to make sure the character is counted only once.
//if(S1[i-1] != S2[j-1]), this means that the character is a non-lcs character and then we move the pointer to the top cell or left cell depending on which is greater. This way non-lcs characters will be included separately in the right order.

//The algorithm steps are stated below:
//
//We start from cell dp[n][m]. Initially i=n and j=m.
//At every cell, we will check if S1[i-1] == S2[j-1], if it is then it means this character is a part of the longest common subsequence. So we will push it to the ans string str. Then we will move to the diagonally top-left(↖)  cell by assigning i to i-1 and j to j-1.
//Else, this character is not a part of the longest common subsequence so we include it in ans string. Originally this cell got its value from its left cell (←) or from its top cell (↑). Whichever cell’s value will be more of the two, we will move to that cell.
//We will continue till i>0 and j>0, failing it we will break from the loop.
//After breaking, either i>0 or j>0 (only one condition will fail to break from the while loop), if(i>0) we push all the characters from S1 to ans string, else if(j>0), we push all the remaining characters from S2.
//At last, we reverse the ‘ans’ string and we get our answer.

//Video watch after 10 min or so : https://www.youtube.com/watch?v=xElxAuBcvsU

public class ShortestCommonSupersequence {

    public String shortestCommonSupersequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = m;
        int j = n;

        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                //Take the element
                //(i-1 Or j-1) . Anything is fine
                //Go Diagonal
                //System.out.println("KK");
                lcs.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                //Left Value is greater
                //Take the char from String str1
                //Go Up one row.
                lcs.append(str1.charAt(i-1));
                i--;
            }
            else{
                //Upper value if greater
                //Take the char from String str2
                //Go left
                lcs.append(str2.charAt(j-1));
                j--;
            }
        }
        //Take the remaining String str1 if any
        while(i > 0){
            lcs.append(str1.charAt(i-1));
            i--;
        }
        //Take the remaining String str2 if any
        while(j > 0){
            lcs.append(str2.charAt(j-1));
            j--;
        }
        //Reverse the result and return as the string is formed from dp table
        return lcs.reverse().toString();
    }
}
