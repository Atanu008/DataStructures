package org.atanu.java.ds.design;

public class TicTacToe {
    int[][] matrix;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        matrix = new int[n][n];
    }

    public int move(int row, int col, int player) {
        //Assuming inputs are correct
        matrix[row][col] = player; // Making the move here
        int n = matrix.length;
        boolean RowWin = true, ColumnWin = true, DiagonalWin = true, ReverseDiagonal = true;
        for(int i = 0; i < n; i++){
            if(matrix[row][i] != player){
                RowWin = false;
            }
            if(matrix[i][col] != player){
                ColumnWin = false;
            }
            if(matrix[i][i] != player){
                DiagonalWin = false;
            }
            if(matrix[i][n-i-1] != player){ // Reverse Diagonal -> Length - column -1
                ReverseDiagonal = false;
            }
        }
        if(RowWin || ColumnWin || DiagonalWin || ReverseDiagonal) {
            System.out.println("Winneer is "+ player );
            return player;
        }
        return -1;//Invalid Return
    }

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);
        toe.move(0, 0, 1); //-> Returns 0 (no one wins)
        toe.move(0, 2, 2); //-> Returns 0 (no one wins)
        toe.move(2, 2, 1); //-> Returns 0 (no one wins)
        toe.move(1, 1, 2); //-> Returns 0 (no one wins)
        toe.move(2, 0, 1); //-> Returns 0 (no one wins)
        toe.move(1, 0, 2); //-> Returns 0 (no one wins)
        toe.move(2, 1, 1); //-> Returns 1 (player 1 wins)

    }
}
