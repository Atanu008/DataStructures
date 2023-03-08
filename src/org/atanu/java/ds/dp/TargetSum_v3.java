package org.atanu.java.ds.dp;

//https://leetcode.com/problems/target-sum/description/
//Leetcode 494
//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/g2Ko7qNYEEj
//Video : https://www.youtube.com/watch?v=hqGa65Rp5LQ&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=13
public class TargetSum_v3 {

    // nums = [0,0,0,0,0,0,0,0,1] Target = 1 : Output = 256
    // Previuos solution did covet this case where zero can be there input
    //The solution doesn't consider presence of "0"s in the array. Why the output is different ?
    //Because, if we have "0", then, it can have +0 and -0 and still will not effect the sum of a set. For example: Target value is = 2
    //1) {0,2} = {+0,2}, {-0,2}.  Ans: 2
    //But if we increase number of 0s,
    //2) {0,0,2} = {+0,+0,2}, {+0,-0,2}, {-0,+0,2},{-0,-0,2} . Ans: 4
    //
    //So, if you observe, your answer increase by (2^number of 0s) i.e. pow(2,number of zeros).
    //So, make a small change as follows:
    //1) on count of subsetsum function,
    //if(nums[i-1] > j )    => change to:  if (nums[i-1] > j || nums[i-1] == 0)
    //      dp[i][j] = dp[i-1][j];
    // //make no change and put the previous value as it is in the next subproblem. (I.e. 2, in example above)
    //And then at the end, you answer will be
    //return (int)Math.pow(2, number of 0s) * dp[nums.length][target] ;
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
        //Some weird cases where target is negative
        if(S1 < 0){
            return 0;
        }
        return (int)Math.pow(2,countZeroes) * countSubsetSum(a, n, S1);
    }

    public int countSubsetSum(int nums[], int n, int sum) {

        int dp[][] = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(nums[i - 1] != 0 && nums[i - 1] <= j){ // Change from previous version : Take only non zero nums[i - 1] != 0
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
