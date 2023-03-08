package org.atanu.java.ds.dp;

//https://leetcode.com/problems/target-sum/description/
//Leetcode 494
//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/g2Ko7qNYEEj

//Video : https://www.youtube.com/watch?v=hqGa65Rp5LQ&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=13
public class TargetSum_v2 {
    //Assume All -ve values are in one set(S1) and all +ve values are in another subset(S2)
    //Then the goal is to Find Number of ways to divide a set into 2 subsets such that S1 - S2 = target
    //This Problem is same Count Number of Subset with Given Difference S1 - S2 = Difference

    //Now We Know
    //    S1 + S2 = Sum
    //    S1 - S2 = Target
    // => S1 - (Sum - S1) = Target
    // => 2S1 - Sum = Target
    // => S1 = (Target + Sum) / 2; // This derived in terms of S1 . same can be derived in terms od S2

    //Now the Goal is to find Num of Sub set having sum as S1[(Target + Sum) / 2]

    public int findTargetSumWays(int[] a, int target) {
        int n = a.length;
        int sum = 0;
        int countZeroes = 0;

        for (int x : a) {
            sum += x;
            if (x == 0) {
                countZeroes++;
            }
        }
        //target > sum  if given target is greater than sum then no matter what you do, you wont be able to make
        //If we can not get (sum + target) / 2 as Integer then its not possible to divide is subset
        if (target > sum || (sum + target) % 2 != 0)
            return 0;
        int S1 = (target + sum) / 2;
        return countSubsetSum(a, n, S1);

    }

    public int countSubsetSum(int nums[], int n, int sum) {

        int dp[][] = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(nums[i - 1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
