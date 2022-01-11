package org.atanu.java.ds.twopointer;

import java.util.Arrays;

//https://leetcode.com/problems/valid-triangle-number/
//LeetCode 611
//Kind of same as 3sum Closest
//Video : https://www.youtube.com/watch?v=PqEiJDdt3S4
public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);
        int count = 0;

        for(int i = nums.length -1; i > 1; i--){
            int left = 0;
            int right = i - 1;

            while(left < right){
                //Since the array is sorted and nums[left] + nums[right] > nums[i],
                //we know that all elements from left, left+1, left+2 till just before right will also satisfy the condition.
                //hence we directly add (right-left) to the result. After that,
                //we reduce right by one place and follow the same process.
                if(nums[left] + nums[right] > nums[i]){
                    count += right -left;
                    right--;
                }else{
                    left++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        ValidTriangleNumber validTriangleNumber = new ValidTriangleNumber();
        int[] nums = {2,2,3,4};
        //Output: 3
        //Explanation: Valid combinations are:
        //2,3,4 (using the first 2)
        //2,3,4 (using the second 2)
        //2,2,3
        System.out.println("Valid Triangle Number "+ validTriangleNumber.triangleNumber(nums));
    }
}
