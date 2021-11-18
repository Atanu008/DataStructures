package org.atanu.java.ds.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Variation Of Longest Increasing Subsequence
//https://leetcode.com/problems/largest-divisible-subset/
//LeetCode 368
// Video https://www.youtube.com/watch?v=sj32Bf4-N7Q
public class LargestDivisibleSubset {

    //Sort nums
    //Find size of longest divisible subset through the same approach as in LIS
    //Construct LDS by iterating through dp from right to left
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.sort(nums);
        dp[0] = 1;
        int maxLdsSize = 1;
        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i ; j++){
                if(nums[i] %nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                    maxLdsSize = Math.max(maxLdsSize, dp[i]);
                }
            }
        }

        int prev = -1;
        LinkedList<Integer> result = new LinkedList<>();
        for(int i = nums.length -1; i >= 0; i--){

            if(dp[i] == maxLdsSize && (prev == -1 || prev % nums[i] == 0)){
                result.addFirst(nums[i]);
                maxLdsSize--;
                prev = nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        int[] nums = {1,2,3,6};
        // [1,3,6] Or [1,2,6] anything is valid. this code will produce [1,3,6]
        List<Integer> result = largestDivisibleSubset.largestDivisibleSubset(nums);
        result.forEach(a -> System.out.print(a +" "));
    }
}
