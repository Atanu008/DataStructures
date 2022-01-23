package org.atanu.java.ds.twopointer;

import java.util.Arrays;

//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
//LeetCode 581
public class ShortestUnsortedContinuousSubarray {
    //We can sort a copy of the given array numsnums, say given by nums\_sortednums_sorted. Then, if we compare the elements of numsnums and nums\_sortednums_sorted, we can determine the leftmost and rightmost elements which mismatch. The subarray lying between them is, then, the required shorted unsorted subarray.
    public int findUnsortedSubarray(int[] nums) {

        //Create and sort the clonned Array
        int[] clonned = nums.clone();
        Arrays.sort(clonned);

        int start = 0;
        int end = nums.length -1;

        //Find the Left Most mismatch
        while(start < nums.length){
            if(nums[start] != clonned[start]){
                break;
            }
            start++;
        }
        //Corner case. If the array is sorted . then start will point to last
        if(start == nums.length){
            return 0;
        }
        //Find the Right Most mismatch
        while(end >= 0){
            if(nums[end] != clonned[end]){
                break;
            }
            end--;
        }
        return end-start+1;
    }

    //O(N)
    //space O(1)O(1)
    public int findUnsortedSubarrayV2(int[] nums) {

        int low = 0;
        int high = nums.length-1;
        // find the first number out of sorting order from the beginning
        while(low < nums.length-1 && nums[low] <= nums[low+1]){
            low++;
        }

        // if the array is sorted
        if(low == nums.length-1){
            return 0;
        }
        // find the first number out of sorting order from the end
        while(high > 0 && nums[high] >= nums[high-1]){
            high--;
        }

        // find the maximum and minimum of the subarray
        int subArrayMax = Integer.MIN_VALUE;
        int subArrayMin = Integer.MAX_VALUE;
        for(int i = low; i <= high; i++){
            subArrayMax = Math.max(nums[i], subArrayMax);
            subArrayMin = Math.min(nums[i], subArrayMin);
        }

        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while(low >0 && nums[low-1] > subArrayMin){
            low--;
        }
        // extend the subarray to include any number which is smaller than the maximum of the subarray
        while(high < nums.length-1 && nums[high+1] < subArrayMax){
            high++;
        }

        return high -low +1;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        ShortestUnsortedContinuousSubarray subarray = new ShortestUnsortedContinuousSubarray();
        int length = subarray.findUnsortedSubarray(nums);
        //Output: 5
        //Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
        System.out.println(length);
        length = subarray.findUnsortedSubarrayV2(nums);
        System.out.println(length);
    }
}
