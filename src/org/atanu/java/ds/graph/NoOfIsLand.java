package org.atanu.java.ds.graph;

public class NoOfIsLand {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islandCount = 0;
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;

    }

    public void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }


    public int numIslandsSol2(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islandCount = 0;
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ++islandCount;
                    dfs(grid, visited, i, j);

                }
            }
        }

        return islandCount;

    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
