package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
//LeetCode 560
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0; int sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        // situation 1:
        // continuous subarray starts
        // from the beginning of the array
        preSum.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(preSum.containsKey(sum-k)){
                // situation 2:
                // number of times the curr_sum − k has occured already,
                // determines the number of times a subarray with sum k
                // has occured upto the current index
                count += preSum.get(sum-k);
            }
            preSum.put(sum, preSum.getOrDefault(sum,0)+1);
        }
        return count;
    }

    //Without checking contains, Using getOrDefault
    public int subarraySumV2(int[] nums, int k) {
        int count = 0; int sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        // situation 1:
        // continuous subarray starts
        // from the beginning of the array
        preSum.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // situation 2:
            // number of times the curr_sum − k has occured already,
            // determines the number of times a subarray with sum k
            // has occured upto the current index
            count += preSum.getOrDefault(sum-k,0);
            preSum.put(sum, preSum.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
