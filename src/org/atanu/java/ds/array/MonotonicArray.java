package org.atanu.java.ds.array;

//https://leetcode.com/problems/monotonic-array/description/
//Leetcode 896
public class MonotonicArray {

    //One Pass Solution
    public boolean isMonotonic(int[] nums) {

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        int i = 0;
        while(i < nums.length - 1){
            if(nums[i] > nums[i+1]){
                isIncreasing = false;
            }
            if(nums[i] < nums[i+1]){
                isDecreasing = false;
            }
            if( !isIncreasing && !isDecreasing){
                return false; // Either Not decreasing and Not Increasing
            }

            i++; //move i
        }

        return true;

    }

    //Two Pass Solution
    public boolean isMonotonic_v2(int[] nums) {

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        int i = 0;
        while(i < nums.length - 1){
            if(nums[i] > nums[i+1]){
                isIncreasing = false;
                break;
            }
            i++;
        }
        //Check if it is Increasing , then No need to check for decreasing
        System.out.println(i);
        if(i == nums.length -1){
            return true;
        }

        int j = 0;
        while(j < nums.length - 1){
            if(nums[j] < nums[j+1]){
                isDecreasing = false;
                break;
            }
            j++;
        }

        return  j == nums.length - 1; // reached last so . no decrement
    }
}
