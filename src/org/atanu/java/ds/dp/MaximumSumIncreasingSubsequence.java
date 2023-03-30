package org.atanu.java.ds.dp;

// Variation Of Longest Increasing Subsequence
// https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
// https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/qAqAWlyGRNG
// Video : https://www.youtube.com/watch?v=R7DrJsTkK8w
public class MaximumSumIncreasingSubsequence {

    public int maximumSumIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = 0;
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i];
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumSumIncreasingSubsequence maximumSumIncreasingSubsequence = new MaximumSumIncreasingSubsequence();
        int[] nums = {4,1,2,6,10,1,12};
        // 4+6+10+12
        System.out.println(maximumSumIncreasingSubsequence.maximumSumIncreasingSubsequence(nums));
        nums = new int[]{-4,10,3,7,15};
        // 10 + 15
        System.out.println(maximumSumIncreasingSubsequence.maximumSumIncreasingSubsequence(nums));
    }
}
