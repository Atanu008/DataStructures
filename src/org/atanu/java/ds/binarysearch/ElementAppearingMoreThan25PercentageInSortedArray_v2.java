package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/
// Leetcode 1287

public class ElementAppearingMoreThan25PercentageInSortedArray_v2 {

    // Binary Search Solution
    // As the array is sorted. Check the length of the each element
    // lengthOfTarget = lastIndexOfTarget - firstIndexOfTarget + 1;
    // If(lengthOfTarget > arr.length / 4){
    //  return that number
    // }
    public int findSpecialInteger(int[] arr) {
        for(int a : arr){
            int firstIndexOfTarget = searchLeft(arr, a);
            int lastIndexOfTarget = searchRight(arr, a);
            int lengthOfTarget = lastIndexOfTarget - firstIndexOfTarget + 1;
            if(lengthOfTarget > arr.length / 4){
                return a;
            }
        }

        return -1;
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

        ElementAppearingMoreThan25PercentageInSortedArray_v2 elements = new ElementAppearingMoreThan25PercentageInSortedArray_v2();
        int[] arr = {1,2,2,6,6,6,6,7,10};
        System.out.println(elements.findSpecialInteger(arr));
    }
}
