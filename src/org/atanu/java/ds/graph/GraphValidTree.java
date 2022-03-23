package org.atanu.java.ds.graph;

//https://leetcode.com/problems/graph-valid-tree/
//LeetCode 261
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) {
            return false;
        }
        // Condition 2: The graph must contain a single connected component.
        // Create a new UnionFind object with n nodes.
        UnionFind unionFind = new UnionFind(n);
        // Add each edge. Check if a merge happened, because if it
        // didn't, there must be a cycle.
        for (int[] edge : edges) {
            int vertexA = edge[0];
            int vertexB = edge[1];
            if (!unionFind.union(vertexA, vertexB)) {
                return false;
            }
        }
        // If we got this far, there's no cycles!
        return true;
    }

    private static class UnionFind {
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

    public static void main(String[] args) {
        GraphValidTree graphValidTree = new GraphValidTree();
        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        boolean result = graphValidTree.validTree(n, edges);
        //Output: true
        System.out.println(result);

        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        result = graphValidTree.validTree(n, edges);
        //Output: true . Has Cycle (3-1)
        System.out.println(result);

    }
}
