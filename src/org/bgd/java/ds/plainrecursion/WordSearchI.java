package org.bgd.java.ds.plainrecursion;

/**
 * <a href="https://leetcode.com/problems/word-search/description/">...</a>
 *
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 *
 * The same letter cell may not be used more than once.
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 *
 */
public class WordSearchI {
    String word;
    int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {
        this.word = word;
        if (board.length == 1 && word.length() == 1 && word.charAt(0) == board[0][0]) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int index, int i, int j) {
        if (index >= word.length()) {
            return true;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        boolean res = false;

        board[i][j] = '#';
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (isValid(board, x, y)) {
                res = backtrack(board, index + 1, x, y);
                if (res) {
                    break;
                }
            }
        }
        board[i][j] = word.charAt(index);
        return res;
    }

    private boolean isValid(char[][] board, int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }
}
