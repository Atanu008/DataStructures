package org.atanu.java.ds.graph;

//https://leetcode.com/problems/island-perimeter/
//LeetCode 463
public class IslandPerimeter {

    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public int islandPerimeter(int[][] grid) {

        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                //Do DFS once we get one Island
                //DFS will return the perimeter
                if(grid[i][j] == 1){
                    return dfs(grid, visited, i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, boolean[][]visited, int row, int column){

        //If the cell is Zero then previuos call has one perimeter
        //If the cell is outside of grid then previuos call has one perimeter
        if(row < 0 || row >= grid.length || column < 0 || column >=  grid[0].length || grid[row][column] == 0){
            return 1;
        }
        if(visited[row][column]){
            return 0;
        }

        int count = 0;
        visited[row][column] = true;
        for(int[] dir: dirs){
            int newRow = row +dir[0];
            int newColumn = column + dir[1];
            count += dfs(grid, visited, newRow, newColumn);
        }

        return count;

    }

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        //Output: 16
        //Explanation: The perimeter is the 16 yellow stripes in the image above.
        System.out.println("Perimeter is "+ islandPerimeter.islandPerimeter(grid) );

    }
}
