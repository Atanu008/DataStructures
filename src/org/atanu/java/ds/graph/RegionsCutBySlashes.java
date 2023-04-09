package org.atanu.java.ds.graph;

// https://leetcode.com/problems/regions-cut-by-slashes/description/
// Leetcode 959

// Awesome Pictorial Explanation :https://leetcode.com/problems/regions-cut-by-slashes/solutions/549769/java-solution-with-pictorial-representation-and-full-explanantion/?orderBy=most_votes
// Ediccative : https://www.educative.io/courses/grokking-coding-interview-patterns-java/gx83pZ71ENk
// Great Video : https://www.youtube.com/watch?v=Cl8Mtc7q80s&t=128s

public class RegionsCutBySlashes {

    public int regionsBySlashes(String[] grid) {

        int N = grid.length;
        UnionFindPathCompressionUnionBySize unionFind = new UnionFindPathCompressionUnionBySize(4 * N * N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){

                int root = 4 * N * i // number of triangles covered in prior rows
                        +  4 * j; // number of triangles covered in this row

                char val = grid[i].charAt(j);
                if(val == '/' || (val == ' ')){
                    unionFind.union(root, root + 1);
                    unionFind.union(root + 2, root + 3);
                }
                if(val == '\\' || (val == ' ')){
                    unionFind.union(root, root + 2);
                    unionFind.union(root + 1, root + 3);
                }
                // Connecting the north component of the current box with the south component of the box above it
                if(i - 1 >= 0){
                    unionFind.union(root, (root - 4*N) + 3);
                }
                // Connecting the south component of the current box with the north component of the box below it
                if(i + 1 < N){
                    unionFind.union(root + 3, (root + 4*N));
                }

                // Connecting the west component of the current box with the east component of the box on its left
                if(j - 1 >= 0){
                    unionFind.union(root + 1, (root - 4) + 2);
                }
                // Connecting the east component of the current box with the west component of the box on its right
                if(j + 1 < N){
                    unionFind.union(root + 2, (root + 4) + 1);
                }
            }
        }

        return unionFind.getNumberOfComponent();
    }


    private static class UnionFindPathCompressionUnionBySize {

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
    }
}
