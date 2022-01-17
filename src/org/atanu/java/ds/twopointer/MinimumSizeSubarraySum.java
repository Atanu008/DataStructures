package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/minimum-size-subarray-sum/
//LeetCode 209
public class MinimumSizeSubarraySum {

    //TC
    //The time complexity of the above algorithm will be O(N)O(N).
    //The outer for loop runs for all elements, and the inner while loop processes each element only once;
    //therefore, the time complexity of the algorithm will be O(N+N)O(N+N),
    // which is asymptotically equivalent to O(N)O(N).
    public int minSubArrayLen(int target, int[] nums) {

        int windowEnd = 0;
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int runningSum = 0;

        while(windowEnd < nums.length){
            runningSum += nums[windowEnd];// add the next element

            // shrink the window as small as possible until the 'windowSum' is smaller than Target
            while(runningSum >= target){
                minLength = Math.min(minLength, windowEnd - windowStart +1);
                runningSum -= nums[windowStart];
                windowStart++;
            }

            windowEnd++;
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        //Output: 2
        //Explanation: The subarray [4,3] has the minimal length under the problem constraint.
        System.out.println("Minimum Size Subarray Sum is "+ minimumSizeSubarraySum.minSubArrayLen(target, nums));
    }
}
