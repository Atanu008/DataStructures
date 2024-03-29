package org.atanu.java.ds.math;

import java.util.Arrays;

//LeetCode 31
//https://leetcode.com/problems/next-permutation/
public class NextPermutation {

    //72531 Next Greater is 73125
    // we need to swap 2 with 3
    // justIncreasingPoint is index of 2
    // justGreaterthanPoint is index of 3;
    // after swap 73521
    // Reverse after current Index of 3 - 73125
    public void nextPermutation(int[] nums) {
        int justIncreasingPoint = -1;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        justIncreasingPoint = i;
        if (justIncreasingPoint >= 0) {
            int justGreaterthanPoint = nums.length - 1;
            while (nums[justGreaterthanPoint] <= nums[justIncreasingPoint]) {
                justGreaterthanPoint--;
            }
            swap(nums, justIncreasingPoint, justGreaterthanPoint);
        }

        // Arrange these elements in Ascending Element
        reverse(nums, justIncreasingPoint + 1, nums.length - 1);

    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j) swap(A, i++, j--);
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {1,2,3};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
}
