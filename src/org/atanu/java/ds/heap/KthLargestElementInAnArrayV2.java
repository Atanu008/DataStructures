package org.atanu.java.ds.heap;

import java.util.Random;

//Using Quick Select
//https://leetcode.com/problems/kth-largest-element-in-an-array/
//LeetCode 215

//Time Complexity : O(n) Worst case O(n^2)
//Space O(1)
public class KthLargestElementInAnArrayV2 {
    private int partition(int[] nums, int start, int end, int pivotIndex) {

        int pIndex = start;
        int pivot = nums[pivotIndex];
        // 1. move pivot to end
        swap(nums, pivotIndex, end);

        // 2. move all smaller elements of Pivot to the left
        for(int i = start; i < end; i++ ){
            if(nums[i] < pivot){
                swap(nums, pIndex, i);;
                pIndex++;
            }
        }

        // move pivot to its final Right place
        swap(nums, pIndex, end);
        return pIndex;
    }

    /*
   Returns the k-th smallest element of list within left..right.
   */
    public int quickSelect(int[] nums, int start, int end, int kthSmallest){

        //Only One Element in the Array
        if(start == end){
            return nums[start];
        }
        // select a random pivot_index
        Random random_num = new Random();
        int pivotIndex = start + random_num.nextInt(end - start);
        pivotIndex = partition(nums, start, end, pivotIndex);

        // the pivot is on (N - k)th smallest position
        if(pivotIndex == kthSmallest){
            return nums[pivotIndex];
        }
        //Go left . if `k` is less than the pivot index
        else if(kthSmallest < pivotIndex){
            return quickSelect(nums, start, pivotIndex -1, kthSmallest);
        }
        // Go right , If
        else{
            return quickSelect(nums, pivotIndex +1, end , kthSmallest);
        }
    }

    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        // kth largest is (N - k)th smallest
        return quickSelect(nums, 0, size -1, size - k);
    }

    public static void main(String[] args) {
        KthLargestElementInAnArrayV2 kthLargestElementInAnArrayV2 = new KthLargestElementInAnArrayV2();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println("Kth Largest Element in the Array is "+ kthLargestElementInAnArrayV2.findKthLargest(nums, k));
    }
}
