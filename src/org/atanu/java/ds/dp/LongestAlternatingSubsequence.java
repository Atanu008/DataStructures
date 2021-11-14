package org.atanu.java.ds.dp;

//https://leetcode.com/problems/wiggle-subsequence/
//LeetCode 376
public class LongestAlternatingSubsequence {
    //Variation Of Longest Increasing Subsequence
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0) return 0;
        //dp[i][0] = stores the LAS ending at 'i' such that the last two elements are in ascending order
        //dp[i][1] = stores the LAS ending at 'i' such that the last two elements are in descending order
        int[][] dp = new int[nums.length][2];
        int maxLength = 1;
        dp[0][0] = dp[0][1] = 1;
        for(int i=1; i < nums.length; i++) {
            // every single element can be considered as LAS of length 1
            dp[i][0] = dp[i][1] = 1;
            for(int j=0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
                } else if (nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
                }
                maxLength = Math.max(maxLength, Math.max(dp[i][0],dp[i][1]));
            }
        }
        return maxLength;
    }

    //KInd of Greedy
    //Video : https://www.youtube.com/watch?v=iJIAPtd9Z9s
    public int wiggleMaxLengthV2(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int up = 1;
        int down = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                up = down + 1;
            }
            else if(nums[i] < nums[i-1]){
                down = up +1;
            }
        }

        return Math.max(up, down);

    }
}
