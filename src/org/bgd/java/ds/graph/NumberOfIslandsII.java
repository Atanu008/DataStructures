package org.bgd.java.ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/number-of-islands-ii/description/">...</a>
 *
 * You are given an empty 2D binary grid grid of size m x n.
 * The grid represents a map where 0's represent water and 1's represent land. Initially, all the cells of grid are water cells (i.e., all the cells are 0's).
 * We may perform an add land operation which turns the water at position into a land.
 * You are given an array positions where positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.
 * Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 * Initially, the 2d grid is filled with water.
 * - Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
 * - Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
 * - Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
 * - Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.
 */
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] arr = new int[m][n];
        UnionFind uf = new UnionFind(m * n);
        List<Integer> answer = new ArrayList<>();

        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int[] p : positions) {
            int landPosition = p[0] * n + p[1];
            uf.insert(landPosition);

            for (int[] d : directions) {
                int x = p[0] + d[0];
                int y = p[1] + d[1];
                int landPositionNew = x * n + y;
                if (x >= 0 && x < m && y >= 0 && y < n && uf.isPresent(landPositionNew)) {
                    uf.union(landPosition, landPositionNew);
                }
            }
            answer.add(uf.getCount());
        }
        return answer;
    }

    class UnionFind {
        int[] rank;
        int[] parents;
        int count;

        UnionFind(int n) {
            this.count = 0; // 0 islands
            this.parents = new int[n + 1];
            this.rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parents[i] = -1;
                rank[i] = 1;
            }
        }

        /**
         * Adds a Land
         */
        void insert(int x) {
            if (parents[x] >= 0) {
                return; // already exists
            }

            parents[x] = x;
            count++;
        }

        /**
         * Checks for land
         */
        boolean isPresent(int x) {
            return parents[x] >= 0;
        }

        int getCount() {
            return this.count;
        }

        int find(int x) {
            if (x == parents[x]) {
                return x;
            }
            return parents[x] = find(parents[x]);
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return;
            }
            if (rank[px] > rank[py]) {
                parents[py] = px;
                rank[px] += rank[py];
            } else {
                parents[px] = py;
                rank[py] += rank[px];
            }
            count--;
        }
    }
}
