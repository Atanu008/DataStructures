package org.bgd.java.ds.dp.onedimension;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

 Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

 0 <= j <= nums[i] and
 i + j < n
 Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



 Example 1:

 Input: nums = [2,3,1,1,4]
 Output: 2
 Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: nums = [2,3,0,1,4]
 Output: 2

 */
public class MinimumJumps {

    public int jump(int[] nums) {
        long[] dp = new long[nums.length];
        Arrays.fill(dp, -1);

        return (int) jumps(nums, dp, 0);
    }

    private long jumps(int[] nums, long[] dp, int i) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        long min = Integer.MAX_VALUE;

        for (int j = i + 1; j <= i + nums[i]; j++) {
            min = Math.min(min, 1 + jumps(nums, dp, j));
        }
        dp[i] = min;
        return dp[i];
    }

    private long jumpsTab(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            long min = Integer.MAX_VALUE;

            for (int j = i + 1; j <= i + nums[i]; j++) {
                min = Math.min(min, 1 + dp[j]);
            }
            dp[i] = (int) min;
        }
        return dp[nums.length - 1];
    }
}
