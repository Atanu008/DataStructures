package org.atanu.java.ds.graph;

//https://leetcode.com/problems/surrounded-regions/
//LeetCode 130
//This implementation double DFS. checking twice
public class SurroundedRegions {

    public void solve(char[][] board) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int row = 1; row < board.length -1; row++){
            for(int column = 1; column < board[0].length -1; column++){
                if(board[row][column] == 'O' && !visited[row][column]){
                    //Check if that cell is part of Surrounded Regions
                    //If NOT then
                    if(!isNOTSurrounded(board, row, column, visited)){
                        //FILL Surrounded Regions
                        fill(board, row, column);
                    }
                }
            }
        }

    }

    public boolean isNOTSurrounded(char[][] board, int row, int column, boolean[][] visited){

        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length){
            return false;
        }

        if(visited[row][column] || board[row][column] == 'X'){
            return false;
        }

        //If ANY OF THE PERIMETER ITEM IS ZERO THEN ITS NOT SURROUNDED
        //RETURN TRUE
        if(board[row][column] == 'O' && (row == 0 || column == 0 || row == board.length -1 || column == board[0].length -1)){
            return true;
        }


        visited[row][column] = true;

        boolean up = isNOTSurrounded(board, row + 1, column, visited);
        boolean down = isNOTSurrounded(board, row - 1, column, visited);
        boolean right = isNOTSurrounded(board, row, column + 1, visited);
        boolean left = isNOTSurrounded(board, row, column - 1, visited);

        boolean isNOTSurrounded = up || down || left || right;

        return isNOTSurrounded;
    }

    public void fill(char[][] board, int row, int column) {

        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] == 'X'){
            return;
        }

        board[row][column] = 'X';

        fill(board, row + 1, column);
        fill(board, row - 1, column);
        fill(board, row, column + 1);
        fill(board, row, column - 1);
    }
}
