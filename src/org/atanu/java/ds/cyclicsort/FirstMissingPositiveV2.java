package org.atanu.java.ds.cyclicsort;

//https://leetcode.com/problems/first-missing-positive/
//LeetCode 41
//https://www.educative.io/courses/grokking-the-coding-interview/R1GXQ071GQ0
public class FirstMissingPositiveV2 {

    //Same code as Version 1 . just followed the code template of cyclic sort
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        //Put each number in its right place
        //Swap numbers if the number is not in its correct position
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        //At last, the first place where its number is not right, return the place + 1.
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return n + 1; //corner case: {1,2,3,4} return 5
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        FirstMissingPositiveV2 firstMissingPositive = new FirstMissingPositiveV2();
        System.out.println("First Missing Positive is "+ firstMissingPositive.firstMissingPositive(nums));
    }
}
