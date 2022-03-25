package org.atanu.java.ds.graph;

//https://leetcode.com/problems/number-of-closed-islands/
//LeetCode 1254
//This Approach is similar to Enclave solution
public class NumberOfClosedIslands {

    int[][] dirs = {{0, 1},{-1, 0},{0, -1},{1, 0}};
    public int closedIsland(int[][] grid) {

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

        boolean[][] visited = new boolean[row][column];
        int closedIslandCound = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++) {
                if(grid[i][j] == 0 && !visited[i][j]) {
                    closedIslandCound++;
                    dfs(grid, i, j, visited);
                }
            }
        }

        return closedIslandCound;
    }

    public void markBorder(int[][] grid, int row, int column) {

        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] != 0) {
            return;
        }
        //If we come here that means its a valid cell and is Obviously zero
        //Mark the cell and recurse for 4 direction neighbour
        grid[row][column] = 1;
        for(int[] dir : dirs) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];
            markBorder(grid, newRow, newColumn);
        }
    }

    public void dfs(int[][] grid, int row, int column, boolean[][] visited) {
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length ||visited[row][column] || grid[row][column] == 1) {
            return;
        }

        visited[row][column] = true;

        for(int[] dir : dirs) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];
            dfs(grid, newRow, newColumn, visited);
        }
    }
}
