package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LeetCode 40
//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        combinationSum2(candidates, target, 0, current, result);

        return result;
    }

    public void combinationSum2(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {

        if (target < 0) {
            return;
        }

        //Add when sum is reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }


        for (int i = index; i < candidates.length; i++) {

            //Skip the same adjacent element. need to consider first index and then skip the same adjacent
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            //Start from the next index as we dont repeat the same element
            combinationSum2(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> result = combinationSumII.combinationSum2(candidates, target);
        result.forEach(System.out::println);
    }
}
