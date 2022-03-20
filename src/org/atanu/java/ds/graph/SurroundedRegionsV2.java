package org.atanu.java.ds.graph;

//https://leetcode.com/problems/surrounded-regions/
//LeetCode 130
//https://www.youtube.com/watch?v=EiK4i9yyd7A&t=1046s

public class SurroundedRegionsV2 {

    //Mark the cells which are attached to border and mark them with "B", as they wont be part of the Surrounded Region
    //After we marking the cells attached to border , we would be left with Surrounded Region
    // Flip the "B" back to "O" . For Surrounded Region "0" To "X"
    public void solve(char[][] board) {

        int row = board.length;
        int column = board[0].length;

        for(int i = 0; i < row; i++){
            markBorder(board, i, 0); //Left Border
            markBorder(board, i, column -1); // Right Border
        }

        for(int i = 0; i < column; i++){
            markBorder(board, 0, i); // Top Border
            markBorder(board, row - 1, i); // Bottom Border
        }
        //Fill Surrounded Regions
        fillRegeion(board);

    }


    public void markBorder(char[][] board, int row, int column) {

        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != 'O'){
            return;
        }

        board[row][column] = 'B';

        markBorder(board, row + 1, column);
        markBorder(board, row - 1, column);
        markBorder(board, row, column + 1);
        markBorder(board, row, column - 1);
    }

    public void fillRegeion(char[][] board){

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'B'){
                    board[i][j] = 'O';
                }
            }
        }
    }

}
