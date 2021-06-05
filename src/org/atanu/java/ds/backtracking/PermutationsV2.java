package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/permutations/
//LeetCode 46
public class PermutationsV2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permutation = new ArrayList<>();
        Set<Integer> currentSet = new HashSet<>();
        dfs(permutation, currentSet, nums);
        return result;
    }

    private void dfs(List<Integer> permutation, Set<Integer> currentSet, int[] nums) {
        if(permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        }
        for(int i = 0; i < nums.length; i++){
            if(currentSet.contains(nums[i])){
                continue;
            }
            permutation.add(nums[i]);
            currentSet.add(nums[i]);
            dfs(permutation, currentSet, nums);
            permutation.remove(permutation.size() - 1);
            currentSet.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        PermutationsV2 permutations = new PermutationsV2();
        List<List<Integer>> result = permutations.permute(nums);
        result.forEach(System.out::println);
    }
}
