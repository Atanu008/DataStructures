package org.atanu.java.ds.dp;

// Variation Of Longest Increasing Subsequence
// Another variation is Leetcode 1671 Minimum Number of Removals to Make Mountain Array
// https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/3Yw0xvBKQVx

//Video : https://www.youtube.com/watch?v=jdfpGSSyN2I

public class LongestBitonicSubsequence {
    //We can separately calculate LIS ans LDS for every index i.e., from the beginning to the end of the array and vice versa.
    // The required length of LBS would be the one that has the maximum sum of LIS and LDS for a given index.
    private int findLBSLength(int[] nums) {
        int[] LIS = new int[nums.length];
        int[] LDS = new int[nums.length];

        LIS[0] = 1;
        for(int i = 1; i < nums.length; i++){
            LIS[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }

            }
        }

        LDS[nums.length -1] = 1;
        for(int i = nums.length -2; i >= 0; i--){
            LDS[i] = 1;
            for(int j = nums.length -1; j > i; j--){
                if(nums[i] > nums[j]){
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        int bitonicLength = 0;
        for(int i = 0; i < nums.length; i++){
            bitonicLength = Math.max(bitonicLength, LIS[i]+LDS[i] -1); // -1 as the common element added twice as LIS and LDS
        }

        return bitonicLength;
    }
    public static void main(String[] args) {
        LongestBitonicSubsequence longestBitonicSubsequence = new LongestBitonicSubsequence();
        int[] nums = {4,2,3,6,10,1,12};
        //Output: 5
        //Explanation: The LBS is {2,3,6,10,1}.
        System.out.println(longestBitonicSubsequence.findLBSLength(nums));
        nums = new int[]{4,2,5,9,7,6,10,3,1};
        //Output: 7
        //Explanation: The LBS is {4,5,9,7,6,3,1}.
        System.out.println(longestBitonicSubsequence.findLBSLength(nums));
    }

}
