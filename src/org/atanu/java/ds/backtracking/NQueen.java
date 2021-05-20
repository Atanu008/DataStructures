package org.atanu.java.ds.backtracking;

import java.util.Arrays;

public class NQueen {

    private static void nQueen(char[][] chess, int row){
        //if `N` queens are placed successfully, print the solution
        if(row == chess.length){
            printBoard(chess);
            return;
        }

        for(int column = 0; column < chess.length; column++){
            // if no two queens threaten each other
            if(isSafe(chess, row, column)){
                // place queen on the current square
                chess[row][column] = 'Q';
                // recur for the next row
                nQueen(chess,row +1);
                // backtrack and remove the queen from the current square
                chess[row][column] = '-';
            }

        }
    }

    private static boolean isSafe(char[][] chess, int row, int column) {
        //Only check the upper rows. from Zero to till Row -1; as the Queen is placed from Row zero

        // return false if two queens share the same column
        for (int i = 0; i < row; i++) {
            if(chess[i][column] == 'Q'){
                return false;
            }
        }
        /* Check upper diagonal on left side */
        for (int i = row, j = column; i >=0 && j >=0 ; i--, j--) {
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        /* Check upper diagonal on Right side */
        for (int i = row, j = column; i >=0 && j < chess.length; i--, j++) {
            //System.out.println(i +" "+j);
            if(chess[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    private static void printBoard(char[][] chess) {
        for(int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print("" + chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 8;
        char[][] chess = new char[N][N];
        // initialize `chess[][]` by `-`
        for (int i = 0; i < N; i++){
            Arrays.fill(chess[i], '-');
        }

        nQueen(chess,0);
    }
}
