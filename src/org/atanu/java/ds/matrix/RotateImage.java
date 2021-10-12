package org.atanu.java.ds.matrix;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-image/
//LeetCode 48
public class RotateImage {
    /*
    The idea was firstly transpose the matrix and then flip it symmetrically. For instance,

1  2  3
4  5  6
7  8  9
after transpose, it will be swap(matrix[i][j], matrix[j][i])

1  4  7
2  5  8
3  6  9
Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

7  4  1
8  5  2
9  6  3
     */
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = i; j < column; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < row; i++){
            int left = 0;
            int right = column - 1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                // System.out.println(temp);
                left++;
                right--;
            }
        }

        //Same row swap method using for instead of while(left < right)
       /* for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }*/

    }

    //For Anticlockwise rotation, transpose step would remain the same.
    //In the last step instead of flipping the columns, flip the rows vertically.

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        RotateImage rotateImage = new RotateImage();
        System.out.println(Arrays.deepToString(matrix));
    }
}
