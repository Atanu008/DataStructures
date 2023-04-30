package org.atanu.java.ds.graph;

import java.util.Arrays;

// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/description/
// Leetcode 1697
public class CheckingExistenceOfEdgeLengthLimitedPaths {

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        int queriesCount = queries.length;
        int[][] queriesWithOriginalIndex = new int[queriesCount][4];
        boolean[] answer = new boolean[queriesCount];
        UnionFind unionFind = new UnionFind(n);
        // Store original indices with all queries.
        for(int i = 0; i < queriesCount; i++){
            queriesWithOriginalIndex[i][0] = queries[i][0];
            queriesWithOriginalIndex[i][1] = queries[i][1];
            queriesWithOriginalIndex[i][2] = queries[i][2];
            queriesWithOriginalIndex[i][3] = i; // Store the original index of the query
        }

        // Sort all queries in increasing order of the limit of edge allowed.
        // The advantage of sorting is that when we reach a query at index iii,
        // and we need to create connected components with edges having weights less than limit(i)
        // we can utilize the components created in the previous query with a weight limit of limit(i−1)
        // as it cannot be more than the current limit, limit(i)
        // This eliminates the need to generate connected components anew for each query and increases the optimization of the solution.

        // Suppose we will first connect queries with limit 2
        // we will only add edges with limit 2, and updates the query result
        // Now if next time if we process queries with limit 5 , we don't need t compute for limit 2 edges
        // they are already connected and we can get the query result
        // The crux of the problem is connect the small edges first
        // as we build the graph next edges will be build with bigger edge value and smaller once will be calculated

        Arrays.sort(queriesWithOriginalIndex, (a, b) -> a[2] - b[2]);
        // Sort all edges in increasing order of their edge weights.
        Arrays.sort(edgeList, (a,b) -> a[2] - b[2]);

        int edgeIndex = 0;

        for(int queryIndex = 0; queryIndex < queriesWithOriginalIndex.length; queryIndex++){

            int p = queriesWithOriginalIndex[queryIndex][0];
            int q = queriesWithOriginalIndex[queryIndex][1];
            int limit = queriesWithOriginalIndex[queryIndex][2];
            int originalQueryIndex = queriesWithOriginalIndex[queryIndex][3];

            while(edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                int nodeA = edgeList[edgeIndex][0];
                int nodeB = edgeList[edgeIndex][1];
                unionFind.union(nodeA, nodeB);
                edgeIndex++;
            }

            boolean isConencted = unionFind.connected(p, q);
            answer[originalQueryIndex] = isConencted;
        }

        return answer;
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
