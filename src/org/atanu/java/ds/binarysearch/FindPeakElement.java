package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/find-peak-element/
//LeetCode 162

//Caould ble aso Termed as Bitonic Array Maximum : https://www.educative.io/courses/grokking-the-coding-interview/RMyRR6wZoYK

// Looks like Leetcode 162 and 852 essentially same problem

public class FindPeakElement {

    //Video : https://www.youtube.com/watch?v=r7U0N2EE_l8
    public int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length -1;

        while(low < high){
            int mid = low + (high -low)/2;

            //If mid is greater than next then there is 100 percentage there will be at least one pick in left
            //And we are not sure about right. So lets search Left by doing  high = mid;
            if(nums[mid] > nums[mid +1]){
                high = mid;
            }
            else{
                low = mid +1;
            }
        }

        return high;
    }

    //Iterative Version

    public int findPeakElement_v2(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            // check if mid element is greater than its neighbors
            // It also covers the single element case
            if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] < nums[mid])){
                return mid;
                // If middle element is not peak and its left neighbor is
                // greater than it,then left half must have a peak element
            }else if(mid == 0 || nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            }
            // If middle element is not peak and its right neighbor
            // is greater than it, then right half must have a peak
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    // Recursive Version
    public int findPeakElement_v3(int[] nums) {

        return findPeakElementUtil(nums, 0, nums.length - 1);
    }

    //Binary search starting with left = 0, right = n-1, mid = (left + right) / 2
    //If nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1] return mid as peak.
    //Else if nums[mid-1] > nums[mid] then search peak on the Left side.
    // Otherwise Search in Right side
    public int findPeakElementUtil(int[] A, int low, int high) {

        int mid = low + (high - low) / 2;

        // check if mid element is greater than its neighbors
        // It also covers the single element case
        if ((mid == 0 || A[mid - 1] <= A[mid]) &&
                (mid == A.length - 1 || A[mid + 1] <= A[mid])) {
            return mid;
        }

        // If middle element is not peak and its left neighbor is
        // greater than it,then left half must have a peak element
        if (mid > 0 && A[mid - 1] > A[mid]) {
            return findPeakElementUtil(A, low, mid - 1);
        }

        // If middle element is not peak and its right neighbor
        // is greater than it, then right half must have a peak
        return findPeakElementUtil(A, mid + 1, high);

    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int arr[] = {1, 2, 1, 4, 1, 0};
        //	int arr[] = {1, 3, 5, 10, 9, 20};

        int index = findPeakElement.findPeakElement_v3(arr);

        System.out.println("Peak Element is " + arr[index]);

    }

}
