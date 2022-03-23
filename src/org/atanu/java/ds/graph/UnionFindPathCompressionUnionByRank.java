package org.atanu.java.ds.graph;

public class UnionFindPathCompressionUnionByRank {

    int[] root;
    int[] rank;// Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.

    public UnionFindPathCompressionUnionByRank(int size) {
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

    public static void main(String[] args) {
        UnionFindPathCompressionUnionByRank uf = new UnionFindPathCompressionUnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
