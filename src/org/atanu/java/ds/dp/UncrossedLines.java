package org.atanu.java.ds.dp;

//https://leetcode.com/problems/uncrossed-lines/description/
//Leetcode 1035

//Its exactly same as Longest common Subsequence(LCS)
public class UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        Integer[][] dp = new Integer[nums1.length][nums2.length];

        return longestCommonSubsequence(0, 0, nums1, nums2, dp);
    }

    private int longestCommonSubsequence(int i, int j, int[] nums1, int[] nums2, Integer[][] dp){

        if(i == nums1.length || j == nums2.length){
            return 0;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(nums1[i] == nums2[j]){
            return dp[i][j] =  1 + longestCommonSubsequence(i+1, j+1, nums1, nums2, dp);
        }

        dp[i][j] = Math.max(longestCommonSubsequence(i+1, j, nums1, nums2, dp), longestCommonSubsequence(i, j+1, nums1, nums2, dp));
        return dp[i][j];
    }

    public static void main(String[] args) {
        UncrossedLines uncrossedLines = new UncrossedLines();
        int[] nums1 = {1,4,2}, nums2 = {1,2,4};
        System.out.println(uncrossedLines.maxUncrossedLines(nums1, nums2));
    }
}
