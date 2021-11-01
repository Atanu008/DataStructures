package org.atanu.java.ds.dp;

import java.util.Arrays;

//Same Solution as Longest Increasing Subsequence
//Sort the pairs by first coordinate and apply LIS
//https://leetcode.com/problems/maximum-length-of-pair-chain/
//LeetCode 646
public class MaximumLengthOfPairChain {

    //Sort the pairs by first coordinate, and let dp[i] be the length of the longest chain ending at pairs[i]
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[pairs.length];
        //Base Case
        dp[0] = 1;
        int maxLength = 1;
        for(int i = 1; i< pairs.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,2},{7,8},{4,5}};
        MaximumLengthOfPairChain maximumLengthOfPairChain = new MaximumLengthOfPairChain();
        //The longest chain is [1,2] -> [4,5] -> [7,8]
        System.out.println("length of Longest Chain is "+maximumLengthOfPairChain.findLongestChain(pairs));

    }
}
