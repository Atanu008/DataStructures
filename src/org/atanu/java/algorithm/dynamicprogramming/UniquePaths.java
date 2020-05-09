package org.atanu.java.algorithm.dynamicprogramming;

//LeetCode 62
//https://leetcode.com/problems/unique-paths/
public class UniquePaths {

	public static int uniquePaths(int column, int row) {

		int[][] dp = new int[row][column];

		//Intialize forst row as One.It would take only one way to reach
		for(int i = 0; i < column; i++){
			dp[0][i] = 1;
		}

		//Intialize forst column as One.It would take only one way to reach
		for(int i = 0; i < row; i++){
			dp[i][0] = 1;
		}

		//fill the dp array by summing up 
		for(int i = 1; i < row; i++){

			for(int j = 1; j < column; j++){
				//
				dp[i][j] = dp[i-1][j] + dp[i][j-1];  //+ dp[i-1][j-1]; For Diagonal
			}
		}

		return dp[row - 1][column - 1];
	}

	public static int uniquePathsTwo(int m, int n) {

	        // If either given row number is first or 
	        // given column number is first 
	        if(m == 1 || n == 1){
	            return 1;
	        }

	        // If diagonal movements are allowed then 
	        // the last addition is required. 
	        return uniquePaths(m -1 , n) + uniquePaths(m , n -1) ; // uniquePaths(m -1 , n-1)
	    }
	
	
	public static void main(String[] args) {
		
		System.out.println("Unique Path "+ uniquePaths(7,3));
		System.out.println("Unique Path "+ uniquePathsTwo(7,3));

	}

}
