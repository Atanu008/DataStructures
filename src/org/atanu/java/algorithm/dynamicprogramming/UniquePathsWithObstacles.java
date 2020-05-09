package org.atanu.java.algorithm.dynamicprogramming;

//Leetcode 63
//https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsWithObstacles {

	 public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        
	        int row = obstacleGrid.length;
	        int column = obstacleGrid[0].length;
	        int[][] dp = new int[row][column];
	        
	        //Filling up the first row. 
	        //If Obstacle found dont need to proceed and let the dp array be filled with zero
	        for(int i = 0; i < column; i++){
	            if(obstacleGrid[0][i] == 1){
	                break;
	            }
	            dp[0][i] = 1;
	        }
	        
	        //Filling up the first column. 
	        //If Obstacle found dont need to proceed and let the dp array be filled with zero
	        for(int i = 0; i < row; i++){
	            if(obstacleGrid[i][0] == 1){
	                break;
	            }
	            dp[i][0] = 1;
	        }
	        
	        for(int i = 1 ; i< row; i++){
	            for(int j = 1; j < column; j++){
	                //If obstacleGrid has obstacle then continue
	                if(obstacleGrid[i][j] == 1){
	                    continue;
	                }
	                else
	                {
	                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
	                }
	            }
	        }
	        
	        //System.out.println(Arrays.deepToString(dp));
	        return dp[row - 1][column - 1];
	    }
	 
	public static void main(String[] args) {
		
		int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
		
		System.out.println("Unique Path "+ uniquePathsWithObstacles(obstacleGrid));

	}

}
