package org.atanu.java.ds.dp;

//https://www.geeksforgeeks.org/count-of-subsets-with-given-difference/
//Video : https://www.youtube.com/watch?v=QihB4bI6BJw&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=12

//Given an array arr[] of size N and a given difference diff,
//the task is to count the number of partitions that we can perform such that
//the difference between the sum of the two subsets is equal to the given difference


//Now We Know
//    S1 + S2 = Sum
//    S1 - S2 = Target
// => (sum - S2) - S2 = Target
// => 2S2 = Sum - Target
// => S2 = (Sum - Target) / 2; // This derived in terms of S2 . same can be derived in terms of S1 (check Target Sum for S1)

//Now the Goal is to find Num of Sub set having sum as S2[(Sum - Target) / 2]
public class NumberOfSubsetsWithGivenDifference {

    public int countSubsetWithDifference(int[] nums, int diff){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //If S2 is not an integer then its not possible to mak ethe subsets
        if((sum - diff) % 2 != 0){
            return 0;
        }

        int requiredSum = (sum - diff) / 2;

        int[][] dp = new int[n + 1][requiredSum + 1];
        //its possible to form sub set by not including any number to form zero sum
        //So the first column is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= requiredSum; j++) {
                if(nums[i - 1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][requiredSum];
    }

    public static void main(String[] args) {
        NumberOfSubsetsWithGivenDifference numberOfSubsetsWithGivenDifference = new NumberOfSubsetsWithGivenDifference();
        int[] nums = { 1, 2, 3, 1, 2 };
        int diff = 1;
        int noOfSubset = numberOfSubsetsWithGivenDifference.countSubsetWithDifference(nums, diff);
        System.out.println(noOfSubset);
    }

}
