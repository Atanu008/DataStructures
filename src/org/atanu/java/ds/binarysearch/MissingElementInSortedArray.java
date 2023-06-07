package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/missing-element-in-sorted-array/description/
// Leetcode 1060

public class MissingElementInSortedArray {

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        /*
        First , we check if k is greater than total missing numbers between [0,n).
        If yes, then we take last number and add k.
        but we need to take into account total missing numbers between [0,n).
        so, we subtract those total missing numbers and get the actual missing one.
        */
        if(k > totalMissingNumber(nums,n-1))

            return nums[n - 1] + (k - totalMissingNumber(nums,n-1));

        /*
        Incase, k is in between [0,n), then we do binary search to get the nearest largest index
        which can contain k number of missing elements.
         */
        int low = 0, high = n-1;
        while(low < high){
            int mid = low+(high-low)/2;
            if(totalMissingNumber(nums,mid)<k)
                low = mid+1;
            else
                high = mid;
        }
        /*
        the loop breaks when low == high
        At nums[high] we have missing number >= k
        Kth missing number belong between nums[high - 1] and nums[high]
        count the Number of missing positive till nums[high - 1] i,e totalMissingNumber(nums,high-1)
        So the remaining missing elemnst are (k - totalMissingNumber(nums,high-1))
        So Kth Missing is : nums[high-1] + (k - totalMissingNumber(nums,high-1))
         */
        return nums[high-1] + k - totalMissingNumber(nums,high-1);
    }

    private int totalMissingNumber(int nums[], int idx){
        return nums[idx] - nums[0] - idx;
    }

    public static void main(String[] args) {
        MissingElementInSortedArray missingElementInSortedArray = new MissingElementInSortedArray();
        int[] nums = {4,7,9,10};
        int k = 1;
        System.out.println(missingElementInSortedArray.missingElement(nums, k));

        nums = new int[]{4,7,9,10};
        k = 3;
        System.out.println(missingElementInSortedArray.missingElement(nums, k));

        nums = new int[]{1,2,4};
        k = 3;
        System.out.println(missingElementInSortedArray.missingElement(nums, k));

    }
}
