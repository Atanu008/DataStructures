package org.bgd.java.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/">...</a>
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        return connected(isConnected);
    }

    /**
     * DFS based soluion
     */

    Map<Integer, List<Integer>> map;

    private int connected(int[][] mat) {
        map = new HashMap<>();
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    int p = i;
                    int c = j;
                    map.get(i)
                      .add(j);
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        return count;

    }

    private void dfs(int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbours : map.get(node)) {
            if (!visited[neighbours]) {
                dfs(neighbours, visited);
            }
        }
    }

    /** DSU / Union Find Solution
     *
     * Add every component and count the number.
     * Then start performing union and decrease count once merged.
     */

    public int findCircleNumUF(int[][] isConnected) {
        DSU ds = new DSU(isConnected.length);
        int count = isConnected.length;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && ds.find(i) != ds.find(j)) {
                    ds.union(i, j);
                    count--;
                }
            }
        }
        return count;
    }

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int i) {
            if (i == parent[i]) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        /**
         * Union by rank with path compression
         */
        void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) {
                return;
            }
            if (rank[pi] < rank[pj]) {
                parent[pi] = pj;
            } else {
                parent[pj] = pi;
                rank[pj] += rank[pi];
            }
        }
    }

}
