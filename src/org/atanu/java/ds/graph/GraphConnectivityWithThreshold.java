package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/graph-connectivity-with-threshold/
//LeetCode 1627
//Video : https://www.youtube.com/watch?v=cnZuX0TR9TQ Intuition of efficient GCD  after 9 minute
public class GraphConnectivityWithThreshold {

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {

        UnionFind unionFind = new UnionFind(n+1);

        for(int i = threshold + 1; i <= n; i++) {
            for(int j = 2*i; j <= n; j += i) {
                unionFind.union(i, j);
            }
        }

        List<Boolean> result = new ArrayList<>();
        for(int[] query: queries) {
            int vertexA = query[0];
            int vertexB = query[1];

            result.add(unionFind.connected(vertexA, vertexB));
        }

        return result;
    }

    static class UnionFind {

        int[] root;
        int[] rank;// Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for(int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = i; // The initial "rank" of each vertex is 1, because each of them is
                // a standalone vertex with no connection to other vertices.
            }
        }

        public int find(int x) {
            if(root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]); // path compression
        }

        public void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            // Always attach a smaller depth tree under the root of the deeper tree.
            if(rootX != rootY) {
                if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                }
                else if(rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                }
                else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
