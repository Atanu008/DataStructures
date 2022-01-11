package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/max-consecutive-ones-iii/
//LetCode 1004
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {

        int longestOnes = 0;
        int zeros = 0;
        int windowEnd = 0;
        int windowStart = 0;

        // while our window is in bounds
        while(windowEnd < nums.length){

            // add the right most element into our window
            if(nums[windowEnd] == 0){
                zeros++;
            }

            // if our window is invalid, contract our window
            while(zeros > k){
                if(nums[windowStart] == 0){
                    zeros--;
                }
                windowStart++;
            }

            // update our longest sequence answer
            longestOnes = Math.max(longestOnes, windowEnd - windowStart +1);
            // expand our window
            windowEnd++;
        }

        return longestOnes;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII maxConsecutiveOnes = new MaxConsecutiveOnesIII();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k =2;
        //Output: 6
        //Explanation: [1,1,1,0,0,1,1,1,1,1,1]
        //Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
        System.out.println("Max Consecutive Ones "+ maxConsecutiveOnes.longestOnes(nums, k));
    }
}
