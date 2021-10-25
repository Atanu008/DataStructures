package org.atanu.java.ds.dp;

//https://leetcode.com/problems/number-of-longest-increasing-subsequence/
//LeetCode 673
//Video : https://www.youtube.com/watch?v=_eHbuLHo6pM&t=927s
public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        //Base Case. For one element Subsequence is always one
        len[0] = 1;
        count[0] = 1;
        int maxLength = 1;
        for(int i = 1; i < n; i++){
            //Base Case. For one element Subsequence is always one
            len[i] = 1;
            count[i] = 1;
            //Check for all previous elements.
            //If (nums[i] > nums[j] then take the length of jth element(i.e dp[j]) + 1(means teh ith element)
            //Take the maximum while evluating all js
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    // strictly increasing
                    if(len[j]+1 > len[i]){
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                    // this means there are more subsequences of same length ending at length lis[i]
                    else if(len[j]+1 == len[i]){
                        count[i] = count[i] + count[j];
                    }
                    maxLength = Math.max(maxLength, len[i]);
                }

            }

        }
        int result = 0;
        for(int i = 0; i< n; i++){
            if(len[i] == maxLength){
                result += count[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence increasingSubsequence = new NumberOfLongestIncreasingSubsequence();
        int[] nums = {1,3,5,4,7};
        int[] nums1 = {2,2,2,2,2};
        System.out.println("Number of Longest Increasing Subsequence is "+ increasingSubsequence.findNumberOfLIS(nums));
        System.out.println("Number of Longest Increasing Subsequence is "+ increasingSubsequence.findNumberOfLIS(nums1));
    }
}
