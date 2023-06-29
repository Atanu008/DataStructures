package org.atanu.java.ds.prefixsum;

// https://leetcode.com/problems/range-sum-query-immutable/description/
// Leetcode 303
// Video : https://www.youtube.com/watch?v=k5Im14rNUFA

// we just pre-calculated the prefix sum of nums array,
// where preSum[i] is sum of nums[0..i], so the result of sumRange(left, right) are:
// If left = 0 then return preSum[right]
// Else return preSum[right] - preSum[left-1].

public class RangeSumQueryImmutable {

    int[] prefixSum;

    public RangeSumQueryImmutable(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        if(left == 0){
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }

}
