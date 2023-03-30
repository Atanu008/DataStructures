package org.atanu.java.ds.dp;

//https://leetcode.com/problems/wiggle-subsequence/
//LeetCode 376

public class LongestAlternatingSubsequence {
    //Variation Of Longest Increasing Subsequence
    //https://leetcode.com/problems/wiggle-subsequence/solutions/1469802/python-dp-from-o-n-2-down-to-o-n-clean-concise/?orderBy=most_votes
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


    //Video : https://www.youtube.com/watch?v=iJIAPtd9Z9s

    //Dynamic Programming
    //The problem asks us to find a sequence where differences of adjacent elements alternate between +ve & -ve. The problem can be restated as Find the number of max and min peaks in the given array.

    //We can iterate over the array and find these possibilities :
    //nums[i] > nums[i - 1]
    //nums[i] < nums[i - 1]
    //nums[i] == nums[i - 1]

    //We maintain two variables up and down both initialised to 1 (1st element will always be chosen).
    //They denote maximum number of peaks till now with last peak being a max peak and min peak respectively.
    //
    // If we come across condition 1, we have encountered a possible max peak.
    // We update up as 1 + down (1 + maximum number of peak till last min peak).
    // However, if the next element is again coming under condition 1,
    // we know that last peak shouldn't have been considered.
    // So, we again update up as 1 + down denoting that the current peak has been considered as max peak.
    //
    //This process is repeated for down as well when we come across condition 2.
    // We update down as 1 + up (1 + maximum number of peak till last max peak).
    //
    //When condition 3 is encountered, we are sure that it is neither a max nor a min peak,
    // so we just skip that iteration.

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
