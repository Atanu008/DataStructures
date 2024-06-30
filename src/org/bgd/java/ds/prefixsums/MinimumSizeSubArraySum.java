package org.bgd.java.ds.prefixsums;

/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">...</a>
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int prefix = 0;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            while (prefix >= target) {
                count = Math.min(count, i - l + 1);
                prefix -= nums[l++];
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
