package org.atanu.java.ds.graph;

//https://leetcode.com/problems/count-sub-islands/
//LeetCode 1905
public class CountSubIslands {

    Boolean isSub = false;
    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int count = 0;
        boolean[][] visited = new boolean[grid2.length][grid2[0].length];
        for(int row = 0; row < grid2.length; row++){
            for(int col = 0; col < grid2[0].length; col++){
                if(grid2[row][col] == 1 && !visited[row][col]){
                    isSub = true;
                    dfs(grid1, grid2, row, col, visited);
                    if(isSub){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid1, int[][] grid2, int row, int col, boolean[][] visited) {
        if(row < 0 || row > grid2.length -1 || col < 0 || col > grid2[0].length -1 || grid2[row][col] == 0 || visited[row][col]){
            return;
        }

        visited[row][col] = true;

        //If Any of the cell is grid1 is 0 then its not a sub island
        if(grid1[row][col] != 1){
            isSub = false;
        }

        dfs(grid1, grid2, row+1, col, visited);
        dfs(grid1, grid2, row-1, col, visited);
        dfs(grid1, grid2, row, col+1, visited);
        dfs(grid1, grid2, row, col-1, visited);

    }
}
