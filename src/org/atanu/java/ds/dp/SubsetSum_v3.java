package org.atanu.java.ds.dp;

import java.util.Arrays;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/m2Y5z9BQL6E
//Video : https://www.youtube.com/watch?v=34l1kTIQCIA&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=8

//Given a set of positive numbers arr and a value total,
//determine if there exists a subset in the given set whose sum is equal to total.
//A subset can be an empty set, or it can either consist of some elements of the set or all the elements of the set.
//
//Let’s say you are given a set = {1, 2, 3, 7} and a total = 6.
//The output will be TRUE as the subset = {1, 2, 3} adds up to make the desired total (1+2+3) = 6.

public class SubsetSum_v3 {

    //Its a bottom up version
    //Just care fully observe the base condition in recursion
    //Same base will be here
    //So in recursion when total became zero then we returned true
    //We will plot nums in rows and total in column
    //So the first column will represnt zero(0) total , So the first column will be true
    //All the other cell will be false
    public boolean subsetSum(int[] nums, int total){

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][total + 1];
        // If sum is 0, then answer is true
        //Explained in above comments
        for(int i  = 0; i <= n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= total; j++){

                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][total];
    }

    public static void main(String[] args) {
        SubsetSum_v3 subsetSum = new SubsetSum_v3();
        int[] nums = {1, 2, 3, 7};
        int total = 6;
        boolean ans = subsetSum.subsetSum(nums, total);
        System.out.println("Bottom UP");
        System.out.println("Does a subset of " + Arrays.toString(nums) + " sum up to " + total + " ?  " + ans);

        nums = new int[]{2, 4, 7};
        total = 8;
        ans = subsetSum.subsetSum(nums, total);
        System.out.println("Does a subset of " + Arrays.toString(nums) + " sum up to " + total + " ?  " + ans);
    }
}
