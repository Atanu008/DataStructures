package org.atanu.java.algorithm.dynamicprogramming;

//Leetcode 64
//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {

public static int minPathSum(int[][] grid) {
        
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        
        //prepare first row by adding the value of previous element
        for(int i = 1; i < column ; i++){
            grid[0][i] += grid[0][i-1];
        }
        
      //prepare first column by adding the value of previous element
        for(int i = 1; i < row ; i++){
            grid[i][0] += grid[i-1][0];
        }
        
         for(int i = 1 ; i< row; i++){
	            for(int j = 1; j < column; j++){
                    
	            	// Chose minumum from previous row Or column  + itself
                    grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
	            }
	        }
        
       // System.out.println(Arrays.deepToString(grid));
        
        return grid[row - 1][ column - 1];
    }
    
	public static void main(String[] args) {
		
		int[][] grid = new int[][] {
		                            {1,3,1},
		                            {1,5,1},
		                            {4,2,1}
									};
									
	  System.out.println(minPathSum(grid));

	}

}
