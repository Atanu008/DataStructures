package org.atanu.java.ds.dp;

//https://leetcode.com/problems/arithmetic-slices/
//LeetCode 413
// Video : https://www.youtube.com/watch?v=rSi4MpGEz1M
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        // for 1234
        // in 3 we got first slice
        // then At 4 we got another 234 , Now total 2 , At 3 One , At 4 one
        // But including 4 we got a bigger one 1234
        // so dp[i] = dp[i-1] + 1;
        for(int i = 2; i< n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i] = dp[i-1] + 1;
                ans += dp[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArithmeticSlices arithmeticSlices = new ArithmeticSlices();
        int[] nums = {1,2,3,4};
        //Output: 3
        //Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
        System.out.println("We have "+arithmeticSlices.numberOfArithmeticSlices(nums) +" arithmetic slices in nums");
    }
}
