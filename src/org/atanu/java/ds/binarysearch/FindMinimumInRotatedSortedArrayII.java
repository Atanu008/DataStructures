package org.atanu.java.ds.binarysearch;

//Video : https://www.youtube.com/watch?v=j3187M1P2Xg
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
//LeetCode 154
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // iterate till search space contains at-least one element
        while (low < high){
            int mid = low + (high -low)/2;

            //No possible solution here. we can discard the left part as it is not sarted as mid greater than high
            if(nums[mid] > nums[high]){
                low = mid+1;
            }
            else if(nums[mid] < nums[high]){
                //If arr[mid] is <= arr[high] so it is sorted and psooible solution.
                //so we need to move left . high is will to move left
                high = mid;
            }
            else{
                // when mid is equal to high. then we need to just decrement high to decrese the search spae
                high--;
            }
        }

        return nums[high];
    }

    public static void main(String[] args) {
        int[] A = {4,5,6,7,1,4,4};
        System.out.println("Minimum Element in rotated Array " + new FindMinimumInRotatedSortedArrayII().findMin(A));
    }
}
