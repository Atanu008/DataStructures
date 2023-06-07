package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/binary-subarrays-with-sum/
// Leetcode 930


// subArrayCount += windowEnd - windowStart + 1;
// Explanation
// suppose initial window [a] then subarrays that ends with this element are [a] --> 1
// now we expand our window [a,b] then subarrays that ends with this new element are [b], [a,b] -->2
// now we expand our window [a,b,c] then subarrays that ends with this new element are [c], [b, c], [a,b,c] -->3
// now we expand our window [a,b,c,d] and let suppose this is not valid window so we compress window from left side to make it valid window
// [b,c,d] then subarrays that ends with this new element are [d], [c,d], [b,c,d] -->3
//
// You can observe that we are only considering subarrays with new element in it which auto. eliminate the counting

public class BinarySubarraysWithSum {

    //Using a hashmap is overkill in this problem since the only sums that are possible are [0, 1, ..., n].
    public int numSubarraysWithSum(int[] nums, int goal) {

        //The largest sum we can have is len(A) = n Why? What if array A[] has all 1's.
        // suppose [1,1,1,1,1] => len = 5
        // Need to have nums.length + 1 places
        int[] prefixSumCount = new int[nums.length + 1];
        // situation 1:
        // continuous subarray starts
        // from the beginning of the array
        prefixSumCount[0] = 1;

        int sum = 0;
        int count = 0;
        for(int a : nums){
            sum += a;
            // situation 2:
            // number of times the curr_sum − k has occurred already,
            // determines the number of times a subarray with sum k
            // has occurred upto the current index
            // sum - goal can be negative and array index wil have problem
            if(sum >= goal){
                count += prefixSumCount[sum - goal];
            }
            prefixSumCount[sum]++;
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
        // Suppose [1, 2, 3] and goal = 6 .
        // sum - gaol = 0; for zero would be getting 1 from Map
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


    // Sliding Window
    // Please reffer SubarraysWithKDifferentIntegers
    // subArrayCount += windowEnd - windowStart + 1;
    // Explanation
    // suppose initial window [a] then subarrays that ends with this element are [a] --> 1
    // now we expand our window [a,b] then subarrays that ends with this new element are [b], [a,b] -->2
    // now we expand our window [a,b,c] then subarrays that ends with this new element are [c], [b, c], [a,b,c] -->3
    // now we expand our window [a,b,c,d] and let suppose this is not valid window so we compress window from left side to make it valid window
    // [b,c,d] then subarrays that ends with this new element are [d], [c,d], [b,c,d] -->3
    //
    // You can observe that we are only considering subarrays with new element in it which auto. eliminate the counting
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

            // all sub arrays will have sum lesser than equal to goal . one one subarray would be equal . the total array
            // suppose we have windowStart = 2 windowEnd = 5
            // total Four(windowEnd - windowStart + 1) elements right .
            // suppose {7, 5, 6, 8}
            // sub araays formed is also 4
            // {7} , {7, 5}, {7, 5, 6} {7, 5, 6, 8}
            subArrayCount += windowEnd - windowStart + 1; // Sub Array Count for that valid window

            windowEnd++;
        }

        return subArrayCount;
    }


}
