package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 39
//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        combinationSum(candidates, target, 0, current, result);
        return result;
    }

    public void combinationSum(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {

        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            current.add(candidates[i]);
            combinationSum(candidates , target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        result.forEach(System.out::println);
    }
}
