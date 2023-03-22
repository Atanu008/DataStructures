package org.atanu.java.ds.dp;

//https://leetcode.com/problems/climbing-stairs/
//LeetCode 70
public class ClimbingStairs {

    public int climbStairs(int n) {

        int[] dp = new int[n+1];

        return climbStairs(n, dp);
    }

    private int climbStairs(int n, int[] dp){
        // you can not make negative step. way is abolute zero
        if(n < 0){
            return 0;
        }
        //Zero steps can be done on only one way
        if(n==0){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }

        // Nth step can be reached from n-1 step by taking 2 step
        // Nth step can be reached from n-2 step by taking 1 step
        dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp);
        return dp[n];
    }

    public int climbStairsV2(int n) {

        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n+1];

        dp[0] = 1; //From ground only one possobility
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int n = 4;

        System.out.println(n+"th Stair can be reached in "+ climbingStairs.climbStairs(n)+ " way");
        System.out.println(n+"th Stair can be reached in "+ climbingStairs.climbStairsV2(n)+ " way");
    }
}
