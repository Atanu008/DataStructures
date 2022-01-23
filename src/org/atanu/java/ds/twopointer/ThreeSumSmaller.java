package org.atanu.java.ds.twopointer;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-smaller/
//LeetCode 259

//Given an array of n integers nums and an integer target,
//find the number of index triplets i, j, k with 0 <= i < j < k < n
//that satisfy the condition nums[i] + nums[j] + nums[k] < target
public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                // found the triplet
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                // left and right to get a sum less than the target sum
                if (nums[i] + nums[left] + nums[right] < target) {
                    count += right - left;
                    left++;
                } else {
                    right--; // we need a pair with a smaller sum
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ThreeSumSmaller threeSumSmaller = new ThreeSumSmaller();
        int[] nums = {-2,0,1,3};
        int target = 2;
        //Output: 2
        //Explanation: Because there are two triplets which sums are less than 2:
        //[-2,0,1]
        //[-2,0,3]
        System.out.println("Three Sum smaller than "+ target +"  is "+ threeSumSmaller.threeSumSmaller(nums,target));
    }
}
