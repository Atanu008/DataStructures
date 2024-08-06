package org.bgd.java.ds.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-smaller/description/">...</a>
 * 259. 3Sum Smaller
 * Given an array of n integers nums and an integer target,
 * find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,0,1,3], target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 * Example 2:
 *
 * Input: nums = [], target = 0
 * Output: 0
 * Example 3:
 *
 * Input: nums = [0], target = 0
 * Output: 0
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            c += twoSum(nums, i, target);
        }
        return c;
    }

    private int twoSum(int[] nums, int i, int target) {
        int l = i + 1, r = nums.length - 1;
        int c = 0;
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum < target) {
                c += r - l;
                l++;

            } else {
                r--;
            }
        }
        return c;
    }
}
