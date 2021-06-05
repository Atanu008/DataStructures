package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations-ii/
//LeetCode 47
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//Sort the array First
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, permutation, visited, result);
        return result;
    }
    private void dfs(int[] nums, List<Integer> permutation, boolean[] visited, List<List<Integer>> result){
        if(permutation.size() == nums.length){
            result.add(new ArrayList<>(permutation));
        }

        //when a number has the same value with its previous, we can use this number only if his previous is used
        //i > 0 && nums[i] == nums[i-1] && !visited[i-1]
        //i > 0 && nums[i] == nums[i-1] && visited[i-1]
        //Both will work
        for(int i = 0; i < nums.length; i++) {
            if(visited[i])
                continue;
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1])
                continue;
            visited[i] = true;
            permutation.add(nums[i]);
            dfs(nums, permutation, visited, result);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        PermutationsII permutationsUnique = new PermutationsII();
        List<List<Integer>> result = permutationsUnique.permuteUnique(nums);
        result.forEach(System.out::println);
    }
}
