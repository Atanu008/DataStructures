package org.atanu.java.ds.twopointer;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/maximum-erasure-value/description/
// Leetcode 1695
// Video : https://www.youtube.com/watch?v=WG6Kok6tIyg

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int windowEnd = 0;
        int windowStart = 0;
        int currentWindowSum = 0;
        int max = 0;
        while(windowEnd < nums.length){
            // remove from the list till the element at the right is present
            // Also decrement the sum
            // Once we are out of the while loop there will be only
            // increment start until subarray has unique elements
            while(set.contains(nums[windowEnd])){
                currentWindowSum -= nums[windowStart];
                set.remove(nums[windowStart]);
                windowStart++;
            }
            currentWindowSum += nums[windowEnd];
            set.add(nums[windowEnd]);
            // update result with maximum sum found so far
            max = Math.max(max, currentWindowSum);
            windowEnd++;
        }
        return max;
    }

    // Brute Force
    // TLE
    public int maximumUniqueSubarray_v2(int[] nums) {
        int n = nums.length;
        int result = 0;
        HashSet set = new HashSet<>();
        for (int start = 0; start < n; start++) {
            // reset set and current sum for next subarray
            set.clear();
            int currentSum = 0;
            for (int end = start; end < n && !set.contains(nums[end]); end++) {
                currentSum += nums[end];
                set.add(nums[end]);
            }
            // update result with maximum sum found so far
            result = Math.max(result, currentSum);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
