package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
//LeetCode 46
public class PermutationsV2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,0);
        return result;
    }

    private void dfs(int[] nums, int index) {
        if(index == nums.length){
            result.add(prepareList(nums));
            return;
        }
        for(int i = index; i<nums.length; i++){
            swap(nums,i, index);
            dfs(nums, index +1);
            swap(nums,index, i);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private List<Integer> prepareList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int a : nums){
            list.add(a);
        }
        return list;
    }


        public static void main(String[] args) {
            int[] nums = {1,2,3};
            PermutationsV2 permutations = new PermutationsV2();
            List<List<Integer>> result = permutations.permute(nums);
            result.forEach(System.out::println);
        }

}
