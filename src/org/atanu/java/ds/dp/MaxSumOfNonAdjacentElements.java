package org.atanu.java.ds.dp;

//https://www.techiedelight.com/maximum-sum-of-subsequence-with-no-adjacent-elements/
//https://medium.com/@amitrajit_bose/max-sum-of-non-adjacent-elements-a04ebc4f2602
//Coding Minute
public class MaxSumOfNonAdjacentElements {

    public int maxSumNonAdjacent(int[] nums){
        int n = nums.length;

        // base case
        if (n == 0) {
            return 0;
        }
        // base case
        if (n == 1) {
            return nums[0];
        }
        // create an auxiliary array to store solutions to subproblems
        int[] dp = new int[n];

        // dp[i] stores the maximum sum possible till index `i`

        // Base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // traverse array from index 2
        for (int i = 2; i < n; i++)
        {
            // dp[i] stores the maximum sum we get by

            // 1. Excluding the current element and take maximum sum until index `i-1`
            // 2. Including the current element nums[i] and take the maximum sum
            //    till until i-2
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

            // if the current element is more than the maximum sum until the current
            // element
            //dp[i] = Integer.max(dp[i], nums[i]); // Not sure in which case this would be used
        }

        // return maximum sum
        return dp[n - 1];
    }

    public  int maxSumNonAdjacentV2(int[] nums)
    {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // base case
        if (nums.length == 1) {
            return nums[0];
        }

        // store maximum sum until index `i-2`
        int prev_prev = 0;

        // stores maximum sum until index `i-1`
        int prev = nums[0];

        // start from index 2
        for (int i = 1; i < nums.length; i++)
        {
            // `curr` stores the maximum sum until index `i`
            //int curr = Integer.max(nums[i], Integer.max(prev, prev_prev + nums[i])); // Not sure why compare current
            int curr = Math.max(prev, prev_prev + nums[i]);
            prev_prev = prev;
            prev = curr;
        }

        // return maximum sum
        return prev;
    }
    public static void main(String[] args) {
        MaxSumOfNonAdjacentElements maxSum = new MaxSumOfNonAdjacentElements();
        int[] nums = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
        System.out.println("The maximum sum is " + maxSum.maxSumNonAdjacent(nums));
        System.out.println("The maximum sum is " + maxSum.maxSumNonAdjacentV2(nums));
    }


}
