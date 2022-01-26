package org.atanu.java.ds.cyclicsort;

//https://leetcode.com/problems/find-the-duplicate-number/
//LeetCode 287
//This one is not that Intuitive
public class FindTheDuplicateNumberV2 {

    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {

            if (nums[i] != i + 1) {
                int j = nums[i] - 1;
                if (nums[i] != nums[j]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    return nums[i];
                }// we have found the duplicate

            } else {
                i++;
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
