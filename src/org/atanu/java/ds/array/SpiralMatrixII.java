package org.atanu.java.ds.array;

import java.util.ArrayList;
import java.util.List;

//LeetCode 59
//https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {

        List<Integer> numbers = new ArrayList<Integer>();
        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        for (int i = 1; i <= n * n; i++) {
            numbers.add(i);
        }

        // numbers.forEach(System.out::print);

        int dir = 0;
        int index = 0;
        while (top <= bottom && left <= right) {

            //
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = numbers.get(index++);

                }
                top++;
            }

            if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = numbers.get(index++);
                }
                right--;
            }

            if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = numbers.get(index++);
                }
                bottom--;
            }

            if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = numbers.get(index++);
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }

        return matrix;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }

    public static void main(String[] args) {
        SpiralMatrixII spm = new SpiralMatrixII();
        int n = 3;
        int[][] resultmatrix = spm.generateMatrix(n);
        spm.printMatrix(resultmatrix);
    }
}
