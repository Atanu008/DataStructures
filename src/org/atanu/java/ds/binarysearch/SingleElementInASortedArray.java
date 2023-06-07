package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
// Leetcode 540
// Video : https://www.youtube.com/watch?v=nMGL2vlyJk0
public class SingleElementInASortedArray {

    // Log(N) solution
    public int singleNonDuplicate(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length;
        while(low <= high){

            int mid = low + (high - low) / 2;

            // Return if its a single element i.e NOT Equal to its left and Right adjacent element
            if((mid > 0 && mid < n - 1)
                    && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }

            // This is tricky
            // If a pair is started with EVEN index and ends with ODD index
            // then single element will not be present in left part. search in right part
            if((mid % 2 == 0 && mid < n - 1 && nums[mid] == nums[mid + 1])
                    || (mid % 2 == 1 && mid > 0 && nums[mid] == nums[mid - 1])){
                low = mid + 1;
            }
            else {// If a pair is started with ODD index and ends with EVEN index
                // then single element will not be present in Right part. search in Left part
                high = mid - 1;
            }
        }

        return nums[low]; // as the array
    }

    // same as Above solution but with differnet Template
    // Prefer this solution
    public int singleNonDuplicate_v2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length;
        while(low < high){

            int mid = low + (high - low) / 2;

            // This is tricky
            // If a pair is started with EVEN index and ends with ODD index
            // then single element will not be present in left part. search in right part
            if((mid % 2 == 0 && mid < n - 1 && nums[mid] == nums[mid + 1])
                    || (mid % 2 == 1 && mid > 0 && nums[mid] == nums[mid - 1])){
                low = mid + 1;
            }
            else {// If a pair is started with ODD index and ends with EVEN index
                // then single element will not be present in Right part. search in Left part. also possible answer
                high = mid;
            }
        }

        return nums[low]; // as the array
    }

    // O(N)
    // XOR of duplicate elements will be zero
    // after the loop will have single element
    public int singleNonDuplicate_v3(int[] nums) {
        int a = 0;
        for(int x : nums){
            a = a^x;
        }

        return a;
    }

    public static void main(String[] args) {
        SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleElementInASortedArray.singleNonDuplicate(nums));
        System.out.println(singleElementInASortedArray.singleNonDuplicate_v3(nums));
    }
}
