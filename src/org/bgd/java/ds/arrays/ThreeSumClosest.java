package org.bgd.java.ds.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-closest/submissions/1322031067/">...</a>
 *
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            diff = twoSum(nums, i, target, diff);
        }
        return target - diff;
    }

    /**
     * This version of twoSum uses a sorted array with 2 pointers. Not the HashMap way
     */
    private int twoSum(int[] nums, int i, int target, int diff) {
        int l = i + 1;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (Math.abs(target - sum) < Math.abs(diff)) {
                diff = target - sum;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return diff;
    }
}

