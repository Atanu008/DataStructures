package org.atanu.java.ds.dp;

//https://leetcode.com/problems/min-cost-climbing-stairs/
//LeetCode 746
public class MinCostClimbingStairs {

    // N = cost.length
    //To reach to the solution either you need to reach last step i.e N-1(last index of Array/stairs)
    // OR second last one step N-2
    // AND you need to calculate the MINIMUM of those steps
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        return Math.min(minCostClimbingStairs(cost, n-1, dp), minCostClimbingStairs(cost, n-2, dp));

    }

    private int minCostClimbingStairs(int[] cost, int n, int[] dp){
        if(n < 0){
            return 0;
        }
        if(n <= 1 ){
            return cost[n];
        }
        if (dp[n] != 0){
            return dp[n];
        }

        dp[n] = cost[n] + Math.min(minCostClimbingStairs(cost, n-1, dp), minCostClimbingStairs(cost, n-2, dp));
        return dp[n];
    }

    // N = cost.length
    //To reach to the solution either you need to reach last step i.e N-1(last index of Array/stairs)
    // OR second last one step N-2
    // AND you need to calculate the MINIMUM of those steps

    //Bottom UP DP
    public int minCostClimbingStairsV2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        for(int i = 0; i<n; i++){
            if(i < 2){
                dp[i] = cost[i];
            }
            else{
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
            }
        }
        return Math.min(dp[n-1], dp[n-2]);

    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] cost = {10,15,20};
        System.out.println("Min Cost Climbing Stairs "+ minCostClimbingStairs.minCostClimbingStairs(cost));
        System.out.println("Min Cost Climbing Stairs "+ minCostClimbingStairs.minCostClimbingStairsV2(cost));
    }
}
