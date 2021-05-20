package org.atanu.java.ds.backtracking;

import java.util.Arrays;
import java.util.List;

//LeetCode 52
//https://leetcode.com/problems/n-queens-ii/
public class NQueensII {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        //Fill Chess Array
        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i], '.');
        }

        dfs(chess, 0);
        return count;
    }

    private void dfs(char[][] chess, int row) {
        if (row == chess.length) {
            count++;
            return;
        }

        for (int column = 0; column < chess.length; column++) {
            // if no two queens threaten each other
            if (isSafe(chess, row, column)) {
                // place queen on the current square
                chess[row][column] = 'Q';
                // recur for the next row
                dfs(chess, row + 1);
                // backtrack and remove the queen from the current square
                chess[row][column] = '.';
            }

        }

    }

    private boolean isSafe(char[][] chess, int row, int column) {
        // return false if two queens share the same column
        for (int i = 0; i < row; i++) {
            if (chess[i][column] == 'Q') {
                return false;
            }
        }
        /* Check upper diagonal on left side */
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        /* Check upper diagonal on Right side */
        for (int i = row, j = column; i >= 0 && j < chess.length; i--, j++) {
            //System.out.println(i +" "+j);
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NQueensII nQueens = new NQueensII();
        int N = 8;
        int result = nQueens.totalNQueens(N);
        System.out.println("Total N Queen Solution Is "+ result);
    }
}
