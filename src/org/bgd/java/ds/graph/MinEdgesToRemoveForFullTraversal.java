package org.bgd.java.ds.graph;

public class MinEdgesToRemoveForFullTraversal {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        int edgesReq = 0;

        for (int[] edge : edges) {
            int type = edge[0];
            int from = edge[1];
            int to = edge[2];
            if (type == 3) {
                edgesReq += alice.union(from, to) | bob.union(from, to);

            }
        }

        for (int[] edge : edges) {
            int type = edge[0];
            int from = edge[1];
            int to = edge[2];
            if (type == 1) {
                edgesReq += alice.union(from, to);

            } else if (type == 2) {
                edgesReq += bob.union(from, to);
            }
        }

        int totaledges = edges.length;
        if (alice.isConnected() && bob.isConnected()) {
            return totaledges - edgesReq;
        }
        return -1;
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
