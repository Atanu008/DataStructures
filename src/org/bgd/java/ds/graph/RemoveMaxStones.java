package org.bgd.java.ds.graph;

/**
 * <a href="https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/">...</a>
 *
 * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
 *
 * A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
 *
 * Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Explanation: One way to remove 5 stones is as follows:
 * 1. Remove stone [2,2] because it shares the same row as [2,1].
 * 2. Remove stone [2,1] because it shares the same column as [0,1].
 * 3. Remove stone [1,2] because it shares the same row as [1,0].
 * 4. Remove stone [1,0] because it shares the same column as [0,0].
 * 5. Remove stone [0,1] because it shares the same row as [0,0].
 * Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
 */
public class RemoveMaxStones {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        int components = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (shareSameRowOrColumn(stones[i], stones[j])) {
                    components -= uf.union(i, j);
                }
            }
        }
        return n - components;
    }

    private boolean shareSameRowOrColumn(int[] a, int[] b) {
        return a[0] == b[0] || a[1] == b[1];
    }

    class UnionFind {
        int[] rank;
        int[] parents;
        int comp;

        UnionFind(int n) {
            this.parents = new int[n + 1];
            this.rank = new int[n + 1];
            this.comp = n;
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
            comp--;
            return 1;
        }

        boolean isConnected() {
            return comp == 1;
        }
    }
}
