package org.bgd.java.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/contiguous-array/description/">...</a>
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxlen = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1) ? 1 : -1;
            if (count == 0) {
                maxlen = Math.max(maxlen, i + 1);
            }
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }

        }
        return maxlen;
    }
}
