package org.atanu.java.ds.dp;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-increasing-subsequence/
//LeetCode 300
//Coding Minute
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        //Base Case. For one element Subsequence is always one
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            //Base Case. For one element Subsequence is always one
            dp[i] = 1;
            //Check for all previous elements.
            //If (nums[i] > nums[j] then take the length of jth element(i.e dp[j]) + 1(means teh ith element)
            //Take the maximum while evluating all js
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }

            }
        }
        return maxLength;
    }

    //Perfect Explanation : Intution
    //https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326308
    // O(NlogN)
    //Using Binary Search
    public int lengthOfLISV2(int[] nums) {

        List<Integer> lisSub = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(lisSub.isEmpty() || curr > lisSub.get(lisSub.size() -1)){
                lisSub.add(curr);
            }
            else{
                int insertIndex = lowerBoundBinarySearch(lisSub, curr);
                lisSub.set(insertIndex, curr);
            }
        }

        return lisSub.size();
    }

    private int lowerBoundBinarySearch(List<Integer> lisSub, int target){

        int low = 0;
        int high = lisSub.size() -1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (lisSub.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence increasingSubsequence = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Longest Increasing Subsequence is " + increasingSubsequence.lengthOfLIS(nums));
        System.out.println("Longest Increasing Subsequence is " + increasingSubsequence.lengthOfLISV2(nums));

    }
}
