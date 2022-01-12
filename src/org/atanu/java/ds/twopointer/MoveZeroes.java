package org.atanu.java.ds.twopointer;

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int pivot = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // Just Change this condition To move Last or First
            // == is for first as . will copy the zero to first and move on
            if (nums[i] != pivot) {
                swap(nums, i, index);
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);

    }
}