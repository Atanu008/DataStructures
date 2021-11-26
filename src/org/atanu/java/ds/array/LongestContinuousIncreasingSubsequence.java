package org.atanu.java.ds.array;

//https://leetcode.com/problems/longest-continuous-increasing-subsequence/
//LeetCode 647
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {

        int result = 0; //Empty array would result to zero
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            //If next element is bigger then increment the running count and update Max(result)
            //Default increase for first element.
            if(i == 0 || nums[i] > nums[i - 1]){
                count++;
                result = Math.max(count,result);
            }
            else{//Reset count its not increasing any more
                count = 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence longestSeq = new LongestContinuousIncreasingSubsequence();
        int[] nums = {1,3,5,4,7};
        System.out.println("Longest Sequence is "+ longestSeq.findLengthOfLCIS(nums));

        nums = new int[]{2, 2, 2, 2, 2};
        System.out.println("Longest Sequence is "+ longestSeq.findLengthOfLCIS(nums));

    }
}
