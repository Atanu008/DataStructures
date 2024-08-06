package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/description/">...</a>
 *
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class SubsetsI {
    List<List<Integer>> answer;
    int limit;

    public List<List<Integer>> subsets(int[] nums) {
        this.answer = new ArrayList<>();
        for (limit = 0; limit < nums.length + 1; limit++) {
            subsetRec(0, nums, new ArrayList<Integer>());
        }
        return answer;

    }

    private void subsetRec(int index, int[] nums, List<Integer> list) {
        if (index == limit) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {

            list.add(nums[i]);

            subsetRec(i + 1, nums, list);

            list.removeLast();
        }
    }

}

}
