package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
//LeetCode 78
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int index){
        result.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(result, current, nums, i+1);
            current.remove(current.size() -1);
        }
    }

    public List<List<Integer>> subsetsV2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrackV2(result, current, nums, 0);
        return result;
    }
    private void backtrackV2(List<List<Integer>> result, List<Integer> current, int[] nums, int index){
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrackV2(result, current, nums, index+1);
        current.remove(current.size() -1);
        backtrackV2(result, current, nums, index+1);
    }

    public List<List<Integer>> subsetsV3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // `N` stores the total number of subsets
        long N = (long) Math.pow(2, nums.length);

        // check every bit of `i`
        for(int i = 0; i < N; i++){
            List<Integer> current = new ArrayList<>();
            for(int j = 0; j < nums.length; j++){
                // if j'th bit of `i` is set, add `nums[j]` to the current set
                if((i & (1 << j)) != 0){
                    current.add(nums[j]);
                }
            }
            result.add(current);
        }
        return result;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets.subsets(nums);
        //result.forEach(System.out::println);

        List<List<Integer>> result2 = subsets.subsetsV2(nums);
        //result2.forEach(System.out::println);

        List<List<Integer>> result3 = subsets.subsetsV3(nums);
        result3.forEach(System.out::println);
    }
}
