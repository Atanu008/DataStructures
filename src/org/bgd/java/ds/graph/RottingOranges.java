package org.bgd.java.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * <a href="https://leetcode.com/problems/rotting-oranges/description/">...</a>
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int oranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    oranges++;
                }
            }
        }

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int time = 0;

        while (!q.isEmpty()) {
            int s = q.size();
            boolean rot = false;
            for (int i = 0; i < s; i++) {

                Pair top = q.poll();

                for (int[] d : directions) {

                    int newx = top.x + d[0];
                    int newy = top.y + d[1];

                    if (newx >= 0 && newx < m && newy >= 0 && newy < n && grid[newx][newy] == 1) {
                        rot = true;
                        q.offer(new Pair(newx, newy));
                        grid[newx][newy] = 2;
                        oranges--;
                    }

                }

            }
            if (rot) {
                time++;
            }
        }
        return oranges == 0 ? time : -1;
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
