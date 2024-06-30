package org.bgd.java.ds.prefixsums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/description/">...</a>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 */

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int prefix = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (prefix == k) {
                c++;
            }

            if (map.containsKey(prefix - k)) {
                c += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return c;
    }
}
