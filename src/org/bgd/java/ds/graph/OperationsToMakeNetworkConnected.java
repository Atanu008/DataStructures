package org.bgd.java.ds.graph;

/**
 * <a href="https://leetcode.com/problems/number-of-operations-to-make-network-connected/">...</a>
 *
 * 1319. Number of Operations to Make Network Connected
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi.
 * Any computer can reach any other computer directly or indirectly through the network.
 * You are given an initial computer network connections.
 * You can extract certain cables between two directly connected computers,
 * and place them between any pair of disconnected computers to make them directly connected.
 * Return the minimum number of times you need to do this in order to make all the computers connected.
 * If it is not possible, return -1.
 */
public class OperationsToMakeNetworkConnected {

    /**
     * Union Find Based Solution
     */
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        int connected = n;
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];
            if (uf.find(x) != uf.find(y)) {
                uf.union(x, y);
                connected--;
            }
        }
        return connected - 1;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        int n;

        UnionFind(int n) {
            this.n = n;
            this.parent = new int[n + 1];
            this.rank = new int[n + 1];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == parent[x]) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return;
            }

            if (rank[x] < rank[y]) {
                parent[y] = x;
                rank[x] += rank[y];
            } else {
                parent[x] = y;
                rank[y] += rank[x];
            }
        }
    }
}
