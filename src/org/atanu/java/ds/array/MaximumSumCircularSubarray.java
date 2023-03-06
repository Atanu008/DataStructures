package org.atanu.java.ds.array;

//https://leetcode.com/problems/maximum-sum-circular-subarray/description/
//Leetcode 918

//Similar solution as //https://leetcode.com/problems/maximum-subarray/
//LeetCode 53

//solve max subarray sum (without circular).
//If not, you can have a reference here: 53. Maximum Subarray

//So there are two case.
//Case 1. The first is that the subarray take only a middle part, and we know how to find the max subarray sum.
//Case2. The second is that the subarray take a part of head array and a part of tail array.
//We can transfer this case to the first one.
//The maximum result equals to the total sum minus the minimum subarray sum.

//Corner Case :
//Just one to pay attention:
//If all numbers are negative, maxSum = max(A) and minSum = sum(A).
//In this case, max(maxSum, total - minSum) = 0, which means the sum of an empty subarray.
//According to the deacription, We need to return the max(A), instead of sum of am empty subarray.
//So we return the maxSum to handle this corner case.

//Explanation: https://leetcode.com/problems/maximum-sum-circular-subarray/solutions/178422/one-pass/?orderBy=most_votes
public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        // stores maximum and minimum sum sub-array found so far
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        // stores maximum and minimum sum of sub-array ending at current position
        int maxEndingHere = 0;
        int minEndingHere = 0;
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // update maximum and minimumsum of sub-array "ending" at index i (by adding
            // current element to maximum sum ending at previous index i-1)
            maxEndingHere = maxEndingHere + nums[i];
            minEndingHere = minEndingHere + nums[i];
            totalSum += nums[i]; //running sum
            // Update maxEndingHere and minEndingHere as current element can be greater/smaller if the previous elements are negative
            maxEndingHere = Math.max(maxEndingHere, nums[i]);
            minEndingHere = Math.min(minEndingHere, nums[i]);
            // update result if current sub-array sum is found to be greater or smaller
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }

        return maxSoFar > 0 ? Math.max(maxSoFar, totalSum - minSoFar) : maxSoFar;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray maximumSumCircularSubarray = new MaximumSumCircularSubarray();
        int[] nums = {5,-3,5};
        //Output: 10
        //This example is circular
        //Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10. .
        System.out.println(maximumSumCircularSubarray.maxSubarraySumCircular(nums));

        //Output: 3
        //Explanation: Subarray [3] has maximum sum 3.
        nums = new int[]{1,-2,3,-2};
        System.out.println(maximumSumCircularSubarray.maxSubarraySumCircular(nums));

        nums = new int[]{-3,-2,-3};
        //Output: -2
        //Explanation: Subarray [-2] has maximum sum -2.
        System.out.println(maximumSumCircularSubarray.maxSubarraySumCircular(nums));

    }
}
