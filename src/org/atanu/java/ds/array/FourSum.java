package org.atanu.java.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/4sum/
//LeetCode 18
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            //Remove Duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                //Remove Duplicate
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = nums.length - 1;
                int remainingTarget = target - (nums[i] + nums[j]);
                while (left < right) {
                    List<Integer> current = new ArrayList<>();
                    int twoSum = nums[left] + nums[right];
                    if (twoSum == remainingTarget) {
                        current.add(nums[i]);
                        current.add(nums[j]);
                        current.add(nums[left]);
                        current.add(nums[right]);
                        result.add(current);
                        left++;
                        right--;
                        //Remove Duplicates
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        //Remove Duplicates
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    } else if (twoSum < remainingTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> retVal = new FourSum().fourSum(nums, target);
        retVal.forEach(System.out::println);
    }
}
