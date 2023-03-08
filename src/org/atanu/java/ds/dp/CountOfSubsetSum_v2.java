package org.atanu.java.ds.dp;

//Its a variation of 0/1 Knapsack and Sub set sum

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/gk4mjNrXVnk
//Video : https://www.youtube.com/watch?v=MqYLmIzl8sQ&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=10

public class CountOfSubsetSum_v2 {

    //We will plot nums in rows and total in column
    //So in recursion when total became zero then we returned 1
    //So the first column will represent zero(0) total , So the first column will be 1
    //All the other cell will be 0
    public int countSubsetSum(int[] nums, int sum){

        int n = nums.length;
        int[][] dp = new int[n+ 1][sum + 1];

        //If sum is 0, then answer is 1
        // we can get 1 way by not including any of teh character
        for(int i = 0; i <= n; i++){
           dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= sum; j++){
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

    public static void main(String[] args) {

        System.out.println("Bottom Up");
        CountOfSubsetSum_v2 countOfSubsetSum = new CountOfSubsetSum_v2();
        int[] nums = {3, 34, 4, 12, 5, 2};
        int targetsum = 9;
        int numberOfSubset = countOfSubsetSum.countSubsetSum(nums, targetsum);

        System.out.println(numberOfSubset);

        nums = new int[]{1, 2, 7, 4, 5};
        targetsum = 9;
        numberOfSubset = countOfSubsetSum.countSubsetSum(nums, targetsum);
        System.out.println(numberOfSubset);

        nums = new int[]{1};
        targetsum = 10;
        numberOfSubset = countOfSubsetSum.countSubsetSum(nums, targetsum);
        System.out.println(numberOfSubset);
    }
}
