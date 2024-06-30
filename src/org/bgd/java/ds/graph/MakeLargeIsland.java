package org.bgd.java.ds.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/making-a-large-island/description/">...</a>
 *
 *
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 *
 * Return the size of the largest island in grid after applying this operation.
 *
 * An island is a 4-directionally connected group of 1s.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,0],[0,1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Example 2:
 *
 * Input: grid = [[1,1],[1,0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Example 3:
 *
 * Input: grid = [[1,1],[1,1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 *
 */
public class MakeLargeIsland {

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        /**
         * Create the unions
         */

        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int currPosition = i * n + j;
                for (int[] d : directions) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (isValid(x, y, m, n) && grid[x][y] == 1) {
                        int newPosition = x * n + y;
                        uf.union(currPosition, newPosition);
                    }
                }
            }
        }

        int total = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                Set<Integer> componentParents = new HashSet<>();

                for (int[] d : directions) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (isValid(x, y, m, n) && grid[x][y] == 1) {
                        int currPosition = x * n + y;
                        componentParents.add(currPosition);
                    }
                }
                int size = 0;
                for (int pos : componentParents) {
                    size += uf.rank[pos];
                }
                total = Math.max(total, size + 1);
            }
        }

        for (int i = 0; i < m * n; i++) {
            total = Math.max(total, uf.rank[uf.find(i)]);
        }
        return total;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    class UnionFind {
        int[] rank;
        int[] parents;

        UnionFind(int n) {
            this.parents = new int[n + 1];
            this.rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parents[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == parents[x]) {
                return x;
            }
            return parents[x] = find(parents[x]);
        }

        int union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return 0;
            }
            if (rank[px] > rank[py]) {
                parents[py] = px;
                rank[px] += rank[py];
            } else {
                parents[px] = py;
                rank[py] += rank[px];
            }
            return 1;
        }
    }
}
