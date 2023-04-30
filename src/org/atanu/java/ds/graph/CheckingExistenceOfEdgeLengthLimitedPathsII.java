package org.atanu.java.ds.graph;

import java.util.Arrays;

// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths-ii/description/
// Leetcode 1724

//We build a tree by Union-Find with no path compression.
//And each time we query, we find the parents as long as the edge weight is smaller than limit.
public class CheckingExistenceOfEdgeLengthLimitedPathsII {

    UnionFind unionFind;
    final int imax = Integer.MAX_VALUE;
    public CheckingExistenceOfEdgeLengthLimitedPathsII(int n, int[][] edgeList) {
        unionFind = new UnionFind(n);
        Arrays.sort(edgeList, (a, b) -> a[2]-b[2]);
        for(int[] edge : edgeList){
            unionFind.union(edge[0], edge[1], edge[2],imax);
        }
    }

    public boolean query(int p, int q, int limit) {
        return unionFind.find(p,limit) == unionFind.find(q,limit);
    }



static class UnionFind {
    int[] root, size, weight;

    public UnionFind(int n) {
        root = new int[n];
        size = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            size[i] = 1;
            weight[i] = 0;
        }
    }

    public int find(int x, int limit) {
        // dont cross the limit
        if (x == root[x] || weight[x] >= limit)
            return x;
        return find(root[x], limit);
    }

    public void union(int x, int y, int limit, int imax) {
        // Use imax(Integer.MAX_VALE) in find methods as we would like to find the parent and not hinder by limit implementation
        int rootX = find(x, imax);
        int rootY = find(y, imax);
        if (rootX == rootY)
            return;
        if (size[rootX] > size[rootY]) {
            root[rootY] = rootX;
            weight[rootY] = limit; // This tricky , think like to reach rootY weight is limit
            size[rootX] += size[rootY];
        } else { // Dont need else if as this will cover both  < and == . In both cases we are making rootY as parent
            root[rootX] = rootY;
            weight[rootX] = limit;
            size[rootY] += size[rootX];
        }
    }
}
}
