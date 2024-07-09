package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/n-queens/editorial/">...</a>
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */
public class NQueens {
    List<List<String>> answer;
    int size;

    public List<List<String>> solveNQueens(int n) {
        size = n;
        answer = new ArrayList<>();
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), initialBoard());
        return answer;
    }

    private void backtrack(int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antidiagonals, char[][] board) {
        if (row == size) {
            answer.add(createBoard(board));
            return;
        }

        for (int col = 0; col < size; col++) {
            int diag = row - col;
            int antidiag = row + col;

            if (cols.contains(col) || diagonals.contains(diag) || antidiagonals.contains(antidiag)) {
                continue;
            }

            // place
            cols.add(col);
            diagonals.add(diag);
            antidiagonals.add(antidiag);
            board[row][col] = 'Q';
            backtrack(row + 1, cols, diagonals, antidiagonals, board);

            // remove
            cols.remove(col);
            diagonals.remove(diag);
            antidiagonals.remove(antidiag);
            board[row][col] = '.';
        }
    }

    private List<String> createBoard(char[][] board) {
        List<String> r = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            String entireRow = new String(board[row]);
            r.add(entireRow);
        }
        return r;
    }

    private char[][] initialBoard() {
        char[][] b = new char[size][size];
        for (char[] row : b) {
            Arrays.fill(row, ',');
        }
        return b;
    }

}
