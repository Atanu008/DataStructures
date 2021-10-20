package org.atanu.java.ds.dp;

//https://leetcode.com/problems/house-robber-ii/
//LeetCode 213
public class HouseRobberII {
    //the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n],
    //depending on which choice offers more money. Now the problem has degenerated to the House Robber
    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(rob(nums, 0, n-1), rob(nums, 1, n));

        //return Math.max(robV2(nums, 0, n-1), robV2(nums, 1, n));
    }

    public int rob(int[] nums, int start, int end){

        int dp[] = new int[end-start];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for(int i = start+2; i < end; i++){
            dp[i-start] = Math.max(nums[i] + dp[i-start-2], dp[i-start -1]);
        }
        return dp[dp.length-1];
    }

    public int robV2(int[] nums, int start, int end){

        int prev_prev = nums[start];
        int prev = Math.max(nums[start], nums[start+1]);

        for(int i = start+2; i < end; i++){
            int current = Math.max(nums[i]+prev_prev, prev);
            prev_prev = prev;
            prev = current;
        }
        return prev;
    }

    public static void main(String[] args) {
        HouseRobberII robberII = new HouseRobberII();
        int[] nums = {1,2,3,1};

        System.out.println("Total amount you can rob is "+robberII.rob(nums));
    }
}
