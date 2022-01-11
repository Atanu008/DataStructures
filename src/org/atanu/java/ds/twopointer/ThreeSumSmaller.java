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
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    count += k - j;
                    j++;

                } else {
                    k--;
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
