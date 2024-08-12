package org.bgd.java.ds.arrays;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix-ii/description/">...</a>
 * <p>
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 */
public class InsertIntoSpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];

        int value = 1;

        int start_col = 0, start_row = 0, end_row = n - 1, end_col = n - 1;

        while (start_col <= end_col && start_row <= end_row) {

            for (int i = start_col; i <= end_col; i++) {
                mat[start_row][i] = value++;
            }

            for (int i = start_row + 1; i <= end_row; i++) {
                mat[i][end_col] = value++;
            }

            for (int i = end_col - 1; i >= start_col; i--) {
                mat[end_row][i] = value++;
            }

            for (int i = end_row - 1; i > start_row; i--) {
                mat[i][start_col] = value++;
            }

            start_row++;
            start_col++;
            end_row--;
            end_col--;
        }
        return mat;
    }
}
