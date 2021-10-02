package org.atanu.java.ds.matrix;

import java.util.Arrays;

//https://leetcode.com/problems/game-of-life/
//LeetCode 289
public class GameOfLife {

    private static final int ALIVE = 1;
    private static final int DEAD = 0;
    private static final int ALIVETODEAD = 2;
    private static final int DEADTOALIVE = 3;

    public void gameOfLife(int[][] board) {

        int row = board.length;
        int column = board[0].length;
        int[][] dummyBoard = new int[row][column];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

        //Initialize dummy board to maintain the initial state as we would modify the board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dummyBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // keep track of the number of alive neighbors
                int liveCount = 0;
                // for each cell, check all possible 8 directions and count the number of alive neighbors
                for (int[] dir : dirs) {
                    liveCount += isLive(dummyBoard, i + dir[0], j + dir[1]);
                }

                // For live cell. will die eithr under or over population
                if (dummyBoard[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = 0;
                }
                // For dead cell. will become alive with live neighbour
                if (dummyBoard[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int isLive(int[][] dummyBoard, int row, int column) {
        if (row >= 0 && row < dummyBoard.length && column >= 0 && column < dummyBoard[0].length && dummyBoard[row][column] == 1)
            return 1;
        return 0;
    }

    // in-place solution
    public void gameOfLifeV2(int[][] board) {

        int row = board.length;
        int column = board[0].length;
        final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // keep track of the number of alive neighbors
                int liveCount = 0;
                // for each cell, check all possible 8 directions and count the number of alive neighbors
                for (int[] dir : dirs) {
                    liveCount += isLiveV2(board, i + dir[0], j + dir[1]);
                }

                // For live cell. will die eithr under or over population
                if (board[i][j] == ALIVE && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = ALIVETODEAD;
                }
                // For dead cell. will become alive with live neighbour
                if (board[i][j] == DEAD && liveCount == 3) {
                    board[i][j] = DEADTOALIVE;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == DEADTOALIVE) {
                    board[i][j] = ALIVE;
                } else if (board[i][j] == ALIVETODEAD) {
                    board[i][j] = DEAD;
                }
            }
        }
    }

    private int isLiveV2(int[][] board, int row, int column) {
        if (row >= 0 && row < board.length && column >= 0 && column < board[0].length
                && (board[row][column] == ALIVE || board[row][column] == ALIVETODEAD))
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new GameOfLife().gameOfLifeV2(board);
        System.out.println(Arrays.deepToString(board));
    }
}
