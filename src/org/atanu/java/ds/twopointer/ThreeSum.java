package org.atanu.java.ds.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/
//LeetCode 15
//Follow this only :)
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retVal = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++ ) {
            //Remove Duplicate
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int target = -nums[i];
            int left = i+1;
            int right = nums.length -1;
            while(left<right){
                List<Integer> current = new ArrayList<>();
                int twoSum = nums[left] + nums[right];
                if(twoSum == target){
                    current.add(nums[i]);
                    current.add(nums[left]);
                    current.add(nums[right]);
                    retVal.add(current);
                    left++;
                    right--;
                    //Remove Duplicate
                    while(left<right && nums[left] == nums[left-1])
                        left++;
                    //Remove Duplicate
                    while(left<right && nums[right] == nums[right+1])
                        right--;
                }else if(twoSum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        return retVal;
    }

    public static void main(String[] args) {

        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> retVal = new ThreeSum().threeSum(nums);
        retVal.forEach(System.out::println);
    }
}
