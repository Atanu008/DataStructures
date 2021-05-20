package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int index){
        result.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            current.add(nums[i]);
            backtrack(result, current, nums, i+1);
            current.remove(current.size() -1);
        }
    }

    public static void main(String[] args) {
        SubsetsII subsets = new SubsetsII();
        int[] nums = {1,2,2};
        List<List<Integer>> result = subsets.subsetsWithDup(nums);
        result.forEach(System.out::println);

    }
}
