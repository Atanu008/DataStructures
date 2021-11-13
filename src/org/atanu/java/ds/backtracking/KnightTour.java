package org.atanu.java.ds.backtracking;

//https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
//https://www.techiedelight.com/print-possible-knights-tours-chessboard/
public class KnightTour {
    final static int N = 8;
    //int[][] dirs = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}}; ?? Not sure why taking Time
    int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    public boolean move(int[][] chess, int row, int column, int move){
        // System.out.println("KK");
        chess[row][column] = move; //Mark visited
        if(move == N*N){
            chess[row][column] = move;
            printChess(chess);
            return true;
        }

        for(int i = 0; i < 8 ; i++){
            int nextRow = row + xMove[i];
            int nextColumn = column + yMove[i];
            if(isValid(chess, nextRow, nextColumn)){
                if(move(chess, nextRow, nextColumn, move+1))
                    return true;
            }
        }
        chess[row][column] = 0; //Un Mark it
        return false;
    }

    private boolean isValid(int[][] chess, int row, int column) {
        if(row < 0 ||row >=N || column < 0 || column >= N || chess[row][column] != 0){
            return false;
        }
        return true;
    }

    private void printChess(int[][] chess) {
        for(int[] row : chess){
            for(int a: row) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
        System.out.println("++++++++");
    }

    public static void main(String[] args) {
        KnightTour knightTour = new KnightTour();
        int[][] chess = new int[N][N];
        knightTour.move(chess, 0,0, 1);
        //knightTour.printChess(chess);
    }
}
