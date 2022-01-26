package org.atanu.java.ds.cyclicsort;

public class MissingNumber {

    //We can harness the fact that XOR is its own inverse to find the missing element in linear time.
    public int missingNumber(int[] nums) {
        int res = nums.length;

        for(int i = 0; i < nums.length ; i++){

            res = res ^ i ^ nums[i];
        }

        return res;
    }

    // Gauss' Formula
    public int missingNumberV2(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }


    //Cylic Sort
    //https://www.educative.io/courses/grokking-the-coding-interview/JPnp17NYXE9
    //In this problem, each number should be equal to its index, compared to index - 1 in the Cyclic Sort. Therefore => nums[i] == nums[nums[i]]
    //Since the array will have ‘n’ numbers, which means array indices will range from 0 to ‘n-1’. Therefore, we will ignore the number ‘n’ as we can’t place it in the array, so => nums[i] < nums.length
    public int missingNumberV3(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }

        }
        // find the first number missing from its index, that will be our required number
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return nums.length;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
