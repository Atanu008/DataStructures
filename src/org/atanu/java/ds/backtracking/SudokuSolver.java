package org.atanu.java.ds.backtracking;

//LeetCode 37
//https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j< board[0].length; j++) {
                char number = board[i][j];
                if(number == '.') {
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false; // Return false if you are not able to place any valid number(1-9)
                }
            }
        }
        return true; // If you exhausted the search space. All cells are occupied by 1-9
    }

    private boolean isValid(char[][] board, int row, int column, char c){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == c)
                return false;
            if(board[i][column] == c)
                return false;
            //for the 3*3 box. i/3 will help to increment the row . i%3 will help to increment the column
            if(board[3*(row/3) + (i/3)][3*(column/3) + i%3] == c)
                return false;
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print("" + aChar + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);
        printBoard(board);

    }

}
