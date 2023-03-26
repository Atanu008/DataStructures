package org.atanu.java.ds.dp;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths-ii/description/
//Leetcode 63
//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/Y5q9z9AjX5A

public class UniquePathsII {
    //Top Down Approach
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // the length of 2d matrix will be equal to the number of rows
        int rows = obstacleGrid.length;

        // The number of elements in 1st row are equal to the number of columns in 2d matrix
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return findUniquePathMemoization(0, 0, rows, cols, obstacleGrid, dp);
    }

    // Helper function to check the boundaries and base case
    public int findUniquePathMemoization(int i, int j, int rows, int cols, int[][] matrix, int[][] dp) {

        // check the boundary constraints
        if (i == rows || j == cols) {
            return 0;
        }

        // check if obstacle is present or not
        if (matrix[i][j] == 1) {
            return 0;
        }

        // check the base case when the last cell is reached
        if (i == rows - 1 && j == cols - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        //Go Bottom(i+1) and Right(j+1) and return the summation
        dp[i][j] = findUniquePathMemoization(i + 1, j, rows, cols, matrix, dp)
                    + findUniquePathMemoization(i, j + 1, rows, cols, matrix, dp);

        return dp[i][j];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println("Top Down");
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int uniquePath = uniquePathsII.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Unique Path "+ uniquePath);

    }
}
