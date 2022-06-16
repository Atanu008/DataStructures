package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
//LeetCode 1658
//Video : https://www.youtube.com/watch?v=HnwetpsZsb8


//Similar
//LeetCode 325
//Same solution as below
//https://leetcode.com/problems/contiguous-array/
//LeetCode 525
public class MinimumOperationsToReduceXToZero {

    /*
       This question is the equivalent of asking: What's the length of the longest subarray that adds up to the total sum
       of all elements in the array, minus x? Let's say this subarray adds up to the variable target.

       Once we've got the answer to that question in a variable res, we can answer the original question by
       subtracting the resulting length from the total length of the array, since that's the number of
       operations we'd need to perform to produce the subarray, or nums.length - res.
    */
    public int minOperations(int[] nums, int x) {

        int totalSum = 0;
        for(int a : nums){
            totalSum += a;
        }

        int targetSum = totalSum - x;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        //Edge case if the resulting Array starts with first index
        prefixSumMap.put(0,-1);
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){

            sum += nums[i];
            int target = sum - targetSum;
            // normally we put this statement here. we put at last in the while loop
            //This is a trick avoid the edge case where all the elements sums up to target
            // in that case we need all the element
            prefixSumMap.put(sum, i); 

            if(prefixSumMap.containsKey(target)){
                maxLength = Math.max(maxLength, i - prefixSumMap.get(target));
            }
        }
        return maxLength != Integer.MIN_VALUE ? nums.length - maxLength : -1;
    }

    //here we are checking the base case here if all the elements are adding to the x
    //Else everything is same
    public int minOperationsV2(int[] nums, int x) {

        int totalSum = 0;
        for(int a : nums){
            totalSum += a;
        }
        /* If your totalSum = x, the longest subarray that adds up to x is the entire array. */
        if(totalSum == x){
            return nums.length;
        }
        int targetSum = totalSum - x;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        //Edge case if the resulting Array starts with first index
        prefixSumMap.put(0,-1);
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];
            int target = sum - targetSum;

            if(prefixSumMap.containsKey(target)){
                maxLength = Math.max(maxLength, i - prefixSumMap.get(target));
            }

            // Since all numbers in the array are positive,
            // the sum will always increase with every step of the loop, so we don't
            //have to worry about uniqueness.
            prefixSumMap.put(sum, i);
        }
        return maxLength != Integer.MIN_VALUE ? nums.length - maxLength : -1;
    }

    //Algorithm
    //Step 1: Calculate the total sum of nums. Mark as total.
    //Step 2: Initialize two pointers left and right to 0. Initialize an integer current to represent the sum from nums[left] to nums[right], inclusively. Initialize an integer maxi to record the maximum length that sums up to total - x.
    //Step 3: Iterate right form 0 to the end of nums. In each iteration:
    //Update current.
    //If current is greater than total - x, move left to left.
    //If current is equal to total - x, update the maximum length.
    //Step 4: Return the result.

    //Check Premuim Explanation also below
    //https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/2136570/Change-Your-Perspective-or-JAVA-Explanation
    public int minOperationsV3(int[] nums, int x) {

        int totalSum = 0;
        for(int a : nums){
            totalSum += a;
        }

        int windowEnd = 0;
        int windowStart = 0;
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;
        while(windowEnd < nums.length){

            sum += nums[windowEnd];

            while(sum > totalSum - x && windowStart <= windowEnd){

                sum -= nums[windowStart];
                windowStart++;
            }
            if(sum == totalSum -x){
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            }

            windowEnd++;
        }

        return maxLength != Integer.MIN_VALUE ? nums.length - maxLength : -1;
    }
}
