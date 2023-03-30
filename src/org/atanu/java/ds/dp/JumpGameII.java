package org.atanu.java.ds.dp;

import java.util.Arrays;

//https://leetcode.com/problems/jump-game-ii/description/
//Leetcode 45

//There is a greedy solution too in O(n)
public class JumpGameII {

    // This solution is kind of Longest Increasing Subsequence

    // Define state(i) as the minimum jumps to reach i
    // state(i) = min(1 + state(j)) for each j that can jump to i.
    // The goal state is state(nums.length - 1).

    public int jump(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < n ; i++){
            //jump from each j : we can jump to j + nums[j]
            // if j + nums[j] >= i that means we ca reach i
            // In that case consider that jump i.e dp[j] + 1
            // dp[j] : Minimum jump to reach j + 1(considering the current jump)
            for(int j = 0 ; j < i; j++){
                if(j + nums[j] >= i){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        int minimumJump = jumpGameII.jump(nums);
        //Output: 2
        //Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
        System.out.println(minimumJump);

    }
}
