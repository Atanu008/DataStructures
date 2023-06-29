package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/sort-array-by-parity/description/
// Leetcode 905
// Exactly same Move Zeros . Move Negative Right
// Only the if condition is different

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {

        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                swap(nums, index, i);
                index++;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int a, int b){

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] nums = {3,1,2,4};
        System.out.println(sortArrayByParity.sortArrayByParity(nums));
    }

}
