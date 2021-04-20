package org.atanu.java.ds.matrix;

import java.util.ArrayList;
import java.util.List;

//LeetCode 54
//https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();

        if(matrix == null || matrix.length == 0) {
            return null;
        }
        int top = 0;
        int bottom = matrix.length -1;
        int left = 0;
        int right = matrix[0].length -1;
        int dir = 0;
        while(top <= bottom && left <= right) {
            // Left To Right Print Top Row
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    resultList.add(matrix[top][i]);
                }
                top++;
            }
            // Top to Bottom Print right column
            if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    resultList.add(matrix[i][right]);
                }
                right--;
            }

            // Right To Left Print Bottom Row
            if(dir == 2){
                for(int i = right; i >= left; i--){
                    resultList.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // Bottom to Top Print left column
            if(dir == 3){
                for(int i = bottom; i >= top; i--){
                    resultList.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4; // To set the direction
        }

        return resultList;

    }

    public static void main(String[] args) {
        SpiralMatrix spm = new SpiralMatrix();
        int matrix[][] = {{1, 2, 3},
                     {4, 5, 6},
                     {7,8,9}};
        List<Integer> result = spm.spiralOrder(matrix);
        result.forEach(System.out::print);
    }

}
