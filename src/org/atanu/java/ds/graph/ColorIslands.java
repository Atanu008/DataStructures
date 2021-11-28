package org.atanu.java.ds.graph;

import java.util.Arrays;

public class ColorIslands {

    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public void colorIslands(int[][] grid){

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int color = 0;
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == 1 && !visited[row][column]){
                    color++;
                    dfs(grid, row, column, visited, color);
                }
            }
        }

        System.out.println(Arrays.deepToString(grid));
    }

    public void dfs(int[][] grid, int row, int column, boolean[][] visited, int color){

        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length
                || grid[row][column] != 1 || visited[row][column]){
            return;
        }

        grid[row][column] = color;
        visited[row][column] = true;
        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newCloumn = column + dir[1];
            dfs(grid, newRow, newCloumn, visited, color);
        }
    }

    public static void main(String[] args) {
        ColorIslands colorIslands = new ColorIslands();
        int[][] grid = {{1,1,1,0,0},{0,1,1,0,0},{0,0,0,0,0},{0,1,1,0,0}};
        colorIslands.colorIslands(grid);

    }
}
