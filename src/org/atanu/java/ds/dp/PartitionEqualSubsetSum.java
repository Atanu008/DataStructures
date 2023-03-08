package org.atanu.java.ds.dp;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/Y5B092Z8OnY
//Video : https://www.youtube.com/watch?v=obhWqDfzwQQ&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=9

//https://leetcode.com/problems/partition-equal-subset-sum/description/
//Leetcode 416
public class PartitionEqualSubsetSum {

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
        // if arraySum is odd, it cannot be partitioned into equal sum subset
        if(arraySum % 2 != 0) return false;
        // calculating the target subset sum
        int targetSum = arraySum / 2;
        Boolean[][] dp = new Boolean[numsLen + 1][targetSum + 1];
        return subsetSum(nums, numsLen, targetSum, dp);
    }

    public boolean subsetSum(int[] nums, int n, int total, Boolean[][] dp){
        //Base Case :
        //We are able to form the total
        //Return true
        if(total == 0){
            return true;
        }
        //Now if we have come this far that means total is NOT Zero
        //Now if n == 0, i.e we have exhausted all the number then its not possible to form the total
        //Return true
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
        int[] nums = {1,5,11,5};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean ans = partitionEqualSubsetSum.canPartition(nums);
        System.out.println("Top Down");
        System.out.println(ans);

        nums = new int[]{1,2,3,5};
        ans = partitionEqualSubsetSum.canPartition(nums);
        System.out.println(ans);
    }
}
