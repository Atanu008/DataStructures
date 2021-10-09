package org.atanu.java.ds.dp;

public class ClimbingStairsKWay {

    // Recursion
    public int climbStairs(int n, int k){
        // base case: 1 way (with no steps)
        if(n == 0){
            return 1;
        }

        //Invalid step. can not be Negative
        if(n < 0){
            return 0;
        }
        int totalWays = 0;
        for(int i = 1; i <= k; i++){
            totalWays += climbStairs(n-i, k);
        }

        return totalWays;
    }

    // Memoization To-Do
    public int climbStairs(int n, int k, int[] dp){
        // base case: 1 way (with no steps)
        if(n == 0){
            return 1;
        }

        //Invalid step. can not be Negative
        if(n < 0){
            return 0;
        }

        if(dp[n] != 0){
            return dp[n];
        }
        int totalWays = 0;
        for(int i = 1; i <= k; i++){
            totalWays += climbStairs(n-i, k);
        }
        dp[n] = totalWays;
        return dp[n];
    }

    public int climbStairsV3(int n, int k){
        // base case: 1 way (with no steps)
        if(n == 0){
            return 1;
        }

        //Invalid step. can not be Negative
        if(n < 0){
            return 0;
        }
        int totalWays = 0;
        for(int i = 1; i <= k; i++){
           // totalWays += climbStairs(n-i, k);
        }

        return totalWays;
    }

    // Bottom UP To-Do
    public static void main(String[] args) {
        int n = 4, k = 3;
        ClimbingStairsKWay climbingStairsKWay = new ClimbingStairsKWay();
        int[] dp = new int[n+1];
        System.out.printf("Total ways to reach the %d'th stair with at most " +
                "%d steps are %d", n, k, climbingStairsKWay.climbStairs(n, k));

        System.out.printf("\nTotal ways to reach the %d'th stair with at most " +
                "%d steps are %d", n, k, climbingStairsKWay.climbStairs(n, k, dp));
    }
}
