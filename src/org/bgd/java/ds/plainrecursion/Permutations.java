package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">...</a>
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        permuteWithRecursion(nums, 0, answer);
        return answer;
    }

    /**
     * Plain recursion
     */

    private void permuteWithRecursion(int[] nums, int index, List<List<Integer>> answer) {
        if (index == nums.length) {
            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                r.add(nums[i]);
            }
            answer.add(r);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permuteWithRecursion(nums, index + 1, answer);
            swap(nums, i, index);
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
