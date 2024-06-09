package org.bgd.java.ds.binarysearch;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/description/">...</a>
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class SearchIn2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midr = mid / n;
            int midc = mid % n;

            if (matrix[midr][midc] == target) {
                return true;
            } else if (matrix[midr][midc] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
