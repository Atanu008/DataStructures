package org.atanu.java.ds.matrix;

public class SearchSorted2DMatrix {

    //this matrix can be represented in 1D sorted Array . Then the idea is to use the binary search.
    public static boolean searchSorted2DMatrix(int[][] matrix, int target) {

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
                System.out.println("Intem found at [" + midRow + ", " + midColumn + " ]");
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
        int mat[][] = {{0, 6, 8, 9, 11},
                {20, 22, 28, 29, 31},
                {36, 38, 50, 61, 63},
                {64, 66, 100, 122, 128}};

        searchSorted2DMatrix(mat, 28);

    }

}
