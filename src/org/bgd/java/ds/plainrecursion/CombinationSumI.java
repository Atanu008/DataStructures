package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">...</a>
 *
 * 39. Combination Sum
 * Solved
 * Medium
 *
 * Topics
 *
 * Companies
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 */
public class CombinationSumI {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        combinationsRecursion(candidates, 0, target, nums, answer);
        return answer;
    }

    private void combinationsRecursion(int[] candidates, int ind, int target, List<Integer> nums, List<List<Integer>> answer) {
        if (ind >= candidates.length) {
            return;
        }
        if (target == 0) {
            answer.add(new ArrayList<>(nums));
            return;
        }

        //pick
        if (candidates[ind] <= target) {
            nums.add(candidates[ind]);
            combinationsRecursion(candidates, ind, target - candidates[ind], nums, answer);
            nums.removeLast();
        }

        // not pick
        combinationsRecursion(candidates, ind + 1, target, nums, answer);
    }
}
