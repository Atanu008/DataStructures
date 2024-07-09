package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets-ii/description/">...</a>
 *
 * 90. Subsets II
 * Medium
 *
 * Topics
 *
 * Companies
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subsetsRec(nums, 0, list, result);
        return result;
    }

    private void subsetsRec(int[] nums, int ind, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));

        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsRec(nums, i + 1, list, lists);
            list.removeLast();
        }
    }

    /**
     * Recursive take not take solution
     */


}
