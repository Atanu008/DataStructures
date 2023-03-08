package org.atanu.java.ds.dp;

//Its a variation of 0/1 Knapsack and Sub set sum

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/gk4mjNrXVnk
//Video : https://www.youtube.com/watch?v=MqYLmIzl8sQ&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=10
public class CountOfSubsetSum {

    public int countSubsetSum(int[] nums, int sum, int n, Integer dp[][]){
        // base cases
        //we are able to form the subsequence with given sum in previous recurssion
        //return 1 as we have found a way
        if(sum == 0){
            return 1;
        }
        //Now if we have come this far that means total is NOT Zero
        //Now if n == 0, i.e we have exhausted all the number then its not possible to form the total
        //Return false
        if(n == 0){
            return 0;
        }
        //Return from cache if exist
        if(dp[n][sum] != null){
            return dp[n][sum];
        }
        //If the current element is less than the current sum try excluding and including it
        //As we need to find total number of ways
        //We need to have add both options
        if(nums[n-1] <= sum){
            return dp[n][sum] = countSubsetSum(nums, sum - nums[n - 1], n- 1, dp) +
                    countSubsetSum(nums, sum, n- 1, dp);
        }
        //Not possible to include the item
        //Try next item
        else{
            return dp[n][sum] = countSubsetSum(nums, sum, n- 1, dp);
        }
    }

    public static void main(String[] args) {
        CountOfSubsetSum countOfSubsetSum = new CountOfSubsetSum();
        int[] nums = {3, 34, 4, 12, 5, 2};
        int targetsum = 9;
        int n = nums.length;
        Integer[][] dp = new Integer[n + 1][targetsum + 1];
        int numberOfSubset = countOfSubsetSum.countSubsetSum(nums, targetsum, n, dp);
        System.out.println(numberOfSubset);

        nums = new int[]{1, 2, 7, 4, 5};
        targetsum = 9;
        n = nums.length;
        Integer[][] dp1 = new Integer[n + 1][targetsum + 1];
        numberOfSubset = countOfSubsetSum.countSubsetSum(nums, targetsum, n, dp1);
        System.out.println(numberOfSubset);

        nums = new int[]{1};
        targetsum = 10;
        n = nums.length;
        Integer[][] dp2 = new Integer[n + 1][targetsum + 1];
        numberOfSubset = countOfSubsetSum.countSubsetSum(nums, targetsum, n, dp2);
        System.out.println(numberOfSubset);
    }
}
