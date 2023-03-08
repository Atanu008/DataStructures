package org.atanu.java.ds.dp;

//https://leetcode.com/problems/target-sum/description/
//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/g2Ko7qNYEEj


import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {

        Map<String, Integer> dp = new HashMap<>();
        return findTargetSumWaysRecur(nums, target, 0, 0, dp);
    }

    private int findTargetSumWaysRecur(int[] nums, int target, int currentSum, int index, Map<String, Integer> dp){

        if(index == nums.length){
            //After visting all the number if we can reach the target the we have found a way
            if(currentSum == target){
                return 1;
            }
            else{
                return 0;
            }
        }

        String key = index +":"+ currentSum;

        if(dp.containsKey(key)){
            return dp.get(key);
        }
        //Try both option + and - .
        //In both cases we will go forward, index + 1
        // take summation of both cases
        int res = findTargetSumWaysRecur(nums, target, currentSum + nums[index], index + 1, dp) +
                findTargetSumWaysRecur(nums, target, currentSum - nums[index], index + 1, dp);

        dp.put(key, res);

        return res;

    }
}
