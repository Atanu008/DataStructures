package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 216
//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        combinationSum3(k, n, 1, current, result);
        return result;
    }

    public void combinationSum3(int k, int target, int start, List<Integer> current, List<List<Integer>> result){

        if(current.size() == k){
            //Sum achived
            if(target == 0){
                result.add(new ArrayList<>(current));
            }
            //Return as the size is K. No need to recurr
            return;
        }

        for(int i = start; i <= 9; i++){
            current.add(i);
            //Recur for i+1 as we dont want to consider the same element again.
            combinationSum3(k, target - i, i+1, current, result);
            current.remove(current.size() - 1);
        }

    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        int k = 3; int target = 9;
        List<List<Integer>> result = combinationSumIII.combinationSum3(k, target);
        result.forEach(System.out::println);
    }
}
