package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/binary-subarrays-with-sum/
public class BinarySubarraysWithSum {

    //Using a hashmap is overkill in this problem since the only sums that are possible are [0, 1, ..., n].
    public int numSubarraysWithSum(int[] nums, int goal) {

        //The largest sum we can have is len(A) = n Why? What if array A[] has all 1's.
        int[] prefixSum = new int[nums.length + 1];
        // situation 1:
        // continuous subarray starts
        // from the beginning of the array
        prefixSum[0] = 1;

        int sum = 0;
        int count = 0;
        for(int a : nums){
            sum += a;
            // situation 2:
            // number of times the curr_sum − k has occured already,
            // determines the number of times a subarray with sum k
            // has occured upto the current index
            if(sum >= goal){
                count += prefixSum[sum - goal];
            }
            prefixSum[sum]++;
        }
        return count;
    }

    //This is same solution as Subarray Sum Equals K . LeetCode 560
    //We are not utilizing any fact that its a binary Array
    public int numSubarraysWithSumV2(int[] nums, int goal) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        // situation 1:
        // continuous subarray starts
        // from the beginning of the array
        prefixSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int a : nums){

            sum += a;
            if(prefixSum.containsKey(sum - goal)){
                // situation 2:
                // number of times the curr_sum − k has occured already,
                // determines the number of times a subarray with sum k
                // has occured upto the current index
                count += prefixSum.get(sum - goal);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    //Sliding Window
    public int numSubarraysWithSumV3(int[] nums, int goal) {

        return numSubarraysWithSumAtMostGoal(nums, goal) - numSubarraysWithSumAtMostGoal(nums, goal-1);

    }

    public int numSubarraysWithSumAtMostGoal(int[] nums, int goal) {

        //base case . submission failed :)
        if(goal < 0){
            return 0;
        }
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;
        int subArrayCount = 0;

        while(windowEnd < nums.length){

            sum += nums[windowEnd];

            while(sum > goal){
                sum -= nums[windowStart];
                windowStart++;
            }

            subArrayCount += windowEnd - windowStart + 1;

            windowEnd++;
        }

        return subArrayCount;
    }


}
