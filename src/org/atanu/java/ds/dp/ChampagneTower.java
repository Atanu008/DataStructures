package org.atanu.java.ds.dp;

//https://leetcode.com/problems/champagne-tower/
//LeetCode 799
public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] dp = new double[query_row + 1][query_glass + 2];
        dp[0][0] = poured;

        for(int i = 0; i < query_row; i ++){
            for(int j = 0; j <= query_glass; j++){
                //It can be negative , so take zero in case of negative
                // Suppose a glass have 0.25 sp 0.25 - 1.0 is negarive
                double remaining = Math.max(dp[i][j] - 1.0, 0);
                dp[i+1][j] += remaining / 2.0;
                dp[i+1][j+1] += remaining / 2.0;
            }
        }

        //Result can not grater than 1.
        //we are not updateing the poured . so lets take min of 10 and result
        return Math.min(dp[query_row][query_glass], 1.0);
    }
}
