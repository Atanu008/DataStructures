package org.atanu.java.ds.graph;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
//LeetCode 947
// Union Intuition : https://www.youtube.com/watch?v=beOCN7G4h-M&t=631s
public class MostStonesRemovedWithSameRowOrColumn {

    public int removeStones(int[][] stones) {

        UnionFind unionFind = new UnionFind(stones.length);

        //Check one stone(i) with every other stones(i+1)
        //If they share common row or column ([0] or [1]) then unite them in same group
        for(int i = 0; i < stones.length; i++) {
            for(int j = i + 1; j < stones.length; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    unionFind.union(i, j);
                }
            }
        }

        return stones.length - unionFind.getNumberOfComponent();

    }

    static class UnionFind {
        int[] root;
        int[] rank;// Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = i; // The initial "rank" of each vertex is 1, because each of them is
                // a standalone vertex with no connection to other vertices.
            }
        }

        public int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]); // path compression
        }

        public void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            // Always attach a smaller depth tree under the root of the deeper tree.
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public int getNumberOfComponent() {
            int count = 0;
            for (int i = 0; i < root.length; i++) {
                if (root[i] == i) { //If the same element is root i.e it belengs to its same set , if its diffeent that means this element have differner root
                    count++;
                }
            }

            return count;
        }
    }
}
