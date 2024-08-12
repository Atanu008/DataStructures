package org.bgd.java.ds.arrays;

/**
 * <a href="https://leetcode.com/problems/set-matrix-zeroes/">...</a>
 *
 *
 */
public class MarkRowColZero {

    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int isCol = 1;

        for (int i = 0; i < R; i++) {
            if (matrix[i][0] == 0) {
                isCol = 0;
            }
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isCol == 0) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
