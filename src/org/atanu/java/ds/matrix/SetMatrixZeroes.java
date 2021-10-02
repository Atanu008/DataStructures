package org.atanu.java.ds.matrix;

import java.util.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/
//LeetCode 73
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;

        int[] rowZeros = new int[row];
        int[] columnZeros = new int[column];

        //Set can be used in place of Array
        //Set<Integer> rows = new HashSet<Integer>();
        //Set<Integer> cols = new HashSet<Integer>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    //Mark Row and Column
                    rowZeros[i] = -1;
                    columnZeros[j] = -1;
                    //Add in set
                    //rows.add(i);
                    //cols.add(j);
                }
            }
        }
        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (rowZeros[i] == -1 || columnZeros[j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //The idea is that we can use the first cell of every row and column as a flag. This flag would determine whether a row or column has been set to zero. This means for every cell instead of going to M+NM+N cells and setting it to zero we just set the flag in two cells.
    public void setZeroesV2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        boolean isColumnZero = false;

        for (int i = 0; i < row; i++) {
            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isColumnZero = true;
            }
            for (int j = 1; j < column; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;//First Column for to check for rows
                    matrix[0][j] = 0;//First row to check for columns
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < column; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isColumnZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new SetMatrixZeroes().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        new SetMatrixZeroes().setZeroesV2(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }
}
