package org.atanu.java.ds.twopointer;

import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/
//LeetCode 75
public class SortColors {

    public void sortColors(int[] nums) {

        int pivot = 1; // Chosen One because for this requirement only
        int low = 0; // will place zeros from start Index.
        int mid = 0; // forward moving pointer
        int high = nums.length - 1; // will place two from end Index

        while(mid <= high){

            //For the Case of Zero . swap zero in start and forward the flow
            if(nums[mid] < pivot){
                swap(nums, low,mid);
                low++;
                mid++;
            }
            // For Case One . Do nothing . Just forward the pointer
            else if(nums[mid] == pivot){
                mid++;
            }
            // For Case Two . swap mid to end. But dont increment the mid.
            // After swap arr[mid] can either be 0,1
            // we will not move mid as the swapped value can be 0 or 1(less than Or Equal to Pivot)
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
