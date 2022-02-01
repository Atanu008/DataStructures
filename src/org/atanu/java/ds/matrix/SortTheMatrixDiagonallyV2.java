package org.atanu.java.ds.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/sort-the-matrix-diagonally/
//LeetCode 1329
public class SortTheMatrixDiagonallyV2 {
    public int[][] diagonalSort(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        // Sort each diagonal that starts on a row.
        for(int row = 0; row < m; row++){
            sortDiagonal(mat, row, 0);
        }

        // Sort each diagonal that starts on a col.
        // Note that we've already sorted the one starting
        // at col = 0; this is the same as the one starting
        // at row = 0. Thats why starting with col = 1
        for(int col = 1; col < n; col++){
            sortDiagonal(mat, 0, col);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {
        int m = mat.length;
        int n = mat[0].length;

        int diagonalLength = Math.min(m - row, n - col);
        //This Could List Could be a priorityQueue
        List<Integer> diagonalList = new ArrayList<>();

        for(int i = 0; i < diagonalLength; i++){
            diagonalList.add(mat[row+i][col+i]);
        }

        //Collections.sort(diagonalList);
        //Use Counting Sort as the values are in range
        List<Integer> sortedList = countingSort(diagonalList);

        for(int i = 0; i < diagonalLength; i++){
            mat[row+i][col+i] = sortedList.remove(0);
        }
    }

    private List<Integer> countingSort(List<Integer> nums) {

        int min = Collections.min(nums);
        int max = Collections.max(nums);

        int len = max - min +1;
        int[] count = new int[len];

        for(int num : nums) {
            count[num - min]++;
        }

        List<Integer> sortedNums = new ArrayList<>();
        // Flatten the list of counts into a sorted list
        for(int i = 0; i < len; i++) {
            for(int times = count[i]; times > 0; times--) {
                sortedNums.add(i + min);
            }
        }

        return sortedNums;
    }

    public static void main(String[] args) {
        SortTheMatrixDiagonallyV2 sortTheMatrixDiagonallyV2  = new SortTheMatrixDiagonallyV2();
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        sortTheMatrixDiagonallyV2.diagonalSort(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}
