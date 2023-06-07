package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/description/
// Leetcode 1150

// Given an integer array nums sorted in non-decreasing order and an integer target, return true if target is a majority element, or false otherwise.
//
//A majority element in an array nums is an element that appears more than nums.length / 2 times in the array.
// Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
//Output: true
//Explanation: The value 5 appears 5 times and the length of the array is 9.
//Thus, 5 is a majority element because 5 > 9/2 is true.

public class CheckIfANumberIsMajorityElementInASortedArray {


    public boolean isMajorityElement(int[] nums, int target) {

        int count = 0;

        for(int num : nums){
            if(num == target){
                count++;
            }
        }

        return count > nums.length / 2;
    }

    // As the array is sorted , we can use Binary Search
    // Binary Search Approach
    // We find the highest and the lowest indexes of target and subtract them to check for count.
    public boolean isMajorityElement_v2(int[] nums, int target) {

        int firstIndexOfTarget = searchLeft(nums, target);
        // Corner Case. Number itself is not present
        // Return false;
        if(firstIndexOfTarget == -1){
            return false;
        }
        int lastIndexOfTarget = searchRight(nums, target);
        int lengthOfTarget = lastIndexOfTarget - firstIndexOfTarget + 1;

        if(lengthOfTarget > nums.length / 2){
            return true;
        }

        return false;

    }

    public int searchLeft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid; //To Go left High has to move(help) left
            }
        }
        return nums[high] == target ? high : -1;
    }

    //●	When can we have infinite loops - whenever mid is not making progress.
    public int searchRight(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            //If we have to move “mid” towards right (in case of duplicates in the array),
            //then mid has to be calculated as (lo + hi) / 2 + 1
            //since by default integer division leans towards left.
            int mid = low + (high - low) / 2 + 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid; //To Go Right Low has to move(help) Right
            }
        }
        return nums[low] == target ? low : -1;
    }

    public static void main(String[] args) {
        CheckIfANumberIsMajorityElementInASortedArray inASortedArray = new CheckIfANumberIsMajorityElementInASortedArray();

        int[] nums = {2,4,5,5,5,5,5,6,6};
        int target = 5;
        System.out.println(inASortedArray.isMajorityElement(nums, target));
        System.out.println(inASortedArray.isMajorityElement(nums, target));

        nums = new int[]{10, 100, 101, 101};
        target = 101;
        System.out.println(inASortedArray.isMajorityElement(nums, target));
        System.out.println(inASortedArray.isMajorityElement(nums, target));
    }
}
