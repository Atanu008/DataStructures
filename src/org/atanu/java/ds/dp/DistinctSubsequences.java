package org.atanu.java.ds.dp;

//https://leetcode.com/problems/distinct-subsequences/description/
//Leetcode

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/YVGN2ZjzK1O
public class DistinctSubsequences {
    //Top Down Approach
    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()][t.length()];
        return dp(s, t, 0, 0, dp);
    }

    private int dp(String s, String t, int sIndex, int tIndex, Integer[][] dp){
        //This is the main condition here
        //if we reached end of the target String that means we have found a way to form the Target String
        //In that case return case
        //So we want to include that was an answer
        if(tIndex == t.length()){
            return 1;
        }
        //If we have reached end of the Main string then there are no ways to form the string
        //Return zero
        if(sIndex == s.length()){
            return 0;
        }
        //If already calculated
        if(dp[sIndex][tIndex] != null){
            return dp[sIndex][tIndex];
        }
        //If from Character from Source and Target Matches
        //Then we have TWO choice
        //Include :
        //Consider/Include the element from source. in that case we would be considering the char from Target
        // dp(s, t, sIndex + 1, tIndex + 1, dp)  :  tIndex + 1 as are matching the charcter

        //Exclude :
        //dp(s, t, sIndex + 1, tIndex, dp) : Not forwarding the tIndex as the source char is not included

        //Take the summution of those two choices .
        //As in both cases we can have the formed target String
        if(s.charAt(sIndex) == t.charAt(tIndex)){
            return dp[sIndex][tIndex] = dp(s, t, sIndex + 1, tIndex + 1, dp) + dp(s, t, sIndex + 1, tIndex, dp);
        }
        //When the charcters dont match
        //We have only one option
        //forward the source String(sIndex + 1) to match for the next
        return dp[sIndex][tIndex] = dp(s, t, sIndex + 1, tIndex, dp);
    }

    //Bottom Up Approach
    //Just see the recursion commencts for more clarity
    //Bottom is is basically the same
    public int numDistinct_v2(String s, String t) {

        int m = s.length() + 1;
        int n = t.length() + 1;
        int[][] dp = new int[m][n];
        // initialize the dp value when t is an empty string, number of subsequence of an empty string should be 1
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // when two pointers pointing to same character
                // if we take these two characters simultaneously, we should have dp[i-1][j-1] subsequences
                // otherwise if we overlook current i (moving back for one step) and keeping the current j we have another dp[i -1][j]
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                // when two pointers pointing to difference characters
                //we cannot take these two characters but we still should make j ending with pointing to current position
                // then we should move i backward
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
