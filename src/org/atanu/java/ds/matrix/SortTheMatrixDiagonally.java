package org.atanu.java.ds.matrix;

import java.util.*;

//https://leetcode.com/problems/sort-the-matrix-diagonally/
//LeetCode 1329
public class SortTheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {

        Map<Integer, Queue<Integer>> diagonalMap = new HashMap<>();

        int m = mat.length;
        int n = mat[0].length;

        // Data structure to store the diagonals.
        // For all diagonals row-column is same
        // For each diagonal, we have one priority Queue
        // Min Heap(PriorityQueue) will sort it as we insert
        for(int row = 0; row < m; row++) {
            for(int column = 0; column < n; column++) {
                diagonalMap.putIfAbsent(row-column, new PriorityQueue<>());
                diagonalMap.get(row-column).add(mat[row][column]);
            }
        }

        //Take out from Min Heap and place it in matrix again
        for(int row = 0; row < m; row++) {
            for(int column = 0; column < n; column++) {
                mat[row][column] = diagonalMap.get(row-column).poll();
            }
        }

        return mat;
    }

    //Sort Diagonals One by One
    public int[][] diagonalSortV2(int[][] mat) {

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

        //This is tricky, diagonal Length is Math.min(m - row, n - col)
        int diagonalLength = Math.min(m - row, n - col);
        //This Could List Could be a priorityQueue
        List<Integer> diagonalList = new ArrayList<>();

        for(int i = 0; i < diagonalLength; i++){
            diagonalList.add(mat[row+i][col+i]);
        }

        Collections.sort(diagonalList);

        for(int i = 0; i < diagonalLength; i++){
            mat[row+i][col+i] = diagonalList.remove(0);
        }
    }

    private void sortDiagonalV2(int[][] mat, int row, int col) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Integer> diagonal = new PriorityQueue<>();

        int diagonalLength = Math.min(m - row, n - col);
        // Put values on this diagonal into the heap.
        for (int i = 0; i < diagonalLength; i++) {
            diagonal.add(mat[row + i][col + i]);
        }
        // Put values on heap back into this diagonal
        for (int i = 0; i < diagonalLength; i++) {
            mat[row + i][col + i] = diagonal.remove();
        }
    }

    public static void main(String[] args) {

        SortTheMatrixDiagonally sortTheMatrixDiagonally  = new SortTheMatrixDiagonally();
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        sortTheMatrixDiagonally.diagonalSort(mat);
        System.out.println(Arrays.deepToString(mat));

        mat = new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        sortTheMatrixDiagonally.diagonalSortV2(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}
