package org.atanu.java.ds.dp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/combination-sum-iv/description/
//Leetcode 377
//Video : https://www.youtube.com/watch?v=dw2nMCxG0ik
//Check Leetcode Premium explanation too.
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {

        Map<Integer, Integer> dp = new HashMap<>();
        // minor optimization
        // Arrays.sort(nums);
        return combine(nums, target, dp);
    }

    private int combine(int[] nums, int remaining, Map<Integer, Integer> dp){

        if(remaining == 0){
            return 1;
        }

        if(dp.containsKey(remaining)){
            return dp.get(remaining);
        }

        int numCombination = 0;
        for(int num : nums){
            if(remaining - num >= 0){
                numCombination += combine(nums, remaining - num, dp);
                // minor optimizaton, early stopping , if the array is sorted
                //As the next element would be bigger only
                // else
                //     break;
            }
        }

        dp.put(remaining, numCombination);
        return numCombination;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        int result = new CombinationSumIV().combinationSum4(nums, target);
        System.out.println(result);
    }
}
