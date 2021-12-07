package org.atanu.java.ds.graph;

//https://leetcode.com/problems/coloring-a-border/
//Leetcode 1034
public class ColoringABorder {

    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    //From an initial point, perform DFS and flip the cell color to negative to track visited cells.
    //After DFS is complete for the cell, check if this cell is inside. If so, flip its color back to the positive.
    //In the end, cells with the negative color are on the border. Change their color to the target color.
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if(grid == null || grid.length == 0)
            return null;

        int connectedComponentColor = grid[row][col];
        dfs(grid, row, col, grid[row][col]);

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0){
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }

    public void dfs(int[][] grid, int row, int col, int oldColor){

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != oldColor){
            return;
        }

        grid[row][col] = -oldColor; // First make all cell in the connected componenet negative

        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newColumn = col + dir[1];
            dfs(grid, newRow, newColumn, oldColor);
        }

        //The reason we are checking abs is some of the cell will be positive and some of them negative
        //because of DFS call .
        if(row > 0 && row < grid.length -1 && col > 0 && col < grid[0].length -1
                && Math.abs(grid[row+1][col]) == oldColor
                && Math.abs(grid[row-1][col]) == oldColor
                && Math.abs(grid[row][col+1]) == oldColor
                && Math.abs(grid[row][col-1]) == oldColor){
            grid[row][col] = oldColor;
        }
    }

    public int[][] colorBorderV2(int[][] grid, int row, int col, int color) {

        int connectedComponentColor = grid[row][col];
        dfsV2(grid, row, col, grid[row][col]);

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0){
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }

    public void dfsV2(int[][] grid, int row, int col, int oldColor){

        grid[row][col] = -oldColor; // First make all cell in the connected componenet negative

        int count = 0;
        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newColumn = col + dir[1];
            if(newRow < 0 || newRow >= grid.length || newColumn < 0 || newColumn >= grid[0].length || Math.abs(grid[newRow][newColumn]) != oldColor){
                continue;
            }
            count++;
            if(grid[newRow][newColumn] == oldColor){
                dfsV2(grid, newRow, newColumn, oldColor);
            }

        }
        if(count == 4){
            grid[row][col] = oldColor;
        }


    }
}
