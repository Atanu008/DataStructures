package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix/description/
// Leetcode 74
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        //base Condition
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int low = 0;
        int high = (row * column) - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int midRow = mid / column; // Row Formula
            int midColumn = mid % column; // Cloumn Formula

            if (matrix[midRow][midColumn] == target) {
                //System.out.println("Intem found at [" + midRow + ", " + midColumn + " ]");
                return true;
            } else if (target < matrix[midRow][midColumn]) {
                high = mid - 1;
            } else if (target > matrix[midRow][midColumn]) {
                low = mid + 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        int[][] matrix = {{0, 6, 8, 9, 11},
                {20, 22, 28, 29, 31},
                {36, 38, 50, 61, 63},
                {64, 66, 100, 122, 128}};
        System.out.println(searchA2DMatrix.searchMatrix(matrix, 28));
        System.out.println(searchA2DMatrix.searchMatrix(matrix, 7));
    }
}
