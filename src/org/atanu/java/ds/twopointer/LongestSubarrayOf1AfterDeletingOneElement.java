package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
//LeetCode 1493
////Almost exactly same as 1004. Max Consecutive Ones III
public class LongestSubarrayOf1AfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int longestOnes = 0;
        int zeros = 0;
        int windowEnd = 0;
        int windowStart = 0;

        // while our window is in bounds
        while (windowEnd < nums.length) {

            // add the right most element into our window
            if (nums[windowEnd] == 0) {
                zeros++;
            }

            // if our window is invalid, contract our window
            //Shrink the window if number of zeros is greater than K
            //After while is done window will have at most K zeros
            while (zeros > 1) {
                if (nums[windowStart] == 0) {
                    zeros--;
                }
                windowStart++;
            }

            // update our longest sequence answer
            //we don't write (windowEnd-windowStart+1) because we need to give its length after removing the zero
            longestOnes = Math.max(longestOnes, windowEnd - windowStart);
            // expand our window
            windowEnd++;
        }

        return longestOnes;
    }
}
