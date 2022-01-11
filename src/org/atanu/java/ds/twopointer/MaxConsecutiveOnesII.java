package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/max-consecutive-ones-ii/
//LeetCode 487
//MaxConsecutiveOnes III is more generalized version. it takes K switch . here K == 1
public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
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
            while(zeros > 1){
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
        MaxConsecutiveOnesII maxConsecutiveOnes = new MaxConsecutiveOnesII();
        int[] nums = {1,0,1,1,0};
        //Output: 4
        //Explanation: Flip the first zero will get the maximum number of consecutive 1s.
        //After flipping, the maximum number of consecutive 1s is 4.
        System.out.println("Max Consecutive Ones "+ maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }
}
