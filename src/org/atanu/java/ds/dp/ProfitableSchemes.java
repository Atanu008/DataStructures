package org.atanu.java.ds.dp;

// Classic Knapsack DP
// having two constraint :

// https://leetcode.com/problems/profitable-schemes/description/
// Leetcode 879
// Video : https://www.youtube.com/watch?v=ay3MHrS7YbQ (can check)
public class ProfitableSchemes {

    int mod = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        Integer[][][] dp = new Integer[group.length + 1][n + 1][minProfit + 1];
        return dp(0, 0, 0, n, minProfit, group, profit, dp);
    }

    private int dp(int i, int people, int p, int n, int minProfit, int[] group, int[] profit, Integer[][][] dp) {

        // the total number of members/people participating in that subset of crimes
        // is greater than n, not possible to make profit
        if(people > n){
            return 0;
        }
        // checked all possibilities
        if(i == group.length){
            // If profit is greater than minProfit , its possible to make profit with current subset
            // Return 1 in that case
            return p >= minProfit ? 1 : 0;
        }

        //System.out.println(i + " "+ people +" "+p);
        if(dp[i][people][p] != null){
            return dp[i][people][p];
        }
        int notTaken = dp(i+1, people, p, n, minProfit, group, profit, dp);

        // Math.min(minProfit, p+profit[i]) is tricky:
        // If we dont put a cop memoization would take a lot of space
        // once the profit is equal to minProfit we don't need to increase it further as it would result profitable scheme
        // suppose p+profit[i] > minProfit , its a profitable scheme right, so dont increase the recursion with p+profit[i]
        // take minProfit instead of p+profit[i]

        int taken = dp(i+1, people+group[i], Math.min(minProfit, p+profit[i]), n, minProfit, group, profit, dp);

        return dp[i][people][p] = (notTaken + taken) % mod;
    }
}
