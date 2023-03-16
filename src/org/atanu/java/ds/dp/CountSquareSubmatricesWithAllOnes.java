package org.atanu.java.ds.dp;

//https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
//Leetcode 1277
//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/B1GB52rZ1rN

//Video : https://www.youtube.com/watch?v=auS1fynpnjo&t=380s

//If matrix[i][j] == 0, then there is no possible square so we skip this iteration.

//If matrix[i][j] == 1, then we compare the size of the squares lookupTable[i-1][j-1], lookupTable[i-1][j], and lookupTable[i][j-1]
//and take the minimum of all three values and then, add 1 to it.
public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {

        // if the matrix is empty, return 0
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        // create lookup table to store number of squares
        int[][] dp = new int[m][n];

        // copy first column and row of input matrix to dp table
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                // there is at least one square submatrix at this location, hence the + 1
                // in addition, find the minimum number of square submatrices
                // whose bottom-right corner is one of the neighbours of this location.
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        // sum up the values in the lookupTable to get the count of square submatrices
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += dp[i][j];
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return result;
    }

    public static void main(String[] args) {
        CountSquareSubmatricesWithAllOnes countSquareSubmatricesWithAllOnes =  new CountSquareSubmatricesWithAllOnes();
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        System.out.println(countSquareSubmatricesWithAllOnes.countSquares(matrix));
    }
}
