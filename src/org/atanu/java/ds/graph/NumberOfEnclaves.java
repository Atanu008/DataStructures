package org.atanu.java.ds.graph;

//https://leetcode.com/problems/number-of-enclaves/
//LeetCode 1020
//Exactly same as SurroundedRegions . //https://leetcode.com/problems/surrounded-regions/
//Here we only need the count
public class NumberOfEnclaves {

    int[][] dirs = {{0, 1},{-1, 0},{0, -1},{1, 0}};
    public int numEnclaves(int[][] grid) {

        int row = grid.length;
        int column = grid[0].length;

        for(int i = 0; i < row; i++){
            markBorder(grid, i, 0);
            markBorder(grid, i, column - 1);
        }

        for(int i = 0; i < column; i++){
            markBorder(grid, 0, i);
            markBorder(grid, row - 1, i);
        }

        return countEnclaves(grid);
    }

    public void markBorder(int[][] grid, int row, int column) {

        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] != 1) {
            return;
        }
        //If we come here that means its a valid cell and is Obviously zero
        //Mark the cell and recurse for 4 direction neighbour
        grid[row][column] = 0;
        for(int[] dir : dirs) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];
            markBorder(grid, newRow, newColumn);
        }
    }

    public int countEnclaves(int[][] grid) {

        int enclavesCount = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    enclavesCount++;
                }
            }
        }

        return enclavesCount;
    }
}
