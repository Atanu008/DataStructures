package org.bgd.java.ds.dp.twodimension;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minPathMemo(grid, grid.length - 1, grid[0].length - 1, dp);
    }

    /**
     * Recursive solution
     */
    private int minRecursion(int[][] g, int i, int j) {
        if (i == 0 && j == 0) {
            return g[i][j];
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        if (j > 0)
            left = minRecursion(g, i, j - 1);
        if (i > 0)
            up = minRecursion(g, i - 1, j);
        return g[i][j] + Math.min(left, up);
    }

    private int minPathMemo(int[][] g, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return g[i][j];
        }
        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = minPathMemo(g, i, j - 1, dp);
        int up = minPathMemo(g, i - 1, j, dp);
        dp[i][j] = g[i][j] + Math.min(left, up);
        return dp[i][j];
    }

    /**
     * Tabulation
     */

    private int minPathTabulation(int[][] g) {
        int[][] dp = new int[g.length][g[0].length];
        dp[0][0] = g[0][0];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = g[i][j];
                } else {
                    int left = (int) Math.pow(10, 9);
                    int up = (int) Math.pow(10, 9);
                    if (j > 0)
                        left = dp[i][j - 1];
                    if (i > 0)
                        up = dp[i - 1][j];
                    dp[i][j] = g[i][j] + Math.min(left, up);
                }

            }
        }
        return dp[g.length - 1][g[0].length - 1];
    }
}
