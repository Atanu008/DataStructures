package org.atanu.java.ds.graph;

//https://leetcode.com/problems/redundant-connection/
//LeetCode 684
// Update Needed with Path Compression
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {

        UnionFind unionFind = new UnionFind(edges.length);
        // Add each edge. Check if a merge happened, because if it
        // didn't, there must be a cycle.
        for (int[] edge : edges) {
            int vertexA = edge[0] -1 ;
            int vertexB = edge[1] -1;
            if (!unionFind.union(vertexA , vertexB)) {
                return edge;
            }
        }

        return new int[]{};
    }

 static class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (root[x] == x) {
            return x;
        }

        return find(root[x]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            root[rootY] = rootX;
            return true;
        }

        //If we are here means rootX == rootY . So there is a cycle . return false
        return false;
    }
}
}
