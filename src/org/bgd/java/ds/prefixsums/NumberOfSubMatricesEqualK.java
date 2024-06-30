package org.bgd.java.ds.prefixsums;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/description/">...</a>
 *
 * 1074. Number of Submatrices That Sum to Target
 *
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 *
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 *
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.
 *
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 */
public class NumberOfSubMatricesEqualK {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;

        // compute 2D prefix sum
        int[][] ps = new int[r + 1][c + 1];
        for (int i = 1; i < r + 1; ++i) {
            for (int j = 1; j < c + 1; ++j) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int count = 0, currSum;
        Map<Integer, Integer> h = new HashMap();
        // reduce 2D problem to 1D one
        // by fixing two columns c1 and c2 and
        // computing 1D prefix sum for all matrices using [c1..c2] columns
        for (int c1 = 1; c1 < c + 1; ++c1) {
            for (int c2 = c1; c2 < c + 1; ++c2) {
                h.clear();
                h.put(0, 1);
                for (int row = 1; row < r + 1; ++row) {
                    // current 1D prefix sum
                    currSum = ps[row][c2] - ps[row][c1 - 1];

                    // add subarrays which sum up to (currSum - target)
                    count += h.getOrDefault(currSum - target, 0);

                    // save current prefix sum
                    h.put(currSum, h.getOrDefault(currSum, 0) + 1);
                }
            }
        }

        return count;
    }
}
