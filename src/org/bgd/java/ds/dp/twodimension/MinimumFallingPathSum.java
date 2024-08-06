package org.bgd.java.ds.dp.twodimension;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-falling-path-sum/">...</a>
 * 931. Minimum Falling Path Sum
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 *
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int min = ((int) Math.pow(10, 9));

        for (int j = 0; j < matrix[0].length; j++) {
            int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            min = Math.min(min, minFallingMemo(matrix, matrix.length - 1, j, dp));
        }
        return min;
    }

    /**
     * Recursive
     * @param m
     * @param i
     * @param j
     * @return
     */
    private int minFallingRec(int[][] m, int i, int j) {
        if (j < 0 || j >= m[0].length) {
            return ((int) Math.pow(10, 9));
        }

        if (i == 0) {
            return m[i][j];
        }
        int up = minFallingRec(m, i - 1, j);
        int ld = minFallingRec(m, i - 1, j - 1);
        int rd = minFallingRec(m, i - 1, j + 1);
        return m[i][j] + Math.min(Math.min(ld, rd), up);
    }

    /**
     * Memoized
     * @param m
     * @param i
     * @param j
     * @param dp
     * @return
     */
    private int minFallingMemo(int[][] m, int i, int j, int[][] dp) {
        if (j < 0 || j >= m[0].length) {
            return ((int) Math.pow(10, 9));
        }

        if (i == 0) {
            return m[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = minFallingMemo(m, i - 1, j, dp);
        int ld = minFallingMemo(m, i - 1, j - 1, dp);
        int rd = minFallingMemo(m, i - 1, j + 1, dp);
        dp[i][j] = m[i][j] + Math.min(Math.min(ld, rd), up);
        return dp[i][j];
    }

    private int minFallingTabulation(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];

        System.arraycopy(mat[0], 0, dp[0], 0, n);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = mat[i][j] + dp[i - 1][j];
                int ld = mat[i][j];
                if (j >= 1) {
                    ld += dp[i - 1][j - 1];
                } else {
                    ld += (int) Math.pow(10, 9);
                }
                int rd = mat[i][j];
                if (j < n - 1) {
                    rd += dp[i - 1][j + 1];
                } else {
                    rd += (int) Math.pow(10, 9);
                }
                dp[i][j] = Math.min(Math.min(ld, rd), up);
            }
        }
        int min = (int) Math.pow(10, 9);
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m - 1][j]);
        }
        return min;
    }
}
