package org.bgd.java.ds.binarysearch;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class SearchIn2DArrayII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startrow = matrix.length - 1;
        int startcol = 0;
        while(startrow >= 0 && startrow < matrix.length && startcol >= 0 && startcol < matrix[0].length) {
            if(target > matrix[startrow][startcol]) {
                startcol++;
            } else if (target < matrix[startrow][startcol]) {
                startrow--;
            } else {
                return true;
            }
        }
        return false;
    }
}
