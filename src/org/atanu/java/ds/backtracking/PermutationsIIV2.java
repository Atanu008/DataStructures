package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations-ii/
//LeetCode 47
public class PermutationsIIV2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int index){
        if(index == nums.length){
            result.add(prepareList(nums));
            return;
        }

        for(int i = index; i < nums.length; i++){
            boolean isContinueForDuplicate = false;
            //If the same element is swapped with same it would produce duplicate permutation
            //Check if the same elemnt present earlier.
            //If yes then skip it
            for(int j = index; j < i; j++){
                if(nums[j] == nums[i]){
                    isContinueForDuplicate = true;
                    break;
                }
            }
            if(isContinueForDuplicate){
                continue;
            }
            swap(nums, i, index);
            dfs(result, nums, index+1);
            swap(nums, i, index);
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
        int[] nums = {1,1,2};
        PermutationsIIV2 permutationsUnique = new PermutationsIIV2();
        List<List<Integer>> result = permutationsUnique.permuteUnique(nums);
        result.forEach(System.out::println);
    }
}
