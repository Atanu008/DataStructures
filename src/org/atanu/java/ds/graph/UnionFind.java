package org.atanu.java.ds.graph;

// LeetCode Premium and Techiedelight
// Coding Minutes is good too
public class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
        }
    }

    public int find(int x) {
        if(root[x] == x) {
            return x;
        }

        return find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            root[rootY] = rootX;
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

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }


    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
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
