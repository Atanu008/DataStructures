package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/count-number-of-nice-subarrays/description/
// Leetcode 1248

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysAtMostK(nums, k) - numberOfSubarraysAtMostK(nums, k-1);
    }

    public int numberOfSubarraysAtMostK(int[] nums, int k) {

        int windowStart = 0;
        int windowEnd = 0;
        int window = 0;
        int subArrayCount = 0;
        while(windowEnd < nums.length){

            window += nums[windowEnd] % 2;

            while(window > k){
                window -= nums[windowStart] % 2;
                windowStart++;
            }

            subArrayCount += windowEnd - windowStart + 1;

            windowEnd++;
        }

        return subArrayCount;
    }
}
