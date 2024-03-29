package org.atanu.java.ds.dp;

//https://leetcode.com/problems/maximal-square/
//LeetCode 221
//https://www.youtube.com/watch?v=RElcqtFYTm0
//https://www.youtube.com/watch?v=c4W7YmgASpQ&t=642s
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;

        }
        int row = matrix.length;
        int coulmn = matrix[0].length;

        // dp(i, j) represents the length of the square
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
        int[][] dp = new int[row+1][coulmn+1];
        int maxLength = 0;

        for(int i = 1 ; i <=row; i ++){
            for(int j = 1; j <=coulmn; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }

            }
        }

        return maxLength*maxLength;
    }

    public static void main(String[] args) {

    }
}
