package org.bgd.java.ds.dp.twodimension;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths-ii/">...</a>
 *
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 *
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 *
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class GridUniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return uniqueMemo(obstacleGrid, m - 1, n - 1, dp);
    }

    /**
     * Recursive solution
     * @param obs
     * @param i
     * @param j
     * @return
     */

    private int uniqueRec(int[][] obs, int i, int j) {
        if (i >= 0 && j >= 0 && obs[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        return uniqueRec(obs, i - 1, j) + uniqueRec(obs, i, j - 1);
    }

    /**
     * Memoization solution
     * @param obs
     * @param i
     * @param j
     * @param dp
     * @return
     */

    private int uniqueMemo(int[][] obs, int i, int j, int[][] dp) {
        if (i >= 0 && j >= 0 && obs[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = uniqueMemo(obs, i - 1, j, dp) + uniqueMemo(obs, i, j - 1, dp);
        return dp[i][j];
    }

    /**
     * Tabulation
     * @param obs
     * @return
     */
    private int uniqueTabulation(int[][] obs) {
        int m = obs.length;
        int n = obs[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obs[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0;
                    int left = 0;

                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
