package org.atanu.java.ds.array;

//https://leetcode.com/problems/contiguous-array/
//LeetCode 525
public class ContiguousArray {


    //Brute Force
    public int findMaxLength(int[] nums) {

        int maxLength = 0;
        int zeros = 0;
        int ones = 0;

        for(int i = 0; i < nums.length; i++){
            zeros = 0;
            ones = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 0){
                    zeros++;
                }
                if(nums[j] == 1){
                    ones++;
                }
                if(zeros == ones){
                    maxLength = Math.max(maxLength, j-i+1);
                }

            }
        }

        return maxLength;
    }
}
