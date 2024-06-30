package org.bgd.java.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/01-matrix/description/">...</a>
 *
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Step> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Step(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!q.isEmpty()) {
            Step top = q.poll();

            for (int[] d : directions) {
                int x = top.x + d[0];
                int y = top.y + d[1];

                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new Step(x, y, top.d + 1));
                    result[x][y] = top.d + 1;

                }
            }
        }
        return result;
    }

    class Step {
        int x;
        int y;
        int d;

        public Step(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
