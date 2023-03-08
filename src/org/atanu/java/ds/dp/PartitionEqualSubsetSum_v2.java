package org.atanu.java.ds.dp;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/Y5B092Z8OnY
//Video : https://www.youtube.com/watch?v=obhWqDfzwQQ&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=9

//https://leetcode.com/problems/partition-equal-subset-sum/description/
//Leetcode 416

public class PartitionEqualSubsetSum_v2 {

    //First, we calculate the sum of the array. If the sum of the array is odd, there can’t be two subarrays with an equal sum. Therefore, we return FALSE.
    //
    //If the sum is even, we calculate TargetSum = Array Sum / 2
    //Now we need to find if TargetSum can be by the numbers of the array.
    //Bsically this the exact same problem now subset sum
    //Subset Sum Problem below :
    //Given a set of positive numbers arr and a value total,
    //determine if there exists a subset in the given set whose sum is equal to total.
    public boolean canPartition(int[] nums) {
        int numsLen = nums.length;
        int arraySum = 0;
        // calculate the sum of array
        for(int i : nums) arraySum += i;
        // if arraySum is odd, it cannot be partitioned into equal sum subarrays
        if(arraySum % 2 != 0) return false;
        // calculating the target subarray sum
        int targetSum = arraySum / 2;
        return subsetSum(nums, targetSum);
    }

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
        int[] nums = {1,5,11,5};
        PartitionEqualSubsetSum_v2 partitionEqualSubsetSum = new PartitionEqualSubsetSum_v2();
        boolean ans = partitionEqualSubsetSum.canPartition(nums);
        System.out.println("Bottom UP");
        System.out.println(ans);

        nums = new int[]{1,2,3,5};
        ans = partitionEqualSubsetSum.canPartition(nums);
        System.out.println(ans);
    }
}
