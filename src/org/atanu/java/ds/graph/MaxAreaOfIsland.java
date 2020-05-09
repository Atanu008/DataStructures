package org.atanu.java.ds.graph;

public class MaxAreaOfIsland {

public int maxAreaOfIsland(int[][] grid) {
        
        if(grid == null && grid.length == 0){
            return 0;
        }
        
        int row = grid.length;
        int column = grid[0].length;
        int maxArea = 0;
        boolean[][] visited = new boolean[row][column];
        
        for(int i = 0; i < row; i++){
            
            for(int j = 0; j < column; j++){
                
                if(grid[i][j] == 1 && !visited[i][j]){
                    
                    maxArea = Math.max(maxArea, dfs(grid,i,j,visited));
                }
            }
        }
        
        return maxArea;
    }
    
    public int dfs(int[][] grid, int i, int j, boolean[][] visited){
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]){
            return 0;
        } 
        
        visited[i][j] = true;
        
        return 1 + dfs(grid, i + 1, j, visited)
                 + dfs(grid, i - 1, j, visited)
                 + dfs(grid, i, j + 1, visited)
                 + dfs(grid, i, j - 1, visited);
            
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
