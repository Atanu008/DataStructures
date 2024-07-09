package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/description/">...</a>
 *
 * 40. Combination Sum II
 * Medium
 *
 * Topics
 *
 * Companies
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        combinationsRecursion(candidates, 0, target, nums, answer);
        return answer;
    }

    private void combinationsRecursion(int[] candidates, int ind, int target, List<Integer> nums, List<List<Integer>> answer) {
        if (target == 0) {
            answer.add(new ArrayList<>(nums));
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
            if (i != ind && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if(candidates[i] > target) {
                break;
            }
            nums.add(candidates[i]);
            combinationsRecursion(candidates, i + 1, target - candidates[i], nums, answer);
            nums.removeLast();
        }
    }

}
