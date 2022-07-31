package org.atanu.java.ds.sort;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-target-indices-after-sorting-array/
//LeetCode 2089
public class FindTargetIndicesAfterSortingArray {

    //One iteration to count less than target, and equal target. Build output based on the first index at lessthan.
    public List<Integer> targetIndices(int[] nums, int target) {

        int countOfLowerIndices = 0;
        int countOfTargetValIndices = 0;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] < target){
                countOfLowerIndices++;
            }else if(nums[i] == target){
                countOfTargetValIndices++;
            }
        }

        List<Integer> result = new ArrayList<>();
        while(countOfTargetValIndices --> 0){
            result.add(countOfLowerIndices++);
        }

        return result;
    }
}
