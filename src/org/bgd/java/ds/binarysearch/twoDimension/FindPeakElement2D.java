package org.bgd.java.ds.binarysearch.twoDimension;

/**
 * <a href="https://leetcode.com/problems/find-a-peak-element-ii/description/">...</a>
 *
 * A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
 *
 * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
 *
 * You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
 *
 * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
 *
 * Input: mat = [[1,4],[3,2]]
 * Output: [0,1]
 * Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
 *
 * Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
 * Output: [1,1]
 * Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 */
public class FindPeakElement2D {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2; // column
            int maxRow = getMax(mat, mid);
            int left = mid - 1 >= 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid + 1 < n ? mat[maxRow][mid + 1] : -1;
            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[] { maxRow, mid };
            } else if (mat[maxRow][mid] < left) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    private int getMax(int[][] mat, int col) {
        int max = -1;
        int ind = -1;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] >= max) {
                max = mat[i][col];
                ind = i;
            }
        }
        return ind;
    }
}
