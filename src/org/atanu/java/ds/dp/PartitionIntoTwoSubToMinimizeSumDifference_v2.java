package org.atanu.java.ds.dp;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/B1w5xqOrm6J
//https://www.techiedelight.com/minimum-sum-partition-problem/

//Video : https://www.youtube.com/watch?v=FB0KUhsxXGY&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=11
public class PartitionIntoTwoSubToMinimizeSumDifference_v2 {
    //Difference = abs(S2 - S1)
    // => abs((sum - S1) - S1)
    // => abs(sum - 2S1) : we would want to minimize it
    //Note if S1 == s2 then the minimum difference would be zero
    //Now the goal is to find
    //All possible values of subset sum and then minimize difference between 2 subset S1 and S2
    //Actually we just need to find till Sum/2 . and then can get the remaining .

    public int findMinAbsDiff(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;++i)
            sum+=nums[i];

        //Subset Sum Problem

        boolean[][] dp = new boolean[n+1][sum/2 + 1];
        // If sum is 0, then answer is tru
        for(int i  = 0; i <= n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum/2; j++){

                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int diff = Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;++i)
        {
            int first = i;
            int second = sum-i;
            if(dp[n][i]==true && diff>Math.abs(first-second))
                diff = Math.abs(first-second);
        }

        return diff;
    }

    public static void main(String[] args) {
        PartitionIntoTwoSubToMinimizeSumDifference_v2 partition = new PartitionIntoTwoSubToMinimizeSumDifference_v2();
        // Input: a set of items
        int[] nums = { 10, 20, 15, 5, 25 };
        int minDifference = partition.findMinAbsDiff(nums);
        System.out.println("Bottom Up");
        System.out.println("The minimum difference is " + minDifference);
    }
}
