package org.atanu.java.ds.matrix;

public class SearchIn2DArray {

    public static void searchIn2DArray(int[][] matrix, int target) {

        int row = matrix.length - 1;
        int column = 0;

        //Start with left bottom element as we would get more search space
        while (row >= 0 && column <= matrix[0].length - 1) {

            if (matrix[row][column] == target) {
                System.out.println("Element Found " + matrix[row][column]);
                return;
            }

            // If target is greater move in Right direction . Increment column
            else if (target > matrix[row][column]) {
                column++;
            }

            // If target is lesser move in Up direction. Decrement row
            else {
                row--;
            }
        }

        System.out.println("Element Not Found");
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target = 21;
        searchIn2DArray(matrix, target);

    }

}
