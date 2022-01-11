package org.atanu.java.ds.graph;

//https://leetcode.com/problems/path-with-maximum-gold/
//LeetCode 1219
public class PathWithMaximumGold {

    public int getMaximumGold(int[][] grid) {

        int maxGold = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] != 0){
                    maxGold = Math.max(maxGold, dfs(grid, row, col, visited));
                }
            }
        }

        return maxGold;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited){

        if(row < 0 || row > grid.length -1 || col < 0 || col > grid[0].length -1 ||grid[row][col] == 0 || visited[row][col]){
            return 0;
        }

        visited[row][col] = true;
        int maxGold = grid[row][col];

        int left = dfs(grid, row, col +1, visited);
        int right = dfs(grid, row, col-1, visited);
        int up = dfs(grid, row-1, col, visited);
        int down = dfs(grid, row+1, col, visited);

        maxGold = maxGold + Math.max(left, Math.max(right, Math.max(up, down)));
        visited[row][col] = false;

        return maxGold;
    }

    //Using Dir Array
    int[][] dirs = {{0,1},{0,-1}, {1,0}, {-1,0}};
    public int getMaximumGoldV2(int[][] grid) {

        int maxGold = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] != 0){
                    maxGold = Math.max(maxGold, dfsV2(grid, row, col, visited));
                }
            }
        }

        return maxGold;
    }

    private int dfsV2(int[][] grid, int row, int col, boolean[][] visited){

        if(row < 0 || row > grid.length -1 || col < 0 || col > grid[0].length -1 ||grid[row][col] == 0 || visited[row][col]){
            return 0;
        }

        visited[row][col] = true;
        int maxGold = 0;
        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            maxGold = Math.max(maxGold , dfsV2(grid, newRow, newCol, visited));
        }

        visited[row][col] = false;

        return maxGold + grid[row][col];
    }

    public static void main(String[] args) {
        PathWithMaximumGold pathWithMaximumGold = new PathWithMaximumGold();
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        //Explanation:
        //[[0,6,0],
        // [5,8,7],
        // [0,9,0]]
        //Path to get the maximum gold, 9 -> 8 -> 7.
        System.out.println("Maximum Gold "+ pathWithMaximumGold.getMaximumGold(grid));
        grid = new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}};
        //Output: 28
        //Explanation:
        //[[1,0,7],
        // [2,0,6],
        // [3,4,5],
        // [0,3,0],
        // [9,0,20]]
        System.out.println("Maximum Gold "+ pathWithMaximumGold.getMaximumGold(grid));
    }
}
