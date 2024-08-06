package org.bgd.java.ds.prefixsums;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/">...</a>
 *
 * 325. Maximum Size Subarray Sum Equals k
 * Given an integer array nums and an integer k, return the maximum length of a
 * subarray that sums to k. If there is not one, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,-1,5,-2,3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 */
public class MaximumSizeSubarraySum {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;

        Map<Integer, Integer> prefixIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k) {
                count = i + 1;
            }

            if (prefixIndexMap.containsKey(prefixSum - k)) {
                count = Math.max(count, i - prefixIndexMap.get(prefixSum - k));
            }

            if (!prefixIndexMap.containsKey(prefixSum)) {
                prefixIndexMap.put(prefixSum, i);
            }
        }
        return count;
    }
}
