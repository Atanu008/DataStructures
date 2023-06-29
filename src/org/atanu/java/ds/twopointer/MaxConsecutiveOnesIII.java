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
        while (windowEnd < nums.length) {

            // add the right most element into our window
            if (nums[windowEnd] == 0) {
                zeros++;
            }

            // if our window has zeros > k then its a Invalid window, Shrink the Window
            // After while is done window will have at most K zeros
            while (zeros > k) {
                if (nums[windowStart] == 0) {
                    zeros--;
                }
                windowStart++;
            }

            // update our longest sequence answer
            longestOnes = Math.max(longestOnes, windowEnd - windowStart + 1);
            // expand our window
            windowEnd++;
        }

        return longestOnes;
    }

    //https://www.educative.io/courses/grokking-the-coding-interview/B6VypRxPolJ
    public int longestOnesV2(int[] nums, int k) {

        int windowEnd = 0;
        int windowStart = 0;
        int maxLength = 0;
        int maxOnesCount = 0;
        // try to extend the range [windowStart, windowEnd]
        while (windowEnd < nums.length) {
            if (nums[windowEnd] == 1)
                maxOnesCount++;

            // current window size is from windowStart to windowEnd, overall we have a maximum of 1s
            // repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
            // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
            // now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' Os
            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (nums[windowStart] == 1) {
                    maxOnesCount--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            windowEnd++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII maxConsecutiveOnes = new MaxConsecutiveOnesIII();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        //Output: 6
        //Explanation: [1,1,1,0,0,1,1,1,1,1,1]
        //Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
        System.out.println("Max Consecutive Ones " + maxConsecutiveOnes.longestOnes(nums, k));
    }
}
