package org.atanu.java.ds.graph;

//https://leetcode.com/problems/similar-string-groups/description/
//Leetcode 839

public class SimilarStringGroups {

    public int numSimilarGroups(String[] strs) {

        UnionFind unionFind = new UnionFind(strs.length);

        for(int i = 0; i < strs.length - 1; i++) {
            for(int j = i + 1; j < strs.length; j++) {
                if(isSimilar(strs[i], strs[j])) {
                    unionFind.union(i,j);
                }
            }
        }

        return unionFind.getNumberOfComponent();
    }

    public boolean isSimilar(String a, String b) {

        if(a.length() != b.length()) {
            return false;
        }
        int len = a.length();
        int notSimilarCount = 0;

        for(int i = 0; i < len; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                notSimilarCount++;
            }

            if(notSimilarCount > 2) {
                return false;
            }
        }

        return true;
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
