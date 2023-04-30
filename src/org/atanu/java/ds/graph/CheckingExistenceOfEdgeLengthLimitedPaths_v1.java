package org.atanu.java.ds.graph;

import java.util.Arrays;
import java.util.PriorityQueue;


// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/description/
// Leetcode 1697

public class CheckingExistenceOfEdgeLengthLimitedPaths_v1 {

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        Arrays.sort(edgeList, (a, b)-> a[2]-b[2]);

        // Same solution is previous one
        // just here we are using priorituQueue to so based on edges
        // but we are only storing the query index which is imp for preparing the answer
        // previous solution we have created one extra array to have the query as well as indexes
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> queries[a][2] -queries[b][2]
        );
        for(int i=0;i<queries.length;i++){
            pq.offer(i);
        }

        int currentEdge =0;
        UnionFind uf = new UnionFind(n);
        while(!pq.isEmpty()){
            int queryIndex = pq.poll();

            while(currentEdge<edgeList.length && edgeList[currentEdge][2]< queries[queryIndex][2] ){
                uf.union(edgeList[currentEdge][0], edgeList[currentEdge][1]);
                currentEdge++;
            }

            result[queryIndex] = uf.connected(queries[queryIndex][0], queries[queryIndex][1]);
        }

        return result;
    }

    public static class UnionFind {

        int[] root;
        int[] size;

        public UnionFind(int n){
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
