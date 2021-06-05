package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
//LeetCode 46
//This Solution works only for unique string/array. duplicates not handled
public class Permutations {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(permutation, visited, nums);
        return result;
    }

    private void dfs(List<Integer> permutation, boolean[] visited, int[] nums) {
        if(permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        }
        //Check every element of Array in every Recursion
        //Skip if it is visited
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            dfs(permutation, visited, nums);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);
        result.forEach(System.out::println);
    }
}
