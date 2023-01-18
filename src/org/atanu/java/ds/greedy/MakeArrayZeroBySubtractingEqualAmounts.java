package org.atanu.java.ds.greedy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/
//LeetCode 2357
public class MakeArrayZeroBySubtractingEqualAmounts {
    //In first operation, smallest will make all its equal values to 0.
    //In second operation, next smallest will make all its equal elements 0.
    //... so. on
    //So Number of unique elements == Number of Operations
    //So we need a set to record unique numbers and return size
    public int minimumOperations(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(num != 0){
                set.add(num);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {1,5,0,3,5};
        int minimumOperations = new MakeArrayZeroBySubtractingEqualAmounts().minimumOperations(nums);
        //Explanation:
        //In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
        //In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
        //In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].
        System.out.println(minimumOperations);
    }
}
