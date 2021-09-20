package org.atanu.java.ds.binarysearch;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//LeetCode 34
public class FirstLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        // int firstPos = searchLeft(nums, target);
        //int lastPos = searchRight(nums, target);

        //int firstPos = searchLeftV2(nums, target);
        //int lastPos = searchRightV2(nums, target);

        int firstPos = searchLeftV3(nums, target);
        int lastPos = searchRightV3(nums, target);

        result[0] = firstPos;
        result[1] = lastPos;

        return result;
    }

    public int searchLeft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                high = mid - 1; // This will keep the progress to left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public int searchRight(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                low = mid + 1; //This will keep the progress to right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public int searchLeftV2(int[] nums, int target) {
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

    public int searchRightV2(int[] nums, int target) {
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

    public int searchLeftV3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (nums[low] != target && nums[high] != target) {
            return -1;
        }

        return nums[low] == target ? low : high;
    }

    public int searchRightV3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[low] != target && nums[high] != target) {
            return -1;
        }

        return nums[high] == target ? high : low;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = new FirstLastPositionInSortedArray().searchRange(nums, target);
        System.out.println("First and Last Index " + Arrays.toString(result));
    }
}
