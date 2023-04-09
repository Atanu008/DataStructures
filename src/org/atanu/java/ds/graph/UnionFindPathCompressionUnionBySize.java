package org.atanu.java.ds.graph;

// https://cp-algorithms.com/data_structures/disjoint_set_union.html#search-for-connected-components-in-an-image
// Video : https://www.youtube.com/watch?v=aBxjDBC4M1U (see from 37 minutes to 40 max)
public class UnionFindPathCompressionUnionBySize {

    int[] root;
    int[] size;

    public UnionFindPathCompressionUnionBySize(int n){
        root = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            root[i] = i;
            size[i] = 1; // The initial "size" of each vertex is 1, because each of them is having one size initially
        }
    }

    public int find(int x){

        if(root[x] == x){
            return x;
        }
        return root[x] = find(root[x]); // path compression
    }

    public void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if(size[rootX] > size[rootY]){
            root[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        else{ // Dont need else if as this will cover both  < and == . In both cases we are making rootY as parent
            root[rootX] = rootY;
            size[rootY] += size[rootX];
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
        UnionFindPathCompressionUnionBySize uf = new UnionFindPathCompressionUnionBySize(10);
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
