package org.atanu.java.ds.binarysearch;

public class SearchA2DMatrixII {

    // Start from Top Right corner
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;


        // Lets start with fixing our pointer to Top Right corner
        // Point to Note : last element in a row is greater than all elements to its left
        // Now if the target is found on that place return true
        // If target is greater then it can not be on that row as all left values are less.
        // Discard Row
        // If target is smaller then it can not be on that column. all the values down that column are greater
        // Discard column
        int row = 0;
        int column = matrix[0].length - 1;

        while(row < m && column >= 0){
            if(matrix[row][column] == target){
                return true;
            }else if(target > matrix[row][column]){
                row++;
            }
            else{
                column--;
            }
        }
        return false;
    }

    // Same Solution
    // This time start with Left Bottom Corner
    // Both are same . For some reason this is intuitive to me
    // Above solution is based in discarding and this one works with considering

    // Start from left bottom,
    // when matrix[x][y] == target , return True
    // when matrix[x][y] > target, exclude x row by moving to top
    // when matrix[x][y] < target, exclude y column by moving to right
    public boolean searchMatrix_v2(int[][] matrix, int target) {


        int m = matrix.length;
        int n = matrix[0].length;

        int row = matrix.length - 1;
        int column = 0;
        while(row >= 0 && column < n){
            if(matrix[row][column] == target) {
                return true;
            }
            // If target is greater move in Right direction . Increment column
            if(target > matrix[row][column]){
                column++;
            }
            // If target is lesser move in Up direction. Decrement row
            else{
                row--;
            }
        }
        return false;
    }
}
