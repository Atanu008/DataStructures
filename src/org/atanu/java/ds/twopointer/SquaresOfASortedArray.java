package org.atanu.java.ds.twopointer;

import java.util.Arrays;

//https://leetcode.com/problems/squares-of-a-sorted-array/
//LeetCode 977
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int low = 0;
        int high = nums.length -1;
        int index = high;
        while(low<= high){
            if(Math.abs(nums[low]) > Math.abs(nums[high])){
                result[index] = nums[low]*nums[low];
                low++;
            }
            else{
                result[index] = nums[high]*nums[high];
                high--;
            }
            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] result = new SquaresOfASortedArray().sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}
