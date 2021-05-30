package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

// To get the sum of sub sets. we could have generated the subsets and the add . O(2^N.N)
// Here we are removing the N by doing the calculation in flight
public class SumOfSubsetsV2 {
    public void sumOfSubSets(int[] nums, int index, int sum, List<Integer> result){
        if(index == nums.length){
            result.add(sum);
            return;
        }
        // pick the element
        sumOfSubSets(nums, index + 1, sum+nums[index], result);
        // Do-not pick the element
        sumOfSubSets(nums, index + 1, sum, result);

    }

    public static void main(String[] args) {
        SumOfSubsetsV2 sumOfSubsetsV2 = new SumOfSubsetsV2();
        int[] nums = {1,2,3};
        List<Integer> result = new ArrayList<>();
        sumOfSubsetsV2.sumOfSubSets(nums, 0, 0, result);
        //Collections.sort(result);
        result.forEach(System.out::println);
    }
}
