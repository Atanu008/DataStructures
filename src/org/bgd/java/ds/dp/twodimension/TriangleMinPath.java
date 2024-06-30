package org.bgd.java.ds.dp.twodimension;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/triangle/">...</a>
 *
 * 120. Triangle
 * Medium
 *
 * Topics
 *
 * Companies
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 *
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 */
public class TriangleMinPath {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.getLast()
          .size() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minTotalMemo(triangle, 0, 0, dp);
    }

    /**
     * Recursive solution
     * @param triangle
     * @param i
     * @param j
     * @return
     */

    private int minTotalRecursion(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size() - 1) {
            return triangle.get(i)
              .get(j);
        }

        int down = minTotalRecursion(triangle, i + 1, j);
        int diag = minTotalRecursion(triangle, i + 1, j + 1);
        return triangle.get(i)
          .get(j) + Math.min(down, diag);
    }

    /**
     * Memoization solution
     */

    private int minTotalMemo(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if (i == triangle.size() - 1) {
            return triangle.get(i)
              .get(j);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = minTotalMemo(triangle, i + 1, j, dp);
        int diag = minTotalMemo(triangle, i + 1, j + 1, dp);
        dp[i][j] = triangle.get(i)
          .get(j) + Math.min(down, diag);
        return dp[i][j];
    }

    /**
     * Tabulation solution
     */

    private int minTotaltabulation(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];

        // fill the last row
        for (int i = 0; i < triangle.getLast()
          .size(); i++) {
            dp[triangle.getLast()
              .size() - 1][i] = triangle.get(triangle.getLast()
                .size() - 1)
              .get(i);
        }

        for (int i = triangle.getLast()
          .size() - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = dp[i + 1][j];
                int diag = dp[i + 1][j + 1];
                dp[i][j] = triangle.get(i)
                  .get(j) + Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}
