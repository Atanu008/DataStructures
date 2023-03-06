package org.atanu.java.ds.dp;

//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
//Leetcode 718
//Same as Longest Common Substring
public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for(int i = 1; i <= nums1.length; i++){
            for(int j = 1; j <= nums2.length; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray  maximumLengthOfRepeatedSubarray = new MaximumLengthOfRepeatedSubarray();
        int[] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
        System.out.println(maximumLengthOfRepeatedSubarray.findLength(nums1, nums2));
    }
}
