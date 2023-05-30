package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
// Leetcode 1498

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums); // sorted array will be used to perform binary search
        int mod = 1000_000_007;

        int[] powOf2 = new int[nums.length]; // powOf2[i] means (2^i) % mod

        powOf2[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            powOf2[i] = (powOf2[i - 1] * 2) % mod;
        }

        int res = 0;
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            if(nums[left] + nums[right] > target) {
                right--; // nums[right] which is macimum is too big so decrease it
            } else {
                res = (res + powOf2[right-left] ) % mod; // every number between right and left be either picked or not picked so that is why pow(2, right - left) essentially
                left++; // increment left to find next set of min and max
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubsequencesThatSatisfyTheGivenSumCondition numberOfSubsequencesThatSatisfyTheGivenSumCondition = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition();
        int[] nums = {3,5,6,7};
        int target = 9;
        //Explanation: There are 4 subsequences that satisfy the condition.
        //[3] -> Min value + max value <= target (3 + 3 <= 9)
        //[3,5] -> (3 + 5 <= 9)
        //[3,5,6] -> (3 + 6 <= 9)
        //[3,6] -> (3 + 6 <= 9)
        int result = numberOfSubsequencesThatSatisfyTheGivenSumCondition.numSubseq(nums, target);
        System.out.println(result);

    }
}
