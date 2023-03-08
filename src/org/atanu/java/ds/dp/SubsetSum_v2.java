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
public class SubsetSum_v2 {
    //Exactly same as 0/1 Knapsack
    //Check the comments to find out the similarities
    public boolean subsetSum(int[] nums, int n, int total, Boolean[][] dp){
        //Base Case :
        //We are able to form the total
        //Return true
        if(total == 0){
            return true;
        }
        //Now if we have come this far that means total is NOT Zero
        //Now if n == 0, i.e we have exhausted all the number then its not possible to form the total
        //Return false
        if(n == 0){
            return false;
        }

        if(dp[n][total] != null){
            return dp[n][total];
        }
        //Now we have two possibilities if the current number is less than the current Total then
        //try including and excluding
        //If any of the recursion is able to form the target then return true.
        if(nums[n-1] <= total){
            //We either exclude the element or include the element
            /*boolean include = subsetSum(nums, n - 1, total - nums[n-1]);
            boolean exclude = subsetSum(nums, n - 1, total);
            return include || exclude;*/

            return dp[n][total] = subsetSum(nums, n - 1, total - nums[n-1], dp) ||
                                    subsetSum(nums, n - 1, total, dp);
        }
        // if last element is greater than total we ignore it
        return dp[n][total] = subsetSum(nums, n - 1, total, dp);
    }

    public static void main(String[] args) {
        SubsetSum_v2 subsetSum = new SubsetSum_v2();
        int[] nums = {1, 2, 3, 7};
        int total = 6;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n+ 1][total + 1];
        boolean ans = subsetSum.subsetSum(nums, nums.length, total, dp);
        System.out.println("Top Down");
        System.out.println("Does a subset of " + Arrays.toString(nums) + " sum up to " + total + " ?  " + ans);

        nums = new int[]{2, 4, 7};
        total = 8;
        n = nums.length;
        Boolean[][] dp2 = new Boolean[n+ 1][total + 1];
        ans = subsetSum.subsetSum(nums, nums.length, total, dp2);
        System.out.println("Does a subset of " + Arrays.toString(nums) + " sum up to " + total + " ?  " + ans);
    }
}
