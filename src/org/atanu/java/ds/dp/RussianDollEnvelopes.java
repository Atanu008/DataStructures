package org.atanu.java.ds.dp;

import java.util.Arrays;

//Another Variation as Longest Increasing Subsequence
//https://leetcode.com/problems/russian-doll-envelopes/
//LeetCode 354
public class RussianDollEnvelopes {

    //Sort the Array on Basis of Width
    //Apply LIS on height
    //will check width condition as well because we need to check strict less
    public int maxEnvelopes(int[][] envelopes) {
        //Sort the Array on Basis of Width
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        //Base Case
        dp[0] = 1;
        int maxLength = 1;
        //Apply LIS on height
        // will check width condition as well because we need to check strict less
        // Sort can give as same values in Envelopes
        for(int i = 1; i< envelopes.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        //Output: 3
        //Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
        System.out.println("The maximum number of envelopes you can Russian doll is "+russianDollEnvelopes.maxEnvelopes(envelopes));
    }
}
