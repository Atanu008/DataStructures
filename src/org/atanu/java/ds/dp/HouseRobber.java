package org.atanu.java.ds.dp;

//https://leetcode.com/problems/house-robber/
//LeetCode 198
//Same problem as Max Sum Of Non-Adjacent Elements
//https://www.techiedelight.com/maximum-sum-of-subsequence-with-no-adjacent-elements/
public class HouseRobber {
    public int rob(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        if(nums.length==1){
            return nums[0];
        }
        //Initialize an arrays to store the money
        int n = nums.length;
        int[] dp = new int[n];

        //We can infer the formula from problem:mark[i]=max(num[i]+mark[i-2],mark[i-1])
        //so initialize two nums at first.
        //For first element we have only one choice
        //For secod element we have two choice. Either choose first or choose current.
        //Choose Maximum between first and current;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //dp[i]=max(num[i]+dp[i-2],dp[i-1])
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }


    public int robV2(int[] nums) {

        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // base case
        if (nums.length == 1) {
            return nums[0];
        }

        // store maximum sum until index `i-2`
        int prev_prev = nums[0];

        // stores maximum sum until index `i-1`
        int prev = Math.max(nums[0], nums[1]);

        // start from index 2
        for (int i = 2; i < nums.length; i++)
        {
            // `curr` stores the maximum sum until index `i`
            int curr = Integer.max(prev, prev_prev + nums[i]);
            prev_prev = prev;
            prev = curr;
        }

        // return maximum sum
        return prev;
    }
}
