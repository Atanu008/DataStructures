package org.atanu.java.ds.graph;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-distinct-islands/
//LeetCode 694
//Video : https://www.youtube.com/watch?v=c1ZxUOHlulo&list=PLtQWXpf5JNGJrA4oZNuF8pRfdxRq3XVm9&index=2
public class NumberOfDistinctIslands {

    public int numDistinctIslands(int[][] grid) {

        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1 && !visited[row][col]){
                    StringBuilder sb = dfs(grid, row, col, visited, new StringBuilder("X"));
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    public StringBuilder dfs(int[][] grid, int row, int col, boolean[][] visited, StringBuilder sb) {

        if(row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length -1 || grid[row][col] == 0 || visited[row][col]){
            return new StringBuilder("O");
        }
        //grid[row][col] = 0;

        visited[row][col] = true;

        dfs(grid, row+1, col, visited, sb.append("U"));
        dfs(grid, row-1, col, visited, sb.append("D"));
        dfs(grid, row, col+1, visited, sb.append("R"));
        dfs(grid, row, col-1, visited, sb.append("L"));

        return sb;

    }
}
